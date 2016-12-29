package com.parse;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.net.http.AndroidHttpClient;
import com.parse.a.a;
import com.parse.a.b;
import com.parse.a.b.b;
import com.parse.a.c;
import com.parse.a.c.a;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class ParseApacheHttpClient
  extends ParseHttpClient<HttpUriRequest, HttpResponse>
{
  private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
  private DefaultHttpClient apacheClient;
  
  public ParseApacheHttpClient(int paramInt, SSLSessionCache paramSSLSessionCache)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, paramInt);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, paramInt);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpClientParams.setRedirecting(localBasicHttpParams, false);
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    localSchemeRegistry.register(new Scheme("https", SSLCertificateSocketFactory.getHttpSocketFactory(paramInt, paramSSLSessionCache), 443));
    paramSSLSessionCache = System.getProperty("http.maxConnections");
    if (paramSSLSessionCache != null)
    {
      paramInt = Integer.parseInt(paramSSLSessionCache);
      ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(paramInt));
      ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, paramInt);
    }
    paramSSLSessionCache = System.getProperty("http.proxyHost");
    String str = System.getProperty("http.proxyPort");
    if ((paramSSLSessionCache != null) && (paramSSLSessionCache.length() != 0) && (str != null) && (str.length() != 0)) {
      localBasicHttpParams.setParameter("http.route.default-proxy", new HttpHost(paramSSLSessionCache, Integer.parseInt(str), "http"));
    }
    this.apacheClient = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
    this.apacheClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
  }
  
  c executeInternal(b paramb)
  {
    paramb = getRequest(paramb);
    return getResponse(this.apacheClient.execute(paramb));
  }
  
  HttpUriRequest getRequest(b paramb)
  {
    if (paramb == null) {
      throw new IllegalArgumentException("ParseHttpRequest passed to getApacheRequest should not be null.");
    }
    b.b localb = paramb.b();
    Object localObject = paramb.a();
    switch (localb)
    {
    default: 
      throw new IllegalStateException("Unsupported http method " + localb.toString());
    case ???: 
      localObject = new HttpGet((String)localObject);
    }
    for (;;)
    {
      Iterator localIterator = paramb.c().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((HttpUriRequest)localObject).setHeader((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      localObject = new HttpDelete((String)localObject);
      continue;
      localObject = new HttpPost((String)localObject);
      continue;
      localObject = new HttpPut((String)localObject);
    }
    AndroidHttpClient.modifyRequestToAcceptGzipResponse((HttpRequest)localObject);
    paramb = paramb.d();
    switch (localb)
    {
    default: 
      return (HttpUriRequest)localObject;
    case ???: 
      ((HttpPost)localObject).setEntity(new ParseApacheHttpEntity(paramb));
      return (HttpUriRequest)localObject;
    }
    ((HttpPut)localObject).setEntity(new ParseApacheHttpEntity(paramb));
    return (HttpUriRequest)localObject;
  }
  
  c getResponse(HttpResponse paramHttpResponse)
  {
    int j = 0;
    if (paramHttpResponse == null) {
      throw new IllegalArgumentException("HttpResponse passed to getResponse should not be null.");
    }
    int k = paramHttpResponse.getStatusLine().getStatusCode();
    if (disableHttpLibraryAutoDecompress()) {}
    int i;
    String str;
    HashMap localHashMap;
    for (InputStream localInputStream = paramHttpResponse.getEntity().getContent();; localInputStream = AndroidHttpClient.getUngzippedContent(paramHttpResponse.getEntity()))
    {
      i = -1;
      arrayOfHeader = paramHttpResponse.getHeaders("Content-Length");
      if (arrayOfHeader.length > 0) {
        i = Integer.parseInt(arrayOfHeader[0].getValue());
      }
      str = paramHttpResponse.getStatusLine().getReasonPhrase();
      localHashMap = new HashMap();
      arrayOfHeader = paramHttpResponse.getAllHeaders();
      int m = arrayOfHeader.length;
      while (j < m)
      {
        localObject = arrayOfHeader[j];
        localHashMap.put(((Header)localObject).getName(), ((Header)localObject).getValue());
        j += 1;
      }
    }
    if (!disableHttpLibraryAutoDecompress()) {
      localHashMap.remove("Content-Encoding");
    }
    Header[] arrayOfHeader = null;
    Object localObject = paramHttpResponse.getEntity();
    paramHttpResponse = arrayOfHeader;
    if (localObject != null)
    {
      paramHttpResponse = arrayOfHeader;
      if (((HttpEntity)localObject).getContentType() != null) {
        paramHttpResponse = ((HttpEntity)localObject).getContentType().getValue();
      }
    }
    return new c.a().a(k).a(localInputStream).a(i).a(str).a(localHashMap).b(paramHttpResponse).a();
  }
  
  private static class ParseApacheHttpEntity
    extends InputStreamEntity
  {
    private a parseBody;
    
    public ParseApacheHttpEntity(a parama)
    {
      super(parama.getContentLength());
      super.setContentType(parama.getContentType());
      this.parseBody = parama;
    }
    
    public void writeTo(OutputStream paramOutputStream)
    {
      this.parseBody.writeTo(paramOutputStream);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseApacheHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */