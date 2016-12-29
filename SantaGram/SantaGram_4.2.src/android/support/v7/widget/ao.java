package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.g.g;
import android.support.v4.j.a.a;
import android.support.v4.j.a.c;
import android.support.v4.j.a.c.j;
import android.support.v4.j.a.c.k;
import android.support.v4.j.a.k;
import android.support.v4.j.ab;
import android.support.v4.j.ad;
import android.support.v4.j.aq;
import android.support.v4.j.s;
import android.support.v4.j.w;
import android.support.v4.j.x;
import android.support.v4.widget.h;
import android.support.v4.widget.u;
import android.support.v7.d.a.a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ao
  extends ViewGroup
  implements ab, w
{
  static final boolean a;
  private static final Interpolator aq;
  private static final int[] k = { 16843830 };
  private static final boolean l;
  private static final Class<?>[] m;
  private int A = 0;
  private boolean B;
  private boolean C;
  private boolean D;
  private int E;
  private boolean F;
  private final boolean G;
  private final AccessibilityManager H;
  private List<j> I;
  private boolean J = false;
  private int K = 0;
  private h L;
  private h M;
  private h N;
  private h O;
  private int P = 0;
  private int Q = -1;
  private VelocityTracker R;
  private int S;
  private int T;
  private int U;
  private int V;
  private int W;
  private final int aa;
  private final int ab;
  private float ac = Float.MIN_VALUE;
  private final u ad = new u();
  private l ae;
  private List<l> af;
  private ao.e.b ag = new f(null);
  private boolean ah = false;
  private ap ai;
  private d aj;
  private final int[] ak = new int[2];
  private x al;
  private final int[] am = new int[2];
  private final int[] an = new int[2];
  private final int[] ao = new int[2];
  private Runnable ap = new Runnable()
  {
    public void run()
    {
      if (ao.this.g != null) {
        ao.this.g.a();
      }
      ao.b(ao.this, false);
    }
  };
  private final be.b ar = new be.b()
  {
    public void a(ao.v paramAnonymousv)
    {
      ao.this.f.a(paramAnonymousv.a, ao.this.b);
    }
    
    public void a(ao.v paramAnonymousv, ao.e.c paramAnonymousc1, ao.e.c paramAnonymousc2)
    {
      ao.this.b.d(paramAnonymousv);
      ao.a(ao.this, paramAnonymousv, paramAnonymousc1, paramAnonymousc2);
    }
    
    public void b(ao.v paramAnonymousv, ao.e.c paramAnonymousc1, ao.e.c paramAnonymousc2)
    {
      ao.b(ao.this, paramAnonymousv, paramAnonymousc1, paramAnonymousc2);
    }
    
    public void c(ao.v paramAnonymousv, ao.e.c paramAnonymousc1, ao.e.c paramAnonymousc2)
    {
      paramAnonymousv.a(false);
      if (ao.d(ao.this)) {
        if (ao.this.g.a(paramAnonymousv, paramAnonymousv, paramAnonymousc1, paramAnonymousc2)) {
          ao.e(ao.this);
        }
      }
      while (!ao.this.g.c(paramAnonymousv, paramAnonymousc1, paramAnonymousc2)) {
        return;
      }
      ao.e(ao.this);
    }
  };
  final n b = new n();
  f c;
  ac d;
  final be e = new be();
  h f;
  e g = new af();
  final s h = new s();
  boolean i = false;
  boolean j = false;
  private final p n = new p(null);
  private q o;
  private boolean p;
  private final Runnable q = new Runnable()
  {
    public void run()
    {
      if ((!ao.a(ao.this)) || (ao.this.isLayoutRequested())) {
        return;
      }
      if (ao.b(ao.this))
      {
        ao.a(ao.this, true);
        return;
      }
      ao.c(ao.this);
    }
  };
  private final Rect r = new Rect();
  private a s;
  private o t;
  private final ArrayList<g> u = new ArrayList();
  private final ArrayList<k> v = new ArrayList();
  private k w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  static
  {
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20))
    {
      bool = true;
      l = bool;
      if (Build.VERSION.SDK_INT < 23) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      m = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
      aq = new Interpolator()
      {
        public float getInterpolation(float paramAnonymousFloat)
        {
          paramAnonymousFloat -= 1.0F;
          return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
        }
      };
      return;
      bool = false;
      break;
    }
  }
  
  public ao(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ao(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ao(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setScrollContainer(true);
    setFocusableInTouchMode(true);
    Object localObject;
    if (Build.VERSION.SDK_INT >= 16)
    {
      bool1 = true;
      this.G = bool1;
      localObject = ViewConfiguration.get(paramContext);
      this.W = ((ViewConfiguration)localObject).getScaledTouchSlop();
      this.aa = ((ViewConfiguration)localObject).getScaledMinimumFlingVelocity();
      this.ab = ((ViewConfiguration)localObject).getScaledMaximumFlingVelocity();
      if (android.support.v4.j.af.a(this) != 2) {
        break label467;
      }
    }
    label467:
    for (boolean bool1 = true;; bool1 = false)
    {
      setWillNotDraw(bool1);
      this.g.a(this.ag);
      a();
      s();
      if (android.support.v4.j.af.e(this) == 0) {
        android.support.v4.j.af.c(this, 1);
      }
      this.H = ((AccessibilityManager)getContext().getSystemService("accessibility"));
      setAccessibilityDelegateCompat(new ap(this));
      bool1 = bool2;
      if (paramAttributeSet != null)
      {
        localObject = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RecyclerView, paramInt, 0);
        String str = ((TypedArray)localObject).getString(a.a.RecyclerView_layoutManager);
        ((TypedArray)localObject).recycle();
        a(paramContext, str, paramAttributeSet, paramInt, 0);
        bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k, paramInt, 0);
          bool1 = paramContext.getBoolean(0, true);
          paramContext.recycle();
        }
      }
      setNestedScrollingEnabled(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void A()
  {
    this.K -= 1;
    if (this.K < 1)
    {
      this.K = 0;
      B();
    }
  }
  
  private void B()
  {
    int i1 = this.E;
    this.E = 0;
    if ((i1 != 0) && (i()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      localAccessibilityEvent.setEventType(2048);
      a.a(localAccessibilityEvent, i1);
      sendAccessibilityEventUnchecked(localAccessibilityEvent);
    }
  }
  
  private void C()
  {
    if ((!this.ah) && (this.x))
    {
      android.support.v4.j.af.a(this, this.ap);
      this.ah = true;
    }
  }
  
  private boolean D()
  {
    return (this.g != null) && (this.f.b());
  }
  
  private void E()
  {
    boolean bool2 = true;
    if (this.J)
    {
      this.c.a();
      o();
      this.f.a(this);
    }
    int i1;
    label59:
    s locals;
    if (D())
    {
      this.c.b();
      if ((!this.i) && (!this.j)) {
        break label177;
      }
      i1 = 1;
      locals = this.h;
      if ((!this.z) || (this.g == null) || ((!this.J) && (i1 == 0) && (!h.b(this.f))) || ((this.J) && (!this.s.b()))) {
        break label182;
      }
      bool1 = true;
      label118:
      s.d(locals, bool1);
      locals = this.h;
      if ((!s.c(this.h)) || (i1 == 0) || (this.J) || (!D())) {
        break label187;
      }
    }
    label177:
    label182:
    label187:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      s.e(locals, bool1);
      return;
      this.c.e();
      break;
      i1 = 0;
      break label59;
      bool1 = false;
      break label118;
    }
  }
  
  private void F()
  {
    boolean bool = true;
    this.h.a(1);
    s.b(this.h, false);
    b();
    this.e.a();
    z();
    E();
    Object localObject = this.h;
    int i2;
    int i1;
    if ((s.c(this.h)) && (this.j))
    {
      s.f((s)localObject, bool);
      this.j = false;
      this.i = false;
      s.c(this.h, s.b(this.h));
      this.h.a = this.s.a();
      a(this.ak);
      if (!s.c(this.h)) {
        break label279;
      }
      i2 = this.d.b();
      i1 = 0;
      label136:
      if (i1 >= i2) {
        break label279;
      }
      localObject = c(this.d.b(i1));
      if ((!((v)localObject).c()) && ((!((v)localObject).n()) || (this.s.b()))) {
        break label191;
      }
    }
    label191:
    ao.e.c localc;
    for (;;)
    {
      i1 += 1;
      break label136;
      bool = false;
      break;
      localc = this.g.a(this.h, (v)localObject, e.d((v)localObject), ((v)localObject).u());
      this.e.a((v)localObject, localc);
      if ((s.d(this.h)) && (((v)localObject).x()) && (!((v)localObject).q()) && (!((v)localObject).c()) && (!((v)localObject).n()))
      {
        long l1 = a((v)localObject);
        this.e.a(l1, (v)localObject);
      }
    }
    label279:
    if (s.b(this.h))
    {
      m();
      bool = s.e(this.h);
      s.a(this.h, false);
      this.f.c(this.b, this.h);
      s.a(this.h, bool);
      i1 = 0;
      if (i1 < this.d.b())
      {
        localObject = c(this.d.b(i1));
        if (((v)localObject).c()) {}
        for (;;)
        {
          i1 += 1;
          break;
          if (!this.e.d((v)localObject))
          {
            int i3 = e.d((v)localObject);
            bool = ((v)localObject).a(8192);
            i2 = i3;
            if (!bool) {
              i2 = i3 | 0x1000;
            }
            localc = this.g.a(this.h, (v)localObject, i2, ((v)localObject).u());
            if (bool) {
              a((v)localObject, localc);
            } else {
              this.e.b((v)localObject, localc);
            }
          }
        }
      }
      n();
    }
    for (;;)
    {
      A();
      a(false);
      s.b(this.h, 2);
      return;
      n();
    }
  }
  
  private void G()
  {
    b();
    z();
    this.h.a(6);
    this.c.e();
    this.h.a = this.s.a();
    s.c(this.h, 0);
    s.c(this.h, false);
    this.f.c(this.b, this.h);
    s.a(this.h, false);
    this.o = null;
    s locals = this.h;
    if ((s.c(this.h)) && (this.g != null)) {}
    for (boolean bool = true;; bool = false)
    {
      s.d(locals, bool);
      s.b(this.h, 4);
      A();
      a(false);
      return;
    }
  }
  
  private void H()
  {
    this.h.a(4);
    b();
    z();
    s.b(this.h, 1);
    if (s.c(this.h))
    {
      int i1 = this.d.b() - 1;
      if (i1 >= 0)
      {
        v localv1 = c(this.d.b(i1));
        if (localv1.c()) {}
        for (;;)
        {
          i1 -= 1;
          break;
          long l1 = a(localv1);
          ao.e.c localc2 = this.g.a(this.h, localv1);
          v localv2 = this.e.a(l1);
          if ((localv2 != null) && (!localv2.c()))
          {
            boolean bool1 = this.e.a(localv2);
            boolean bool2 = this.e.a(localv1);
            if ((bool1) && (localv2 == localv1))
            {
              this.e.c(localv1, localc2);
            }
            else
            {
              ao.e.c localc1 = this.e.b(localv2);
              this.e.c(localv1, localc2);
              localc2 = this.e.c(localv1);
              if (localc1 == null) {
                a(l1, localv1, localv2);
              } else {
                a(localv2, localv1, localc1, localc2, bool1, bool2);
              }
            }
          }
          else
          {
            this.e.c(localv1, localc2);
          }
        }
      }
      this.e.a(this.ar);
    }
    this.f.b(this.b);
    s.d(this.h, this.h.a);
    this.J = false;
    s.d(this.h, false);
    s.e(this.h, false);
    h.a(this.f, false);
    if (n.a(this.b) != null) {
      n.a(this.b).clear();
    }
    A();
    a(false);
    this.e.a();
    if (j(this.ak[0], this.ak[1])) {
      h(0, 0);
    }
  }
  
  private void I()
  {
    int i2 = this.d.b();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = this.d.b(i1);
      Object localObject = a(localView);
      if ((localObject != null) && (((v)localObject).h != null))
      {
        localObject = ((v)localObject).h.a;
        int i3 = localView.getLeft();
        int i4 = localView.getTop();
        if ((i3 != ((View)localObject).getLeft()) || (i4 != ((View)localObject).getTop())) {
          ((View)localObject).layout(i3, i4, ((View)localObject).getWidth() + i3, ((View)localObject).getHeight() + i4);
        }
      }
      i1 += 1;
    }
  }
  
  private String a(Context paramContext, String paramString)
  {
    if (paramString.charAt(0) == '.') {
      paramContext = paramContext.getPackageName() + paramString;
    }
    do
    {
      return paramContext;
      paramContext = paramString;
    } while (paramString.contains("."));
    return ao.class.getPackage().getName() + '.' + paramString;
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i2 = 1;
    int i3 = 0;
    int i1;
    if (paramFloat2 < 0.0F)
    {
      d();
      i1 = i3;
      if (this.L.a(-paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight())) {
        i1 = 1;
      }
      if (paramFloat4 >= 0.0F) {
        break label158;
      }
      f();
      if (!this.M.a(-paramFloat4 / getHeight(), paramFloat1 / getWidth())) {
        break label196;
      }
    }
    for (;;)
    {
      if ((i2 != 0) || (paramFloat2 != 0.0F) || (paramFloat4 != 0.0F)) {
        android.support.v4.j.af.d(this);
      }
      return;
      i1 = i3;
      if (paramFloat2 <= 0.0F) {
        break;
      }
      e();
      i1 = i3;
      if (!this.N.a(paramFloat2 / getWidth(), paramFloat3 / getHeight())) {
        break;
      }
      i1 = 1;
      break;
      label158:
      if (paramFloat4 > 0.0F)
      {
        g();
        if (this.O.a(paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth())) {}
      }
      else
      {
        label196:
        i2 = i1;
      }
    }
  }
  
  private void a(long paramLong, v paramv1, v paramv2)
  {
    int i2 = this.d.b();
    int i1 = 0;
    if (i1 < i2)
    {
      v localv = c(this.d.b(i1));
      if (localv == paramv1) {}
      while (a(localv) != paramLong)
      {
        i1 += 1;
        break;
      }
      if ((this.s != null) && (this.s.b())) {
        throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + localv + " \n View Holder 2:" + paramv1);
      }
      throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + localv + " \n View Holder 2:" + paramv1);
    }
    Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + paramv2 + " cannot be found but it is necessary for " + paramv1);
  }
  
  private void a(Context paramContext, String paramString, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      paramString = paramString.trim();
      if (paramString.length() != 0)
      {
        String str = a(paramContext, paramString);
        try
        {
          if (isInEditMode()) {}
          Class localClass;
          for (paramString = getClass().getClassLoader();; paramString = paramContext.getClassLoader())
          {
            localClass = paramString.loadClass(str).asSubclass(h.class);
            try
            {
              paramString = localClass.getConstructor(m);
              Object[] arrayOfObject = new Object[4];
              arrayOfObject[0] = paramContext;
              arrayOfObject[1] = paramAttributeSet;
              arrayOfObject[2] = Integer.valueOf(paramInt1);
              arrayOfObject[3] = Integer.valueOf(paramInt2);
              paramContext = arrayOfObject;
            }
            catch (NoSuchMethodException paramContext)
            {
              try
              {
                paramString = localClass.getConstructor(new Class[0]);
                paramContext = null;
              }
              catch (NoSuchMethodException paramString)
              {
                paramString.initCause(paramContext);
                throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, paramString);
              }
            }
            paramString.setAccessible(true);
            setLayoutManager((h)paramString.newInstance(paramContext));
            return;
          }
          return;
        }
        catch (ClassNotFoundException paramContext)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, paramContext);
        }
        catch (InvocationTargetException paramContext)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, paramContext);
        }
        catch (InstantiationException paramContext)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, paramContext);
        }
        catch (IllegalAccessException paramContext)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, paramContext);
        }
        catch (ClassCastException paramContext)
        {
          throw new IllegalStateException(paramAttributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, paramContext);
        }
      }
    }
  }
  
  private void a(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.s != null)
    {
      this.s.b(this.n);
      this.s.b(this);
    }
    if ((!paramBoolean1) || (paramBoolean2))
    {
      if (this.g != null) {
        this.g.c();
      }
      if (this.f != null)
      {
        this.f.c(this.b);
        this.f.b(this.b);
      }
      this.b.a();
    }
    this.c.a();
    a locala = this.s;
    this.s = parama;
    if (parama != null)
    {
      parama.a(this.n);
      parama.a(this);
    }
    if (this.f != null) {
      this.f.a(locala, this.s);
    }
    this.b.a(locala, this.s, paramBoolean1);
    s.a(this.h, true);
    o();
  }
  
  private void a(v paramv, ao.e.c paramc)
  {
    paramv.a(0, 8192);
    if ((s.d(this.h)) && (paramv.x()) && (!paramv.q()) && (!paramv.c()))
    {
      long l1 = a(paramv);
      this.e.a(l1, paramv);
    }
    this.e.a(paramv, paramc);
  }
  
  private void a(v paramv, ao.e.c paramc1, ao.e.c paramc2)
  {
    paramv.a(false);
    if (this.g.b(paramv, paramc1, paramc2)) {
      C();
    }
  }
  
  private void a(v paramv1, v paramv2, ao.e.c paramc1, ao.e.c paramc2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramv1.a(false);
    if (paramBoolean1) {
      b(paramv1);
    }
    if (paramv1 != paramv2)
    {
      if (paramBoolean2) {
        b(paramv2);
      }
      paramv1.g = paramv2;
      b(paramv1);
      this.b.d(paramv1);
      paramv2.a(false);
      paramv2.h = paramv1;
    }
    if (this.g.a(paramv1, paramv2, paramc1, paramc2)) {
      C();
    }
  }
  
  private void a(int[] paramArrayOfInt)
  {
    int i6 = this.d.b();
    if (i6 == 0)
    {
      paramArrayOfInt[0] = 0;
      paramArrayOfInt[1] = 0;
      return;
    }
    int i1 = Integer.MAX_VALUE;
    int i4 = Integer.MIN_VALUE;
    int i3 = 0;
    v localv;
    if (i3 < i6)
    {
      localv = c(this.d.b(i3));
      if (!localv.c()) {}
    }
    for (;;)
    {
      i3 += 1;
      break;
      int i5 = localv.d();
      int i2 = i1;
      if (i5 < i1) {
        i2 = i5;
      }
      if (i5 > i4)
      {
        i4 = i5;
        i1 = i2;
        continue;
        paramArrayOfInt[0] = i1;
        paramArrayOfInt[1] = i4;
      }
      else
      {
        i1 = i2;
      }
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getAction();
    if ((i2 == 3) || (i2 == 0)) {
      this.w = null;
    }
    int i3 = this.v.size();
    int i1 = 0;
    while (i1 < i3)
    {
      k localk = (k)this.v.get(i1);
      if ((localk.a(this, paramMotionEvent)) && (i2 != 3))
      {
        this.w = localk;
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private void b(v paramv)
  {
    View localView = paramv.a;
    if (localView.getParent() == this) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.b.d(a(localView));
      if (!paramv.r()) {
        break;
      }
      this.d.a(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (i1 == 0)
    {
      this.d.a(localView, true);
      return;
    }
    this.d.d(localView);
  }
  
  private void b(v paramv, ao.e.c paramc1, ao.e.c paramc2)
  {
    b(paramv);
    paramv.a(false);
    if (this.g.a(paramv, paramc1, paramc2)) {
      C();
    }
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    int i2;
    if (this.w != null)
    {
      if (i1 == 0) {
        this.w = null;
      }
    }
    else
    {
      if (i1 == 0) {
        break label107;
      }
      i2 = this.v.size();
      i1 = 0;
    }
    while (i1 < i2)
    {
      k localk = (k)this.v.get(i1);
      if (localk.a(this, paramMotionEvent))
      {
        this.w = localk;
        return true;
        this.w.b(this, paramMotionEvent);
        if ((i1 == 3) || (i1 == 1)) {
          this.w = null;
        }
        return true;
      }
      i1 += 1;
    }
    label107:
    return false;
  }
  
  static v c(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((i)paramView.getLayoutParams()).a;
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    int i1 = s.b(paramMotionEvent);
    if (s.b(paramMotionEvent, i1) == this.Q) {
      if (i1 != 0) {
        break label75;
      }
    }
    label75:
    for (i1 = 1;; i1 = 0)
    {
      this.Q = s.b(paramMotionEvent, i1);
      int i2 = (int)(s.c(paramMotionEvent, i1) + 0.5F);
      this.U = i2;
      this.S = i2;
      i1 = (int)(s.d(paramMotionEvent, i1) + 0.5F);
      this.V = i1;
      this.T = i1;
      return;
    }
  }
  
  private boolean c(v paramv)
  {
    return (this.g == null) || (this.g.a(paramv, paramv.u()));
  }
  
  private int d(v paramv)
  {
    if ((paramv.a(524)) || (!paramv.p())) {
      return -1;
    }
    return this.c.c(paramv.b);
  }
  
  private void e(int paramInt)
  {
    if (this.f == null) {
      return;
    }
    this.f.d(paramInt);
    awakenScrollBars();
  }
  
  private float getScrollFactor()
  {
    if (this.ac == Float.MIN_VALUE)
    {
      TypedValue localTypedValue = new TypedValue();
      if (getContext().getTheme().resolveAttribute(16842829, localTypedValue, true)) {
        this.ac = localTypedValue.getDimension(getContext().getResources().getDisplayMetrics());
      }
    }
    else
    {
      return this.ac;
    }
    return 0.0F;
  }
  
  private x getScrollingChildHelper()
  {
    if (this.al == null) {
      this.al = new x(this);
    }
    return this.al;
  }
  
  private boolean h(View paramView)
  {
    b();
    boolean bool2 = this.d.f(paramView);
    if (bool2)
    {
      paramView = c(paramView);
      this.b.d(paramView);
      this.b.b(paramView);
    }
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a(bool1);
      return bool2;
    }
  }
  
  private void i(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.L != null)
    {
      bool1 = bool2;
      if (!this.L.a())
      {
        bool1 = bool2;
        if (paramInt1 > 0) {
          bool1 = this.L.b();
        }
      }
    }
    bool2 = bool1;
    if (this.N != null)
    {
      bool2 = bool1;
      if (!this.N.a())
      {
        bool2 = bool1;
        if (paramInt1 < 0) {
          bool2 = bool1 | this.N.b();
        }
      }
    }
    bool1 = bool2;
    if (this.M != null)
    {
      bool1 = bool2;
      if (!this.M.a())
      {
        bool1 = bool2;
        if (paramInt2 > 0) {
          bool1 = bool2 | this.M.b();
        }
      }
    }
    bool2 = bool1;
    if (this.O != null)
    {
      bool2 = bool1;
      if (!this.O.a())
      {
        bool2 = bool1;
        if (paramInt2 < 0) {
          bool2 = bool1 | this.O.b();
        }
      }
    }
    if (bool2) {
      android.support.v4.j.af.d(this);
    }
  }
  
  private void i(View paramView)
  {
    v localv = c(paramView);
    f(paramView);
    if ((this.s != null) && (localv != null)) {
      this.s.d(localv);
    }
    if (this.I != null)
    {
      int i1 = this.I.size() - 1;
      while (i1 >= 0)
      {
        ((j)this.I.get(i1)).b(paramView);
        i1 -= 1;
      }
    }
  }
  
  private void j(View paramView)
  {
    v localv = c(paramView);
    e(paramView);
    if ((this.s != null) && (localv != null)) {
      this.s.c(localv);
    }
    if (this.I != null)
    {
      int i1 = this.I.size() - 1;
      while (i1 >= 0)
      {
        ((j)this.I.get(i1)).a(paramView);
        i1 -= 1;
      }
    }
  }
  
  private boolean j(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (this.d.b() == 0) {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        bool = true;
      }
    }
    do
    {
      return bool;
      a(this.ak);
    } while ((this.ak[0] == paramInt1) && (this.ak[1] == paramInt2));
    return true;
  }
  
  private void s()
  {
    this.d = new ac(new ac.b()
    {
      public int a()
      {
        return ao.this.getChildCount();
      }
      
      public int a(View paramAnonymousView)
      {
        return ao.this.indexOfChild(paramAnonymousView);
      }
      
      public void a(int paramAnonymousInt)
      {
        View localView = ao.this.getChildAt(paramAnonymousInt);
        if (localView != null) {
          ao.b(ao.this, localView);
        }
        ao.this.removeViewAt(paramAnonymousInt);
      }
      
      public void a(View paramAnonymousView, int paramAnonymousInt)
      {
        ao.this.addView(paramAnonymousView, paramAnonymousInt);
        ao.a(ao.this, paramAnonymousView);
      }
      
      public void a(View paramAnonymousView, int paramAnonymousInt, ViewGroup.LayoutParams paramAnonymousLayoutParams)
      {
        ao.v localv = ao.c(paramAnonymousView);
        if (localv != null)
        {
          if ((!localv.r()) && (!localv.c())) {
            throw new IllegalArgumentException("Called attach on a child which is not detached: " + localv);
          }
          localv.m();
        }
        ao.a(ao.this, paramAnonymousView, paramAnonymousInt, paramAnonymousLayoutParams);
      }
      
      public ao.v b(View paramAnonymousView)
      {
        return ao.c(paramAnonymousView);
      }
      
      public View b(int paramAnonymousInt)
      {
        return ao.this.getChildAt(paramAnonymousInt);
      }
      
      public void b()
      {
        int j = a();
        int i = 0;
        while (i < j)
        {
          ao.b(ao.this, b(i));
          i += 1;
        }
        ao.this.removeAllViews();
      }
      
      public void c(int paramAnonymousInt)
      {
        Object localObject = b(paramAnonymousInt);
        if (localObject != null)
        {
          localObject = ao.c((View)localObject);
          if (localObject != null)
          {
            if ((((ao.v)localObject).r()) && (!((ao.v)localObject).c())) {
              throw new IllegalArgumentException("called detach on an already detached child " + localObject);
            }
            ((ao.v)localObject).b(256);
          }
        }
        ao.a(ao.this, paramAnonymousInt);
      }
      
      public void c(View paramAnonymousView)
      {
        paramAnonymousView = ao.c(paramAnonymousView);
        if (paramAnonymousView != null) {
          ao.v.a(paramAnonymousView);
        }
      }
      
      public void d(View paramAnonymousView)
      {
        paramAnonymousView = ao.c(paramAnonymousView);
        if (paramAnonymousView != null) {
          ao.v.b(paramAnonymousView);
        }
      }
    });
  }
  
  private void setScrollState(int paramInt)
  {
    if (paramInt == this.P) {
      return;
    }
    this.P = paramInt;
    if (paramInt != 2) {
      v();
    }
    d(paramInt);
  }
  
  private void t()
  {
    if (!this.z) {}
    label106:
    do
    {
      do
      {
        return;
        if (this.J)
        {
          g.a("RV FullInvalidate");
          k();
          g.a();
          return;
        }
      } while (!this.c.d());
      if ((this.c.a(4)) && (!this.c.a(11)))
      {
        g.a("RV PartialInvalidate");
        b();
        this.c.b();
        if (!this.B)
        {
          if (!u()) {
            break label106;
          }
          k();
        }
        for (;;)
        {
          a(true);
          g.a();
          return;
          this.c.c();
        }
      }
    } while (!this.c.d());
    g.a("RV FullInvalidate");
    k();
    g.a();
  }
  
  private boolean u()
  {
    boolean bool2 = false;
    int i2 = this.d.b();
    int i1 = 0;
    boolean bool1 = bool2;
    if (i1 < i2)
    {
      v localv = c(this.d.b(i1));
      if ((localv == null) || (localv.c())) {}
      while (!localv.x())
      {
        i1 += 1;
        break;
      }
      bool1 = true;
    }
    return bool1;
  }
  
  private void v()
  {
    this.ad.b();
    if (this.f != null) {
      this.f.F();
    }
  }
  
  private void w()
  {
    boolean bool2 = false;
    if (this.L != null) {
      bool2 = this.L.b();
    }
    boolean bool1 = bool2;
    if (this.M != null) {
      bool1 = bool2 | this.M.b();
    }
    bool2 = bool1;
    if (this.N != null) {
      bool2 = bool1 | this.N.b();
    }
    bool1 = bool2;
    if (this.O != null) {
      bool1 = bool2 | this.O.b();
    }
    if (bool1) {
      android.support.v4.j.af.d(this);
    }
  }
  
  private void x()
  {
    if (this.R != null) {
      this.R.clear();
    }
    stopNestedScroll();
    w();
  }
  
  private void y()
  {
    x();
    setScrollState(0);
  }
  
  private void z()
  {
    this.K += 1;
  }
  
  long a(v paramv)
  {
    if (this.s.b()) {
      return paramv.g();
    }
    return paramv.b;
  }
  
  v a(int paramInt, boolean paramBoolean)
  {
    int i2 = this.d.c();
    int i1 = 0;
    while (i1 < i2)
    {
      v localv = c(this.d.c(i1));
      if ((localv != null) && (!localv.q())) {
        if (paramBoolean)
        {
          if (localv.b != paramInt) {}
        }
        else {
          while (localv.d() == paramInt) {
            return localv;
          }
        }
      }
      i1 += 1;
    }
    return null;
  }
  
  public v a(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this)) {
      throw new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
    }
    return c(paramView);
  }
  
  void a()
  {
    this.c = new f(new f.a()
    {
      public ao.v a(int paramAnonymousInt)
      {
        ao.v localv = ao.this.a(paramAnonymousInt, true);
        if (localv == null) {}
        while (ao.this.d.c(localv.a)) {
          return null;
        }
        return localv;
      }
      
      public void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        ao.this.a(paramAnonymousInt1, paramAnonymousInt2, true);
        ao.this.i = true;
        ao.s.a(ao.this.h, paramAnonymousInt2);
      }
      
      public void a(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        ao.this.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        ao.this.j = true;
      }
      
      public void a(f.b paramAnonymousb)
      {
        c(paramAnonymousb);
      }
      
      public void b(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        ao.this.a(paramAnonymousInt1, paramAnonymousInt2, false);
        ao.this.i = true;
      }
      
      public void b(f.b paramAnonymousb)
      {
        c(paramAnonymousb);
      }
      
      public void c(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        ao.this.f(paramAnonymousInt1, paramAnonymousInt2);
        ao.this.i = true;
      }
      
      void c(f.b paramAnonymousb)
      {
        switch (paramAnonymousb.a)
        {
        case 3: 
        case 5: 
        case 6: 
        case 7: 
        default: 
          return;
        case 1: 
          ao.this.f.a(ao.this, paramAnonymousb.b, paramAnonymousb.d);
          return;
        case 2: 
          ao.this.f.b(ao.this, paramAnonymousb.b, paramAnonymousb.d);
          return;
        case 4: 
          ao.this.f.a(ao.this, paramAnonymousb.b, paramAnonymousb.d, paramAnonymousb.c);
          return;
        }
        ao.this.f.a(ao.this, paramAnonymousb.b, paramAnonymousb.d, 1);
      }
      
      public void d(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        ao.this.e(paramAnonymousInt1, paramAnonymousInt2);
        ao.this.i = true;
      }
    });
  }
  
  public void a(int paramInt)
  {
    int i2 = this.d.b();
    int i1 = 0;
    while (i1 < i2)
    {
      this.d.b(i1).offsetTopAndBottom(paramInt);
      i1 += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (this.f == null) {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    }
    for (;;)
    {
      return;
      if (!this.C)
      {
        if (!this.f.d()) {
          paramInt1 = 0;
        }
        if (!this.f.e()) {
          paramInt2 = i1;
        }
        while ((paramInt1 != 0) || (paramInt2 != 0))
        {
          this.ad.b(paramInt1, paramInt2);
          return;
        }
      }
    }
  }
  
  void a(int paramInt1, int paramInt2, Object paramObject)
  {
    int i2 = this.d.c();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = this.d.c(i1);
      v localv = c(localView);
      if ((localv == null) || (localv.c())) {}
      for (;;)
      {
        i1 += 1;
        break;
        if ((localv.b >= paramInt1) && (localv.b < paramInt1 + paramInt2))
        {
          localv.b(2);
          localv.a(paramObject);
          ((i)localView.getLayoutParams()).c = true;
        }
      }
    }
    this.b.c(paramInt1, paramInt2);
  }
  
  void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = this.d.c();
    int i1 = 0;
    if (i1 < i2)
    {
      v localv = c(this.d.c(i1));
      if ((localv != null) && (!localv.c()))
      {
        if (localv.b < paramInt1 + paramInt2) {
          break label83;
        }
        localv.a(-paramInt2, paramBoolean);
        s.a(this.h, true);
      }
      for (;;)
      {
        i1 += 1;
        break;
        label83:
        if (localv.b >= paramInt1)
        {
          localv.a(paramInt1 - 1, -paramInt2, paramBoolean);
          s.a(this.h, true);
        }
      }
    }
    this.b.b(paramInt1, paramInt2, paramBoolean);
    requestLayout();
  }
  
  void a(String paramString)
  {
    if (j())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
      }
      throw new IllegalStateException(paramString);
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (this.A < 1) {
      this.A = 1;
    }
    if (!paramBoolean) {
      this.B = false;
    }
    if (this.A == 1)
    {
      if ((paramBoolean) && (this.B) && (!this.C) && (this.f != null) && (this.s != null)) {
        k();
      }
      if (!this.C) {
        this.B = false;
      }
    }
    this.A -= 1;
  }
  
  boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    t();
    int i2;
    int i1;
    int i3;
    int i4;
    if (this.s != null)
    {
      b();
      z();
      g.a("RV Scroll");
      if (paramInt1 != 0)
      {
        i2 = this.f.a(paramInt1, this.b, this.h);
        i1 = paramInt1 - i2;
        if (paramInt2 != 0)
        {
          i3 = this.f.b(paramInt2, this.b, this.h);
          i4 = paramInt2 - i3;
          label84:
          g.a();
          I();
          A();
          a(false);
          int i5 = i3;
          i3 = i1;
          i1 = i5;
        }
      }
    }
    for (;;)
    {
      if (!this.u.isEmpty()) {
        invalidate();
      }
      if (dispatchNestedScroll(i2, i1, i3, i4, this.am))
      {
        this.U -= this.am[0];
        this.V -= this.am[1];
        if (paramMotionEvent != null) {
          paramMotionEvent.offsetLocation(this.am[0], this.am[1]);
        }
        paramMotionEvent = this.ao;
        paramMotionEvent[0] += this.am[0];
        paramMotionEvent = this.ao;
        paramMotionEvent[1] += this.am[1];
      }
      for (;;)
      {
        if ((i2 != 0) || (i1 != 0)) {
          h(i2, i1);
        }
        if (!awakenScrollBars()) {
          invalidate();
        }
        if ((i2 != 0) || (i1 != 0)) {
          bool = true;
        }
        return bool;
        if (android.support.v4.j.af.a(this) != 2)
        {
          if (paramMotionEvent != null) {
            a(paramMotionEvent.getX(), i3, paramMotionEvent.getY(), i4);
          }
          i(paramInt1, paramInt2);
        }
      }
      i3 = 0;
      i4 = 0;
      break label84;
      i2 = 0;
      i1 = 0;
      break;
      i1 = 0;
      i2 = 0;
      i4 = 0;
      i3 = 0;
    }
  }
  
  boolean a(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool = false;
    int i2 = 0;
    if (j()) {
      if (paramAccessibilityEvent == null) {
        break label46;
      }
    }
    label46:
    for (int i1 = a.b(paramAccessibilityEvent);; i1 = 0)
    {
      if (i1 == 0) {
        i1 = i2;
      }
      for (;;)
      {
        this.E = (i1 | this.E);
        bool = true;
        return bool;
      }
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((this.f == null) || (!this.f.a(this, paramArrayList, paramInt1, paramInt2))) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
  }
  
  public View b(View paramView)
  {
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent != null) && (localViewParent != this) && ((localViewParent instanceof View)); localViewParent = paramView.getParent()) {
      paramView = (View)localViewParent;
    }
    if (localViewParent == this) {
      return paramView;
    }
    return null;
  }
  
  void b()
  {
    this.A += 1;
    if ((this.A == 1) && (!this.C)) {
      this.B = false;
    }
  }
  
  public void b(int paramInt)
  {
    int i2 = this.d.b();
    int i1 = 0;
    while (i1 < i2)
    {
      this.d.b(i1).offsetLeftAndRight(paramInt);
      i1 += 1;
    }
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    if (this.f == null) {
      Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    }
    boolean bool2;
    int i1;
    do
    {
      do
      {
        return false;
      } while (this.C);
      bool1 = this.f.d();
      bool2 = this.f.e();
      if (bool1)
      {
        i1 = paramInt1;
        if (Math.abs(paramInt1) >= this.aa) {}
      }
      else
      {
        i1 = 0;
      }
      if (bool2)
      {
        paramInt1 = paramInt2;
        if (Math.abs(paramInt2) >= this.aa) {}
      }
      else
      {
        paramInt1 = 0;
      }
    } while (((i1 == 0) && (paramInt1 == 0)) || (dispatchNestedPreFling(i1, paramInt1)));
    if ((bool1) || (bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      dispatchNestedFling(i1, paramInt1, bool1);
      if (!bool1) {
        break;
      }
      paramInt2 = Math.max(-this.ab, Math.min(i1, this.ab));
      paramInt1 = Math.max(-this.ab, Math.min(paramInt1, this.ab));
      this.ad.a(paramInt2, paramInt1);
      return true;
    }
  }
  
  public void c()
  {
    setScrollState(0);
    v();
  }
  
  public void c(int paramInt) {}
  
  void c(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      d();
      this.L.a(-paramInt1);
      if (paramInt2 >= 0) {
        break label69;
      }
      f();
      this.M.a(-paramInt2);
    }
    for (;;)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        android.support.v4.j.af.d(this);
      }
      return;
      if (paramInt1 <= 0) {
        break;
      }
      e();
      this.N.a(paramInt1);
      break;
      label69:
      if (paramInt2 > 0)
      {
        g();
        this.O.a(paramInt2);
      }
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof i)) && (this.f.a((i)paramLayoutParams));
  }
  
  public int computeHorizontalScrollExtent()
  {
    if (this.f == null) {}
    while (!this.f.d()) {
      return 0;
    }
    return this.f.d(this.h);
  }
  
  public int computeHorizontalScrollOffset()
  {
    if (this.f == null) {}
    while (!this.f.d()) {
      return 0;
    }
    return this.f.b(this.h);
  }
  
  public int computeHorizontalScrollRange()
  {
    if (this.f == null) {}
    while (!this.f.d()) {
      return 0;
    }
    return this.f.f(this.h);
  }
  
  public int computeVerticalScrollExtent()
  {
    if (this.f == null) {}
    while (!this.f.e()) {
      return 0;
    }
    return this.f.e(this.h);
  }
  
  public int computeVerticalScrollOffset()
  {
    if (this.f == null) {}
    while (!this.f.e()) {
      return 0;
    }
    return this.f.c(this.h);
  }
  
  public int computeVerticalScrollRange()
  {
    if (this.f == null) {}
    while (!this.f.e()) {
      return 0;
    }
    return this.f.g(this.h);
  }
  
  public int d(View paramView)
  {
    paramView = c(paramView);
    if (paramView != null) {
      return paramView.d();
    }
    return -1;
  }
  
  void d()
  {
    if (this.L != null) {
      return;
    }
    this.L = new h(getContext());
    if (this.p)
    {
      this.L.a(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.L.a(getMeasuredHeight(), getMeasuredWidth());
  }
  
  void d(int paramInt)
  {
    if (this.f != null) {
      this.f.k(paramInt);
    }
    c(paramInt);
    if (this.ae != null) {
      this.ae.a(this, paramInt);
    }
    if (this.af != null)
    {
      int i1 = this.af.size() - 1;
      while (i1 >= 0)
      {
        ((l)this.af.get(i1)).a(this, paramInt);
        i1 -= 1;
      }
    }
  }
  
  void d(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(h.a(paramInt1, getPaddingLeft() + getPaddingRight(), android.support.v4.j.af.o(this)), h.a(paramInt2, getPaddingTop() + getPaddingBottom(), android.support.v4.j.af.p(this)));
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return getScrollingChildHelper().a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return getScrollingChildHelper().a(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return getScrollingChildHelper().a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return getScrollingChildHelper().a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i3 = 1;
    int i4 = 0;
    super.draw(paramCanvas);
    int i2 = this.u.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((g)this.u.get(i1)).b(paramCanvas, this, this.h);
      i1 += 1;
    }
    int i5;
    if ((this.L != null) && (!this.L.a()))
    {
      i5 = paramCanvas.save();
      if (this.p)
      {
        i1 = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i1 + -getHeight(), 0.0F);
        if ((this.L == null) || (!this.L.a(paramCanvas))) {
          break label456;
        }
        i2 = 1;
        label128:
        paramCanvas.restoreToCount(i5);
      }
    }
    for (;;)
    {
      i1 = i2;
      if (this.M != null)
      {
        i1 = i2;
        if (!this.M.a())
        {
          i5 = paramCanvas.save();
          if (this.p) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          }
          if ((this.M == null) || (!this.M.a(paramCanvas))) {
            break label461;
          }
          i1 = 1;
          label202:
          i1 = i2 | i1;
          paramCanvas.restoreToCount(i5);
        }
      }
      i2 = i1;
      if (this.N != null)
      {
        i2 = i1;
        if (!this.N.a())
        {
          i5 = paramCanvas.save();
          int i6 = getWidth();
          if (!this.p) {
            break label466;
          }
          i2 = getPaddingTop();
          label257:
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-i2, -i6);
          if ((this.N == null) || (!this.N.a(paramCanvas))) {
            break label471;
          }
          i2 = 1;
          label295:
          i2 = i1 | i2;
          paramCanvas.restoreToCount(i5);
        }
      }
      i1 = i2;
      if (this.O != null)
      {
        i1 = i2;
        if (!this.O.a())
        {
          i5 = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.p) {
            break label476;
          }
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label372:
          i1 = i4;
          if (this.O != null)
          {
            i1 = i4;
            if (this.O.a(paramCanvas)) {
              i1 = 1;
            }
          }
          i1 = i2 | i1;
          paramCanvas.restoreToCount(i5);
        }
      }
      if ((i1 == 0) && (this.g != null) && (this.u.size() > 0) && (this.g.b())) {
        i1 = i3;
      }
      for (;;)
      {
        if (i1 != 0) {
          android.support.v4.j.af.d(this);
        }
        return;
        i1 = 0;
        break;
        label456:
        i2 = 0;
        break label128;
        label461:
        i1 = 0;
        break label202;
        label466:
        i2 = 0;
        break label257;
        label471:
        i2 = 0;
        break label295;
        label476:
        paramCanvas.translate(-getWidth(), -getHeight());
        break label372;
      }
      i2 = 0;
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  void e()
  {
    if (this.N != null) {
      return;
    }
    this.N = new h(getContext());
    if (this.p)
    {
      this.N.a(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.N.a(getMeasuredHeight(), getMeasuredWidth());
  }
  
  void e(int paramInt1, int paramInt2)
  {
    int i5 = this.d.c();
    int i1;
    int i2;
    if (paramInt1 < paramInt2)
    {
      i1 = -1;
      i2 = paramInt2;
    }
    v localv;
    for (int i3 = paramInt1;; i3 = paramInt2)
    {
      int i4 = 0;
      for (;;)
      {
        if (i4 >= i5) {
          break label127;
        }
        localv = c(this.d.c(i4));
        if ((localv != null) && (localv.b >= i3) && (localv.b <= i2)) {
          break;
        }
        i4 += 1;
      }
      i1 = 1;
      i2 = paramInt1;
    }
    if (localv.b == paramInt1) {
      localv.a(paramInt2 - paramInt1, false);
    }
    for (;;)
    {
      s.a(this.h, true);
      break;
      localv.a(i1, false);
    }
    label127:
    this.b.a(paramInt1, paramInt2);
    requestLayout();
  }
  
  public void e(View paramView) {}
  
  void f()
  {
    if (this.M != null) {
      return;
    }
    this.M = new h(getContext());
    if (this.p)
    {
      this.M.a(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.M.a(getMeasuredWidth(), getMeasuredHeight());
  }
  
  void f(int paramInt1, int paramInt2)
  {
    int i2 = this.d.c();
    int i1 = 0;
    while (i1 < i2)
    {
      v localv = c(this.d.c(i1));
      if ((localv != null) && (!localv.c()) && (localv.b >= paramInt1))
      {
        localv.a(paramInt2, false);
        s.a(this.h, true);
      }
      i1 += 1;
    }
    this.b.b(paramInt1, paramInt2);
    requestLayout();
  }
  
  public void f(View paramView) {}
  
  public View focusSearch(View paramView, int paramInt)
  {
    Object localObject2 = this.f.d(paramView, paramInt);
    if (localObject2 != null) {}
    Object localObject1;
    do
    {
      return (View)localObject2;
      localObject2 = FocusFinder.getInstance().findNextFocus(this, paramView, paramInt);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.s != null)
        {
          localObject1 = localObject2;
          if (this.f != null)
          {
            localObject1 = localObject2;
            if (!j())
            {
              localObject1 = localObject2;
              if (!this.C)
              {
                b();
                localObject1 = this.f.a(paramView, paramInt, this.b, this.h);
                a(false);
              }
            }
          }
        }
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return super.focusSearch(paramView, paramInt);
  }
  
  Rect g(View paramView)
  {
    i locali = (i)paramView.getLayoutParams();
    if (!locali.c) {
      return locali.b;
    }
    Rect localRect = locali.b;
    localRect.set(0, 0, 0, 0);
    int i2 = this.u.size();
    int i1 = 0;
    while (i1 < i2)
    {
      this.r.set(0, 0, 0, 0);
      ((g)this.u.get(i1)).a(this.r, paramView, this, this.h);
      localRect.left += this.r.left;
      localRect.top += this.r.top;
      localRect.right += this.r.right;
      localRect.bottom += this.r.bottom;
      i1 += 1;
    }
    locali.c = false;
    return localRect;
  }
  
  void g()
  {
    if (this.O != null) {
      return;
    }
    this.O = new h(getContext());
    if (this.p)
    {
      this.O.a(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.O.a(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public void g(int paramInt1, int paramInt2) {}
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    if (this.f == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.f.a();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.f == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.f.a(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.f == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.f.a(paramLayoutParams);
  }
  
  public a getAdapter()
  {
    return this.s;
  }
  
  public int getBaseline()
  {
    if (this.f != null) {
      return this.f.s();
    }
    return super.getBaseline();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.aj == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return this.aj.a(paramInt1, paramInt2);
  }
  
  public ap getCompatAccessibilityDelegate()
  {
    return this.ai;
  }
  
  public e getItemAnimator()
  {
    return this.g;
  }
  
  public h getLayoutManager()
  {
    return this.f;
  }
  
  public int getMaxFlingVelocity()
  {
    return this.ab;
  }
  
  public int getMinFlingVelocity()
  {
    return this.aa;
  }
  
  public m getRecycledViewPool()
  {
    return this.b.f();
  }
  
  public int getScrollState()
  {
    return this.P;
  }
  
  void h()
  {
    this.O = null;
    this.M = null;
    this.N = null;
    this.L = null;
  }
  
  void h(int paramInt1, int paramInt2)
  {
    int i1 = getScrollX();
    int i2 = getScrollY();
    onScrollChanged(i1, i2, i1, i2);
    g(paramInt1, paramInt2);
    if (this.ae != null) {
      this.ae.a(this, paramInt1, paramInt2);
    }
    if (this.af != null)
    {
      i1 = this.af.size() - 1;
      while (i1 >= 0)
      {
        ((l)this.af.get(i1)).a(this, paramInt1, paramInt2);
        i1 -= 1;
      }
    }
  }
  
  public boolean hasNestedScrollingParent()
  {
    return getScrollingChildHelper().b();
  }
  
  boolean i()
  {
    return (this.H != null) && (this.H.isEnabled());
  }
  
  public boolean isAttachedToWindow()
  {
    return this.x;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelper().a();
  }
  
  public boolean j()
  {
    return this.K > 0;
  }
  
  void k()
  {
    if (this.s == null)
    {
      Log.e("RecyclerView", "No adapter attached; skipping layout");
      return;
    }
    if (this.f == null)
    {
      Log.e("RecyclerView", "No layout manager attached; skipping layout");
      return;
    }
    s.b(this.h, false);
    if (s.a(this.h) == 1)
    {
      F();
      this.f.f(this);
      G();
    }
    for (;;)
    {
      H();
      return;
      if ((this.c.f()) || (this.f.w() != getWidth()) || (this.f.x() != getHeight()))
      {
        this.f.f(this);
        G();
      }
      else
      {
        this.f.f(this);
      }
    }
  }
  
  void l()
  {
    int i2 = this.d.c();
    int i1 = 0;
    while (i1 < i2)
    {
      ((i)this.d.c(i1).getLayoutParams()).c = true;
      i1 += 1;
    }
    this.b.i();
  }
  
  void m()
  {
    int i2 = this.d.c();
    int i1 = 0;
    while (i1 < i2)
    {
      v localv = c(this.d.c(i1));
      if (!localv.c()) {
        localv.b();
      }
      i1 += 1;
    }
  }
  
  void n()
  {
    int i2 = this.d.c();
    int i1 = 0;
    while (i1 < i2)
    {
      v localv = c(this.d.c(i1));
      if (!localv.c()) {
        localv.a();
      }
      i1 += 1;
    }
    this.b.h();
  }
  
  void o()
  {
    int i2 = this.d.c();
    int i1 = 0;
    while (i1 < i2)
    {
      v localv = c(this.d.c(i1));
      if ((localv != null) && (!localv.c())) {
        localv.b(6);
      }
      i1 += 1;
    }
    l();
    this.b.g();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.K = 0;
    this.x = true;
    this.z = false;
    if (this.f != null) {
      this.f.c(this);
    }
    this.ah = false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.g != null) {
      this.g.c();
    }
    this.z = false;
    c();
    this.x = false;
    if (this.f != null) {
      this.f.b(this, this.b);
    }
    removeCallbacks(this.ap);
    this.e.b();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i2 = this.u.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((g)this.u.get(i1)).a(paramCanvas, this, this.h);
      i1 += 1;
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (this.f == null) {}
    label110:
    label113:
    for (;;)
    {
      return false;
      if ((!this.C) && ((s.d(paramMotionEvent) & 0x2) != 0) && (paramMotionEvent.getAction() == 8))
      {
        float f1;
        if (this.f.e())
        {
          f1 = -s.e(paramMotionEvent, 9);
          if (!this.f.d()) {
            break label110;
          }
        }
        for (float f2 = s.e(paramMotionEvent, 10);; f2 = 0.0F)
        {
          if ((f1 == 0.0F) && (f2 == 0.0F)) {
            break label113;
          }
          float f3 = getScrollFactor();
          a((int)(f2 * f3), (int)(f1 * f3), paramMotionEvent);
          return false;
          f1 = 0.0F;
          break;
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i3 = -1;
    boolean bool1 = true;
    if (this.C) {}
    do
    {
      return false;
      if (a(paramMotionEvent))
      {
        y();
        return true;
      }
    } while (this.f == null);
    boolean bool2 = this.f.d();
    boolean bool3 = this.f.e();
    if (this.R == null) {
      this.R = VelocityTracker.obtain();
    }
    this.R.addMovement(paramMotionEvent);
    int i2 = s.a(paramMotionEvent);
    int i1 = s.b(paramMotionEvent);
    switch (i2)
    {
    case 4: 
    default: 
      if (this.P == 1) {
        return bool1;
      }
      break;
    case 0: 
      label136:
      if (this.D) {
        this.D = false;
      }
      this.Q = s.b(paramMotionEvent, 0);
      i1 = (int)(paramMotionEvent.getX() + 0.5F);
      this.U = i1;
      this.S = i1;
      i1 = (int)(paramMotionEvent.getY() + 0.5F);
      this.V = i1;
      this.T = i1;
      if (this.P == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
      }
      paramMotionEvent = this.ao;
      this.ao[1] = 0;
      paramMotionEvent[0] = 0;
      if (!bool2) {}
      break;
    }
    for (i1 = 1;; i1 = 0)
    {
      i2 = i1;
      if (bool3) {
        i2 = i1 | 0x2;
      }
      startNestedScroll(i2);
      break;
      this.Q = s.b(paramMotionEvent, i1);
      i2 = (int)(s.c(paramMotionEvent, i1) + 0.5F);
      this.U = i2;
      this.S = i2;
      i1 = (int)(s.d(paramMotionEvent, i1) + 0.5F);
      this.V = i1;
      this.T = i1;
      break;
      i2 = s.a(paramMotionEvent, this.Q);
      if (i2 < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.Q + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      i1 = (int)(s.c(paramMotionEvent, i2) + 0.5F);
      i2 = (int)(s.d(paramMotionEvent, i2) + 0.5F);
      if (this.P == 1) {
        break;
      }
      i1 -= this.S;
      int i4 = i2 - this.T;
      int i5;
      if ((bool2) && (Math.abs(i1) > this.W))
      {
        i2 = this.S;
        i5 = this.W;
        if (i1 < 0)
        {
          i1 = -1;
          label449:
          this.U = (i1 * i5 + i2);
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        i2 = i1;
        if (bool3)
        {
          i2 = i1;
          if (Math.abs(i4) > this.W)
          {
            i2 = this.T;
            i5 = this.W;
            if (i4 >= 0) {
              break label530;
            }
          }
        }
        label530:
        for (i1 = i3;; i1 = 1)
        {
          this.V = (i2 + i1 * i5);
          i2 = 1;
          if (i2 == 0) {
            break;
          }
          setScrollState(1);
          break;
          i1 = 1;
          break label449;
        }
        c(paramMotionEvent);
        break;
        this.R.clear();
        stopNestedScroll();
        break;
        y();
        break;
        bool1 = false;
        break label136;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    g.a("RV OnLayout");
    k();
    g.a();
    this.z = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = 0;
    if (this.f == null) {
      d(paramInt1, paramInt2);
    }
    do
    {
      int i1;
      do
      {
        return;
        if (!h.a(this.f)) {
          break;
        }
        int i3 = View.MeasureSpec.getMode(paramInt1);
        int i4 = View.MeasureSpec.getMode(paramInt2);
        i1 = i2;
        if (i3 == 1073741824)
        {
          i1 = i2;
          if (i4 == 1073741824) {
            i1 = 1;
          }
        }
        this.f.a(this.b, this.h, paramInt1, paramInt2);
      } while ((i1 != 0) || (this.s == null));
      if (s.a(this.h) == 1) {
        F();
      }
      this.f.a(paramInt1, paramInt2);
      s.b(this.h, true);
      G();
      this.f.b(paramInt1, paramInt2);
    } while (!this.f.k());
    this.f.a(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    s.b(this.h, true);
    G();
    this.f.b(paramInt1, paramInt2);
    return;
    if (this.y)
    {
      this.f.a(this.b, this.h, paramInt1, paramInt2);
      return;
    }
    if (this.F)
    {
      b();
      E();
      if (s.b(this.h))
      {
        s.c(this.h, true);
        this.F = false;
        a(false);
      }
    }
    else
    {
      if (this.s == null) {
        break label342;
      }
    }
    label342:
    for (this.h.a = this.s.a();; this.h.a = 0)
    {
      b();
      this.f.a(this.b, this.h, paramInt1, paramInt2);
      a(false);
      s.c(this.h, false);
      return;
      this.c.e();
      s.c(this.h, false);
      break;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof q)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      this.o = ((q)paramParcelable);
      super.onRestoreInstanceState(this.o.getSuperState());
    } while ((this.f == null) || (this.o.a == null));
    this.f.a(this.o.a);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    q localq = new q(super.onSaveInstanceState());
    if (this.o != null)
    {
      q.a(localq, this.o);
      return localq;
    }
    if (this.f != null)
    {
      localq.a = this.f.c();
      return localq;
    }
    localq.a = null;
    return localq;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      h();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i7 = 0;
    if ((this.C) || (this.D)) {}
    do
    {
      return false;
      if (b(paramMotionEvent))
      {
        y();
        return true;
      }
    } while (this.f == null);
    boolean bool1 = this.f.d();
    boolean bool2 = this.f.e();
    if (this.R == null) {
      this.R = VelocityTracker.obtain();
    }
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    int i3 = s.a(paramMotionEvent);
    int i2 = s.b(paramMotionEvent);
    if (i3 == 0)
    {
      int[] arrayOfInt = this.ao;
      this.ao[1] = 0;
      arrayOfInt[0] = 0;
    }
    localMotionEvent.offsetLocation(this.ao[0], this.ao[1]);
    int i1 = i7;
    switch (i3)
    {
    default: 
      i1 = i7;
    case 4: 
      if (i1 == 0) {
        this.R.addMovement(localMotionEvent);
      }
      localMotionEvent.recycle();
      return true;
    case 0: 
      this.Q = s.b(paramMotionEvent, 0);
      i1 = (int)(paramMotionEvent.getX() + 0.5F);
      this.U = i1;
      this.S = i1;
      i1 = (int)(paramMotionEvent.getY() + 0.5F);
      this.V = i1;
      this.T = i1;
      if (!bool1) {
        break;
      }
    }
    for (i1 = 1;; i1 = 0)
    {
      i2 = i1;
      if (bool2) {
        i2 = i1 | 0x2;
      }
      startNestedScroll(i2);
      i1 = i7;
      break;
      this.Q = s.b(paramMotionEvent, i2);
      i1 = (int)(s.c(paramMotionEvent, i2) + 0.5F);
      this.U = i1;
      this.S = i1;
      i1 = (int)(s.d(paramMotionEvent, i2) + 0.5F);
      this.V = i1;
      this.T = i1;
      i1 = i7;
      break;
      i1 = s.a(paramMotionEvent, this.Q);
      if (i1 < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.Q + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      int i8 = (int)(s.c(paramMotionEvent, i1) + 0.5F);
      int i9 = (int)(s.d(paramMotionEvent, i1) + 0.5F);
      int i4 = this.U - i8;
      i3 = this.V - i9;
      i1 = i3;
      i2 = i4;
      if (dispatchNestedPreScroll(i4, i3, this.an, this.am))
      {
        i2 = i4 - this.an[0];
        i1 = i3 - this.an[1];
        localMotionEvent.offsetLocation(this.am[0], this.am[1]);
        paramMotionEvent = this.ao;
        paramMotionEvent[0] += this.am[0];
        paramMotionEvent = this.ao;
        paramMotionEvent[1] += this.am[1];
      }
      i3 = i1;
      i4 = i2;
      if (this.P != 1)
      {
        if ((!bool1) || (Math.abs(i2) <= this.W)) {
          break label940;
        }
        if (i2 <= 0) {
          break label773;
        }
        i2 -= this.W;
      }
      label612:
      label662:
      label734:
      label773:
      label785:
      label803:
      label863:
      label924:
      label940:
      for (i3 = 1;; i3 = 0)
      {
        int i5 = i1;
        int i6 = i3;
        if (bool2)
        {
          i5 = i1;
          i6 = i3;
          if (Math.abs(i1) > this.W)
          {
            if (i1 <= 0) {
              break label785;
            }
            i5 = i1 - this.W;
            i6 = 1;
          }
        }
        i3 = i5;
        i4 = i2;
        if (i6 != 0)
        {
          setScrollState(1);
          i4 = i2;
          i3 = i5;
        }
        i1 = i7;
        if (this.P != 1) {
          break;
        }
        this.U = (i8 - this.am[0]);
        this.V = (i9 - this.am[1]);
        if (bool1) {
          if (!bool2) {
            break label803;
          }
        }
        for (;;)
        {
          i1 = i7;
          if (!a(i4, i3, localMotionEvent)) {
            break;
          }
          getParent().requestDisallowInterceptTouchEvent(true);
          i1 = i7;
          break;
          i2 += this.W;
          break label612;
          i5 = i1 + this.W;
          break label662;
          i4 = 0;
          break label734;
          i3 = 0;
        }
        c(paramMotionEvent);
        i1 = i7;
        break;
        this.R.addMovement(localMotionEvent);
        this.R.computeCurrentVelocity(1000, this.ab);
        float f1;
        if (bool1)
        {
          f1 = -ad.a(this.R, this.Q);
          if (!bool2) {
            break label924;
          }
        }
        for (float f2 = -ad.b(this.R, this.Q);; f2 = 0.0F)
        {
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!b((int)f1, (int)f2))) {
            setScrollState(0);
          }
          x();
          i1 = 1;
          break;
          f1 = 0.0F;
          break label863;
        }
        y();
        i1 = i7;
        break;
      }
    }
  }
  
  public boolean p()
  {
    return (!this.z) || (this.J) || (this.c.d());
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    v localv = c(paramView);
    if (localv != null)
    {
      if (!localv.r()) {
        break label32;
      }
      localv.m();
    }
    label32:
    while (localv.c())
    {
      i(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localv);
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    Object localObject;
    if ((!this.f.a(this, this.h, paramView1, paramView2)) && (paramView2 != null))
    {
      this.r.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
      localObject = paramView2.getLayoutParams();
      if ((localObject instanceof i))
      {
        localObject = (i)localObject;
        if (!((i)localObject).c)
        {
          localObject = ((i)localObject).b;
          Rect localRect = this.r;
          localRect.left -= ((Rect)localObject).left;
          localRect = this.r;
          localRect.right += ((Rect)localObject).right;
          localRect = this.r;
          localRect.top -= ((Rect)localObject).top;
          localRect = this.r;
          int i1 = localRect.bottom;
          localRect.bottom = (((Rect)localObject).bottom + i1);
        }
      }
      offsetDescendantRectToMyCoords(paramView2, this.r);
      offsetRectIntoDescendantCoords(paramView1, this.r);
      localObject = this.r;
      if (this.z) {
        break label204;
      }
    }
    label204:
    for (boolean bool = true;; bool = false)
    {
      requestChildRectangleOnScreen(paramView1, (Rect)localObject, bool);
      super.requestChildFocus(paramView1, paramView2);
      return;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return this.f.a(this, paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int i2 = this.v.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((k)this.v.get(i1)).a(paramBoolean);
      i1 += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((this.A == 0) && (!this.C))
    {
      super.requestLayout();
      return;
    }
    this.B = true;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.f == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      do
      {
        return;
      } while (this.C);
      bool1 = this.f.d();
      bool2 = this.f.e();
    } while ((!bool1) && (!bool2));
    if (bool1) {
      if (!bool2) {
        break label74;
      }
    }
    for (;;)
    {
      a(paramInt1, paramInt2, null);
      return;
      paramInt1 = 0;
      break;
      label74:
      paramInt2 = 0;
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    if (a(paramAccessibilityEvent)) {
      return;
    }
    super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
  }
  
  public void setAccessibilityDelegateCompat(ap paramap)
  {
    this.ai = paramap;
    android.support.v4.j.af.a(this, this.ai);
  }
  
  public void setAdapter(a parama)
  {
    setLayoutFrozen(false);
    a(parama, false, true);
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(d paramd)
  {
    if (paramd == this.aj) {
      return;
    }
    this.aj = paramd;
    if (this.aj != null) {}
    for (boolean bool = true;; bool = false)
    {
      setChildrenDrawingOrderEnabled(bool);
      return;
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.p) {
      h();
    }
    this.p = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.z) {
      requestLayout();
    }
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public void setItemAnimator(e parame)
  {
    if (this.g != null)
    {
      this.g.c();
      this.g.a(null);
    }
    this.g = parame;
    if (this.g != null) {
      this.g.a(this.ag);
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    if (paramBoolean != this.C)
    {
      a("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        this.C = false;
        if ((this.B) && (this.f != null) && (this.s != null)) {
          requestLayout();
        }
        this.B = false;
      }
    }
    else
    {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    onTouchEvent(MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0));
    this.C = true;
    this.D = true;
    c();
  }
  
  public void setLayoutManager(h paramh)
  {
    if (paramh == this.f) {
      return;
    }
    c();
    if (this.f != null)
    {
      if (this.x) {
        this.f.b(this, this.b);
      }
      this.f.b(null);
    }
    this.b.a();
    this.d.a();
    this.f = paramh;
    if (paramh != null)
    {
      if (paramh.q != null) {
        throw new IllegalArgumentException("LayoutManager " + paramh + " is already attached to a RecyclerView: " + paramh.q);
      }
      this.f.b(this);
      if (this.x) {
        this.f.c(this);
      }
    }
    requestLayout();
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().a(paramBoolean);
  }
  
  @Deprecated
  public void setOnScrollListener(l paraml)
  {
    this.ae = paraml;
  }
  
  public void setRecycledViewPool(m paramm)
  {
    this.b.a(paramm);
  }
  
  public void setRecyclerListener(o paramo)
  {
    this.t = paramo;
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    switch (paramInt)
    {
    default: 
      Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + paramInt + "; using default value");
    case 0: 
      this.W = localViewConfiguration.getScaledTouchSlop();
      return;
    }
    this.W = aq.a(localViewConfiguration);
  }
  
  public void setViewCacheExtension(t paramt)
  {
    this.b.a(paramt);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().a(paramInt);
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().c();
  }
  
  public static abstract class a<VH extends ao.v>
  {
    private final ao.b a;
    private boolean b;
    
    public abstract int a();
    
    public int a(int paramInt)
    {
      return 0;
    }
    
    public abstract VH a(ViewGroup paramViewGroup, int paramInt);
    
    public void a(ao.c paramc)
    {
      this.a.registerObserver(paramc);
    }
    
    public void a(VH paramVH) {}
    
    public abstract void a(VH paramVH, int paramInt);
    
    public void a(VH paramVH, int paramInt, List<Object> paramList)
    {
      a(paramVH, paramInt);
    }
    
    public void a(ao paramao) {}
    
    public long b(int paramInt)
    {
      return -1L;
    }
    
    public final VH b(ViewGroup paramViewGroup, int paramInt)
    {
      g.a("RV CreateView");
      paramViewGroup = a(paramViewGroup, paramInt);
      paramViewGroup.e = paramInt;
      g.a();
      return paramViewGroup;
    }
    
    public void b(ao.c paramc)
    {
      this.a.unregisterObserver(paramc);
    }
    
    public final void b(VH paramVH, int paramInt)
    {
      paramVH.b = paramInt;
      if (b()) {
        paramVH.d = b(paramInt);
      }
      paramVH.a(1, 519);
      g.a("RV OnBindView");
      a(paramVH, paramInt, paramVH.u());
      paramVH.t();
      g.a();
    }
    
    public void b(ao paramao) {}
    
    public final boolean b()
    {
      return this.b;
    }
    
    public boolean b(VH paramVH)
    {
      return false;
    }
    
    public void c(VH paramVH) {}
    
    public void d(VH paramVH) {}
  }
  
  static class b
    extends Observable<ao.c>
  {}
  
  public static abstract class c {}
  
  public static abstract interface d
  {
    public abstract int a(int paramInt1, int paramInt2);
  }
  
  public static abstract class e
  {
    private b a = null;
    private ArrayList<a> b = new ArrayList();
    private long c = 120L;
    private long d = 120L;
    private long e = 250L;
    private long f = 250L;
    
    static int d(ao.v paramv)
    {
      int j = ao.v.f(paramv) & 0xE;
      int i;
      if (paramv.n()) {
        i = 4;
      }
      int k;
      int m;
      do
      {
        do
        {
          do
          {
            do
            {
              return i;
              i = j;
            } while ((j & 0x4) != 0);
            k = paramv.f();
            m = paramv.e();
            i = j;
          } while (k == -1);
          i = j;
        } while (m == -1);
        i = j;
      } while (k == m);
      return j | 0x800;
    }
    
    public c a(ao.s params, ao.v paramv)
    {
      return i().a(paramv);
    }
    
    public c a(ao.s params, ao.v paramv, int paramInt, List<Object> paramList)
    {
      return i().a(paramv);
    }
    
    public abstract void a();
    
    void a(b paramb)
    {
      this.a = paramb;
    }
    
    public abstract boolean a(ao.v paramv, c paramc1, c paramc2);
    
    public abstract boolean a(ao.v paramv1, ao.v paramv2, c paramc1, c paramc2);
    
    public boolean a(ao.v paramv, List<Object> paramList)
    {
      return g(paramv);
    }
    
    public abstract boolean b();
    
    public abstract boolean b(ao.v paramv, c paramc1, c paramc2);
    
    public abstract void c();
    
    public abstract void c(ao.v paramv);
    
    public abstract boolean c(ao.v paramv, c paramc1, c paramc2);
    
    public long d()
    {
      return this.e;
    }
    
    public long e()
    {
      return this.c;
    }
    
    public final void e(ao.v paramv)
    {
      f(paramv);
      if (this.a != null) {
        this.a.a(paramv);
      }
    }
    
    public long f()
    {
      return this.d;
    }
    
    public void f(ao.v paramv) {}
    
    public long g()
    {
      return this.f;
    }
    
    public boolean g(ao.v paramv)
    {
      return true;
    }
    
    public final void h()
    {
      int j = this.b.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.b.get(i)).a();
        i += 1;
      }
      this.b.clear();
    }
    
    public c i()
    {
      return new c();
    }
    
    public static abstract interface a
    {
      public abstract void a();
    }
    
    static abstract interface b
    {
      public abstract void a(ao.v paramv);
    }
    
    public static class c
    {
      public int a;
      public int b;
      public int c;
      public int d;
      
      public c a(ao.v paramv)
      {
        return a(paramv, 0);
      }
      
      public c a(ao.v paramv, int paramInt)
      {
        paramv = paramv.a;
        this.a = paramv.getLeft();
        this.b = paramv.getTop();
        this.c = paramv.getRight();
        this.d = paramv.getBottom();
        return this;
      }
    }
  }
  
  private class f
    implements ao.e.b
  {
    private f() {}
    
    public void a(ao.v paramv)
    {
      paramv.a(true);
      if ((paramv.g != null) && (paramv.h == null)) {
        paramv.g = null;
      }
      paramv.h = null;
      if ((!ao.v.e(paramv)) && (!ao.c(ao.this, paramv.a)) && (paramv.r())) {
        ao.this.removeDetachedView(paramv.a, false);
      }
    }
  }
  
  public static abstract class g
  {
    @Deprecated
    public void a(Canvas paramCanvas, ao paramao) {}
    
    public void a(Canvas paramCanvas, ao paramao, ao.s params)
    {
      a(paramCanvas, paramao);
    }
    
    @Deprecated
    public void a(Rect paramRect, int paramInt, ao paramao)
    {
      paramRect.set(0, 0, 0, 0);
    }
    
    public void a(Rect paramRect, View paramView, ao paramao, ao.s params)
    {
      a(paramRect, ((ao.i)paramView.getLayoutParams()).e(), paramao);
    }
    
    @Deprecated
    public void b(Canvas paramCanvas, ao paramao) {}
    
    public void b(Canvas paramCanvas, ao paramao, ao.s params)
    {
      b(paramCanvas, paramao);
    }
  }
  
  public static abstract class h
  {
    private boolean a = false;
    private boolean b = false;
    private boolean c = true;
    private int d;
    private int e;
    private int f;
    private int g;
    ac p;
    ao q;
    ao.r r;
    boolean s = false;
    
    public static int a(int paramInt1, int paramInt2, int paramInt3)
    {
      int j = View.MeasureSpec.getMode(paramInt1);
      int i = View.MeasureSpec.getSize(paramInt1);
      paramInt1 = i;
      switch (j)
      {
      default: 
        paramInt1 = Math.max(paramInt2, paramInt3);
      case 1073741824: 
        return paramInt1;
      }
      return Math.min(i, Math.max(paramInt2, paramInt3));
    }
    
    public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      int j = 0;
      int k = 0;
      int i = Math.max(0, paramInt1 - paramInt3);
      if (paramBoolean) {
        if (paramInt4 >= 0)
        {
          paramInt1 = 1073741824;
          paramInt3 = paramInt4;
        }
      }
      for (;;)
      {
        return View.MeasureSpec.makeMeasureSpec(paramInt3, paramInt1);
        if (paramInt4 == -1)
        {
          switch (paramInt2)
          {
          default: 
            paramInt2 = 0;
            paramInt1 = j;
          }
          for (;;)
          {
            paramInt3 = paramInt1;
            paramInt1 = paramInt2;
            break;
            paramInt1 = i;
            continue;
            paramInt2 = 0;
            paramInt1 = j;
          }
        }
        if (paramInt4 == -2)
        {
          paramInt3 = 0;
          paramInt1 = k;
          continue;
          if (paramInt4 >= 0)
          {
            paramInt1 = 1073741824;
            paramInt3 = paramInt4;
            continue;
          }
          if (paramInt4 == -1)
          {
            paramInt1 = paramInt2;
            paramInt3 = i;
            continue;
          }
          if (paramInt4 == -2)
          {
            if (paramInt2 != Integer.MIN_VALUE)
            {
              paramInt1 = k;
              paramInt3 = i;
              if (paramInt2 != 1073741824) {
                continue;
              }
            }
            paramInt1 = Integer.MIN_VALUE;
            paramInt3 = i;
            continue;
          }
        }
        paramInt3 = 0;
        paramInt1 = k;
      }
    }
    
    public static a a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
      a locala = new a();
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RecyclerView, paramInt1, paramInt2);
      locala.a = paramContext.getInt(a.a.RecyclerView_android_orientation, 1);
      locala.b = paramContext.getInt(a.a.RecyclerView_spanCount, 1);
      locala.c = paramContext.getBoolean(a.a.RecyclerView_reverseLayout, false);
      locala.d = paramContext.getBoolean(a.a.RecyclerView_stackFromEnd, false);
      paramContext.recycle();
      return locala;
    }
    
    private void a(int paramInt, View paramView)
    {
      this.p.d(paramInt);
    }
    
    private void a(ao.n paramn, int paramInt, View paramView)
    {
      ao.v localv = ao.c(paramView);
      if (localv.c()) {
        return;
      }
      if ((localv.n()) && (!localv.q()) && (!ao.f(this.q).b()))
      {
        f(paramInt);
        paramn.b(localv);
        return;
      }
      g(paramInt);
      paramn.c(paramView);
      this.q.e.h(localv);
    }
    
    private void a(ao.r paramr)
    {
      if (this.r == paramr) {
        this.r = null;
      }
    }
    
    private void a(View paramView, int paramInt, boolean paramBoolean)
    {
      ao.v localv = ao.c(paramView);
      ao.i locali;
      if ((paramBoolean) || (localv.q()))
      {
        this.q.e.e(localv);
        locali = (ao.i)paramView.getLayoutParams();
        if ((!localv.k()) && (!localv.i())) {
          break label128;
        }
        if (!localv.i()) {
          break label120;
        }
        localv.j();
        label68:
        this.p.a(paramView, paramInt, paramView.getLayoutParams(), false);
      }
      for (;;)
      {
        if (locali.d)
        {
          localv.a.invalidate();
          locali.d = false;
        }
        return;
        this.q.e.f(localv);
        break;
        label120:
        localv.l();
        break label68;
        label128:
        if (paramView.getParent() == this.q)
        {
          int j = this.p.b(paramView);
          int i = paramInt;
          if (paramInt == -1) {
            i = this.p.b();
          }
          if (j == -1) {
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.q.indexOfChild(paramView));
          }
          if (j != i) {
            this.q.f.c(j, i);
          }
        }
        else
        {
          this.p.a(paramView, paramInt, false);
          locali.c = true;
          if ((this.r != null) && (this.r.c())) {
            this.r.b(paramView);
          }
        }
      }
    }
    
    private static boolean b(int paramInt1, int paramInt2, int paramInt3)
    {
      boolean bool2 = true;
      int i = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      boolean bool1;
      if ((paramInt3 > 0) && (paramInt1 != paramInt3)) {
        bool1 = false;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
          switch (i)
          {
          case 0: 
          default: 
            return false;
          case -2147483648: 
            bool1 = bool2;
          }
        } while (paramInt2 >= paramInt1);
        return false;
        bool1 = bool2;
      } while (paramInt2 == paramInt1);
      return false;
    }
    
    public int A()
    {
      if (this.q != null) {
        return this.q.getPaddingRight();
      }
      return 0;
    }
    
    public int B()
    {
      if (this.q != null) {
        return this.q.getPaddingBottom();
      }
      return 0;
    }
    
    public View C()
    {
      if (this.q == null) {}
      View localView;
      do
      {
        return null;
        localView = this.q.getFocusedChild();
      } while ((localView == null) || (this.p.c(localView)));
      return localView;
    }
    
    public int D()
    {
      return android.support.v4.j.af.o(this.q);
    }
    
    public int E()
    {
      return android.support.v4.j.af.p(this.q);
    }
    
    void F()
    {
      if (this.r != null) {
        this.r.a();
      }
    }
    
    public void G()
    {
      this.a = true;
    }
    
    boolean H()
    {
      boolean bool2 = false;
      int j = t();
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          ViewGroup.LayoutParams localLayoutParams = h(i).getLayoutParams();
          if ((localLayoutParams.width < 0) && (localLayoutParams.height < 0)) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
    }
    
    public int a(int paramInt, ao.n paramn, ao.s params)
    {
      return 0;
    }
    
    public int a(ao.n paramn, ao.s params)
    {
      if ((this.q == null) || (ao.f(this.q) == null)) {}
      while (!e()) {
        return 1;
      }
      return ao.f(this.q).a();
    }
    
    public abstract ao.i a();
    
    public ao.i a(Context paramContext, AttributeSet paramAttributeSet)
    {
      return new ao.i(paramContext, paramAttributeSet);
    }
    
    public ao.i a(ViewGroup.LayoutParams paramLayoutParams)
    {
      if ((paramLayoutParams instanceof ao.i)) {
        return new ao.i((ao.i)paramLayoutParams);
      }
      if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        return new ao.i((ViewGroup.MarginLayoutParams)paramLayoutParams);
      }
      return new ao.i(paramLayoutParams);
    }
    
    public View a(View paramView, int paramInt, ao.n paramn, ao.s params)
    {
      return null;
    }
    
    void a(int paramInt1, int paramInt2)
    {
      this.f = View.MeasureSpec.getSize(paramInt1);
      this.d = View.MeasureSpec.getMode(paramInt1);
      if ((this.d == 0) && (!ao.a)) {
        this.f = 0;
      }
      this.g = View.MeasureSpec.getSize(paramInt2);
      this.e = View.MeasureSpec.getMode(paramInt2);
      if ((this.e == 0) && (!ao.a)) {
        this.g = 0;
      }
    }
    
    public void a(int paramInt, ao.n paramn)
    {
      View localView = h(paramInt);
      f(paramInt);
      paramn.a(localView);
    }
    
    public void a(Rect paramRect, int paramInt1, int paramInt2)
    {
      int i = paramRect.width();
      int j = y();
      int k = A();
      int m = paramRect.height();
      int n = z();
      int i1 = B();
      d(a(paramInt1, i + j + k, D()), a(paramInt2, m + n + i1, E()));
    }
    
    public void a(Parcelable paramParcelable) {}
    
    void a(c paramc)
    {
      a(this.q.b, this.q.h, paramc);
    }
    
    public void a(ao.a parama1, ao.a parama2) {}
    
    public void a(ao.n paramn)
    {
      int i = t() - 1;
      while (i >= 0)
      {
        a(paramn, i, h(i));
        i -= 1;
      }
    }
    
    public void a(ao.n paramn, ao.s params, int paramInt1, int paramInt2)
    {
      this.q.d(paramInt1, paramInt2);
    }
    
    public void a(ao.n paramn, ao.s params, c paramc)
    {
      if ((android.support.v4.j.af.b(this.q, -1)) || (android.support.v4.j.af.a(this.q, -1)))
      {
        paramc.a(8192);
        paramc.a(true);
      }
      if ((android.support.v4.j.af.b(this.q, 1)) || (android.support.v4.j.af.a(this.q, 1)))
      {
        paramc.a(4096);
        paramc.a(true);
      }
      paramc.a(c.j.a(a(paramn, params), b(paramn, params), e(paramn, params), d(paramn, params)));
    }
    
    public void a(ao.n paramn, ao.s params, View paramView, c paramc)
    {
      int i;
      if (e())
      {
        i = d(paramView);
        if (!d()) {
          break label51;
        }
      }
      label51:
      for (int j = d(paramView);; j = 0)
      {
        paramc.b(c.k.a(i, 1, j, 1, false, false));
        return;
        i = 0;
        break;
      }
    }
    
    public void a(ao.n paramn, ao.s params, AccessibilityEvent paramAccessibilityEvent)
    {
      boolean bool2 = true;
      paramn = a.a(paramAccessibilityEvent);
      if ((this.q == null) || (paramn == null)) {
        return;
      }
      boolean bool1 = bool2;
      if (!android.support.v4.j.af.b(this.q, 1))
      {
        bool1 = bool2;
        if (!android.support.v4.j.af.b(this.q, -1))
        {
          bool1 = bool2;
          if (!android.support.v4.j.af.a(this.q, -1)) {
            if (!android.support.v4.j.af.a(this.q, 1)) {
              break label111;
            }
          }
        }
      }
      label111:
      for (bool1 = bool2;; bool1 = false)
      {
        paramn.a(bool1);
        if (ao.f(this.q) == null) {
          break;
        }
        paramn.a(ao.f(this.q).a());
        return;
      }
    }
    
    public void a(ao paramao) {}
    
    public void a(ao paramao, int paramInt1, int paramInt2) {}
    
    public void a(ao paramao, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void a(ao paramao, int paramInt1, int paramInt2, Object paramObject)
    {
      c(paramao, paramInt1, paramInt2);
    }
    
    public void a(ao paramao, ao.n paramn)
    {
      e(paramao);
    }
    
    public void a(View paramView)
    {
      a(paramView, -1);
    }
    
    public void a(View paramView, int paramInt)
    {
      a(paramView, paramInt, true);
    }
    
    public void a(View paramView, int paramInt1, int paramInt2)
    {
      ao.i locali = (ao.i)paramView.getLayoutParams();
      Rect localRect = this.q.g(paramView);
      int k = localRect.left;
      int m = localRect.right;
      int i = localRect.top;
      int j = localRect.bottom;
      paramInt1 = a(w(), u(), k + m + paramInt1 + (y() + A() + locali.leftMargin + locali.rightMargin), locali.width, d());
      paramInt2 = a(x(), v(), j + i + paramInt2 + (z() + B() + locali.topMargin + locali.bottomMargin), locali.height, e());
      if (b(paramView, paramInt1, paramInt2, locali)) {
        paramView.measure(paramInt1, paramInt2);
      }
    }
    
    public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      Rect localRect = ((ao.i)paramView.getLayoutParams()).b;
      paramView.layout(localRect.left + paramInt1, localRect.top + paramInt2, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
    }
    
    public void a(View paramView, int paramInt, ao.i parami)
    {
      ao.v localv = ao.c(paramView);
      if (localv.q()) {
        this.q.e.e(localv);
      }
      for (;;)
      {
        this.p.a(paramView, paramInt, parami, localv.q());
        return;
        this.q.e.f(localv);
      }
    }
    
    public void a(View paramView, Rect paramRect)
    {
      if (this.q == null)
      {
        paramRect.set(0, 0, 0, 0);
        return;
      }
      paramRect.set(this.q.g(paramView));
    }
    
    void a(View paramView, c paramc)
    {
      ao.v localv = ao.c(paramView);
      if ((localv != null) && (!localv.q()) && (!this.p.c(localv.a))) {
        a(this.q.b, this.q.h, paramView, paramc);
      }
    }
    
    public void a(View paramView, ao.n paramn)
    {
      c(paramView);
      paramn.a(paramView);
    }
    
    public void a(AccessibilityEvent paramAccessibilityEvent)
    {
      a(this.q.b, this.q.h, paramAccessibilityEvent);
    }
    
    public void a(String paramString)
    {
      if (this.q != null) {
        this.q.a(paramString);
      }
    }
    
    boolean a(int paramInt, Bundle paramBundle)
    {
      return a(this.q.b, this.q.h, paramInt, paramBundle);
    }
    
    public boolean a(ao.i parami)
    {
      return parami != null;
    }
    
    public boolean a(ao.n paramn, ao.s params, int paramInt, Bundle paramBundle)
    {
      if (this.q == null) {}
      int i;
      do
      {
        return false;
        switch (paramInt)
        {
        default: 
          paramInt = 0;
          i = 0;
        }
      } while ((i == 0) && (paramInt == 0));
      this.q.scrollBy(paramInt, i);
      return true;
      if (android.support.v4.j.af.b(this.q, -1)) {}
      for (paramInt = -(x() - z() - B());; paramInt = 0)
      {
        i = paramInt;
        int j;
        if (android.support.v4.j.af.a(this.q, -1))
        {
          j = -(w() - y() - A());
          i = paramInt;
          paramInt = j;
          break;
          if (!android.support.v4.j.af.b(this.q, 1)) {
            break label207;
          }
        }
        label207:
        for (paramInt = x() - z() - B();; paramInt = 0)
        {
          i = paramInt;
          if (android.support.v4.j.af.a(this.q, 1))
          {
            j = w();
            int k = y();
            int m = A();
            i = paramInt;
            paramInt = j - k - m;
            break;
          }
          paramInt = 0;
          break;
        }
      }
    }
    
    public boolean a(ao.n paramn, ao.s params, View paramView, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    public boolean a(ao paramao, ao.s params, View paramView1, View paramView2)
    {
      return a(paramao, paramView1, paramView2);
    }
    
    public boolean a(ao paramao, View paramView, Rect paramRect, boolean paramBoolean)
    {
      int i2 = y();
      int m = z();
      int i3 = w() - A();
      int i1 = x();
      int i6 = B();
      int i4 = paramView.getLeft() + paramRect.left - paramView.getScrollX();
      int n = paramView.getTop() + paramRect.top - paramView.getScrollY();
      int i5 = i4 + paramRect.width();
      int i7 = paramRect.height();
      int i = Math.min(0, i4 - i2);
      int j = Math.min(0, n - m);
      int k = Math.max(0, i5 - i3);
      i1 = Math.max(0, n + i7 - (i1 - i6));
      if (r() == 1) {
        if (k != 0)
        {
          i = k;
          if (j == 0) {
            break label217;
          }
          label154:
          if ((i == 0) && (j == 0)) {
            break label243;
          }
          if (!paramBoolean) {
            break label232;
          }
          paramao.scrollBy(i, j);
        }
      }
      for (;;)
      {
        return true;
        i = Math.max(i, i5 - i3);
        break;
        if (i != 0) {
          break;
        }
        for (;;)
        {
          i = Math.min(i4 - i2, k);
        }
        label217:
        j = Math.min(n - m, i1);
        break label154;
        label232:
        paramao.a(i, j);
      }
      label243:
      return false;
    }
    
    @Deprecated
    public boolean a(ao paramao, View paramView1, View paramView2)
    {
      return (q()) || (paramao.j());
    }
    
    public boolean a(ao paramao, ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
    {
      return false;
    }
    
    boolean a(View paramView, int paramInt1, int paramInt2, ao.i parami)
    {
      return (!this.c) || (!b(paramView.getMeasuredWidth(), paramInt1, parami.width)) || (!b(paramView.getMeasuredHeight(), paramInt2, parami.height));
    }
    
    boolean a(View paramView, int paramInt, Bundle paramBundle)
    {
      return a(this.q.b, this.q.h, paramView, paramInt, paramBundle);
    }
    
    public boolean a(Runnable paramRunnable)
    {
      if (this.q != null) {
        return this.q.removeCallbacks(paramRunnable);
      }
      return false;
    }
    
    public int b(int paramInt, ao.n paramn, ao.s params)
    {
      return 0;
    }
    
    public int b(ao.n paramn, ao.s params)
    {
      if ((this.q == null) || (ao.f(this.q) == null)) {}
      while (!d()) {
        return 1;
      }
      return ao.f(this.q).a();
    }
    
    public int b(ao.s params)
    {
      return 0;
    }
    
    void b(int paramInt1, int paramInt2)
    {
      int j = Integer.MAX_VALUE;
      int i = Integer.MIN_VALUE;
      int i5 = t();
      if (i5 == 0)
      {
        this.q.d(paramInt1, paramInt2);
        return;
      }
      int n = 0;
      int k = Integer.MIN_VALUE;
      int m = Integer.MAX_VALUE;
      int i1;
      int i3;
      int i2;
      if (n < i5)
      {
        View localView = h(n);
        ao.i locali = (ao.i)localView.getLayoutParams();
        int i4 = h(localView) - locali.leftMargin;
        i1 = j(localView);
        i3 = locali.rightMargin + i1;
        i2 = i(localView) - locali.topMargin;
        i1 = k(localView);
        i1 = locali.bottomMargin + i1;
        if (i4 >= m) {
          break label219;
        }
        m = i4;
      }
      label219:
      for (;;)
      {
        if (i3 > k) {
          k = i3;
        }
        for (;;)
        {
          if (i2 < j) {
            j = i2;
          }
          for (;;)
          {
            if (i1 > i) {
              i = i1;
            }
            for (;;)
            {
              n += 1;
              break;
              ao.n(this.q).set(m, j, k, i);
              a(ao.n(this.q), paramInt1, paramInt2);
              return;
            }
          }
        }
      }
    }
    
    void b(ao.n paramn)
    {
      int j = paramn.d();
      int i = j - 1;
      if (i >= 0)
      {
        View localView = paramn.e(i);
        ao.v localv = ao.c(localView);
        if (localv.c()) {}
        for (;;)
        {
          i -= 1;
          break;
          localv.a(false);
          if (localv.r()) {
            this.q.removeDetachedView(localView, false);
          }
          if (this.q.g != null) {
            this.q.g.c(localv);
          }
          localv.a(true);
          paramn.b(localView);
        }
      }
      paramn.e();
      if (j > 0) {
        this.q.invalidate();
      }
    }
    
    void b(ao paramao)
    {
      if (paramao == null)
      {
        this.q = null;
        this.p = null;
        this.f = 0;
      }
      for (this.g = 0;; this.g = paramao.getHeight())
      {
        this.d = 1073741824;
        this.e = 1073741824;
        return;
        this.q = paramao;
        this.p = paramao.d;
        this.f = paramao.getWidth();
      }
    }
    
    public void b(ao paramao, int paramInt1, int paramInt2) {}
    
    void b(ao paramao, ao.n paramn)
    {
      this.s = false;
      a(paramao, paramn);
    }
    
    public void b(View paramView)
    {
      b(paramView, -1);
    }
    
    public void b(View paramView, int paramInt)
    {
      a(paramView, paramInt, false);
    }
    
    public boolean b()
    {
      return false;
    }
    
    boolean b(View paramView, int paramInt1, int paramInt2, ao.i parami)
    {
      return (paramView.isLayoutRequested()) || (!this.c) || (!b(paramView.getWidth(), paramInt1, parami.width)) || (!b(paramView.getHeight(), paramInt2, parami.height));
    }
    
    public int c(ao.s params)
    {
      return 0;
    }
    
    public Parcelable c()
    {
      return null;
    }
    
    public View c(int paramInt)
    {
      int j = t();
      int i = 0;
      if (i < j)
      {
        View localView = h(i);
        ao.v localv = ao.c(localView);
        if (localv == null) {}
        while ((localv.d() != paramInt) || (localv.c()) || ((!this.q.h.a()) && (localv.q())))
        {
          i += 1;
          break;
        }
        return localView;
      }
      return null;
    }
    
    public void c(int paramInt1, int paramInt2)
    {
      View localView = h(paramInt1);
      if (localView == null) {
        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + paramInt1);
      }
      g(paramInt1);
      c(localView, paramInt2);
    }
    
    public void c(ao.n paramn)
    {
      int i = t() - 1;
      while (i >= 0)
      {
        if (!ao.c(h(i)).c()) {
          a(i, paramn);
        }
        i -= 1;
      }
    }
    
    public void c(ao.n paramn, ao.s params)
    {
      Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }
    
    void c(ao paramao)
    {
      this.s = true;
      d(paramao);
    }
    
    public void c(ao paramao, int paramInt1, int paramInt2) {}
    
    public void c(View paramView)
    {
      this.p.a(paramView);
    }
    
    public void c(View paramView, int paramInt)
    {
      a(paramView, paramInt, (ao.i)paramView.getLayoutParams());
    }
    
    public void c(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
    
    public int d(ao.n paramn, ao.s params)
    {
      return 0;
    }
    
    public int d(ao.s params)
    {
      return 0;
    }
    
    public int d(View paramView)
    {
      return ((ao.i)paramView.getLayoutParams()).e();
    }
    
    public View d(View paramView, int paramInt)
    {
      return null;
    }
    
    public void d(int paramInt) {}
    
    public void d(int paramInt1, int paramInt2)
    {
      ao.b(this.q, paramInt1, paramInt2);
    }
    
    public void d(ao paramao) {}
    
    public boolean d()
    {
      return false;
    }
    
    public int e(ao.s params)
    {
      return 0;
    }
    
    public View e(View paramView)
    {
      if (this.q == null) {}
      do
      {
        return null;
        paramView = this.q.b(paramView);
      } while ((paramView == null) || (this.p.c(paramView)));
      return paramView;
    }
    
    @Deprecated
    public void e(ao paramao) {}
    
    public boolean e()
    {
      return false;
    }
    
    public boolean e(ao.n paramn, ao.s params)
    {
      return false;
    }
    
    public int f(ao.s params)
    {
      return 0;
    }
    
    public int f(View paramView)
    {
      Rect localRect = ((ao.i)paramView.getLayoutParams()).b;
      int i = paramView.getMeasuredWidth();
      int j = localRect.left;
      return localRect.right + (i + j);
    }
    
    public void f(int paramInt)
    {
      if (h(paramInt) != null) {
        this.p.a(paramInt);
      }
    }
    
    void f(ao paramao)
    {
      a(View.MeasureSpec.makeMeasureSpec(paramao.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramao.getHeight(), 1073741824));
    }
    
    public int g(ao.s params)
    {
      return 0;
    }
    
    public int g(View paramView)
    {
      Rect localRect = ((ao.i)paramView.getLayoutParams()).b;
      int i = paramView.getMeasuredHeight();
      int j = localRect.top;
      return localRect.bottom + (i + j);
    }
    
    public void g(int paramInt)
    {
      a(paramInt, h(paramInt));
    }
    
    public int h(View paramView)
    {
      return paramView.getLeft() - n(paramView);
    }
    
    public View h(int paramInt)
    {
      if (this.p != null) {
        return this.p.b(paramInt);
      }
      return null;
    }
    
    public int i(View paramView)
    {
      return paramView.getTop() - l(paramView);
    }
    
    public void i(int paramInt)
    {
      if (this.q != null) {
        this.q.b(paramInt);
      }
    }
    
    public int j(View paramView)
    {
      return paramView.getRight() + o(paramView);
    }
    
    public void j(int paramInt)
    {
      if (this.q != null) {
        this.q.a(paramInt);
      }
    }
    
    public int k(View paramView)
    {
      return paramView.getBottom() + m(paramView);
    }
    
    public void k(int paramInt) {}
    
    boolean k()
    {
      return false;
    }
    
    public int l(View paramView)
    {
      return ((ao.i)paramView.getLayoutParams()).b.top;
    }
    
    public int m(View paramView)
    {
      return ((ao.i)paramView.getLayoutParams()).b.bottom;
    }
    
    public int n(View paramView)
    {
      return ((ao.i)paramView.getLayoutParams()).b.left;
    }
    
    public void n()
    {
      if (this.q != null) {
        this.q.requestLayout();
      }
    }
    
    public int o(View paramView)
    {
      return ((ao.i)paramView.getLayoutParams()).b.right;
    }
    
    public boolean o()
    {
      return this.s;
    }
    
    public boolean p()
    {
      return (this.q != null) && (ao.o(this.q));
    }
    
    public boolean q()
    {
      return (this.r != null) && (this.r.c());
    }
    
    public int r()
    {
      return android.support.v4.j.af.h(this.q);
    }
    
    public int s()
    {
      return -1;
    }
    
    public int t()
    {
      if (this.p != null) {
        return this.p.b();
      }
      return 0;
    }
    
    public int u()
    {
      return this.d;
    }
    
    public int v()
    {
      return this.e;
    }
    
    public int w()
    {
      return this.f;
    }
    
    public int x()
    {
      return this.g;
    }
    
    public int y()
    {
      if (this.q != null) {
        return this.q.getPaddingLeft();
      }
      return 0;
    }
    
    public int z()
    {
      if (this.q != null) {
        return this.q.getPaddingTop();
      }
      return 0;
    }
    
    public static class a
    {
      public int a;
      public int b;
      public boolean c;
      public boolean d;
    }
  }
  
  public static class i
    extends ViewGroup.MarginLayoutParams
  {
    ao.v a;
    final Rect b = new Rect();
    boolean c = true;
    boolean d = false;
    
    public i(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public i(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public i(i parami)
    {
      super();
    }
    
    public i(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public i(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public boolean c()
    {
      return this.a.q();
    }
    
    public boolean d()
    {
      return this.a.x();
    }
    
    public int e()
    {
      return this.a.d();
    }
  }
  
  public static abstract interface j
  {
    public abstract void a(View paramView);
    
    public abstract void b(View paramView);
  }
  
  public static abstract interface k
  {
    public abstract void a(boolean paramBoolean);
    
    public abstract boolean a(ao paramao, MotionEvent paramMotionEvent);
    
    public abstract void b(ao paramao, MotionEvent paramMotionEvent);
  }
  
  public static abstract class l
  {
    public void a(ao paramao, int paramInt) {}
    
    public void a(ao paramao, int paramInt1, int paramInt2) {}
  }
  
  public static class m
  {
    private SparseArray<ArrayList<ao.v>> a = new SparseArray();
    private SparseIntArray b = new SparseIntArray();
    private int c = 0;
    
    private ArrayList<ao.v> b(int paramInt)
    {
      ArrayList localArrayList2 = (ArrayList)this.a.get(paramInt);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList2 = new ArrayList();
        this.a.put(paramInt, localArrayList2);
        localArrayList1 = localArrayList2;
        if (this.b.indexOfKey(paramInt) < 0)
        {
          this.b.put(paramInt, 5);
          localArrayList1 = localArrayList2;
        }
      }
      return localArrayList1;
    }
    
    public ao.v a(int paramInt)
    {
      ArrayList localArrayList = (ArrayList)this.a.get(paramInt);
      if ((localArrayList != null) && (!localArrayList.isEmpty()))
      {
        paramInt = localArrayList.size() - 1;
        ao.v localv = (ao.v)localArrayList.get(paramInt);
        localArrayList.remove(paramInt);
        return localv;
      }
      return null;
    }
    
    public void a()
    {
      this.a.clear();
    }
    
    void a(ao.a parama)
    {
      this.c += 1;
    }
    
    void a(ao.a parama1, ao.a parama2, boolean paramBoolean)
    {
      if (parama1 != null) {
        b();
      }
      if ((!paramBoolean) && (this.c == 0)) {
        a();
      }
      if (parama2 != null) {
        a(parama2);
      }
    }
    
    public void a(ao.v paramv)
    {
      int i = paramv.h();
      ArrayList localArrayList = b(i);
      if (this.b.get(i) <= localArrayList.size()) {
        return;
      }
      paramv.v();
      localArrayList.add(paramv);
    }
    
    void b()
    {
      this.c -= 1;
    }
  }
  
  public final class n
  {
    final ArrayList<ao.v> a = new ArrayList();
    final ArrayList<ao.v> b = new ArrayList();
    private ArrayList<ao.v> d = null;
    private final List<ao.v> e = Collections.unmodifiableList(this.a);
    private int f = 2;
    private ao.m g;
    private ao.t h;
    
    public n() {}
    
    private void a(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      int i = paramViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof ViewGroup)) {
          a((ViewGroup)localView, true);
        }
        i -= 1;
      }
      if (!paramBoolean) {
        return;
      }
      if (paramViewGroup.getVisibility() == 4)
      {
        paramViewGroup.setVisibility(0);
        paramViewGroup.setVisibility(4);
        return;
      }
      i = paramViewGroup.getVisibility();
      paramViewGroup.setVisibility(4);
      paramViewGroup.setVisibility(i);
    }
    
    private void d(View paramView)
    {
      if (ao.this.i())
      {
        if (android.support.v4.j.af.e(paramView) == 0) {
          android.support.v4.j.af.c(paramView, 1);
        }
        if (!android.support.v4.j.af.b(paramView)) {
          android.support.v4.j.af.a(paramView, ao.l(ao.this).b());
        }
      }
    }
    
    private void f(ao.v paramv)
    {
      if ((paramv.a instanceof ViewGroup)) {
        a((ViewGroup)paramv.a, false);
      }
    }
    
    ao.v a(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int j = 0;
      int k = this.a.size();
      int i = 0;
      Object localObject;
      ao.v localv;
      for (;;)
      {
        if (i < k)
        {
          localObject = (ao.v)this.a.get(i);
          if ((((ao.v)localObject).k()) || (((ao.v)localObject).d() != paramInt1) || (((ao.v)localObject).n()) || ((!ao.s.f(ao.this.h)) && (((ao.v)localObject).q()))) {
            break label251;
          }
          if ((paramInt2 != -1) && (((ao.v)localObject).h() != paramInt2)) {
            Log.e("RecyclerView", "Scrap view for position " + paramInt1 + " isn't dirty but has" + " wrong view type! (found " + ((ao.v)localObject).h() + " but expected " + paramInt2 + ")");
          }
        }
        else
        {
          if (paramBoolean) {
            break label288;
          }
          localObject = ao.this.d.a(paramInt1, paramInt2);
          if (localObject == null) {
            break label288;
          }
          localv = ao.c((View)localObject);
          ao.this.d.e((View)localObject);
          paramInt1 = ao.this.d.b((View)localObject);
          if (paramInt1 != -1) {
            break;
          }
          throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + localv);
        }
        ((ao.v)localObject).b(32);
        return (ao.v)localObject;
        label251:
        i += 1;
      }
      ao.this.d.d(paramInt1);
      c((View)localObject);
      localv.b(8224);
      return localv;
      label288:
      i = this.b.size();
      paramInt2 = j;
      for (;;)
      {
        if (paramInt2 >= i) {
          break label363;
        }
        localv = (ao.v)this.b.get(paramInt2);
        if ((!localv.n()) && (localv.d() == paramInt1))
        {
          localObject = localv;
          if (paramBoolean) {
            break;
          }
          this.b.remove(paramInt2);
          return localv;
        }
        paramInt2 += 1;
      }
      label363:
      return null;
    }
    
    ao.v a(long paramLong, int paramInt, boolean paramBoolean)
    {
      int i = this.a.size() - 1;
      ao.v localv2;
      ao.v localv1;
      while (i >= 0)
      {
        localv2 = (ao.v)this.a.get(i);
        if ((localv2.g() == paramLong) && (!localv2.k()))
        {
          if (paramInt == localv2.h())
          {
            localv2.b(32);
            localv1 = localv2;
            if (localv2.q())
            {
              localv1 = localv2;
              if (!ao.this.h.a())
              {
                localv2.a(2, 14);
                localv1 = localv2;
              }
            }
            return localv1;
          }
          if (!paramBoolean)
          {
            this.a.remove(i);
            ao.this.removeDetachedView(localv2.a, false);
            b(localv2.a);
          }
        }
        i -= 1;
      }
      i = this.b.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label245;
        }
        localv2 = (ao.v)this.b.get(i);
        if (localv2.g() == paramLong)
        {
          if (paramInt == localv2.h())
          {
            localv1 = localv2;
            if (paramBoolean) {
              break;
            }
            this.b.remove(i);
            return localv2;
          }
          if (!paramBoolean) {
            d(i);
          }
        }
        i -= 1;
      }
      label245:
      return null;
    }
    
    View a(int paramInt, boolean paramBoolean)
    {
      boolean bool = true;
      if ((paramInt < 0) || (paramInt >= ao.this.h.e())) {
        throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + ao.this.h.e());
      }
      Object localObject2;
      int i;
      if (ao.this.h.a())
      {
        localObject2 = f(paramInt);
        if (localObject2 != null) {
          i = 1;
        }
      }
      for (;;)
      {
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = a(paramInt, -1, paramBoolean);
          localObject1 = localObject2;
          if (localObject2 != null) {
            if (!a((ao.v)localObject2)) {
              if (!paramBoolean)
              {
                ((ao.v)localObject2).b(4);
                if (((ao.v)localObject2).i())
                {
                  ao.this.removeDetachedView(((ao.v)localObject2).a, false);
                  ((ao.v)localObject2).j();
                  label173:
                  b((ao.v)localObject2);
                }
              }
              else
              {
                localObject1 = null;
              }
            }
          }
        }
        for (;;)
        {
          Object localObject3 = localObject1;
          int k = i;
          int j;
          if (localObject1 == null)
          {
            k = ao.this.c.b(paramInt);
            if ((k < 0) || (k >= ao.f(ao.this).a()))
            {
              throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + k + ")." + "state:" + ao.this.h.e());
              i = 0;
              break;
              if (!((ao.v)localObject2).k()) {
                break label173;
              }
              ((ao.v)localObject2).l();
              break label173;
              i = 1;
              localObject1 = localObject2;
              continue;
            }
            int m = ao.f(ao.this).a(k);
            localObject2 = localObject1;
            j = i;
            if (ao.f(ao.this).b())
            {
              localObject1 = a(ao.f(ao.this).b(k), m, paramBoolean);
              localObject2 = localObject1;
              j = i;
              if (localObject1 != null)
              {
                ((ao.v)localObject1).b = k;
                j = 1;
                localObject2 = localObject1;
              }
            }
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (this.h != null)
              {
                localObject3 = this.h.a(this, paramInt, m);
                localObject1 = localObject2;
                if (localObject3 != null)
                {
                  localObject2 = ao.this.a((View)localObject3);
                  if (localObject2 == null) {
                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                  }
                  localObject1 = localObject2;
                  if (((ao.v)localObject2).c()) {
                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                  }
                }
              }
            }
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject1 = f().a(m);
              localObject2 = localObject1;
              if (localObject1 != null)
              {
                ((ao.v)localObject1).v();
                localObject2 = localObject1;
                if (ao.r())
                {
                  f((ao.v)localObject1);
                  localObject2 = localObject1;
                }
              }
            }
            localObject3 = localObject2;
            k = j;
            if (localObject2 == null) {
              localObject2 = ao.f(ao.this).b(ao.this, m);
            }
          }
          for (i = j;; i = k)
          {
            if ((i != 0) && (!ao.this.h.a()) && (((ao.v)localObject2).a(8192)))
            {
              ((ao.v)localObject2).a(0, 8192);
              if (ao.s.c(ao.this.h))
              {
                j = ao.e.d((ao.v)localObject2);
                localObject1 = ao.this.g.a(ao.this.h, (ao.v)localObject2, j | 0x1000, ((ao.v)localObject2).u());
                ao.a(ao.this, (ao.v)localObject2, (ao.e.c)localObject1);
              }
            }
            if ((ao.this.h.a()) && (((ao.v)localObject2).p()))
            {
              ((ao.v)localObject2).f = paramInt;
              paramInt = 0;
            }
            for (;;)
            {
              localObject1 = ((ao.v)localObject2).a.getLayoutParams();
              if (localObject1 == null)
              {
                localObject1 = (ao.i)ao.this.generateDefaultLayoutParams();
                ((ao.v)localObject2).a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                label726:
                ((ao.i)localObject1).a = ((ao.v)localObject2);
                if ((i == 0) || (paramInt == 0)) {
                  break label891;
                }
              }
              label891:
              for (paramBoolean = bool;; paramBoolean = false)
              {
                ((ao.i)localObject1).d = paramBoolean;
                return ((ao.v)localObject2).a;
                if ((((ao.v)localObject2).p()) && (!((ao.v)localObject2).o()) && (!((ao.v)localObject2).n())) {
                  break label896;
                }
                j = ao.this.c.b(paramInt);
                ((ao.v)localObject2).k = ao.this;
                ao.f(ao.this).b((ao.v)localObject2, j);
                d(((ao.v)localObject2).a);
                if (ao.this.h.a()) {
                  ((ao.v)localObject2).f = paramInt;
                }
                paramInt = 1;
                break;
                if (!ao.this.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
                {
                  localObject1 = (ao.i)ao.this.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
                  ((ao.v)localObject2).a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  break label726;
                }
                localObject1 = (ao.i)localObject1;
                break label726;
              }
              label896:
              paramInt = 0;
            }
            localObject2 = localObject3;
          }
        }
        localObject2 = null;
        i = 0;
      }
    }
    
    public void a()
    {
      this.a.clear();
      c();
    }
    
    public void a(int paramInt)
    {
      this.f = paramInt;
      int i = this.b.size() - 1;
      while ((i >= 0) && (this.b.size() > paramInt))
      {
        d(i);
        i -= 1;
      }
    }
    
    void a(int paramInt1, int paramInt2)
    {
      int i;
      int j;
      int k;
      int m;
      label26:
      ao.v localv;
      if (paramInt1 < paramInt2)
      {
        i = -1;
        j = paramInt2;
        k = paramInt1;
        int n = this.b.size();
        m = 0;
        if (m >= n) {
          return;
        }
        localv = (ao.v)this.b.get(m);
        if ((localv != null) && (localv.b >= k) && (localv.b <= j)) {
          break label89;
        }
      }
      for (;;)
      {
        m += 1;
        break label26;
        i = 1;
        j = paramInt1;
        k = paramInt2;
        break;
        label89:
        if (localv.b == paramInt1) {
          localv.a(paramInt2 - paramInt1, false);
        } else {
          localv.a(i, false);
        }
      }
    }
    
    void a(ao.a parama1, ao.a parama2, boolean paramBoolean)
    {
      a();
      f().a(parama1, parama2, paramBoolean);
    }
    
    void a(ao.m paramm)
    {
      if (this.g != null) {
        this.g.b();
      }
      this.g = paramm;
      if (paramm != null) {
        this.g.a(ao.this.getAdapter());
      }
    }
    
    void a(ao.t paramt)
    {
      this.h = paramt;
    }
    
    public void a(View paramView)
    {
      ao.v localv = ao.c(paramView);
      if (localv.r()) {
        ao.this.removeDetachedView(paramView, false);
      }
      if (localv.i()) {
        localv.j();
      }
      for (;;)
      {
        b(localv);
        return;
        if (localv.k()) {
          localv.l();
        }
      }
    }
    
    boolean a(ao.v paramv)
    {
      boolean bool2 = true;
      boolean bool1;
      if (paramv.q()) {
        bool1 = ao.this.h.a();
      }
      do
      {
        do
        {
          return bool1;
          if ((paramv.b < 0) || (paramv.b >= ao.f(ao.this).a())) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + paramv);
          }
          if ((!ao.this.h.a()) && (ao.f(ao.this).a(paramv.b) != paramv.h())) {
            return false;
          }
          bool1 = bool2;
        } while (!ao.f(ao.this).b());
        bool1 = bool2;
      } while (paramv.g() == ao.f(ao.this).b(paramv.b));
      return false;
    }
    
    public int b(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= ao.this.h.e())) {
        throw new IndexOutOfBoundsException("invalid position " + paramInt + ". State " + "item count is " + ao.this.h.e());
      }
      if (!ao.this.h.a()) {
        return paramInt;
      }
      return ao.this.c.b(paramInt);
    }
    
    public List<ao.v> b()
    {
      return this.e;
    }
    
    void b(int paramInt1, int paramInt2)
    {
      int j = this.b.size();
      int i = 0;
      while (i < j)
      {
        ao.v localv = (ao.v)this.b.get(i);
        if ((localv != null) && (localv.b >= paramInt1)) {
          localv.a(paramInt2, true);
        }
        i += 1;
      }
    }
    
    void b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int i = this.b.size() - 1;
      if (i >= 0)
      {
        ao.v localv = (ao.v)this.b.get(i);
        if (localv != null)
        {
          if (localv.b < paramInt1 + paramInt2) {
            break label63;
          }
          localv.a(-paramInt2, paramBoolean);
        }
        for (;;)
        {
          i -= 1;
          break;
          label63:
          if (localv.b >= paramInt1)
          {
            localv.b(8);
            d(i);
          }
        }
      }
    }
    
    void b(ao.v paramv)
    {
      boolean bool = true;
      int j = 0;
      if ((paramv.i()) || (paramv.a.getParent() != null))
      {
        StringBuilder localStringBuilder = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(paramv.i()).append(" isAttached:");
        if (paramv.a.getParent() != null) {}
        for (;;)
        {
          throw new IllegalArgumentException(bool);
          bool = false;
        }
      }
      if (paramv.r()) {
        throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramv);
      }
      if (paramv.c()) {
        throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
      }
      bool = ao.v.c(paramv);
      int i;
      if ((ao.f(ao.this) != null) && (bool) && (ao.f(ao.this).b(paramv)))
      {
        i = 1;
        if ((i == 0) && (!paramv.w())) {
          break label293;
        }
        if (paramv.a(14)) {
          break label288;
        }
        i = this.b.size();
        if ((i == this.f) && (i > 0)) {
          d(0);
        }
        if (i >= this.f) {
          break label288;
        }
        this.b.add(paramv);
        i = 1;
        label237:
        if (i != 0) {
          break label285;
        }
        c(paramv);
        j = 1;
      }
      for (;;)
      {
        ao.this.e.g(paramv);
        if ((i == 0) && (j == 0) && (bool)) {
          paramv.k = null;
        }
        return;
        i = 0;
        break;
        label285:
        continue;
        label288:
        i = 0;
        break label237;
        label293:
        i = 0;
      }
    }
    
    void b(View paramView)
    {
      paramView = ao.c(paramView);
      ao.v.a(paramView, null);
      ao.v.a(paramView, false);
      paramView.l();
      b(paramView);
    }
    
    public View c(int paramInt)
    {
      return a(paramInt, false);
    }
    
    void c()
    {
      int i = this.b.size() - 1;
      while (i >= 0)
      {
        d(i);
        i -= 1;
      }
      this.b.clear();
    }
    
    void c(int paramInt1, int paramInt2)
    {
      int i = this.b.size() - 1;
      if (i >= 0)
      {
        ao.v localv = (ao.v)this.b.get(i);
        if (localv == null) {}
        for (;;)
        {
          i -= 1;
          break;
          int j = localv.d();
          if ((j >= paramInt1) && (j < paramInt1 + paramInt2))
          {
            localv.b(2);
            d(i);
          }
        }
      }
    }
    
    void c(ao.v paramv)
    {
      android.support.v4.j.af.a(paramv.a, null);
      e(paramv);
      paramv.k = null;
      f().a(paramv);
    }
    
    void c(View paramView)
    {
      paramView = ao.c(paramView);
      if ((paramView.a(12)) || (!paramView.x()) || (ao.a(ao.this, paramView)))
      {
        if ((paramView.n()) && (!paramView.q()) && (!ao.f(ao.this).b())) {
          throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        }
        paramView.a(this, false);
        this.a.add(paramView);
        return;
      }
      if (this.d == null) {
        this.d = new ArrayList();
      }
      paramView.a(this, true);
      this.d.add(paramView);
    }
    
    int d()
    {
      return this.a.size();
    }
    
    void d(int paramInt)
    {
      c((ao.v)this.b.get(paramInt));
      this.b.remove(paramInt);
    }
    
    void d(ao.v paramv)
    {
      if (ao.v.d(paramv)) {
        this.d.remove(paramv);
      }
      for (;;)
      {
        ao.v.a(paramv, null);
        ao.v.a(paramv, false);
        paramv.l();
        return;
        this.a.remove(paramv);
      }
    }
    
    View e(int paramInt)
    {
      return ((ao.v)this.a.get(paramInt)).a;
    }
    
    void e()
    {
      this.a.clear();
      if (this.d != null) {
        this.d.clear();
      }
    }
    
    void e(ao.v paramv)
    {
      if (ao.m(ao.this) != null) {
        ao.m(ao.this).a(paramv);
      }
      if (ao.f(ao.this) != null) {
        ao.f(ao.this).a(paramv);
      }
      if (ao.this.h != null) {
        ao.this.e.g(paramv);
      }
    }
    
    ao.m f()
    {
      if (this.g == null) {
        this.g = new ao.m();
      }
      return this.g;
    }
    
    ao.v f(int paramInt)
    {
      int j = 0;
      int k;
      if (this.d != null)
      {
        k = this.d.size();
        if (k != 0) {}
      }
      else
      {
        return null;
      }
      int i = 0;
      ao.v localv;
      while (i < k)
      {
        localv = (ao.v)this.d.get(i);
        if ((!localv.k()) && (localv.d() == paramInt))
        {
          localv.b(32);
          return localv;
        }
        i += 1;
      }
      if (ao.f(ao.this).b())
      {
        paramInt = ao.this.c.b(paramInt);
        if ((paramInt > 0) && (paramInt < ao.f(ao.this).a()))
        {
          long l = ao.f(ao.this).b(paramInt);
          paramInt = j;
          while (paramInt < k)
          {
            localv = (ao.v)this.d.get(paramInt);
            if ((!localv.k()) && (localv.g() == l))
            {
              localv.b(32);
              return localv;
            }
            paramInt += 1;
          }
        }
      }
      return null;
    }
    
    void g()
    {
      int j;
      int i;
      if ((ao.f(ao.this) != null) && (ao.f(ao.this).b()))
      {
        j = this.b.size();
        i = 0;
      }
      while (i < j)
      {
        ao.v localv = (ao.v)this.b.get(i);
        if (localv != null)
        {
          localv.b(6);
          localv.a(null);
        }
        i += 1;
        continue;
        c();
      }
    }
    
    void h()
    {
      int j = 0;
      int k = this.b.size();
      int i = 0;
      while (i < k)
      {
        ((ao.v)this.b.get(i)).a();
        i += 1;
      }
      k = this.a.size();
      i = 0;
      while (i < k)
      {
        ((ao.v)this.a.get(i)).a();
        i += 1;
      }
      if (this.d != null)
      {
        k = this.d.size();
        i = j;
        while (i < k)
        {
          ((ao.v)this.d.get(i)).a();
          i += 1;
        }
      }
    }
    
    void i()
    {
      int j = this.b.size();
      int i = 0;
      while (i < j)
      {
        ao.i locali = (ao.i)((ao.v)this.b.get(i)).a.getLayoutParams();
        if (locali != null) {
          locali.c = true;
        }
        i += 1;
      }
    }
  }
  
  public static abstract interface o
  {
    public abstract void a(ao.v paramv);
  }
  
  private class p
    extends ao.c
  {
    private p() {}
  }
  
  public static class q
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<q> CREATOR = new Parcelable.Creator()
    {
      public ao.q a(Parcel paramAnonymousParcel)
      {
        return new ao.q(paramAnonymousParcel);
      }
      
      public ao.q[] a(int paramAnonymousInt)
      {
        return new ao.q[paramAnonymousInt];
      }
    };
    Parcelable a;
    
    q(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readParcelable(ao.h.class.getClassLoader());
    }
    
    q(Parcelable paramParcelable)
    {
      super();
    }
    
    private void a(q paramq)
    {
      this.a = paramq.a;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(this.a, 0);
    }
  }
  
  public static abstract class r
  {
    private int a;
    private ao b;
    private ao.h c;
    private boolean d;
    private boolean e;
    private View f;
    private final a g;
    
    private void a(int paramInt1, int paramInt2)
    {
      ao localao = this.b;
      if ((!this.e) || (this.a == -1) || (localao == null)) {
        a();
      }
      this.d = false;
      if (this.f != null)
      {
        if (a(this.f) != this.a) {
          break label146;
        }
        a(this.f, localao.h, this.g);
        a.a(this.g, localao);
        a();
      }
      for (;;)
      {
        if (this.e)
        {
          a(paramInt1, paramInt2, localao.h, this.g);
          boolean bool = this.g.a();
          a.a(this.g, localao);
          if (bool)
          {
            if (!this.e) {
              break;
            }
            this.d = true;
            ao.p(localao).a();
          }
        }
        return;
        label146:
        Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
        this.f = null;
      }
      a();
    }
    
    public int a(View paramView)
    {
      return this.b.d(paramView);
    }
    
    protected final void a()
    {
      if (!this.e) {
        return;
      }
      e();
      ao.s.e(this.b.h, -1);
      this.f = null;
      this.a = -1;
      this.d = false;
      this.e = false;
      ao.h.a(this.c, this);
      this.c = null;
      this.b = null;
    }
    
    public void a(int paramInt)
    {
      this.a = paramInt;
    }
    
    protected abstract void a(int paramInt1, int paramInt2, ao.s params, a parama);
    
    protected abstract void a(View paramView, ao.s params, a parama);
    
    protected void b(View paramView)
    {
      if (a(paramView) == d()) {
        this.f = paramView;
      }
    }
    
    public boolean b()
    {
      return this.d;
    }
    
    public boolean c()
    {
      return this.e;
    }
    
    public int d()
    {
      return this.a;
    }
    
    protected abstract void e();
    
    public static class a
    {
      private int a;
      private int b;
      private int c;
      private int d;
      private Interpolator e;
      private boolean f;
      private int g;
      
      private void a(ao paramao)
      {
        if (this.d >= 0)
        {
          int i = this.d;
          this.d = -1;
          ao.c(paramao, i);
          this.f = false;
          return;
        }
        if (this.f)
        {
          b();
          if (this.e == null) {
            if (this.c == Integer.MIN_VALUE) {
              ao.p(paramao).b(this.a, this.b);
            }
          }
          for (;;)
          {
            this.g += 1;
            if (this.g > 10) {
              Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }
            this.f = false;
            return;
            ao.p(paramao).a(this.a, this.b, this.c);
            continue;
            ao.p(paramao).a(this.a, this.b, this.c, this.e);
          }
        }
        this.g = 0;
      }
      
      private void b()
      {
        if ((this.e != null) && (this.c < 1)) {
          throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        if (this.c < 1) {
          throw new IllegalStateException("Scroll duration must be a positive number");
        }
      }
      
      boolean a()
      {
        return this.d >= 0;
      }
    }
  }
  
  public static class s
  {
    int a = 0;
    private int b = -1;
    private int c = 1;
    private SparseArray<Object> d;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    
    void a(int paramInt)
    {
      if ((this.c & paramInt) == 0) {
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(this.c));
      }
    }
    
    public boolean a()
    {
      return this.h;
    }
    
    public boolean b()
    {
      return this.j;
    }
    
    public int c()
    {
      return this.b;
    }
    
    public boolean d()
    {
      return this.b != -1;
    }
    
    public int e()
    {
      if (this.h) {
        return this.e - this.f;
      }
      return this.a;
    }
    
    public String toString()
    {
      return "State{mTargetPosition=" + this.b + ", mData=" + this.d + ", mItemCount=" + this.a + ", mPreviousLayoutItemCount=" + this.e + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f + ", mStructureChanged=" + this.g + ", mInPreLayout=" + this.h + ", mRunSimpleAnimations=" + this.i + ", mRunPredictiveAnimations=" + this.j + '}';
    }
  }
  
  public static abstract class t
  {
    public abstract View a(ao.n paramn, int paramInt1, int paramInt2);
  }
  
  private class u
    implements Runnable
  {
    private int b;
    private int c;
    private u d = u.a(ao.this.getContext(), ao.q());
    private Interpolator e = ao.q();
    private boolean f = false;
    private boolean g = false;
    
    public u() {}
    
    private float a(float paramFloat)
    {
      return (float)Math.sin((float)((paramFloat - 0.5F) * 0.4712389167638204D));
    }
    
    private int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int j = Math.abs(paramInt1);
      int k = Math.abs(paramInt2);
      int i;
      if (j > k)
      {
        i = 1;
        paramInt3 = (int)Math.sqrt(paramInt3 * paramInt3 + paramInt4 * paramInt4);
        paramInt2 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
        if (i == 0) {
          break label140;
        }
      }
      label140:
      for (paramInt1 = ao.this.getWidth();; paramInt1 = ao.this.getHeight())
      {
        paramInt4 = paramInt1 / 2;
        float f3 = Math.min(1.0F, paramInt2 * 1.0F / paramInt1);
        float f1 = paramInt4;
        float f2 = paramInt4;
        f3 = a(f3);
        if (paramInt3 <= 0) {
          break label151;
        }
        paramInt1 = Math.round(1000.0F * Math.abs((f3 * f2 + f1) / paramInt3)) * 4;
        return Math.min(paramInt1, 2000);
        i = 0;
        break;
      }
      label151:
      if (i != 0) {}
      for (paramInt2 = j;; paramInt2 = k)
      {
        paramInt1 = (int)((paramInt2 / paramInt1 + 1.0F) * 300.0F);
        break;
      }
    }
    
    private void c()
    {
      this.g = false;
      this.f = true;
    }
    
    private void d()
    {
      this.f = false;
      if (this.g) {
        a();
      }
    }
    
    void a()
    {
      if (this.f)
      {
        this.g = true;
        return;
      }
      ao.this.removeCallbacks(this);
      android.support.v4.j.af.a(ao.this, this);
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      ao.b(ao.this, 2);
      this.c = 0;
      this.b = 0;
      this.d.a(0, 0, paramInt1, paramInt2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
      a();
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3)
    {
      a(paramInt1, paramInt2, paramInt3, ao.q());
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      a(paramInt1, paramInt2, b(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
    {
      if (this.e != paramInterpolator)
      {
        this.e = paramInterpolator;
        this.d = u.a(ao.this.getContext(), paramInterpolator);
      }
      ao.b(ao.this, 2);
      this.c = 0;
      this.b = 0;
      this.d.a(0, 0, paramInt1, paramInt2, paramInt3);
      a();
    }
    
    public void b()
    {
      ao.this.removeCallbacks(this);
      this.d.h();
    }
    
    public void b(int paramInt1, int paramInt2)
    {
      a(paramInt1, paramInt2, 0, 0);
    }
    
    public void run()
    {
      if (ao.this.f == null)
      {
        b();
        return;
      }
      c();
      ao.c(ao.this);
      u localu = this.d;
      ao.r localr = ao.this.f.r;
      int i6;
      int i7;
      int i4;
      int i5;
      int i1;
      int k;
      int j;
      int i3;
      int i;
      int n;
      int m;
      if (localu.g())
      {
        i6 = localu.b();
        i7 = localu.c();
        i4 = i6 - this.b;
        i5 = i7 - this.c;
        i1 = 0;
        k = 0;
        i2 = 0;
        j = 0;
        this.b = i6;
        this.c = i7;
        i3 = 0;
        i = 0;
        n = 0;
        m = 0;
        if (ao.f(ao.this) == null) {
          break label728;
        }
        ao.this.b();
        ao.g(ao.this);
        g.a("RV Scroll");
        if (i4 != 0)
        {
          k = ao.this.f.a(i4, ao.this.b, ao.this.h);
          i = i4 - k;
        }
        if (i5 != 0)
        {
          j = ao.this.f.b(i5, ao.this.b, ao.this.h);
          m = i5 - j;
        }
        g.a();
        ao.h(ao.this);
        ao.i(ao.this);
        ao.this.a(false);
        n = m;
        i2 = j;
        i3 = i;
        i1 = k;
        if (localr == null) {
          break label728;
        }
        n = m;
        i2 = j;
        i3 = i;
        i1 = k;
        if (localr.b()) {
          break label728;
        }
        n = m;
        i2 = j;
        i3 = i;
        i1 = k;
        if (!localr.c()) {
          break label728;
        }
        n = ao.this.h.e();
        if (n != 0) {
          break label660;
        }
        localr.a();
        n = j;
        j = i;
        if (!ao.j(ao.this).isEmpty()) {
          ao.this.invalidate();
        }
        if (android.support.v4.j.af.a(ao.this) != 2) {
          ao.a(ao.this, i4, i5);
        }
        if ((j != 0) || (m != 0))
        {
          i1 = (int)localu.f();
          if (j == i6) {
            break label804;
          }
          if (j >= 0) {
            break label747;
          }
          i = -i1;
        }
      }
      label413:
      label432:
      label559:
      label587:
      label608:
      label660:
      label728:
      label747:
      label781:
      label787:
      label792:
      label804:
      for (int i2 = i;; i2 = 0)
      {
        if (m != i7) {
          if (m < 0) {
            i = -i1;
          }
        }
        for (;;)
        {
          if (android.support.v4.j.af.a(ao.this) != 2) {
            ao.this.c(i2, i);
          }
          if (((i2 != 0) || (j == i6) || (localu.d() == 0)) && ((i != 0) || (m == i7) || (localu.e() == 0))) {
            localu.h();
          }
          if ((k != 0) || (n != 0)) {
            ao.this.h(k, n);
          }
          if (!ao.k(ao.this)) {
            ao.this.invalidate();
          }
          if ((i5 != 0) && (ao.this.f.e()) && (n == i5))
          {
            i = 1;
            if ((i4 == 0) || (!ao.this.f.d()) || (k != i4)) {
              break label781;
            }
            j = 1;
            if (((i4 != 0) || (i5 != 0)) && (j == 0) && (i == 0)) {
              break label787;
            }
            i = 1;
            if ((!localu.a()) && (i != 0)) {
              break label792;
            }
            ao.b(ao.this, 0);
          }
          for (;;)
          {
            if (localr != null)
            {
              if (localr.b()) {
                ao.r.a(localr, 0, 0);
              }
              if (!this.g) {
                localr.a();
              }
            }
            d();
            return;
            if (localr.d() >= n)
            {
              localr.a(n - 1);
              ao.r.a(localr, i4 - i, i5 - m);
              n = j;
              j = i;
              break;
            }
            ao.r.a(localr, i4 - i, i5 - m);
            i1 = k;
            i3 = i;
            i2 = j;
            n = m;
            j = i3;
            m = n;
            n = i2;
            k = i1;
            break;
            if (j > 0)
            {
              i = i1;
              break label413;
            }
            i = 0;
            break label413;
            i = i1;
            if (m > 0) {
              break label432;
            }
            i = 0;
            break label432;
            i = 0;
            break label559;
            j = 0;
            break label587;
            i = 0;
            break label608;
            a();
          }
          i = 0;
        }
      }
    }
  }
  
  public static abstract class v
  {
    private static final List<Object> m = Collections.EMPTY_LIST;
    public final View a;
    int b;
    int c;
    long d;
    int e;
    int f;
    v g;
    v h;
    List<Object> i;
    List<Object> j;
    ao k;
    private int l;
    private int n;
    private ao.n o;
    private boolean p;
    private int q;
    
    private void A()
    {
      android.support.v4.j.af.c(this.a, this.q);
      this.q = 0;
    }
    
    private boolean B()
    {
      return (this.l & 0x10) != 0;
    }
    
    private boolean C()
    {
      return ((this.l & 0x10) == 0) && (android.support.v4.j.af.c(this.a));
    }
    
    private void y()
    {
      if (this.i == null)
      {
        this.i = new ArrayList();
        this.j = Collections.unmodifiableList(this.i);
      }
    }
    
    private void z()
    {
      this.q = android.support.v4.j.af.e(this.a);
      android.support.v4.j.af.c(this.a, 4);
    }
    
    void a()
    {
      this.c = -1;
      this.f = -1;
    }
    
    void a(int paramInt1, int paramInt2)
    {
      this.l = (this.l & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    }
    
    void a(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      b(8);
      a(paramInt2, paramBoolean);
      this.b = paramInt1;
    }
    
    void a(int paramInt, boolean paramBoolean)
    {
      if (this.c == -1) {
        this.c = this.b;
      }
      if (this.f == -1) {
        this.f = this.b;
      }
      if (paramBoolean) {
        this.f += paramInt;
      }
      this.b += paramInt;
      if (this.a.getLayoutParams() != null) {
        ((ao.i)this.a.getLayoutParams()).c = true;
      }
    }
    
    void a(ao.n paramn, boolean paramBoolean)
    {
      this.o = paramn;
      this.p = paramBoolean;
    }
    
    void a(Object paramObject)
    {
      if (paramObject == null) {
        b(1024);
      }
      while ((this.l & 0x400) != 0) {
        return;
      }
      y();
      this.i.add(paramObject);
    }
    
    public final void a(boolean paramBoolean)
    {
      int i1;
      if (paramBoolean)
      {
        i1 = this.n - 1;
        this.n = i1;
        if (this.n >= 0) {
          break label64;
        }
        this.n = 0;
        Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
      }
      label64:
      do
      {
        return;
        i1 = this.n + 1;
        break;
        if ((!paramBoolean) && (this.n == 1))
        {
          this.l |= 0x10;
          return;
        }
      } while ((!paramBoolean) || (this.n != 0));
      this.l &= 0xFFFFFFEF;
    }
    
    boolean a(int paramInt)
    {
      return (this.l & paramInt) != 0;
    }
    
    void b()
    {
      if (this.c == -1) {
        this.c = this.b;
      }
    }
    
    void b(int paramInt)
    {
      this.l |= paramInt;
    }
    
    boolean c()
    {
      return (this.l & 0x80) != 0;
    }
    
    public final int d()
    {
      if (this.f == -1) {
        return this.b;
      }
      return this.f;
    }
    
    public final int e()
    {
      if (this.k == null) {
        return -1;
      }
      return ao.b(this.k, this);
    }
    
    public final int f()
    {
      return this.c;
    }
    
    public final long g()
    {
      return this.d;
    }
    
    public final int h()
    {
      return this.e;
    }
    
    boolean i()
    {
      return this.o != null;
    }
    
    void j()
    {
      this.o.d(this);
    }
    
    boolean k()
    {
      return (this.l & 0x20) != 0;
    }
    
    void l()
    {
      this.l &= 0xFFFFFFDF;
    }
    
    void m()
    {
      this.l &= 0xFEFF;
    }
    
    boolean n()
    {
      return (this.l & 0x4) != 0;
    }
    
    boolean o()
    {
      return (this.l & 0x2) != 0;
    }
    
    boolean p()
    {
      return (this.l & 0x1) != 0;
    }
    
    boolean q()
    {
      return (this.l & 0x8) != 0;
    }
    
    boolean r()
    {
      return (this.l & 0x100) != 0;
    }
    
    boolean s()
    {
      return ((this.l & 0x200) != 0) || (n());
    }
    
    void t()
    {
      if (this.i != null) {
        this.i.clear();
      }
      this.l &= 0xFBFF;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.b + " id=" + this.d + ", oldPos=" + this.c + ", pLpos:" + this.f);
      StringBuilder localStringBuilder2;
      if (i())
      {
        localStringBuilder2 = localStringBuilder1.append(" scrap ");
        if (!this.p) {
          break label277;
        }
      }
      label277:
      for (String str = "[changeScrap]";; str = "[attachedScrap]")
      {
        localStringBuilder2.append(str);
        if (n()) {
          localStringBuilder1.append(" invalid");
        }
        if (!p()) {
          localStringBuilder1.append(" unbound");
        }
        if (o()) {
          localStringBuilder1.append(" update");
        }
        if (q()) {
          localStringBuilder1.append(" removed");
        }
        if (c()) {
          localStringBuilder1.append(" ignored");
        }
        if (r()) {
          localStringBuilder1.append(" tmpDetached");
        }
        if (!w()) {
          localStringBuilder1.append(" not recyclable(" + this.n + ")");
        }
        if (s()) {
          localStringBuilder1.append(" undefined adapter position");
        }
        if (this.a.getParent() == null) {
          localStringBuilder1.append(" no parent");
        }
        localStringBuilder1.append("}");
        return localStringBuilder1.toString();
      }
    }
    
    List<Object> u()
    {
      if ((this.l & 0x400) == 0)
      {
        if ((this.i == null) || (this.i.size() == 0)) {
          return m;
        }
        return this.j;
      }
      return m;
    }
    
    void v()
    {
      this.l = 0;
      this.b = -1;
      this.c = -1;
      this.d = -1L;
      this.f = -1;
      this.n = 0;
      this.g = null;
      this.h = null;
      t();
      this.q = 0;
    }
    
    public final boolean w()
    {
      return ((this.l & 0x10) == 0) && (!android.support.v4.j.af.c(this.a));
    }
    
    boolean x()
    {
      return (this.l & 0x2) != 0;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */