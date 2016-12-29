package com.parse;

import a.h;
import a.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class OfflineQueryLogic
{
  private final OfflineStore store;
  
  OfflineQueryLogic(OfflineStore paramOfflineStore)
  {
    this.store = paramOfflineStore;
  }
  
  private static boolean compare(Object paramObject1, Object paramObject2, Decider paramDecider)
  {
    if ((paramObject2 instanceof List)) {
      return compareList(paramObject1, (List)paramObject2, paramDecider);
    }
    if ((paramObject2 instanceof JSONArray)) {
      return compareArray(paramObject1, (JSONArray)paramObject2, paramDecider);
    }
    return paramDecider.decide(paramObject1, paramObject2);
  }
  
  private static boolean compareArray(Object paramObject, JSONArray paramJSONArray, Decider paramDecider)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramJSONArray.length()) {}
      try
      {
        bool1 = paramDecider.decide(paramObject, paramJSONArray.get(i));
        if (bool1)
        {
          bool1 = true;
          return bool1;
        }
      }
      catch (JSONException paramObject)
      {
        throw new RuntimeException((Throwable)paramObject);
      }
      i += 1;
    }
  }
  
  private static boolean compareList(Object paramObject, List<?> paramList, Decider paramDecider)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (paramDecider.decide(paramObject, paramList.next())) {
        return true;
      }
    }
    return false;
  }
  
  private static int compareTo(Object paramObject1, Object paramObject2)
  {
    int i;
    int j;
    if ((paramObject1 == JSONObject.NULL) || (paramObject1 == null))
    {
      i = 1;
      if ((paramObject2 != JSONObject.NULL) && (paramObject2 != null)) {
        break label45;
      }
      j = 1;
    }
    for (;;)
    {
      if ((i != 0) || (j != 0))
      {
        if (i == 0)
        {
          return 1;
          i = 0;
          break;
          label45:
          j = 0;
          continue;
        }
        if (j == 0) {
          return -1;
        }
        return 0;
      }
    }
    if (((paramObject1 instanceof Date)) && ((paramObject2 instanceof Date))) {
      return ((Date)paramObject1).compareTo((Date)paramObject2);
    }
    if (((paramObject1 instanceof String)) && ((paramObject2 instanceof String))) {
      return ((String)paramObject1).compareTo((String)paramObject2);
    }
    if (((paramObject1 instanceof Number)) && ((paramObject2 instanceof Number))) {
      return Numbers.compare((Number)paramObject1, (Number)paramObject2);
    }
    throw new IllegalArgumentException(String.format("Cannot compare %s against %s", new Object[] { paramObject1, paramObject2 }));
  }
  
  private <T extends ParseObject> ConstraintMatcher<T> createDontSelectMatcher(ParseUser paramParseUser, Object paramObject, String paramString)
  {
    new ConstraintMatcher(paramParseUser, createSelectMatcher(paramParseUser, paramObject, paramString))
    {
      public j<Boolean> matchesAsync(T paramAnonymousT, ParseSQLiteDatabase paramAnonymousParseSQLiteDatabase)
      {
        this.val$selectMatcher.matchesAsync(paramAnonymousT, paramAnonymousParseSQLiteDatabase).c(new h()
        {
          public Boolean then(j<Boolean> paramAnonymous2j)
          {
            if (!((Boolean)paramAnonymous2j.f()).booleanValue()) {}
            for (boolean bool = true;; bool = false) {
              return Boolean.valueOf(bool);
            }
          }
        });
      }
    };
  }
  
  private <T extends ParseObject> ConstraintMatcher<T> createInQueryMatcher(ParseUser paramParseUser, Object paramObject, final String paramString)
  {
    new SubQueryMatcher(paramParseUser, ((ParseQuery.State.Builder)paramObject).build(), paramString)
    {
      protected boolean matches(T paramAnonymousT, List<T> paramAnonymousList)
      {
        return OfflineQueryLogic.matchesInConstraint(paramAnonymousList, OfflineQueryLogic.access$200(paramAnonymousT, paramString));
      }
    };
  }
  
  private <T extends ParseObject> ConstraintMatcher<T> createMatcher(ParseUser paramParseUser, ParseQuery.QueryConstraints paramQueryConstraints)
  {
    final ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramQueryConstraints.keySet().iterator();
    while (localIterator1.hasNext())
    {
      final String str1 = (String)localIterator1.next();
      final Object localObject = paramQueryConstraints.get(str1);
      if (str1.equals("$or"))
      {
        localArrayList.add(createOrMatcher(paramParseUser, (ArrayList)localObject));
      }
      else if ((localObject instanceof ParseQuery.KeyConstraints))
      {
        localObject = (ParseQuery.KeyConstraints)localObject;
        Iterator localIterator2 = ((ParseQuery.KeyConstraints)localObject).keySet().iterator();
        while (localIterator2.hasNext())
        {
          String str2 = (String)localIterator2.next();
          localArrayList.add(createMatcher(paramParseUser, str2, ((ParseQuery.KeyConstraints)localObject).get(str2), str1, (ParseQuery.KeyConstraints)localObject));
        }
      }
      else if ((localObject instanceof ParseQuery.RelationConstraint))
      {
        localArrayList.add(new ConstraintMatcher(paramParseUser, (ParseQuery.RelationConstraint)localObject)
        {
          public j<Boolean> matchesAsync(T paramAnonymousT, ParseSQLiteDatabase paramAnonymousParseSQLiteDatabase)
          {
            return j.a(Boolean.valueOf(localObject.getRelation().hasKnownObject(paramAnonymousT)));
          }
        });
      }
      else
      {
        localArrayList.add(new ConstraintMatcher(paramParseUser, str1)
        {
          public j<Boolean> matchesAsync(T paramAnonymousT, ParseSQLiteDatabase paramAnonymousParseSQLiteDatabase)
          {
            try
            {
              paramAnonymousT = OfflineQueryLogic.getValue(paramAnonymousT, str1);
              return j.a(Boolean.valueOf(OfflineQueryLogic.matchesEqualConstraint(localObject, paramAnonymousT)));
            }
            catch (ParseException paramAnonymousT) {}
            return j.a(paramAnonymousT);
          }
        });
      }
    }
    new ConstraintMatcher(paramParseUser, localArrayList)
    {
      public j<Boolean> matchesAsync(final T paramAnonymousT, final ParseSQLiteDatabase paramAnonymousParseSQLiteDatabase)
      {
        j localj = j.a(Boolean.valueOf(true));
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext()) {
          localj = localj.d(new h()
          {
            public j<Boolean> then(j<Boolean> paramAnonymous2j)
            {
              if (!((Boolean)paramAnonymous2j.f()).booleanValue()) {
                return paramAnonymous2j;
              }
              return this.val$matcher.matchesAsync(paramAnonymousT, paramAnonymousParseSQLiteDatabase);
            }
          });
        }
        return localj;
      }
    };
  }
  
  private <T extends ParseObject> ConstraintMatcher<T> createMatcher(ParseUser paramParseUser, final String paramString1, final Object paramObject, final String paramString2, final ParseQuery.KeyConstraints paramKeyConstraints)
  {
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        new ConstraintMatcher(paramParseUser, paramString2)
        {
          public j<Boolean> matchesAsync(T paramAnonymousT, ParseSQLiteDatabase paramAnonymousParseSQLiteDatabase)
          {
            try
            {
              paramAnonymousT = OfflineQueryLogic.getValue(paramAnonymousT, paramString2);
              paramAnonymousT = j.a(Boolean.valueOf(OfflineQueryLogic.matchesStatelessConstraint(paramString1, paramObject, paramAnonymousT, paramKeyConstraints)));
              return paramAnonymousT;
            }
            catch (ParseException paramAnonymousT) {}
            return j.a(paramAnonymousT);
          }
        };
        if (paramString1.equals("$inQuery"))
        {
          i = 0;
          continue;
          if (paramString1.equals("$notInQuery"))
          {
            i = 1;
            continue;
            if (paramString1.equals("$select"))
            {
              i = 2;
              continue;
              if (paramString1.equals("$dontSelect")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return createInQueryMatcher(paramParseUser, paramObject, paramString2);
    return createNotInQueryMatcher(paramParseUser, paramObject, paramString2);
    return createSelectMatcher(paramParseUser, paramObject, paramString2);
    return createDontSelectMatcher(paramParseUser, paramObject, paramString2);
  }
  
  private <T extends ParseObject> ConstraintMatcher<T> createNotInQueryMatcher(ParseUser paramParseUser, Object paramObject, String paramString)
  {
    new ConstraintMatcher(paramParseUser, createInQueryMatcher(paramParseUser, paramObject, paramString))
    {
      public j<Boolean> matchesAsync(T paramAnonymousT, ParseSQLiteDatabase paramAnonymousParseSQLiteDatabase)
      {
        this.val$inQueryMatcher.matchesAsync(paramAnonymousT, paramAnonymousParseSQLiteDatabase).c(new h()
        {
          public Boolean then(j<Boolean> paramAnonymous2j)
          {
            if (!((Boolean)paramAnonymous2j.f()).booleanValue()) {}
            for (boolean bool = true;; bool = false) {
              return Boolean.valueOf(bool);
            }
          }
        });
      }
    };
  }
  
  private <T extends ParseObject> ConstraintMatcher<T> createOrMatcher(ParseUser paramParseUser, ArrayList<ParseQuery.QueryConstraints> paramArrayList)
  {
    final ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(createMatcher(paramParseUser, (ParseQuery.QueryConstraints)paramArrayList.next()));
    }
    new ConstraintMatcher(paramParseUser, localArrayList)
    {
      public j<Boolean> matchesAsync(final T paramAnonymousT, final ParseSQLiteDatabase paramAnonymousParseSQLiteDatabase)
      {
        j localj = j.a(Boolean.valueOf(false));
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext()) {
          localj = localj.d(new h()
          {
            public j<Boolean> then(j<Boolean> paramAnonymous2j)
            {
              if (((Boolean)paramAnonymous2j.f()).booleanValue()) {
                return paramAnonymous2j;
              }
              return this.val$matcher.matchesAsync(paramAnonymousT, paramAnonymousParseSQLiteDatabase);
            }
          });
        }
        return localj;
      }
    };
  }
  
  private <T extends ParseObject> ConstraintMatcher<T> createSelectMatcher(ParseUser paramParseUser, Object paramObject, final String paramString)
  {
    paramObject = (Map)paramObject;
    new SubQueryMatcher(paramParseUser, ((ParseQuery.State.Builder)((Map)paramObject).get("query")).build(), paramString)
    {
      protected boolean matches(T paramAnonymousT, List<T> paramAnonymousList)
      {
        paramAnonymousT = OfflineQueryLogic.getValue(paramAnonymousT, paramString);
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext()) {
          if (OfflineQueryLogic.matchesEqualConstraint(paramAnonymousT, OfflineQueryLogic.access$200((ParseObject)paramAnonymousList.next(), this.val$resultKey))) {
            return true;
          }
        }
        return false;
      }
    };
  }
  
  private static j<Void> fetchIncludeAsync(final OfflineStore paramOfflineStore, Object paramObject, final String paramString, final ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    final int i = 0;
    if (paramObject == null)
    {
      localObject = j.a(null);
      return (j<Void>)localObject;
    }
    if ((paramObject instanceof Collection))
    {
      localObject = (Collection)paramObject;
      paramObject = j.a(null);
      Iterator localIterator = ((Collection)localObject).iterator();
      for (;;)
      {
        localObject = paramObject;
        if (!localIterator.hasNext()) {
          break;
        }
        paramObject = ((j)paramObject).d(new h()
        {
          public j<Void> then(j<Void> paramAnonymousj)
          {
            return OfflineQueryLogic.fetchIncludeAsync(this.val$store, this.val$item, paramString, paramParseSQLiteDatabase);
          }
        });
      }
    }
    if ((paramObject instanceof JSONArray))
    {
      localObject = (JSONArray)paramObject;
      paramObject = j.a(null);
      while (i < ((JSONArray)localObject).length())
      {
        paramObject = ((j)paramObject).d(new h()
        {
          public j<Void> then(j<Void> paramAnonymousj)
          {
            return OfflineQueryLogic.fetchIncludeAsync(this.val$store, localObject.get(i), paramString, paramParseSQLiteDatabase);
          }
        });
        i += 1;
      }
      return (j<Void>)paramObject;
    }
    if (paramString == null)
    {
      if (JSONObject.NULL.equals(paramObject)) {
        return j.a(null);
      }
      if ((paramObject instanceof ParseObject)) {
        return paramOfflineStore.fetchLocallyAsync((ParseObject)paramObject, paramParseSQLiteDatabase).k();
      }
      return j.a(new ParseException(121, "include is invalid for non-ParseObjects"));
    }
    paramString = paramString.split("\\.", 2);
    final Object localObject = paramString[0];
    if (paramString.length > 1) {}
    for (paramString = paramString[1];; paramString = null) {
      j.a(null).b(new h()
      {
        public j<Object> then(j<Void> paramAnonymousj)
        {
          paramAnonymousj = null;
          if ((this.val$container instanceof ParseObject)) {
            paramAnonymousj = OfflineQueryLogic.fetchIncludeAsync(paramOfflineStore, this.val$container, null, paramParseSQLiteDatabase).c(new h()
            {
              public Object then(j<Void> paramAnonymous2j)
              {
                return ((ParseObject)OfflineQueryLogic.20.this.val$container).get(OfflineQueryLogic.20.this.val$key);
              }
            });
          }
          do
          {
            return paramAnonymousj;
            if ((this.val$container instanceof Map)) {
              return j.a(((Map)this.val$container).get(localObject));
            }
            if ((this.val$container instanceof JSONObject)) {
              return j.a(((JSONObject)this.val$container).opt(localObject));
            }
          } while (JSONObject.NULL.equals(this.val$container));
          return j.a(new IllegalStateException("include is invalid"));
        }
      }).d(new h()
      {
        public j<Void> then(j<Object> paramAnonymousj)
        {
          return OfflineQueryLogic.fetchIncludeAsync(this.val$store, paramAnonymousj.f(), paramString, paramParseSQLiteDatabase);
        }
      });
    }
  }
  
  static <T extends ParseObject> j<Void> fetchIncludesAsync(OfflineStore paramOfflineStore, final T paramT, ParseQuery.State<T> paramState, final ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    Object localObject = paramState.includes();
    paramState = j.a(null);
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramState = paramState.d(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          return OfflineQueryLogic.fetchIncludeAsync(this.val$store, paramT, this.val$include, paramParseSQLiteDatabase);
        }
      });
    }
    return paramState;
  }
  
  private static Object getValue(Object paramObject, String paramString)
  {
    return getValue(paramObject, paramString, 0);
  }
  
  private static Object getValue(Object paramObject, String paramString, int paramInt)
  {
    String[] arrayOfString = null;
    Object localObject = null;
    if (paramString.contains("."))
    {
      arrayOfString = paramString.split("\\.", 2);
      paramObject = getValue(paramObject, arrayOfString[0], paramInt + 1);
      if ((paramObject != null) && (paramObject != JSONObject.NULL) && (!(paramObject instanceof Map)) && (!(paramObject instanceof JSONObject)) && (paramInt <= 0)) {}
    }
    try
    {
      paramObject = PointerEncoder.get().encode(paramObject);
      if ((paramObject instanceof JSONObject)) {
        localObject = getValue(paramObject, arrayOfString[1], paramInt + 1);
      }
      do
      {
        do
        {
          return localObject;
          throw new ParseException(102, String.format("Key %s is invalid.", new Object[] { paramString }));
          return getValue(paramObject, arrayOfString[1], paramInt + 1);
          if ((paramObject instanceof ParseObject))
          {
            paramObject = (ParseObject)paramObject;
            if (!((ParseObject)paramObject).isDataAvailable()) {
              throw new ParseException(121, String.format("Bad key: %s", new Object[] { paramString }));
            }
            paramInt = -1;
            switch (paramString.hashCode())
            {
            }
            for (;;)
            {
              switch (paramInt)
              {
              default: 
                return ((ParseObject)paramObject).get(paramString);
                if (paramString.equals("objectId"))
                {
                  paramInt = 0;
                  continue;
                  if (paramString.equals("createdAt"))
                  {
                    paramInt = 1;
                    continue;
                    if (paramString.equals("_created_at"))
                    {
                      paramInt = 2;
                      continue;
                      if (paramString.equals("updatedAt"))
                      {
                        paramInt = 3;
                        continue;
                        if (paramString.equals("_updated_at")) {
                          paramInt = 4;
                        }
                      }
                    }
                  }
                }
                break;
              }
            }
            return ((ParseObject)paramObject).getObjectId();
            return ((ParseObject)paramObject).getCreatedAt();
            return ((ParseObject)paramObject).getUpdatedAt();
          }
          if ((paramObject instanceof JSONObject)) {
            return ((JSONObject)paramObject).opt(paramString);
          }
          if ((paramObject instanceof Map)) {
            return ((Map)paramObject).get(paramString);
          }
          localObject = arrayOfString;
        } while (paramObject == JSONObject.NULL);
        localObject = arrayOfString;
      } while (paramObject == null);
      throw new ParseException(121, String.format("Bad key: %s", new Object[] { paramString }));
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        paramObject = localObject;
      }
    }
  }
  
  static <T extends ParseObject> boolean hasReadAccess(ParseUser paramParseUser, T paramT)
  {
    if (paramParseUser == paramT) {}
    do
    {
      return true;
      paramT = paramT.getACL();
    } while ((paramT == null) || (paramT.getPublicReadAccess()) || ((paramParseUser != null) && (paramT.getReadAccess(paramParseUser))));
    return false;
  }
  
  static <T extends ParseObject> boolean hasWriteAccess(ParseUser paramParseUser, T paramT)
  {
    if (paramParseUser == paramT) {}
    do
    {
      return true;
      paramT = paramT.getACL();
    } while ((paramT == null) || (paramT.getPublicWriteAccess()) || ((paramParseUser != null) && (paramT.getWriteAccess(paramParseUser))));
    return false;
  }
  
  private static boolean matchesAllConstraint(Object paramObject1, Object paramObject2)
  {
    if ((paramObject2 == null) || (paramObject2 == JSONObject.NULL)) {
      return false;
    }
    if (!(paramObject2 instanceof Collection)) {
      throw new IllegalArgumentException("Value type not supported for $all queries.");
    }
    if ((paramObject1 instanceof Collection))
    {
      paramObject1 = ((Collection)paramObject1).iterator();
      while (((Iterator)paramObject1).hasNext()) {
        if (!matchesEqualConstraint(((Iterator)paramObject1).next(), paramObject2)) {
          return false;
        }
      }
      return true;
    }
    throw new IllegalArgumentException("Constraint type not supported for $all queries.");
  }
  
  private static boolean matchesEqualConstraint(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null)) {
      if (paramObject1 != paramObject2) {}
    }
    do
    {
      do
      {
        return true;
        return false;
        if ((!(paramObject1 instanceof Number)) || (!(paramObject2 instanceof Number))) {
          break;
        }
      } while (compareTo(paramObject1, paramObject2) == 0);
      return false;
      if ((!(paramObject1 instanceof ParseGeoPoint)) || (!(paramObject2 instanceof ParseGeoPoint))) {
        break;
      }
      paramObject1 = (ParseGeoPoint)paramObject1;
      paramObject2 = (ParseGeoPoint)paramObject2;
    } while ((((ParseGeoPoint)paramObject1).getLatitude() == ((ParseGeoPoint)paramObject2).getLatitude()) && (((ParseGeoPoint)paramObject1).getLongitude() == ((ParseGeoPoint)paramObject2).getLongitude()));
    return false;
    compare(paramObject1, paramObject2, new Decider()
    {
      public boolean decide(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        return paramAnonymousObject1.equals(paramAnonymousObject2);
      }
    });
  }
  
  private static boolean matchesExistsConstraint(Object paramObject1, Object paramObject2)
  {
    boolean bool = false;
    if ((paramObject1 != null) && (((Boolean)paramObject1).booleanValue())) {
      return (paramObject2 != null) && (paramObject2 != JSONObject.NULL);
    }
    if ((paramObject2 == null) || (paramObject2 == JSONObject.NULL)) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean matchesGreaterThanConstraint(Object paramObject1, Object paramObject2)
  {
    compare(paramObject1, paramObject2, new Decider()
    {
      public boolean decide(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        if ((paramAnonymousObject2 == null) || (paramAnonymousObject2 == JSONObject.NULL)) {}
        while (OfflineQueryLogic.compareTo(paramAnonymousObject1, paramAnonymousObject2) >= 0) {
          return false;
        }
        return true;
      }
    });
  }
  
  private static boolean matchesGreaterThanOrEqualToConstraint(Object paramObject1, Object paramObject2)
  {
    compare(paramObject1, paramObject2, new Decider()
    {
      public boolean decide(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        if ((paramAnonymousObject2 == null) || (paramAnonymousObject2 == JSONObject.NULL)) {}
        while (OfflineQueryLogic.compareTo(paramAnonymousObject1, paramAnonymousObject2) > 0) {
          return false;
        }
        return true;
      }
    });
  }
  
  private static boolean matchesInConstraint(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 instanceof Collection))
    {
      paramObject1 = ((Collection)paramObject1).iterator();
      while (((Iterator)paramObject1).hasNext()) {
        if (matchesEqualConstraint(((Iterator)paramObject1).next(), paramObject2)) {
          return true;
        }
      }
      return false;
    }
    throw new IllegalArgumentException("Constraint type not supported for $in queries.");
  }
  
  private static boolean matchesLessThanConstraint(Object paramObject1, Object paramObject2)
  {
    compare(paramObject1, paramObject2, new Decider()
    {
      public boolean decide(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        if ((paramAnonymousObject2 == null) || (paramAnonymousObject2 == JSONObject.NULL)) {}
        while (OfflineQueryLogic.compareTo(paramAnonymousObject1, paramAnonymousObject2) <= 0) {
          return false;
        }
        return true;
      }
    });
  }
  
  private static boolean matchesLessThanOrEqualToConstraint(Object paramObject1, Object paramObject2)
  {
    compare(paramObject1, paramObject2, new Decider()
    {
      public boolean decide(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        if ((paramAnonymousObject2 == null) || (paramAnonymousObject2 == JSONObject.NULL)) {}
        while (OfflineQueryLogic.compareTo(paramAnonymousObject1, paramAnonymousObject2) < 0) {
          return false;
        }
        return true;
      }
    });
  }
  
  private static boolean matchesNearSphereConstraint(Object paramObject1, Object paramObject2, Double paramDouble)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject2 == null) || (paramObject2 == JSONObject.NULL)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramDouble == null);
      bool1 = bool2;
    } while (((ParseGeoPoint)paramObject1).distanceInRadiansTo((ParseGeoPoint)paramObject2) <= paramDouble.doubleValue());
    return false;
  }
  
  private static boolean matchesNotEqualConstraint(Object paramObject1, Object paramObject2)
  {
    return !matchesEqualConstraint(paramObject1, paramObject2);
  }
  
  private static boolean matchesNotInConstraint(Object paramObject1, Object paramObject2)
  {
    return !matchesInConstraint(paramObject1, paramObject2);
  }
  
  private static boolean matchesRegexConstraint(Object paramObject1, Object paramObject2, String paramString)
  {
    int j = 0;
    if ((paramObject2 == null) || (paramObject2 == JSONObject.NULL)) {
      return false;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (!str.matches("^[imxs]*$")) {
      throw new ParseException(102, String.format("Invalid regex options: %s", new Object[] { str }));
    }
    if (str.contains("i")) {
      j = 2;
    }
    int i = j;
    if (str.contains("m")) {
      i = j | 0x8;
    }
    j = i;
    if (str.contains("x")) {
      j = i | 0x4;
    }
    i = j;
    if (str.contains("s")) {
      i = j | 0x20;
    }
    return Pattern.compile((String)paramObject1, i).matcher((String)paramObject2).find();
  }
  
  private static boolean matchesStatelessConstraint(String paramString, Object paramObject1, Object paramObject2, ParseQuery.KeyConstraints paramKeyConstraints)
  {
    boolean bool = true;
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new UnsupportedOperationException(String.format("The offline store does not yet support the %s operator.", new Object[] { paramString }));
        if (paramString.equals("$ne"))
        {
          i = 0;
          continue;
          if (paramString.equals("$lt"))
          {
            i = 1;
            continue;
            if (paramString.equals("$lte"))
            {
              i = 2;
              continue;
              if (paramString.equals("$gt"))
              {
                i = 3;
                continue;
                if (paramString.equals("$gte"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("$in"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("$nin"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("$all"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("$regex"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("$options"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("$exists"))
                            {
                              i = 10;
                              continue;
                              if (paramString.equals("$nearSphere"))
                              {
                                i = 11;
                                continue;
                                if (paramString.equals("$maxDistance"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString.equals("$within")) {
                                    i = 13;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    bool = matchesNotEqualConstraint(paramObject1, paramObject2);
    return bool;
    return matchesLessThanConstraint(paramObject1, paramObject2);
    return matchesLessThanOrEqualToConstraint(paramObject1, paramObject2);
    return matchesGreaterThanConstraint(paramObject1, paramObject2);
    return matchesGreaterThanOrEqualToConstraint(paramObject1, paramObject2);
    return matchesInConstraint(paramObject1, paramObject2);
    return matchesNotInConstraint(paramObject1, paramObject2);
    return matchesAllConstraint(paramObject1, paramObject2);
    return matchesRegexConstraint(paramObject1, paramObject2, (String)paramKeyConstraints.get("$options"));
    return matchesExistsConstraint(paramObject1, paramObject2);
    return matchesNearSphereConstraint(paramObject1, paramObject2, (Double)paramKeyConstraints.get("$maxDistance"));
    return matchesWithinConstraint(paramObject1, paramObject2);
  }
  
  private static boolean matchesWithinConstraint(Object paramObject1, Object paramObject2)
  {
    if ((paramObject2 == null) || (paramObject2 == JSONObject.NULL)) {
      return false;
    }
    Object localObject = (ArrayList)((HashMap)paramObject1).get("$box");
    paramObject1 = (ParseGeoPoint)((ArrayList)localObject).get(0);
    localObject = (ParseGeoPoint)((ArrayList)localObject).get(1);
    paramObject2 = (ParseGeoPoint)paramObject2;
    if (((ParseGeoPoint)localObject).getLongitude() < ((ParseGeoPoint)paramObject1).getLongitude()) {
      throw new ParseException(102, "whereWithinGeoBox queries cannot cross the International Date Line.");
    }
    if (((ParseGeoPoint)localObject).getLatitude() < ((ParseGeoPoint)paramObject1).getLatitude()) {
      throw new ParseException(102, "The southwest corner of a geo box must be south of the northeast corner.");
    }
    if (((ParseGeoPoint)localObject).getLongitude() - ((ParseGeoPoint)paramObject1).getLongitude() > 180.0D) {
      throw new ParseException(102, "Geo box queries larger than 180 degrees in longitude are not supported. Please check point order.");
    }
    return (((ParseGeoPoint)paramObject2).getLatitude() >= ((ParseGeoPoint)paramObject1).getLatitude()) && (((ParseGeoPoint)paramObject2).getLatitude() <= ((ParseGeoPoint)localObject).getLatitude()) && (((ParseGeoPoint)paramObject2).getLongitude() >= ((ParseGeoPoint)paramObject1).getLongitude()) && (((ParseGeoPoint)paramObject2).getLongitude() <= ((ParseGeoPoint)localObject).getLongitude());
  }
  
  static <T extends ParseObject> void sort(List<T> paramList, ParseQuery.State<T> paramState)
  {
    final ParseGeoPoint localParseGeoPoint = null;
    final List localList = paramState.order();
    Object localObject1 = paramState.order().iterator();
    String str;
    while (((Iterator)localObject1).hasNext())
    {
      str = (String)((Iterator)localObject1).next();
      if ((!str.matches("^-?[A-Za-z][A-Za-z0-9_]*$")) && (!"_created_at".equals(str)) && (!"_updated_at".equals(str))) {
        throw new ParseException(105, String.format("Invalid key name: \"%s\".", new Object[] { str }));
      }
    }
    Iterator localIterator = paramState.constraints().keySet().iterator();
    localObject1 = null;
    if (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      Object localObject2 = paramState.constraints().get(str);
      if (!(localObject2 instanceof ParseQuery.KeyConstraints)) {
        break label220;
      }
      localObject2 = (ParseQuery.KeyConstraints)localObject2;
      if (!((ParseQuery.KeyConstraints)localObject2).containsKey("$nearSphere")) {
        break label220;
      }
      localParseGeoPoint = (ParseGeoPoint)((ParseQuery.KeyConstraints)localObject2).get("$nearSphere");
      localObject1 = str;
    }
    label220:
    for (;;)
    {
      break;
      if ((localList.size() == 0) && (localObject1 == null)) {
        return;
      }
      Collections.sort(paramList, new Comparator()
      {
        public int compare(T paramAnonymousT1, T paramAnonymousT2)
        {
          Object localObject1;
          int j;
          if (this.val$nearSphereKey != null)
          {
            try
            {
              localObject1 = (ParseGeoPoint)OfflineQueryLogic.getValue(paramAnonymousT1, this.val$nearSphereKey);
              localObject2 = (ParseGeoPoint)OfflineQueryLogic.getValue(paramAnonymousT2, this.val$nearSphereKey);
              double d1 = ((ParseGeoPoint)localObject1).distanceInRadiansTo(localParseGeoPoint);
              double d2 = ((ParseGeoPoint)localObject2).distanceInRadiansTo(localParseGeoPoint);
              if (d1 == d2) {
                break label88;
              }
              if (d1 - d2 > 0.0D)
              {
                j = 1;
                return j;
              }
            }
            catch (ParseException paramAnonymousT1)
            {
              throw new RuntimeException(paramAnonymousT1);
            }
            return -1;
          }
          label88:
          Object localObject2 = localList.iterator();
          label99:
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = (String)((Iterator)localObject2).next();
            if (!((String)localObject1).startsWith("-")) {
              break label221;
            }
            localObject1 = ((String)localObject1).substring(1);
          }
          label221:
          for (int i = 1;; i = 0)
          {
            try
            {
              localObject3 = OfflineQueryLogic.getValue(paramAnonymousT1, (String)localObject1);
              localObject4 = OfflineQueryLogic.getValue(paramAnonymousT2, (String)localObject1);
            }
            catch (ParseException paramAnonymousT1)
            {
              try
              {
                Object localObject3;
                Object localObject4;
                int k = OfflineQueryLogic.compareTo(localObject3, localObject4);
                if (k == 0) {
                  break label99;
                }
                j = k;
                if (i == 0) {
                  break;
                }
                return -k;
              }
              catch (IllegalArgumentException paramAnonymousT1)
              {
                throw new IllegalArgumentException(String.format("Unable to sort by key %s.", new Object[] { localObject1 }), paramAnonymousT1);
              }
              paramAnonymousT1 = paramAnonymousT1;
              throw new RuntimeException(paramAnonymousT1);
            }
            return 0;
          }
        }
      });
      return;
    }
  }
  
  <T extends ParseObject> ConstraintMatcher<T> createMatcher(ParseQuery.State<T> paramState, ParseUser paramParseUser)
  {
    new ConstraintMatcher(paramParseUser, paramState.ignoreACLs())
    {
      public j<Boolean> matchesAsync(T paramAnonymousT, ParseSQLiteDatabase paramAnonymousParseSQLiteDatabase)
      {
        if ((!this.val$ignoreACLs) && (!OfflineQueryLogic.hasReadAccess(this.user, paramAnonymousT))) {
          return j.a(Boolean.valueOf(false));
        }
        return this.val$constraintMatcher.matchesAsync(paramAnonymousT, paramAnonymousParseSQLiteDatabase);
      }
    };
  }
  
  abstract class ConstraintMatcher<T extends ParseObject>
  {
    final ParseUser user;
    
    public ConstraintMatcher(ParseUser paramParseUser)
    {
      this.user = paramParseUser;
    }
    
    abstract j<Boolean> matchesAsync(T paramT, ParseSQLiteDatabase paramParseSQLiteDatabase);
  }
  
  private static abstract interface Decider
  {
    public abstract boolean decide(Object paramObject1, Object paramObject2);
  }
  
  private abstract class SubQueryMatcher<T extends ParseObject>
    extends OfflineQueryLogic.ConstraintMatcher<T>
  {
    private final ParseQuery.State<T> subQuery;
    private j<List<T>> subQueryResults = null;
    
    public SubQueryMatcher(ParseQuery.State<T> paramState)
    {
      super(paramState);
      ParseQuery.State localState;
      this.subQuery = localState;
    }
    
    protected abstract boolean matches(T paramT, List<T> paramList);
    
    public j<Boolean> matchesAsync(final T paramT, ParseSQLiteDatabase paramParseSQLiteDatabase)
    {
      if (this.subQueryResults == null) {
        this.subQueryResults = OfflineQueryLogic.this.store.findAsync(this.subQuery, this.user, null, paramParseSQLiteDatabase);
      }
      this.subQueryResults.c(new h()
      {
        public Boolean then(j<List<T>> paramAnonymousj)
        {
          return Boolean.valueOf(OfflineQueryLogic.SubQueryMatcher.this.matches(paramT, (List)paramAnonymousj.f()));
        }
      });
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/OfflineQueryLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */