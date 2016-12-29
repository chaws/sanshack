package com.parse;

import a.h;
import a.j;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.parse.a.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class Parse
{
  public static final int LOG_LEVEL_DEBUG = 3;
  public static final int LOG_LEVEL_ERROR = 6;
  public static final int LOG_LEVEL_INFO = 4;
  public static final int LOG_LEVEL_NONE = Integer.MAX_VALUE;
  public static final int LOG_LEVEL_VERBOSE = 2;
  public static final int LOG_LEVEL_WARNING = 5;
  private static final Object MUTEX = new Object();
  private static final Object MUTEX_CALLBACKS = new Object();
  private static final String PARSE_APPLICATION_ID = "com.parse.APPLICATION_ID";
  private static final String PARSE_CLIENT_KEY = "com.parse.CLIENT_KEY";
  private static Set<ParseCallbacks> callbacks = new HashSet();
  static ParseEventuallyQueue eventuallyQueue = null;
  private static List<d> interceptors;
  private static boolean isLocalDatastoreEnabled;
  private static OfflineStore offlineStore;
  
  private Parse()
  {
    throw new AssertionError();
  }
  
  public static void addParseNetworkInterceptor(d paramd)
  {
    if (isInitialized()) {
      throw new IllegalStateException("`Parse#addParseNetworkInterceptor(ParseNetworkInterceptor)` must be invoked before `Parse#initialize(Context)`");
    }
    if (interceptors == null) {
      interceptors = new ArrayList();
    }
    interceptors.add(paramd);
  }
  
  private static boolean allParsePushIntentReceiversInternal()
  {
    Iterator localIterator = ManifestInfo.getIntentReceivers(new String[] { "com.parse.push.intent.RECEIVE", "com.parse.push.intent.DELETE", "com.parse.push.intent.OPEN" }).iterator();
    while (localIterator.hasNext()) {
      if (((ResolveInfo)localIterator.next()).activityInfo.exported) {
        return false;
      }
    }
    return true;
  }
  
  static void checkCacheApplicationId()
  {
    String str;
    Object localObject3;
    synchronized (MUTEX)
    {
      str = ParsePlugins.get().applicationId();
      Object localObject4;
      boolean bool1;
      if (str != null)
      {
        localObject3 = getParseCacheDir();
        localObject4 = new File((File)localObject3, "applicationId");
        bool1 = ((File)localObject4).exists();
        if (bool1) {
          bool1 = false;
        }
      }
      try
      {
        localObject4 = new RandomAccessFile((File)localObject4, "r");
        byte[] arrayOfByte = new byte[(int)((RandomAccessFile)localObject4).length()];
        ((RandomAccessFile)localObject4).readFully(arrayOfByte);
        ((RandomAccessFile)localObject4).close();
        boolean bool2 = new String(arrayOfByte, "UTF-8").equals(str);
        bool1 = bool2;
      }
      catch (IOException localIOException3)
      {
        for (;;) {}
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        for (;;) {}
      }
      if (bool1) {}
    }
    try
    {
      ParseFileUtils.deleteDirectory((File)localObject3);
      localObject3 = new File((File)localObject3, "applicationId");
    }
    catch (IOException localIOException2)
    {
      try
      {
        localObject3 = new FileOutputStream((File)localObject3);
        ((FileOutputStream)localObject3).write(str.getBytes("UTF-8"));
        ((FileOutputStream)localObject3).close();
        return;
        localObject2 = finally;
        throw ((Throwable)localObject2);
        localIOException2 = localIOException2;
      }
      catch (IOException localIOException1)
      {
        for (;;) {}
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;) {}
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;) {}
      }
    }
  }
  
  static void checkContext()
  {
    if (ParsePlugins.Android.get().applicationContext() == null) {
      throw new RuntimeException("applicationContext is null. You must call Parse.initialize(Context) before using the Parse library.");
    }
  }
  
  static void checkInit()
  {
    if (ParsePlugins.get() == null) {
      throw new RuntimeException("You must call Parse.initialize(Context) before using the Parse library.");
    }
    if (ParsePlugins.get().applicationId() == null) {
      throw new RuntimeException("applicationId is null. You must call Parse.initialize(Context) before using the Parse library.");
    }
    if (ParsePlugins.get().clientKey() == null) {
      throw new RuntimeException("clientKey is null. You must call Parse.initialize(Context) before using the Parse library.");
    }
  }
  
  private static ParseCallbacks[] collectParseCallbacks()
  {
    synchronized (MUTEX_CALLBACKS)
    {
      if (callbacks == null) {
        return null;
      }
      ParseCallbacks[] arrayOfParseCallbacks2 = new ParseCallbacks[callbacks.size()];
      ParseCallbacks[] arrayOfParseCallbacks1 = arrayOfParseCallbacks2;
      if (callbacks.size() > 0) {
        arrayOfParseCallbacks1 = (ParseCallbacks[])callbacks.toArray(arrayOfParseCallbacks2);
      }
      return arrayOfParseCallbacks1;
    }
  }
  
  static void destroy()
  {
    synchronized (MUTEX)
    {
      ParseEventuallyQueue localParseEventuallyQueue = eventuallyQueue;
      eventuallyQueue = null;
      if (localParseEventuallyQueue != null) {
        localParseEventuallyQueue.onDestroy();
      }
      ParseCorePlugins.getInstance().reset();
      ParsePlugins.reset();
      return;
    }
  }
  
  static void disableLocalDatastore()
  {
    setLocalDatastore(null);
    ParseCorePlugins.getInstance().reset();
  }
  
  private static void dispatchOnParseInitialized()
  {
    ParseCallbacks[] arrayOfParseCallbacks = collectParseCallbacks();
    if (arrayOfParseCallbacks != null)
    {
      int j = arrayOfParseCallbacks.length;
      int i = 0;
      while (i < j)
      {
        arrayOfParseCallbacks[i].onParseInitialized();
        i += 1;
      }
    }
  }
  
  public static void enableLocalDatastore(Context paramContext)
  {
    if (isInitialized()) {
      throw new IllegalStateException("`Parse#enableLocalDatastore(Context)` must be invoked before `Parse#initialize(Context)`");
    }
    isLocalDatastoreEnabled = true;
  }
  
  static String externalVersionName()
  {
    return "a1.13.1";
  }
  
  static Context getApplicationContext()
  {
    checkContext();
    return ParsePlugins.Android.get().applicationContext();
  }
  
  static ParseEventuallyQueue getEventuallyQueue()
  {
    return getEventuallyQueue(ParsePlugins.Android.get().applicationContext());
  }
  
  private static ParseEventuallyQueue getEventuallyQueue(Context paramContext)
  {
    synchronized (MUTEX)
    {
      boolean bool = isLocalDatastoreEnabled();
      ParseHttpClient localParseHttpClient;
      if ((eventuallyQueue == null) || ((bool) && ((eventuallyQueue instanceof ParseCommandCache))) || ((!bool) && ((eventuallyQueue instanceof ParsePinningEventuallyQueue))))
      {
        checkContext();
        localParseHttpClient = ParsePlugins.get().restClient();
        if (!bool) {
          break label103;
        }
        localObject1 = new ParsePinningEventuallyQueue(paramContext, localParseHttpClient);
        eventuallyQueue = (ParseEventuallyQueue)localObject1;
        if ((bool) && (ParseCommandCache.getPendingCount() > 0)) {
          new ParseCommandCache(paramContext, localParseHttpClient);
        }
      }
      paramContext = eventuallyQueue;
      return paramContext;
      label103:
      Object localObject1 = new ParseCommandCache(paramContext, localParseHttpClient);
    }
  }
  
  static OfflineStore getLocalDatastore()
  {
    return offlineStore;
  }
  
  public static int getLogLevel()
  {
    return PLog.getLogLevel();
  }
  
  static File getParseCacheDir()
  {
    return ParsePlugins.get().getCacheDir();
  }
  
  static File getParseCacheDir(String paramString)
  {
    synchronized (MUTEX)
    {
      paramString = new File(getParseCacheDir(), paramString);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return paramString;
    }
  }
  
  @Deprecated
  static File getParseDir()
  {
    return ParsePlugins.get().getParseDir();
  }
  
  static File getParseFilesDir()
  {
    return ParsePlugins.get().getFilesDir();
  }
  
  static File getParseFilesDir(String paramString)
  {
    synchronized (MUTEX)
    {
      paramString = new File(getParseFilesDir(), paramString);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return paramString;
    }
  }
  
  static boolean hasPermission(String paramString)
  {
    return getApplicationContext().checkCallingOrSelfPermission(paramString) == 0;
  }
  
  public static void initialize(Context paramContext)
  {
    paramContext = new Parse.Configuration.Builder(paramContext);
    if (paramContext.applicationId == null) {
      throw new RuntimeException("ApplicationId not defined. You must provide ApplicationId in AndroidManifest.xml.\n<meta-data\n    android:name=\"com.parse.APPLICATION_ID\"\n    android:value=\"<Your Application Id>\" />");
    }
    if (paramContext.clientKey == null) {
      throw new RuntimeException("ClientKey not defined. You must provide ClientKey in AndroidManifest.xml.\n<meta-data\n    android:name=\"com.parse.CLIENT_KEY\"\n    android:value=\"<Your Client Key>\" />");
    }
    initialize(paramContext.setNetworkInterceptors(interceptors).setLocalDatastoreEnabled(isLocalDatastoreEnabled).build());
  }
  
  public static void initialize(Context paramContext, String paramString1, String paramString2)
  {
    initialize(new Parse.Configuration.Builder(paramContext).applicationId(paramString1).clientKey(paramString2).setNetworkInterceptors(interceptors).setLocalDatastoreEnabled(isLocalDatastoreEnabled).build());
  }
  
  public static void initialize(Configuration arg0)
  {
    isLocalDatastoreEnabled = ???.localDataStoreEnabled;
    ParsePlugins.Android.initialize(???.context, ???.applicationId, ???.clientKey);
    Context localContext;
    for (;;)
    {
      try
      {
        ParseRESTCommand.server = new URL(???.server);
        localContext = ???.context.getApplicationContext();
        ParseHttpClient.setKeepAlive(true);
        ParseHttpClient.setMaxConnections(20);
        if ((???.interceptors != null) && (???.interceptors.size() > 0)) {
          initializeParseHttpClientsWithParseNetworkInterceptors(???.interceptors);
        }
        ParseObject.registerParseSubclasses();
        if (???.localDataStoreEnabled)
        {
          offlineStore = new OfflineStore(???.context);
          checkCacheApplicationId();
          j.a(new Callable()
          {
            public Void call()
            {
              Parse.getEventuallyQueue(this.val$context);
              return null;
            }
          });
          ParseFieldOperations.registerDefaultDecoders();
          if (allParsePushIntentReceiversInternal()) {
            break;
          }
          throw new SecurityException("To prevent external tampering to your app's notifications, all receivers registered to handle the following actions must have their exported attributes set to false: com.parse.push.intent.RECEIVE, com.parse.push.intent.OPEN, com.parse.push.intent.DELETE");
        }
      }
      catch (MalformedURLException ???)
      {
        throw new RuntimeException(???);
      }
      ParseKeyValueCache.initialize(???.context);
    }
    GcmRegistrar.getInstance().registerAsync().b(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        return ParseUser.getCurrentUserAsync().k();
      }
    }).a(new h()
    {
      public Void then(j<Void> paramAnonymousj)
      {
        ParseConfig.getCurrentConfig();
        return null;
      }
    }, j.a);
    if (ManifestInfo.getPushType() == PushType.PPNS) {
      PushService.startServiceIfRequired(localContext);
    }
    dispatchOnParseInitialized();
    synchronized (MUTEX_CALLBACKS)
    {
      callbacks = null;
      return;
    }
  }
  
  private static void initializeParseHttpClientsWithParseNetworkInterceptors(List<d> paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = new ArrayList();
    ((List)localObject).add(ParsePlugins.get().restClient());
    ((List)localObject).add(ParseCorePlugins.getInstance().getFileController().awsClient());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ParseHttpClient localParseHttpClient = (ParseHttpClient)((Iterator)localObject).next();
      localParseHttpClient.addInternalInterceptor(new ParseDecompressInterceptor());
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        localParseHttpClient.addExternalInterceptor((d)localIterator.next());
      }
    }
  }
  
  static boolean isInitialized()
  {
    return ParsePlugins.get() != null;
  }
  
  static boolean isLocalDatastoreEnabled()
  {
    return isLocalDatastoreEnabled;
  }
  
  static void registerParseCallbacks(ParseCallbacks paramParseCallbacks)
  {
    if (isInitialized()) {
      throw new IllegalStateException("You must register callbacks before Parse.initialize(Context)");
    }
    synchronized (MUTEX_CALLBACKS)
    {
      if (callbacks == null) {
        return;
      }
      callbacks.add(paramParseCallbacks);
      return;
    }
  }
  
  public static void removeParseNetworkInterceptor(d paramd)
  {
    if (isInitialized()) {
      throw new IllegalStateException("`Parse#addParseNetworkInterceptor(ParseNetworkInterceptor)` must be invoked before `Parse#initialize(Context)`");
    }
    if (interceptors == null) {
      return;
    }
    interceptors.remove(paramd);
  }
  
  static void requirePermission(String paramString)
  {
    if (!hasPermission(paramString)) {
      throw new IllegalStateException("To use this functionality, add this to your AndroidManifest.xml:\n<uses-permission android:name=\"" + paramString + "\" />");
    }
  }
  
  static void setLocalDatastore(OfflineStore paramOfflineStore)
  {
    if (paramOfflineStore != null) {}
    for (boolean bool = true;; bool = false)
    {
      isLocalDatastoreEnabled = bool;
      offlineStore = paramOfflineStore;
      return;
    }
  }
  
  public static void setLogLevel(int paramInt)
  {
    PLog.setLogLevel(paramInt);
  }
  
  static void unregisterParseCallbacks(ParseCallbacks paramParseCallbacks)
  {
    synchronized (MUTEX_CALLBACKS)
    {
      if (callbacks == null) {
        return;
      }
      callbacks.remove(paramParseCallbacks);
      return;
    }
  }
  
  public static final class Configuration
  {
    final String applicationId;
    final String clientKey;
    final Context context;
    final List<d> interceptors;
    final boolean localDataStoreEnabled;
    final String server;
    
    private Configuration(Builder paramBuilder)
    {
      this.context = paramBuilder.context;
      this.applicationId = paramBuilder.applicationId;
      this.clientKey = paramBuilder.clientKey;
      this.server = paramBuilder.server;
      this.localDataStoreEnabled = paramBuilder.localDataStoreEnabled;
      if (paramBuilder.interceptors != null) {}
      for (paramBuilder = Collections.unmodifiableList(new ArrayList(paramBuilder.interceptors));; paramBuilder = null)
      {
        this.interceptors = paramBuilder;
        return;
      }
    }
    
    public static final class Builder
    {
      private String applicationId;
      private String clientKey;
      private Context context;
      private List<d> interceptors;
      private boolean localDataStoreEnabled;
      private String server = "https://api.parse.com/1/";
      
      public Builder(Context paramContext)
      {
        this.context = paramContext;
        if (paramContext != null)
        {
          paramContext = ManifestInfo.getApplicationMetadata(paramContext.getApplicationContext());
          if (paramContext != null)
          {
            this.applicationId = paramContext.getString("com.parse.APPLICATION_ID");
            this.clientKey = paramContext.getString("com.parse.CLIENT_KEY");
          }
        }
      }
      
      private Builder setLocalDatastoreEnabled(boolean paramBoolean)
      {
        this.localDataStoreEnabled = paramBoolean;
        return this;
      }
      
      public Builder addNetworkInterceptor(d paramd)
      {
        if (this.interceptors == null) {
          this.interceptors = new ArrayList();
        }
        this.interceptors.add(paramd);
        return this;
      }
      
      public Builder applicationId(String paramString)
      {
        this.applicationId = paramString;
        return this;
      }
      
      public Parse.Configuration build()
      {
        return new Parse.Configuration(this, null);
      }
      
      public Builder clientKey(String paramString)
      {
        this.clientKey = paramString;
        return this;
      }
      
      public Builder enableLocalDataStore()
      {
        this.localDataStoreEnabled = true;
        return this;
      }
      
      public Builder server(String paramString)
      {
        String str = paramString;
        if (!paramString.endsWith("/")) {
          str = paramString + "/";
        }
        this.server = str;
        return this;
      }
      
      Builder setNetworkInterceptors(Collection<d> paramCollection)
      {
        if (this.interceptors == null) {
          this.interceptors = new ArrayList();
        }
        for (;;)
        {
          if (paramCollection != null) {
            this.interceptors.addAll(paramCollection);
          }
          return this;
          this.interceptors.clear();
        }
      }
    }
  }
  
  static abstract interface ParseCallbacks
  {
    public abstract void onParseInitialized();
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/Parse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */