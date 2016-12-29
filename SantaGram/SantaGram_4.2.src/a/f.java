package a;

import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;

public class f
  implements Closeable
{
  private final Object a;
  private final List<e> b;
  private ScheduledFuture<?> c;
  private boolean d;
  private boolean e;
  
  private void b()
  {
    if (this.e) {
      throw new IllegalStateException("Object already closed");
    }
  }
  
  private void c()
  {
    if (this.c != null)
    {
      this.c.cancel(true);
      this.c = null;
    }
  }
  
  void a(e parame)
  {
    synchronized (this.a)
    {
      b();
      this.b.remove(parame);
      return;
    }
  }
  
  public boolean a()
  {
    synchronized (this.a)
    {
      b();
      boolean bool = this.d;
      return bool;
    }
  }
  
  public void close()
  {
    synchronized (this.a)
    {
      if (this.e) {
        return;
      }
      c();
      Iterator localIterator = this.b.iterator();
      if (localIterator.hasNext()) {
        ((e)localIterator.next()).close();
      }
    }
    this.b.clear();
    this.e = true;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[] { getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(a()) });
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */