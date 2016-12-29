package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

abstract class g
{
  static final int[] h = { 16842919, 16842910 };
  static final int[] i = { 16842908, 16842910 };
  static final int[] j = new int[0];
  private final Rect a = new Rect();
  Drawable b;
  Drawable c;
  b d;
  Drawable e;
  float f;
  float g;
  final y k;
  final m l;
  private ViewTreeObserver.OnPreDrawListener m;
  
  g(y paramy, m paramm)
  {
    this.k = paramy;
    this.l = paramm;
  }
  
  private void j()
  {
    if (this.m == null) {
      this.m = new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          g.this.e();
          return true;
        }
      };
    }
  }
  
  abstract float a();
  
  abstract void a(float paramFloat);
  
  abstract void a(int paramInt);
  
  abstract void a(ColorStateList paramColorStateList);
  
  abstract void a(PorterDuff.Mode paramMode);
  
  abstract void a(Rect paramRect);
  
  abstract void a(a parama, boolean paramBoolean);
  
  abstract void a(int[] paramArrayOfInt);
  
  abstract void b();
  
  final void b(float paramFloat)
  {
    if (this.f != paramFloat)
    {
      this.f = paramFloat;
      a(paramFloat);
    }
  }
  
  void b(Rect paramRect) {}
  
  abstract void b(a parama, boolean paramBoolean);
  
  abstract void c();
  
  boolean d()
  {
    return false;
  }
  
  void e() {}
  
  final Drawable f()
  {
    return this.e;
  }
  
  final void g()
  {
    Rect localRect = this.a;
    a(localRect);
    b(localRect);
    this.l.a(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  void h()
  {
    if (d())
    {
      j();
      this.k.getViewTreeObserver().addOnPreDrawListener(this.m);
    }
  }
  
  void i()
  {
    if (this.m != null)
    {
      this.k.getViewTreeObserver().removeOnPreDrawListener(this.m);
      this.m = null;
    }
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/widget/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */