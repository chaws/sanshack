package android.support.v4.c;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public final class e
{
  private static final a a = new b();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 15)
    {
      a = new d();
      return;
    }
    if (i >= 11)
    {
      a = new c();
      return;
    }
  }
  
  public static Intent a(ComponentName paramComponentName)
  {
    return a.a(paramComponentName);
  }
  
  static abstract interface a
  {
    public abstract Intent a(ComponentName paramComponentName);
  }
  
  static class b
    implements e.a
  {
    public Intent a(ComponentName paramComponentName)
    {
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.setComponent(paramComponentName);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      return localIntent;
    }
  }
  
  static class c
    extends e.b
  {
    public Intent a(ComponentName paramComponentName)
    {
      return f.a(paramComponentName);
    }
  }
  
  static class d
    extends e.c
  {}
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */