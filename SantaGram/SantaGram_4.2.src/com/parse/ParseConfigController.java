package com.parse;

import a.h;
import a.j;
import org.json.JSONObject;

class ParseConfigController
{
  private ParseCurrentConfigController currentConfigController;
  private final ParseHttpClient restClient;
  
  public ParseConfigController(ParseHttpClient paramParseHttpClient, ParseCurrentConfigController paramParseCurrentConfigController)
  {
    this.restClient = paramParseHttpClient;
    this.currentConfigController = paramParseCurrentConfigController;
  }
  
  public j<ParseConfig> getAsync(String paramString)
  {
    paramString = ParseRESTConfigCommand.fetchConfigCommand(paramString);
    paramString.enableRetrying();
    paramString.executeAsync(this.restClient).d(new h()
    {
      public j<ParseConfig> then(final j<JSONObject> paramAnonymousj)
      {
        paramAnonymousj = ParseConfig.decode((JSONObject)paramAnonymousj.f(), ParseDecoder.get());
        ParseConfigController.this.currentConfigController.setCurrentConfigAsync(paramAnonymousj).a(new h()
        {
          public ParseConfig then(j<Void> paramAnonymous2j)
          {
            return paramAnonymousj;
          }
        });
      }
    });
  }
  
  ParseCurrentConfigController getCurrentConfigController()
  {
    return this.currentConfigController;
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseConfigController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */