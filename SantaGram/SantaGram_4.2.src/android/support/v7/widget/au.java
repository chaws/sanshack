package android.support.v7.widget;

import android.view.View;

public abstract class au
  extends ao.e
{
  boolean a = true;
  
  public final void a(ao.v paramv, boolean paramBoolean)
  {
    d(paramv, paramBoolean);
    e(paramv);
  }
  
  public abstract boolean a(ao.v paramv);
  
  public abstract boolean a(ao.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean a(ao.v paramv, ao.e.c paramc1, ao.e.c paramc2)
  {
    int k = paramc1.a;
    int m = paramc1.b;
    paramc1 = paramv.a;
    int i;
    if (paramc2 == null)
    {
      i = paramc1.getLeft();
      if (paramc2 != null) {
        break label103;
      }
    }
    label103:
    for (int j = paramc1.getTop();; j = paramc2.b)
    {
      if ((paramv.q()) || ((k == i) && (m == j))) {
        break label112;
      }
      paramc1.layout(i, j, paramc1.getWidth() + i, paramc1.getHeight() + j);
      return a(paramv, k, m, i, j);
      i = paramc2.a;
      break;
    }
    label112:
    return a(paramv);
  }
  
  public abstract boolean a(ao.v paramv1, ao.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean a(ao.v paramv1, ao.v paramv2, ao.e.c paramc1, ao.e.c paramc2)
  {
    int k = paramc1.a;
    int m = paramc1.b;
    int i;
    if (paramv2.c()) {
      i = paramc1.a;
    }
    for (int j = paramc1.b;; j = paramc2.b)
    {
      return a(paramv1, paramv2, k, m, i, j);
      i = paramc2.a;
    }
  }
  
  public final void b(ao.v paramv, boolean paramBoolean)
  {
    c(paramv, paramBoolean);
  }
  
  public abstract boolean b(ao.v paramv);
  
  public boolean b(ao.v paramv, ao.e.c paramc1, ao.e.c paramc2)
  {
    if ((paramc1 != null) && ((paramc1.a != paramc2.a) || (paramc1.b != paramc2.b))) {
      return a(paramv, paramc1.a, paramc1.b, paramc2.a, paramc2.b);
    }
    return b(paramv);
  }
  
  public void c(ao.v paramv, boolean paramBoolean) {}
  
  public boolean c(ao.v paramv, ao.e.c paramc1, ao.e.c paramc2)
  {
    if ((paramc1.a != paramc2.a) || (paramc1.b != paramc2.b)) {
      return a(paramv, paramc1.a, paramc1.b, paramc2.a, paramc2.b);
    }
    i(paramv);
    return false;
  }
  
  public void d(ao.v paramv, boolean paramBoolean) {}
  
  public boolean g(ao.v paramv)
  {
    return (!this.a) || (paramv.n());
  }
  
  public final void h(ao.v paramv)
  {
    o(paramv);
    e(paramv);
  }
  
  public final void i(ao.v paramv)
  {
    s(paramv);
    e(paramv);
  }
  
  public final void j(ao.v paramv)
  {
    q(paramv);
    e(paramv);
  }
  
  public final void k(ao.v paramv)
  {
    n(paramv);
  }
  
  public final void l(ao.v paramv)
  {
    r(paramv);
  }
  
  public final void m(ao.v paramv)
  {
    p(paramv);
  }
  
  public void n(ao.v paramv) {}
  
  public void o(ao.v paramv) {}
  
  public void p(ao.v paramv) {}
  
  public void q(ao.v paramv) {}
  
  public void r(ao.v paramv) {}
  
  public void s(ao.v paramv) {}
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */