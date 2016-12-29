package android.support.v4.g;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class c
{
  public static <T> Parcelable.Creator<T> a(d<T> paramd)
  {
    if (Build.VERSION.SDK_INT >= 13) {
      return f.a(paramd);
    }
    return new a(paramd);
  }
  
  static class a<T>
    implements Parcelable.Creator<T>
  {
    final d<T> a;
    
    public a(d<T> paramd)
    {
      this.a = paramd;
    }
    
    public T createFromParcel(Parcel paramParcel)
    {
      return (T)this.a.b(paramParcel, null);
    }
    
    public T[] newArray(int paramInt)
    {
      return this.a.b(paramInt);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */