package com.parse;

import org.json.JSONObject;

class NoObjectsEncoder
  extends ParseEncoder
{
  private static final NoObjectsEncoder INSTANCE = new NoObjectsEncoder();
  
  public static NoObjectsEncoder get()
  {
    return INSTANCE;
  }
  
  public JSONObject encodeRelatedObject(ParseObject paramParseObject)
  {
    throw new IllegalArgumentException("ParseObjects not allowed here");
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/NoObjectsEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */