package com.northpolewonderland.santagram;

import android.app.ProgressDialog;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.a.e;
import android.widget.EditText;
import android.widget.ImageView;
import com.parse.ParseUser;

public class AddPost
  extends e
  implements LocationListener
{
  Location currentLocation;
  ParseUser curruser = ParseUser.getCurrentUser();
  LocationManager locationManager;
  a marshMallowPermission = new a(this);
  ProgressDialog pd;
  ImageView postImage;
  EditText postTxt;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968603);
    b.a(getApplicationContext(), getClass().getSimpleName());
  }
  
  public void onLocationChanged(Location paramLocation) {}
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/northpolewonderland/santagram/AddPost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */