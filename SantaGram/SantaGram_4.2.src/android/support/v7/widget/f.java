package android.support.v7.widget;

import android.support.v4.i.h.a;
import android.support.v4.i.h.b;
import java.util.ArrayList;
import java.util.List;

class f
  implements am.a
{
  final ArrayList<b> a = new ArrayList();
  final ArrayList<b> b = new ArrayList();
  final a c;
  Runnable d;
  final boolean e;
  final am f;
  private h.a<b> g = new h.b(30);
  private int h = 0;
  
  f(a parama)
  {
    this(parama, false);
  }
  
  f(a parama, boolean paramBoolean)
  {
    this.c = parama;
    this.e = paramBoolean;
    this.f = new am(this);
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    int j = this.b.size() - 1;
    b localb;
    if (j >= 0)
    {
      localb = (b)this.b.get(j);
      int k;
      int i;
      if (localb.a == 8) {
        if (localb.b < localb.d)
        {
          k = localb.b;
          i = localb.d;
          label61:
          if ((paramInt1 < k) || (paramInt1 > i)) {
            break label189;
          }
          if (k != localb.b) {
            break label149;
          }
          if (paramInt2 != 1) {
            break label131;
          }
          localb.d += 1;
          label97:
          paramInt1 += 1;
          label101:
          i = paramInt1;
        }
      }
      for (;;)
      {
        j -= 1;
        paramInt1 = i;
        break;
        k = localb.d;
        i = localb.b;
        break label61;
        label131:
        if (paramInt2 != 2) {
          break label97;
        }
        localb.d -= 1;
        break label97;
        label149:
        if (paramInt2 == 1) {
          localb.b += 1;
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          if (paramInt2 == 2) {
            localb.b -= 1;
          }
        }
        label189:
        if (paramInt1 < localb.b)
        {
          if (paramInt2 == 1)
          {
            localb.b += 1;
            localb.d += 1;
            break label101;
          }
          if (paramInt2 == 2)
          {
            localb.b -= 1;
            localb.d -= 1;
          }
        }
        break label101;
        if (localb.b <= paramInt1)
        {
          if (localb.a == 1)
          {
            i = paramInt1 - localb.d;
          }
          else
          {
            i = paramInt1;
            if (localb.a == 2) {
              i = paramInt1 + localb.d;
            }
          }
        }
        else if (paramInt2 == 1)
        {
          localb.b += 1;
          i = paramInt1;
        }
        else
        {
          i = paramInt1;
          if (paramInt2 == 2)
          {
            localb.b -= 1;
            i = paramInt1;
          }
        }
      }
    }
    paramInt2 = this.b.size() - 1;
    if (paramInt2 >= 0)
    {
      localb = (b)this.b.get(paramInt2);
      if (localb.a == 8) {
        if ((localb.d == localb.b) || (localb.d < 0))
        {
          this.b.remove(paramInt2);
          a(localb);
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        if (localb.d <= 0)
        {
          this.b.remove(paramInt2);
          a(localb);
        }
      }
    }
    return paramInt1;
  }
  
  private void b(b paramb)
  {
    g(paramb);
  }
  
  private void c(b paramb)
  {
    int i2 = paramb.b;
    int k = paramb.b + paramb.d;
    int j = -1;
    int i = paramb.b;
    int n = 0;
    if (i < k) {
      if ((this.c.a(i) != null) || (d(i)))
      {
        if (j != 0) {
          break label221;
        }
        e(a(2, i2, n, null));
      }
    }
    label100:
    label215:
    label221:
    for (int m = 1;; m = 0)
    {
      j = 1;
      if (m != 0)
      {
        m = i - n;
        i = k - n;
        k = 1;
        n = k;
        k = i;
        i = m + 1;
        break;
        if (j != 1) {
          break label215;
        }
        g(a(2, i2, n, null));
      }
      for (j = 1;; j = 0)
      {
        int i1 = 0;
        m = j;
        j = i1;
        break;
        n += 1;
        m = i;
        i = k;
        k = n;
        break label100;
        b localb = paramb;
        if (n != paramb.d)
        {
          a(paramb);
          localb = a(2, i2, n, null);
        }
        if (j == 0)
        {
          e(localb);
          return;
        }
        g(localb);
        return;
      }
    }
  }
  
  private void d(b paramb)
  {
    int k = paramb.b;
    int i2 = paramb.b;
    int i3 = paramb.d;
    int i = paramb.b;
    int i1 = -1;
    int j = 0;
    if (i < i2 + i3)
    {
      int m;
      int n;
      if ((this.c.a(i) != null) || (d(i)))
      {
        m = j;
        n = k;
        if (i1 == 0)
        {
          e(a(4, k, j, paramb.c));
          m = 0;
          n = i;
        }
        k = n;
      }
      for (j = 1;; j = 0)
      {
        i += 1;
        m += 1;
        i1 = j;
        j = m;
        break;
        m = j;
        n = k;
        if (i1 == 1)
        {
          g(a(4, k, j, paramb.c));
          m = 0;
          n = i;
        }
        k = n;
      }
    }
    Object localObject = paramb;
    if (j != paramb.d)
    {
      localObject = paramb.c;
      a(paramb);
      localObject = a(4, k, j, localObject);
    }
    if (i1 == 0)
    {
      e((b)localObject);
      return;
    }
    g((b)localObject);
  }
  
  private boolean d(int paramInt)
  {
    int k = this.b.size();
    int i = 0;
    while (i < k)
    {
      b localb = (b)this.b.get(i);
      if (localb.a == 8)
      {
        if (a(localb.d, i + 1) == paramInt) {
          return true;
        }
      }
      else if (localb.a == 1)
      {
        int m = localb.b;
        int n = localb.d;
        int j = localb.b;
        while (j < m + n)
        {
          if (a(j, i + 1) == paramInt) {
            return true;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void e(b paramb)
  {
    if ((paramb.a == 1) || (paramb.a == 8)) {
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
    int i1 = b(paramb.b, paramb.a);
    int j = paramb.b;
    int k;
    int n;
    int m;
    label112:
    int i2;
    switch (paramb.a)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("op should be remove or update." + paramb);
    case 4: 
      k = 1;
      n = 1;
      m = 1;
      if (m >= paramb.d) {
        break label299;
      }
      i2 = b(paramb.b + k * m, paramb.a);
      switch (paramb.a)
      {
      case 3: 
      default: 
        i = 0;
        label174:
        if (i == 0) {}
        break;
      }
      break;
    }
    for (int i = n + 1;; i = n)
    {
      m += 1;
      n = i;
      break label112;
      k = 0;
      break;
      if (i2 == i1 + 1)
      {
        i = 1;
        break label174;
      }
      i = 0;
      break label174;
      if (i2 == i1)
      {
        i = 1;
        break label174;
      }
      i = 0;
      break label174;
      localObject = a(paramb.a, i1, n, paramb.c);
      a((b)localObject, j);
      a((b)localObject);
      i = j;
      if (paramb.a == 4) {
        i = j + n;
      }
      n = 1;
      i1 = i2;
      j = i;
    }
    label299:
    Object localObject = paramb.c;
    a(paramb);
    if (n > 0)
    {
      paramb = a(paramb.a, i1, n, localObject);
      a(paramb, j);
      a(paramb);
    }
  }
  
  private void f(b paramb)
  {
    g(paramb);
  }
  
  private void g(b paramb)
  {
    this.b.add(paramb);
    switch (paramb.a)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("Unknown update op type for " + paramb);
    case 1: 
      this.c.c(paramb.b, paramb.d);
      return;
    case 8: 
      this.c.d(paramb.b, paramb.d);
      return;
    case 2: 
      this.c.b(paramb.b, paramb.d);
      return;
    }
    this.c.a(paramb.b, paramb.d, paramb.c);
  }
  
  int a(int paramInt1, int paramInt2)
  {
    int k = this.b.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = paramInt2;
    b localb;
    if (j < k)
    {
      localb = (b)this.b.get(j);
      if (localb.a == 8) {
        if (localb.b == paramInt2) {
          paramInt1 = localb.d;
        }
      }
    }
    for (;;)
    {
      j += 1;
      paramInt2 = paramInt1;
      break;
      int i = paramInt2;
      if (localb.b < paramInt2) {
        i = paramInt2 - 1;
      }
      paramInt1 = i;
      if (localb.d <= i)
      {
        paramInt1 = i + 1;
        continue;
        paramInt1 = paramInt2;
        if (localb.b <= paramInt2) {
          if (localb.a == 2)
          {
            if (paramInt2 < localb.b + localb.d)
            {
              paramInt1 = -1;
              return paramInt1;
            }
            paramInt1 = paramInt2 - localb.d;
          }
          else
          {
            paramInt1 = paramInt2;
            if (localb.a == 1) {
              paramInt1 = paramInt2 + localb.d;
            }
          }
        }
      }
    }
  }
  
  public b a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    b localb = (b)this.g.a();
    if (localb == null) {
      return new b(paramInt1, paramInt2, paramInt3, paramObject);
    }
    localb.a = paramInt1;
    localb.b = paramInt2;
    localb.d = paramInt3;
    localb.c = paramObject;
    return localb;
  }
  
  void a()
  {
    a(this.a);
    a(this.b);
    this.h = 0;
  }
  
  public void a(b paramb)
  {
    if (!this.e)
    {
      paramb.c = null;
      this.g.a(paramb);
    }
  }
  
  void a(b paramb, int paramInt)
  {
    this.c.a(paramb);
    switch (paramb.a)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 2: 
      this.c.a(paramInt, paramb.d);
      return;
    }
    this.c.a(paramInt, paramb.d, paramb.c);
  }
  
  void a(List<b> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a((b)paramList.get(i));
      i += 1;
    }
    paramList.clear();
  }
  
  boolean a(int paramInt)
  {
    return (this.h & paramInt) != 0;
  }
  
  int b(int paramInt)
  {
    return a(paramInt, 0);
  }
  
  void b()
  {
    this.f.a(this.a);
    int j = this.a.size();
    int i = 0;
    if (i < j)
    {
      b localb = (b)this.a.get(i);
      switch (localb.a)
      {
      }
      for (;;)
      {
        if (this.d != null) {
          this.d.run();
        }
        i += 1;
        break;
        f(localb);
        continue;
        c(localb);
        continue;
        d(localb);
        continue;
        b(localb);
      }
    }
    this.a.clear();
  }
  
  public int c(int paramInt)
  {
    int m = this.a.size();
    int k = 0;
    int i = paramInt;
    paramInt = i;
    b localb;
    if (k < m)
    {
      localb = (b)this.a.get(k);
      switch (localb.a)
      {
      default: 
        paramInt = i;
      }
    }
    for (;;)
    {
      k += 1;
      i = paramInt;
      break;
      paramInt = i;
      if (localb.b <= i)
      {
        paramInt = i + localb.d;
        continue;
        paramInt = i;
        if (localb.b <= i)
        {
          if (localb.b + localb.d > i)
          {
            paramInt = -1;
            return paramInt;
          }
          paramInt = i - localb.d;
          continue;
          if (localb.b == i)
          {
            paramInt = localb.d;
          }
          else
          {
            int j = i;
            if (localb.b < i) {
              j = i - 1;
            }
            paramInt = j;
            if (localb.d <= j) {
              paramInt = j + 1;
            }
          }
        }
      }
    }
  }
  
  void c()
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      this.c.b((b)this.b.get(i));
      i += 1;
    }
    a(this.b);
    this.h = 0;
  }
  
  boolean d()
  {
    return this.a.size() > 0;
  }
  
  void e()
  {
    c();
    int j = this.a.size();
    int i = 0;
    if (i < j)
    {
      b localb = (b)this.a.get(i);
      switch (localb.a)
      {
      }
      for (;;)
      {
        if (this.d != null) {
          this.d.run();
        }
        i += 1;
        break;
        this.c.b(localb);
        this.c.c(localb.b, localb.d);
        continue;
        this.c.b(localb);
        this.c.a(localb.b, localb.d);
        continue;
        this.c.b(localb);
        this.c.a(localb.b, localb.d, localb.c);
        continue;
        this.c.b(localb);
        this.c.d(localb.b, localb.d);
      }
    }
    a(this.a);
    this.h = 0;
  }
  
  boolean f()
  {
    return (!this.b.isEmpty()) && (!this.a.isEmpty());
  }
  
  static abstract interface a
  {
    public abstract ao.v a(int paramInt);
    
    public abstract void a(int paramInt1, int paramInt2);
    
    public abstract void a(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void a(f.b paramb);
    
    public abstract void b(int paramInt1, int paramInt2);
    
    public abstract void b(f.b paramb);
    
    public abstract void c(int paramInt1, int paramInt2);
    
    public abstract void d(int paramInt1, int paramInt2);
  }
  
  static class b
  {
    int a;
    int b;
    Object c;
    int d;
    
    b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.d = paramInt3;
      this.c = paramObject;
    }
    
    String a()
    {
      switch (this.a)
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        return "??";
      case 1: 
        return "add";
      case 2: 
        return "rm";
      case 4: 
        return "up";
      }
      return "mv";
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        do
        {
          do
          {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
              return false;
            }
            paramObject = (b)paramObject;
            if (this.a != ((b)paramObject).a) {
              return false;
            }
          } while ((this.a == 8) && (Math.abs(this.d - this.b) == 1) && (this.d == ((b)paramObject).b) && (this.b == ((b)paramObject).d));
          if (this.d != ((b)paramObject).d) {
            return false;
          }
          if (this.b != ((b)paramObject).b) {
            return false;
          }
          if (this.c == null) {
            break;
          }
        } while (this.c.equals(((b)paramObject).c));
        return false;
      } while (((b)paramObject).c == null);
      return false;
    }
    
    public int hashCode()
    {
      return (this.a * 31 + this.b) * 31 + this.d;
    }
    
    public String toString()
    {
      return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.b + "c:" + this.d + ",p:" + this.c + "]";
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */