package android.support.v7.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.view.b;
import android.support.v7.view.f.a;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window;
import android.view.Window.Callback;

class j
  extends i
{
  private static q r;
  private int s = -100;
  private boolean t;
  private boolean u = true;
  
  j(Context paramContext, Window paramWindow, f paramf)
  {
    super(paramContext, paramWindow, paramf);
  }
  
  private boolean e(int paramInt)
  {
    Resources localResources = this.a.getResources();
    Configuration localConfiguration = localResources.getConfiguration();
    int i = localConfiguration.uiMode;
    if (paramInt == 2) {}
    for (paramInt = 32; (i & 0x30) != paramInt; paramInt = 16)
    {
      localConfiguration = new Configuration(localConfiguration);
      localConfiguration.uiMode = (paramInt | localConfiguration.uiMode & 0xFFFFFFCF);
      localResources.updateConfiguration(localConfiguration, null);
      return true;
    }
    return false;
  }
  
  private q t()
  {
    if (r == null) {
      r = new q(this.a.getApplicationContext());
    }
    return r;
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if ((paramBundle != null) && (this.s == -100)) {
      this.s = paramBundle.getInt("appcompat:local_night_mode", -100);
    }
  }
  
  public void c(Bundle paramBundle)
  {
    super.c(paramBundle);
    if (this.s != -100) {
      paramBundle.putInt("appcompat:local_night_mode", this.s);
    }
  }
  
  int d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      if (t().a()) {
        return 2;
      }
      return 1;
    }
    return -1;
  }
  
  public boolean i()
  {
    this.t = true;
    if (this.s == -100) {}
    for (int i = j();; i = this.s)
    {
      i = d(i);
      if (i == -1) {
        break;
      }
      return e(i);
    }
    return false;
  }
  
  public boolean o()
  {
    return this.u;
  }
  
  class a
    extends h.b
  {
    a(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    final ActionMode a(ActionMode.Callback paramCallback)
    {
      paramCallback = new f.a(j.this.a, paramCallback);
      b localb = j.this.a(paramCallback);
      if (localb != null) {
        return paramCallback.b(localb);
      }
      return null;
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      if (j.this.o()) {
        return a(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */