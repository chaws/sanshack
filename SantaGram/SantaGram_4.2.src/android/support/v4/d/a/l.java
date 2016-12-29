package android.support.v4.d.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class l
  extends j
{
  l(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  l(j.a parama, Resources paramResources)
  {
    super(parama, paramResources);
  }
  
  j.a b()
  {
    return new a(this.b, null);
  }
  
  public void jumpToCurrentState()
  {
    this.c.jumpToCurrentState();
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
      return new l(this, paramResources);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/d/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */