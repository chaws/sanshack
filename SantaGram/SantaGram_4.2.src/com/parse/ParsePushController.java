package com.parse;

import a.j;

class ParsePushController
{
  static final String DEVICE_TYPE_ANDROID = "android";
  static final String DEVICE_TYPE_IOS = "ios";
  private final ParseHttpClient restClient;
  
  public ParsePushController(ParseHttpClient paramParseHttpClient)
  {
    this.restClient = paramParseHttpClient;
  }
  
  ParseRESTCommand buildRESTSendPushCommand(ParsePush.State paramState, String paramString)
  {
    int j = 1;
    int i;
    label47:
    String str;
    if (paramState.queryState() == null) {
      if ((paramState.pushToAndroid() != null) && (paramState.pushToAndroid().booleanValue()))
      {
        i = 1;
        if ((paramState.pushToIOS() == null) || (!paramState.pushToIOS().booleanValue())) {
          break label91;
        }
        if ((j == 0) || (i == 0)) {
          break label97;
        }
        str = null;
      }
    }
    for (;;)
    {
      return ParseRESTPushCommand.sendPushCommand(paramState.queryState(), paramState.channelSet(), str, paramState.expirationTime(), paramState.expirationTimeInterval(), paramState.data(), paramString);
      i = 0;
      break;
      label91:
      j = 0;
      break label47;
      label97:
      if (j != 0) {
        str = "ios";
      } else if (i != 0) {
        str = "android";
      } else {
        str = null;
      }
    }
  }
  
  public j<Void> sendInBackground(ParsePush.State paramState, String paramString)
  {
    return buildRESTSendPushCommand(paramState, paramString).executeAsync(this.restClient).k();
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParsePushController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */