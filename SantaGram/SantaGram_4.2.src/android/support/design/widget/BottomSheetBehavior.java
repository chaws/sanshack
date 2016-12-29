package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.g;
import android.support.v4.j.ad;
import android.support.v4.j.af;
import android.support.v4.j.s;
import android.support.v4.j.w;
import android.support.v4.widget.ab;
import android.support.v4.widget.ab.a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View>
  extends CoordinatorLayout.b<V>
{
  private float a;
  private int b;
  private int c;
  private int d;
  private boolean e;
  private int f = 4;
  private ab g;
  private boolean h;
  private int i;
  private boolean j;
  private int k;
  private WeakReference<V> l;
  private WeakReference<View> m;
  private a n;
  private VelocityTracker o;
  private int p;
  private int q;
  private boolean r;
  private final ab.a s = new ab.a()
  {
    public int a(View paramAnonymousView)
    {
      if (BottomSheetBehavior.g(BottomSheetBehavior.this)) {
        return BottomSheetBehavior.h(BottomSheetBehavior.this) - BottomSheetBehavior.f(BottomSheetBehavior.this);
      }
      return BottomSheetBehavior.i(BottomSheetBehavior.this) - BottomSheetBehavior.f(BottomSheetBehavior.this);
    }
    
    public int a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      int i = BottomSheetBehavior.f(BottomSheetBehavior.this);
      if (BottomSheetBehavior.g(BottomSheetBehavior.this)) {}
      for (paramAnonymousInt2 = BottomSheetBehavior.h(BottomSheetBehavior.this);; paramAnonymousInt2 = BottomSheetBehavior.i(BottomSheetBehavior.this)) {
        return k.a(paramAnonymousInt1, i, paramAnonymousInt2);
      }
    }
    
    public void a(int paramAnonymousInt)
    {
      if (paramAnonymousInt == 1) {
        BottomSheetBehavior.b(BottomSheetBehavior.this, 1);
      }
    }
    
    public void a(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      int j = 3;
      int i;
      if (paramAnonymousFloat2 < 0.0F) {
        i = BottomSheetBehavior.f(BottomSheetBehavior.this);
      }
      while (BottomSheetBehavior.j(BottomSheetBehavior.this).a(paramAnonymousView.getLeft(), i))
      {
        BottomSheetBehavior.b(BottomSheetBehavior.this, 2);
        af.a(paramAnonymousView, new BottomSheetBehavior.c(BottomSheetBehavior.this, paramAnonymousView, j));
        return;
        if ((BottomSheetBehavior.g(BottomSheetBehavior.this)) && (BottomSheetBehavior.a(BottomSheetBehavior.this, paramAnonymousView, paramAnonymousFloat2)))
        {
          i = BottomSheetBehavior.h(BottomSheetBehavior.this);
          j = 5;
        }
        else if (paramAnonymousFloat2 == 0.0F)
        {
          i = paramAnonymousView.getTop();
          if (Math.abs(i - BottomSheetBehavior.f(BottomSheetBehavior.this)) < Math.abs(i - BottomSheetBehavior.i(BottomSheetBehavior.this)))
          {
            i = BottomSheetBehavior.f(BottomSheetBehavior.this);
          }
          else
          {
            i = BottomSheetBehavior.i(BottomSheetBehavior.this);
            j = 4;
          }
        }
        else
        {
          i = BottomSheetBehavior.i(BottomSheetBehavior.this);
          j = 4;
        }
      }
      BottomSheetBehavior.b(BottomSheetBehavior.this, j);
    }
    
    public void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      BottomSheetBehavior.a(BottomSheetBehavior.this, paramAnonymousInt2);
    }
    
    public boolean a(View paramAnonymousView, int paramAnonymousInt)
    {
      if (BottomSheetBehavior.a(BottomSheetBehavior.this) == 1) {}
      View localView;
      do
      {
        do
        {
          return false;
        } while (BottomSheetBehavior.b(BottomSheetBehavior.this));
        if ((BottomSheetBehavior.a(BottomSheetBehavior.this) != 3) || (BottomSheetBehavior.c(BottomSheetBehavior.this) != paramAnonymousInt)) {
          break;
        }
        localView = (View)BottomSheetBehavior.d(BottomSheetBehavior.this).get();
      } while ((localView != null) && (af.b(localView, -1)));
      if ((BottomSheetBehavior.e(BottomSheetBehavior.this) != null) && (BottomSheetBehavior.e(BottomSheetBehavior.this).get() == paramAnonymousView)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public int b(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return paramAnonymousView.getLeft();
    }
  };
  
  public BottomSheetBehavior() {}
  
  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.g.BottomSheetBehavior_Params);
    a(paramAttributeSet.getDimensionPixelSize(a.g.BottomSheetBehavior_Params_behavior_peekHeight, 0));
    a(paramAttributeSet.getBoolean(a.g.BottomSheetBehavior_Params_behavior_hideable, false));
    paramAttributeSet.recycle();
    this.a = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
  }
  
  private View a(View paramView)
  {
    if ((paramView instanceof w)) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i2 = paramView.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = a(paramView.getChildAt(i1));
        if (localView != null) {
          return localView;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  private void a()
  {
    this.p = -1;
    if (this.o != null)
    {
      this.o.recycle();
      this.o = null;
    }
  }
  
  private boolean a(View paramView, float paramFloat)
  {
    if (paramView.getTop() < this.d) {}
    while (Math.abs(paramView.getTop() + 0.1F * paramFloat - this.d) / this.b <= 0.5F) {
      return false;
    }
    return true;
  }
  
  private float b()
  {
    this.o.computeCurrentVelocity(1000, this.a);
    return ad.b(this.o, this.p);
  }
  
  private void b(int paramInt)
  {
    if (this.f == paramInt) {}
    View localView;
    do
    {
      return;
      this.f = paramInt;
      localView = (View)this.l.get();
    } while ((localView == null) || (this.n == null));
    this.n.a(localView, paramInt);
  }
  
  private void c(int paramInt)
  {
    View localView = (View)this.l.get();
    if ((localView != null) && (this.n != null))
    {
      if (paramInt > this.d) {
        this.n.a(localView, (this.d - paramInt) / this.b);
      }
    }
    else {
      return;
    }
    this.n.a(localView, (this.d - paramInt) / (this.d - this.c));
  }
  
  public final void a(int paramInt)
  {
    this.b = Math.max(0, paramInt);
    this.d = (this.k - paramInt);
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramParcelable = (b)paramParcelable;
    super.a(paramCoordinatorLayout, paramV, paramParcelable.getSuperState());
    if ((paramParcelable.a == 1) || (paramParcelable.a == 2))
    {
      this.f = 4;
      return;
    }
    this.f = paramParcelable.a;
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView)
  {
    int i2 = 3;
    if (paramV.getTop() == this.c) {
      b(3);
    }
    while ((paramView != this.m.get()) || (!this.j)) {
      return;
    }
    int i1;
    if (this.i > 0)
    {
      i1 = this.c;
      if (!this.g.a(paramV, paramV.getLeft(), i1)) {
        break label194;
      }
      b(2);
      af.a(paramV, new c(paramV, i2));
    }
    for (;;)
    {
      this.j = false;
      return;
      if ((this.e) && (a(paramV, b())))
      {
        i1 = this.k;
        i2 = 5;
        break;
      }
      if (this.i == 0)
      {
        i1 = paramV.getTop();
        if (Math.abs(i1 - this.c) < Math.abs(i1 - this.d))
        {
          i1 = this.c;
          break;
        }
        i1 = this.d;
        i2 = 4;
        break;
      }
      i1 = this.d;
      i2 = 4;
      break;
      label194:
      b(i2);
    }
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (paramView != (View)this.m.get()) {
      return;
    }
    paramInt1 = paramV.getTop();
    int i1 = paramInt1 - paramInt2;
    if (paramInt2 > 0) {
      if (i1 < this.c)
      {
        paramArrayOfInt[1] = (paramInt1 - this.c);
        af.e(paramV, -paramArrayOfInt[1]);
        b(3);
      }
    }
    for (;;)
    {
      c(paramV.getTop());
      this.i = paramInt2;
      this.j = true;
      return;
      paramArrayOfInt[1] = paramInt2;
      af.e(paramV, -paramInt2);
      b(1);
      continue;
      if ((paramInt2 < 0) && (!af.b(paramView, -1))) {
        if ((i1 <= this.d) || (this.e))
        {
          paramArrayOfInt[1] = paramInt2;
          af.e(paramV, -paramInt2);
          b(1);
        }
        else
        {
          paramArrayOfInt[1] = (paramInt1 - this.d);
          af.e(paramV, -paramArrayOfInt[1]);
          b(4);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    if ((this.f != 1) && (this.f != 2))
    {
      if ((af.t(paramCoordinatorLayout)) && (!af.t(paramV))) {
        af.a(paramV, true);
      }
      paramCoordinatorLayout.a(paramV, paramInt);
    }
    this.k = paramCoordinatorLayout.getHeight();
    this.c = Math.max(0, this.k - paramV.getHeight());
    this.d = Math.max(this.k - this.b, this.c);
    if (this.f == 3) {
      af.e(paramV, this.c);
    }
    for (;;)
    {
      if (this.g == null) {
        this.g = ab.a(paramCoordinatorLayout, this.s);
      }
      this.l = new WeakReference(paramV);
      this.m = new WeakReference(a(paramV));
      return true;
      if ((this.e) && (this.f == 5)) {
        af.e(paramV, this.k);
      } else if (this.f == 4) {
        af.e(paramV, this.d);
      }
    }
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if (!paramV.isShown()) {
      return false;
    }
    int i1 = s.a(paramMotionEvent);
    if (i1 == 0) {
      a();
    }
    if (this.o == null) {
      this.o = VelocityTracker.obtain();
    }
    this.o.addMovement(paramMotionEvent);
    switch (i1)
    {
    }
    while ((!this.h) && (this.g.a(paramMotionEvent)))
    {
      return true;
      this.r = false;
      this.p = -1;
      if (this.h)
      {
        this.h = false;
        return false;
        int i2 = (int)paramMotionEvent.getX();
        this.q = ((int)paramMotionEvent.getY());
        View localView = (View)this.m.get();
        if ((localView != null) && (paramCoordinatorLayout.a(localView, i2, this.q)))
        {
          this.p = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
          this.r = true;
        }
        if ((this.p == -1) && (!paramCoordinatorLayout.a(paramV, i2, this.q))) {}
        for (bool1 = true;; bool1 = false)
        {
          this.h = bool1;
          break;
        }
      }
    }
    paramV = (View)this.m.get();
    if ((i1 == 2) && (paramV != null) && (!this.h) && (this.f != 1) && (!paramCoordinatorLayout.a(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (Math.abs(this.q - paramMotionEvent.getY()) > this.g.a())) {}
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramView == this.m.get()) && ((this.f != 3) || (super.a(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)));
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt)
  {
    boolean bool = false;
    this.i = 0;
    this.j = false;
    if ((paramInt & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public Parcelable b(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return new b(super.b(paramCoordinatorLayout, paramV), this.f);
  }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!paramV.isShown()) {
      bool1 = false;
    }
    do
    {
      int i1;
      do
      {
        return bool1;
        i1 = s.a(paramMotionEvent);
        if (this.f != 1) {
          break;
        }
        bool1 = bool2;
      } while (i1 == 0);
      this.g.b(paramMotionEvent);
      if (i1 == 0) {
        a();
      }
      if (this.o == null) {
        this.o = VelocityTracker.obtain();
      }
      this.o.addMovement(paramMotionEvent);
      if ((i1 == 2) && (!this.h) && (Math.abs(this.q - paramMotionEvent.getY()) > this.g.a())) {
        this.g.a(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      }
      bool1 = bool2;
    } while (!this.h);
    return false;
  }
  
  public static abstract class a
  {
    public abstract void a(View paramView, float paramFloat);
    
    public abstract void a(View paramView, int paramInt);
  }
  
  protected static class b
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator()
    {
      public BottomSheetBehavior.b a(Parcel paramAnonymousParcel)
      {
        return new BottomSheetBehavior.b(paramAnonymousParcel);
      }
      
      public BottomSheetBehavior.b[] a(int paramAnonymousInt)
      {
        return new BottomSheetBehavior.b[paramAnonymousInt];
      }
    };
    final int a;
    
    public b(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readInt();
    }
    
    public b(Parcelable paramParcelable, int paramInt)
    {
      super();
      this.a = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a);
    }
  }
  
  private class c
    implements Runnable
  {
    private final View b;
    private final int c;
    
    c(View paramView, int paramInt)
    {
      this.b = paramView;
      this.c = paramInt;
    }
    
    public void run()
    {
      if ((BottomSheetBehavior.j(BottomSheetBehavior.this) != null) && (BottomSheetBehavior.j(BottomSheetBehavior.this).a(true)))
      {
        af.a(this.b, this);
        return;
      }
      BottomSheetBehavior.b(BottomSheetBehavior.this, this.c);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/widget/BottomSheetBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */