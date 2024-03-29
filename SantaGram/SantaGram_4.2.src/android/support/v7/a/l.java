package android.support.v7.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.b.z;
import android.support.v4.j.aa;
import android.support.v4.j.af;
import android.support.v4.j.aq;
import android.support.v4.j.av;
import android.support.v4.j.ba;
import android.support.v4.j.bc;
import android.support.v4.j.i;
import android.support.v7.b.a.a;
import android.support.v7.b.a.c;
import android.support.v7.b.a.f;
import android.support.v7.b.a.h;
import android.support.v7.b.a.j;
import android.support.v7.b.a.k;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.view.d;
import android.support.v7.view.menu.f.a;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ad;
import android.support.v7.widget.ah;
import android.support.v7.widget.ah.a;
import android.support.v7.widget.bd;
import android.support.v7.widget.bf;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;

class l
  extends h
  implements android.support.v4.j.m, f.a
{
  private boolean A;
  private d[] B;
  private d C;
  private boolean D;
  private boolean E;
  private int F;
  private final Runnable G = new Runnable()
  {
    public void run()
    {
      if ((l.a(l.this) & 0x1) != 0) {
        l.a(l.this, 0);
      }
      if ((l.a(l.this) & 0x1000) != 0) {
        l.a(l.this, 108);
      }
      l.a(l.this, false);
      l.b(l.this, 0);
    }
  };
  private boolean H;
  private Rect I;
  private Rect J;
  private n K;
  b m;
  ActionBarContextView n;
  PopupWindow o;
  Runnable p;
  av q = null;
  private ad r;
  private a s;
  private e t;
  private boolean u;
  private ViewGroup v;
  private TextView w;
  private View x;
  private boolean y;
  private boolean z;
  
  l(Context paramContext, Window paramWindow, f paramf)
  {
    super(paramContext, paramWindow, paramf);
  }
  
  private d a(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = this.B;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > paramInt) {}
    }
    else
    {
      localObject1 = new d[paramInt + 1];
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      }
      this.B = ((d[])localObject1);
    }
    localObject2 = localObject1[paramInt];
    if (localObject2 == null)
    {
      localObject2 = new d(paramInt);
      localObject1[paramInt] = localObject2;
      return (d)localObject2;
    }
    return (d)localObject2;
  }
  
  private d a(Menu paramMenu)
  {
    d[] arrayOfd = this.B;
    int i;
    int j;
    if (arrayOfd != null)
    {
      i = arrayOfd.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label57;
      }
      d locald = arrayOfd[j];
      if ((locald != null) && (locald.j == paramMenu))
      {
        return locald;
        i = 0;
        break;
      }
      j += 1;
    }
    label57:
    return null;
  }
  
  private void a(int paramInt, d paramd, Menu paramMenu)
  {
    Object localObject1 = paramd;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      d locald = paramd;
      if (paramd == null)
      {
        locald = paramd;
        if (paramInt >= 0)
        {
          locald = paramd;
          if (paramInt < this.B.length) {
            locald = this.B[paramInt];
          }
        }
      }
      localObject1 = locald;
      localObject2 = paramMenu;
      if (locald != null)
      {
        localObject2 = locald.j;
        localObject1 = locald;
      }
    }
    if ((localObject1 != null) && (!((d)localObject1).o)) {}
    while (p()) {
      return;
    }
    this.c.onPanelClosed(paramInt, (Menu)localObject2);
  }
  
  private void a(d paramd, KeyEvent paramKeyEvent)
  {
    int k = -1;
    if ((paramd.o) || (p())) {}
    Object localObject;
    int i;
    label108:
    label114:
    label118:
    label120:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramd.a == 0)
          {
            localObject = this.a;
            if ((((Context)localObject).getResources().getConfiguration().screenLayout & 0xF) != 4) {
              break label108;
            }
            i = 1;
            if (((Context)localObject).getApplicationInfo().targetSdkVersion < 11) {
              break label114;
            }
          }
          for (int j = 1;; j = 0)
          {
            if ((i != 0) && (j != 0)) {
              break label118;
            }
            localObject = q();
            if ((localObject == null) || (((Window.Callback)localObject).onMenuOpened(paramd.a, paramd.j))) {
              break label120;
            }
            a(paramd, true);
            return;
            i = 0;
            break;
          }
        }
        localObject = (WindowManager)this.a.getSystemService("window");
      } while ((localObject == null) || (!b(paramd, paramKeyEvent)));
      if ((paramd.g != null) && (!paramd.q)) {
        break label396;
      }
      if (paramd.g != null) {
        break;
      }
    } while ((!a(paramd)) || (paramd.g == null));
    label182:
    if ((c(paramd)) && (paramd.a()))
    {
      paramKeyEvent = paramd.h.getLayoutParams();
      if (paramKeyEvent != null) {
        break label434;
      }
      paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
    }
    label396:
    label434:
    for (;;)
    {
      i = paramd.b;
      paramd.g.setBackgroundResource(i);
      ViewParent localViewParent = paramd.h.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeView(paramd.h);
      }
      paramd.g.addView(paramd.h, paramKeyEvent);
      if (!paramd.h.hasFocus()) {
        paramd.h.requestFocus();
      }
      i = -2;
      for (;;)
      {
        paramd.n = false;
        paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramd.d, paramd.e, 1002, 8519680, -3);
        paramKeyEvent.gravity = paramd.c;
        paramKeyEvent.windowAnimations = paramd.f;
        ((WindowManager)localObject).addView(paramd.g, paramKeyEvent);
        paramd.o = true;
        return;
        if ((!paramd.q) || (paramd.g.getChildCount() <= 0)) {
          break label182;
        }
        paramd.g.removeAllViews();
        break label182;
        break;
        if (paramd.i != null)
        {
          paramKeyEvent = paramd.i.getLayoutParams();
          if (paramKeyEvent != null)
          {
            i = k;
            if (paramKeyEvent.width == -1) {
              continue;
            }
          }
        }
        i = -2;
      }
    }
  }
  
  private void a(d paramd, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramd.a == 0) && (this.r != null) && (this.r.e())) {
      b(paramd.j);
    }
    do
    {
      return;
      WindowManager localWindowManager = (WindowManager)this.a.getSystemService("window");
      if ((localWindowManager != null) && (paramd.o) && (paramd.g != null))
      {
        localWindowManager.removeView(paramd.g);
        if (paramBoolean) {
          a(paramd.a, paramd, null);
        }
      }
      paramd.m = false;
      paramd.n = false;
      paramd.o = false;
      paramd.h = null;
      paramd.q = true;
    } while (this.C != paramd);
    this.C = null;
  }
  
  private void a(android.support.v7.view.menu.f paramf, boolean paramBoolean)
  {
    if ((this.r != null) && (this.r.d()) && ((!aq.b(ViewConfiguration.get(this.a))) || (this.r.f())))
    {
      paramf = q();
      if ((!this.r.e()) || (!paramBoolean)) {
        if ((paramf != null) && (!p()))
        {
          if ((this.E) && ((this.F & 0x1) != 0))
          {
            this.b.getDecorView().removeCallbacks(this.G);
            this.G.run();
          }
          d locald = a(0, true);
          if ((locald.j != null) && (!locald.r) && (paramf.onPreparePanel(0, locald.i, locald.j)))
          {
            paramf.onMenuOpened(108, locald.j);
            this.r.g();
          }
        }
      }
      do
      {
        return;
        this.r.h();
      } while (p());
      paramf.onPanelClosed(108, a(0, true).j);
      return;
    }
    paramf = a(0, true);
    paramf.q = true;
    a(paramf, false);
    a(paramf, null);
  }
  
  private boolean a(d paramd)
  {
    paramd.a(n());
    paramd.g = new c(paramd.l);
    paramd.c = 81;
    return true;
  }
  
  private boolean a(d paramd, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramKeyEvent.isSystem()) {
      bool2 = bool1;
    }
    do
    {
      do
      {
        do
        {
          return bool2;
          if (!paramd.m)
          {
            bool1 = bool2;
            if (!b(paramd, paramKeyEvent)) {}
          }
          else
          {
            bool1 = bool2;
            if (paramd.j != null) {
              bool1 = paramd.j.performShortcut(paramInt1, paramKeyEvent, paramInt2);
            }
          }
          bool2 = bool1;
        } while (!bool1);
        bool2 = bool1;
      } while ((paramInt2 & 0x1) != 0);
      bool2 = bool1;
    } while (this.r != null);
    a(paramd, true);
    return bool1;
  }
  
  private boolean a(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    View localView = this.b.getDecorView();
    for (;;)
    {
      if (paramViewParent == null) {
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof View)) || (af.C((View)paramViewParent))) {
        return false;
      }
      paramViewParent = paramViewParent.getParent();
    }
  }
  
  private void b(android.support.v7.view.menu.f paramf)
  {
    if (this.A) {
      return;
    }
    this.A = true;
    this.r.j();
    Window.Callback localCallback = q();
    if ((localCallback != null) && (!p())) {
      localCallback.onPanelClosed(108, paramf);
    }
    this.A = false;
  }
  
  private boolean b(d paramd)
  {
    Context localContext = this.a;
    TypedValue localTypedValue;
    Resources.Theme localTheme;
    Object localObject1;
    if (((paramd.a == 0) || (paramd.a == 108)) && (this.r != null))
    {
      localTypedValue = new TypedValue();
      localTheme = localContext.getTheme();
      localTheme.resolveAttribute(a.a.actionBarTheme, localTypedValue, true);
      localObject1 = null;
      if (localTypedValue.resourceId != 0)
      {
        localObject1 = localContext.getResources().newTheme();
        ((Resources.Theme)localObject1).setTo(localTheme);
        ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
        ((Resources.Theme)localObject1).resolveAttribute(a.a.actionBarWidgetTheme, localTypedValue, true);
        Object localObject2 = localObject1;
        if (localTypedValue.resourceId != 0)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localContext.getResources().newTheme();
            ((Resources.Theme)localObject2).setTo(localTheme);
          }
          ((Resources.Theme)localObject2).applyStyle(localTypedValue.resourceId, true);
        }
        if (localObject2 == null) {
          break label203;
        }
        localObject1 = new d(localContext, 0);
        ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = new android.support.v7.view.menu.f((Context)localObject1);
      ((android.support.v7.view.menu.f)localObject1).a(this);
      paramd.a((android.support.v7.view.menu.f)localObject1);
      return true;
      localTheme.resolveAttribute(a.a.actionBarWidgetTheme, localTypedValue, true);
      break;
      label203:
      localObject1 = localContext;
    }
  }
  
  private boolean b(d paramd, KeyEvent paramKeyEvent)
  {
    if (p()) {
      return false;
    }
    if (paramd.m) {
      return true;
    }
    if ((this.C != null) && (this.C != paramd)) {
      a(this.C, false);
    }
    Window.Callback localCallback = q();
    if (localCallback != null) {
      paramd.i = localCallback.onCreatePanelView(paramd.a);
    }
    if ((paramd.a == 0) || (paramd.a == 108)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.r != null)) {
        this.r.i();
      }
      if ((paramd.i != null) || ((i != 0) && ((m() instanceof o)))) {
        break label412;
      }
      if ((paramd.j != null) && (!paramd.r)) {
        break label280;
      }
      if ((paramd.j == null) && ((!b(paramd)) || (paramd.j == null))) {
        break;
      }
      if ((i != 0) && (this.r != null))
      {
        if (this.s == null) {
          this.s = new a(null);
        }
        this.r.a(paramd.j, this.s);
      }
      paramd.j.g();
      if (localCallback.onCreatePanelMenu(paramd.a, paramd.j)) {
        break label275;
      }
      paramd.a(null);
      if ((i == 0) || (this.r == null)) {
        break;
      }
      this.r.a(null, this.s);
      return false;
    }
    label275:
    paramd.r = false;
    label280:
    paramd.j.g();
    if (paramd.s != null)
    {
      paramd.j.b(paramd.s);
      paramd.s = null;
    }
    if (!localCallback.onPreparePanel(0, paramd.i, paramd.j))
    {
      if ((i != 0) && (this.r != null)) {
        this.r.a(null, this.s);
      }
      paramd.j.h();
      return false;
    }
    if (paramKeyEvent != null)
    {
      i = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
        break label435;
      }
    }
    label412:
    label435:
    for (boolean bool = true;; bool = false)
    {
      paramd.p = bool;
      paramd.j.setQwertyMode(paramd.p);
      paramd.j.h();
      paramd.m = true;
      paramd.n = false;
      this.C = paramd;
      return true;
      i = -1;
      break;
    }
  }
  
  private boolean c(d paramd)
  {
    if (paramd.i != null)
    {
      paramd.h = paramd.i;
      return true;
    }
    if (paramd.j == null) {
      return false;
    }
    if (this.t == null) {
      this.t = new e(null);
    }
    paramd.h = ((View)paramd.a(this.t));
    if (paramd.h != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void d(int paramInt)
  {
    a(a(paramInt, true), true);
  }
  
  private boolean d(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getRepeatCount() == 0)
    {
      d locald = a(paramInt, true);
      if (!locald.o) {
        return b(locald, paramKeyEvent);
      }
    }
    return false;
  }
  
  private void e(int paramInt)
  {
    this.F |= 1 << paramInt;
    if (!this.E)
    {
      af.a(this.b.getDecorView(), this.G);
      this.E = true;
    }
  }
  
  private boolean e(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    if (this.m != null) {
      return false;
    }
    d locald = a(paramInt, true);
    if ((paramInt == 0) && (this.r != null) && (this.r.d()) && (!aq.b(ViewConfiguration.get(this.a)))) {
      if (!this.r.e())
      {
        if ((p()) || (!b(locald, paramKeyEvent))) {
          break label226;
        }
        bool1 = this.r.g();
      }
    }
    for (;;)
    {
      if (bool1)
      {
        paramKeyEvent = (AudioManager)this.a.getSystemService("audio");
        if (paramKeyEvent == null) {
          break label213;
        }
        paramKeyEvent.playSoundEffect(0);
      }
      label122:
      return bool1;
      bool1 = this.r.h();
      continue;
      if ((!locald.o) && (!locald.n)) {
        break;
      }
      bool1 = locald.o;
      a(locald, true);
    }
    if (locald.m)
    {
      if (!locald.r) {
        break label232;
      }
      locald.m = false;
    }
    label213:
    label226:
    label232:
    for (boolean bool1 = b(locald, paramKeyEvent);; bool1 = true)
    {
      if (bool1)
      {
        a(locald, paramKeyEvent);
        bool1 = bool2;
        break;
        Log.w("AppCompatDelegate", "Couldn't get audio manager");
        break label122;
      }
      bool1 = false;
      break;
    }
  }
  
  private void f(int paramInt)
  {
    d locald = a(paramInt, true);
    if (locald.j != null)
    {
      Bundle localBundle = new Bundle();
      locald.j.a(localBundle);
      if (localBundle.size() > 0) {
        locald.s = localBundle;
      }
      locald.j.g();
      locald.j.clear();
    }
    locald.r = true;
    locald.q = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.r != null))
    {
      locald = a(0, false);
      if (locald != null)
      {
        locald.m = false;
        b(locald, null);
      }
    }
  }
  
  private int g(int paramInt)
  {
    int j = 1;
    int k = 1;
    int i1 = 0;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.n != null) && ((this.n.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.n.getLayoutParams();
      if (this.n.isShown())
      {
        if (this.I == null)
        {
          this.I = new Rect();
          this.J = new Rect();
        }
        localObject2 = this.I;
        Rect localRect = this.J;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        bf.a(this.v, (Rect)localObject2, localRect);
        if (localRect.top == 0)
        {
          i = paramInt;
          if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == i) {
            break label361;
          }
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt;
          if (this.x != null) {
            break label286;
          }
          this.x = new View(this.a);
          this.x.setBackgroundColor(this.a.getResources().getColor(a.c.abc_input_method_navigation_guard));
          this.v.addView(this.x, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i = 1;
          label199:
          if (this.x == null) {
            break label321;
          }
          label206:
          j = paramInt;
          if (!this.j)
          {
            j = paramInt;
            if (k != 0) {
              j = 0;
            }
          }
          paramInt = j;
          j = i;
          i = k;
          label238:
          if (j != 0) {
            this.n.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      if (this.x != null)
      {
        localObject1 = this.x;
        if (i == 0) {
          break label345;
        }
      }
      label286:
      label321:
      label345:
      for (i = i1;; i = 8)
      {
        ((View)localObject1).setVisibility(i);
        return paramInt;
        i = 0;
        break;
        localObject2 = this.x.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject2).height != paramInt)
        {
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          this.x.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        i = 1;
        break label199;
        k = 0;
        break label206;
        if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == 0) {
          break label352;
        }
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;
        i = 0;
        break label238;
      }
      label352:
      j = 0;
      i = 0;
      break label238;
      label361:
      i = 0;
      break label199;
      i = 0;
    }
  }
  
  private int h(int paramInt)
  {
    int i;
    if (paramInt == 8)
    {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
      i = 108;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt != 9);
    Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
    return 109;
  }
  
  private void t()
  {
    if (!this.u)
    {
      this.v = u();
      Object localObject = r();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        b((CharSequence)localObject);
      }
      v();
      a(this.v);
      this.u = true;
      localObject = a(0, false);
      if ((!p()) && ((localObject == null) || (((d)localObject).j == null))) {
        e(108);
      }
    }
  }
  
  private ViewGroup u()
  {
    Object localObject = this.a.obtainStyledAttributes(a.k.AppCompatTheme);
    if (!((TypedArray)localObject).hasValue(a.k.AppCompatTheme_windowActionBar))
    {
      ((TypedArray)localObject).recycle();
      throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }
    if (((TypedArray)localObject).getBoolean(a.k.AppCompatTheme_windowNoTitle, false))
    {
      c(1);
      if (((TypedArray)localObject).getBoolean(a.k.AppCompatTheme_windowActionBarOverlay, false)) {
        c(109);
      }
      if (((TypedArray)localObject).getBoolean(a.k.AppCompatTheme_windowActionModeOverlay, false)) {
        c(10);
      }
      this.k = ((TypedArray)localObject).getBoolean(a.k.AppCompatTheme_android_windowIsFloating, false);
      ((TypedArray)localObject).recycle();
      this.b.getDecorView();
      localObject = LayoutInflater.from(this.a);
      if (this.l) {
        break label430;
      }
      if (!this.k) {
        break label271;
      }
      localObject = (ViewGroup)((LayoutInflater)localObject).inflate(a.h.abc_dialog_title_material, null);
      this.i = false;
      this.h = false;
    }
    for (;;)
    {
      if (localObject == null)
      {
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
        if (!((TypedArray)localObject).getBoolean(a.k.AppCompatTheme_windowActionBar, false)) {
          break;
        }
        c(108);
        break;
        label271:
        if (!this.h) {
          break label638;
        }
        localObject = new TypedValue();
        this.a.getTheme().resolveAttribute(a.a.actionBarTheme, (TypedValue)localObject, true);
        if (((TypedValue)localObject).resourceId != 0) {}
        for (localObject = new d(this.a, ((TypedValue)localObject).resourceId);; localObject = this.a)
        {
          localObject = (ViewGroup)LayoutInflater.from((Context)localObject).inflate(a.h.abc_screen_toolbar, null);
          this.r = ((ad)((ViewGroup)localObject).findViewById(a.f.decor_content_parent));
          this.r.setWindowCallback(q());
          if (this.i) {
            this.r.a(109);
          }
          if (this.y) {
            this.r.a(2);
          }
          if (this.z) {
            this.r.a(5);
          }
          break;
        }
        label430:
        if (this.j) {}
        for (localObject = (ViewGroup)((LayoutInflater)localObject).inflate(a.h.abc_screen_simple_overlay_action_mode, null);; localObject = (ViewGroup)((LayoutInflater)localObject).inflate(a.h.abc_screen_simple, null))
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label487;
          }
          af.a((View)localObject, new aa()
          {
            public bc a(View paramAnonymousView, bc paramAnonymousbc)
            {
              int i = paramAnonymousbc.b();
              int j = l.c(l.this, i);
              bc localbc = paramAnonymousbc;
              if (i != j) {
                localbc = paramAnonymousbc.a(paramAnonymousbc.a(), j, paramAnonymousbc.c(), paramAnonymousbc.d());
              }
              return af.a(paramAnonymousView, localbc);
            }
          });
          break;
        }
        label487:
        ((ah)localObject).setOnFitSystemWindowsListener(new ah.a()
        {
          public void a(Rect paramAnonymousRect)
          {
            paramAnonymousRect.top = l.c(l.this, paramAnonymousRect.top);
          }
        });
        continue;
      }
      if (this.r == null) {
        this.w = ((TextView)((ViewGroup)localObject).findViewById(a.f.title));
      }
      bf.b((View)localObject);
      ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)((ViewGroup)localObject).findViewById(a.f.action_bar_activity_content);
      ViewGroup localViewGroup = (ViewGroup)this.b.findViewById(16908290);
      if (localViewGroup != null)
      {
        while (localViewGroup.getChildCount() > 0)
        {
          View localView = localViewGroup.getChildAt(0);
          localViewGroup.removeViewAt(0);
          localContentFrameLayout.addView(localView);
        }
        localViewGroup.setId(-1);
        localContentFrameLayout.setId(16908290);
        if ((localViewGroup instanceof FrameLayout)) {
          ((FrameLayout)localViewGroup).setForeground(null);
        }
      }
      this.b.setContentView((View)localObject);
      localContentFrameLayout.setAttachListener(new ContentFrameLayout.a()
      {
        public void a() {}
        
        public void b()
        {
          l.b(l.this);
        }
      });
      return (ViewGroup)localObject;
      label638:
      localObject = null;
    }
  }
  
  private void v()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.v.findViewById(16908290);
    Object localObject = this.b.getDecorView();
    localContentFrameLayout.a(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
    localObject = this.a.obtainStyledAttributes(a.k.AppCompatTheme);
    ((TypedArray)localObject).getValue(a.k.AppCompatTheme_windowMinWidthMajor, localContentFrameLayout.getMinWidthMajor());
    ((TypedArray)localObject).getValue(a.k.AppCompatTheme_windowMinWidthMinor, localContentFrameLayout.getMinWidthMinor());
    if (((TypedArray)localObject).hasValue(a.k.AppCompatTheme_windowFixedWidthMajor)) {
      ((TypedArray)localObject).getValue(a.k.AppCompatTheme_windowFixedWidthMajor, localContentFrameLayout.getFixedWidthMajor());
    }
    if (((TypedArray)localObject).hasValue(a.k.AppCompatTheme_windowFixedWidthMinor)) {
      ((TypedArray)localObject).getValue(a.k.AppCompatTheme_windowFixedWidthMinor, localContentFrameLayout.getFixedWidthMinor());
    }
    if (((TypedArray)localObject).hasValue(a.k.AppCompatTheme_windowFixedHeightMajor)) {
      ((TypedArray)localObject).getValue(a.k.AppCompatTheme_windowFixedHeightMajor, localContentFrameLayout.getFixedHeightMajor());
    }
    if (((TypedArray)localObject).hasValue(a.k.AppCompatTheme_windowFixedHeightMinor)) {
      ((TypedArray)localObject).getValue(a.k.AppCompatTheme_windowFixedHeightMinor, localContentFrameLayout.getFixedHeightMinor());
    }
    ((TypedArray)localObject).recycle();
    localContentFrameLayout.requestLayout();
  }
  
  private void w()
  {
    if (this.q != null) {
      this.q.b();
    }
  }
  
  private void x()
  {
    if (this.u) {
      throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }
  }
  
  private void y()
  {
    if (this.r != null) {
      this.r.j();
    }
    if (this.o != null)
    {
      this.b.getDecorView().removeCallbacks(this.p);
      if (!this.o.isShowing()) {}
    }
    try
    {
      this.o.dismiss();
      this.o = null;
      w();
      d locald = a(0, false);
      if ((locald != null) && (locald.j != null)) {
        locald.j.close();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public b a(b.a parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (this.m != null) {
      this.m.c();
    }
    parama = new b(parama);
    a locala = a();
    if (locala != null)
    {
      this.m = locala.a(parama);
      if ((this.m != null) && (this.e != null)) {
        this.e.onSupportActionModeStarted(this.m);
      }
    }
    if (this.m == null) {
      this.m = b(parama);
    }
    return this.m;
  }
  
  public View a(int paramInt)
  {
    t();
    return this.b.findViewById(paramInt);
  }
  
  public final View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = b(paramView, paramString, paramContext, paramAttributeSet);
    if (localView != null) {
      return localView;
    }
    return c(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  void a(int paramInt, Menu paramMenu)
  {
    if (paramInt == 108)
    {
      paramMenu = a();
      if (paramMenu != null) {
        paramMenu.f(false);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      paramMenu = a(paramInt, true);
    } while (!paramMenu.o);
    a(paramMenu, false);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((this.h) && (this.u))
    {
      a locala = a();
      if (locala != null) {
        locala.a(paramConfiguration);
      }
    }
    i();
  }
  
  public void a(Bundle paramBundle)
  {
    if (((this.c instanceof Activity)) && (z.b((Activity)this.c) != null))
    {
      paramBundle = m();
      if (paramBundle == null) {
        this.H = true;
      }
    }
    else
    {
      return;
    }
    paramBundle.d(true);
  }
  
  public void a(android.support.v7.view.menu.f paramf)
  {
    a(paramf, true);
  }
  
  public void a(Toolbar paramToolbar)
  {
    if (!(this.c instanceof Activity)) {
      return;
    }
    a locala = a();
    if ((locala instanceof r)) {
      throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }
    this.g = null;
    if (locala != null) {
      locala.i();
    }
    if (paramToolbar != null)
    {
      paramToolbar = new o(paramToolbar, ((Activity)this.a).getTitle(), this.d);
      this.f = paramToolbar;
      this.b.setCallback(paramToolbar.j());
    }
    for (;;)
    {
      e();
      return;
      this.f = null;
      this.b.setCallback(this.d);
    }
  }
  
  public void a(View paramView)
  {
    t();
    ViewGroup localViewGroup = (ViewGroup)this.v.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.c.onContentChanged();
  }
  
  public void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    t();
    ViewGroup localViewGroup = (ViewGroup)this.v.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.c.onContentChanged();
  }
  
  void a(ViewGroup paramViewGroup) {}
  
  boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = a();
    if ((localObject != null) && (((a)localObject).a(paramInt, paramKeyEvent))) {}
    boolean bool;
    do
    {
      do
      {
        return true;
        if ((this.C == null) || (!a(this.C, paramKeyEvent.getKeyCode(), paramKeyEvent, 1))) {
          break;
        }
      } while (this.C == null);
      this.C.n = true;
      return true;
      if (this.C != null) {
        break;
      }
      localObject = a(0, true);
      b((d)localObject, paramKeyEvent);
      bool = a((d)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
      ((d)localObject).m = false;
    } while (bool);
    return false;
  }
  
  public boolean a(android.support.v7.view.menu.f paramf, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = q();
    if ((localCallback != null) && (!p()))
    {
      paramf = a(paramf.p());
      if (paramf != null) {
        return localCallback.onMenuItemSelected(paramf.a, paramMenuItem);
      }
    }
    return false;
  }
  
  boolean a(KeyEvent paramKeyEvent)
  {
    int i = 1;
    if ((paramKeyEvent.getKeyCode() == 82) && (this.c.dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    int j = paramKeyEvent.getKeyCode();
    if (paramKeyEvent.getAction() == 0) {}
    while (i != 0)
    {
      return c(j, paramKeyEvent);
      i = 0;
    }
    return b(j, paramKeyEvent);
  }
  
  b b(b.a parama)
  {
    w();
    if (this.m != null) {
      this.m.c();
    }
    b localb1 = new b(parama);
    if ((this.e != null) && (!p())) {}
    for (;;)
    {
      try
      {
        b localb = this.e.onWindowStartingSupportActionMode(localb1);
        if (localb != null)
        {
          this.m = localb;
          if ((this.m != null) && (this.e != null)) {
            this.e.onSupportActionModeStarted(this.m);
          }
          return this.m;
        }
      }
      catch (AbstractMethodError localAbstractMethodError)
      {
        localObject1 = null;
        continue;
        Object localObject2;
        if (this.n == null)
        {
          if (!this.k) {
            continue;
          }
          localObject2 = new TypedValue();
          localObject1 = this.a.getTheme();
          ((Resources.Theme)localObject1).resolveAttribute(a.a.actionBarTheme, (TypedValue)localObject2, true);
          if (((TypedValue)localObject2).resourceId != 0)
          {
            Resources.Theme localTheme = this.a.getResources().newTheme();
            localTheme.setTo((Resources.Theme)localObject1);
            localTheme.applyStyle(((TypedValue)localObject2).resourceId, true);
            localObject1 = new d(this.a, 0);
            ((Context)localObject1).getTheme().setTo(localTheme);
            this.n = new ActionBarContextView((Context)localObject1);
            this.o = new PopupWindow((Context)localObject1, null, a.a.actionModePopupWindowStyle);
            android.support.v4.widget.o.a(this.o, 2);
            this.o.setContentView(this.n);
            this.o.setWidth(-1);
            ((Context)localObject1).getTheme().resolveAttribute(a.a.actionBarSize, (TypedValue)localObject2, true);
            int i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, ((Context)localObject1).getResources().getDisplayMetrics());
            this.n.setContentHeight(i);
            this.o.setHeight(-2);
            this.p = new Runnable()
            {
              public void run()
              {
                l.this.o.showAtLocation(l.this.n, 55, 0, 0);
                l.c(l.this);
                af.c(l.this.n, 0.0F);
                l.this.q = af.q(l.this.n).a(1.0F);
                l.this.q.a(new ba()
                {
                  public void a(View paramAnonymous2View)
                  {
                    l.this.n.setVisibility(0);
                  }
                  
                  public void b(View paramAnonymous2View)
                  {
                    af.c(l.this.n, 1.0F);
                    l.this.q.a(null);
                    l.this.q = null;
                  }
                });
              }
            };
          }
        }
        else
        {
          if (this.n == null) {
            continue;
          }
          w();
          this.n.c();
          localObject1 = this.n.getContext();
          localObject2 = this.n;
          if (this.o != null) {
            continue;
          }
          bool = true;
          localObject1 = new android.support.v7.view.e((Context)localObject1, (ActionBarContextView)localObject2, localb1, bool);
          if (!parama.a((b)localObject1, ((b)localObject1).b())) {
            continue;
          }
          ((b)localObject1).d();
          this.n.a((b)localObject1);
          this.m = ((b)localObject1);
          af.c(this.n, 0.0F);
          this.q = af.q(this.n).a(1.0F);
          this.q.a(new ba()
          {
            public void a(View paramAnonymousView)
            {
              l.this.n.setVisibility(0);
              l.this.n.sendAccessibilityEvent(32);
              if (l.this.n.getParent() != null) {
                af.s((View)l.this.n.getParent());
              }
            }
            
            public void b(View paramAnonymousView)
            {
              af.c(l.this.n, 1.0F);
              l.this.q.a(null);
              l.this.q = null;
            }
          });
          if (this.o == null) {
            continue;
          }
          this.b.getDecorView().post(this.p);
          continue;
        }
        localObject1 = this.a;
        continue;
        localObject1 = (ViewStubCompat)this.v.findViewById(a.f.action_mode_bar_stub);
        if (localObject1 == null) {
          continue;
        }
        ((ViewStubCompat)localObject1).setLayoutInflater(LayoutInflater.from(n()));
        this.n = ((ActionBarContextView)((ViewStubCompat)localObject1).a());
        continue;
        boolean bool = false;
        continue;
        this.m = null;
        continue;
      }
      Object localObject1 = null;
    }
  }
  
  View b(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if ((this.c instanceof LayoutInflater.Factory))
    {
      paramView = ((LayoutInflater.Factory)this.c).onCreateView(paramString, paramContext, paramAttributeSet);
      if (paramView != null) {
        return paramView;
      }
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    t();
    ViewGroup localViewGroup = (ViewGroup)this.v.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.a).inflate(paramInt, localViewGroup);
    this.c.onContentChanged();
  }
  
  public void b(Bundle paramBundle)
  {
    t();
  }
  
  public void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    t();
    ((ViewGroup)this.v.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.c.onContentChanged();
  }
  
  void b(CharSequence paramCharSequence)
  {
    if (this.r != null) {
      this.r.setWindowTitle(paramCharSequence);
    }
    do
    {
      return;
      if (m() != null)
      {
        m().b(paramCharSequence);
        return;
      }
    } while (this.w == null);
    this.w.setText(paramCharSequence);
  }
  
  boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = true;
    switch (paramInt)
    {
    }
    do
    {
      bool1 = false;
      boolean bool2;
      do
      {
        return bool1;
        e(0, paramKeyEvent);
        return true;
        bool2 = this.D;
        this.D = false;
        paramKeyEvent = a(0, false);
        if ((paramKeyEvent == null) || (!paramKeyEvent.o)) {
          break;
        }
      } while (bool2);
      a(paramKeyEvent, true);
      return true;
    } while (!s());
    return true;
  }
  
  boolean b(int paramInt, Menu paramMenu)
  {
    if (paramInt == 108)
    {
      paramMenu = a();
      if (paramMenu != null) {
        paramMenu.f(true);
      }
      return true;
    }
    return false;
  }
  
  public View c(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    boolean bool1;
    if (Build.VERSION.SDK_INT < 21)
    {
      bool1 = true;
      if (this.K == null) {
        this.K = new n();
      }
      if ((!bool1) || (!a((ViewParent)paramView))) {
        break label75;
      }
    }
    label75:
    for (boolean bool2 = true;; bool2 = false)
    {
      return this.K.a(paramView, paramString, paramContext, paramAttributeSet, bool2, bool1, true, bd.a());
      bool1 = false;
      break;
    }
  }
  
  public void c()
  {
    a locala = a();
    if (locala != null) {
      locala.e(false);
    }
  }
  
  public boolean c(int paramInt)
  {
    paramInt = h(paramInt);
    if ((this.l) && (paramInt == 108)) {
      return false;
    }
    if ((this.h) && (paramInt == 1)) {
      this.h = false;
    }
    switch (paramInt)
    {
    default: 
      return this.b.requestFeature(paramInt);
    case 108: 
      x();
      this.h = true;
      return true;
    case 109: 
      x();
      this.i = true;
      return true;
    case 10: 
      x();
      this.j = true;
      return true;
    case 2: 
      x();
      this.y = true;
      return true;
    case 5: 
      x();
      this.z = true;
      return true;
    }
    x();
    this.l = true;
    return true;
  }
  
  boolean c(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      if (Build.VERSION.SDK_INT < 11) {
        a(paramInt, paramKeyEvent);
      }
      return false;
    case 82: 
      d(0, paramKeyEvent);
      return true;
    }
    if ((paramKeyEvent.getFlags() & 0x80) != 0) {}
    for (;;)
    {
      this.D = bool;
      break;
      bool = false;
    }
  }
  
  public void d()
  {
    a locala = a();
    if (locala != null) {
      locala.e(true);
    }
  }
  
  public void e()
  {
    a locala = a();
    if ((locala != null) && (locala.f())) {
      return;
    }
    e(0);
  }
  
  public void f()
  {
    super.f();
    if (this.f != null) {
      this.f.i();
    }
  }
  
  public void h()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.a);
    if (localLayoutInflater.getFactory() == null) {
      i.a(localLayoutInflater, this);
    }
    while ((i.a(localLayoutInflater) instanceof l)) {
      return;
    }
    Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
  }
  
  public void l()
  {
    t();
    if ((!this.h) || (this.f != null)) {}
    for (;;)
    {
      return;
      if ((this.c instanceof Activity)) {
        this.f = new r((Activity)this.c, this.i);
      }
      while (this.f != null)
      {
        this.f.d(this.H);
        return;
        if ((this.c instanceof Dialog)) {
          this.f = new r((Dialog)this.c);
        }
      }
    }
  }
  
  boolean s()
  {
    if (this.m != null) {
      this.m.c();
    }
    a locala;
    do
    {
      return true;
      locala = a();
    } while ((locala != null) && (locala.g()));
    return false;
  }
  
  private final class a
    implements android.support.v7.view.menu.l.a
  {
    private a() {}
    
    public void a(android.support.v7.view.menu.f paramf, boolean paramBoolean)
    {
      l.a(l.this, paramf);
    }
    
    public boolean a(android.support.v7.view.menu.f paramf)
    {
      Window.Callback localCallback = l.this.q();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramf);
      }
      return true;
    }
  }
  
  class b
    implements b.a
  {
    private b.a b;
    
    public b(b.a parama)
    {
      this.b = parama;
    }
    
    public void a(b paramb)
    {
      this.b.a(paramb);
      if (l.this.o != null) {
        l.this.b.getDecorView().removeCallbacks(l.this.p);
      }
      if (l.this.n != null)
      {
        l.c(l.this);
        l.this.q = af.q(l.this.n).a(0.0F);
        l.this.q.a(new ba()
        {
          public void b(View paramAnonymousView)
          {
            l.this.n.setVisibility(8);
            if (l.this.o != null) {
              l.this.o.dismiss();
            }
            for (;;)
            {
              l.this.n.removeAllViews();
              l.this.q.a(null);
              l.this.q = null;
              return;
              if ((l.this.n.getParent() instanceof View)) {
                af.s((View)l.this.n.getParent());
              }
            }
          }
        });
      }
      if (l.this.e != null) {
        l.this.e.onSupportActionModeFinished(l.this.m);
      }
      l.this.m = null;
    }
    
    public boolean a(b paramb, Menu paramMenu)
    {
      return this.b.a(paramb, paramMenu);
    }
    
    public boolean a(b paramb, MenuItem paramMenuItem)
    {
      return this.b.a(paramb, paramMenuItem);
    }
    
    public boolean b(b paramb, Menu paramMenu)
    {
      return this.b.b(paramb, paramMenu);
    }
  }
  
  private class c
    extends ContentFrameLayout
  {
    public c(Context paramContext)
    {
      super();
    }
    
    private boolean a(int paramInt1, int paramInt2)
    {
      return (paramInt1 < -5) || (paramInt2 < -5) || (paramInt1 > getWidth() + 5) || (paramInt2 > getHeight() + 5);
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (l.this.a(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if ((paramMotionEvent.getAction() == 0) && (a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
      {
        l.d(l.this, 0);
        return true;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public void setBackgroundResource(int paramInt)
    {
      setBackgroundDrawable(android.support.v7.widget.m.a().a(getContext(), paramInt));
    }
  }
  
  private static final class d
  {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    ViewGroup g;
    View h;
    View i;
    android.support.v7.view.menu.f j;
    android.support.v7.view.menu.e k;
    Context l;
    boolean m;
    boolean n;
    boolean o;
    public boolean p;
    boolean q;
    boolean r;
    Bundle s;
    
    d(int paramInt)
    {
      this.a = paramInt;
      this.q = false;
    }
    
    android.support.v7.view.menu.m a(android.support.v7.view.menu.l.a parama)
    {
      if (this.j == null) {
        return null;
      }
      if (this.k == null)
      {
        this.k = new android.support.v7.view.menu.e(this.l, a.h.abc_list_menu_item_layout);
        this.k.a(parama);
        this.j.a(this.k);
      }
      return this.k.a(this.g);
    }
    
    void a(Context paramContext)
    {
      TypedValue localTypedValue = new TypedValue();
      Resources.Theme localTheme = paramContext.getResources().newTheme();
      localTheme.setTo(paramContext.getTheme());
      localTheme.resolveAttribute(a.a.actionBarPopupTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      localTheme.resolveAttribute(a.a.panelMenuListTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      for (;;)
      {
        paramContext = new d(paramContext, 0);
        paramContext.getTheme().setTo(localTheme);
        this.l = paramContext;
        paramContext = paramContext.obtainStyledAttributes(a.k.AppCompatTheme);
        this.b = paramContext.getResourceId(a.k.AppCompatTheme_panelBackground, 0);
        this.f = paramContext.getResourceId(a.k.AppCompatTheme_android_windowAnimationStyle, 0);
        paramContext.recycle();
        return;
        localTheme.applyStyle(a.j.Theme_AppCompat_CompactMenu, true);
      }
    }
    
    void a(android.support.v7.view.menu.f paramf)
    {
      if (paramf == this.j) {}
      do
      {
        return;
        if (this.j != null) {
          this.j.b(this.k);
        }
        this.j = paramf;
      } while ((paramf == null) || (this.k == null));
      paramf.a(this.k);
    }
    
    public boolean a()
    {
      boolean bool2 = true;
      boolean bool1;
      if (this.h == null) {
        bool1 = false;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.i != null);
        bool1 = bool2;
      } while (this.k.a().getCount() > 0);
      return false;
    }
  }
  
  private final class e
    implements android.support.v7.view.menu.l.a
  {
    private e() {}
    
    public void a(android.support.v7.view.menu.f paramf, boolean paramBoolean)
    {
      android.support.v7.view.menu.f localf = paramf.p();
      if (localf != paramf) {}
      for (int i = 1;; i = 0)
      {
        l locall = l.this;
        if (i != 0) {
          paramf = localf;
        }
        paramf = l.a(locall, paramf);
        if (paramf != null)
        {
          if (i == 0) {
            break;
          }
          l.a(l.this, paramf.a, paramf, localf);
          l.a(l.this, paramf, true);
        }
        return;
      }
      l.a(l.this, paramf, paramBoolean);
    }
    
    public boolean a(android.support.v7.view.menu.f paramf)
    {
      if ((paramf == null) && (l.this.h))
      {
        Window.Callback localCallback = l.this.q();
        if ((localCallback != null) && (!l.this.p())) {
          localCallback.onMenuOpened(108, paramf);
        }
      }
      return true;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */