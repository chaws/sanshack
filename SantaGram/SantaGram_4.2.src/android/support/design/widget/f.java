package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.j.af;
import android.view.ViewPropertyAnimator;

class f
  extends e
{
  private boolean m;
  
  f(y paramy, m paramm)
  {
    super(paramy, paramm);
  }
  
  private void c(float paramFloat)
  {
    if (this.a != null) {
      this.a.a(-paramFloat);
    }
    if (this.d != null) {
      this.d.a(-paramFloat);
    }
  }
  
  void a(final g.a parama, final boolean paramBoolean)
  {
    if ((this.m) || (this.k.getVisibility() != 0)) {
      if (parama != null) {
        parama.b();
      }
    }
    do
    {
      return;
      if ((af.A(this.k)) && (!this.k.isInEditMode())) {
        break;
      }
      this.k.a(8, paramBoolean);
    } while (parama == null);
    parama.b();
    return;
    this.k.animate().cancel();
    this.k.animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setDuration(200L).setInterpolator(a.c).setListener(new AnimatorListenerAdapter()
    {
      private boolean d;
      
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        f.a(f.this, false);
        this.d = true;
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        f.a(f.this, false);
        if (!this.d)
        {
          f.this.k.a(8, paramBoolean);
          if (parama != null) {
            parama.b();
          }
        }
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        f.a(f.this, true);
        this.d = false;
        f.this.k.a(0, paramBoolean);
      }
    });
  }
  
  void b(final g.a parama, final boolean paramBoolean)
  {
    if ((this.m) || (this.k.getVisibility() != 0))
    {
      if ((!af.A(this.k)) || (this.k.isInEditMode())) {
        break label127;
      }
      this.k.animate().cancel();
      if (this.k.getVisibility() != 0)
      {
        this.k.setAlpha(0.0F);
        this.k.setScaleY(0.0F);
        this.k.setScaleX(0.0F);
      }
      this.k.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(200L).setInterpolator(a.d).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (parama != null) {
            parama.a();
          }
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          f.this.k.a(0, paramBoolean);
        }
      });
    }
    label127:
    do
    {
      return;
      this.k.a(0, paramBoolean);
      this.k.setAlpha(1.0F);
      this.k.setScaleY(1.0F);
      this.k.setScaleX(1.0F);
    } while (parama == null);
    parama.a();
  }
  
  boolean d()
  {
    return true;
  }
  
  void e()
  {
    c(this.k.getRotation());
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/widget/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */