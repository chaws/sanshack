package com.parse;

import a.g;
import a.j;
import a.k;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class LocationNotifier
{
  private static Location fakeLocation = null;
  
  static j<Location> getCurrentLocationAsync(final Context paramContext, long paramLong, Criteria paramCriteria)
  {
    final k localk = new k();
    g localg = new g();
    paramContext = (LocationManager)paramContext.getSystemService("location");
    final LocationListener local1 = new LocationListener()
    {
      public void onLocationChanged(Location paramAnonymousLocation)
      {
        if (paramAnonymousLocation == null) {
          return;
        }
        ((ScheduledFuture)this.val$timeoutFuture.a()).cancel(true);
        localk.a(paramAnonymousLocation);
        paramContext.removeUpdates(this);
      }
      
      public void onProviderDisabled(String paramAnonymousString) {}
      
      public void onProviderEnabled(String paramAnonymousString) {}
      
      public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle) {}
    };
    localg.a(ParseExecutors.scheduled().schedule(new Runnable()
    {
      public void run()
      {
        this.val$tcs.a(new ParseException(124, "Location fetch timed out."));
        paramContext.removeUpdates(local1);
      }
    }, paramLong, TimeUnit.MILLISECONDS));
    paramCriteria = paramContext.getBestProvider(paramCriteria, true);
    if (paramCriteria != null) {
      paramContext.requestLocationUpdates(paramCriteria, 0L, 0.0F, local1);
    }
    if (fakeLocation != null) {
      local1.onLocationChanged(fakeLocation);
    }
    return localk.a();
  }
  
  static void setFakeLocation(Location paramLocation)
  {
    fakeLocation = paramLocation;
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/LocationNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */