package android.support.v7.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.b.a.a;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

public class d
  extends m
  implements DialogInterface
{
  private c a = new c(getContext(), this, getWindow());
  
  d(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, a(paramContext, paramInt));
  }
  
  static int a(Context paramContext, int paramInt)
  {
    if (paramInt >= 16777216) {
      return paramInt;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(a.a.alertDialogTheme, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  public void a(int paramInt)
  {
    this.a.b(paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a.a();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a.a(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a.b(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.a.a(paramCharSequence);
  }
  
  public static class a
  {
    private final c.a a;
    private int b;
    
    public a(Context paramContext)
    {
      this(paramContext, d.a(paramContext, 0));
    }
    
    public a(Context paramContext, int paramInt)
    {
      this.a = new c.a(new ContextThemeWrapper(paramContext, d.a(paramContext, paramInt)));
      this.b = paramInt;
    }
    
    public Context a()
    {
      return this.a.a;
    }
    
    public a a(int paramInt)
    {
      this.a.f = this.a.a.getText(paramInt);
      return this;
    }
    
    public a a(DialogInterface.OnKeyListener paramOnKeyListener)
    {
      this.a.r = paramOnKeyListener;
      return this;
    }
    
    public a a(Drawable paramDrawable)
    {
      this.a.d = paramDrawable;
      return this;
    }
    
    public a a(View paramView)
    {
      this.a.g = paramView;
      return this;
    }
    
    public a a(ListAdapter paramListAdapter, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.t = paramListAdapter;
      this.a.u = paramOnClickListener;
      return this;
    }
    
    public a a(CharSequence paramCharSequence)
    {
      this.a.f = paramCharSequence;
      return this;
    }
    
    public a a(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.i = paramCharSequence;
      this.a.j = paramOnClickListener;
      return this;
    }
    
    public a b(int paramInt)
    {
      this.a.c = paramInt;
      return this;
    }
    
    public a b(View paramView)
    {
      this.a.w = paramView;
      this.a.v = 0;
      this.a.B = false;
      return this;
    }
    
    public a b(CharSequence paramCharSequence)
    {
      this.a.h = paramCharSequence;
      return this;
    }
    
    public a b(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.k = paramCharSequence;
      this.a.l = paramOnClickListener;
      return this;
    }
    
    public d b()
    {
      d locald = new d(this.a.a, this.b, false);
      this.a.a(d.a(locald));
      locald.setCancelable(this.a.o);
      if (this.a.o) {
        locald.setCanceledOnTouchOutside(true);
      }
      locald.setOnCancelListener(this.a.p);
      locald.setOnDismissListener(this.a.q);
      if (this.a.r != null) {
        locald.setOnKeyListener(this.a.r);
      }
      return locald;
    }
    
    public d c()
    {
      d locald = b();
      locald.show();
      return locald;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */