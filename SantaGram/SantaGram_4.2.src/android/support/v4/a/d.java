package android.support.v4.a;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;

class d
  implements b
{
  private TimeInterpolator a;
  
  public void a(View paramView)
  {
    if (this.a == null) {
      this.a = new ValueAnimator().getInterpolator();
    }
    paramView.animate().setInterpolator(this.a);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */