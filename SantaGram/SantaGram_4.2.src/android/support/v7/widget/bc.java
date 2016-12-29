package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.j.af;
import android.support.v4.j.av;
import android.support.v4.j.ba;
import android.support.v7.b.a.a;
import android.support.v7.b.a.e;
import android.support.v7.b.a.f;
import android.support.v7.b.a.i;
import android.support.v7.b.a.k;
import android.support.v7.view.menu.a;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.view.menu.l.a;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class bc
  implements ae
{
  private Toolbar a;
  private int b;
  private View c;
  private View d;
  private Drawable e;
  private Drawable f;
  private Drawable g;
  private boolean h;
  private CharSequence i;
  private CharSequence j;
  private CharSequence k;
  private Window.Callback l;
  private boolean m;
  private d n;
  private int o = 0;
  private final m p;
  private int q = 0;
  private Drawable r;
  
  public bc(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, a.i.abc_action_bar_up_description, a.e.abc_ic_ab_back_mtrl_am_alpha);
  }
  
  public bc(Toolbar paramToolbar, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.a = paramToolbar;
    this.i = paramToolbar.getTitle();
    this.j = paramToolbar.getSubtitle();
    boolean bool;
    if (this.i != null)
    {
      bool = true;
      this.h = bool;
      this.g = paramToolbar.getNavigationIcon();
      if (!paramBoolean) {
        break label495;
      }
      paramToolbar = bb.a(paramToolbar.getContext(), null, a.k.ActionBar, a.a.actionBarStyle, 0);
      Object localObject = paramToolbar.c(a.k.ActionBar_title);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        b((CharSequence)localObject);
      }
      localObject = paramToolbar.c(a.k.ActionBar_subtitle);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        c((CharSequence)localObject);
      }
      localObject = paramToolbar.a(a.k.ActionBar_logo);
      if (localObject != null) {
        c((Drawable)localObject);
      }
      localObject = paramToolbar.a(a.k.ActionBar_icon);
      if ((this.g == null) && (localObject != null)) {
        a((Drawable)localObject);
      }
      localObject = paramToolbar.a(a.k.ActionBar_homeAsUpIndicator);
      if (localObject != null) {
        d((Drawable)localObject);
      }
      c(paramToolbar.a(a.k.ActionBar_displayOptions, 0));
      int i1 = paramToolbar.g(a.k.ActionBar_customNavigationLayout, 0);
      if (i1 != 0)
      {
        a(LayoutInflater.from(this.a.getContext()).inflate(i1, this.a, false));
        c(this.b | 0x10);
      }
      i1 = paramToolbar.f(a.k.ActionBar_height, 0);
      if (i1 > 0)
      {
        localObject = this.a.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = i1;
        this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      i1 = paramToolbar.d(a.k.ActionBar_contentInsetStart, -1);
      int i2 = paramToolbar.d(a.k.ActionBar_contentInsetEnd, -1);
      if ((i1 >= 0) || (i2 >= 0)) {
        this.a.a(Math.max(i1, 0), Math.max(i2, 0));
      }
      i1 = paramToolbar.g(a.k.ActionBar_titleTextStyle, 0);
      if (i1 != 0) {
        this.a.a(this.a.getContext(), i1);
      }
      i1 = paramToolbar.g(a.k.ActionBar_subtitleTextStyle, 0);
      if (i1 != 0) {
        this.a.b(this.a.getContext(), i1);
      }
      i1 = paramToolbar.g(a.k.ActionBar_popupTheme, 0);
      if (i1 != 0) {
        this.a.setPopupTheme(i1);
      }
      paramToolbar.a();
    }
    for (;;)
    {
      this.p = m.a();
      e(paramInt1);
      this.k = this.a.getNavigationContentDescription();
      b(this.p.a(b(), paramInt2));
      this.a.setNavigationOnClickListener(new View.OnClickListener()
      {
        final a a = new a(bc.a(bc.this).getContext(), 0, 16908332, 0, 0, bc.b(bc.this));
        
        public void onClick(View paramAnonymousView)
        {
          if ((bc.c(bc.this) != null) && (bc.d(bc.this))) {
            bc.c(bc.this).onMenuItemSelected(0, this.a);
          }
        }
      });
      return;
      bool = false;
      break;
      label495:
      this.b = s();
    }
  }
  
  private void e(CharSequence paramCharSequence)
  {
    this.i = paramCharSequence;
    if ((this.b & 0x8) != 0) {
      this.a.setTitle(paramCharSequence);
    }
  }
  
  private int s()
  {
    int i1 = 11;
    if (this.a.getNavigationIcon() != null) {
      i1 = 15;
    }
    return i1;
  }
  
  private void t()
  {
    Drawable localDrawable = null;
    if ((this.b & 0x2) != 0)
    {
      if ((this.b & 0x1) == 0) {
        break label49;
      }
      if (this.f == null) {
        break label41;
      }
      localDrawable = this.f;
    }
    for (;;)
    {
      this.a.setLogo(localDrawable);
      return;
      label41:
      localDrawable = this.e;
      continue;
      label49:
      localDrawable = this.e;
    }
  }
  
  private void u()
  {
    if ((this.b & 0x4) != 0)
    {
      if (TextUtils.isEmpty(this.k)) {
        this.a.setNavigationContentDescription(this.q);
      }
    }
    else {
      return;
    }
    this.a.setNavigationContentDescription(this.k);
  }
  
  private void v()
  {
    Toolbar localToolbar;
    if ((this.b & 0x4) != 0)
    {
      localToolbar = this.a;
      if (this.g == null) {
        break label32;
      }
    }
    label32:
    for (Drawable localDrawable = this.g;; localDrawable = this.r)
    {
      localToolbar.setNavigationIcon(localDrawable);
      return;
    }
  }
  
  public av a(final int paramInt, long paramLong)
  {
    av localav = af.q(this.a);
    if (paramInt == 0) {}
    for (float f1 = 1.0F;; f1 = 0.0F) {
      localav.a(f1).a(paramLong).a(new ba()
      {
        private boolean c = false;
        
        public void a(View paramAnonymousView)
        {
          bc.a(bc.this).setVisibility(0);
        }
        
        public void b(View paramAnonymousView)
        {
          if (!this.c) {
            bc.a(bc.this).setVisibility(paramInt);
          }
        }
        
        public void c(View paramAnonymousView)
        {
          this.c = true;
        }
      });
    }
  }
  
  public ViewGroup a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = this.p.a(b(), paramInt);; localDrawable = null)
    {
      a(localDrawable);
      return;
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    this.e = paramDrawable;
    t();
  }
  
  public void a(l.a parama, f.a parama1)
  {
    this.a.a(parama, parama1);
  }
  
  public void a(at paramat)
  {
    if ((this.c != null) && (this.c.getParent() == this.a)) {
      this.a.removeView(this.c);
    }
    this.c = paramat;
    if ((paramat != null) && (this.o == 2))
    {
      this.a.addView(this.c, 0);
      Toolbar.b localb = (Toolbar.b)this.c.getLayoutParams();
      localb.width = -2;
      localb.height = -2;
      localb.a = 8388691;
      paramat.setAllowCollapse(true);
    }
  }
  
  public void a(Menu paramMenu, l.a parama)
  {
    if (this.n == null)
    {
      this.n = new d(this.a.getContext());
      this.n.a(a.f.action_menu_presenter);
    }
    this.n.a(parama);
    this.a.a((f)paramMenu, this.n);
  }
  
  public void a(View paramView)
  {
    if ((this.d != null) && ((this.b & 0x10) != 0)) {
      this.a.removeView(this.d);
    }
    this.d = paramView;
    if ((paramView != null) && ((this.b & 0x10) != 0)) {
      this.a.addView(this.d);
    }
  }
  
  public void a(Window.Callback paramCallback)
  {
    this.l = paramCallback;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (!this.h) {
      e(paramCharSequence);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.setCollapsible(paramBoolean);
  }
  
  public Context b()
  {
    return this.a.getContext();
  }
  
  public void b(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = this.p.a(b(), paramInt);; localDrawable = null)
    {
      c(localDrawable);
      return;
    }
  }
  
  public void b(Drawable paramDrawable)
  {
    if (this.r != paramDrawable)
    {
      this.r = paramDrawable;
      v();
    }
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.h = true;
    e(paramCharSequence);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(int paramInt)
  {
    int i1 = this.b ^ paramInt;
    this.b = paramInt;
    if (i1 != 0)
    {
      if ((i1 & 0x4) != 0)
      {
        if ((paramInt & 0x4) == 0) {
          break label115;
        }
        v();
        u();
      }
      if ((i1 & 0x3) != 0) {
        t();
      }
      if ((i1 & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label126;
        }
        this.a.setTitle(this.i);
        this.a.setSubtitle(this.j);
      }
    }
    for (;;)
    {
      if (((i1 & 0x10) != 0) && (this.d != null))
      {
        if ((paramInt & 0x10) == 0) {
          break label145;
        }
        this.a.addView(this.d);
      }
      return;
      label115:
      this.a.setNavigationIcon(null);
      break;
      label126:
      this.a.setTitle(null);
      this.a.setSubtitle(null);
    }
    label145:
    this.a.removeView(this.d);
  }
  
  public void c(Drawable paramDrawable)
  {
    this.f = paramDrawable;
    t();
  }
  
  public void c(CharSequence paramCharSequence)
  {
    this.j = paramCharSequence;
    if ((this.b & 0x8) != 0) {
      this.a.setSubtitle(paramCharSequence);
    }
  }
  
  public boolean c()
  {
    return this.a.g();
  }
  
  public void d()
  {
    this.a.h();
  }
  
  public void d(int paramInt)
  {
    this.a.setVisibility(paramInt);
  }
  
  public void d(Drawable paramDrawable)
  {
    this.g = paramDrawable;
    v();
  }
  
  public void d(CharSequence paramCharSequence)
  {
    this.k = paramCharSequence;
    u();
  }
  
  public CharSequence e()
  {
    return this.a.getTitle();
  }
  
  public void e(int paramInt)
  {
    if (paramInt == this.q) {}
    do
    {
      return;
      this.q = paramInt;
    } while (!TextUtils.isEmpty(this.a.getNavigationContentDescription()));
    f(this.q);
  }
  
  public void f()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public void f(int paramInt)
  {
    if (paramInt == 0) {}
    for (Object localObject = null;; localObject = b().getString(paramInt))
    {
      d((CharSequence)localObject);
      return;
    }
  }
  
  public void g()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public boolean h()
  {
    return this.a.a();
  }
  
  public boolean i()
  {
    return this.a.b();
  }
  
  public boolean j()
  {
    return this.a.c();
  }
  
  public boolean k()
  {
    return this.a.d();
  }
  
  public boolean l()
  {
    return this.a.e();
  }
  
  public void m()
  {
    this.m = true;
  }
  
  public void n()
  {
    this.a.f();
  }
  
  public int o()
  {
    return this.b;
  }
  
  public int p()
  {
    return this.o;
  }
  
  public int q()
  {
    return this.a.getVisibility();
  }
  
  public Menu r()
  {
    return this.a.getMenu();
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */