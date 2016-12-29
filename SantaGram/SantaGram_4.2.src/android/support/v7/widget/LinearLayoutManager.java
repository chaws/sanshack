package android.support.v7.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.j.a.a;
import android.support.v4.j.a.k;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager
  extends ao.h
{
  private c a;
  private boolean b;
  private boolean c = false;
  private boolean d = false;
  private boolean e = true;
  private boolean f;
  int i;
  an j;
  boolean k = false;
  int l = -1;
  int m = Integer.MIN_VALUE;
  d n = null;
  final a o = new a();
  
  public LinearLayoutManager(Context paramContext)
  {
    this(paramContext, 1, false);
  }
  
  public LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    b(paramInt);
    b(paramBoolean);
    c(true);
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    b(paramContext.a);
    b(paramContext.c);
    a(paramContext.d);
    c(true);
  }
  
  private void I()
  {
    boolean bool = true;
    if ((this.i == 1) || (!g()))
    {
      this.k = this.c;
      return;
    }
    if (!this.c) {}
    for (;;)
    {
      this.k = bool;
      return;
      bool = false;
    }
  }
  
  private View J()
  {
    if (this.k) {}
    for (int i1 = t() - 1;; i1 = 0) {
      return h(i1);
    }
  }
  
  private View K()
  {
    if (this.k) {}
    for (int i1 = 0;; i1 = t() - 1) {
      return h(i1);
    }
  }
  
  private int a(int paramInt, ao.n paramn, ao.s params, boolean paramBoolean)
  {
    int i1 = this.j.d() - paramInt;
    if (i1 > 0)
    {
      int i2 = -c(-i1, paramn, params);
      i1 = i2;
      if (paramBoolean)
      {
        paramInt = this.j.d() - (paramInt + i2);
        i1 = i2;
        if (paramInt > 0)
        {
          this.j.a(paramInt);
          i1 = i2 + paramInt;
        }
      }
      return i1;
    }
    return 0;
  }
  
  private View a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.k) {
      return a(t() - 1, -1, paramBoolean1, paramBoolean2);
    }
    return a(0, t(), paramBoolean1, paramBoolean2);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, ao.s params)
  {
    int i1 = -1;
    int i2 = 1;
    this.a.l = j();
    this.a.h = a(params);
    this.a.f = paramInt1;
    if (paramInt1 == 1)
    {
      params = this.a;
      params.h += this.j.g();
      params = K();
      localc = this.a;
      if (this.k) {}
      for (paramInt1 = i1;; paramInt1 = 1)
      {
        localc.e = paramInt1;
        this.a.d = (d(params) + this.a.e);
        this.a.b = this.j.b(params);
        paramInt1 = this.j.b(params) - this.j.d();
        this.a.c = paramInt2;
        if (paramBoolean)
        {
          params = this.a;
          params.c -= paramInt1;
        }
        this.a.g = paramInt1;
        return;
      }
    }
    params = J();
    c localc = this.a;
    localc.h += this.j.c();
    localc = this.a;
    if (this.k) {}
    for (paramInt1 = i2;; paramInt1 = -1)
    {
      localc.e = paramInt1;
      this.a.d = (d(params) + this.a.e);
      this.a.b = this.j.a(params);
      paramInt1 = -this.j.a(params) + this.j.c();
      break;
    }
  }
  
  private void a(a parama)
  {
    e(parama.a, parama.b);
  }
  
  private void a(ao.n paramn, int paramInt)
  {
    if (paramInt < 0) {}
    for (;;)
    {
      return;
      int i2 = t();
      int i1;
      View localView;
      if (this.k)
      {
        i1 = i2 - 1;
        while (i1 >= 0)
        {
          localView = h(i1);
          if (this.j.b(localView) > paramInt)
          {
            a(paramn, i2 - 1, i1);
            return;
          }
          i1 -= 1;
        }
      }
      else
      {
        i1 = 0;
        while (i1 < i2)
        {
          localView = h(i1);
          if (this.j.b(localView) > paramInt)
          {
            a(paramn, 0, i1);
            return;
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void a(ao.n paramn, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {}
    for (;;)
    {
      return;
      int i1 = paramInt1;
      if (paramInt2 > paramInt1)
      {
        paramInt2 -= 1;
        while (paramInt2 >= paramInt1)
        {
          a(paramInt2, paramn);
          paramInt2 -= 1;
        }
      }
      else
      {
        while (i1 > paramInt2)
        {
          a(i1, paramn);
          i1 -= 1;
        }
      }
    }
  }
  
  private void a(ao.n paramn, c paramc)
  {
    if ((!paramc.a) || (paramc.l)) {
      return;
    }
    if (paramc.f == -1)
    {
      b(paramn, paramc.g);
      return;
    }
    a(paramn, paramc.g);
  }
  
  private void a(ao.n paramn, ao.s params, a parama)
  {
    if (a(params, parama)) {}
    while (b(paramn, params, parama)) {
      return;
    }
    parama.b();
    if (this.d) {}
    for (int i1 = params.e() - 1;; i1 = 0)
    {
      parama.a = i1;
      return;
    }
  }
  
  private boolean a(ao.s params, a parama)
  {
    boolean bool = false;
    if ((params.a()) || (this.l == -1)) {
      return false;
    }
    if ((this.l < 0) || (this.l >= params.e()))
    {
      this.l = -1;
      this.m = Integer.MIN_VALUE;
      return false;
    }
    parama.a = this.l;
    if ((this.n != null) && (this.n.a()))
    {
      parama.c = this.n.c;
      if (parama.c)
      {
        parama.b = (this.j.d() - this.n.b);
        return true;
      }
      parama.b = (this.j.c() + this.n.b);
      return true;
    }
    if (this.m == Integer.MIN_VALUE)
    {
      params = c(this.l);
      int i1;
      if (params != null)
      {
        if (this.j.c(params) > this.j.f())
        {
          parama.b();
          return true;
        }
        if (this.j.a(params) - this.j.c() < 0)
        {
          parama.b = this.j.c();
          parama.c = false;
          return true;
        }
        if (this.j.d() - this.j.b(params) < 0)
        {
          parama.b = this.j.d();
          parama.c = true;
          return true;
        }
        if (parama.c) {}
        for (i1 = this.j.b(params) + this.j.b();; i1 = this.j.a(params))
        {
          parama.b = i1;
          return true;
        }
      }
      if (t() > 0)
      {
        i1 = d(h(0));
        if (this.l >= i1) {
          break label351;
        }
      }
      label351:
      for (int i2 = 1;; i2 = 0)
      {
        if (i2 == this.k) {
          bool = true;
        }
        parama.c = bool;
        parama.b();
        return true;
      }
    }
    parama.c = this.k;
    if (this.k)
    {
      parama.b = (this.j.d() - this.m);
      return true;
    }
    parama.b = (this.j.c() + this.m);
    return true;
  }
  
  private int b(int paramInt, ao.n paramn, ao.s params, boolean paramBoolean)
  {
    int i1 = paramInt - this.j.c();
    if (i1 > 0)
    {
      int i2 = -c(i1, paramn, params);
      i1 = i2;
      if (paramBoolean)
      {
        paramInt = paramInt + i2 - this.j.c();
        i1 = i2;
        if (paramInt > 0)
        {
          this.j.a(-paramInt);
          i1 = i2 - paramInt;
        }
      }
      return i1;
    }
    return 0;
  }
  
  private View b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.k) {
      return a(0, t(), paramBoolean1, paramBoolean2);
    }
    return a(t() - 1, -1, paramBoolean1, paramBoolean2);
  }
  
  private void b(a parama)
  {
    f(parama.a, parama.b);
  }
  
  private void b(ao.n paramn, int paramInt)
  {
    int i1 = t();
    if (paramInt < 0) {}
    for (;;)
    {
      return;
      int i2 = this.j.e() - paramInt;
      View localView;
      if (this.k)
      {
        paramInt = 0;
        while (paramInt < i1)
        {
          localView = h(paramInt);
          if (this.j.a(localView) < i2)
          {
            a(paramn, 0, paramInt);
            return;
          }
          paramInt += 1;
        }
      }
      else
      {
        paramInt = i1 - 1;
        while (paramInt >= 0)
        {
          localView = h(paramInt);
          if (this.j.a(localView) < i2)
          {
            a(paramn, i1 - 1, paramInt);
            return;
          }
          paramInt -= 1;
        }
      }
    }
  }
  
  private void b(ao.n paramn, ao.s params, int paramInt1, int paramInt2)
  {
    if ((!params.b()) || (t() == 0) || (params.a()) || (!b())) {
      return;
    }
    int i1 = 0;
    int i2 = 0;
    List localList = paramn.b();
    int i5 = localList.size();
    int i6 = d(h(0));
    int i3 = 0;
    if (i3 < i5)
    {
      ao.v localv = (ao.v)localList.get(i3);
      int i4;
      if (localv.q())
      {
        i4 = i2;
        i2 = i1;
        i1 = i4;
      }
      for (;;)
      {
        i4 = i3 + 1;
        i3 = i2;
        i2 = i1;
        i1 = i3;
        i3 = i4;
        break;
        int i7;
        if (localv.d() < i6)
        {
          i7 = 1;
          label143:
          if (i7 == this.k) {
            break label195;
          }
        }
        label195:
        for (i4 = -1;; i4 = 1)
        {
          if (i4 != -1) {
            break label201;
          }
          i4 = this.j.c(localv.a) + i1;
          i1 = i2;
          i2 = i4;
          break;
          i7 = 0;
          break label143;
        }
        label201:
        i4 = this.j.c(localv.a) + i2;
        i2 = i1;
        i1 = i4;
      }
    }
    this.a.k = localList;
    if (i1 > 0)
    {
      f(d(J()), paramInt1);
      this.a.h = i1;
      this.a.c = 0;
      this.a.a();
      a(paramn, this.a, params, false);
    }
    if (i2 > 0)
    {
      e(d(K()), paramInt2);
      this.a.h = i2;
      this.a.c = 0;
      this.a.a();
      a(paramn, this.a, params, false);
    }
    this.a.k = null;
  }
  
  private boolean b(ao.n paramn, ao.s params, a parama)
  {
    int i1 = 0;
    if (t() == 0) {}
    do
    {
      return false;
      View localView = C();
      if ((localView != null) && (a.a(parama, localView, params)))
      {
        parama.a(localView);
        return true;
      }
    } while (this.b != this.d);
    if (parama.c)
    {
      paramn = f(paramn, params);
      label66:
      if (paramn == null) {
        break label165;
      }
      parama.b(paramn);
      if ((!params.a()) && (b()))
      {
        if ((this.j.a(paramn) >= this.j.d()) || (this.j.b(paramn) < this.j.c())) {
          i1 = 1;
        }
        if (i1 != 0) {
          if (!parama.c) {
            break label167;
          }
        }
      }
    }
    label165:
    label167:
    for (i1 = this.j.d();; i1 = this.j.c())
    {
      parama.b = i1;
      return true;
      paramn = g(paramn, params);
      break label66;
      break;
    }
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    this.a.c = (this.j.d() - paramInt2);
    c localc = this.a;
    if (this.k) {}
    for (int i1 = -1;; i1 = 1)
    {
      localc.e = i1;
      this.a.d = paramInt1;
      this.a.f = 1;
      this.a.b = paramInt2;
      this.a.g = Integer.MIN_VALUE;
      return;
    }
  }
  
  private View f(ao.n paramn, ao.s params)
  {
    if (this.k) {
      return h(paramn, params);
    }
    return i(paramn, params);
  }
  
  private void f(int paramInt1, int paramInt2)
  {
    this.a.c = (paramInt2 - this.j.c());
    this.a.d = paramInt1;
    c localc = this.a;
    if (this.k) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      localc.e = paramInt1;
      this.a.f = -1;
      this.a.b = paramInt2;
      this.a.g = Integer.MIN_VALUE;
      return;
    }
  }
  
  private View g(ao.n paramn, ao.s params)
  {
    if (this.k) {
      return i(paramn, params);
    }
    return h(paramn, params);
  }
  
  private int h(ao.s params)
  {
    boolean bool2 = false;
    if (t() == 0) {
      return 0;
    }
    h();
    an localan = this.j;
    if (!this.e) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = a(bool1, true);
      bool1 = bool2;
      if (!this.e) {
        bool1 = true;
      }
      return as.a(params, localan, localView, b(bool1, true), this, this.e, this.k);
    }
  }
  
  private View h(ao.n paramn, ao.s params)
  {
    return a(paramn, params, 0, t(), params.e());
  }
  
  private int i(ao.s params)
  {
    boolean bool2 = false;
    if (t() == 0) {
      return 0;
    }
    h();
    an localan = this.j;
    if (!this.e) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = a(bool1, true);
      bool1 = bool2;
      if (!this.e) {
        bool1 = true;
      }
      return as.a(params, localan, localView, b(bool1, true), this, this.e);
    }
  }
  
  private View i(ao.n paramn, ao.s params)
  {
    return a(paramn, params, t() - 1, -1, params.e());
  }
  
  private int j(ao.s params)
  {
    boolean bool2 = false;
    if (t() == 0) {
      return 0;
    }
    h();
    an localan = this.j;
    if (!this.e) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = a(bool1, true);
      bool1 = bool2;
      if (!this.e) {
        bool1 = true;
      }
      return as.b(params, localan, localView, b(bool1, true), this, this.e);
    }
  }
  
  public int a(int paramInt, ao.n paramn, ao.s params)
  {
    if (this.i == 1) {
      return 0;
    }
    return c(paramInt, paramn, params);
  }
  
  int a(ao.n paramn, c paramc, ao.s params, boolean paramBoolean)
  {
    int i3 = paramc.c;
    if (paramc.g != Integer.MIN_VALUE)
    {
      if (paramc.c < 0) {
        paramc.g += paramc.c;
      }
      a(paramn, paramc);
    }
    int i1 = paramc.c + paramc.h;
    b localb = new b();
    if (((paramc.l) || (i1 > 0)) && (paramc.a(params)))
    {
      localb.a();
      a(paramn, params, paramc, localb);
      if (!localb.b) {
        break label111;
      }
    }
    for (;;)
    {
      return i3 - paramc.c;
      label111:
      paramc.b += localb.a * paramc.f;
      int i2;
      if ((localb.c) && (this.a.k == null))
      {
        i2 = i1;
        if (params.a()) {}
      }
      else
      {
        paramc.c -= localb.a;
        i2 = i1 - localb.a;
      }
      if (paramc.g != Integer.MIN_VALUE)
      {
        paramc.g += localb.a;
        if (paramc.c < 0) {
          paramc.g += paramc.c;
        }
        a(paramn, paramc);
      }
      i1 = i2;
      if (!paramBoolean) {
        break;
      }
      i1 = i2;
      if (!localb.d) {
        break;
      }
    }
  }
  
  protected int a(ao.s params)
  {
    if (params.d()) {
      return this.j.f();
    }
    return 0;
  }
  
  public ao.i a()
  {
    return new ao.i(-2, -2);
  }
  
  View a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    h();
    int i2 = this.j.c();
    int i3 = this.j.d();
    if (paramInt2 > paramInt1) {}
    Object localObject;
    View localView;
    for (int i1 = 1;; i1 = -1)
    {
      localObject = null;
      if (paramInt1 == paramInt2) {
        break label130;
      }
      localView = h(paramInt1);
      int i4 = this.j.a(localView);
      int i5 = this.j.b(localView);
      if ((i4 >= i3) || (i5 <= i2)) {
        break label133;
      }
      if ((paramBoolean1) && ((i4 < i2) || (i5 > i3))) {
        break;
      }
      return localView;
    }
    if ((paramBoolean2) && (localObject == null)) {
      localObject = localView;
    }
    label130:
    label133:
    for (;;)
    {
      paramInt1 += i1;
      break;
      return (View)localObject;
    }
  }
  
  View a(ao.n paramn, ao.s params, int paramInt1, int paramInt2, int paramInt3)
  {
    params = null;
    h();
    int i2 = this.j.c();
    int i3 = this.j.d();
    int i1;
    label35:
    Object localObject1;
    if (paramInt2 > paramInt1)
    {
      i1 = 1;
      paramn = null;
      if (paramInt1 == paramInt2) {
        break label157;
      }
      localObject1 = h(paramInt1);
      int i4 = d((View)localObject1);
      if ((i4 < 0) || (i4 >= paramInt3)) {
        break label172;
      }
      if (!((ao.i)((View)localObject1).getLayoutParams()).c()) {
        break label113;
      }
      if (paramn != null) {
        break label172;
      }
      paramn = params;
      params = (ao.s)localObject1;
    }
    for (;;)
    {
      paramInt1 += i1;
      localObject1 = params;
      params = paramn;
      paramn = (ao.n)localObject1;
      break label35;
      i1 = -1;
      break;
      label113:
      Object localObject2;
      if (this.j.a((View)localObject1) < i3)
      {
        localObject2 = localObject1;
        if (this.j.b((View)localObject1) >= i2) {}
      }
      else
      {
        if (params != null) {
          break label172;
        }
        params = paramn;
        paramn = (ao.n)localObject1;
        continue;
        label157:
        if (params == null) {
          break label167;
        }
      }
      for (;;)
      {
        localObject2 = params;
        return (View)localObject2;
        label167:
        params = paramn;
      }
      label172:
      localObject1 = paramn;
      paramn = params;
      params = (ao.s)localObject1;
    }
  }
  
  public View a(View paramView, int paramInt, ao.n paramn, ao.s params)
  {
    I();
    if (t() == 0) {}
    label42:
    label134:
    label136:
    label142:
    for (;;)
    {
      return null;
      paramInt = e(paramInt);
      if (paramInt != Integer.MIN_VALUE)
      {
        h();
        if (paramInt == -1)
        {
          paramView = g(paramn, params);
          if (paramView == null) {
            break label134;
          }
          h();
          a(paramInt, (int)(0.33333334F * this.j.f()), false, params);
          this.a.g = Integer.MIN_VALUE;
          this.a.a = false;
          a(paramn, this.a, params, true);
          if (paramInt != -1) {
            break label136;
          }
        }
        for (paramn = J();; paramn = K())
        {
          if ((paramn == paramView) || (!paramn.isFocusable())) {
            break label142;
          }
          return paramn;
          paramView = f(paramn, params);
          break label42;
          break;
        }
      }
    }
  }
  
  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof d))
    {
      this.n = ((d)paramParcelable);
      n();
    }
  }
  
  void a(ao.n paramn, ao.s params, a parama, int paramInt) {}
  
  void a(ao.n paramn, ao.s params, c paramc, b paramb)
  {
    paramn = paramc.a(paramn);
    if (paramn == null)
    {
      paramb.b = true;
      return;
    }
    params = (ao.i)paramn.getLayoutParams();
    boolean bool2;
    boolean bool1;
    label61:
    int i1;
    int i2;
    label120:
    int i3;
    int i4;
    if (paramc.k == null)
    {
      bool2 = this.k;
      if (paramc.f == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label215;
        }
        b(paramn);
        a(paramn, 0, 0);
        paramb.a = this.j.c(paramn);
        if (this.i != 1) {
          break label322;
        }
        if (!g()) {
          break label271;
        }
        i1 = w() - A();
        i2 = i1 - this.j.d(paramn);
        if (paramc.f != -1) {
          break label293;
        }
        i3 = paramc.b;
        i4 = paramc.b - paramb.a;
      }
    }
    for (;;)
    {
      a(paramn, i2 + params.leftMargin, i4 + params.topMargin, i1 - params.rightMargin, i3 - params.bottomMargin);
      if ((params.c()) || (params.d())) {
        paramb.c = true;
      }
      paramb.d = paramn.isFocusable();
      return;
      bool1 = false;
      break;
      label215:
      b(paramn, 0);
      break label61;
      bool2 = this.k;
      if (paramc.f == -1) {}
      for (bool1 = true;; bool1 = false)
      {
        if (bool2 != bool1) {
          break label262;
        }
        a(paramn);
        break;
      }
      label262:
      a(paramn, 0);
      break label61;
      label271:
      i2 = y();
      i1 = this.j.d(paramn) + i2;
      break label120;
      label293:
      i4 = paramc.b;
      i3 = paramc.b;
      int i5 = paramb.a;
      i3 += i5;
      continue;
      label322:
      i4 = z();
      i3 = this.j.d(paramn) + i4;
      if (paramc.f == -1)
      {
        i1 = paramc.b;
        i2 = paramc.b - paramb.a;
      }
      else
      {
        i2 = paramc.b;
        i1 = paramc.b;
        i5 = paramb.a;
        i1 += i5;
      }
    }
  }
  
  public void a(ao paramao, ao.n paramn)
  {
    super.a(paramao, paramn);
    if (this.f)
    {
      c(paramn);
      paramn.a();
    }
  }
  
  public void a(AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramAccessibilityEvent);
    if (t() > 0)
    {
      paramAccessibilityEvent = a.a(paramAccessibilityEvent);
      paramAccessibilityEvent.b(l());
      paramAccessibilityEvent.c(m());
    }
  }
  
  public void a(String paramString)
  {
    if (this.n == null) {
      super.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(null);
    if (this.d == paramBoolean) {
      return;
    }
    this.d = paramBoolean;
    n();
  }
  
  public int b(int paramInt, ao.n paramn, ao.s params)
  {
    if (this.i == 0) {
      return 0;
    }
    return c(paramInt, paramn, params);
  }
  
  public int b(ao.s params)
  {
    return h(params);
  }
  
  public void b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:" + paramInt);
    }
    a(null);
    if (paramInt == this.i) {
      return;
    }
    this.i = paramInt;
    this.j = null;
    n();
  }
  
  public void b(boolean paramBoolean)
  {
    a(null);
    if (paramBoolean == this.c) {
      return;
    }
    this.c = paramBoolean;
    n();
  }
  
  public boolean b()
  {
    return (this.n == null) && (this.b == this.d);
  }
  
  int c(int paramInt, ao.n paramn, ao.s params)
  {
    if ((t() == 0) || (paramInt == 0)) {
      return 0;
    }
    this.a.a = true;
    h();
    if (paramInt > 0) {}
    int i2;
    int i3;
    for (int i1 = 1;; i1 = -1)
    {
      i2 = Math.abs(paramInt);
      a(i1, i2, true, params);
      i3 = this.a.g + a(paramn, this.a, params, false);
      if (i3 >= 0) {
        break;
      }
      return 0;
    }
    if (i2 > i3) {
      paramInt = i1 * i3;
    }
    this.j.a(-paramInt);
    this.a.j = paramInt;
    return paramInt;
  }
  
  public int c(ao.s params)
  {
    return h(params);
  }
  
  public Parcelable c()
  {
    if (this.n != null) {
      return new d(this.n);
    }
    d locald = new d();
    if (t() > 0)
    {
      h();
      boolean bool = this.b ^ this.k;
      locald.c = bool;
      if (bool)
      {
        localView = K();
        locald.b = (this.j.d() - this.j.b(localView));
        locald.a = d(localView);
        return locald;
      }
      View localView = J();
      locald.a = d(localView);
      locald.b = (this.j.a(localView) - this.j.c());
      return locald;
    }
    locald.b();
    return locald;
  }
  
  public View c(int paramInt)
  {
    int i1 = t();
    Object localObject;
    if (i1 == 0) {
      localObject = null;
    }
    View localView;
    do
    {
      return (View)localObject;
      int i2 = paramInt - d(h(0));
      if ((i2 < 0) || (i2 >= i1)) {
        break;
      }
      localView = h(i2);
      localObject = localView;
    } while (d(localView) == paramInt);
    return super.c(paramInt);
  }
  
  public void c(ao.n paramn, ao.s params)
  {
    if (((this.n != null) || (this.l != -1)) && (params.e() == 0))
    {
      c(paramn);
      return;
    }
    if ((this.n != null) && (this.n.a())) {
      this.l = this.n.a;
    }
    h();
    this.a.a = false;
    I();
    this.o.a();
    this.o.c = (this.k ^ this.d);
    a(paramn, params, this.o);
    int i1 = a(params);
    int i2;
    int i4;
    int i5;
    int i3;
    Object localObject;
    if (this.a.j >= 0)
    {
      i2 = 0;
      i4 = i2 + this.j.c();
      i5 = i1 + this.j.g();
      i2 = i5;
      i3 = i4;
      if (params.a())
      {
        i2 = i5;
        i3 = i4;
        if (this.l != -1)
        {
          i2 = i5;
          i3 = i4;
          if (this.m != Integer.MIN_VALUE)
          {
            localObject = c(this.l);
            i2 = i5;
            i3 = i4;
            if (localObject != null)
            {
              if (!this.k) {
                break label662;
              }
              i1 = this.j.d() - this.j.b((View)localObject) - this.m;
              label248:
              if (i1 <= 0) {
                break label696;
              }
              i3 = i4 + i1;
              i2 = i5;
            }
          }
        }
      }
      label264:
      if (!this.o.c) {
        break label716;
      }
      if (!this.k) {
        break label710;
      }
      i1 = 1;
      label284:
      a(paramn, params, this.o, i1);
      a(paramn);
      this.a.l = j();
      this.a.i = params.a();
      if (!this.o.c) {
        break label735;
      }
      b(this.o);
      this.a.h = i3;
      a(paramn, this.a, params, false);
      i4 = this.a.b;
      i5 = this.a.d;
      i1 = i2;
      if (this.a.c > 0) {
        i1 = i2 + this.a.c;
      }
      a(this.o);
      this.a.h = i1;
      localObject = this.a;
      ((c)localObject).d += this.a.e;
      a(paramn, this.a, params, false);
      i3 = this.a.b;
      if (this.a.c <= 0) {
        break label988;
      }
      i1 = this.a.c;
      f(i5, i4);
      this.a.h = i1;
      a(paramn, this.a, params, false);
    }
    label530:
    label662:
    label696:
    label710:
    label716:
    label735:
    label939:
    label988:
    for (i1 = this.a.b;; i1 = i4)
    {
      i2 = i1;
      i1 = i3;
      i3 = i1;
      i4 = i2;
      if (t() > 0)
      {
        if (!(this.k ^ this.d)) {
          break label939;
        }
        i3 = a(i1, paramn, params, true);
        i4 = i2 + i3;
        i2 = b(i4, paramn, params, false);
        i4 += i2;
      }
      for (i3 = i1 + i3 + i2;; i3 = i1 + i5)
      {
        b(paramn, params, i4, i3);
        if (!params.a())
        {
          this.l = -1;
          this.m = Integer.MIN_VALUE;
          this.j.a();
        }
        this.b = this.d;
        this.n = null;
        return;
        i2 = i1;
        i1 = 0;
        break;
        i1 = this.j.a((View)localObject);
        i2 = this.j.c();
        i1 = this.m - (i1 - i2);
        break label248;
        i2 = i5 - i1;
        i3 = i4;
        break label264;
        i1 = -1;
        break label284;
        if (this.k)
        {
          i1 = -1;
          break label284;
        }
        i1 = 1;
        break label284;
        a(this.o);
        this.a.h = i2;
        a(paramn, this.a, params, false);
        i4 = this.a.b;
        i5 = this.a.d;
        i1 = i3;
        if (this.a.c > 0) {
          i1 = i3 + this.a.c;
        }
        b(this.o);
        this.a.h = i1;
        localObject = this.a;
        ((c)localObject).d += this.a.e;
        a(paramn, this.a, params, false);
        i3 = this.a.b;
        i1 = i4;
        i2 = i3;
        if (this.a.c <= 0) {
          break label530;
        }
        i1 = this.a.c;
        e(i5, i4);
        this.a.h = i1;
        a(paramn, this.a, params, false);
        i1 = this.a.b;
        i2 = i3;
        break label530;
        i3 = b(i2, paramn, params, true);
        i1 += i3;
        i5 = a(i1, paramn, params, false);
        i4 = i2 + i3 + i5;
      }
    }
  }
  
  public int d(ao.s params)
  {
    return i(params);
  }
  
  public void d(int paramInt)
  {
    this.l = paramInt;
    this.m = Integer.MIN_VALUE;
    if (this.n != null) {
      this.n.b();
    }
    n();
  }
  
  public boolean d()
  {
    return this.i == 0;
  }
  
  int e(int paramInt)
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
  
  public int e(ao.s params)
  {
    return i(params);
  }
  
  public boolean e()
  {
    return this.i == 1;
  }
  
  public int f()
  {
    return this.i;
  }
  
  public int f(ao.s params)
  {
    return j(params);
  }
  
  public int g(ao.s params)
  {
    return j(params);
  }
  
  protected boolean g()
  {
    return r() == 1;
  }
  
  void h()
  {
    if (this.a == null) {
      this.a = i();
    }
    if (this.j == null) {
      this.j = an.a(this, this.i);
    }
  }
  
  c i()
  {
    return new c();
  }
  
  boolean j()
  {
    return (this.j.h() == 0) && (this.j.e() == 0);
  }
  
  boolean k()
  {
    return (v() != 1073741824) && (u() != 1073741824) && (H());
  }
  
  public int l()
  {
    View localView = a(0, t(), false, true);
    if (localView == null) {
      return -1;
    }
    return d(localView);
  }
  
  public int m()
  {
    View localView = a(t() - 1, -1, false, true);
    if (localView == null) {
      return -1;
    }
    return d(localView);
  }
  
  class a
  {
    int a;
    int b;
    boolean c;
    
    a() {}
    
    private boolean a(View paramView, ao.s params)
    {
      paramView = (ao.i)paramView.getLayoutParams();
      return (!paramView.c()) && (paramView.e() >= 0) && (paramView.e() < params.e());
    }
    
    void a()
    {
      this.a = -1;
      this.b = Integer.MIN_VALUE;
      this.c = false;
    }
    
    public void a(View paramView)
    {
      int j = LinearLayoutManager.this.j.b();
      if (j >= 0) {
        b(paramView);
      }
      int i;
      do
      {
        int k;
        do
        {
          do
          {
            do
            {
              return;
              this.a = LinearLayoutManager.this.d(paramView);
              if (!this.c) {
                break;
              }
              i = LinearLayoutManager.this.j.d() - j - LinearLayoutManager.this.j.b(paramView);
              this.b = (LinearLayoutManager.this.j.d() - i);
            } while (i <= 0);
            j = LinearLayoutManager.this.j.c(paramView);
            k = this.b;
            m = LinearLayoutManager.this.j.c();
            j = k - j - (m + Math.min(LinearLayoutManager.this.j.a(paramView) - m, 0));
          } while (j >= 0);
          k = this.b;
          this.b = (Math.min(i, -j) + k);
          return;
          k = LinearLayoutManager.this.j.a(paramView);
          i = k - LinearLayoutManager.this.j.c();
          this.b = k;
        } while (i <= 0);
        int m = LinearLayoutManager.this.j.c(paramView);
        int n = LinearLayoutManager.this.j.d();
        int i1 = LinearLayoutManager.this.j.b(paramView);
        j = LinearLayoutManager.this.j.d() - Math.min(0, n - j - i1) - (k + m);
      } while (j >= 0);
      this.b -= Math.min(i, -j);
    }
    
    void b()
    {
      if (this.c) {}
      for (int i = LinearLayoutManager.this.j.d();; i = LinearLayoutManager.this.j.c())
      {
        this.b = i;
        return;
      }
    }
    
    public void b(View paramView)
    {
      if (this.c) {}
      for (this.b = (LinearLayoutManager.this.j.b(paramView) + LinearLayoutManager.this.j.b());; this.b = LinearLayoutManager.this.j.a(paramView))
      {
        this.a = LinearLayoutManager.this.d(paramView);
        return;
      }
    }
    
    public String toString()
    {
      return "AnchorInfo{mPosition=" + this.a + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.c + '}';
    }
  }
  
  protected static class b
  {
    public int a;
    public boolean b;
    public boolean c;
    public boolean d;
    
    void a()
    {
      this.a = 0;
      this.b = false;
      this.c = false;
      this.d = false;
    }
  }
  
  static class c
  {
    boolean a = true;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h = 0;
    boolean i = false;
    int j;
    List<ao.v> k = null;
    boolean l;
    
    private View b()
    {
      int n = this.k.size();
      int m = 0;
      if (m < n)
      {
        View localView = ((ao.v)this.k.get(m)).a;
        ao.i locali = (ao.i)localView.getLayoutParams();
        if (locali.c()) {}
        while (this.d != locali.e())
        {
          m += 1;
          break;
        }
        a(localView);
        return localView;
      }
      return null;
    }
    
    View a(ao.n paramn)
    {
      if (this.k != null) {
        return b();
      }
      paramn = paramn.c(this.d);
      this.d += this.e;
      return paramn;
    }
    
    public void a()
    {
      a(null);
    }
    
    public void a(View paramView)
    {
      paramView = b(paramView);
      if (paramView == null)
      {
        this.d = -1;
        return;
      }
      this.d = ((ao.i)paramView.getLayoutParams()).e();
    }
    
    boolean a(ao.s params)
    {
      return (this.d >= 0) && (this.d < params.e());
    }
    
    public View b(View paramView)
    {
      int i2 = this.k.size();
      Object localObject = null;
      int m = Integer.MAX_VALUE;
      int n = 0;
      if (n < i2)
      {
        View localView = ((ao.v)this.k.get(n)).a;
        ao.i locali = (ao.i)localView.getLayoutParams();
        if (localView != paramView) {
          if (!locali.c()) {}
        }
        for (;;)
        {
          n += 1;
          break;
          int i1 = (locali.e() - this.d) * this.e;
          if (i1 >= 0) {
            if (i1 < m)
            {
              if (i1 == 0) {
                return localView;
              }
              localObject = localView;
              m = i1;
            }
          }
        }
      }
      return (View)localObject;
    }
  }
  
  public static class d
    implements Parcelable
  {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator()
    {
      public LinearLayoutManager.d a(Parcel paramAnonymousParcel)
      {
        return new LinearLayoutManager.d(paramAnonymousParcel);
      }
      
      public LinearLayoutManager.d[] a(int paramAnonymousInt)
      {
        return new LinearLayoutManager.d[paramAnonymousInt];
      }
    };
    int a;
    int b;
    boolean c;
    
    public d() {}
    
    d(Parcel paramParcel)
    {
      this.a = paramParcel.readInt();
      this.b = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.c = bool;
        return;
        bool = false;
      }
    }
    
    public d(d paramd)
    {
      this.a = paramd.a;
      this.b = paramd.b;
      this.c = paramd.c;
    }
    
    boolean a()
    {
      return this.a >= 0;
    }
    
    void b()
    {
      this.a = -1;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.a);
      paramParcel.writeInt(this.b);
      if (this.c) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/LinearLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */