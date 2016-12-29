package com.parse;

import a.j;
import com.parse.a.b.b;
import com.parse.a.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.Callable;

class ParseAWSRequest
  extends ParseRequest<Void>
{
  private final File tempFile;
  
  public ParseAWSRequest(b.b paramb, String paramString, File paramFile)
  {
    super(paramb, paramString);
    this.tempFile = paramFile;
  }
  
  protected j<Void> onResponseAsync(final c paramc, final ProgressCallback paramProgressCallback)
  {
    int i = paramc.a();
    if (((i >= 200) && (i < 300)) || (i == 304))
    {
      if (this.method != b.b.a) {
        return null;
      }
    }
    else
    {
      if (this.method == b.b.a) {}
      for (paramProgressCallback = "Download from";; paramProgressCallback = "Upload to") {
        return j.a(new ParseException(100, String.format("%s S3 failed. %s", new Object[] { paramProgressCallback, paramc.d() })));
      }
    }
    j.a(new Callable()
    {
      public Void call()
      {
        long l3 = paramc.c();
        long l1 = 0L;
        try
        {
          localObject1 = paramc.b();
          try
          {
            localObject3 = ParseFileUtils.openOutputStream(ParseAWSRequest.this.tempFile);
            byte[] arrayOfByte = new byte[32768];
            for (;;)
            {
              int i = ((InputStream)localObject1).read(arrayOfByte, 0, arrayOfByte.length);
              if (i == -1) {
                break;
              }
              ((FileOutputStream)localObject3).write(arrayOfByte, 0, i);
              long l2 = l1 + i;
              l1 = l2;
              if (paramProgressCallback != null)
              {
                l1 = l2;
                if (l3 != -1L)
                {
                  i = Math.round((float)l2 / (float)l3 * 100.0F);
                  paramProgressCallback.done(Integer.valueOf(i));
                  l1 = l2;
                }
              }
            }
            ParseIOUtils.closeQuietly((InputStream)localObject3);
          }
          finally
          {
            localObject3 = localObject1;
            localObject1 = localObject4;
          }
        }
        finally
        {
          for (;;)
          {
            Object localObject1;
            Object localObject3 = null;
          }
        }
        throw ((Throwable)localObject1);
        ParseIOUtils.closeQuietly((InputStream)localObject1);
        return null;
      }
    }, ParseExecutors.io());
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseAWSRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */