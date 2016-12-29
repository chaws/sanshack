package com.parse;

import android.net.SSLSessionCache;
import android.os.Build.VERSION;
import com.parse.a.b;
import com.parse.a.c;
import com.parse.a.d;
import com.parse.a.d.a;
import java.util.ArrayList;
import java.util.List;

abstract class ParseHttpClient<LibraryRequest, LibraryResponse>
{
  private static final String APACHE_HTTPCLIENT_NAME = "org.apache.http";
  private static final String KEEP_ALIVE_PROPERTY_NAME = "http.keepAlive";
  private static final String MAX_CONNECTIONS_PROPERTY_NAME = "http.maxConnections";
  private static final String OKHTTPCLIENT_PATH = "okhttp3.OkHttpClient";
  private static final String OKHTTP_NAME = "com.squareup.okhttp3";
  private static final String TAG = "com.parse.ParseHttpClient";
  private static final String URLCONNECTION_NAME = "net.java.URLConnection";
  private List<d> externalInterceptors;
  private boolean hasExecuted;
  private List<d> internalInterceptors;
  
  public static ParseHttpClient createClient(int paramInt, SSLSessionCache paramSSLSessionCache)
  {
    String str;
    if (hasOkHttpOnClasspath())
    {
      str = "com.squareup.okhttp3";
      paramSSLSessionCache = new ParseOkHttpClient(paramInt, paramSSLSessionCache);
    }
    for (;;)
    {
      PLog.i("com.parse.ParseHttpClient", "Using " + str + " library for networking communication.");
      return paramSSLSessionCache;
      if (Build.VERSION.SDK_INT >= 19)
      {
        str = "net.java.URLConnection";
        paramSSLSessionCache = new ParseURLConnectionHttpClient(paramInt, paramSSLSessionCache);
      }
      else
      {
        str = "org.apache.http";
        paramSSLSessionCache = new ParseApacheHttpClient(paramInt, paramSSLSessionCache);
      }
    }
  }
  
  private static boolean hasOkHttpOnClasspath()
  {
    try
    {
      Class.forName("okhttp3.OkHttpClient");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  public static void setKeepAlive(boolean paramBoolean)
  {
    System.setProperty("http.keepAlive", String.valueOf(paramBoolean));
  }
  
  public static void setMaxConnections(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max connections should be large than 0");
    }
    System.setProperty("http.maxConnections", String.valueOf(paramInt));
  }
  
  void addExternalInterceptor(d paramd)
  {
    if (this.externalInterceptors == null) {
      this.externalInterceptors = new ArrayList();
    }
    this.externalInterceptors.add(paramd);
  }
  
  void addInternalInterceptor(d paramd)
  {
    if (this.hasExecuted) {
      throw new IllegalStateException("`ParseHttpClient#addInternalInterceptor(ParseNetworkInterceptor)` can only be invoked before `ParseHttpClient` execute any request");
    }
    if (this.internalInterceptors == null) {
      this.internalInterceptors = new ArrayList();
    }
    this.internalInterceptors.add(paramd);
  }
  
  boolean disableHttpLibraryAutoDecompress()
  {
    return (this.externalInterceptors != null) && (this.externalInterceptors.size() > 0);
  }
  
  public final c execute(b paramb)
  {
    if (!this.hasExecuted) {
      this.hasExecuted = true;
    }
    return new ParseNetworkInterceptorChain(0, 0, paramb).proceed(paramb);
  }
  
  abstract c executeInternal(b paramb);
  
  abstract LibraryRequest getRequest(b paramb);
  
  abstract c getResponse(LibraryResponse paramLibraryResponse);
  
  private class ParseNetworkInterceptorChain
    implements d.a
  {
    private final int externalIndex;
    private final int internalIndex;
    private final b request;
    
    ParseNetworkInterceptorChain(int paramInt1, int paramInt2, b paramb)
    {
      this.internalIndex = paramInt1;
      this.externalIndex = paramInt2;
      this.request = paramb;
    }
    
    public b getRequest()
    {
      return this.request;
    }
    
    public c proceed(b paramb)
    {
      if ((ParseHttpClient.this.internalInterceptors != null) && (this.internalIndex < ParseHttpClient.this.internalInterceptors.size()))
      {
        paramb = new ParseNetworkInterceptorChain(ParseHttpClient.this, this.internalIndex + 1, this.externalIndex, paramb);
        return ((d)ParseHttpClient.this.internalInterceptors.get(this.internalIndex)).intercept(paramb);
      }
      if ((ParseHttpClient.this.externalInterceptors != null) && (this.externalIndex < ParseHttpClient.this.externalInterceptors.size()))
      {
        paramb = new ParseNetworkInterceptorChain(ParseHttpClient.this, this.internalIndex, this.externalIndex + 1, paramb);
        return ((d)ParseHttpClient.this.externalInterceptors.get(this.externalIndex)).intercept(paramb);
      }
      return ParseHttpClient.this.executeInternal(paramb);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */