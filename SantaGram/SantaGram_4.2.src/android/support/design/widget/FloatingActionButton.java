package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.a.c;
import android.support.v4.j.af;
import android.support.v7.widget.p;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

@CoordinatorLayout.c(a=Behavior.class)
public class FloatingActionButton
  extends y
{
  private ColorStateList a;
  private PorterDuff.Mode b;
  private int c;
  private int d;
  private int e;
  private boolean f;
  private final Rect g;
  private p h;
  private g i;
  
  private static int a(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (j)
    {
    case 0: 
    default: 
      return paramInt1;
    case -2147483648: 
      return Math.min(paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  private g.a a(final a parama)
  {
    if (parama == null) {
      return null;
    }
    new g.a()
    {
      public void a()
      {
        parama.a(FloatingActionButton.this);
      }
      
      public void b()
      {
        parama.b(FloatingActionButton.this);
      }
    };
  }
  
  private g a()
  {
    int j = Build.VERSION.SDK_INT;
    if (j >= 21) {
      return new h(this, new b(null));
    }
    if (j >= 14) {
      return new f(this, new b(null));
    }
    return new e(this, new b(null));
  }
  
  private void a(a parama, boolean paramBoolean)
  {
    getImpl().b(a(parama), paramBoolean);
  }
  
  private void b(a parama, boolean paramBoolean)
  {
    getImpl().a(a(parama), paramBoolean);
  }
  
  private g getImpl()
  {
    if (this.i == null) {
      this.i = a();
    }
    return this.i;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    getImpl().a(getDrawableState());
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return this.a;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return this.b;
  }
  
  public float getCompatElevation()
  {
    return getImpl().a();
  }
  
  public Drawable getContentBackground()
  {
    return getImpl().f();
  }
  
  final int getSizeDimension()
  {
    switch (this.d)
    {
    default: 
      return getResources().getDimensionPixelSize(a.c.design_fab_size_normal);
    }
    return getResources().getDimensionPixelSize(a.c.design_fab_size_mini);
  }
  
  public boolean getUseCompatPadding()
  {
    return this.f;
  }
  
  @TargetApi(11)
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    getImpl().b();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getImpl().h();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getImpl().i();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getSizeDimension();
    paramInt1 = Math.min(a(j, paramInt1), a(j, paramInt2));
    setMeasuredDimension(this.g.left + paramInt1 + this.g.right, paramInt1 + this.g.top + this.g.bottom);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.a != paramColorStateList)
    {
      this.a = paramColorStateList;
      getImpl().a(paramColorStateList);
    }
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.b != paramMode)
    {
      this.b = paramMode;
      getImpl().a(paramMode);
    }
  }
  
  public void setCompatElevation(float paramFloat)
  {
    getImpl().b(paramFloat);
  }
  
  public void setImageResource(int paramInt)
  {
    this.h.a(paramInt);
  }
  
  public void setRippleColor(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      getImpl().a(paramInt);
    }
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.f != paramBoolean)
    {
      this.f = paramBoolean;
      getImpl().c();
    }
  }
  
  public static class Behavior
    extends CoordinatorLayout.b<FloatingActionButton>
  {
    private static final boolean a;
    private q b;
    private float c;
    private Rect d;
    
    static
    {
      if (Build.VERSION.SDK_INT >= 11) {}
      for (boolean bool = true;; bool = false)
      {
        a = bool;
        return;
      }
    }
    
    private float a(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton)
    {
      float f = 0.0F;
      List localList = paramCoordinatorLayout.d(paramFloatingActionButton);
      int j = localList.size();
      int i = 0;
      if (i < j)
      {
        View localView = (View)localList.get(i);
        if ((!(localView instanceof Snackbar.SnackbarLayout)) || (!paramCoordinatorLayout.a(paramFloatingActionButton, localView))) {
          break label88;
        }
        f = Math.min(f, af.n(localView) - localView.getHeight());
      }
      label88:
      for (;;)
      {
        i += 1;
        break;
        return f;
      }
    }
    
    private boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
    {
      if (((CoordinatorLayout.e)paramFloatingActionButton.getLayoutParams()).a() != paramAppBarLayout.getId()) {
        return false;
      }
      if (paramFloatingActionButton.getUserSetVisibility() != 0) {
        return false;
      }
      if (this.d == null) {
        this.d = new Rect();
      }
      Rect localRect = this.d;
      t.b(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (localRect.bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        FloatingActionButton.a(paramFloatingActionButton, null, false);
      }
      for (;;)
      {
        return true;
        FloatingActionButton.b(paramFloatingActionButton, null, false);
      }
    }
    
    private void b(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton)
    {
      int j = 0;
      Rect localRect = FloatingActionButton.a(paramFloatingActionButton);
      CoordinatorLayout.e locale;
      int i;
      if ((localRect != null) && (localRect.centerX() > 0) && (localRect.centerY() > 0))
      {
        locale = (CoordinatorLayout.e)paramFloatingActionButton.getLayoutParams();
        if (paramFloatingActionButton.getRight() < paramCoordinatorLayout.getWidth() - locale.rightMargin) {
          break label94;
        }
        i = localRect.right;
      }
      for (;;)
      {
        if (paramFloatingActionButton.getBottom() >= paramCoordinatorLayout.getBottom() - locale.bottomMargin) {
          j = localRect.bottom;
        }
        for (;;)
        {
          paramFloatingActionButton.offsetTopAndBottom(j);
          paramFloatingActionButton.offsetLeftAndRight(i);
          return;
          label94:
          if (paramFloatingActionButton.getLeft() > locale.leftMargin) {
            break label138;
          }
          i = -localRect.left;
          break;
          if (paramFloatingActionButton.getTop() <= locale.topMargin) {
            j = -localRect.top;
          }
        }
        label138:
        i = 0;
      }
    }
    
    private void d(CoordinatorLayout paramCoordinatorLayout, final FloatingActionButton paramFloatingActionButton, View paramView)
    {
      float f1 = a(paramCoordinatorLayout, paramFloatingActionButton);
      if (this.c == f1) {
        return;
      }
      float f2 = af.n(paramFloatingActionButton);
      if ((this.b != null) && (this.b.b())) {
        this.b.e();
      }
      if ((paramFloatingActionButton.isShown()) && (Math.abs(f2 - f1) > paramFloatingActionButton.getHeight() * 0.667F))
      {
        if (this.b == null)
        {
          this.b = x.a();
          this.b.a(a.b);
          this.b.a(new q.a()
          {
            public void a(q paramAnonymousq)
            {
              af.b(paramFloatingActionButton, paramAnonymousq.d());
            }
          });
        }
        this.b.a(f2, f1);
        this.b.a();
      }
      for (;;)
      {
        this.c = f1;
        return;
        af.b(paramFloatingActionButton, f1);
      }
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, int paramInt)
    {
      List localList = paramCoordinatorLayout.d(paramFloatingActionButton);
      int j = localList.size();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          View localView = (View)localList.get(i);
          if ((!(localView instanceof AppBarLayout)) || (!a(paramCoordinatorLayout, (AppBarLayout)localView, paramFloatingActionButton))) {}
        }
        else
        {
          paramCoordinatorLayout.a(paramFloatingActionButton, paramInt);
          b(paramCoordinatorLayout, paramFloatingActionButton);
          return true;
        }
        i += 1;
      }
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      return (a) && ((paramView instanceof Snackbar.SnackbarLayout));
    }
    
    public boolean b(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      if ((paramView instanceof Snackbar.SnackbarLayout)) {
        d(paramCoordinatorLayout, paramFloatingActionButton, paramView);
      }
      for (;;)
      {
        return false;
        if ((paramView instanceof AppBarLayout)) {
          a(paramCoordinatorLayout, (AppBarLayout)paramView, paramFloatingActionButton);
        }
      }
    }
    
    public void c(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      if ((paramView instanceof Snackbar.SnackbarLayout)) {
        d(paramCoordinatorLayout, paramFloatingActionButton, paramView);
      }
    }
  }
  
  public static abstract class a
  {
    public void a(FloatingActionButton paramFloatingActionButton) {}
    
    public void b(FloatingActionButton paramFloatingActionButton) {}
  }
  
  private class b
    implements m
  {
    private b() {}
    
    public float a()
    {
      return FloatingActionButton.this.getSizeDimension() / 2.0F;
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      FloatingActionButton.a(FloatingActionButton.this).set(paramInt1, paramInt2, paramInt3, paramInt4);
      FloatingActionButton.this.setPadding(FloatingActionButton.b(FloatingActionButton.this) + paramInt1, FloatingActionButton.b(FloatingActionButton.this) + paramInt2, FloatingActionButton.b(FloatingActionButton.this) + paramInt3, FloatingActionButton.b(FloatingActionButton.this) + paramInt4);
    }
    
    public void a(Drawable paramDrawable)
    {
      FloatingActionButton.a(FloatingActionButton.this, paramDrawable);
    }
    
    public boolean b()
    {
      return FloatingActionButton.c(FloatingActionButton.this);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/widget/FloatingActionButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */