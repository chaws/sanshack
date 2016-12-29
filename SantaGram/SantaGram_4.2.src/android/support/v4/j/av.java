package android.support.v4.j;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class av
{
  static final g a = new a();
  private WeakReference<View> b;
  private Runnable c = null;
  private Runnable d = null;
  private int e = -1;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      a = new f();
      return;
    }
    if (i >= 19)
    {
      a = new e();
      return;
    }
    if (i >= 18)
    {
      a = new c();
      return;
    }
    if (i >= 16)
    {
      a = new d();
      return;
    }
    if (i >= 14)
    {
      a = new b();
      return;
    }
  }
  
  av(View paramView)
  {
    this.b = new WeakReference(paramView);
  }
  
  public long a()
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      return a.a(this, localView);
    }
    return 0L;
  }
  
  public av a(float paramFloat)
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.a(this, localView, paramFloat);
    }
    return this;
  }
  
  public av a(long paramLong)
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.a(this, localView, paramLong);
    }
    return this;
  }
  
  public av a(az paramaz)
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.a(this, localView, paramaz);
    }
    return this;
  }
  
  public av a(bb parambb)
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.a(this, localView, parambb);
    }
    return this;
  }
  
  public av a(Interpolator paramInterpolator)
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.a(this, localView, paramInterpolator);
    }
    return this;
  }
  
  public av b(float paramFloat)
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.b(this, localView, paramFloat);
    }
    return this;
  }
  
  public av b(long paramLong)
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.b(this, localView, paramLong);
    }
    return this;
  }
  
  public void b()
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.b(this, localView);
    }
  }
  
  public av c(float paramFloat)
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.c(this, localView, paramFloat);
    }
    return this;
  }
  
  public void c()
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a.c(this, localView);
    }
  }
  
  static class a
    implements av.g
  {
    WeakHashMap<View, Runnable> a = null;
    
    private void a(View paramView)
    {
      if (this.a != null)
      {
        Runnable localRunnable = (Runnable)this.a.get(paramView);
        if (localRunnable != null) {
          paramView.removeCallbacks(localRunnable);
        }
      }
    }
    
    private void d(av paramav, View paramView)
    {
      Object localObject = paramView.getTag(2113929216);
      if ((localObject instanceof az)) {}
      for (localObject = (az)localObject;; localObject = null)
      {
        Runnable localRunnable1 = av.a(paramav);
        Runnable localRunnable2 = av.b(paramav);
        av.b(paramav, null);
        av.a(paramav, null);
        if (localRunnable1 != null) {
          localRunnable1.run();
        }
        if (localObject != null)
        {
          ((az)localObject).a(paramView);
          ((az)localObject).b(paramView);
        }
        if (localRunnable2 != null) {
          localRunnable2.run();
        }
        if (this.a != null) {
          this.a.remove(paramView);
        }
        return;
      }
    }
    
    private void e(av paramav, View paramView)
    {
      if (this.a != null) {}
      for (Runnable localRunnable = (Runnable)this.a.get(paramView);; localRunnable = null)
      {
        Object localObject = localRunnable;
        if (localRunnable == null)
        {
          localObject = new a(paramav, paramView, null);
          if (this.a == null) {
            this.a = new WeakHashMap();
          }
          this.a.put(paramView, localObject);
        }
        paramView.removeCallbacks((Runnable)localObject);
        paramView.post((Runnable)localObject);
        return;
      }
    }
    
    public long a(av paramav, View paramView)
    {
      return 0L;
    }
    
    public void a(av paramav, View paramView, float paramFloat)
    {
      e(paramav, paramView);
    }
    
    public void a(av paramav, View paramView, long paramLong) {}
    
    public void a(av paramav, View paramView, az paramaz)
    {
      paramView.setTag(2113929216, paramaz);
    }
    
    public void a(av paramav, View paramView, bb parambb) {}
    
    public void a(av paramav, View paramView, Interpolator paramInterpolator) {}
    
    public void b(av paramav, View paramView)
    {
      e(paramav, paramView);
    }
    
    public void b(av paramav, View paramView, float paramFloat)
    {
      e(paramav, paramView);
    }
    
    public void b(av paramav, View paramView, long paramLong) {}
    
    public void c(av paramav, View paramView)
    {
      a(paramView);
      d(paramav, paramView);
    }
    
    public void c(av paramav, View paramView, float paramFloat)
    {
      e(paramav, paramView);
    }
    
    class a
      implements Runnable
    {
      WeakReference<View> a;
      av b;
      
      private a(av paramav, View paramView)
      {
        this.a = new WeakReference(paramView);
        this.b = paramav;
      }
      
      public void run()
      {
        View localView = (View)this.a.get();
        if (localView != null) {
          av.a.a(av.a.this, this.b, localView);
        }
      }
    }
  }
  
  static class b
    extends av.a
  {
    WeakHashMap<View, Integer> b = null;
    
    public long a(av paramav, View paramView)
    {
      return aw.a(paramView);
    }
    
    public void a(av paramav, View paramView, float paramFloat)
    {
      aw.a(paramView, paramFloat);
    }
    
    public void a(av paramav, View paramView, long paramLong)
    {
      aw.a(paramView, paramLong);
    }
    
    public void a(av paramav, View paramView, az paramaz)
    {
      paramView.setTag(2113929216, paramaz);
      aw.a(paramView, new a(paramav));
    }
    
    public void a(av paramav, View paramView, Interpolator paramInterpolator)
    {
      aw.a(paramView, paramInterpolator);
    }
    
    public void b(av paramav, View paramView)
    {
      aw.b(paramView);
    }
    
    public void b(av paramav, View paramView, float paramFloat)
    {
      aw.b(paramView, paramFloat);
    }
    
    public void b(av paramav, View paramView, long paramLong)
    {
      aw.b(paramView, paramLong);
    }
    
    public void c(av paramav, View paramView)
    {
      aw.c(paramView);
    }
    
    public void c(av paramav, View paramView, float paramFloat)
    {
      aw.c(paramView, paramFloat);
    }
    
    static class a
      implements az
    {
      av a;
      boolean b;
      
      a(av paramav)
      {
        this.a = paramav;
      }
      
      public void a(View paramView)
      {
        this.b = false;
        if (av.c(this.a) >= 0) {
          af.a(paramView, 2, null);
        }
        if (av.a(this.a) != null)
        {
          localObject = av.a(this.a);
          av.b(this.a, null);
          ((Runnable)localObject).run();
        }
        Object localObject = paramView.getTag(2113929216);
        if ((localObject instanceof az)) {}
        for (localObject = (az)localObject;; localObject = null)
        {
          if (localObject != null) {
            ((az)localObject).a(paramView);
          }
          return;
        }
      }
      
      public void b(View paramView)
      {
        if (av.c(this.a) >= 0)
        {
          af.a(paramView, av.c(this.a), null);
          av.a(this.a, -1);
        }
        if ((Build.VERSION.SDK_INT >= 16) || (!this.b))
        {
          if (av.b(this.a) != null)
          {
            localObject = av.b(this.a);
            av.a(this.a, null);
            ((Runnable)localObject).run();
          }
          localObject = paramView.getTag(2113929216);
          if (!(localObject instanceof az)) {
            break label115;
          }
        }
        label115:
        for (Object localObject = (az)localObject;; localObject = null)
        {
          if (localObject != null) {
            ((az)localObject).b(paramView);
          }
          this.b = true;
          return;
        }
      }
      
      public void c(View paramView)
      {
        Object localObject = paramView.getTag(2113929216);
        if ((localObject instanceof az)) {}
        for (localObject = (az)localObject;; localObject = null)
        {
          if (localObject != null) {
            ((az)localObject).c(paramView);
          }
          return;
        }
      }
    }
  }
  
  static class c
    extends av.d
  {}
  
  static class d
    extends av.b
  {
    public void a(av paramav, View paramView, az paramaz)
    {
      ax.a(paramView, paramaz);
    }
  }
  
  static class e
    extends av.c
  {
    public void a(av paramav, View paramView, bb parambb)
    {
      ay.a(paramView, parambb);
    }
  }
  
  static class f
    extends av.e
  {}
  
  static abstract interface g
  {
    public abstract long a(av paramav, View paramView);
    
    public abstract void a(av paramav, View paramView, float paramFloat);
    
    public abstract void a(av paramav, View paramView, long paramLong);
    
    public abstract void a(av paramav, View paramView, az paramaz);
    
    public abstract void a(av paramav, View paramView, bb parambb);
    
    public abstract void a(av paramav, View paramView, Interpolator paramInterpolator);
    
    public abstract void b(av paramav, View paramView);
    
    public abstract void b(av paramav, View paramView, float paramFloat);
    
    public abstract void b(av paramav, View paramView, long paramLong);
    
    public abstract void c(av paramav, View paramView);
    
    public abstract void c(av paramav, View paramView, float paramFloat);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/j/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */