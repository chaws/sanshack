package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FitWindowsLinearLayout
  extends LinearLayout
  implements ah
{
  private ah.a a;
  
  public FitWindowsLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FitWindowsLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    if (this.a != null) {
      this.a.a(paramRect);
    }
    return super.fitSystemWindows(paramRect);
  }
  
  public void setOnFitSystemWindowsListener(ah.a parama)
  {
    this.a = parama;
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/FitWindowsLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */