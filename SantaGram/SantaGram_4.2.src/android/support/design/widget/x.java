package android.support.design.widget;

import android.os.Build.VERSION;

class x
{
  static final q.b a = new q.b()
  {
    public q a()
    {
      if (Build.VERSION.SDK_INT >= 12) {}
      for (Object localObject = new s();; localObject = new r()) {
        return new q((q.c)localObject);
      }
    }
  };
  private static final a b = new b(null);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      b = new c(null);
      return;
    }
  }
  
  static q a()
  {
    return a.a();
  }
  
  private static abstract interface a {}
  
  private static class b
    implements x.a
  {}
  
  private static class c
    implements x.a
  {}
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/widget/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */