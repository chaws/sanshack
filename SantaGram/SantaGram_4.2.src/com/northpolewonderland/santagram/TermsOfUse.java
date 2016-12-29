package com.northpolewonderland.santagram;

import android.os.Bundle;
import android.support.v7.a.a;
import android.support.v7.a.e;
import android.view.MenuItem;
import android.webkit.WebView;

public class TermsOfUse
  extends e
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968642);
    super.setRequestedOrientation(1);
    b.a(getApplicationContext(), getClass().getSimpleName());
    getSupportActionBar().a(true);
    getSupportActionBar().b(true);
    getSupportActionBar().a("Terms of Use");
    ((WebView)findViewById(2131558632)).loadUrl("file:///android_asset/tou.html");
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    finish();
    return true;
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/northpolewonderland/santagram/TermsOfUse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */