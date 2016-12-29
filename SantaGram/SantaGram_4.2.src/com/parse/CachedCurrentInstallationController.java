package com.parse;

import a.h;
import a.j;

class CachedCurrentInstallationController
  implements ParseCurrentInstallationController
{
  static final String TAG = "com.parse.CachedCurrentInstallationController";
  ParseInstallation currentInstallation;
  private final InstallationId installationId;
  private final Object mutex = new Object();
  private final ParseObjectStore<ParseInstallation> store;
  private final TaskQueue taskQueue = new TaskQueue();
  
  public CachedCurrentInstallationController(ParseObjectStore<ParseInstallation> paramParseObjectStore, InstallationId paramInstallationId)
  {
    this.store = paramParseObjectStore;
    this.installationId = paramInstallationId;
  }
  
  public void clearFromDisk()
  {
    synchronized (this.mutex)
    {
      this.currentInstallation = null;
    }
    try
    {
      this.installationId.clear();
      ParseTaskUtils.wait(this.store.deleteAsync());
      return;
    }
    catch (ParseException localParseException) {}
    localObject2 = finally;
    throw ((Throwable)localObject2);
  }
  
  public void clearFromMemory()
  {
    synchronized (this.mutex)
    {
      this.currentInstallation = null;
      return;
    }
  }
  
  public j<Boolean> existsAsync()
  {
    synchronized (this.mutex)
    {
      if (this.currentInstallation != null)
      {
        j localj = j.a(Boolean.valueOf(true));
        return localj;
      }
      this.taskQueue.enqueue(new h()
      {
        public j<Boolean> then(j<Void> paramAnonymousj)
        {
          paramAnonymousj.b(new h()
          {
            public j<Boolean> then(j<Void> paramAnonymous2j)
            {
              return CachedCurrentInstallationController.this.store.existsAsync();
            }
          });
        }
      });
    }
  }
  
  public j<ParseInstallation> getAsync()
  {
    synchronized (this.mutex)
    {
      if (this.currentInstallation != null)
      {
        j localj = j.a(this.currentInstallation);
        return localj;
      }
      this.taskQueue.enqueue(new h()
      {
        public j<ParseInstallation> then(j<Void> paramAnonymousj)
        {
          paramAnonymousj.b(new h()
          {
            public j<ParseInstallation> then(j<Void> arg1)
            {
              synchronized (CachedCurrentInstallationController.this.mutex)
              {
                if (CachedCurrentInstallationController.this.currentInstallation != null)
                {
                  j localj = j.a(CachedCurrentInstallationController.this.currentInstallation);
                  return localj;
                }
                CachedCurrentInstallationController.this.store.getAsync().a(new h()
                {
                  public ParseInstallation then(j<ParseInstallation> paramAnonymous3j)
                  {
                    paramAnonymous3j = (ParseInstallation)paramAnonymous3j.f();
                    if (paramAnonymous3j == null)
                    {
                      paramAnonymous3j = (ParseInstallation)ParseObject.create(ParseInstallation.class);
                      paramAnonymous3j.updateDeviceInfo(CachedCurrentInstallationController.this.installationId);
                    }
                    synchronized (CachedCurrentInstallationController.this.mutex)
                    {
                      CachedCurrentInstallationController.this.currentInstallation = paramAnonymous3j;
                      return paramAnonymous3j;
                      CachedCurrentInstallationController.this.installationId.set(paramAnonymous3j.getInstallationId());
                      PLog.v("com.parse.CachedCurrentInstallationController", "Successfully deserialized Installation object");
                    }
                  }
                }, ParseExecutors.io());
              }
            }
          });
        }
      });
    }
  }
  
  public boolean isCurrent(ParseInstallation paramParseInstallation)
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        if (this.currentInstallation == paramParseInstallation)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public j<Void> setAsync(final ParseInstallation paramParseInstallation)
  {
    if (!isCurrent(paramParseInstallation)) {
      return j.a(null);
    }
    this.taskQueue.enqueue(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        paramAnonymousj.b(new h()
        {
          public j<Void> then(j<Void> paramAnonymous2j)
          {
            return CachedCurrentInstallationController.this.store.setAsync(CachedCurrentInstallationController.1.this.val$installation);
          }
        }).b(new h()
        {
          public j<Void> then(j<Void> paramAnonymous2j)
          {
            CachedCurrentInstallationController.this.installationId.set(CachedCurrentInstallationController.1.this.val$installation.getInstallationId());
            return paramAnonymous2j;
          }
        }, ParseExecutors.io());
      }
    });
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/CachedCurrentInstallationController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */