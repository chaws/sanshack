package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.e.a.a;
import android.support.v4.i.i;
import android.support.v7.view.menu.n;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

@TargetApi(11)
public class f
  extends ActionMode
{
  final Context a;
  final b b;
  
  public f(Context paramContext, b paramb)
  {
    this.a = paramContext;
    this.b = paramb;
  }
  
  public void finish()
  {
    this.b.c();
  }
  
  public View getCustomView()
  {
    return this.b.i();
  }
  
  public Menu getMenu()
  {
    return n.a(this.a, (a)this.b.b());
  }
  
  public MenuInflater getMenuInflater()
  {
    return this.b.a();
  }
  
  public CharSequence getSubtitle()
  {
    return this.b.g();
  }
  
  public Object getTag()
  {
    return this.b.j();
  }
  
  public CharSequence getTitle()
  {
    return this.b.f();
  }
  
  public boolean getTitleOptionalHint()
  {
    return this.b.k();
  }
  
  public void invalidate()
  {
    this.b.d();
  }
  
  public boolean isTitleOptional()
  {
    return this.b.h();
  }
  
  public void setCustomView(View paramView)
  {
    this.b.a(paramView);
  }
  
  public void setSubtitle(int paramInt)
  {
    this.b.b(paramInt);
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.b.a(paramCharSequence);
  }
  
  public void setTag(Object paramObject)
  {
    this.b.a(paramObject);
  }
  
  public void setTitle(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.b.b(paramCharSequence);
  }
  
  public void setTitleOptionalHint(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
  
  public static class a
    implements b.a
  {
    final ActionMode.Callback a;
    final Context b;
    final ArrayList<f> c;
    final i<Menu, Menu> d;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      this.b = paramContext;
      this.a = paramCallback;
      this.c = new ArrayList();
      this.d = new i();
    }
    
    private Menu a(Menu paramMenu)
    {
      Menu localMenu2 = (Menu)this.d.get(paramMenu);
      Menu localMenu1 = localMenu2;
      if (localMenu2 == null)
      {
        localMenu1 = n.a(this.b, (a)paramMenu);
        this.d.put(paramMenu, localMenu1);
      }
      return localMenu1;
    }
    
    public void a(b paramb)
    {
      this.a.onDestroyActionMode(b(paramb));
    }
    
    public boolean a(b paramb, Menu paramMenu)
    {
      return this.a.onCreateActionMode(b(paramb), a(paramMenu));
    }
    
    public boolean a(b paramb, MenuItem paramMenuItem)
    {
      return this.a.onActionItemClicked(b(paramb), n.a(this.b, (android.support.v4.e.a.b)paramMenuItem));
    }
    
    public ActionMode b(b paramb)
    {
      int j = this.c.size();
      int i = 0;
      while (i < j)
      {
        f localf = (f)this.c.get(i);
        if ((localf != null) && (localf.b == paramb)) {
          return localf;
        }
        i += 1;
      }
      paramb = new f(this.b, paramb);
      this.c.add(paramb);
      return paramb;
    }
    
    public boolean b(b paramb, Menu paramMenu)
    {
      return this.a.onPrepareActionMode(b(paramb), a(paramMenu));
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/view/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */