package android.support.v4.b;

import android.content.Context;
import android.os.Build.VERSION;

public final class f
{
  private static final b a = new b(null);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      a = new a(null);
      return;
    }
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    return a.a(paramContext, paramString1, paramString2);
  }
  
  public static String a(String paramString)
  {
    return a.a(paramString);
  }
  
  private static class a
    extends f.b
  {
    private a()
    {
      super();
    }
    
    public int a(Context paramContext, String paramString1, String paramString2)
    {
      return g.a(paramContext, paramString1, paramString2);
    }
    
    public String a(String paramString)
    {
      return g.a(paramString);
    }
  }
  
  private static class b
  {
    public int a(Context paramContext, String paramString1, String paramString2)
    {
      return 1;
    }
    
    public String a(String paramString)
    {
      return null;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */