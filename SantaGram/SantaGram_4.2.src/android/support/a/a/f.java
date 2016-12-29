package android.support.a.a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public class f
  extends e
{
  static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
  private f c;
  private PorterDuffColorFilter d;
  private ColorFilter e;
  private boolean f;
  private boolean g = true;
  private Drawable.ConstantState h;
  private final float[] i = new float[9];
  private final Matrix j = new Matrix();
  private final Rect k = new Rect();
  
  private f()
  {
    this.c = new f();
  }
  
  private f(f paramf)
  {
    this.c = paramf;
    this.d = a(this.d, paramf.c, paramf.d);
  }
  
  private static PorterDuff.Mode a(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return paramMode;
    case 3: 
      return PorterDuff.Mode.SRC_OVER;
    case 5: 
      return PorterDuff.Mode.SRC_IN;
    case 9: 
      return PorterDuff.Mode.SRC_ATOP;
    case 14: 
      return PorterDuff.Mode.MULTIPLY;
    case 15: 
      return PorterDuff.Mode.SCREEN;
    }
    return PorterDuff.Mode.ADD;
  }
  
  public static f a(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = new f();
      ((f)localObject).a = android.support.v4.c.a.a.a(paramResources, paramInt, paramTheme);
      ((f)localObject).h = new g(((f)localObject).a.getConstantState());
      return (f)localObject;
    }
    try
    {
      localObject = paramResources.getXml(paramInt);
      localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
      {
        paramInt = ((XmlPullParser)localObject).next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt != 2) {
        throw new XmlPullParserException("No start tag found");
      }
    }
    catch (XmlPullParserException paramResources)
    {
      AttributeSet localAttributeSet;
      Log.e("VectorDrawableCompat", "parser error", paramResources);
      return null;
      paramResources = a(paramResources, (XmlPullParser)localObject, localAttributeSet, paramTheme);
      return paramResources;
    }
    catch (IOException paramResources)
    {
      for (;;)
      {
        Log.e("VectorDrawableCompat", "parser error", paramResources);
      }
    }
  }
  
  public static f a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    f localf = new f();
    localf.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return localf;
  }
  
  private void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
  {
    f localf = this.c;
    e locale = localf.b;
    localf.d = a(d.a(paramTypedArray, paramXmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
    ColorStateList localColorStateList = paramTypedArray.getColorStateList(1);
    if (localColorStateList != null) {
      localf.c = localColorStateList;
    }
    localf.e = d.a(paramTypedArray, paramXmlPullParser, "autoMirrored", 5, localf.e);
    locale.c = d.a(paramTypedArray, paramXmlPullParser, "viewportWidth", 7, locale.c);
    locale.d = d.a(paramTypedArray, paramXmlPullParser, "viewportHeight", 8, locale.d);
    if (locale.c <= 0.0F) {
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    }
    if (locale.d <= 0.0F) {
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }
    locale.a = paramTypedArray.getDimension(3, locale.a);
    locale.b = paramTypedArray.getDimension(2, locale.b);
    if (locale.a <= 0.0F) {
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires width > 0");
    }
    if (locale.b <= 0.0F) {
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires height > 0");
    }
    locale.a(d.a(paramTypedArray, paramXmlPullParser, "alpha", 4, locale.b()));
    paramTypedArray = paramTypedArray.getString(0);
    if (paramTypedArray != null)
    {
      locale.f = paramTypedArray;
      locale.g.put(paramTypedArray, locale);
    }
  }
  
  private boolean a()
  {
    return false;
  }
  
  private static int b(int paramInt, float paramFloat)
  {
    return (int)(Color.alpha(paramInt) * paramFloat) << 24 | 0xFFFFFF & paramInt;
  }
  
  private void b(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    f localf = this.c;
    e locale = localf.b;
    Stack localStack = new Stack();
    localStack.push(e.a(locale));
    int i1 = paramXmlPullParser.getEventType();
    int m = 1;
    if (i1 != 1)
    {
      Object localObject;
      c localc;
      int n;
      if (i1 == 2)
      {
        localObject = paramXmlPullParser.getName();
        localc = (c)localStack.peek();
        if ("path".equals(localObject))
        {
          localObject = new b();
          ((b)localObject).a(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          localc.a.add(localObject);
          if (((b)localObject).b() != null) {
            locale.g.put(((b)localObject).b(), localObject);
          }
          m = 0;
          n = localf.a;
          localf.a = (((b)localObject).o | n);
          label162:
          n = m;
        }
      }
      for (;;)
      {
        i1 = paramXmlPullParser.next();
        m = n;
        break;
        if ("clip-path".equals(localObject))
        {
          localObject = new a();
          ((a)localObject).a(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          localc.a.add(localObject);
          if (((a)localObject).b() != null) {
            locale.g.put(((a)localObject).b(), localObject);
          }
          localf.a |= ((a)localObject).o;
          break label162;
        }
        if ("group".equals(localObject))
        {
          localObject = new c();
          ((c)localObject).a(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          localc.a.add(localObject);
          localStack.push(localObject);
          if (((c)localObject).a() != null) {
            locale.g.put(((c)localObject).a(), localObject);
          }
          localf.a |= c.a((c)localObject);
        }
        break label162;
        n = m;
        if (i1 == 3)
        {
          n = m;
          if ("group".equals(paramXmlPullParser.getName()))
          {
            localStack.pop();
            n = m;
          }
        }
      }
    }
    if (m != 0)
    {
      paramResources = new StringBuffer();
      if (paramResources.length() > 0) {
        paramResources.append(" or ");
      }
      paramResources.append("path");
      throw new XmlPullParserException("no " + paramResources + " defined");
    }
  }
  
  PorterDuffColorFilter a(PorterDuffColorFilter paramPorterDuffColorFilter, ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
  
  Object a(String paramString)
  {
    return this.c.b.g.get(paramString);
  }
  
  void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean canApplyTheme()
  {
    if (this.a != null) {
      android.support.v4.d.a.a.d(this.a);
    }
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a != null) {
      this.a.draw(paramCanvas);
    }
    Object localObject;
    int m;
    int n;
    do
    {
      do
      {
        return;
        copyBounds(this.k);
      } while ((this.k.width() <= 0) || (this.k.height() <= 0));
      if (this.e != null) {
        break;
      }
      localObject = this.d;
      paramCanvas.getMatrix(this.j);
      this.j.getValues(this.i);
      float f2 = Math.abs(this.i[0]);
      float f1 = Math.abs(this.i[4]);
      float f4 = Math.abs(this.i[1]);
      float f3 = Math.abs(this.i[3]);
      if ((f4 != 0.0F) || (f3 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      m = (int)(f2 * this.k.width());
      n = (int)(f1 * this.k.height());
      m = Math.min(2048, m);
      n = Math.min(2048, n);
    } while ((m <= 0) || (n <= 0));
    int i1 = paramCanvas.save();
    paramCanvas.translate(this.k.left, this.k.top);
    if (a())
    {
      paramCanvas.translate(this.k.width(), 0.0F);
      paramCanvas.scale(-1.0F, 1.0F);
    }
    this.k.offsetTo(0, 0);
    this.c.b(m, n);
    if (!this.g) {
      this.c.a(m, n);
    }
    for (;;)
    {
      this.c.a(paramCanvas, (ColorFilter)localObject, this.k);
      paramCanvas.restoreToCount(i1);
      return;
      localObject = this.e;
      break;
      if (!this.c.b())
      {
        this.c.a(m, n);
        this.c.c();
      }
    }
  }
  
  public int getAlpha()
  {
    if (this.a != null) {
      return android.support.v4.d.a.a.c(this.a);
    }
    return this.c.b.a();
  }
  
  public int getChangingConfigurations()
  {
    if (this.a != null) {
      return this.a.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.c.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (this.a != null) {
      return new g(this.a.getConstantState());
    }
    this.c.a = getChangingConfigurations();
    return this.c;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.a != null) {
      return this.a.getIntrinsicHeight();
    }
    return (int)this.c.b.b;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.a != null) {
      return this.a.getIntrinsicWidth();
    }
    return (int)this.c.b.a;
  }
  
  public int getOpacity()
  {
    if (this.a != null) {
      return this.a.getOpacity();
    }
    return -3;
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    if (this.a != null)
    {
      this.a.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.a != null)
    {
      android.support.v4.d.a.a.a(this.a, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    f localf = this.c;
    localf.b = new e();
    TypedArray localTypedArray = b(paramResources, paramTheme, paramAttributeSet, a.a);
    a(localTypedArray, paramXmlPullParser);
    localTypedArray.recycle();
    localf.a = getChangingConfigurations();
    localf.k = true;
    b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.d = a(this.d, localf.c, localf.d);
  }
  
  public void invalidateSelf()
  {
    if (this.a != null)
    {
      this.a.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public boolean isStateful()
  {
    if (this.a != null) {
      return this.a.isStateful();
    }
    return (super.isStateful()) || ((this.c != null) && (this.c.c != null) && (this.c.c.isStateful()));
  }
  
  public Drawable mutate()
  {
    if (this.a != null) {
      this.a.mutate();
    }
    while ((this.f) || (super.mutate() != this)) {
      return this;
    }
    this.c = new f(this.c);
    this.f = true;
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.a != null) {
      this.a.setBounds(paramRect);
    }
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.a != null) {
      return this.a.setState(paramArrayOfInt);
    }
    paramArrayOfInt = this.c;
    if ((paramArrayOfInt.c != null) && (paramArrayOfInt.d != null))
    {
      this.d = a(this.d, paramArrayOfInt.c, paramArrayOfInt.d);
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    if (this.a != null)
    {
      this.a.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.a != null) {
      this.a.setAlpha(paramInt);
    }
    while (this.c.b.a() == paramInt) {
      return;
    }
    this.c.b.a(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.a != null)
    {
      this.a.setColorFilter(paramColorFilter);
      return;
    }
    this.e = paramColorFilter;
    invalidateSelf();
  }
  
  public void setTint(int paramInt)
  {
    if (this.a != null)
    {
      android.support.v4.d.a.a.a(this.a, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    if (this.a != null) {
      android.support.v4.d.a.a.a(this.a, paramColorStateList);
    }
    f localf;
    do
    {
      return;
      localf = this.c;
    } while (localf.c == paramColorStateList);
    localf.c = paramColorStateList;
    this.d = a(this.d, paramColorStateList, localf.d);
    invalidateSelf();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.a != null) {
      android.support.v4.d.a.a.a(this.a, paramMode);
    }
    f localf;
    do
    {
      return;
      localf = this.c;
    } while (localf.d == paramMode);
    localf.d = paramMode;
    this.d = a(this.d, localf.c, paramMode);
    invalidateSelf();
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a != null) {
      return this.a.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    if (this.a != null)
    {
      this.a.unscheduleSelf(paramRunnable);
      return;
    }
    super.unscheduleSelf(paramRunnable);
  }
  
  private static class a
    extends f.d
  {
    public a() {}
    
    public a(a parama)
    {
      super();
    }
    
    private void a(TypedArray paramTypedArray)
    {
      String str = paramTypedArray.getString(0);
      if (str != null) {
        this.n = str;
      }
      paramTypedArray = paramTypedArray.getString(1);
      if (paramTypedArray != null) {
        this.m = c.a(paramTypedArray);
      }
    }
    
    public void a(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      if (!d.a(paramXmlPullParser, "pathData")) {
        return;
      }
      paramResources = e.b(paramResources, paramTheme, paramAttributeSet, a.d);
      a(paramResources);
      paramResources.recycle();
    }
    
    public boolean a()
    {
      return true;
    }
  }
  
  private static class b
    extends f.d
  {
    int a = 0;
    float b = 0.0F;
    int c = 0;
    float d = 1.0F;
    int e;
    float f = 1.0F;
    float g = 0.0F;
    float h = 1.0F;
    float i = 0.0F;
    Paint.Cap j = Paint.Cap.BUTT;
    Paint.Join k = Paint.Join.MITER;
    float l = 4.0F;
    private int[] p;
    
    public b() {}
    
    public b(b paramb)
    {
      super();
      this.p = paramb.p;
      this.a = paramb.a;
      this.b = paramb.b;
      this.d = paramb.d;
      this.c = paramb.c;
      this.e = paramb.e;
      this.f = paramb.f;
      this.g = paramb.g;
      this.h = paramb.h;
      this.i = paramb.i;
      this.j = paramb.j;
      this.k = paramb.k;
      this.l = paramb.l;
    }
    
    private Paint.Cap a(int paramInt, Paint.Cap paramCap)
    {
      switch (paramInt)
      {
      default: 
        return paramCap;
      case 0: 
        return Paint.Cap.BUTT;
      case 1: 
        return Paint.Cap.ROUND;
      }
      return Paint.Cap.SQUARE;
    }
    
    private Paint.Join a(int paramInt, Paint.Join paramJoin)
    {
      switch (paramInt)
      {
      default: 
        return paramJoin;
      case 0: 
        return Paint.Join.MITER;
      case 1: 
        return Paint.Join.ROUND;
      }
      return Paint.Join.BEVEL;
    }
    
    private void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    {
      this.p = null;
      if (!d.a(paramXmlPullParser, "pathData")) {
        return;
      }
      String str = paramTypedArray.getString(0);
      if (str != null) {
        this.n = str;
      }
      str = paramTypedArray.getString(2);
      if (str != null) {
        this.m = c.a(str);
      }
      this.c = d.b(paramTypedArray, paramXmlPullParser, "fillColor", 1, this.c);
      this.f = d.a(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.f);
      this.j = a(d.a(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1), this.j);
      this.k = a(d.a(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1), this.k);
      this.l = d.a(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.l);
      this.a = d.b(paramTypedArray, paramXmlPullParser, "strokeColor", 3, this.a);
      this.d = d.a(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.d);
      this.b = d.a(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.b);
      this.h = d.a(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.h);
      this.i = d.a(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.i);
      this.g = d.a(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.g);
    }
    
    public void a(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      paramResources = e.b(paramResources, paramTheme, paramAttributeSet, a.c);
      a(paramResources, paramXmlPullParser);
      paramResources.recycle();
    }
  }
  
  private static class c
  {
    final ArrayList<Object> a = new ArrayList();
    private final Matrix b = new Matrix();
    private float c = 0.0F;
    private float d = 0.0F;
    private float e = 0.0F;
    private float f = 1.0F;
    private float g = 1.0F;
    private float h = 0.0F;
    private float i = 0.0F;
    private final Matrix j = new Matrix();
    private int k;
    private int[] l;
    private String m = null;
    
    public c() {}
    
    public c(c paramc, android.support.v4.i.a<String, Object> parama)
    {
      this.c = paramc.c;
      this.d = paramc.d;
      this.e = paramc.e;
      this.f = paramc.f;
      this.g = paramc.g;
      this.h = paramc.h;
      this.i = paramc.i;
      this.l = paramc.l;
      this.m = paramc.m;
      this.k = paramc.k;
      if (this.m != null) {
        parama.put(this.m, this);
      }
      this.j.set(paramc.j);
      ArrayList localArrayList = paramc.a;
      int n = 0;
      while (n < localArrayList.size())
      {
        paramc = localArrayList.get(n);
        if ((paramc instanceof c))
        {
          paramc = (c)paramc;
          this.a.add(new c(paramc, parama));
          n += 1;
        }
        else
        {
          if ((paramc instanceof f.b)) {}
          for (paramc = new f.b((f.b)paramc);; paramc = new f.a((f.a)paramc))
          {
            this.a.add(paramc);
            if (paramc.n == null) {
              break;
            }
            parama.put(paramc.n, paramc);
            break;
            if (!(paramc instanceof f.a)) {
              break label317;
            }
          }
          label317:
          throw new IllegalStateException("Unknown object in the tree!");
        }
      }
    }
    
    private void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    {
      this.l = null;
      this.c = d.a(paramTypedArray, paramXmlPullParser, "rotation", 5, this.c);
      this.d = paramTypedArray.getFloat(1, this.d);
      this.e = paramTypedArray.getFloat(2, this.e);
      this.f = d.a(paramTypedArray, paramXmlPullParser, "scaleX", 3, this.f);
      this.g = d.a(paramTypedArray, paramXmlPullParser, "scaleY", 4, this.g);
      this.h = d.a(paramTypedArray, paramXmlPullParser, "translateX", 6, this.h);
      this.i = d.a(paramTypedArray, paramXmlPullParser, "translateY", 7, this.i);
      paramTypedArray = paramTypedArray.getString(0);
      if (paramTypedArray != null) {
        this.m = paramTypedArray;
      }
      b();
    }
    
    private void b()
    {
      this.j.reset();
      this.j.postTranslate(-this.d, -this.e);
      this.j.postScale(this.f, this.g);
      this.j.postRotate(this.c, 0.0F, 0.0F);
      this.j.postTranslate(this.h + this.d, this.i + this.e);
    }
    
    public String a()
    {
      return this.m;
    }
    
    public void a(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      paramResources = e.b(paramResources, paramTheme, paramAttributeSet, a.b);
      a(paramResources, paramXmlPullParser);
      paramResources.recycle();
    }
  }
  
  private static class d
  {
    protected c.b[] m = null;
    String n;
    int o;
    
    public d() {}
    
    public d(d paramd)
    {
      this.n = paramd.n;
      this.o = paramd.o;
      this.m = c.a(paramd.m);
    }
    
    public void a(Path paramPath)
    {
      paramPath.reset();
      if (this.m != null) {
        c.b.a(this.m, paramPath);
      }
    }
    
    public boolean a()
    {
      return false;
    }
    
    public String b()
    {
      return this.n;
    }
  }
  
  private static class e
  {
    private static final Matrix j = new Matrix();
    float a = 0.0F;
    float b = 0.0F;
    float c = 0.0F;
    float d = 0.0F;
    int e = 255;
    String f = null;
    final android.support.v4.i.a<String, Object> g = new android.support.v4.i.a();
    private final Path h;
    private final Path i;
    private final Matrix k = new Matrix();
    private Paint l;
    private Paint m;
    private PathMeasure n;
    private int o;
    private final f.c p;
    
    public e()
    {
      this.p = new f.c();
      this.h = new Path();
      this.i = new Path();
    }
    
    public e(e parame)
    {
      this.p = new f.c(parame.p, this.g);
      this.h = new Path(parame.h);
      this.i = new Path(parame.i);
      this.a = parame.a;
      this.b = parame.b;
      this.c = parame.c;
      this.d = parame.d;
      this.o = parame.o;
      this.e = parame.e;
      this.f = parame.f;
      if (parame.f != null) {
        this.g.put(parame.f, this);
      }
    }
    
    private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      return paramFloat1 * paramFloat4 - paramFloat2 * paramFloat3;
    }
    
    private float a(Matrix paramMatrix)
    {
      float f1 = 0.0F;
      float[] arrayOfFloat = new float[4];
      float[] tmp9_7 = arrayOfFloat;
      tmp9_7[0] = 0.0F;
      float[] tmp13_9 = tmp9_7;
      tmp13_9[1] = 1.0F;
      float[] tmp17_13 = tmp13_9;
      tmp17_13[2] = 1.0F;
      float[] tmp21_17 = tmp17_13;
      tmp21_17[3] = 0.0F;
      tmp21_17;
      paramMatrix.mapVectors(arrayOfFloat);
      float f3 = (float)Math.hypot(arrayOfFloat[0], arrayOfFloat[1]);
      float f4 = (float)Math.hypot(arrayOfFloat[2], arrayOfFloat[3]);
      float f2 = a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
      f3 = Math.max(f3, f4);
      if (f3 > 0.0F) {
        f1 = Math.abs(f2) / f3;
      }
      return f1;
    }
    
    private void a(f.c paramc, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      f.c.b(paramc).set(paramMatrix);
      f.c.b(paramc).preConcat(f.c.c(paramc));
      int i1 = 0;
      if (i1 < paramc.a.size())
      {
        paramMatrix = paramc.a.get(i1);
        if ((paramMatrix instanceof f.c)) {
          a((f.c)paramMatrix, f.c.b(paramc), paramCanvas, paramInt1, paramInt2, paramColorFilter);
        }
        for (;;)
        {
          i1 += 1;
          break;
          if ((paramMatrix instanceof f.d)) {
            a(paramc, (f.d)paramMatrix, paramCanvas, paramInt1, paramInt2, paramColorFilter);
          }
        }
      }
    }
    
    private void a(f.c paramc, f.d paramd, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      float f2 = paramInt1 / this.c;
      float f3 = paramInt2 / this.d;
      float f1 = Math.min(f2, f3);
      paramc = f.c.b(paramc);
      this.k.set(paramc);
      this.k.postScale(f2, f3);
      f2 = a(paramc);
      if (f2 == 0.0F) {
        return;
      }
      paramd.a(this.h);
      Path localPath = this.h;
      this.i.reset();
      if (paramd.a())
      {
        this.i.addPath(localPath, this.k);
        paramCanvas.clipPath(this.i, Region.Op.REPLACE);
        return;
      }
      paramc = (f.b)paramd;
      float f6;
      float f4;
      if ((paramc.g != 0.0F) || (paramc.h != 1.0F))
      {
        f6 = paramc.g;
        float f7 = paramc.i;
        f4 = paramc.h;
        float f5 = paramc.i;
        if (this.n == null) {
          this.n = new PathMeasure();
        }
        this.n.setPath(this.h, false);
        f3 = this.n.getLength();
        f6 = (f6 + f7) % 1.0F * f3;
        f4 = (f4 + f5) % 1.0F * f3;
        localPath.reset();
        if (f6 <= f4) {
          break label506;
        }
        this.n.getSegment(f6, f3, localPath, true);
        this.n.getSegment(0.0F, f4, localPath, true);
      }
      for (;;)
      {
        localPath.rLineTo(0.0F, 0.0F);
        this.i.addPath(localPath, this.k);
        if (paramc.c != 0)
        {
          if (this.m == null)
          {
            this.m = new Paint();
            this.m.setStyle(Paint.Style.FILL);
            this.m.setAntiAlias(true);
          }
          paramd = this.m;
          paramd.setColor(f.a(paramc.c, paramc.f));
          paramd.setColorFilter(paramColorFilter);
          paramCanvas.drawPath(this.i, paramd);
        }
        if (paramc.a == 0) {
          break;
        }
        if (this.l == null)
        {
          this.l = new Paint();
          this.l.setStyle(Paint.Style.STROKE);
          this.l.setAntiAlias(true);
        }
        paramd = this.l;
        if (paramc.k != null) {
          paramd.setStrokeJoin(paramc.k);
        }
        if (paramc.j != null) {
          paramd.setStrokeCap(paramc.j);
        }
        paramd.setStrokeMiter(paramc.l);
        paramd.setColor(f.a(paramc.a, paramc.d));
        paramd.setColorFilter(paramColorFilter);
        paramd.setStrokeWidth(f2 * f1 * paramc.b);
        paramCanvas.drawPath(this.i, paramd);
        return;
        label506:
        this.n.getSegment(f6, f4, localPath, true);
      }
    }
    
    public int a()
    {
      return this.e;
    }
    
    public void a(float paramFloat)
    {
      a((int)(255.0F * paramFloat));
    }
    
    public void a(int paramInt)
    {
      this.e = paramInt;
    }
    
    public void a(Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      a(this.p, j, paramCanvas, paramInt1, paramInt2, paramColorFilter);
    }
    
    public float b()
    {
      return a() / 255.0F;
    }
  }
  
  private static class f
    extends Drawable.ConstantState
  {
    int a;
    f.e b;
    ColorStateList c = null;
    PorterDuff.Mode d = f.b;
    boolean e;
    Bitmap f;
    ColorStateList g;
    PorterDuff.Mode h;
    int i;
    boolean j;
    boolean k;
    Paint l;
    
    public f()
    {
      this.b = new f.e();
    }
    
    public f(f paramf)
    {
      if (paramf != null)
      {
        this.a = paramf.a;
        this.b = new f.e(paramf.b);
        if (f.e.b(paramf.b) != null) {
          f.e.a(this.b, new Paint(f.e.b(paramf.b)));
        }
        if (f.e.c(paramf.b) != null) {
          f.e.b(this.b, new Paint(f.e.c(paramf.b)));
        }
        this.c = paramf.c;
        this.d = paramf.d;
        this.e = paramf.e;
      }
    }
    
    public Paint a(ColorFilter paramColorFilter)
    {
      if ((!a()) && (paramColorFilter == null)) {
        return null;
      }
      if (this.l == null)
      {
        this.l = new Paint();
        this.l.setFilterBitmap(true);
      }
      this.l.setAlpha(this.b.a());
      this.l.setColorFilter(paramColorFilter);
      return this.l;
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      this.f.eraseColor(0);
      Canvas localCanvas = new Canvas(this.f);
      this.b.a(localCanvas, paramInt1, paramInt2, null);
    }
    
    public void a(Canvas paramCanvas, ColorFilter paramColorFilter, Rect paramRect)
    {
      paramColorFilter = a(paramColorFilter);
      paramCanvas.drawBitmap(this.f, null, paramRect, paramColorFilter);
    }
    
    public boolean a()
    {
      return this.b.a() < 255;
    }
    
    public void b(int paramInt1, int paramInt2)
    {
      if ((this.f == null) || (!c(paramInt1, paramInt2)))
      {
        this.f = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        this.k = true;
      }
    }
    
    public boolean b()
    {
      return (!this.k) && (this.g == this.c) && (this.h == this.d) && (this.j == this.e) && (this.i == this.b.a());
    }
    
    public void c()
    {
      this.g = this.c;
      this.h = this.d;
      this.i = this.b.a();
      this.j = this.e;
      this.k = false;
    }
    
    public boolean c(int paramInt1, int paramInt2)
    {
      return (paramInt1 == this.f.getWidth()) && (paramInt2 == this.f.getHeight());
    }
    
    public int getChangingConfigurations()
    {
      return this.a;
    }
    
    public Drawable newDrawable()
    {
      return new f(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new f(this, null);
    }
  }
  
  private static class g
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState a;
    
    public g(Drawable.ConstantState paramConstantState)
    {
      this.a = paramConstantState;
    }
    
    public boolean canApplyTheme()
    {
      return this.a.canApplyTheme();
    }
    
    public int getChangingConfigurations()
    {
      return this.a.getChangingConfigurations();
    }
    
    public Drawable newDrawable()
    {
      f localf = new f(null);
      localf.a = ((VectorDrawable)this.a.newDrawable());
      return localf;
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      f localf = new f(null);
      localf.a = ((VectorDrawable)this.a.newDrawable(paramResources));
      return localf;
    }
    
    public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      f localf = new f(null);
      localf.a = ((VectorDrawable)this.a.newDrawable(paramResources, paramTheme));
      return localf;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */