package com.parse;

public abstract interface FunctionCallback<T>
  extends ParseCallback2<T, ParseException>
{
  public abstract void done(T paramT, ParseException paramParseException);
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/FunctionCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */