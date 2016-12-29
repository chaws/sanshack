package android.support.v4.j.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class a
{
  private static final d a = new c();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      a = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new a();
      return;
    }
  }
  
  public static k a(AccessibilityEvent paramAccessibilityEvent)
  {
    return new k(paramAccessibilityEvent);
  }
  
  public static void a(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    a.a(paramAccessibilityEvent, paramInt);
  }
  
  public static int b(AccessibilityEvent paramAccessibilityEvent)
  {
    return a.a(paramAccessibilityEvent);
  }
  
  static class a
    extends a.c
  {}
  
  static class b
    extends a.a
  {
    public int a(AccessibilityEvent paramAccessibilityEvent)
    {
      return b.a(paramAccessibilityEvent);
    }
    
    public void a(AccessibilityEvent paramAccessibilityEvent, int paramInt)
    {
      b.a(paramAccessibilityEvent, paramInt);
    }
  }
  
  static class c
    implements a.d
  {
    public int a(AccessibilityEvent paramAccessibilityEvent)
    {
      return 0;
    }
    
    public void a(AccessibilityEvent paramAccessibilityEvent, int paramInt) {}
  }
  
  static abstract interface d
  {
    public abstract int a(AccessibilityEvent paramAccessibilityEvent);
    
    public abstract void a(AccessibilityEvent paramAccessibilityEvent, int paramInt);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/j/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */