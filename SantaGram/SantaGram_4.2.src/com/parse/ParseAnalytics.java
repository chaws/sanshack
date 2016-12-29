package com.parse;

import a.g;
import a.h;
import a.j;
import android.content.Intent;
import android.os.Bundle;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseAnalytics
{
  private static final String TAG = "com.parse.ParseAnalytics";
  private static final Map<String, Boolean> lruSeenPushes = new LinkedHashMap()
  {
    protected boolean removeEldestEntry(Map.Entry<String, Boolean> paramAnonymousEntry)
    {
      return size() > 10;
    }
  };
  
  static void clear()
  {
    synchronized (lruSeenPushes)
    {
      lruSeenPushes.clear();
      return;
    }
  }
  
  static ParseAnalyticsController getAnalyticsController()
  {
    return ParseCorePlugins.getInstance().getAnalyticsController();
  }
  
  static String getPushHashFromIntent(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {}
    for (paramIntent = paramIntent.getExtras().getString("com.parse.Data");; paramIntent = null)
    {
      if (paramIntent == null) {
        return null;
      }
      try
      {
        paramIntent = new JSONObject(paramIntent).optString("push_hash");
        return paramIntent;
      }
      catch (JSONException paramIntent)
      {
        PLog.e("com.parse.ParseAnalytics", "Failed to parse push data: " + paramIntent.getMessage());
        return null;
      }
    }
  }
  
  @Deprecated
  public static void trackAppOpened(Intent paramIntent)
  {
    trackAppOpenedInBackground(paramIntent);
  }
  
  public static j<Void> trackAppOpenedInBackground(Intent arg0)
  {
    Object localObject1 = getPushHashFromIntent(???);
    g localg = new g();
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {}
    synchronized (lruSeenPushes)
    {
      if (lruSeenPushes.containsKey(localObject1))
      {
        localObject1 = j.a(null);
        return (j<Void>)localObject1;
      }
      lruSeenPushes.put(localObject1, Boolean.valueOf(true));
      localg.a(localObject1);
      ParseUser.getCurrentSessionTokenAsync().d(new h()
      {
        public j<Void> then(j<String> paramAnonymousj)
        {
          paramAnonymousj = (String)paramAnonymousj.f();
          return ParseAnalytics.getAnalyticsController().trackAppOpenedInBackground((String)this.val$pushHash.a(), paramAnonymousj);
        }
      });
    }
  }
  
  public static void trackAppOpenedInBackground(Intent paramIntent, SaveCallback paramSaveCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(trackAppOpenedInBackground(paramIntent), paramSaveCallback);
  }
  
  @Deprecated
  public static void trackEvent(String paramString)
  {
    trackEventInBackground(paramString);
  }
  
  @Deprecated
  public static void trackEvent(String paramString, Map<String, String> paramMap)
  {
    trackEventInBackground(paramString, paramMap);
  }
  
  public static j<Void> trackEventInBackground(String paramString)
  {
    return trackEventInBackground(paramString, (Map)null);
  }
  
  public static j<Void> trackEventInBackground(String paramString, final Map<String, String> paramMap)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      throw new IllegalArgumentException("A name for the custom event must be provided.");
    }
    if (paramMap != null) {}
    for (paramMap = Collections.unmodifiableMap(new HashMap(paramMap));; paramMap = null) {
      ParseUser.getCurrentSessionTokenAsync().d(new h()
      {
        public j<Void> then(j<String> paramAnonymousj)
        {
          paramAnonymousj = (String)paramAnonymousj.f();
          return ParseAnalytics.getAnalyticsController().trackEventInBackground(this.val$name, paramMap, paramAnonymousj);
        }
      });
    }
  }
  
  public static void trackEventInBackground(String paramString, SaveCallback paramSaveCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(trackEventInBackground(paramString), paramSaveCallback);
  }
  
  public static void trackEventInBackground(String paramString, Map<String, String> paramMap, SaveCallback paramSaveCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(trackEventInBackground(paramString, paramMap), paramSaveCallback);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */