package android.support.v7.widget;

import android.support.v4.i.a;
import android.support.v4.i.e;
import android.support.v4.i.h.a;
import android.support.v4.i.h.b;

class be
{
  final a<ao.v, a> a = new a();
  final e<ao.v> b = new e();
  
  private ao.e.c a(ao.v paramv, int paramInt)
  {
    Object localObject2 = null;
    int i = this.a.a(paramv);
    Object localObject1;
    if (i < 0) {
      localObject1 = localObject2;
    }
    a locala;
    do
    {
      do
      {
        return (ao.e.c)localObject1;
        locala = (a)this.a.c(i);
        localObject1 = localObject2;
      } while (locala == null);
      localObject1 = localObject2;
    } while ((locala.a & paramInt) == 0);
    locala.a &= (paramInt ^ 0xFFFFFFFF);
    if (paramInt == 4) {}
    for (paramv = locala.b;; paramv = locala.c)
    {
      localObject1 = paramv;
      if ((locala.a & 0xC) != 0) {
        break;
      }
      this.a.d(i);
      a.a(locala);
      return paramv;
      if (paramInt != 8) {
        break label128;
      }
    }
    label128:
    throw new IllegalArgumentException("Must provide flag PRE or POST");
  }
  
  ao.v a(long paramLong)
  {
    return (ao.v)this.b.a(paramLong);
  }
  
  void a()
  {
    this.a.clear();
    this.b.c();
  }
  
  void a(long paramLong, ao.v paramv)
  {
    this.b.b(paramLong, paramv);
  }
  
  void a(ao.v paramv, ao.e.c paramc)
  {
    a locala2 = (a)this.a.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.a();
      this.a.put(paramv, locala1);
    }
    locala1.b = paramc;
    locala1.a |= 0x4;
  }
  
  void a(b paramb)
  {
    int i = this.a.size() - 1;
    if (i >= 0)
    {
      ao.v localv = (ao.v)this.a.b(i);
      a locala = (a)this.a.d(i);
      if ((locala.a & 0x3) == 3) {
        paramb.a(localv);
      }
      for (;;)
      {
        a.a(locala);
        i -= 1;
        break;
        if ((locala.a & 0x1) != 0)
        {
          if (locala.b == null) {
            paramb.a(localv);
          } else {
            paramb.a(localv, locala.b, locala.c);
          }
        }
        else if ((locala.a & 0xE) == 14) {
          paramb.b(localv, locala.b, locala.c);
        } else if ((locala.a & 0xC) == 12) {
          paramb.c(localv, locala.b, locala.c);
        } else if ((locala.a & 0x4) != 0) {
          paramb.a(localv, locala.b, null);
        } else if ((locala.a & 0x8) != 0) {
          paramb.b(localv, locala.b, locala.c);
        } else if ((locala.a & 0x2) == 0) {}
      }
    }
  }
  
  boolean a(ao.v paramv)
  {
    paramv = (a)this.a.get(paramv);
    return (paramv != null) && ((paramv.a & 0x1) != 0);
  }
  
  ao.e.c b(ao.v paramv)
  {
    return a(paramv, 4);
  }
  
  void b() {}
  
  void b(ao.v paramv, ao.e.c paramc)
  {
    a locala2 = (a)this.a.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.a();
      this.a.put(paramv, locala1);
    }
    locala1.a |= 0x2;
    locala1.b = paramc;
  }
  
  ao.e.c c(ao.v paramv)
  {
    return a(paramv, 8);
  }
  
  void c(ao.v paramv, ao.e.c paramc)
  {
    a locala2 = (a)this.a.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.a();
      this.a.put(paramv, locala1);
    }
    locala1.c = paramc;
    locala1.a |= 0x8;
  }
  
  boolean d(ao.v paramv)
  {
    paramv = (a)this.a.get(paramv);
    return (paramv != null) && ((paramv.a & 0x4) != 0);
  }
  
  void e(ao.v paramv)
  {
    a locala2 = (a)this.a.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.a();
      this.a.put(paramv, locala1);
    }
    locala1.a |= 0x1;
  }
  
  void f(ao.v paramv)
  {
    paramv = (a)this.a.get(paramv);
    if (paramv == null) {
      return;
    }
    paramv.a &= 0xFFFFFFFE;
  }
  
  void g(ao.v paramv)
  {
    int i = this.b.b() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramv == this.b.c(i)) {
          this.b.a(i);
        }
      }
      else
      {
        paramv = (a)this.a.remove(paramv);
        if (paramv != null) {
          a.a(paramv);
        }
        return;
      }
      i -= 1;
    }
  }
  
  public void h(ao.v paramv)
  {
    f(paramv);
  }
  
  static class a
  {
    static h.a<a> d = new h.b(20);
    int a;
    ao.e.c b;
    ao.e.c c;
    
    static a a()
    {
      a locala2 = (a)d.a();
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a();
      }
      return locala1;
    }
    
    static void a(a parama)
    {
      parama.a = 0;
      parama.b = null;
      parama.c = null;
      d.a(parama);
    }
    
    static void b()
    {
      while (d.a() != null) {}
    }
  }
  
  static abstract interface b
  {
    public abstract void a(ao.v paramv);
    
    public abstract void a(ao.v paramv, ao.e.c paramc1, ao.e.c paramc2);
    
    public abstract void b(ao.v paramv, ao.e.c paramc1, ao.e.c paramc2);
    
    public abstract void c(ao.v paramv, ao.e.c paramc1, ao.e.c paramc2);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */