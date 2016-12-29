package android.support.v4.j.a;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class h
{
  private static final a a = new d();
  private final Object b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      a = new c();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new b();
      return;
    }
  }
  
  public h()
  {
    this.b = a.a(this);
  }
  
  public h(Object paramObject)
  {
    this.b = paramObject;
  }
  
  public c a(int paramInt)
  {
    return null;
  }
  
  public Object a()
  {
    return this.b;
  }
  
  public List<c> a(String paramString, int paramInt)
  {
    return null;
  }
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
  
  public c b(int paramInt)
  {
    return null;
  }
  
  static abstract interface a
  {
    public abstract Object a(h paramh);
  }
  
  static class b
    extends h.d
  {
    public Object a(final h paramh)
    {
      i.a(new i.a()
      {
        public Object a(int paramAnonymousInt)
        {
          c localc = paramh.a(paramAnonymousInt);
          if (localc == null) {
            return null;
          }
          return localc.a();
        }
        
        public List<Object> a(String paramAnonymousString, int paramAnonymousInt)
        {
          paramAnonymousString = paramh.a(paramAnonymousString, paramAnonymousInt);
          ArrayList localArrayList = new ArrayList();
          int i = paramAnonymousString.size();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            localArrayList.add(((c)paramAnonymousString.get(paramAnonymousInt)).a());
            paramAnonymousInt += 1;
          }
          return localArrayList;
        }
        
        public boolean a(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
        {
          return paramh.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
        }
      });
    }
  }
  
  static class c
    extends h.d
  {
    public Object a(final h paramh)
    {
      j.a(new j.a()
      {
        public Object a(int paramAnonymousInt)
        {
          c localc = paramh.a(paramAnonymousInt);
          if (localc == null) {
            return null;
          }
          return localc.a();
        }
        
        public List<Object> a(String paramAnonymousString, int paramAnonymousInt)
        {
          paramAnonymousString = paramh.a(paramAnonymousString, paramAnonymousInt);
          ArrayList localArrayList = new ArrayList();
          int i = paramAnonymousString.size();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            localArrayList.add(((c)paramAnonymousString.get(paramAnonymousInt)).a());
            paramAnonymousInt += 1;
          }
          return localArrayList;
        }
        
        public boolean a(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
        {
          return paramh.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
        }
        
        public Object b(int paramAnonymousInt)
        {
          c localc = paramh.b(paramAnonymousInt);
          if (localc == null) {
            return null;
          }
          return localc.a();
        }
      });
    }
  }
  
  static class d
    implements h.a
  {
    public Object a(h paramh)
    {
      return null;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/j/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */