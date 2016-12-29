package com.parse;

import a.g;
import a.h;
import a.j;
import a.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseObject
{
  private static final String AUTO_CLASS_NAME = "_Automatic";
  public static final String DEFAULT_PIN = "_default";
  private static final String KEY_ACL = "ACL";
  private static final String KEY_CLASS_NAME = "className";
  private static final String KEY_COMPLETE = "__complete";
  private static final String KEY_CREATED_AT = "createdAt";
  static final String KEY_IS_DELETING_EVENTUALLY = "__isDeletingEventually";
  private static final String KEY_IS_DELETING_EVENTUALLY_OLD = "isDeletingEventually";
  private static final String KEY_OBJECT_ID = "objectId";
  private static final String KEY_OPERATIONS = "__operations";
  private static final String KEY_UPDATED_AT = "updatedAt";
  private static final String NEW_OFFLINE_OBJECT_ID_PLACEHOLDER = "*** Offline Object ***";
  static final String VERSION_NAME = "1.13.1";
  private static final ThreadLocal<String> isCreatingPointerForObjectId = new ThreadLocal()
  {
    protected String initialValue()
    {
      return null;
    }
  };
  private final Map<String, Object> estimatedData;
  boolean isDeleted;
  int isDeletingEventually;
  private String localId;
  final Object mutex = new Object();
  final LinkedList<ParseOperationSet> operationSetQueue;
  private final ParseMulticastDelegate<ParseObject> saveEvent = new ParseMulticastDelegate();
  private State state;
  final TaskQueue taskQueue = new TaskQueue();
  
  protected ParseObject()
  {
    this("_Automatic");
  }
  
  public ParseObject(String paramString)
  {
    String str2 = (String)isCreatingPointerForObjectId.get();
    if (paramString == null) {
      throw new IllegalArgumentException("You must specify a Parse class name when creating a new ParseObject.");
    }
    String str1 = paramString;
    if ("_Automatic".equals(paramString)) {
      str1 = getSubclassingController().getClassName(getClass());
    }
    if (!getSubclassingController().isSubclassValid(str1, getClass())) {
      throw new IllegalArgumentException("You must create this type of ParseObject using ParseObject.create() or the proper subclass.");
    }
    this.operationSetQueue = new LinkedList();
    this.operationSetQueue.add(new ParseOperationSet());
    this.estimatedData = new HashMap();
    paramString = newStateBuilder(str1);
    if (str2 == null)
    {
      setDefaultValues();
      paramString.isComplete(true);
    }
    for (;;)
    {
      this.state = paramString.build();
      paramString = Parse.getLocalDatastore();
      if (paramString != null) {
        paramString.registerNewObject(this);
      }
      return;
      if (!str2.equals("*** Offline Object ***")) {
        paramString.objectId(str2);
      }
      paramString.isComplete(false);
    }
  }
  
  private void applyOperations(ParseOperationSet paramParseOperationSet, Map<String, Object> paramMap)
  {
    Iterator localIterator = paramParseOperationSet.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = ((ParseFieldOperation)paramParseOperationSet.get(str)).apply(paramMap.get(str), str);
      if (localObject != null) {
        paramMap.put(str, localObject);
      } else {
        paramMap.remove(str);
      }
    }
  }
  
  private boolean canBeSerialized()
  {
    synchronized (this.mutex)
    {
      final g localg = new g(Boolean.valueOf(true));
      new ParseTraverser()
      {
        protected boolean visit(Object paramAnonymousObject)
        {
          if (((paramAnonymousObject instanceof ParseFile)) && (((ParseFile)paramAnonymousObject).isDirty())) {
            localg.a(Boolean.valueOf(false));
          }
          if (((paramAnonymousObject instanceof ParseObject)) && (((ParseObject)paramAnonymousObject).getObjectId() == null)) {
            localg.a(Boolean.valueOf(false));
          }
          return ((Boolean)localg.a()).booleanValue();
        }
      }.setYieldRoot(false).setTraverseParseObjects(true).traverse(this);
      boolean bool = ((Boolean)localg.a()).booleanValue();
      return bool;
    }
  }
  
  private void checkGetAccess(String paramString)
  {
    if (!isDataAvailable(paramString)) {
      throw new IllegalStateException("ParseObject has no data for '" + paramString + "'. Call fetchIfNeeded() to get the data.");
    }
  }
  
  private void checkKeyIsMutable(String paramString)
  {
    if (!isKeyMutable(paramString)) {
      throw new IllegalArgumentException("Cannot modify `" + paramString + "` property of an " + getClassName() + " object.");
    }
  }
  
  private static void collectDirtyChildren(Object paramObject, Collection<ParseObject> paramCollection, Collection<ParseFile> paramCollection1)
  {
    collectDirtyChildren(paramObject, paramCollection, paramCollection1, new HashSet(), new HashSet());
  }
  
  private static void collectDirtyChildren(Object paramObject, final Collection<ParseObject> paramCollection, Collection<ParseFile> paramCollection1, final Set<ParseObject> paramSet1, final Set<ParseObject> paramSet2)
  {
    new ParseTraverser()
    {
      protected boolean visit(Object paramAnonymousObject)
      {
        if ((paramAnonymousObject instanceof ParseFile)) {
          if (this.val$dirtyFiles != null) {}
        }
        label188:
        for (;;)
        {
          return true;
          paramAnonymousObject = (ParseFile)paramAnonymousObject;
          if (((ParseFile)paramAnonymousObject).getUrl() == null)
          {
            this.val$dirtyFiles.add(paramAnonymousObject);
            return true;
            if (((paramAnonymousObject instanceof ParseObject)) && (paramCollection != null))
            {
              ParseObject localParseObject = (ParseObject)paramAnonymousObject;
              Object localObject = paramSet1;
              paramAnonymousObject = paramSet2;
              if (localParseObject.getObjectId() != null) {
                paramAnonymousObject = new HashSet();
              }
              for (;;)
              {
                if (((Set)localObject).contains(localParseObject)) {
                  break label188;
                }
                localObject = new HashSet((Collection)localObject);
                ((Set)localObject).add(localParseObject);
                ParseObject.collectDirtyChildren(localParseObject.estimatedData, paramCollection, this.val$dirtyFiles, (Set)localObject, (Set)paramAnonymousObject);
                if (!localParseObject.isDirty(false)) {
                  break;
                }
                paramCollection.add(localParseObject);
                return true;
                if (((Set)paramAnonymousObject).contains(localParseObject)) {
                  throw new RuntimeException("Found a circular dependency while saving.");
                }
                paramAnonymousObject = new HashSet((Collection)paramAnonymousObject);
                ((Set)paramAnonymousObject).add(localParseObject);
              }
            }
          }
        }
      }
    }.setYieldRoot(true).traverse(paramObject);
  }
  
  private Map<String, ParseObject> collectFetchedObjects()
  {
    final HashMap localHashMap = new HashMap();
    new ParseTraverser()
    {
      protected boolean visit(Object paramAnonymousObject)
      {
        if ((paramAnonymousObject instanceof ParseObject))
        {
          paramAnonymousObject = (ParseObject)paramAnonymousObject;
          ParseObject.State localState = ((ParseObject)paramAnonymousObject).getState();
          if ((localState.objectId() != null) && (localState.isComplete())) {
            localHashMap.put(localState.objectId(), paramAnonymousObject);
          }
        }
        return true;
      }
    }.traverse(this.estimatedData);
    return localHashMap;
  }
  
  public static <T extends ParseObject> T create(Class<T> paramClass)
  {
    return create(getSubclassingController().getClassName(paramClass));
  }
  
  public static ParseObject create(String paramString)
  {
    return getSubclassingController().newInstance(paramString);
  }
  
  public static <T extends ParseObject> T createWithoutData(Class<T> paramClass, String paramString)
  {
    return createWithoutData(getSubclassingController().getClassName(paramClass), paramString);
  }
  
  /* Error */
  public static ParseObject createWithoutData(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 301	com/parse/Parse:getLocalDatastore	()Lcom/parse/OfflineStore;
    //   3: astore_2
    //   4: aload_1
    //   5: ifnonnull +70 -> 75
    //   8: getstatic 208	com/parse/ParseObject:isCreatingPointerForObjectId	Ljava/lang/ThreadLocal;
    //   11: ldc -80
    //   13: invokevirtual 515	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   16: aload_2
    //   17: ifnull +90 -> 107
    //   20: aload_1
    //   21: ifnull +86 -> 107
    //   24: aload_2
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 518	com/parse/OfflineStore:getObject	(Ljava/lang/String;Ljava/lang/String;)Lcom/parse/ParseObject;
    //   30: astore_1
    //   31: aload_1
    //   32: astore_2
    //   33: aload_1
    //   34: ifnonnull +64 -> 98
    //   37: aload_0
    //   38: invokestatic 498	com/parse/ParseObject:create	(Ljava/lang/String;)Lcom/parse/ParseObject;
    //   41: astore_0
    //   42: aload_0
    //   43: astore_2
    //   44: aload_0
    //   45: invokevirtual 521	com/parse/ParseObject:hasChanges	()Z
    //   48: ifeq +50 -> 98
    //   51: new 451	java/lang/IllegalStateException
    //   54: dup
    //   55: ldc_w 523
    //   58: invokespecial 467	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   61: athrow
    //   62: astore_0
    //   63: aload_0
    //   64: athrow
    //   65: astore_0
    //   66: getstatic 208	com/parse/ParseObject:isCreatingPointerForObjectId	Ljava/lang/ThreadLocal;
    //   69: aconst_null
    //   70: invokevirtual 515	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   73: aload_0
    //   74: athrow
    //   75: getstatic 208	com/parse/ParseObject:isCreatingPointerForObjectId	Ljava/lang/ThreadLocal;
    //   78: aload_1
    //   79: invokevirtual 515	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   82: goto -66 -> 16
    //   85: astore_0
    //   86: new 510	java/lang/RuntimeException
    //   89: dup
    //   90: ldc_w 525
    //   93: aload_0
    //   94: invokespecial 528	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   97: athrow
    //   98: getstatic 208	com/parse/ParseObject:isCreatingPointerForObjectId	Ljava/lang/ThreadLocal;
    //   101: aconst_null
    //   102: invokevirtual 515	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   105: aload_2
    //   106: areturn
    //   107: aconst_null
    //   108: astore_1
    //   109: goto -78 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramString1	String
    //   0	112	1	paramString2	String
    //   3	103	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	16	62	java/lang/RuntimeException
    //   24	31	62	java/lang/RuntimeException
    //   37	42	62	java/lang/RuntimeException
    //   44	62	62	java/lang/RuntimeException
    //   75	82	62	java/lang/RuntimeException
    //   8	16	65	finally
    //   24	31	65	finally
    //   37	42	65	finally
    //   44	62	65	finally
    //   63	65	65	finally
    //   75	82	65	finally
    //   86	98	65	finally
    //   8	16	85	java/lang/Exception
    //   24	31	85	java/lang/Exception
    //   37	42	85	java/lang/Exception
    //   44	62	85	java/lang/Exception
    //   75	82	85	java/lang/Exception
  }
  
  private ParseOperationSet currentOperations()
  {
    synchronized (this.mutex)
    {
      ParseOperationSet localParseOperationSet = (ParseOperationSet)this.operationSetQueue.getLast();
      return localParseOperationSet;
    }
  }
  
  private ParseRESTObjectCommand currentSaveEventuallyCommand(ParseOperationSet paramParseOperationSet, ParseEncoder paramParseEncoder, String paramString)
  {
    State localState = getState();
    paramParseOperationSet = ParseRESTObjectCommand.saveObjectCommand(localState, toJSONObjectForSaving(localState, paramParseOperationSet, paramParseEncoder), paramString);
    paramParseOperationSet.enableRetrying();
    return paramParseOperationSet;
  }
  
  private static j<Void> deepSaveAsync(final Object paramObject, final String paramString)
  {
    Object localObject1 = new HashSet();
    Object localObject3 = new HashSet();
    collectDirtyChildren(paramObject, (Collection)localObject1, (Collection)localObject3);
    Object localObject2 = new HashSet();
    paramObject = ((Set)localObject1).iterator();
    while (((Iterator)paramObject).hasNext())
    {
      localObject4 = (ParseObject)((Iterator)paramObject).next();
      if (((localObject4 instanceof ParseUser)) && (((ParseUser)localObject4).isLazy())) {
        ((Set)localObject2).add((ParseUser)localObject4);
      }
    }
    ((Set)localObject1).removeAll((Collection)localObject2);
    paramObject = new AtomicBoolean(false);
    final Object localObject4 = new ArrayList();
    localObject3 = ((Set)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((List)localObject4).add(((ParseFile)((Iterator)localObject3).next()).saveAsync(paramString, null, null));
    }
    localObject3 = j.a((Collection)localObject4).a(new h()
    {
      public Void then(j<Void> paramAnonymousj)
      {
        this.val$filesComplete.set(true);
        return null;
      }
    });
    localObject4 = new AtomicBoolean(false);
    ArrayList localArrayList = new ArrayList();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localArrayList.add(((ParseUser)((Iterator)localObject2).next()).saveAsync(paramString));
    }
    localObject2 = j.a(localArrayList).a(new h()
    {
      public Void then(j<Void> paramAnonymousj)
      {
        this.val$usersComplete.set(true);
        return null;
      }
    });
    localObject1 = new g(localObject1);
    j.a(Arrays.asList(new j[] { localObject3, localObject2, j.a(null).a(new Callable()new h
    {
      public Boolean call()
      {
        if (((Set)this.val$remaining.a()).size() > 0) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    }, new h()
    {
      public j<Void> then(final j<Void> paramAnonymousj)
      {
        paramAnonymousj = new ArrayList();
        HashSet localHashSet = new HashSet();
        Iterator localIterator = ((Set)this.val$remaining.a()).iterator();
        while (localIterator.hasNext())
        {
          ParseObject localParseObject = (ParseObject)localIterator.next();
          if (localParseObject.canBeSerialized()) {
            paramAnonymousj.add(localParseObject);
          } else {
            localHashSet.add(localParseObject);
          }
        }
        this.val$remaining.a(localHashSet);
        if ((paramAnonymousj.size() == 0) && (paramObject.get()) && (localObject4.get())) {
          throw new RuntimeException("Unable to save a ParseObject with a relation to a cycle.");
        }
        if (paramAnonymousj.size() == 0) {
          return j.a(null);
        }
        ParseObject.enqueueForAll(paramAnonymousj, new h()
        {
          public j<Void> then(j<Void> paramAnonymous2j)
          {
            return ParseObject.saveAllAsync(paramAnonymousj, ParseObject.41.this.val$sessionToken, paramAnonymous2j);
          }
        });
      }
    }) }));
  }
  
  public static <T extends ParseObject> void deleteAll(List<T> paramList)
  {
    ParseTaskUtils.wait(deleteAllInBackground(paramList));
  }
  
  private static <T extends ParseObject> j<Void> deleteAllAsync(List<T> paramList, final String paramString)
  {
    if (paramList.size() == 0) {
      return j.a(null);
    }
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList(j);
    HashSet localHashSet = new HashSet();
    int i = 0;
    while (i < j)
    {
      ParseObject localParseObject = (ParseObject)paramList.get(i);
      if (!localHashSet.contains(localParseObject.getObjectId()))
      {
        localHashSet.add(localParseObject.getObjectId());
        localArrayList.add(localParseObject);
      }
      i += 1;
    }
    enqueueForAll(localArrayList, new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        return ParseObject.deleteAllAsync(this.val$uniqueObjects, paramString, paramAnonymousj);
      }
    });
  }
  
  private static <T extends ParseObject> j<Void> deleteAllAsync(List<T> paramList, final String paramString, j<Void> paramj)
  {
    paramj.b(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        int j = this.val$uniqueObjects.size();
        paramAnonymousj = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          localObject = (ParseObject)this.val$uniqueObjects.get(i);
          ((ParseObject)localObject).validateDelete();
          paramAnonymousj.add(((ParseObject)localObject).getState());
          i += 1;
        }
        paramAnonymousj = ParseObject.access$800().deleteAllAsync(paramAnonymousj, paramString);
        Object localObject = new ArrayList(j);
        i = 0;
        while (i < j)
        {
          ((List)localObject).add(((j)paramAnonymousj.get(i)).d(new h()
          {
            public j<Void> then(final j<Void> paramAnonymous2j)
            {
              this.val$object.handleDeleteResultAsync().b(new h()
              {
                public j<Void> then(j<Void> paramAnonymous3j)
                {
                  return paramAnonymous2j;
                }
              });
            }
          }));
          i += 1;
        }
        return j.a((Collection)localObject);
      }
    });
  }
  
  public static <T extends ParseObject> j<Void> deleteAllInBackground(List<T> paramList)
  {
    ParseUser.getCurrentSessionTokenAsync().d(new h()
    {
      public j<Void> then(j<String> paramAnonymousj)
      {
        paramAnonymousj = (String)paramAnonymousj.f();
        return ParseObject.deleteAllAsync(this.val$objects, paramAnonymousj);
      }
    });
  }
  
  public static <T extends ParseObject> void deleteAllInBackground(List<T> paramList, DeleteCallback paramDeleteCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(deleteAllInBackground(paramList), paramDeleteCallback);
  }
  
  private j<Void> deleteAsync(final String paramString, j<Void> paramj)
  {
    validateDelete();
    paramj.d(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        if (ParseObject.this.state.objectId() == null) {
          return paramAnonymousj.j();
        }
        return ParseObject.this.deleteAsync(paramString);
      }
    }).d(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        return ParseObject.this.handleDeleteResultAsync();
      }
    });
  }
  
  /* Error */
  static <T> j<T> enqueueForAll(List<? extends ParseObject> paramList, final h<Void, j<T>> paramh)
  {
    // Byte code:
    //   0: new 684	a/k
    //   3: dup
    //   4: invokespecial 685	a/k:<init>	()V
    //   7: astore_3
    //   8: new 570	java/util/ArrayList
    //   11: dup
    //   12: aload_0
    //   13: invokeinterface 631 1 0
    //   18: invokespecial 634	java/util/ArrayList:<init>	(I)V
    //   21: astore_2
    //   22: aload_0
    //   23: invokeinterface 686 1 0
    //   28: astore 4
    //   30: aload 4
    //   32: invokeinterface 388 1 0
    //   37: ifeq +29 -> 66
    //   40: aload_2
    //   41: aload 4
    //   43: invokeinterface 391 1 0
    //   48: checkcast 2	com/parse/ParseObject
    //   51: getfield 220	com/parse/ParseObject:taskQueue	Lcom/parse/TaskQueue;
    //   54: invokevirtual 690	com/parse/TaskQueue:getLock	()Ljava/util/concurrent/locks/Lock;
    //   57: invokeinterface 580 2 0
    //   62: pop
    //   63: goto -33 -> 30
    //   66: new 692	com/parse/LockSet
    //   69: dup
    //   70: aload_2
    //   71: invokespecial 695	com/parse/LockSet:<init>	(Ljava/util/Collection;)V
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 698	com/parse/LockSet:lock	()V
    //   79: aload_1
    //   80: aload_3
    //   81: invokevirtual 700	a/k:a	()La/j;
    //   84: invokeinterface 705 2 0
    //   89: checkcast 582	a/j
    //   92: astore_1
    //   93: new 570	java/util/ArrayList
    //   96: dup
    //   97: invokespecial 571	java/util/ArrayList:<init>	()V
    //   100: astore 4
    //   102: aload_0
    //   103: invokeinterface 686 1 0
    //   108: astore_0
    //   109: aload_0
    //   110: invokeinterface 388 1 0
    //   115: ifeq +52 -> 167
    //   118: aload_0
    //   119: invokeinterface 391 1 0
    //   124: checkcast 2	com/parse/ParseObject
    //   127: getfield 220	com/parse/ParseObject:taskQueue	Lcom/parse/TaskQueue;
    //   130: new 34	com/parse/ParseObject$2
    //   133: dup
    //   134: aload 4
    //   136: aload_1
    //   137: invokespecial 708	com/parse/ParseObject$2:<init>	(Ljava/util/List;La/j;)V
    //   140: invokevirtual 711	com/parse/TaskQueue:enqueue	(La/h;)La/j;
    //   143: pop
    //   144: goto -35 -> 109
    //   147: astore_0
    //   148: aload_2
    //   149: invokevirtual 714	com/parse/LockSet:unlock	()V
    //   152: aload_0
    //   153: athrow
    //   154: astore_0
    //   155: aload_0
    //   156: athrow
    //   157: astore_0
    //   158: new 510	java/lang/RuntimeException
    //   161: dup
    //   162: aload_0
    //   163: invokespecial 717	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   166: athrow
    //   167: aload 4
    //   169: invokestatic 585	a/j:a	(Ljava/util/Collection;)La/j;
    //   172: new 60	com/parse/ParseObject$3
    //   175: dup
    //   176: aload_3
    //   177: invokespecial 720	com/parse/ParseObject$3:<init>	(La/k;)V
    //   180: invokevirtual 591	a/j:a	(La/h;)La/j;
    //   183: pop
    //   184: aload_2
    //   185: invokevirtual 714	com/parse/LockSet:unlock	()V
    //   188: aload_1
    //   189: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramList	List<? extends ParseObject>
    //   0	190	1	paramh	h<Void, j<T>>
    //   21	164	2	localObject1	Object
    //   7	170	3	localk	k
    //   28	140	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   79	93	147	finally
    //   93	109	147	finally
    //   109	144	147	finally
    //   155	157	147	finally
    //   158	167	147	finally
    //   167	184	147	finally
    //   79	93	154	java/lang/RuntimeException
    //   79	93	157	java/lang/Exception
  }
  
  private j<Void> enqueueSaveEventuallyOperationAsync(final ParseOperationSet paramParseOperationSet)
  {
    if (!paramParseOperationSet.isSaveEventually()) {
      throw new IllegalStateException("This should only be used to enqueue saveEventually operation sets");
    }
    this.taskQueue.enqueue(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        paramAnonymousj.b(new h()
        {
          public j<Void> then(j<Void> paramAnonymous2j)
          {
            return Parse.getEventuallyQueue().waitForOperationSetAndEventuallyPin(ParseObject.15.this.val$operationSet, null).k();
          }
        });
      }
    });
  }
  
  public static <T extends ParseObject> List<T> fetchAll(List<T> paramList)
  {
    return (List)ParseTaskUtils.wait(fetchAllInBackground(paramList));
  }
  
  private static <T extends ParseObject> j<List<T>> fetchAllAsync(List<T> paramList, final ParseUser paramParseUser, final boolean paramBoolean, j<Void> paramj)
  {
    if (paramList.size() == 0) {
      return j.a(paramList);
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      ParseObject localParseObject = (ParseObject)localIterator.next();
      if ((!paramBoolean) || (!localParseObject.isDataAvailable()))
      {
        if ((localObject != null) && (!localParseObject.getClassName().equals(localObject))) {
          throw new IllegalArgumentException("All objects should have the same class");
        }
        localObject = localParseObject.getClassName();
        if (localParseObject.getObjectId() != null) {
          localArrayList.add(localParseObject.getObjectId());
        } else if (!paramBoolean) {
          throw new IllegalArgumentException("All objects must exist on the server");
        }
      }
    }
    if (localArrayList.size() == 0) {
      return j.a(paramList);
    }
    paramj.b(new h()
    {
      public j<List<T>> then(j<Void> paramAnonymousj)
      {
        return this.val$query.findAsync(this.val$query.getBuilder().build(), paramParseUser, null);
      }
    }).c(new h()
    {
      public List<T> then(j<List<T>> paramAnonymousj)
      {
        HashMap localHashMap = new HashMap();
        paramAnonymousj = ((List)paramAnonymousj.f()).iterator();
        ParseObject localParseObject1;
        while (paramAnonymousj.hasNext())
        {
          localParseObject1 = (ParseObject)paramAnonymousj.next();
          localHashMap.put(localParseObject1.getObjectId(), localParseObject1);
        }
        paramAnonymousj = this.val$objects.iterator();
        while (paramAnonymousj.hasNext())
        {
          localParseObject1 = (ParseObject)paramAnonymousj.next();
          if ((!paramBoolean) || (!localParseObject1.isDataAvailable()))
          {
            ParseObject localParseObject2 = (ParseObject)localHashMap.get(localParseObject1.getObjectId());
            if (localParseObject2 == null) {
              throw new ParseException(101, "Object id " + localParseObject1.getObjectId() + " does not exist");
            }
            if (!Parse.isLocalDatastoreEnabled()) {
              localParseObject1.mergeFromObject(localParseObject2);
            }
          }
        }
        return this.val$objects;
      }
    });
  }
  
  private static <T extends ParseObject> j<List<T>> fetchAllAsync(List<T> paramList, final boolean paramBoolean)
  {
    ParseUser.getCurrentUserAsync().d(new h()
    {
      public j<List<T>> then(final j<ParseUser> paramAnonymousj)
      {
        paramAnonymousj = (ParseUser)paramAnonymousj.f();
        ParseObject.enqueueForAll(this.val$objects, new h()
        {
          public j<List<T>> then(j<Void> paramAnonymous2j)
          {
            return ParseObject.fetchAllAsync(ParseObject.45.this.val$objects, paramAnonymousj, ParseObject.45.this.val$onlyIfNeeded, paramAnonymous2j);
          }
        });
      }
    });
  }
  
  public static <T extends ParseObject> List<T> fetchAllIfNeeded(List<T> paramList)
  {
    return (List)ParseTaskUtils.wait(fetchAllIfNeededInBackground(paramList));
  }
  
  public static <T extends ParseObject> j<List<T>> fetchAllIfNeededInBackground(List<T> paramList)
  {
    return fetchAllAsync(paramList, true);
  }
  
  public static <T extends ParseObject> void fetchAllIfNeededInBackground(List<T> paramList, FindCallback<T> paramFindCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(fetchAllIfNeededInBackground(paramList), paramFindCallback);
  }
  
  public static <T extends ParseObject> j<List<T>> fetchAllInBackground(List<T> paramList)
  {
    return fetchAllAsync(paramList, false);
  }
  
  public static <T extends ParseObject> void fetchAllInBackground(List<T> paramList, FindCallback<T> paramFindCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(fetchAllInBackground(paramList), paramFindCallback);
  }
  
  static <T extends ParseObject> T from(State paramState)
  {
    ParseObject localParseObject = createWithoutData(paramState.className(), paramState.objectId());
    synchronized (localParseObject.mutex)
    {
      if (paramState.isComplete())
      {
        localParseObject.setState(paramState);
        return localParseObject;
      }
      paramState = localParseObject.getState().newBuilder().apply(paramState).build();
    }
  }
  
  static <T extends ParseObject> T fromJSON(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    return fromJSON(paramJSONObject, paramString, paramBoolean, ParseDecoder.get());
  }
  
  static <T extends ParseObject> T fromJSON(JSONObject paramJSONObject, String paramString, boolean paramBoolean, ParseDecoder paramParseDecoder)
  {
    paramString = paramJSONObject.optString("className", paramString);
    if (paramString == null) {
      return null;
    }
    paramString = createWithoutData(paramString, paramJSONObject.optString("objectId", null));
    paramString.setState(paramString.mergeFromServer(paramString.getState(), paramJSONObject, paramParseDecoder, paramBoolean));
    return paramString;
  }
  
  static <T extends ParseObject> T fromJSONPayload(JSONObject paramJSONObject, ParseDecoder paramParseDecoder)
  {
    Object localObject = paramJSONObject.optString("className");
    if ((localObject == null) || (ParseTextUtils.isEmpty((CharSequence)localObject))) {
      return null;
    }
    localObject = createWithoutData((String)localObject, paramJSONObject.optString("objectId", null));
    ((ParseObject)localObject).build(paramJSONObject, paramParseDecoder);
    return (T)localObject;
  }
  
  private ParseACL getACL(boolean paramBoolean)
  {
    synchronized (this.mutex)
    {
      checkGetAccess("ACL");
      Object localObject2 = this.estimatedData.get("ACL");
      if (localObject2 == null) {
        return null;
      }
      if (!(localObject2 instanceof ParseACL)) {
        throw new RuntimeException("only ACLs can be stored in the ACL key");
      }
    }
    if ((paramBoolean) && (((ParseACL)localObject3).isShared()))
    {
      localParseACL = new ParseACL((ParseACL)localObject3);
      this.estimatedData.put("ACL", localParseACL);
      return localParseACL;
    }
    ParseACL localParseACL = (ParseACL)localParseACL;
    return localParseACL;
  }
  
  private static LocalIdManager getLocalIdManager()
  {
    return ParseCorePlugins.getInstance().getLocalIdManager();
  }
  
  private static ParseObjectController getObjectController()
  {
    return ParseCorePlugins.getInstance().getObjectController();
  }
  
  private static ParseObjectSubclassingController getSubclassingController()
  {
    return ParseCorePlugins.getInstance().getSubclassingController();
  }
  
  private boolean hasDirtyChildren()
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        ArrayList localArrayList = new ArrayList();
        collectDirtyChildren(this.estimatedData, localArrayList, null);
        if (localArrayList.size() > 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private void notifyObjectIdChanged(String paramString1, String paramString2)
  {
    synchronized (this.mutex)
    {
      OfflineStore localOfflineStore = Parse.getLocalDatastore();
      if (localOfflineStore != null) {
        localOfflineStore.updateObjectId(this, paramString1, paramString2);
      }
      if (this.localId != null)
      {
        getLocalIdManager().setObjectId(this.localId, paramString2);
        this.localId = null;
      }
      return;
    }
  }
  
  public static <T extends ParseObject> void pinAll(String paramString, List<T> paramList)
  {
    ParseTaskUtils.wait(pinAllInBackground(paramString, paramList));
  }
  
  public static <T extends ParseObject> void pinAll(List<T> paramList)
  {
    ParseTaskUtils.wait(pinAllInBackground("_default", paramList));
  }
  
  public static <T extends ParseObject> j<Void> pinAllInBackground(String paramString, List<T> paramList)
  {
    return pinAllInBackground(paramString, paramList, true);
  }
  
  private static <T extends ParseObject> j<Void> pinAllInBackground(String paramString, final List<T> paramList, final boolean paramBoolean)
  {
    if (!Parse.isLocalDatastoreEnabled()) {
      throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
    }
    j localj = j.a(null);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localj = localj.d(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          if (!this.val$object.isDataAvailable("ACL")) {
            return j.a(null);
          }
          paramAnonymousj = this.val$object.getACL(false);
          if (paramAnonymousj == null) {
            return j.a(null);
          }
          paramAnonymousj = paramAnonymousj.getUnresolvedUser();
          if ((paramAnonymousj == null) || (!paramAnonymousj.isCurrentUser())) {
            return j.a(null);
          }
          return ParseUser.pinCurrentUserIfNeededAsync(paramAnonymousj);
        }
      });
    }
    localj.d(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        OfflineStore localOfflineStore = Parse.getLocalDatastore();
        if (this.val$name != null) {}
        for (paramAnonymousj = this.val$name;; paramAnonymousj = "_default") {
          return localOfflineStore.pinAllObjectsAsync(paramAnonymousj, paramList, paramBoolean);
        }
      }
    }).d(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        if ("_currentUser".equals(this.val$name)) {}
        Object localObject;
        do
        {
          do
          {
            Iterator localIterator;
            while (!localIterator.hasNext())
            {
              return paramAnonymousj;
              localIterator = paramList.iterator();
            }
            localObject = (ParseObject)localIterator.next();
          } while (!(localObject instanceof ParseUser));
          localObject = (ParseUser)localObject;
        } while (!((ParseUser)localObject).isCurrentUser());
        return ParseUser.pinCurrentUserIfNeededAsync((ParseUser)localObject);
      }
    });
  }
  
  public static <T extends ParseObject> j<Void> pinAllInBackground(List<T> paramList)
  {
    return pinAllInBackground("_default", paramList);
  }
  
  public static <T extends ParseObject> void pinAllInBackground(String paramString, List<T> paramList, SaveCallback paramSaveCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(pinAllInBackground(paramString, paramList), paramSaveCallback);
  }
  
  public static <T extends ParseObject> void pinAllInBackground(List<T> paramList, SaveCallback paramSaveCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(pinAllInBackground("_default", paramList), paramSaveCallback);
  }
  
  private void rebuildEstimatedData()
  {
    synchronized (this.mutex)
    {
      this.estimatedData.clear();
      Iterator localIterator1 = this.state.keySet().iterator();
      if (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        this.estimatedData.put(str, this.state.get(str));
      }
    }
    Iterator localIterator2 = this.operationSetQueue.iterator();
    while (localIterator2.hasNext()) {
      applyOperations((ParseOperationSet)localIterator2.next(), this.estimatedData);
    }
  }
  
  static void registerParseSubclasses()
  {
    registerSubclass(ParseUser.class);
    registerSubclass(ParseRole.class);
    registerSubclass(ParseInstallation.class);
    registerSubclass(ParseSession.class);
    registerSubclass(ParsePin.class);
    registerSubclass(EventuallyPin.class);
  }
  
  public static void registerSubclass(Class<? extends ParseObject> paramClass)
  {
    getSubclassingController().registerSubclass(paramClass);
  }
  
  public static <T extends ParseObject> void saveAll(List<T> paramList)
  {
    ParseTaskUtils.wait(saveAllInBackground(paramList));
  }
  
  private static <T extends ParseObject> j<Void> saveAllAsync(List<T> paramList, final String paramString, j<Void> paramj)
  {
    paramj.b(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        int j = this.val$uniqueObjects.size();
        Object localObject = new ArrayList(j);
        paramAnonymousj = new ArrayList(j);
        ArrayList localArrayList = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          ParseObject localParseObject = (ParseObject)this.val$uniqueObjects.get(i);
          localParseObject.updateBeforeSave();
          localParseObject.validateSave();
          ((List)localObject).add(localParseObject.getState());
          paramAnonymousj.add(localParseObject.startSave());
          localArrayList.add(new KnownParseObjectDecoder(localParseObject.collectFetchedObjects()));
          i += 1;
        }
        localObject = ParseObject.access$800().saveAllAsync((List)localObject, paramAnonymousj, paramString, localArrayList);
        localArrayList = new ArrayList(j);
        i = 0;
        while (i < j)
        {
          localArrayList.add(((j)((List)localObject).get(i)).b(new h()
          {
            public j<Void> then(final j<ParseObject.State> paramAnonymous2j)
            {
              ParseObject.State localState = (ParseObject.State)paramAnonymous2j.f();
              this.val$object.handleSaveResultAsync(localState, this.val$operations).b(new h()
              {
                public j<Void> then(j<Void> paramAnonymous3j)
                {
                  if ((paramAnonymous3j.e()) || (paramAnonymous3j.d())) {
                    return paramAnonymous3j;
                  }
                  return paramAnonymous2j.k();
                }
              });
            }
          }));
          i += 1;
        }
        return j.a(localArrayList);
      }
    });
  }
  
  public static <T extends ParseObject> j<Void> saveAllInBackground(List<T> paramList)
  {
    ParseUser.getCurrentUserAsync().d(new h()
    {
      public j<String> then(j<ParseUser> paramAnonymousj)
      {
        paramAnonymousj = (ParseUser)paramAnonymousj.f();
        if (paramAnonymousj == null) {
          return j.a(null);
        }
        if (!paramAnonymousj.isLazy()) {
          return j.a(paramAnonymousj.getSessionToken());
        }
        paramAnonymousj = this.val$objects.iterator();
        while (paramAnonymousj.hasNext())
        {
          final Object localObject = (ParseObject)paramAnonymousj.next();
          if (((ParseObject)localObject).isDataAvailable("ACL"))
          {
            localObject = ((ParseObject)localObject).getACL(false);
            if (localObject != null)
            {
              final ParseUser localParseUser = ((ParseACL)localObject).getUnresolvedUser();
              if ((localParseUser != null) && (localParseUser.isCurrentUser())) {
                localParseUser.saveAsync(null).c(new h()
                {
                  public String then(j<Void> paramAnonymous2j)
                  {
                    if (localObject.hasUnresolvedUser()) {
                      throw new IllegalStateException("ACL has an unresolved ParseUser. Save or sign up before attempting to serialize the ACL.");
                    }
                    return localParseUser.getSessionToken();
                  }
                });
              }
            }
          }
        }
        return j.a(null);
      }
    }).d(new h()
    {
      public j<Void> then(j<String> paramAnonymousj)
      {
        paramAnonymousj = (String)paramAnonymousj.f();
        return ParseObject.deepSaveAsync(this.val$objects, paramAnonymousj);
      }
    });
  }
  
  public static <T extends ParseObject> void saveAllInBackground(List<T> paramList, SaveCallback paramSaveCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(saveAllInBackground(paramList), paramSaveCallback);
  }
  
  private void setState(State paramState, boolean paramBoolean)
  {
    synchronized (this.mutex)
    {
      String str1 = this.state.objectId();
      String str2 = paramState.objectId();
      this.state = paramState;
      if ((paramBoolean) && (!ParseTextUtils.equals(str1, str2))) {
        notifyObjectIdChanged(str1, str2);
      }
      rebuildEstimatedData();
      return;
    }
  }
  
  public static void unpinAll()
  {
    ParseTaskUtils.wait(unpinAllInBackground());
  }
  
  public static void unpinAll(String paramString)
  {
    ParseTaskUtils.wait(unpinAllInBackground(paramString));
  }
  
  public static <T extends ParseObject> void unpinAll(String paramString, List<T> paramList)
  {
    ParseTaskUtils.wait(unpinAllInBackground(paramString, paramList));
  }
  
  public static <T extends ParseObject> void unpinAll(List<T> paramList)
  {
    ParseTaskUtils.wait(unpinAllInBackground("_default", paramList));
  }
  
  public static j<Void> unpinAllInBackground()
  {
    return unpinAllInBackground("_default");
  }
  
  public static j<Void> unpinAllInBackground(String paramString)
  {
    if (!Parse.isLocalDatastoreEnabled()) {
      throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
    }
    String str = paramString;
    if (paramString == null) {
      str = "_default";
    }
    return Parse.getLocalDatastore().unpinAllObjectsAsync(str);
  }
  
  public static <T extends ParseObject> j<Void> unpinAllInBackground(String paramString, List<T> paramList)
  {
    if (!Parse.isLocalDatastoreEnabled()) {
      throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
    }
    String str = paramString;
    if (paramString == null) {
      str = "_default";
    }
    return Parse.getLocalDatastore().unpinAllObjectsAsync(str, paramList);
  }
  
  public static <T extends ParseObject> j<Void> unpinAllInBackground(List<T> paramList)
  {
    return unpinAllInBackground("_default", paramList);
  }
  
  public static void unpinAllInBackground(DeleteCallback paramDeleteCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(unpinAllInBackground(), paramDeleteCallback);
  }
  
  public static void unpinAllInBackground(String paramString, DeleteCallback paramDeleteCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(unpinAllInBackground(paramString), paramDeleteCallback);
  }
  
  public static <T extends ParseObject> void unpinAllInBackground(String paramString, List<T> paramList, DeleteCallback paramDeleteCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(unpinAllInBackground(paramString, paramList), paramDeleteCallback);
  }
  
  public static <T extends ParseObject> void unpinAllInBackground(List<T> paramList, DeleteCallback paramDeleteCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(unpinAllInBackground("_default", paramList), paramDeleteCallback);
  }
  
  static void unregisterParseSubclasses()
  {
    unregisterSubclass(ParseUser.class);
    unregisterSubclass(ParseRole.class);
    unregisterSubclass(ParseInstallation.class);
    unregisterSubclass(ParseSession.class);
    unregisterSubclass(ParsePin.class);
    unregisterSubclass(EventuallyPin.class);
  }
  
  static void unregisterSubclass(Class<? extends ParseObject> paramClass)
  {
    getSubclassingController().unregisterSubclass(paramClass);
  }
  
  public void add(String paramString, Object paramObject)
  {
    addAll(paramString, Arrays.asList(new Object[] { paramObject }));
  }
  
  public void addAll(String paramString, Collection<?> paramCollection)
  {
    performOperation(paramString, new ParseAddOperation(paramCollection));
  }
  
  public void addAllUnique(String paramString, Collection<?> paramCollection)
  {
    performOperation(paramString, new ParseAddUniqueOperation(paramCollection));
  }
  
  public void addUnique(String paramString, Object paramObject)
  {
    addAllUnique(paramString, Arrays.asList(new Object[] { paramObject }));
  }
  
  void build(JSONObject paramJSONObject, ParseDecoder paramParseDecoder)
  {
    ParseObject.State.Builder localBuilder;
    for (;;)
    {
      String str;
      try
      {
        localBuilder = (ParseObject.State.Builder)new ParseObject.State.Builder(this.state).isComplete(true);
        localBuilder.clear();
        Iterator localIterator = paramJSONObject.keys();
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
        if (str.equals("className")) {
          continue;
        }
        if (str.equals("objectId"))
        {
          localBuilder.objectId(paramJSONObject.getString(str));
          continue;
        }
        if (!str.equals("createdAt")) {
          break label126;
        }
      }
      catch (JSONException paramJSONObject)
      {
        throw new RuntimeException(paramJSONObject);
      }
      localBuilder.createdAt(ParseDateFormat.getInstance().parse(paramJSONObject.getString(str)));
      continue;
      label126:
      if (str.equals("updatedAt"))
      {
        localBuilder.updatedAt(ParseDateFormat.getInstance().parse(paramJSONObject.getString(str)));
      }
      else
      {
        Object localObject = paramParseDecoder.decode(paramJSONObject.get(str));
        if ((localObject instanceof ParseFieldOperation)) {
          performOperation(str, (ParseFieldOperation)localObject);
        } else {
          put(str, localObject);
        }
      }
    }
    setState(localBuilder.build());
  }
  
  public boolean containsKey(String paramString)
  {
    synchronized (this.mutex)
    {
      boolean bool = this.estimatedData.containsKey(paramString);
      return bool;
    }
  }
  
  void copyChangesFrom(ParseObject paramParseObject)
  {
    synchronized (this.mutex)
    {
      paramParseObject = (ParseOperationSet)paramParseObject.operationSetQueue.getFirst();
      Iterator localIterator = paramParseObject.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        performOperation(str, (ParseFieldOperation)paramParseObject.get(str));
      }
    }
  }
  
  public final void delete()
  {
    ParseTaskUtils.wait(deleteInBackground());
  }
  
  j<Void> deleteAsync(String paramString)
  {
    return getObjectController().deleteAsync(getState(), paramString);
  }
  
  public final j<Void> deleteEventually()
  {
    synchronized (this.mutex)
    {
      validateDelete();
      this.isDeletingEventually += 1;
      Object localObject1 = null;
      if (getObjectId() == null) {
        localObject1 = getOrCreateLocalId();
      }
      Object localObject4 = ParseUser.getCurrentSessionToken();
      localObject4 = ParseRESTObjectCommand.deleteObjectCommand(getState(), (String)localObject4);
      ((ParseRESTCommand)localObject4).enableRetrying();
      ((ParseRESTCommand)localObject4).setLocalId((String)localObject1);
      localObject1 = Parse.getEventuallyQueue().enqueueEventuallyAsync((ParseRESTCommand)localObject4, this);
      if (Parse.isLocalDatastoreEnabled()) {
        return ((j)localObject1).k();
      }
    }
    ((j)localObject2).d(new h()
    {
      public j<Void> then(j<JSONObject> paramAnonymousj)
      {
        return ParseObject.this.handleDeleteEventuallyResultAsync();
      }
    });
  }
  
  public final void deleteEventually(DeleteCallback paramDeleteCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(deleteEventually(), paramDeleteCallback);
  }
  
  public final j<Void> deleteInBackground()
  {
    ParseUser.getCurrentSessionTokenAsync().d(new h()
    {
      public j<Void> then(final j<String> paramAnonymousj)
      {
        paramAnonymousj = (String)paramAnonymousj.f();
        ParseObject.this.taskQueue.enqueue(new h()
        {
          public j<Void> then(j<Void> paramAnonymous2j)
          {
            return ParseObject.this.deleteAsync(paramAnonymousj, paramAnonymous2j);
          }
        });
      }
    });
  }
  
  public final void deleteInBackground(DeleteCallback paramDeleteCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(deleteInBackground(), paramDeleteCallback);
  }
  
  public <T extends ParseObject> T fetch()
  {
    return (ParseObject)ParseTaskUtils.wait(fetchInBackground());
  }
  
  <T extends ParseObject> j<T> fetchAsync(final String paramString, j<Void> paramj)
  {
    paramj.d(new h()
    {
      public j<ParseObject.State> then(j<Void> arg1)
      {
        synchronized (ParseObject.this.mutex)
        {
          ParseObject.State localState = ParseObject.this.getState();
          Map localMap = ParseObject.this.collectFetchedObjects();
          ??? = new KnownParseObjectDecoder(localMap);
          return ParseObject.access$800().fetchAsync(localState, paramString, ???);
        }
      }
    }).d(new h()
    {
      public j<Void> then(j<ParseObject.State> paramAnonymousj)
      {
        paramAnonymousj = (ParseObject.State)paramAnonymousj.f();
        return ParseObject.this.handleFetchResultAsync(paramAnonymousj);
      }
    }).c(new h()
    {
      public T then(j<Void> paramAnonymousj)
      {
        return ParseObject.this;
      }
    });
  }
  
  public void fetchFromLocalDatastore()
  {
    ParseTaskUtils.wait(fetchFromLocalDatastoreAsync());
  }
  
  <T extends ParseObject> j<T> fetchFromLocalDatastoreAsync()
  {
    if (!Parse.isLocalDatastoreEnabled()) {
      throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
    }
    return Parse.getLocalDatastore().fetchLocallyAsync(this);
  }
  
  public <T extends ParseObject> void fetchFromLocalDatastoreInBackground(GetCallback<T> paramGetCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(fetchFromLocalDatastoreAsync(), paramGetCallback);
  }
  
  public <T extends ParseObject> T fetchIfNeeded()
  {
    return (ParseObject)ParseTaskUtils.wait(fetchIfNeededInBackground());
  }
  
  public final <T extends ParseObject> j<T> fetchIfNeededInBackground()
  {
    if (isDataAvailable()) {
      return j.a(this);
    }
    ParseUser.getCurrentSessionTokenAsync().d(new h()
    {
      public j<T> then(final j<String> paramAnonymousj)
      {
        paramAnonymousj = (String)paramAnonymousj.f();
        ParseObject.this.taskQueue.enqueue(new h()
        {
          public j<T> then(j<Void> paramAnonymous2j)
          {
            if (ParseObject.this.isDataAvailable()) {
              return j.a(ParseObject.this);
            }
            return ParseObject.this.fetchAsync(paramAnonymousj, paramAnonymous2j);
          }
        });
      }
    });
  }
  
  public final <T extends ParseObject> void fetchIfNeededInBackground(GetCallback<T> paramGetCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(fetchIfNeededInBackground(), paramGetCallback);
  }
  
  public final <T extends ParseObject> j<T> fetchInBackground()
  {
    ParseUser.getCurrentSessionTokenAsync().d(new h()
    {
      public j<T> then(final j<String> paramAnonymousj)
      {
        paramAnonymousj = (String)paramAnonymousj.f();
        ParseObject.this.taskQueue.enqueue(new h()
        {
          public j<T> then(j<Void> paramAnonymous2j)
          {
            return ParseObject.this.fetchAsync(paramAnonymousj, paramAnonymous2j);
          }
        });
      }
    });
  }
  
  public final <T extends ParseObject> void fetchInBackground(GetCallback<T> paramGetCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(fetchInBackground(), paramGetCallback);
  }
  
  public Object get(String paramString)
  {
    synchronized (this.mutex)
    {
      if (paramString.equals("ACL"))
      {
        paramString = getACL();
        return paramString;
      }
      checkGetAccess(paramString);
      Object localObject2 = this.estimatedData.get(paramString);
      if ((localObject2 instanceof ParseRelation)) {
        ((ParseRelation)localObject2).ensureParentAndKey(this, paramString);
      }
      return localObject2;
    }
  }
  
  public ParseACL getACL()
  {
    return getACL(true);
  }
  
  public boolean getBoolean(String paramString)
  {
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      paramString = this.estimatedData.get(paramString);
      if (!(paramString instanceof Boolean)) {
        return false;
      }
      boolean bool = ((Boolean)paramString).booleanValue();
      return bool;
    }
  }
  
  public byte[] getBytes(String paramString)
  {
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      paramString = this.estimatedData.get(paramString);
      if (!(paramString instanceof byte[])) {
        return null;
      }
      paramString = (byte[])paramString;
      return paramString;
    }
  }
  
  public String getClassName()
  {
    synchronized (this.mutex)
    {
      String str = this.state.className();
      return str;
    }
  }
  
  public Date getCreatedAt()
  {
    long l = getState().createdAt();
    if (l > 0L) {
      return new Date(l);
    }
    return null;
  }
  
  public Date getDate(String paramString)
  {
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      paramString = this.estimatedData.get(paramString);
      if (!(paramString instanceof Date)) {
        return null;
      }
      paramString = (Date)paramString;
      return paramString;
    }
  }
  
  public double getDouble(String paramString)
  {
    paramString = getNumber(paramString);
    if (paramString == null) {
      return 0.0D;
    }
    return paramString.doubleValue();
  }
  
  public int getInt(String paramString)
  {
    paramString = getNumber(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  public JSONArray getJSONArray(String paramString)
  {
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      Object localObject1 = this.estimatedData.get(paramString);
      paramString = (String)localObject1;
      if ((localObject1 instanceof List)) {
        paramString = PointerOrLocalIdEncoder.get().encode(localObject1);
      }
      if (!(paramString instanceof JSONArray)) {
        return null;
      }
      paramString = (JSONArray)paramString;
      return paramString;
    }
  }
  
  public JSONObject getJSONObject(String paramString)
  {
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      Object localObject1 = this.estimatedData.get(paramString);
      paramString = (String)localObject1;
      if ((localObject1 instanceof Map)) {
        paramString = PointerOrLocalIdEncoder.get().encode(localObject1);
      }
      if (!(paramString instanceof JSONObject)) {
        return null;
      }
      paramString = (JSONObject)paramString;
      return paramString;
    }
  }
  
  public <T> List<T> getList(String paramString)
  {
    synchronized (this.mutex)
    {
      paramString = this.estimatedData.get(paramString);
      if (!(paramString instanceof List)) {
        return null;
      }
      paramString = (List)paramString;
      return paramString;
    }
  }
  
  public long getLong(String paramString)
  {
    paramString = getNumber(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.longValue();
  }
  
  public <V> Map<String, V> getMap(String paramString)
  {
    synchronized (this.mutex)
    {
      paramString = this.estimatedData.get(paramString);
      if (!(paramString instanceof Map)) {
        return null;
      }
      paramString = (Map)paramString;
      return paramString;
    }
  }
  
  public Number getNumber(String paramString)
  {
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      paramString = this.estimatedData.get(paramString);
      if (!(paramString instanceof Number)) {
        return null;
      }
      paramString = (Number)paramString;
      return paramString;
    }
  }
  
  public String getObjectId()
  {
    synchronized (this.mutex)
    {
      String str = this.state.objectId();
      return str;
    }
  }
  
  String getOrCreateLocalId()
  {
    synchronized (this.mutex)
    {
      if (this.localId != null) {
        break label50;
      }
      if (this.state.objectId() != null) {
        throw new IllegalStateException("Attempted to get a localId for an object with an objectId.");
      }
    }
    this.localId = getLocalIdManager().createLocalId();
    label50:
    String str = this.localId;
    return str;
  }
  
  public ParseFile getParseFile(String paramString)
  {
    paramString = get(paramString);
    if (!(paramString instanceof ParseFile)) {
      return null;
    }
    return (ParseFile)paramString;
  }
  
  public ParseGeoPoint getParseGeoPoint(String paramString)
  {
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      paramString = this.estimatedData.get(paramString);
      if (!(paramString instanceof ParseGeoPoint)) {
        return null;
      }
      paramString = (ParseGeoPoint)paramString;
      return paramString;
    }
  }
  
  public ParseObject getParseObject(String paramString)
  {
    paramString = get(paramString);
    if (!(paramString instanceof ParseObject)) {
      return null;
    }
    return (ParseObject)paramString;
  }
  
  public ParseUser getParseUser(String paramString)
  {
    paramString = get(paramString);
    if (!(paramString instanceof ParseUser)) {
      return null;
    }
    return (ParseUser)paramString;
  }
  
  public <T extends ParseObject> ParseRelation<T> getRelation(String paramString)
  {
    synchronized (this.mutex)
    {
      Object localObject2 = this.estimatedData.get(paramString);
      if ((localObject2 instanceof ParseRelation))
      {
        localObject2 = (ParseRelation)localObject2;
        ((ParseRelation)localObject2).ensureParentAndKey(this, paramString);
        return (ParseRelation<T>)localObject2;
      }
      localObject2 = new ParseRelation(this, paramString);
      this.estimatedData.put(paramString, localObject2);
      return (ParseRelation<T>)localObject2;
    }
  }
  
  State getState()
  {
    synchronized (this.mutex)
    {
      State localState = this.state;
      return localState;
    }
  }
  
  public String getString(String paramString)
  {
    synchronized (this.mutex)
    {
      checkGetAccess(paramString);
      paramString = this.estimatedData.get(paramString);
      if (!(paramString instanceof String)) {
        return null;
      }
      paramString = (String)paramString;
      return paramString;
    }
  }
  
  public Date getUpdatedAt()
  {
    long l = getState().updatedAt();
    if (l > 0L) {
      return new Date(l);
    }
    return null;
  }
  
  j<Void> handleDeleteEventuallyResultAsync()
  {
    synchronized (this.mutex)
    {
      this.isDeletingEventually -= 1;
      handleDeleteResultAsync().d(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          Parse.getEventuallyQueue().notifyTestHelper(6);
          return paramAnonymousj;
        }
      });
    }
  }
  
  j<Void> handleDeleteResultAsync()
  {
    j localj = j.a(null);
    synchronized (this.mutex)
    {
      this.isDeleted = true;
      final OfflineStore localOfflineStore = Parse.getLocalDatastore();
      ??? = localj;
      if (localOfflineStore != null) {
        ??? = localj.b(new h()
        {
          public j<Void> then(j<Void> arg1)
          {
            synchronized (ParseObject.this.mutex)
            {
              if (ParseObject.this.isDeleted)
              {
                localOfflineStore.unregisterObject(ParseObject.this);
                localj = localOfflineStore.deleteDataForObjectAsync(ParseObject.this);
                return localj;
              }
              j localj = localOfflineStore.updateDataForObjectAsync(ParseObject.this);
              return localj;
            }
          }
        });
      }
      return (j<Void>)???;
    }
  }
  
  j<Void> handleFetchResultAsync(final State paramState)
  {
    j localj2 = j.a((Void)null);
    final OfflineStore localOfflineStore = Parse.getLocalDatastore();
    j localj1 = localj2;
    if (localOfflineStore != null) {
      localj1 = localj2.d(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          return localOfflineStore.fetchLocallyAsync(ParseObject.this).k();
        }
      }).b(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          j<Void> localj = paramAnonymousj;
          if ((paramAnonymousj.g() instanceof ParseException))
          {
            localj = paramAnonymousj;
            if (((ParseException)paramAnonymousj.g()).getCode() == 120) {
              localj = null;
            }
          }
          return localj;
        }
      });
    }
    localj1 = localj1.d(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        synchronized (ParseObject.this.mutex)
        {
          if (paramState.isComplete())
          {
            paramAnonymousj = paramState;
            ParseObject.this.setState(paramAnonymousj);
            return null;
          }
          paramAnonymousj = ParseObject.this.getState().newBuilder().apply(paramState).build();
        }
      }
    });
    paramState = localj1;
    if (localOfflineStore != null) {
      paramState = localj1.d(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          return localOfflineStore.updateDataForObjectAsync(ParseObject.this);
        }
      }).b(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          j<Void> localj = paramAnonymousj;
          if ((paramAnonymousj.g() instanceof ParseException))
          {
            localj = paramAnonymousj;
            if (((ParseException)paramAnonymousj.g()).getCode() == 120) {
              localj = null;
            }
          }
          return localj;
        }
      });
    }
    return paramState;
  }
  
  j<Void> handleSaveEventuallyResultAsync(JSONObject paramJSONObject, ParseOperationSet paramParseOperationSet)
  {
    if (paramJSONObject != null) {}
    for (final boolean bool = true;; bool = false) {
      handleSaveResultAsync(paramJSONObject, paramParseOperationSet).d(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          if (bool) {
            Parse.getEventuallyQueue().notifyTestHelper(5);
          }
          return paramAnonymousj;
        }
      });
    }
  }
  
  j<Void> handleSaveResultAsync(final State paramState, final ParseOperationSet paramParseOperationSet)
  {
    j localj = j.a((Void)null);
    if (paramState != null) {}
    for (int i = 1;; i = 0) {
      for (;;)
      {
        synchronized (this.mutex)
        {
          ListIterator localListIterator = this.operationSetQueue.listIterator(this.operationSetQueue.indexOf(paramParseOperationSet));
          localListIterator.next();
          localListIterator.remove();
          if (i == 0)
          {
            ((ParseOperationSet)localListIterator.next()).mergeFrom(paramParseOperationSet);
            return localj;
          }
          ??? = Parse.getLocalDatastore();
          if (??? != null)
          {
            localj = localj.d(new h()
            {
              public j<Void> then(j<Void> paramAnonymousj)
              {
                return localObject.fetchLocallyAsync(ParseObject.this).k();
              }
            });
            paramParseOperationSet = localj.a(new h()
            {
              public Void then(j<Void> paramAnonymousj)
              {
                synchronized (ParseObject.this.mutex)
                {
                  if (paramState.isComplete())
                  {
                    paramAnonymousj = paramState;
                    ParseObject.this.setState(paramAnonymousj);
                    return null;
                  }
                  paramAnonymousj = ParseObject.this.getState().newBuilder().apply(paramParseOperationSet).apply(paramState).build();
                }
              }
            });
            paramState = paramParseOperationSet;
            if (??? != null) {
              paramState = paramParseOperationSet.d(new h()
              {
                public j<Void> then(j<Void> paramAnonymousj)
                {
                  return localObject.updateDataForObjectAsync(ParseObject.this);
                }
              });
            }
            paramState.c(new h()
            {
              public Void then(j<Void> paramAnonymousj)
              {
                ParseObject.this.saveEvent.invoke(ParseObject.this, null);
                return null;
              }
            });
          }
        }
      }
    }
  }
  
  j<Void> handleSaveResultAsync(JSONObject paramJSONObject, ParseOperationSet paramParseOperationSet)
  {
    Object localObject1 = null;
    if (paramJSONObject != null) {}
    synchronized (this.mutex)
    {
      localObject1 = new KnownParseObjectDecoder(collectFetchedObjects());
      localObject1 = ParseObjectCoder.get().decode(getState().newBuilder().clear(), paramJSONObject, (ParseDecoder)localObject1).isComplete(false).build();
      return handleSaveResultAsync((State)localObject1, paramParseOperationSet);
    }
  }
  
  public boolean has(String paramString)
  {
    return containsKey(paramString);
  }
  
  boolean hasChanges()
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        if (currentOperations().size() > 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  boolean hasOutstandingOperations()
  {
    for (boolean bool = true;; bool = false) {
      synchronized (this.mutex)
      {
        if (this.operationSetQueue.size() > 1) {
          return bool;
        }
      }
    }
  }
  
  public boolean hasSameId(ParseObject paramParseObject)
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        if ((getClassName() != null) && (getObjectId() != null) && (getClassName().equals(paramParseObject.getClassName())) && (getObjectId().equals(paramParseObject.getObjectId())))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void increment(String paramString)
  {
    increment(paramString, Integer.valueOf(1));
  }
  
  public void increment(String paramString, Number paramNumber)
  {
    performOperation(paramString, new ParseIncrementOperation(paramNumber));
  }
  
  public boolean isDataAvailable()
  {
    synchronized (this.mutex)
    {
      boolean bool = this.state.isComplete();
      return bool;
    }
  }
  
  boolean isDataAvailable(String paramString)
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        if (!isDataAvailable())
        {
          if (!this.estimatedData.containsKey(paramString)) {
            break label44;
          }
          break label39;
          return bool;
        }
      }
      label39:
      boolean bool = true;
      continue;
      label44:
      bool = false;
    }
  }
  
  public boolean isDirty()
  {
    return isDirty(true);
  }
  
  public boolean isDirty(String paramString)
  {
    synchronized (this.mutex)
    {
      boolean bool = currentOperations().containsKey(paramString);
      return bool;
    }
  }
  
  boolean isDirty(boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        if ((!this.isDeleted) && (getObjectId() != null) && (!hasChanges()))
        {
          if ((!paramBoolean) || (!hasDirtyChildren())) {
            break label56;
          }
          break label51;
          return paramBoolean;
        }
      }
      label51:
      paramBoolean = true;
      continue;
      label56:
      paramBoolean = false;
    }
  }
  
  boolean isKeyMutable(String paramString)
  {
    return true;
  }
  
  public Set<String> keySet()
  {
    synchronized (this.mutex)
    {
      Set localSet = Collections.unmodifiableSet(this.estimatedData.keySet());
      return localSet;
    }
  }
  
  /* Error */
  void mergeFromObject(ParseObject paramParseObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 215	com/parse/ParseObject:mutex	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_1
    //   9: if_acmpne +6 -> 15
    //   12: aload_2
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: aload_1
    //   17: invokevirtual 538	com/parse/ParseObject:getState	()Lcom/parse/ParseObject$State;
    //   20: invokevirtual 798	com/parse/ParseObject$State:newBuilder	()Lcom/parse/ParseObject$State$Init;
    //   23: invokevirtual 293	com/parse/ParseObject$State$Init:build	()Lcom/parse/ParseObject$State;
    //   26: iconst_0
    //   27: invokespecial 1310	com/parse/ParseObject:setState	(Lcom/parse/ParseObject$State;Z)V
    //   30: aload_2
    //   31: monitorexit
    //   32: return
    //   33: astore_1
    //   34: aload_2
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	ParseObject
    //   0	38	1	paramParseObject	ParseObject
    //   4	31	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	14	33	finally
    //   15	32	33	finally
    //   34	36	33	finally
  }
  
  State mergeFromServer(State paramState, JSONObject paramJSONObject, ParseDecoder paramParseDecoder, boolean paramBoolean)
  {
    for (;;)
    {
      ParseObject.State.Init localInit;
      try
      {
        localInit = paramState.newBuilder();
        if (paramBoolean) {
          localInit.clear();
        }
        if (paramState.isComplete()) {
          break label249;
        }
        if (!paramBoolean) {
          break label121;
        }
      }
      catch (JSONException paramState)
      {
        throw new RuntimeException(paramState);
      }
      localInit.isComplete(paramBoolean);
      paramState = paramJSONObject.keys();
      if (paramState.hasNext())
      {
        String str = (String)paramState.next();
        if ((!str.equals("__type")) && (!str.equals("className"))) {
          if (str.equals("objectId"))
          {
            localInit.objectId(paramJSONObject.getString(str));
            continue;
            label121:
            paramBoolean = false;
          }
          else if (str.equals("createdAt"))
          {
            localInit.createdAt(ParseDateFormat.getInstance().parse(paramJSONObject.getString(str)));
          }
          else if (str.equals("updatedAt"))
          {
            localInit.updatedAt(ParseDateFormat.getInstance().parse(paramJSONObject.getString(str)));
          }
          else if (str.equals("ACL"))
          {
            localInit.put("ACL", ParseACL.createACLFromJSONObject(paramJSONObject.getJSONObject(str), paramParseDecoder));
          }
          else
          {
            localInit.put(str, paramParseDecoder.decode(paramJSONObject.get(str)));
          }
        }
      }
      else
      {
        paramState = localInit.build();
        return paramState;
        label249:
        paramBoolean = true;
      }
    }
  }
  
  void mergeREST(State paramState, JSONObject paramJSONObject, ParseDecoder paramParseDecoder)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    Object localObject1;
    ParseOperationSet localParseOperationSet1;
    for (;;)
    {
      synchronized (this.mutex)
      {
        try
        {
          boolean bool = paramJSONObject.getBoolean("__complete");
          this.isDeletingEventually = ParseJSONUtils.getInt(paramJSONObject, Arrays.asList(new String[] { "__isDeletingEventually", "isDeletingEventually" }));
          JSONArray localJSONArray = paramJSONObject.getJSONArray("__operations");
          ParseOperationSet localParseOperationSet2 = currentOperations();
          this.operationSetQueue.clear();
          i = 0;
          localObject1 = null;
          if (i < localJSONArray.length())
          {
            localParseOperationSet1 = ParseOperationSet.fromRest(localJSONArray.getJSONObject(i), paramParseDecoder);
            if (localParseOperationSet1.isSaveEventually())
            {
              Object localObject2 = localObject1;
              if (localObject1 != null)
              {
                this.operationSetQueue.add(localObject1);
                localObject2 = null;
              }
              localArrayList.add(localParseOperationSet1);
              this.operationSetQueue.add(localParseOperationSet1);
              localObject1 = localObject2;
              break;
            }
            if (localObject1 == null) {
              break label374;
            }
            localParseOperationSet1.mergeFrom((ParseOperationSet)localObject1);
            break label374;
          }
          if (localObject1 != null) {
            this.operationSetQueue.add(localObject1);
          }
          currentOperations().mergeFrom(localParseOperationSet2);
          if (paramState.updatedAt() < 0L)
          {
            i = 1;
            if (i != 0) {
              setState(mergeFromServer(paramState, ParseJSONUtils.create(paramJSONObject, Arrays.asList(new String[] { "__complete", "__isDeletingEventually", "isDeletingEventually", "__operations" })), paramParseDecoder, bool));
            }
            paramState = localArrayList.iterator();
            if (paramState.hasNext())
            {
              enqueueSaveEventuallyOperationAsync((ParseOperationSet)paramState.next());
              continue;
            }
          }
          else
          {
            if (!paramJSONObject.has("updatedAt")) {
              break label359;
            }
            localObject1 = ParseDateFormat.getInstance().parse(paramJSONObject.getString("updatedAt"));
            i = new Date(paramState.updatedAt()).compareTo((Date)localObject1);
            if (i >= 0) {
              break label359;
            }
            i = 1;
            continue;
            paramState = finally;
          }
        }
        catch (JSONException paramState)
        {
          throw new RuntimeException(paramState);
        }
      }
      return;
      label359:
      i = 0;
    }
    for (;;)
    {
      i += 1;
      break;
      label374:
      localObject1 = localParseOperationSet1;
    }
  }
  
  boolean needsDefaultACL()
  {
    return true;
  }
  
  ParseObject.State.Init<?> newStateBuilder(String paramString)
  {
    return new ParseObject.State.Builder(paramString);
  }
  
  void performOperation(String paramString, ParseFieldOperation paramParseFieldOperation)
  {
    synchronized (this.mutex)
    {
      Object localObject2 = paramParseFieldOperation.apply(this.estimatedData.get(paramString), paramString);
      if (localObject2 != null)
      {
        this.estimatedData.put(paramString, localObject2);
        paramParseFieldOperation = paramParseFieldOperation.mergeWithPrevious((ParseFieldOperation)currentOperations().get(paramString));
        currentOperations().put(paramString, paramParseFieldOperation);
        return;
      }
      this.estimatedData.remove(paramString);
    }
  }
  
  void performPut(String paramString, Object paramObject)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("key may not be null.");
    }
    if (paramObject == null) {
      throw new IllegalArgumentException("value may not be null.");
    }
    Object localObject;
    if ((paramObject instanceof JSONObject)) {
      localObject = ParseDecoder.get().convertJSONObjectToMap((JSONObject)paramObject);
    }
    while (!ParseEncoder.isValidType(localObject))
    {
      throw new IllegalArgumentException("invalid type for value: " + localObject.getClass().toString());
      localObject = paramObject;
      if ((paramObject instanceof JSONArray)) {
        localObject = ParseDecoder.get().convertJSONArrayToList((JSONArray)paramObject);
      }
    }
    performOperation(paramString, new ParseSetOperation(localObject));
  }
  
  void performRemove(String paramString)
  {
    synchronized (this.mutex)
    {
      if (get(paramString) != null) {
        performOperation(paramString, ParseDeleteOperation.getInstance());
      }
      return;
    }
  }
  
  public void pin()
  {
    ParseTaskUtils.wait(pinInBackground());
  }
  
  public void pin(String paramString)
  {
    ParseTaskUtils.wait(pinInBackground(paramString));
  }
  
  public j<Void> pinInBackground()
  {
    return pinAllInBackground("_default", Arrays.asList(new ParseObject[] { this }));
  }
  
  public j<Void> pinInBackground(String paramString)
  {
    return pinAllInBackground(paramString, Collections.singletonList(this));
  }
  
  j<Void> pinInBackground(String paramString, boolean paramBoolean)
  {
    return pinAllInBackground(paramString, Collections.singletonList(this), paramBoolean);
  }
  
  public void pinInBackground(SaveCallback paramSaveCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(pinInBackground(), paramSaveCallback);
  }
  
  public void pinInBackground(String paramString, SaveCallback paramSaveCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(pinInBackground(paramString), paramSaveCallback);
  }
  
  public void put(String paramString, Object paramObject)
  {
    checkKeyIsMutable(paramString);
    performPut(paramString, paramObject);
  }
  
  @Deprecated
  public final void refresh()
  {
    fetch();
  }
  
  @Deprecated
  public final void refreshInBackground(RefreshCallback paramRefreshCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(fetchInBackground(), paramRefreshCallback);
  }
  
  void registerSaveListener(GetCallback<ParseObject> paramGetCallback)
  {
    synchronized (this.mutex)
    {
      this.saveEvent.subscribe(paramGetCallback);
      return;
    }
  }
  
  public void remove(String paramString)
  {
    checkKeyIsMutable(paramString);
    performRemove(paramString);
  }
  
  public void removeAll(String paramString, Collection<?> paramCollection)
  {
    checkKeyIsMutable(paramString);
    performOperation(paramString, new ParseRemoveOperation(paramCollection));
  }
  
  public void revert()
  {
    synchronized (this.mutex)
    {
      if (isDirty())
      {
        currentOperations().clear();
        rebuildEstimatedData();
      }
      return;
    }
  }
  
  public void revert(String paramString)
  {
    synchronized (this.mutex)
    {
      if (isDirty(paramString))
      {
        currentOperations().remove(paramString);
        rebuildEstimatedData();
      }
      return;
    }
  }
  
  public final void save()
  {
    ParseTaskUtils.wait(saveInBackground());
  }
  
  j<JSONObject> saveAsync(ParseHttpClient paramParseHttpClient, ParseOperationSet paramParseOperationSet, String paramString)
  {
    return currentSaveEventuallyCommand(paramParseOperationSet, PointerEncoder.get(), paramString).executeAsync(paramParseHttpClient);
  }
  
  j<Void> saveAsync(final String paramString)
  {
    this.taskQueue.enqueue(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        return ParseObject.this.saveAsync(paramString, paramAnonymousj);
      }
    });
  }
  
  j<Void> saveAsync(final String paramString, j<Void> paramj)
  {
    if (!isDirty()) {
      return j.a(null);
    }
    final ParseOperationSet localParseOperationSet;
    synchronized (this.mutex)
    {
      updateBeforeSave();
      validateSave();
      localParseOperationSet = startSave();
    }
    synchronized (this.mutex)
    {
      j localj = deepSaveAsync(this.estimatedData, paramString);
      localj.d(TaskQueue.waitFor(paramj)).d(new h()
      {
        public j<ParseObject.State> then(j<Void> paramAnonymousj)
        {
          paramAnonymousj = new KnownParseObjectDecoder(ParseObject.this.collectFetchedObjects());
          return ParseObject.access$800().saveAsync(ParseObject.this.getState(), localParseOperationSet, paramString, paramAnonymousj);
        }
      }).b(new h()
      {
        public j<Void> then(final j<ParseObject.State> paramAnonymousj)
        {
          ParseObject.State localState = (ParseObject.State)paramAnonymousj.f();
          ParseObject.this.handleSaveResultAsync(localState, localParseOperationSet).b(new h()
          {
            public j<Void> then(j<Void> paramAnonymous2j)
            {
              if ((paramAnonymous2j.e()) || (paramAnonymous2j.d())) {
                return paramAnonymous2j;
              }
              return paramAnonymousj.k();
            }
          });
        }
      });
      paramString = finally;
      throw paramString;
    }
  }
  
  public final j<Void> saveEventually()
  {
    Object localObject1 = null;
    if (!isDirty())
    {
      Parse.getEventuallyQueue().fakeObjectUpdate();
      return j.a(null);
    }
    synchronized (this.mutex)
    {
      updateBeforeSave();
    }
    final ParseOperationSet localParseOperationSet;
    Object localObject4;
    try
    {
      validateSaveEventually();
      ArrayList localArrayList = new ArrayList();
      collectDirtyChildren(this.estimatedData, localArrayList, null);
      if (getObjectId() == null) {
        localObject1 = getOrCreateLocalId();
      }
      localParseOperationSet = startSave();
      localParseOperationSet.setIsSaveEventually(true);
      localObject4 = ParseUser.getCurrentSessionToken();
      try
      {
        localObject4 = currentSaveEventuallyCommand(localParseOperationSet, PointerOrLocalIdEncoder.get(), (String)localObject4);
        ((ParseRESTCommand)localObject4).setLocalId((String)localObject1);
        ((ParseRESTCommand)localObject4).setOperationSetUUID(localParseOperationSet.getUUID());
        ((ParseRESTCommand)localObject4).retainLocalIds();
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((ParseObject)((Iterator)localObject1).next()).saveEventually();
        }
        localObject2 = finally;
      }
      catch (ParseException localParseException1)
      {
        throw new IllegalStateException("Unable to saveEventually.", localParseException1);
      }
      throw ((Throwable)localObject2);
    }
    catch (ParseException localParseException2)
    {
      localj = j.a(localParseException2);
      return localj;
    }
    j localj = Parse.getEventuallyQueue().enqueueEventuallyAsync((ParseRESTCommand)localObject4, this);
    enqueueSaveEventuallyOperationAsync(localParseOperationSet);
    ((ParseRESTCommand)localObject4).releaseLocalIds();
    if (Parse.isLocalDatastoreEnabled()) {
      return localj.k();
    }
    localj.d(new h()
    {
      public j<Void> then(j<JSONObject> paramAnonymousj)
      {
        paramAnonymousj = (JSONObject)paramAnonymousj.f();
        return ParseObject.this.handleSaveEventuallyResultAsync(paramAnonymousj, localParseOperationSet);
      }
    });
  }
  
  public final void saveEventually(SaveCallback paramSaveCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(saveEventually(), paramSaveCallback);
  }
  
  public final j<Void> saveInBackground()
  {
    ParseUser.getCurrentUserAsync().d(new h()
    {
      public j<String> then(final j<ParseUser> paramAnonymousj)
      {
        paramAnonymousj = (ParseUser)paramAnonymousj.f();
        if (paramAnonymousj == null) {
          return j.a(null);
        }
        if (!paramAnonymousj.isLazy()) {
          return j.a(paramAnonymousj.getSessionToken());
        }
        if (!ParseObject.this.isDataAvailable("ACL")) {
          return j.a(null);
        }
        paramAnonymousj = ParseObject.this.getACL(false);
        if (paramAnonymousj == null) {
          return j.a(null);
        }
        final ParseUser localParseUser = paramAnonymousj.getUnresolvedUser();
        if ((localParseUser == null) || (!localParseUser.isCurrentUser())) {
          return j.a(null);
        }
        localParseUser.saveAsync(null).c(new h()
        {
          public String then(j<Void> paramAnonymous2j)
          {
            if (paramAnonymousj.hasUnresolvedUser()) {
              throw new IllegalStateException("ACL has an unresolved ParseUser. Save or sign up before attempting to serialize the ACL.");
            }
            return localParseUser.getSessionToken();
          }
        });
      }
    }).d(new h()
    {
      public j<Void> then(j<String> paramAnonymousj)
      {
        paramAnonymousj = (String)paramAnonymousj.f();
        return ParseObject.this.saveAsync(paramAnonymousj);
      }
    });
  }
  
  public final void saveInBackground(SaveCallback paramSaveCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(saveInBackground(), paramSaveCallback);
  }
  
  public void setACL(ParseACL paramParseACL)
  {
    put("ACL", paramParseACL);
  }
  
  void setDefaultValues()
  {
    if ((needsDefaultACL()) && (ParseACL.getDefaultACL() != null)) {
      setACL(ParseACL.getDefaultACL());
    }
  }
  
  public void setObjectId(String paramString)
  {
    synchronized (this.mutex)
    {
      String str = this.state.objectId();
      if (ParseTextUtils.equals(str, paramString)) {
        return;
      }
      this.state = this.state.newBuilder().objectId(paramString).build();
      notifyObjectIdChanged(str, paramString);
      return;
    }
  }
  
  void setState(State paramState)
  {
    synchronized (this.mutex)
    {
      setState(paramState, true);
      return;
    }
  }
  
  ParseOperationSet startSave()
  {
    synchronized (this.mutex)
    {
      ParseOperationSet localParseOperationSet = currentOperations();
      this.operationSetQueue.addLast(new ParseOperationSet());
      return localParseOperationSet;
    }
  }
  
  <T extends State> JSONObject toJSONObjectForSaving(T paramT, ParseOperationSet paramParseOperationSet, ParseEncoder paramParseEncoder)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Iterator localIterator = paramParseOperationSet.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramParseEncoder.encode((ParseFieldOperation)paramParseOperationSet.get(str)));
      }
      if (paramT.objectId() == null) {
        break label97;
      }
    }
    catch (JSONException paramT)
    {
      throw new RuntimeException("could not serialize object to JSON");
    }
    localJSONObject.put("objectId", paramT.objectId());
    label97:
    return localJSONObject;
  }
  
  JSONObject toRest(ParseEncoder paramParseEncoder)
  {
    synchronized (this.mutex)
    {
      State localState = getState();
      int j = this.operationSetQueue.size();
      ArrayList localArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        localArrayList.add(new ParseOperationSet((ParseOperationSet)this.operationSetQueue.get(i)));
        i += 1;
      }
      return toRest(localState, localArrayList, paramParseEncoder);
    }
  }
  
  JSONObject toRest(State paramState, List<ParseOperationSet> paramList, ParseEncoder paramParseEncoder)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("className", paramState.className());
      if (paramState.objectId() != null) {
        localJSONObject.put("objectId", paramState.objectId());
      }
      if (paramState.createdAt() > 0L) {
        localJSONObject.put("createdAt", ParseDateFormat.getInstance().format(new Date(paramState.createdAt())));
      }
      if (paramState.updatedAt() > 0L) {
        localJSONObject.put("updatedAt", ParseDateFormat.getInstance().format(new Date(paramState.updatedAt())));
      }
      Iterator localIterator = paramState.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramParseEncoder.encode(paramState.get(str)));
      }
      localJSONObject.put("__complete", paramState.isComplete());
    }
    catch (JSONException paramState)
    {
      throw new RuntimeException("could not serialize object to JSON");
    }
    localJSONObject.put("__isDeletingEventually", this.isDeletingEventually);
    paramState = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramState.put(((ParseOperationSet)paramList.next()).toRest(paramParseEncoder));
    }
    localJSONObject.put("__operations", paramState);
    return localJSONObject;
  }
  
  public void unpin()
  {
    ParseTaskUtils.wait(unpinInBackground());
  }
  
  public void unpin(String paramString)
  {
    ParseTaskUtils.wait(unpinInBackground(paramString));
  }
  
  public j<Void> unpinInBackground()
  {
    return unpinAllInBackground("_default", Arrays.asList(new ParseObject[] { this }));
  }
  
  public j<Void> unpinInBackground(String paramString)
  {
    return unpinAllInBackground(paramString, Arrays.asList(new ParseObject[] { this }));
  }
  
  public void unpinInBackground(DeleteCallback paramDeleteCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(unpinInBackground(), paramDeleteCallback);
  }
  
  public void unpinInBackground(String paramString, DeleteCallback paramDeleteCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(unpinInBackground(paramString), paramDeleteCallback);
  }
  
  void unregisterSaveListener(GetCallback<ParseObject> paramGetCallback)
  {
    synchronized (this.mutex)
    {
      this.saveEvent.unsubscribe(paramGetCallback);
      return;
    }
  }
  
  void updateBeforeSave() {}
  
  void validateDelete() {}
  
  void validateSave() {}
  
  void validateSaveEventually() {}
  
  static class State
  {
    private final String className;
    private final long createdAt;
    private final boolean isComplete;
    private final String objectId;
    private final Map<String, Object> serverData;
    private final long updatedAt;
    
    State(Init<?> paramInit)
    {
      this.className = paramInit.className;
      this.objectId = paramInit.objectId;
      this.createdAt = paramInit.createdAt;
      if (paramInit.updatedAt > 0L) {}
      for (long l = paramInit.updatedAt;; l = this.createdAt)
      {
        this.updatedAt = l;
        this.serverData = Collections.unmodifiableMap(new HashMap(paramInit.serverData));
        this.isComplete = paramInit.isComplete;
        return;
      }
    }
    
    public static Init<?> newBuilder(String paramString)
    {
      if ("_User".equals(paramString)) {
        return new ParseUser.State.Builder();
      }
      return new Builder(paramString);
    }
    
    public String className()
    {
      return this.className;
    }
    
    public long createdAt()
    {
      return this.createdAt;
    }
    
    public Object get(String paramString)
    {
      return this.serverData.get(paramString);
    }
    
    public boolean isComplete()
    {
      return this.isComplete;
    }
    
    public Set<String> keySet()
    {
      return this.serverData.keySet();
    }
    
    public <T extends Init<?>> T newBuilder()
    {
      return new Builder(this);
    }
    
    public String objectId()
    {
      return this.objectId;
    }
    
    public String toString()
    {
      return String.format(Locale.US, "%s@%s[className=%s, objectId=%s, createdAt=%d, updatedAt=%d, isComplete=%s, serverData=%s]", new Object[] { getClass().getName(), Integer.toHexString(hashCode()), this.className, this.objectId, Long.valueOf(this.createdAt), Long.valueOf(this.updatedAt), Boolean.valueOf(this.isComplete), this.serverData });
    }
    
    public long updatedAt()
    {
      return this.updatedAt;
    }
    
    static class Builder
      extends ParseObject.State.Init<Builder>
    {
      public Builder(ParseObject.State paramState)
      {
        super();
      }
      
      public Builder(String paramString)
      {
        super();
      }
      
      public ParseObject.State build()
      {
        return new ParseObject.State(this);
      }
      
      Builder self()
      {
        return this;
      }
    }
    
    static abstract class Init<T extends Init>
    {
      private final String className;
      private long createdAt = -1L;
      private boolean isComplete;
      private String objectId;
      Map<String, Object> serverData = new HashMap();
      private long updatedAt = -1L;
      
      Init(ParseObject.State paramState)
      {
        this.className = paramState.className();
        this.objectId = paramState.objectId();
        this.createdAt = paramState.createdAt();
        this.updatedAt = paramState.updatedAt();
        Iterator localIterator = paramState.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.serverData.put(str, paramState.get(str));
        }
        this.isComplete = paramState.isComplete();
      }
      
      public Init(String paramString)
      {
        this.className = paramString;
      }
      
      public T apply(ParseObject.State paramState)
      {
        if (paramState.objectId() != null) {
          objectId(paramState.objectId());
        }
        if (paramState.createdAt() > 0L) {
          createdAt(paramState.createdAt());
        }
        if (paramState.updatedAt() > 0L) {
          updatedAt(paramState.updatedAt());
        }
        if ((this.isComplete) || (paramState.isComplete())) {}
        for (boolean bool = true;; bool = false)
        {
          isComplete(bool);
          Iterator localIterator = paramState.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            put(str, paramState.get(str));
          }
        }
        return self();
      }
      
      public T apply(ParseOperationSet paramParseOperationSet)
      {
        Iterator localIterator = paramParseOperationSet.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject = ((ParseFieldOperation)paramParseOperationSet.get(str)).apply(this.serverData.get(str), str);
          if (localObject != null) {
            put(str, localObject);
          } else {
            remove(str);
          }
        }
        return self();
      }
      
      abstract <S extends ParseObject.State> S build();
      
      public T clear()
      {
        this.objectId = null;
        this.createdAt = -1L;
        this.updatedAt = -1L;
        this.isComplete = false;
        this.serverData.clear();
        return self();
      }
      
      public T createdAt(long paramLong)
      {
        this.createdAt = paramLong;
        return self();
      }
      
      public T createdAt(Date paramDate)
      {
        this.createdAt = paramDate.getTime();
        return self();
      }
      
      public T isComplete(boolean paramBoolean)
      {
        this.isComplete = paramBoolean;
        return self();
      }
      
      public T objectId(String paramString)
      {
        this.objectId = paramString;
        return self();
      }
      
      public T put(String paramString, Object paramObject)
      {
        this.serverData.put(paramString, paramObject);
        return self();
      }
      
      public T remove(String paramString)
      {
        this.serverData.remove(paramString);
        return self();
      }
      
      abstract T self();
      
      public T updatedAt(long paramLong)
      {
        this.updatedAt = paramLong;
        return self();
      }
      
      public T updatedAt(Date paramDate)
      {
        this.updatedAt = paramDate.getTime();
        return self();
      }
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */