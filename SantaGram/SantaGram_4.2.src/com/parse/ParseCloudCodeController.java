package com.parse;

import a.h;
import a.j;
import java.util.Map;
import org.json.JSONObject;

class ParseCloudCodeController
{
  final ParseHttpClient restClient;
  
  public ParseCloudCodeController(ParseHttpClient paramParseHttpClient)
  {
    this.restClient = paramParseHttpClient;
  }
  
  public <T> j<T> callFunctionInBackground(String paramString1, Map<String, ?> paramMap, String paramString2)
  {
    ParseRESTCloudCommand.callFunctionCommand(paramString1, paramMap, paramString2).executeAsync(this.restClient).c(new h()
    {
      public T then(j<JSONObject> paramAnonymousj)
      {
        return (T)ParseCloudCodeController.this.convertCloudResponse(paramAnonymousj.f());
      }
    });
  }
  
  Object convertCloudResponse(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof JSONObject)) {
      localObject = ((JSONObject)paramObject).opt("result");
    }
    paramObject = ParseDecoder.get().decode(localObject);
    if (paramObject != null) {
      localObject = paramObject;
    }
    return localObject;
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseCloudCodeController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */