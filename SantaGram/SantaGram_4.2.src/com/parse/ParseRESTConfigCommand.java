package com.parse;

import com.parse.a.b.b;
import java.util.HashMap;
import java.util.Map;

class ParseRESTConfigCommand
  extends ParseRESTCommand
{
  public ParseRESTConfigCommand(String paramString1, b.b paramb, Map<String, ?> paramMap, String paramString2)
  {
    super(paramString1, paramb, paramMap, paramString2);
  }
  
  public static ParseRESTConfigCommand fetchConfigCommand(String paramString)
  {
    return new ParseRESTConfigCommand("config", b.b.a, null, paramString);
  }
  
  public static ParseRESTConfigCommand updateConfigCommand(Map<String, ?> paramMap, String paramString)
  {
    HashMap localHashMap = null;
    if (paramMap != null)
    {
      localHashMap = new HashMap();
      localHashMap.put("params", paramMap);
    }
    return new ParseRESTConfigCommand("config", b.b.c, localHashMap, paramString);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseRESTConfigCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */