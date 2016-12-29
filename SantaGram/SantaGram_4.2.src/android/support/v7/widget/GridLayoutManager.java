package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.j.a.c;
import android.support.v4.j.a.c.k;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager
  extends LinearLayoutManager
{
  boolean a = false;
  int b = -1;
  int[] c;
  View[] d;
  final SparseIntArray e = new SparseIntArray();
  final SparseIntArray f = new SparseIntArray();
  c g = new a();
  final Rect h = new Rect();
  
  public GridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramContext);
    a(paramInt);
  }
  
  public GridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramInt2, paramBoolean);
    a(paramInt1);
  }
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(a(paramContext, paramAttributeSet, paramInt1, paramInt2).b);
  }
  
  private void I()
  {
    this.e.clear();
    this.f.clear();
  }
  
  private void J()
  {
    int j = t();
    int i = 0;
    while (i < j)
    {
      b localb = (b)h(i).getLayoutParams();
      int k = localb.e();
      this.e.put(k, localb.b());
      this.f.put(k, localb.a());
      i += 1;
    }
  }
  
  private void K()
  {
    if (f() == 1) {}
    for (int i = w() - A() - y();; i = x() - B() - z())
    {
      l(i);
      return;
    }
  }
  
  private void L()
  {
    if ((this.d == null) || (this.d.length != this.b)) {
      this.d = new View[this.b];
    }
  }
  
  private int a(ao.n paramn, ao.s params, int paramInt)
  {
    if (!params.a()) {
      return this.g.c(paramInt, this.b);
    }
    int i = paramn.b(paramInt);
    if (i == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + paramInt);
      return 0;
    }
    return this.g.c(i, this.b);
  }
  
  private void a(float paramFloat, int paramInt)
  {
    l(Math.max(Math.round(this.b * paramFloat), paramInt));
  }
  
  private void a(ao.n paramn, ao.s params, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i;
    int j;
    int k;
    label43:
    b localb;
    if (paramBoolean)
    {
      i = 1;
      paramInt2 = 0;
      j = paramInt1;
      paramInt1 = paramInt2;
      if ((this.i != 1) || (!g())) {
        break label150;
      }
      paramInt2 = this.b - 1;
      k = -1;
      if (paramInt1 == j) {
        return;
      }
      View localView = this.d[paramInt1];
      localb = (b)localView.getLayoutParams();
      b.a(localb, c(paramn, params, d(localView)));
      if ((k != -1) || (b.b(localb) <= 1)) {
        break label159;
      }
      b.b(localb, paramInt2 - (b.b(localb) - 1));
    }
    for (;;)
    {
      paramInt2 += b.b(localb) * k;
      paramInt1 += i;
      break label43;
      paramInt1 -= 1;
      i = -1;
      j = -1;
      break;
      label150:
      paramInt2 = 0;
      k = 1;
      break label43;
      label159:
      b.b(localb, paramInt2);
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramView, this.h);
    ao.i locali = (ao.i)paramView.getLayoutParams();
    int i;
    if (!paramBoolean1)
    {
      i = paramInt1;
      if (this.i != 1) {}
    }
    else
    {
      i = b(paramInt1, locali.leftMargin + this.h.left, locali.rightMargin + this.h.right);
    }
    if (!paramBoolean1)
    {
      paramInt1 = paramInt2;
      if (this.i != 0) {}
    }
    else
    {
      paramInt1 = b(paramInt2, locali.topMargin + this.h.top, locali.bottomMargin + this.h.bottom);
    }
    if (paramBoolean2) {}
    for (paramBoolean1 = a(paramView, i, paramInt1, locali);; paramBoolean1 = b(paramView, i, paramInt1, locali))
    {
      if (paramBoolean1) {
        paramView.measure(i, paramInt1);
      }
      return;
    }
  }
  
  static int[] a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int k = 0;
    int[] arrayOfInt;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length == paramInt1 + 1))
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt[(paramArrayOfInt.length - 1)] == paramInt2) {}
    }
    else
    {
      arrayOfInt = new int[paramInt1 + 1];
    }
    arrayOfInt[0] = 0;
    int m = paramInt2 / paramInt1;
    int n = paramInt2 % paramInt1;
    int i = 1;
    int j = 0;
    paramInt2 = k;
    if (i <= paramInt1)
    {
      paramInt2 += n;
      if ((paramInt2 <= 0) || (paramInt1 - paramInt2 >= n)) {
        break label113;
      }
      k = m + 1;
      paramInt2 -= paramInt1;
    }
    for (;;)
    {
      j += k;
      arrayOfInt[i] = j;
      i += 1;
      break;
      return arrayOfInt;
      label113:
      k = m;
    }
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    int i;
    do
    {
      return paramInt1;
      i = View.MeasureSpec.getMode(paramInt1);
    } while ((i != Integer.MIN_VALUE) && (i != 1073741824));
    return View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i);
  }
  
  private int b(ao.n paramn, ao.s params, int paramInt)
  {
    if (!params.a()) {
      i = this.g.b(paramInt, this.b);
    }
    int j;
    do
    {
      return i;
      j = this.f.get(paramInt, -1);
      i = j;
    } while (j != -1);
    int i = paramn.b(paramInt);
    if (i == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + paramInt);
      return 0;
    }
    return this.g.b(i, this.b);
  }
  
  private void b(ao.n paramn, ao.s params, LinearLayoutManager.a parama, int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {}
    for (;;)
    {
      paramInt = b(paramn, params, parama.a);
      if (i == 0) {
        break;
      }
      while ((paramInt > 0) && (parama.a > 0))
      {
        parama.a -= 1;
        paramInt = b(paramn, params, parama.a);
      }
      i = 0;
    }
    int k = params.e();
    i = parama.a;
    while (i < k - 1)
    {
      int j = b(paramn, params, i + 1);
      if (j <= paramInt) {
        break;
      }
      i += 1;
      paramInt = j;
    }
    parama.a = i;
  }
  
  private int c(ao.n paramn, ao.s params, int paramInt)
  {
    if (!params.a()) {
      i = this.g.a(paramInt);
    }
    int j;
    do
    {
      return i;
      j = this.e.get(paramInt, -1);
      i = j;
    } while (j != -1);
    int i = paramn.b(paramInt);
    if (i == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + paramInt);
      return 1;
    }
    return this.g.a(i);
  }
  
  private void l(int paramInt)
  {
    this.c = a(this.c, this.b, paramInt);
  }
  
  public int a(int paramInt, ao.n paramn, ao.s params)
  {
    K();
    L();
    return super.a(paramInt, paramn, params);
  }
  
  public int a(ao.n paramn, ao.s params)
  {
    if (this.i == 0) {
      return this.b;
    }
    if (params.e() < 1) {
      return 0;
    }
    return a(paramn, params, params.e() - 1) + 1;
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
  
  View a(ao.n paramn, ao.s params, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    h();
    int j = this.j.c();
    int k = this.j.d();
    int i;
    Object localObject1;
    label37:
    Object localObject3;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      localObject1 = null;
      if (paramInt1 == paramInt2) {
        break label197;
      }
      localObject3 = h(paramInt1);
      int m = d((View)localObject3);
      if ((m < 0) || (m >= paramInt3)) {
        break label216;
      }
      if (b(paramn, params, m) == 0) {
        break label119;
      }
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      paramInt1 += i;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label37;
      i = -1;
      break;
      label119:
      if (((ao.i)((View)localObject3).getLayoutParams()).c())
      {
        if (localObject1 == null)
        {
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
      }
      else
      {
        Object localObject4;
        if (this.j.a((View)localObject3) < k)
        {
          localObject4 = localObject3;
          if (this.j.b((View)localObject3) >= j) {}
        }
        else
        {
          if (localObject2 != null) {
            break label216;
          }
          localObject2 = localObject1;
          localObject1 = localObject3;
          continue;
          label197:
          if (localObject2 == null) {
            break label209;
          }
        }
        for (;;)
        {
          localObject4 = localObject2;
          return (View)localObject4;
          label209:
          localObject2 = localObject1;
        }
      }
      label216:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public View a(View paramView, int paramInt, ao.n paramn, ao.s params)
  {
    View localView = e(paramView);
    if (localView == null)
    {
      paramn = null;
      return paramn;
    }
    b localb = (b)localView.getLayoutParams();
    int i4 = b.a(localb);
    int i5 = b.a(localb) + b.b(localb);
    if (super.a(paramView, paramInt, paramn, params) == null) {
      return null;
    }
    int i8;
    label83:
    int m;
    int k;
    if (e(paramInt) == 1)
    {
      i8 = 1;
      if (i8 == this.k) {
        break label162;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label167;
      }
      paramInt = t() - 1;
      m = -1;
      k = -1;
      label100:
      if ((this.i != 1) || (!g())) {
        break label181;
      }
    }
    int j;
    int i;
    int i1;
    label132:
    label162:
    label167:
    label181:
    for (int n = 1;; n = 0)
    {
      paramView = null;
      j = -1;
      i = 0;
      i1 = paramInt;
      paramInt = j;
      if (i1 != k)
      {
        params = h(i1);
        if (params != localView) {
          break label187;
        }
      }
      return paramView;
      i8 = 0;
      break;
      paramInt = 0;
      break label83;
      k = t();
      paramInt = 0;
      m = 1;
      break label100;
    }
    label187:
    if (!params.isFocusable())
    {
      j = i;
      i = paramInt;
      paramInt = j;
    }
    for (;;)
    {
      i1 += m;
      j = i;
      i = paramInt;
      paramInt = j;
      break label132;
      localb = (b)params.getLayoutParams();
      int i6 = b.a(localb);
      int i7 = b.a(localb) + b.b(localb);
      if (i6 == i4)
      {
        paramn = params;
        if (i7 == i5) {
          break;
        }
      }
      int i3 = 0;
      if (paramView == null) {
        j = 1;
      }
      for (;;)
      {
        if (j != 0)
        {
          i = b.a(localb);
          paramInt = Math.min(i7, i5) - Math.max(i6, i4);
          paramView = params;
          break;
          j = Math.max(i6, i4);
          int i2 = Math.min(i7, i5) - j;
          if (i2 > i)
          {
            j = 1;
          }
          else
          {
            j = i3;
            if (i2 == i)
            {
              if (i6 > paramInt) {}
              for (i2 = 1;; i2 = 0)
              {
                j = i3;
                if (n != i2) {
                  break;
                }
                j = 1;
                break;
              }
            }
          }
        }
      }
      j = paramInt;
      paramInt = i;
      i = j;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == this.b) {
      return;
    }
    this.a = true;
    if (paramInt < 1) {
      throw new IllegalArgumentException("Span count should be at least 1. Provided " + paramInt);
    }
    this.b = paramInt;
    this.g.a();
  }
  
  public void a(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (this.c == null) {
      super.a(paramRect, paramInt1, paramInt2);
    }
    int i = y();
    int j = A() + i;
    int k = z() + B();
    if (this.i == 1)
    {
      i = a(paramInt2, k + paramRect.height(), E());
      paramInt2 = a(paramInt1, j + this.c[(this.c.length - 1)], D());
      paramInt1 = i;
    }
    for (;;)
    {
      d(paramInt2, paramInt1);
      return;
      i = a(paramInt1, j + paramRect.width(), D());
      paramInt1 = a(paramInt2, k + this.c[(this.c.length - 1)], E());
      paramInt2 = i;
    }
  }
  
  void a(ao.n paramn, ao.s params, LinearLayoutManager.a parama, int paramInt)
  {
    super.a(paramn, params, parama, paramInt);
    K();
    if ((params.e() > 0) && (!params.a())) {
      b(paramn, params, parama, paramInt);
    }
    L();
  }
  
  void a(ao.n paramn, ao.s params, LinearLayoutManager.c paramc, LinearLayoutManager.b paramb)
  {
    int i3 = this.j.i();
    int j;
    int k;
    label37:
    boolean bool1;
    label57:
    int i1;
    int i2;
    int n;
    if (i3 != 1073741824)
    {
      j = 1;
      if (t() <= 0) {
        break label225;
      }
      k = this.c[this.b];
      if (j != 0) {
        K();
      }
      if (paramc.e != 1) {
        break label231;
      }
      bool1 = true;
      i1 = 0;
      i2 = 0;
      i = this.b;
      n = i1;
      m = i2;
      if (!bool1)
      {
        i = b(paramn, params, paramc.d) + c(paramn, params, paramc.d);
        m = i2;
        n = i1;
      }
    }
    for (;;)
    {
      if ((n < this.b) && (paramc.a(params)) && (i > 0))
      {
        i2 = paramc.d;
        i1 = c(paramn, params, i2);
        if (i1 > this.b)
        {
          throw new IllegalArgumentException("Item at position " + i2 + " requires " + i1 + " spans but GridLayoutManager has only " + this.b + " spans.");
          j = 0;
          break;
          label225:
          k = 0;
          break label37;
          label231:
          bool1 = false;
          break label57;
        }
        i -= i1;
        if (i >= 0) {
          break label261;
        }
      }
      label261:
      View localView;
      do
      {
        if (n != 0) {
          break;
        }
        paramb.b = true;
        return;
        localView = paramc.a(paramn);
      } while (localView == null);
      m += i1;
      this.d[n] = localView;
      n += 1;
    }
    a(paramn, params, n, m, bool1);
    int m = 0;
    float f1 = 0.0F;
    int i = 0;
    label351:
    label399:
    label447:
    boolean bool2;
    if (m < n)
    {
      paramn = this.d[m];
      if (paramc.k == null) {
        if (bool1)
        {
          b(paramn);
          params = (b)paramn.getLayoutParams();
          i2 = this.c[(b.a(params) + b.b(params))];
          int i4 = this.c[b.a(params)];
          if (this.i != 0) {
            break label583;
          }
          i1 = params.height;
          i2 = a(i2 - i4, i3, 0, i1, false);
          i4 = this.j.f();
          int i5 = this.j.h();
          if (this.i != 1) {
            break label592;
          }
          i1 = params.height;
          i1 = a(i4, i5, 0, i1, true);
          if (this.i != 1) {
            break label607;
          }
          if (params.height != -1) {
            break label601;
          }
          bool2 = true;
          label479:
          a(paramn, i2, i1, bool2, false);
          i1 = this.j.c(paramn);
          if (i1 <= i) {
            break label1459;
          }
          i = i1;
        }
      }
    }
    label583:
    label592:
    label601:
    label607:
    label729:
    label777:
    label809:
    label848:
    label857:
    label959:
    label1003:
    label1012:
    label1101:
    label1360:
    label1396:
    label1444:
    label1453:
    label1459:
    for (;;)
    {
      float f2 = 1.0F * this.j.d(paramn) / b.b(params);
      if (f2 > f1) {
        f1 = f2;
      }
      for (;;)
      {
        m += 1;
        break;
        b(paramn, 0);
        break label351;
        if (bool1)
        {
          a(paramn);
          break label351;
        }
        a(paramn, 0);
        break label351;
        i1 = params.width;
        break label399;
        i1 = params.width;
        break label447;
        bool2 = false;
        break label479;
        if (params.width == -1) {}
        for (bool2 = true;; bool2 = false)
        {
          a(paramn, i1, i2, bool2, false);
          break;
        }
        m = i;
        if (j != 0)
        {
          a(f1, k);
          i = 0;
          j = 0;
          m = i;
          if (j < n)
          {
            paramn = this.d[j];
            params = (b)paramn.getLayoutParams();
            m = this.c[(b.a(params) + b.b(params))];
            i1 = this.c[b.a(params)];
            if (this.i == 0)
            {
              k = params.height;
              m = a(m - i1, 1073741824, 0, k, false);
              i1 = this.j.f();
              i2 = this.j.h();
              if (this.i != 1) {
                break label848;
              }
              k = params.height;
              k = a(i1, i2, 0, k, true);
              if (this.i != 1) {
                break label857;
              }
              a(paramn, m, k, false, true);
              k = this.j.c(paramn);
              if (k <= i) {
                break label1453;
              }
              i = k;
            }
          }
        }
        for (;;)
        {
          j += 1;
          break;
          k = params.width;
          break label729;
          k = params.width;
          break label777;
          a(paramn, k, m, false, true);
          break label809;
          k = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
          i = 0;
          if (i < n)
          {
            paramn = this.d[i];
            if (this.j.c(paramn) != m)
            {
              params = (b)paramn.getLayoutParams();
              i1 = this.c[(b.a(params) + b.b(params))];
              i2 = this.c[b.a(params)];
              if (this.i != 0) {
                break label1003;
              }
              j = params.height;
              j = a(i1 - i2, 1073741824, 0, j, false);
              if (this.i != 1) {
                break label1012;
              }
              a(paramn, j, k, true, true);
            }
            for (;;)
            {
              i += 1;
              break;
              j = params.width;
              break label959;
              a(paramn, k, j, true, true);
            }
          }
          paramb.a = m;
          j = 0;
          k = 0;
          if (this.i == 1) {
            if (paramc.f == -1)
            {
              k = paramc.b;
              m = k - m;
              i = 0;
              j = 0;
              i3 = 0;
              i1 = i;
              i2 = k;
              k = i3;
              i = j;
              j = i1;
              i1 = i2;
              if (k >= n) {
                break label1444;
              }
              paramn = this.d[k];
              params = (b)paramn.getLayoutParams();
              if (this.i != 1) {
                break label1396;
              }
              if (!g()) {
                break label1360;
              }
              j = y() + this.c[(b.a(params) + b.b(params))];
              i2 = this.j.d(paramn);
              i = j;
              j -= i2;
            }
          }
          for (;;)
          {
            a(paramn, j + params.leftMargin, m + params.topMargin, i - params.rightMargin, i1 - params.bottomMargin);
            if ((params.c()) || (params.d())) {
              paramb.c = true;
            }
            paramb.d |= paramn.isFocusable();
            i2 = k + 1;
            k = j;
            j = i;
            i = k;
            k = i2;
            break label1101;
            i = paramc.b;
            k = i + m;
            i1 = 0;
            j = 0;
            m = i;
            i = i1;
            break;
            if (paramc.f == -1)
            {
              i = paramc.b;
              i1 = i - m;
              m = j;
              j = i1;
              break;
            }
            i1 = paramc.b;
            i = m + i1;
            m = j;
            j = i1;
            break;
            i = y();
            j = this.c[b.a(params)] + i;
            i = this.j.d(paramn) + j;
            continue;
            m = z();
            m = this.c[b.a(params)] + m;
            i1 = this.j.d(paramn) + m;
            i2 = i;
            i = j;
            j = i2;
          }
          Arrays.fill(this.d, null);
          return;
        }
      }
    }
  }
  
  public void a(ao.n paramn, ao.s params, View paramView, c paramc)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof b))
    {
      super.a(paramView, paramc);
      return;
    }
    paramView = (b)localLayoutParams;
    int i = a(paramn, params, paramView.e());
    if (this.i == 0)
    {
      j = paramView.a();
      k = paramView.b();
      if ((this.b > 1) && (paramView.b() == this.b)) {}
      for (bool = true;; bool = false)
      {
        paramc.b(c.k.a(j, k, i, 1, bool, false));
        return;
      }
    }
    int j = paramView.a();
    int k = paramView.b();
    if ((this.b > 1) && (paramView.b() == this.b)) {}
    for (boolean bool = true;; bool = false)
    {
      paramc.b(c.k.a(i, 1, j, k, bool, false));
      return;
    }
  }
  
  public void a(ao paramao)
  {
    this.g.a();
  }
  
  public void a(ao paramao, int paramInt1, int paramInt2)
  {
    this.g.a();
  }
  
  public void a(ao paramao, int paramInt1, int paramInt2, int paramInt3)
  {
    this.g.a();
  }
  
  public void a(ao paramao, int paramInt1, int paramInt2, Object paramObject)
  {
    this.g.a();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }
    super.a(false);
  }
  
  public boolean a(ao.i parami)
  {
    return parami instanceof b;
  }
  
  public int b(int paramInt, ao.n paramn, ao.s params)
  {
    K();
    L();
    return super.b(paramInt, paramn, params);
  }
  
  public int b(ao.n paramn, ao.s params)
  {
    if (this.i == 1) {
      return this.b;
    }
    if (params.e() < 1) {
      return 0;
    }
    return a(paramn, params, params.e() - 1) + 1;
  }
  
  public void b(ao paramao, int paramInt1, int paramInt2)
  {
    this.g.a();
  }
  
  public boolean b()
  {
    return (this.n == null) && (!this.a);
  }
  
  public void c(ao.n paramn, ao.s params)
  {
    if (params.a()) {
      J();
    }
    super.c(paramn, params);
    I();
    if (!params.a()) {
      this.a = false;
    }
  }
  
  public static final class a
    extends GridLayoutManager.c
  {
    public int a(int paramInt)
    {
      return 1;
    }
    
    public int a(int paramInt1, int paramInt2)
    {
      return paramInt1 % paramInt2;
    }
  }
  
  public static class b
    extends ao.i
  {
    private int e = -1;
    private int f = 0;
    
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
    
    public int a()
    {
      return this.e;
    }
    
    public int b()
    {
      return this.f;
    }
  }
  
  public static abstract class c
  {
    final SparseIntArray a = new SparseIntArray();
    private boolean b = false;
    
    public abstract int a(int paramInt);
    
    public int a(int paramInt1, int paramInt2)
    {
      int n = a(paramInt1);
      if (n == paramInt2) {
        return 0;
      }
      int j;
      int i;
      if ((this.b) && (this.a.size() > 0))
      {
        j = b(paramInt1);
        if (j >= 0)
        {
          i = this.a.get(j) + a(j);
          j += 1;
        }
      }
      for (;;)
      {
        if (j < paramInt1)
        {
          int k = a(j);
          int m = i + k;
          if (m == paramInt2) {
            i = 0;
          }
          for (;;)
          {
            j += 1;
            break;
            i = k;
            if (m <= paramInt2) {
              i = m;
            }
          }
        }
        if (i + n > paramInt2) {
          break;
        }
        return i;
        j = 0;
        i = 0;
      }
    }
    
    public void a()
    {
      this.a.clear();
    }
    
    int b(int paramInt)
    {
      int i = 0;
      int j = this.a.size() - 1;
      while (i <= j)
      {
        int k = i + j >>> 1;
        if (this.a.keyAt(k) < paramInt) {
          i = k + 1;
        } else {
          j = k - 1;
        }
      }
      paramInt = i - 1;
      if ((paramInt >= 0) && (paramInt < this.a.size())) {
        return this.a.keyAt(paramInt);
      }
      return -1;
    }
    
    int b(int paramInt1, int paramInt2)
    {
      int i;
      if (!this.b) {
        i = a(paramInt1, paramInt2);
      }
      int j;
      do
      {
        return i;
        j = this.a.get(paramInt1, -1);
        i = j;
      } while (j != -1);
      paramInt2 = a(paramInt1, paramInt2);
      this.a.put(paramInt1, paramInt2);
      return paramInt2;
    }
    
    public int c(int paramInt1, int paramInt2)
    {
      int n = a(paramInt1);
      int k = 0;
      int i = 0;
      int j = 0;
      int m;
      if (k < paramInt1)
      {
        m = a(k);
        j += m;
        if (j == paramInt2)
        {
          j = i + 1;
          i = 0;
        }
      }
      for (;;)
      {
        m = k + 1;
        k = i;
        i = j;
        j = k;
        k = m;
        break;
        if (j > paramInt2)
        {
          j = i + 1;
          i = m;
          continue;
          paramInt1 = i;
          if (j + n > paramInt2) {
            paramInt1 = i + 1;
          }
          return paramInt1;
        }
        else
        {
          m = j;
          j = i;
          i = m;
        }
      }
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/GridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */