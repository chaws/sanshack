package com.parse;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.SSLSessionCache;
import android.os.Build.VERSION;
import com.parse.a.b;
import com.parse.a.b.a;
import com.parse.a.c;
import com.parse.a.d;
import com.parse.a.d.a;
import java.io.File;

class ParsePlugins
{
  private static final String INSTALLATION_ID_LOCATION = "installationId";
  private static final Object LOCK = new Object();
  private static ParsePlugins instance;
  private final String applicationId;
  File cacheDir;
  private final String clientKey;
  File filesDir;
  private InstallationId installationId;
  final Object lock = new Object();
  File parseDir;
  private ParseHttpClient restClient;
  
  private ParsePlugins(String paramString1, String paramString2)
  {
    this.applicationId = paramString1;
    this.clientKey = paramString2;
  }
  
  private static File createFileDir(File paramFile)
  {
    if ((!paramFile.exists()) && (!paramFile.mkdirs())) {}
    return paramFile;
  }
  
  static ParsePlugins get()
  {
    synchronized (LOCK)
    {
      ParsePlugins localParsePlugins = instance;
      return localParsePlugins;
    }
  }
  
  static void initialize(String paramString1, String paramString2)
  {
    set(new ParsePlugins(paramString1, paramString2));
  }
  
  static void reset()
  {
    synchronized (LOCK)
    {
      instance = null;
      return;
    }
  }
  
  static void set(ParsePlugins paramParsePlugins)
  {
    synchronized (LOCK)
    {
      if (instance != null) {
        throw new IllegalStateException("ParsePlugins is already initialized");
      }
    }
    instance = paramParsePlugins;
  }
  
  String applicationId()
  {
    return this.applicationId;
  }
  
  String clientKey()
  {
    return this.clientKey;
  }
  
  File getCacheDir()
  {
    throw new IllegalStateException("Stub");
  }
  
  File getFilesDir()
  {
    throw new IllegalStateException("Stub");
  }
  
  @Deprecated
  File getParseDir()
  {
    throw new IllegalStateException("Stub");
  }
  
  InstallationId installationId()
  {
    synchronized (this.lock)
    {
      if (this.installationId == null) {
        this.installationId = new InstallationId(new File(getParseDir(), "installationId"));
      }
      InstallationId localInstallationId = this.installationId;
      return localInstallationId;
    }
  }
  
  ParseHttpClient newHttpClient()
  {
    return ParseHttpClient.createClient(10000, null);
  }
  
  ParseHttpClient restClient()
  {
    synchronized (this.lock)
    {
      if (this.restClient == null)
      {
        this.restClient = newHttpClient();
        this.restClient.addInternalInterceptor(new d()
        {
          public c intercept(d.a paramAnonymousa)
          {
            b localb = paramAnonymousa.getRequest();
            b.a locala = new b.a(localb).a("X-Parse-Application-Id", ParsePlugins.this.applicationId).a("X-Parse-Client-Key", ParsePlugins.this.clientKey).a("X-Parse-Client-Version", Parse.externalVersionName()).a("X-Parse-App-Build-Version", String.valueOf(ManifestInfo.getVersionCode())).a("X-Parse-App-Display-Version", ManifestInfo.getVersionName()).a("X-Parse-OS-Version", Build.VERSION.RELEASE).a("User-Agent", ParsePlugins.this.userAgent());
            if (localb.a("X-Parse-Installation-Id") == null) {
              locala.a("X-Parse-Installation-Id", ParsePlugins.this.installationId().get());
            }
            return paramAnonymousa.proceed(locala.a());
          }
        });
      }
      ParseHttpClient localParseHttpClient = this.restClient;
      return localParseHttpClient;
    }
  }
  
  String userAgent()
  {
    return "Parse Java SDK";
  }
  
  static class Android
    extends ParsePlugins
  {
    private final Context applicationContext;
    
    private Android(Context paramContext, String paramString1, String paramString2)
    {
      super(paramString2, null);
      this.applicationContext = paramContext.getApplicationContext();
    }
    
    static Android get()
    {
      return (Android)ParsePlugins.get();
    }
    
    static void initialize(Context paramContext, String paramString1, String paramString2)
    {
      ParsePlugins.set(new Android(paramContext, paramString1, paramString2));
    }
    
    Context applicationContext()
    {
      return this.applicationContext;
    }
    
    File getCacheDir()
    {
      synchronized (this.lock)
      {
        if (this.cacheDir == null) {
          this.cacheDir = new File(this.applicationContext.getCacheDir(), "com.parse");
        }
        File localFile = ParsePlugins.createFileDir(this.cacheDir);
        return localFile;
      }
    }
    
    File getFilesDir()
    {
      synchronized (this.lock)
      {
        if (this.filesDir == null) {
          this.filesDir = new File(this.applicationContext.getFilesDir(), "com.parse");
        }
        File localFile = ParsePlugins.createFileDir(this.filesDir);
        return localFile;
      }
    }
    
    File getParseDir()
    {
      synchronized (this.lock)
      {
        if (this.parseDir == null) {
          this.parseDir = this.applicationContext.getDir("Parse", 0);
        }
        File localFile = ParsePlugins.createFileDir(this.parseDir);
        return localFile;
      }
    }
    
    public ParseHttpClient newHttpClient()
    {
      return ParseHttpClient.createClient(10000, new SSLSessionCache(this.applicationContext));
    }
    
    String userAgent()
    {
      Object localObject = "unknown";
      try
      {
        String str = this.applicationContext.getPackageName();
        int i = this.applicationContext.getPackageManager().getPackageInfo(str, 0).versionCode;
        str = str + "/" + i;
        localObject = str;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;) {}
      }
      return "Parse Android SDK 1.13.1 (" + (String)localObject + ") API Level " + Build.VERSION.SDK_INT;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParsePlugins.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */