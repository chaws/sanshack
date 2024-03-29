package com.parse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

class ParseImpreciseDateFormat
{
  private static final ParseImpreciseDateFormat INSTANCE = new ParseImpreciseDateFormat();
  private static final String TAG = "ParseDateFormat";
  private final DateFormat dateFormat;
  private final Object lock = new Object();
  
  private ParseImpreciseDateFormat()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    this.dateFormat = localSimpleDateFormat;
  }
  
  public static ParseImpreciseDateFormat getInstance()
  {
    return INSTANCE;
  }
  
  String format(Date paramDate)
  {
    synchronized (this.lock)
    {
      paramDate = this.dateFormat.format(paramDate);
      return paramDate;
    }
  }
  
  Date parse(String paramString)
  {
    synchronized (this.lock)
    {
      try
      {
        Date localDate = this.dateFormat.parse(paramString);
        return localDate;
      }
      catch (ParseException localParseException)
      {
        PLog.e("ParseDateFormat", "could not parse date: " + paramString, localParseException);
        return null;
      }
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseImpreciseDateFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */