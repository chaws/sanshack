package com.parse;

public abstract interface LogInCallback
  extends ParseCallback2<ParseUser, ParseException>
{
  public abstract void done(ParseUser paramParseUser, ParseException paramParseException);
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/LogInCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */