package com.parse;

import a.a;
import a.h;
import a.j;
import a.k;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

class ParseTaskUtils
{
  static j<Void> callbackOnMainThreadAsync(j<Void> paramj, ParseCallback1<ParseException> paramParseCallback1)
  {
    return callbackOnMainThreadAsync(paramj, paramParseCallback1, false);
  }
  
  static j<Void> callbackOnMainThreadAsync(j<Void> paramj, ParseCallback1<ParseException> paramParseCallback1, boolean paramBoolean)
  {
    if (paramParseCallback1 == null) {
      return paramj;
    }
    callbackOnMainThreadAsync(paramj, new ParseCallback2()
    {
      public void done(Void paramAnonymousVoid, ParseException paramAnonymousParseException)
      {
        this.val$callback.done(paramAnonymousParseException);
      }
    }, paramBoolean);
  }
  
  static <T> j<T> callbackOnMainThreadAsync(j<T> paramj, ParseCallback2<T, ParseException> paramParseCallback2)
  {
    return callbackOnMainThreadAsync(paramj, paramParseCallback2, false);
  }
  
  static <T> j<T> callbackOnMainThreadAsync(j<T> paramj, final ParseCallback2<T, ParseException> paramParseCallback2, boolean paramBoolean)
  {
    if (paramParseCallback2 == null) {
      return paramj;
    }
    final k localk = new k();
    paramj.a(new h()
    {
      public Void then(final j<T> paramAnonymousj)
      {
        if ((paramAnonymousj.d()) && (!this.val$reportCancellation))
        {
          localk.c();
          return null;
        }
        ParseExecutors.main().execute(new Runnable()
        {
          public void run()
          {
            try
            {
              localObject1 = paramAnonymousj.g();
              if ((localObject1 == null) || ((localObject1 instanceof ParseException))) {
                break label191;
              }
              localObject1 = new ParseException((Throwable)localObject1);
            }
            finally
            {
              label191:
              for (;;)
              {
                Object localObject1;
                if (paramAnonymousj.d()) {
                  ParseTaskUtils.2.this.val$tcs.c();
                }
                for (;;)
                {
                  throw ((Throwable)localObject2);
                  if (paramAnonymousj.e()) {
                    ParseTaskUtils.2.this.val$tcs.b(paramAnonymousj.g());
                  } else {
                    ParseTaskUtils.2.this.val$tcs.b(paramAnonymousj.f());
                  }
                }
              }
            }
            ParseTaskUtils.2.this.val$callback.done(paramAnonymousj.f(), (ParseException)localObject1);
            if (paramAnonymousj.d())
            {
              ParseTaskUtils.2.this.val$tcs.c();
              return;
            }
            if (paramAnonymousj.e())
            {
              ParseTaskUtils.2.this.val$tcs.b(paramAnonymousj.g());
              return;
            }
            ParseTaskUtils.2.this.val$tcs.b(paramAnonymousj.f());
          }
        });
        return null;
      }
    });
    return localk.a();
  }
  
  static <T> T wait(j<T> paramj)
  {
    try
    {
      paramj.h();
      if (!paramj.e()) {
        break label75;
      }
      paramj = paramj.g();
      if ((paramj instanceof ParseException)) {
        throw ((ParseException)paramj);
      }
    }
    catch (InterruptedException paramj)
    {
      throw new RuntimeException(paramj);
    }
    if ((paramj instanceof a)) {
      throw new ParseException(paramj);
    }
    if ((paramj instanceof RuntimeException)) {
      throw ((RuntimeException)paramj);
    }
    throw new RuntimeException(paramj);
    label75:
    if (paramj.d()) {
      throw new RuntimeException(new CancellationException());
    }
    paramj = paramj.f();
    return paramj;
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseTaskUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */