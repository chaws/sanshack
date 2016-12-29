package android.support.v4.j;

import android.view.View;

class al
{
  public static void a(View paramView, int paramInt)
  {
    paramView.setImportantForAccessibility(paramInt);
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
  
  public static void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postOnAnimationDelayed(paramRunnable, paramLong);
  }
  
  public static boolean a(View paramView)
  {
    return paramView.hasTransientState();
  }
  
  public static void b(View paramView)
  {
    paramView.postInvalidateOnAnimation();
  }
  
  public static int c(View paramView)
  {
    return paramView.getImportantForAccessibility();
  }
  
  public static int d(View paramView)
  {
    return paramView.getMinimumWidth();
  }
  
  public static int e(View paramView)
  {
    return paramView.getMinimumHeight();
  }
  
  public static void f(View paramView)
  {
    paramView.requestFitSystemWindows();
  }
  
  public static boolean g(View paramView)
  {
    return paramView.getFitsSystemWindows();
  }
  
  public static boolean h(View paramView)
  {
    return paramView.hasOverlappingRendering();
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/j/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */