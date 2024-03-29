package com.parse;

import a.h;
import a.j;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@ParseClassName("_Installation")
public class ParseInstallation
  extends ParseObject
{
  private static final String KEY_APP_IDENTIFIER = "appIdentifier";
  private static final String KEY_APP_NAME = "appName";
  private static final String KEY_APP_VERSION = "appVersion";
  static final String KEY_CHANNELS = "channels";
  private static final String KEY_DEVICE_TOKEN = "deviceToken";
  private static final String KEY_DEVICE_TYPE = "deviceType";
  private static final String KEY_INSTALLATION_ID = "installationId";
  private static final String KEY_LOCALE = "localeIdentifier";
  private static final String KEY_PARSE_VERSION = "parseVersion";
  private static final String KEY_PUSH_TYPE = "pushType";
  private static final String KEY_TIME_ZONE = "timeZone";
  private static final List<String> READ_ONLY_FIELDS = Collections.unmodifiableList(Arrays.asList(new String[] { "deviceType", "installationId", "deviceToken", "pushType", "timeZone", "localeIdentifier", "appVersion", "appName", "parseVersion", "appIdentifier" }));
  private static final String TAG = "com.parse.ParseInstallation";
  
  public static ParseInstallation getCurrentInstallation()
  {
    try
    {
      ParseInstallation localParseInstallation = (ParseInstallation)ParseTaskUtils.wait(getCurrentInstallationController().getAsync());
      return localParseInstallation;
    }
    catch (ParseException localParseException) {}
    return null;
  }
  
  static ParseCurrentInstallationController getCurrentInstallationController()
  {
    return ParseCorePlugins.getInstance().getCurrentInstallationController();
  }
  
  public static ParseQuery<ParseInstallation> getQuery()
  {
    return ParseQuery.getQuery(ParseInstallation.class);
  }
  
  private void updateLocaleIdentifier()
  {
    Object localObject1 = Locale.getDefault();
    Object localObject2 = ((Locale)localObject1).getLanguage();
    String str = ((Locale)localObject1).getCountry();
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    do
    {
      return;
      localObject1 = localObject2;
      if (((String)localObject2).equals("iw")) {
        localObject1 = "he";
      }
      localObject2 = localObject1;
      if (((String)localObject1).equals("in")) {
        localObject2 = "id";
      }
      localObject1 = localObject2;
      if (((String)localObject2).equals("ji")) {
        localObject1 = "yi";
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(str)) {
        localObject2 = String.format(Locale.US, "%s-%s", new Object[] { localObject1, str });
      }
    } while (((String)localObject2).equals(get("localeIdentifier")));
    performPut("localeIdentifier", localObject2);
  }
  
  private void updateTimezone()
  {
    String str = TimeZone.getDefault().getID();
    if (((str.indexOf('/') > 0) || (str.equals("GMT"))) && (!str.equals(get("timeZone")))) {
      performPut("timeZone", str);
    }
  }
  
  private void updateVersionInfo()
  {
    synchronized (this.mutex)
    {
      try
      {
        Object localObject3 = Parse.getApplicationContext();
        String str = ((Context)localObject3).getPackageName();
        Object localObject4 = ((Context)localObject3).getPackageManager();
        localObject3 = ((PackageManager)localObject4).getPackageInfo(str, 0).versionName;
        localObject4 = ((PackageManager)localObject4).getApplicationLabel(((PackageManager)localObject4).getApplicationInfo(str, 0)).toString();
        if ((str != null) && (!str.equals(get("appIdentifier")))) {
          performPut("appIdentifier", str);
        }
        if ((localObject4 != null) && (!((String)localObject4).equals(get("appName")))) {
          performPut("appName", localObject4);
        }
        if ((localObject3 != null) && (!((String)localObject3).equals(get("appVersion")))) {
          performPut("appVersion", localObject3);
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          PLog.w("com.parse.ParseInstallation", "Cannot load package info; will not be saved to installation");
        }
      }
      if (!"1.13.1".equals(get("parseVersion"))) {
        performPut("parseVersion", "1.13.1");
      }
      return;
    }
  }
  
  <T extends ParseObject> j<T> fetchAsync(final String paramString, final j<Void> paramj)
  {
    synchronized (this.mutex)
    {
      if (getObjectId() == null)
      {
        localj = saveAsync(paramString, paramj);
        paramString = localj.d(new h()
        {
          public j<T> then(j<Void> paramAnonymousj)
          {
            return ParseInstallation.this.fetchAsync(paramString, paramj);
          }
        });
        return paramString;
      }
      j localj = j.a(null);
    }
  }
  
  String getDeviceToken()
  {
    return super.getString("deviceToken");
  }
  
  public String getInstallationId()
  {
    return getString("installationId");
  }
  
  PushType getPushType()
  {
    return PushType.fromString(super.getString("pushType"));
  }
  
  j<Void> handleFetchResultAsync(ParseObject.State paramState)
  {
    super.handleFetchResultAsync(paramState).d(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        return ParseInstallation.getCurrentInstallationController().setAsync(ParseInstallation.this);
      }
    });
  }
  
  j<Void> handleSaveResultAsync(ParseObject.State paramState, ParseOperationSet paramParseOperationSet)
  {
    paramParseOperationSet = super.handleSaveResultAsync(paramState, paramParseOperationSet);
    if (paramState == null) {
      return paramParseOperationSet;
    }
    paramParseOperationSet.d(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        return ParseInstallation.getCurrentInstallationController().setAsync(ParseInstallation.this);
      }
    });
  }
  
  boolean isKeyMutable(String paramString)
  {
    return !READ_ONLY_FIELDS.contains(paramString);
  }
  
  boolean needsDefaultACL()
  {
    return false;
  }
  
  void removeDeviceToken()
  {
    performRemove("deviceToken");
  }
  
  void removePushType()
  {
    performRemove("pushType");
  }
  
  void setDeviceToken(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      performPut("deviceToken", paramString);
    }
  }
  
  void setPushType(PushType paramPushType)
  {
    if (paramPushType != null) {
      performPut("pushType", paramPushType.toString());
    }
  }
  
  void updateBeforeSave()
  {
    super.updateBeforeSave();
    if (getCurrentInstallationController().isCurrent(this))
    {
      updateTimezone();
      updateVersionInfo();
      updateDeviceInfo();
      updateLocaleIdentifier();
    }
  }
  
  void updateDeviceInfo()
  {
    updateDeviceInfo(ParsePlugins.get().installationId());
  }
  
  void updateDeviceInfo(InstallationId paramInstallationId)
  {
    if (!has("installationId")) {
      performPut("installationId", paramInstallationId.get());
    }
    if (!"android".equals(get("deviceType"))) {
      performPut("deviceType", "android");
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseInstallation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */