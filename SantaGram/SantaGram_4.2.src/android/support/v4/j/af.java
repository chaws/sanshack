package android.support.v4.j;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

public final class af
{
  static final m a = new a();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      a = new l();
      return;
    }
    if (i >= 21)
    {
      a = new k();
      return;
    }
    if (i >= 19)
    {
      a = new j();
      return;
    }
    if (i >= 17)
    {
      a = new h();
      return;
    }
    if (i >= 16)
    {
      a = new g();
      return;
    }
    if (i >= 15)
    {
      a = new e();
      return;
    }
    if (i >= 14)
    {
      a = new f();
      return;
    }
    if (i >= 11)
    {
      a = new d();
      return;
    }
    if (i >= 9)
    {
      a = new c();
      return;
    }
    if (i >= 7)
    {
      a = new b();
      return;
    }
  }
  
  public static boolean A(View paramView)
  {
    return a.C(paramView);
  }
  
  public static float B(View paramView)
  {
    return a.D(paramView);
  }
  
  public static boolean C(View paramView)
  {
    return a.E(paramView);
  }
  
  public static boolean D(View paramView)
  {
    return a.F(paramView);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return a.a(paramInt1, paramInt2);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return a.a(paramInt1, paramInt2, paramInt3);
  }
  
  public static int a(View paramView)
  {
    return a.a(paramView);
  }
  
  public static bc a(View paramView, bc parambc)
  {
    return a.a(paramView, parambc);
  }
  
  public static void a(View paramView, float paramFloat)
  {
    a.a(paramView, paramFloat);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    a.a(paramView, paramInt1, paramInt2);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(View paramView, int paramInt, Paint paramPaint)
  {
    a.a(paramView, paramInt, paramPaint);
  }
  
  public static void a(View paramView, ColorStateList paramColorStateList)
  {
    a.a(paramView, paramColorStateList);
  }
  
  public static void a(View paramView, PorterDuff.Mode paramMode)
  {
    a.a(paramView, paramMode);
  }
  
  public static void a(View paramView, a parama)
  {
    a.a(paramView, parama);
  }
  
  public static void a(View paramView, aa paramaa)
  {
    a.a(paramView, paramaa);
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    a.a(paramView, paramRunnable);
  }
  
  public static void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    a.a(paramView, paramRunnable, paramLong);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    a.a(paramView, paramBoolean);
  }
  
  public static boolean a(View paramView, int paramInt)
  {
    return a.a(paramView, paramInt);
  }
  
  public static void b(View paramView, float paramFloat)
  {
    a.b(paramView, paramFloat);
  }
  
  public static void b(View paramView, boolean paramBoolean)
  {
    a.b(paramView, paramBoolean);
  }
  
  public static boolean b(View paramView)
  {
    return a.b(paramView);
  }
  
  public static boolean b(View paramView, int paramInt)
  {
    return a.b(paramView, paramInt);
  }
  
  public static void c(View paramView, float paramFloat)
  {
    a.c(paramView, paramFloat);
  }
  
  public static void c(View paramView, int paramInt)
  {
    a.c(paramView, paramInt);
  }
  
  public static void c(View paramView, boolean paramBoolean)
  {
    a.c(paramView, paramBoolean);
  }
  
  public static boolean c(View paramView)
  {
    return a.c(paramView);
  }
  
  public static void d(View paramView)
  {
    a.d(paramView);
  }
  
  public static void d(View paramView, float paramFloat)
  {
    a.d(paramView, paramFloat);
  }
  
  public static void d(View paramView, int paramInt)
  {
    a.d(paramView, paramInt);
  }
  
  public static int e(View paramView)
  {
    return a.e(paramView);
  }
  
  public static void e(View paramView, int paramInt)
  {
    a.f(paramView, paramInt);
  }
  
  public static float f(View paramView)
  {
    return a.f(paramView);
  }
  
  public static void f(View paramView, int paramInt)
  {
    a.e(paramView, paramInt);
  }
  
  public static int g(View paramView)
  {
    return a.g(paramView);
  }
  
  public static int h(View paramView)
  {
    return a.h(paramView);
  }
  
  public static int i(View paramView)
  {
    return a.i(paramView);
  }
  
  public static int j(View paramView)
  {
    return a.j(paramView);
  }
  
  public static int k(View paramView)
  {
    return a.k(paramView);
  }
  
  public static int l(View paramView)
  {
    return a.l(paramView);
  }
  
  public static float m(View paramView)
  {
    return a.n(paramView);
  }
  
  public static float n(View paramView)
  {
    return a.o(paramView);
  }
  
  public static int o(View paramView)
  {
    return a.p(paramView);
  }
  
  public static int p(View paramView)
  {
    return a.q(paramView);
  }
  
  public static av q(View paramView)
  {
    return a.r(paramView);
  }
  
  public static int r(View paramView)
  {
    return a.s(paramView);
  }
  
  public static void s(View paramView)
  {
    a.t(paramView);
  }
  
  public static boolean t(View paramView)
  {
    return a.w(paramView);
  }
  
  public static void u(View paramView)
  {
    a.x(paramView);
  }
  
  public static boolean v(View paramView)
  {
    return a.m(paramView);
  }
  
  public static boolean w(View paramView)
  {
    return a.y(paramView);
  }
  
  public static ColorStateList x(View paramView)
  {
    return a.z(paramView);
  }
  
  public static PorterDuff.Mode y(View paramView)
  {
    return a.A(paramView);
  }
  
  public static void z(View paramView)
  {
    a.B(paramView);
  }
  
  static class a
    implements af.m
  {
    WeakHashMap<View, av> a = null;
    
    private boolean a(ab paramab, int paramInt)
    {
      boolean bool = true;
      int i = paramab.computeHorizontalScrollOffset();
      int j = paramab.computeHorizontalScrollRange() - paramab.computeHorizontalScrollExtent();
      if (j == 0) {
        bool = false;
      }
      do
      {
        do
        {
          return bool;
          if (paramInt >= 0) {
            break;
          }
        } while (i > 0);
        return false;
      } while (i < j - 1);
      return false;
    }
    
    private boolean b(ab paramab, int paramInt)
    {
      boolean bool = true;
      int i = paramab.computeVerticalScrollOffset();
      int j = paramab.computeVerticalScrollRange() - paramab.computeVerticalScrollExtent();
      if (j == 0) {
        bool = false;
      }
      do
      {
        do
        {
          return bool;
          if (paramInt >= 0) {
            break;
          }
        } while (i > 0);
        return false;
      } while (i < j - 1);
      return false;
    }
    
    public PorterDuff.Mode A(View paramView)
    {
      return ag.b(paramView);
    }
    
    public void B(View paramView)
    {
      if ((paramView instanceof w)) {
        ((w)paramView).stopNestedScroll();
      }
    }
    
    public boolean C(View paramView)
    {
      return ag.c(paramView);
    }
    
    public float D(View paramView)
    {
      return v(paramView) + u(paramView);
    }
    
    public boolean E(View paramView)
    {
      return ag.f(paramView);
    }
    
    public boolean F(View paramView)
    {
      return false;
    }
    
    public int a(int paramInt1, int paramInt2)
    {
      return paramInt1 | paramInt2;
    }
    
    public int a(int paramInt1, int paramInt2, int paramInt3)
    {
      return View.resolveSize(paramInt1, paramInt2);
    }
    
    public int a(View paramView)
    {
      return 2;
    }
    
    long a()
    {
      return 10L;
    }
    
    public bc a(View paramView, bc parambc)
    {
      return parambc;
    }
    
    public void a(View paramView, float paramFloat) {}
    
    public void a(View paramView, int paramInt1, int paramInt2) {}
    
    public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void a(View paramView, int paramInt, Paint paramPaint) {}
    
    public void a(View paramView, ColorStateList paramColorStateList)
    {
      ag.a(paramView, paramColorStateList);
    }
    
    public void a(View paramView, PorterDuff.Mode paramMode)
    {
      ag.a(paramView, paramMode);
    }
    
    public void a(View paramView, a parama) {}
    
    public void a(View paramView, aa paramaa) {}
    
    public void a(View paramView, Runnable paramRunnable)
    {
      paramView.postDelayed(paramRunnable, a());
    }
    
    public void a(View paramView, Runnable paramRunnable, long paramLong)
    {
      paramView.postDelayed(paramRunnable, a() + paramLong);
    }
    
    public void a(View paramView, boolean paramBoolean) {}
    
    public boolean a(View paramView, int paramInt)
    {
      return ((paramView instanceof ab)) && (a((ab)paramView, paramInt));
    }
    
    public void b(View paramView, float paramFloat) {}
    
    public void b(View paramView, boolean paramBoolean) {}
    
    public boolean b(View paramView)
    {
      return false;
    }
    
    public boolean b(View paramView, int paramInt)
    {
      return ((paramView instanceof ab)) && (b((ab)paramView, paramInt));
    }
    
    public void c(View paramView, float paramFloat) {}
    
    public void c(View paramView, int paramInt) {}
    
    public void c(View paramView, boolean paramBoolean) {}
    
    public boolean c(View paramView)
    {
      return false;
    }
    
    public void d(View paramView)
    {
      paramView.invalidate();
    }
    
    public void d(View paramView, float paramFloat) {}
    
    public void d(View paramView, int paramInt) {}
    
    public int e(View paramView)
    {
      return 0;
    }
    
    public void e(View paramView, int paramInt)
    {
      ag.b(paramView, paramInt);
    }
    
    public float f(View paramView)
    {
      return 1.0F;
    }
    
    public void f(View paramView, int paramInt)
    {
      ag.a(paramView, paramInt);
    }
    
    public int g(View paramView)
    {
      return 0;
    }
    
    public int h(View paramView)
    {
      return 0;
    }
    
    public int i(View paramView)
    {
      return paramView.getMeasuredWidth();
    }
    
    public int j(View paramView)
    {
      return 0;
    }
    
    public int k(View paramView)
    {
      return paramView.getPaddingLeft();
    }
    
    public int l(View paramView)
    {
      return paramView.getPaddingRight();
    }
    
    public boolean m(View paramView)
    {
      return true;
    }
    
    public float n(View paramView)
    {
      return 0.0F;
    }
    
    public float o(View paramView)
    {
      return 0.0F;
    }
    
    public int p(View paramView)
    {
      return ag.d(paramView);
    }
    
    public int q(View paramView)
    {
      return ag.e(paramView);
    }
    
    public av r(View paramView)
    {
      return new av(paramView);
    }
    
    public int s(View paramView)
    {
      return 0;
    }
    
    public void t(View paramView) {}
    
    public float u(View paramView)
    {
      return 0.0F;
    }
    
    public float v(View paramView)
    {
      return 0.0F;
    }
    
    public boolean w(View paramView)
    {
      return false;
    }
    
    public void x(View paramView) {}
    
    public boolean y(View paramView)
    {
      return false;
    }
    
    public ColorStateList z(View paramView)
    {
      return ag.a(paramView);
    }
  }
  
  static class b
    extends af.a
  {}
  
  static class c
    extends af.b
  {
    public int a(View paramView)
    {
      return ah.a(paramView);
    }
  }
  
  static class d
    extends af.c
  {
    public int a(int paramInt1, int paramInt2)
    {
      return ai.a(paramInt1, paramInt2);
    }
    
    public int a(int paramInt1, int paramInt2, int paramInt3)
    {
      return ai.a(paramInt1, paramInt2, paramInt3);
    }
    
    long a()
    {
      return ai.a();
    }
    
    public void a(View paramView, float paramFloat)
    {
      ai.a(paramView, paramFloat);
    }
    
    public void a(View paramView, int paramInt, Paint paramPaint)
    {
      ai.a(paramView, paramInt, paramPaint);
    }
    
    public void b(View paramView, float paramFloat)
    {
      ai.b(paramView, paramFloat);
    }
    
    public void b(View paramView, boolean paramBoolean)
    {
      ai.a(paramView, paramBoolean);
    }
    
    public void c(View paramView, float paramFloat)
    {
      ai.c(paramView, paramFloat);
    }
    
    public void c(View paramView, boolean paramBoolean)
    {
      ai.b(paramView, paramBoolean);
    }
    
    public void e(View paramView, int paramInt)
    {
      ai.b(paramView, paramInt);
    }
    
    public float f(View paramView)
    {
      return ai.a(paramView);
    }
    
    public void f(View paramView, int paramInt)
    {
      ai.a(paramView, paramInt);
    }
    
    public int g(View paramView)
    {
      return ai.b(paramView);
    }
    
    public int i(View paramView)
    {
      return ai.c(paramView);
    }
    
    public int j(View paramView)
    {
      return ai.d(paramView);
    }
    
    public float n(View paramView)
    {
      return ai.e(paramView);
    }
    
    public float o(View paramView)
    {
      return ai.f(paramView);
    }
    
    public void x(View paramView)
    {
      ai.g(paramView);
    }
  }
  
  static class e
    extends af.f
  {
    public boolean F(View paramView)
    {
      return ak.a(paramView);
    }
  }
  
  static class f
    extends af.d
  {
    static Field b;
    static boolean c = false;
    
    public void a(View paramView, a parama)
    {
      if (parama == null) {}
      for (parama = null;; parama = parama.a())
      {
        aj.a(paramView, parama);
        return;
      }
    }
    
    public void a(View paramView, boolean paramBoolean)
    {
      aj.a(paramView, paramBoolean);
    }
    
    public boolean a(View paramView, int paramInt)
    {
      return aj.a(paramView, paramInt);
    }
    
    /* Error */
    public boolean b(View paramView)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: getstatic 15	android/support/v4/j/af$f:c	Z
      //   5: ifeq +5 -> 10
      //   8: iconst_0
      //   9: ireturn
      //   10: getstatic 42	android/support/v4/j/af$f:b	Ljava/lang/reflect/Field;
      //   13: ifnonnull +20 -> 33
      //   16: ldc 44
      //   18: ldc 46
      //   20: invokevirtual 52	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
      //   23: putstatic 42	android/support/v4/j/af$f:b	Ljava/lang/reflect/Field;
      //   26: getstatic 42	android/support/v4/j/af$f:b	Ljava/lang/reflect/Field;
      //   29: iconst_1
      //   30: invokevirtual 58	java/lang/reflect/Field:setAccessible	(Z)V
      //   33: getstatic 42	android/support/v4/j/af$f:b	Ljava/lang/reflect/Field;
      //   36: aload_1
      //   37: invokevirtual 62	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   40: astore_1
      //   41: aload_1
      //   42: ifnull +12 -> 54
      //   45: iload_2
      //   46: ireturn
      //   47: astore_1
      //   48: iconst_1
      //   49: putstatic 15	android/support/v4/j/af$f:c	Z
      //   52: iconst_0
      //   53: ireturn
      //   54: iconst_0
      //   55: istore_2
      //   56: goto -11 -> 45
      //   59: astore_1
      //   60: iconst_1
      //   61: putstatic 15	android/support/v4/j/af$f:c	Z
      //   64: iconst_0
      //   65: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	66	0	this	f
      //   0	66	1	paramView	View
      //   1	55	2	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   16	33	47	java/lang/Throwable
      //   33	41	59	java/lang/Throwable
    }
    
    public boolean b(View paramView, int paramInt)
    {
      return aj.b(paramView, paramInt);
    }
    
    public av r(View paramView)
    {
      if (this.a == null) {
        this.a = new WeakHashMap();
      }
      av localav2 = (av)this.a.get(paramView);
      av localav1 = localav2;
      if (localav2 == null)
      {
        localav1 = new av(paramView);
        this.a.put(paramView, localav1);
      }
      return localav1;
    }
  }
  
  static class g
    extends af.e
  {
    public void a(View paramView, Runnable paramRunnable)
    {
      al.a(paramView, paramRunnable);
    }
    
    public void a(View paramView, Runnable paramRunnable, long paramLong)
    {
      al.a(paramView, paramRunnable, paramLong);
    }
    
    public void c(View paramView, int paramInt)
    {
      int i = paramInt;
      if (paramInt == 4) {
        i = 2;
      }
      al.a(paramView, i);
    }
    
    public boolean c(View paramView)
    {
      return al.a(paramView);
    }
    
    public void d(View paramView)
    {
      al.b(paramView);
    }
    
    public int e(View paramView)
    {
      return al.c(paramView);
    }
    
    public boolean m(View paramView)
    {
      return al.h(paramView);
    }
    
    public int p(View paramView)
    {
      return al.d(paramView);
    }
    
    public int q(View paramView)
    {
      return al.e(paramView);
    }
    
    public void t(View paramView)
    {
      al.f(paramView);
    }
    
    public boolean w(View paramView)
    {
      return al.g(paramView);
    }
  }
  
  static class h
    extends af.g
  {
    public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      am.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public int h(View paramView)
    {
      return am.a(paramView);
    }
    
    public int k(View paramView)
    {
      return am.b(paramView);
    }
    
    public int l(View paramView)
    {
      return am.c(paramView);
    }
    
    public int s(View paramView)
    {
      return am.d(paramView);
    }
    
    public boolean y(View paramView)
    {
      return am.e(paramView);
    }
  }
  
  static class i
    extends af.h
  {}
  
  static class j
    extends af.i
  {
    public boolean C(View paramView)
    {
      return an.a(paramView);
    }
    
    public boolean E(View paramView)
    {
      return an.b(paramView);
    }
    
    public void c(View paramView, int paramInt)
    {
      al.a(paramView, paramInt);
    }
    
    public void d(View paramView, int paramInt)
    {
      an.a(paramView, paramInt);
    }
  }
  
  static class k
    extends af.j
  {
    public PorterDuff.Mode A(View paramView)
    {
      return ao.e(paramView);
    }
    
    public void B(View paramView)
    {
      ao.f(paramView);
    }
    
    public float D(View paramView)
    {
      return ao.g(paramView);
    }
    
    public bc a(View paramView, bc parambc)
    {
      return ao.a(paramView, parambc);
    }
    
    public void a(View paramView, ColorStateList paramColorStateList)
    {
      ao.a(paramView, paramColorStateList);
    }
    
    public void a(View paramView, PorterDuff.Mode paramMode)
    {
      ao.a(paramView, paramMode);
    }
    
    public void a(View paramView, aa paramaa)
    {
      ao.a(paramView, paramaa);
    }
    
    public void d(View paramView, float paramFloat)
    {
      ao.a(paramView, paramFloat);
    }
    
    public void e(View paramView, int paramInt)
    {
      ao.b(paramView, paramInt);
    }
    
    public void f(View paramView, int paramInt)
    {
      ao.a(paramView, paramInt);
    }
    
    public void t(View paramView)
    {
      ao.a(paramView);
    }
    
    public float u(View paramView)
    {
      return ao.b(paramView);
    }
    
    public float v(View paramView)
    {
      return ao.c(paramView);
    }
    
    public ColorStateList z(View paramView)
    {
      return ao.d(paramView);
    }
  }
  
  static class l
    extends af.k
  {
    public void a(View paramView, int paramInt1, int paramInt2)
    {
      ap.a(paramView, paramInt1, paramInt2);
    }
    
    public void e(View paramView, int paramInt)
    {
      ap.b(paramView, paramInt);
    }
    
    public void f(View paramView, int paramInt)
    {
      ap.a(paramView, paramInt);
    }
  }
  
  static abstract interface m
  {
    public abstract PorterDuff.Mode A(View paramView);
    
    public abstract void B(View paramView);
    
    public abstract boolean C(View paramView);
    
    public abstract float D(View paramView);
    
    public abstract boolean E(View paramView);
    
    public abstract boolean F(View paramView);
    
    public abstract int a(int paramInt1, int paramInt2);
    
    public abstract int a(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract int a(View paramView);
    
    public abstract bc a(View paramView, bc parambc);
    
    public abstract void a(View paramView, float paramFloat);
    
    public abstract void a(View paramView, int paramInt1, int paramInt2);
    
    public abstract void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void a(View paramView, int paramInt, Paint paramPaint);
    
    public abstract void a(View paramView, ColorStateList paramColorStateList);
    
    public abstract void a(View paramView, PorterDuff.Mode paramMode);
    
    public abstract void a(View paramView, a parama);
    
    public abstract void a(View paramView, aa paramaa);
    
    public abstract void a(View paramView, Runnable paramRunnable);
    
    public abstract void a(View paramView, Runnable paramRunnable, long paramLong);
    
    public abstract void a(View paramView, boolean paramBoolean);
    
    public abstract boolean a(View paramView, int paramInt);
    
    public abstract void b(View paramView, float paramFloat);
    
    public abstract void b(View paramView, boolean paramBoolean);
    
    public abstract boolean b(View paramView);
    
    public abstract boolean b(View paramView, int paramInt);
    
    public abstract void c(View paramView, float paramFloat);
    
    public abstract void c(View paramView, int paramInt);
    
    public abstract void c(View paramView, boolean paramBoolean);
    
    public abstract boolean c(View paramView);
    
    public abstract void d(View paramView);
    
    public abstract void d(View paramView, float paramFloat);
    
    public abstract void d(View paramView, int paramInt);
    
    public abstract int e(View paramView);
    
    public abstract void e(View paramView, int paramInt);
    
    public abstract float f(View paramView);
    
    public abstract void f(View paramView, int paramInt);
    
    public abstract int g(View paramView);
    
    public abstract int h(View paramView);
    
    public abstract int i(View paramView);
    
    public abstract int j(View paramView);
    
    public abstract int k(View paramView);
    
    public abstract int l(View paramView);
    
    public abstract boolean m(View paramView);
    
    public abstract float n(View paramView);
    
    public abstract float o(View paramView);
    
    public abstract int p(View paramView);
    
    public abstract int q(View paramView);
    
    public abstract av r(View paramView);
    
    public abstract int s(View paramView);
    
    public abstract void t(View paramView);
    
    public abstract boolean w(View paramView);
    
    public abstract void x(View paramView);
    
    public abstract boolean y(View paramView);
    
    public abstract ColorStateList z(View paramView);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/j/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */