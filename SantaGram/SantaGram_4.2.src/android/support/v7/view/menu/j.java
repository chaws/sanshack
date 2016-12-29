package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.e.a.b;
import android.support.v4.j.d.b;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

@TargetApi(16)
class j
  extends i
{
  j(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  i.a a(ActionProvider paramActionProvider)
  {
    return new a(this.a, paramActionProvider);
  }
  
  class a
    extends i.a
    implements ActionProvider.VisibilityListener
  {
    d.b c;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super(paramContext, paramActionProvider);
    }
    
    public View a(MenuItem paramMenuItem)
    {
      return this.a.onCreateActionView(paramMenuItem);
    }
    
    public void a(d.b paramb)
    {
      this.c = paramb;
      ActionProvider localActionProvider = this.a;
      if (paramb != null) {}
      for (paramb = this;; paramb = null)
      {
        localActionProvider.setVisibilityListener(paramb);
        return;
      }
    }
    
    public boolean b()
    {
      return this.a.overridesItemVisibility();
    }
    
    public boolean c()
    {
      return this.a.isVisible();
    }
    
    public void onActionProviderVisibilityChanged(boolean paramBoolean)
    {
      if (this.c != null) {
        this.c.a(paramBoolean);
      }
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/view/menu/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */