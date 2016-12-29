package android.support.v4.g;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class e<T>
  implements Parcelable.ClassLoaderCreator<T>
{
  private final d<T> a;
  
  public e(d<T> paramd)
  {
    this.a = paramd;
  }
  
  public T createFromParcel(Parcel paramParcel)
  {
    return (T)this.a.b(paramParcel, null);
  }
  
  public T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return (T)this.a.b(paramParcel, paramClassLoader);
  }
  
  public T[] newArray(int paramInt)
  {
    return this.a.b(paramInt);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/g/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */