package android.support.design.widget;

import android.support.v4.j.af;
import android.support.v4.j.s;
import android.support.v4.widget.ab;
import android.support.v4.widget.ab.a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View>
  extends CoordinatorLayout.b<V>
{
  private ab a;
  private a b;
  private boolean c;
  private float d = 0.0F;
  private boolean e;
  private int f = 2;
  private float g = 0.5F;
  private float h = 0.0F;
  private float i = 0.5F;
  private final ab.a j = new ab.a()
  {
    private int b;
    private int c = -1;
    
    private boolean a(View paramAnonymousView, float paramAnonymousFloat)
    {
      int i;
      if (paramAnonymousFloat != 0.0F) {
        if (af.h(paramAnonymousView) == 1)
        {
          i = 1;
          if (SwipeDismissBehavior.c(SwipeDismissBehavior.this) != 2) {
            break label34;
          }
        }
      }
      label34:
      label56:
      label64:
      label87:
      int j;
      int k;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                i = 0;
                break;
                if (SwipeDismissBehavior.c(SwipeDismissBehavior.this) != 0) {
                  break label64;
                }
                if (i == 0) {
                  break label56;
                }
              } while (paramAnonymousFloat < 0.0F);
              return false;
            } while (paramAnonymousFloat > 0.0F);
            return false;
            if (SwipeDismissBehavior.c(SwipeDismissBehavior.this) != 1) {
              break label138;
            }
            if (i == 0) {
              break label87;
            }
          } while (paramAnonymousFloat > 0.0F);
          return false;
        } while (paramAnonymousFloat < 0.0F);
        return false;
        i = paramAnonymousView.getLeft();
        j = this.b;
        k = Math.round(paramAnonymousView.getWidth() * SwipeDismissBehavior.d(SwipeDismissBehavior.this));
      } while (Math.abs(i - j) >= k);
      return false;
      label138:
      return false;
    }
    
    public int a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return paramAnonymousView.getTop();
    }
    
    public void a(int paramAnonymousInt)
    {
      if (SwipeDismissBehavior.a(SwipeDismissBehavior.this) != null) {
        SwipeDismissBehavior.a(SwipeDismissBehavior.this).a(paramAnonymousInt);
      }
    }
    
    public void a(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      this.c = -1;
      int i = paramAnonymousView.getWidth();
      boolean bool = false;
      if (a(paramAnonymousView, paramAnonymousFloat1)) {
        if (paramAnonymousView.getLeft() < this.b)
        {
          i = this.b - i;
          bool = true;
          label46:
          if (!SwipeDismissBehavior.b(SwipeDismissBehavior.this).a(i, paramAnonymousView.getTop())) {
            break label105;
          }
          af.a(paramAnonymousView, new SwipeDismissBehavior.b(SwipeDismissBehavior.this, paramAnonymousView, bool));
        }
      }
      label105:
      while ((!bool) || (SwipeDismissBehavior.a(SwipeDismissBehavior.this) == null))
      {
        return;
        i = this.b + i;
        break;
        i = this.b;
        break label46;
      }
      SwipeDismissBehavior.a(SwipeDismissBehavior.this).a(paramAnonymousView);
    }
    
    public void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      float f1 = this.b + paramAnonymousView.getWidth() * SwipeDismissBehavior.e(SwipeDismissBehavior.this);
      float f2 = this.b + paramAnonymousView.getWidth() * SwipeDismissBehavior.f(SwipeDismissBehavior.this);
      if (paramAnonymousInt1 <= f1)
      {
        af.c(paramAnonymousView, 1.0F);
        return;
      }
      if (paramAnonymousInt1 >= f2)
      {
        af.c(paramAnonymousView, 0.0F);
        return;
      }
      af.c(paramAnonymousView, SwipeDismissBehavior.b(0.0F, 1.0F - SwipeDismissBehavior.a(f1, f2, paramAnonymousInt1), 1.0F));
    }
    
    public boolean a(View paramAnonymousView, int paramAnonymousInt)
    {
      return (this.c == -1) && (SwipeDismissBehavior.this.a(paramAnonymousView));
    }
    
    public int b(View paramAnonymousView)
    {
      return paramAnonymousView.getWidth();
    }
    
    public int b(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      int i;
      if (af.h(paramAnonymousView) == 1)
      {
        paramAnonymousInt2 = 1;
        if (SwipeDismissBehavior.c(SwipeDismissBehavior.this) != 0) {
          break label72;
        }
        if (paramAnonymousInt2 == 0) {
          break label53;
        }
        i = this.b - paramAnonymousView.getWidth();
        paramAnonymousInt2 = this.b;
      }
      for (;;)
      {
        return SwipeDismissBehavior.a(i, paramAnonymousInt1, paramAnonymousInt2);
        paramAnonymousInt2 = 0;
        break;
        label53:
        i = this.b;
        paramAnonymousInt2 = this.b + paramAnonymousView.getWidth();
        continue;
        label72:
        if (SwipeDismissBehavior.c(SwipeDismissBehavior.this) == 1)
        {
          if (paramAnonymousInt2 != 0)
          {
            i = this.b;
            paramAnonymousInt2 = this.b + paramAnonymousView.getWidth();
          }
          else
          {
            i = this.b - paramAnonymousView.getWidth();
            paramAnonymousInt2 = this.b;
          }
        }
        else
        {
          i = this.b - paramAnonymousView.getWidth();
          paramAnonymousInt2 = this.b + paramAnonymousView.getWidth();
        }
      }
    }
    
    public void b(View paramAnonymousView, int paramAnonymousInt)
    {
      this.c = paramAnonymousInt;
      this.b = paramAnonymousView.getLeft();
      paramAnonymousView = paramAnonymousView.getParent();
      if (paramAnonymousView != null) {
        paramAnonymousView.requestDisallowInterceptTouchEvent(true);
      }
    }
  };
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (this.a == null) {
      if (!this.e) {
        break label33;
      }
    }
    label33:
    for (paramViewGroup = ab.a(paramViewGroup, this.d, this.j);; paramViewGroup = ab.a(paramViewGroup, this.j))
    {
      this.a = paramViewGroup;
      return;
    }
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  private static float c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.min(Math.max(paramFloat1, paramFloat2), paramFloat3);
  }
  
  public void a(float paramFloat)
  {
    this.h = c(0.0F, paramFloat, 1.0F);
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(a parama)
  {
    this.b = parama;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    switch (s.a(paramMotionEvent))
    {
    case 2: 
    default: 
      if (paramCoordinatorLayout.a(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      do
      {
        if (!this.c) {
          break;
        }
        return false;
      } while (!this.c);
      this.c = false;
      return false;
    }
    a(paramCoordinatorLayout);
    return this.a.a(paramMotionEvent);
  }
  
  public boolean a(View paramView)
  {
    return true;
  }
  
  public void b(float paramFloat)
  {
    this.i = c(0.0F, paramFloat, 1.0F);
  }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.a != null)
    {
      this.a.b(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
    
    public abstract void a(View paramView);
  }
  
  private class b
    implements Runnable
  {
    private final View b;
    private final boolean c;
    
    b(View paramView, boolean paramBoolean)
    {
      this.b = paramView;
      this.c = paramBoolean;
    }
    
    public void run()
    {
      if ((SwipeDismissBehavior.b(SwipeDismissBehavior.this) != null) && (SwipeDismissBehavior.b(SwipeDismissBehavior.this).a(true))) {
        af.a(this.b, this);
      }
      while ((!this.c) || (SwipeDismissBehavior.a(SwipeDismissBehavior.this) == null)) {
        return;
      }
      SwipeDismissBehavior.a(SwipeDismissBehavior.this).a(this.b);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/widget/SwipeDismissBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */