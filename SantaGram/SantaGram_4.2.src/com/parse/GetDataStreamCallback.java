package com.parse;

import java.io.InputStream;

public abstract interface GetDataStreamCallback
  extends ParseCallback2<InputStream, ParseException>
{
  public abstract void done(InputStream paramInputStream, ParseException paramParseException);
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/GetDataStreamCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */