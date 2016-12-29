package a;

class l
{
  private j<?> a;
  
  public l(j<?> paramj)
  {
    this.a = paramj;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  protected void finalize()
  {
    try
    {
      j localj = this.a;
      if (localj != null)
      {
        j.b localb = j.a();
        if (localb != null) {
          localb.a(localj, new m(localj.g()));
        }
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */