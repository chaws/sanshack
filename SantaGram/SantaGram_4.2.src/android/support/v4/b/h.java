package android.support.v4.b;

import android.os.Build.VERSION;
import android.support.v4.i.a;
import android.support.v4.i.d;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class h
  extends v
  implements Runnable
{
  static final boolean a;
  final s b;
  a c;
  a d;
  int e;
  int f;
  int g;
  int h;
  int i;
  int j;
  int k;
  boolean l;
  boolean m = true;
  String n;
  boolean o;
  int p = -1;
  int q;
  CharSequence r;
  int s;
  CharSequence t;
  ArrayList<String> u;
  ArrayList<String> v;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public h(s params)
  {
    this.b = params;
  }
  
  private b a(SparseArray<m> paramSparseArray1, SparseArray<m> paramSparseArray2, boolean paramBoolean)
  {
    int i5 = 0;
    b localb = new b();
    localb.d = new View(this.b.o.g());
    int i2 = 0;
    int i1 = 0;
    int i3 = i5;
    int i4 = i1;
    if (i2 < paramSparseArray1.size())
    {
      if (!a(paramSparseArray1.keyAt(i2), localb, paramBoolean, paramSparseArray1, paramSparseArray2)) {
        break label164;
      }
      i1 = 1;
    }
    label164:
    for (;;)
    {
      i2 += 1;
      break;
      while (i3 < paramSparseArray2.size())
      {
        i2 = paramSparseArray2.keyAt(i3);
        i1 = i4;
        if (paramSparseArray1.get(i2) == null)
        {
          i1 = i4;
          if (a(i2, localb, paramBoolean, paramSparseArray1, paramSparseArray2)) {
            i1 = 1;
          }
        }
        i3 += 1;
        i4 = i1;
      }
      paramSparseArray1 = localb;
      if (i4 == 0) {
        paramSparseArray1 = null;
      }
      return paramSparseArray1;
    }
  }
  
  private a<String, View> a(b paramb, m paramm, boolean paramBoolean)
  {
    a locala2 = new a();
    a locala1 = locala2;
    if (this.u != null)
    {
      w.a(locala2, paramm.g());
      if (!paramBoolean) {
        break label82;
      }
      locala2.a(this.v);
    }
    label82:
    for (locala1 = locala2; paramBoolean; locala1 = a(this.u, this.v, locala2))
    {
      if (paramm.X != null) {
        paramm.X.a(this.v, locala1);
      }
      a(paramb, locala1, false);
      return locala1;
    }
    if (paramm.Y != null) {
      paramm.Y.a(this.v, locala1);
    }
    b(paramb, locala1, false);
    return locala1;
  }
  
  private a<String, View> a(b paramb, boolean paramBoolean, m paramm)
  {
    a locala = b(paramb, paramm, paramBoolean);
    if (paramBoolean)
    {
      if (paramm.Y != null) {
        paramm.Y.a(this.v, locala);
      }
      a(paramb, locala, true);
      return locala;
    }
    if (paramm.X != null) {
      paramm.X.a(this.v, locala);
    }
    b(paramb, locala, true);
    return locala;
  }
  
  private static a<String, View> a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, a<String, View> parama)
  {
    if (parama.isEmpty()) {
      return parama;
    }
    a locala = new a();
    int i2 = paramArrayList1.size();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = (View)parama.get(paramArrayList1.get(i1));
      if (localView != null) {
        locala.put(paramArrayList2.get(i1), localView);
      }
      i1 += 1;
    }
    return locala;
  }
  
  private static Object a(m paramm1, m paramm2, boolean paramBoolean)
  {
    if ((paramm1 == null) || (paramm2 == null)) {
      return null;
    }
    if (paramBoolean) {}
    for (paramm1 = paramm2.v();; paramm1 = paramm1.u()) {
      return w.b(paramm1);
    }
  }
  
  private static Object a(m paramm, boolean paramBoolean)
  {
    if (paramm == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramm = paramm.t();; paramm = paramm.q()) {
      return w.a(paramm);
    }
  }
  
  private static Object a(Object paramObject, m paramm, ArrayList<View> paramArrayList, a<String, View> parama, View paramView)
  {
    Object localObject = paramObject;
    if (paramObject != null) {
      localObject = w.a(paramObject, paramm.g(), paramArrayList, parama, paramView);
    }
    return localObject;
  }
  
  private void a(b paramb, int paramInt, Object paramObject)
  {
    if (this.b.g != null)
    {
      int i1 = 0;
      if (i1 < this.b.g.size())
      {
        m localm = (m)this.b.g.get(i1);
        if ((localm.I != null) && (localm.H != null) && (localm.x == paramInt))
        {
          if (!localm.z) {
            break label125;
          }
          if (!paramb.b.contains(localm.I))
          {
            w.a(paramObject, localm.I, true);
            paramb.b.add(localm.I);
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          label125:
          w.a(paramObject, localm.I, false);
          paramb.b.remove(localm.I);
        }
      }
    }
  }
  
  private void a(b paramb, m paramm1, m paramm2, boolean paramBoolean, a<String, View> parama)
  {
    if (paramBoolean) {}
    for (paramb = paramm2.X;; paramb = paramm1.X)
    {
      if (paramb != null) {
        paramb.b(new ArrayList(parama.keySet()), new ArrayList(parama.values()), null);
      }
      return;
    }
  }
  
  private void a(b paramb, a<String, View> parama, boolean paramBoolean)
  {
    int i1;
    int i2;
    label13:
    String str;
    Object localObject;
    if (this.v == null)
    {
      i1 = 0;
      i2 = 0;
      if (i2 >= i1) {
        return;
      }
      str = (String)this.u.get(i2);
      localObject = (View)parama.get((String)this.v.get(i2));
      if (localObject != null)
      {
        localObject = w.a((View)localObject);
        if (!paramBoolean) {
          break label103;
        }
        a(paramb.a, str, (String)localObject);
      }
    }
    for (;;)
    {
      i2 += 1;
      break label13;
      i1 = this.v.size();
      break;
      label103:
      a(paramb.a, (String)localObject, str);
    }
  }
  
  private void a(final b paramb, final View paramView, final Object paramObject, final m paramm1, final m paramm2, final boolean paramBoolean, final ArrayList<View> paramArrayList)
  {
    paramView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        paramView.getViewTreeObserver().removeOnPreDrawListener(this);
        if (paramObject != null)
        {
          w.a(paramObject, paramArrayList);
          paramArrayList.clear();
          a locala = h.a(h.this, paramb, paramBoolean, paramm1);
          w.a(paramObject, paramb.d, locala, paramArrayList);
          h.a(h.this, locala, paramb);
          h.a(h.this, paramb, paramm1, paramm2, paramBoolean, locala);
        }
        return true;
      }
    });
  }
  
  private static void a(b paramb, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if (paramArrayList1 != null)
    {
      int i1 = 0;
      while (i1 < paramArrayList1.size())
      {
        String str1 = (String)paramArrayList1.get(i1);
        String str2 = (String)paramArrayList2.get(i1);
        a(paramb.a, str1, str2);
        i1 += 1;
      }
    }
  }
  
  private void a(a<String, View> parama, b paramb)
  {
    if ((this.v != null) && (!parama.isEmpty()))
    {
      parama = (View)parama.get(this.v.get(0));
      if (parama != null) {
        paramb.c.a = parama;
      }
    }
  }
  
  private static void a(a<String, String> parama, String paramString1, String paramString2)
  {
    int i1;
    if ((paramString1 != null) && (paramString2 != null)) {
      i1 = 0;
    }
    while (i1 < parama.size())
    {
      if (paramString1.equals(parama.c(i1)))
      {
        parama.a(i1, paramString2);
        return;
      }
      i1 += 1;
    }
    parama.put(paramString1, paramString2);
  }
  
  private static void a(SparseArray<m> paramSparseArray1, SparseArray<m> paramSparseArray2, m paramm)
  {
    if (paramm != null)
    {
      int i1 = paramm.x;
      if ((i1 != 0) && (!paramm.f()))
      {
        if ((paramm.e()) && (paramm.g() != null) && (paramSparseArray1.get(i1) == null)) {
          paramSparseArray1.put(i1, paramm);
        }
        if (paramSparseArray2.get(i1) == paramm) {
          paramSparseArray2.remove(i1);
        }
      }
    }
  }
  
  private void a(final View paramView, final b paramb, final int paramInt, final Object paramObject)
  {
    paramView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        paramView.getViewTreeObserver().removeOnPreDrawListener(this);
        h.a(h.this, paramb, paramInt, paramObject);
        return true;
      }
    });
  }
  
  private boolean a(int paramInt, b paramb, boolean paramBoolean, SparseArray<m> paramSparseArray1, SparseArray<m> paramSparseArray2)
  {
    ViewGroup localViewGroup = (ViewGroup)this.b.p.a(paramInt);
    if (localViewGroup == null) {
      return false;
    }
    final Object localObject2 = (m)paramSparseArray2.get(paramInt);
    Object localObject4 = (m)paramSparseArray1.get(paramInt);
    Object localObject3 = a((m)localObject2, paramBoolean);
    paramSparseArray2 = a((m)localObject2, (m)localObject4, paramBoolean);
    Object localObject5 = b((m)localObject4, paramBoolean);
    paramSparseArray1 = null;
    ArrayList localArrayList1 = new ArrayList();
    if (paramSparseArray2 != null)
    {
      localObject1 = a(paramb, (m)localObject4, paramBoolean);
      if (((a)localObject1).isEmpty())
      {
        paramSparseArray1 = null;
        paramSparseArray2 = null;
        if ((localObject3 != null) || (paramSparseArray2 != null) || (localObject5 != null)) {
          break label208;
        }
        return false;
      }
      if (!paramBoolean) {
        break label198;
      }
    }
    label198:
    for (paramSparseArray1 = ((m)localObject4).X;; paramSparseArray1 = ((m)localObject2).X)
    {
      if (paramSparseArray1 != null) {
        paramSparseArray1.a(new ArrayList(((a)localObject1).keySet()), new ArrayList(((a)localObject1).values()), null);
      }
      a(paramb, localViewGroup, paramSparseArray2, (m)localObject2, (m)localObject4, paramBoolean, localArrayList1);
      paramSparseArray1 = (SparseArray<m>)localObject1;
      break;
    }
    label208:
    Object localObject1 = new ArrayList();
    localObject4 = a(localObject5, (m)localObject4, (ArrayList)localObject1, paramSparseArray1, paramb.d);
    if ((this.v != null) && (paramSparseArray1 != null))
    {
      localObject5 = (View)paramSparseArray1.get(this.v.get(0));
      if (localObject5 != null)
      {
        if (localObject4 != null) {
          w.a(localObject4, (View)localObject5);
        }
        if (paramSparseArray2 != null) {
          w.a(paramSparseArray2, (View)localObject5);
        }
      }
    }
    localObject5 = new w.b()
    {
      public View a()
      {
        return localObject2.g();
      }
    };
    ArrayList localArrayList2 = new ArrayList();
    a locala = new a();
    boolean bool = true;
    if (localObject2 != null) {
      if (!paramBoolean) {
        break label462;
      }
    }
    label462:
    for (bool = ((m)localObject2).x();; bool = ((m)localObject2).w())
    {
      localObject2 = w.a(localObject3, localObject4, paramSparseArray2, bool);
      if (localObject2 != null)
      {
        w.a(localObject3, paramSparseArray2, localViewGroup, (w.b)localObject5, paramb.d, paramb.c, paramb.a, localArrayList2, paramSparseArray1, locala, localArrayList1);
        a(localViewGroup, paramb, paramInt, localObject2);
        w.a(localObject2, paramb.d, true);
        a(paramb, paramInt, localObject2);
        w.a(localViewGroup, localObject2);
        w.a(localViewGroup, paramb.d, localObject3, localArrayList2, localObject4, (ArrayList)localObject1, paramSparseArray2, localArrayList1, localObject2, paramb.b, locala);
      }
      if (localObject2 == null) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private a<String, View> b(b paramb, m paramm, boolean paramBoolean)
  {
    a locala = new a();
    paramm = paramm.g();
    paramb = locala;
    if (paramm != null)
    {
      paramb = locala;
      if (this.u != null)
      {
        w.a(locala, paramm);
        if (!paramBoolean) {
          break label57;
        }
        paramb = a(this.u, this.v, locala);
      }
    }
    return paramb;
    label57:
    locala.a(this.v);
    return locala;
  }
  
  private static Object b(m paramm, boolean paramBoolean)
  {
    if (paramm == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramm = paramm.r();; paramm = paramm.s()) {
      return w.a(paramm);
    }
  }
  
  private void b(b paramb, a<String, View> parama, boolean paramBoolean)
  {
    int i2 = parama.size();
    int i1 = 0;
    if (i1 < i2)
    {
      String str1 = (String)parama.b(i1);
      String str2 = w.a((View)parama.c(i1));
      if (paramBoolean) {
        a(paramb.a, str1, str2);
      }
      for (;;)
      {
        i1 += 1;
        break;
        a(paramb.a, str2, str1);
      }
    }
  }
  
  private void b(SparseArray<m> paramSparseArray1, SparseArray<m> paramSparseArray2)
  {
    if (!this.b.p.a()) {}
    a locala;
    do
    {
      return;
      locala = this.c;
    } while (locala == null);
    switch (locala.c)
    {
    }
    for (;;)
    {
      locala = locala.a;
      break;
      b(paramSparseArray1, paramSparseArray2, locala.d);
      continue;
      Object localObject1 = locala.d;
      if (this.b.g != null)
      {
        int i1 = 0;
        if (i1 < this.b.g.size())
        {
          m localm = (m)this.b.g.get(i1);
          Object localObject2;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (localm.x != ((m)localObject1).x) {}
          }
          else
          {
            if (localm != localObject1) {
              break label194;
            }
            localObject2 = null;
            paramSparseArray2.remove(localm.x);
          }
          for (;;)
          {
            i1 += 1;
            localObject1 = localObject2;
            break;
            label194:
            a(paramSparseArray1, paramSparseArray2, localm);
            localObject2 = localObject1;
          }
        }
      }
      b(paramSparseArray1, paramSparseArray2, locala.d);
      continue;
      a(paramSparseArray1, paramSparseArray2, locala.d);
      continue;
      a(paramSparseArray1, paramSparseArray2, locala.d);
      continue;
      b(paramSparseArray1, paramSparseArray2, locala.d);
      continue;
      a(paramSparseArray1, paramSparseArray2, locala.d);
      continue;
      b(paramSparseArray1, paramSparseArray2, locala.d);
    }
  }
  
  private void b(SparseArray<m> paramSparseArray1, SparseArray<m> paramSparseArray2, m paramm)
  {
    if (paramm != null)
    {
      int i1 = paramm.x;
      if (i1 != 0)
      {
        if (!paramm.e()) {
          paramSparseArray2.put(i1, paramm);
        }
        if (paramSparseArray1.get(i1) == paramm) {
          paramSparseArray1.remove(i1);
        }
      }
      if ((paramm.b < 1) && (this.b.n >= 1))
      {
        this.b.c(paramm);
        this.b.a(paramm, 1, 0, 0, false);
      }
    }
  }
  
  public b a(boolean paramBoolean, b paramb, SparseArray<m> paramSparseArray1, SparseArray<m> paramSparseArray2)
  {
    if (s.a)
    {
      Log.v("FragmentManager", "popFromBackStack: " + this);
      a("  ", null, new PrintWriter(new d("FragmentManager")), null);
    }
    b localb = paramb;
    if (a)
    {
      localb = paramb;
      if (this.b.n >= 1)
      {
        if (paramb != null) {
          break label239;
        }
        if (paramSparseArray1.size() == 0)
        {
          localb = paramb;
          if (paramSparseArray2.size() == 0) {}
        }
        else
        {
          localb = a(paramSparseArray1, paramSparseArray2, true);
        }
      }
    }
    label114:
    a(-1);
    int i1;
    label127:
    int i2;
    label135:
    int i3;
    if (localb != null)
    {
      i1 = 0;
      if (localb == null) {
        break label273;
      }
      i2 = 0;
      paramb = this.d;
      if (paramb == null) {
        break label562;
      }
      if (localb == null) {
        break label282;
      }
      i3 = 0;
      label152:
      if (localb == null) {
        break label291;
      }
    }
    label239:
    label273:
    label282:
    label291:
    for (int i4 = 0;; i4 = paramb.h) {
      switch (paramb.c)
      {
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + paramb.c);
        localb = paramb;
        if (paramBoolean) {
          break label114;
        }
        a(paramb, this.v, this.u);
        localb = paramb;
        break label114;
        i1 = this.k;
        break label127;
        i2 = this.j;
        break label135;
        i3 = paramb.g;
        break label152;
      }
    }
    paramSparseArray1 = paramb.d;
    paramSparseArray1.G = i4;
    this.b.a(paramSparseArray1, s.c(i2), i1);
    for (;;)
    {
      paramb = paramb.b;
      break;
      paramSparseArray1 = paramb.d;
      if (paramSparseArray1 != null)
      {
        paramSparseArray1.G = i4;
        this.b.a(paramSparseArray1, s.c(i2), i1);
      }
      if (paramb.i != null)
      {
        i4 = 0;
        while (i4 < paramb.i.size())
        {
          paramSparseArray1 = (m)paramb.i.get(i4);
          paramSparseArray1.G = i3;
          this.b.a(paramSparseArray1, false);
          i4 += 1;
        }
        paramSparseArray1 = paramb.d;
        paramSparseArray1.G = i3;
        this.b.a(paramSparseArray1, false);
        continue;
        paramSparseArray1 = paramb.d;
        paramSparseArray1.G = i3;
        this.b.c(paramSparseArray1, s.c(i2), i1);
        continue;
        paramSparseArray1 = paramb.d;
        paramSparseArray1.G = i4;
        this.b.b(paramSparseArray1, s.c(i2), i1);
        continue;
        paramSparseArray1 = paramb.d;
        paramSparseArray1.G = i3;
        this.b.e(paramSparseArray1, s.c(i2), i1);
        continue;
        paramSparseArray1 = paramb.d;
        paramSparseArray1.G = i3;
        this.b.d(paramSparseArray1, s.c(i2), i1);
      }
    }
    label562:
    if (paramBoolean)
    {
      this.b.a(this.b.n, s.c(i2), i1, true);
      localb = null;
    }
    if (this.p >= 0)
    {
      this.b.b(this.p);
      this.p = -1;
    }
    return localb;
  }
  
  public String a()
  {
    return this.n;
  }
  
  void a(int paramInt)
  {
    if (!this.l) {}
    for (;;)
    {
      return;
      if (s.a) {
        Log.v("FragmentManager", "Bump nesting in " + this + " by " + paramInt);
      }
      for (a locala = this.c; locala != null; locala = locala.a)
      {
        m localm;
        if (locala.d != null)
        {
          localm = locala.d;
          localm.r += paramInt;
          if (s.a) {
            Log.v("FragmentManager", "Bump nesting of " + locala.d + " to " + locala.d.r);
          }
        }
        if (locala.i != null)
        {
          int i1 = locala.i.size() - 1;
          while (i1 >= 0)
          {
            localm = (m)locala.i.get(i1);
            localm.r += paramInt;
            if (s.a) {
              Log.v("FragmentManager", "Bump nesting of " + localm + " to " + localm.r);
            }
            i1 -= 1;
          }
        }
      }
    }
  }
  
  void a(a parama)
  {
    if (this.c == null)
    {
      this.d = parama;
      this.c = parama;
    }
    for (;;)
    {
      parama.e = this.f;
      parama.f = this.g;
      parama.g = this.h;
      parama.h = this.i;
      this.e += 1;
      return;
      parama.b = this.d;
      this.d.a = parama;
      this.d = parama;
    }
  }
  
  public void a(SparseArray<m> paramSparseArray1, SparseArray<m> paramSparseArray2)
  {
    if (!this.b.p.a()) {}
    a locala;
    do
    {
      return;
      locala = this.d;
    } while (locala == null);
    switch (locala.c)
    {
    }
    for (;;)
    {
      locala = locala.b;
      break;
      a(paramSparseArray1, paramSparseArray2, locala.d);
      continue;
      if (locala.i != null)
      {
        int i1 = locala.i.size() - 1;
        while (i1 >= 0)
        {
          b(paramSparseArray1, paramSparseArray2, (m)locala.i.get(i1));
          i1 -= 1;
        }
      }
      a(paramSparseArray1, paramSparseArray2, locala.d);
      continue;
      b(paramSparseArray1, paramSparseArray2, locala.d);
      continue;
      b(paramSparseArray1, paramSparseArray2, locala.d);
      continue;
      a(paramSparseArray1, paramSparseArray2, locala.d);
      continue;
      b(paramSparseArray1, paramSparseArray2, locala.d);
      continue;
      a(paramSparseArray1, paramSparseArray2, locala.d);
    }
  }
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    a(paramString, paramPrintWriter, true);
  }
  
  public void a(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.n);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.p);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.o);
      if (this.j != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.j));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.k));
      }
      if ((this.f != 0) || (this.g != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.f));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.g));
      }
      if ((this.h != 0) || (this.i != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.h));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.i));
      }
      if ((this.q != 0) || (this.r != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.q));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.r);
      }
      if ((this.s != 0) || (this.t != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.s));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.t);
      }
    }
    if (this.c != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      String str2 = paramString + "    ";
      a locala = this.c;
      int i1 = 0;
      while (locala != null)
      {
        String str1;
        int i2;
        switch (locala.c)
        {
        default: 
          str1 = "cmd=" + locala.c;
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str1);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(locala.d);
          if (paramBoolean)
          {
            if ((locala.e != 0) || (locala.f != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locala.e));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locala.f));
            }
            if ((locala.g != 0) || (locala.h != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locala.g));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locala.h));
            }
          }
          if ((locala.i == null) || (locala.i.size() <= 0)) {
            break label807;
          }
          i2 = 0;
          label641:
          if (i2 >= locala.i.size()) {
            break label807;
          }
          paramPrintWriter.print(str2);
          if (locala.i.size() == 1) {
            paramPrintWriter.print("Removed: ");
          }
          break;
        }
        for (;;)
        {
          paramPrintWriter.println(locala.i.get(i2));
          i2 += 1;
          break label641;
          str1 = "NULL";
          break;
          str1 = "ADD";
          break;
          str1 = "REPLACE";
          break;
          str1 = "REMOVE";
          break;
          str1 = "HIDE";
          break;
          str1 = "SHOW";
          break;
          str1 = "DETACH";
          break;
          str1 = "ATTACH";
          break;
          if (i2 == 0) {
            paramPrintWriter.println("Removed:");
          }
          paramPrintWriter.print(str2);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i2);
          paramPrintWriter.print(": ");
        }
        label807:
        locala = locala.a;
        i1 += 1;
      }
    }
  }
  
  public void run()
  {
    if (s.a) {
      Log.v("FragmentManager", "Run: " + this);
    }
    if ((this.l) && (this.p < 0)) {
      throw new IllegalStateException("addToBackStack() called after commit()");
    }
    a(1);
    Object localObject1;
    if ((a) && (this.b.n >= 1))
    {
      localObject1 = new SparseArray();
      localObject2 = new SparseArray();
      b((SparseArray)localObject1, (SparseArray)localObject2);
    }
    for (Object localObject2 = a((SparseArray)localObject1, (SparseArray)localObject2, false);; localObject2 = null)
    {
      int i1;
      label117:
      int i2;
      label124:
      a locala;
      int i3;
      if (localObject2 != null)
      {
        i1 = 0;
        if (localObject2 == null) {
          break label232;
        }
        i2 = 0;
        locala = this.c;
        if (locala == null) {
          break label699;
        }
        if (localObject2 == null) {
          break label241;
        }
        i3 = 0;
        label140:
        if (localObject2 == null) {
          break label250;
        }
      }
      label232:
      label241:
      label250:
      for (int i4 = 0;; i4 = locala.f) {
        switch (locala.c)
        {
        default: 
          throw new IllegalArgumentException("Unknown cmd: " + locala.c);
          i1 = this.k;
          break label117;
          i2 = this.j;
          break label124;
          i3 = locala.e;
          break label140;
        }
      }
      localObject1 = locala.d;
      ((m)localObject1).G = i3;
      this.b.a((m)localObject1, false);
      for (;;)
      {
        locala = locala.a;
        break;
        localObject1 = locala.d;
        int i6 = ((m)localObject1).x;
        Object localObject3 = localObject1;
        if (this.b.g != null)
        {
          int i5 = this.b.g.size() - 1;
          localObject3 = localObject1;
          if (i5 >= 0)
          {
            localObject3 = (m)this.b.g.get(i5);
            if (s.a) {
              Log.v("FragmentManager", "OP_REPLACE: adding=" + localObject1 + " old=" + localObject3);
            }
            if (((m)localObject3).x == i6) {
              if (localObject3 == localObject1)
              {
                localObject1 = null;
                locala.d = null;
              }
            }
            for (;;)
            {
              i5 -= 1;
              break;
              if (locala.i == null) {
                locala.i = new ArrayList();
              }
              locala.i.add(localObject3);
              ((m)localObject3).G = i4;
              if (this.l)
              {
                ((m)localObject3).r += 1;
                if (s.a) {
                  Log.v("FragmentManager", "Bump nesting of " + localObject3 + " to " + ((m)localObject3).r);
                }
              }
              this.b.a((m)localObject3, i2, i1);
            }
          }
        }
        if (localObject3 != null)
        {
          ((m)localObject3).G = i3;
          this.b.a((m)localObject3, false);
          continue;
          localObject1 = locala.d;
          ((m)localObject1).G = i4;
          this.b.a((m)localObject1, i2, i1);
          continue;
          localObject1 = locala.d;
          ((m)localObject1).G = i4;
          this.b.b((m)localObject1, i2, i1);
          continue;
          localObject1 = locala.d;
          ((m)localObject1).G = i3;
          this.b.c((m)localObject1, i2, i1);
          continue;
          localObject1 = locala.d;
          ((m)localObject1).G = i4;
          this.b.d((m)localObject1, i2, i1);
          continue;
          localObject1 = locala.d;
          ((m)localObject1).G = i3;
          this.b.e((m)localObject1, i2, i1);
        }
      }
      label699:
      this.b.a(this.b.n, i2, i1, true);
      if (this.l) {
        this.b.a(this);
      }
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.p >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.p);
    }
    if (this.n != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.n);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class a
  {
    a a;
    a b;
    int c;
    m d;
    int e;
    int f;
    int g;
    int h;
    ArrayList<m> i;
  }
  
  public class b
  {
    public a<String, String> a = new a();
    public ArrayList<View> b = new ArrayList();
    public w.a c = new w.a();
    public View d;
    
    public b() {}
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */