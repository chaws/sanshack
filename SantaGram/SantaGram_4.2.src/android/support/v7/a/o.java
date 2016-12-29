package android.support.v7.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.support.v4.j.af;
import android.support.v7.b.a.a;
import android.support.v7.b.a.h;
import android.support.v7.b.a.j;
import android.support.v7.view.i;
import android.support.v7.view.menu.e;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.view.menu.l.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.c;
import android.support.v7.widget.ae;
import android.support.v7.widget.bc;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.widget.ListAdapter;
import java.util.ArrayList;

class o
  extends a
{
  private ae a;
  private boolean b;
  private Window.Callback c;
  private boolean d;
  private boolean e;
  private ArrayList<a.b> f = new ArrayList();
  private e g;
  private final Runnable h = new Runnable()
  {
    public void run()
    {
      o.this.k();
    }
  };
  private final Toolbar.c i = new Toolbar.c()
  {
    public boolean a(MenuItem paramAnonymousMenuItem)
    {
      return o.a(o.this).onMenuItemSelected(0, paramAnonymousMenuItem);
    }
  };
  
  public o(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    this.a = new bc(paramToolbar, false);
    this.c = new d(paramCallback);
    this.a.a(this.c);
    paramToolbar.setOnMenuItemClickListener(this.i);
    this.a.a(paramCharSequence);
  }
  
  private View a(Menu paramMenu)
  {
    b(paramMenu);
    if ((paramMenu == null) || (this.g == null)) {}
    while (this.g.a().getCount() <= 0) {
      return null;
    }
    return (View)this.g.a(this.a.a());
  }
  
  private void b(Menu paramMenu)
  {
    Object localObject;
    Resources.Theme localTheme;
    if ((this.g == null) && ((paramMenu instanceof f)))
    {
      paramMenu = (f)paramMenu;
      localObject = this.a.b();
      TypedValue localTypedValue = new TypedValue();
      localTheme = ((Context)localObject).getResources().newTheme();
      localTheme.setTo(((Context)localObject).getTheme());
      localTheme.resolveAttribute(a.a.actionBarPopupTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      localTheme.resolveAttribute(a.a.panelMenuListTheme, localTypedValue, true);
      if (localTypedValue.resourceId == 0) {
        break label170;
      }
      localTheme.applyStyle(localTypedValue.resourceId, true);
    }
    for (;;)
    {
      localObject = new ContextThemeWrapper((Context)localObject, 0);
      ((Context)localObject).getTheme().setTo(localTheme);
      this.g = new e((Context)localObject, a.h.abc_list_menu_item_layout);
      this.g.a(new c(null));
      paramMenu.a(this.g);
      return;
      label170:
      localTheme.applyStyle(a.j.Theme_AppCompat_CompactMenu, true);
    }
  }
  
  private Menu l()
  {
    if (!this.d)
    {
      this.a.a(new a(null), new b(null));
      this.d = true;
    }
    return this.a.r();
  }
  
  public int a()
  {
    return this.a.o();
  }
  
  public void a(float paramFloat)
  {
    af.d(this.a.a(), paramFloat);
  }
  
  public void a(int paramInt)
  {
    ae localae = this.a;
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = this.a.b().getText(paramInt);; localCharSequence = null)
    {
      localae.b(localCharSequence);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = this.a.o();
    this.a.c(j & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.a.b(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int j = 4;; j = 0)
    {
      a(j, 4);
      return;
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    Menu localMenu = l();
    int j;
    if (localMenu != null)
    {
      if (paramKeyEvent == null) {
        break label54;
      }
      j = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(j).getKeyboardType() == 1) {
        break label60;
      }
    }
    label54:
    label60:
    for (boolean bool = true;; bool = false)
    {
      localMenu.setQwertyMode(bool);
      localMenu.performShortcut(paramInt, paramKeyEvent, 0);
      return true;
      j = -1;
      break;
    }
  }
  
  public void b()
  {
    this.a.d(8);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.a.a(paramCharSequence);
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean c()
  {
    return this.a.q() == 0;
  }
  
  public Context d()
  {
    return this.a.b();
  }
  
  public void d(boolean paramBoolean) {}
  
  public void e(boolean paramBoolean) {}
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean == this.e) {}
    for (;;)
    {
      return;
      this.e = paramBoolean;
      int k = this.f.size();
      int j = 0;
      while (j < k)
      {
        ((a.b)this.f.get(j)).a(paramBoolean);
        j += 1;
      }
    }
  }
  
  public boolean f()
  {
    this.a.a().removeCallbacks(this.h);
    af.a(this.a.a(), this.h);
    return true;
  }
  
  public boolean g()
  {
    if (this.a.c())
    {
      this.a.d();
      return true;
    }
    return false;
  }
  
  public boolean h()
  {
    ViewGroup localViewGroup = this.a.a();
    if ((localViewGroup != null) && (!localViewGroup.hasFocus()))
    {
      localViewGroup.requestFocus();
      return true;
    }
    return false;
  }
  
  void i()
  {
    this.a.a().removeCallbacks(this.h);
  }
  
  public Window.Callback j()
  {
    return this.c;
  }
  
  void k()
  {
    Menu localMenu = l();
    if ((localMenu instanceof f)) {}
    for (localf = (f)localMenu;; localf = null)
    {
      if (localf != null) {
        localf.g();
      }
      try
      {
        localMenu.clear();
        if ((!this.c.onCreatePanelMenu(0, localMenu)) || (!this.c.onPreparePanel(0, null, localMenu))) {
          localMenu.clear();
        }
        return;
      }
      finally
      {
        if (localf == null) {
          break;
        }
        localf.h();
      }
    }
  }
  
  private final class a
    implements l.a
  {
    private boolean b;
    
    private a() {}
    
    public void a(f paramf, boolean paramBoolean)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      o.c(o.this).n();
      if (o.a(o.this) != null) {
        o.a(o.this).onPanelClosed(108, paramf);
      }
      this.b = false;
    }
    
    public boolean a(f paramf)
    {
      if (o.a(o.this) != null)
      {
        o.a(o.this).onMenuOpened(108, paramf);
        return true;
      }
      return false;
    }
  }
  
  private final class b
    implements f.a
  {
    private b() {}
    
    public void a(f paramf)
    {
      if (o.a(o.this) != null)
      {
        if (!o.c(o.this).i()) {
          break label41;
        }
        o.a(o.this).onPanelClosed(108, paramf);
      }
      label41:
      while (!o.a(o.this).onPreparePanel(0, null, paramf)) {
        return;
      }
      o.a(o.this).onMenuOpened(108, paramf);
    }
    
    public boolean a(f paramf, MenuItem paramMenuItem)
    {
      return false;
    }
  }
  
  private final class c
    implements l.a
  {
    private c() {}
    
    public void a(f paramf, boolean paramBoolean)
    {
      if (o.a(o.this) != null) {
        o.a(o.this).onPanelClosed(0, paramf);
      }
    }
    
    public boolean a(f paramf)
    {
      if ((paramf == null) && (o.a(o.this) != null)) {
        o.a(o.this).onMenuOpened(0, paramf);
      }
      return true;
    }
  }
  
  private class d
    extends i
  {
    public d(Window.Callback paramCallback)
    {
      super();
    }
    
    public View onCreatePanelView(int paramInt)
    {
      switch (paramInt)
      {
      }
      Menu localMenu;
      do
      {
        return super.onCreatePanelView(paramInt);
        localMenu = o.c(o.this).r();
      } while ((!onPreparePanel(paramInt, null, localMenu)) || (!onMenuOpened(paramInt, localMenu)));
      return o.a(o.this, localMenu);
    }
    
    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if ((bool) && (!o.b(o.this)))
      {
        o.c(o.this).m();
        o.a(o.this, true);
      }
      return bool;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */