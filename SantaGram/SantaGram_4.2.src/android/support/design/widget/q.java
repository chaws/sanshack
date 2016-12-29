package android.support.design.widget;

import android.view.animation.Interpolator;

class q
{
  private final c a;
  
  q(c paramc)
  {
    this.a = paramc;
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.a.a(paramFloat1, paramFloat2);
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1, paramInt2);
  }
  
  public void a(final a parama)
  {
    if (parama != null)
    {
      this.a.a(new q.c.b()
      {
        public void a()
        {
          parama.a(q.this);
        }
      });
      return;
    }
    this.a.a(null);
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.a.a(paramInterpolator);
  }
  
  public boolean b()
  {
    return this.a.b();
  }
  
  public int c()
  {
    return this.a.c();
  }
  
  public float d()
  {
    return this.a.d();
  }
  
  public void e()
  {
    this.a.e();
  }
  
  static abstract interface a
  {
    public abstract void a(q paramq);
  }
  
  static abstract interface b
  {
    public abstract q a();
  }
  
  static abstract class c
  {
    abstract void a();
    
    abstract void a(float paramFloat1, float paramFloat2);
    
    abstract void a(int paramInt);
    
    abstract void a(int paramInt1, int paramInt2);
    
    abstract void a(b paramb);
    
    abstract void a(Interpolator paramInterpolator);
    
    abstract boolean b();
    
    abstract int c();
    
    abstract float d();
    
    abstract void e();
    
    static abstract interface a
    {
      public abstract void a();
      
      public abstract void b();
      
      public abstract void c();
    }
    
    static abstract interface b
    {
      public abstract void a();
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/widget/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */