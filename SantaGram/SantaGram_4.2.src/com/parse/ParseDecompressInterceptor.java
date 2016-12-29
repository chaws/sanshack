package com.parse;

import com.parse.a.c;
import com.parse.a.c.a;
import com.parse.a.d;
import com.parse.a.d.a;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

class ParseDecompressInterceptor
  implements d
{
  private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
  private static final String CONTENT_LENGTH_HEADER = "Content-Length";
  private static final String GZIP_ENCODING = "gzip";
  
  public c intercept(d.a parama)
  {
    c localc = parama.proceed(parama.getRequest());
    parama = localc;
    if ("gzip".equalsIgnoreCase(localc.a("Content-Encoding")))
    {
      parama = new HashMap(localc.f());
      parama.remove("Content-Encoding");
      parama.put("Content-Length", "-1");
      parama = new c.a(localc).a(-1L).a(parama).a(new GZIPInputStream(localc.b())).a();
    }
    return parama;
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseDecompressInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */