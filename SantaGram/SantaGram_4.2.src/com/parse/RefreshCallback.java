package com.parse;

public abstract interface RefreshCallback
  extends ParseCallback2<ParseObject, ParseException>
{
  public abstract void done(ParseObject paramParseObject, ParseException paramParseException);
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/RefreshCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */