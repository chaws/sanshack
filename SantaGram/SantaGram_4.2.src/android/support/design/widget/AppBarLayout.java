package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.g;
import android.support.v4.g.c;
import android.support.v4.g.d;
import android.support.v4.j.af;
import android.support.v4.j.bc;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.List;

@CoordinatorLayout.c(a=Behavior.class)
public class AppBarLayout
  extends LinearLayout
{
  boolean a;
  private int b;
  private int c;
  private int d;
  private float e;
  private int f;
  private bc g;
  private final List<b> h;
  
  private void b()
  {
    this.b = -1;
    this.c = -1;
    this.d = -1;
  }
  
  private boolean c()
  {
    return this.a;
  }
  
  private boolean d()
  {
    return getTotalScrollRange() != 0;
  }
  
  private void e()
  {
    this.f = 0;
  }
  
  private int getDownNestedPreScrollRange()
  {
    if (this.c != -1) {
      return this.c;
    }
    int j = getChildCount() - 1;
    int i = 0;
    View localView;
    int k;
    int m;
    if (j >= 0)
    {
      localView = getChildAt(j);
      a locala = (a)localView.getLayoutParams();
      k = localView.getMeasuredHeight();
      m = locala.a;
      if ((m & 0x5) == 5)
      {
        int n = locala.topMargin;
        i = locala.bottomMargin + n + i;
        if ((m & 0x8) != 0) {
          i += af.p(localView);
        }
      }
    }
    for (;;)
    {
      j -= 1;
      break;
      if ((m & 0x2) != 0)
      {
        i += k - af.p(localView);
      }
      else
      {
        i += k;
        continue;
        if (i > 0)
        {
          i = Math.max(0, i - getTopInset());
          this.c = i;
          return i;
        }
      }
    }
  }
  
  private int getDownNestedScrollRange()
  {
    if (this.d != -1) {
      return this.d;
    }
    int k = getChildCount();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      a locala = (a)localView.getLayoutParams();
      int n = localView.getMeasuredHeight();
      int i1 = locala.topMargin;
      int i2 = locala.bottomMargin;
      int m = locala.a;
      if ((m & 0x1) != 0)
      {
        i += n + (i1 + i2);
        if ((m & 0x2) != 0) {
          i -= af.p(localView) + getTopInset();
        }
      }
    }
    for (;;)
    {
      i = Math.max(0, i);
      this.d = i;
      return i;
      j += 1;
      break;
    }
  }
  
  private int getPendingAction()
  {
    return this.f;
  }
  
  private int getTopInset()
  {
    if (this.g != null) {
      return this.g.b();
    }
    return 0;
  }
  
  private int getUpNestedPreScrollRange()
  {
    return getTotalScrollRange();
  }
  
  protected a a()
  {
    return new a(-1, -2);
  }
  
  public a a(AttributeSet paramAttributeSet)
  {
    return new a(getContext(), paramAttributeSet);
  }
  
  protected a a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LinearLayout.LayoutParams)) {
      return new a((LinearLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new a((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new a(paramLayoutParams);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label31;
      }
    }
    label31:
    for (int j = 4;; j = 0)
    {
      this.f = (j | i);
      requestLayout();
      return;
      i = 2;
      break;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof a;
  }
  
  final int getMinimumHeightForVisibleOverlappingContent()
  {
    int i = getTopInset();
    int j = af.p(this);
    if (j != 0) {
      return i + j * 2;
    }
    j = getChildCount();
    if (j >= 1) {
      return i + af.p(getChildAt(j - 1)) * 2;
    }
    return 0;
  }
  
  public float getTargetElevation()
  {
    return this.e;
  }
  
  public final int getTotalScrollRange()
  {
    if (this.b != -1) {
      return this.b;
    }
    int k = getChildCount();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      a locala = (a)localView.getLayoutParams();
      int n = localView.getMeasuredHeight();
      int m = locala.a;
      if ((m & 0x1) != 0)
      {
        int i1 = locala.topMargin;
        i += locala.bottomMargin + (n + i1);
        if ((m & 0x2) != 0) {
          i -= af.p(localView);
        }
      }
    }
    for (;;)
    {
      i = Math.max(0, i - getTopInset());
      this.b = i;
      return i;
      j += 1;
      break;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    b();
    this.a = false;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        if (((a)getChildAt(paramInt1).getLayoutParams()).b() != null) {
          this.a = true;
        }
      }
      else {
        return;
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    b();
  }
  
  public void setExpanded(boolean paramBoolean)
  {
    a(paramBoolean, af.A(this));
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt != 1) {
      throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }
    super.setOrientation(paramInt);
  }
  
  public void setTargetElevation(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public static class Behavior
    extends i<AppBarLayout>
  {
    private int a;
    private boolean b;
    private boolean c;
    private q d;
    private int e = -1;
    private boolean f;
    private float g;
    private WeakReference<View> h;
    private a i;
    
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private int a(AppBarLayout paramAppBarLayout, int paramInt)
    {
      int j = 0;
      int k = paramAppBarLayout.getChildCount();
      while (j < k)
      {
        View localView = paramAppBarLayout.getChildAt(j);
        if ((localView.getTop() <= -paramInt) && (localView.getBottom() >= -paramInt)) {
          return j;
        }
        j += 1;
      }
      return -1;
    }
    
    private static boolean a(int paramInt1, int paramInt2)
    {
      return (paramInt1 & paramInt2) == paramInt2;
    }
    
    private int b(AppBarLayout paramAppBarLayout, int paramInt)
    {
      int m = Math.abs(paramInt);
      int n = paramAppBarLayout.getChildCount();
      int k = 0;
      int j = paramInt;
      View localView;
      Interpolator localInterpolator;
      if (k < n)
      {
        localView = paramAppBarLayout.getChildAt(k);
        AppBarLayout.a locala = (AppBarLayout.a)localView.getLayoutParams();
        localInterpolator = locala.b();
        if ((m < localView.getTop()) || (m > localView.getBottom())) {
          break label224;
        }
        j = paramInt;
        if (localInterpolator != null)
        {
          n = locala.a();
          if ((n & 0x1) == 0) {
            break label233;
          }
          j = localView.getHeight();
          k = locala.topMargin;
          k = locala.bottomMargin + (j + k) + 0;
          j = k;
          if ((n & 0x2) == 0) {}
        }
      }
      label224:
      label233:
      for (j = k - af.p(localView);; j = 0)
      {
        k = j;
        if (af.t(localView)) {
          k = j - AppBarLayout.e(paramAppBarLayout);
        }
        j = paramInt;
        if (k > 0)
        {
          j = localView.getTop();
          float f1 = k;
          j = Math.round(localInterpolator.getInterpolation((m - j) / k) * f1);
          j = Integer.signum(paramInt) * (j + localView.getTop());
        }
        return j;
        k += 1;
        break;
      }
    }
    
    private void b(final CoordinatorLayout paramCoordinatorLayout, final AppBarLayout paramAppBarLayout, int paramInt)
    {
      int j = a();
      if (j == paramInt)
      {
        if ((this.d != null) && (this.d.b())) {
          this.d.e();
        }
        return;
      }
      if (this.d == null)
      {
        this.d = x.a();
        this.d.a(a.e);
        this.d.a(new q.a()
        {
          public void a(q paramAnonymousq)
          {
            AppBarLayout.Behavior.this.a_(paramCoordinatorLayout, paramAppBarLayout, paramAnonymousq.c());
          }
        });
      }
      for (;;)
      {
        float f1 = Math.abs(j - paramInt) / paramCoordinatorLayout.getResources().getDisplayMetrics().density;
        this.d.a(Math.round(f1 * 1000.0F / 300.0F));
        this.d.a(j, paramInt);
        this.d.a();
        return;
        this.d.e();
      }
    }
    
    private void c(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout)
    {
      int i1 = a();
      int i2 = a(paramAppBarLayout, i1);
      View localView;
      int n;
      int m;
      int j;
      int k;
      if (i2 >= 0)
      {
        localView = paramAppBarLayout.getChildAt(i2);
        n = ((AppBarLayout.a)localView.getLayoutParams()).a();
        if ((n & 0x11) == 17)
        {
          m = -localView.getTop();
          j = -localView.getBottom();
          k = j;
          if (i2 == paramAppBarLayout.getChildCount() - 1) {
            k = j + AppBarLayout.e(paramAppBarLayout);
          }
          if (!a(n, 2)) {
            break label139;
          }
          k += af.p(localView);
          j = m;
        }
      }
      for (;;)
      {
        if (i1 < (k + j) / 2) {}
        for (;;)
        {
          b(paramCoordinatorLayout, paramAppBarLayout, k.a(k, -paramAppBarLayout.getTotalScrollRange(), 0));
          return;
          label139:
          if (!a(n, 5)) {
            break label186;
          }
          n = af.p(localView) + k;
          j = n;
          if (i1 < n) {
            break;
          }
          k = n;
          j = m;
          break;
          k = j;
        }
        label186:
        j = m;
      }
    }
    
    private void d(AppBarLayout paramAppBarLayout)
    {
      List localList = AppBarLayout.i(paramAppBarLayout);
      int k = localList.size();
      int j = 0;
      while (j < k)
      {
        AppBarLayout.b localb = (AppBarLayout.b)localList.get(j);
        if (localb != null) {
          localb.a(paramAppBarLayout, b());
        }
        j += 1;
      }
    }
    
    int a()
    {
      return b() + this.a;
    }
    
    int a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt1, int paramInt2, int paramInt3)
    {
      int j = 0;
      int k = a();
      if ((paramInt2 != 0) && (k >= paramInt2) && (k <= paramInt3))
      {
        paramInt2 = k.a(paramInt1, paramInt2, paramInt3);
        paramInt1 = j;
        if (k != paramInt2) {
          if (!AppBarLayout.h(paramAppBarLayout)) {
            break label108;
          }
        }
        label108:
        for (paramInt1 = b(paramAppBarLayout, paramInt2);; paramInt1 = paramInt2)
        {
          boolean bool = a(paramInt1);
          this.a = (paramInt2 - paramInt1);
          if ((!bool) && (AppBarLayout.h(paramAppBarLayout))) {
            paramCoordinatorLayout.c(paramAppBarLayout);
          }
          d(paramAppBarLayout);
          paramInt1 = k - paramInt2;
          return paramInt1;
        }
      }
      this.a = 0;
      return 0;
    }
    
    void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout)
    {
      c(paramCoordinatorLayout, paramAppBarLayout);
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, Parcelable paramParcelable)
    {
      if ((paramParcelable instanceof b))
      {
        paramParcelable = (b)paramParcelable;
        super.a(paramCoordinatorLayout, paramAppBarLayout, paramParcelable.getSuperState());
        this.e = paramParcelable.a;
        this.g = paramParcelable.b;
        this.f = paramParcelable.c;
        return;
      }
      super.a(paramCoordinatorLayout, paramAppBarLayout, paramParcelable);
      this.e = -1;
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView)
    {
      if (!this.c) {
        c(paramCoordinatorLayout, paramAppBarLayout);
      }
      this.b = false;
      this.c = false;
      this.h = new WeakReference(paramView);
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (paramInt4 < 0)
      {
        b(paramCoordinatorLayout, paramAppBarLayout, paramInt4, -AppBarLayout.d(paramAppBarLayout), 0);
        this.b = true;
        return;
      }
      this.b = false;
    }
    
    public void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
    {
      if ((paramInt2 != 0) && (!this.b))
      {
        if (paramInt2 >= 0) {
          break label50;
        }
        paramInt1 = -paramAppBarLayout.getTotalScrollRange();
      }
      for (int j = paramInt1 + AppBarLayout.b(paramAppBarLayout);; j = 0)
      {
        paramArrayOfInt[1] = b(paramCoordinatorLayout, paramAppBarLayout, paramInt2, paramInt1, j);
        return;
        label50:
        paramInt1 = -AppBarLayout.c(paramAppBarLayout);
      }
    }
    
    boolean a(AppBarLayout paramAppBarLayout)
    {
      if (this.i != null) {
        return this.i.a(paramAppBarLayout);
      }
      if (this.h != null)
      {
        paramAppBarLayout = (View)this.h.get();
        return (paramAppBarLayout != null) && (paramAppBarLayout.isShown()) && (!af.b(paramAppBarLayout, -1));
      }
      return true;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt)
    {
      boolean bool = super.a(paramCoordinatorLayout, paramAppBarLayout, paramInt);
      int j = AppBarLayout.f(paramAppBarLayout);
      if (j != 0) {
        if ((j & 0x4) != 0)
        {
          paramInt = 1;
          if ((j & 0x2) == 0) {
            break label107;
          }
          j = -AppBarLayout.c(paramAppBarLayout);
          if (paramInt == 0) {
            break label95;
          }
          b(paramCoordinatorLayout, paramAppBarLayout, j);
        }
      }
      label95:
      label107:
      while (this.e < 0) {
        for (;;)
        {
          AppBarLayout.g(paramAppBarLayout);
          this.e = -1;
          a(k.a(b(), -paramAppBarLayout.getTotalScrollRange(), 0));
          d(paramAppBarLayout);
          return bool;
          paramInt = 0;
          continue;
          a_(paramCoordinatorLayout, paramAppBarLayout, j);
          continue;
          if ((j & 0x1) != 0) {
            if (paramInt != 0) {
              b(paramCoordinatorLayout, paramAppBarLayout, 0);
            } else {
              a_(paramCoordinatorLayout, paramAppBarLayout, 0);
            }
          }
        }
      }
      paramCoordinatorLayout = paramAppBarLayout.getChildAt(this.e);
      paramInt = -paramCoordinatorLayout.getBottom();
      if (this.f) {}
      for (paramInt = af.p(paramCoordinatorLayout) + paramInt;; paramInt = Math.round(paramCoordinatorLayout.getHeight() * this.g) + paramInt)
      {
        a(paramInt);
        break;
      }
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (((CoordinatorLayout.e)paramAppBarLayout.getLayoutParams()).height == -2)
      {
        paramCoordinatorLayout.a(paramAppBarLayout, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(0, 0), paramInt4);
        return true;
      }
      return super.a(paramCoordinatorLayout, paramAppBarLayout, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      boolean bool = false;
      if (!paramBoolean) {
        paramBoolean = a(paramCoordinatorLayout, paramAppBarLayout, -paramAppBarLayout.getTotalScrollRange(), 0, -paramFloat2);
      }
      for (;;)
      {
        this.c = paramBoolean;
        return paramBoolean;
        int j;
        if (paramFloat2 < 0.0F)
        {
          j = -paramAppBarLayout.getTotalScrollRange() + AppBarLayout.b(paramAppBarLayout);
          paramBoolean = bool;
          if (a() < j)
          {
            b(paramCoordinatorLayout, paramAppBarLayout, j);
            paramBoolean = true;
          }
        }
        else
        {
          j = -AppBarLayout.c(paramAppBarLayout);
          paramBoolean = bool;
          if (a() > j)
          {
            b(paramCoordinatorLayout, paramAppBarLayout, j);
            paramBoolean = true;
          }
        }
      }
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView1, View paramView2, int paramInt)
    {
      if (((paramInt & 0x2) != 0) && (AppBarLayout.a(paramAppBarLayout)) && (paramCoordinatorLayout.getHeight() - paramView1.getHeight() <= paramAppBarLayout.getHeight())) {}
      for (boolean bool = true;; bool = false)
      {
        if ((bool) && (this.d != null)) {
          this.d.e();
        }
        this.h = null;
        return bool;
      }
    }
    
    int b(AppBarLayout paramAppBarLayout)
    {
      return -AppBarLayout.d(paramAppBarLayout);
    }
    
    public Parcelable b(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout)
    {
      boolean bool = false;
      Parcelable localParcelable = super.b(paramCoordinatorLayout, paramAppBarLayout);
      int k = b();
      int m = paramAppBarLayout.getChildCount();
      int j = 0;
      while (j < m)
      {
        paramCoordinatorLayout = paramAppBarLayout.getChildAt(j);
        int n = paramCoordinatorLayout.getBottom() + k;
        if ((paramCoordinatorLayout.getTop() + k <= 0) && (n >= 0))
        {
          paramAppBarLayout = new b(localParcelable);
          paramAppBarLayout.a = j;
          if (n == af.p(paramCoordinatorLayout)) {
            bool = true;
          }
          paramAppBarLayout.c = bool;
          paramAppBarLayout.b = (n / paramCoordinatorLayout.getHeight());
          return paramAppBarLayout;
        }
        j += 1;
      }
      return localParcelable;
    }
    
    int c(AppBarLayout paramAppBarLayout)
    {
      return paramAppBarLayout.getTotalScrollRange();
    }
    
    public static abstract class a
    {
      public abstract boolean a(AppBarLayout paramAppBarLayout);
    }
    
    protected static class b
      extends View.BaseSavedState
    {
      public static final Parcelable.Creator<b> CREATOR = c.a(new d()
      {
        public AppBarLayout.Behavior.b a(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
        {
          return new AppBarLayout.Behavior.b(paramAnonymousParcel, paramAnonymousClassLoader);
        }
        
        public AppBarLayout.Behavior.b[] a(int paramAnonymousInt)
        {
          return new AppBarLayout.Behavior.b[paramAnonymousInt];
        }
      });
      int a;
      float b;
      boolean c;
      
      public b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        super();
        this.a = paramParcel.readInt();
        this.b = paramParcel.readFloat();
        if (paramParcel.readByte() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.c = bool;
          return;
        }
      }
      
      public b(Parcelable paramParcelable)
      {
        super();
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(this.a);
        paramParcel.writeFloat(this.b);
        if (this.c) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeByte((byte)paramInt);
          return;
        }
      }
    }
  }
  
  public static class ScrollingViewBehavior
    extends j
  {
    public ScrollingViewBehavior() {}
    
    public ScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.g.ScrollingViewBehavior_Params);
      b(paramContext.getDimensionPixelSize(a.g.ScrollingViewBehavior_Params_behavior_overlapTop, 0));
      paramContext.recycle();
    }
    
    private static int a(AppBarLayout paramAppBarLayout)
    {
      paramAppBarLayout = ((CoordinatorLayout.e)paramAppBarLayout.getLayoutParams()).b();
      if ((paramAppBarLayout instanceof AppBarLayout.Behavior)) {
        return ((AppBarLayout.Behavior)paramAppBarLayout).a();
      }
      return 0;
    }
    
    private void e(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      paramCoordinatorLayout = ((CoordinatorLayout.e)paramView2.getLayoutParams()).b();
      if ((paramCoordinatorLayout instanceof AppBarLayout.Behavior))
      {
        paramCoordinatorLayout = (AppBarLayout.Behavior)paramCoordinatorLayout;
        paramCoordinatorLayout.a();
        int i = paramView2.getBottom();
        int j = paramView1.getTop();
        af.e(paramView1, AppBarLayout.Behavior.a(paramCoordinatorLayout) + (i - j) + a() - c(paramView2));
      }
    }
    
    float a(View paramView)
    {
      int j;
      int k;
      int i;
      if ((paramView instanceof AppBarLayout))
      {
        paramView = (AppBarLayout)paramView;
        j = paramView.getTotalScrollRange();
        k = AppBarLayout.b(paramView);
        i = a(paramView);
        if ((k == 0) || (j + i > k)) {
          break label43;
        }
      }
      label43:
      do
      {
        return 0.0F;
        j -= k;
      } while (j == 0);
      return 1.0F + i / j;
    }
    
    View a(List<View> paramList)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        View localView = (View)paramList.get(i);
        if ((localView instanceof AppBarLayout)) {
          return localView;
        }
        i += 1;
      }
      return null;
    }
    
    int b(View paramView)
    {
      if ((paramView instanceof AppBarLayout)) {
        return ((AppBarLayout)paramView).getTotalScrollRange();
      }
      return super.b(paramView);
    }
    
    public boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      return paramView2 instanceof AppBarLayout;
    }
    
    public boolean c(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      e(paramCoordinatorLayout, paramView1, paramView2);
      return false;
    }
  }
  
  public static class a
    extends LinearLayout.LayoutParams
  {
    int a = 1;
    Interpolator b;
    
    public a(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.g.AppBarLayout_LayoutParams);
      this.a = paramAttributeSet.getInt(a.g.AppBarLayout_LayoutParams_layout_scrollFlags, 0);
      if (paramAttributeSet.hasValue(a.g.AppBarLayout_LayoutParams_layout_scrollInterpolator)) {
        this.b = AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(a.g.AppBarLayout_LayoutParams_layout_scrollInterpolator, 0));
      }
      paramAttributeSet.recycle();
    }
    
    public a(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public a(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public a(LinearLayout.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public int a()
    {
      return this.a;
    }
    
    public Interpolator b()
    {
      return this.b;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(AppBarLayout paramAppBarLayout, int paramInt);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/widget/AppBarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */