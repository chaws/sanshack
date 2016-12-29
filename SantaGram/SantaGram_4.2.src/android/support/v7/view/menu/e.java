package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.b.a.h;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class e
  implements l, AdapterView.OnItemClickListener
{
  Context a;
  LayoutInflater b;
  f c;
  ExpandedMenuView d;
  int e;
  int f;
  a g;
  private int h;
  private l.a i;
  
  public e(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.e = paramInt2;
  }
  
  public e(Context paramContext, int paramInt)
  {
    this(paramInt, 0);
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a);
  }
  
  public m a(ViewGroup paramViewGroup)
  {
    if (this.d == null)
    {
      this.d = ((ExpandedMenuView)this.b.inflate(a.h.abc_expanded_menu_layout, paramViewGroup, false));
      if (this.g == null) {
        this.g = new a();
      }
      this.d.setAdapter(this.g);
      this.d.setOnItemClickListener(this);
    }
    return this.d;
  }
  
  public ListAdapter a()
  {
    if (this.g == null) {
      this.g = new a();
    }
    return this.g;
  }
  
  public void a(Context paramContext, f paramf)
  {
    if (this.e != 0)
    {
      this.a = new ContextThemeWrapper(paramContext, this.e);
      this.b = LayoutInflater.from(this.a);
    }
    for (;;)
    {
      this.c = paramf;
      if (this.g != null) {
        this.g.notifyDataSetChanged();
      }
      return;
      if (this.a != null)
      {
        this.a = paramContext;
        if (this.b == null) {
          this.b = LayoutInflater.from(this.a);
        }
      }
    }
  }
  
  public void a(f paramf, boolean paramBoolean)
  {
    if (this.i != null) {
      this.i.a(paramf, paramBoolean);
    }
  }
  
  public void a(l.a parama)
  {
    this.i = parama;
  }
  
  public boolean a(f paramf, h paramh)
  {
    return false;
  }
  
  public boolean a(p paramp)
  {
    if (!paramp.hasVisibleItems()) {
      return false;
    }
    new g(paramp).a(null);
    if (this.i != null) {
      this.i.a(paramp);
    }
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.g != null) {
      this.g.notifyDataSetChanged();
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
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.c.a(this.g.a(paramInt), this, 0);
  }
  
  private class a
    extends BaseAdapter
  {
    private int b = -1;
    
    public a()
    {
      a();
    }
    
    public h a(int paramInt)
    {
      ArrayList localArrayList = e.this.c.l();
      int i = e.a(e.this) + paramInt;
      paramInt = i;
      if (this.b >= 0)
      {
        paramInt = i;
        if (i >= this.b) {
          paramInt = i + 1;
        }
      }
      return (h)localArrayList.get(paramInt);
    }
    
    void a()
    {
      h localh = e.this.c.r();
      if (localh != null)
      {
        ArrayList localArrayList = e.this.c.l();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((h)localArrayList.get(i) == localh)
          {
            this.b = i;
            return;
          }
          i += 1;
        }
      }
      this.b = -1;
    }
    
    public int getCount()
    {
      int i = e.this.c.l().size() - e.a(e.this);
      if (this.b < 0) {
        return i;
      }
      return i - 1;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = e.this.b.inflate(e.this.f, paramViewGroup, false);
      }
      for (;;)
      {
        ((m.a)paramView).a(a(paramInt), 0);
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


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/view/menu/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */