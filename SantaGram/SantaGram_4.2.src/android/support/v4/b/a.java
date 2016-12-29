package android.support.v4.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

public class a
  extends android.support.v4.c.a
{
  private static b.a a(ac paramac)
  {
    b localb = null;
    if (paramac != null) {
      localb = new b(paramac);
    }
    return localb;
  }
  
  public static void a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      e.a(paramActivity);
      return;
    }
    paramActivity.finish();
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      e.a(paramActivity, paramIntent, paramInt, paramBundle);
      return;
    }
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, ac paramac)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      b.a(paramActivity, a(paramac));
    }
  }
  
  public static void a(final Activity paramActivity, String[] paramArrayOfString, final int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      c.a(paramActivity, paramArrayOfString, paramInt);
    }
    while (!(paramActivity instanceof a)) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        int[] arrayOfInt = new int[this.a.length];
        PackageManager localPackageManager = paramActivity.getPackageManager();
        String str = paramActivity.getPackageName();
        int j = this.a.length;
        int i = 0;
        while (i < j)
        {
          arrayOfInt[i] = localPackageManager.checkPermission(this.a[i], str);
          i += 1;
        }
        ((a.a)paramActivity).onRequestPermissionsResult(paramInt, this.a, arrayOfInt);
      }
    });
  }
  
  public static void b(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      b.a(paramActivity);
      return;
    }
    paramActivity.finish();
  }
  
  public static void b(Activity paramActivity, ac paramac)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      b.b(paramActivity, a(paramac));
    }
  }
  
  public static void c(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      b.b(paramActivity);
    }
  }
  
  public static void d(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      b.c(paramActivity);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  }
  
  private static class b
    extends b.a
  {
    private ac a;
    
    public b(ac paramac)
    {
      this.a = paramac;
    }
    
    public Parcelable a(View paramView, Matrix paramMatrix, RectF paramRectF)
    {
      return this.a.a(paramView, paramMatrix, paramRectF);
    }
    
    public View a(Context paramContext, Parcelable paramParcelable)
    {
      return this.a.a(paramContext, paramParcelable);
    }
    
    public void a(List<View> paramList)
    {
      this.a.a(paramList);
    }
    
    public void a(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      this.a.a(paramList, paramList1, paramList2);
    }
    
    public void a(List<String> paramList, Map<String, View> paramMap)
    {
      this.a.a(paramList, paramMap);
    }
    
    public void b(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      this.a.b(paramList, paramList1, paramList2);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */