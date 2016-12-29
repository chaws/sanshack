package com.parse;

import com.parse.a.b.b;
import java.util.Map;

class ParseRESTCloudCommand
  extends ParseRESTCommand
{
  private ParseRESTCloudCommand(String paramString1, b.b paramb, Map<String, ?> paramMap, String paramString2)
  {
    super(paramString1, paramb, paramMap, paramString2);
  }
  
  public static ParseRESTCloudCommand callFunctionCommand(String paramString1, Map<String, ?> paramMap, String paramString2)
  {
    return new ParseRESTCloudCommand(String.format("functions/%s", new Object[] { paramString1 }), b.b.b, paramMap, paramString2);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseRESTCloudCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */