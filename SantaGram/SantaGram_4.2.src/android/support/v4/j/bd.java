package android.support.v4.j;

import android.view.WindowInsets;

class bd
  extends bc
{
  private final WindowInsets a;
  
  bd(WindowInsets paramWindowInsets)
  {
    this.a = paramWindowInsets;
  }
  
  public int a()
  {
    return this.a.getSystemWindowInsetLeft();
  }
  
  public bc a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new bd(this.a.replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public int b()
  {
    return this.a.getSystemWindowInsetTop();
  }
  
  public int c()
  {
    return this.a.getSystemWindowInsetRight();
  }
  
  public int d()
  {
    return this.a.getSystemWindowInsetBottom();
  }
  
  public boolean e()
  {
    return this.a.isConsumed();
  }
  
  WindowInsets f()
  {
    return this.a;
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/j/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */