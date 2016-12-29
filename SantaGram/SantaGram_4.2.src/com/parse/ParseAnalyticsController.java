package com.parse;

import a.j;
import java.util.Map;

class ParseAnalyticsController
{
  ParseEventuallyQueue eventuallyQueue;
  
  public ParseAnalyticsController(ParseEventuallyQueue paramParseEventuallyQueue)
  {
    this.eventuallyQueue = paramParseEventuallyQueue;
  }
  
  public j<Void> trackAppOpenedInBackground(String paramString1, String paramString2)
  {
    paramString1 = ParseRESTAnalyticsCommand.trackAppOpenedCommand(paramString1, paramString2);
    return this.eventuallyQueue.enqueueEventuallyAsync(paramString1, null).k();
  }
  
  public j<Void> trackEventInBackground(String paramString1, Map<String, String> paramMap, String paramString2)
  {
    paramString1 = ParseRESTAnalyticsCommand.trackEventCommand(paramString1, paramMap, paramString2);
    return this.eventuallyQueue.enqueueEventuallyAsync(paramString1, null).k();
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseAnalyticsController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */