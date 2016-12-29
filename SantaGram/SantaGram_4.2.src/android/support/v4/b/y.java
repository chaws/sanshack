package android.support.v4.b;

import android.os.Bundle;
import android.support.v4.c.g;
import android.support.v4.c.g.a;
import android.support.v4.c.g.b;
import android.support.v4.i.c;
import android.support.v4.i.j;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class y
  extends x
{
  static boolean a = false;
  final j<a> b = new j();
  final j<a> c = new j();
  final String d;
  boolean e;
  boolean f;
  private q g;
  
  y(String paramString, q paramq, boolean paramBoolean)
  {
    this.d = paramString;
    this.g = paramq;
    this.e = paramBoolean;
  }
  
  void a(q paramq)
  {
    this.g = paramq;
  }
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str;
    int i;
    a locala;
    if (this.b.b() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      str = paramString + "    ";
      i = 0;
      while (i < this.b.b())
      {
        locala = (a)this.b.e(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.b.d(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(locala.toString());
        locala.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
    if (this.c.b() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      str = paramString + "    ";
      i = j;
      while (i < this.c.b())
      {
        locala = (a)this.c.e(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.c.d(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(locala.toString());
        locala.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    int j = this.b.b();
    int i = 0;
    boolean bool2 = false;
    if (i < j)
    {
      a locala = (a)this.b.e(i);
      if ((locala.h) && (!locala.f)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 |= bool1;
        i += 1;
        break;
      }
    }
    return bool2;
  }
  
  void b()
  {
    if (a) {
      Log.v("LoaderManager", "Starting in " + this);
    }
    if (this.e)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStart when already started: " + this, localRuntimeException);
    }
    for (;;)
    {
      return;
      this.e = true;
      int i = this.b.b() - 1;
      while (i >= 0)
      {
        ((a)this.b.e(i)).a();
        i -= 1;
      }
    }
  }
  
  void c()
  {
    if (a) {
      Log.v("LoaderManager", "Stopping in " + this);
    }
    if (!this.e)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStop when not started: " + this, localRuntimeException);
      return;
    }
    int i = this.b.b() - 1;
    while (i >= 0)
    {
      ((a)this.b.e(i)).e();
      i -= 1;
    }
    this.e = false;
  }
  
  void d()
  {
    if (a) {
      Log.v("LoaderManager", "Retaining in " + this);
    }
    if (!this.e)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doRetain when not started: " + this, localRuntimeException);
    }
    for (;;)
    {
      return;
      this.f = true;
      this.e = false;
      int i = this.b.b() - 1;
      while (i >= 0)
      {
        ((a)this.b.e(i)).b();
        i -= 1;
      }
    }
  }
  
  void e()
  {
    if (this.f)
    {
      if (a) {
        Log.v("LoaderManager", "Finished Retaining in " + this);
      }
      this.f = false;
      int i = this.b.b() - 1;
      while (i >= 0)
      {
        ((a)this.b.e(i)).c();
        i -= 1;
      }
    }
  }
  
  void f()
  {
    int i = this.b.b() - 1;
    while (i >= 0)
    {
      ((a)this.b.e(i)).k = true;
      i -= 1;
    }
  }
  
  void g()
  {
    int i = this.b.b() - 1;
    while (i >= 0)
    {
      ((a)this.b.e(i)).d();
      i -= 1;
    }
  }
  
  void h()
  {
    if (!this.f)
    {
      if (a) {
        Log.v("LoaderManager", "Destroying Active in " + this);
      }
      i = this.b.b() - 1;
      while (i >= 0)
      {
        ((a)this.b.e(i)).f();
        i -= 1;
      }
      this.b.c();
    }
    if (a) {
      Log.v("LoaderManager", "Destroying Inactive in " + this);
    }
    int i = this.c.b() - 1;
    while (i >= 0)
    {
      ((a)this.c.e(i)).f();
      i -= 1;
    }
    this.c.c();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    c.a(this.g, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  final class a
    implements g.a<Object>, g.b<Object>
  {
    final int a;
    final Bundle b;
    x.a<Object> c;
    g<Object> d;
    boolean e;
    boolean f;
    Object g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    a n;
    
    void a()
    {
      if ((this.i) && (this.j)) {
        this.h = true;
      }
      do
      {
        do
        {
          return;
        } while (this.h);
        this.h = true;
        if (y.a) {
          Log.v("LoaderManager", "  Starting: " + this);
        }
        if ((this.d == null) && (this.c != null)) {
          this.d = this.c.a(this.a, this.b);
        }
      } while (this.d == null);
      if ((this.d.getClass().isMemberClass()) && (!Modifier.isStatic(this.d.getClass().getModifiers()))) {
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.d);
      }
      if (!this.m)
      {
        this.d.a(this.a, this);
        this.d.a(this);
        this.m = true;
      }
      this.d.a();
    }
    
    void a(g<Object> paramg, Object paramObject)
    {
      String str;
      if (this.c != null)
      {
        if (y.a(this.o) == null) {
          break label158;
        }
        str = y.a(this.o).d.v;
        y.a(this.o).d.v = "onLoadFinished";
      }
      for (;;)
      {
        try
        {
          if (y.a) {
            Log.v("LoaderManager", "  onLoadFinished in " + paramg + ": " + paramg.a(paramObject));
          }
          this.c.a(paramg, paramObject);
          if (y.a(this.o) != null) {
            y.a(this.o).d.v = str;
          }
          this.f = true;
          return;
        }
        finally
        {
          if (y.a(this.o) != null) {
            y.a(this.o).d.v = str;
          }
        }
        label158:
        str = null;
      }
    }
    
    public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mId=");
      paramPrintWriter.print(this.a);
      paramPrintWriter.print(" mArgs=");
      paramPrintWriter.println(this.b);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCallbacks=");
      paramPrintWriter.println(this.c);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mLoader=");
      paramPrintWriter.println(this.d);
      if (this.d != null) {
        this.d.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
      if ((this.e) || (this.f))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mHaveData=");
        paramPrintWriter.print(this.e);
        paramPrintWriter.print("  mDeliveredData=");
        paramPrintWriter.println(this.f);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mData=");
        paramPrintWriter.println(this.g);
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.h);
      paramPrintWriter.print(" mReportNextStart=");
      paramPrintWriter.print(this.k);
      paramPrintWriter.print(" mDestroyed=");
      paramPrintWriter.println(this.l);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mRetaining=");
      paramPrintWriter.print(this.i);
      paramPrintWriter.print(" mRetainingStarted=");
      paramPrintWriter.print(this.j);
      paramPrintWriter.print(" mListenerRegistered=");
      paramPrintWriter.println(this.m);
      if (this.n != null)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Pending Loader ");
        paramPrintWriter.print(this.n);
        paramPrintWriter.println(":");
        this.n.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
    }
    
    void b()
    {
      if (y.a) {
        Log.v("LoaderManager", "  Retaining: " + this);
      }
      this.i = true;
      this.j = this.h;
      this.h = false;
      this.c = null;
    }
    
    void c()
    {
      if (this.i)
      {
        if (y.a) {
          Log.v("LoaderManager", "  Finished Retaining: " + this);
        }
        this.i = false;
        if ((this.h != this.j) && (!this.h)) {
          e();
        }
      }
      if ((this.h) && (this.e) && (!this.k)) {
        a(this.d, this.g);
      }
    }
    
    void d()
    {
      if ((this.h) && (this.k))
      {
        this.k = false;
        if (this.e) {
          a(this.d, this.g);
        }
      }
    }
    
    void e()
    {
      if (y.a) {
        Log.v("LoaderManager", "  Stopping: " + this);
      }
      this.h = false;
      if ((!this.i) && (this.d != null) && (this.m))
      {
        this.m = false;
        this.d.a(this);
        this.d.b(this);
        this.d.c();
      }
    }
    
    void f()
    {
      if (y.a) {
        Log.v("LoaderManager", "  Destroying: " + this);
      }
      this.l = true;
      boolean bool = this.f;
      this.f = false;
      String str;
      if ((this.c != null) && (this.d != null) && (this.e) && (bool))
      {
        if (y.a) {
          Log.v("LoaderManager", "  Reseting: " + this);
        }
        if (y.a(this.o) == null) {
          break label277;
        }
        str = y.a(this.o).d.v;
        y.a(this.o).d.v = "onLoaderReset";
      }
      for (;;)
      {
        try
        {
          this.c.a(this.d);
          if (y.a(this.o) != null) {
            y.a(this.o).d.v = str;
          }
          this.c = null;
          this.g = null;
          this.e = false;
          if (this.d != null)
          {
            if (this.m)
            {
              this.m = false;
              this.d.a(this);
              this.d.b(this);
            }
            this.d.e();
          }
          if (this.n != null) {
            this.n.f();
          }
          return;
        }
        finally
        {
          if (y.a(this.o) != null) {
            y.a(this.o).d.v = str;
          }
        }
        label277:
        str = null;
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("LoaderInfo{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" #");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" : ");
      c.a(this.d, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/b/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */