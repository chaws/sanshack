package android.support.design.widget;

import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class o
{
  private final ArrayList<a> a = new ArrayList();
  private a b = null;
  private Animation c = null;
  private WeakReference<View> d;
  private Animation.AnimationListener e = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      if (o.a(o.this) == paramAnonymousAnimation) {
        o.a(o.this, null);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  
  private void a(a parama)
  {
    this.c = parama.b;
    parama = a();
    if (parama != null) {
      parama.startAnimation(this.c);
    }
  }
  
  private void c()
  {
    View localView = a();
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      Animation localAnimation = ((a)this.a.get(i)).b;
      if (localView.getAnimation() == localAnimation) {
        localView.clearAnimation();
      }
      i += 1;
    }
    this.d = null;
    this.b = null;
    this.c = null;
  }
  
  private void d()
  {
    if (this.c != null)
    {
      View localView = a();
      if ((localView != null) && (localView.getAnimation() == this.c)) {
        localView.clearAnimation();
      }
      this.c = null;
    }
  }
  
  View a()
  {
    if (this.d == null) {
      return null;
    }
    return (View)this.d.get();
  }
  
  void a(View paramView)
  {
    View localView = a();
    if (localView == paramView) {}
    do
    {
      return;
      if (localView != null) {
        c();
      }
    } while (paramView == null);
    this.d = new WeakReference(paramView);
  }
  
  void a(int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    int j = this.a.size();
    int i = 0;
    Object localObject1 = localObject2;
    if (i < j)
    {
      localObject1 = (a)this.a.get(i);
      if (!StateSet.stateSetMatches(((a)localObject1).a, paramArrayOfInt)) {}
    }
    else
    {
      if (localObject1 != this.b) {
        break label65;
      }
    }
    label65:
    do
    {
      return;
      i += 1;
      break;
      if (this.b != null) {
        d();
      }
      this.b = ((a)localObject1);
      paramArrayOfInt = (View)this.d.get();
    } while ((localObject1 == null) || (paramArrayOfInt == null) || (paramArrayOfInt.getVisibility() != 0));
    a((a)localObject1);
  }
  
  public void a(int[] paramArrayOfInt, Animation paramAnimation)
  {
    paramArrayOfInt = new a(paramArrayOfInt, paramAnimation, null);
    paramAnimation.setAnimationListener(this.e);
    this.a.add(paramArrayOfInt);
  }
  
  public void b()
  {
    if (this.c != null)
    {
      View localView = a();
      if ((localView != null) && (localView.getAnimation() == this.c)) {
        localView.clearAnimation();
      }
    }
  }
  
  static class a
  {
    final int[] a;
    final Animation b;
    
    private a(int[] paramArrayOfInt, Animation paramAnimation)
    {
      this.a = paramArrayOfInt;
      this.b = paramAnimation;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/widget/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */