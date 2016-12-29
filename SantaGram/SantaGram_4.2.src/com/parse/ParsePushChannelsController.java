package com.parse;

import a.h;
import a.j;
import java.util.Collections;
import java.util.List;

class ParsePushChannelsController
{
  private static final String TAG = "com.parse.ParsePushChannelsController";
  private static boolean loggedManifestError = false;
  
  private static void checkManifestAndLogErrorIfNecessary()
  {
    if ((!loggedManifestError) && (ManifestInfo.getPushType() == PushType.NONE))
    {
      loggedManifestError = true;
      PLog.e("com.parse.ParsePushChannelsController", "Tried to subscribe or unsubscribe from a channel, but push is not enabled correctly. " + ManifestInfo.getNonePushTypeLogMessage());
    }
  }
  
  private static ParseCurrentInstallationController getCurrentInstallationController()
  {
    return ParseCorePlugins.getInstance().getCurrentInstallationController();
  }
  
  public j<Void> subscribeInBackground(final String paramString)
  {
    
    if (paramString == null) {
      throw new IllegalArgumentException("Can't subscribe to null channel.");
    }
    getCurrentInstallationController().getAsync().d(new h()
    {
      public j<Void> then(j<ParseInstallation> paramAnonymousj)
      {
        paramAnonymousj = (ParseInstallation)paramAnonymousj.f();
        List localList = paramAnonymousj.getList("channels");
        if ((localList == null) || (paramAnonymousj.isDirty("channels")) || (!localList.contains(paramString)))
        {
          paramAnonymousj.addUnique("channels", paramString);
          return paramAnonymousj.saveInBackground();
        }
        return j.a(null);
      }
    });
  }
  
  public j<Void> unsubscribeInBackground(final String paramString)
  {
    
    if (paramString == null) {
      throw new IllegalArgumentException("Can't unsubscribe from null channel.");
    }
    getCurrentInstallationController().getAsync().d(new h()
    {
      public j<Void> then(j<ParseInstallation> paramAnonymousj)
      {
        paramAnonymousj = (ParseInstallation)paramAnonymousj.f();
        List localList = paramAnonymousj.getList("channels");
        if ((localList != null) && (localList.contains(paramString)))
        {
          paramAnonymousj.removeAll("channels", Collections.singletonList(paramString));
          return paramAnonymousj.saveInBackground();
        }
        return j.a(null);
      }
    });
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParsePushChannelsController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */