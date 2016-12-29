package com.parse;

import a.h;
import a.j;
import org.json.JSONObject;

class NetworkSessionController
  implements ParseSessionController
{
  private final ParseHttpClient client;
  private final ParseObjectCoder coder;
  
  public NetworkSessionController(ParseHttpClient paramParseHttpClient)
  {
    this.client = paramParseHttpClient;
    this.coder = ParseObjectCoder.get();
  }
  
  public j<ParseObject.State> getSessionAsync(String paramString)
  {
    ParseRESTSessionCommand.getCurrentSessionCommand(paramString).executeAsync(this.client).c(new h()
    {
      public ParseObject.State then(j<JSONObject> paramAnonymousj)
      {
        paramAnonymousj = (JSONObject)paramAnonymousj.f();
        return ((ParseObject.State.Builder)((ParseObject.State.Builder)NetworkSessionController.this.coder.decode(new ParseObject.State.Builder("_Session"), paramAnonymousj, ParseDecoder.get())).isComplete(true)).build();
      }
    });
  }
  
  public j<Void> revokeAsync(String paramString)
  {
    return ParseRESTSessionCommand.revoke(paramString).executeAsync(this.client).k();
  }
  
  public j<ParseObject.State> upgradeToRevocable(String paramString)
  {
    ParseRESTSessionCommand.upgradeToRevocableSessionCommand(paramString).executeAsync(this.client).c(new h()
    {
      public ParseObject.State then(j<JSONObject> paramAnonymousj)
      {
        paramAnonymousj = (JSONObject)paramAnonymousj.f();
        return ((ParseObject.State.Builder)((ParseObject.State.Builder)NetworkSessionController.this.coder.decode(new ParseObject.State.Builder("_Session"), paramAnonymousj, ParseDecoder.get())).isComplete(true)).build();
      }
    });
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/NetworkSessionController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */