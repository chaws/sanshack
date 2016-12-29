package com.parse;

import a.h;
import a.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class NetworkQueryController
  extends AbstractQueryController
{
  private static final String TAG = "NetworkQueryController";
  private final ParseHttpClient restClient;
  
  public NetworkQueryController(ParseHttpClient paramParseHttpClient)
  {
    this.restClient = paramParseHttpClient;
  }
  
  <T extends ParseObject> List<T> convertFindResponse(ParseQuery.State<T> paramState, JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    JSONArray localJSONArray = paramJSONObject.getJSONArray("results");
    if (localJSONArray == null)
    {
      PLog.d("NetworkQueryController", "null results in find response");
      return localArrayList;
    }
    paramJSONObject = paramJSONObject.optString("className", null);
    if (paramJSONObject == null) {
      paramJSONObject = paramState.className();
    }
    for (;;)
    {
      int i = 0;
      label50:
      Object localObject;
      if (i < localJSONArray.length())
      {
        localObject = localJSONArray.getJSONObject(i);
        if (paramState.selectedKeys() != null) {
          break label134;
        }
      }
      label134:
      for (boolean bool = true;; bool = false)
      {
        localObject = ParseObject.fromJSON((JSONObject)localObject, paramJSONObject, bool);
        localArrayList.add(localObject);
        ParseQuery.RelationConstraint localRelationConstraint = (ParseQuery.RelationConstraint)paramState.constraints().get("$relatedTo");
        if (localRelationConstraint != null) {
          localRelationConstraint.getRelation().addKnownObject((ParseObject)localObject);
        }
        i += 1;
        break label50;
        break;
      }
    }
  }
  
  public <T extends ParseObject> j<Integer> countAsync(ParseQuery.State<T> paramState, ParseUser paramParseUser, j<Void> paramj)
  {
    if (paramParseUser != null) {}
    for (paramParseUser = paramParseUser.getSessionToken();; paramParseUser = null) {
      return countAsync(paramState, paramParseUser, true, paramj);
    }
  }
  
  <T extends ParseObject> j<Integer> countAsync(final ParseQuery.State<T> paramState, final String paramString, boolean paramBoolean, j<Void> paramj)
  {
    paramString = ParseRESTQueryCommand.countCommand(paramState, paramString);
    if (paramBoolean) {
      paramString.enableRetrying();
    }
    paramString.executeAsync(this.restClient, paramj).d(new h()
    {
      public j<JSONObject> then(j<JSONObject> paramAnonymousj)
      {
        Object localObject = paramState.cachePolicy();
        if ((localObject != null) && (localObject != ParseQuery.CachePolicy.IGNORE_CACHE))
        {
          localObject = (JSONObject)paramAnonymousj.f();
          ParseKeyValueCache.saveToKeyValueCache(paramString.getCacheKey(), ((JSONObject)localObject).toString());
        }
        return paramAnonymousj;
      }
    }, j.a).c(new h()
    {
      public Integer then(j<JSONObject> paramAnonymousj)
      {
        return Integer.valueOf(((JSONObject)paramAnonymousj.f()).optInt("count"));
      }
    });
  }
  
  public <T extends ParseObject> j<List<T>> findAsync(ParseQuery.State<T> paramState, ParseUser paramParseUser, j<Void> paramj)
  {
    if (paramParseUser != null) {}
    for (paramParseUser = paramParseUser.getSessionToken();; paramParseUser = null) {
      return findAsync(paramState, paramParseUser, true, paramj);
    }
  }
  
  <T extends ParseObject> j<List<T>> findAsync(final ParseQuery.State<T> paramState, final String paramString, boolean paramBoolean, j<Void> paramj)
  {
    long l1 = System.nanoTime();
    paramString = ParseRESTQueryCommand.findCommand(paramState, paramString);
    if (paramBoolean) {
      paramString.enableRetrying();
    }
    final long l2 = System.nanoTime();
    paramString.executeAsync(this.restClient, paramj).c(new h()
    {
      public List<T> then(j<JSONObject> paramAnonymousj)
      {
        Object localObject = (JSONObject)paramAnonymousj.f();
        ParseQuery.CachePolicy localCachePolicy = paramState.cachePolicy();
        if ((localCachePolicy != null) && (localCachePolicy != ParseQuery.CachePolicy.IGNORE_CACHE)) {
          ParseKeyValueCache.saveToKeyValueCache(paramString.getCacheKey(), ((JSONObject)localObject).toString());
        }
        long l1 = System.nanoTime();
        paramAnonymousj = NetworkQueryController.this.convertFindResponse(paramState, (JSONObject)paramAnonymousj.f());
        long l2 = System.nanoTime();
        if (((JSONObject)localObject).has("trace"))
        {
          localObject = ((JSONObject)localObject).get("trace");
          PLog.d("ParseQuery", String.format("Query pre-processing took %f seconds\n%s\nClient side parsing took %f seconds\n", new Object[] { Float.valueOf((float)(l2 - this.val$queryStart) / 1000000.0F), localObject, Float.valueOf((float)(l2 - l1) / 1000000.0F) }));
        }
        return paramAnonymousj;
      }
    }, j.a);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/NetworkQueryController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */