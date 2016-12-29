package android.support.v4.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class i
  implements Parcelable
{
  public static final Parcelable.Creator<i> CREATOR = new Parcelable.Creator()
  {
    public i a(Parcel paramAnonymousParcel)
    {
      return new i(paramAnonymousParcel);
    }
    
    public i[] a(int paramAnonymousInt)
    {
      return new i[paramAnonymousInt];
    }
  };
  final int[] a;
  final int b;
  final int c;
  final String d;
  final int e;
  final int f;
  final CharSequence g;
  final int h;
  final CharSequence i;
  final ArrayList<String> j;
  final ArrayList<String> k;
  
  public i(Parcel paramParcel)
  {
    this.a = paramParcel.createIntArray();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.h = paramParcel.readInt();
    this.i = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.j = paramParcel.createStringArrayList();
    this.k = paramParcel.createStringArrayList();
  }
  
  public i(h paramh)
  {
    h.a locala = paramh.c;
    int n;
    for (int m = 0; locala != null; m = n)
    {
      n = m;
      if (locala.i != null) {
        n = m + locala.i.size();
      }
      locala = locala.a;
    }
    this.a = new int[m + paramh.e * 7];
    if (!paramh.l) {
      throw new IllegalStateException("Not on back stack");
    }
    locala = paramh.c;
    m = 0;
    if (locala != null)
    {
      int[] arrayOfInt = this.a;
      n = m + 1;
      arrayOfInt[m] = locala.c;
      arrayOfInt = this.a;
      int i1 = n + 1;
      if (locala.d != null) {}
      for (m = locala.d.g;; m = -1)
      {
        arrayOfInt[n] = m;
        arrayOfInt = this.a;
        m = i1 + 1;
        arrayOfInt[i1] = locala.e;
        arrayOfInt = this.a;
        n = m + 1;
        arrayOfInt[m] = locala.f;
        arrayOfInt = this.a;
        m = n + 1;
        arrayOfInt[n] = locala.g;
        arrayOfInt = this.a;
        n = m + 1;
        arrayOfInt[m] = locala.h;
        if (locala.i == null) {
          break label318;
        }
        i1 = locala.i.size();
        arrayOfInt = this.a;
        m = n + 1;
        arrayOfInt[n] = i1;
        n = 0;
        while (n < i1)
        {
          this.a[m] = ((m)locala.i.get(n)).g;
          n += 1;
          m += 1;
        }
      }
      for (;;)
      {
        locala = locala.a;
        break;
        label318:
        arrayOfInt = this.a;
        m = n + 1;
        arrayOfInt[n] = 0;
      }
    }
    this.b = paramh.j;
    this.c = paramh.k;
    this.d = paramh.n;
    this.e = paramh.p;
    this.f = paramh.q;
    this.g = paramh.r;
    this.h = paramh.s;
    this.i = paramh.t;
    this.j = paramh.u;
    this.k = paramh.v;
  }
  
  public h a(s params)
  {
    h localh = new h(params);
    int i1 = 0;
    int m = 0;
    while (m < this.a.length)
    {
      h.a locala = new h.a();
      Object localObject = this.a;
      int n = m + 1;
      locala.c = localObject[m];
      if (s.a) {
        Log.v("FragmentManager", "Instantiate " + localh + " op #" + i1 + " base fragment #" + this.a[n]);
      }
      localObject = this.a;
      m = n + 1;
      n = localObject[n];
      if (n >= 0) {}
      for (locala.d = ((m)params.f.get(n));; locala.d = null)
      {
        localObject = this.a;
        n = m + 1;
        locala.e = localObject[m];
        localObject = this.a;
        m = n + 1;
        locala.f = localObject[n];
        localObject = this.a;
        n = m + 1;
        locala.g = localObject[m];
        localObject = this.a;
        m = n + 1;
        locala.h = localObject[n];
        localObject = this.a;
        n = m + 1;
        int i3 = localObject[m];
        m = n;
        if (i3 <= 0) {
          break;
        }
        locala.i = new ArrayList(i3);
        int i2 = 0;
        for (;;)
        {
          m = n;
          if (i2 >= i3) {
            break;
          }
          if (s.a) {
            Log.v("FragmentManager", "Instantiate " + localh + " set remove fragment #" + this.a[n]);
          }
          localObject = (m)params.f.get(this.a[n]);
          locala.i.add(localObject);
          i2 += 1;
          n += 1;
        }
      }
      localh.f = locala.e;
      localh.g = locala.f;
      localh.h = locala.g;
      localh.i = locala.h;
      localh.a(locala);
      i1 += 1;
    }
    localh.j = this.b;
    localh.k = this.c;
    localh.n = this.d;
    localh.p = this.e;
    localh.l = true;
    localh.q = this.f;
    localh.r = this.g;
    localh.s = this.h;
    localh.t = this.i;
    localh.u = this.j;
    localh.v = this.k;
    localh.a(1);
    return localh;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    TextUtils.writeToParcel(this.g, paramParcel, 0);
    paramParcel.writeInt(this.h);
    TextUtils.writeToParcel(this.i, paramParcel, 0);
    paramParcel.writeStringList(this.j);
    paramParcel.writeStringList(this.k);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */