package android.support.v4.c;

import android.support.v4.i.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class g<D>
{
  int a;
  b<D> b;
  a<D> c;
  boolean d;
  boolean e;
  boolean f;
  boolean g;
  boolean h;
  
  public String a(D paramD)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    c.a(paramD, localStringBuilder);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void a()
  {
    this.d = true;
    this.f = false;
    this.e = false;
    b();
  }
  
  public void a(int paramInt, b<D> paramb)
  {
    if (this.b != null) {
      throw new IllegalStateException("There is already a listener registered");
    }
    this.b = paramb;
    this.a = paramInt;
  }
  
  public void a(a<D> parama)
  {
    if (this.c != null) {
      throw new IllegalStateException("There is already a listener registered");
    }
    this.c = parama;
  }
  
  public void a(b<D> paramb)
  {
    if (this.b == null) {
      throw new IllegalStateException("No listener register");
    }
    if (this.b != paramb) {
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    this.b = null;
  }
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.a);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(this.b);
    if ((this.d) || (this.g) || (this.h))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.d);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(this.g);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(this.h);
    }
    if ((this.e) || (this.f))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(this.e);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(this.f);
    }
  }
  
  protected void b() {}
  
  public void b(a<D> parama)
  {
    if (this.c == null) {
      throw new IllegalStateException("No listener register");
    }
    if (this.c != parama) {
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    this.c = null;
  }
  
  public void c()
  {
    this.d = false;
    d();
  }
  
  protected void d() {}
  
  public void e()
  {
    f();
    this.f = true;
    this.d = false;
    this.e = false;
    this.g = false;
    this.h = false;
  }
  
  protected void f() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    c.a(this, localStringBuilder);
    localStringBuilder.append(" id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static abstract interface a<D> {}
  
  public static abstract interface b<D> {}
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */