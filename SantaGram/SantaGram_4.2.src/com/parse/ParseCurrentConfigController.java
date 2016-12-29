package com.parse;

import a.j;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

class ParseCurrentConfigController
{
  ParseConfig currentConfig;
  private File currentConfigFile;
  private final Object currentConfigMutex = new Object();
  
  public ParseCurrentConfigController(File paramFile)
  {
    this.currentConfigFile = paramFile;
  }
  
  void clearCurrentConfigForTesting()
  {
    synchronized (this.currentConfigMutex)
    {
      this.currentConfig = null;
      return;
    }
  }
  
  public j<ParseConfig> getCurrentConfigAsync()
  {
    j.a(new Callable()
    {
      public ParseConfig call()
      {
        synchronized (ParseCurrentConfigController.this.currentConfigMutex)
        {
          if (ParseCurrentConfigController.this.currentConfig == null)
          {
            localParseConfig = ParseCurrentConfigController.this.getFromDisk();
            ParseCurrentConfigController localParseCurrentConfigController = ParseCurrentConfigController.this;
            if (localParseConfig != null) {
              localParseCurrentConfigController.currentConfig = localParseConfig;
            }
          }
          else
          {
            return ParseCurrentConfigController.this.currentConfig;
          }
          ParseConfig localParseConfig = new ParseConfig();
        }
      }
    }, ParseExecutors.io());
  }
  
  ParseConfig getFromDisk()
  {
    try
    {
      JSONObject localJSONObject = ParseFileUtils.readFileToJSONObject(this.currentConfigFile);
      return ParseConfig.decode(localJSONObject, ParseDecoder.get());
    }
    catch (JSONException localJSONException)
    {
      return null;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  void saveToDisk(ParseConfig paramParseConfig)
  {
    // Byte code:
    //   0: new 76	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 77	org/json/JSONObject:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 79
    //   11: invokestatic 84	com/parse/NoObjectsEncoder:get	()Lcom/parse/NoObjectsEncoder;
    //   14: aload_1
    //   15: invokevirtual 88	com/parse/ParseConfig:getParams	()Ljava/util/Map;
    //   18: invokevirtual 92	com/parse/NoObjectsEncoder:encode	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 76	org/json/JSONObject
    //   24: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   27: pop
    //   28: aload_0
    //   29: getfield 23	com/parse/ParseCurrentConfigController:currentConfigFile	Ljava/io/File;
    //   32: aload_2
    //   33: invokestatic 100	com/parse/ParseFileUtils:writeJSONObjectToFile	(Ljava/io/File;Lorg/json/JSONObject;)V
    //   36: return
    //   37: astore_1
    //   38: new 102	java/lang/RuntimeException
    //   41: dup
    //   42: ldc 104
    //   44: invokespecial 107	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   47: athrow
    //   48: astore_1
    //   49: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	ParseCurrentConfigController
    //   0	50	1	paramParseConfig	ParseConfig
    //   7	26	2	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   8	28	37	org/json/JSONException
    //   28	36	48	java/io/IOException
  }
  
  public j<Void> setCurrentConfigAsync(final ParseConfig paramParseConfig)
  {
    j.a(new Callable()
    {
      public Void call()
      {
        synchronized (ParseCurrentConfigController.this.currentConfigMutex)
        {
          ParseCurrentConfigController.this.currentConfig = paramParseConfig;
          ParseCurrentConfigController.this.saveToDisk(paramParseConfig);
          return null;
        }
      }
    }, ParseExecutors.io());
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseCurrentConfigController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */