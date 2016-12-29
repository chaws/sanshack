package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.j.a;
import android.support.v4.j.a.c;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class ap
  extends a
{
  final ao b;
  final a c = new a()
  {
    public void a(View paramAnonymousView, c paramAnonymousc)
    {
      super.a(paramAnonymousView, paramAnonymousc);
      if ((!ap.a(ap.this)) && (ap.this.b.getLayoutManager() != null)) {
        ap.this.b.getLayoutManager().a(paramAnonymousView, paramAnonymousc);
      }
    }
    
    public boolean a(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      if (super.a(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle)) {
        return true;
      }
      if ((!ap.a(ap.this)) && (ap.this.b.getLayoutManager() != null)) {
        return ap.this.b.getLayoutManager().a(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
      }
      return false;
    }
  };
  
  public ap(ao paramao)
  {
    this.b = paramao;
  }
  
  private boolean c()
  {
    return this.b.p();
  }
  
  public void a(View paramView, c paramc)
  {
    super.a(paramView, paramc);
    paramc.a(ao.class.getName());
    if ((!c()) && (this.b.getLayoutManager() != null)) {
      this.b.getLayoutManager().a(paramc);
    }
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.a(paramView, paramInt, paramBundle)) {
      return true;
    }
    if ((!c()) && (this.b.getLayoutManager() != null)) {
      return this.b.getLayoutManager().a(paramInt, paramBundle);
    }
    return false;
  }
  
  a b()
  {
    return this.c;
  }
  
  public void d(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.d(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ao.class.getName());
    if (((paramView instanceof ao)) && (!c()))
    {
      paramView = (ao)paramView;
      if (paramView.getLayoutManager() != null) {
        paramView.getLayoutManager().a(paramAccessibilityEvent);
      }
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */