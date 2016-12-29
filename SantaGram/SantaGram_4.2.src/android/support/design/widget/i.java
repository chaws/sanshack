package android.support.design.widget;

import android.content.Context;
import android.support.v4.j.ad;
import android.support.v4.j.af;
import android.support.v4.j.s;
import android.support.v4.widget.u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

abstract class i<V extends View>
  extends v<V>
{
  private Runnable a;
  private u b;
  private boolean c;
  private int d = -1;
  private int e;
  private int f = -1;
  private VelocityTracker g;
  
  public i() {}
  
  public i(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void c()
  {
    if (this.g == null) {
      this.g = VelocityTracker.obtain();
    }
  }
  
  int a()
  {
    return b();
  }
  
  int a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = b();
    int j = 0;
    int i = j;
    if (paramInt2 != 0)
    {
      i = j;
      if (k >= paramInt2)
      {
        i = j;
        if (k <= paramInt3)
        {
          paramInt1 = k.a(paramInt1, paramInt2, paramInt3);
          i = j;
          if (k != paramInt1)
          {
            a(paramInt1);
            i = k - paramInt1;
          }
        }
      }
    }
    return i;
  }
  
  int a(V paramV)
  {
    return paramV.getHeight();
  }
  
  void a(CoordinatorLayout paramCoordinatorLayout, V paramV) {}
  
  final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, float paramFloat)
  {
    if (this.a != null)
    {
      paramV.removeCallbacks(this.a);
      this.a = null;
    }
    if (this.b == null) {
      this.b = u.a(paramV.getContext());
    }
    this.b.a(0, b(), 0, Math.round(paramFloat), 0, 0, paramInt1, paramInt2);
    if (this.b.g())
    {
      this.a = new a(paramCoordinatorLayout, paramV);
      af.a(paramV, this.a);
      return true;
    }
    a(paramCoordinatorLayout, paramV);
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.f < 0) {
      this.f = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    if ((paramMotionEvent.getAction() == 2) && (this.c)) {
      return true;
    }
    switch (s.a(paramMotionEvent))
    {
    }
    for (;;)
    {
      if (this.g != null) {
        this.g.addMovement(paramMotionEvent);
      }
      return this.c;
      this.c = false;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((c(paramV)) && (paramCoordinatorLayout.a(paramV, i, j)))
      {
        this.e = j;
        this.d = s.b(paramMotionEvent, 0);
        c();
        continue;
        i = this.d;
        if (i != -1)
        {
          i = s.a(paramMotionEvent, i);
          if (i != -1)
          {
            i = (int)s.d(paramMotionEvent, i);
            if (Math.abs(i - this.e) > this.f)
            {
              this.c = true;
              this.e = i;
              continue;
              this.c = false;
              this.d = -1;
              if (this.g != null)
              {
                this.g.recycle();
                this.g = null;
              }
            }
          }
        }
      }
    }
  }
  
  int a_(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return a(paramCoordinatorLayout, paramV, paramInt, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  final int b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramCoordinatorLayout, paramV, a() - paramInt1, paramInt2, paramInt3);
  }
  
  int b(V paramV)
  {
    return -paramV.getHeight();
  }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (this.f < 0) {
      this.f = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    switch (s.a(paramMotionEvent))
    {
    }
    for (;;)
    {
      if (this.g != null) {
        this.g.addMovement(paramMotionEvent);
      }
      boolean bool1 = true;
      do
      {
        do
        {
          do
          {
            return bool1;
            i = (int)paramMotionEvent.getX();
            j = (int)paramMotionEvent.getY();
            bool1 = bool2;
          } while (!paramCoordinatorLayout.a(paramV, i, j));
          bool1 = bool2;
        } while (!c(paramV));
        this.e = j;
        this.d = s.b(paramMotionEvent, 0);
        c();
        break;
        i = s.a(paramMotionEvent, this.d);
        bool1 = bool2;
      } while (i == -1);
      int k = (int)s.d(paramMotionEvent, i);
      int j = this.e - k;
      int i = j;
      if (!this.c)
      {
        i = j;
        if (Math.abs(j) > this.f)
        {
          this.c = true;
          if (j <= 0) {
            break label260;
          }
        }
      }
      label260:
      for (i = j - this.f; this.c; i = j + this.f)
      {
        this.e = k;
        b(paramCoordinatorLayout, paramV, i, b(paramV), 0);
        break;
      }
      if (this.g != null)
      {
        this.g.addMovement(paramMotionEvent);
        this.g.computeCurrentVelocity(1000);
        float f1 = ad.b(this.g, this.d);
        a(paramCoordinatorLayout, paramV, -a(paramV), 0, f1);
      }
      this.c = false;
      this.d = -1;
      if (this.g != null)
      {
        this.g.recycle();
        this.g = null;
      }
    }
  }
  
  boolean c(V paramV)
  {
    return false;
  }
  
  private class a
    implements Runnable
  {
    private final CoordinatorLayout b;
    private final V c;
    
    a(V paramV)
    {
      this.b = paramV;
      View localView;
      this.c = localView;
    }
    
    public void run()
    {
      if ((this.c != null) && (i.a(i.this) != null))
      {
        if (i.a(i.this).g())
        {
          i.this.a_(this.b, this.c, i.a(i.this).c());
          af.a(this.c, this);
        }
      }
      else {
        return;
      }
      i.this.a(this.b, this.c);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/widget/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */