package a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class j<TResult>
{
  public static final ExecutorService a = ;
  public static final Executor b = b.b();
  private static final Executor c = c.b();
  private static volatile b d;
  private static j<?> m = new j(null);
  private static j<Boolean> n = new j(Boolean.valueOf(true));
  private static j<Boolean> o = new j(Boolean.valueOf(false));
  private static j<?> p = new j(true);
  private final Object e = new Object();
  private boolean f;
  private boolean g;
  private TResult h;
  private Exception i;
  private boolean j;
  private l k;
  private List<h<TResult, Void>> l = new ArrayList();
  
  j() {}
  
  private j(TResult paramTResult)
  {
    b(paramTResult);
  }
  
  private j(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      l();
      return;
    }
    b(null);
  }
  
  public static b a()
  {
    return d;
  }
  
  public static <TResult> j<TResult> a(Exception paramException)
  {
    k localk = new k();
    localk.b(paramException);
    return localk.a();
  }
  
  public static <TResult> j<TResult> a(TResult paramTResult)
  {
    if (paramTResult == null) {
      return m;
    }
    if ((paramTResult instanceof Boolean))
    {
      if (((Boolean)paramTResult).booleanValue()) {
        return n;
      }
      return o;
    }
    k localk = new k();
    localk.b(paramTResult);
    return localk.a();
  }
  
  public static j<Void> a(Collection<? extends j<?>> paramCollection)
  {
    if (paramCollection.size() == 0) {
      return a(null);
    }
    final k localk = new k();
    final ArrayList localArrayList = new ArrayList();
    Object localObject = new Object();
    final AtomicInteger localAtomicInteger = new AtomicInteger(paramCollection.size());
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      ((j)paramCollection.next()).a(new h()
      {
        public Void a(j<Object> paramAnonymousj)
        {
          if (paramAnonymousj.e()) {}
          synchronized (this.a)
          {
            localArrayList.add(paramAnonymousj.g());
            if (paramAnonymousj.d()) {
              localAtomicBoolean.set(true);
            }
            if (localAtomicInteger.decrementAndGet() == 0)
            {
              if (localArrayList.size() == 0) {
                break label143;
              }
              if (localArrayList.size() == 1) {
                localk.b((Exception)localArrayList.get(0));
              }
            }
            else
            {
              return null;
            }
          }
          paramAnonymousj = new a(String.format("There were %d exceptions.", new Object[] { Integer.valueOf(localArrayList.size()) }), localArrayList);
          localk.b(paramAnonymousj);
          return null;
          label143:
          if (localAtomicBoolean.get())
          {
            localk.c();
            return null;
          }
          localk.b(null);
          return null;
        }
      });
    }
    return localk.a();
  }
  
  public static <TResult> j<TResult> a(Callable<TResult> paramCallable)
  {
    return a(paramCallable, a, null);
  }
  
  public static <TResult> j<TResult> a(Callable<TResult> paramCallable, Executor paramExecutor)
  {
    return a(paramCallable, paramExecutor, null);
  }
  
  public static <TResult> j<TResult> a(final Callable<TResult> paramCallable, Executor paramExecutor, d paramd)
  {
    final k localk = new k();
    try
    {
      paramExecutor.execute(new Runnable()
      {
        public void run()
        {
          if ((this.a != null) && (this.a.a()))
          {
            localk.c();
            return;
          }
          try
          {
            localk.b(paramCallable.call());
            return;
          }
          catch (CancellationException localCancellationException)
          {
            localk.c();
            return;
          }
          catch (Exception localException)
          {
            localk.b(localException);
          }
        }
      });
      return localk.a();
    }
    catch (Exception paramCallable)
    {
      for (;;)
      {
        localk.b(new i(paramCallable));
      }
    }
  }
  
  public static <TResult> j<TResult>.a b()
  {
    j localj = new j();
    localj.getClass();
    return new a();
  }
  
  private static <TContinuationResult, TResult> void c(final k<TContinuationResult> paramk, final h<TResult, TContinuationResult> paramh, final j<TResult> paramj, Executor paramExecutor, d paramd)
  {
    try
    {
      paramExecutor.execute(new Runnable()
      {
        public void run()
        {
          if ((this.a != null) && (this.a.a()))
          {
            paramk.c();
            return;
          }
          try
          {
            Object localObject = paramh.then(paramj);
            paramk.b(localObject);
            return;
          }
          catch (CancellationException localCancellationException)
          {
            paramk.c();
            return;
          }
          catch (Exception localException)
          {
            paramk.b(localException);
          }
        }
      });
      return;
    }
    catch (Exception paramh)
    {
      paramk.b(new i(paramh));
    }
  }
  
  private static <TContinuationResult, TResult> void d(final k<TContinuationResult> paramk, final h<TResult, j<TContinuationResult>> paramh, final j<TResult> paramj, Executor paramExecutor, d paramd)
  {
    try
    {
      paramExecutor.execute(new Runnable()
      {
        public void run()
        {
          if ((this.a != null) && (this.a.a()))
          {
            paramk.c();
            return;
          }
          try
          {
            j localj = (j)paramh.then(paramj);
            if (localj == null)
            {
              paramk.b(null);
              return;
            }
          }
          catch (CancellationException localCancellationException)
          {
            paramk.c();
            return;
            localCancellationException.a(new h()
            {
              public Void a(j<TContinuationResult> paramAnonymous2j)
              {
                if ((j.6.this.a != null) && (j.6.this.a.a()))
                {
                  j.6.this.b.c();
                  return null;
                }
                if (paramAnonymous2j.d())
                {
                  j.6.this.b.c();
                  return null;
                }
                if (paramAnonymous2j.e())
                {
                  j.6.this.b.b(paramAnonymous2j.g());
                  return null;
                }
                j.6.this.b.b(paramAnonymous2j.f());
                return null;
              }
            });
            return;
          }
          catch (Exception localException)
          {
            paramk.b(localException);
          }
        }
      });
      return;
    }
    catch (Exception paramh)
    {
      paramk.b(new i(paramh));
    }
  }
  
  public static <TResult> j<TResult> i()
  {
    return p;
  }
  
  private void m()
  {
    for (;;)
    {
      h localh;
      synchronized (this.e)
      {
        Iterator localIterator = this.l.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localh = (h)localIterator.next();
      }
      try
      {
        localh.then(this);
      }
      catch (RuntimeException localRuntimeException)
      {
        throw localRuntimeException;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
    this.l = null;
  }
  
  public <TContinuationResult> j<TContinuationResult> a(h<TResult, TContinuationResult> paramh)
  {
    return a(paramh, c, null);
  }
  
  public <TContinuationResult> j<TContinuationResult> a(h<TResult, TContinuationResult> paramh, Executor paramExecutor)
  {
    return a(paramh, paramExecutor, null);
  }
  
  public <TContinuationResult> j<TContinuationResult> a(final h<TResult, TContinuationResult> paramh, final Executor paramExecutor, final d paramd)
  {
    final k localk = new k();
    synchronized (this.e)
    {
      boolean bool = c();
      if (!bool) {
        this.l.add(new h()
        {
          public Void a(j<TResult> paramAnonymousj)
          {
            j.a(localk, paramh, paramAnonymousj, paramExecutor, paramd);
            return null;
          }
        });
      }
      if (bool) {
        c(localk, paramh, this, paramExecutor, paramd);
      }
      return localk.a();
    }
  }
  
  public j<Void> a(Callable<Boolean> paramCallable, h<Void, j<Void>> paramh)
  {
    return a(paramCallable, paramh, c, null);
  }
  
  public j<Void> a(final Callable<Boolean> paramCallable, final h<Void, j<Void>> paramh, final Executor paramExecutor, final d paramd)
  {
    final g localg = new g();
    localg.a(new h()
    {
      public j<Void> a(j<Void> paramAnonymousj)
      {
        if ((paramd != null) && (paramd.a())) {
          return j.i();
        }
        if (((Boolean)paramCallable.call()).booleanValue()) {
          return j.a(null).d(paramh, paramExecutor).d((h)localg.a(), paramExecutor);
        }
        return j.a(null);
      }
    });
    return k().b((h)localg.a(), paramExecutor);
  }
  
  public <TContinuationResult> j<TContinuationResult> b(h<TResult, j<TContinuationResult>> paramh)
  {
    return b(paramh, c, null);
  }
  
  public <TContinuationResult> j<TContinuationResult> b(h<TResult, j<TContinuationResult>> paramh, Executor paramExecutor)
  {
    return b(paramh, paramExecutor, null);
  }
  
  public <TContinuationResult> j<TContinuationResult> b(final h<TResult, j<TContinuationResult>> paramh, final Executor paramExecutor, final d paramd)
  {
    final k localk = new k();
    synchronized (this.e)
    {
      boolean bool = c();
      if (!bool) {
        this.l.add(new h()
        {
          public Void a(j<TResult> paramAnonymousj)
          {
            j.b(localk, paramh, paramAnonymousj, paramExecutor, paramd);
            return null;
          }
        });
      }
      if (bool) {
        d(localk, paramh, this, paramExecutor, paramd);
      }
      return localk.a();
    }
  }
  
  boolean b(Exception paramException)
  {
    synchronized (this.e)
    {
      if (this.f) {
        return false;
      }
      this.f = true;
      this.i = paramException;
      this.j = false;
      this.e.notifyAll();
      m();
      if ((!this.j) && (a() != null)) {
        this.k = new l(this);
      }
      return true;
    }
  }
  
  boolean b(TResult paramTResult)
  {
    synchronized (this.e)
    {
      if (this.f) {
        return false;
      }
      this.f = true;
      this.h = paramTResult;
      this.e.notifyAll();
      m();
      return true;
    }
  }
  
  public <TContinuationResult> j<TContinuationResult> c(h<TResult, TContinuationResult> paramh)
  {
    return c(paramh, c, null);
  }
  
  public <TContinuationResult> j<TContinuationResult> c(h<TResult, TContinuationResult> paramh, Executor paramExecutor)
  {
    return c(paramh, paramExecutor, null);
  }
  
  public <TContinuationResult> j<TContinuationResult> c(final h<TResult, TContinuationResult> paramh, Executor paramExecutor, final d paramd)
  {
    b(new h()
    {
      public j<TContinuationResult> a(j<TResult> paramAnonymousj)
      {
        if ((paramd != null) && (paramd.a())) {
          return j.i();
        }
        if (paramAnonymousj.e()) {
          return j.a(paramAnonymousj.g());
        }
        if (paramAnonymousj.d()) {
          return j.i();
        }
        return paramAnonymousj.a(paramh);
      }
    }, paramExecutor);
  }
  
  public boolean c()
  {
    synchronized (this.e)
    {
      boolean bool = this.f;
      return bool;
    }
  }
  
  public <TContinuationResult> j<TContinuationResult> d(h<TResult, j<TContinuationResult>> paramh)
  {
    return d(paramh, c);
  }
  
  public <TContinuationResult> j<TContinuationResult> d(h<TResult, j<TContinuationResult>> paramh, Executor paramExecutor)
  {
    return d(paramh, paramExecutor, null);
  }
  
  public <TContinuationResult> j<TContinuationResult> d(final h<TResult, j<TContinuationResult>> paramh, Executor paramExecutor, final d paramd)
  {
    b(new h()
    {
      public j<TContinuationResult> a(j<TResult> paramAnonymousj)
      {
        if ((paramd != null) && (paramd.a())) {
          return j.i();
        }
        if (paramAnonymousj.e()) {
          return j.a(paramAnonymousj.g());
        }
        if (paramAnonymousj.d()) {
          return j.i();
        }
        return paramAnonymousj.b(paramh);
      }
    }, paramExecutor);
  }
  
  public boolean d()
  {
    synchronized (this.e)
    {
      boolean bool = this.g;
      return bool;
    }
  }
  
  public boolean e()
  {
    for (;;)
    {
      synchronized (this.e)
      {
        if (g() != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public TResult f()
  {
    synchronized (this.e)
    {
      Object localObject2 = this.h;
      return (TResult)localObject2;
    }
  }
  
  public Exception g()
  {
    synchronized (this.e)
    {
      if (this.i != null)
      {
        this.j = true;
        if (this.k != null)
        {
          this.k.a();
          this.k = null;
        }
      }
      Exception localException = this.i;
      return localException;
    }
  }
  
  public void h()
  {
    synchronized (this.e)
    {
      if (!c()) {
        this.e.wait();
      }
      return;
    }
  }
  
  public <TOut> j<TOut> j()
  {
    return this;
  }
  
  public j<Void> k()
  {
    b(new h()
    {
      public j<Void> a(j<TResult> paramAnonymousj)
      {
        if (paramAnonymousj.d()) {
          return j.i();
        }
        if (paramAnonymousj.e()) {
          return j.a(paramAnonymousj.g());
        }
        return j.a(null);
      }
    });
  }
  
  boolean l()
  {
    synchronized (this.e)
    {
      if (this.f) {
        return false;
      }
      this.f = true;
      this.g = true;
      this.e.notifyAll();
      m();
      return true;
    }
  }
  
  public class a
    extends k<TResult>
  {
    a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(j<?> paramj, m paramm);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */