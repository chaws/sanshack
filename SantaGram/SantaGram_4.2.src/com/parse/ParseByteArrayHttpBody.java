package com.parse;

import com.parse.a.a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

class ParseByteArrayHttpBody
  extends a
{
  final byte[] content;
  final InputStream contentInputStream;
  
  public ParseByteArrayHttpBody(String paramString1, String paramString2)
  {
    this(paramString1.getBytes("UTF-8"), paramString2);
  }
  
  public ParseByteArrayHttpBody(byte[] paramArrayOfByte, String paramString)
  {
    super(paramString, paramArrayOfByte.length);
    this.content = paramArrayOfByte;
    this.contentInputStream = new ByteArrayInputStream(paramArrayOfByte);
  }
  
  public InputStream getContent()
  {
    return this.contentInputStream;
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("Output stream may not be null");
    }
    paramOutputStream.write(this.content);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseByteArrayHttpBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */