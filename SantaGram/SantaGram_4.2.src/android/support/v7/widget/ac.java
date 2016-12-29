package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class ac
{
  final b a;
  final a b;
  final List<View> c;
  
  ac(b paramb)
  {
    this.a = paramb;
    this.b = new a();
    this.c = new ArrayList();
  }
  
  private int e(int paramInt)
  {
    if (paramInt < 0)
    {
      paramInt = -1;
      return paramInt;
    }
    int j = this.a.a();
    int i = paramInt;
    for (;;)
    {
      if (i >= j) {
        break label72;
      }
      int k = paramInt - (i - this.b.e(i));
      if (k == 0) {
        for (;;)
        {
          paramInt = i;
          if (!this.b.c(i)) {
            break;
          }
          i += 1;
        }
      }
      i += k;
    }
    label72:
    return -1;
  }
  
  private void g(View paramView)
  {
    this.c.add(paramView);
    this.a.c(paramView);
  }
  
  private boolean h(View paramView)
  {
    if (this.c.remove(paramView))
    {
      this.a.d(paramView);
      return true;
    }
    return false;
  }
  
  View a(int paramInt1, int paramInt2)
  {
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.c.get(i);
      ao.v localv = this.a.b(localView);
      if ((localv.d() == paramInt1) && (!localv.n()) && (!localv.q()) && ((paramInt2 == -1) || (localv.h() == paramInt2))) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  void a()
  {
    this.b.a();
    int i = this.c.size() - 1;
    while (i >= 0)
    {
      this.a.d((View)this.c.get(i));
      this.c.remove(i);
      i -= 1;
    }
    this.a.b();
  }
  
  void a(int paramInt)
  {
    paramInt = e(paramInt);
    View localView = this.a.b(paramInt);
    if (localView == null) {
      return;
    }
    if (this.b.d(paramInt)) {
      h(localView);
    }
    this.a.a(paramInt);
  }
  
  void a(View paramView)
  {
    int i = this.a.a(paramView);
    if (i < 0) {
      return;
    }
    if (this.b.d(i)) {
      h(paramView);
    }
    this.a.a(i);
  }
  
  void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.a.a();; paramInt = e(paramInt))
    {
      this.b.a(paramInt, paramBoolean);
      if (paramBoolean) {
        g(paramView);
      }
      this.a.a(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.a.a();; paramInt = e(paramInt))
    {
      this.b.a(paramInt, paramBoolean);
      if (paramBoolean) {
        g(paramView);
      }
      this.a.a(paramView, paramInt);
      return;
    }
  }
  
  void a(View paramView, boolean paramBoolean)
  {
    a(paramView, -1, paramBoolean);
  }
  
  int b()
  {
    return this.a.a() - this.c.size();
  }
  
  int b(View paramView)
  {
    int i = this.a.a(paramView);
    if (i == -1) {}
    while (this.b.c(i)) {
      return -1;
    }
    return i - this.b.e(i);
  }
  
  View b(int paramInt)
  {
    paramInt = e(paramInt);
    return this.a.b(paramInt);
  }
  
  int c()
  {
    return this.a.a();
  }
  
  View c(int paramInt)
  {
    return this.a.b(paramInt);
  }
  
  boolean c(View paramView)
  {
    return this.c.contains(paramView);
  }
  
  void d(int paramInt)
  {
    paramInt = e(paramInt);
    this.b.d(paramInt);
    this.a.c(paramInt);
  }
  
  void d(View paramView)
  {
    int i = this.a.a(paramView);
    if (i < 0) {
      throw new IllegalArgumentException("view is not a child, cannot hide " + paramView);
    }
    this.b.a(i);
    g(paramView);
  }
  
  void e(View paramView)
  {
    int i = this.a.a(paramView);
    if (i < 0) {
      throw new IllegalArgumentException("view is not a child, cannot hide " + paramView);
    }
    if (!this.b.c(i)) {
      throw new RuntimeException("trying to unhide a view that was not hidden" + paramView);
    }
    this.b.b(i);
    h(paramView);
  }
  
  boolean f(View paramView)
  {
    int i = this.a.a(paramView);
    if (i == -1)
    {
      if (h(paramView)) {}
      return true;
    }
    if (this.b.c(i))
    {
      this.b.d(i);
      if (!h(paramView)) {}
      this.a.a(i);
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    return this.b.toString() + ", hidden list:" + this.c.size();
  }
  
  static class a
  {
    long a = 0L;
    a b;
    
    private void b()
    {
      if (this.b == null) {
        this.b = new a();
      }
    }
    
    void a()
    {
      this.a = 0L;
      if (this.b != null) {
        this.b.a();
      }
    }
    
    void a(int paramInt)
    {
      if (paramInt >= 64)
      {
        b();
        this.b.a(paramInt - 64);
        return;
      }
      this.a |= 1L << paramInt;
    }
    
    void a(int paramInt, boolean paramBoolean)
    {
      if (paramInt >= 64)
      {
        b();
        this.b.a(paramInt - 64, paramBoolean);
      }
      label114:
      label120:
      for (;;)
      {
        return;
        boolean bool;
        if ((this.a & 0x8000000000000000) != 0L)
        {
          bool = true;
          long l1 = (1L << paramInt) - 1L;
          long l2 = this.a;
          this.a = (((l1 ^ 0xFFFFFFFFFFFFFFFF) & this.a) << 1 | l2 & l1);
          if (!paramBoolean) {
            break label114;
          }
          a(paramInt);
        }
        for (;;)
        {
          if ((!bool) && (this.b == null)) {
            break label120;
          }
          b();
          this.b.a(0, bool);
          return;
          bool = false;
          break;
          b(paramInt);
        }
      }
    }
    
    void b(int paramInt)
    {
      if (paramInt >= 64)
      {
        if (this.b != null) {
          this.b.b(paramInt - 64);
        }
        return;
      }
      this.a &= (1L << paramInt ^ 0xFFFFFFFFFFFFFFFF);
    }
    
    boolean c(int paramInt)
    {
      if (paramInt >= 64)
      {
        b();
        return this.b.c(paramInt - 64);
      }
      return (this.a & 1L << paramInt) != 0L;
    }
    
    boolean d(int paramInt)
    {
      boolean bool2;
      if (paramInt >= 64)
      {
        b();
        bool2 = this.b.d(paramInt - 64);
        return bool2;
      }
      long l1 = 1L << paramInt;
      if ((this.a & l1) != 0L) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        this.a &= (l1 ^ 0xFFFFFFFFFFFFFFFF);
        l1 -= 1L;
        long l2 = this.a;
        this.a = (Long.rotateRight((l1 ^ 0xFFFFFFFFFFFFFFFF) & this.a, 1) | l2 & l1);
        bool2 = bool1;
        if (this.b == null) {
          break;
        }
        if (this.b.c(0)) {
          a(63);
        }
        this.b.d(0);
        return bool1;
      }
    }
    
    int e(int paramInt)
    {
      if (this.b == null)
      {
        if (paramInt >= 64) {
          return Long.bitCount(this.a);
        }
        return Long.bitCount(this.a & (1L << paramInt) - 1L);
      }
      if (paramInt < 64) {
        return Long.bitCount(this.a & (1L << paramInt) - 1L);
      }
      return this.b.e(paramInt - 64) + Long.bitCount(this.a);
    }
    
    public String toString()
    {
      if (this.b == null) {
        return Long.toBinaryString(this.a);
      }
      return this.b.toString() + "xx" + Long.toBinaryString(this.a);
    }
  }
  
  static abstract interface b
  {
    public abstract int a();
    
    public abstract int a(View paramView);
    
    public abstract void a(int paramInt);
    
    public abstract void a(View paramView, int paramInt);
    
    public abstract void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams);
    
    public abstract ao.v b(View paramView);
    
    public abstract View b(int paramInt);
    
    public abstract void b();
    
    public abstract void c(int paramInt);
    
    public abstract void c(View paramView);
    
    public abstract void d(View paramView);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */