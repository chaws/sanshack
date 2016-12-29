package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ParseBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "com.parse.ParseBroadcastReceiver";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    PLog.d("com.parse.ParseBroadcastReceiver", "received " + paramIntent.getAction());
    PushService.startServiceIfRequired(paramContext);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */