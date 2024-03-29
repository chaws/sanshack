package com.parse;

import a.h;
import a.j;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TaskQueue
{
  private final Lock lock = new ReentrantLock();
  private j<Void> tail;
  
  /* Error */
  private j<Void> getTaskToAwait()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 31 1 0
    //   9: aload_0
    //   10: getfield 33	com/parse/TaskQueue:tail	La/j;
    //   13: ifnull +32 -> 45
    //   16: aload_0
    //   17: getfield 33	com/parse/TaskQueue:tail	La/j;
    //   20: astore_1
    //   21: aload_1
    //   22: new 6	com/parse/TaskQueue$1
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 36	com/parse/TaskQueue$1:<init>	(Lcom/parse/TaskQueue;)V
    //   30: invokevirtual 42	a/j:a	(La/h;)La/j;
    //   33: astore_1
    //   34: aload_0
    //   35: getfield 24	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   38: invokeinterface 45 1 0
    //   43: aload_1
    //   44: areturn
    //   45: aconst_null
    //   46: invokestatic 48	a/j:a	(Ljava/lang/Object;)La/j;
    //   49: astore_1
    //   50: goto -29 -> 21
    //   53: astore_1
    //   54: aload_0
    //   55: getfield 24	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   58: invokeinterface 45 1 0
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	TaskQueue
    //   20	30	1	localj	j
    //   53	11	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	53	finally
    //   21	34	53	finally
    //   45	50	53	finally
  }
  
  static <T> h<T, j<T>> waitFor(j<Void> paramj)
  {
    new h()
    {
      public j<T> then(final j<T> paramAnonymousj)
      {
        this.val$toAwait.b(new h()
        {
          public j<T> then(j<Void> paramAnonymous2j)
          {
            return paramAnonymousj;
          }
        });
      }
    };
  }
  
  /* Error */
  <T> j<T> enqueue(h<Void, j<T>> paramh)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 31 1 0
    //   9: aload_0
    //   10: getfield 33	com/parse/TaskQueue:tail	La/j;
    //   13: ifnull +55 -> 68
    //   16: aload_0
    //   17: getfield 33	com/parse/TaskQueue:tail	La/j;
    //   20: astore_2
    //   21: aload_1
    //   22: aload_0
    //   23: invokespecial 63	com/parse/TaskQueue:getTaskToAwait	()La/j;
    //   26: invokeinterface 69 2 0
    //   31: checkcast 38	a/j
    //   34: astore_1
    //   35: aload_0
    //   36: iconst_2
    //   37: anewarray 38	a/j
    //   40: dup
    //   41: iconst_0
    //   42: aload_2
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: aload_1
    //   47: aastore
    //   48: invokestatic 75	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   51: invokestatic 78	a/j:a	(Ljava/util/Collection;)La/j;
    //   54: putfield 33	com/parse/TaskQueue:tail	La/j;
    //   57: aload_0
    //   58: getfield 24	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   61: invokeinterface 45 1 0
    //   66: aload_1
    //   67: areturn
    //   68: aconst_null
    //   69: invokestatic 48	a/j:a	(Ljava/lang/Object;)La/j;
    //   72: astore_2
    //   73: goto -52 -> 21
    //   76: astore_1
    //   77: aload_1
    //   78: athrow
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 24	com/parse/TaskQueue:lock	Ljava/util/concurrent/locks/Lock;
    //   84: invokeinterface 45 1 0
    //   89: aload_1
    //   90: athrow
    //   91: astore_1
    //   92: new 59	java/lang/RuntimeException
    //   95: dup
    //   96: aload_1
    //   97: invokespecial 81	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	TaskQueue
    //   0	101	1	paramh	h<Void, j<T>>
    //   20	53	2	localj	j
    // Exception table:
    //   from	to	target	type
    //   21	35	76	java/lang/RuntimeException
    //   9	21	79	finally
    //   21	35	79	finally
    //   35	57	79	finally
    //   68	73	79	finally
    //   77	79	79	finally
    //   92	101	79	finally
    //   21	35	91	java/lang/Exception
  }
  
  Lock getLock()
  {
    return this.lock;
  }
  
  void waitUntilFinished()
  {
    this.lock.lock();
    try
    {
      j localj = this.tail;
      if (localj == null) {
        return;
      }
      this.tail.h();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/TaskQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */