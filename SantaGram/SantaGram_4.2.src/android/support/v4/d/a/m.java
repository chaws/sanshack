package android.support.v4.d.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class m
  extends l
{
  m(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  m(j.a parama, Resources paramResources)
  {
    super(parama, paramResources);
  }
  
  j.a b()
  {
    return new a(this.b, null);
  }
  
  public boolean isAutoMirrored()
  {
    return this.c.isAutoMirrored();
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    this.c.setAutoMirrored(paramBoolean);
  }
  
  private static class a
    extends j.a
  {
    a(j.a parama, Resources paramResources)
    {
      super(paramResources);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new m(this, paramResources);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/d/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */