package com.parse.a;

import java.io.InputStream;
import java.io.OutputStream;

public abstract class a
{
  private final long contentLength;
  private final String contentType;
  
  public a(String paramString, long paramLong)
  {
    this.contentType = paramString;
    this.contentLength = paramLong;
  }
  
  public abstract InputStream getContent();
  
  public long getContentLength()
  {
    return this.contentLength;
  }
  
  public String getContentType()
  {
    return this.contentType;
  }
  
  public abstract void writeTo(OutputStream paramOutputStream);
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */