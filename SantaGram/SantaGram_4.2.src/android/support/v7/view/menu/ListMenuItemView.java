package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a.f;
import android.support.v7.b.a.h;
import android.support.v7.b.a.k;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView
  extends LinearLayout
  implements m.a
{
  private h a;
  private ImageView b;
  private RadioButton c;
  private TextView d;
  private CheckBox e;
  private TextView f;
  private Drawable g;
  private int h;
  private Context i;
  private boolean j;
  private int k;
  private Context l;
  private LayoutInflater m;
  private boolean n;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.l = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MenuView, paramInt, 0);
    this.g = paramAttributeSet.getDrawable(a.k.MenuView_android_itemBackground);
    this.h = paramAttributeSet.getResourceId(a.k.MenuView_android_itemTextAppearance, -1);
    this.j = paramAttributeSet.getBoolean(a.k.MenuView_preserveIconSpacing, false);
    this.i = paramContext;
    paramAttributeSet.recycle();
  }
  
  private void b()
  {
    this.b = ((ImageView)getInflater().inflate(a.h.abc_list_menu_item_icon, this, false));
    addView(this.b, 0);
  }
  
  private void c()
  {
    this.c = ((RadioButton)getInflater().inflate(a.h.abc_list_menu_item_radio, this, false));
    addView(this.c);
  }
  
  private void d()
  {
    this.e = ((CheckBox)getInflater().inflate(a.h.abc_list_menu_item_checkbox, this, false));
    addView(this.e);
  }
  
  private LayoutInflater getInflater()
  {
    if (this.m == null) {
      this.m = LayoutInflater.from(this.l);
    }
    return this.m;
  }
  
  public void a(h paramh, int paramInt)
  {
    this.a = paramh;
    this.k = paramInt;
    if (paramh.isVisible()) {}
    for (paramInt = 0;; paramInt = 8)
    {
      setVisibility(paramInt);
      setTitle(paramh.a(this));
      setCheckable(paramh.isCheckable());
      a(paramh.f(), paramh.d());
      setIcon(paramh.getIcon());
      setEnabled(paramh.isEnabled());
      return;
    }
  }
  
  public void a(boolean paramBoolean, char paramChar)
  {
    if ((paramBoolean) && (this.a.f())) {}
    for (paramChar = '\000';; paramChar = '\b')
    {
      if (paramChar == 0) {
        this.f.setText(this.a.e());
      }
      if (this.f.getVisibility() != paramChar) {
        this.f.setVisibility(paramChar);
      }
      return;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public h getItemData()
  {
    return this.a;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setBackgroundDrawable(this.g);
    this.d = ((TextView)findViewById(a.f.title));
    if (this.h != -1) {
      this.d.setTextAppearance(this.i, this.h);
    }
    this.f = ((TextView)findViewById(a.f.shortcut));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.b != null) && (this.j))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = localLayoutParams.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.c == null) && (this.e == null)) {}
    label50:
    label131:
    label138:
    do
    {
      return;
      Object localObject1;
      Object localObject2;
      if (this.a.g())
      {
        if (this.c == null) {
          c();
        }
        localObject1 = this.c;
        localObject2 = this.e;
        if (!paramBoolean) {
          break label138;
        }
        ((CompoundButton)localObject1).setChecked(this.a.isChecked());
        if (!paramBoolean) {
          break label131;
        }
      }
      for (int i1 = 0;; i1 = 8)
      {
        if (((CompoundButton)localObject1).getVisibility() != i1) {
          ((CompoundButton)localObject1).setVisibility(i1);
        }
        if ((localObject2 == null) || (((CompoundButton)localObject2).getVisibility() == 8)) {
          break;
        }
        ((CompoundButton)localObject2).setVisibility(8);
        return;
        if (this.e == null) {
          d();
        }
        localObject1 = this.e;
        localObject2 = this.c;
        break label50;
      }
      if (this.e != null) {
        this.e.setVisibility(8);
      }
    } while (this.c == null);
    this.c.setVisibility(8);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.a.g()) {
      if (this.c == null) {
        c();
      }
    }
    for (Object localObject = this.c;; localObject = this.e)
    {
      ((CompoundButton)localObject).setChecked(paramBoolean);
      return;
      if (this.e == null) {
        d();
      }
    }
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.n = paramBoolean;
    this.j = paramBoolean;
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i1;
    if ((this.a.i()) || (this.n))
    {
      i1 = 1;
      if ((i1 != 0) || (this.j)) {
        break label36;
      }
    }
    label36:
    while ((this.b == null) && (paramDrawable == null) && (!this.j))
    {
      return;
      i1 = 0;
      break;
    }
    if (this.b == null) {
      b();
    }
    if ((paramDrawable != null) || (this.j))
    {
      ImageView localImageView = this.b;
      if (i1 != 0) {}
      for (;;)
      {
        localImageView.setImageDrawable(paramDrawable);
        if (this.b.getVisibility() == 0) {
          break;
        }
        this.b.setVisibility(0);
        return;
        paramDrawable = null;
      }
    }
    this.b.setVisibility(8);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.d.setText(paramCharSequence);
      if (this.d.getVisibility() != 0) {
        this.d.setVisibility(0);
      }
    }
    while (this.d.getVisibility() == 8) {
      return;
    }
    this.d.setVisibility(8);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/view/menu/ListMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */