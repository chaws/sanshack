package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.j.af;
import android.support.v4.j.d;
import android.support.v7.b.a.f;
import android.support.v7.b.a.h;
import android.support.v7.b.a.i;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

public class ActivityChooserView
  extends ViewGroup
{
  d a;
  private final a b;
  private final b c;
  private final aj d;
  private final FrameLayout e;
  private final ImageView f;
  private final FrameLayout g;
  private final int h;
  private final DataSetObserver i;
  private final ViewTreeObserver.OnGlobalLayoutListener j;
  private ak k;
  private PopupWindow.OnDismissListener l;
  private boolean m;
  private int n;
  private boolean o;
  private int p;
  
  private void a(int paramInt)
  {
    if (this.b.d() == null) {
      throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }
    getViewTreeObserver().addOnGlobalLayoutListener(this.j);
    boolean bool;
    int i1;
    label60:
    label92:
    ak localak;
    if (this.g.getVisibility() == 0)
    {
      bool = true;
      int i2 = this.b.c();
      if (!bool) {
        break label187;
      }
      i1 = 1;
      if ((paramInt == Integer.MAX_VALUE) || (i2 <= i1 + paramInt)) {
        break label192;
      }
      this.b.a(true);
      this.b.a(paramInt - 1);
      localak = getListPopupWindow();
      if (!localak.k())
      {
        if ((!this.m) && (bool)) {
          break label211;
        }
        this.b.a(true, bool);
      }
    }
    for (;;)
    {
      localak.f(Math.min(this.b.a(), this.h));
      localak.c();
      if (this.a != null) {
        this.a.a(true);
      }
      localak.m().setContentDescription(getContext().getString(a.i.abc_activitychooserview_choose_application));
      return;
      bool = false;
      break;
      label187:
      i1 = 0;
      break label60;
      label192:
      this.b.a(false);
      this.b.a(paramInt);
      break label92;
      label211:
      this.b.a(false, false);
    }
  }
  
  private ak getListPopupWindow()
  {
    if (this.k == null)
    {
      this.k = new ak(getContext());
      this.k.a(this.b);
      this.k.a(this);
      this.k.a(true);
      this.k.a(this.c);
      this.k.a(this.c);
    }
    return this.k;
  }
  
  public boolean a()
  {
    if ((c()) || (!this.o)) {
      return false;
    }
    this.m = false;
    a(this.n);
    return true;
  }
  
  public boolean b()
  {
    if (c())
    {
      getListPopupWindow().i();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.j);
      }
    }
    return true;
  }
  
  public boolean c()
  {
    return getListPopupWindow().k();
  }
  
  public e getDataModel()
  {
    return this.b.d();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    e locale = this.b.d();
    if (locale != null) {
      locale.registerObserver(this.i);
    }
    this.o = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.b.d();
    if (localObject != null) {
      ((e)localObject).unregisterObserver(this.i);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this.j);
    }
    if (c()) {
      b();
    }
    this.o = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.d.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!c()) {
      b();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    aj localaj = this.d;
    int i1 = paramInt2;
    if (this.g.getVisibility() != 0) {
      i1 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localaj, paramInt1, i1);
    setMeasuredDimension(localaj.getMeasuredWidth(), localaj.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(e parame)
  {
    this.b.a(parame);
    if (c())
    {
      b();
      a();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    this.f.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    this.f.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.l = paramOnDismissListener;
  }
  
  public void setProvider(d paramd)
  {
    this.a = paramd;
  }
  
  public static class InnerLayout
    extends aj
  {
    private static final int[] a = { 16842964 };
    
    public InnerLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = bb.a(paramContext, paramAttributeSet, a);
      setBackgroundDrawable(paramContext.a(0));
      paramContext.a();
    }
  }
  
  private class a
    extends BaseAdapter
  {
    private e b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;
    
    public int a()
    {
      int i = 0;
      int k = this.c;
      this.c = Integer.MAX_VALUE;
      int m = View.MeasureSpec.makeMeasureSpec(0, 0);
      int n = View.MeasureSpec.makeMeasureSpec(0, 0);
      int i1 = getCount();
      View localView = null;
      int j = 0;
      while (i < i1)
      {
        localView = getView(i, localView, null);
        localView.measure(m, n);
        j = Math.max(j, localView.getMeasuredWidth());
        i += 1;
      }
      this.c = k;
      return j;
    }
    
    public void a(int paramInt)
    {
      if (this.c != paramInt)
      {
        this.c = paramInt;
        notifyDataSetChanged();
      }
    }
    
    public void a(e parame)
    {
      e locale = ActivityChooserView.a(this.a).d();
      if ((locale != null) && (this.a.isShown())) {
        locale.unregisterObserver(ActivityChooserView.g(this.a));
      }
      this.b = parame;
      if ((parame != null) && (this.a.isShown())) {
        parame.registerObserver(ActivityChooserView.g(this.a));
      }
      notifyDataSetChanged();
    }
    
    public void a(boolean paramBoolean)
    {
      if (this.f != paramBoolean)
      {
        this.f = paramBoolean;
        notifyDataSetChanged();
      }
    }
    
    public void a(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((this.d != paramBoolean1) || (this.e != paramBoolean2))
      {
        this.d = paramBoolean1;
        this.e = paramBoolean2;
        notifyDataSetChanged();
      }
    }
    
    public ResolveInfo b()
    {
      return this.b.b();
    }
    
    public int c()
    {
      return this.b.a();
    }
    
    public e d()
    {
      return this.b;
    }
    
    public boolean e()
    {
      return this.d;
    }
    
    public int getCount()
    {
      int j = this.b.a();
      int i = j;
      if (!this.d)
      {
        i = j;
        if (this.b.b() != null) {
          i = j - 1;
        }
      }
      j = Math.min(i, this.c);
      i = j;
      if (this.f) {
        i = j + 1;
      }
      return i;
    }
    
    public Object getItem(int paramInt)
    {
      switch (getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        return null;
      }
      int i = paramInt;
      if (!this.d)
      {
        i = paramInt;
        if (this.b.b() != null) {
          i = paramInt + 1;
        }
      }
      return this.b.a(i);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      if ((this.f) && (paramInt == getCount() - 1)) {
        return 1;
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      switch (getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        if (paramView != null)
        {
          localView = paramView;
          if (paramView.getId() == 1) {}
        }
        else
        {
          localView = LayoutInflater.from(this.a.getContext()).inflate(a.h.abc_activity_chooser_view_list_item, paramViewGroup, false);
          localView.setId(1);
          ((TextView)localView.findViewById(a.f.title)).setText(this.a.getContext().getString(a.i.abc_activity_chooser_view_see_all));
        }
        return localView;
      }
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getId() == a.f.list_item) {}
      }
      else
      {
        localView = LayoutInflater.from(this.a.getContext()).inflate(a.h.abc_activity_chooser_view_list_item, paramViewGroup, false);
      }
      paramView = this.a.getContext().getPackageManager();
      paramViewGroup = (ImageView)localView.findViewById(a.f.icon);
      ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
      paramViewGroup.setImageDrawable(localResolveInfo.loadIcon(paramView));
      ((TextView)localView.findViewById(a.f.title)).setText(localResolveInfo.loadLabel(paramView));
      if ((this.d) && (paramInt == 0) && (this.e))
      {
        af.c(localView, true);
        return localView;
      }
      af.c(localView, false);
      return localView;
    }
    
    public int getViewTypeCount()
    {
      return 3;
    }
  }
  
  private class b
    implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
  {
    private void a()
    {
      if (ActivityChooserView.f(this.a) != null) {
        ActivityChooserView.f(this.a).onDismiss();
      }
    }
    
    public void onClick(View paramView)
    {
      if (paramView == ActivityChooserView.c(this.a))
      {
        this.a.b();
        paramView = ActivityChooserView.a(this.a).b();
        int i = ActivityChooserView.a(this.a).d().a(paramView);
        paramView = ActivityChooserView.a(this.a).d().b(i);
        if (paramView != null)
        {
          paramView.addFlags(524288);
          this.a.getContext().startActivity(paramView);
        }
        return;
      }
      if (paramView == ActivityChooserView.d(this.a))
      {
        ActivityChooserView.a(this.a, false);
        ActivityChooserView.a(this.a, ActivityChooserView.e(this.a));
        return;
      }
      throw new IllegalArgumentException();
    }
    
    public void onDismiss()
    {
      a();
      if (this.a.a != null) {
        this.a.a.a(false);
      }
    }
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      switch (((ActivityChooserView.a)paramAdapterView.getAdapter()).getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        ActivityChooserView.a(this.a, Integer.MAX_VALUE);
      }
      do
      {
        return;
        this.a.b();
        if (!ActivityChooserView.b(this.a)) {
          break;
        }
      } while (paramInt <= 0);
      ActivityChooserView.a(this.a).d().c(paramInt);
      return;
      if (ActivityChooserView.a(this.a).e()) {}
      for (;;)
      {
        paramAdapterView = ActivityChooserView.a(this.a).d().b(paramInt);
        if (paramAdapterView == null) {
          break;
        }
        paramAdapterView.addFlags(524288);
        this.a.getContext().startActivity(paramAdapterView);
        return;
        paramInt += 1;
      }
    }
    
    public boolean onLongClick(View paramView)
    {
      if (paramView == ActivityChooserView.c(this.a))
      {
        if (ActivityChooserView.a(this.a).getCount() > 0)
        {
          ActivityChooserView.a(this.a, true);
          ActivityChooserView.a(this.a, ActivityChooserView.e(this.a));
        }
        return true;
      }
      throw new IllegalArgumentException();
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/ActivityChooserView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */