package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.b.a.a;
import android.support.v7.b.a.d;
import android.support.v7.b.a.h;
import android.support.v7.widget.ak;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class k
  implements l, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  static final int a = a.h.abc_popup_menu_item_layout;
  boolean b;
  private final Context c;
  private final LayoutInflater d;
  private final f e;
  private final a f;
  private final boolean g;
  private final int h;
  private final int i;
  private final int j;
  private View k;
  private ak l;
  private ViewTreeObserver m;
  private l.a n;
  private ViewGroup o;
  private boolean p;
  private int q;
  private int r = 0;
  
  public k(Context paramContext, f paramf, View paramView)
  {
    this(paramContext, paramf, paramView, false, a.a.popupMenuStyle);
  }
  
  public k(Context paramContext, f paramf, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramf, paramView, paramBoolean, paramInt, 0);
  }
  
  public k(Context paramContext, f paramf, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.c = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.e = paramf;
    this.f = new a(this.e);
    this.g = paramBoolean;
    this.i = paramInt1;
    this.j = paramInt2;
    Resources localResources = paramContext.getResources();
    this.h = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
    this.k = paramView;
    paramf.a(this, paramContext);
  }
  
  private int g()
  {
    a locala = this.f;
    int i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i6 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i7 = locala.getCount();
    int i2 = 0;
    int i3 = 0;
    View localView = null;
    int i1 = 0;
    int i4 = i1;
    if (i2 < i7)
    {
      i4 = locala.getItemViewType(i2);
      if (i4 == i3) {
        break label156;
      }
      i3 = i4;
      localView = null;
      label70:
      if (this.o == null) {
        this.o = new FrameLayout(this.c);
      }
      localView = locala.getView(i2, localView, this.o);
      localView.measure(i5, i6);
      i4 = localView.getMeasuredWidth();
      if (i4 >= this.h) {
        i4 = this.h;
      }
    }
    else
    {
      return i4;
    }
    if (i4 > i1) {
      i1 = i4;
    }
    for (;;)
    {
      i2 += 1;
      break;
      label156:
      break label70;
    }
  }
  
  public void a()
  {
    if (!d()) {
      throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }
  }
  
  public void a(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void a(Context paramContext, f paramf) {}
  
  public void a(f paramf, boolean paramBoolean)
  {
    if (paramf != this.e) {}
    do
    {
      return;
      e();
    } while (this.n == null);
    this.n.a(paramf, paramBoolean);
  }
  
  public void a(l.a parama)
  {
    this.n = parama;
  }
  
  public void a(View paramView)
  {
    this.k = paramView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a(f paramf, h paramh)
  {
    return false;
  }
  
  public boolean a(p paramp)
  {
    k localk;
    int i1;
    if (paramp.hasVisibleItems())
    {
      localk = new k(this.c, paramp, this.k);
      localk.a(this.n);
      int i2 = paramp.size();
      i1 = 0;
      if (i1 >= i2) {
        break label120;
      }
      MenuItem localMenuItem = paramp.getItem(i1);
      if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null)) {}
    }
    label120:
    for (boolean bool = true;; bool = false)
    {
      localk.a(bool);
      if (localk.d())
      {
        if (this.n != null) {
          this.n.a(paramp);
        }
        return true;
        i1 += 1;
        break;
      }
      return false;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.p = false;
    if (this.f != null) {
      this.f.notifyDataSetChanged();
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(f paramf, h paramh)
  {
    return false;
  }
  
  public ak c()
  {
    return this.l;
  }
  
  public boolean d()
  {
    int i1 = 0;
    this.l = new ak(this.c, null, this.i, this.j);
    this.l.a(this);
    this.l.a(this);
    this.l.a(this.f);
    this.l.a(true);
    View localView = this.k;
    if (localView != null)
    {
      if (this.m == null) {
        i1 = 1;
      }
      this.m = localView.getViewTreeObserver();
      if (i1 != 0) {
        this.m.addOnGlobalLayoutListener(this);
      }
      this.l.a(localView);
      this.l.d(this.r);
      if (!this.p)
      {
        this.q = g();
        this.p = true;
      }
      this.l.f(this.q);
      this.l.g(2);
      this.l.c();
      this.l.m().setOnKeyListener(this);
      return true;
    }
    return false;
  }
  
  public void e()
  {
    if (f()) {
      this.l.i();
    }
  }
  
  public boolean f()
  {
    return (this.l != null) && (this.l.k());
  }
  
  public void onDismiss()
  {
    this.l = null;
    this.e.close();
    if (this.m != null)
    {
      if (!this.m.isAlive()) {
        this.m = this.k.getViewTreeObserver();
      }
      this.m.removeGlobalOnLayoutListener(this);
      this.m = null;
    }
  }
  
  public void onGlobalLayout()
  {
    if (f())
    {
      View localView = this.k;
      if ((localView != null) && (localView.isShown())) {
        break label28;
      }
      e();
    }
    label28:
    while (!f()) {
      return;
    }
    this.l.c();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.f;
    a.a(paramAdapterView).a(paramAdapterView.a(paramInt), 0);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      e();
      return true;
    }
    return false;
  }
  
  private class a
    extends BaseAdapter
  {
    private f b;
    private int c = -1;
    
    public a(f paramf)
    {
      this.b = paramf;
      a();
    }
    
    public h a(int paramInt)
    {
      if (k.a(k.this)) {}
      for (ArrayList localArrayList = this.b.l();; localArrayList = this.b.i())
      {
        int i = paramInt;
        if (this.c >= 0)
        {
          i = paramInt;
          if (paramInt >= this.c) {
            i = paramInt + 1;
          }
        }
        return (h)localArrayList.get(i);
      }
    }
    
    void a()
    {
      h localh = k.c(k.this).r();
      if (localh != null)
      {
        ArrayList localArrayList = k.c(k.this).l();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((h)localArrayList.get(i) == localh)
          {
            this.c = i;
            return;
          }
          i += 1;
        }
      }
      this.c = -1;
    }
    
    public int getCount()
    {
      if (k.a(k.this)) {}
      for (ArrayList localArrayList = this.b.l(); this.c < 0; localArrayList = this.b.i()) {
        return localArrayList.size();
      }
      return localArrayList.size() - 1;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = k.b(k.this).inflate(k.a, paramViewGroup, false);
      }
      for (;;)
      {
        paramViewGroup = (m.a)paramView;
        if (k.this.b) {
          ((ListMenuItemView)paramView).setForceShowIcon(true);
        }
        paramViewGroup.a(a(paramInt), 0);
        return paramView;
      }
    }
    
    public void notifyDataSetChanged()
    {
      a();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/view/menu/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */