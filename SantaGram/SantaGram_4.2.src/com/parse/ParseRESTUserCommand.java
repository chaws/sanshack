package com.parse;

import a.j;
import com.parse.a.b.a;
import com.parse.a.b.b;
import com.parse.a.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class ParseRESTUserCommand
  extends ParseRESTCommand
{
  private static final String HEADER_REVOCABLE_SESSION = "X-Parse-Revocable-Session";
  private static final String HEADER_TRUE = "1";
  private boolean isRevocableSessionEnabled;
  private int statusCode;
  
  private ParseRESTUserCommand(String paramString1, b.b paramb, Map<String, ?> paramMap, String paramString2)
  {
    this(paramString1, paramb, paramMap, paramString2, false);
  }
  
  private ParseRESTUserCommand(String paramString1, b.b paramb, Map<String, ?> paramMap, String paramString2, boolean paramBoolean)
  {
    super(paramString1, paramb, paramMap, paramString2);
    this.isRevocableSessionEnabled = paramBoolean;
  }
  
  private ParseRESTUserCommand(String paramString1, b.b paramb, JSONObject paramJSONObject, String paramString2, boolean paramBoolean)
  {
    super(paramString1, paramb, paramJSONObject, paramString2);
    this.isRevocableSessionEnabled = paramBoolean;
  }
  
  public static ParseRESTUserCommand getCurrentUserCommand(String paramString)
  {
    return new ParseRESTUserCommand("users/me", b.b.a, null, paramString);
  }
  
  public static ParseRESTUserCommand logInUserCommand(String paramString1, String paramString2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("username", paramString1);
    localHashMap.put("password", paramString2);
    return new ParseRESTUserCommand("login", b.b.a, localHashMap, null, paramBoolean);
  }
  
  public static ParseRESTUserCommand resetPasswordResetCommand(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("email", paramString);
    return new ParseRESTUserCommand("requestPasswordReset", b.b.b, localHashMap, null);
  }
  
  public static ParseRESTUserCommand serviceLogInUserCommand(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(paramString, PointerEncoder.get().encode(paramMap));
      paramString = new JSONObject();
      paramString.put("authData", localJSONObject);
      return serviceLogInUserCommand(paramString, null, paramBoolean);
    }
    catch (JSONException paramString)
    {
      throw new RuntimeException("could not serialize object to JSON");
    }
  }
  
  public static ParseRESTUserCommand serviceLogInUserCommand(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    return new ParseRESTUserCommand("users", b.b.b, paramJSONObject, paramString, paramBoolean);
  }
  
  public static ParseRESTUserCommand signUpUserCommand(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    return new ParseRESTUserCommand("classes/_User", b.b.b, paramJSONObject, paramString, paramBoolean);
  }
  
  protected void addAdditionalHeaders(b.a parama)
  {
    super.addAdditionalHeaders(parama);
    if (this.isRevocableSessionEnabled) {
      parama.a("X-Parse-Revocable-Session", "1");
    }
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  protected j<JSONObject> onResponseAsync(c paramc, ProgressCallback paramProgressCallback)
  {
    this.statusCode = paramc.a();
    return super.onResponseAsync(paramc, paramProgressCallback);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseRESTUserCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */