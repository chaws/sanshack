package com.parse;

import a.h;
import a.j;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ParseClassName("_Session")
public class ParseSession
  extends ParseObject
{
  private static final String KEY_CREATED_WITH = "createdWith";
  private static final String KEY_EXPIRES_AT = "expiresAt";
  private static final String KEY_INSTALLATION_ID = "installationId";
  private static final String KEY_RESTRICTED = "restricted";
  private static final String KEY_SESSION_TOKEN = "sessionToken";
  private static final String KEY_USER = "user";
  private static final List<String> READ_ONLY_KEYS = Collections.unmodifiableList(Arrays.asList(new String[] { "sessionToken", "createdWith", "restricted", "user", "expiresAt", "installationId" }));
  
  public static j<ParseSession> getCurrentSessionInBackground()
  {
    ParseUser.getCurrentSessionTokenAsync().d(new h()
    {
      public j<ParseSession> then(j<String> paramAnonymousj)
      {
        paramAnonymousj = (String)paramAnonymousj.f();
        if (paramAnonymousj == null) {
          return j.a(null);
        }
        ParseSession.access$000().getSessionAsync(paramAnonymousj).c(new h()
        {
          public ParseSession then(j<ParseObject.State> paramAnonymous2j)
          {
            return (ParseSession)ParseObject.from((ParseObject.State)paramAnonymous2j.f());
          }
        });
      }
    });
  }
  
  public static void getCurrentSessionInBackground(GetCallback<ParseSession> paramGetCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(getCurrentSessionInBackground(), paramGetCallback);
  }
  
  public static ParseQuery<ParseSession> getQuery()
  {
    return ParseQuery.getQuery(ParseSession.class);
  }
  
  private static ParseSessionController getSessionController()
  {
    return ParseCorePlugins.getInstance().getSessionController();
  }
  
  static boolean isRevocableSessionToken(String paramString)
  {
    return paramString.contains("r:");
  }
  
  static j<Void> revokeAsync(String paramString)
  {
    if ((paramString == null) || (!isRevocableSessionToken(paramString))) {
      return j.a(null);
    }
    return getSessionController().revokeAsync(paramString);
  }
  
  static j<String> upgradeToRevocableSessionAsync(String paramString)
  {
    if ((paramString == null) || (isRevocableSessionToken(paramString))) {
      return j.a(paramString);
    }
    getSessionController().upgradeToRevocable(paramString).c(new h()
    {
      public String then(j<ParseObject.State> paramAnonymousj)
      {
        return ((ParseSession)ParseObject.from((ParseObject.State)paramAnonymousj.f())).getSessionToken();
      }
    });
  }
  
  public String getSessionToken()
  {
    return getString("sessionToken");
  }
  
  boolean isKeyMutable(String paramString)
  {
    return !READ_ONLY_KEYS.contains(paramString);
  }
  
  boolean needsDefaultACL()
  {
    return false;
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */