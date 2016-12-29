package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class n
{
  private static n a;
  private final Object b = new Object();
  private final Handler c = new Handler(Looper.getMainLooper(), new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return false;
      }
      n.a(n.this, (n.b)paramAnonymousMessage.obj);
      return true;
    }
  });
  private b d;
  private b e;
  
  static n a()
  {
    if (a == null) {
      a = new n();
    }
    return a;
  }
  
  private void a(b paramb)
  {
    if (b.b(paramb) == -2) {
      return;
    }
    int i = 2750;
    if (b.b(paramb) > 0) {
      i = b.b(paramb);
    }
    for (;;)
    {
      this.c.removeCallbacksAndMessages(paramb);
      this.c.sendMessageDelayed(Message.obtain(this.c, 0, paramb), i);
      return;
      if (b.b(paramb) == -1) {
        i = 1500;
      }
    }
  }
  
  private boolean a(b paramb, int paramInt)
  {
    a locala = (a)b.a(paramb).get();
    if (locala != null)
    {
      this.c.removeCallbacksAndMessages(paramb);
      locala.a(paramInt);
      return true;
    }
    return false;
  }
  
  private void b()
  {
    if (this.e != null)
    {
      this.d = this.e;
      this.e = null;
      a locala = (a)b.a(this.d).get();
      if (locala != null) {
        locala.a();
      }
    }
    else
    {
      return;
    }
    this.d = null;
  }
  
  private void b(b paramb)
  {
    synchronized (this.b)
    {
      if ((this.d == paramb) || (this.e == paramb)) {
        a(paramb, 2);
      }
      return;
    }
  }
  
  private boolean f(a parama)
  {
    return (this.d != null) && (this.d.a(parama));
  }
  
  private boolean g(a parama)
  {
    return (this.e != null) && (this.e.a(parama));
  }
  
  public void a(a parama)
  {
    synchronized (this.b)
    {
      if (f(parama))
      {
        this.d = null;
        if (this.e != null) {
          b();
        }
      }
      return;
    }
  }
  
  public void a(a parama, int paramInt)
  {
    synchronized (this.b)
    {
      if (f(parama)) {
        a(this.d, paramInt);
      }
      while (!g(parama)) {
        return;
      }
      a(this.e, paramInt);
    }
  }
  
  public void b(a parama)
  {
    synchronized (this.b)
    {
      if (f(parama)) {
        a(this.d);
      }
      return;
    }
  }
  
  public void c(a parama)
  {
    synchronized (this.b)
    {
      if (f(parama)) {
        this.c.removeCallbacksAndMessages(this.d);
      }
      return;
    }
  }
  
  public void d(a parama)
  {
    synchronized (this.b)
    {
      if (f(parama)) {
        a(this.d);
      }
      return;
    }
  }
  
  public boolean e(a parama)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (!f(parama))
        {
          if (!g(parama)) {
            break label40;
          }
          break label35;
          return bool;
        }
      }
      label35:
      boolean bool = true;
      continue;
      label40:
      bool = false;
    }
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
  }
  
  private static class b
  {
    private final WeakReference<n.a> a;
    private int b;
    
    boolean a(n.a parama)
    {
      return (parama != null) && (this.a.get() == parama);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/widget/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */