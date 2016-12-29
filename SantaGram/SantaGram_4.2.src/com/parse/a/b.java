package com.parse.a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private final String a;
  private final b b;
  private final Map<String, String> c;
  private final a d;
  
  private b(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = Collections.unmodifiableMap(new HashMap(a.c(parama)));
    this.d = a.d(parama);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String a(String paramString)
  {
    return (String)this.c.get(paramString);
  }
  
  public b b()
  {
    return this.b;
  }
  
  public Map<String, String> c()
  {
    return this.c;
  }
  
  public a d()
  {
    return this.d;
  }
  
  public static final class a
  {
    private String a;
    private b.b b;
    private Map<String, String> c;
    private a d;
    
    public a()
    {
      this.c = new HashMap();
    }
    
    public a(b paramb)
    {
      this.a = b.a(paramb);
      this.b = b.b(paramb);
      this.c = new HashMap(b.c(paramb));
      this.d = b.d(paramb);
    }
    
    public a a(a parama)
    {
      this.d = parama;
      return this;
    }
    
    public a a(b.b paramb)
    {
      this.b = paramb;
      return this;
    }
    
    public a a(String paramString)
    {
      this.a = paramString;
      return this;
    }
    
    public a a(String paramString1, String paramString2)
    {
      this.c.put(paramString1, paramString2);
      return this;
    }
    
    public b a()
    {
      return new b(this, null);
    }
  }
  
  public static enum b
  {
    private b() {}
    
    public static b a(String paramString)
    {
      int i = -1;
      switch (paramString.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          throw new IllegalArgumentException("Invalid http method: <" + paramString + ">");
          if (paramString.equals("GET"))
          {
            i = 0;
            continue;
            if (paramString.equals("POST"))
            {
              i = 1;
              continue;
              if (paramString.equals("PUT"))
              {
                i = 2;
                continue;
                if (paramString.equals("DELETE")) {
                  i = 3;
                }
              }
            }
          }
          break;
        }
      }
      return a;
      return b;
      return c;
      return d;
    }
    
    public String toString()
    {
      switch (b.1.a[ordinal()])
      {
      default: 
        throw new IllegalArgumentException("Invalid http method: <" + this + ">");
      case 1: 
        return "GET";
      case 2: 
        return "POST";
      case 3: 
        return "PUT";
      }
      return "DELETE";
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */