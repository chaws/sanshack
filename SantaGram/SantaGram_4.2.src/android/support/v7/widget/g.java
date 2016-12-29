package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.j.ac;
import android.support.v7.b.a.a;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

public class g
  extends AutoCompleteTextView
  implements ac
{
  private static final int[] a = { 16843126 };
  private m b = m.a();
  private h c;
  private z d;
  
  public g(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public g(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.autoCompleteTextViewStyle);
  }
  
  public g(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(ay.a(paramContext), paramAttributeSet, paramInt);
    paramContext = bb.a(getContext(), paramAttributeSet, a, paramInt, 0);
    if (paramContext.f(0)) {
      setDropDownBackgroundDrawable(paramContext.a(0));
    }
    paramContext.a();
    this.c = new h(this, this.b);
    this.c.a(paramAttributeSet, paramInt);
    this.d = z.a(this);
    this.d.a(paramAttributeSet, paramInt);
    this.d.a();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.c != null) {
      this.c.c();
    }
    if (this.d != null) {
      this.d.a();
    }
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (this.c != null) {
      return this.c.a();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.c != null) {
      return this.c.b();
    }
    return null;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.c != null) {
      this.c.a(paramDrawable);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.c != null) {
      this.c.a(paramInt);
    }
  }
  
  public void setDropDownBackgroundResource(int paramInt)
  {
    if (this.b != null)
    {
      setDropDownBackgroundDrawable(this.b.a(getContext(), paramInt));
      return;
    }
    super.setDropDownBackgroundResource(paramInt);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.c != null) {
      this.c.a(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.c != null) {
      this.c.a(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.d != null) {
      this.d.a(paramContext, paramInt);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */