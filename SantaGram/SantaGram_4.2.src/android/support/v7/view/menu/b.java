package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.j.af;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b
  implements l
{
  protected Context a;
  protected Context b;
  protected f c;
  protected LayoutInflater d;
  protected LayoutInflater e;
  protected m f;
  private l.a g;
  private int h;
  private int i;
  private int j;
  
  public b(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public l.a a()
  {
    return this.g;
  }
  
  public m a(ViewGroup paramViewGroup)
  {
    if (this.f == null)
    {
      this.f = ((m)this.d.inflate(this.h, paramViewGroup, false));
      this.f.a(this.c);
      b(true);
    }
    return this.f;
  }
  
  public View a(h paramh, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof m.a)) {}
    for (paramView = (m.a)paramView;; paramView = b(paramViewGroup))
    {
      a(paramh, paramView);
      return (View)paramView;
    }
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(Context paramContext, f paramf)
  {
    this.b = paramContext;
    this.e = LayoutInflater.from(this.b);
    this.c = paramf;
  }
  
  public void a(f paramf, boolean paramBoolean)
  {
    if (this.g != null) {
      this.g.a(paramf, paramBoolean);
    }
  }
  
  public abstract void a(h paramh, m.a parama);
  
  public void a(l.a parama)
  {
    this.g = parama;
  }
  
  protected void a(View paramView, int paramInt)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(paramView);
    }
    ((ViewGroup)this.f).addView(paramView, paramInt);
  }
  
  public boolean a(int paramInt, h paramh)
  {
    return true;
  }
  
  public boolean a(f paramf, h paramh)
  {
    return false;
  }
  
  public boolean a(p paramp)
  {
    if (this.g != null) {
      return this.g.a(paramp);
    }
    return false;
  }
  
  protected boolean a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public m.a b(ViewGroup paramViewGroup)
  {
    return (m.a)this.d.inflate(this.i, paramViewGroup, false);
  }
  
  public void b(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.f;
    if (localViewGroup == null) {}
    label201:
    label208:
    for (;;)
    {
      return;
      int m;
      if (this.c != null)
      {
        this.c.j();
        ArrayList localArrayList = this.c.i();
        int i1 = localArrayList.size();
        int n = 0;
        int k = 0;
        m = k;
        if (n < i1)
        {
          h localh2 = (h)localArrayList.get(n);
          if (!a(k, localh2)) {
            break label201;
          }
          View localView1 = localViewGroup.getChildAt(k);
          if ((localView1 instanceof m.a)) {}
          for (h localh1 = ((m.a)localView1).getItemData();; localh1 = null)
          {
            View localView2 = a(localh2, localView1, localViewGroup);
            if (localh2 != localh1)
            {
              localView2.setPressed(false);
              af.u(localView2);
            }
            if (localView2 != localView1) {
              a(localView2, k);
            }
            k += 1;
            n += 1;
            break;
          }
        }
      }
      for (;;)
      {
        if (m >= localViewGroup.getChildCount()) {
          break label208;
        }
        if (!a(localViewGroup, m))
        {
          m += 1;
          continue;
          break;
          m = 0;
        }
      }
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
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/view/menu/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */