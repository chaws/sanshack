package com.parse;

import a.h;
import a.j;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

class CacheQueryController
  extends AbstractQueryController
{
  private final NetworkQueryController networkController;
  
  public CacheQueryController(NetworkQueryController paramNetworkQueryController)
  {
    this.networkController = paramNetworkQueryController;
  }
  
  private <T extends ParseObject> j<Integer> countFromCacheAsync(final ParseQuery.State<T> paramState, String paramString)
  {
    j.a(new Callable()
    {
      public Integer call()
      {
        JSONObject localJSONObject = ParseKeyValueCache.jsonFromKeyValueCache(this.val$cacheKey, paramState.maxCacheAge());
        if (localJSONObject == null) {
          throw new ParseException(120, "results not cached");
        }
        try
        {
          int i = localJSONObject.getInt("count");
          return Integer.valueOf(i);
        }
        catch (JSONException localJSONException)
        {
          throw new ParseException(120, "the cache contains corrupted json");
        }
      }
    }, j.a);
  }
  
  private <T extends ParseObject> j<List<T>> findFromCacheAsync(final ParseQuery.State<T> paramState, String paramString)
  {
    j.a(new Callable()
    {
      public List<T> call()
      {
        Object localObject = ParseKeyValueCache.jsonFromKeyValueCache(this.val$cacheKey, paramState.maxCacheAge());
        if (localObject == null) {
          throw new ParseException(120, "results not cached");
        }
        try
        {
          localObject = CacheQueryController.this.networkController.convertFindResponse(paramState, (JSONObject)localObject);
          return (List<T>)localObject;
        }
        catch (JSONException localJSONException)
        {
          throw new ParseException(120, "the cache contains corrupted json");
        }
      }
    }, j.a);
  }
  
  private <TResult> j<TResult> runCommandWithPolicyAsync(final CommandDelegate<TResult> paramCommandDelegate, ParseQuery.CachePolicy paramCachePolicy)
  {
    switch (paramCachePolicy)
    {
    default: 
      throw new RuntimeException("Unknown cache policy: " + paramCachePolicy);
    case ???: 
    case ???: 
      return paramCommandDelegate.runOnNetworkAsync(true);
    case ???: 
      return paramCommandDelegate.runFromCacheAsync();
    case ???: 
      paramCommandDelegate.runFromCacheAsync().b(new h()
      {
        public j<TResult> then(j<TResult> paramAnonymousj)
        {
          Object localObject = paramAnonymousj;
          if ((paramAnonymousj.g() instanceof ParseException)) {
            localObject = paramCommandDelegate.runOnNetworkAsync(true);
          }
          return (j<TResult>)localObject;
        }
      });
    case ???: 
      paramCommandDelegate.runOnNetworkAsync(false).b(new h()
      {
        public j<TResult> then(j<TResult> paramAnonymousj)
        {
          Exception localException = paramAnonymousj.g();
          Object localObject = paramAnonymousj;
          if ((localException instanceof ParseException))
          {
            localObject = paramAnonymousj;
            if (((ParseException)localException).getCode() == 100) {
              localObject = paramCommandDelegate.runFromCacheAsync();
            }
          }
          return (j<TResult>)localObject;
        }
      });
    }
    throw new RuntimeException("You cannot use the cache policy CACHE_THEN_NETWORK with find()");
  }
  
  public <T extends ParseObject> j<Integer> countAsync(final ParseQuery.State<T> paramState, final ParseUser paramParseUser, final j<Void> paramj)
  {
    if (paramParseUser != null) {}
    for (paramParseUser = paramParseUser.getSessionToken();; paramParseUser = null) {
      runCommandWithPolicyAsync(new CommandDelegate()
      {
        public j<Integer> runFromCacheAsync()
        {
          return CacheQueryController.this.countFromCacheAsync(paramState, paramParseUser);
        }
        
        public j<Integer> runOnNetworkAsync(boolean paramAnonymousBoolean)
        {
          return CacheQueryController.this.networkController.countAsync(paramState, paramParseUser, paramAnonymousBoolean, paramj);
        }
      }, paramState.cachePolicy());
    }
  }
  
  public <T extends ParseObject> j<List<T>> findAsync(final ParseQuery.State<T> paramState, final ParseUser paramParseUser, final j<Void> paramj)
  {
    if (paramParseUser != null) {}
    for (paramParseUser = paramParseUser.getSessionToken();; paramParseUser = null) {
      runCommandWithPolicyAsync(new CommandDelegate()
      {
        public j<List<T>> runFromCacheAsync()
        {
          return CacheQueryController.this.findFromCacheAsync(paramState, paramParseUser);
        }
        
        public j<List<T>> runOnNetworkAsync(boolean paramAnonymousBoolean)
        {
          return CacheQueryController.this.networkController.findAsync(paramState, paramParseUser, paramAnonymousBoolean, paramj);
        }
      }, paramState.cachePolicy());
    }
  }
  
  private static abstract interface CommandDelegate<T>
  {
    public abstract j<T> runFromCacheAsync();
    
    public abstract j<T> runOnNetworkAsync(boolean paramBoolean);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/CacheQueryController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */