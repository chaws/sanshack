package android.support.v4.b;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.i.i;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class q<E>
  extends o
{
  private final Activity a;
  final Context b;
  final int c;
  final s d = new s();
  private final Handler e;
  private i<String, x> f;
  private boolean g;
  private y h;
  private boolean i;
  private boolean j;
  
  q(Activity paramActivity, Context paramContext, Handler paramHandler, int paramInt)
  {
    this.a = paramActivity;
    this.b = paramContext;
    this.e = paramHandler;
    this.c = paramInt;
  }
  
  q(n paramn)
  {
    this(paramn, paramn, paramn.mHandler, 0);
  }
  
  y a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.f == null) {
      this.f = new i();
    }
    y localy = (y)this.f.get(paramString);
    if (localy == null)
    {
      if (paramBoolean2)
      {
        localy = new y(paramString, this, paramBoolean1);
        this.f.put(paramString, localy);
      }
      return localy;
    }
    localy.a(this);
    return localy;
  }
  
  public View a(int paramInt)
  {
    return null;
  }
  
  void a(i<String, x> parami)
  {
    this.f = parami;
  }
  
  void a(String paramString)
  {
    if (this.f != null)
    {
      y localy = (y)this.f.get(paramString);
      if ((localy != null) && (!localy.f))
      {
        localy.h();
        this.f.remove(paramString);
      }
    }
  }
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    if (this.h == null) {}
    while (!this.j) {
      return;
    }
    this.j = false;
    if (paramBoolean)
    {
      this.h.d();
      return;
    }
    this.h.c();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(m paramm)
  {
    return true;
  }
  
  public LayoutInflater b()
  {
    return (LayoutInflater)this.b.getSystemService("layout_inflater");
  }
  
  void b(m paramm) {}
  
  void b(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(this.j);
    if (this.h != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this.h)));
      paramPrintWriter.println(":");
      this.h.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public void c() {}
  
  public boolean d()
  {
    return true;
  }
  
  public int e()
  {
    return this.c;
  }
  
  Activity f()
  {
    return this.a;
  }
  
  Context g()
  {
    return this.b;
  }
  
  Handler h()
  {
    return this.e;
  }
  
  s i()
  {
    return this.d;
  }
  
  y j()
  {
    if (this.h != null) {
      return this.h;
    }
    this.i = true;
    this.h = a("(root)", this.j, true);
    return this.h;
  }
  
  boolean k()
  {
    return this.g;
  }
  
  void l()
  {
    if (this.j) {
      return;
    }
    this.j = true;
    if (this.h != null) {
      this.h.b();
    }
    for (;;)
    {
      this.i = true;
      return;
      if (!this.i)
      {
        this.h = a("(root)", this.j, false);
        if ((this.h != null) && (!this.h.e)) {
          this.h.b();
        }
      }
    }
  }
  
  void m()
  {
    if (this.h == null) {
      return;
    }
    this.h.h();
  }
  
  void n()
  {
    if (this.f != null)
    {
      int m = this.f.size();
      y[] arrayOfy = new y[m];
      int k = m - 1;
      while (k >= 0)
      {
        arrayOfy[k] = ((y)this.f.c(k));
        k -= 1;
      }
      k = 0;
      while (k < m)
      {
        y localy = arrayOfy[k];
        localy.e();
        localy.g();
        k += 1;
      }
    }
  }
  
  i<String, x> o()
  {
    int m = 0;
    int n;
    if (this.f != null)
    {
      int i1 = this.f.size();
      y[] arrayOfy = new y[i1];
      int k = i1 - 1;
      while (k >= 0)
      {
        arrayOfy[k] = ((y)this.f.c(k));
        k -= 1;
      }
      k = 0;
      n = k;
      if (m < i1)
      {
        y localy = arrayOfy[m];
        if (localy.f) {
          k = 1;
        }
        for (;;)
        {
          m += 1;
          break;
          localy.h();
          this.f.remove(localy.d);
        }
      }
    }
    else
    {
      n = 0;
    }
    if (n != 0) {
      return this.f;
    }
    return null;
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */