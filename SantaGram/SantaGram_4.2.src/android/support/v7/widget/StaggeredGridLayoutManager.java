package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.j.a.a;
import android.support.v4.j.a.c;
import android.support.v4.j.a.c.k;
import android.support.v4.j.a.k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager
  extends ao.h
{
  private final Runnable A = new Runnable()
  {
    public void run()
    {
      StaggeredGridLayoutManager.a(StaggeredGridLayoutManager.this);
    }
  };
  an a;
  an b;
  boolean c = false;
  int d = -1;
  int e = Integer.MIN_VALUE;
  c f = new c();
  private int g = -1;
  private e[] h;
  private int i;
  private int j;
  private final ai k;
  private boolean l = false;
  private BitSet m;
  private int n = 2;
  private boolean o;
  private boolean t;
  private d u;
  private int v;
  private final Rect w = new Rect();
  private final a x = new a(null);
  private boolean y = false;
  private boolean z = true;
  
  public StaggeredGridLayoutManager(int paramInt1, int paramInt2)
  {
    this.i = paramInt2;
    a(paramInt1);
    if (this.n != 0) {}
    for (;;)
    {
      c(bool);
      this.k = new ai();
      m();
      return;
      bool = false;
    }
  }
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    b(paramContext.a);
    a(paramContext.b);
    a(paramContext.c);
    if (this.n != 0) {}
    for (;;)
    {
      c(bool);
      this.k = new ai();
      m();
      return;
      bool = false;
    }
  }
  
  private boolean I()
  {
    if ((t() == 0) || (this.n == 0) || (!o())) {
      return false;
    }
    int i2;
    if (this.c) {
      i2 = L();
    }
    for (int i1 = M(); (i2 == 0) && (f() != null); i1 = L())
    {
      this.f.a();
      G();
      n();
      return true;
      i2 = M();
    }
    if (!this.y) {
      return false;
    }
    if (this.c) {}
    StaggeredGridLayoutManager.c.a locala1;
    for (int i3 = -1;; i3 = 1)
    {
      locala1 = this.f.a(i2, i1 + 1, i3, true);
      if (locala1 != null) {
        break;
      }
      this.y = false;
      this.f.a(i1 + 1);
      return false;
    }
    StaggeredGridLayoutManager.c.a locala2 = this.f.a(i2, locala1.a, i3 * -1, true);
    if (locala2 == null) {
      this.f.a(locala1.a);
    }
    for (;;)
    {
      G();
      n();
      return true;
      this.f.a(locala2.a + 1);
    }
  }
  
  private void J()
  {
    boolean bool = true;
    if ((this.i == 1) || (!h()))
    {
      this.c = this.l;
      return;
    }
    if (!this.l) {}
    for (;;)
    {
      this.c = bool;
      return;
      bool = false;
    }
  }
  
  private void K()
  {
    if (this.b.h() == 1073741824) {
      return;
    }
    float f1 = 0.0F;
    int i3 = t();
    int i1 = 0;
    View localView;
    float f2;
    while (i1 < i3)
    {
      localView = h(i1);
      f2 = this.b.c(localView);
      if (f2 < f1)
      {
        label54:
        i1 += 1;
      }
      else
      {
        if (!((b)localView.getLayoutParams()).a()) {
          break label324;
        }
        f2 = 1.0F * f2 / this.g;
      }
    }
    label161:
    label201:
    label324:
    for (;;)
    {
      f1 = Math.max(f1, f2);
      break label54;
      int i4 = this.j;
      int i2 = Math.round(this.g * f1);
      i1 = i2;
      if (this.b.h() == Integer.MIN_VALUE) {
        i1 = Math.min(i2, this.b.f());
      }
      e(i1);
      if (this.j == i4) {
        break;
      }
      i1 = 0;
      b localb;
      if (i1 < i3)
      {
        localView = h(i1);
        localb = (b)localView.getLayoutParams();
        if (!localb.f) {
          break label201;
        }
      }
      for (;;)
      {
        i1 += 1;
        break label161;
        break;
        if ((h()) && (this.i == 1))
        {
          localView.offsetLeftAndRight(-(this.g - 1 - localb.e.d) * this.j - -(this.g - 1 - localb.e.d) * i4);
        }
        else
        {
          i2 = localb.e.d * this.j;
          int i5 = localb.e.d * i4;
          if (this.i == 1) {
            localView.offsetLeftAndRight(i2 - i5);
          } else {
            localView.offsetTopAndBottom(i2 - i5);
          }
        }
      }
    }
  }
  
  private int L()
  {
    int i1 = t();
    if (i1 == 0) {
      return 0;
    }
    return d(h(i1 - 1));
  }
  
  private int M()
  {
    if (t() == 0) {
      return 0;
    }
    return d(h(0));
  }
  
  private int a(ao.n paramn, ai paramai, ao.s params)
  {
    this.m.set(0, this.g, true);
    int i1;
    int i4;
    label61:
    int i2;
    label64:
    View localView;
    b localb;
    int i7;
    int i6;
    label136:
    e locale;
    label157:
    label168:
    label189:
    label222:
    int i5;
    StaggeredGridLayoutManager.c.a locala;
    int i3;
    if (this.k.i) {
      if (paramai.e == 1)
      {
        i1 = Integer.MAX_VALUE;
        e(paramai.e, i1);
        if (!this.c) {
          break label506;
        }
        i4 = this.a.d();
        i2 = 0;
        if ((!paramai.a(params)) || ((!this.k.i) && (this.m.isEmpty()))) {
          break label876;
        }
        localView = paramai.a(paramn);
        localb = (b)localView.getLayoutParams();
        i7 = localb.e();
        i2 = this.f.c(i7);
        if (i2 != -1) {
          break label518;
        }
        i6 = 1;
        if (i6 == 0) {
          break label534;
        }
        if (!localb.f) {
          break label524;
        }
        locale = this.h[0];
        this.f.a(i7, locale);
        localb.e = locale;
        if (paramai.e != 1) {
          break label546;
        }
        b(localView);
        a(localView, localb, false);
        if (paramai.e != 1) {
          break label568;
        }
        if (!localb.f) {
          break label556;
        }
        i2 = q(i4);
        i5 = i2 + this.a.c(localView);
        if ((i6 == 0) || (!localb.f)) {
          break label967;
        }
        locala = m(i2);
        locala.b = -1;
        locala.a = i7;
        this.f.a(locala);
        i3 = i2;
      }
    }
    for (;;)
    {
      if ((localb.f) && (paramai.d == -1))
      {
        if (i6 != 0) {
          this.y = true;
        }
      }
      else
      {
        label309:
        a(localView, localb, paramai);
        if ((!h()) || (this.i != 1)) {
          break label768;
        }
        if (!localb.f) {
          break label738;
        }
        i2 = this.b.d();
        label350:
        i7 = i2 - this.b.c(localView);
        i6 = i2;
        i2 = i7;
        if (this.i != 1) {
          break label825;
        }
        b(localView, i2, i3, i6, i5);
        label394:
        if (!localb.f) {
          break label842;
        }
        e(this.k.e, i1);
        label415:
        a(paramn, this.k);
        if ((this.k.h) && (localView.isFocusable()))
        {
          if (!localb.f) {
            break label860;
          }
          this.m.clear();
        }
      }
      for (;;)
      {
        i2 = 1;
        break label64;
        i1 = Integer.MIN_VALUE;
        break;
        if (paramai.e == 1)
        {
          i1 = paramai.g + paramai.b;
          break;
        }
        i1 = paramai.f - paramai.b;
        break;
        label506:
        i4 = this.a.c();
        break label61;
        label518:
        i6 = 0;
        break label136;
        label524:
        locale = a(paramai);
        break label157;
        label534:
        locale = this.h[i2];
        break label168;
        label546:
        b(localView, 0);
        break label189;
        label556:
        i2 = locale.b(i4);
        break label222;
        label568:
        if (localb.f) {}
        for (i2 = p(i4);; i2 = locale.a(i4))
        {
          i3 = i2 - this.a.c(localView);
          if ((i6 != 0) && (localb.f))
          {
            locala = n(i2);
            locala.b = 1;
            locala.a = i7;
            this.f.a(locala);
          }
          i5 = i2;
          break;
        }
        if (paramai.e == 1) {
          if (!j()) {
            i2 = 1;
          }
        }
        for (;;)
        {
          if (i2 == 0) {
            break label736;
          }
          locala = this.f.f(i7);
          if (locala != null) {
            locala.d = true;
          }
          this.y = true;
          break;
          i2 = 0;
          continue;
          if (!l()) {
            i2 = 1;
          } else {
            i2 = 0;
          }
        }
        label736:
        break label309;
        label738:
        i2 = this.b.d() - (this.g - 1 - locale.d) * this.j;
        break label350;
        label768:
        if (localb.f) {}
        for (i2 = this.b.c();; i2 = locale.d * this.j + this.b.c())
        {
          i6 = i2 + this.b.c(localView);
          break;
        }
        label825:
        b(localView, i3, i2, i5, i6);
        break label394;
        label842:
        a(locale, this.k.e, i1);
        break label415;
        label860:
        this.m.set(locale.d, false);
      }
      label876:
      if (i2 == 0) {
        a(paramn, this.k);
      }
      if (this.k.e == -1) {
        i1 = p(this.a.c());
      }
      for (i1 = this.a.c() - i1; i1 > 0; i1 = q(this.a.d()) - this.a.d()) {
        return Math.min(paramai.b, i1);
      }
      return 0;
      label967:
      i3 = i2;
    }
  }
  
  private int a(ao.s params)
  {
    boolean bool2 = false;
    if (t() == 0) {
      return 0;
    }
    an localan = this.a;
    if (!this.z) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = a(bool1, true);
      bool1 = bool2;
      if (!this.z) {
        bool1 = true;
      }
      return as.a(params, localan, localView, b(bool1, true), this, this.z, this.c);
    }
  }
  
  private e a(ai paramai)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i2 = -1;
    int i1;
    int i3;
    int i6;
    int i5;
    int i4;
    if (s(paramai.e))
    {
      i1 = this.g - 1;
      i3 = -1;
      if (paramai.e != 1) {
        break label123;
      }
      i6 = this.a.c();
      i5 = Integer.MAX_VALUE;
      i4 = i1;
      paramai = (ai)localObject1;
      i1 = i5;
      label60:
      localObject1 = paramai;
      if (i4 == i3) {
        break label194;
      }
      localObject1 = this.h[i4];
      i5 = ((e)localObject1).b(i6);
      if (i5 >= i1) {
        break label199;
      }
      paramai = (ai)localObject1;
      i1 = i5;
    }
    label123:
    label194:
    label196:
    label199:
    for (;;)
    {
      i4 += i2;
      break label60;
      i3 = this.g;
      i1 = 0;
      i2 = 1;
      break;
      i6 = this.a.d();
      i5 = Integer.MIN_VALUE;
      i4 = i1;
      paramai = (ai)localObject2;
      i1 = i5;
      localObject1 = paramai;
      if (i4 != i3)
      {
        localObject1 = this.h[i4];
        i5 = ((e)localObject1).a(i6);
        if (i5 <= i1) {
          break label196;
        }
        paramai = (ai)localObject1;
        i1 = i5;
      }
      for (;;)
      {
        i4 += i2;
        break;
        return (e)localObject1;
      }
    }
  }
  
  private void a(int paramInt, ao.s params)
  {
    boolean bool2 = false;
    this.k.b = 0;
    this.k.c = paramInt;
    int i1;
    boolean bool1;
    if (q())
    {
      i1 = params.c();
      if (i1 != -1)
      {
        boolean bool3 = this.c;
        if (i1 < paramInt)
        {
          bool1 = true;
          if (bool3 != bool1) {
            break label171;
          }
          paramInt = this.a.f();
          i1 = 0;
        }
      }
    }
    for (;;)
    {
      label67:
      if (p())
      {
        this.k.f = (this.a.c() - i1);
        this.k.g = (paramInt + this.a.d());
      }
      for (;;)
      {
        this.k.h = false;
        this.k.a = true;
        params = this.k;
        bool1 = bool2;
        if (this.a.h() == 0)
        {
          bool1 = bool2;
          if (this.a.e() == 0) {
            bool1 = true;
          }
        }
        params.i = bool1;
        return;
        bool1 = false;
        break;
        label171:
        i1 = this.a.f();
        paramInt = 0;
        break label67;
        this.k.g = (paramInt + this.a.e());
        this.k.f = (-i1);
      }
      paramInt = 0;
      i1 = 0;
    }
  }
  
  private void a(a parama)
  {
    if (this.u.c > 0) {
      if (this.u.c == this.g)
      {
        int i2 = 0;
        if (i2 < this.g)
        {
          this.h[i2].e();
          int i3 = this.u.d[i2];
          int i1 = i3;
          if (i3 != Integer.MIN_VALUE) {
            if (!this.u.i) {
              break label102;
            }
          }
          label102:
          for (i1 = i3 + this.a.d();; i1 = i3 + this.a.c())
          {
            this.h[i2].c(i1);
            i2 += 1;
            break;
          }
        }
      }
      else
      {
        this.u.a();
        this.u.a = this.u.b;
      }
    }
    this.t = this.u.j;
    a(this.u.h);
    J();
    if (this.u.a != -1) {
      this.d = this.u.a;
    }
    for (parama.c = this.u.i;; parama.c = this.c)
    {
      if (this.u.e > 1)
      {
        this.f.a = this.u.f;
        this.f.b = this.u.g;
      }
      return;
    }
  }
  
  private void a(e parame, int paramInt1, int paramInt2)
  {
    int i1 = parame.i();
    if (paramInt1 == -1) {
      if (i1 + parame.b() <= paramInt2) {
        this.m.set(parame.d, false);
      }
    }
    while (parame.d() - i1 < paramInt2) {
      return;
    }
    this.m.set(parame.d, false);
  }
  
  private void a(ao.n paramn, int paramInt)
  {
    for (;;)
    {
      View localView;
      b localb;
      if (t() > 0)
      {
        localView = h(0);
        if (this.a.b(localView) <= paramInt)
        {
          localb = (b)localView.getLayoutParams();
          if (!localb.f) {
            break label112;
          }
          i1 = 0;
          if (i1 >= this.g) {
            break label81;
          }
          if (e.a(this.h[i1]).size() != 1) {
            break label72;
          }
        }
      }
      label72:
      label81:
      label112:
      while (e.a(localb.e).size() == 1)
      {
        for (;;)
        {
          return;
          i1 += 1;
        }
        int i1 = 0;
        while (i1 < this.g)
        {
          this.h[i1].h();
          i1 += 1;
        }
      }
      localb.e.h();
      a(localView, paramn);
    }
  }
  
  private void a(ao.n paramn, ai paramai)
  {
    if ((!paramai.a) || (paramai.i)) {
      return;
    }
    if (paramai.b == 0)
    {
      if (paramai.e == -1)
      {
        b(paramn, paramai.g);
        return;
      }
      a(paramn, paramai.f);
      return;
    }
    if (paramai.e == -1)
    {
      i1 = paramai.f - o(paramai.f);
      if (i1 < 0) {}
      for (i1 = paramai.g;; i1 = paramai.g - Math.min(i1, paramai.b))
      {
        b(paramn, i1);
        return;
      }
    }
    int i1 = r(paramai.g) - paramai.g;
    if (i1 < 0) {}
    int i2;
    for (i1 = paramai.f;; i1 = Math.min(i1, paramai.b) + i2)
    {
      a(paramn, i1);
      return;
      i2 = paramai.f;
    }
  }
  
  private void a(ao.n paramn, ao.s params, boolean paramBoolean)
  {
    a locala = this.x;
    locala.a();
    if (((this.u != null) || (this.d != -1)) && (params.e() == 0))
    {
      c(paramn);
      return;
    }
    if (this.u != null) {
      a(locala);
    }
    for (;;)
    {
      a(params, locala);
      if ((this.u == null) && ((locala.c != this.o) || (h() != this.t)))
      {
        this.f.a();
        locala.d = true;
      }
      if ((t() <= 0) || ((this.u != null) && (this.u.c >= 1))) {
        break label247;
      }
      if (!locala.d) {
        break;
      }
      i1 = 0;
      while (i1 < this.g)
      {
        this.h[i1].e();
        if (locala.b != Integer.MIN_VALUE) {
          this.h[i1].c(locala.b);
        }
        i1 += 1;
      }
      J();
      locala.c = this.c;
    }
    int i1 = 0;
    while (i1 < this.g)
    {
      this.h[i1].a(this.c, locala.b);
      i1 += 1;
    }
    label247:
    a(paramn);
    this.k.a = false;
    this.y = false;
    e(this.b.f());
    a(locala.a, params);
    if (locala.c)
    {
      l(-1);
      a(paramn, this.k, params);
      l(1);
      this.k.c = (locala.a + this.k.d);
      a(paramn, this.k, params);
      label346:
      K();
      if (t() > 0)
      {
        if (!this.c) {
          break label545;
        }
        b(paramn, params, true);
        c(paramn, params, false);
      }
      label378:
      if ((!paramBoolean) || (params.a())) {
        break label574;
      }
      if ((this.n == 0) || (t() <= 0) || ((!this.y) && (f() == null))) {
        break label562;
      }
      i1 = 1;
      label420:
      if (i1 == 0) {
        break label568;
      }
      a(this.A);
      if (!I()) {
        break label568;
      }
      i1 = 1;
      label444:
      this.d = -1;
      this.e = Integer.MIN_VALUE;
    }
    for (;;)
    {
      this.o = locala.c;
      this.t = h();
      this.u = null;
      if (i1 == 0) {
        break;
      }
      a(paramn, params, false);
      return;
      l(1);
      a(paramn, this.k, params);
      l(-1);
      this.k.c = (locala.a + this.k.d);
      a(paramn, this.k, params);
      break label346;
      label545:
      c(paramn, params, true);
      b(paramn, params, false);
      break label378;
      label562:
      i1 = 0;
      break label420;
      label568:
      i1 = 0;
      break label444;
      label574:
      i1 = 0;
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramView, this.w);
    b localb = (b)paramView.getLayoutParams();
    paramInt1 = b(paramInt1, localb.leftMargin + this.w.left, localb.rightMargin + this.w.right);
    paramInt2 = b(paramInt2, localb.topMargin + this.w.top, localb.bottomMargin + this.w.bottom);
    if (paramBoolean) {}
    for (paramBoolean = a(paramView, paramInt1, paramInt2, localb);; paramBoolean = b(paramView, paramInt1, paramInt2, localb))
    {
      if (paramBoolean) {
        paramView.measure(paramInt1, paramInt2);
      }
      return;
    }
  }
  
  private void a(View paramView, b paramb, ai paramai)
  {
    if (paramai.e == 1)
    {
      if (paramb.f)
      {
        p(paramView);
        return;
      }
      paramb.e.b(paramView);
      return;
    }
    if (paramb.f)
    {
      q(paramView);
      return;
    }
    paramb.e.a(paramView);
  }
  
  private void a(View paramView, b paramb, boolean paramBoolean)
  {
    if (paramb.f)
    {
      if (this.i == 1)
      {
        a(paramView, this.v, a(x(), v(), 0, paramb.height, true), paramBoolean);
        return;
      }
      a(paramView, a(w(), u(), 0, paramb.width, true), this.v, paramBoolean);
      return;
    }
    if (this.i == 1)
    {
      a(paramView, a(this.j, u(), 0, paramb.width, false), a(x(), v(), 0, paramb.height, true), paramBoolean);
      return;
    }
    a(paramView, a(w(), u(), 0, paramb.width, true), a(this.j, v(), 0, paramb.height, false), paramBoolean);
  }
  
  private boolean a(e parame)
  {
    boolean bool = true;
    if (this.c)
    {
      if (parame.d() < this.a.d()) {
        return !parame.c((View)e.a(parame).get(e.a(parame).size() - 1)).f;
      }
    }
    else if (parame.b() > this.a.c())
    {
      if (!parame.c((View)e.a(parame).get(0)).f) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return false;
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    int i1;
    do
    {
      return paramInt1;
      i1 = View.MeasureSpec.getMode(paramInt1);
    } while ((i1 != Integer.MIN_VALUE) && (i1 != 1073741824));
    return View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i1);
  }
  
  private void b(ao.n paramn, int paramInt)
  {
    int i1 = t() - 1;
    for (;;)
    {
      View localView;
      b localb;
      if (i1 >= 0)
      {
        localView = h(i1);
        if (this.a.a(localView) >= paramInt)
        {
          localb = (b)localView.getLayoutParams();
          if (!localb.f) {
            break label119;
          }
          i2 = 0;
          if (i2 >= this.g) {
            break label88;
          }
          if (e.a(this.h[i2]).size() != 1) {
            break label79;
          }
        }
      }
      label79:
      label88:
      label119:
      while (e.a(localb.e).size() == 1)
      {
        for (;;)
        {
          return;
          i2 += 1;
        }
        int i2 = 0;
        while (i2 < this.g)
        {
          this.h[i2].g();
          i2 += 1;
        }
      }
      localb.e.g();
      a(localView, paramn);
      i1 -= 1;
    }
  }
  
  private void b(ao.n paramn, ao.s params, boolean paramBoolean)
  {
    int i1 = q(Integer.MIN_VALUE);
    if (i1 == Integer.MIN_VALUE) {}
    do
    {
      do
      {
        return;
        i1 = this.a.d() - i1;
      } while (i1 <= 0);
      i1 -= -c(-i1, paramn, params);
    } while ((!paramBoolean) || (i1 <= 0));
    this.a.a(i1);
  }
  
  private void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    b localb = (b)paramView.getLayoutParams();
    a(paramView, paramInt1 + localb.leftMargin, paramInt2 + localb.topMargin, paramInt3 - localb.rightMargin, paramInt4 - localb.bottomMargin);
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3)
  {
    int i3;
    int i2;
    int i1;
    if (this.c)
    {
      i3 = L();
      if (paramInt3 != 8) {
        break label104;
      }
      if (paramInt1 >= paramInt2) {
        break label93;
      }
      i2 = paramInt2 + 1;
      i1 = paramInt1;
      label32:
      this.f.b(i1);
      switch (paramInt3)
      {
      default: 
        label76:
        if (i2 > i3) {
          break;
        }
      }
    }
    for (;;)
    {
      return;
      i3 = M();
      break;
      label93:
      i2 = paramInt1 + 1;
      i1 = paramInt2;
      break label32;
      label104:
      i2 = paramInt1 + paramInt2;
      i1 = paramInt1;
      break label32;
      this.f.b(paramInt1, paramInt2);
      break label76;
      this.f.a(paramInt1, paramInt2);
      break label76;
      this.f.a(paramInt1, 1);
      this.f.b(paramInt2, 1);
      break label76;
      if (this.c) {}
      for (paramInt1 = M(); i1 <= paramInt1; paramInt1 = L())
      {
        n();
        return;
      }
    }
  }
  
  private void c(ao.n paramn, ao.s params, boolean paramBoolean)
  {
    int i1 = p(Integer.MAX_VALUE);
    if (i1 == Integer.MAX_VALUE) {}
    do
    {
      do
      {
        return;
        i1 -= this.a.c();
      } while (i1 <= 0);
      i1 -= c(i1, paramn, params);
    } while ((!paramBoolean) || (i1 <= 0));
    this.a.a(-i1);
  }
  
  private boolean c(ao.s params, a parama)
  {
    if (this.o) {}
    for (int i1 = v(params.e());; i1 = u(params.e()))
    {
      parama.a = i1;
      parama.b = Integer.MIN_VALUE;
      return true;
    }
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (i1 < this.g)
    {
      if (e.a(this.h[i1]).isEmpty()) {}
      for (;;)
      {
        i1 += 1;
        break;
        a(this.h[i1], paramInt1, paramInt2);
      }
    }
  }
  
  private int h(ao.s params)
  {
    boolean bool2 = false;
    if (t() == 0) {
      return 0;
    }
    an localan = this.a;
    if (!this.z) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = a(bool1, true);
      bool1 = bool2;
      if (!this.z) {
        bool1 = true;
      }
      return as.a(params, localan, localView, b(bool1, true), this, this.z);
    }
  }
  
  private int i(ao.s params)
  {
    boolean bool2 = false;
    if (t() == 0) {
      return 0;
    }
    an localan = this.a;
    if (!this.z) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = a(bool1, true);
      bool1 = bool2;
      if (!this.z) {
        bool1 = true;
      }
      return as.b(params, localan, localView, b(bool1, true), this, this.z);
    }
  }
  
  private void l(int paramInt)
  {
    int i1 = 1;
    this.k.e = paramInt;
    ai localai = this.k;
    boolean bool2 = this.c;
    boolean bool1;
    if (paramInt == -1)
    {
      bool1 = true;
      if (bool2 != bool1) {
        break label50;
      }
    }
    label50:
    for (paramInt = i1;; paramInt = -1)
    {
      localai.d = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  private StaggeredGridLayoutManager.c.a m(int paramInt)
  {
    StaggeredGridLayoutManager.c.a locala = new StaggeredGridLayoutManager.c.a();
    locala.c = new int[this.g];
    int i1 = 0;
    while (i1 < this.g)
    {
      locala.c[i1] = (paramInt - this.h[i1].b(paramInt));
      i1 += 1;
    }
    return locala;
  }
  
  private void m()
  {
    this.a = an.a(this, this.i);
    this.b = an.a(this, 1 - this.i);
  }
  
  private StaggeredGridLayoutManager.c.a n(int paramInt)
  {
    StaggeredGridLayoutManager.c.a locala = new StaggeredGridLayoutManager.c.a();
    locala.c = new int[this.g];
    int i1 = 0;
    while (i1 < this.g)
    {
      locala.c[i1] = (this.h[i1].a(paramInt) - paramInt);
      i1 += 1;
    }
    return locala;
  }
  
  private int o(int paramInt)
  {
    int i2 = this.h[0].a(paramInt);
    int i1 = 1;
    while (i1 < this.g)
    {
      int i4 = this.h[i1].a(paramInt);
      int i3 = i2;
      if (i4 > i2) {
        i3 = i4;
      }
      i1 += 1;
      i2 = i3;
    }
    return i2;
  }
  
  private int p(int paramInt)
  {
    int i2 = this.h[0].a(paramInt);
    int i1 = 1;
    while (i1 < this.g)
    {
      int i4 = this.h[i1].a(paramInt);
      int i3 = i2;
      if (i4 < i2) {
        i3 = i4;
      }
      i1 += 1;
      i2 = i3;
    }
    return i2;
  }
  
  private void p(View paramView)
  {
    int i1 = this.g - 1;
    while (i1 >= 0)
    {
      this.h[i1].b(paramView);
      i1 -= 1;
    }
  }
  
  private int q(int paramInt)
  {
    int i2 = this.h[0].b(paramInt);
    int i1 = 1;
    while (i1 < this.g)
    {
      int i4 = this.h[i1].b(paramInt);
      int i3 = i2;
      if (i4 > i2) {
        i3 = i4;
      }
      i1 += 1;
      i2 = i3;
    }
    return i2;
  }
  
  private void q(View paramView)
  {
    int i1 = this.g - 1;
    while (i1 >= 0)
    {
      this.h[i1].a(paramView);
      i1 -= 1;
    }
  }
  
  private int r(int paramInt)
  {
    int i2 = this.h[0].b(paramInt);
    int i1 = 1;
    while (i1 < this.g)
    {
      int i4 = this.h[i1].b(paramInt);
      int i3 = i2;
      if (i4 < i2) {
        i3 = i4;
      }
      i1 += 1;
      i2 = i3;
    }
    return i2;
  }
  
  private boolean s(int paramInt)
  {
    int i1;
    if (this.i == 0) {
      if (paramInt == -1)
      {
        i1 = 1;
        if (i1 == this.c) {
          break label29;
        }
      }
    }
    label29:
    label63:
    label66:
    for (;;)
    {
      return true;
      i1 = 0;
      break;
      return false;
      if (paramInt == -1)
      {
        i1 = 1;
        if (i1 != this.c) {
          break label63;
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == h()) {
          break label66;
        }
        return false;
        i1 = 0;
        break;
      }
    }
  }
  
  private int t(int paramInt)
  {
    int i1 = -1;
    if (t() == 0)
    {
      if (this.c) {
        return 1;
      }
      return -1;
    }
    int i2;
    if (paramInt < M())
    {
      i2 = 1;
      if (i2 == this.c) {
        break label47;
      }
    }
    label47:
    for (paramInt = i1;; paramInt = 1)
    {
      return paramInt;
      i2 = 0;
      break;
    }
  }
  
  private int u(int paramInt)
  {
    int i2 = t();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = d(h(i1));
      if ((i3 >= 0) && (i3 < paramInt)) {
        return i3;
      }
      i1 += 1;
    }
    return 0;
  }
  
  private int v(int paramInt)
  {
    int i1 = t() - 1;
    while (i1 >= 0)
    {
      int i2 = d(h(i1));
      if ((i2 >= 0) && (i2 < paramInt)) {
        return i2;
      }
      i1 -= 1;
    }
    return 0;
  }
  
  private int w(int paramInt)
  {
    int i2 = -1;
    int i3 = 1;
    int i4 = Integer.MIN_VALUE;
    int i1 = i2;
    switch (paramInt)
    {
    default: 
      i1 = Integer.MIN_VALUE;
    case 1: 
    case 2: 
    case 33: 
    case 130: 
    case 17: 
      do
      {
        do
        {
          return i1;
          return 1;
          i1 = i2;
        } while (this.i == 1);
        return Integer.MIN_VALUE;
        paramInt = i4;
        if (this.i == 1) {
          paramInt = 1;
        }
        return paramInt;
        i1 = i2;
      } while (this.i == 0);
      return Integer.MIN_VALUE;
    }
    if (this.i == 0) {}
    for (paramInt = i3;; paramInt = Integer.MIN_VALUE) {
      return paramInt;
    }
  }
  
  public int a(int paramInt, ao.n paramn, ao.s params)
  {
    return c(paramInt, paramn, params);
  }
  
  public int a(ao.n paramn, ao.s params)
  {
    if (this.i == 0) {
      return this.g;
    }
    return super.a(paramn, params);
  }
  
  public ao.i a()
  {
    if (this.i == 0) {
      return new b(-2, -1);
    }
    return new b(-1, -2);
  }
  
  public ao.i a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new b(paramContext, paramAttributeSet);
  }
  
  public ao.i a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new b((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new b(paramLayoutParams);
  }
  
  public View a(View paramView, int paramInt, ao.n paramn, ao.s params)
  {
    int i1 = 0;
    if (t() == 0) {
      return null;
    }
    paramView = e(paramView);
    if (paramView == null) {
      return null;
    }
    J();
    int i2 = w(paramInt);
    if (i2 == Integer.MIN_VALUE) {
      return null;
    }
    Object localObject = (b)paramView.getLayoutParams();
    boolean bool = ((b)localObject).f;
    localObject = ((b)localObject).e;
    if (i2 == 1) {}
    for (paramInt = L();; paramInt = M())
    {
      a(paramInt, params);
      l(i2);
      this.k.c = (this.k.d + paramInt);
      this.k.b = ((int)(0.33333334F * this.a.f()));
      this.k.h = true;
      this.k.a = false;
      a(paramn, this.k, params);
      this.o = this.c;
      if (bool) {
        break;
      }
      paramn = ((e)localObject).a(paramInt, i2);
      if ((paramn == null) || (paramn == paramView)) {
        break;
      }
      return paramn;
    }
    if (s(i2))
    {
      i1 = this.g - 1;
      while (i1 >= 0)
      {
        paramn = this.h[i1].a(paramInt, i2);
        if ((paramn != null) && (paramn != paramView)) {
          return paramn;
        }
        i1 -= 1;
      }
    }
    do
    {
      i1 += 1;
      if (i1 >= this.g) {
        break;
      }
      paramn = this.h[i1].a(paramInt, i2);
    } while ((paramn == null) || (paramn == paramView));
    return paramn;
    return null;
  }
  
  View a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = this.a.c();
    int i3 = this.a.d();
    int i4 = t();
    int i1 = 0;
    Object localObject1 = null;
    if (i1 < i4)
    {
      View localView = h(i1);
      int i5 = this.a.a(localView);
      Object localObject2 = localObject1;
      if (this.a.b(localView) > i2)
      {
        if (i5 < i3) {
          break label94;
        }
        localObject2 = localObject1;
      }
      for (;;)
      {
        i1 += 1;
        localObject1 = localObject2;
        break;
        label94:
        if ((i5 >= i2) || (!paramBoolean1)) {
          return localView;
        }
        localObject2 = localObject1;
        if (paramBoolean2)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
      }
    }
    return (View)localObject1;
  }
  
  public void a(int paramInt)
  {
    a(null);
    if (paramInt != this.g)
    {
      g();
      this.g = paramInt;
      this.m = new BitSet(this.g);
      this.h = new e[this.g];
      paramInt = 0;
      while (paramInt < this.g)
      {
        this.h[paramInt] = new e(paramInt, null);
        paramInt += 1;
      }
      n();
    }
  }
  
  public void a(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i1 = y();
    int i2 = A() + i1;
    int i3 = z() + B();
    if (this.i == 1)
    {
      i1 = a(paramInt2, i3 + paramRect.height(), E());
      paramInt2 = a(paramInt1, i2 + this.j * this.g, D());
      paramInt1 = i1;
    }
    for (;;)
    {
      d(paramInt2, paramInt1);
      return;
      i1 = a(paramInt1, i2 + paramRect.width(), D());
      paramInt1 = a(paramInt2, i3 + this.j * this.g, E());
      paramInt2 = i1;
    }
  }
  
  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof d))
    {
      this.u = ((d)paramParcelable);
      n();
    }
  }
  
  public void a(ao.n paramn, ao.s params, View paramView, c paramc)
  {
    paramn = paramView.getLayoutParams();
    if (!(paramn instanceof b))
    {
      super.a(paramView, paramc);
      return;
    }
    paramn = (b)paramn;
    if (this.i == 0)
    {
      i2 = paramn.b();
      if (paramn.f) {}
      for (i1 = this.g;; i1 = 1)
      {
        paramc.b(c.k.a(i2, i1, -1, -1, paramn.f, false));
        return;
      }
    }
    int i2 = paramn.b();
    if (paramn.f) {}
    for (int i1 = this.g;; i1 = 1)
    {
      paramc.b(c.k.a(-1, -1, i2, i1, paramn.f, false));
      return;
    }
  }
  
  void a(ao.s params, a parama)
  {
    if (b(params, parama)) {}
    while (c(params, parama)) {
      return;
    }
    parama.b();
    parama.a = 0;
  }
  
  public void a(ao paramao)
  {
    this.f.a();
    n();
  }
  
  public void a(ao paramao, int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2, 1);
  }
  
  public void a(ao paramao, int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramInt1, paramInt2, 8);
  }
  
  public void a(ao paramao, int paramInt1, int paramInt2, Object paramObject)
  {
    c(paramInt1, paramInt2, 4);
  }
  
  public void a(ao paramao, ao.n paramn)
  {
    a(this.A);
    int i1 = 0;
    while (i1 < this.g)
    {
      this.h[i1].e();
      i1 += 1;
    }
  }
  
  public void a(AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramAccessibilityEvent);
    View localView1;
    View localView2;
    if (t() > 0)
    {
      paramAccessibilityEvent = a.a(paramAccessibilityEvent);
      localView1 = a(false, true);
      localView2 = b(false, true);
      if ((localView1 != null) && (localView2 != null)) {}
    }
    else
    {
      return;
    }
    int i1 = d(localView1);
    int i2 = d(localView2);
    if (i1 < i2)
    {
      paramAccessibilityEvent.b(i1);
      paramAccessibilityEvent.c(i2);
      return;
    }
    paramAccessibilityEvent.b(i2);
    paramAccessibilityEvent.c(i1);
  }
  
  public void a(String paramString)
  {
    if (this.u == null) {
      super.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(null);
    if ((this.u != null) && (this.u.h != paramBoolean)) {
      this.u.h = paramBoolean;
    }
    this.l = paramBoolean;
    n();
  }
  
  public boolean a(ao.i parami)
  {
    return parami instanceof b;
  }
  
  public int b(int paramInt, ao.n paramn, ao.s params)
  {
    return c(paramInt, paramn, params);
  }
  
  public int b(ao.n paramn, ao.s params)
  {
    if (this.i == 1) {
      return this.g;
    }
    return super.b(paramn, params);
  }
  
  public int b(ao.s params)
  {
    return a(params);
  }
  
  View b(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = this.a.c();
    int i3 = this.a.d();
    int i1 = t() - 1;
    Object localObject1 = null;
    if (i1 >= 0)
    {
      View localView = h(i1);
      int i4 = this.a.a(localView);
      int i5 = this.a.b(localView);
      Object localObject2 = localObject1;
      if (i5 > i2)
      {
        if (i4 < i3) {
          break label95;
        }
        localObject2 = localObject1;
      }
      for (;;)
      {
        i1 -= 1;
        localObject1 = localObject2;
        break;
        label95:
        if ((i5 <= i3) || (!paramBoolean1)) {
          return localView;
        }
        localObject2 = localObject1;
        if (paramBoolean2)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
      }
    }
    return (View)localObject1;
  }
  
  public void b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    a(null);
    if (paramInt == this.i) {
      return;
    }
    this.i = paramInt;
    an localan = this.a;
    this.a = this.b;
    this.b = localan;
    n();
  }
  
  public void b(ao paramao, int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2, 2);
  }
  
  public boolean b()
  {
    return this.u == null;
  }
  
  boolean b(ao.s params, a parama)
  {
    boolean bool = false;
    if ((params.a()) || (this.d == -1)) {
      return false;
    }
    if ((this.d < 0) || (this.d >= params.e()))
    {
      this.d = -1;
      this.e = Integer.MIN_VALUE;
      return false;
    }
    if ((this.u == null) || (this.u.a == -1) || (this.u.c < 1))
    {
      params = c(this.d);
      if (params != null)
      {
        if (this.c) {}
        for (int i1 = L();; i1 = M())
        {
          parama.a = i1;
          if (this.e == Integer.MIN_VALUE) {
            break label188;
          }
          if (!parama.c) {
            break;
          }
          parama.b = (this.a.d() - this.e - this.a.b(params));
          return true;
        }
        parama.b = (this.a.c() + this.e - this.a.a(params));
        return true;
        label188:
        if (this.a.c(params) > this.a.f())
        {
          if (parama.c) {}
          for (i1 = this.a.d();; i1 = this.a.c())
          {
            parama.b = i1;
            return true;
          }
        }
        i1 = this.a.a(params) - this.a.c();
        if (i1 < 0)
        {
          parama.b = (-i1);
          return true;
        }
        i1 = this.a.d() - this.a.b(params);
        if (i1 < 0)
        {
          parama.b = i1;
          return true;
        }
        parama.b = Integer.MIN_VALUE;
        return true;
      }
      parama.a = this.d;
      if (this.e == Integer.MIN_VALUE)
      {
        if (t(parama.a) == 1) {
          bool = true;
        }
        parama.c = bool;
        parama.b();
      }
      for (;;)
      {
        parama.d = true;
        return true;
        parama.a(this.e);
      }
    }
    parama.b = Integer.MIN_VALUE;
    parama.a = this.d;
    return true;
  }
  
  int c(int paramInt, ao.n paramn, ao.s params)
  {
    int i2;
    int i1;
    if (paramInt > 0)
    {
      i2 = L();
      i1 = 1;
      this.k.a = true;
      a(i2, params);
      l(i1);
      this.k.c = (this.k.d + i2);
      i2 = Math.abs(paramInt);
      this.k.b = i2;
      i1 = a(paramn, this.k, params);
      if (i2 >= i1) {
        break label116;
      }
    }
    for (;;)
    {
      this.a.a(-paramInt);
      this.o = this.c;
      return paramInt;
      i1 = -1;
      i2 = M();
      break;
      label116:
      if (paramInt < 0) {
        paramInt = -i1;
      } else {
        paramInt = i1;
      }
    }
  }
  
  public int c(ao.s params)
  {
    return a(params);
  }
  
  public Parcelable c()
  {
    if (this.u != null) {
      return new d(this.u);
    }
    d locald = new d();
    locald.h = this.l;
    locald.i = this.o;
    locald.j = this.t;
    int i1;
    label118:
    int i2;
    label151:
    int i3;
    if ((this.f != null) && (this.f.a != null))
    {
      locald.f = this.f.a;
      locald.e = locald.f.length;
      locald.g = this.f.b;
      if (t() <= 0) {
        break label267;
      }
      if (!this.o) {
        break label222;
      }
      i1 = L();
      locald.a = i1;
      locald.b = i();
      locald.c = this.g;
      locald.d = new int[this.g];
      i2 = 0;
      if (i2 >= this.g) {
        return locald;
      }
      if (!this.o) {
        break label230;
      }
      i3 = this.h[i2].b(Integer.MIN_VALUE);
      i1 = i3;
      if (i3 != Integer.MIN_VALUE) {
        i1 = i3 - this.a.d();
      }
    }
    for (;;)
    {
      locald.d[i2] = i1;
      i2 += 1;
      break label151;
      locald.e = 0;
      break;
      label222:
      i1 = M();
      break label118;
      label230:
      i3 = this.h[i2].a(Integer.MIN_VALUE);
      i1 = i3;
      if (i3 != Integer.MIN_VALUE) {
        i1 = i3 - this.a.c();
      }
    }
    label267:
    locald.a = -1;
    locald.b = -1;
    locald.c = 0;
    return locald;
  }
  
  public void c(ao.n paramn, ao.s params)
  {
    a(paramn, params, true);
  }
  
  public int d(ao.s params)
  {
    return h(params);
  }
  
  public void d(int paramInt)
  {
    if ((this.u != null) && (this.u.a != paramInt)) {
      this.u.b();
    }
    this.d = paramInt;
    this.e = Integer.MIN_VALUE;
    n();
  }
  
  public boolean d()
  {
    return this.i == 0;
  }
  
  public int e(ao.s params)
  {
    return h(params);
  }
  
  void e(int paramInt)
  {
    this.j = (paramInt / this.g);
    this.v = View.MeasureSpec.makeMeasureSpec(paramInt, this.b.h());
  }
  
  public boolean e()
  {
    return this.i == 1;
  }
  
  public int f(ao.s params)
  {
    return i(params);
  }
  
  View f()
  {
    int i1 = t() - 1;
    BitSet localBitSet = new BitSet(this.g);
    localBitSet.set(0, this.g, true);
    int i2;
    int i3;
    if ((this.i == 1) && (h()))
    {
      i2 = 1;
      if (!this.c) {
        break label127;
      }
      i3 = -1;
      label58:
      if (i1 >= i3) {
        break label139;
      }
    }
    int i5;
    View localView;
    b localb;
    label127:
    label139:
    for (int i4 = 1;; i4 = -1)
    {
      i5 = i1;
      if (i5 == i3) {
        break label350;
      }
      localView = h(i5);
      localb = (b)localView.getLayoutParams();
      if (!localBitSet.get(localb.e.d)) {
        break label156;
      }
      if (!a(localb.e)) {
        break label145;
      }
      return localView;
      i2 = -1;
      break;
      i3 = i1 + 1;
      i1 = 0;
      break label58;
    }
    label145:
    localBitSet.clear(localb.e.d);
    label156:
    if (localb.f) {}
    label278:
    label344:
    label348:
    label350:
    label352:
    label356:
    for (;;)
    {
      i5 += i4;
      break;
      if (i5 + i4 != i3)
      {
        Object localObject = h(i5 + i4);
        int i6;
        if (this.c)
        {
          i1 = this.a.b(localView);
          i6 = this.a.b((View)localObject);
          if (i1 < i6) {
            return localView;
          }
          if (i1 != i6) {
            break label352;
          }
          i1 = 1;
        }
        for (;;)
        {
          if (i1 == 0) {
            break label356;
          }
          localObject = (b)((View)localObject).getLayoutParams();
          if (localb.e.d - ((b)localObject).e.d < 0)
          {
            i1 = 1;
            if (i2 >= 0) {
              break label344;
            }
          }
          for (i6 = 1;; i6 = 0)
          {
            if (i1 == i6) {
              break label348;
            }
            return localView;
            i1 = this.a.a(localView);
            i6 = this.a.a((View)localObject);
            if (i1 > i6) {
              return localView;
            }
            if (i1 != i6) {
              break label352;
            }
            i1 = 1;
            break;
            i1 = 0;
            break label278;
          }
          break;
          return null;
          i1 = 0;
        }
      }
    }
  }
  
  public int g(ao.s params)
  {
    return i(params);
  }
  
  public void g()
  {
    this.f.a();
    n();
  }
  
  boolean h()
  {
    return r() == 1;
  }
  
  int i()
  {
    if (this.c) {}
    for (View localView = b(true, true); localView == null; localView = a(true, true)) {
      return -1;
    }
    return d(localView);
  }
  
  public void i(int paramInt)
  {
    super.i(paramInt);
    int i1 = 0;
    while (i1 < this.g)
    {
      this.h[i1].d(paramInt);
      i1 += 1;
    }
  }
  
  public void j(int paramInt)
  {
    super.j(paramInt);
    int i1 = 0;
    while (i1 < this.g)
    {
      this.h[i1].d(paramInt);
      i1 += 1;
    }
  }
  
  boolean j()
  {
    boolean bool2 = true;
    int i2 = this.h[0].b(Integer.MIN_VALUE);
    int i1 = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.g)
      {
        if (this.h[i1].b(Integer.MIN_VALUE) != i2) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public void k(int paramInt)
  {
    if (paramInt == 0) {
      I();
    }
  }
  
  boolean l()
  {
    boolean bool2 = true;
    int i2 = this.h[0].a(Integer.MIN_VALUE);
    int i1 = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.g)
      {
        if (this.h[i1].a(Integer.MIN_VALUE) != i2) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  private class a
  {
    int a;
    int b;
    boolean c;
    boolean d;
    
    private a() {}
    
    void a()
    {
      this.a = -1;
      this.b = Integer.MIN_VALUE;
      this.c = false;
      this.d = false;
    }
    
    void a(int paramInt)
    {
      if (this.c)
      {
        this.b = (StaggeredGridLayoutManager.this.a.d() - paramInt);
        return;
      }
      this.b = (StaggeredGridLayoutManager.this.a.c() + paramInt);
    }
    
    void b()
    {
      if (this.c) {}
      for (int i = StaggeredGridLayoutManager.this.a.d();; i = StaggeredGridLayoutManager.this.a.c())
      {
        this.b = i;
        return;
      }
    }
  }
  
  public static class b
    extends ao.i
  {
    StaggeredGridLayoutManager.e e;
    boolean f;
    
    public b(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public b(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public b(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public b(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public boolean a()
    {
      return this.f;
    }
    
    public final int b()
    {
      if (this.e == null) {
        return -1;
      }
      return this.e.d;
    }
  }
  
  static class c
  {
    int[] a;
    List<a> b;
    
    private void c(int paramInt1, int paramInt2)
    {
      if (this.b == null) {
        return;
      }
      int i = this.b.size() - 1;
      label21:
      a locala;
      if (i >= 0)
      {
        locala = (a)this.b.get(i);
        if (locala.a >= paramInt1) {
          break label58;
        }
      }
      for (;;)
      {
        i -= 1;
        break label21;
        break;
        label58:
        if (locala.a < paramInt1 + paramInt2) {
          this.b.remove(i);
        } else {
          locala.a -= paramInt2;
        }
      }
    }
    
    private void d(int paramInt1, int paramInt2)
    {
      if (this.b == null) {
        return;
      }
      int i = this.b.size() - 1;
      label21:
      a locala;
      if (i >= 0)
      {
        locala = (a)this.b.get(i);
        if (locala.a >= paramInt1) {
          break label58;
        }
      }
      for (;;)
      {
        i -= 1;
        break label21;
        break;
        label58:
        locala.a += paramInt2;
      }
    }
    
    private int g(int paramInt)
    {
      if (this.b == null) {
        return -1;
      }
      a locala = f(paramInt);
      if (locala != null) {
        this.b.remove(locala);
      }
      int j = this.b.size();
      int i = 0;
      if (i < j) {
        if (((a)this.b.get(i)).a < paramInt) {}
      }
      for (;;)
      {
        if (i != -1)
        {
          locala = (a)this.b.get(i);
          this.b.remove(i);
          return locala.a;
          i += 1;
          break;
        }
        return -1;
        i = -1;
      }
    }
    
    int a(int paramInt)
    {
      if (this.b != null)
      {
        int i = this.b.size() - 1;
        while (i >= 0)
        {
          if (((a)this.b.get(i)).a >= paramInt) {
            this.b.remove(i);
          }
          i -= 1;
        }
      }
      return b(paramInt);
    }
    
    public a a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      Object localObject;
      if (this.b == null)
      {
        localObject = null;
        return (a)localObject;
      }
      int j = this.b.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label117;
        }
        a locala = (a)this.b.get(i);
        if (locala.a >= paramInt2) {
          return null;
        }
        if (locala.a >= paramInt1)
        {
          localObject = locala;
          if (paramInt3 == 0) {
            break;
          }
          localObject = locala;
          if (locala.b == paramInt3) {
            break;
          }
          if (paramBoolean)
          {
            localObject = locala;
            if (locala.d) {
              break;
            }
          }
        }
        i += 1;
      }
      label117:
      return null;
    }
    
    void a()
    {
      if (this.a != null) {
        Arrays.fill(this.a, -1);
      }
      this.b = null;
    }
    
    void a(int paramInt1, int paramInt2)
    {
      if ((this.a == null) || (paramInt1 >= this.a.length)) {
        return;
      }
      e(paramInt1 + paramInt2);
      System.arraycopy(this.a, paramInt1 + paramInt2, this.a, paramInt1, this.a.length - paramInt1 - paramInt2);
      Arrays.fill(this.a, this.a.length - paramInt2, this.a.length, -1);
      c(paramInt1, paramInt2);
    }
    
    void a(int paramInt, StaggeredGridLayoutManager.e parame)
    {
      e(paramInt);
      this.a[paramInt] = parame.d;
    }
    
    public void a(a parama)
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      int j = this.b.size();
      int i = 0;
      while (i < j)
      {
        a locala = (a)this.b.get(i);
        if (locala.a == parama.a) {
          this.b.remove(i);
        }
        if (locala.a >= parama.a)
        {
          this.b.add(i, parama);
          return;
        }
        i += 1;
      }
      this.b.add(parama);
    }
    
    int b(int paramInt)
    {
      if (this.a == null) {}
      while (paramInt >= this.a.length) {
        return -1;
      }
      int i = g(paramInt);
      if (i == -1)
      {
        Arrays.fill(this.a, paramInt, this.a.length, -1);
        return this.a.length;
      }
      Arrays.fill(this.a, paramInt, i + 1, -1);
      return i + 1;
    }
    
    void b(int paramInt1, int paramInt2)
    {
      if ((this.a == null) || (paramInt1 >= this.a.length)) {
        return;
      }
      e(paramInt1 + paramInt2);
      System.arraycopy(this.a, paramInt1, this.a, paramInt1 + paramInt2, this.a.length - paramInt1 - paramInt2);
      Arrays.fill(this.a, paramInt1, paramInt1 + paramInt2, -1);
      d(paramInt1, paramInt2);
    }
    
    int c(int paramInt)
    {
      if ((this.a == null) || (paramInt >= this.a.length)) {
        return -1;
      }
      return this.a[paramInt];
    }
    
    int d(int paramInt)
    {
      int i = this.a.length;
      while (i <= paramInt) {
        i *= 2;
      }
      return i;
    }
    
    void e(int paramInt)
    {
      if (this.a == null)
      {
        this.a = new int[Math.max(paramInt, 10) + 1];
        Arrays.fill(this.a, -1);
      }
      while (paramInt < this.a.length) {
        return;
      }
      int[] arrayOfInt = this.a;
      this.a = new int[d(paramInt)];
      System.arraycopy(arrayOfInt, 0, this.a, 0, arrayOfInt.length);
      Arrays.fill(this.a, arrayOfInt.length, this.a.length, -1);
    }
    
    public a f(int paramInt)
    {
      Object localObject;
      if (this.b == null)
      {
        localObject = null;
        return (a)localObject;
      }
      int i = this.b.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label63;
        }
        a locala = (a)this.b.get(i);
        localObject = locala;
        if (locala.a == paramInt) {
          break;
        }
        i -= 1;
      }
      label63:
      return null;
    }
    
    static class a
      implements Parcelable
    {
      public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator()
      {
        public StaggeredGridLayoutManager.c.a a(Parcel paramAnonymousParcel)
        {
          return new StaggeredGridLayoutManager.c.a(paramAnonymousParcel);
        }
        
        public StaggeredGridLayoutManager.c.a[] a(int paramAnonymousInt)
        {
          return new StaggeredGridLayoutManager.c.a[paramAnonymousInt];
        }
      };
      int a;
      int b;
      int[] c;
      boolean d;
      
      public a() {}
      
      public a(Parcel paramParcel)
      {
        this.a = paramParcel.readInt();
        this.b = paramParcel.readInt();
        if (paramParcel.readInt() == 1) {}
        for (;;)
        {
          this.d = bool;
          int i = paramParcel.readInt();
          if (i > 0)
          {
            this.c = new int[i];
            paramParcel.readIntArray(this.c);
          }
          return;
          bool = false;
        }
      }
      
      int a(int paramInt)
      {
        if (this.c == null) {
          return 0;
        }
        return this.c[paramInt];
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public String toString()
      {
        return "FullSpanItem{mPosition=" + this.a + ", mGapDir=" + this.b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.a);
        paramParcel.writeInt(this.b);
        if (this.d) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeInt(paramInt);
          if ((this.c == null) || (this.c.length <= 0)) {
            break;
          }
          paramParcel.writeInt(this.c.length);
          paramParcel.writeIntArray(this.c);
          return;
        }
        paramParcel.writeInt(0);
      }
    }
  }
  
  public static class d
    implements Parcelable
  {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator()
    {
      public StaggeredGridLayoutManager.d a(Parcel paramAnonymousParcel)
      {
        return new StaggeredGridLayoutManager.d(paramAnonymousParcel);
      }
      
      public StaggeredGridLayoutManager.d[] a(int paramAnonymousInt)
      {
        return new StaggeredGridLayoutManager.d[paramAnonymousInt];
      }
    };
    int a;
    int b;
    int c;
    int[] d;
    int e;
    int[] f;
    List<StaggeredGridLayoutManager.c.a> g;
    boolean h;
    boolean i;
    boolean j;
    
    public d() {}
    
    d(Parcel paramParcel)
    {
      this.a = paramParcel.readInt();
      this.b = paramParcel.readInt();
      this.c = paramParcel.readInt();
      if (this.c > 0)
      {
        this.d = new int[this.c];
        paramParcel.readIntArray(this.d);
      }
      this.e = paramParcel.readInt();
      if (this.e > 0)
      {
        this.f = new int[this.e];
        paramParcel.readIntArray(this.f);
      }
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.h = bool1;
        if (paramParcel.readInt() != 1) {
          break label152;
        }
        bool1 = true;
        label113:
        this.i = bool1;
        if (paramParcel.readInt() != 1) {
          break label157;
        }
      }
      label152:
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.j = bool1;
        this.g = paramParcel.readArrayList(StaggeredGridLayoutManager.c.a.class.getClassLoader());
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label113;
      }
    }
    
    public d(d paramd)
    {
      this.c = paramd.c;
      this.a = paramd.a;
      this.b = paramd.b;
      this.d = paramd.d;
      this.e = paramd.e;
      this.f = paramd.f;
      this.h = paramd.h;
      this.i = paramd.i;
      this.j = paramd.j;
      this.g = paramd.g;
    }
    
    void a()
    {
      this.d = null;
      this.c = 0;
      this.e = 0;
      this.f = null;
      this.g = null;
    }
    
    void b()
    {
      this.d = null;
      this.c = 0;
      this.a = -1;
      this.b = -1;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int k = 1;
      paramParcel.writeInt(this.a);
      paramParcel.writeInt(this.b);
      paramParcel.writeInt(this.c);
      if (this.c > 0) {
        paramParcel.writeIntArray(this.d);
      }
      paramParcel.writeInt(this.e);
      if (this.e > 0) {
        paramParcel.writeIntArray(this.f);
      }
      if (this.h)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.i) {
          break label120;
        }
        paramInt = 1;
        label87:
        paramParcel.writeInt(paramInt);
        if (!this.j) {
          break label125;
        }
      }
      label120:
      label125:
      for (paramInt = k;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeList(this.g);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label87;
      }
    }
  }
  
  class e
  {
    int a = Integer.MIN_VALUE;
    int b = Integer.MIN_VALUE;
    int c = 0;
    final int d;
    private ArrayList<View> f = new ArrayList();
    
    private e(int paramInt)
    {
      this.d = paramInt;
    }
    
    int a(int paramInt)
    {
      if (this.a != Integer.MIN_VALUE) {
        paramInt = this.a;
      }
      while (this.f.size() == 0) {
        return paramInt;
      }
      a();
      return this.a;
    }
    
    public View a(int paramInt1, int paramInt2)
    {
      View localView2 = null;
      View localView1 = null;
      int i;
      if (paramInt2 == -1)
      {
        i = this.f.size();
        paramInt2 = 0;
        if (paramInt2 < i)
        {
          localView2 = (View)this.f.get(paramInt2);
          if (localView2.isFocusable())
          {
            if (StaggeredGridLayoutManager.this.d(localView2) > paramInt1) {}
            for (int k = 1;; k = 0)
            {
              if (k != StaggeredGridLayoutManager.b(StaggeredGridLayoutManager.this)) {
                break label92;
              }
              paramInt2 += 1;
              localView1 = localView2;
              break;
            }
          }
        }
        label92:
        return localView1;
      }
      paramInt2 = this.f.size() - 1;
      localView1 = localView2;
      if (paramInt2 >= 0)
      {
        localView2 = (View)this.f.get(paramInt2);
        if (localView2.isFocusable())
        {
          if (StaggeredGridLayoutManager.this.d(localView2) > paramInt1)
          {
            i = 1;
            label148:
            if (StaggeredGridLayoutManager.b(StaggeredGridLayoutManager.this)) {
              break label184;
            }
          }
          label184:
          for (int j = 1;; j = 0)
          {
            if (i != j) {
              return localView1;
            }
            paramInt2 -= 1;
            localView1 = localView2;
            break;
            i = 0;
            break label148;
          }
        }
      }
      return localView1;
    }
    
    void a()
    {
      Object localObject = (View)this.f.get(0);
      StaggeredGridLayoutManager.b localb = c((View)localObject);
      this.a = StaggeredGridLayoutManager.this.a.a((View)localObject);
      if (localb.f)
      {
        localObject = StaggeredGridLayoutManager.this.f.f(localb.e());
        if ((localObject != null) && (((StaggeredGridLayoutManager.c.a)localObject).b == -1)) {
          this.a -= ((StaggeredGridLayoutManager.c.a)localObject).a(this.d);
        }
      }
    }
    
    void a(View paramView)
    {
      StaggeredGridLayoutManager.b localb = c(paramView);
      localb.e = this;
      this.f.add(0, paramView);
      this.a = Integer.MIN_VALUE;
      if (this.f.size() == 1) {
        this.b = Integer.MIN_VALUE;
      }
      if ((localb.c()) || (localb.d())) {
        this.c += StaggeredGridLayoutManager.this.a.c(paramView);
      }
    }
    
    void a(boolean paramBoolean, int paramInt)
    {
      int i;
      if (paramBoolean)
      {
        i = b(Integer.MIN_VALUE);
        e();
        if (i != Integer.MIN_VALUE) {
          break label32;
        }
      }
      label32:
      while (((paramBoolean) && (i < StaggeredGridLayoutManager.this.a.d())) || ((!paramBoolean) && (i > StaggeredGridLayoutManager.this.a.c())))
      {
        return;
        i = a(Integer.MIN_VALUE);
        break;
      }
      int j = i;
      if (paramInt != Integer.MIN_VALUE) {
        j = i + paramInt;
      }
      this.b = j;
      this.a = j;
    }
    
    int b()
    {
      if (this.a != Integer.MIN_VALUE) {
        return this.a;
      }
      a();
      return this.a;
    }
    
    int b(int paramInt)
    {
      if (this.b != Integer.MIN_VALUE) {
        paramInt = this.b;
      }
      while (this.f.size() == 0) {
        return paramInt;
      }
      c();
      return this.b;
    }
    
    void b(View paramView)
    {
      StaggeredGridLayoutManager.b localb = c(paramView);
      localb.e = this;
      this.f.add(paramView);
      this.b = Integer.MIN_VALUE;
      if (this.f.size() == 1) {
        this.a = Integer.MIN_VALUE;
      }
      if ((localb.c()) || (localb.d())) {
        this.c += StaggeredGridLayoutManager.this.a.c(paramView);
      }
    }
    
    StaggeredGridLayoutManager.b c(View paramView)
    {
      return (StaggeredGridLayoutManager.b)paramView.getLayoutParams();
    }
    
    void c()
    {
      Object localObject = (View)this.f.get(this.f.size() - 1);
      StaggeredGridLayoutManager.b localb = c((View)localObject);
      this.b = StaggeredGridLayoutManager.this.a.b((View)localObject);
      if (localb.f)
      {
        localObject = StaggeredGridLayoutManager.this.f.f(localb.e());
        if ((localObject != null) && (((StaggeredGridLayoutManager.c.a)localObject).b == 1))
        {
          int i = this.b;
          this.b = (((StaggeredGridLayoutManager.c.a)localObject).a(this.d) + i);
        }
      }
    }
    
    void c(int paramInt)
    {
      this.a = paramInt;
      this.b = paramInt;
    }
    
    int d()
    {
      if (this.b != Integer.MIN_VALUE) {
        return this.b;
      }
      c();
      return this.b;
    }
    
    void d(int paramInt)
    {
      if (this.a != Integer.MIN_VALUE) {
        this.a += paramInt;
      }
      if (this.b != Integer.MIN_VALUE) {
        this.b += paramInt;
      }
    }
    
    void e()
    {
      this.f.clear();
      f();
      this.c = 0;
    }
    
    void f()
    {
      this.a = Integer.MIN_VALUE;
      this.b = Integer.MIN_VALUE;
    }
    
    void g()
    {
      int i = this.f.size();
      View localView = (View)this.f.remove(i - 1);
      StaggeredGridLayoutManager.b localb = c(localView);
      localb.e = null;
      if ((localb.c()) || (localb.d())) {
        this.c -= StaggeredGridLayoutManager.this.a.c(localView);
      }
      if (i == 1) {
        this.a = Integer.MIN_VALUE;
      }
      this.b = Integer.MIN_VALUE;
    }
    
    void h()
    {
      View localView = (View)this.f.remove(0);
      StaggeredGridLayoutManager.b localb = c(localView);
      localb.e = null;
      if (this.f.size() == 0) {
        this.b = Integer.MIN_VALUE;
      }
      if ((localb.c()) || (localb.d())) {
        this.c -= StaggeredGridLayoutManager.this.a.c(localView);
      }
      this.a = Integer.MIN_VALUE;
    }
    
    public int i()
    {
      return this.c;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/StaggeredGridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */