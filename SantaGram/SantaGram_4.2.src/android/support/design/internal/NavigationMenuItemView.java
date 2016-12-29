package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.a.b;
import android.support.design.a.c;
import android.support.design.a.d;
import android.support.design.a.e;
import android.support.v4.widget.x;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.m.a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView
  extends a
  implements m.a
{
  private static final int[] c = { 16842912 };
  private final int d;
  private final CheckedTextView e;
  private FrameLayout f;
  private h g;
  private ColorStateList h;
  
  public NavigationMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(a.e.design_navigation_menu_item, this, true);
    this.d = paramContext.getResources().getDimensionPixelSize(a.c.design_navigation_icon_size);
    this.e = ((CheckedTextView)findViewById(a.d.design_menu_item_text));
    this.e.setDuplicateParentStateEnabled(true);
  }
  
  private StateListDrawable b()
  {
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(a.b.colorControlHighlight, localTypedValue, true))
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(c, new ColorDrawable(localTypedValue.data));
      localStateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
      return localStateListDrawable;
    }
    return null;
  }
  
  private void setActionView(View paramView)
  {
    if (this.f == null) {
      this.f = ((FrameLayout)((ViewStub)findViewById(a.d.design_menu_item_action_area_stub)).inflate());
    }
    this.f.removeAllViews();
    if (paramView != null) {
      this.f.addView(paramView);
    }
  }
  
  public void a(h paramh, int paramInt)
  {
    this.g = paramh;
    if (paramh.isVisible()) {}
    for (paramInt = 0;; paramInt = 8)
    {
      setVisibility(paramInt);
      if (getBackground() == null) {
        setBackgroundDrawable(b());
      }
      setCheckable(paramh.isCheckable());
      setChecked(paramh.isChecked());
      setEnabled(paramh.isEnabled());
      setTitle(paramh.getTitle());
      setIcon(paramh.getIcon());
      setActionView(paramh.getActionView());
      return;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public h getItemData()
  {
    return this.g;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.g != null) && (this.g.isCheckable()) && (this.g.isChecked())) {
      mergeDrawableStates(arrayOfInt, c);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    this.e.setChecked(paramBoolean);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable.getConstantState();
      if (localObject != null) {
        break label57;
      }
    }
    for (;;)
    {
      localObject = android.support.v4.d.a.a.f(paramDrawable).mutate();
      ((Drawable)localObject).setBounds(0, 0, this.d, this.d);
      android.support.v4.d.a.a.a((Drawable)localObject, this.h);
      x.a(this.e, (Drawable)localObject, null, null, null);
      return;
      label57:
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
    }
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    this.h = paramColorStateList;
    if (this.g != null) {
      setIcon(this.g.getIcon());
    }
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.e.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.e.setText(paramCharSequence);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/design/internal/NavigationMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */