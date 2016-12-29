package com.parse;

import a.h;
import a.j;
import com.parse.a.b.b;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import org.json.JSONObject;

class ParseFileController
{
  private ParseHttpClient awsClient;
  private final File cachePath;
  private final Object lock = new Object();
  private final ParseHttpClient restClient;
  
  public ParseFileController(ParseHttpClient paramParseHttpClient, File paramFile)
  {
    this.restClient = paramParseHttpClient;
    this.cachePath = paramFile;
  }
  
  ParseFileController awsClient(ParseHttpClient paramParseHttpClient)
  {
    synchronized (this.lock)
    {
      this.awsClient = paramParseHttpClient;
      return this;
    }
  }
  
  ParseHttpClient awsClient()
  {
    synchronized (this.lock)
    {
      if (this.awsClient == null) {
        this.awsClient = ParsePlugins.get().newHttpClient();
      }
      ParseHttpClient localParseHttpClient = this.awsClient;
      return localParseHttpClient;
    }
  }
  
  public void clearCache()
  {
    File[] arrayOfFile = this.cachePath.listFiles();
    if (arrayOfFile == null) {}
    for (;;)
    {
      return;
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        ParseFileUtils.deleteQuietly(arrayOfFile[i]);
        i += 1;
      }
    }
  }
  
  public j<File> fetchAsync(final ParseFile.State paramState, final String paramString, final ProgressCallback paramProgressCallback, final j<Void> paramj)
  {
    if ((paramj != null) && (paramj.d())) {
      return j.i();
    }
    paramString = getCacheFile(paramState);
    j.a(new Callable()
    {
      public Boolean call()
      {
        return Boolean.valueOf(paramString.exists());
      }
    }, ParseExecutors.io()).b(new h()
    {
      public j<File> then(final j<Boolean> paramAnonymousj)
      {
        if (((Boolean)paramAnonymousj.f()).booleanValue()) {
          return j.a(paramString);
        }
        if ((paramj != null) && (paramj.d())) {
          return j.i();
        }
        paramAnonymousj = ParseFileController.this.getTempFile(paramState);
        new ParseAWSRequest(b.b.a, paramState.url(), paramAnonymousj).executeAsync(ParseFileController.this.awsClient(), null, paramProgressCallback, paramj).b(new h()
        {
          public j<File> then(j<Void> paramAnonymous2j)
          {
            if ((ParseFileController.3.this.val$cancellationToken != null) && (ParseFileController.3.this.val$cancellationToken.d())) {
              throw new CancellationException();
            }
            if (paramAnonymous2j.e())
            {
              ParseFileUtils.deleteQuietly(paramAnonymousj);
              return paramAnonymous2j.j();
            }
            ParseFileUtils.deleteQuietly(ParseFileController.3.this.val$cacheFile);
            ParseFileUtils.moveFile(paramAnonymousj, ParseFileController.3.this.val$cacheFile);
            return j.a(ParseFileController.3.this.val$cacheFile);
          }
        }, ParseExecutors.io());
      }
    });
  }
  
  public File getCacheFile(ParseFile.State paramState)
  {
    return new File(this.cachePath, paramState.name());
  }
  
  File getTempFile(ParseFile.State paramState)
  {
    if (paramState.url() == null) {
      return null;
    }
    return new File(this.cachePath, paramState.url() + ".tmp");
  }
  
  public boolean isDataAvailable(ParseFile.State paramState)
  {
    return getCacheFile(paramState).exists();
  }
  
  public j<ParseFile.State> saveAsync(final ParseFile.State paramState, final File paramFile, String paramString, ProgressCallback paramProgressCallback, j<Void> paramj)
  {
    if (paramState.url() != null) {
      return j.a(paramState);
    }
    if ((paramj != null) && (paramj.d())) {
      return j.i();
    }
    paramString = ((ParseRESTFileCommand.Builder)new ParseRESTFileCommand.Builder().fileName(paramState.name()).file(paramFile).contentType(paramState.mimeType()).sessionToken(paramString)).build();
    paramString.enableRetrying();
    paramString.executeAsync(this.restClient, paramProgressCallback, null, paramj).c(new h()
    {
      public ParseFile.State then(j<JSONObject> paramAnonymousj)
      {
        paramAnonymousj = (JSONObject)paramAnonymousj.f();
        paramAnonymousj = new ParseFile.State.Builder(paramState).name(paramAnonymousj.getString("name")).url(paramAnonymousj.getString("url")).build();
        try
        {
          ParseFileUtils.copyFile(paramFile, ParseFileController.this.getCacheFile(paramAnonymousj));
          return paramAnonymousj;
        }
        catch (IOException localIOException) {}
        return paramAnonymousj;
      }
    }, ParseExecutors.io());
  }
  
  public j<ParseFile.State> saveAsync(final ParseFile.State paramState, final byte[] paramArrayOfByte, String paramString, ProgressCallback paramProgressCallback, j<Void> paramj)
  {
    if (paramState.url() != null) {
      return j.a(paramState);
    }
    if ((paramj != null) && (paramj.d())) {
      return j.i();
    }
    paramString = ((ParseRESTFileCommand.Builder)new ParseRESTFileCommand.Builder().fileName(paramState.name()).data(paramArrayOfByte).contentType(paramState.mimeType()).sessionToken(paramString)).build();
    paramString.enableRetrying();
    paramString.executeAsync(this.restClient, paramProgressCallback, null, paramj).c(new h()
    {
      public ParseFile.State then(j<JSONObject> paramAnonymousj)
      {
        paramAnonymousj = (JSONObject)paramAnonymousj.f();
        paramAnonymousj = new ParseFile.State.Builder(paramState).name(paramAnonymousj.getString("name")).url(paramAnonymousj.getString("url")).build();
        try
        {
          ParseFileUtils.writeByteArrayToFile(ParseFileController.this.getCacheFile(paramAnonymousj), paramArrayOfByte);
          return paramAnonymousj;
        }
        catch (IOException localIOException) {}
        return paramAnonymousj;
      }
    }, ParseExecutors.io());
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseFileController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */