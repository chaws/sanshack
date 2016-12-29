package com.parse;

import a.h;
import a.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

@ParseClassName("_User")
public class ParseUser
  extends ParseObject
{
  private static final String KEY_AUTH_DATA = "authData";
  private static final String KEY_EMAIL = "email";
  private static final String KEY_PASSWORD = "password";
  private static final String KEY_SESSION_TOKEN = "sessionToken";
  private static final String KEY_USERNAME = "username";
  private static final List<String> READ_ONLY_KEYS = Collections.unmodifiableList(Arrays.asList(new String[] { "sessionToken", "authData" }));
  private static boolean autoUserEnabled;
  private static final Object isAutoUserEnabledMutex = new Object();
  private boolean isCurrentUser = false;
  
  public static ParseUser become(String paramString)
  {
    return (ParseUser)ParseTaskUtils.wait(becomeInBackground(paramString));
  }
  
  public static j<ParseUser> becomeInBackground(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Must specify a sessionToken for the user to log in with");
    }
    getUserController().getUserAsync(paramString).d(new h()
    {
      public j<ParseUser> then(final j<ParseUser.State> paramAnonymousj)
      {
        paramAnonymousj = (ParseUser)ParseObject.from((ParseUser.State)paramAnonymousj.f());
        ParseUser.saveCurrentUserAsync(paramAnonymousj).c(new h()
        {
          public ParseUser then(j<Void> paramAnonymous2j)
          {
            return paramAnonymousj;
          }
        });
      }
    });
  }
  
  public static void becomeInBackground(String paramString, LogInCallback paramLogInCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(becomeInBackground(paramString), paramLogInCallback);
  }
  
  static void disableAutomaticUser()
  {
    synchronized (isAutoUserEnabledMutex)
    {
      autoUserEnabled = false;
      return;
    }
  }
  
  public static void enableAutomaticUser()
  {
    synchronized (isAutoUserEnabledMutex)
    {
      autoUserEnabled = true;
      return;
    }
  }
  
  public static j<Void> enableRevocableSessionInBackground()
  {
    ParseCorePlugins.getInstance().registerUserController(new NetworkUserController(ParsePlugins.get().restClient(), true));
    getCurrentUserController().getAsync(false).d(new h()
    {
      public j<Void> then(j<ParseUser> paramAnonymousj)
      {
        paramAnonymousj = (ParseUser)paramAnonymousj.f();
        if (paramAnonymousj == null) {
          return j.a(null);
        }
        return paramAnonymousj.upgradeToRevocableSessionAsync();
      }
    });
  }
  
  private Map<String, String> getAuthData(String paramString)
  {
    return (Map)getAuthData().get(paramString);
  }
  
  static ParseAuthenticationManager getAuthenticationManager()
  {
    return ParseCorePlugins.getInstance().getAuthenticationManager();
  }
  
  static String getCurrentSessionToken()
  {
    ParseUser localParseUser = getCurrentUser();
    if (localParseUser != null) {
      return localParseUser.getSessionToken();
    }
    return null;
  }
  
  static j<String> getCurrentSessionTokenAsync()
  {
    return getCurrentUserController().getCurrentSessionTokenAsync();
  }
  
  public static ParseUser getCurrentUser()
  {
    return getCurrentUser(isAutomaticUserEnabled());
  }
  
  private static ParseUser getCurrentUser(boolean paramBoolean)
  {
    try
    {
      ParseUser localParseUser = (ParseUser)ParseTaskUtils.wait(getCurrentUserController().getAsync(paramBoolean));
      return localParseUser;
    }
    catch (ParseException localParseException) {}
    return null;
  }
  
  static j<ParseUser> getCurrentUserAsync()
  {
    return getCurrentUserController().getAsync();
  }
  
  static ParseCurrentUserController getCurrentUserController()
  {
    return ParseCorePlugins.getInstance().getCurrentUserController();
  }
  
  public static ParseQuery<ParseUser> getQuery()
  {
    return ParseQuery.getQuery(ParseUser.class);
  }
  
  static ParseUserController getUserController()
  {
    return ParseCorePlugins.getInstance().getUserController();
  }
  
  static boolean isAutomaticUserEnabled()
  {
    synchronized (isAutoUserEnabledMutex)
    {
      boolean bool = autoUserEnabled;
      return bool;
    }
  }
  
  private j<Void> linkWithAsync(final String paramString1, Map<String, String> paramMap, j<Void> paramj, String paramString2)
  {
    synchronized (this.mutex)
    {
      boolean bool = isLazy();
      final Map localMap = getAuthData("anonymous");
      stripAnonymity();
      putAuthData(paramString1, paramMap);
      paramString1 = saveAsync(paramString2, bool, paramj).b(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          synchronized (ParseUser.this.mutex)
          {
            if ((paramAnonymousj.e()) || (paramAnonymousj.d()))
            {
              ParseUser.this.restoreAnonymity(localMap);
              return paramAnonymousj;
            }
            paramAnonymousj = ParseUser.this.synchronizeAuthDataAsync(paramString1);
            return paramAnonymousj;
          }
        }
      });
      return paramString1;
    }
  }
  
  private j<Void> linkWithAsync(final String paramString1, final Map<String, String> paramMap, final String paramString2)
  {
    this.taskQueue.enqueue(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        return ParseUser.this.linkWithAsync(paramString1, paramMap, paramAnonymousj, paramString2);
      }
    });
  }
  
  public static ParseUser logIn(String paramString1, String paramString2)
  {
    return (ParseUser)ParseTaskUtils.wait(logInInBackground(paramString1, paramString2));
  }
  
  public static j<ParseUser> logInInBackground(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Must specify a username for the user to log in with");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("Must specify a password for the user to log in with");
    }
    getUserController().logInAsync(paramString1, paramString2).d(new h()
    {
      public j<ParseUser> then(final j<ParseUser.State> paramAnonymousj)
      {
        paramAnonymousj = (ParseUser)ParseObject.from((ParseUser.State)paramAnonymousj.f());
        ParseUser.saveCurrentUserAsync(paramAnonymousj).c(new h()
        {
          public ParseUser then(j<Void> paramAnonymous2j)
          {
            return paramAnonymousj;
          }
        });
      }
    });
  }
  
  public static void logInInBackground(String paramString1, String paramString2, LogInCallback paramLogInCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(logInInBackground(paramString1, paramString2), paramLogInCallback);
  }
  
  public static j<ParseUser> logInWithInBackground(String paramString, final Map<String, String> paramMap)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Invalid authType: " + null);
    }
    final h local11 = new h()
    {
      public j<ParseUser> then(j<Void> paramAnonymousj)
      {
        ParseUser.getUserController().logInAsync(this.val$authType, paramMap).d(new h()
        {
          public j<ParseUser> then(final j<ParseUser.State> paramAnonymous2j)
          {
            paramAnonymous2j = (ParseUser)ParseObject.from((ParseUser.State)paramAnonymous2j.f());
            ParseUser.saveCurrentUserAsync(paramAnonymous2j).c(new h()
            {
              public ParseUser then(j<Void> paramAnonymous3j)
              {
                return paramAnonymous2j;
              }
            });
          }
        });
      }
    };
    getCurrentUserController().getAsync(false).d(new h()
    {
      public j<ParseUser> then(j<ParseUser> arg1)
      {
        final Object localObject1 = (ParseUser)???.f();
        if (localObject1 != null) {
          synchronized (((ParseUser)localObject1).mutex)
          {
            if (ParseAnonymousUtils.isLinked((ParseUser)localObject1))
            {
              if (((ParseUser)localObject1).isLazy())
              {
                final Map localMap = ((ParseUser)localObject1).getAuthData("anonymous");
                localObject1 = ((ParseUser)localObject1).taskQueue.enqueue(new h()
                {
                  public j<ParseUser> then(j<Void> paramAnonymous2j)
                  {
                    paramAnonymous2j.b(new h()
                    {
                      public j<Void> then(j<Void> paramAnonymous3j)
                      {
                        synchronized (ParseUser.12.1.this.val$user.mutex)
                        {
                          ParseUser.12.1.this.val$user.stripAnonymity();
                          ParseUser.12.1.this.val$user.putAuthData(ParseUser.12.this.val$authType, ParseUser.12.this.val$authData);
                          paramAnonymous3j = ParseUser.12.1.this.val$user.resolveLazinessAsync(paramAnonymous3j);
                          return paramAnonymous3j;
                        }
                      }
                    }).b(new h()
                    {
                      public j<ParseUser> then(j<Void> paramAnonymous3j)
                      {
                        synchronized (ParseUser.12.1.this.val$user.mutex)
                        {
                          if (paramAnonymous3j.e())
                          {
                            ParseUser.12.1.this.val$user.removeAuthData(ParseUser.12.this.val$authType);
                            ParseUser.12.1.this.val$user.restoreAnonymity(ParseUser.12.1.this.val$oldAnonymousData);
                            paramAnonymous3j = j.a(paramAnonymous3j.g());
                            return paramAnonymous3j;
                          }
                          if (paramAnonymous3j.d())
                          {
                            paramAnonymous3j = j.i();
                            return paramAnonymous3j;
                          }
                        }
                        paramAnonymous3j = j.a(ParseUser.12.1.this.val$user);
                        return paramAnonymous3j;
                      }
                    });
                  }
                });
                return (j<ParseUser>)localObject1;
              }
              localObject1 = ((ParseUser)localObject1).linkWithInBackground(this.val$authType, paramMap).b(new h()
              {
                public j<ParseUser> then(j<Void> paramAnonymous2j)
                {
                  if (paramAnonymous2j.e())
                  {
                    Exception localException = paramAnonymous2j.g();
                    if (((localException instanceof ParseException)) && (((ParseException)localException).getCode() == 208)) {
                      return j.a(null).b(ParseUser.12.this.val$logInWithTask);
                    }
                  }
                  if (paramAnonymous2j.d()) {
                    return j.i();
                  }
                  return j.a(localObject1);
                }
              });
              return (j<ParseUser>)localObject1;
            }
          }
        }
        return j.a(null).b(local11);
      }
    });
  }
  
  public static void logOut()
  {
    try
    {
      ParseTaskUtils.wait(logOutInBackground());
      return;
    }
    catch (ParseException localParseException) {}
  }
  
  public static j<Void> logOutInBackground()
  {
    return getCurrentUserController().logOutAsync();
  }
  
  public static void logOutInBackground(LogOutCallback paramLogOutCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(logOutInBackground(), paramLogOutCallback);
  }
  
  static j<Void> pinCurrentUserIfNeededAsync(ParseUser paramParseUser)
  {
    if (!Parse.isLocalDatastoreEnabled()) {
      throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
    }
    return getCurrentUserController().setIfNeededAsync(paramParseUser);
  }
  
  public static void registerAuthenticationCallback(String paramString, AuthenticationCallback paramAuthenticationCallback)
  {
    getAuthenticationManager().register(paramString, paramAuthenticationCallback);
  }
  
  private void removeAuthData(String paramString)
  {
    synchronized (this.mutex)
    {
      Map localMap = getAuthData();
      localMap.remove(paramString);
      performPut("authData", localMap);
      return;
    }
  }
  
  public static void requestPasswordReset(String paramString)
  {
    ParseTaskUtils.wait(requestPasswordResetInBackground(paramString));
  }
  
  public static j<Void> requestPasswordResetInBackground(String paramString)
  {
    return getUserController().requestPasswordResetAsync(paramString);
  }
  
  public static void requestPasswordResetInBackground(String paramString, RequestPasswordResetCallback paramRequestPasswordResetCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(requestPasswordResetInBackground(paramString), paramRequestPasswordResetCallback);
  }
  
  private void restoreAnonymity(Map<String, String> paramMap)
  {
    Object localObject = this.mutex;
    if (paramMap != null) {}
    try
    {
      putAuthData("anonymous", paramMap);
      return;
    }
    finally {}
  }
  
  private static j<Void> saveCurrentUserAsync(ParseUser paramParseUser)
  {
    return getCurrentUserController().setAsync(paramParseUser);
  }
  
  private j<Void> setSessionTokenInBackground(String paramString)
  {
    synchronized (this.mutex)
    {
      State localState = getState();
      if (paramString.equals(localState.sessionToken()))
      {
        paramString = j.a(null);
        return paramString;
      }
      setState(localState.newBuilder().sessionToken(paramString).build());
      paramString = saveCurrentUserAsync(this);
      return paramString;
    }
  }
  
  private void stripAnonymity()
  {
    synchronized (this.mutex)
    {
      if (ParseAnonymousUtils.isLinked(this))
      {
        if (getObjectId() != null) {
          putAuthData("anonymous", null);
        }
      }
      else {
        return;
      }
      removeAuthData("anonymous");
    }
  }
  
  private j<Void> synchronizeAuthDataAsync(ParseAuthenticationManager paramParseAuthenticationManager, final String paramString, Map<String, String> paramMap)
  {
    paramParseAuthenticationManager.restoreAuthenticationAsync(paramString, paramMap).b(new h()
    {
      public j<Void> then(j<Boolean> paramAnonymousj)
      {
        if ((!paramAnonymousj.e()) && (((Boolean)paramAnonymousj.f()).booleanValue())) {}
        for (int i = 1; i == 0; i = 0) {
          return ParseUser.this.unlinkFromInBackground(paramString);
        }
        return paramAnonymousj.k();
      }
    });
  }
  
  private j<Void> upgradeToRevocableSessionAsync(j<Void> paramj)
  {
    paramj.b(new h()
    {
      public j<String> then(j<Void> paramAnonymousj)
      {
        return ParseSession.upgradeToRevocableSessionAsync(this.val$sessionToken);
      }
    }).d(new h()
    {
      public j<Void> then(j<String> paramAnonymousj)
      {
        paramAnonymousj = (String)paramAnonymousj.f();
        return ParseUser.this.setSessionTokenInBackground(paramAnonymousj);
      }
    });
  }
  
  j<Void> cleanUpAuthDataAsync()
  {
    Object localObject1 = getAuthenticationManager();
    Map localMap;
    synchronized (this.mutex)
    {
      localMap = getState().authData();
      if (localMap.size() == 0)
      {
        localObject1 = j.a(null);
        return (j<Void>)localObject1;
      }
      ??? = new ArrayList();
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() == null)
        {
          localIterator.remove();
          ((List)???).add(((ParseAuthenticationManager)localObject1).restoreAuthenticationAsync((String)localEntry.getKey(), null).k());
        }
      }
    }
    setState(getState().newBuilder().authData(localMap).build());
    return j.a((Collection)???);
  }
  
  public ParseUser fetch()
  {
    return (ParseUser)super.fetch();
  }
  
  <T extends ParseObject> j<T> fetchAsync(String paramString, j<Void> paramj)
  {
    if (isLazy()) {
      paramString = j.a(this);
    }
    do
    {
      return paramString;
      paramj = super.fetchAsync(paramString, paramj);
      paramString = paramj;
    } while (!isCurrentUser());
    paramj.d(new h()
    {
      public j<Void> then(j<T> paramAnonymousj)
      {
        return ParseUser.this.cleanUpAuthDataAsync();
      }
    }).d(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        return ParseUser.saveCurrentUserAsync(ParseUser.this);
      }
    }).c(new h()
    {
      public T then(j<Void> paramAnonymousj)
      {
        return ParseUser.this;
      }
    });
  }
  
  <T extends ParseObject> j<T> fetchFromLocalDatastoreAsync()
  {
    if (isLazy()) {
      return j.a(this);
    }
    return super.fetchFromLocalDatastoreAsync();
  }
  
  public ParseUser fetchIfNeeded()
  {
    return (ParseUser)super.fetchIfNeeded();
  }
  
  Map<String, Map<String, String>> getAuthData()
  {
    synchronized (this.mutex)
    {
      Map localMap = getMap("authData");
      Object localObject1 = localMap;
      if (localMap == null) {
        localObject1 = new HashMap();
      }
      return (Map<String, Map<String, String>>)localObject1;
    }
  }
  
  public String getEmail()
  {
    return getString("email");
  }
  
  String getPassword()
  {
    return getString("password");
  }
  
  public String getSessionToken()
  {
    return getState().sessionToken();
  }
  
  State getState()
  {
    return (State)super.getState();
  }
  
  public String getUsername()
  {
    return getString("username");
  }
  
  j<Void> handleSaveResultAsync(ParseObject.State paramState, ParseOperationSet paramParseOperationSet)
  {
    if (paramState != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramParseOperationSet.remove("password");
      }
      return super.handleSaveResultAsync(paramState, paramParseOperationSet);
    }
  }
  
  public boolean isAuthenticated()
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        ParseUser localParseUser = getCurrentUser();
        if (!isLazy())
        {
          if ((getState().sessionToken() == null) || (localParseUser == null) || (!getObjectId().equals(localParseUser.getObjectId()))) {
            break label63;
          }
          break label58;
          return bool;
        }
      }
      label58:
      boolean bool = true;
      continue;
      label63:
      bool = false;
    }
  }
  
  boolean isCurrentUser()
  {
    synchronized (this.mutex)
    {
      boolean bool = this.isCurrentUser;
      return bool;
    }
  }
  
  boolean isKeyMutable(String paramString)
  {
    return !READ_ONLY_KEYS.contains(paramString);
  }
  
  boolean isLazy()
  {
    for (;;)
    {
      synchronized (this.mutex)
      {
        if ((getObjectId() == null) && (ParseAnonymousUtils.isLinked(this)))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean isLinked(String paramString)
  {
    Map localMap = getAuthData();
    return (localMap.containsKey(paramString)) && (localMap.get(paramString) != null);
  }
  
  public boolean isNew()
  {
    return getState().isNew();
  }
  
  public j<Void> linkWithInBackground(String paramString, Map<String, String> paramMap)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Invalid authType: " + null);
    }
    return linkWithAsync(paramString, paramMap, getSessionToken());
  }
  
  j<Void> logOutAsync()
  {
    return logOutAsync(true);
  }
  
  j<Void> logOutAsync(boolean paramBoolean)
  {
    Object localObject2 = getAuthenticationManager();
    ArrayList localArrayList = new ArrayList();
    String str;
    synchronized (this.mutex)
    {
      str = getState().sessionToken();
      Iterator localIterator = getAuthData().entrySet().iterator();
      if (localIterator.hasNext()) {
        localArrayList.add(((ParseAuthenticationManager)localObject2).deauthenticateAsync((String)((Map.Entry)localIterator.next()).getKey()));
      }
    }
    localObject2 = getState().newBuilder().sessionToken(null).isNew(false).build();
    this.isCurrentUser = false;
    setState((ParseObject.State)localObject2);
    if (paramBoolean) {
      localCollection.add(ParseSession.revokeAsync(str));
    }
    return j.a(localCollection);
  }
  
  boolean needsDefaultACL()
  {
    return false;
  }
  
  ParseUser.State.Builder newStateBuilder(String paramString)
  {
    return new ParseUser.State.Builder();
  }
  
  public void put(String paramString, Object paramObject)
  {
    synchronized (this.mutex)
    {
      if ("username".equals(paramString)) {
        stripAnonymity();
      }
      super.put(paramString, paramObject);
      return;
    }
  }
  
  void putAuthData(String paramString, Map<String, String> paramMap)
  {
    synchronized (this.mutex)
    {
      Map localMap = getAuthData();
      localMap.put(paramString, paramMap);
      performPut("authData", localMap);
      return;
    }
  }
  
  public void remove(String paramString)
  {
    if ("username".equals(paramString)) {
      throw new IllegalArgumentException("Can't remove the username key.");
    }
    super.remove(paramString);
  }
  
  j<Void> resolveLazinessAsync(j<Void> paramj)
  {
    synchronized (this.mutex)
    {
      if (getAuthData().size() == 0)
      {
        paramj = signUpAsync(paramj);
        return paramj;
      }
      paramj = paramj.d(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          ParseUser.getUserController().logInAsync(ParseUser.this.getState(), this.val$operations).d(new h()
          {
            public j<Void> then(final j<ParseUser.State> paramAnonymous2j)
            {
              paramAnonymous2j = (ParseUser.State)paramAnonymous2j.f();
              if ((Parse.isLocalDatastoreEnabled()) && (!paramAnonymous2j.isNew())) {}
              for (paramAnonymous2j = j.a(paramAnonymous2j);; paramAnonymous2j = ParseUser.this.handleSaveResultAsync(paramAnonymous2j, ParseUser.16.this.val$operations).c(new h()
                  {
                    public ParseUser.State then(j<Void> paramAnonymous3j)
                    {
                      return paramAnonymous2j;
                    }
                  })) {
                paramAnonymous2j.d(new h()
                {
                  public j<Void> then(j<ParseUser.State> paramAnonymous3j)
                  {
                    ParseUser.State localState = (ParseUser.State)paramAnonymous3j.f();
                    if (!localState.isNew()) {
                      return ParseUser.saveCurrentUserAsync((ParseUser)ParseObject.from(localState));
                    }
                    return paramAnonymous3j.k();
                  }
                });
              }
            }
          });
        }
      });
      return paramj;
    }
  }
  
  j<Void> saveAsync(String paramString, j<Void> paramj)
  {
    return saveAsync(paramString, isLazy(), paramj);
  }
  
  j<Void> saveAsync(String paramString, boolean paramBoolean, j<Void> paramj)
  {
    if (paramBoolean) {}
    for (paramString = resolveLazinessAsync(paramj);; paramString = super.saveAsync(paramString, paramj))
    {
      paramj = paramString;
      if (isCurrentUser()) {
        paramj = paramString.d(new h()
        {
          public j<Void> then(j<Void> paramAnonymousj)
          {
            return ParseUser.this.cleanUpAuthDataAsync();
          }
        }).d(new h()
        {
          public j<Void> then(j<Void> paramAnonymousj)
          {
            return ParseUser.saveCurrentUserAsync(ParseUser.this);
          }
        });
      }
      return paramj;
    }
  }
  
  public void setEmail(String paramString)
  {
    put("email", paramString);
  }
  
  void setIsCurrentUser(boolean paramBoolean)
  {
    synchronized (this.mutex)
    {
      this.isCurrentUser = paramBoolean;
      return;
    }
  }
  
  public void setPassword(String paramString)
  {
    put("password", paramString);
  }
  
  void setState(ParseObject.State paramState)
  {
    Object localObject = paramState;
    if (isCurrentUser())
    {
      localObject = (ParseUser.State.Builder)paramState.newBuilder();
      if ((getSessionToken() != null) && (paramState.get("sessionToken") == null)) {
        ((ParseUser.State.Builder)localObject).put("sessionToken", getSessionToken());
      }
      if ((getAuthData().size() > 0) && (paramState.get("authData") == null)) {
        ((ParseUser.State.Builder)localObject).put("authData", getAuthData());
      }
      localObject = ((ParseUser.State.Builder)localObject).build();
    }
    super.setState((ParseObject.State)localObject);
  }
  
  public void setUsername(String paramString)
  {
    put("username", paramString);
  }
  
  public void signUp()
  {
    ParseTaskUtils.wait(signUpInBackground());
  }
  
  j<Void> signUpAsync(j<Void> paramj)
  {
    final Object localObject2 = getCurrentUser();
    Object localObject1 = this.mutex;
    if (localObject2 != null) {}
    for (;;)
    {
      try
      {
        str1 = ((ParseUser)localObject2).getSessionToken();
        if (ParseTextUtils.isEmpty(getUsername()))
        {
          paramj = j.a(new IllegalArgumentException("Username cannot be missing or blank"));
          return paramj;
        }
        if (ParseTextUtils.isEmpty(getPassword()))
        {
          paramj = j.a(new IllegalArgumentException("Password cannot be missing or blank"));
          return paramj;
        }
      }
      finally {}
      if (getObjectId() != null)
      {
        localObject2 = getAuthData();
        if ((((Map)localObject2).containsKey("anonymous")) && (((Map)localObject2).get("anonymous") == null))
        {
          paramj = saveAsync(str1, paramj);
          return paramj;
        }
        paramj = j.a(new IllegalArgumentException("Cannot sign up a user that has already signed up."));
        return paramj;
      }
      if (this.operationSetQueue.size() > 1)
      {
        paramj = j.a(new IllegalArgumentException("Cannot sign up a user that is already signing up."));
        return paramj;
      }
      if ((localObject2 != null) && (ParseAnonymousUtils.isLinked((ParseUser)localObject2)))
      {
        if (this == localObject2)
        {
          paramj = j.a(new IllegalArgumentException("Attempt to merge currentUser with itself."));
          return paramj;
        }
        boolean bool = ((ParseUser)localObject2).isLazy();
        final String str2 = ((ParseUser)localObject2).getUsername();
        final String str3 = ((ParseUser)localObject2).getPassword();
        final Map localMap = ((ParseUser)localObject2).getAuthData("anonymous");
        ((ParseUser)localObject2).copyChangesFrom(this);
        ((ParseUser)localObject2).setUsername(getUsername());
        ((ParseUser)localObject2).setPassword(getPassword());
        revert();
        paramj = ((ParseUser)localObject2).saveAsync(str1, bool, paramj).b(new h()
        {
          public j<Void> then(j<Void> paramAnonymousj)
          {
            if ((paramAnonymousj.d()) || (paramAnonymousj.e())) {
              for (;;)
              {
                synchronized (localObject2.mutex)
                {
                  if (str2 != null)
                  {
                    localObject2.setUsername(str2);
                    if (str3 != null)
                    {
                      localObject2.setPassword(str3);
                      localObject2.restoreAnonymity(localMap);
                      return paramAnonymousj;
                    }
                  }
                  else
                  {
                    localObject2.revert("username");
                  }
                }
                localObject2.revert("password");
              }
            }
            localObject2.revert("password");
            ParseUser.this.revert("password");
            ParseUser.this.mergeFromObject(localObject2);
            return ParseUser.saveCurrentUserAsync(ParseUser.this);
          }
        });
        return paramj;
      }
      paramj = paramj.d(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          ParseUser.getUserController().signUpAsync(ParseUser.this.getState(), this.val$operations, str1).b(new h()
          {
            public j<Void> then(final j<ParseUser.State> paramAnonymous2j)
            {
              ParseUser.State localState = (ParseUser.State)paramAnonymous2j.f();
              ParseUser.this.handleSaveResultAsync(localState, ParseUser.8.this.val$operations).b(new h()
              {
                public j<Void> then(j<Void> paramAnonymous3j)
                {
                  if ((!paramAnonymous2j.d()) && (!paramAnonymous2j.e())) {
                    return ParseUser.saveCurrentUserAsync(ParseUser.this);
                  }
                  return paramAnonymous2j.k();
                }
              });
            }
          });
        }
      });
      return paramj;
      final String str1 = null;
    }
  }
  
  public j<Void> signUpInBackground()
  {
    this.taskQueue.enqueue(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        return ParseUser.this.signUpAsync(paramAnonymousj);
      }
    });
  }
  
  public void signUpInBackground(SignUpCallback paramSignUpCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(signUpInBackground(), paramSignUpCallback);
  }
  
  j<Void> synchronizeAllAuthDataAsync()
  {
    synchronized (this.mutex)
    {
      if (!isCurrentUser())
      {
        localObject2 = j.a(null);
        return (j<Void>)localObject2;
      }
      Object localObject2 = getAuthData();
      ??? = new ArrayList(((Map)localObject2).size());
      localObject2 = ((Map)localObject2).keySet().iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((List)???).add(synchronizeAuthDataAsync((String)((Iterator)localObject2).next()));
      }
    }
    return j.a((Collection)???);
  }
  
  j<Void> synchronizeAuthDataAsync(String paramString)
  {
    synchronized (this.mutex)
    {
      if (!isCurrentUser())
      {
        paramString = j.a(null);
        return paramString;
      }
      Map localMap = getAuthData(paramString);
      return synchronizeAuthDataAsync(getAuthenticationManager(), paramString, localMap);
    }
  }
  
  JSONObject toRest(ParseObject.State paramState, List<ParseOperationSet> paramList, ParseEncoder paramParseEncoder)
  {
    int i = 0;
    Object localObject2;
    for (Object localObject1 = paramList; i < paramList.size(); localObject1 = localObject2)
    {
      ParseOperationSet localParseOperationSet = (ParseOperationSet)paramList.get(i);
      localObject2 = localObject1;
      if (localParseOperationSet.containsKey("password"))
      {
        localObject2 = localObject1;
        if (localObject1 == paramList) {
          localObject2 = new LinkedList(paramList);
        }
        localObject1 = new ParseOperationSet(localParseOperationSet);
        ((ParseOperationSet)localObject1).remove("password");
        ((List)localObject2).set(i, localObject1);
      }
      i += 1;
    }
    return super.toRest(paramState, (List)localObject1, paramParseEncoder);
  }
  
  public j<Void> unlinkFromInBackground(String paramString)
  {
    if (paramString == null) {
      return j.a(null);
    }
    synchronized (this.mutex)
    {
      if (!getAuthData().containsKey(paramString))
      {
        paramString = j.a(null);
        return paramString;
      }
    }
    putAuthData(paramString, null);
    return saveInBackground();
  }
  
  j<Void> upgradeToRevocableSessionAsync()
  {
    this.taskQueue.enqueue(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        return ParseUser.this.upgradeToRevocableSessionAsync(paramAnonymousj);
      }
    });
  }
  
  void validateDelete()
  {
    synchronized (this.mutex)
    {
      super.validateDelete();
      if ((!isAuthenticated()) && (isDirty())) {
        throw new IllegalArgumentException("Cannot delete a ParseUser that is not authenticated.");
      }
    }
  }
  
  void validateSave()
  {
    synchronized (this.mutex)
    {
      if (getObjectId() == null) {
        throw new IllegalArgumentException("Cannot save a ParseUser until it has been signed up. Call signUp first.");
      }
    }
    if ((isAuthenticated()) || (!isDirty()) || (isCurrentUser())) {
      return;
    }
    if (!Parse.isLocalDatastoreEnabled())
    {
      ??? = getCurrentUser();
      if ((??? != null) && (getObjectId().equals(((ParseUser)???).getObjectId()))) {}
    }
    else
    {
      throw new IllegalArgumentException("Cannot save a ParseUser that is not authenticated.");
    }
  }
  
  void validateSaveEventually()
  {
    if (isDirty("password")) {
      throw new ParseException(-1, "Unable to saveEventually on a ParseUser with dirty password");
    }
  }
  
  static class State
    extends ParseObject.State
  {
    private final boolean isNew;
    
    private State(Builder paramBuilder)
    {
      super();
      this.isNew = paramBuilder.isNew;
    }
    
    public Map<String, Map<String, String>> authData()
    {
      Map localMap = (Map)get("authData");
      Object localObject = localMap;
      if (localMap == null) {
        localObject = new HashMap();
      }
      return (Map<String, Map<String, String>>)localObject;
    }
    
    public boolean isNew()
    {
      return this.isNew;
    }
    
    public Builder newBuilder()
    {
      return new Builder(this);
    }
    
    public String sessionToken()
    {
      return (String)get("sessionToken");
    }
    
    static class Builder
      extends ParseObject.State.Init<Builder>
    {
      private boolean isNew;
      
      public Builder()
      {
        super();
      }
      
      Builder(ParseUser.State paramState)
      {
        super();
        this.isNew = paramState.isNew();
      }
      
      public Builder apply(ParseObject.State paramState)
      {
        isNew(((ParseUser.State)paramState).isNew());
        return (Builder)super.apply(paramState);
      }
      
      public Builder authData(Map<String, Map<String, String>> paramMap)
      {
        return (Builder)put("authData", paramMap);
      }
      
      public ParseUser.State build()
      {
        return new ParseUser.State(this, null);
      }
      
      public Builder isNew(boolean paramBoolean)
      {
        this.isNew = paramBoolean;
        return this;
      }
      
      public Builder putAuthData(String paramString, Map<String, String> paramMap)
      {
        Map localMap = (Map)this.serverData.get("authData");
        Object localObject = localMap;
        if (localMap == null) {
          localObject = new HashMap();
        }
        ((Map)localObject).put(paramString, paramMap);
        this.serverData.put("authData", localObject);
        return this;
      }
      
      Builder self()
      {
        return this;
      }
      
      public Builder sessionToken(String paramString)
      {
        return (Builder)put("sessionToken", paramString);
      }
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */