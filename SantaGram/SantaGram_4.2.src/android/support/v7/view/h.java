package android.support.v7.view;

import android.support.v4.j.av;
import android.support.v4.j.az;
import android.support.v4.j.ba;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class h
{
  private final ArrayList<av> a = new ArrayList();
  private long b = -1L;
  private Interpolator c;
  private az d;
  private boolean e;
  private final ba f = new ba()
  {
    private boolean b = false;
    private int c = 0;
    
    void a()
    {
      this.c = 0;
      this.b = false;
      h.b(h.this);
    }
    
    public void a(View paramAnonymousView)
    {
      if (this.b) {}
      do
      {
        return;
        this.b = true;
      } while (h.a(h.this) == null);
      h.a(h.this).a(null);
    }
    
    public void b(View paramAnonymousView)
    {
      int i = this.c + 1;
      this.c = i;
      if (i == h.c(h.this).size())
      {
        if (h.a(h.this) != null) {
          h.a(h.this).b(null);
        }
        a();
      }
    }
  };
  
  private void c()
  {
    this.e = false;
  }
  
  public h a(long paramLong)
  {
    if (!this.e) {
      this.b = paramLong;
    }
    return this;
  }
  
  public h a(av paramav)
  {
    if (!this.e) {
      this.a.add(paramav);
    }
    return this;
  }
  
  public h a(av paramav1, av paramav2)
  {
    this.a.add(paramav1);
    paramav2.b(paramav1.a());
    this.a.add(paramav2);
    return this;
  }
  
  public h a(az paramaz)
  {
    if (!this.e) {
      this.d = paramaz;
    }
    return this;
  }
  
  public h a(Interpolator paramInterpolator)
  {
    if (!this.e) {
      this.c = paramInterpolator;
    }
    return this;
  }
  
  public void a()
  {
    if (this.e) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      av localav = (av)localIterator.next();
      if (this.b >= 0L) {
        localav.a(this.b);
      }
      if (this.c != null) {
        localav.a(this.c);
      }
      if (this.d != null) {
        localav.a(this.f);
      }
      localav.c();
    }
    this.e = true;
  }
  
  public void b()
  {
    if (!this.e) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((av)localIterator.next()).b();
    }
    this.e = false;
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/view/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */