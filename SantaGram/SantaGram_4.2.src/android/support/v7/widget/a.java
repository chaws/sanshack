package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.j.af;
import android.support.v4.j.av;
import android.support.v4.j.az;
import android.support.v4.j.s;
import android.support.v7.b.a.k;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

abstract class a
  extends ViewGroup
{
  protected final a a = new a();
  protected final Context b;
  protected ActionMenuView c;
  protected d d;
  protected int e;
  protected av f;
  private boolean g;
  private boolean h;
  
  a(Context paramContext)
  {
    this(paramContext, null);
  }
  
  a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(android.support.v7.b.a.a.actionBarPopupTheme, paramAttributeSet, true)) && (paramAttributeSet.resourceId != 0))
    {
      this.b = new ContextThemeWrapper(paramContext, paramAttributeSet.resourceId);
      return;
    }
    this.b = paramContext;
  }
  
  protected static int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramInt1 - paramInt2;
    }
    return paramInt1 + paramInt2;
  }
  
  protected int a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, Integer.MIN_VALUE), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() - paramInt3);
  }
  
  protected int a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    paramInt2 = (paramInt3 - j) / 2 + paramInt2;
    if (paramBoolean) {
      paramView.layout(paramInt1 - i, paramInt2, paramInt1, j + paramInt2);
    }
    for (;;)
    {
      paramInt1 = i;
      if (paramBoolean) {
        paramInt1 = -i;
      }
      return paramInt1;
      paramView.layout(paramInt1, paramInt2, paramInt1 + i, j + paramInt2);
    }
  }
  
  public av a(int paramInt, long paramLong)
  {
    if (this.f != null) {
      this.f.b();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        af.c(this, 0.0F);
      }
      localav = af.q(this).a(1.0F);
      localav.a(paramLong);
      localav.a(this.a.a(localav, paramInt));
      return localav;
    }
    av localav = af.q(this).a(0.0F);
    localav.a(paramLong);
    localav.a(this.a.a(localav, paramInt));
    return localav;
  }
  
  public boolean a()
  {
    if (this.d != null) {
      return this.d.d();
    }
    return false;
  }
  
  public int getAnimatedVisibility()
  {
    if (this.f != null) {
      return this.a.a;
    }
    return getVisibility();
  }
  
  public int getContentHeight()
  {
    return this.e;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    TypedArray localTypedArray = getContext().obtainStyledAttributes(null, a.k.ActionBar, android.support.v7.b.a.a.actionBarStyle, 0);
    setContentHeight(localTypedArray.getLayoutDimension(a.k.ActionBar_height, 0));
    localTypedArray.recycle();
    if (this.d != null) {
      this.d.a(paramConfiguration);
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = s.a(paramMotionEvent);
    if (i == 9) {
      this.h = false;
    }
    if (!this.h)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.h = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.h = false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = s.a(paramMotionEvent);
    if (i == 0) {
      this.g = false;
    }
    if (!this.g)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.g = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.g = false;
    }
    return true;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.e = paramInt;
    requestLayout();
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != getVisibility())
    {
      if (this.f != null) {
        this.f.b();
      }
      super.setVisibility(paramInt);
    }
  }
  
  protected class a
    implements az
  {
    int a;
    private boolean c = false;
    
    protected a() {}
    
    public a a(av paramav, int paramInt)
    {
      a.this.f = paramav;
      this.a = paramInt;
      return this;
    }
    
    public void a(View paramView)
    {
      a.a(a.this, 0);
      this.c = false;
    }
    
    public void b(View paramView)
    {
      if (this.c) {
        return;
      }
      a.this.f = null;
      a.b(a.this, this.a);
    }
    
    public void c(View paramView)
    {
      this.c = true;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */