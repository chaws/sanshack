package android.support.v4.j;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewPropertyAnimator;

class ay
{
  public static void a(final View paramView, bb parambb)
  {
    ValueAnimator.AnimatorUpdateListener local1 = null;
    if (parambb != null) {
      local1 = new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          this.a.a(paramView);
        }
      };
    }
    paramView.animate().setUpdateListener(local1);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/j/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */