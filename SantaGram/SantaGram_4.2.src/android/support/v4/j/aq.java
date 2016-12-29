package android.support.v4.j;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public final class aq
{
  static final e a = new a();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new d();
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new c();
      return;
    }
    if (Build.VERSION.SDK_INT >= 8)
    {
      a = new b();
      return;
    }
  }
  
  public static int a(ViewConfiguration paramViewConfiguration)
  {
    return a.a(paramViewConfiguration);
  }
  
  public static boolean b(ViewConfiguration paramViewConfiguration)
  {
    return a.b(paramViewConfiguration);
  }
  
  static class a
    implements aq.e
  {
    public int a(ViewConfiguration paramViewConfiguration)
    {
      return paramViewConfiguration.getScaledTouchSlop();
    }
    
    public boolean b(ViewConfiguration paramViewConfiguration)
    {
      return true;
    }
  }
  
  static class b
    extends aq.a
  {
    public int a(ViewConfiguration paramViewConfiguration)
    {
      return ar.a(paramViewConfiguration);
    }
  }
  
  static class c
    extends aq.b
  {
    public boolean b(ViewConfiguration paramViewConfiguration)
    {
      return false;
    }
  }
  
  static class d
    extends aq.c
  {
    public boolean b(ViewConfiguration paramViewConfiguration)
    {
      return as.a(paramViewConfiguration);
    }
  }
  
  static abstract interface e
  {
    public abstract int a(ViewConfiguration paramViewConfiguration);
    
    public abstract boolean b(ViewConfiguration paramViewConfiguration);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/j/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */