package android.support.v4.h;

import android.os.Build.VERSION;
import java.util.Locale;

public final class a
{
  private static final a a = new b();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      a = new d();
      return;
    }
    if (i >= 14)
    {
      a = new c();
      return;
    }
  }
  
  public static String a(Locale paramLocale)
  {
    return a.a(paramLocale);
  }
  
  static abstract interface a
  {
    public abstract String a(Locale paramLocale);
  }
  
  static class b
    implements a.a
  {
    public String a(Locale paramLocale)
    {
      return null;
    }
  }
  
  static class c
    implements a.a
  {
    public String a(Locale paramLocale)
    {
      return c.a(paramLocale);
    }
  }
  
  static class d
    implements a.a
  {
    public String a(Locale paramLocale)
    {
      return b.a(paramLocale);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */