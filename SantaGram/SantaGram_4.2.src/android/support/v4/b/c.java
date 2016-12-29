package android.support.v4.b;

import android.app.Activity;

class c
{
  public static void a(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    if ((paramActivity instanceof a)) {
      ((a)paramActivity).validateRequestPermissionsRequestCode(paramInt);
    }
    paramActivity.requestPermissions(paramArrayOfString, paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void validateRequestPermissionsRequestCode(int paramInt);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */