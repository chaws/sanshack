package android.support.v4.j;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

public final class i
{
  static final a a = new b();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      a = new d();
      return;
    }
    if (i >= 11)
    {
      a = new c();
      return;
    }
  }
  
  public static m a(LayoutInflater paramLayoutInflater)
  {
    return a.a(paramLayoutInflater);
  }
  
  public static void a(LayoutInflater paramLayoutInflater, m paramm)
  {
    a.a(paramLayoutInflater, paramm);
  }
  
  static abstract interface a
  {
    public abstract m a(LayoutInflater paramLayoutInflater);
    
    public abstract void a(LayoutInflater paramLayoutInflater, m paramm);
  }
  
  static class b
    implements i.a
  {
    public m a(LayoutInflater paramLayoutInflater)
    {
      return j.a(paramLayoutInflater);
    }
    
    public void a(LayoutInflater paramLayoutInflater, m paramm)
    {
      j.a(paramLayoutInflater, paramm);
    }
  }
  
  static class c
    extends i.b
  {
    public void a(LayoutInflater paramLayoutInflater, m paramm)
    {
      k.a(paramLayoutInflater, paramm);
    }
  }
  
  static class d
    extends i.c
  {
    public void a(LayoutInflater paramLayoutInflater, m paramm)
    {
      l.a(paramLayoutInflater, paramm);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/j/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */