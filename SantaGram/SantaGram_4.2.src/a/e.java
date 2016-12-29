package a;

import java.io.Closeable;

public class e
  implements Closeable
{
  private final Object a;
  private f b;
  private Runnable c;
  private boolean d;
  
  public void close()
  {
    synchronized (this.a)
    {
      if (this.d) {
        return;
      }
      this.d = true;
      this.b.a(this);
      this.b = null;
      this.c = null;
      return;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */