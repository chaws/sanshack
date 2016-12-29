package android.support.v7.a;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window;
import android.view.Window.Callback;

class k
  extends j
{
  private final UiModeManager r;
  
  k(Context paramContext, Window paramWindow, f paramf)
  {
    super(paramContext, paramWindow, paramf);
    this.r = ((UiModeManager)paramContext.getSystemService("uimode"));
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  int d(int paramInt)
  {
    if ((paramInt == 0) && (this.r.getNightMode() == 0)) {
      return -1;
    }
    return super.d(paramInt);
  }
  
  class a
    extends j.a
  {
    a(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      return null;
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      if (k.this.o()) {}
      switch (paramInt)
      {
      default: 
        return super.onWindowStartingActionMode(paramCallback, paramInt);
      }
      return a(paramCallback);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */