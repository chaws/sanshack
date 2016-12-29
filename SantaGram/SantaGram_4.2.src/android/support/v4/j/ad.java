package android.support.v4.j;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public final class ad
{
  static final c a = new a();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new b();
      return;
    }
  }
  
  public static float a(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return a.a(paramVelocityTracker, paramInt);
  }
  
  public static float b(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return a.b(paramVelocityTracker, paramInt);
  }
  
  static class a
    implements ad.c
  {
    public float a(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return paramVelocityTracker.getXVelocity();
    }
    
    public float b(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return paramVelocityTracker.getYVelocity();
    }
  }
  
  static class b
    implements ad.c
  {
    public float a(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return ae.a(paramVelocityTracker, paramInt);
    }
    
    public float b(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return ae.b(paramVelocityTracker, paramInt);
    }
  }
  
  static abstract interface c
  {
    public abstract float a(VelocityTracker paramVelocityTracker, int paramInt);
    
    public abstract float b(VelocityTracker paramVelocityTracker, int paramInt);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/j/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */