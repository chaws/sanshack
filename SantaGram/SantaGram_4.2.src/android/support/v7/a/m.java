package android.support.v7.a;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.support.v7.b.a.a;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class m
  extends Dialog
  implements f
{
  private g a;
  
  public m(Context paramContext, int paramInt)
  {
    super(paramContext, a(paramContext, paramInt));
    a().a(null);
    a().i();
  }
  
  private static int a(Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
    {
      TypedValue localTypedValue = new TypedValue();
      paramContext.getTheme().resolveAttribute(a.a.dialogTheme, localTypedValue, true);
      i = localTypedValue.resourceId;
    }
    return i;
  }
  
  public g a()
  {
    if (this.a == null) {
      this.a = g.a(this, this);
    }
    return this.a;
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a().b(paramView, paramLayoutParams);
  }
  
  public boolean b(int paramInt)
  {
    return a().c(paramInt);
  }
  
  public View findViewById(int paramInt)
  {
    return a().a(paramInt);
  }
  
  public void invalidateOptionsMenu()
  {
    a().e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    a().h();
    super.onCreate(paramBundle);
    a().a(paramBundle);
  }
  
  protected void onStop()
  {
    super.onStop();
    a().c();
  }
  
  public void onSupportActionModeFinished(b paramb) {}
  
  public void onSupportActionModeStarted(b paramb) {}
  
  public b onWindowStartingSupportActionMode(b.a parama)
  {
    return null;
  }
  
  public void setContentView(int paramInt)
  {
    a().b(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    a().a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a().a(paramView, paramLayoutParams);
  }
  
  public void setTitle(int paramInt)
  {
    super.setTitle(paramInt);
    a().a(getContext().getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    a().a(paramCharSequence);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */