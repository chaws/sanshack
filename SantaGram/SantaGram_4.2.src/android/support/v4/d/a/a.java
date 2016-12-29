package android.support.v4.d.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public final class a
{
  static final b a = new a();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      a = new h();
      return;
    }
    if (i >= 21)
    {
      a = new g();
      return;
    }
    if (i >= 19)
    {
      a = new f();
      return;
    }
    if (i >= 17)
    {
      a = new e();
      return;
    }
    if (i >= 11)
    {
      a = new d();
      return;
    }
    if (i >= 5)
    {
      a = new c();
      return;
    }
  }
  
  public static void a(Drawable paramDrawable)
  {
    a.a(paramDrawable);
  }
  
  public static void a(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    a.a(paramDrawable, paramFloat1, paramFloat2);
  }
  
  public static void a(Drawable paramDrawable, int paramInt)
  {
    a.a(paramDrawable, paramInt);
  }
  
  public static void a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a.a(paramDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    a.a(paramDrawable, paramColorStateList);
  }
  
  public static void a(Drawable paramDrawable, Resources.Theme paramTheme)
  {
    a.a(paramDrawable, paramTheme);
  }
  
  public static void a(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    a.a(paramDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
  
  public static void a(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    a.a(paramDrawable, paramMode);
  }
  
  public static void a(Drawable paramDrawable, boolean paramBoolean)
  {
    a.a(paramDrawable, paramBoolean);
  }
  
  public static void b(Drawable paramDrawable, int paramInt)
  {
    a.b(paramDrawable, paramInt);
  }
  
  public static boolean b(Drawable paramDrawable)
  {
    return a.b(paramDrawable);
  }
  
  public static int c(Drawable paramDrawable)
  {
    return a.e(paramDrawable);
  }
  
  public static boolean d(Drawable paramDrawable)
  {
    return a.f(paramDrawable);
  }
  
  public static ColorFilter e(Drawable paramDrawable)
  {
    return a.g(paramDrawable);
  }
  
  public static Drawable f(Drawable paramDrawable)
  {
    return a.c(paramDrawable);
  }
  
  public static int g(Drawable paramDrawable)
  {
    return a.d(paramDrawable);
  }
  
  static class a
    implements a.b
  {
    public void a(Drawable paramDrawable) {}
    
    public void a(Drawable paramDrawable, float paramFloat1, float paramFloat2) {}
    
    public void a(Drawable paramDrawable, int paramInt)
    {
      c.a(paramDrawable, paramInt);
    }
    
    public void a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public void a(Drawable paramDrawable, ColorStateList paramColorStateList)
    {
      c.a(paramDrawable, paramColorStateList);
    }
    
    public void a(Drawable paramDrawable, Resources.Theme paramTheme) {}
    
    public void a(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      c.a(paramDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
    
    public void a(Drawable paramDrawable, PorterDuff.Mode paramMode)
    {
      c.a(paramDrawable, paramMode);
    }
    
    public void a(Drawable paramDrawable, boolean paramBoolean) {}
    
    public void b(Drawable paramDrawable, int paramInt) {}
    
    public boolean b(Drawable paramDrawable)
    {
      return false;
    }
    
    public Drawable c(Drawable paramDrawable)
    {
      return c.a(paramDrawable);
    }
    
    public int d(Drawable paramDrawable)
    {
      return 0;
    }
    
    public int e(Drawable paramDrawable)
    {
      return 0;
    }
    
    public boolean f(Drawable paramDrawable)
    {
      return false;
    }
    
    public ColorFilter g(Drawable paramDrawable)
    {
      return null;
    }
  }
  
  static abstract interface b
  {
    public abstract void a(Drawable paramDrawable);
    
    public abstract void a(Drawable paramDrawable, float paramFloat1, float paramFloat2);
    
    public abstract void a(Drawable paramDrawable, int paramInt);
    
    public abstract void a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void a(Drawable paramDrawable, ColorStateList paramColorStateList);
    
    public abstract void a(Drawable paramDrawable, Resources.Theme paramTheme);
    
    public abstract void a(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme);
    
    public abstract void a(Drawable paramDrawable, PorterDuff.Mode paramMode);
    
    public abstract void a(Drawable paramDrawable, boolean paramBoolean);
    
    public abstract void b(Drawable paramDrawable, int paramInt);
    
    public abstract boolean b(Drawable paramDrawable);
    
    public abstract Drawable c(Drawable paramDrawable);
    
    public abstract int d(Drawable paramDrawable);
    
    public abstract int e(Drawable paramDrawable);
    
    public abstract boolean f(Drawable paramDrawable);
    
    public abstract ColorFilter g(Drawable paramDrawable);
  }
  
  static class c
    extends a.a
  {
    public Drawable c(Drawable paramDrawable)
    {
      return d.a(paramDrawable);
    }
  }
  
  static class d
    extends a.c
  {
    public void a(Drawable paramDrawable)
    {
      e.a(paramDrawable);
    }
    
    public Drawable c(Drawable paramDrawable)
    {
      return e.b(paramDrawable);
    }
  }
  
  static class e
    extends a.d
  {
    public void b(Drawable paramDrawable, int paramInt)
    {
      f.a(paramDrawable, paramInt);
    }
    
    public int d(Drawable paramDrawable)
    {
      int i = f.a(paramDrawable);
      if (i >= 0) {
        return i;
      }
      return 0;
    }
  }
  
  static class f
    extends a.e
  {
    public void a(Drawable paramDrawable, boolean paramBoolean)
    {
      g.a(paramDrawable, paramBoolean);
    }
    
    public boolean b(Drawable paramDrawable)
    {
      return g.a(paramDrawable);
    }
    
    public Drawable c(Drawable paramDrawable)
    {
      return g.b(paramDrawable);
    }
    
    public int e(Drawable paramDrawable)
    {
      return g.c(paramDrawable);
    }
  }
  
  static class g
    extends a.f
  {
    public void a(Drawable paramDrawable, float paramFloat1, float paramFloat2)
    {
      h.a(paramDrawable, paramFloat1, paramFloat2);
    }
    
    public void a(Drawable paramDrawable, int paramInt)
    {
      h.a(paramDrawable, paramInt);
    }
    
    public void a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      h.a(paramDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void a(Drawable paramDrawable, ColorStateList paramColorStateList)
    {
      h.a(paramDrawable, paramColorStateList);
    }
    
    public void a(Drawable paramDrawable, Resources.Theme paramTheme)
    {
      h.a(paramDrawable, paramTheme);
    }
    
    public void a(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      h.a(paramDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
    
    public void a(Drawable paramDrawable, PorterDuff.Mode paramMode)
    {
      h.a(paramDrawable, paramMode);
    }
    
    public Drawable c(Drawable paramDrawable)
    {
      return h.a(paramDrawable);
    }
    
    public boolean f(Drawable paramDrawable)
    {
      return h.b(paramDrawable);
    }
    
    public ColorFilter g(Drawable paramDrawable)
    {
      return h.c(paramDrawable);
    }
  }
  
  static class h
    extends a.g
  {
    public void b(Drawable paramDrawable, int paramInt)
    {
      b.a(paramDrawable, paramInt);
    }
    
    public Drawable c(Drawable paramDrawable)
    {
      return paramDrawable;
    }
    
    public int d(Drawable paramDrawable)
    {
      return b.a(paramDrawable);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/d/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */