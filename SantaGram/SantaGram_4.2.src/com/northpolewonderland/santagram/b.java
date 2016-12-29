package com.northpolewonderland.santagram;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.util.Log;
import android.util.TypedValue;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static String a = "SantaGram";
  
  /* Error */
  private static float a()
  {
    // Byte code:
    //   0: new 24	java/io/RandomAccessFile
    //   3: dup
    //   4: ldc 26
    //   6: ldc 28
    //   8: invokespecial 32	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: invokevirtual 36	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   16: ldc 38
    //   18: invokevirtual 44	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   21: astore_1
    //   22: aload_1
    //   23: iconst_4
    //   24: aaload
    //   25: invokestatic 50	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   28: lstore_2
    //   29: aload_1
    //   30: iconst_2
    //   31: aaload
    //   32: invokestatic 50	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   35: lstore 4
    //   37: aload_1
    //   38: iconst_3
    //   39: aaload
    //   40: invokestatic 50	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   43: lstore 6
    //   45: aload_1
    //   46: iconst_5
    //   47: aaload
    //   48: invokestatic 50	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   51: lstore 8
    //   53: aload_1
    //   54: bipush 6
    //   56: aaload
    //   57: invokestatic 50	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   60: lstore 10
    //   62: aload_1
    //   63: bipush 7
    //   65: aaload
    //   66: invokestatic 50	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   69: lstore 12
    //   71: aload_1
    //   72: bipush 8
    //   74: aaload
    //   75: invokestatic 50	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   78: lstore 14
    //   80: lload 4
    //   82: lload 6
    //   84: ladd
    //   85: lload 8
    //   87: ladd
    //   88: lload 10
    //   90: ladd
    //   91: lload 12
    //   93: ladd
    //   94: lload 14
    //   96: ladd
    //   97: lstore 4
    //   99: ldc2_w 51
    //   102: invokestatic 58	java/lang/Thread:sleep	(J)V
    //   105: aload_0
    //   106: lconst_0
    //   107: invokevirtual 61	java/io/RandomAccessFile:seek	(J)V
    //   110: aload_0
    //   111: invokevirtual 36	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   114: astore_1
    //   115: aload_0
    //   116: invokevirtual 64	java/io/RandomAccessFile:close	()V
    //   119: aload_1
    //   120: ldc 38
    //   122: invokevirtual 44	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   125: astore_0
    //   126: aload_0
    //   127: iconst_4
    //   128: aaload
    //   129: invokestatic 50	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   132: lstore 6
    //   134: aload_0
    //   135: iconst_2
    //   136: aaload
    //   137: invokestatic 50	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   140: lstore 8
    //   142: aload_0
    //   143: iconst_3
    //   144: aaload
    //   145: invokestatic 50	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   148: lstore 10
    //   150: aload_0
    //   151: iconst_5
    //   152: aaload
    //   153: invokestatic 50	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   156: lstore 12
    //   158: aload_0
    //   159: bipush 6
    //   161: aaload
    //   162: invokestatic 50	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   165: lstore 14
    //   167: aload_0
    //   168: bipush 7
    //   170: aaload
    //   171: invokestatic 50	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   174: lstore 16
    //   176: aload_0
    //   177: bipush 8
    //   179: aaload
    //   180: invokestatic 50	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   183: lstore 18
    //   185: lload 18
    //   187: lload 8
    //   189: lload 10
    //   191: ladd
    //   192: lload 12
    //   194: ladd
    //   195: lload 14
    //   197: ladd
    //   198: lload 16
    //   200: ladd
    //   201: ladd
    //   202: lstore 8
    //   204: lload 8
    //   206: lload 4
    //   208: lsub
    //   209: l2f
    //   210: lload 8
    //   212: lload 6
    //   214: ladd
    //   215: lload_2
    //   216: lload 4
    //   218: ladd
    //   219: lsub
    //   220: l2f
    //   221: fdiv
    //   222: freturn
    //   223: astore_0
    //   224: aload_0
    //   225: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   228: fconst_0
    //   229: freturn
    //   230: astore_1
    //   231: goto -126 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	166	0	localObject1	Object
    //   223	2	0	localIOException	java.io.IOException
    //   21	99	1	localObject2	Object
    //   230	1	1	localException	Exception
    //   28	188	2	l1	long
    //   35	182	4	l2	long
    //   43	170	6	l3	long
    //   51	160	8	l4	long
    //   60	130	10	l5	long
    //   69	124	12	l6	long
    //   78	118	14	l7	long
    //   174	25	16	l8	long
    //   183	3	18	l9	long
    // Exception table:
    //   from	to	target	type
    //   0	80	223	java/io/IOException
    //   99	105	223	java/io/IOException
    //   105	185	223	java/io/IOException
    //   99	105	230	java/lang/Exception
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getDisplayMetrics());
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    int i = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      k /= 2;
      m /= 2;
      for (;;)
      {
        j = i;
        if (k / i <= paramInt2) {
          break;
        }
        j = i;
        if (m / i <= paramInt1) {
          break;
        }
        i *= 2;
      }
    }
    return j;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    paramFloat = Math.min(paramFloat / paramBitmap.getWidth(), paramFloat / paramBitmap.getHeight());
    if (paramFloat > 1.0F) {
      return paramBitmap;
    }
    return Bitmap.createScaledBitmap(paramBitmap, Math.round(paramBitmap.getWidth() * paramFloat), Math.round(paramFloat * paramBitmap.getHeight()), false);
  }
  
  public static Bitmap a(byte[] paramArrayOfByte, Context paramContext, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    localOptions.inSampleSize = a(localOptions, a(paramContext, paramInt1), a(paramContext, paramInt2));
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    final JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("username", "guest");
      localJSONObject.put("password", "busyreindeer78");
      localJSONObject.put("type", "usage");
      localJSONObject.put("activity", paramString);
      localJSONObject.put("udid", Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
      new Thread(new Runnable()
      {
        public void run()
        {
          b.a(this.a.getString(2131165206), localJSONObject);
        }
      }).start();
      return;
    }
    catch (Exception paramContext)
    {
      Log.e(a, paramContext.getMessage());
    }
  }
  
  public static void a(Context paramContext, Throwable paramThrowable)
  {
    final JSONObject localJSONObject1 = new JSONObject();
    Log.i(paramContext.getString(2131165204), "Exception: sending exception data to " + paramContext.getString(2131165216));
    try
    {
      localJSONObject1.put("operation", "WriteCrashDump");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("message", paramThrowable.getMessage());
      localJSONObject2.put("lmessage", paramThrowable.getLocalizedMessage());
      localJSONObject2.put("strace", Log.getStackTraceString(paramThrowable));
      localJSONObject2.put("model", Build.MODEL);
      localJSONObject2.put("sdkint", String.valueOf(Build.VERSION.SDK_INT));
      localJSONObject2.put("device", Build.DEVICE);
      localJSONObject2.put("product", Build.PRODUCT);
      localJSONObject2.put("lversion", System.getProperty("os.version"));
      localJSONObject2.put("vmheapsz", String.valueOf(Runtime.getRuntime().totalMemory()));
      localJSONObject2.put("vmallocmem", String.valueOf(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
      localJSONObject2.put("vmheapszlimit", String.valueOf(Runtime.getRuntime().maxMemory()));
      localJSONObject2.put("natallocmem", String.valueOf(Debug.getNativeHeapAllocatedSize()));
      localJSONObject2.put("cpuusage", String.valueOf(a()));
      localJSONObject2.put("totalstor", String.valueOf(b()));
      localJSONObject2.put("freestor", String.valueOf(c()));
      localJSONObject2.put("busystor", String.valueOf(d()));
      localJSONObject2.put("udid", Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
      localJSONObject1.put("data", localJSONObject2);
      new Thread(new Runnable()
      {
        public void run()
        {
          b.a(this.a.getString(2131165216), localJSONObject1);
        }
      }).start();
      return;
    }
    catch (JSONException paramThrowable)
    {
      Log.e(a, "Error posting message to " + paramContext.getString(2131165216) + " -- " + paramThrowable.getMessage());
    }
  }
  
  /* Error */
  public static void a(String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 339	java/net/URL
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 342	java/net/URL:<init>	(Ljava/lang/String;)V
    //   12: invokevirtual 346	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   15: checkcast 348	java/net/HttpURLConnection
    //   18: astore_0
    //   19: aload_0
    //   20: sipush 10000
    //   23: invokevirtual 352	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   26: aload_0
    //   27: sipush 15000
    //   30: invokevirtual 355	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   33: aload_0
    //   34: ldc_w 357
    //   37: ldc_w 359
    //   40: invokevirtual 362	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: iconst_1
    //   45: invokevirtual 366	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   48: aload_0
    //   49: ldc_w 368
    //   52: invokevirtual 371	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   55: new 373	java/io/BufferedOutputStream
    //   58: dup
    //   59: aload_0
    //   60: invokevirtual 377	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   63: invokespecial 380	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   66: astore_2
    //   67: new 382	java/io/BufferedWriter
    //   70: dup
    //   71: new 384	java/io/OutputStreamWriter
    //   74: dup
    //   75: aload_2
    //   76: ldc_w 386
    //   79: invokespecial 389	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   82: invokespecial 392	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   85: astore_3
    //   86: aload_3
    //   87: aload_1
    //   88: invokevirtual 393	org/json/JSONObject:toString	()Ljava/lang/String;
    //   91: invokevirtual 396	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   94: aload_3
    //   95: invokevirtual 397	java/io/BufferedWriter:close	()V
    //   98: aload_2
    //   99: invokevirtual 400	java/io/OutputStream:close	()V
    //   102: aload_0
    //   103: invokevirtual 403	java/net/HttpURLConnection:getResponseCode	()I
    //   106: istore 4
    //   108: iload 4
    //   110: tableswitch	default:+26->136, 200:+35->145, 201:+35->145, 202:+35->145
    //   136: aload_0
    //   137: ifnull +7 -> 144
    //   140: aload_0
    //   141: invokevirtual 406	java/net/HttpURLConnection:disconnect	()V
    //   144: return
    //   145: new 408	java/io/BufferedReader
    //   148: dup
    //   149: new 410	java/io/InputStreamReader
    //   152: dup
    //   153: aload_0
    //   154: invokevirtual 414	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   157: invokespecial 417	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   160: invokespecial 420	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   163: astore_1
    //   164: new 422	java/lang/StringBuffer
    //   167: dup
    //   168: invokespecial 423	java/lang/StringBuffer:<init>	()V
    //   171: astore_2
    //   172: aload_1
    //   173: invokevirtual 424	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   176: astore_3
    //   177: aload_3
    //   178: ifnull +34 -> 212
    //   181: aload_2
    //   182: aload_3
    //   183: invokevirtual 427	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   186: pop
    //   187: goto -15 -> 172
    //   190: astore_1
    //   191: aload_0
    //   192: astore_2
    //   193: aload_1
    //   194: invokevirtual 428	java/lang/Exception:printStackTrace	()V
    //   197: aload_0
    //   198: ifnull -54 -> 144
    //   201: aload_0
    //   202: invokevirtual 406	java/net/HttpURLConnection:disconnect	()V
    //   205: return
    //   206: astore_0
    //   207: aload_0
    //   208: invokevirtual 428	java/lang/Exception:printStackTrace	()V
    //   211: return
    //   212: aload_1
    //   213: invokevirtual 429	java/io/BufferedReader:close	()V
    //   216: aload_0
    //   217: ifnull -73 -> 144
    //   220: aload_0
    //   221: invokevirtual 406	java/net/HttpURLConnection:disconnect	()V
    //   224: return
    //   225: astore_0
    //   226: aload_0
    //   227: invokevirtual 428	java/lang/Exception:printStackTrace	()V
    //   230: return
    //   231: astore_0
    //   232: aload_0
    //   233: invokevirtual 428	java/lang/Exception:printStackTrace	()V
    //   236: return
    //   237: astore_0
    //   238: aload_2
    //   239: astore_1
    //   240: aload_1
    //   241: ifnull +7 -> 248
    //   244: aload_1
    //   245: invokevirtual 406	java/net/HttpURLConnection:disconnect	()V
    //   248: aload_0
    //   249: athrow
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 428	java/lang/Exception:printStackTrace	()V
    //   255: goto -7 -> 248
    //   258: astore_2
    //   259: aload_0
    //   260: astore_1
    //   261: aload_2
    //   262: astore_0
    //   263: goto -23 -> 240
    //   266: astore_1
    //   267: aload_3
    //   268: astore_0
    //   269: goto -78 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramString	String
    //   0	272	1	paramJSONObject	JSONObject
    //   1	238	2	localObject1	Object
    //   258	4	2	localObject2	Object
    //   3	265	3	localObject3	Object
    //   106	3	4	i	int
    // Exception table:
    //   from	to	target	type
    //   19	108	190	java/lang/Exception
    //   145	172	190	java/lang/Exception
    //   172	177	190	java/lang/Exception
    //   181	187	190	java/lang/Exception
    //   212	216	190	java/lang/Exception
    //   201	205	206	java/lang/Exception
    //   220	224	225	java/lang/Exception
    //   140	144	231	java/lang/Exception
    //   4	19	237	finally
    //   193	197	237	finally
    //   244	248	250	java/lang/Exception
    //   19	108	258	finally
    //   145	172	258	finally
    //   172	177	258	finally
    //   181	187	258	finally
    //   212	216	258	finally
    //   4	19	266	java/lang/Exception
  }
  
  private static long b()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
    long l = localStatFs.getBlockCountLong();
    return localStatFs.getBlockSizeLong() * l;
  }
  
  private static long c()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
    long l = localStatFs.getAvailableBlocksLong();
    return localStatFs.getBlockSizeLong() * l;
  }
  
  private static long d()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
    long l1 = localStatFs.getBlockCountLong();
    long l2 = localStatFs.getBlockSizeLong();
    long l3 = localStatFs.getAvailableBlocksLong();
    return l1 * l2 - localStatFs.getBlockSizeLong() * l3;
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/northpolewonderland/santagram/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */