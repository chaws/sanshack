package android.support.v4.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

class e
{
  public static void a(Activity paramActivity)
  {
    paramActivity.finishAffinity();
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */