package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.support.v4.g.a;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

class e
  extends DataSetObservable
{
  private static final String a = e.class.getSimpleName();
  private static final Object b = new Object();
  private static final Map<String, e> c = new HashMap();
  private final Object d;
  private final List<a> e;
  private final List<c> f;
  private final Context g;
  private final String h;
  private Intent i;
  private b j;
  private int k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private d p;
  
  private boolean a(c paramc)
  {
    boolean bool = this.f.add(paramc);
    if (bool)
    {
      this.n = true;
      i();
      d();
      f();
      notifyChanged();
    }
    return bool;
  }
  
  private void d()
  {
    if (!this.m) {
      throw new IllegalStateException("No preceding call to #readHistoricalData");
    }
    if (!this.n) {}
    do
    {
      return;
      this.n = false;
    } while (TextUtils.isEmpty(this.h));
    a.a(new e(null), new Object[] { new ArrayList(this.f), this.h });
  }
  
  private void e()
  {
    boolean bool1 = g();
    boolean bool2 = h();
    i();
    if ((bool1 | bool2))
    {
      f();
      notifyChanged();
    }
  }
  
  private boolean f()
  {
    if ((this.j != null) && (this.i != null) && (!this.e.isEmpty()) && (!this.f.isEmpty()))
    {
      this.j.a(this.i, this.e, Collections.unmodifiableList(this.f));
      return true;
    }
    return false;
  }
  
  private boolean g()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.o)
    {
      bool1 = bool2;
      if (this.i != null)
      {
        this.o = false;
        this.e.clear();
        List localList = this.g.getPackageManager().queryIntentActivities(this.i, 0);
        int i2 = localList.size();
        int i1 = 0;
        while (i1 < i2)
        {
          ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i1);
          this.e.add(new a(localResolveInfo));
          i1 += 1;
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean h()
  {
    if ((this.l) && (this.n) && (!TextUtils.isEmpty(this.h)))
    {
      this.l = false;
      this.m = true;
      j();
      return true;
    }
    return false;
  }
  
  private void i()
  {
    int i2 = this.f.size() - this.k;
    if (i2 <= 0) {}
    for (;;)
    {
      return;
      this.n = true;
      int i1 = 0;
      while (i1 < i2)
      {
        c localc = (c)this.f.remove(0);
        i1 += 1;
      }
    }
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 71	android/support/v7/widget/e:g	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 98	android/support/v7/widget/e:h	Ljava/lang/String;
    //   8: invokevirtual 194	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_1
    //   12: invokestatic 200	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore_2
    //   16: aload_2
    //   17: aload_1
    //   18: ldc -54
    //   20: invokeinterface 208 3 0
    //   25: iconst_0
    //   26: istore 4
    //   28: iload 4
    //   30: iconst_1
    //   31: if_icmpeq +20 -> 51
    //   34: iload 4
    //   36: iconst_2
    //   37: if_icmpeq +14 -> 51
    //   40: aload_2
    //   41: invokeinterface 211 1 0
    //   46: istore 4
    //   48: goto -20 -> 28
    //   51: ldc -43
    //   53: aload_2
    //   54: invokeinterface 216 1 0
    //   59: invokevirtual 221	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: ifne +53 -> 115
    //   65: new 188	org/xmlpull/v1/XmlPullParserException
    //   68: dup
    //   69: ldc -33
    //   71: invokespecial 224	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: astore_2
    //   76: getstatic 55	android/support/v7/widget/e:a	Ljava/lang/String;
    //   79: new 226	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   86: ldc -27
    //   88: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: getfield 98	android/support/v7/widget/e:h	Ljava/lang/String;
    //   95: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: aload_2
    //   102: invokestatic 241	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   105: pop
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 246	java/io/FileInputStream:close	()V
    //   114: return
    //   115: aload_0
    //   116: getfield 74	android/support/v7/widget/e:f	Ljava/util/List;
    //   119: astore_3
    //   120: aload_3
    //   121: invokeinterface 152 1 0
    //   126: aload_2
    //   127: invokeinterface 211 1 0
    //   132: istore 4
    //   134: iload 4
    //   136: iconst_1
    //   137: if_icmpne +14 -> 151
    //   140: aload_1
    //   141: ifnull -27 -> 114
    //   144: aload_1
    //   145: invokevirtual 246	java/io/FileInputStream:close	()V
    //   148: return
    //   149: astore_1
    //   150: return
    //   151: iload 4
    //   153: iconst_3
    //   154: if_icmpeq -28 -> 126
    //   157: iload 4
    //   159: iconst_4
    //   160: if_icmpeq -34 -> 126
    //   163: ldc -8
    //   165: aload_2
    //   166: invokeinterface 216 1 0
    //   171: invokevirtual 221	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   174: ifne +55 -> 229
    //   177: new 188	org/xmlpull/v1/XmlPullParserException
    //   180: dup
    //   181: ldc -6
    //   183: invokespecial 224	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   186: athrow
    //   187: astore_2
    //   188: getstatic 55	android/support/v7/widget/e:a	Ljava/lang/String;
    //   191: new 226	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   198: ldc -27
    //   200: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_0
    //   204: getfield 98	android/support/v7/widget/e:h	Ljava/lang/String;
    //   207: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: aload_2
    //   214: invokestatic 241	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   217: pop
    //   218: aload_1
    //   219: ifnull -105 -> 114
    //   222: aload_1
    //   223: invokevirtual 246	java/io/FileInputStream:close	()V
    //   226: return
    //   227: astore_1
    //   228: return
    //   229: aload_3
    //   230: new 14	android/support/v7/widget/e$c
    //   233: dup
    //   234: aload_2
    //   235: aconst_null
    //   236: ldc -4
    //   238: invokeinterface 256 3 0
    //   243: aload_2
    //   244: aconst_null
    //   245: ldc_w 258
    //   248: invokeinterface 256 3 0
    //   253: invokestatic 264	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   256: aload_2
    //   257: aconst_null
    //   258: ldc_w 266
    //   261: invokeinterface 256 3 0
    //   266: invokestatic 272	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   269: invokespecial 275	android/support/v7/widget/e$c:<init>	(Ljava/lang/String;JF)V
    //   272: invokeinterface 80 2 0
    //   277: pop
    //   278: goto -152 -> 126
    //   281: astore_2
    //   282: aload_1
    //   283: ifnull +7 -> 290
    //   286: aload_1
    //   287: invokevirtual 246	java/io/FileInputStream:close	()V
    //   290: aload_2
    //   291: athrow
    //   292: astore_1
    //   293: return
    //   294: astore_1
    //   295: goto -5 -> 290
    //   298: astore_1
    //   299: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	e
    //   11	134	1	localFileInputStream	java.io.FileInputStream
    //   149	74	1	localIOException1	IOException
    //   227	60	1	localIOException2	IOException
    //   292	1	1	localIOException3	IOException
    //   294	1	1	localIOException4	IOException
    //   298	1	1	localFileNotFoundException	FileNotFoundException
    //   15	39	2	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   75	91	2	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   187	70	2	localIOException5	IOException
    //   281	10	2	localObject	Object
    //   119	111	3	localList	List
    //   26	135	4	i1	int
    // Exception table:
    //   from	to	target	type
    //   12	25	75	org/xmlpull/v1/XmlPullParserException
    //   40	48	75	org/xmlpull/v1/XmlPullParserException
    //   51	75	75	org/xmlpull/v1/XmlPullParserException
    //   115	126	75	org/xmlpull/v1/XmlPullParserException
    //   126	134	75	org/xmlpull/v1/XmlPullParserException
    //   163	187	75	org/xmlpull/v1/XmlPullParserException
    //   229	278	75	org/xmlpull/v1/XmlPullParserException
    //   144	148	149	java/io/IOException
    //   12	25	187	java/io/IOException
    //   40	48	187	java/io/IOException
    //   51	75	187	java/io/IOException
    //   115	126	187	java/io/IOException
    //   126	134	187	java/io/IOException
    //   163	187	187	java/io/IOException
    //   229	278	187	java/io/IOException
    //   222	226	227	java/io/IOException
    //   12	25	281	finally
    //   40	48	281	finally
    //   51	75	281	finally
    //   76	106	281	finally
    //   115	126	281	finally
    //   126	134	281	finally
    //   163	187	281	finally
    //   188	218	281	finally
    //   229	278	281	finally
    //   110	114	292	java/io/IOException
    //   286	290	294	java/io/IOException
    //   0	12	298	java/io/FileNotFoundException
  }
  
  public int a()
  {
    synchronized (this.d)
    {
      e();
      int i1 = this.e.size();
      return i1;
    }
  }
  
  public int a(ResolveInfo paramResolveInfo)
  {
    for (;;)
    {
      int i1;
      synchronized (this.d)
      {
        e();
        List localList = this.e;
        int i2 = localList.size();
        i1 = 0;
        if (i1 < i2)
        {
          if (((a)localList.get(i1)).a == paramResolveInfo) {
            return i1;
          }
        }
        else {
          return -1;
        }
      }
      i1 += 1;
    }
  }
  
  public ResolveInfo a(int paramInt)
  {
    synchronized (this.d)
    {
      e();
      ResolveInfo localResolveInfo = ((a)this.e.get(paramInt)).a;
      return localResolveInfo;
    }
  }
  
  public Intent b(int paramInt)
  {
    synchronized (this.d)
    {
      if (this.i == null) {
        return null;
      }
      e();
      Object localObject2 = (a)this.e.get(paramInt);
      localObject2 = new ComponentName(((a)localObject2).a.activityInfo.packageName, ((a)localObject2).a.activityInfo.name);
      Intent localIntent1 = new Intent(this.i);
      localIntent1.setComponent((ComponentName)localObject2);
      if (this.p != null)
      {
        Intent localIntent2 = new Intent(localIntent1);
        if (this.p.a(this, localIntent2)) {
          return null;
        }
      }
      a(new c((ComponentName)localObject2, System.currentTimeMillis(), 1.0F));
      return localIntent1;
    }
  }
  
  public ResolveInfo b()
  {
    synchronized (this.d)
    {
      e();
      if (!this.e.isEmpty())
      {
        ResolveInfo localResolveInfo = ((a)this.e.get(0)).a;
        return localResolveInfo;
      }
      return null;
    }
  }
  
  public void c(int paramInt)
  {
    for (;;)
    {
      synchronized (this.d)
      {
        e();
        a locala1 = (a)this.e.get(paramInt);
        a locala2 = (a)this.e.get(0);
        if (locala2 != null)
        {
          f1 = locala2.b - locala1.b + 5.0F;
          a(new c(new ComponentName(locala1.a.activityInfo.packageName, locala1.a.activityInfo.name), System.currentTimeMillis(), f1));
          return;
        }
      }
      float f1 = 1.0F;
    }
  }
  
  public final class a
    implements Comparable<a>
  {
    public final ResolveInfo a;
    public float b;
    
    public a(ResolveInfo paramResolveInfo)
    {
      this.a = paramResolveInfo;
    }
    
    public int a(a parama)
    {
      return Float.floatToIntBits(parama.b) - Float.floatToIntBits(this.b);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (a)paramObject;
      } while (Float.floatToIntBits(this.b) == Float.floatToIntBits(((a)paramObject).b));
      return false;
    }
    
    public int hashCode()
    {
      return Float.floatToIntBits(this.b) + 31;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("resolveInfo:").append(this.a.toString());
      localStringBuilder.append("; weight:").append(new BigDecimal(this.b));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(Intent paramIntent, List<e.a> paramList, List<e.c> paramList1);
  }
  
  public static final class c
  {
    public final ComponentName a;
    public final long b;
    public final float c;
    
    public c(ComponentName paramComponentName, long paramLong, float paramFloat)
    {
      this.a = paramComponentName;
      this.b = paramLong;
      this.c = paramFloat;
    }
    
    public c(String paramString, long paramLong, float paramFloat)
    {
      this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
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
        if (this.a == null)
        {
          if (((c)paramObject).a != null) {
            return false;
          }
        }
        else if (!this.a.equals(((c)paramObject).a)) {
          return false;
        }
        if (this.b != ((c)paramObject).b) {
          return false;
        }
      } while (Float.floatToIntBits(this.c) == Float.floatToIntBits(((c)paramObject).c));
      return false;
    }
    
    public int hashCode()
    {
      if (this.a == null) {}
      for (int i = 0;; i = this.a.hashCode()) {
        return ((i + 31) * 31 + (int)(this.b ^ this.b >>> 32)) * 31 + Float.floatToIntBits(this.c);
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("; activity:").append(this.a);
      localStringBuilder.append("; time:").append(this.b);
      localStringBuilder.append("; weight:").append(new BigDecimal(this.c));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean a(e parame, Intent paramIntent);
  }
  
  private final class e
    extends AsyncTask<Object, Void, Void>
  {
    private e() {}
    
    public Void a(Object... paramVarArgs)
    {
      int i = 0;
      List localList = (List)paramVarArgs[0];
      Object localObject2 = (String)paramVarArgs[1];
      for (;;)
      {
        try
        {
          paramVarArgs = e.a(e.this).openFileOutput((String)localObject2, 0);
          localObject2 = Xml.newSerializer();
          int j;
          e.c localc;
          ((XmlSerializer)localObject2).endTag(null, "historical-records");
        }
        catch (FileNotFoundException paramVarArgs)
        {
          try
          {
            ((XmlSerializer)localObject2).setOutput(paramVarArgs, null);
            ((XmlSerializer)localObject2).startDocument("UTF-8", Boolean.valueOf(true));
            ((XmlSerializer)localObject2).startTag(null, "historical-records");
            j = localList.size();
            if (i >= j) {
              break label204;
            }
            localc = (e.c)localList.remove(0);
            ((XmlSerializer)localObject2).startTag(null, "historical-record");
            ((XmlSerializer)localObject2).attribute(null, "activity", localc.a.flattenToString());
            ((XmlSerializer)localObject2).attribute(null, "time", String.valueOf(localc.b));
            ((XmlSerializer)localObject2).attribute(null, "weight", String.valueOf(localc.c));
            ((XmlSerializer)localObject2).endTag(null, "historical-record");
            i += 1;
            continue;
            paramVarArgs = paramVarArgs;
            Log.e(e.c(), "Error writing historical recrod file: " + (String)localObject2, paramVarArgs);
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            Log.e(e.c(), "Error writing historical recrod file: " + e.b(e.this), localIllegalArgumentException);
            e.a(e.this, true);
            if (paramVarArgs == null) {
              continue;
            }
            try
            {
              paramVarArgs.close();
              return null;
            }
            catch (IOException paramVarArgs)
            {
              return null;
            }
          }
          catch (IllegalStateException localIllegalStateException)
          {
            Log.e(e.c(), "Error writing historical recrod file: " + e.b(e.this), localIllegalStateException);
            e.a(e.this, true);
            if (paramVarArgs == null) {
              continue;
            }
            try
            {
              paramVarArgs.close();
              return null;
            }
            catch (IOException paramVarArgs)
            {
              return null;
            }
          }
          catch (IOException localIOException)
          {
            Log.e(e.c(), "Error writing historical recrod file: " + e.b(e.this), localIOException);
            e.a(e.this, true);
            if (paramVarArgs == null) {
              continue;
            }
            try
            {
              paramVarArgs.close();
              return null;
            }
            catch (IOException paramVarArgs)
            {
              return null;
            }
          }
          finally
          {
            e.a(e.this, true);
            if (paramVarArgs == null) {
              break label428;
            }
          }
          return null;
        }
        label204:
        ((XmlSerializer)localObject2).endDocument();
        e.a(e.this, true);
        if (paramVarArgs != null) {
          try
          {
            paramVarArgs.close();
            return null;
          }
          catch (IOException paramVarArgs)
          {
            return null;
          }
        }
      }
      try
      {
        paramVarArgs.close();
        label428:
        throw ((Throwable)localObject1);
      }
      catch (IOException paramVarArgs)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */