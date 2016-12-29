package android.support.v4.j.a;

import android.graphics.Rect;
import android.os.Build.VERSION;

public class c
{
  private static final d a = new i();
  private final Object b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 22)
    {
      a = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new a();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      a = new h();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      a = new g();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      a = new f();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new e();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new c();
      return;
    }
  }
  
  public c(Object paramObject)
  {
    this.b = paramObject;
  }
  
  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "ACTION_UNKNOWN";
    case 1: 
      return "ACTION_FOCUS";
    case 2: 
      return "ACTION_CLEAR_FOCUS";
    case 4: 
      return "ACTION_SELECT";
    case 8: 
      return "ACTION_CLEAR_SELECTION";
    case 16: 
      return "ACTION_CLICK";
    case 32: 
      return "ACTION_LONG_CLICK";
    case 64: 
      return "ACTION_ACCESSIBILITY_FOCUS";
    case 128: 
      return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
    case 256: 
      return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
    case 512: 
      return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
    case 1024: 
      return "ACTION_NEXT_HTML_ELEMENT";
    case 2048: 
      return "ACTION_PREVIOUS_HTML_ELEMENT";
    case 4096: 
      return "ACTION_SCROLL_FORWARD";
    case 8192: 
      return "ACTION_SCROLL_BACKWARD";
    case 65536: 
      return "ACTION_CUT";
    case 16384: 
      return "ACTION_COPY";
    case 32768: 
      return "ACTION_PASTE";
    }
    return "ACTION_SET_SELECTION";
  }
  
  public Object a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    a.a(this.b, paramInt);
  }
  
  public void a(Rect paramRect)
  {
    a.a(this.b, paramRect);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    a.a(this.b, paramCharSequence);
  }
  
  public void a(Object paramObject)
  {
    a.a(this.b, ((j)paramObject).a);
  }
  
  public void a(boolean paramBoolean)
  {
    a.a(this.b, paramBoolean);
  }
  
  public int b()
  {
    return a.a(this.b);
  }
  
  public void b(Rect paramRect)
  {
    a.b(this.b, paramRect);
  }
  
  public void b(Object paramObject)
  {
    a.b(this.b, k.a((k)paramObject));
  }
  
  public boolean c()
  {
    return a.f(this.b);
  }
  
  public boolean d()
  {
    return a.g(this.b);
  }
  
  public boolean e()
  {
    return a.j(this.b);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (c)paramObject;
        if (this.b != null) {
          break;
        }
      } while (((c)paramObject).b == null);
      return false;
    } while (this.b.equals(((c)paramObject).b));
    return false;
  }
  
  public boolean f()
  {
    return a.k(this.b);
  }
  
  public boolean g()
  {
    return a.o(this.b);
  }
  
  public boolean h()
  {
    return a.h(this.b);
  }
  
  public int hashCode()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.hashCode();
  }
  
  public boolean i()
  {
    return a.l(this.b);
  }
  
  public boolean j()
  {
    return a.i(this.b);
  }
  
  public boolean k()
  {
    return a.m(this.b);
  }
  
  public boolean l()
  {
    return a.n(this.b);
  }
  
  public CharSequence m()
  {
    return a.d(this.b);
  }
  
  public CharSequence n()
  {
    return a.b(this.b);
  }
  
  public CharSequence o()
  {
    return a.e(this.b);
  }
  
  public CharSequence p()
  {
    return a.c(this.b);
  }
  
  public String q()
  {
    return a.p(this.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    Rect localRect = new Rect();
    a(localRect);
    localStringBuilder.append("; boundsInParent: " + localRect);
    b(localRect);
    localStringBuilder.append("; boundsInScreen: " + localRect);
    localStringBuilder.append("; packageName: ").append(m());
    localStringBuilder.append("; className: ").append(n());
    localStringBuilder.append("; text: ").append(o());
    localStringBuilder.append("; contentDescription: ").append(p());
    localStringBuilder.append("; viewId: ").append(q());
    localStringBuilder.append("; checkable: ").append(c());
    localStringBuilder.append("; checked: ").append(d());
    localStringBuilder.append("; focusable: ").append(e());
    localStringBuilder.append("; focused: ").append(f());
    localStringBuilder.append("; selected: ").append(g());
    localStringBuilder.append("; clickable: ").append(h());
    localStringBuilder.append("; longClickable: ").append(i());
    localStringBuilder.append("; enabled: ").append(j());
    localStringBuilder.append("; password: ").append(k());
    localStringBuilder.append("; scrollable: " + l());
    localStringBuilder.append("; [");
    int i = b();
    while (i != 0)
    {
      int k = 1 << Integer.numberOfTrailingZeros(i);
      int j = i & (k ^ 0xFFFFFFFF);
      localStringBuilder.append(b(k));
      i = j;
      if (j != 0)
      {
        localStringBuilder.append(", ");
        i = j;
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  static class a
    extends c.h
  {
    public Object a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return d.a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
    }
    
    public Object a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return d.a(paramInt1, paramInt2, paramBoolean, paramInt3);
    }
  }
  
  static class b
    extends c.a
  {}
  
  static class c
    extends c.i
  {
    public int a(Object paramObject)
    {
      return e.a(paramObject);
    }
    
    public void a(Object paramObject, int paramInt)
    {
      e.a(paramObject, paramInt);
    }
    
    public void a(Object paramObject, Rect paramRect)
    {
      e.a(paramObject, paramRect);
    }
    
    public void a(Object paramObject, CharSequence paramCharSequence)
    {
      e.a(paramObject, paramCharSequence);
    }
    
    public void a(Object paramObject, boolean paramBoolean)
    {
      e.a(paramObject, paramBoolean);
    }
    
    public CharSequence b(Object paramObject)
    {
      return e.b(paramObject);
    }
    
    public void b(Object paramObject, Rect paramRect)
    {
      e.b(paramObject, paramRect);
    }
    
    public CharSequence c(Object paramObject)
    {
      return e.c(paramObject);
    }
    
    public CharSequence d(Object paramObject)
    {
      return e.d(paramObject);
    }
    
    public CharSequence e(Object paramObject)
    {
      return e.e(paramObject);
    }
    
    public boolean f(Object paramObject)
    {
      return e.f(paramObject);
    }
    
    public boolean g(Object paramObject)
    {
      return e.g(paramObject);
    }
    
    public boolean h(Object paramObject)
    {
      return e.h(paramObject);
    }
    
    public boolean i(Object paramObject)
    {
      return e.i(paramObject);
    }
    
    public boolean j(Object paramObject)
    {
      return e.j(paramObject);
    }
    
    public boolean k(Object paramObject)
    {
      return e.k(paramObject);
    }
    
    public boolean l(Object paramObject)
    {
      return e.l(paramObject);
    }
    
    public boolean m(Object paramObject)
    {
      return e.m(paramObject);
    }
    
    public boolean n(Object paramObject)
    {
      return e.n(paramObject);
    }
    
    public boolean o(Object paramObject)
    {
      return e.o(paramObject);
    }
  }
  
  static abstract interface d
  {
    public abstract int a(Object paramObject);
    
    public abstract Object a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract Object a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3);
    
    public abstract void a(Object paramObject, int paramInt);
    
    public abstract void a(Object paramObject, Rect paramRect);
    
    public abstract void a(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void a(Object paramObject1, Object paramObject2);
    
    public abstract void a(Object paramObject, boolean paramBoolean);
    
    public abstract CharSequence b(Object paramObject);
    
    public abstract void b(Object paramObject, Rect paramRect);
    
    public abstract void b(Object paramObject1, Object paramObject2);
    
    public abstract CharSequence c(Object paramObject);
    
    public abstract CharSequence d(Object paramObject);
    
    public abstract CharSequence e(Object paramObject);
    
    public abstract boolean f(Object paramObject);
    
    public abstract boolean g(Object paramObject);
    
    public abstract boolean h(Object paramObject);
    
    public abstract boolean i(Object paramObject);
    
    public abstract boolean j(Object paramObject);
    
    public abstract boolean k(Object paramObject);
    
    public abstract boolean l(Object paramObject);
    
    public abstract boolean m(Object paramObject);
    
    public abstract boolean n(Object paramObject);
    
    public abstract boolean o(Object paramObject);
    
    public abstract String p(Object paramObject);
  }
  
  static class e
    extends c.c
  {}
  
  static class f
    extends c.e
  {}
  
  static class g
    extends c.f
  {
    public String p(Object paramObject)
    {
      return f.a(paramObject);
    }
  }
  
  static class h
    extends c.g
  {
    public Object a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return g.a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1);
    }
    
    public Object a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return g.a(paramInt1, paramInt2, paramBoolean, paramInt3);
    }
    
    public void a(Object paramObject1, Object paramObject2)
    {
      g.a(paramObject1, paramObject2);
    }
    
    public void b(Object paramObject1, Object paramObject2)
    {
      g.b(paramObject1, paramObject2);
    }
  }
  
  static class i
    implements c.d
  {
    public int a(Object paramObject)
    {
      return 0;
    }
    
    public Object a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return null;
    }
    
    public Object a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return null;
    }
    
    public void a(Object paramObject, int paramInt) {}
    
    public void a(Object paramObject, Rect paramRect) {}
    
    public void a(Object paramObject, CharSequence paramCharSequence) {}
    
    public void a(Object paramObject1, Object paramObject2) {}
    
    public void a(Object paramObject, boolean paramBoolean) {}
    
    public CharSequence b(Object paramObject)
    {
      return null;
    }
    
    public void b(Object paramObject, Rect paramRect) {}
    
    public void b(Object paramObject1, Object paramObject2) {}
    
    public CharSequence c(Object paramObject)
    {
      return null;
    }
    
    public CharSequence d(Object paramObject)
    {
      return null;
    }
    
    public CharSequence e(Object paramObject)
    {
      return null;
    }
    
    public boolean f(Object paramObject)
    {
      return false;
    }
    
    public boolean g(Object paramObject)
    {
      return false;
    }
    
    public boolean h(Object paramObject)
    {
      return false;
    }
    
    public boolean i(Object paramObject)
    {
      return false;
    }
    
    public boolean j(Object paramObject)
    {
      return false;
    }
    
    public boolean k(Object paramObject)
    {
      return false;
    }
    
    public boolean l(Object paramObject)
    {
      return false;
    }
    
    public boolean m(Object paramObject)
    {
      return false;
    }
    
    public boolean n(Object paramObject)
    {
      return false;
    }
    
    public boolean o(Object paramObject)
    {
      return false;
    }
    
    public String p(Object paramObject)
    {
      return null;
    }
  }
  
  public static class j
  {
    final Object a;
    
    private j(Object paramObject)
    {
      this.a = paramObject;
    }
    
    public static j a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return new j(c.r().a(paramInt1, paramInt2, paramBoolean, paramInt3));
    }
  }
  
  public static class k
  {
    private final Object a;
    
    private k(Object paramObject)
    {
      this.a = paramObject;
    }
    
    public static k a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return new k(c.r().a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2));
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/j/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */