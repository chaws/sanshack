package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public final class u
{
  Object a;
  a b;
  
  private u(int paramInt, Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInt >= 14) {
      this.b = new d();
    }
    for (;;)
    {
      this.a = this.b.a(paramContext, paramInterpolator);
      return;
      if (paramInt >= 9) {
        this.b = new c();
      } else {
        this.b = new b();
      }
    }
  }
  
  public static u a(Context paramContext)
  {
    return a(paramContext, null);
  }
  
  public static u a(Context paramContext, Interpolator paramInterpolator)
  {
    return new u(Build.VERSION.SDK_INT, paramContext, paramInterpolator);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.a(this.a, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.b.a(this.a, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.b.a(this.a, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    this.b.a(this.a, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }
  
  public boolean a()
  {
    return this.b.a(this.a);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return this.b.a(this.a, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public int b()
  {
    return this.b.b(this.a);
  }
  
  public int c()
  {
    return this.b.c(this.a);
  }
  
  public int d()
  {
    return this.b.g(this.a);
  }
  
  public int e()
  {
    return this.b.h(this.a);
  }
  
  public float f()
  {
    return this.b.d(this.a);
  }
  
  public boolean g()
  {
    return this.b.e(this.a);
  }
  
  public void h()
  {
    this.b.f(this.a);
  }
  
  static abstract interface a
  {
    public abstract Object a(Context paramContext, Interpolator paramInterpolator);
    
    public abstract void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public abstract void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
    
    public abstract void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
    
    public abstract boolean a(Object paramObject);
    
    public abstract boolean a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
    
    public abstract int b(Object paramObject);
    
    public abstract int c(Object paramObject);
    
    public abstract float d(Object paramObject);
    
    public abstract boolean e(Object paramObject);
    
    public abstract void f(Object paramObject);
    
    public abstract int g(Object paramObject);
    
    public abstract int h(Object paramObject);
  }
  
  static class b
    implements u.a
  {
    public Object a(Context paramContext, Interpolator paramInterpolator)
    {
      if (paramInterpolator != null) {
        return new Scroller(paramContext, paramInterpolator);
      }
      return new Scroller(paramContext);
    }
    
    public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      ((Scroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      ((Scroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      ((Scroller)paramObject).fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
    
    public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
    {
      ((Scroller)paramObject).fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
    
    public boolean a(Object paramObject)
    {
      return ((Scroller)paramObject).isFinished();
    }
    
    public boolean a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      return false;
    }
    
    public int b(Object paramObject)
    {
      return ((Scroller)paramObject).getCurrX();
    }
    
    public int c(Object paramObject)
    {
      return ((Scroller)paramObject).getCurrY();
    }
    
    public float d(Object paramObject)
    {
      return 0.0F;
    }
    
    public boolean e(Object paramObject)
    {
      return ((Scroller)paramObject).computeScrollOffset();
    }
    
    public void f(Object paramObject)
    {
      ((Scroller)paramObject).abortAnimation();
    }
    
    public int g(Object paramObject)
    {
      return ((Scroller)paramObject).getFinalX();
    }
    
    public int h(Object paramObject)
    {
      return ((Scroller)paramObject).getFinalY();
    }
  }
  
  static class c
    implements u.a
  {
    public Object a(Context paramContext, Interpolator paramInterpolator)
    {
      return v.a(paramContext, paramInterpolator);
    }
    
    public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      v.a(paramObject, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      v.a(paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      v.a(paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
    
    public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
    {
      v.a(paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    }
    
    public boolean a(Object paramObject)
    {
      return v.a(paramObject);
    }
    
    public boolean a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      return v.a(paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
    
    public int b(Object paramObject)
    {
      return v.b(paramObject);
    }
    
    public int c(Object paramObject)
    {
      return v.c(paramObject);
    }
    
    public float d(Object paramObject)
    {
      return 0.0F;
    }
    
    public boolean e(Object paramObject)
    {
      return v.d(paramObject);
    }
    
    public void f(Object paramObject)
    {
      v.e(paramObject);
    }
    
    public int g(Object paramObject)
    {
      return v.f(paramObject);
    }
    
    public int h(Object paramObject)
    {
      return v.g(paramObject);
    }
  }
  
  static class d
    extends u.c
  {
    public float d(Object paramObject)
    {
      return w.a(paramObject);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/widget/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */