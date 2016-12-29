package android.support.v4.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class t
  implements Parcelable
{
  public static final Parcelable.Creator<t> CREATOR = new Parcelable.Creator()
  {
    public t a(Parcel paramAnonymousParcel)
    {
      return new t(paramAnonymousParcel);
    }
    
    public t[] a(int paramAnonymousInt)
    {
      return new t[paramAnonymousInt];
    }
  };
  u[] a;
  int[] b;
  i[] c;
  
  public t() {}
  
  public t(Parcel paramParcel)
  {
    this.a = ((u[])paramParcel.createTypedArray(u.CREATOR));
    this.b = paramParcel.createIntArray();
    this.c = ((i[])paramParcel.createTypedArray(i.CREATOR));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.a, paramInt);
    paramParcel.writeIntArray(this.b);
    paramParcel.writeTypedArray(this.c, paramInt);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/b/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */