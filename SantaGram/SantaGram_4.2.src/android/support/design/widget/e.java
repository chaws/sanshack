package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

class e
  extends g
{
  l a;
  private int m;
  private o n;
  private boolean o;
  
  e(y paramy, m paramm)
  {
    super(paramy, paramm);
    this.m = paramy.getResources().getInteger(17694720);
    this.n = new o();
    this.n.a(paramy);
    this.n.a(h, a(new b(null)));
    this.n.a(i, a(new b(null)));
    this.n.a(j, a(new c(null)));
  }
  
  private Animation a(Animation paramAnimation)
  {
    paramAnimation.setInterpolator(a.b);
    paramAnimation.setDuration(this.m);
    return paramAnimation;
  }
  
  private static ColorStateList b(int paramInt)
  {
    return new ColorStateList(new int[][] { i, h, new int[0] }, new int[] { paramInt, paramInt, 0 });
  }
  
  float a()
  {
    return this.f;
  }
  
  void a(float paramFloat)
  {
    if (this.a != null)
    {
      this.a.a(paramFloat, this.g + paramFloat);
      g();
    }
  }
  
  void a(int paramInt)
  {
    if (this.c != null) {
      android.support.v4.d.a.a.a(this.c, b(paramInt));
    }
  }
  
  void a(ColorStateList paramColorStateList)
  {
    if (this.b != null) {
      android.support.v4.d.a.a.a(this.b, paramColorStateList);
    }
    if (this.d != null) {
      this.d.a(paramColorStateList);
    }
  }
  
  void a(PorterDuff.Mode paramMode)
  {
    if (this.b != null) {
      android.support.v4.d.a.a.a(this.b, paramMode);
    }
  }
  
  void a(Rect paramRect)
  {
    this.a.getPadding(paramRect);
  }
  
  void a(final g.a parama, final boolean paramBoolean)
  {
    if ((this.o) || (this.k.getVisibility() != 0))
    {
      if (parama != null) {
        parama.b();
      }
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.k.getContext(), android.support.design.a.a.design_fab_out);
    localAnimation.setInterpolator(a.c);
    localAnimation.setDuration(200L);
    localAnimation.setAnimationListener(new a.a()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        e.a(e.this, false);
        e.this.k.a(8, paramBoolean);
        if (parama != null) {
          parama.b();
        }
      }
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        e.a(e.this, true);
      }
    });
    this.k.startAnimation(localAnimation);
  }
  
  void a(int[] paramArrayOfInt)
  {
    this.n.a(paramArrayOfInt);
  }
  
  void b()
  {
    this.n.b();
  }
  
  void b(final g.a parama, boolean paramBoolean)
  {
    if ((this.k.getVisibility() != 0) || (this.o))
    {
      this.k.clearAnimation();
      this.k.a(0, paramBoolean);
      localAnimation = AnimationUtils.loadAnimation(this.k.getContext(), android.support.design.a.a.design_fab_in);
      localAnimation.setDuration(200L);
      localAnimation.setInterpolator(a.d);
      localAnimation.setAnimationListener(new a.a()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (parama != null) {
            parama.a();
          }
        }
      });
      this.k.startAnimation(localAnimation);
    }
    while (parama == null)
    {
      Animation localAnimation;
      return;
    }
    parama.a();
  }
  
  void c() {}
  
  private abstract class a
    extends Animation
  {
    private float b;
    private float c;
    
    private a() {}
    
    protected abstract float a();
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      e.this.a.b(this.b + this.c * paramFloat);
    }
    
    public void reset()
    {
      super.reset();
      this.b = e.this.a.a();
      this.c = (a() - this.b);
    }
  }
  
  private class b
    extends e.a
  {
    private b()
    {
      super(null);
    }
    
    protected float a()
    {
      return e.this.f + e.this.g;
    }
  }
  
  private class c
    extends e.a
  {
    private c()
    {
      super(null);
    }
    
    protected float a()
    {
      return e.this.f;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/widget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */