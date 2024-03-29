package com.parse;

import a.j;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

class ParseExecutors
{
  private static final Object SCHEDULED_EXECUTOR_LOCK = new Object();
  private static ScheduledExecutorService scheduledExecutor;
  
  static Executor io()
  {
    return j.a;
  }
  
  static Executor main()
  {
    return j.b;
  }
  
  static ScheduledExecutorService scheduled()
  {
    synchronized (SCHEDULED_EXECUTOR_LOCK)
    {
      if (scheduledExecutor == null) {
        scheduledExecutor = Executors.newScheduledThreadPool(1);
      }
      return scheduledExecutor;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseExecutors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */