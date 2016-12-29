package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public final class h
{
  private static final c b = new a();
  private Object a;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      b = new d();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      b = new b();
      return;
    }
  }
  
  public h(Context paramContext)
  {
    this.a = b.a(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b.a(this.a, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return b.a(this.a);
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    return b.a(this.a, paramFloat1, paramFloat2);
  }
  
  public boolean a(int paramInt)
  {
    return b.a(this.a, paramInt);
  }
  
  public boolean a(Canvas paramCanvas)
  {
    return b.a(this.a, paramCanvas);
  }
  
  public boolean b()
  {
    return b.b(this.a);
  }
  
  static class a
    implements h.c
  {
    public Object a(Context paramContext)
    {
      return null;
    }
    
    public void a(Object paramObject, int paramInt1, int paramInt2) {}
    
    public boolean a(Object paramObject)
    {
      return true;
    }
    
    public boolean a(Object paramObject, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public boolean a(Object paramObject, int paramInt)
    {
      return false;
    }
    
    public boolean a(Object paramObject, Canvas paramCanvas)
    {
      return false;
    }
    
    public boolean b(Object paramObject)
    {
      return false;
    }
  }
  
  static class b
    implements h.c
  {
    public Object a(Context paramContext)
    {
      return i.a(paramContext);
    }
    
    public void a(Object paramObject, int paramInt1, int paramInt2)
    {
      i.a(paramObject, paramInt1, paramInt2);
    }
    
    public boolean a(Object paramObject)
    {
      return i.a(paramObject);
    }
    
    public boolean a(Object paramObject, float paramFloat1, float paramFloat2)
    {
      return i.a(paramObject, paramFloat1);
    }
    
    public boolean a(Object paramObject, int paramInt)
    {
      return i.a(paramObject, paramInt);
    }
    
    public boolean a(Object paramObject, Canvas paramCanvas)
    {
      return i.a(paramObject, paramCanvas);
    }
    
    public boolean b(Object paramObject)
    {
      return i.b(paramObject);
    }
  }
  
  static abstract interface c
  {
    public abstract Object a(Context paramContext);
    
    public abstract void a(Object paramObject, int paramInt1, int paramInt2);
    
    public abstract boolean a(Object paramObject);
    
    public abstract boolean a(Object paramObject, float paramFloat1, float paramFloat2);
    
    public abstract boolean a(Object paramObject, int paramInt);
    
    public abstract boolean a(Object paramObject, Canvas paramCanvas);
    
    public abstract boolean b(Object paramObject);
  }
  
  static class d
    extends h.b
  {
    public boolean a(Object paramObject, float paramFloat1, float paramFloat2)
    {
      return j.a(paramObject, paramFloat1, paramFloat2);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/widget/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */