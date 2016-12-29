package com.parse;

import a.h;
import a.j;
import java.util.Map;

public final class ParseCloud
{
  public static <T> T callFunction(String paramString, Map<String, ?> paramMap)
  {
    return (T)ParseTaskUtils.wait(callFunctionInBackground(paramString, paramMap));
  }
  
  public static <T> j<T> callFunctionInBackground(String paramString, final Map<String, ?> paramMap)
  {
    ParseUser.getCurrentSessionTokenAsync().d(new h()
    {
      public j<T> then(j<String> paramAnonymousj)
      {
        paramAnonymousj = (String)paramAnonymousj.f();
        return ParseCloud.getCloudCodeController().callFunctionInBackground(this.val$name, paramMap, paramAnonymousj);
      }
    });
  }
  
  public static <T> void callFunctionInBackground(String paramString, Map<String, ?> paramMap, FunctionCallback<T> paramFunctionCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(callFunctionInBackground(paramString, paramMap), paramFunctionCallback);
  }
  
  static ParseCloudCodeController getCloudCodeController()
  {
    return ParseCorePlugins.getInstance().getCloudCodeController();
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseCloud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */