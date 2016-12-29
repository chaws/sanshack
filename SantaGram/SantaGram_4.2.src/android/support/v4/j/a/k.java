package android.support.v4.j.a;

import android.os.Build.VERSION;

public class k
{
  private static final c a = new e();
  private final Object b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new d();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      a = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new a();
      return;
    }
  }
  
  public k(Object paramObject)
  {
    this.b = paramObject;
  }
  
  public void a(int paramInt)
  {
    a.b(this.b, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    a.a(this.b, paramBoolean);
  }
  
  public void b(int paramInt)
  {
    a.a(this.b, paramInt);
  }
  
  public void c(int paramInt)
  {
    a.e(this.b, paramInt);
  }
  
  public void d(int paramInt)
  {
    a.c(this.b, paramInt);
  }
  
  public void e(int paramInt)
  {
    a.d(this.b, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (k)paramObject;
        if (this.b != null) {
          break;
        }
      } while (((k)paramObject).b == null);
      return false;
    } while (this.b.equals(((k)paramObject).b));
    return false;
  }
  
  public void f(int paramInt)
  {
    a.f(this.b, paramInt);
  }
  
  public void g(int paramInt)
  {
    a.g(this.b, paramInt);
  }
  
  public int hashCode()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.hashCode();
  }
  
  static class a
    extends k.e
  {
    public void a(Object paramObject, int paramInt)
    {
      l.a(paramObject, paramInt);
    }
    
    public void a(Object paramObject, boolean paramBoolean)
    {
      l.a(paramObject, paramBoolean);
    }
    
    public void b(Object paramObject, int paramInt)
    {
      l.b(paramObject, paramInt);
    }
    
    public void c(Object paramObject, int paramInt)
    {
      l.c(paramObject, paramInt);
    }
    
    public void d(Object paramObject, int paramInt)
    {
      l.d(paramObject, paramInt);
    }
    
    public void e(Object paramObject, int paramInt)
    {
      l.e(paramObject, paramInt);
    }
  }
  
  static class b
    extends k.a
  {
    public void f(Object paramObject, int paramInt)
    {
      m.a(paramObject, paramInt);
    }
    
    public void g(Object paramObject, int paramInt)
    {
      m.b(paramObject, paramInt);
    }
  }
  
  static abstract interface c
  {
    public abstract void a(Object paramObject, int paramInt);
    
    public abstract void a(Object paramObject, boolean paramBoolean);
    
    public abstract void b(Object paramObject, int paramInt);
    
    public abstract void c(Object paramObject, int paramInt);
    
    public abstract void d(Object paramObject, int paramInt);
    
    public abstract void e(Object paramObject, int paramInt);
    
    public abstract void f(Object paramObject, int paramInt);
    
    public abstract void g(Object paramObject, int paramInt);
  }
  
  static class d
    extends k.b
  {}
  
  static class e
    implements k.c
  {
    public void a(Object paramObject, int paramInt) {}
    
    public void a(Object paramObject, boolean paramBoolean) {}
    
    public void b(Object paramObject, int paramInt) {}
    
    public void c(Object paramObject, int paramInt) {}
    
    public void d(Object paramObject, int paramInt) {}
    
    public void e(Object paramObject, int paramInt) {}
    
    public void f(Object paramObject, int paramInt) {}
    
    public void g(Object paramObject, int paramInt) {}
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/j/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */