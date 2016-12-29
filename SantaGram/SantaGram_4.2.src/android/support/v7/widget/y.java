package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.c.a;
import android.support.v4.j.ac;
import android.support.v4.j.af;
import android.support.v7.b.a.a;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class y
  extends Spinner
  implements ac
{
  private static final boolean a;
  private static final boolean b;
  private static final int[] c;
  private m d;
  private h e;
  private Context f;
  private ak.b g;
  private SpinnerAdapter h;
  private boolean i;
  private b j;
  private int k;
  private final Rect l;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      bool = true;
      a = bool;
      if (Build.VERSION.SDK_INT < 16) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      c = new int[] { 16843505 };
      return;
      bool = false;
      break;
    }
  }
  
  public y(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.spinnerStyle);
  }
  
  public y(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  public y(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAttributeSet, paramInt1, paramInt2, null);
  }
  
  /* Error */
  public y(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, final Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 74	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 76	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 78	android/graphics/Rect:<init>	()V
    //   15: putfield 80	android/support/v7/widget/y:l	Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 85	android/support/v7/b/a$k:Spinner	[I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokestatic 90	android/support/v7/widget/bb:a	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/bb;
    //   28: astore 8
    //   30: aload_0
    //   31: invokestatic 95	android/support/v7/widget/m:a	()Landroid/support/v7/widget/m;
    //   34: putfield 97	android/support/v7/widget/y:d	Landroid/support/v7/widget/m;
    //   37: aload_0
    //   38: new 99	android/support/v7/widget/h
    //   41: dup
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 97	android/support/v7/widget/y:d	Landroid/support/v7/widget/m;
    //   47: invokespecial 102	android/support/v7/widget/h:<init>	(Landroid/view/View;Landroid/support/v7/widget/m;)V
    //   50: putfield 104	android/support/v7/widget/y:e	Landroid/support/v7/widget/h;
    //   53: aload 5
    //   55: ifnull +285 -> 340
    //   58: aload_0
    //   59: new 106	android/support/v7/view/d
    //   62: dup
    //   63: aload_1
    //   64: aload 5
    //   66: invokespecial 109	android/support/v7/view/d:<init>	(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   69: putfield 111	android/support/v7/widget/y:f	Landroid/content/Context;
    //   72: aload_0
    //   73: getfield 111	android/support/v7/widget/y:f	Landroid/content/Context;
    //   76: ifnull +184 -> 260
    //   79: iload 4
    //   81: istore 10
    //   83: iload 4
    //   85: iconst_m1
    //   86: if_icmpne +71 -> 157
    //   89: getstatic 47	android/os/Build$VERSION:SDK_INT	I
    //   92: bipush 11
    //   94: if_icmplt +359 -> 453
    //   97: aload_1
    //   98: aload_2
    //   99: getstatic 54	android/support/v7/widget/y:c	[I
    //   102: iload_3
    //   103: iconst_0
    //   104: invokevirtual 117	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   107: astore 6
    //   109: iload 4
    //   111: istore 9
    //   113: aload 6
    //   115: astore 5
    //   117: aload 6
    //   119: iconst_0
    //   120: invokevirtual 123	android/content/res/TypedArray:hasValue	(I)Z
    //   123: ifeq +16 -> 139
    //   126: aload 6
    //   128: astore 5
    //   130: aload 6
    //   132: iconst_0
    //   133: iconst_0
    //   134: invokevirtual 127	android/content/res/TypedArray:getInt	(II)I
    //   137: istore 9
    //   139: iload 9
    //   141: istore 10
    //   143: aload 6
    //   145: ifnull +12 -> 157
    //   148: aload 6
    //   150: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   153: iload 9
    //   155: istore 10
    //   157: iload 10
    //   159: iconst_1
    //   160: if_icmpne +100 -> 260
    //   163: new 13	android/support/v7/widget/y$b
    //   166: dup
    //   167: aload_0
    //   168: aload_0
    //   169: getfield 111	android/support/v7/widget/y:f	Landroid/content/Context;
    //   172: aload_2
    //   173: iload_3
    //   174: invokespecial 133	android/support/v7/widget/y$b:<init>	(Landroid/support/v7/widget/y;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   177: astore 5
    //   179: aload_0
    //   180: getfield 111	android/support/v7/widget/y:f	Landroid/content/Context;
    //   183: aload_2
    //   184: getstatic 85	android/support/v7/b/a$k:Spinner	[I
    //   187: iload_3
    //   188: iconst_0
    //   189: invokestatic 90	android/support/v7/widget/bb:a	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/bb;
    //   192: astore 6
    //   194: aload_0
    //   195: aload 6
    //   197: getstatic 136	android/support/v7/b/a$k:Spinner_android_dropDownWidth	I
    //   200: bipush -2
    //   202: invokevirtual 138	android/support/v7/widget/bb:f	(II)I
    //   205: putfield 140	android/support/v7/widget/y:k	I
    //   208: aload 5
    //   210: aload 6
    //   212: getstatic 143	android/support/v7/b/a$k:Spinner_android_popupBackground	I
    //   215: invokevirtual 146	android/support/v7/widget/bb:a	(I)Landroid/graphics/drawable/Drawable;
    //   218: invokevirtual 149	android/support/v7/widget/y$b:a	(Landroid/graphics/drawable/Drawable;)V
    //   221: aload 5
    //   223: aload 8
    //   225: getstatic 152	android/support/v7/b/a$k:Spinner_android_prompt	I
    //   228: invokevirtual 155	android/support/v7/widget/bb:d	(I)Ljava/lang/String;
    //   231: invokevirtual 158	android/support/v7/widget/y$b:a	(Ljava/lang/CharSequence;)V
    //   234: aload 6
    //   236: invokevirtual 160	android/support/v7/widget/bb:a	()V
    //   239: aload_0
    //   240: aload 5
    //   242: putfield 162	android/support/v7/widget/y:j	Landroid/support/v7/widget/y$b;
    //   245: aload_0
    //   246: new 8	android/support/v7/widget/y$1
    //   249: dup
    //   250: aload_0
    //   251: aload_0
    //   252: aload 5
    //   254: invokespecial 165	android/support/v7/widget/y$1:<init>	(Landroid/support/v7/widget/y;Landroid/view/View;Landroid/support/v7/widget/y$b;)V
    //   257: putfield 167	android/support/v7/widget/y:g	Landroid/support/v7/widget/ak$b;
    //   260: aload 8
    //   262: getstatic 170	android/support/v7/b/a$k:Spinner_android_entries	I
    //   265: invokevirtual 173	android/support/v7/widget/bb:e	(I)[Ljava/lang/CharSequence;
    //   268: astore 5
    //   270: aload 5
    //   272: ifnull +28 -> 300
    //   275: new 175	android/widget/ArrayAdapter
    //   278: dup
    //   279: aload_1
    //   280: ldc -80
    //   282: aload 5
    //   284: invokespecial 179	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   287: astore_1
    //   288: aload_1
    //   289: getstatic 184	android/support/v7/b/a$h:support_simple_spinner_dropdown_item	I
    //   292: invokevirtual 188	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   295: aload_0
    //   296: aload_1
    //   297: invokevirtual 192	android/support/v7/widget/y:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   300: aload 8
    //   302: invokevirtual 160	android/support/v7/widget/bb:a	()V
    //   305: aload_0
    //   306: iconst_1
    //   307: putfield 194	android/support/v7/widget/y:i	Z
    //   310: aload_0
    //   311: getfield 196	android/support/v7/widget/y:h	Landroid/widget/SpinnerAdapter;
    //   314: ifnull +16 -> 330
    //   317: aload_0
    //   318: aload_0
    //   319: getfield 196	android/support/v7/widget/y:h	Landroid/widget/SpinnerAdapter;
    //   322: invokevirtual 192	android/support/v7/widget/y:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   325: aload_0
    //   326: aconst_null
    //   327: putfield 196	android/support/v7/widget/y:h	Landroid/widget/SpinnerAdapter;
    //   330: aload_0
    //   331: getfield 104	android/support/v7/widget/y:e	Landroid/support/v7/widget/h;
    //   334: aload_2
    //   335: iload_3
    //   336: invokevirtual 199	android/support/v7/widget/h:a	(Landroid/util/AttributeSet;I)V
    //   339: return
    //   340: aload 8
    //   342: getstatic 202	android/support/v7/b/a$k:Spinner_popupTheme	I
    //   345: iconst_0
    //   346: invokevirtual 204	android/support/v7/widget/bb:g	(II)I
    //   349: istore 9
    //   351: iload 9
    //   353: ifeq +20 -> 373
    //   356: aload_0
    //   357: new 106	android/support/v7/view/d
    //   360: dup
    //   361: aload_1
    //   362: iload 9
    //   364: invokespecial 207	android/support/v7/view/d:<init>	(Landroid/content/Context;I)V
    //   367: putfield 111	android/support/v7/widget/y:f	Landroid/content/Context;
    //   370: goto -298 -> 72
    //   373: getstatic 49	android/support/v7/widget/y:a	Z
    //   376: ifne +15 -> 391
    //   379: aload_1
    //   380: astore 5
    //   382: aload_0
    //   383: aload 5
    //   385: putfield 111	android/support/v7/widget/y:f	Landroid/content/Context;
    //   388: goto -316 -> 72
    //   391: aconst_null
    //   392: astore 5
    //   394: goto -12 -> 382
    //   397: astore 7
    //   399: aconst_null
    //   400: astore 6
    //   402: aload 6
    //   404: astore 5
    //   406: ldc -47
    //   408: ldc -45
    //   410: aload 7
    //   412: invokestatic 216	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   415: pop
    //   416: iload 4
    //   418: istore 10
    //   420: aload 6
    //   422: ifnull -265 -> 157
    //   425: aload 6
    //   427: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   430: iload 4
    //   432: istore 10
    //   434: goto -277 -> 157
    //   437: astore_1
    //   438: aconst_null
    //   439: astore 5
    //   441: aload 5
    //   443: ifnull +8 -> 451
    //   446: aload 5
    //   448: invokevirtual 130	android/content/res/TypedArray:recycle	()V
    //   451: aload_1
    //   452: athrow
    //   453: iconst_1
    //   454: istore 10
    //   456: goto -299 -> 157
    //   459: astore_1
    //   460: goto -19 -> 441
    //   463: astore 7
    //   465: goto -63 -> 402
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	y
    //   0	468	1	paramContext	Context
    //   0	468	2	paramAttributeSet	AttributeSet
    //   0	468	3	paramInt1	int
    //   0	468	4	paramInt2	int
    //   0	468	5	paramTheme	Resources.Theme
    //   107	319	6	localObject	Object
    //   397	14	7	localException1	Exception
    //   463	1	7	localException2	Exception
    //   28	313	8	localbb	bb
    //   111	252	9	m	int
    //   81	374	10	n	int
    // Exception table:
    //   from	to	target	type
    //   97	109	397	java/lang/Exception
    //   97	109	437	finally
    //   117	126	459	finally
    //   130	139	459	finally
    //   406	416	459	finally
    //   117	126	463	java/lang/Exception
    //   130	139	463	java/lang/Exception
  }
  
  private int a(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int i3 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int i4 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int m = Math.max(0, getSelectedItemPosition());
    int i5 = Math.min(paramSpinnerAdapter.getCount(), m + 15);
    int n = Math.max(0, m - (15 - (i5 - m)));
    View localView = null;
    int i1 = 0;
    m = 0;
    if (n < i5)
    {
      int i2 = paramSpinnerAdapter.getItemViewType(n);
      if (i2 == m) {
        break label203;
      }
      localView = null;
      m = i2;
    }
    label203:
    for (;;)
    {
      localView = paramSpinnerAdapter.getView(n, localView, this);
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(i3, i4);
      i1 = Math.max(i1, localView.getMeasuredWidth());
      n += 1;
      break;
      if (paramDrawable != null)
      {
        paramDrawable.getPadding(this.l);
        return this.l.left + this.l.right + i1;
      }
      return i1;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.e != null) {
      this.e.c();
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    if (this.j != null) {
      return this.j.f();
    }
    if (b) {
      return super.getDropDownHorizontalOffset();
    }
    return 0;
  }
  
  public int getDropDownVerticalOffset()
  {
    if (this.j != null) {
      return this.j.g();
    }
    if (b) {
      return super.getDropDownVerticalOffset();
    }
    return 0;
  }
  
  public int getDropDownWidth()
  {
    if (this.j != null) {
      return this.k;
    }
    if (b) {
      return super.getDropDownWidth();
    }
    return 0;
  }
  
  public Drawable getPopupBackground()
  {
    if (this.j != null) {
      return this.j.d();
    }
    if (b) {
      return super.getPopupBackground();
    }
    return null;
  }
  
  public Context getPopupContext()
  {
    if (this.j != null) {
      return this.f;
    }
    if (a) {
      return super.getPopupContext();
    }
    return null;
  }
  
  public CharSequence getPrompt()
  {
    if (this.j != null) {
      return this.j.a();
    }
    return super.getPrompt();
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (this.e != null) {
      return this.e.a();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.e != null) {
      return this.e.b();
    }
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.j != null) && (this.j.k())) {
      this.j.i();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.j != null) && (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.g != null) && (this.g.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    if (this.j != null)
    {
      if (!this.j.k()) {
        this.j.c();
      }
      return true;
    }
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!this.i) {
      this.h = paramSpinnerAdapter;
    }
    do
    {
      return;
      super.setAdapter(paramSpinnerAdapter);
    } while (this.j == null);
    if (this.f == null) {}
    for (Context localContext = getContext();; localContext = this.f)
    {
      this.j.a(new a(paramSpinnerAdapter, localContext.getTheme()));
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.e != null) {
      this.e.a(paramDrawable);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.e != null) {
      this.e.a(paramInt);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    if (this.j != null) {
      this.j.b(paramInt);
    }
    while (!b) {
      return;
    }
    super.setDropDownHorizontalOffset(paramInt);
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    if (this.j != null) {
      this.j.c(paramInt);
    }
    while (!b) {
      return;
    }
    super.setDropDownVerticalOffset(paramInt);
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (this.j != null) {
      this.k = paramInt;
    }
    while (!b) {
      return;
    }
    super.setDropDownWidth(paramInt);
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    if (this.j != null) {
      this.j.a(paramDrawable);
    }
    while (!b) {
      return;
    }
    super.setPopupBackgroundDrawable(paramDrawable);
  }
  
  public void setPopupBackgroundResource(int paramInt)
  {
    setPopupBackgroundDrawable(a.a(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    if (this.j != null)
    {
      this.j.a(paramCharSequence);
      return;
    }
    super.setPrompt(paramCharSequence);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.e != null) {
      this.e.a(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.e != null) {
      this.e.a(paramMode);
    }
  }
  
  private static class a
    implements ListAdapter, SpinnerAdapter
  {
    private SpinnerAdapter a;
    private ListAdapter b;
    
    public a(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
    {
      this.a = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof ListAdapter)) {
        this.b = ((ListAdapter)paramSpinnerAdapter);
      }
      if (paramTheme != null)
      {
        if ((!y.a()) || (!(paramSpinnerAdapter instanceof ThemedSpinnerAdapter))) {
          break label64;
        }
        paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
        if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
          paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
        }
      }
      label64:
      do
      {
        do
        {
          return;
        } while (!(paramSpinnerAdapter instanceof ax));
        paramSpinnerAdapter = (ax)paramSpinnerAdapter;
      } while (paramSpinnerAdapter.a() != null);
      paramSpinnerAdapter.a(paramTheme);
    }
    
    public boolean areAllItemsEnabled()
    {
      ListAdapter localListAdapter = this.b;
      if (localListAdapter != null) {
        return localListAdapter.areAllItemsEnabled();
      }
      return true;
    }
    
    public int getCount()
    {
      if (this.a == null) {
        return 0;
      }
      return this.a.getCount();
    }
    
    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (this.a == null) {
        return null;
      }
      return this.a.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public Object getItem(int paramInt)
    {
      if (this.a == null) {
        return null;
      }
      return this.a.getItem(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      if (this.a == null) {
        return -1L;
      }
      return this.a.getItemId(paramInt);
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public int getViewTypeCount()
    {
      return 1;
    }
    
    public boolean hasStableIds()
    {
      return (this.a != null) && (this.a.hasStableIds());
    }
    
    public boolean isEmpty()
    {
      return getCount() == 0;
    }
    
    public boolean isEnabled(int paramInt)
    {
      ListAdapter localListAdapter = this.b;
      if (localListAdapter != null) {
        return localListAdapter.isEnabled(paramInt);
      }
      return true;
    }
    
    public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.a != null) {
        this.a.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.a != null) {
        this.a.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
  
  private class b
    extends ak
  {
    private CharSequence c;
    private ListAdapter d;
    private final Rect e = new Rect();
    
    public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      a(y.this);
      a(true);
      a(0);
      a(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          y.this.setSelection(paramAnonymousInt);
          if (y.this.getOnItemClickListener() != null) {
            y.this.performItemClick(paramAnonymousView, paramAnonymousInt, y.b.a(y.b.this).getItemId(paramAnonymousInt));
          }
          y.b.this.i();
        }
      });
    }
    
    private boolean b(View paramView)
    {
      return (af.C(paramView)) && (paramView.getGlobalVisibleRect(this.e));
    }
    
    public CharSequence a()
    {
      return this.c;
    }
    
    public void a(ListAdapter paramListAdapter)
    {
      super.a(paramListAdapter);
      this.d = paramListAdapter;
    }
    
    public void a(CharSequence paramCharSequence)
    {
      this.c = paramCharSequence;
    }
    
    void b()
    {
      Object localObject = d();
      int i;
      int m;
      int n;
      int i1;
      int j;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(y.b(y.this));
        if (bf.a(y.this))
        {
          i = y.b(y.this).right;
          m = y.this.getPaddingLeft();
          n = y.this.getPaddingRight();
          i1 = y.this.getWidth();
          if (y.c(y.this) != -2) {
            break label238;
          }
          j = y.a(y.this, (SpinnerAdapter)this.d, d());
          int k = y.this.getContext().getResources().getDisplayMetrics().widthPixels - y.b(y.this).left - y.b(y.this).right;
          if (j <= k) {
            break label286;
          }
          j = k;
        }
      }
      label165:
      label238:
      label286:
      for (;;)
      {
        f(Math.max(j, i1 - m - n));
        if (bf.a(y.this)) {
          i = i1 - n - h() + i;
        }
        for (;;)
        {
          b(i);
          return;
          i = -y.b(y.this).left;
          break;
          localObject = y.b(y.this);
          y.b(y.this).right = 0;
          ((Rect)localObject).left = 0;
          i = 0;
          break;
          if (y.c(y.this) == -1)
          {
            f(i1 - m - n);
            break label165;
          }
          f(y.c(y.this));
          break label165;
          i += m;
        }
      }
    }
    
    public void c()
    {
      boolean bool = k();
      b();
      g(2);
      super.c();
      m().setChoiceMode(1);
      h(y.this.getSelectedItemPosition());
      if (bool) {}
      ViewTreeObserver localViewTreeObserver;
      do
      {
        return;
        localViewTreeObserver = y.this.getViewTreeObserver();
      } while (localViewTreeObserver == null);
      final ViewTreeObserver.OnGlobalLayoutListener local2 = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public void onGlobalLayout()
        {
          if (!y.b.a(y.b.this, y.this))
          {
            y.b.this.i();
            return;
          }
          y.b.this.b();
          y.b.b(y.b.this);
        }
      };
      localViewTreeObserver.addOnGlobalLayoutListener(local2);
      a(new PopupWindow.OnDismissListener()
      {
        public void onDismiss()
        {
          ViewTreeObserver localViewTreeObserver = y.this.getViewTreeObserver();
          if (localViewTreeObserver != null) {
            localViewTreeObserver.removeGlobalOnLayoutListener(local2);
          }
        }
      });
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */