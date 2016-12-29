package com.parse;

import a.h;
import a.j;
import java.util.Arrays;
import java.util.Map;

class CachedCurrentUserController
  implements ParseCurrentUserController
{
  ParseUser currentUser;
  boolean currentUserMatchesDisk = false;
  private final Object mutex = new Object();
  private final ParseObjectStore<ParseUser> store;
  private final TaskQueue taskQueue = new TaskQueue();
  
  public CachedCurrentUserController(ParseObjectStore<ParseUser> paramParseObjectStore)
  {
    this.store = paramParseObjectStore;
  }
  
  private ParseUser lazyLogIn()
  {
    return lazyLogIn("anonymous", ParseAnonymousUtils.getAuthData());
  }
  
  public void clearFromDisk()
  {
    synchronized (this.mutex)
    {
      this.currentUser = null;
      this.currentUserMatchesDisk = false;
    }
  }
  
  public void clearFromMemory()
  {
    synchronized (this.mutex)
    {
      this.currentUser = null;
      this.currentUserMatchesDisk = false;
      return;
    }
  }
  
  public j<Boolean> existsAsync()
  {
    synchronized (this.mutex)
    {
      if (this.currentUser != null)
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
              return CachedCurrentUserController.this.store.existsAsync();
            }
          });
        }
      });
    }
  }
  
  public j<ParseUser> getAsync()
  {
    return getAsync(ParseUser.isAutomaticUserEnabled());
  }
  
  public j<ParseUser> getAsync(final boolean paramBoolean)
  {
    synchronized (this.mutex)
    {
      if (this.currentUser != null)
      {
        j localj = j.a(this.currentUser);
        return localj;
      }
      this.taskQueue.enqueue(new h()
      {
        public j<ParseUser> then(j<Void> paramAnonymousj)
        {
          paramAnonymousj.b(new h()
          {
            public j<ParseUser> then(j<Void> arg1)
            {
              boolean bool;
              synchronized (CachedCurrentUserController.this.mutex)
              {
                ParseUser localParseUser = CachedCurrentUserController.this.currentUser;
                bool = CachedCurrentUserController.this.currentUserMatchesDisk;
                if (localParseUser != null) {
                  return j.a(localParseUser);
                }
              }
              if (bool)
              {
                if (CachedCurrentUserController.5.this.val$shouldAutoCreateUser) {
                  return j.a(CachedCurrentUserController.this.lazyLogIn());
                }
                return null;
              }
              CachedCurrentUserController.this.store.getAsync().a(new h()
              {
                public ParseUser then(j<ParseUser> arg1)
                {
                  boolean bool = true;
                  ParseUser localParseUser = (ParseUser)???.f();
                  if (!???.e()) {}
                  for (;;)
                  {
                    synchronized (CachedCurrentUserController.this.mutex)
                    {
                      CachedCurrentUserController.this.currentUser = localParseUser;
                      CachedCurrentUserController.this.currentUserMatchesDisk = bool;
                      if (localParseUser == null) {
                        break;
                      }
                    }
                    synchronized (localParseUser.mutex)
                    {
                      localParseUser.setIsCurrentUser(true);
                      return localParseUser;
                      bool = false;
                      continue;
                      localObject1 = finally;
                      throw ((Throwable)localObject1);
                    }
                  }
                  if (CachedCurrentUserController.5.this.val$shouldAutoCreateUser) {
                    return CachedCurrentUserController.this.lazyLogIn();
                  }
                  return null;
                }
              });
            }
          });
        }
      });
    }
  }
  
  public j<String> getCurrentSessionTokenAsync()
  {
    getAsync(false).c(new h()
    {
      public String then(j<ParseUser> paramAnonymousj)
      {
        paramAnonymousj = (ParseUser)paramAnonymousj.f();
        if (paramAnonymousj != null) {
          return paramAnonymousj.getSessionToken();
        }
        return null;
      }
    });
  }
  
  public boolean isCurrent(ParseUser paramParseUser)
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        if (this.currentUser == paramParseUser)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  ParseUser lazyLogIn(String arg1, Map<String, String> paramMap)
  {
    ParseUser localParseUser = (ParseUser)ParseObject.create(ParseUser.class);
    synchronized (localParseUser.mutex)
    {
      localParseUser.setIsCurrentUser(true);
      localParseUser.putAuthData(???, paramMap);
    }
    synchronized (this.mutex)
    {
      this.currentUserMatchesDisk = false;
      this.currentUser = localParseUser;
      return localParseUser;
      ??? = finally;
      throw ???;
    }
  }
  
  public j<Void> logOutAsync()
  {
    this.taskQueue.enqueue(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        final j localj = CachedCurrentUserController.this.getAsync(false);
        j.a(Arrays.asList(new j[] { localj, paramAnonymousj })).b(new h()
        {
          public j<Void> then(j<Void> paramAnonymous2j)
          {
            j.a(Arrays.asList(new j[] { localj.d(new h()
            {
              public j<Void> then(j<ParseUser> paramAnonymous3j)
              {
                ParseUser localParseUser = (ParseUser)paramAnonymous3j.f();
                if (localParseUser == null) {
                  return paramAnonymous3j.j();
                }
                return localParseUser.logOutAsync();
              }
            }), CachedCurrentUserController.this.store.deleteAsync().a(new h()
            {
              public Void then(j<Void> arg1)
              {
                if (!???.e()) {}
                for (boolean bool = true;; bool = false) {
                  synchronized (CachedCurrentUserController.this.mutex)
                  {
                    CachedCurrentUserController.this.currentUserMatchesDisk = bool;
                    CachedCurrentUserController.this.currentUser = null;
                    return null;
                  }
                }
              }
            }) }));
          }
        });
      }
    });
  }
  
  public j<Void> setAsync(final ParseUser paramParseUser)
  {
    this.taskQueue.enqueue(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        paramAnonymousj.b(new h()
        {
          public j<Void> then(j<Void> paramAnonymous2j)
          {
            synchronized (CachedCurrentUserController.this.mutex)
            {
              ParseUser localParseUser = CachedCurrentUserController.this.currentUser;
              ??? = paramAnonymous2j;
              if (localParseUser != null)
              {
                ??? = paramAnonymous2j;
                if (localParseUser != CachedCurrentUserController.1.this.val$user) {
                  ??? = localParseUser.logOutAsync(false).a(new h()
                  {
                    public Void then(j<Void> paramAnonymous3j)
                    {
                      return null;
                    }
                  });
                }
              }
              return (j<Void>)???;
            }
          }
        }).d(new h()
        {
          public j<Void> then(j<Void> paramAnonymous2j)
          {
            CachedCurrentUserController.1.this.val$user.setIsCurrentUser(true);
            return CachedCurrentUserController.1.this.val$user.synchronizeAllAuthDataAsync();
          }
        }).d(new h()
        {
          public j<Void> then(j<Void> paramAnonymous2j)
          {
            CachedCurrentUserController.this.store.setAsync(CachedCurrentUserController.1.this.val$user).a(new h()
            {
              public Void then(j<Void> paramAnonymous3j)
              {
                for (;;)
                {
                  synchronized (CachedCurrentUserController.this.mutex)
                  {
                    CachedCurrentUserController localCachedCurrentUserController = CachedCurrentUserController.this;
                    if (!paramAnonymous3j.e())
                    {
                      bool = true;
                      localCachedCurrentUserController.currentUserMatchesDisk = bool;
                      CachedCurrentUserController.this.currentUser = CachedCurrentUserController.1.this.val$user;
                      return null;
                    }
                  }
                  boolean bool = false;
                }
              }
            });
          }
        });
      }
    });
  }
  
  public j<Void> setIfNeededAsync(ParseUser paramParseUser)
  {
    synchronized (this.mutex)
    {
      if ((!paramParseUser.isCurrentUser()) || (this.currentUserMatchesDisk))
      {
        paramParseUser = j.a(null);
        return paramParseUser;
      }
      return setAsync(paramParseUser);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/CachedCurrentUserController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */