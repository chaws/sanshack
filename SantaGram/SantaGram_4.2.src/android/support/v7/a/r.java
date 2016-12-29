package android.support.v7.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.j.af;
import android.support.v4.j.av;
import android.support.v4.j.az;
import android.support.v4.j.ba;
import android.support.v4.j.bb;
import android.support.v7.b.a.a;
import android.support.v7.b.a.f;
import android.support.v7.b.a.k;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ae;
import android.support.v7.widget.at;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class r
  extends a
  implements ActionBarOverlayLayout.a
{
  private static final Interpolator i;
  private static final Interpolator j;
  private static final boolean k;
  private boolean A;
  private int B = 0;
  private boolean C = true;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G = true;
  private h H;
  private boolean I;
  a a;
  b b;
  b.a c;
  boolean d;
  final az e = new ba()
  {
    public void b(View paramAnonymousView)
    {
      if ((r.a(r.this)) && (r.b(r.this) != null))
      {
        af.b(r.b(r.this), 0.0F);
        af.b(r.c(r.this), 0.0F);
      }
      r.c(r.this).setVisibility(8);
      r.c(r.this).setTransitioning(false);
      r.a(r.this, null);
      r.this.j();
      if (r.d(r.this) != null) {
        af.s(r.d(r.this));
      }
    }
  };
  final az f = new ba()
  {
    public void b(View paramAnonymousView)
    {
      r.a(r.this, null);
      r.c(r.this).requestLayout();
    }
  };
  final bb g = new bb()
  {
    public void a(View paramAnonymousView)
    {
      ((View)r.c(r.this).getParent()).invalidate();
    }
  };
  private Context l;
  private Context m;
  private Activity n;
  private Dialog o;
  private ActionBarOverlayLayout p;
  private ActionBarContainer q;
  private ae r;
  private ActionBarContextView s;
  private View t;
  private at u;
  private ArrayList<Object> v = new ArrayList();
  private int w = -1;
  private boolean x;
  private boolean y;
  private ArrayList<a.b> z = new ArrayList();
  
  static
  {
    boolean bool2 = true;
    if (!r.class.desiredAssertionStatus())
    {
      bool1 = true;
      h = bool1;
      i = new AccelerateInterpolator();
      j = new DecelerateInterpolator();
      if (Build.VERSION.SDK_INT < 14) {
        break label56;
      }
    }
    label56:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      k = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public r(Activity paramActivity, boolean paramBoolean)
  {
    this.n = paramActivity;
    paramActivity = paramActivity.getWindow().getDecorView();
    a(paramActivity);
    if (!paramBoolean) {
      this.t = paramActivity.findViewById(16908290);
    }
  }
  
  public r(Dialog paramDialog)
  {
    this.o = paramDialog;
    a(paramDialog.getWindow().getDecorView());
  }
  
  private void a(View paramView)
  {
    this.p = ((ActionBarOverlayLayout)paramView.findViewById(a.f.decor_content_parent));
    if (this.p != null) {
      this.p.setActionBarVisibilityCallback(this);
    }
    this.r = b(paramView.findViewById(a.f.action_bar));
    this.s = ((ActionBarContextView)paramView.findViewById(a.f.action_context_bar));
    this.q = ((ActionBarContainer)paramView.findViewById(a.f.action_bar_container));
    if ((this.r == null) || (this.s == null) || (this.q == null)) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
    }
    this.l = this.r.b();
    int i1;
    if ((this.r.o() & 0x4) != 0)
    {
      i1 = 1;
      if (i1 != 0) {
        this.x = true;
      }
      paramView = android.support.v7.view.a.a(this.l);
      if ((!paramView.f()) && (i1 == 0)) {
        break label264;
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      k(paramView.d());
      paramView = this.l.obtainStyledAttributes(null, a.k.ActionBar, a.a.actionBarStyle, 0);
      if (paramView.getBoolean(a.k.ActionBar_hideOnContentScroll, false)) {
        c(true);
      }
      i1 = paramView.getDimensionPixelSize(a.k.ActionBar_elevation, 0);
      if (i1 != 0) {
        a(i1);
      }
      paramView.recycle();
      return;
      i1 = 0;
      break;
    }
  }
  
  private ae b(View paramView)
  {
    if ((paramView instanceof ae)) {
      return (ae)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    if ("Can't make a decor toolbar out of " + paramView != null) {}
    for (paramView = paramView.getClass().getSimpleName();; paramView = "null") {
      throw new IllegalStateException(paramView);
    }
  }
  
  private static boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private void k(boolean paramBoolean)
  {
    boolean bool = true;
    this.A = paramBoolean;
    int i1;
    label46:
    label79:
    Object localObject;
    if (!this.A)
    {
      this.r.a(null);
      this.q.setTabContainer(this.u);
      if (k() != 2) {
        break label153;
      }
      i1 = 1;
      if (this.u != null)
      {
        if (i1 == 0) {
          break label158;
        }
        this.u.setVisibility(0);
        if (this.p != null) {
          af.s(this.p);
        }
      }
      localObject = this.r;
      if ((this.A) || (i1 == 0)) {
        break label170;
      }
      paramBoolean = true;
      label97:
      ((ae)localObject).a(paramBoolean);
      localObject = this.p;
      if ((this.A) || (i1 == 0)) {
        break label175;
      }
    }
    label153:
    label158:
    label170:
    label175:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((ActionBarOverlayLayout)localObject).setHasNonEmbeddedTabs(paramBoolean);
      return;
      this.q.setTabContainer(null);
      this.r.a(this.u);
      break;
      i1 = 0;
      break label46;
      this.u.setVisibility(8);
      break label79;
      paramBoolean = false;
      break label97;
    }
  }
  
  private void l(boolean paramBoolean)
  {
    if (b(this.D, this.E, this.F)) {
      if (!this.G)
      {
        this.G = true;
        h(paramBoolean);
      }
    }
    while (!this.G) {
      return;
    }
    this.G = false;
    i(paramBoolean);
  }
  
  private void q()
  {
    if (!this.F)
    {
      this.F = true;
      if (this.p != null) {
        this.p.setShowingForActionMode(true);
      }
      l(false);
    }
  }
  
  private void r()
  {
    if (this.F)
    {
      this.F = false;
      if (this.p != null) {
        this.p.setShowingForActionMode(false);
      }
      l(false);
    }
  }
  
  public int a()
  {
    return this.r.o();
  }
  
  public b a(b.a parama)
  {
    if (this.a != null) {
      this.a.c();
    }
    this.p.setHideOnContentScrollEnabled(false);
    this.s.c();
    parama = new a(this.s.getContext(), parama);
    if (parama.e())
    {
      parama.d();
      this.s.a(parama);
      j(true);
      this.s.sendAccessibilityEvent(32);
      this.a = parama;
      return parama;
    }
    return null;
  }
  
  public void a(float paramFloat)
  {
    af.d(this.q, paramFloat);
  }
  
  public void a(int paramInt)
  {
    a(this.l.getString(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1 = this.r.o();
    if ((paramInt2 & 0x4) != 0) {
      this.x = true;
    }
    this.r.c(i1 & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public void a(Configuration paramConfiguration)
  {
    k(android.support.v7.view.a.a(this.l).d());
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.r.b(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 4;; i1 = 0)
    {
      a(i1, 4);
      return;
    }
  }
  
  public void b()
  {
    if (!this.D)
    {
      this.D = true;
      l(false);
    }
  }
  
  public void b(int paramInt)
  {
    this.B = paramInt;
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.r.a(paramCharSequence);
  }
  
  public void b(boolean paramBoolean)
  {
    this.r.b(paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.p.a())) {
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    this.d = paramBoolean;
    this.p.setHideOnContentScrollEnabled(paramBoolean);
  }
  
  public boolean c()
  {
    int i1 = l();
    return (this.G) && ((i1 == 0) || (e() < i1));
  }
  
  public Context d()
  {
    int i1;
    if (this.m == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.l.getTheme().resolveAttribute(a.a.actionBarWidgetTheme, localTypedValue, true);
      i1 = localTypedValue.resourceId;
      if (i1 == 0) {
        break label61;
      }
    }
    label61:
    for (this.m = new ContextThemeWrapper(this.l, i1);; this.m = this.l) {
      return this.m;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (!this.x) {
      a(paramBoolean);
    }
  }
  
  public int e()
  {
    return this.p.getActionBarHideOffset();
  }
  
  public void e(boolean paramBoolean)
  {
    this.I = paramBoolean;
    if ((!paramBoolean) && (this.H != null)) {
      this.H.b();
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean == this.y) {}
    for (;;)
    {
      return;
      this.y = paramBoolean;
      int i2 = this.z.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((a.b)this.z.get(i1)).a(paramBoolean);
        i1 += 1;
      }
    }
  }
  
  public void g(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public boolean g()
  {
    if ((this.r != null) && (this.r.c()))
    {
      this.r.d();
      return true;
    }
    return false;
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.H != null) {
      this.H.b();
    }
    this.q.setVisibility(0);
    if ((this.B == 0) && (k) && ((this.I) || (paramBoolean)))
    {
      af.b(this.q, 0.0F);
      float f2 = -this.q.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp77_75 = localObject;
        tmp77_75[0] = 0;
        Object tmp81_77 = tmp77_75;
        tmp81_77[1] = 0;
        tmp81_77;
        this.q.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      af.b(this.q, f1);
      Object localObject = new h();
      av localav = af.q(this.q).c(0.0F);
      localav.a(this.g);
      ((h)localObject).a(localav);
      if ((this.C) && (this.t != null))
      {
        af.b(this.t, f1);
        ((h)localObject).a(af.q(this.t).c(0.0F));
      }
      ((h)localObject).a(j);
      ((h)localObject).a(250L);
      ((h)localObject).a(this.f);
      this.H = ((h)localObject);
      ((h)localObject).a();
    }
    for (;;)
    {
      if (this.p != null) {
        af.s(this.p);
      }
      return;
      af.c(this.q, 1.0F);
      af.b(this.q, 0.0F);
      if ((this.C) && (this.t != null)) {
        af.b(this.t, 0.0F);
      }
      this.f.b(null);
    }
  }
  
  public boolean h()
  {
    ViewGroup localViewGroup = this.r.a();
    if ((localViewGroup != null) && (!localViewGroup.hasFocus()))
    {
      localViewGroup.requestFocus();
      return true;
    }
    return false;
  }
  
  public void i(boolean paramBoolean)
  {
    if (this.H != null) {
      this.H.b();
    }
    if ((this.B == 0) && (k) && ((this.I) || (paramBoolean)))
    {
      af.c(this.q, 1.0F);
      this.q.setTransitioning(true);
      h localh = new h();
      float f2 = -this.q.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp86_84 = localObject;
        tmp86_84[0] = 0;
        Object tmp90_86 = tmp86_84;
        tmp90_86[1] = 0;
        tmp90_86;
        this.q.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = af.q(this.q).c(f1);
      ((av)localObject).a(this.g);
      localh.a((av)localObject);
      if ((this.C) && (this.t != null)) {
        localh.a(af.q(this.t).c(f1));
      }
      localh.a(i);
      localh.a(250L);
      localh.a(this.e);
      this.H = localh;
      localh.a();
      return;
    }
    this.e.b(null);
  }
  
  void j()
  {
    if (this.c != null)
    {
      this.c.a(this.b);
      this.b = null;
      this.c = null;
    }
  }
  
  public void j(boolean paramBoolean)
  {
    av localav1;
    av localav2;
    if (paramBoolean)
    {
      q();
      if (!paramBoolean) {
        break label68;
      }
      localav1 = this.r.a(4, 100L);
      localav2 = this.s.a(0, 200L);
    }
    for (;;)
    {
      h localh = new h();
      localh.a(localav1, localav2);
      localh.a();
      return;
      r();
      break;
      label68:
      localav2 = this.r.a(0, 200L);
      localav1 = this.s.a(8, 100L);
    }
  }
  
  public int k()
  {
    return this.r.p();
  }
  
  public int l()
  {
    return this.q.getHeight();
  }
  
  public void m()
  {
    if (this.E)
    {
      this.E = false;
      l(true);
    }
  }
  
  public void n()
  {
    if (!this.E)
    {
      this.E = true;
      l(true);
    }
  }
  
  public void o()
  {
    if (this.H != null)
    {
      this.H.b();
      this.H = null;
    }
  }
  
  public void p() {}
  
  public class a
    extends b
    implements f.a
  {
    private final Context b;
    private final f c;
    private b.a d;
    private WeakReference<View> e;
    
    public a(Context paramContext, b.a parama)
    {
      this.b = paramContext;
      this.d = parama;
      this.c = new f(paramContext).a(1);
      this.c.a(this);
    }
    
    public MenuInflater a()
    {
      return new g(this.b);
    }
    
    public void a(int paramInt)
    {
      b(r.i(r.this).getResources().getString(paramInt));
    }
    
    public void a(f paramf)
    {
      if (this.d == null) {
        return;
      }
      d();
      r.g(r.this).a();
    }
    
    public void a(View paramView)
    {
      r.g(r.this).setCustomView(paramView);
      this.e = new WeakReference(paramView);
    }
    
    public void a(CharSequence paramCharSequence)
    {
      r.g(r.this).setSubtitle(paramCharSequence);
    }
    
    public void a(boolean paramBoolean)
    {
      super.a(paramBoolean);
      r.g(r.this).setTitleOptional(paramBoolean);
    }
    
    public boolean a(f paramf, MenuItem paramMenuItem)
    {
      if (this.d != null) {
        return this.d.a(this, paramMenuItem);
      }
      return false;
    }
    
    public Menu b()
    {
      return this.c;
    }
    
    public void b(int paramInt)
    {
      a(r.i(r.this).getResources().getString(paramInt));
    }
    
    public void b(CharSequence paramCharSequence)
    {
      r.g(r.this).setTitle(paramCharSequence);
    }
    
    public void c()
    {
      if (r.this.a != this) {
        return;
      }
      if (!r.a(r.e(r.this), r.f(r.this), false))
      {
        r.this.b = this;
        r.this.c = this.d;
      }
      for (;;)
      {
        this.d = null;
        r.this.j(false);
        r.g(r.this).b();
        r.h(r.this).a().sendAccessibilityEvent(32);
        r.d(r.this).setHideOnContentScrollEnabled(r.this.d);
        r.this.a = null;
        return;
        this.d.a(this);
      }
    }
    
    public void d()
    {
      if (r.this.a != this) {
        return;
      }
      this.c.g();
      try
      {
        this.d.b(this, this.c);
        return;
      }
      finally
      {
        this.c.h();
      }
    }
    
    public boolean e()
    {
      this.c.g();
      try
      {
        boolean bool = this.d.a(this, this.c);
        return bool;
      }
      finally
      {
        this.c.h();
      }
    }
    
    public CharSequence f()
    {
      return r.g(r.this).getTitle();
    }
    
    public CharSequence g()
    {
      return r.g(r.this).getSubtitle();
    }
    
    public boolean h()
    {
      return r.g(r.this).d();
    }
    
    public View i()
    {
      if (this.e != null) {
        return (View)this.e.get();
      }
      return null;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */