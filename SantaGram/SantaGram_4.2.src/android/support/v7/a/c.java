package android.support.v7.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.j.af;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.b;
import android.support.v7.b.a.a;
import android.support.v7.b.a.f;
import android.support.v7.b.a.k;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class c
{
  private TextView A;
  private TextView B;
  private View C;
  private ListAdapter D;
  private int E = -1;
  private int F;
  private int G;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L = 0;
  private Handler M;
  private final View.OnClickListener N = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if ((paramAnonymousView == c.a(c.this)) && (c.b(c.this) != null)) {
        paramAnonymousView = Message.obtain(c.b(c.this));
      }
      for (;;)
      {
        if (paramAnonymousView != null) {
          paramAnonymousView.sendToTarget();
        }
        c.h(c.this).obtainMessage(1, c.g(c.this)).sendToTarget();
        return;
        if ((paramAnonymousView == c.c(c.this)) && (c.d(c.this) != null)) {
          paramAnonymousView = Message.obtain(c.d(c.this));
        } else if ((paramAnonymousView == c.e(c.this)) && (c.f(c.this) != null)) {
          paramAnonymousView = Message.obtain(c.f(c.this));
        } else {
          paramAnonymousView = null;
        }
      }
    }
  };
  private final Context a;
  private final m b;
  private final Window c;
  private CharSequence d;
  private CharSequence e;
  private ListView f;
  private View g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private boolean m = false;
  private Button n;
  private CharSequence o;
  private Message p;
  private Button q;
  private CharSequence r;
  private Message s;
  private Button t;
  private CharSequence u;
  private Message v;
  private NestedScrollView w;
  private int x = 0;
  private Drawable y;
  private ImageView z;
  
  public c(Context paramContext, m paramm, Window paramWindow)
  {
    this.a = paramContext;
    this.b = paramm;
    this.c = paramWindow;
    this.M = new b(paramm);
    paramContext = paramContext.obtainStyledAttributes(null, a.k.AlertDialog, a.a.alertDialogStyle, 0);
    this.F = paramContext.getResourceId(a.k.AlertDialog_android_layout, 0);
    this.G = paramContext.getResourceId(a.k.AlertDialog_buttonPanelSideLayout, 0);
    this.H = paramContext.getResourceId(a.k.AlertDialog_listLayout, 0);
    this.I = paramContext.getResourceId(a.k.AlertDialog_multiChoiceItemLayout, 0);
    this.J = paramContext.getResourceId(a.k.AlertDialog_singleChoiceItemLayout, 0);
    this.K = paramContext.getResourceId(a.k.AlertDialog_listItemLayout, 0);
    paramContext.recycle();
    paramm.b(1);
  }
  
  private ViewGroup a(View paramView1, View paramView2)
  {
    if (paramView1 == null) {
      if (!(paramView2 instanceof ViewStub)) {
        break label71;
      }
    }
    label71:
    for (paramView1 = ((ViewStub)paramView2).inflate();; paramView1 = paramView2)
    {
      return (ViewGroup)paramView1;
      if (paramView2 != null)
      {
        ViewParent localViewParent = paramView2.getParent();
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView(paramView2);
        }
      }
      if ((paramView1 instanceof ViewStub)) {
        paramView1 = ((ViewStub)paramView1).inflate();
      }
      for (;;)
      {
        return (ViewGroup)paramView1;
      }
    }
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    int i1 = 0;
    View localView;
    if (this.g != null) {
      localView = this.g;
    }
    for (;;)
    {
      if (localView != null) {
        i1 = 1;
      }
      if ((i1 == 0) || (!a(localView))) {
        this.c.setFlags(131072, 131072);
      }
      if (i1 == 0) {
        break;
      }
      FrameLayout localFrameLayout = (FrameLayout)this.c.findViewById(a.f.custom);
      localFrameLayout.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      if (this.m) {
        localFrameLayout.setPadding(this.i, this.j, this.k, this.l);
      }
      if (this.f != null) {
        ((LinearLayout.LayoutParams)paramViewGroup.getLayoutParams()).weight = 0.0F;
      }
      return;
      if (this.h != 0) {
        localView = LayoutInflater.from(this.a).inflate(this.h, paramViewGroup, false);
      } else {
        localView = null;
      }
    }
    paramViewGroup.setVisibility(8);
  }
  
  private void a(ViewGroup paramViewGroup, final View paramView, int paramInt1, int paramInt2)
  {
    final Object localObject = null;
    View localView2 = this.c.findViewById(a.f.scrollIndicatorUp);
    View localView1 = this.c.findViewById(a.f.scrollIndicatorDown);
    if (Build.VERSION.SDK_INT >= 23)
    {
      af.a(paramView, paramInt1, paramInt2);
      if (localView2 != null) {
        paramViewGroup.removeView(localView2);
      }
      if (localView1 != null) {
        paramViewGroup.removeView(localView1);
      }
    }
    label232:
    for (;;)
    {
      return;
      paramView = localView2;
      if (localView2 != null)
      {
        paramView = localView2;
        if ((paramInt1 & 0x1) == 0)
        {
          paramViewGroup.removeView(localView2);
          paramView = null;
        }
      }
      if ((localView1 != null) && ((paramInt1 & 0x2) == 0)) {
        paramViewGroup.removeView(localView1);
      }
      for (;;)
      {
        if ((paramView == null) && (localObject == null)) {
          break label232;
        }
        if (this.e != null)
        {
          this.w.setOnScrollChangeListener(new NestedScrollView.b()
          {
            public void a(NestedScrollView paramAnonymousNestedScrollView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
            {
              c.a(paramAnonymousNestedScrollView, paramView, localObject);
            }
          });
          this.w.post(new Runnable()
          {
            public void run()
            {
              c.a(c.i(c.this), paramView, localObject);
            }
          });
          return;
        }
        if (this.f != null)
        {
          this.f.setOnScrollListener(new AbsListView.OnScrollListener()
          {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              c.a(paramAnonymousAbsListView, paramView, localObject);
            }
            
            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
          });
          this.f.post(new Runnable()
          {
            public void run()
            {
              c.a(c.j(c.this), paramView, localObject);
            }
          });
          return;
        }
        if (paramView != null) {
          paramViewGroup.removeView(paramView);
        }
        if (localObject == null) {
          break;
        }
        paramViewGroup.removeView((View)localObject);
        return;
        localObject = localView1;
      }
    }
  }
  
  static boolean a(View paramView)
  {
    if (paramView.onCheckIsTextEditor()) {
      return true;
    }
    if (!(paramView instanceof ViewGroup)) {
      return false;
    }
    paramView = (ViewGroup)paramView;
    int i1 = paramView.getChildCount();
    while (i1 > 0)
    {
      int i2 = i1 - 1;
      i1 = i2;
      if (a(paramView.getChildAt(i2))) {
        return true;
      }
    }
    return false;
  }
  
  private int b()
  {
    if (this.G == 0) {
      return this.F;
    }
    if (this.L == 1) {
      return this.G;
    }
    return this.F;
  }
  
  private static void b(View paramView1, View paramView2, View paramView3)
  {
    int i2 = 0;
    if (paramView2 != null)
    {
      if (af.b(paramView1, -1))
      {
        i1 = 0;
        paramView2.setVisibility(i1);
      }
    }
    else if (paramView3 != null) {
      if (!af.b(paramView1, 1)) {
        break label48;
      }
    }
    label48:
    for (int i1 = i2;; i1 = 4)
    {
      paramView3.setVisibility(i1);
      return;
      i1 = 4;
      break;
    }
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    if (this.C != null)
    {
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
      paramViewGroup.addView(this.C, 0, localLayoutParams);
      this.c.findViewById(a.f.title_template).setVisibility(8);
      return;
    }
    this.z = ((ImageView)this.c.findViewById(16908294));
    int i1;
    if (!TextUtils.isEmpty(this.d)) {
      i1 = 1;
    }
    while (i1 != 0)
    {
      this.A = ((TextView)this.c.findViewById(a.f.alertTitle));
      this.A.setText(this.d);
      if (this.x != 0)
      {
        this.z.setImageResource(this.x);
        return;
        i1 = 0;
      }
      else
      {
        if (this.y != null)
        {
          this.z.setImageDrawable(this.y);
          return;
        }
        this.A.setPadding(this.z.getPaddingLeft(), this.z.getPaddingTop(), this.z.getPaddingRight(), this.z.getPaddingBottom());
        this.z.setVisibility(8);
        return;
      }
    }
    this.c.findViewById(a.f.title_template).setVisibility(8);
    this.z.setVisibility(8);
    paramViewGroup.setVisibility(8);
  }
  
  private void c()
  {
    Object localObject2 = this.c.findViewById(a.f.parentPanel);
    Object localObject4 = ((View)localObject2).findViewById(a.f.topPanel);
    Object localObject3 = ((View)localObject2).findViewById(a.f.contentPanel);
    Object localObject1 = ((View)localObject2).findViewById(a.f.buttonPanel);
    localObject2 = (ViewGroup)((View)localObject2).findViewById(a.f.customPanel);
    a((ViewGroup)localObject2);
    View localView3 = ((ViewGroup)localObject2).findViewById(a.f.topPanel);
    View localView2 = ((ViewGroup)localObject2).findViewById(a.f.contentPanel);
    View localView1 = ((ViewGroup)localObject2).findViewById(a.f.buttonPanel);
    localObject4 = a(localView3, (View)localObject4);
    localObject3 = a(localView2, (View)localObject3);
    localObject1 = a(localView1, (View)localObject1);
    c((ViewGroup)localObject3);
    d((ViewGroup)localObject1);
    b((ViewGroup)localObject4);
    int i1;
    int i3;
    if ((localObject2 != null) && (((ViewGroup)localObject2).getVisibility() != 8))
    {
      i1 = 1;
      if ((localObject4 == null) || (((ViewGroup)localObject4).getVisibility() == 8)) {
        break label322;
      }
      i3 = 1;
      label155:
      if ((localObject1 == null) || (((ViewGroup)localObject1).getVisibility() == 8)) {
        break label328;
      }
      i2 = 1;
      label171:
      if ((i2 == 0) && (localObject3 != null))
      {
        localObject1 = ((ViewGroup)localObject3).findViewById(a.f.textSpacerNoButtons);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
      }
      if ((i3 != 0) && (this.w != null)) {
        this.w.setClipToPadding(true);
      }
      if (i1 == 0)
      {
        if (this.f == null) {
          break label334;
        }
        localObject1 = this.f;
        label234:
        if (localObject1 != null)
        {
          if (i3 == 0) {
            break label342;
          }
          i1 = 1;
          label246:
          if (i2 == 0) {
            break label348;
          }
        }
      }
    }
    label322:
    label328:
    label334:
    label342:
    label348:
    for (int i2 = 2;; i2 = 0)
    {
      a((ViewGroup)localObject3, (View)localObject1, i2 | i1, 3);
      localObject1 = this.f;
      if ((localObject1 != null) && (this.D != null))
      {
        ((ListView)localObject1).setAdapter(this.D);
        i1 = this.E;
        if (i1 > -1)
        {
          ((ListView)localObject1).setItemChecked(i1, true);
          ((ListView)localObject1).setSelection(i1);
        }
      }
      return;
      i1 = 0;
      break;
      i3 = 0;
      break label155;
      i2 = 0;
      break label171;
      localObject1 = this.w;
      break label234;
      i1 = 0;
      break label246;
    }
  }
  
  private void c(ViewGroup paramViewGroup)
  {
    this.w = ((NestedScrollView)this.c.findViewById(a.f.scrollView));
    this.w.setFocusable(false);
    this.w.setNestedScrollingEnabled(false);
    this.B = ((TextView)paramViewGroup.findViewById(16908299));
    if (this.B == null) {
      return;
    }
    if (this.e != null)
    {
      this.B.setText(this.e);
      return;
    }
    this.B.setVisibility(8);
    this.w.removeView(this.B);
    if (this.f != null)
    {
      paramViewGroup = (ViewGroup)this.w.getParent();
      int i1 = paramViewGroup.indexOfChild(this.w);
      paramViewGroup.removeViewAt(i1);
      paramViewGroup.addView(this.f, i1, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
    paramViewGroup.setVisibility(8);
  }
  
  private void d(ViewGroup paramViewGroup)
  {
    int i2 = 1;
    this.n = ((Button)paramViewGroup.findViewById(16908313));
    this.n.setOnClickListener(this.N);
    if (TextUtils.isEmpty(this.o))
    {
      this.n.setVisibility(8);
      i1 = 0;
      this.q = ((Button)paramViewGroup.findViewById(16908314));
      this.q.setOnClickListener(this.N);
      if (!TextUtils.isEmpty(this.r)) {
        break label177;
      }
      this.q.setVisibility(8);
      label92:
      this.t = ((Button)paramViewGroup.findViewById(16908315));
      this.t.setOnClickListener(this.N);
      if (!TextUtils.isEmpty(this.u)) {
        break label203;
      }
      this.t.setVisibility(8);
      label136:
      if (i1 == 0) {
        break label229;
      }
    }
    label177:
    label203:
    label229:
    for (int i1 = i2;; i1 = 0)
    {
      if (i1 == 0) {
        paramViewGroup.setVisibility(8);
      }
      return;
      this.n.setText(this.o);
      this.n.setVisibility(0);
      i1 = 1;
      break;
      this.q.setText(this.r);
      this.q.setVisibility(0);
      i1 |= 0x2;
      break label92;
      this.t.setText(this.u);
      this.t.setVisibility(0);
      i1 |= 0x4;
      break label136;
    }
  }
  
  public void a()
  {
    int i1 = b();
    this.b.setContentView(i1);
    c();
  }
  
  public void a(int paramInt)
  {
    this.g = null;
    this.h = paramInt;
    this.m = false;
  }
  
  public void a(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage)
  {
    Message localMessage = paramMessage;
    if (paramMessage == null)
    {
      localMessage = paramMessage;
      if (paramOnClickListener != null) {
        localMessage = this.M.obtainMessage(paramInt, paramOnClickListener);
      }
    }
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Button does not exist");
    case -1: 
      this.o = paramCharSequence;
      this.p = localMessage;
      return;
    case -2: 
      this.r = paramCharSequence;
      this.s = localMessage;
      return;
    }
    this.u = paramCharSequence;
    this.v = localMessage;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.y = paramDrawable;
    this.x = 0;
    if (this.z != null)
    {
      if (paramDrawable != null)
      {
        this.z.setVisibility(0);
        this.z.setImageDrawable(paramDrawable);
      }
    }
    else {
      return;
    }
    this.z.setVisibility(8);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.g = paramView;
    this.h = 0;
    this.m = true;
    this.i = paramInt1;
    this.j = paramInt2;
    this.k = paramInt3;
    this.l = paramInt4;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
    if (this.A != null) {
      this.A.setText(paramCharSequence);
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.w != null) && (this.w.a(paramKeyEvent));
  }
  
  public void b(int paramInt)
  {
    this.y = null;
    this.x = paramInt;
    if (this.z != null)
    {
      if (paramInt != 0)
      {
        this.z.setVisibility(0);
        this.z.setImageResource(this.x);
      }
    }
    else {
      return;
    }
    this.z.setVisibility(8);
  }
  
  public void b(View paramView)
  {
    this.C = paramView;
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    if (this.B != null) {
      this.B.setText(paramCharSequence);
    }
  }
  
  public boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.w != null) && (this.w.a(paramKeyEvent));
  }
  
  public int c(int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    this.a.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  public void c(View paramView)
  {
    this.g = paramView;
    this.h = 0;
    this.m = false;
  }
  
  public static class a
  {
    public int A;
    public boolean B = false;
    public boolean[] C;
    public boolean D;
    public boolean E;
    public int F = -1;
    public DialogInterface.OnMultiChoiceClickListener G;
    public Cursor H;
    public String I;
    public String J;
    public AdapterView.OnItemSelectedListener K;
    public a L;
    public boolean M = true;
    public final Context a;
    public final LayoutInflater b;
    public int c = 0;
    public Drawable d;
    public int e = 0;
    public CharSequence f;
    public View g;
    public CharSequence h;
    public CharSequence i;
    public DialogInterface.OnClickListener j;
    public CharSequence k;
    public DialogInterface.OnClickListener l;
    public CharSequence m;
    public DialogInterface.OnClickListener n;
    public boolean o;
    public DialogInterface.OnCancelListener p;
    public DialogInterface.OnDismissListener q;
    public DialogInterface.OnKeyListener r;
    public CharSequence[] s;
    public ListAdapter t;
    public DialogInterface.OnClickListener u;
    public int v;
    public View w;
    public int x;
    public int y;
    public int z;
    
    public a(Context paramContext)
    {
      this.a = paramContext;
      this.o = true;
      this.b = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    }
    
    private void b(final c paramc)
    {
      final ListView localListView = (ListView)this.b.inflate(c.k(paramc), null);
      Object localObject;
      if (this.D) {
        if (this.H == null)
        {
          localObject = new ArrayAdapter(this.a, c.l(paramc), 16908308, this.s)
          {
            public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
            {
              paramAnonymousView = super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
              if ((c.a.this.C != null) && (c.a.this.C[paramAnonymousInt] != 0)) {
                localListView.setItemChecked(paramAnonymousInt, true);
              }
              return paramAnonymousView;
            }
          };
          if (this.L != null) {
            this.L.a(localListView);
          }
          c.a(paramc, (ListAdapter)localObject);
          c.a(paramc, this.F);
          if (this.u == null) {
            break label270;
          }
          localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              c.a.this.u.onClick(c.g(paramc), paramAnonymousInt);
              if (!c.a.this.E) {
                c.g(paramc).dismiss();
              }
            }
          });
          label106:
          if (this.K != null) {
            localListView.setOnItemSelectedListener(this.K);
          }
          if (!this.E) {
            break label294;
          }
          localListView.setChoiceMode(1);
        }
      }
      for (;;)
      {
        c.a(paramc, localListView);
        return;
        localObject = new CursorAdapter(this.a, this.H, false)
        {
          private final int d;
          private final int e;
          
          public void bindView(View paramAnonymousView, Context paramAnonymousContext, Cursor paramAnonymousCursor)
          {
            ((CheckedTextView)paramAnonymousView.findViewById(16908308)).setText(paramAnonymousCursor.getString(this.d));
            paramAnonymousView = localListView;
            int i = paramAnonymousCursor.getPosition();
            if (paramAnonymousCursor.getInt(this.e) == 1) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousView.setItemChecked(i, bool);
              return;
            }
          }
          
          public View newView(Context paramAnonymousContext, Cursor paramAnonymousCursor, ViewGroup paramAnonymousViewGroup)
          {
            return c.a.this.b.inflate(c.l(paramc), paramAnonymousViewGroup, false);
          }
        };
        break;
        if (this.E) {}
        for (int i1 = c.m(paramc);; i1 = c.n(paramc))
        {
          if (this.H == null) {
            break label232;
          }
          localObject = new SimpleCursorAdapter(this.a, i1, this.H, new String[] { this.I }, new int[] { 16908308 });
          break;
        }
        label232:
        if (this.t != null)
        {
          localObject = this.t;
          break;
        }
        localObject = new c.c(this.a, i1, 16908308, this.s);
        break;
        label270:
        if (this.G == null) {
          break label106;
        }
        localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            if (c.a.this.C != null) {
              c.a.this.C[paramAnonymousInt] = localListView.isItemChecked(paramAnonymousInt);
            }
            c.a.this.G.onClick(c.g(paramc), paramAnonymousInt, localListView.isItemChecked(paramAnonymousInt));
          }
        });
        break label106;
        label294:
        if (this.D) {
          localListView.setChoiceMode(2);
        }
      }
    }
    
    public void a(c paramc)
    {
      if (this.g != null)
      {
        paramc.b(this.g);
        if (this.h != null) {
          paramc.b(this.h);
        }
        if (this.i != null) {
          paramc.a(-1, this.i, this.j, null);
        }
        if (this.k != null) {
          paramc.a(-2, this.k, this.l, null);
        }
        if (this.m != null) {
          paramc.a(-3, this.m, this.n, null);
        }
        if ((this.s != null) || (this.H != null) || (this.t != null)) {
          b(paramc);
        }
        if (this.w == null) {
          break label236;
        }
        if (!this.B) {
          break label227;
        }
        paramc.a(this.w, this.x, this.y, this.z, this.A);
      }
      label227:
      label236:
      while (this.v == 0)
      {
        return;
        if (this.f != null) {
          paramc.a(this.f);
        }
        if (this.d != null) {
          paramc.a(this.d);
        }
        if (this.c != 0) {
          paramc.b(this.c);
        }
        if (this.e == 0) {
          break;
        }
        paramc.b(paramc.c(this.e));
        break;
        paramc.c(this.w);
        return;
      }
      paramc.a(this.v);
    }
    
    public static abstract interface a
    {
      public abstract void a(ListView paramListView);
    }
  }
  
  private static final class b
    extends Handler
  {
    private WeakReference<DialogInterface> a;
    
    public b(DialogInterface paramDialogInterface)
    {
      this.a = new WeakReference(paramDialogInterface);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 0: 
      default: 
        return;
      case -3: 
      case -2: 
      case -1: 
        ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.a.get(), paramMessage.what);
        return;
      }
      ((DialogInterface)paramMessage.obj).dismiss();
    }
  }
  
  private static class c
    extends ArrayAdapter<CharSequence>
  {
    public c(Context paramContext, int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence)
    {
      super(paramInt1, paramInt2, paramArrayOfCharSequence);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public boolean hasStableIds()
    {
      return true;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */