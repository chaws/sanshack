package com.parse;

import a.h;
import a.j;
import java.util.Map;
import org.json.JSONObject;

class NetworkUserController
  implements ParseUserController
{
  private static final int STATUS_CODE_CREATED = 201;
  private final ParseHttpClient client;
  private final ParseObjectCoder coder;
  private final boolean revocableSession;
  
  public NetworkUserController(ParseHttpClient paramParseHttpClient)
  {
    this(paramParseHttpClient, false);
  }
  
  public NetworkUserController(ParseHttpClient paramParseHttpClient, boolean paramBoolean)
  {
    this.client = paramParseHttpClient;
    this.coder = ParseObjectCoder.get();
    this.revocableSession = paramBoolean;
  }
  
  public j<ParseUser.State> getUserAsync(String paramString)
  {
    ParseRESTUserCommand.getCurrentUserCommand(paramString).executeAsync(this.client).c(new h()
    {
      public ParseUser.State then(j<JSONObject> paramAnonymousj)
      {
        paramAnonymousj = (JSONObject)paramAnonymousj.f();
        return ((ParseUser.State.Builder)((ParseUser.State.Builder)NetworkUserController.this.coder.decode(new ParseUser.State.Builder(), paramAnonymousj, ParseDecoder.get())).isComplete(true)).build();
      }
    });
  }
  
  public j<ParseUser.State> logInAsync(final ParseUser.State paramState, ParseOperationSet paramParseOperationSet)
  {
    paramState = ParseRESTUserCommand.serviceLogInUserCommand(this.coder.encode(paramState, paramParseOperationSet, PointerEncoder.get()), paramState.sessionToken(), this.revocableSession);
    paramState.executeAsync(this.client).c(new h()
    {
      public ParseUser.State then(j<JSONObject> paramAnonymousj)
      {
        boolean bool2 = true;
        paramAnonymousj = (JSONObject)paramAnonymousj.f();
        boolean bool1;
        if (paramState.getStatusCode() == 201)
        {
          bool1 = true;
          if (bool1) {
            break label73;
          }
        }
        for (;;)
        {
          return ((ParseUser.State.Builder)((ParseUser.State.Builder)NetworkUserController.this.coder.decode(new ParseUser.State.Builder(), paramAnonymousj, ParseDecoder.get())).isComplete(bool2)).isNew(bool1).build();
          bool1 = false;
          break;
          label73:
          bool2 = false;
        }
      }
    });
  }
  
  public j<ParseUser.State> logInAsync(String paramString1, String paramString2)
  {
    ParseRESTUserCommand.logInUserCommand(paramString1, paramString2, this.revocableSession).executeAsync(this.client).c(new h()
    {
      public ParseUser.State then(j<JSONObject> paramAnonymousj)
      {
        paramAnonymousj = (JSONObject)paramAnonymousj.f();
        return ((ParseUser.State.Builder)((ParseUser.State.Builder)NetworkUserController.this.coder.decode(new ParseUser.State.Builder(), paramAnonymousj, ParseDecoder.get())).isComplete(true)).build();
      }
    });
  }
  
  public j<ParseUser.State> logInAsync(final String paramString, final Map<String, String> paramMap)
  {
    final ParseRESTUserCommand localParseRESTUserCommand = ParseRESTUserCommand.serviceLogInUserCommand(paramString, paramMap, this.revocableSession);
    localParseRESTUserCommand.executeAsync(this.client).c(new h()
    {
      public ParseUser.State then(j<JSONObject> paramAnonymousj)
      {
        boolean bool = true;
        paramAnonymousj = (JSONObject)paramAnonymousj.f();
        paramAnonymousj = (ParseUser.State.Builder)((ParseUser.State.Builder)NetworkUserController.this.coder.decode(new ParseUser.State.Builder(), paramAnonymousj, ParseDecoder.get())).isComplete(true);
        if (localParseRESTUserCommand.getStatusCode() == 201) {}
        for (;;)
        {
          return paramAnonymousj.isNew(bool).putAuthData(paramString, paramMap).build();
          bool = false;
        }
      }
    });
  }
  
  public j<Void> requestPasswordResetAsync(String paramString)
  {
    return ParseRESTUserCommand.resetPasswordResetCommand(paramString).executeAsync(this.client).k();
  }
  
  public j<ParseUser.State> signUpAsync(ParseObject.State paramState, ParseOperationSet paramParseOperationSet, String paramString)
  {
    ParseRESTUserCommand.signUpUserCommand(this.coder.encode(paramState, paramParseOperationSet, PointerEncoder.get()), paramString, this.revocableSession).executeAsync(this.client).c(new h()
    {
      public ParseUser.State then(j<JSONObject> paramAnonymousj)
      {
        paramAnonymousj = (JSONObject)paramAnonymousj.f();
        return ((ParseUser.State.Builder)((ParseUser.State.Builder)NetworkUserController.this.coder.decode(new ParseUser.State.Builder(), paramAnonymousj, ParseDecoder.get())).isComplete(false)).isNew(true).build();
      }
    });
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/NetworkUserController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */