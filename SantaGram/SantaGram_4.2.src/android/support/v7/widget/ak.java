package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.h.d;
import android.support.v4.j.af;
import android.support.v4.j.av;
import android.support.v4.widget.k;
import android.support.v4.widget.o;
import android.support.v7.b.a.a;
import android.support.v7.b.a.k;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class ak
{
  private static Method a;
  private static Method c;
  private final c A = new c(null);
  private Runnable B;
  private final Handler C;
  private Rect D = new Rect();
  private boolean E;
  private int F;
  int b = Integer.MAX_VALUE;
  private Context d;
  private PopupWindow e;
  private ListAdapter f;
  private a g;
  private int h = -2;
  private int i = -2;
  private int j;
  private int k;
  private int l = 1002;
  private boolean m;
  private int n = 0;
  private boolean o = false;
  private boolean p = false;
  private View q;
  private int r = 0;
  private DataSetObserver s;
  private View t;
  private Drawable u;
  private AdapterView.OnItemClickListener v;
  private AdapterView.OnItemSelectedListener w;
  private final g x = new g(null);
  private final f y = new f(null);
  private final e z = new e(null);
  
  static
  {
    try
    {
      a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;)
      {
        try
        {
          c = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        localNoSuchMethodException1 = localNoSuchMethodException1;
        Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
      }
    }
  }
  
  public ak(Context paramContext)
  {
    this(paramContext, null, a.a.listPopupWindowStyle);
  }
  
  public ak(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ak(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.d = paramContext;
    this.C = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ListPopupWindow, paramInt1, paramInt2);
    this.j = localTypedArray.getDimensionPixelOffset(a.k.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    this.k = localTypedArray.getDimensionPixelOffset(a.k.ListPopupWindow_android_dropDownVerticalOffset, 0);
    if (this.k != 0) {
      this.m = true;
    }
    localTypedArray.recycle();
    this.e = new s(paramContext, paramAttributeSet, paramInt1);
    this.e.setInputMethodMode(1);
    this.F = d.a(this.d.getResources().getConfiguration().locale);
  }
  
  private int a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (c != null) {
      try
      {
        int i1 = ((Integer)c.invoke(this.e, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
        return i1;
      }
      catch (Exception localException)
      {
        Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
      }
    }
    return this.e.getMaxAvailableHeight(paramView, paramInt);
  }
  
  private void a()
  {
    if (this.q != null)
    {
      ViewParent localViewParent = this.q.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.q);
      }
    }
  }
  
  private int b()
  {
    boolean bool2 = true;
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    label245:
    int i2;
    int i1;
    if (this.g == null)
    {
      localObject2 = this.d;
      this.B = new Runnable()
      {
        public void run()
        {
          View localView = ak.this.e();
          if ((localView != null) && (localView.getWindowToken() != null)) {
            ak.this.c();
          }
        }
      };
      if (!this.E)
      {
        bool1 = true;
        this.g = new a((Context)localObject2, bool1);
        if (this.u != null) {
          this.g.setSelector(this.u);
        }
        this.g.setAdapter(this.f);
        this.g.setOnItemClickListener(this.v);
        this.g.setFocusable(true);
        this.g.setFocusableInTouchMode(true);
        this.g.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = ak.a(ak.this);
              if (paramAnonymousAdapterView != null) {
                ak.a.a(paramAnonymousAdapterView, false);
              }
            }
          }
          
          public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.g.setOnScrollListener(this.z);
        if (this.w != null) {
          this.g.setOnItemSelectedListener(this.w);
        }
        localObject1 = this.g;
        localView = this.q;
        if (localView == null) {
          break label714;
        }
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.r)
        {
        default: 
          Log.e("ListPopupWindow", "Invalid hint position " + this.r);
          if (this.i >= 0)
          {
            i2 = this.i;
            i1 = Integer.MIN_VALUE;
            label263:
            localView.measure(View.MeasureSpec.makeMeasureSpec(i2, i1), 0);
            localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
            i1 = localView.getMeasuredHeight();
            i2 = ((LinearLayout.LayoutParams)localObject1).topMargin;
            i1 = ((LinearLayout.LayoutParams)localObject1).bottomMargin + (i1 + i2);
            localObject1 = localObject2;
          }
          break;
        }
      }
    }
    for (;;)
    {
      this.e.setContentView((View)localObject1);
      for (;;)
      {
        label317:
        localObject1 = this.e.getBackground();
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.D);
          i2 = this.D.top + this.D.bottom;
          if (this.m) {
            break label705;
          }
          this.k = (-this.D.top);
        }
        label374:
        label545:
        label705:
        for (;;)
        {
          if (this.e.getInputMethodMode() == 2) {}
          int i4;
          for (bool1 = bool2;; bool1 = false)
          {
            i4 = a(e(), this.k, bool1);
            if ((!this.o) && (this.h != -1)) {
              break label545;
            }
            return i4 + i2;
            bool1 = false;
            break;
            ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
            ((LinearLayout)localObject2).addView(localView);
            break label245;
            ((LinearLayout)localObject2).addView(localView);
            ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
            break label245;
            i1 = 0;
            i2 = 0;
            break label263;
            localObject1 = (ViewGroup)this.e.getContentView();
            localObject1 = this.q;
            if (localObject1 == null) {
              break label708;
            }
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            i1 = ((View)localObject1).getMeasuredHeight();
            i2 = ((LinearLayout.LayoutParams)localObject2).topMargin;
            i1 = ((LinearLayout.LayoutParams)localObject2).bottomMargin + (i1 + i2);
            break label317;
            this.D.setEmpty();
            i2 = 0;
            break label374;
          }
          int i3;
          switch (this.i)
          {
          default: 
            i3 = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
          }
          for (;;)
          {
            i4 = this.g.a(i3, 0, -1, i4 - i1, -1);
            i3 = i1;
            if (i4 > 0) {
              i3 = i1 + i2;
            }
            return i4 + i3;
            i3 = View.MeasureSpec.makeMeasureSpec(this.d.getResources().getDisplayMetrics().widthPixels - (this.D.left + this.D.right), Integer.MIN_VALUE);
            continue;
            i3 = View.MeasureSpec.makeMeasureSpec(this.d.getResources().getDisplayMetrics().widthPixels - (this.D.left + this.D.right), 1073741824);
          }
        }
        label708:
        i1 = 0;
      }
      label714:
      i1 = 0;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (a != null) {}
    try
    {
      a.invoke(this.e, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
    }
  }
  
  public void a(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.e.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(View paramView)
  {
    this.t = paramView;
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.v = paramOnItemClickListener;
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    if (this.s == null) {
      this.s = new d(null);
    }
    for (;;)
    {
      this.f = paramListAdapter;
      if (this.f != null) {
        paramListAdapter.registerDataSetObserver(this.s);
      }
      if (this.g != null) {
        this.g.setAdapter(this.f);
      }
      return;
      if (this.f != null) {
        this.f.unregisterDataSetObserver(this.s);
      }
    }
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.e.setOnDismissListener(paramOnDismissListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.E = paramBoolean;
    this.e.setFocusable(paramBoolean);
  }
  
  public void b(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void c()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    int i4 = -1;
    int i1 = b();
    boolean bool3 = l();
    o.a(this.e, this.l);
    int i2;
    label65:
    PopupWindow localPopupWindow;
    if (this.e.isShowing())
    {
      int i3;
      label86:
      label100:
      View localView;
      int i5;
      int i6;
      if (this.i == -1)
      {
        i2 = -1;
        if (this.h != -1) {
          break label270;
        }
        if (!bool3) {
          break label220;
        }
        if (!bool3) {
          break label231;
        }
        localPopupWindow = this.e;
        if (this.i != -1) {
          break label225;
        }
        i3 = -1;
        localPopupWindow.setWidth(i3);
        this.e.setHeight(0);
        localPopupWindow = this.e;
        bool1 = bool2;
        if (!this.p)
        {
          bool1 = bool2;
          if (!this.o) {
            bool1 = true;
          }
        }
        localPopupWindow.setOutsideTouchable(bool1);
        localPopupWindow = this.e;
        localView = e();
        i5 = this.j;
        i6 = this.k;
        i3 = i2;
        if (i2 < 0) {
          i3 = -1;
        }
        if (i1 >= 0) {
          break label290;
        }
        i1 = i4;
      }
      label220:
      label225:
      label231:
      label270:
      label290:
      for (;;)
      {
        localPopupWindow.update(localView, i5, i6, i3, i1);
        return;
        if (this.i == -2)
        {
          i2 = e().getWidth();
          break;
        }
        i2 = this.i;
        break;
        i1 = -1;
        break label65;
        i3 = 0;
        break label86;
        localPopupWindow = this.e;
        if (this.i == -1) {}
        for (i3 = -1;; i3 = 0)
        {
          localPopupWindow.setWidth(i3);
          this.e.setHeight(-1);
          break;
        }
        if (this.h == -2) {
          break label100;
        }
        i1 = this.h;
        break label100;
      }
    }
    if (this.i == -1)
    {
      i2 = -1;
      label304:
      if (this.h != -1) {
        break label474;
      }
      i1 = -1;
      label314:
      this.e.setWidth(i2);
      this.e.setHeight(i1);
      b(true);
      localPopupWindow = this.e;
      if ((this.p) || (this.o)) {
        break label491;
      }
    }
    for (;;)
    {
      localPopupWindow.setOutsideTouchable(bool1);
      this.e.setTouchInterceptor(this.y);
      o.a(this.e, e(), this.j, this.k, this.n);
      this.g.setSelection(-1);
      if ((!this.E) || (this.g.isInTouchMode())) {
        j();
      }
      if (this.E) {
        break;
      }
      this.C.post(this.A);
      return;
      if (this.i == -2)
      {
        i2 = e().getWidth();
        break label304;
      }
      i2 = this.i;
      break label304;
      label474:
      if (this.h == -2) {
        break label314;
      }
      i1 = this.h;
      break label314;
      label491:
      bool1 = false;
    }
  }
  
  public void c(int paramInt)
  {
    this.k = paramInt;
    this.m = true;
  }
  
  public Drawable d()
  {
    return this.e.getBackground();
  }
  
  public void d(int paramInt)
  {
    this.n = paramInt;
  }
  
  public View e()
  {
    return this.t;
  }
  
  public void e(int paramInt)
  {
    this.i = paramInt;
  }
  
  public int f()
  {
    return this.j;
  }
  
  public void f(int paramInt)
  {
    Drawable localDrawable = this.e.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.D);
      this.i = (this.D.left + this.D.right + paramInt);
      return;
    }
    e(paramInt);
  }
  
  public int g()
  {
    if (!this.m) {
      return 0;
    }
    return this.k;
  }
  
  public void g(int paramInt)
  {
    this.e.setInputMethodMode(paramInt);
  }
  
  public int h()
  {
    return this.i;
  }
  
  public void h(int paramInt)
  {
    a locala = this.g;
    if ((k()) && (locala != null))
    {
      a.a(locala, false);
      locala.setSelection(paramInt);
      if ((Build.VERSION.SDK_INT >= 11) && (locala.getChoiceMode() != 0)) {
        locala.setItemChecked(paramInt, true);
      }
    }
  }
  
  public void i()
  {
    this.e.dismiss();
    a();
    this.e.setContentView(null);
    this.g = null;
    this.C.removeCallbacks(this.x);
  }
  
  public void j()
  {
    a locala = this.g;
    if (locala != null)
    {
      a.a(locala, true);
      locala.requestLayout();
    }
  }
  
  public boolean k()
  {
    return this.e.isShowing();
  }
  
  public boolean l()
  {
    return this.e.getInputMethodMode() == 2;
  }
  
  public ListView m()
  {
    return this.g;
  }
  
  private static class a
    extends al
  {
    private boolean g;
    private boolean h;
    private boolean i;
    private av j;
    private k k;
    
    public a(Context paramContext, boolean paramBoolean)
    {
      super(null, a.a.dropDownListViewStyle);
      this.h = paramBoolean;
      setCacheColorHint(0);
    }
    
    private void a(View paramView, int paramInt)
    {
      performItemClick(paramView, paramInt, getItemIdAtPosition(paramInt));
    }
    
    private void a(View paramView, int paramInt, float paramFloat1, float paramFloat2)
    {
      this.i = true;
      if (Build.VERSION.SDK_INT >= 21) {
        drawableHotspotChanged(paramFloat1, paramFloat2);
      }
      if (!isPressed()) {
        setPressed(true);
      }
      layoutChildren();
      if (this.f != -1)
      {
        View localView = getChildAt(this.f - getFirstVisiblePosition());
        if ((localView != null) && (localView != paramView) && (localView.isPressed())) {
          localView.setPressed(false);
        }
      }
      this.f = paramInt;
      float f1 = paramView.getLeft();
      float f2 = paramView.getTop();
      if (Build.VERSION.SDK_INT >= 21) {
        paramView.drawableHotspotChanged(paramFloat1 - f1, paramFloat2 - f2);
      }
      if (!paramView.isPressed()) {
        paramView.setPressed(true);
      }
      a(paramInt, paramView, paramFloat1, paramFloat2);
      setSelectorEnabled(false);
      refreshDrawableState();
    }
    
    private void d()
    {
      this.i = false;
      setPressed(false);
      drawableStateChanged();
      View localView = getChildAt(this.f - getFirstVisiblePosition());
      if (localView != null) {
        localView.setPressed(false);
      }
      if (this.j != null)
      {
        this.j.b();
        this.j = null;
      }
    }
    
    protected boolean a()
    {
      return (this.i) || (super.a());
    }
    
    public boolean a(MotionEvent paramMotionEvent, int paramInt)
    {
      int m = android.support.v4.j.s.a(paramMotionEvent);
      switch (m)
      {
      default: 
        paramInt = 0;
      case 3: 
        for (bool = true;; bool = false)
        {
          label41:
          if ((!bool) || (paramInt != 0)) {
            d();
          }
          if (!bool) {
            break;
          }
          if (this.k == null) {
            this.k = new k(this);
          }
          this.k.a(true);
          this.k.onTouch(this, paramMotionEvent);
          label97:
          return bool;
          paramInt = 0;
        }
      }
      for (boolean bool = false;; bool = true)
      {
        int n = paramMotionEvent.findPointerIndex(paramInt);
        if (n < 0)
        {
          paramInt = 0;
          bool = false;
          break label41;
        }
        paramInt = (int)paramMotionEvent.getX(n);
        n = (int)paramMotionEvent.getY(n);
        int i1 = pointToPosition(paramInt, n);
        if (i1 == -1)
        {
          paramInt = 1;
          break label41;
        }
        View localView = getChildAt(i1 - getFirstVisiblePosition());
        a(localView, i1, paramInt, n);
        if (m != 1) {
          break;
        }
        a(localView, i1);
        break;
        if (this.k == null) {
          break label97;
        }
        this.k.a(false);
        return bool;
      }
    }
    
    public boolean hasFocus()
    {
      return (this.h) || (super.hasFocus());
    }
    
    public boolean hasWindowFocus()
    {
      return (this.h) || (super.hasWindowFocus());
    }
    
    public boolean isFocused()
    {
      return (this.h) || (super.isFocused());
    }
    
    public boolean isInTouchMode()
    {
      return ((this.h) && (this.g)) || (super.isInTouchMode());
    }
  }
  
  public static abstract class b
    implements View.OnTouchListener
  {
    private final float a;
    private final int b;
    private final int c;
    private final View d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private boolean h;
    private int i;
    private final int[] j = new int[2];
    
    public b(View paramView)
    {
      this.d = paramView;
      this.a = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      this.b = ViewConfiguration.getTapTimeout();
      this.c = ((this.b + ViewConfiguration.getLongPressTimeout()) / 2);
    }
    
    private boolean a(MotionEvent paramMotionEvent)
    {
      View localView = this.d;
      if (!localView.isEnabled()) {}
      int k;
      do
      {
        return false;
        switch (android.support.v4.j.s.a(paramMotionEvent))
        {
        default: 
          return false;
        case 0: 
          this.i = paramMotionEvent.getPointerId(0);
          this.h = false;
          if (this.e == null) {
            this.e = new a(null);
          }
          localView.postDelayed(this.e, this.b);
          if (this.f == null) {
            this.f = new b(null);
          }
          localView.postDelayed(this.f, this.c);
          return false;
        case 2: 
          k = paramMotionEvent.findPointerIndex(this.i);
        }
      } while ((k < 0) || (a(localView, paramMotionEvent.getX(k), paramMotionEvent.getY(k), this.a)));
      d();
      localView.getParent().requestDisallowInterceptTouchEvent(true);
      return true;
      d();
      return false;
    }
    
    private static boolean a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      return (paramFloat1 >= -paramFloat3) && (paramFloat2 >= -paramFloat3) && (paramFloat1 < paramView.getRight() - paramView.getLeft() + paramFloat3) && (paramFloat2 < paramView.getBottom() - paramView.getTop() + paramFloat3);
    }
    
    private boolean a(View paramView, MotionEvent paramMotionEvent)
    {
      int[] arrayOfInt = this.j;
      paramView.getLocationOnScreen(arrayOfInt);
      paramMotionEvent.offsetLocation(-arrayOfInt[0], -arrayOfInt[1]);
      return true;
    }
    
    private boolean b(MotionEvent paramMotionEvent)
    {
      boolean bool1 = true;
      View localView = this.d;
      Object localObject = a();
      if ((localObject == null) || (!((ak)localObject).k())) {}
      do
      {
        return false;
        localObject = ak.a((ak)localObject);
      } while ((localObject == null) || (!((ak.a)localObject).isShown()));
      MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
      b(localView, localMotionEvent);
      a((View)localObject, localMotionEvent);
      boolean bool2 = ((ak.a)localObject).a(localMotionEvent, this.i);
      localMotionEvent.recycle();
      int k = android.support.v4.j.s.a(paramMotionEvent);
      if ((k != 1) && (k != 3))
      {
        k = 1;
        if ((!bool2) || (k == 0)) {
          break label121;
        }
      }
      for (;;)
      {
        return bool1;
        k = 0;
        break;
        label121:
        bool1 = false;
      }
    }
    
    private boolean b(View paramView, MotionEvent paramMotionEvent)
    {
      int[] arrayOfInt = this.j;
      paramView.getLocationOnScreen(arrayOfInt);
      paramMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
      return true;
    }
    
    private void d()
    {
      if (this.f != null) {
        this.d.removeCallbacks(this.f);
      }
      if (this.e != null) {
        this.d.removeCallbacks(this.e);
      }
    }
    
    private void e()
    {
      d();
      View localView = this.d;
      if ((!localView.isEnabled()) || (localView.isLongClickable())) {}
      while (!b()) {
        return;
      }
      localView.getParent().requestDisallowInterceptTouchEvent(true);
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      localView.onTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      this.g = true;
      this.h = true;
    }
    
    public abstract ak a();
    
    protected boolean b()
    {
      ak localak = a();
      if ((localak != null) && (!localak.k())) {
        localak.c();
      }
      return true;
    }
    
    protected boolean c()
    {
      ak localak = a();
      if ((localak != null) && (localak.k())) {
        localak.i();
      }
      return true;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      boolean bool2 = false;
      boolean bool3 = this.g;
      if (bool3)
      {
        if (this.h) {
          bool1 = b(paramMotionEvent);
        }
        for (;;)
        {
          this.g = bool1;
          if (!bool1)
          {
            bool1 = bool2;
            if (!bool3) {}
          }
          else
          {
            bool1 = true;
          }
          return bool1;
          if ((b(paramMotionEvent)) || (!c())) {
            bool1 = true;
          } else {
            bool1 = false;
          }
        }
      }
      if ((a(paramMotionEvent)) && (b())) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (bool1)
        {
          long l = SystemClock.uptimeMillis();
          paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          this.d.onTouchEvent(paramView);
          paramView.recycle();
        }
        break;
      }
    }
    
    private class a
      implements Runnable
    {
      private a() {}
      
      public void run()
      {
        ak.b.a(ak.b.this).getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
    
    private class b
      implements Runnable
    {
      private b() {}
      
      public void run()
      {
        ak.b.b(ak.b.this);
      }
    }
  }
  
  private class c
    implements Runnable
  {
    private c() {}
    
    public void run()
    {
      ak.this.j();
    }
  }
  
  private class d
    extends DataSetObserver
  {
    private d() {}
    
    public void onChanged()
    {
      if (ak.this.k()) {
        ak.this.c();
      }
    }
    
    public void onInvalidated()
    {
      ak.this.i();
    }
  }
  
  private class e
    implements AbsListView.OnScrollListener
  {
    private e() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramInt == 1) && (!ak.this.l()) && (ak.b(ak.this).getContentView() != null))
      {
        ak.d(ak.this).removeCallbacks(ak.c(ak.this));
        ak.c(ak.this).run();
      }
    }
  }
  
  private class f
    implements View.OnTouchListener
  {
    private f() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((i == 0) && (ak.b(ak.this) != null) && (ak.b(ak.this).isShowing()) && (j >= 0) && (j < ak.b(ak.this).getWidth()) && (k >= 0) && (k < ak.b(ak.this).getHeight())) {
        ak.d(ak.this).postDelayed(ak.c(ak.this), 250L);
      }
      for (;;)
      {
        return false;
        if (i == 1) {
          ak.d(ak.this).removeCallbacks(ak.c(ak.this));
        }
      }
    }
  }
  
  private class g
    implements Runnable
  {
    private g() {}
    
    public void run()
    {
      if ((ak.a(ak.this) != null) && (af.C(ak.a(ak.this))) && (ak.a(ak.this).getCount() > ak.a(ak.this).getChildCount()) && (ak.a(ak.this).getChildCount() <= ak.this.b))
      {
        ak.b(ak.this).setInputMethodMode(2);
        ak.this.c();
      }
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */