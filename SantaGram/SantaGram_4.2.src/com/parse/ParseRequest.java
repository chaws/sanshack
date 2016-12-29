package com.parse;

import a.h;
import a.j;
import a.k;
import android.os.Build.VERSION;
import com.parse.a.a;
import com.parse.a.b;
import com.parse.a.b.a;
import com.parse.a.b.b;
import com.parse.a.c;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ParseRequest<Response>
{
  private static final int CORE_POOL_SIZE = CPU_COUNT * 2 + 1;
  private static final int CPU_COUNT;
  static final long DEFAULT_INITIAL_RETRY_DELAY = 1000L;
  protected static final int DEFAULT_MAX_RETRIES = 4;
  private static final long KEEP_ALIVE_TIME = 1L;
  private static final int MAX_POOL_SIZE = CPU_COUNT * 2 * 2 + 1;
  private static final int MAX_QUEUE_SIZE = 128;
  static final ExecutorService NETWORK_EXECUTOR = newThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), sThreadFactory);
  private static long defaultInitialRetryDelay = 1000L;
  private static final ThreadFactory sThreadFactory = new ThreadFactory()
  {
    private final AtomicInteger mCount = new AtomicInteger(1);
    
    public Thread newThread(Runnable paramAnonymousRunnable)
    {
      return new Thread(paramAnonymousRunnable, "ParseRequest.NETWORK_EXECUTOR-thread-" + this.mCount.getAndIncrement());
    }
  };
  private int maxRetries = 4;
  b.b method;
  String url;
  
  static
  {
    CPU_COUNT = Runtime.getRuntime().availableProcessors();
  }
  
  public ParseRequest(b.b paramb, String paramString)
  {
    this.method = paramb;
    this.url = paramString;
  }
  
  public ParseRequest(String paramString)
  {
    this(b.b.a, paramString);
  }
  
  private j<Response> executeAsync(ParseHttpClient paramParseHttpClient, final b paramb, final int paramInt, final long paramLong, final ProgressCallback paramProgressCallback, final j<Void> paramj)
  {
    if ((paramj != null) && (paramj.d())) {
      return j.i();
    }
    sendOneRequestAsync(paramParseHttpClient, paramb, paramProgressCallback).b(new h()
    {
      public j<Response> then(final j<Response> paramAnonymousj)
      {
        Exception localException = paramAnonymousj.g();
        Object localObject = paramAnonymousj;
        if (paramAnonymousj.e())
        {
          localObject = paramAnonymousj;
          if ((localException instanceof ParseException))
          {
            if ((paramj == null) || (!paramj.d())) {
              break label46;
            }
            localObject = j.i();
          }
        }
        label46:
        do
        {
          do
          {
            return (j<Response>)localObject;
            if (!(localException instanceof ParseRequest.ParseRequestException)) {
              break;
            }
            localObject = paramAnonymousj;
          } while (((ParseRequest.ParseRequestException)localException).isPermanentFailure);
          localObject = paramAnonymousj;
        } while (paramInt >= ParseRequest.this.maxRetries);
        PLog.i("com.parse.ParseRequest", "Request failed. Waiting " + paramLong + " milliseconds before attempt #" + (paramInt + 1));
        paramAnonymousj = new k();
        ParseExecutors.scheduled().schedule(new Runnable()
        {
          public void run()
          {
            ParseRequest.this.executeAsync(ParseRequest.4.this.val$client, ParseRequest.4.this.val$request, ParseRequest.4.this.val$attemptsMade + 1, ParseRequest.4.this.val$delay * 2L, ParseRequest.4.this.val$downloadProgressCallback, ParseRequest.4.this.val$cancellationToken).b(new h()
            {
              public j<Void> then(j<Response> paramAnonymous3j)
              {
                if (paramAnonymous3j.d()) {
                  ParseRequest.4.1.this.val$retryTask.c();
                }
                for (;;)
                {
                  return null;
                  if (paramAnonymous3j.e()) {
                    ParseRequest.4.1.this.val$retryTask.b(paramAnonymous3j.g());
                  } else {
                    ParseRequest.4.1.this.val$retryTask.b(paramAnonymous3j.f());
                  }
                }
              }
            });
          }
        }, paramLong, TimeUnit.MILLISECONDS);
        return paramAnonymousj.a();
      }
    });
  }
  
  private j<Response> executeAsync(ParseHttpClient paramParseHttpClient, b paramb, ProgressCallback paramProgressCallback, j<Void> paramj)
  {
    return executeAsync(paramParseHttpClient, paramb, 0, defaultInitialRetryDelay + (defaultInitialRetryDelay * Math.random()), paramProgressCallback, paramj);
  }
  
  public static long getDefaultInitialRetryDelay()
  {
    return defaultInitialRetryDelay;
  }
  
  private static ThreadPoolExecutor newThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    paramTimeUnit = new ThreadPoolExecutor(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
    if (Build.VERSION.SDK_INT >= 9) {
      paramTimeUnit.allowCoreThreadTimeOut(true);
    }
    return paramTimeUnit;
  }
  
  private j<Response> sendOneRequestAsync(final ParseHttpClient paramParseHttpClient, final b paramb, final ProgressCallback paramProgressCallback)
  {
    j.a(null).d(new h()
    {
      public j<Response> then(j<Void> paramAnonymousj)
      {
        paramAnonymousj = paramParseHttpClient.execute(paramb);
        return ParseRequest.this.onResponseAsync(paramAnonymousj, paramProgressCallback);
      }
    }, NETWORK_EXECUTOR).b(new h()
    {
      public j<Response> then(j<Response> paramAnonymousj)
      {
        Object localObject = paramAnonymousj;
        if (paramAnonymousj.e())
        {
          Exception localException = paramAnonymousj.g();
          localObject = paramAnonymousj;
          if ((localException instanceof IOException)) {
            localObject = j.a(ParseRequest.this.newTemporaryException("i/o failure", localException));
          }
        }
        return (j<Response>)localObject;
      }
    }, j.a);
  }
  
  public static void setDefaultInitialRetryDelay(long paramLong)
  {
    defaultInitialRetryDelay = paramLong;
  }
  
  public j<Response> executeAsync(ParseHttpClient paramParseHttpClient)
  {
    return executeAsync(paramParseHttpClient, (ProgressCallback)null, null, null);
  }
  
  public j<Response> executeAsync(ParseHttpClient paramParseHttpClient, j<Void> paramj)
  {
    return executeAsync(paramParseHttpClient, (ProgressCallback)null, null, paramj);
  }
  
  public j<Response> executeAsync(ParseHttpClient paramParseHttpClient, ProgressCallback paramProgressCallback1, ProgressCallback paramProgressCallback2)
  {
    return executeAsync(paramParseHttpClient, paramProgressCallback1, paramProgressCallback2, null);
  }
  
  public j<Response> executeAsync(ParseHttpClient paramParseHttpClient, ProgressCallback paramProgressCallback1, ProgressCallback paramProgressCallback2, j<Void> paramj)
  {
    return executeAsync(paramParseHttpClient, newRequest(this.method, this.url, paramProgressCallback1), paramProgressCallback2, paramj);
  }
  
  protected a newBody(ProgressCallback paramProgressCallback)
  {
    return null;
  }
  
  protected ParseException newPermanentException(int paramInt, String paramString)
  {
    paramString = new ParseRequestException(paramInt, paramString);
    paramString.isPermanentFailure = true;
    return paramString;
  }
  
  protected b newRequest(b.b paramb, String paramString, ProgressCallback paramProgressCallback)
  {
    paramString = new b.a().a(paramb).a(paramString);
    switch (paramb)
    {
    default: 
      throw new IllegalStateException("Invalid method " + paramb);
    case ???: 
    case ???: 
      paramString.a(newBody(paramProgressCallback));
    }
    return paramString.a();
  }
  
  protected ParseException newTemporaryException(int paramInt, String paramString)
  {
    paramString = new ParseRequestException(paramInt, paramString);
    paramString.isPermanentFailure = false;
    return paramString;
  }
  
  protected ParseException newTemporaryException(String paramString, Throwable paramThrowable)
  {
    paramString = new ParseRequestException(100, paramString, paramThrowable);
    paramString.isPermanentFailure = false;
    return paramString;
  }
  
  protected abstract j<Response> onResponseAsync(c paramc, ProgressCallback paramProgressCallback);
  
  public void setMaxRetries(int paramInt)
  {
    this.maxRetries = paramInt;
  }
  
  private static class ParseRequestException
    extends ParseException
  {
    boolean isPermanentFailure = false;
    
    public ParseRequestException(int paramInt, String paramString)
    {
      super(paramString);
    }
    
    public ParseRequestException(int paramInt, String paramString, Throwable paramThrowable)
    {
      super(paramString, paramThrowable);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */