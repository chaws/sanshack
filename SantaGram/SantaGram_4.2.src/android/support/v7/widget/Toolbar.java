package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.j.af;
import android.support.v4.j.e;
import android.support.v4.j.n;
import android.support.v4.j.s;
import android.support.v7.b.a.k;
import android.support.v7.view.c;
import android.support.v7.view.g;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.l.a;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
  extends ViewGroup
{
  private boolean A;
  private final ArrayList<View> B = new ArrayList();
  private final ArrayList<View> C = new ArrayList();
  private final int[] D = new int[2];
  private c E;
  private final ActionMenuView.e F = new ActionMenuView.e()
  {
    public boolean a(MenuItem paramAnonymousMenuItem)
    {
      if (Toolbar.a(Toolbar.this) != null) {
        return Toolbar.a(Toolbar.this).a(paramAnonymousMenuItem);
      }
      return false;
    }
  };
  private bc G;
  private d H;
  private a I;
  private l.a J;
  private f.a K;
  private boolean L;
  private final Runnable M = new Runnable()
  {
    public void run()
    {
      Toolbar.this.d();
    }
  };
  private final m N;
  View a;
  private ActionMenuView b;
  private TextView c;
  private TextView d;
  private ImageButton e;
  private ImageView f;
  private Drawable g;
  private CharSequence h;
  private ImageButton i;
  private Context j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private final ar t = new ar();
  private int u = 8388627;
  private CharSequence v;
  private CharSequence w;
  private int x;
  private int y;
  private boolean z;
  
  public Toolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, android.support.v7.b.a.a.toolbarStyle);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = bb.a(getContext(), paramAttributeSet, a.k.Toolbar, paramInt, 0);
    this.l = paramContext.g(a.k.Toolbar_titleTextAppearance, 0);
    this.m = paramContext.g(a.k.Toolbar_subtitleTextAppearance, 0);
    this.u = paramContext.c(a.k.Toolbar_android_gravity, this.u);
    this.n = 48;
    paramInt = paramContext.d(a.k.Toolbar_titleMargins, 0);
    this.s = paramInt;
    this.r = paramInt;
    this.q = paramInt;
    this.p = paramInt;
    paramInt = paramContext.d(a.k.Toolbar_titleMarginStart, -1);
    if (paramInt >= 0) {
      this.p = paramInt;
    }
    paramInt = paramContext.d(a.k.Toolbar_titleMarginEnd, -1);
    if (paramInt >= 0) {
      this.q = paramInt;
    }
    paramInt = paramContext.d(a.k.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0) {
      this.r = paramInt;
    }
    paramInt = paramContext.d(a.k.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0) {
      this.s = paramInt;
    }
    this.o = paramContext.e(a.k.Toolbar_maxButtonHeight, -1);
    paramInt = paramContext.d(a.k.Toolbar_contentInsetStart, Integer.MIN_VALUE);
    int i1 = paramContext.d(a.k.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
    int i2 = paramContext.e(a.k.Toolbar_contentInsetLeft, 0);
    int i3 = paramContext.e(a.k.Toolbar_contentInsetRight, 0);
    this.t.b(i2, i3);
    if ((paramInt != Integer.MIN_VALUE) || (i1 != Integer.MIN_VALUE)) {
      this.t.a(paramInt, i1);
    }
    this.g = paramContext.a(a.k.Toolbar_collapseIcon);
    this.h = paramContext.c(a.k.Toolbar_collapseContentDescription);
    paramAttributeSet = paramContext.c(a.k.Toolbar_title);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.c(a.k.Toolbar_subtitle);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    this.j = getContext();
    setPopupTheme(paramContext.g(a.k.Toolbar_popupTheme, 0));
    paramAttributeSet = paramContext.a(a.k.Toolbar_navigationIcon);
    if (paramAttributeSet != null) {
      setNavigationIcon(paramAttributeSet);
    }
    paramAttributeSet = paramContext.c(a.k.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setNavigationContentDescription(paramAttributeSet);
    }
    paramAttributeSet = paramContext.a(a.k.Toolbar_logo);
    if (paramAttributeSet != null) {
      setLogo(paramAttributeSet);
    }
    paramAttributeSet = paramContext.c(a.k.Toolbar_logoDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setLogoDescription(paramAttributeSet);
    }
    if (paramContext.f(a.k.Toolbar_titleTextColor)) {
      setTitleTextColor(paramContext.b(a.k.Toolbar_titleTextColor, -1));
    }
    if (paramContext.f(a.k.Toolbar_subtitleTextColor)) {
      setSubtitleTextColor(paramContext.b(a.k.Toolbar_subtitleTextColor, -1));
    }
    paramContext.a();
    this.N = m.a();
  }
  
  private int a(int paramInt)
  {
    int i1 = paramInt & 0x70;
    paramInt = i1;
    switch (i1)
    {
    default: 
      paramInt = this.u & 0x70;
    }
    return paramInt;
  }
  
  private int a(View paramView, int paramInt)
  {
    b localb = (b)paramView.getLayoutParams();
    int i2 = paramView.getMeasuredHeight();
    int i1;
    int i3;
    int i4;
    if (paramInt > 0)
    {
      paramInt = (i2 - paramInt) / 2;
      switch (a(localb.a))
      {
      default: 
        i1 = getPaddingTop();
        i3 = getPaddingBottom();
        i4 = getHeight();
        paramInt = (i4 - i1 - i3 - i2) / 2;
        if (paramInt < localb.topMargin) {
          paramInt = localb.topMargin;
        }
        break;
      }
    }
    for (;;)
    {
      return paramInt + i1;
      paramInt = 0;
      break;
      return getPaddingTop() - paramInt;
      return getHeight() - getPaddingBottom() - i2 - localb.bottomMargin - paramInt;
      i2 = i4 - i3 - i2 - paramInt - i1;
      if (i2 < localb.bottomMargin) {
        paramInt = Math.max(0, paramInt - (localb.bottomMargin - i2));
      }
    }
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = localMarginLayoutParams.leftMargin - paramArrayOfInt[0];
    int i2 = localMarginLayoutParams.rightMargin - paramArrayOfInt[1];
    int i3 = Math.max(0, i1) + Math.max(0, i2);
    paramArrayOfInt[0] = Math.max(0, -i1);
    paramArrayOfInt[1] = Math.max(0, -i2);
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + i3 + paramInt2, localMarginLayoutParams.width), getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height));
    return paramView.getMeasuredWidth() + i3;
  }
  
  private int a(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    b localb = (b)paramView.getLayoutParams();
    int i1 = localb.leftMargin - paramArrayOfInt[0];
    paramInt1 = Math.max(0, i1) + paramInt1;
    paramArrayOfInt[0] = Math.max(0, -i1);
    paramInt2 = a(paramView, paramInt2);
    i1 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i1, paramView.getMeasuredHeight() + paramInt2);
    return localb.rightMargin + i1 + paramInt1;
  }
  
  private int a(List<View> paramList, int[] paramArrayOfInt)
  {
    int i4 = paramArrayOfInt[0];
    int i3 = paramArrayOfInt[1];
    int i5 = paramList.size();
    int i2 = 0;
    int i1 = 0;
    while (i2 < i5)
    {
      paramArrayOfInt = (View)paramList.get(i2);
      b localb = (b)paramArrayOfInt.getLayoutParams();
      i4 = localb.leftMargin - i4;
      i3 = localb.rightMargin - i3;
      int i6 = Math.max(0, i4);
      int i7 = Math.max(0, i3);
      i4 = Math.max(0, -i4);
      i3 = Math.max(0, -i3);
      int i8 = paramArrayOfInt.getMeasuredWidth();
      i2 += 1;
      i1 += i8 + i6 + i7;
    }
    return i1;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height);
    paramInt3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt3 != 1073741824)
    {
      paramInt1 = paramInt2;
      if (paramInt5 >= 0)
      {
        paramInt1 = paramInt5;
        if (paramInt3 != 0) {
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt2), paramInt5);
        }
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      }
    }
    paramView.measure(i1, paramInt1);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = i();
    }
    for (;;)
    {
      ((b)localObject).b = 1;
      if ((!paramBoolean) || (this.a == null)) {
        break;
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.C.add(paramView);
      return;
      if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
        localObject = a((ViewGroup.LayoutParams)localObject);
      } else {
        localObject = (b)localObject;
      }
    }
    addView(paramView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void a(List<View> paramList, int paramInt)
  {
    int i1 = 1;
    int i2 = 0;
    if (af.h(this) == 1) {}
    int i4;
    int i3;
    View localView;
    b localb;
    for (;;)
    {
      i4 = getChildCount();
      i3 = e.a(paramInt, af.h(this));
      paramList.clear();
      paramInt = i2;
      if (i1 == 0) {
        break;
      }
      paramInt = i4 - 1;
      while (paramInt >= 0)
      {
        localView = getChildAt(paramInt);
        localb = (b)localView.getLayoutParams();
        if ((localb.b == 0) && (a(localView)) && (b(localb.a) == i3)) {
          paramList.add(localView);
        }
        paramInt -= 1;
      }
      i1 = 0;
    }
    while (paramInt < i4)
    {
      localView = getChildAt(paramInt);
      localb = (b)localView.getLayoutParams();
      if ((localb.b == 0) && (a(localView)) && (b(localb.a) == i3)) {
        paramList.add(localView);
      }
      paramInt += 1;
    }
  }
  
  private boolean a(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }
  
  private int b(int paramInt)
  {
    int i2 = af.h(this);
    int i1 = e.a(paramInt, i2) & 0x7;
    paramInt = i1;
    switch (i1)
    {
    case 2: 
    case 4: 
    default: 
      if (i2 == 1) {
        paramInt = 5;
      }
      break;
    case 1: 
    case 3: 
    case 5: 
      return paramInt;
    }
    return 3;
  }
  
  private int b(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = n.a(paramView);
    return n.b(paramView) + i1;
  }
  
  private int b(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    b localb = (b)paramView.getLayoutParams();
    int i1 = localb.rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i1);
    paramArrayOfInt[1] = Math.max(0, -i1);
    paramInt2 = a(paramView, paramInt2);
    i1 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i1, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - (localb.leftMargin + i1);
  }
  
  private int c(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = paramView.topMargin;
    return paramView.bottomMargin + i1;
  }
  
  private boolean d(View paramView)
  {
    return (paramView.getParent() == this) || (this.C.contains(paramView));
  }
  
  private MenuInflater getMenuInflater()
  {
    return new g(getContext());
  }
  
  private void l()
  {
    if (this.f == null) {
      this.f = new ImageView(getContext());
    }
  }
  
  private void m()
  {
    n();
    if (this.b.d() == null)
    {
      f localf = (f)this.b.getMenu();
      if (this.I == null) {
        this.I = new a(null);
      }
      this.b.setExpandedActionViewsExclusive(true);
      localf.a(this.I, this.j);
    }
  }
  
  private void n()
  {
    if (this.b == null)
    {
      this.b = new ActionMenuView(getContext());
      this.b.setPopupTheme(this.k);
      this.b.setOnMenuItemClickListener(this.F);
      this.b.a(this.J, this.K);
      b localb = i();
      localb.a = (0x800005 | this.n & 0x70);
      this.b.setLayoutParams(localb);
      a(this.b, false);
    }
  }
  
  private void o()
  {
    if (this.e == null)
    {
      this.e = new ImageButton(getContext(), null, android.support.v7.b.a.a.toolbarNavigationButtonStyle);
      b localb = i();
      localb.a = (0x800003 | this.n & 0x70);
      this.e.setLayoutParams(localb);
    }
  }
  
  private void p()
  {
    if (this.i == null)
    {
      this.i = new ImageButton(getContext(), null, android.support.v7.b.a.a.toolbarNavigationButtonStyle);
      this.i.setImageDrawable(this.g);
      this.i.setContentDescription(this.h);
      b localb = i();
      localb.a = (0x800003 | this.n & 0x70);
      localb.b = 2;
      this.i.setLayoutParams(localb);
      this.i.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Toolbar.this.h();
        }
      });
    }
  }
  
  private void q()
  {
    removeCallbacks(this.M);
    post(this.M);
  }
  
  private boolean r()
  {
    if (!this.L) {
      return false;
    }
    int i2 = getChildCount();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label56;
      }
      View localView = getChildAt(i1);
      if ((a(localView)) && (localView.getMeasuredWidth() > 0) && (localView.getMeasuredHeight() > 0)) {
        break;
      }
      i1 += 1;
    }
    label56:
    return true;
  }
  
  public b a(AttributeSet paramAttributeSet)
  {
    return new b(getContext(), paramAttributeSet);
  }
  
  protected b a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof b)) {
      return new b((b)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof android.support.v7.a.a.a)) {
      return new b((android.support.v7.a.a.a)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new b((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new b(paramLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.t.a(paramInt1, paramInt2);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    this.l = paramInt;
    if (this.c != null) {
      this.c.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public void a(f paramf, d paramd)
  {
    if ((paramf == null) && (this.b == null)) {}
    f localf;
    do
    {
      return;
      n();
      localf = this.b.d();
    } while (localf == paramf);
    if (localf != null)
    {
      localf.b(this.H);
      localf.b(this.I);
    }
    if (this.I == null) {
      this.I = new a(null);
    }
    paramd.d(true);
    if (paramf != null)
    {
      paramf.a(paramd, this.j);
      paramf.a(this.I, this.j);
    }
    for (;;)
    {
      this.b.setPopupTheme(this.k);
      this.b.setPresenter(paramd);
      this.H = paramd;
      return;
      paramd.a(this.j, null);
      this.I.a(this.j, null);
      paramd.b(true);
      this.I.b(true);
    }
  }
  
  public void a(l.a parama, f.a parama1)
  {
    this.J = parama;
    this.K = parama1;
    if (this.b != null) {
      this.b.a(parama, parama1);
    }
  }
  
  public boolean a()
  {
    return (getVisibility() == 0) && (this.b != null) && (this.b.a());
  }
  
  public void b(Context paramContext, int paramInt)
  {
    this.m = paramInt;
    if (this.d != null) {
      this.d.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public boolean b()
  {
    return (this.b != null) && (this.b.g());
  }
  
  public boolean c()
  {
    return (this.b != null) && (this.b.h());
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof b));
  }
  
  public boolean d()
  {
    return (this.b != null) && (this.b.e());
  }
  
  public boolean e()
  {
    return (this.b != null) && (this.b.f());
  }
  
  public void f()
  {
    if (this.b != null) {
      this.b.i();
    }
  }
  
  public boolean g()
  {
    return (this.I != null) && (this.I.b != null);
  }
  
  public int getContentInsetEnd()
  {
    return this.t.d();
  }
  
  public int getContentInsetLeft()
  {
    return this.t.a();
  }
  
  public int getContentInsetRight()
  {
    return this.t.b();
  }
  
  public int getContentInsetStart()
  {
    return this.t.c();
  }
  
  public Drawable getLogo()
  {
    if (this.f != null) {
      return this.f.getDrawable();
    }
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    if (this.f != null) {
      return this.f.getContentDescription();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    m();
    return this.b.getMenu();
  }
  
  public CharSequence getNavigationContentDescription()
  {
    if (this.e != null) {
      return this.e.getContentDescription();
    }
    return null;
  }
  
  public Drawable getNavigationIcon()
  {
    if (this.e != null) {
      return this.e.getDrawable();
    }
    return null;
  }
  
  public Drawable getOverflowIcon()
  {
    m();
    return this.b.getOverflowIcon();
  }
  
  public int getPopupTheme()
  {
    return this.k;
  }
  
  public CharSequence getSubtitle()
  {
    return this.w;
  }
  
  public CharSequence getTitle()
  {
    return this.v;
  }
  
  public ae getWrapper()
  {
    if (this.G == null) {
      this.G = new bc(this, true);
    }
    return this.G;
  }
  
  public void h()
  {
    if (this.I == null) {}
    for (h localh = null;; localh = this.I.b)
    {
      if (localh != null) {
        localh.collapseActionView();
      }
      return;
    }
  }
  
  protected b i()
  {
    return new b(-2, -2);
  }
  
  void j()
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      View localView = getChildAt(i1);
      if ((((b)localView.getLayoutParams()).b != 2) && (localView != this.b))
      {
        removeViewAt(i1);
        this.C.add(localView);
      }
      i1 -= 1;
    }
  }
  
  void k()
  {
    int i1 = this.C.size() - 1;
    while (i1 >= 0)
    {
      addView((View)this.C.get(i1));
      i1 -= 1;
    }
    this.C.clear();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.M);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i1 = s.a(paramMotionEvent);
    if (i1 == 9) {
      this.A = false;
    }
    if (!this.A)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i1 == 9) && (!bool)) {
        this.A = true;
      }
    }
    if ((i1 == 10) || (i1 == 3)) {
      this.A = false;
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3;
    int i6;
    int i9;
    int i1;
    int i7;
    int i8;
    int i10;
    int[] arrayOfInt;
    int i5;
    if (af.h(this) == 1)
    {
      i3 = 1;
      i6 = getWidth();
      i9 = getHeight();
      i1 = getPaddingLeft();
      i7 = getPaddingRight();
      i8 = getPaddingTop();
      i10 = getPaddingBottom();
      paramInt4 = i6 - i7;
      arrayOfInt = this.D;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      i5 = af.p(this);
      if (!a(this.e)) {
        break label1565;
      }
      if (i3 == 0) {
        break label876;
      }
      paramInt4 = b(this.e, paramInt4, arrayOfInt, i5);
      paramInt1 = i1;
    }
    for (;;)
    {
      label111:
      paramInt2 = paramInt4;
      paramInt3 = paramInt1;
      if (a(this.i))
      {
        if (i3 != 0)
        {
          paramInt2 = b(this.i, paramInt4, arrayOfInt, i5);
          paramInt3 = paramInt1;
        }
      }
      else
      {
        label151:
        paramInt1 = paramInt2;
        paramInt4 = paramInt3;
        if (a(this.b))
        {
          if (i3 == 0) {
            break label915;
          }
          paramInt4 = a(this.b, paramInt3, arrayOfInt, i5);
          paramInt1 = paramInt2;
        }
        label191:
        arrayOfInt[0] = Math.max(0, getContentInsetLeft() - paramInt4);
        arrayOfInt[1] = Math.max(0, getContentInsetRight() - (i6 - i7 - paramInt1));
        paramInt3 = Math.max(paramInt4, getContentInsetLeft());
        paramInt4 = Math.min(paramInt1, i6 - i7 - getContentInsetRight());
        paramInt2 = paramInt4;
        paramInt1 = paramInt3;
        if (a(this.a))
        {
          if (i3 == 0) {
            break label936;
          }
          paramInt2 = b(this.a, paramInt4, arrayOfInt, i5);
          paramInt1 = paramInt3;
        }
        label293:
        if (!a(this.f)) {
          break label1559;
        }
        if (i3 == 0) {
          break label957;
        }
        paramInt2 = b(this.f, paramInt2, arrayOfInt, i5);
        paramInt3 = paramInt1;
      }
      for (;;)
      {
        label326:
        paramBoolean = a(this.c);
        boolean bool = a(this.d);
        paramInt1 = 0;
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = (b)this.c.getLayoutParams();
          paramInt1 = ((b)localObject1).topMargin;
          paramInt4 = this.c.getMeasuredHeight();
          paramInt1 = 0 + (((b)localObject1).bottomMargin + (paramInt1 + paramInt4));
        }
        int i2;
        if (bool)
        {
          localObject1 = (b)this.d.getLayoutParams();
          paramInt4 = ((b)localObject1).topMargin;
          i2 = this.d.getMeasuredHeight();
        }
        for (int i4 = ((b)localObject1).bottomMargin + (paramInt4 + i2) + paramInt1;; i4 = paramInt1)
        {
          label464:
          Object localObject2;
          if (!paramBoolean)
          {
            paramInt4 = paramInt2;
            paramInt1 = paramInt3;
            if (!bool) {}
          }
          else
          {
            if (!paramBoolean) {
              break label975;
            }
            localObject1 = this.c;
            if (!bool) {
              break label984;
            }
            localObject2 = this.d;
            label475:
            localObject1 = (b)((View)localObject1).getLayoutParams();
            localObject2 = (b)((View)localObject2).getLayoutParams();
            if (((!paramBoolean) || (this.c.getMeasuredWidth() <= 0)) && ((!bool) || (this.d.getMeasuredWidth() <= 0))) {
              break label993;
            }
            i2 = 1;
            label527:
            switch (this.u & 0x70)
            {
            default: 
              paramInt1 = (i9 - i8 - i10 - i4) / 2;
              if (paramInt1 < ((b)localObject1).topMargin + this.r) {
                paramInt1 = ((b)localObject1).topMargin + this.r;
              }
              break;
            }
          }
          label599:
          label604:
          label620:
          label876:
          label915:
          label936:
          label957:
          label975:
          label984:
          label993:
          label1113:
          label1527:
          label1544:
          label1550:
          for (;;)
          {
            paramInt1 = i8 + paramInt1;
            if (i3 != 0) {
              if (i2 != 0)
              {
                paramInt4 = this.p;
                paramInt4 -= arrayOfInt[1];
                paramInt2 -= Math.max(0, paramInt4);
                arrayOfInt[1] = Math.max(0, -paramInt4);
                if (!paramBoolean) {
                  break label1544;
                }
                localObject1 = (b)this.c.getLayoutParams();
                paramInt4 = paramInt2 - this.c.getMeasuredWidth();
                i3 = this.c.getMeasuredHeight() + paramInt1;
                this.c.layout(paramInt4, paramInt1, paramInt2, i3);
                i4 = this.q;
                paramInt1 = i3 + ((b)localObject1).bottomMargin;
                paramInt4 -= i4;
              }
            }
            for (;;)
            {
              if (bool)
              {
                localObject1 = (b)this.d.getLayoutParams();
                paramInt1 = ((b)localObject1).topMargin + paramInt1;
                i3 = this.d.getMeasuredWidth();
                i4 = this.d.getMeasuredHeight() + paramInt1;
                this.d.layout(paramInt2 - i3, paramInt1, paramInt2, i4);
                paramInt1 = this.q;
                i3 = ((b)localObject1).bottomMargin;
              }
              for (paramInt1 = paramInt2 - paramInt1;; paramInt1 = paramInt2)
              {
                if (i2 != 0) {}
                for (paramInt1 = Math.min(paramInt4, paramInt1);; paramInt1 = paramInt2)
                {
                  paramInt4 = paramInt1;
                  paramInt1 = paramInt3;
                  a(this.B, 3);
                  paramInt3 = this.B.size();
                  paramInt2 = 0;
                  for (;;)
                  {
                    if (paramInt2 < paramInt3)
                    {
                      paramInt1 = a((View)this.B.get(paramInt2), paramInt1, arrayOfInt, i5);
                      paramInt2 += 1;
                      continue;
                      i3 = 0;
                      break;
                      paramInt1 = a(this.e, i1, arrayOfInt, i5);
                      break label111;
                      paramInt3 = a(this.i, paramInt1, arrayOfInt, i5);
                      paramInt2 = paramInt4;
                      break label151;
                      paramInt1 = b(this.b, paramInt2, arrayOfInt, i5);
                      paramInt4 = paramInt3;
                      break label191;
                      paramInt1 = a(this.a, paramInt3, arrayOfInt, i5);
                      paramInt2 = paramInt4;
                      break label293;
                      paramInt3 = a(this.f, paramInt1, arrayOfInt, i5);
                      break label326;
                      localObject1 = this.d;
                      break label464;
                      localObject2 = this.c;
                      break label475;
                      i2 = 0;
                      break label527;
                      paramInt1 = getPaddingTop();
                      paramInt1 = ((b)localObject1).topMargin + paramInt1 + this.r;
                      break label604;
                      paramInt4 = i9 - i10 - i4 - paramInt1 - i8;
                      if (paramInt4 >= ((b)localObject1).bottomMargin + this.s) {
                        break label1550;
                      }
                      paramInt1 = Math.max(0, paramInt1 - (((b)localObject2).bottomMargin + this.s - paramInt4));
                      break label599;
                      paramInt1 = i9 - i10 - ((b)localObject2).bottomMargin - this.s - i4;
                      break label604;
                      paramInt4 = 0;
                      break label620;
                      if (i2 != 0)
                      {
                        paramInt4 = this.p;
                        paramInt4 -= arrayOfInt[0];
                        paramInt3 += Math.max(0, paramInt4);
                        arrayOfInt[0] = Math.max(0, -paramInt4);
                        if (!paramBoolean) {
                          break label1527;
                        }
                        localObject1 = (b)this.c.getLayoutParams();
                        i3 = this.c.getMeasuredWidth() + paramInt3;
                        paramInt4 = this.c.getMeasuredHeight() + paramInt1;
                        this.c.layout(paramInt3, paramInt1, i3, paramInt4);
                        i4 = this.q;
                        paramInt1 = ((b)localObject1).bottomMargin;
                        i3 += i4;
                        paramInt1 += paramInt4;
                      }
                    }
                  }
                  for (;;)
                  {
                    if (bool)
                    {
                      localObject1 = (b)this.d.getLayoutParams();
                      paramInt4 = paramInt1 + ((b)localObject1).topMargin;
                      paramInt1 = this.d.getMeasuredWidth() + paramInt3;
                      i4 = this.d.getMeasuredHeight() + paramInt4;
                      this.d.layout(paramInt3, paramInt4, paramInt1, i4);
                      paramInt4 = this.q;
                      i4 = ((b)localObject1).bottomMargin;
                    }
                    for (i4 = paramInt4 + paramInt1;; i4 = paramInt3)
                    {
                      paramInt4 = paramInt2;
                      paramInt1 = paramInt3;
                      if (i2 == 0) {
                        break;
                      }
                      paramInt1 = Math.max(i3, i4);
                      paramInt4 = paramInt2;
                      break;
                      paramInt4 = 0;
                      break label1113;
                      a(this.B, 5);
                      paramInt3 = this.B.size();
                      paramInt2 = 0;
                      while (paramInt2 < paramInt3)
                      {
                        paramInt4 = b((View)this.B.get(paramInt2), paramInt4, arrayOfInt, i5);
                        paramInt2 += 1;
                      }
                      a(this.B, 1);
                      paramInt3 = a(this.B, arrayOfInt);
                      paramInt2 = (i6 - i1 - i7) / 2 + i1 - paramInt3 / 2;
                      paramInt3 += paramInt2;
                      if (paramInt2 < paramInt1) {}
                      for (;;)
                      {
                        paramInt4 = this.B.size();
                        paramInt3 = 0;
                        paramInt2 = paramInt1;
                        paramInt1 = paramInt3;
                        while (paramInt1 < paramInt4)
                        {
                          paramInt2 = a((View)this.B.get(paramInt1), paramInt2, arrayOfInt, i5);
                          paramInt1 += 1;
                        }
                        paramInt1 = paramInt2;
                        if (paramInt3 > paramInt4) {
                          paramInt1 = paramInt2 - (paramInt3 - paramInt4);
                        }
                      }
                      this.B.clear();
                      return;
                    }
                    i3 = paramInt3;
                  }
                }
              }
              paramInt4 = paramInt2;
            }
          }
        }
        label1559:
        paramInt3 = paramInt1;
      }
      label1565:
      paramInt1 = i1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = 0;
    int i3 = 0;
    int[] arrayOfInt = this.D;
    int i5;
    int i6;
    int i1;
    int i7;
    int i2;
    int i8;
    label539:
    View localView;
    if (bf.a(this))
    {
      i5 = 0;
      i6 = 1;
      i1 = 0;
      if (a(this.e))
      {
        a(this.e, paramInt1, 0, paramInt2, 0, this.o);
        i1 = this.e.getMeasuredWidth() + b(this.e);
        i4 = Math.max(0, this.e.getMeasuredHeight() + c(this.e));
        i3 = bf.a(0, af.j(this.e));
      }
      i7 = i1;
      i1 = i3;
      i2 = i4;
      if (a(this.i))
      {
        a(this.i, paramInt1, 0, paramInt2, 0, this.o);
        i7 = this.i.getMeasuredWidth() + b(this.i);
        i2 = Math.max(i4, this.i.getMeasuredHeight() + c(this.i));
        i1 = bf.a(i3, af.j(this.i));
      }
      i3 = getContentInsetStart();
      i8 = 0 + Math.max(i3, i7);
      arrayOfInt[i6] = Math.max(0, i3 - i7);
      i6 = 0;
      i3 = i1;
      i4 = i2;
      if (a(this.b))
      {
        a(this.b, paramInt1, i8, paramInt2, 0, this.o);
        i6 = this.b.getMeasuredWidth() + b(this.b);
        i4 = Math.max(i2, this.b.getMeasuredHeight() + c(this.b));
        i3 = bf.a(i1, af.j(this.b));
      }
      i1 = getContentInsetEnd();
      i7 = i8 + Math.max(i1, i6);
      arrayOfInt[i5] = Math.max(0, i1 - i6);
      i6 = i7;
      i1 = i3;
      i2 = i4;
      if (a(this.a))
      {
        i6 = i7 + a(this.a, paramInt1, i7, paramInt2, 0, arrayOfInt);
        i2 = Math.max(i4, this.a.getMeasuredHeight() + c(this.a));
        i1 = bf.a(i3, af.j(this.a));
      }
      i3 = i6;
      i4 = i1;
      i5 = i2;
      if (a(this.f))
      {
        i3 = i6 + a(this.f, paramInt1, i6, paramInt2, 0, arrayOfInt);
        i5 = Math.max(i2, this.f.getMeasuredHeight() + c(this.f));
        i4 = bf.a(i1, af.j(this.f));
      }
      i7 = getChildCount();
      i6 = 0;
      i2 = i5;
      i1 = i4;
      i4 = i6;
      i6 = i3;
      if (i4 >= i7) {
        break label646;
      }
      localView = getChildAt(i4);
      if (((b)localView.getLayoutParams()).b != 0) {
        break label953;
      }
      if (a(localView)) {
        break label595;
      }
    }
    label595:
    label646:
    label953:
    for (;;)
    {
      i4 += 1;
      break label539;
      i5 = 1;
      i6 = 0;
      break;
      i6 += a(localView, paramInt1, i6, paramInt2, 0, arrayOfInt);
      i2 = Math.max(i2, localView.getMeasuredHeight() + c(localView));
      i1 = bf.a(i1, af.j(localView));
      continue;
      i5 = 0;
      i4 = 0;
      int i9 = this.r + this.s;
      int i10 = this.p + this.q;
      i3 = i1;
      if (a(this.c))
      {
        a(this.c, paramInt1, i6 + i10, paramInt2, i9, arrayOfInt);
        i3 = this.c.getMeasuredWidth();
        i5 = b(this.c) + i3;
        i4 = this.c.getMeasuredHeight() + c(this.c);
        i3 = bf.a(i1, af.j(this.c));
      }
      i8 = i4;
      i7 = i5;
      i1 = i3;
      if (a(this.d))
      {
        i7 = Math.max(i5, a(this.d, paramInt1, i6 + i10, paramInt2, i9 + i4, arrayOfInt));
        i8 = i4 + (this.d.getMeasuredHeight() + c(this.d));
        i1 = bf.a(i3, af.j(this.d));
      }
      i2 = Math.max(i2, i8);
      i5 = getPaddingLeft();
      i8 = getPaddingRight();
      i3 = getPaddingTop();
      i4 = getPaddingBottom();
      i5 = af.a(Math.max(i7 + i6 + (i5 + i8), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i1);
      paramInt1 = af.a(Math.max(i2 + (i3 + i4), getSuggestedMinimumHeight()), paramInt2, i1 << 16);
      if (r()) {
        paramInt1 = 0;
      }
      setMeasuredDimension(i5, paramInt1);
      return;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof d))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    d locald = (d)paramParcelable;
    super.onRestoreInstanceState(locald.getSuperState());
    if (this.b != null) {}
    for (paramParcelable = this.b.d();; paramParcelable = null)
    {
      if ((locald.a != 0) && (this.I != null) && (paramParcelable != null))
      {
        paramParcelable = paramParcelable.findItem(locald.a);
        if (paramParcelable != null) {
          android.support.v4.j.p.b(paramParcelable);
        }
      }
      if (!locald.b) {
        break;
      }
      q();
      return;
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    ar localar = this.t;
    if (paramInt == 1) {}
    for (;;)
    {
      localar.a(bool);
      return;
      bool = false;
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    d locald = new d(super.onSaveInstanceState());
    if ((this.I != null) && (this.I.b != null)) {
      locald.a = this.I.b.getItemId();
    }
    locald.b = b();
    return locald;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = s.a(paramMotionEvent);
    if (i1 == 0) {
      this.z = false;
    }
    if (!this.z)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i1 == 0) && (!bool)) {
        this.z = true;
      }
    }
    if ((i1 == 1) || (i1 == 3)) {
      this.z = false;
    }
    return true;
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.L = paramBoolean;
    requestLayout();
  }
  
  public void setLogo(int paramInt)
  {
    setLogo(this.N.a(getContext(), paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      l();
      if (!d(this.f)) {
        a(this.f, true);
      }
    }
    for (;;)
    {
      if (this.f != null) {
        this.f.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.f != null) && (d(this.f)))
      {
        removeView(this.f);
        this.C.remove(this.f);
      }
    }
  }
  
  public void setLogoDescription(int paramInt)
  {
    setLogoDescription(getContext().getText(paramInt));
  }
  
  public void setLogoDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      l();
    }
    if (this.f != null) {
      this.f.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationContentDescription(int paramInt)
  {
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = getContext().getText(paramInt);; localCharSequence = null)
    {
      setNavigationContentDescription(localCharSequence);
      return;
    }
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      o();
    }
    if (this.e != null) {
      this.e.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationIcon(int paramInt)
  {
    setNavigationIcon(this.N.a(getContext(), paramInt));
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      o();
      if (!d(this.e)) {
        a(this.e, true);
      }
    }
    for (;;)
    {
      if (this.e != null) {
        this.e.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.e != null) && (d(this.e)))
      {
        removeView(this.e);
        this.C.remove(this.e);
      }
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    o();
    this.e.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(c paramc)
  {
    this.E = paramc;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    m();
    this.b.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.k != paramInt)
    {
      this.k = paramInt;
      if (paramInt == 0) {
        this.j = getContext();
      }
    }
    else
    {
      return;
    }
    this.j = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.d == null)
      {
        Context localContext = getContext();
        this.d = new TextView(localContext);
        this.d.setSingleLine();
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        if (this.m != 0) {
          this.d.setTextAppearance(localContext, this.m);
        }
        if (this.y != 0) {
          this.d.setTextColor(this.y);
        }
      }
      if (!d(this.d)) {
        a(this.d, true);
      }
    }
    for (;;)
    {
      if (this.d != null) {
        this.d.setText(paramCharSequence);
      }
      this.w = paramCharSequence;
      return;
      if ((this.d != null) && (d(this.d)))
      {
        removeView(this.d);
        this.C.remove(this.d);
      }
    }
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    this.y = paramInt;
    if (this.d != null) {
      this.d.setTextColor(paramInt);
    }
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getContext().getText(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.c == null)
      {
        Context localContext = getContext();
        this.c = new TextView(localContext);
        this.c.setSingleLine();
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        if (this.l != 0) {
          this.c.setTextAppearance(localContext, this.l);
        }
        if (this.x != 0) {
          this.c.setTextColor(this.x);
        }
      }
      if (!d(this.c)) {
        a(this.c, true);
      }
    }
    for (;;)
    {
      if (this.c != null) {
        this.c.setText(paramCharSequence);
      }
      this.v = paramCharSequence;
      return;
      if ((this.c != null) && (d(this.c)))
      {
        removeView(this.c);
        this.C.remove(this.c);
      }
    }
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.x = paramInt;
    if (this.c != null) {
      this.c.setTextColor(paramInt);
    }
  }
  
  private class a
    implements l
  {
    f a;
    h b;
    
    private a() {}
    
    public void a(Context paramContext, f paramf)
    {
      if ((this.a != null) && (this.b != null)) {
        this.a.d(this.b);
      }
      this.a = paramf;
    }
    
    public void a(f paramf, boolean paramBoolean) {}
    
    public boolean a(f paramf, h paramh)
    {
      Toolbar.b(Toolbar.this);
      if (Toolbar.c(Toolbar.this).getParent() != Toolbar.this) {
        Toolbar.this.addView(Toolbar.c(Toolbar.this));
      }
      Toolbar.this.a = paramh.getActionView();
      this.b = paramh;
      if (Toolbar.this.a.getParent() != Toolbar.this)
      {
        paramf = Toolbar.this.i();
        paramf.a = (0x800003 | Toolbar.d(Toolbar.this) & 0x70);
        paramf.b = 2;
        Toolbar.this.a.setLayoutParams(paramf);
        Toolbar.this.addView(Toolbar.this.a);
      }
      Toolbar.this.j();
      Toolbar.this.requestLayout();
      paramh.e(true);
      if ((Toolbar.this.a instanceof c)) {
        ((c)Toolbar.this.a).a();
      }
      return true;
    }
    
    public boolean a(android.support.v7.view.menu.p paramp)
    {
      return false;
    }
    
    public void b(boolean paramBoolean)
    {
      int k = 0;
      int j;
      int m;
      int i;
      if (this.b != null)
      {
        j = k;
        if (this.a != null)
        {
          m = this.a.size();
          i = 0;
        }
      }
      for (;;)
      {
        j = k;
        if (i < m)
        {
          if (this.a.getItem(i) == this.b) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            b(this.a, this.b);
          }
          return;
        }
        i += 1;
      }
    }
    
    public boolean b()
    {
      return false;
    }
    
    public boolean b(f paramf, h paramh)
    {
      if ((Toolbar.this.a instanceof c)) {
        ((c)Toolbar.this.a).b();
      }
      Toolbar.this.removeView(Toolbar.this.a);
      Toolbar.this.removeView(Toolbar.c(Toolbar.this));
      Toolbar.this.a = null;
      Toolbar.this.k();
      this.b = null;
      Toolbar.this.requestLayout();
      paramh.e(false);
      return true;
    }
  }
  
  public static class b
    extends android.support.v7.a.a.a
  {
    int b = 0;
    
    public b(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.a = 8388627;
    }
    
    public b(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public b(android.support.v7.a.a.a parama)
    {
      super();
    }
    
    public b(b paramb)
    {
      super();
      this.b = paramb.b;
    }
    
    public b(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public b(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      a(paramMarginLayoutParams);
    }
    
    void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      this.leftMargin = paramMarginLayoutParams.leftMargin;
      this.topMargin = paramMarginLayoutParams.topMargin;
      this.rightMargin = paramMarginLayoutParams.rightMargin;
      this.bottomMargin = paramMarginLayoutParams.bottomMargin;
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean a(MenuItem paramMenuItem);
  }
  
  public static class d
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator()
    {
      public Toolbar.d a(Parcel paramAnonymousParcel)
      {
        return new Toolbar.d(paramAnonymousParcel);
      }
      
      public Toolbar.d[] a(int paramAnonymousInt)
      {
        return new Toolbar.d[paramAnonymousInt];
      }
    };
    int a;
    boolean b;
    
    public d(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.b = bool;
        return;
      }
    }
    
    public d(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a);
      if (this.b) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/Toolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */