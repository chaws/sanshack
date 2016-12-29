package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.j.af;
import android.support.v7.b.a.k;
import android.util.AttributeSet;
import android.view.View;

class h
{
  private final View a;
  private final m b;
  private az c;
  private az d;
  private az e;
  
  h(View paramView, m paramm)
  {
    this.a = paramView;
    this.b = paramm;
  }
  
  private boolean b(Drawable paramDrawable)
  {
    if (this.e == null) {
      this.e = new az();
    }
    az localaz = this.e;
    localaz.a();
    Object localObject = af.x(this.a);
    if (localObject != null)
    {
      localaz.d = true;
      localaz.a = ((ColorStateList)localObject);
    }
    localObject = af.y(this.a);
    if (localObject != null)
    {
      localaz.c = true;
      localaz.b = ((PorterDuff.Mode)localObject);
    }
    if ((localaz.d) || (localaz.c))
    {
      m.a(paramDrawable, localaz, this.a.getDrawableState());
      return true;
    }
    return false;
  }
  
  ColorStateList a()
  {
    if (this.d != null) {
      return this.d.a;
    }
    return null;
  }
  
  void a(int paramInt)
  {
    if (this.b != null) {}
    for (ColorStateList localColorStateList = this.b.b(this.a.getContext(), paramInt);; localColorStateList = null)
    {
      b(localColorStateList);
      return;
    }
  }
  
  void a(ColorStateList paramColorStateList)
  {
    if (this.d == null) {
      this.d = new az();
    }
    this.d.a = paramColorStateList;
    this.d.d = true;
    c();
  }
  
  void a(PorterDuff.Mode paramMode)
  {
    if (this.d == null) {
      this.d = new az();
    }
    this.d.b = paramMode;
    this.d.c = true;
    c();
  }
  
  void a(Drawable paramDrawable)
  {
    b(null);
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.a.getContext().obtainStyledAttributes(paramAttributeSet, a.k.ViewBackgroundHelper, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(a.k.ViewBackgroundHelper_android_background))
      {
        ColorStateList localColorStateList = this.b.b(this.a.getContext(), paramAttributeSet.getResourceId(a.k.ViewBackgroundHelper_android_background, -1));
        if (localColorStateList != null) {
          b(localColorStateList);
        }
      }
      if (paramAttributeSet.hasValue(a.k.ViewBackgroundHelper_backgroundTint)) {
        af.a(this.a, paramAttributeSet.getColorStateList(a.k.ViewBackgroundHelper_backgroundTint));
      }
      if (paramAttributeSet.hasValue(a.k.ViewBackgroundHelper_backgroundTintMode)) {
        af.a(this.a, ag.a(paramAttributeSet.getInt(a.k.ViewBackgroundHelper_backgroundTintMode, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  PorterDuff.Mode b()
  {
    if (this.d != null) {
      return this.d.b;
    }
    return null;
  }
  
  void b(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.c == null) {
        this.c = new az();
      }
      this.c.a = paramColorStateList;
      this.c.d = true;
    }
    for (;;)
    {
      c();
      return;
      this.c = null;
    }
  }
  
  void c()
  {
    Drawable localDrawable = this.a.getBackground();
    if ((localDrawable == null) || ((Build.VERSION.SDK_INT == 21) && (b(localDrawable)))) {}
    do
    {
      return;
      if (this.d != null)
      {
        m.a(localDrawable, this.d, this.a.getDrawableState());
        return;
      }
    } while (this.c == null);
    m.a(localDrawable, this.c, this.a.getDrawableState());
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */