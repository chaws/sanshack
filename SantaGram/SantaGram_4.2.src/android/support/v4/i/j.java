package android.support.v4.i;

public class j<E>
  implements Cloneable
{
  private static final Object a = new Object();
  private boolean b = false;
  private int[] c;
  private Object[] d;
  private int e;
  
  public j()
  {
    this(10);
  }
  
  public j(int paramInt)
  {
    if (paramInt == 0) {
      this.c = b.a;
    }
    for (this.d = b.c;; this.d = new Object[paramInt])
    {
      this.e = 0;
      return;
      paramInt = b.a(paramInt);
      this.c = new int[paramInt];
    }
  }
  
  private void d()
  {
    int m = this.e;
    int[] arrayOfInt = this.c;
    Object[] arrayOfObject = this.d;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != a)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.b = false;
    this.e = j;
  }
  
  public j<E> a()
  {
    try
    {
      j localj = (j)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        localj.c = ((int[])this.c.clone());
        localj.d = ((Object[])this.d.clone());
        return localj;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  public E a(int paramInt)
  {
    return (E)a(paramInt, null);
  }
  
  public E a(int paramInt, E paramE)
  {
    paramInt = b.a(this.c, this.e, paramInt);
    if ((paramInt < 0) || (this.d[paramInt] == a)) {
      return paramE;
    }
    return (E)this.d[paramInt];
  }
  
  public int b()
  {
    if (this.b) {
      d();
    }
    return this.e;
  }
  
  public void b(int paramInt)
  {
    paramInt = b.a(this.c, this.e, paramInt);
    if ((paramInt >= 0) && (this.d[paramInt] != a))
    {
      this.d[paramInt] = a;
      this.b = true;
    }
  }
  
  public void b(int paramInt, E paramE)
  {
    int i = b.a(this.c, this.e, paramInt);
    if (i >= 0)
    {
      this.d[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.e) && (this.d[j] == a))
    {
      this.c[j] = paramInt;
      this.d[j] = paramE;
      return;
    }
    i = j;
    if (this.b)
    {
      i = j;
      if (this.e >= this.c.length)
      {
        d();
        i = b.a(this.c, this.e, paramInt) ^ 0xFFFFFFFF;
      }
    }
    if (this.e >= this.c.length)
    {
      j = b.a(this.e + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.c, 0, arrayOfInt, 0, this.c.length);
      System.arraycopy(this.d, 0, arrayOfObject, 0, this.d.length);
      this.c = arrayOfInt;
      this.d = arrayOfObject;
    }
    if (this.e - i != 0)
    {
      System.arraycopy(this.c, i, this.c, i + 1, this.e - i);
      System.arraycopy(this.d, i, this.d, i + 1, this.e - i);
    }
    this.c[i] = paramInt;
    this.d[i] = paramE;
    this.e += 1;
  }
  
  public void c()
  {
    int j = this.e;
    Object[] arrayOfObject = this.d;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.e = 0;
    this.b = false;
  }
  
  public void c(int paramInt)
  {
    b(paramInt);
  }
  
  public int d(int paramInt)
  {
    if (this.b) {
      d();
    }
    return this.c[paramInt];
  }
  
  public E e(int paramInt)
  {
    if (this.b) {
      d();
    }
    return (E)this.d[paramInt];
  }
  
  public int f(int paramInt)
  {
    if (this.b) {
      d();
    }
    return b.a(this.c, this.e, paramInt);
  }
  
  public String toString()
  {
    if (b() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.e * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.e)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(d(i));
      localStringBuilder.append('=');
      Object localObject = e(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/i/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */