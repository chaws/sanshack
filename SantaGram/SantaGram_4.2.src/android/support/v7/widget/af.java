package android.support.v7.widget;

import android.support.v4.a.a;
import android.support.v4.j.av;
import android.support.v4.j.az;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class af
  extends au
{
  private ArrayList<ao.v> b = new ArrayList();
  private ArrayList<ao.v> c = new ArrayList();
  private ArrayList<b> d = new ArrayList();
  private ArrayList<a> e = new ArrayList();
  private ArrayList<ArrayList<ao.v>> f = new ArrayList();
  private ArrayList<ArrayList<b>> g = new ArrayList();
  private ArrayList<ArrayList<a>> h = new ArrayList();
  private ArrayList<ao.v> i = new ArrayList();
  private ArrayList<ao.v> j = new ArrayList();
  private ArrayList<ao.v> k = new ArrayList();
  private ArrayList<ao.v> l = new ArrayList();
  
  private void a(final a parama)
  {
    final View localView = null;
    final Object localObject = parama.a;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((ao.v)localObject).a)
    {
      ao.v localv = parama.b;
      if (localv != null) {
        localView = localv.a;
      }
      if (localObject != null)
      {
        localObject = android.support.v4.j.af.q((View)localObject).a(g());
        this.l.add(parama.a);
        ((av)localObject).b(parama.e - parama.c);
        ((av)localObject).c(parama.f - parama.d);
        ((av)localObject).a(0.0F).a(new c(parama)
        {
          public void a(View paramAnonymousView)
          {
            af.this.b(parama.a, true);
          }
          
          public void b(View paramAnonymousView)
          {
            localObject.a(null);
            android.support.v4.j.af.c(paramAnonymousView, 1.0F);
            android.support.v4.j.af.a(paramAnonymousView, 0.0F);
            android.support.v4.j.af.b(paramAnonymousView, 0.0F);
            af.this.a(parama.a, true);
            af.h(af.this).remove(parama.a);
            af.e(af.this);
          }
        }).c();
      }
      if (localView != null)
      {
        localObject = android.support.v4.j.af.q(localView);
        this.l.add(parama.b);
        ((av)localObject).b(0.0F).c(0.0F).a(g()).a(1.0F).a(new c(parama)
        {
          public void a(View paramAnonymousView)
          {
            af.this.b(parama.b, false);
          }
          
          public void b(View paramAnonymousView)
          {
            localObject.a(null);
            android.support.v4.j.af.c(localView, 1.0F);
            android.support.v4.j.af.a(localView, 0.0F);
            android.support.v4.j.af.b(localView, 0.0F);
            af.this.a(parama.b, false);
            af.h(af.this).remove(parama.b);
            af.e(af.this);
          }
        }).c();
      }
      return;
    }
  }
  
  private void a(List<a> paramList, ao.v paramv)
  {
    int m = paramList.size() - 1;
    while (m >= 0)
    {
      a locala = (a)paramList.get(m);
      if ((a(locala, paramv)) && (locala.a == null) && (locala.b == null)) {
        paramList.remove(locala);
      }
      m -= 1;
    }
  }
  
  private boolean a(a parama, ao.v paramv)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (parama.b == paramv) {
      parama.b = null;
    }
    for (;;)
    {
      android.support.v4.j.af.c(paramv.a, 1.0F);
      android.support.v4.j.af.a(paramv.a, 0.0F);
      android.support.v4.j.af.b(paramv.a, 0.0F);
      a(paramv, bool1);
      bool1 = true;
      do
      {
        return bool1;
        bool1 = bool2;
      } while (parama.a != paramv);
      parama.a = null;
      bool1 = true;
    }
  }
  
  private void b(a parama)
  {
    if (parama.a != null) {
      a(parama, parama.a);
    }
    if (parama.b != null) {
      a(parama, parama.b);
    }
  }
  
  private void b(final ao.v paramv, final int paramInt1, final int paramInt2, int paramInt3, int paramInt4)
  {
    final Object localObject = paramv.a;
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if (paramInt1 != 0) {
      android.support.v4.j.af.q((View)localObject).b(0.0F);
    }
    if (paramInt2 != 0) {
      android.support.v4.j.af.q((View)localObject).c(0.0F);
    }
    localObject = android.support.v4.j.af.q((View)localObject);
    this.j.add(paramv);
    ((av)localObject).a(d()).a(new c(paramv)
    {
      public void a(View paramAnonymousView)
      {
        af.this.l(paramv);
      }
      
      public void b(View paramAnonymousView)
      {
        localObject.a(null);
        af.this.i(paramv);
        af.g(af.this).remove(paramv);
        af.e(af.this);
      }
      
      public void c(View paramAnonymousView)
      {
        if (paramInt1 != 0) {
          android.support.v4.j.af.a(paramAnonymousView, 0.0F);
        }
        if (paramInt2 != 0) {
          android.support.v4.j.af.b(paramAnonymousView, 0.0F);
        }
      }
    }).c();
  }
  
  private void j()
  {
    if (!b()) {
      h();
    }
  }
  
  private void t(final ao.v paramv)
  {
    final av localav = android.support.v4.j.af.q(paramv.a);
    this.k.add(paramv);
    localav.a(f()).a(0.0F).a(new c(paramv)
    {
      public void a(View paramAnonymousView)
      {
        af.this.k(paramv);
      }
      
      public void b(View paramAnonymousView)
      {
        localav.a(null);
        android.support.v4.j.af.c(paramAnonymousView, 1.0F);
        af.this.h(paramv);
        af.d(af.this).remove(paramv);
        af.e(af.this);
      }
    }).c();
  }
  
  private void u(final ao.v paramv)
  {
    final av localav = android.support.v4.j.af.q(paramv.a);
    this.i.add(paramv);
    localav.a(1.0F).a(e()).a(new c(paramv)
    {
      public void a(View paramAnonymousView)
      {
        af.this.m(paramv);
      }
      
      public void b(View paramAnonymousView)
      {
        localav.a(null);
        af.this.j(paramv);
        af.f(af.this).remove(paramv);
        af.e(af.this);
      }
      
      public void c(View paramAnonymousView)
      {
        android.support.v4.j.af.c(paramAnonymousView, 1.0F);
      }
    }).c();
  }
  
  private void v(ao.v paramv)
  {
    a.a(paramv.a);
    c(paramv);
  }
  
  public void a()
  {
    int m;
    int n;
    label25:
    int i1;
    if (!this.b.isEmpty())
    {
      m = 1;
      if (this.d.isEmpty()) {
        break label76;
      }
      n = 1;
      if (this.e.isEmpty()) {
        break label82;
      }
      i1 = 1;
      label38:
      if (this.c.isEmpty()) {
        break label88;
      }
    }
    label76:
    label82:
    label88:
    for (int i2 = 1;; i2 = 0)
    {
      if ((m != 0) || (n != 0) || (i2 != 0) || (i1 != 0)) {
        break label94;
      }
      return;
      m = 0;
      break;
      n = 0;
      break label25;
      i1 = 0;
      break label38;
    }
    label94:
    final Object localObject1 = this.b.iterator();
    while (((Iterator)localObject1).hasNext()) {
      t((ao.v)((Iterator)localObject1).next());
    }
    this.b.clear();
    Object localObject2;
    label208:
    label282:
    long l1;
    label354:
    long l2;
    if (n != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.d);
      this.g.add(localObject1);
      this.d.clear();
      localObject2 = new Runnable()
      {
        public void run()
        {
          Iterator localIterator = localObject1.iterator();
          while (localIterator.hasNext())
          {
            af.b localb = (af.b)localIterator.next();
            af.a(af.this, localb.a, localb.b, localb.c, localb.d, localb.e);
          }
          localObject1.clear();
          af.a(af.this).remove(localObject1);
        }
      };
      if (m != 0) {
        android.support.v4.j.af.a(((b)((ArrayList)localObject1).get(0)).a.a, (Runnable)localObject2, f());
      }
    }
    else
    {
      if (i1 != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.e);
        this.h.add(localObject1);
        this.e.clear();
        localObject2 = new Runnable()
        {
          public void run()
          {
            Iterator localIterator = localObject1.iterator();
            while (localIterator.hasNext())
            {
              af.a locala = (af.a)localIterator.next();
              af.a(af.this, locala);
            }
            localObject1.clear();
            af.b(af.this).remove(localObject1);
          }
        };
        if (m == 0) {
          break label415;
        }
        android.support.v4.j.af.a(((a)((ArrayList)localObject1).get(0)).a.a, (Runnable)localObject2, f());
      }
      if (i2 == 0) {
        break label422;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.c);
      this.f.add(localObject1);
      this.c.clear();
      localObject2 = new Runnable()
      {
        public void run()
        {
          Iterator localIterator = localObject1.iterator();
          while (localIterator.hasNext())
          {
            ao.v localv = (ao.v)localIterator.next();
            af.a(af.this, localv);
          }
          localObject1.clear();
          af.c(af.this).remove(localObject1);
        }
      };
      if ((m == 0) && (n == 0) && (i1 == 0)) {
        break label442;
      }
      if (m == 0) {
        break label424;
      }
      l1 = f();
      if (n == 0) {
        break label430;
      }
      l2 = d();
      label365:
      if (i1 == 0) {
        break label436;
      }
    }
    label415:
    label422:
    label424:
    label430:
    label436:
    for (long l3 = g();; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      android.support.v4.j.af.a(((ao.v)((ArrayList)localObject1).get(0)).a, (Runnable)localObject2, l1 + l2);
      return;
      ((Runnable)localObject2).run();
      break label208;
      ((Runnable)localObject2).run();
      break label282;
      break;
      l1 = 0L;
      break label354;
      l2 = 0L;
      break label365;
    }
    label442:
    ((Runnable)localObject2).run();
  }
  
  void a(List<ao.v> paramList)
  {
    int m = paramList.size() - 1;
    while (m >= 0)
    {
      android.support.v4.j.af.q(((ao.v)paramList.get(m)).a).b();
      m -= 1;
    }
  }
  
  public boolean a(ao.v paramv)
  {
    v(paramv);
    this.b.add(paramv);
    return true;
  }
  
  public boolean a(ao.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramv.a;
    paramInt1 = (int)(paramInt1 + android.support.v4.j.af.m(paramv.a));
    paramInt2 = (int)(paramInt2 + android.support.v4.j.af.n(paramv.a));
    v(paramv);
    int m = paramInt3 - paramInt1;
    int n = paramInt4 - paramInt2;
    if ((m == 0) && (n == 0))
    {
      i(paramv);
      return false;
    }
    if (m != 0) {
      android.support.v4.j.af.a(localView, -m);
    }
    if (n != 0) {
      android.support.v4.j.af.b(localView, -n);
    }
    this.d.add(new b(paramv, paramInt1, paramInt2, paramInt3, paramInt4, null));
    return true;
  }
  
  public boolean a(ao.v paramv1, ao.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramv1 == paramv2) {
      return a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    float f1 = android.support.v4.j.af.m(paramv1.a);
    float f2 = android.support.v4.j.af.n(paramv1.a);
    float f3 = android.support.v4.j.af.f(paramv1.a);
    v(paramv1);
    int m = (int)(paramInt3 - paramInt1 - f1);
    int n = (int)(paramInt4 - paramInt2 - f2);
    android.support.v4.j.af.a(paramv1.a, f1);
    android.support.v4.j.af.b(paramv1.a, f2);
    android.support.v4.j.af.c(paramv1.a, f3);
    if (paramv2 != null)
    {
      v(paramv2);
      android.support.v4.j.af.a(paramv2.a, -m);
      android.support.v4.j.af.b(paramv2.a, -n);
      android.support.v4.j.af.c(paramv2.a, 0.0F);
    }
    this.e.add(new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4, null));
    return true;
  }
  
  public boolean a(ao.v paramv, List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.a(paramv, paramList));
  }
  
  public boolean b()
  {
    return (!this.c.isEmpty()) || (!this.e.isEmpty()) || (!this.d.isEmpty()) || (!this.b.isEmpty()) || (!this.j.isEmpty()) || (!this.k.isEmpty()) || (!this.i.isEmpty()) || (!this.l.isEmpty()) || (!this.g.isEmpty()) || (!this.f.isEmpty()) || (!this.h.isEmpty());
  }
  
  public boolean b(ao.v paramv)
  {
    v(paramv);
    android.support.v4.j.af.c(paramv.a, 0.0F);
    this.c.add(paramv);
    return true;
  }
  
  public void c()
  {
    int m = this.d.size() - 1;
    Object localObject1;
    Object localObject2;
    while (m >= 0)
    {
      localObject1 = (b)this.d.get(m);
      localObject2 = ((b)localObject1).a.a;
      android.support.v4.j.af.b((View)localObject2, 0.0F);
      android.support.v4.j.af.a((View)localObject2, 0.0F);
      i(((b)localObject1).a);
      this.d.remove(m);
      m -= 1;
    }
    m = this.b.size() - 1;
    while (m >= 0)
    {
      h((ao.v)this.b.get(m));
      this.b.remove(m);
      m -= 1;
    }
    m = this.c.size() - 1;
    while (m >= 0)
    {
      localObject1 = (ao.v)this.c.get(m);
      android.support.v4.j.af.c(((ao.v)localObject1).a, 1.0F);
      j((ao.v)localObject1);
      this.c.remove(m);
      m -= 1;
    }
    m = this.e.size() - 1;
    while (m >= 0)
    {
      b((a)this.e.get(m));
      m -= 1;
    }
    this.e.clear();
    if (!b()) {
      return;
    }
    m = this.g.size() - 1;
    int n;
    while (m >= 0)
    {
      localObject1 = (ArrayList)this.g.get(m);
      n = ((ArrayList)localObject1).size() - 1;
      while (n >= 0)
      {
        localObject2 = (b)((ArrayList)localObject1).get(n);
        View localView = ((b)localObject2).a.a;
        android.support.v4.j.af.b(localView, 0.0F);
        android.support.v4.j.af.a(localView, 0.0F);
        i(((b)localObject2).a);
        ((ArrayList)localObject1).remove(n);
        if (((ArrayList)localObject1).isEmpty()) {
          this.g.remove(localObject1);
        }
        n -= 1;
      }
      m -= 1;
    }
    m = this.f.size() - 1;
    while (m >= 0)
    {
      localObject1 = (ArrayList)this.f.get(m);
      n = ((ArrayList)localObject1).size() - 1;
      while (n >= 0)
      {
        localObject2 = (ao.v)((ArrayList)localObject1).get(n);
        android.support.v4.j.af.c(((ao.v)localObject2).a, 1.0F);
        j((ao.v)localObject2);
        ((ArrayList)localObject1).remove(n);
        if (((ArrayList)localObject1).isEmpty()) {
          this.f.remove(localObject1);
        }
        n -= 1;
      }
      m -= 1;
    }
    m = this.h.size() - 1;
    while (m >= 0)
    {
      localObject1 = (ArrayList)this.h.get(m);
      n = ((ArrayList)localObject1).size() - 1;
      while (n >= 0)
      {
        b((a)((ArrayList)localObject1).get(n));
        if (((ArrayList)localObject1).isEmpty()) {
          this.h.remove(localObject1);
        }
        n -= 1;
      }
      m -= 1;
    }
    a(this.k);
    a(this.j);
    a(this.i);
    a(this.l);
    h();
  }
  
  public void c(ao.v paramv)
  {
    View localView = paramv.a;
    android.support.v4.j.af.q(localView).b();
    int m = this.d.size() - 1;
    while (m >= 0)
    {
      if (((b)this.d.get(m)).a == paramv)
      {
        android.support.v4.j.af.b(localView, 0.0F);
        android.support.v4.j.af.a(localView, 0.0F);
        i(paramv);
        this.d.remove(m);
      }
      m -= 1;
    }
    a(this.e, paramv);
    if (this.b.remove(paramv))
    {
      android.support.v4.j.af.c(localView, 1.0F);
      h(paramv);
    }
    if (this.c.remove(paramv))
    {
      android.support.v4.j.af.c(localView, 1.0F);
      j(paramv);
    }
    m = this.h.size() - 1;
    ArrayList localArrayList;
    while (m >= 0)
    {
      localArrayList = (ArrayList)this.h.get(m);
      a(localArrayList, paramv);
      if (localArrayList.isEmpty()) {
        this.h.remove(m);
      }
      m -= 1;
    }
    m = this.g.size() - 1;
    if (m >= 0)
    {
      localArrayList = (ArrayList)this.g.get(m);
      int n = localArrayList.size() - 1;
      for (;;)
      {
        if (n >= 0)
        {
          if (((b)localArrayList.get(n)).a != paramv) {
            break label299;
          }
          android.support.v4.j.af.b(localView, 0.0F);
          android.support.v4.j.af.a(localView, 0.0F);
          i(paramv);
          localArrayList.remove(n);
          if (localArrayList.isEmpty()) {
            this.g.remove(m);
          }
        }
        m -= 1;
        break;
        label299:
        n -= 1;
      }
    }
    m = this.f.size() - 1;
    while (m >= 0)
    {
      localArrayList = (ArrayList)this.f.get(m);
      if (localArrayList.remove(paramv))
      {
        android.support.v4.j.af.c(localView, 1.0F);
        j(paramv);
        if (localArrayList.isEmpty()) {
          this.f.remove(m);
        }
      }
      m -= 1;
    }
    if ((!this.k.remove(paramv)) || ((!this.i.remove(paramv)) || ((!this.l.remove(paramv)) || (this.j.remove(paramv))))) {}
    j();
  }
  
  private static class a
  {
    public ao.v a;
    public ao.v b;
    public int c;
    public int d;
    public int e;
    public int f;
    
    private a(ao.v paramv1, ao.v paramv2)
    {
      this.a = paramv1;
      this.b = paramv2;
    }
    
    private a(ao.v paramv1, ao.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramv1, paramv2);
      this.c = paramInt1;
      this.d = paramInt2;
      this.e = paramInt3;
      this.f = paramInt4;
    }
    
    public String toString()
    {
      return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
    }
  }
  
  private static class b
  {
    public ao.v a;
    public int b;
    public int c;
    public int d;
    public int e;
    
    private b(ao.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramv;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramInt4;
    }
  }
  
  private static class c
    implements az
  {
    public void a(View paramView) {}
    
    public void b(View paramView) {}
    
    public void c(View paramView) {}
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */