package com.parse;

import android.net.Uri;
import com.parse.a.b.b;
import org.json.JSONObject;

class ParseRESTObjectCommand
  extends ParseRESTCommand
{
  public ParseRESTObjectCommand(String paramString1, b.b paramb, JSONObject paramJSONObject, String paramString2)
  {
    super(paramString1, paramb, paramJSONObject, paramString2);
  }
  
  private static ParseRESTObjectCommand createObjectCommand(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    return new ParseRESTObjectCommand(String.format("classes/%s", new Object[] { Uri.encode(paramString1) }), b.b.b, paramJSONObject, paramString2);
  }
  
  public static ParseRESTObjectCommand deleteObjectCommand(ParseObject.State paramState, String paramString)
  {
    String str1 = String.format("classes/%s", new Object[] { Uri.encode(paramState.className()) });
    String str2 = paramState.objectId();
    paramState = str1;
    if (str2 != null) {
      paramState = str1 + String.format("/%s", new Object[] { Uri.encode(str2) });
    }
    return new ParseRESTObjectCommand(paramState, b.b.d, null, paramString);
  }
  
  public static ParseRESTObjectCommand getObjectCommand(String paramString1, String paramString2, String paramString3)
  {
    return new ParseRESTObjectCommand(String.format("classes/%s/%s", new Object[] { Uri.encode(paramString2), Uri.encode(paramString1) }), b.b.a, null, paramString3);
  }
  
  public static ParseRESTObjectCommand saveObjectCommand(ParseObject.State paramState, JSONObject paramJSONObject, String paramString)
  {
    if (paramState.objectId() == null) {
      return createObjectCommand(paramState.className(), paramJSONObject, paramString);
    }
    return updateObjectCommand(paramState.objectId(), paramState.className(), paramJSONObject, paramString);
  }
  
  private static ParseRESTObjectCommand updateObjectCommand(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3)
  {
    return new ParseRESTObjectCommand(String.format("classes/%s/%s", new Object[] { Uri.encode(paramString2), Uri.encode(paramString1) }), b.b.c, paramJSONObject, paramString3);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseRESTObjectCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */