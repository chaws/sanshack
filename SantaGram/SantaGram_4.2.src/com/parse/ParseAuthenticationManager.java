package com.parse;

import a.h;
import a.j;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

class ParseAuthenticationManager
{
  private final Map<String, AuthenticationCallback> callbacks = new HashMap();
  private final ParseCurrentUserController controller;
  private final Object lock = new Object();
  
  public ParseAuthenticationManager(ParseCurrentUserController paramParseCurrentUserController)
  {
    this.controller = paramParseCurrentUserController;
  }
  
  public j<Void> deauthenticateAsync(final String paramString)
  {
    synchronized (this.lock)
    {
      paramString = (AuthenticationCallback)this.callbacks.get(paramString);
      if (paramString != null) {
        j.a(new Callable()
        {
          public Void call()
          {
            paramString.onRestore(null);
            return null;
          }
        }, ParseExecutors.io());
      }
    }
    return j.a(null);
  }
  
  public void register(final String paramString, AuthenticationCallback paramAuthenticationCallback)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Invalid authType: " + null);
    }
    synchronized (this.lock)
    {
      if (this.callbacks.containsKey(paramString)) {
        throw new IllegalStateException("Callback already registered for <" + paramString + ">: " + this.callbacks.get(paramString));
      }
    }
    this.callbacks.put(paramString, paramAuthenticationCallback);
    if ("anonymous".equals(paramString)) {
      return;
    }
    this.controller.getAsync(false).d(new h()
    {
      public j<Void> then(j<ParseUser> paramAnonymousj)
      {
        paramAnonymousj = (ParseUser)paramAnonymousj.f();
        if (paramAnonymousj != null) {
          return paramAnonymousj.synchronizeAuthDataAsync(paramString);
        }
        return null;
      }
    });
  }
  
  public j<Boolean> restoreAuthenticationAsync(final String paramString, final Map<String, String> paramMap)
  {
    synchronized (this.lock)
    {
      paramString = (AuthenticationCallback)this.callbacks.get(paramString);
      if (paramString == null) {
        return j.a(Boolean.valueOf(true));
      }
    }
    j.a(new Callable()
    {
      public Boolean call()
      {
        return Boolean.valueOf(paramString.onRestore(paramMap));
      }
    }, ParseExecutors.io());
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseAuthenticationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */