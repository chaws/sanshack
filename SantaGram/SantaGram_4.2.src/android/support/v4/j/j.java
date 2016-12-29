package android.support.v4.j;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

class j
{
  static m a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.getFactory();
    if ((paramLayoutInflater instanceof a)) {
      return ((a)paramLayoutInflater).a;
    }
    return null;
  }
  
  static void a(LayoutInflater paramLayoutInflater, m paramm)
  {
    if (paramm != null) {}
    for (paramm = new a(paramm);; paramm = null)
    {
      paramLayoutInflater.setFactory(paramm);
      return;
    }
  }
  
  static class a
    implements LayoutInflater.Factory
  {
    final m a;
    
    a(m paramm)
    {
      this.a = paramm;
    }
    
    public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
    {
      return this.a.a(null, paramString, paramContext, paramAttributeSet);
    }
    
    public String toString()
    {
      return getClass().getName() + "{" + this.a + "}";
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/j/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */