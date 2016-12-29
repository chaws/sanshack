package a;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class c
{
  private static final c a = new c();
  private final ExecutorService b;
  private final ScheduledExecutorService c;
  private final Executor d;
  
  private c()
  {
    if (!c()) {}
    for (ExecutorService localExecutorService = Executors.newCachedThreadPool();; localExecutorService = b.a())
    {
      this.b = localExecutorService;
      this.c = Executors.newSingleThreadScheduledExecutor();
      this.d = new a(null);
      return;
    }
  }
  
  public static ExecutorService a()
  {
    return a.b;
  }
  
  static Executor b()
  {
    return a.d;
  }
  
  private static boolean c()
  {
    String str = System.getProperty("java.runtime.name");
    if (str == null) {
      return false;
    }
    return str.toLowerCase(Locale.US).contains("android");
  }
  
  private static class a
    implements Executor
  {
    private ThreadLocal<Integer> a = new ThreadLocal();
    
    private int a()
    {
      Integer localInteger2 = (Integer)this.a.get();
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null) {
        localInteger1 = Integer.valueOf(0);
      }
      int i = localInteger1.intValue() + 1;
      this.a.set(Integer.valueOf(i));
      return i;
    }
    
    private int b()
    {
      Integer localInteger2 = (Integer)this.a.get();
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null) {
        localInteger1 = Integer.valueOf(0);
      }
      int i = localInteger1.intValue() - 1;
      if (i == 0)
      {
        this.a.remove();
        return i;
      }
      this.a.set(Integer.valueOf(i));
      return i;
    }
    
    public void execute(Runnable paramRunnable)
    {
      if (a() <= 15) {}
      for (;;)
      {
        try
        {
          paramRunnable.run();
          return;
        }
        finally
        {
          b();
        }
        c.a().execute(paramRunnable);
      }
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */