package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.j.af;
import android.support.v7.b.a.b;
import android.support.v7.b.a.k;
import android.support.v7.widget.ActionMenuView.a;
import android.support.v7.widget.ab;
import android.support.v7.widget.ak;
import android.support.v7.widget.ak.b;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView
  extends ab
  implements m.a, ActionMenuView.a, View.OnClickListener, View.OnLongClickListener
{
  private h a;
  private CharSequence b;
  private Drawable c;
  private f.b d;
  private ak.b e;
  private b f;
  private boolean g;
  private boolean h;
  private int i;
  private int j;
  private int k;
  
  public ActionMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = paramContext.getResources();
    this.g = localResources.getBoolean(a.b.abc_config_allowActionMenuItemTextWithIcon);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ActionMenuItemView, paramInt, 0);
    this.i = paramContext.getDimensionPixelSize(a.k.ActionMenuItemView_android_minWidth, 0);
    paramContext.recycle();
    this.k = ((int)(localResources.getDisplayMetrics().density * 32.0F + 0.5F));
    setOnClickListener(this);
    setOnLongClickListener(this);
    this.j = -1;
  }
  
  private void e()
  {
    int i1 = 0;
    int m;
    if (!TextUtils.isEmpty(this.b))
    {
      m = 1;
      if (this.c != null)
      {
        n = i1;
        if (!this.a.m()) {
          break label54;
        }
        if (!this.g)
        {
          n = i1;
          if (!this.h) {
            break label54;
          }
        }
      }
      int n = 1;
      label54:
      if ((m & n) == 0) {
        break label76;
      }
    }
    label76:
    for (CharSequence localCharSequence = this.b;; localCharSequence = null)
    {
      setText(localCharSequence);
      return;
      m = 0;
      break;
    }
  }
  
  public void a(h paramh, int paramInt)
  {
    this.a = paramh;
    setIcon(paramh.getIcon());
    setTitle(paramh.a(this));
    setId(paramh.getItemId());
    if (paramh.isVisible()) {}
    for (paramInt = 0;; paramInt = 8)
    {
      setVisibility(paramInt);
      setEnabled(paramh.isEnabled());
      if ((paramh.hasSubMenu()) && (this.e == null)) {
        this.e = new a();
      }
      return;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean b()
  {
    return !TextUtils.isEmpty(getText());
  }
  
  public boolean c()
  {
    return (b()) && (this.a.getIcon() == null);
  }
  
  public boolean d()
  {
    return b();
  }
  
  public h getItemData()
  {
    return this.a;
  }
  
  public void onClick(View paramView)
  {
    if (this.d != null) {
      this.d.a(this.a);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    this.g = getContext().getResources().getBoolean(a.b.abc_config_allowActionMenuItemTextWithIcon);
    e();
  }
  
  public boolean onLongClick(View paramView)
  {
    if (b()) {
      return false;
    }
    int[] arrayOfInt = new int[2];
    Rect localRect = new Rect();
    getLocationOnScreen(arrayOfInt);
    getWindowVisibleDisplayFrame(localRect);
    Context localContext = getContext();
    int m = getWidth();
    int i1 = getHeight();
    int i2 = arrayOfInt[1];
    int i3 = i1 / 2;
    int n = arrayOfInt[0];
    n = m / 2 + n;
    m = n;
    if (af.h(paramView) == 0) {
      m = localContext.getResources().getDisplayMetrics().widthPixels - n;
    }
    paramView = Toast.makeText(localContext, this.a.getTitle(), 0);
    if (i2 + i3 < localRect.height()) {
      paramView.setGravity(8388661, m, arrayOfInt[1] + i1 - localRect.top);
    }
    for (;;)
    {
      paramView.show();
      return true;
      paramView.setGravity(81, 0, i1);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool = b();
    if ((bool) && (this.j >= 0)) {
      super.setPadding(this.j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    super.onMeasure(paramInt1, paramInt2);
    int m = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int n = getMeasuredWidth();
    if (m == Integer.MIN_VALUE) {}
    for (paramInt1 = Math.min(paramInt1, this.i);; paramInt1 = this.i)
    {
      if ((m != 1073741824) && (this.i > 0) && (n < paramInt1)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
      }
      if ((!bool) && (this.c != null)) {
        super.setPadding((getMeasuredWidth() - this.c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      }
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.a.hasSubMenu()) && (this.e != null) && (this.e.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    if (this.h != paramBoolean)
    {
      this.h = paramBoolean;
      if (this.a != null) {
        this.a.h();
      }
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.c = paramDrawable;
    if (paramDrawable != null)
    {
      int i2 = paramDrawable.getIntrinsicWidth();
      int i1 = paramDrawable.getIntrinsicHeight();
      int n = i1;
      int m = i2;
      float f1;
      if (i2 > this.k)
      {
        f1 = this.k / i2;
        m = this.k;
        n = (int)(i1 * f1);
      }
      i2 = n;
      i1 = m;
      if (n > this.k)
      {
        f1 = this.k / n;
        i2 = this.k;
        i1 = (int)(m * f1);
      }
      paramDrawable.setBounds(0, 0, i1, i2);
    }
    setCompoundDrawables(paramDrawable, null, null, null);
    e();
  }
  
  public void setItemInvoker(f.b paramb)
  {
    this.d = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.j = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPopupCallback(b paramb)
  {
    this.f = paramb;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    setContentDescription(this.b);
    e();
  }
  
  private class a
    extends ak.b
  {
    public a()
    {
      super();
    }
    
    public ak a()
    {
      if (ActionMenuItemView.a(ActionMenuItemView.this) != null) {
        return ActionMenuItemView.a(ActionMenuItemView.this).a();
      }
      return null;
    }
    
    protected boolean b()
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (ActionMenuItemView.b(ActionMenuItemView.this) != null)
      {
        bool1 = bool2;
        if (ActionMenuItemView.b(ActionMenuItemView.this).a(ActionMenuItemView.c(ActionMenuItemView.this)))
        {
          ak localak = a();
          bool1 = bool2;
          if (localak != null)
          {
            bool1 = bool2;
            if (localak.k()) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
  }
  
  public static abstract class b
  {
    public abstract ak a();
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/view/menu/ActionMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */