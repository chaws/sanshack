package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.Interpolator;

class s
  extends q.c
{
  final ValueAnimator a = new ValueAnimator();
  
  public void a()
  {
    this.a.start();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.a.setFloatValues(new float[] { paramFloat1, paramFloat2 });
  }
  
  public void a(int paramInt)
  {
    this.a.setDuration(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.setIntValues(new int[] { paramInt1, paramInt2 });
  }
  
  public void a(final q.c.b paramb)
  {
    this.a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        paramb.a();
      }
    });
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.a.setInterpolator(paramInterpolator);
  }
  
  public boolean b()
  {
    return this.a.isRunning();
  }
  
  public int c()
  {
    return ((Integer)this.a.getAnimatedValue()).intValue();
  }
  
  public float d()
  {
    return ((Float)this.a.getAnimatedValue()).floatValue();
  }
  
  public void e()
  {
    this.a.cancel();
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/widget/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */