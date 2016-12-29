package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.c.a;
import android.support.v7.b.a.k;
import android.util.AttributeSet;
import android.widget.ImageView;

public class p
{
  private final ImageView a;
  private final m b;
  
  public p(ImageView paramImageView, m paramm)
  {
    this.a = paramImageView;
    this.b = paramm;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.b != null) {}
      for (Drawable localDrawable = this.b.a(this.a.getContext(), paramInt);; localDrawable = a.a(this.a.getContext(), paramInt))
      {
        if (localDrawable != null) {
          ag.a(localDrawable);
        }
        this.a.setImageDrawable(localDrawable);
        return;
      }
    }
    this.a.setImageDrawable(null);
  }
  
  public void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = bb.a(this.a.getContext(), paramAttributeSet, a.k.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = paramAttributeSet.b(a.k.AppCompatImageView_android_src);
      if (localDrawable != null) {
        this.a.setImageDrawable(localDrawable);
      }
      paramInt = paramAttributeSet.g(a.k.AppCompatImageView_srcCompat, -1);
      if (paramInt != -1)
      {
        localDrawable = this.b.a(this.a.getContext(), paramInt);
        if (localDrawable != null) {
          this.a.setImageDrawable(localDrawable);
        }
      }
      localDrawable = this.a.getDrawable();
      if (localDrawable != null) {
        ag.a(localDrawable);
      }
      return;
    }
    finally
    {
      paramAttributeSet.a();
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */