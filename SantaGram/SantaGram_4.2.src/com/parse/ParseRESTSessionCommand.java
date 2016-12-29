package com.parse;

import com.parse.a.b.b;
import org.json.JSONObject;

class ParseRESTSessionCommand
  extends ParseRESTCommand
{
  private ParseRESTSessionCommand(String paramString1, b.b paramb, JSONObject paramJSONObject, String paramString2)
  {
    super(paramString1, paramb, paramJSONObject, paramString2);
  }
  
  public static ParseRESTSessionCommand getCurrentSessionCommand(String paramString)
  {
    return new ParseRESTSessionCommand("sessions/me", b.b.a, null, paramString);
  }
  
  public static ParseRESTSessionCommand revoke(String paramString)
  {
    return new ParseRESTSessionCommand("logout", b.b.b, new JSONObject(), paramString);
  }
  
  public static ParseRESTSessionCommand upgradeToRevocableSessionCommand(String paramString)
  {
    return new ParseRESTSessionCommand("upgradeToRevocableSession", b.b.b, new JSONObject(), paramString);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseRESTSessionCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */