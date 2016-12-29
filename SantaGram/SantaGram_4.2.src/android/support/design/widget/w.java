package android.support.design.widget;

import android.support.v4.j.af;
import android.view.View;

class w
{
  private final View a;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public w(View paramView)
  {
    this.a = paramView;
  }
  
  private void c()
  {
    af.e(this.a, this.d - (this.a.getTop() - this.b));
    af.f(this.a, this.e - (this.a.getLeft() - this.c));
  }
  
  public void a()
  {
    this.b = this.a.getTop();
    this.c = this.a.getLeft();
    c();
  }
  
  public boolean a(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      c();
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public boolean b(int paramInt)
  {
    if (this.e != paramInt)
    {
      this.e = paramInt;
      c();
      return true;
    }
    return false;
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/widget/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */