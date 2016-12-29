package com.parse;

import a.g;
import android.net.SSLSessionCache;
import com.parse.a.a;
import com.parse.a.b;
import com.parse.a.b.a;
import com.parse.a.b.b;
import com.parse.a.c;
import com.parse.a.c.a;
import com.parse.a.d;
import com.parse.a.d.a;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

class ParseOkHttpClient
  extends ParseHttpClient<Request, Response>
{
  private static final String OKHTTP_DELETE = "DELETE";
  private static final String OKHTTP_GET = "GET";
  private static final String OKHTTP_POST = "POST";
  private static final String OKHTTP_PUT = "PUT";
  private OkHttpClient okHttpClient;
  
  public ParseOkHttpClient(int paramInt, SSLSessionCache paramSSLSessionCache)
  {
    paramSSLSessionCache = new OkHttpClient.Builder();
    paramSSLSessionCache.connectTimeout(paramInt, TimeUnit.MILLISECONDS);
    paramSSLSessionCache.readTimeout(paramInt, TimeUnit.MILLISECONDS);
    paramSSLSessionCache.followRedirects(false);
    this.okHttpClient = paramSSLSessionCache.build();
  }
  
  private b getParseHttpRequest(Request paramRequest)
  {
    b.a locala = new b.a();
    Object localObject = paramRequest.method();
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Invalid http method " + paramRequest.method());
        if (((String)localObject).equals("GET"))
        {
          i = 0;
          continue;
          if (((String)localObject).equals("DELETE"))
          {
            i = 1;
            continue;
            if (((String)localObject).equals("POST"))
            {
              i = 2;
              continue;
              if (((String)localObject).equals("PUT")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    locala.a(b.b.a);
    for (;;)
    {
      locala.a(paramRequest.url().toString());
      localObject = paramRequest.headers().toMultimap().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        locala.a((String)localEntry.getKey(), (String)((List)localEntry.getValue()).get(0));
      }
      locala.a(b.b.d);
      continue;
      locala.a(b.b.b);
      continue;
      locala.a(b.b.c);
    }
    paramRequest = (ParseOkHttpRequestBody)paramRequest.body();
    if (paramRequest != null) {
      locala.a(paramRequest.getParseHttpBody());
    }
    return locala.a();
  }
  
  void addExternalInterceptor(final d paramd)
  {
    OkHttpClient.Builder localBuilder = this.okHttpClient.newBuilder();
    localBuilder.networkInterceptors().add(new Interceptor()
    {
      public Response intercept(final Interceptor.Chain paramAnonymousChain)
      {
        final Object localObject1 = paramAnonymousChain.request();
        final Object localObject2 = ParseOkHttpClient.this.getParseHttpRequest((Request)localObject1);
        localObject1 = new g();
        paramAnonymousChain = paramd.intercept(new d.a()
        {
          public b getRequest()
          {
            return localObject2;
          }
          
          public c proceed(b paramAnonymous2b)
          {
            paramAnonymous2b = ParseOkHttpClient.this.getRequest(paramAnonymous2b);
            paramAnonymous2b = paramAnonymousChain.proceed(paramAnonymous2b);
            localObject1.a(paramAnonymous2b);
            return ParseOkHttpClient.this.getResponse(paramAnonymous2b);
          }
        });
        localObject1 = ((Response)((g)localObject1).a()).newBuilder();
        ((Response.Builder)localObject1).code(paramAnonymousChain.a()).message(paramAnonymousChain.d());
        if (paramAnonymousChain.f() != null)
        {
          localObject2 = paramAnonymousChain.f().entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            ((Response.Builder)localObject1).header((String)localEntry.getKey(), (String)localEntry.getValue());
          }
        }
        ((Response.Builder)localObject1).body(new ResponseBody()
        {
          public long contentLength()
          {
            return paramAnonymousChain.c();
          }
          
          public MediaType contentType()
          {
            if (paramAnonymousChain.e() == null) {
              return null;
            }
            return MediaType.parse(paramAnonymousChain.e());
          }
          
          public BufferedSource source()
          {
            if (paramAnonymousChain.b() == null) {
              return null;
            }
            return Okio.buffer(Okio.source(paramAnonymousChain.b()));
          }
        });
        return ((Response.Builder)localObject1).build();
      }
    });
    this.okHttpClient = localBuilder.build();
  }
  
  c executeInternal(b paramb)
  {
    paramb = getRequest(paramb);
    return getResponse(this.okHttpClient.newCall(paramb).execute());
  }
  
  Request getRequest(b paramb)
  {
    Request.Builder localBuilder = new Request.Builder();
    b.b localb = paramb.b();
    switch (localb)
    {
    default: 
      throw new IllegalStateException("Unsupported http method " + localb.toString());
    case ???: 
      localBuilder.get();
    }
    for (;;)
    {
      localBuilder.url(paramb.a());
      localObject = new Headers.Builder();
      Iterator localIterator = paramb.c().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((Headers.Builder)localObject).add((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      localBuilder.delete();
    }
    localBuilder.headers(((Headers.Builder)localObject).build());
    Object localObject = paramb.d();
    paramb = null;
    if ((localObject instanceof ParseByteArrayHttpBody)) {
      paramb = new ParseOkHttpRequestBody((a)localObject);
    }
    switch (localb)
    {
    }
    for (;;)
    {
      return localBuilder.build();
      localBuilder.put(paramb);
      continue;
      localBuilder.post(paramb);
    }
  }
  
  c getResponse(Response paramResponse)
  {
    int i = paramResponse.code();
    InputStream localInputStream = paramResponse.body().byteStream();
    int j = (int)paramResponse.body().contentLength();
    String str = paramResponse.message();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramResponse.headers().names().iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localHashMap.put(localObject, paramResponse.header((String)localObject));
    }
    localIterator = null;
    Object localObject = paramResponse.body();
    paramResponse = localIterator;
    if (localObject != null)
    {
      paramResponse = localIterator;
      if (((ResponseBody)localObject).contentType() != null) {
        paramResponse = ((ResponseBody)localObject).contentType().toString();
      }
    }
    return new c.a().a(i).a(localInputStream).a(j).a(str).a(localHashMap).b(paramResponse).a();
  }
  
  private static class ParseOkHttpRequestBody
    extends RequestBody
  {
    private a parseBody;
    
    public ParseOkHttpRequestBody(a parama)
    {
      this.parseBody = parama;
    }
    
    public long contentLength()
    {
      return this.parseBody.getContentLength();
    }
    
    public MediaType contentType()
    {
      if (this.parseBody.getContentType() == null) {
        return null;
      }
      return MediaType.parse(this.parseBody.getContentType());
    }
    
    public a getParseHttpBody()
    {
      return this.parseBody;
    }
    
    public void writeTo(BufferedSink paramBufferedSink)
    {
      this.parseBody.writeTo(paramBufferedSink.outputStream());
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseOkHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */