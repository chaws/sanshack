package android.support.v4.d.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

class k
  extends j
{
  k(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  k(j.a parama, Resources paramResources)
  {
    super(parama, paramResources);
  }
  
  protected Drawable a(Drawable.ConstantState paramConstantState, Resources paramResources)
  {
    return paramConstantState.newDrawable(paramResources);
  }
  
  j.a b()
  {
    return new a(this.b, null);
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
      return new k(this, paramResources);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/d/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */