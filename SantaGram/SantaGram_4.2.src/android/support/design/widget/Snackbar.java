package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.a.a;
import android.support.design.a.c;
import android.support.design.a.d;
import android.support.design.a.e;
import android.support.design.a.g;
import android.support.v4.j.af;
import android.support.v4.j.av;
import android.support.v4.j.ba;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class Snackbar
{
  private static final Handler a = new Handler(Looper.getMainLooper(), new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return false;
      case 0: 
        ((Snackbar)paramAnonymousMessage.obj).b();
        return true;
      }
      ((Snackbar)paramAnonymousMessage.obj).a(paramAnonymousMessage.arg1);
      return true;
    }
  });
  private final ViewGroup b;
  private final SnackbarLayout c;
  private b d;
  private final AccessibilityManager e;
  private final n.a f;
  
  private void b(int paramInt)
  {
    n.a().a(this.f, paramInt);
  }
  
  private void c(final int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      af.q(this.c).c(this.c.getHeight()).a(a.b).a(250L).a(new ba()
      {
        public void a(View paramAnonymousView)
        {
          Snackbar.b(Snackbar.this).b(0, 180);
        }
        
        public void b(View paramAnonymousView)
        {
          Snackbar.b(Snackbar.this, paramInt);
        }
      }).c();
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.c.getContext(), a.a.design_snackbar_out);
    localAnimation.setInterpolator(a.b);
    localAnimation.setDuration(250L);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        Snackbar.b(Snackbar.this, paramInt);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.c.startAnimation(localAnimation);
  }
  
  private void d()
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      af.b(this.c, this.c.getHeight());
      af.q(this.c).c(0.0F).a(a.b).a(250L).a(new ba()
      {
        public void a(View paramAnonymousView)
        {
          Snackbar.b(Snackbar.this).a(70, 180);
        }
        
        public void b(View paramAnonymousView)
        {
          Snackbar.e(Snackbar.this);
        }
      }).c();
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.c.getContext(), a.a.design_snackbar_in);
    localAnimation.setInterpolator(a.b);
    localAnimation.setDuration(250L);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        Snackbar.e(Snackbar.this);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.c.startAnimation(localAnimation);
  }
  
  private void d(int paramInt)
  {
    n.a().a(this.f);
    if (this.d != null) {
      this.d.a(this, paramInt);
    }
    ViewParent localViewParent = this.c.getParent();
    if ((localViewParent instanceof ViewGroup)) {
      ((ViewGroup)localViewParent).removeView(this.c);
    }
  }
  
  private void e()
  {
    n.a().b(this.f);
    if (this.d != null) {
      this.d.a(this);
    }
  }
  
  private boolean f()
  {
    return !this.e.isEnabled();
  }
  
  final void a(int paramInt)
  {
    if ((f()) && (this.c.getVisibility() == 0))
    {
      c(paramInt);
      return;
    }
    d(paramInt);
  }
  
  public boolean a()
  {
    return n.a().e(this.f);
  }
  
  final void b()
  {
    if (this.c.getParent() == null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.c.getLayoutParams();
      if ((localLayoutParams instanceof CoordinatorLayout.e))
      {
        a locala = new a();
        locala.a(0.1F);
        locala.b(0.6F);
        locala.a(0);
        locala.a(new SwipeDismissBehavior.a()
        {
          public void a(int paramAnonymousInt)
          {
            switch (paramAnonymousInt)
            {
            default: 
              return;
            case 1: 
            case 2: 
              n.a().c(Snackbar.a(Snackbar.this));
              return;
            }
            n.a().d(Snackbar.a(Snackbar.this));
          }
          
          public void a(View paramAnonymousView)
          {
            paramAnonymousView.setVisibility(8);
            Snackbar.a(Snackbar.this, 0);
          }
        });
        ((CoordinatorLayout.e)localLayoutParams).a(locala);
      }
      this.b.addView(this.c);
    }
    this.c.setOnAttachStateChangeListener(new Snackbar.SnackbarLayout.a()
    {
      public void a(View paramAnonymousView) {}
      
      public void b(View paramAnonymousView)
      {
        if (Snackbar.this.a()) {
          Snackbar.c().post(new Runnable()
          {
            public void run()
            {
              Snackbar.b(Snackbar.this, 3);
            }
          });
        }
      }
    });
    if (af.A(this.c))
    {
      if (f())
      {
        d();
        return;
      }
      e();
      return;
    }
    this.c.setOnLayoutChangeListener(new Snackbar.SnackbarLayout.b()
    {
      public void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        Snackbar.b(Snackbar.this).setOnLayoutChangeListener(null);
        if (Snackbar.c(Snackbar.this))
        {
          Snackbar.d(Snackbar.this);
          return;
        }
        Snackbar.e(Snackbar.this);
      }
    });
  }
  
  public static class SnackbarLayout
    extends LinearLayout
  {
    private TextView a;
    private Button b;
    private int c;
    private int d;
    private b e;
    private a f;
    
    public SnackbarLayout(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public SnackbarLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.g.SnackbarLayout);
      this.c = paramAttributeSet.getDimensionPixelSize(a.g.SnackbarLayout_android_maxWidth, -1);
      this.d = paramAttributeSet.getDimensionPixelSize(a.g.SnackbarLayout_maxActionInlineWidth, -1);
      if (paramAttributeSet.hasValue(a.g.SnackbarLayout_elevation)) {
        af.d(this, paramAttributeSet.getDimensionPixelSize(a.g.SnackbarLayout_elevation, 0));
      }
      paramAttributeSet.recycle();
      setClickable(true);
      LayoutInflater.from(paramContext).inflate(a.e.design_layout_snackbar_include, this);
      af.d(this, 1);
      af.c(this, 1);
    }
    
    private static void a(View paramView, int paramInt1, int paramInt2)
    {
      if (af.w(paramView))
      {
        af.a(paramView, af.k(paramView), paramInt1, af.l(paramView), paramInt2);
        return;
      }
      paramView.setPadding(paramView.getPaddingLeft(), paramInt1, paramView.getPaddingRight(), paramInt2);
    }
    
    private boolean a(int paramInt1, int paramInt2, int paramInt3)
    {
      boolean bool = false;
      if (paramInt1 != getOrientation())
      {
        setOrientation(paramInt1);
        bool = true;
      }
      if ((this.a.getPaddingTop() != paramInt2) || (this.a.getPaddingBottom() != paramInt3))
      {
        a(this.a, paramInt2, paramInt3);
        bool = true;
      }
      return bool;
    }
    
    void a(int paramInt1, int paramInt2)
    {
      af.c(this.a, 0.0F);
      af.q(this.a).a(1.0F).a(paramInt2).b(paramInt1).c();
      if (this.b.getVisibility() == 0)
      {
        af.c(this.b, 0.0F);
        af.q(this.b).a(1.0F).a(paramInt2).b(paramInt1).c();
      }
    }
    
    void b(int paramInt1, int paramInt2)
    {
      af.c(this.a, 1.0F);
      af.q(this.a).a(0.0F).a(paramInt2).b(paramInt1).c();
      if (this.b.getVisibility() == 0)
      {
        af.c(this.b, 1.0F);
        af.q(this.b).a(0.0F).a(paramInt2).b(paramInt1).c();
      }
    }
    
    Button getActionView()
    {
      return this.b;
    }
    
    TextView getMessageView()
    {
      return this.a;
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      if (this.f != null) {
        this.f.a(this);
      }
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      if (this.f != null) {
        this.f.b(this);
      }
    }
    
    protected void onFinishInflate()
    {
      super.onFinishInflate();
      this.a = ((TextView)findViewById(a.d.snackbar_text));
      this.b = ((Button)findViewById(a.d.snackbar_action));
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.e != null) {
        this.e.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      int i = paramInt1;
      if (this.c > 0)
      {
        i = paramInt1;
        if (getMeasuredWidth() > this.c)
        {
          i = View.MeasureSpec.makeMeasureSpec(this.c, 1073741824);
          super.onMeasure(i, paramInt2);
        }
      }
      int j = getResources().getDimensionPixelSize(a.c.design_snackbar_padding_vertical_2lines);
      int k = getResources().getDimensionPixelSize(a.c.design_snackbar_padding_vertical);
      if (this.a.getLayout().getLineCount() > 1)
      {
        paramInt1 = 1;
        if ((paramInt1 == 0) || (this.d <= 0) || (this.b.getMeasuredWidth() <= this.d)) {
          break label142;
        }
        if (!a(1, j, j - k)) {
          break label170;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          super.onMeasure(i, paramInt2);
        }
        return;
        paramInt1 = 0;
        break;
        label142:
        if (paramInt1 != 0) {}
        for (paramInt1 = j;; paramInt1 = k)
        {
          if (!a(0, paramInt1, paramInt1)) {
            break label170;
          }
          paramInt1 = 1;
          break;
        }
        label170:
        paramInt1 = 0;
      }
    }
    
    void setOnAttachStateChangeListener(a parama)
    {
      this.f = parama;
    }
    
    void setOnLayoutChangeListener(b paramb)
    {
      this.e = paramb;
    }
    
    static abstract interface a
    {
      public abstract void a(View paramView);
      
      public abstract void b(View paramView);
    }
    
    static abstract interface b
    {
      public abstract void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    }
  }
  
  final class a
    extends SwipeDismissBehavior<Snackbar.SnackbarLayout>
  {
    a() {}
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, Snackbar.SnackbarLayout paramSnackbarLayout, MotionEvent paramMotionEvent)
    {
      if (paramCoordinatorLayout.a(paramSnackbarLayout, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        switch (paramMotionEvent.getActionMasked())
        {
        }
      }
      for (;;)
      {
        return super.a(paramCoordinatorLayout, paramSnackbarLayout, paramMotionEvent);
        n.a().c(Snackbar.a(Snackbar.this));
        continue;
        n.a().d(Snackbar.a(Snackbar.this));
      }
    }
    
    public boolean a(View paramView)
    {
      return paramView instanceof Snackbar.SnackbarLayout;
    }
  }
  
  public static abstract class b
  {
    public void a(Snackbar paramSnackbar) {}
    
    public void a(Snackbar paramSnackbar, int paramInt) {}
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/widget/Snackbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */