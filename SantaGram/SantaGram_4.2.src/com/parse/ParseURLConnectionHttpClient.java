package com.parse;

import android.net.SSLSessionCache;
import com.parse.a.a;
import com.parse.a.b;
import com.parse.a.b.b;
import com.parse.a.c;
import com.parse.a.c.a;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ParseURLConnectionHttpClient
  extends ParseHttpClient<HttpURLConnection, HttpURLConnection>
{
  private static final String ACCEPT_ENCODING_HEADER = "Accept-encoding";
  private static final String CONTENT_LENGTH_HEADER = "Content-Length";
  private static final String CONTENT_TYPE_HEADER = "Content-Type";
  private static final String GZIP_ENCODING = "gzip";
  private int socketOperationTimeout;
  
  public ParseURLConnectionHttpClient(int paramInt, SSLSessionCache paramSSLSessionCache)
  {
    this.socketOperationTimeout = paramInt;
  }
  
  c executeInternal(b paramb)
  {
    HttpURLConnection localHttpURLConnection = getRequest(paramb);
    paramb = paramb.d();
    if (paramb != null)
    {
      OutputStream localOutputStream = localHttpURLConnection.getOutputStream();
      paramb.writeTo(localOutputStream);
      localOutputStream.flush();
      localOutputStream.close();
    }
    return getResponse(localHttpURLConnection);
  }
  
  HttpURLConnection getRequest(b paramb)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramb.a()).openConnection();
    localHttpURLConnection.setRequestMethod(paramb.b().toString());
    localHttpURLConnection.setConnectTimeout(this.socketOperationTimeout);
    localHttpURLConnection.setReadTimeout(this.socketOperationTimeout);
    localHttpURLConnection.setDoInput(true);
    localHttpURLConnection.setInstanceFollowRedirects(false);
    Iterator localIterator = paramb.c().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    if (disableHttpLibraryAutoDecompress()) {
      localHttpURLConnection.setRequestProperty("Accept-encoding", "gzip");
    }
    paramb = paramb.d();
    if (paramb != null)
    {
      localHttpURLConnection.setRequestProperty("Content-Length", String.valueOf(paramb.getContentLength()));
      localHttpURLConnection.setRequestProperty("Content-Type", paramb.getContentType());
      localHttpURLConnection.setFixedLengthStreamingMode(paramb.getContentLength());
      localHttpURLConnection.setDoOutput(true);
    }
    return localHttpURLConnection;
  }
  
  c getResponse(HttpURLConnection paramHttpURLConnection)
  {
    int i = paramHttpURLConnection.getResponseCode();
    InputStream localInputStream;
    int j;
    String str;
    HashMap localHashMap;
    label56:
    Object localObject2;
    if (i < 400)
    {
      localInputStream = paramHttpURLConnection.getInputStream();
      j = paramHttpURLConnection.getContentLength();
      str = paramHttpURLConnection.getResponseMessage();
      localHashMap = new HashMap();
      Iterator localIterator = paramHttpURLConnection.getHeaderFields().entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Map.Entry)localIterator.next();
      } while ((((Map.Entry)localObject1).getKey() == null) || (((List)((Map.Entry)localObject1).getValue()).size() <= 0));
      localObject2 = ((Map.Entry)localObject1).getKey();
      if (((Map.Entry)localObject1).getValue() != null) {
        break label145;
      }
    }
    label145:
    for (Object localObject1 = "";; localObject1 = (String)((List)((Map.Entry)localObject1).getValue()).get(0))
    {
      localHashMap.put(localObject2, localObject1);
      break label56;
      localInputStream = paramHttpURLConnection.getErrorStream();
      break;
    }
    paramHttpURLConnection = paramHttpURLConnection.getContentType();
    return new c.a().a(i).a(localInputStream).a(j).a(str).a(localHashMap).b(paramHttpURLConnection).a();
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseURLConnectionHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */