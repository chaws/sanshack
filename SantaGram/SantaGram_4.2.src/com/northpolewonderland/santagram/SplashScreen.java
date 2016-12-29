package com.northpolewonderland.santagram;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.support.v7.a.e;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import java.io.File;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class SplashScreen
  extends e
{
  private static String TAG = "SantaGram";
  private static int splashInterval = 2000;
  Thread.UncaughtExceptionHandler paramThrowable;
  
  /* Error */
  private float cpuUsage()
  {
    // Byte code:
    //   0: new 38	java/io/RandomAccessFile
    //   3: dup
    //   4: ldc 40
    //   6: ldc 42
    //   8: invokespecial 45	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual 49	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   16: ldc 51
    //   18: invokevirtual 57	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   21: astore_2
    //   22: aload_2
    //   23: iconst_4
    //   24: aaload
    //   25: invokestatic 63	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   28: lstore_3
    //   29: aload_2
    //   30: iconst_2
    //   31: aaload
    //   32: invokestatic 63	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   35: lstore 5
    //   37: aload_2
    //   38: iconst_3
    //   39: aaload
    //   40: invokestatic 63	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   43: lstore 7
    //   45: aload_2
    //   46: iconst_5
    //   47: aaload
    //   48: invokestatic 63	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   51: lstore 9
    //   53: aload_2
    //   54: bipush 6
    //   56: aaload
    //   57: invokestatic 63	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   60: lstore 11
    //   62: aload_2
    //   63: bipush 7
    //   65: aaload
    //   66: invokestatic 63	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   69: lstore 13
    //   71: aload_2
    //   72: bipush 8
    //   74: aaload
    //   75: invokestatic 63	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   78: lstore 15
    //   80: lload 5
    //   82: lload 7
    //   84: ladd
    //   85: lload 9
    //   87: ladd
    //   88: lload 11
    //   90: ladd
    //   91: lload 13
    //   93: ladd
    //   94: lload 15
    //   96: ladd
    //   97: lstore 5
    //   99: ldc2_w 64
    //   102: invokestatic 71	java/lang/Thread:sleep	(J)V
    //   105: aload_1
    //   106: lconst_0
    //   107: invokevirtual 74	java/io/RandomAccessFile:seek	(J)V
    //   110: aload_1
    //   111: invokevirtual 49	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   114: astore_2
    //   115: aload_1
    //   116: invokevirtual 77	java/io/RandomAccessFile:close	()V
    //   119: aload_2
    //   120: ldc 51
    //   122: invokevirtual 57	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   125: astore_1
    //   126: aload_1
    //   127: iconst_4
    //   128: aaload
    //   129: invokestatic 63	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   132: lstore 7
    //   134: aload_1
    //   135: iconst_2
    //   136: aaload
    //   137: invokestatic 63	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   140: lstore 9
    //   142: aload_1
    //   143: iconst_3
    //   144: aaload
    //   145: invokestatic 63	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   148: lstore 11
    //   150: aload_1
    //   151: iconst_5
    //   152: aaload
    //   153: invokestatic 63	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   156: lstore 13
    //   158: aload_1
    //   159: bipush 6
    //   161: aaload
    //   162: invokestatic 63	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   165: lstore 15
    //   167: aload_1
    //   168: bipush 7
    //   170: aaload
    //   171: invokestatic 63	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   174: lstore 17
    //   176: aload_1
    //   177: bipush 8
    //   179: aaload
    //   180: invokestatic 63	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   183: lstore 19
    //   185: lload 19
    //   187: lload 9
    //   189: lload 11
    //   191: ladd
    //   192: lload 13
    //   194: ladd
    //   195: lload 15
    //   197: ladd
    //   198: lload 17
    //   200: ladd
    //   201: ladd
    //   202: lstore 9
    //   204: lload 9
    //   206: lload 5
    //   208: lsub
    //   209: l2f
    //   210: lload 9
    //   212: lload 7
    //   214: ladd
    //   215: lload_3
    //   216: lload 5
    //   218: ladd
    //   219: lsub
    //   220: l2f
    //   221: fdiv
    //   222: freturn
    //   223: astore_1
    //   224: aload_1
    //   225: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   228: fconst_0
    //   229: freturn
    //   230: astore_2
    //   231: goto -126 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	SplashScreen
    //   11	166	1	localObject1	Object
    //   223	2	1	localIOException	java.io.IOException
    //   21	99	2	localObject2	Object
    //   230	1	2	localException	Exception
    //   28	188	3	l1	long
    //   35	182	5	l2	long
    //   43	170	7	l3	long
    //   51	160	9	l4	long
    //   60	130	11	l5	long
    //   69	124	13	l6	long
    //   78	118	15	l7	long
    //   174	25	17	l8	long
    //   183	3	19	l9	long
    // Exception table:
    //   from	to	target	type
    //   0	80	223	java/io/IOException
    //   99	105	223	java/io/IOException
    //   105	185	223	java/io/IOException
    //   99	105	230	java/lang/Exception
  }
  
  private void postDeviceAnalyticsData()
  {
    final JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("username", "guest");
      localJSONObject.put("password", "busyreindeer78");
      localJSONObject.put("type", "launch");
      localJSONObject.put("model", Build.MODEL);
      localJSONObject.put("sdkint", Build.VERSION.SDK_INT);
      localJSONObject.put("device", Build.DEVICE);
      localJSONObject.put("product", Build.PRODUCT);
      localJSONObject.put("manuf", Build.MANUFACTURER);
      localJSONObject.put("lversion", System.getProperty("os.version"));
      localJSONObject.put("screenDensityW", getWindow().getWindowManager().getDefaultDisplay().getWidth());
      localJSONObject.put("screenDensityH", getWindow().getWindowManager().getDefaultDisplay().getHeight());
      localJSONObject.put("locale", Locale.getDefault().getISO3Country());
      localJSONObject.put("appVersion", getString(2131165207));
      localJSONObject.put("udid", Settings.Secure.getString(getContentResolver(), "android_id"));
      new Thread(new Runnable()
      {
        public void run()
        {
          b.a(SplashScreen.this.getString(2131165205), localJSONObject);
        }
      }).start();
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e(TAG, "Error in postDeviceAnalyticsData: " + localJSONException.getMessage());
    }
  }
  
  private void postExceptionData(Throwable paramThrowable1)
  {
    final JSONObject localJSONObject1 = new JSONObject();
    Log.i(getString(2131165204), "Exception: sending exception data to " + getString(2131165216));
    try
    {
      localJSONObject1.put("operation", "WriteCrashDump");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("message", paramThrowable1.getMessage());
      localJSONObject2.put("lmessage", paramThrowable1.getLocalizedMessage());
      localJSONObject2.put("strace", Log.getStackTraceString(paramThrowable1));
      localJSONObject2.put("model", Build.MODEL);
      localJSONObject2.put("sdkint", String.valueOf(Build.VERSION.SDK_INT));
      localJSONObject2.put("device", Build.DEVICE);
      localJSONObject2.put("product", Build.PRODUCT);
      localJSONObject2.put("lversion", System.getProperty("os.version"));
      localJSONObject2.put("vmheapsz", String.valueOf(Runtime.getRuntime().totalMemory()));
      localJSONObject2.put("vmallocmem", String.valueOf(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
      localJSONObject2.put("vmheapszlimit", String.valueOf(Runtime.getRuntime().maxMemory()));
      localJSONObject2.put("natallocmem", String.valueOf(Debug.getNativeHeapAllocatedSize()));
      localJSONObject2.put("cpuusage", String.valueOf(cpuUsage()));
      localJSONObject2.put("totalstor", String.valueOf(totalStorage()));
      localJSONObject2.put("freestor", String.valueOf(freeStorage()));
      localJSONObject2.put("busystor", String.valueOf(busyStorage()));
      localJSONObject2.put("udid", Settings.Secure.getString(getContentResolver(), "android_id"));
      localJSONObject1.put("data", localJSONObject2);
      new Thread(new Runnable()
      {
        public void run()
        {
          b.a(SplashScreen.this.getString(2131165216), localJSONObject1);
        }
      }).start();
      return;
    }
    catch (JSONException paramThrowable1)
    {
      Log.e(TAG, "Error posting message to " + getString(2131165216) + " -- " + paramThrowable1.getMessage());
    }
  }
  
  public long busyStorage()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
    long l1 = localStatFs.getBlockCountLong();
    long l2 = localStatFs.getBlockSizeLong();
    long l3 = localStatFs.getAvailableBlocksLong();
    return l1 * l2 - localStatFs.getBlockSizeLong() * l3;
  }
  
  public long freeStorage()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
    long l = localStatFs.getAvailableBlocksLong();
    return localStatFs.getBlockSizeLong() * l;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
    {
      public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
      {
        b.a(SplashScreen.this.getApplicationContext(), paramAnonymousThrowable);
        try
        {
          Thread.sleep(10000L);
          System.exit(0);
          return;
        }
        catch (InterruptedException paramAnonymousThread)
        {
          for (;;)
          {
            paramAnonymousThread.printStackTrace();
          }
        }
      }
    });
    b.a(getApplicationContext(), getClass().getSimpleName());
    postDeviceAnalyticsData();
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    setContentView(2130968640);
    new Handler().postDelayed(new Runnable()
    {
      private void a() {}
      
      public void run()
      {
        Intent localIntent = new Intent(SplashScreen.this, Home.class);
        SplashScreen.this.startActivity(localIntent);
        a();
      }
    }, splashInterval);
  }
  
  public long totalStorage()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
    long l = localStatFs.getBlockCountLong();
    return localStatFs.getBlockSizeLong() * l;
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/northpolewonderland/santagram/SplashScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */