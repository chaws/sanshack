package com.parse.a;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private final int a;
  private final InputStream b;
  private final long c;
  private final String d;
  private final Map<String, String> e;
  private final String f;
  
  private c(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = Collections.unmodifiableMap(new HashMap(a.e(parama)));
    this.f = a.f(parama);
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String a(String paramString)
  {
    return (String)this.e.get(paramString);
  }
  
  public InputStream b()
  {
    return this.b;
  }
  
  public long c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public Map<String, String> f()
  {
    return this.e;
  }
  
  public static final class a
  {
    private int a;
    private InputStream b;
    private long c;
    private String d;
    private Map<String, String> e;
    private String f;
    
    public a()
    {
      this.c = -1L;
      this.e = new HashMap();
    }
    
    public a(c paramc)
    {
      a(paramc.a());
      a(paramc.b());
      a(paramc.c());
      b(paramc.e());
      a(paramc.f());
      a(paramc.d());
    }
    
    public a a(int paramInt)
    {
      this.a = paramInt;
      return this;
    }
    
    public a a(long paramLong)
    {
      this.c = paramLong;
      return this;
    }
    
    public a a(InputStream paramInputStream)
    {
      this.b = paramInputStream;
      return this;
    }
    
    public a a(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public a a(Map<String, String> paramMap)
    {
      this.e = new HashMap(paramMap);
      return this;
    }
    
    public c a()
    {
      return new c(this, null);
    }
    
    public a b(String paramString)
    {
      this.f = paramString;
      return this;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */