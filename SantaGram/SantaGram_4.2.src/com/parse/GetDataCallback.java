package com.parse;

public abstract interface GetDataCallback
  extends ParseCallback2<byte[], ParseException>
{
  public abstract void done(byte[] paramArrayOfByte, ParseException paramParseException);
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/GetDataCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */