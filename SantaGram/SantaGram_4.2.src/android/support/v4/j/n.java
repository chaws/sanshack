package android.support.v4.j;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public final class n
{
  static final a a = new b();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      a = new c();
      return;
    }
  }
  
  public static int a(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    return a.a(paramMarginLayoutParams);
  }
  
  public static int b(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    return a.b(paramMarginLayoutParams);
  }
  
  static abstract interface a
  {
    public abstract int a(ViewGroup.MarginLayoutParams paramMarginLayoutParams);
    
    public abstract int b(ViewGroup.MarginLayoutParams paramMarginLayoutParams);
  }
  
  static class b
    implements n.a
  {
    public int a(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      return paramMarginLayoutParams.leftMargin;
    }
    
    public int b(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      return paramMarginLayoutParams.rightMargin;
    }
  }
  
  static class c
    implements n.a
  {
    public int a(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      return o.a(paramMarginLayoutParams);
    }
    
    public int b(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      return o.b(paramMarginLayoutParams);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/j/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */