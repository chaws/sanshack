package com.parse;

import a.g;
import a.h;
import a.j;
import a.k;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

class OfflineStore
{
  private static final int MAX_SQL_VARIABLES = 999;
  private final WeakValueHashMap<Pair<String, String>, ParseObject> classNameAndObjectIdToObjectMap = new WeakValueHashMap();
  private final WeakHashMap<ParseObject, j<ParseObject>> fetchedObjects = new WeakHashMap();
  private final OfflineSQLiteOpenHelper helper;
  private final Object lock = new Object();
  private final WeakHashMap<ParseObject, j<String>> objectToUuidMap = new WeakHashMap();
  private final WeakValueHashMap<String, ParseObject> uuidToObjectMap = new WeakValueHashMap();
  
  OfflineStore(Context paramContext)
  {
    this(new OfflineSQLiteOpenHelper(paramContext));
  }
  
  OfflineStore(OfflineSQLiteOpenHelper paramOfflineSQLiteOpenHelper)
  {
    this.helper = paramOfflineSQLiteOpenHelper;
  }
  
  private <T extends ParseObject> j<Integer> countFromPinAsync(String paramString, final ParseQuery.State<T> paramState, final ParseUser paramParseUser, final ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    if (paramString != null) {}
    for (paramString = getParsePin(paramString, paramParseSQLiteDatabase);; paramString = j.a(null)) {
      paramString.d(new h()
      {
        public j<Integer> then(j<ParsePin> paramAnonymousj)
        {
          paramAnonymousj = (ParsePin)paramAnonymousj.f();
          OfflineStore.this.findAsync(paramState, paramParseUser, paramAnonymousj, true, paramParseSQLiteDatabase).c(new h()
          {
            public Integer then(j<List<T>> paramAnonymous2j)
            {
              return Integer.valueOf(((List)paramAnonymous2j.f()).size());
            }
          });
        }
      });
    }
  }
  
  private j<Void> deleteDataForObjectAsync(final ParseObject paramParseObject, final ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    final g localg = new g();
    synchronized (this.lock)
    {
      j localj = (j)this.objectToUuidMap.get(paramParseObject);
      if (localj == null)
      {
        paramParseObject = j.a(null);
        return paramParseObject;
      }
      localj.d(new h()
      {
        public j<String> then(j<String> paramAnonymousj)
        {
          localg.a(paramAnonymousj.f());
          return paramAnonymousj;
        }
      }).d(new h()
      {
        public j<Cursor> then(j<String> paramAnonymousj)
        {
          paramAnonymousj = (String)localg.a();
          return paramParseSQLiteDatabase.queryAsync("Dependencies", new String[] { "key" }, "uuid=?", new String[] { paramAnonymousj });
        }
      }).d(new h()
      {
        public j<Void> then(j<Cursor> paramAnonymousj)
        {
          paramAnonymousj = (Cursor)paramAnonymousj.f();
          Object localObject = new ArrayList();
          paramAnonymousj.moveToFirst();
          while (!paramAnonymousj.isAfterLast())
          {
            ((List)localObject).add(paramAnonymousj.getString(0));
            paramAnonymousj.moveToNext();
          }
          paramAnonymousj.close();
          paramAnonymousj = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            final String str = (String)((Iterator)localObject).next();
            paramAnonymousj.add(OfflineStore.this.getPointerAsync(str, paramParseSQLiteDatabase).d(new h()
            {
              public j<ParsePin> then(j<ParseObject> paramAnonymous2j)
              {
                paramAnonymous2j = (ParsePin)paramAnonymous2j.f();
                return OfflineStore.this.fetchLocallyAsync(paramAnonymous2j, OfflineStore.31.this.val$db);
              }
            }).b(new h()
            {
              public j<Void> then(j<ParsePin> paramAnonymous2j)
              {
                ParsePin localParsePin = (ParsePin)paramAnonymous2j.f();
                List localList = localParsePin.getObjects();
                if ((localList == null) || (!localList.contains(OfflineStore.31.this.val$object))) {
                  return paramAnonymous2j.k();
                }
                localList.remove(OfflineStore.31.this.val$object);
                if (localList.size() == 0) {
                  return OfflineStore.this.unpinAsync(str, OfflineStore.31.this.val$db);
                }
                localParsePin.setObjects(localList);
                return OfflineStore.this.saveLocallyAsync(localParsePin, true, OfflineStore.31.this.val$db);
              }
            }));
          }
          return j.a(paramAnonymousj);
        }
      }).d(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          paramAnonymousj = (String)localg.a();
          return paramParseSQLiteDatabase.deleteAsync("Dependencies", "uuid=?", new String[] { paramAnonymousj });
        }
      }).d(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          paramAnonymousj = (String)localg.a();
          return paramParseSQLiteDatabase.deleteAsync("ParseObjects", "uuid=?", new String[] { paramAnonymousj });
        }
      }).d(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          synchronized (OfflineStore.this.lock)
          {
            OfflineStore.this.fetchedObjects.remove(paramParseObject);
            return paramAnonymousj;
          }
        }
      });
    }
  }
  
  private j<Void> deleteObjects(final List<String> paramList, final ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    int i = 0;
    if (paramList.size() <= 0) {
      return j.a(null);
    }
    if (paramList.size() > 999) {
      deleteObjects(paramList.subList(0, 999), paramParseSQLiteDatabase).d(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          return OfflineStore.this.deleteObjects(paramList.subList(999, paramList.size()), paramParseSQLiteDatabase);
        }
      });
    }
    String[] arrayOfString = new String[paramList.size()];
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = "?";
      i += 1;
    }
    return paramParseSQLiteDatabase.deleteAsync("ParseObjects", "uuid IN (" + TextUtils.join(",", arrayOfString) + ")", (String[])paramList.toArray(new String[paramList.size()]));
  }
  
  private <T extends ParseObject> j<List<T>> findAsync(final ParseQuery.State<T> paramState, final ParseUser paramParseUser, ParsePin paramParsePin, final boolean paramBoolean, final ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    final OfflineQueryLogic localOfflineQueryLogic = new OfflineQueryLogic(this);
    final ArrayList localArrayList = new ArrayList();
    String str;
    if (paramParsePin == null)
    {
      paramParsePin = "className=?" + " AND isDeletingEventually=0";
      str = paramState.className();
    }
    for (paramParsePin = paramParseSQLiteDatabase.queryAsync("ParseObjects", new String[] { "uuid" }, paramParsePin, new String[] { str });; paramParsePin = paramParsePin.d(new h()
        {
          public j<Cursor> then(j<String> paramAnonymousj)
          {
            paramAnonymousj = (String)paramAnonymousj.f();
            String str1 = "className=? AND key=?" + " AND isDeletingEventually=0";
            String str2 = paramState.className();
            return paramParseSQLiteDatabase.queryAsync("ParseObjects A  INNER JOIN Dependencies B  ON A.uuid=B.uuid", new String[] { "A.uuid" }, str1, new String[] { str2, paramAnonymousj });
          }
        }))
    {
      paramParsePin.d(new h()
      {
        public j<Void> then(j<Cursor> paramAnonymousj)
        {
          paramAnonymousj = (Cursor)paramAnonymousj.f();
          Object localObject = new ArrayList();
          paramAnonymousj.moveToFirst();
          while (!paramAnonymousj.isAfterLast())
          {
            ((List)localObject).add(paramAnonymousj.getString(0));
            paramAnonymousj.moveToNext();
          }
          paramAnonymousj.close();
          final OfflineQueryLogic.ConstraintMatcher localConstraintMatcher = localOfflineQueryLogic.createMatcher(paramState, paramParseUser);
          paramAnonymousj = j.a(null);
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            final String str = (String)((Iterator)localObject).next();
            final g localg = new g();
            paramAnonymousj = paramAnonymousj.d(new h()
            {
              public j<T> then(j<Void> paramAnonymous2j)
              {
                return OfflineStore.this.getPointerAsync(str, OfflineStore.6.this.val$db);
              }
            }).d(new h()
            {
              public j<T> then(j<T> paramAnonymous2j)
              {
                localg.a(paramAnonymous2j.f());
                return OfflineStore.this.fetchLocallyAsync((ParseObject)localg.a(), OfflineStore.6.this.val$db);
              }
            }).d(new h()
            {
              public j<Boolean> then(j<T> paramAnonymous2j)
              {
                if (!((ParseObject)localg.a()).isDataAvailable()) {
                  return j.a(Boolean.valueOf(false));
                }
                return localConstraintMatcher.matchesAsync((ParseObject)localg.a(), OfflineStore.6.this.val$db);
              }
            }).c(new h()
            {
              public Void then(j<Boolean> paramAnonymous2j)
              {
                if (((Boolean)paramAnonymous2j.f()).booleanValue()) {
                  OfflineStore.6.this.val$results.add(localg.a());
                }
                return null;
              }
            });
          }
          return paramAnonymousj;
        }
      }).d(new h()
      {
        public j<List<T>> then(final j<Void> paramAnonymousj)
        {
          OfflineQueryLogic.sort(localArrayList, paramState);
          Object localObject = localArrayList;
          int i = paramState.skip();
          paramAnonymousj = (j<Void>)localObject;
          if (!paramBoolean)
          {
            paramAnonymousj = (j<Void>)localObject;
            if (i >= 0) {
              paramAnonymousj = ((List)localObject).subList(Math.min(paramState.skip(), ((List)localObject).size()), ((List)localObject).size());
            }
          }
          i = paramState.limit();
          if ((!paramBoolean) && (i >= 0) && (paramAnonymousj.size() > i)) {
            paramAnonymousj = paramAnonymousj.subList(0, i);
          }
          for (;;)
          {
            localObject = j.a(null);
            Iterator localIterator = paramAnonymousj.iterator();
            while (localIterator.hasNext()) {
              localObject = ((j)localObject).d(new h()
              {
                public j<Void> then(j<Void> paramAnonymous2j)
                {
                  return OfflineQueryLogic.fetchIncludesAsync(OfflineStore.this, this.val$object, OfflineStore.5.this.val$query, OfflineStore.5.this.val$db);
                }
              });
            }
            ((j)localObject).c(new h()
            {
              public List<T> then(j<Void> paramAnonymous2j)
              {
                return paramAnonymousj;
              }
            });
          }
        }
      });
      paramParsePin = (j)this.objectToUuidMap.get(paramParsePin);
      if (paramParsePin == null) {
        return j.a(localArrayList);
      }
    }
  }
  
  private <T extends ParseObject> j<List<T>> findFromPinAsync(String paramString, final ParseQuery.State<T> paramState, final ParseUser paramParseUser, final ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    if (paramString != null) {}
    for (paramString = getParsePin(paramString, paramParseSQLiteDatabase);; paramString = j.a(null)) {
      paramString.d(new h()
      {
        public j<List<T>> then(j<ParsePin> paramAnonymousj)
        {
          paramAnonymousj = (ParsePin)paramAnonymousj.f();
          return OfflineStore.this.findAsync(paramState, paramParseUser, paramAnonymousj, false, paramParseSQLiteDatabase);
        }
      });
    }
  }
  
  private j<String> getOrCreateUUIDAsync(final ParseObject paramParseObject, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    final String str = UUID.randomUUID().toString();
    final k localk = new k();
    synchronized (this.lock)
    {
      j localj = (j)this.objectToUuidMap.get(paramParseObject);
      if (localj != null) {
        return localj;
      }
      this.objectToUuidMap.put(paramParseObject, localk.a());
      this.uuidToObjectMap.put(str, paramParseObject);
      this.fetchedObjects.put(paramParseObject, localk.a().c(new h()
      {
        public ParseObject then(j<String> paramAnonymousj)
        {
          return paramParseObject;
        }
      }));
      ??? = new ContentValues();
      ((ContentValues)???).put("uuid", str);
      ((ContentValues)???).put("className", paramParseObject.getClassName());
      paramParseSQLiteDatabase.insertOrThrowAsync("ParseObjects", (ContentValues)???).a(new h()
      {
        public Void then(j<Void> paramAnonymousj)
        {
          localk.b(str);
          return null;
        }
      });
      return localk.a();
    }
  }
  
  private j<ParsePin> getParsePin(final String paramString, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    findAsync(new ParseQuery.State.Builder(ParsePin.class).whereEqualTo("_name", paramString).build(), null, null, paramParseSQLiteDatabase).c(new h()
    {
      public ParsePin then(j<List<ParsePin>> paramAnonymousj)
      {
        if ((paramAnonymousj.f() != null) && (((List)paramAnonymousj.f()).size() > 0)) {}
        for (paramAnonymousj = (ParsePin)((List)paramAnonymousj.f()).get(0);; paramAnonymousj = null)
        {
          Object localObject = paramAnonymousj;
          if (paramAnonymousj == null)
          {
            localObject = (ParsePin)ParseObject.create(ParsePin.class);
            ((ParsePin)localObject).setName(paramString);
          }
          return (ParsePin)localObject;
        }
      }
    });
  }
  
  private <T extends ParseObject> j<T> getPointerAsync(final String paramString, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    synchronized (this.lock)
    {
      ParseObject localParseObject = (ParseObject)this.uuidToObjectMap.get(paramString);
      if (localParseObject != null)
      {
        paramString = j.a(localParseObject);
        return paramString;
      }
      paramParseSQLiteDatabase.queryAsync("ParseObjects", new String[] { "className", "objectId" }, "uuid = ?", new String[] { paramString }).c(new h()
      {
        public T then(j<Cursor> arg1)
        {
          Object localObject1 = (Cursor)???.f();
          ((Cursor)localObject1).moveToFirst();
          if (((Cursor)localObject1).isAfterLast())
          {
            ((Cursor)localObject1).close();
            throw new IllegalStateException("Attempted to find non-existent uuid " + paramString);
          }
          synchronized (OfflineStore.this.lock)
          {
            Object localObject3 = (ParseObject)OfflineStore.this.uuidToObjectMap.get(paramString);
            if (localObject3 != null) {
              return (T)localObject3;
            }
            String str = ((Cursor)localObject1).getString(0);
            localObject3 = ((Cursor)localObject1).getString(1);
            ((Cursor)localObject1).close();
            localObject1 = ParseObject.createWithoutData(str, (String)localObject3);
            if (localObject3 == null)
            {
              OfflineStore.this.uuidToObjectMap.put(paramString, localObject1);
              OfflineStore.this.objectToUuidMap.put(localObject1, j.a(paramString));
            }
            return (T)localObject1;
          }
        }
      });
    }
  }
  
  private <T extends ParseObject> j<Void> pinAllObjectsAsync(String paramString, final List<T> paramList, final boolean paramBoolean, final ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return j.a(null);
    }
    getParsePin(paramString, paramParseSQLiteDatabase).d(new h()
    {
      public j<Void> then(j<ParsePin> paramAnonymousj)
      {
        ParsePin localParsePin = (ParsePin)paramAnonymousj.f();
        paramAnonymousj = localParsePin.getObjects();
        if (paramAnonymousj == null) {
          paramAnonymousj = new ArrayList(paramList);
        }
        for (;;)
        {
          localParsePin.setObjects(paramAnonymousj);
          if (paramBoolean)
          {
            return OfflineStore.this.saveLocallyAsync(localParsePin, true, paramParseSQLiteDatabase);
            Iterator localIterator = paramList.iterator();
            while (localIterator.hasNext())
            {
              ParseObject localParseObject = (ParseObject)localIterator.next();
              if (!paramAnonymousj.contains(localParseObject)) {
                paramAnonymousj.add(localParseObject);
              }
            }
          }
          return OfflineStore.this.saveLocallyAsync(localParsePin, localParsePin.getObjects(), paramParseSQLiteDatabase);
        }
      }
    });
  }
  
  private <T> j<T> runWithManagedConnection(final SQLiteDatabaseCallable<j<T>> paramSQLiteDatabaseCallable)
  {
    this.helper.getWritableDatabaseAsync().d(new h()
    {
      public j<T> then(final j<ParseSQLiteDatabase> paramAnonymousj)
      {
        paramAnonymousj = (ParseSQLiteDatabase)paramAnonymousj.f();
        ((j)paramSQLiteDatabaseCallable.call(paramAnonymousj)).b(new h()
        {
          public j<T> then(j<T> paramAnonymous2j)
          {
            paramAnonymousj.closeAsync();
            return paramAnonymous2j;
          }
        });
      }
    });
  }
  
  private j<Void> runWithManagedTransaction(final SQLiteDatabaseCallable<j<Void>> paramSQLiteDatabaseCallable)
  {
    this.helper.getWritableDatabaseAsync().d(new h()
    {
      public j<Void> then(final j<ParseSQLiteDatabase> paramAnonymousj)
      {
        paramAnonymousj = (ParseSQLiteDatabase)paramAnonymousj.f();
        paramAnonymousj.beginTransactionAsync().d(new h()
        {
          public j<Void> then(j<Void> paramAnonymous2j)
          {
            ((j)OfflineStore.48.this.val$callable.call(paramAnonymousj)).d(new h()
            {
              public j<Void> then(j<Void> paramAnonymous3j)
              {
                return OfflineStore.48.1.this.val$db.setTransactionSuccessfulAsync();
              }
            }).b(new h()
            {
              public j<Void> then(j<Void> paramAnonymous3j)
              {
                OfflineStore.48.1.this.val$db.endTransactionAsync();
                OfflineStore.48.1.this.val$db.closeAsync();
                return paramAnonymous3j;
              }
            });
          }
        });
      }
    });
  }
  
  private j<Void> saveLocallyAsync(final ParseObject paramParseObject, final List<ParseObject> paramList, final ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    if (paramList != null) {}
    ArrayList localArrayList;
    for (paramList = new ArrayList(paramList);; paramList = new ArrayList())
    {
      if (!paramList.contains(paramParseObject)) {
        paramList.add(paramParseObject);
      }
      localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(fetchLocallyAsync((ParseObject)localIterator.next(), paramParseSQLiteDatabase).k());
      }
    }
    j.a(localArrayList).b(new h()
    {
      public j<String> then(j<Void> paramAnonymousj)
      {
        return (j)OfflineStore.this.objectToUuidMap.get(paramParseObject);
      }
    }).d(new h()
    {
      public j<Void> then(j<String> paramAnonymousj)
      {
        paramAnonymousj = (String)paramAnonymousj.f();
        if (paramAnonymousj == null) {
          return null;
        }
        return OfflineStore.this.unpinAsync(paramAnonymousj, paramParseSQLiteDatabase);
      }
    }).d(new h()
    {
      public j<String> then(j<Void> paramAnonymousj)
      {
        return OfflineStore.this.getOrCreateUUIDAsync(paramParseObject, paramParseSQLiteDatabase);
      }
    }).d(new h()
    {
      public j<Void> then(j<String> paramAnonymousj)
      {
        paramAnonymousj = (String)paramAnonymousj.f();
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          ParseObject localParseObject = (ParseObject)localIterator.next();
          localArrayList.add(OfflineStore.this.saveLocallyAsync(paramAnonymousj, localParseObject, paramParseSQLiteDatabase));
        }
        return j.a(localArrayList);
      }
    });
  }
  
  private j<Void> saveLocallyAsync(ParseObject paramParseObject, boolean paramBoolean, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    final ArrayList localArrayList = new ArrayList();
    if (!paramBoolean) {
      localArrayList.add(paramParseObject);
    }
    for (;;)
    {
      return saveLocallyAsync(paramParseObject, localArrayList, paramParseSQLiteDatabase);
      new ParseTraverser()
      {
        protected boolean visit(Object paramAnonymousObject)
        {
          if ((paramAnonymousObject instanceof ParseObject)) {
            localArrayList.add((ParseObject)paramAnonymousObject);
          }
          return true;
        }
      }.setYieldRoot(true).setTraverseParseObjects(true).traverse(paramParseObject);
    }
  }
  
  private j<Void> saveLocallyAsync(final String paramString, final ParseObject paramParseObject, final ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    if ((paramParseObject.getObjectId() != null) && (!paramParseObject.isDataAvailable()) && (!paramParseObject.hasChanges()) && (!paramParseObject.hasOutstandingOperations())) {
      return j.a(null);
    }
    final g localg = new g();
    getOrCreateUUIDAsync(paramParseObject, paramParseSQLiteDatabase).d(new h()
    {
      public j<Void> then(j<String> paramAnonymousj)
      {
        paramAnonymousj = (String)paramAnonymousj.f();
        localg.a(paramAnonymousj);
        return OfflineStore.this.updateDataForObjectAsync(paramAnonymousj, paramParseObject, paramParseSQLiteDatabase);
      }
    }).d(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        paramAnonymousj = new ContentValues();
        paramAnonymousj.put("key", paramString);
        paramAnonymousj.put("uuid", (String)localg.a());
        return paramParseSQLiteDatabase.insertWithOnConflict("Dependencies", paramAnonymousj, 4);
      }
    });
  }
  
  private j<Void> unpinAllObjectsAsync(String paramString, final ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    getParsePin(paramString, paramParseSQLiteDatabase).b(new h()
    {
      public j<Void> then(j<ParsePin> paramAnonymousj)
      {
        if (paramAnonymousj.e()) {
          return paramAnonymousj.k();
        }
        paramAnonymousj = (ParsePin)paramAnonymousj.f();
        return OfflineStore.this.unpinAsync(paramAnonymousj, paramParseSQLiteDatabase);
      }
    });
  }
  
  private <T extends ParseObject> j<Void> unpinAllObjectsAsync(String paramString, final List<T> paramList, final ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return j.a(null);
    }
    getParsePin(paramString, paramParseSQLiteDatabase).d(new h()
    {
      public j<Void> then(j<ParsePin> paramAnonymousj)
      {
        paramAnonymousj = (ParsePin)paramAnonymousj.f();
        List localList = paramAnonymousj.getObjects();
        if (localList == null) {
          return j.a(null);
        }
        localList.removeAll(paramList);
        if (localList.size() == 0) {
          return OfflineStore.this.unpinAsync(paramAnonymousj, paramParseSQLiteDatabase);
        }
        paramAnonymousj.setObjects(localList);
        return OfflineStore.this.saveLocallyAsync(paramAnonymousj, true, paramParseSQLiteDatabase);
      }
    });
  }
  
  private j<Void> unpinAsync(ParseObject paramParseObject, final ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    paramParseObject = (j)this.objectToUuidMap.get(paramParseObject);
    if (paramParseObject == null) {
      return j.a(null);
    }
    paramParseObject.b(new h()
    {
      public j<Void> then(j<String> paramAnonymousj)
      {
        paramAnonymousj = (String)paramAnonymousj.f();
        if (paramAnonymousj == null) {
          return j.a(null);
        }
        return OfflineStore.this.unpinAsync(paramAnonymousj, paramParseSQLiteDatabase);
      }
    });
  }
  
  private j<Void> unpinAsync(final String paramString, final ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    final LinkedList localLinkedList = new LinkedList();
    j.a((Void)null).b(new h()
    {
      public j<Cursor> then(j<Void> paramAnonymousj)
      {
        paramAnonymousj = paramString;
        return paramParseSQLiteDatabase.rawQueryAsync("SELECT uuid FROM Dependencies WHERE key=? AND uuid IN ( SELECT uuid FROM Dependencies GROUP BY uuid HAVING COUNT(uuid)=1)", new String[] { paramAnonymousj });
      }
    }).d(new h()
    {
      public j<Void> then(j<Cursor> paramAnonymousj)
      {
        paramAnonymousj = (Cursor)paramAnonymousj.f();
        while (paramAnonymousj.moveToNext()) {
          localLinkedList.add(paramAnonymousj.getString(0));
        }
        paramAnonymousj.close();
        return OfflineStore.this.deleteObjects(localLinkedList, paramParseSQLiteDatabase);
      }
    }).d(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        paramAnonymousj = paramString;
        return paramParseSQLiteDatabase.deleteAsync("Dependencies", "key=?", new String[] { paramAnonymousj });
      }
    }).c(new h()
    {
      public Void then(j<Void> arg1)
      {
        synchronized (OfflineStore.this.lock)
        {
          Iterator localIterator = localLinkedList.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ParseObject localParseObject = (ParseObject)OfflineStore.this.uuidToObjectMap.get(str);
            if (localParseObject != null)
            {
              OfflineStore.this.objectToUuidMap.remove(localParseObject);
              OfflineStore.this.uuidToObjectMap.remove(str);
            }
          }
        }
        return null;
      }
    });
  }
  
  private j<Void> updateDataForObjectAsync(final ParseObject paramParseObject, final ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    synchronized (this.lock)
    {
      j localj = (j)this.objectToUuidMap.get(paramParseObject);
      if (localj == null)
      {
        paramParseObject = j.a(null);
        return paramParseObject;
      }
      localj.d(new h()
      {
        public j<Void> then(j<String> paramAnonymousj)
        {
          paramAnonymousj = (String)paramAnonymousj.f();
          return OfflineStore.this.updateDataForObjectAsync(paramAnonymousj, paramParseObject, paramParseSQLiteDatabase);
        }
      });
    }
  }
  
  private j<Void> updateDataForObjectAsync(final String paramString, final ParseObject paramParseObject, final ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    OfflineEncoder localOfflineEncoder = new OfflineEncoder(paramParseSQLiteDatabase);
    final JSONObject localJSONObject = paramParseObject.toRest(localOfflineEncoder);
    localOfflineEncoder.whenFinished().d(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        String str1 = paramParseObject.getClassName();
        String str2 = paramParseObject.getObjectId();
        int i = localJSONObject.getInt("__isDeletingEventually");
        paramAnonymousj = new ContentValues();
        paramAnonymousj.put("className", str1);
        paramAnonymousj.put("json", localJSONObject.toString());
        if (str2 != null) {
          paramAnonymousj.put("objectId", str2);
        }
        paramAnonymousj.put("isDeletingEventually", Integer.valueOf(i));
        str1 = paramString;
        return paramParseSQLiteDatabase.updateAsync("ParseObjects", paramAnonymousj, "uuid = ?", new String[] { str1 }).k();
      }
    });
  }
  
  void clearDatabase(Context paramContext)
  {
    this.helper.clearDatabase(paramContext);
  }
  
  <T extends ParseObject> j<Integer> countFromPinAsync(final String paramString, final ParseQuery.State<T> paramState, final ParseUser paramParseUser)
  {
    runWithManagedConnection(new SQLiteDatabaseCallable()
    {
      public j<Integer> call(ParseSQLiteDatabase paramAnonymousParseSQLiteDatabase)
      {
        return OfflineStore.this.countFromPinAsync(paramString, paramState, paramParseUser, paramAnonymousParseSQLiteDatabase);
      }
    });
  }
  
  j<Void> deleteDataForObjectAsync(final ParseObject paramParseObject)
  {
    this.helper.getWritableDatabaseAsync().b(new h()
    {
      public j<Void> then(final j<ParseSQLiteDatabase> paramAnonymousj)
      {
        paramAnonymousj = (ParseSQLiteDatabase)paramAnonymousj.f();
        paramAnonymousj.beginTransactionAsync().d(new h()
        {
          public j<Void> then(j<Void> paramAnonymous2j)
          {
            OfflineStore.this.deleteDataForObjectAsync(OfflineStore.29.this.val$object, paramAnonymousj).d(new h()
            {
              public j<Void> then(j<Void> paramAnonymous3j)
              {
                return OfflineStore.29.1.this.val$db.setTransactionSuccessfulAsync();
              }
            }).b(new h()
            {
              public j<Void> then(j<Void> paramAnonymous3j)
              {
                OfflineStore.29.1.this.val$db.endTransactionAsync();
                OfflineStore.29.1.this.val$db.closeAsync();
                return paramAnonymous3j;
              }
            });
          }
        });
      }
    });
  }
  
  <T extends ParseObject> j<T> fetchLocallyAsync(final T paramT)
  {
    runWithManagedConnection(new SQLiteDatabaseCallable()
    {
      public j<T> call(ParseSQLiteDatabase paramAnonymousParseSQLiteDatabase)
      {
        return OfflineStore.this.fetchLocallyAsync(paramT, paramAnonymousParseSQLiteDatabase);
      }
    });
  }
  
  <T extends ParseObject> j<T> fetchLocallyAsync(final T paramT, ParseSQLiteDatabase arg2)
  {
    final k localk = new k();
    for (;;)
    {
      j localj;
      String str1;
      String str2;
      synchronized (this.lock)
      {
        if (this.fetchedObjects.containsKey(paramT))
        {
          paramT = (j)this.fetchedObjects.get(paramT);
          return paramT;
        }
        this.fetchedObjects.put(paramT, localk.a());
        localj = (j)this.objectToUuidMap.get(paramT);
        str1 = paramT.getClassName();
        str2 = paramT.getObjectId();
        ??? = j.a(null);
        if (str2 != null) {
          break label182;
        }
        if (localj == null) {
          ((j)???).d(new h()
          {
            public j<Void> then(final j<String> paramAnonymousj)
            {
              paramAnonymousj = (String)paramAnonymousj.f();
              if (paramAnonymousj == null) {
                return j.a(new ParseException(120, "Attempted to fetch an object offline which was never saved to the offline cache."));
              }
              try
              {
                paramAnonymousj = new JSONObject(paramAnonymousj);
                final HashMap localHashMap = new HashMap();
                new ParseTraverser()
                {
                  protected boolean visit(Object paramAnonymous2Object)
                  {
                    if (((paramAnonymous2Object instanceof JSONObject)) && (((JSONObject)paramAnonymous2Object).optString("__type").equals("OfflineObject")))
                    {
                      paramAnonymous2Object = ((JSONObject)paramAnonymous2Object).optString("uuid");
                      localHashMap.put(paramAnonymous2Object, OfflineStore.this.getPointerAsync((String)paramAnonymous2Object, OfflineStore.11.this.val$db));
                    }
                    return true;
                  }
                }.setTraverseParseObjects(false).setYieldRoot(false).traverse(paramAnonymousj);
                j.a(localHashMap.values()).c(new h()
                {
                  public Void then(j<Void> paramAnonymous2j)
                  {
                    OfflineStore.11.this.val$object.mergeREST(OfflineStore.11.this.val$object.getState(), paramAnonymousj, new OfflineStore.OfflineDecoder(OfflineStore.this, localHashMap, null));
                    return null;
                  }
                });
              }
              catch (JSONException paramAnonymousj) {}
              return j.a(paramAnonymousj);
            }
          }).b(new h()
          {
            public j<T> then(j<Void> paramAnonymousj)
            {
              if (paramAnonymousj.d()) {
                localk.c();
              }
              for (;;)
              {
                return localk.a();
                if (paramAnonymousj.e()) {
                  localk.b(paramAnonymousj.g());
                } else {
                  localk.b(paramT);
                }
              }
            }
          });
        }
      }
      ??? = new g();
      ??? = localj.d(new h()
      {
        public j<Cursor> then(j<String> paramAnonymousj)
        {
          localObject.a(paramAnonymousj.f());
          paramAnonymousj = (String)localObject.a();
          return paramParseSQLiteDatabase.queryAsync("ParseObjects", this.val$select, "uuid = ?", new String[] { paramAnonymousj });
        }
      }).c(new h()
      {
        public String then(j<Cursor> paramAnonymousj)
        {
          paramAnonymousj = (Cursor)paramAnonymousj.f();
          paramAnonymousj.moveToFirst();
          if (paramAnonymousj.isAfterLast())
          {
            paramAnonymousj.close();
            throw new IllegalStateException("Attempted to find non-existent uuid " + (String)localObject.a());
          }
          String str = paramAnonymousj.getString(0);
          paramAnonymousj.close();
          return str;
        }
      });
      continue;
      label182:
      if (localj != null)
      {
        localk.b(new IllegalStateException("This object must have already been fetched from the local datastore, but isn't marked as fetched."));
        synchronized (this.lock)
        {
          this.fetchedObjects.remove(paramT);
          return localk.a();
        }
      }
      ??? = String.format("%s = ? AND %s = ?", new Object[] { "className", "objectId" });
      ??? = ???.queryAsync("ParseObjects", new String[] { "json", "uuid" }, (String)???, new String[] { str1, str2 }).c(new h()
      {
        public String then(j<Cursor> paramAnonymousj)
        {
          ??? = (Cursor)paramAnonymousj.f();
          ((Cursor)???).moveToFirst();
          if (((Cursor)???).isAfterLast())
          {
            ((Cursor)???).close();
            throw new ParseException(120, "This object is not available in the offline cache.");
          }
          paramAnonymousj = ((Cursor)???).getString(0);
          String str = ((Cursor)???).getString(1);
          ((Cursor)???).close();
          synchronized (OfflineStore.this.lock)
          {
            OfflineStore.this.objectToUuidMap.put(paramT, j.a(str));
            OfflineStore.this.uuidToObjectMap.put(str, paramT);
            return paramAnonymousj;
          }
        }
      });
    }
  }
  
  <T extends ParseObject> j<List<T>> findAsync(ParseQuery.State<T> paramState, ParseUser paramParseUser, ParsePin paramParsePin, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    return findAsync(paramState, paramParseUser, paramParsePin, false, paramParseSQLiteDatabase);
  }
  
  <T extends ParseObject> j<List<T>> findFromPinAsync(final String paramString, final ParseQuery.State<T> paramState, final ParseUser paramParseUser)
  {
    runWithManagedConnection(new SQLiteDatabaseCallable()
    {
      public j<List<T>> call(ParseSQLiteDatabase paramAnonymousParseSQLiteDatabase)
      {
        return OfflineStore.this.findFromPinAsync(paramString, paramState, paramParseUser, paramAnonymousParseSQLiteDatabase);
      }
    });
  }
  
  ParseObject getObject(String arg1, String paramString2)
  {
    if (paramString2 == null) {
      throw new IllegalStateException("objectId cannot be null.");
    }
    paramString2 = Pair.create(???, paramString2);
    synchronized (this.lock)
    {
      paramString2 = (ParseObject)this.classNameAndObjectIdToObjectMap.get(paramString2);
      return paramString2;
    }
  }
  
  <T extends ParseObject> j<Void> pinAllObjectsAsync(final String paramString, final List<T> paramList, final boolean paramBoolean)
  {
    runWithManagedTransaction(new SQLiteDatabaseCallable()
    {
      public j<Void> call(ParseSQLiteDatabase paramAnonymousParseSQLiteDatabase)
      {
        return OfflineStore.this.pinAllObjectsAsync(paramString, paramList, paramBoolean, paramAnonymousParseSQLiteDatabase);
      }
    });
  }
  
  void registerNewObject(ParseObject paramParseObject)
  {
    synchronized (this.lock)
    {
      Object localObject2 = paramParseObject.getObjectId();
      if (localObject2 != null)
      {
        localObject2 = Pair.create(paramParseObject.getClassName(), localObject2);
        this.classNameAndObjectIdToObjectMap.put(localObject2, paramParseObject);
      }
      return;
    }
  }
  
  void simulateReboot()
  {
    synchronized (this.lock)
    {
      this.uuidToObjectMap.clear();
      this.objectToUuidMap.clear();
      this.classNameAndObjectIdToObjectMap.clear();
      this.fetchedObjects.clear();
      return;
    }
  }
  
  j<Void> unpinAllObjectsAsync(final String paramString)
  {
    runWithManagedTransaction(new SQLiteDatabaseCallable()
    {
      public j<Void> call(ParseSQLiteDatabase paramAnonymousParseSQLiteDatabase)
      {
        return OfflineStore.this.unpinAllObjectsAsync(paramString, paramAnonymousParseSQLiteDatabase);
      }
    });
  }
  
  <T extends ParseObject> j<Void> unpinAllObjectsAsync(final String paramString, final List<T> paramList)
  {
    runWithManagedTransaction(new SQLiteDatabaseCallable()
    {
      public j<Void> call(ParseSQLiteDatabase paramAnonymousParseSQLiteDatabase)
      {
        return OfflineStore.this.unpinAllObjectsAsync(paramString, paramList, paramAnonymousParseSQLiteDatabase);
      }
    });
  }
  
  void unregisterObject(ParseObject paramParseObject)
  {
    synchronized (this.lock)
    {
      String str = paramParseObject.getObjectId();
      if (str != null) {
        this.classNameAndObjectIdToObjectMap.remove(Pair.create(paramParseObject.getClassName(), str));
      }
      return;
    }
  }
  
  j<Void> updateDataForObjectAsync(final ParseObject paramParseObject)
  {
    synchronized (this.lock)
    {
      j localj = (j)this.fetchedObjects.get(paramParseObject);
      if (localj == null)
      {
        paramParseObject = j.a(new IllegalStateException("An object cannot be updated if it wasn't fetched."));
        return paramParseObject;
      }
      localj.b(new h()
      {
        public j<Void> then(j<ParseObject> paramAnonymousj)
        {
          if (paramAnonymousj.e())
          {
            if (((paramAnonymousj.g() instanceof ParseException)) && (((ParseException)paramAnonymousj.g()).getCode() == 120)) {
              return j.a(null);
            }
            return paramAnonymousj.k();
          }
          OfflineStore.this.helper.getWritableDatabaseAsync().b(new h()
          {
            public j<Void> then(final j<ParseSQLiteDatabase> paramAnonymous2j)
            {
              paramAnonymous2j = (ParseSQLiteDatabase)paramAnonymous2j.f();
              paramAnonymous2j.beginTransactionAsync().d(new h()
              {
                public j<Void> then(j<Void> paramAnonymous3j)
                {
                  OfflineStore.this.updateDataForObjectAsync(OfflineStore.26.this.val$object, paramAnonymous2j).d(new h()
                  {
                    public j<Void> then(j<Void> paramAnonymous4j)
                    {
                      return OfflineStore.26.1.1.this.val$db.setTransactionSuccessfulAsync();
                    }
                  }).b(new h()
                  {
                    public j<Void> then(j<Void> paramAnonymous4j)
                    {
                      OfflineStore.26.1.1.this.val$db.endTransactionAsync();
                      OfflineStore.26.1.1.this.val$db.closeAsync();
                      return paramAnonymous4j;
                    }
                  });
                }
              });
            }
          });
        }
      });
    }
  }
  
  void updateObjectId(ParseObject paramParseObject, String arg2, String paramString2)
  {
    if (??? != null)
    {
      if (???.equals(paramString2)) {
        return;
      }
      throw new RuntimeException("objectIds cannot be changed in offline mode.");
    }
    paramString2 = Pair.create(paramParseObject.getClassName(), paramString2);
    synchronized (this.lock)
    {
      ParseObject localParseObject = (ParseObject)this.classNameAndObjectIdToObjectMap.get(paramString2);
      if ((localParseObject != null) && (localParseObject != paramParseObject)) {
        throw new RuntimeException("Attempted to change an objectId to one that's already known to the Offline Store.");
      }
    }
    this.classNameAndObjectIdToObjectMap.put(paramString2, paramParseObject);
  }
  
  private class OfflineDecoder
    extends ParseDecoder
  {
    private Map<String, j<ParseObject>> offlineObjects;
    
    private OfflineDecoder()
    {
      Map localMap;
      this.offlineObjects = localMap;
    }
    
    public Object decode(Object paramObject)
    {
      if (((paramObject instanceof JSONObject)) && (((JSONObject)paramObject).optString("__type").equals("OfflineObject")))
      {
        paramObject = ((JSONObject)paramObject).optString("uuid");
        return ((j)this.offlineObjects.get(paramObject)).f();
      }
      return super.decode(paramObject);
    }
  }
  
  private class OfflineEncoder
    extends ParseEncoder
  {
    private ParseSQLiteDatabase db;
    private ArrayList<j<Void>> tasks = new ArrayList();
    private final Object tasksLock = new Object();
    
    public OfflineEncoder(ParseSQLiteDatabase paramParseSQLiteDatabase)
    {
      this.db = paramParseSQLiteDatabase;
    }
    
    /* Error */
    public JSONObject encodeRelatedObject(ParseObject paramParseObject)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual 54	com/parse/ParseObject:getObjectId	()Ljava/lang/String;
      //   4: ifnull +44 -> 48
      //   7: new 56	org/json/JSONObject
      //   10: dup
      //   11: invokespecial 57	org/json/JSONObject:<init>	()V
      //   14: astore_2
      //   15: aload_2
      //   16: ldc 59
      //   18: ldc 61
      //   20: invokevirtual 65	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   23: pop
      //   24: aload_2
      //   25: ldc 67
      //   27: aload_1
      //   28: invokevirtual 54	com/parse/ParseObject:getObjectId	()Ljava/lang/String;
      //   31: invokevirtual 65	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   34: pop
      //   35: aload_2
      //   36: ldc 69
      //   38: aload_1
      //   39: invokevirtual 72	com/parse/ParseObject:getClassName	()Ljava/lang/String;
      //   42: invokevirtual 65	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   45: pop
      //   46: aload_2
      //   47: areturn
      //   48: new 56	org/json/JSONObject
      //   51: dup
      //   52: invokespecial 57	org/json/JSONObject:<init>	()V
      //   55: astore_3
      //   56: aload_3
      //   57: ldc 59
      //   59: ldc 74
      //   61: invokevirtual 65	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   64: pop
      //   65: aload_0
      //   66: getfield 37	com/parse/OfflineStore$OfflineEncoder:tasksLock	Ljava/lang/Object;
      //   69: astore_2
      //   70: aload_2
      //   71: monitorenter
      //   72: aload_0
      //   73: getfield 32	com/parse/OfflineStore$OfflineEncoder:tasks	Ljava/util/ArrayList;
      //   76: aload_0
      //   77: getfield 24	com/parse/OfflineStore$OfflineEncoder:this$0	Lcom/parse/OfflineStore;
      //   80: aload_1
      //   81: aload_0
      //   82: getfield 39	com/parse/OfflineStore$OfflineEncoder:db	Lcom/parse/ParseSQLiteDatabase;
      //   85: invokestatic 78	com/parse/OfflineStore:access$200	(Lcom/parse/OfflineStore;Lcom/parse/ParseObject;Lcom/parse/ParseSQLiteDatabase;)La/j;
      //   88: new 11	com/parse/OfflineStore$OfflineEncoder$2
      //   91: dup
      //   92: aload_0
      //   93: aload_3
      //   94: invokespecial 81	com/parse/OfflineStore$OfflineEncoder$2:<init>	(Lcom/parse/OfflineStore$OfflineEncoder;Lorg/json/JSONObject;)V
      //   97: invokevirtual 87	a/j:c	(La/h;)La/j;
      //   100: invokevirtual 91	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   103: pop
      //   104: aload_2
      //   105: monitorexit
      //   106: aload_3
      //   107: areturn
      //   108: astore_1
      //   109: aload_2
      //   110: monitorexit
      //   111: aload_1
      //   112: athrow
      //   113: astore_1
      //   114: new 93	java/lang/RuntimeException
      //   117: dup
      //   118: aload_1
      //   119: invokespecial 96	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   122: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	123	0	this	OfflineEncoder
      //   0	123	1	paramParseObject	ParseObject
      //   55	52	3	localJSONObject	JSONObject
      // Exception table:
      //   from	to	target	type
      //   72	106	108	finally
      //   109	111	108	finally
      //   0	46	113	org/json/JSONException
      //   48	72	113	org/json/JSONException
      //   111	113	113	org/json/JSONException
    }
    
    public j<Void> whenFinished()
    {
      j.a(this.tasks).b(new h()
      {
        public j<Void> then(j<Void> arg1)
        {
          synchronized (OfflineStore.OfflineEncoder.this.tasksLock)
          {
            Object localObject1 = OfflineStore.OfflineEncoder.this.tasks.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              j localj = (j)((Iterator)localObject1).next();
              if ((localj.e()) || (localj.d())) {
                return localj;
              }
            }
            OfflineStore.OfflineEncoder.this.tasks.clear();
            localObject1 = j.a((Void)null);
            return (j<Void>)localObject1;
          }
        }
      });
    }
  }
  
  private static abstract interface SQLiteDatabaseCallable<T>
  {
    public abstract T call(ParseSQLiteDatabase paramParseSQLiteDatabase);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/OfflineStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */