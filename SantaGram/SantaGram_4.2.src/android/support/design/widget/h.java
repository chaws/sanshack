package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
class h
  extends f
{
  private final Interpolator m;
  private InsetDrawable n;
  
  h(y paramy, m paramm)
  {
    super(paramy, paramm);
    if (paramy.isInEditMode()) {}
    for (paramy = null;; paramy = AnimationUtils.loadInterpolator(this.k.getContext(), 17563661))
    {
      this.m = paramy;
      return;
    }
  }
  
  public float a()
  {
    return this.k.getElevation();
  }
  
  public void a(float paramFloat)
  {
    this.k.setElevation(paramFloat);
    if (this.l.b()) {
      g();
    }
  }
  
  void a(int paramInt)
  {
    if ((this.c instanceof RippleDrawable))
    {
      ((RippleDrawable)this.c).setColor(ColorStateList.valueOf(paramInt));
      return;
    }
    super.a(paramInt);
  }
  
  void a(Rect paramRect)
  {
    if (this.l.b())
    {
      float f1 = this.l.a();
      float f2 = a() + this.g;
      int i = (int)Math.ceil(l.b(f2, f1, false));
      int j = (int)Math.ceil(l.a(f2, f1, false));
      paramRect.set(i, j, i, j);
      return;
    }
    paramRect.set(0, 0, 0, 0);
  }
  
  void a(int[] paramArrayOfInt) {}
  
  void b() {}
  
  void b(Rect paramRect)
  {
    if (this.l.b())
    {
      this.n = new InsetDrawable(this.c, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.l.a(this.n);
      return;
    }
    this.l.a(this.c);
  }
  
  void c()
  {
    g();
  }
  
  boolean d()
  {
    return false;
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/widget/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */