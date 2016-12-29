package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

public final class o
{
  static final f a = new c();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      a = new b();
      return;
    }
    if (i >= 21)
    {
      a = new a();
      return;
    }
    if (i >= 19)
    {
      a = new e();
      return;
    }
    if (i >= 9)
    {
      a = new d();
      return;
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    a.a(paramPopupWindow, paramInt);
  }
  
  public static void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a.a(paramPopupWindow, paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    a.a(paramPopupWindow, paramBoolean);
  }
  
  static class a
    extends o.e
  {
    public void a(PopupWindow paramPopupWindow, boolean paramBoolean)
    {
      p.a(paramPopupWindow, paramBoolean);
    }
  }
  
  static class b
    extends o.a
  {
    public void a(PopupWindow paramPopupWindow, int paramInt)
    {
      q.a(paramPopupWindow, paramInt);
    }
    
    public void a(PopupWindow paramPopupWindow, boolean paramBoolean)
    {
      q.a(paramPopupWindow, paramBoolean);
    }
  }
  
  static class c
    implements o.f
  {
    public void a(PopupWindow paramPopupWindow, int paramInt) {}
    
    public void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
    {
      paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2);
    }
    
    public void a(PopupWindow paramPopupWindow, boolean paramBoolean) {}
  }
  
  static class d
    extends o.c
  {
    public void a(PopupWindow paramPopupWindow, int paramInt)
    {
      r.a(paramPopupWindow, paramInt);
    }
  }
  
  static class e
    extends o.d
  {
    public void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
    {
      s.a(paramPopupWindow, paramView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  static abstract interface f
  {
    public abstract void a(PopupWindow paramPopupWindow, int paramInt);
    
    public abstract void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void a(PopupWindow paramPopupWindow, boolean paramBoolean);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/widget/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */