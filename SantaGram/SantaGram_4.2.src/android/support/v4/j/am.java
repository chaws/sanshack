package android.support.v4.j;

import android.view.View;

class am
{
  public static int a(View paramView)
  {
    return paramView.getLayoutDirection();
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static int b(View paramView)
  {
    return paramView.getPaddingStart();
  }
  
  public static int c(View paramView)
  {
    return paramView.getPaddingEnd();
  }
  
  public static int d(View paramView)
  {
    return paramView.getWindowSystemUiVisibility();
  }
  
  public static boolean e(View paramView)
  {
    return paramView.isPaddingRelative();
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/j/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */