package android.support.v4.h;

import android.os.Build.VERSION;
import java.util.Locale;

public final class d
{
  public static final Locale a;
  private static final a b;
  private static String c;
  private static String d;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17) {}
    for (b = new b(null);; b = new a(null))
    {
      a = new Locale("", "");
      c = "Arab";
      d = "Hebr";
      return;
    }
  }
  
  public static int a(Locale paramLocale)
  {
    return b.a(paramLocale);
  }
  
  private static class a
  {
    private static int b(Locale paramLocale)
    {
      switch (Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0)))
      {
      default: 
        return 0;
      }
      return 1;
    }
    
    public int a(Locale paramLocale)
    {
      if ((paramLocale != null) && (!paramLocale.equals(d.a)))
      {
        String str = a.a(paramLocale);
        if (str == null) {
          return b(paramLocale);
        }
        if ((str.equalsIgnoreCase(d.a())) || (str.equalsIgnoreCase(d.b()))) {
          return 1;
        }
      }
      return 0;
    }
  }
  
  private static class b
    extends d.a
  {
    private b()
    {
      super();
    }
    
    public int a(Locale paramLocale)
    {
      return e.a(paramLocale);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/h/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */