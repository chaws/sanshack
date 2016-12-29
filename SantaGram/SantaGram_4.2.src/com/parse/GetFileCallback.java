package com.parse;

import java.io.File;

public abstract interface GetFileCallback
  extends ParseCallback2<File, ParseException>
{
  public abstract void done(File paramFile, ParseException paramParseException);
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/GetFileCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */