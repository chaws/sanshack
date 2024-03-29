package android.support.v7.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.c.h;
import android.util.Log;
import java.util.Calendar;

class q
{
  private static final a a = new a(null);
  private final Context b;
  private final LocationManager c;
  
  q(Context paramContext)
  {
    this.b = paramContext;
    this.c = ((LocationManager)paramContext.getSystemService("location"));
  }
  
  private Location a(String paramString)
  {
    if (this.c != null) {
      try
      {
        if (this.c.isProviderEnabled(paramString))
        {
          paramString = this.c.getLastKnownLocation(paramString);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        Log.d("TwilightManager", "Failed to get last known location", paramString);
      }
    }
    return null;
  }
  
  private void a(Location paramLocation)
  {
    a locala = a;
    long l1 = System.currentTimeMillis();
    p localp = p.a();
    localp.a(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = localp.a;
    localp.a(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    if (localp.c == 1) {}
    long l3;
    long l4;
    long l5;
    for (boolean bool = true;; bool = false)
    {
      l3 = localp.b;
      l4 = localp.a;
      localp.a(86400000L + l1, paramLocation.getLatitude(), paramLocation.getLongitude());
      l5 = localp.b;
      if ((l3 != -1L) && (l4 != -1L)) {
        break;
      }
      l1 = 43200000L + l1;
      locala.a = bool;
      locala.b = l2;
      locala.c = l3;
      locala.d = l4;
      locala.e = l5;
      locala.f = l1;
      return;
    }
    if (l1 > l4) {
      l1 = 0L + l5;
    }
    for (;;)
    {
      l1 += 60000L;
      break;
      if (l1 > l3) {
        l1 = 0L + l4;
      } else {
        l1 = 0L + l3;
      }
    }
  }
  
  private boolean a(a parama)
  {
    return (parama != null) && (parama.f > System.currentTimeMillis());
  }
  
  private Location b()
  {
    Object localObject1 = null;
    if (h.a(this.b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {}
    for (Location localLocation = a("network");; localLocation = null)
    {
      if (h.a(this.b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
        localObject1 = a("gps");
      }
      if ((localObject1 != null) && (localLocation != null))
      {
        Object localObject2 = localLocation;
        if (((Location)localObject1).getTime() > localLocation.getTime()) {
          localObject2 = localObject1;
        }
        return (Location)localObject2;
      }
      if (localObject1 != null) {}
      for (;;)
      {
        return (Location)localObject1;
        localObject1 = localLocation;
      }
    }
  }
  
  boolean a()
  {
    a locala = a;
    if (a(locala)) {
      return locala.a;
    }
    Location localLocation = b();
    if (localLocation != null)
    {
      a(localLocation);
      return locala.a;
    }
    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
    int i = Calendar.getInstance().get(11);
    return (i < 6) || (i >= 22);
  }
  
  private static class a
  {
    boolean a;
    long b;
    long c;
    long d;
    long e;
    long f;
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */