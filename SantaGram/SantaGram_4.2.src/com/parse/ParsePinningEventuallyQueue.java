package com.parse;

import a.h;
import a.j;
import a.k;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

class ParsePinningEventuallyQueue
  extends ParseEventuallyQueue
{
  private static final String TAG = "ParsePinningEventuallyQueue";
  private final Object connectionLock = new Object();
  private k<Void> connectionTaskCompletionSource = new k();
  private ArrayList<String> eventuallyPinUUIDQueue = new ArrayList();
  private final ParseHttpClient httpClient;
  private ConnectivityNotifier.ConnectivityListener listener = new ConnectivityNotifier.ConnectivityListener()
  {
    public void networkConnectivityStatusChanged(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getBooleanExtra("noConnectivity", false))
      {
        ParsePinningEventuallyQueue.this.setConnected(false);
        return;
      }
      ParsePinningEventuallyQueue.this.setConnected(ConnectivityNotifier.isConnected(paramAnonymousContext));
    }
  };
  private ConnectivityNotifier notifier;
  private TaskQueue operationSetTaskQueue = new TaskQueue();
  private HashMap<String, k<JSONObject>> pendingEventuallyTasks = new HashMap();
  private HashMap<String, k<JSONObject>> pendingOperationSetUUIDTasks = new HashMap();
  private TaskQueue taskQueue = new TaskQueue();
  private final Object taskQueueSyncLock = new Object();
  private HashMap<String, EventuallyPin> uuidToEventuallyPin = new HashMap();
  private HashMap<String, ParseOperationSet> uuidToOperationSet = new HashMap();
  
  public ParsePinningEventuallyQueue(Context paramContext, ParseHttpClient paramParseHttpClient)
  {
    setConnected(ConnectivityNotifier.isConnected(paramContext));
    this.httpClient = paramParseHttpClient;
    this.notifier = ConnectivityNotifier.getNotifier(paramContext);
    this.notifier.addListener(this.listener);
    resume();
  }
  
  private j<Void> enqueueEventuallyAsync(final ParseRESTCommand paramParseRESTCommand, final ParseObject paramParseObject, j<Void> paramj, final k<JSONObject> paramk)
  {
    paramj.b(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        EventuallyPin.pinEventuallyCommand(paramParseObject, paramParseRESTCommand).b(new h()
        {
          public j<Void> then(j<EventuallyPin> paramAnonymous2j)
          {
            EventuallyPin localEventuallyPin = (EventuallyPin)paramAnonymous2j.f();
            Exception localException = paramAnonymous2j.g();
            if (localException != null)
            {
              if (5 >= Parse.getLogLevel()) {
                PLog.w("ParsePinningEventuallyQueue", "Unable to save command for later.", localException);
              }
              ParsePinningEventuallyQueue.this.notifyTestHelper(4);
              return j.a(null);
            }
            ParsePinningEventuallyQueue.this.pendingOperationSetUUIDTasks.put(localEventuallyPin.getUUID(), ParsePinningEventuallyQueue.5.this.val$tcs);
            ParsePinningEventuallyQueue.this.populateQueueAsync().b(new h()
            {
              public j<Void> then(j<Void> paramAnonymous3j)
              {
                ParsePinningEventuallyQueue.this.notifyTestHelper(3);
                return paramAnonymous3j;
              }
            });
            return paramAnonymous2j.k();
          }
        });
      }
    });
  }
  
  private j<Void> populateQueueAsync()
  {
    this.taskQueue.enqueue(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        return ParsePinningEventuallyQueue.this.populateQueueAsync(paramAnonymousj);
      }
    });
  }
  
  private j<Void> populateQueueAsync(j<Void> paramj)
  {
    paramj.b(new h()
    {
      public j<List<EventuallyPin>> then(j<Void> paramAnonymousj)
      {
        return EventuallyPin.findAllPinned(ParsePinningEventuallyQueue.this.eventuallyPinUUIDQueue);
      }
    }).d(new h()
    {
      public j<Void> then(j<List<EventuallyPin>> paramAnonymousj)
      {
        Iterator localIterator = ((List)paramAnonymousj.f()).iterator();
        while (localIterator.hasNext())
        {
          EventuallyPin localEventuallyPin = (EventuallyPin)localIterator.next();
          ParsePinningEventuallyQueue.this.runEventuallyAsync(localEventuallyPin);
        }
        return paramAnonymousj.k();
      }
    });
  }
  
  private j<JSONObject> process(final EventuallyPin paramEventuallyPin, final ParseOperationSet paramParseOperationSet)
  {
    waitForConnectionAsync().d(new h()
    {
      public j<JSONObject> then(j<Void> paramAnonymousj)
      {
        final int i = paramEventuallyPin.getType();
        final ParseObject localParseObject = paramEventuallyPin.getObject();
        paramAnonymousj = paramEventuallyPin.getSessionToken();
        if (i == 1) {
          paramAnonymousj = localParseObject.saveAsync(ParsePinningEventuallyQueue.this.httpClient, paramParseOperationSet, paramAnonymousj);
        }
        for (;;)
        {
          paramAnonymousj.b(new h()
          {
            public j<JSONObject> then(final j<JSONObject> paramAnonymous2j)
            {
              Exception localException = paramAnonymous2j.g();
              if ((localException != null) && ((localException instanceof ParseException)) && (((ParseException)localException).getCode() == 100))
              {
                ParsePinningEventuallyQueue.this.setConnected(false);
                ParsePinningEventuallyQueue.this.notifyTestHelper(7);
                return ParsePinningEventuallyQueue.this.process(ParsePinningEventuallyQueue.13.this.val$eventuallyPin, ParsePinningEventuallyQueue.13.this.val$operationSet);
              }
              ParsePinningEventuallyQueue.13.this.val$eventuallyPin.unpinInBackground("_eventuallyPin").b(new h()
              {
                public j<Void> then(j<Void> paramAnonymous3j)
                {
                  Object localObject = (JSONObject)paramAnonymous2j.f();
                  if (ParsePinningEventuallyQueue.13.1.this.val$type == 1) {
                    localObject = ParsePinningEventuallyQueue.13.1.this.val$object.handleSaveEventuallyResultAsync((JSONObject)localObject, ParsePinningEventuallyQueue.13.this.val$operationSet);
                  }
                  do
                  {
                    do
                    {
                      return (j<Void>)localObject;
                      localObject = paramAnonymous3j;
                    } while (ParsePinningEventuallyQueue.13.1.this.val$type != 2);
                    localObject = paramAnonymous3j;
                  } while (paramAnonymous2j.e());
                  return ParsePinningEventuallyQueue.13.1.this.val$object.handleDeleteEventuallyResultAsync();
                }
              }).b(new h()
              {
                public j<JSONObject> then(j<Void> paramAnonymous3j)
                {
                  return paramAnonymous2j;
                }
              });
            }
          });
          if (i == 2)
          {
            paramAnonymousj = localParseObject.deleteAsync(paramAnonymousj).j();
          }
          else
          {
            paramAnonymousj = paramEventuallyPin.getCommand();
            if (paramAnonymousj == null)
            {
              paramAnonymousj = j.a(null);
              ParsePinningEventuallyQueue.this.notifyTestHelper(8);
            }
            else
            {
              paramAnonymousj = paramAnonymousj.executeAsync(ParsePinningEventuallyQueue.this.httpClient);
            }
          }
        }
      }
    });
  }
  
  private j<Void> runEventuallyAsync(final EventuallyPin paramEventuallyPin)
  {
    final String str = paramEventuallyPin.getUUID();
    if (this.eventuallyPinUUIDQueue.contains(str)) {
      return j.a(null);
    }
    this.eventuallyPinUUIDQueue.add(str);
    this.operationSetTaskQueue.enqueue(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        ParsePinningEventuallyQueue.this.runEventuallyAsync(paramEventuallyPin, paramAnonymousj).b(new h()
        {
          public j<Void> then(j<Void> paramAnonymous2j)
          {
            ParsePinningEventuallyQueue.this.eventuallyPinUUIDQueue.remove(ParsePinningEventuallyQueue.9.this.val$uuid);
            return paramAnonymous2j;
          }
        });
      }
    });
    return j.a(null);
  }
  
  private j<Void> runEventuallyAsync(final EventuallyPin paramEventuallyPin, j<Void> paramj)
  {
    paramj.b(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        return ParsePinningEventuallyQueue.this.waitForConnectionAsync();
      }
    }).d(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        ParsePinningEventuallyQueue.this.waitForOperationSetAndEventuallyPin(null, paramEventuallyPin).b(new h()
        {
          public j<Void> then(j<JSONObject> paramAnonymous2j)
          {
            Exception localException = paramAnonymous2j.g();
            k localk;
            if (localException != null)
            {
              if ((localException instanceof ParsePinningEventuallyQueue.PauseException)) {
                return paramAnonymous2j.k();
              }
              if (6 >= Parse.getLogLevel()) {
                PLog.e("ParsePinningEventuallyQueue", "Failed to run command.", localException);
              }
              ParsePinningEventuallyQueue.this.notifyTestHelper(2, localException);
              localk = (k)ParsePinningEventuallyQueue.this.pendingOperationSetUUIDTasks.remove(ParsePinningEventuallyQueue.10.this.val$eventuallyPin.getUUID());
              if (localk != null)
              {
                if (localException == null) {
                  break label108;
                }
                localk.b(localException);
              }
            }
            for (;;)
            {
              return paramAnonymous2j.k();
              ParsePinningEventuallyQueue.this.notifyTestHelper(1);
              break;
              label108:
              localk.b(paramAnonymous2j.f());
            }
          }
        });
      }
    });
  }
  
  private j<Void> waitForConnectionAsync()
  {
    synchronized (this.connectionLock)
    {
      j localj = this.connectionTaskCompletionSource.a();
      return localj;
    }
  }
  
  private j<Void> whenAll(Collection<TaskQueue> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(((TaskQueue)paramCollection.next()).enqueue(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          return paramAnonymousj;
        }
      }));
    }
    return j.a(localArrayList);
  }
  
  public void clear()
  {
    pause();
    j localj = this.taskQueue.enqueue(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        paramAnonymousj.b(new h()
        {
          public j<Void> then(j<Void> paramAnonymous2j)
          {
            EventuallyPin.findAllPinned().d(new h()
            {
              public j<Void> then(j<List<EventuallyPin>> paramAnonymous3j)
              {
                Object localObject = (List)paramAnonymous3j.f();
                paramAnonymous3j = new ArrayList();
                localObject = ((List)localObject).iterator();
                while (((Iterator)localObject).hasNext()) {
                  paramAnonymous3j.add(((EventuallyPin)((Iterator)localObject).next()).unpinInBackground("_eventuallyPin"));
                }
                return j.a(paramAnonymous3j);
              }
            });
          }
        });
      }
    });
    try
    {
      ParseTaskUtils.wait(localj);
      simulateReboot();
      resume();
      return;
    }
    catch (ParseException localParseException)
    {
      throw new IllegalStateException(localParseException);
    }
  }
  
  public j<JSONObject> enqueueEventuallyAsync(final ParseRESTCommand paramParseRESTCommand, final ParseObject paramParseObject)
  {
    Parse.requirePermission("android.permission.ACCESS_NETWORK_STATE");
    final k localk = new k();
    this.taskQueue.enqueue(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        return ParsePinningEventuallyQueue.this.enqueueEventuallyAsync(paramParseRESTCommand, paramParseObject, paramAnonymousj, localk);
      }
    });
    return localk.a();
  }
  
  public void onDestroy()
  {
    this.notifier.removeListener(this.listener);
  }
  
  public void pause()
  {
    synchronized (this.connectionLock)
    {
      this.connectionTaskCompletionSource.a(new PauseException(null));
      this.connectionTaskCompletionSource = j.b();
      this.connectionTaskCompletionSource.a(new PauseException(null));
      synchronized (this.taskQueueSyncLock)
      {
        Iterator localIterator = this.pendingEventuallyTasks.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((k)this.pendingEventuallyTasks.get(str)).a(new PauseException(null));
        }
      }
    }
    this.pendingEventuallyTasks.clear();
    this.uuidToOperationSet.clear();
    this.uuidToEventuallyPin.clear();
    try
    {
      ParseTaskUtils.wait(whenAll(Arrays.asList(new TaskQueue[] { this.taskQueue, this.operationSetTaskQueue })));
      return;
    }
    catch (ParseException localParseException)
    {
      throw new IllegalStateException(localParseException);
    }
  }
  
  public int pendingCount()
  {
    try
    {
      int i = ((Integer)ParseTaskUtils.wait(pendingCountAsync())).intValue();
      return i;
    }
    catch (ParseException localParseException)
    {
      throw new IllegalStateException(localParseException);
    }
  }
  
  public j<Integer> pendingCountAsync()
  {
    final k localk = new k();
    this.taskQueue.enqueue(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        ParsePinningEventuallyQueue.this.pendingCountAsync(paramAnonymousj).b(new h()
        {
          public j<Void> then(j<Integer> paramAnonymous2j)
          {
            int i = ((Integer)paramAnonymous2j.f()).intValue();
            ParsePinningEventuallyQueue.2.this.val$tcs.b(Integer.valueOf(i));
            return j.a(null);
          }
        });
      }
    });
    return localk.a();
  }
  
  public j<Integer> pendingCountAsync(j<Void> paramj)
  {
    paramj.b(new h()
    {
      public j<Integer> then(j<Void> paramAnonymousj)
      {
        EventuallyPin.findAllPinned().b(new h()
        {
          public j<Integer> then(j<List<EventuallyPin>> paramAnonymous2j)
          {
            return j.a(Integer.valueOf(((List)paramAnonymous2j.f()).size()));
          }
        });
      }
    });
  }
  
  public void resume()
  {
    if (isConnected())
    {
      this.connectionTaskCompletionSource.a(null);
      this.connectionTaskCompletionSource = j.b();
      this.connectionTaskCompletionSource.a(null);
    }
    for (;;)
    {
      populateQueueAsync();
      return;
      this.connectionTaskCompletionSource = j.b();
    }
  }
  
  public void setConnected(boolean paramBoolean)
  {
    synchronized (this.connectionLock)
    {
      if (isConnected() != paramBoolean)
      {
        super.setConnected(paramBoolean);
        if (paramBoolean)
        {
          this.connectionTaskCompletionSource.a(null);
          this.connectionTaskCompletionSource = j.b();
          this.connectionTaskCompletionSource.a(null);
        }
      }
      else
      {
        return;
      }
      this.connectionTaskCompletionSource = j.b();
    }
  }
  
  void simulateReboot()
  {
    pause();
    this.pendingOperationSetUUIDTasks.clear();
    this.pendingEventuallyTasks.clear();
    this.uuidToOperationSet.clear();
    this.uuidToEventuallyPin.clear();
    resume();
  }
  
  j<JSONObject> waitForOperationSetAndEventuallyPin(final ParseOperationSet paramParseOperationSet, EventuallyPin paramEventuallyPin)
  {
    if ((paramEventuallyPin != null) && (paramEventuallyPin.getType() != 1)) {
      return process(paramEventuallyPin, null);
    }
    Object localObject = this.taskQueueSyncLock;
    if ((paramParseOperationSet != null) && (paramEventuallyPin == null)) {}
    ParseOperationSet localParseOperationSet;
    for (;;)
    {
      try
      {
        paramEventuallyPin = paramParseOperationSet.getUUID();
        this.uuidToOperationSet.put(paramEventuallyPin, paramParseOperationSet);
        paramParseOperationSet = paramEventuallyPin;
        paramEventuallyPin = (EventuallyPin)this.uuidToEventuallyPin.get(paramParseOperationSet);
        localParseOperationSet = (ParseOperationSet)this.uuidToOperationSet.get(paramParseOperationSet);
        if ((paramEventuallyPin != null) && (localParseOperationSet != null)) {
          break;
        }
        if (!this.pendingEventuallyTasks.containsKey(paramParseOperationSet)) {
          break label159;
        }
        paramParseOperationSet = (k)this.pendingEventuallyTasks.get(paramParseOperationSet);
        paramParseOperationSet = paramParseOperationSet.a();
        return paramParseOperationSet;
      }
      finally {}
      if ((paramParseOperationSet == null) && (paramEventuallyPin != null))
      {
        paramParseOperationSet = paramEventuallyPin.getOperationSetUUID();
        this.uuidToEventuallyPin.put(paramParseOperationSet, paramEventuallyPin);
      }
      else
      {
        throw new IllegalStateException("Either operationSet or eventuallyPin must be set.");
        label159:
        paramEventuallyPin = j.b();
        this.pendingEventuallyTasks.put(paramParseOperationSet, paramEventuallyPin);
        paramParseOperationSet = paramEventuallyPin;
      }
    }
    final k localk = (k)this.pendingEventuallyTasks.get(paramParseOperationSet);
    process(paramEventuallyPin, localParseOperationSet).b(new h()
    {
      public j<JSONObject> then(j<JSONObject> paramAnonymousj)
      {
        for (;;)
        {
          synchronized (ParsePinningEventuallyQueue.this.taskQueueSyncLock)
          {
            ParsePinningEventuallyQueue.this.pendingEventuallyTasks.remove(paramParseOperationSet);
            ParsePinningEventuallyQueue.this.uuidToOperationSet.remove(paramParseOperationSet);
            ParsePinningEventuallyQueue.this.uuidToEventuallyPin.remove(paramParseOperationSet);
            ??? = paramAnonymousj.g();
            if (??? != null)
            {
              localk.a((Exception)???);
              return localk.a();
            }
          }
          if (paramAnonymousj.d()) {
            localk.b();
          } else {
            localk.a(paramAnonymousj.f());
          }
        }
      }
    });
  }
  
  private static class PauseException
    extends Exception
  {}
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParsePinningEventuallyQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */