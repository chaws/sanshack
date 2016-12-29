package com.parse;

import a.h;
import a.j;
import a.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public class ParseFile
{
  private Set<k<?>> currentTasks = Collections.synchronizedSet(new HashSet());
  byte[] data;
  File file;
  private State state;
  final TaskQueue taskQueue = new TaskQueue();
  
  ParseFile(State paramState)
  {
    this.state = paramState;
  }
  
  public ParseFile(File paramFile)
  {
    this(paramFile, null);
  }
  
  public ParseFile(File paramFile, String paramString)
  {
    this(new ParseFile.State.Builder().name(paramFile.getName()).mimeType(paramString).build());
    this.file = paramFile;
  }
  
  public ParseFile(String paramString, byte[] paramArrayOfByte)
  {
    this(paramString, paramArrayOfByte, null);
  }
  
  public ParseFile(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this(new ParseFile.State.Builder().name(paramString1).mimeType(paramString2).build());
    this.data = paramArrayOfByte;
  }
  
  ParseFile(JSONObject paramJSONObject, ParseDecoder paramParseDecoder)
  {
    this(new ParseFile.State.Builder().name(paramJSONObject.optString("name")).url(paramJSONObject.optString("url")).build());
  }
  
  public ParseFile(byte[] paramArrayOfByte)
  {
    this(null, paramArrayOfByte, null);
  }
  
  public ParseFile(byte[] paramArrayOfByte, String paramString)
  {
    this(null, paramArrayOfByte, paramString);
  }
  
  private j<File> fetchInBackground(final ProgressCallback paramProgressCallback, j<Void> paramj1, final j<Void> paramj2)
  {
    if ((paramj2 != null) && (paramj2.d())) {
      return j.i();
    }
    paramj1.b(new h()
    {
      public j<File> then(j<Void> paramAnonymousj)
      {
        if ((paramj2 != null) && (paramj2.d())) {
          return j.i();
        }
        return ParseFile.getFileController().fetchAsync(ParseFile.this.state, null, ParseFile.progressCallbackOnMainThread(paramProgressCallback), paramj2);
      }
    });
  }
  
  static ParseFileController getFileController()
  {
    return ParseCorePlugins.getInstance().getFileController();
  }
  
  private static ProgressCallback progressCallbackOnMainThread(ProgressCallback paramProgressCallback)
  {
    if (paramProgressCallback == null) {
      return null;
    }
    new ProgressCallback()
    {
      public void done(final Integer paramAnonymousInteger)
      {
        j.a(new Callable()
        {
          public Void call()
          {
            ParseFile.1.this.val$progressCallback.done(paramAnonymousInteger);
            return null;
          }
        }, ParseExecutors.main());
      }
    };
  }
  
  private j<Void> saveAsync(final String paramString, final ProgressCallback paramProgressCallback, j<Void> paramj1, final j<Void> paramj2)
  {
    if (!isDirty()) {
      return j.a(null);
    }
    if ((paramj2 != null) && (paramj2.d())) {
      return j.i();
    }
    paramj1.b(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        if (!ParseFile.this.isDirty()) {
          return j.a(null);
        }
        if ((paramj2 != null) && (paramj2.d())) {
          return j.i();
        }
        if (ParseFile.this.data != null) {}
        for (paramAnonymousj = ParseFile.getFileController().saveAsync(ParseFile.this.state, ParseFile.this.data, paramString, ParseFile.progressCallbackOnMainThread(paramProgressCallback), paramj2);; paramAnonymousj = ParseFile.getFileController().saveAsync(ParseFile.this.state, ParseFile.this.file, paramString, ParseFile.progressCallbackOnMainThread(paramProgressCallback), paramj2)) {
          paramAnonymousj.d(new h()
          {
            public j<Void> then(j<ParseFile.State> paramAnonymous2j)
            {
              ParseFile.access$402(ParseFile.this, (ParseFile.State)paramAnonymous2j.f());
              ParseFile.this.data = null;
              ParseFile.this.file = null;
              return paramAnonymous2j.k();
            }
          });
        }
      }
    });
  }
  
  public void cancel()
  {
    HashSet localHashSet = new HashSet(this.currentTasks);
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).b();
    }
    this.currentTasks.removeAll(localHashSet);
  }
  
  JSONObject encode()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("__type", "File");
    localJSONObject.put("name", getName());
    if (getUrl() == null) {
      throw new IllegalStateException("Unable to encode an unsaved ParseFile.");
    }
    localJSONObject.put("url", getUrl());
    return localJSONObject;
  }
  
  public byte[] getData()
  {
    return (byte[])ParseTaskUtils.wait(getDataInBackground());
  }
  
  public j<byte[]> getDataInBackground()
  {
    return getDataInBackground((ProgressCallback)null);
  }
  
  public j<byte[]> getDataInBackground(final ProgressCallback paramProgressCallback)
  {
    final k localk = new k();
    this.currentTasks.add(localk);
    this.taskQueue.enqueue(new h()
    {
      public j<byte[]> then(j<Void> paramAnonymousj)
      {
        ParseFile.this.fetchInBackground(paramProgressCallback, paramAnonymousj, localk.a()).c(new h()
        {
          public byte[] then(j<File> paramAnonymous2j)
          {
            paramAnonymous2j = (File)paramAnonymous2j.f();
            try
            {
              paramAnonymous2j = ParseFileUtils.readFileToByteArray(paramAnonymous2j);
              return paramAnonymous2j;
            }
            catch (IOException paramAnonymous2j) {}
            return null;
          }
        });
      }
    }).b(new h()
    {
      public j<byte[]> then(j<byte[]> paramAnonymousj)
      {
        localk.a(null);
        ParseFile.this.currentTasks.remove(localk);
        return paramAnonymousj;
      }
    });
  }
  
  public void getDataInBackground(GetDataCallback paramGetDataCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(getDataInBackground(), paramGetDataCallback);
  }
  
  public void getDataInBackground(GetDataCallback paramGetDataCallback, ProgressCallback paramProgressCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(getDataInBackground(paramProgressCallback), paramGetDataCallback);
  }
  
  public InputStream getDataStream()
  {
    return (InputStream)ParseTaskUtils.wait(getDataStreamInBackground());
  }
  
  public j<InputStream> getDataStreamInBackground()
  {
    return getDataStreamInBackground((ProgressCallback)null);
  }
  
  public j<InputStream> getDataStreamInBackground(final ProgressCallback paramProgressCallback)
  {
    final k localk = new k();
    this.currentTasks.add(localk);
    this.taskQueue.enqueue(new h()
    {
      public j<InputStream> then(j<Void> paramAnonymousj)
      {
        ParseFile.this.fetchInBackground(paramProgressCallback, paramAnonymousj, localk.a()).c(new h()
        {
          public InputStream then(j<File> paramAnonymous2j)
          {
            return new FileInputStream((File)paramAnonymous2j.f());
          }
        });
      }
    }).b(new h()
    {
      public j<InputStream> then(j<InputStream> paramAnonymousj)
      {
        localk.a(null);
        ParseFile.this.currentTasks.remove(localk);
        return paramAnonymousj;
      }
    });
  }
  
  public void getDataStreamInBackground(GetDataStreamCallback paramGetDataStreamCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(getDataStreamInBackground(), paramGetDataStreamCallback);
  }
  
  public void getDataStreamInBackground(GetDataStreamCallback paramGetDataStreamCallback, ProgressCallback paramProgressCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(getDataStreamInBackground(paramProgressCallback), paramGetDataStreamCallback);
  }
  
  public File getFile()
  {
    return (File)ParseTaskUtils.wait(getFileInBackground());
  }
  
  public j<File> getFileInBackground()
  {
    return getFileInBackground((ProgressCallback)null);
  }
  
  public j<File> getFileInBackground(final ProgressCallback paramProgressCallback)
  {
    final k localk = new k();
    this.currentTasks.add(localk);
    this.taskQueue.enqueue(new h()
    {
      public j<File> then(j<Void> paramAnonymousj)
      {
        return ParseFile.this.fetchInBackground(paramProgressCallback, paramAnonymousj, localk.a());
      }
    }).b(new h()
    {
      public j<File> then(j<File> paramAnonymousj)
      {
        localk.a(null);
        ParseFile.this.currentTasks.remove(localk);
        return paramAnonymousj;
      }
    });
  }
  
  public void getFileInBackground(GetFileCallback paramGetFileCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(getFileInBackground(), paramGetFileCallback);
  }
  
  public void getFileInBackground(GetFileCallback paramGetFileCallback, ProgressCallback paramProgressCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(getFileInBackground(paramProgressCallback), paramGetFileCallback);
  }
  
  public String getName()
  {
    return this.state.name();
  }
  
  State getState()
  {
    return this.state;
  }
  
  public String getUrl()
  {
    return this.state.url();
  }
  
  public boolean isDataAvailable()
  {
    return (this.data != null) || (getFileController().isDataAvailable(this.state));
  }
  
  public boolean isDirty()
  {
    return this.state.url() == null;
  }
  
  public void save()
  {
    ParseTaskUtils.wait(saveInBackground());
  }
  
  j<Void> saveAsync(final String paramString, final ProgressCallback paramProgressCallback, final j<Void> paramj)
  {
    this.taskQueue.enqueue(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        return ParseFile.this.saveAsync(paramString, paramProgressCallback, paramAnonymousj, paramj);
      }
    });
  }
  
  public j<Void> saveInBackground()
  {
    return saveInBackground((ProgressCallback)null);
  }
  
  public j<Void> saveInBackground(final ProgressCallback paramProgressCallback)
  {
    final k localk = new k();
    this.currentTasks.add(localk);
    ParseUser.getCurrentSessionTokenAsync().d(new h()
    {
      public j<Void> then(j<String> paramAnonymousj)
      {
        paramAnonymousj = (String)paramAnonymousj.f();
        return ParseFile.this.saveAsync(paramAnonymousj, paramProgressCallback, localk.a());
      }
    }).b(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        localk.a(null);
        ParseFile.this.currentTasks.remove(localk);
        return paramAnonymousj;
      }
    });
  }
  
  public void saveInBackground(SaveCallback paramSaveCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(saveInBackground(), paramSaveCallback);
  }
  
  public void saveInBackground(SaveCallback paramSaveCallback, ProgressCallback paramProgressCallback)
  {
    ParseTaskUtils.callbackOnMainThreadAsync(saveInBackground(paramProgressCallback), paramSaveCallback);
  }
  
  static class State
  {
    private final String contentType;
    private final String name;
    private final String url;
    
    private State(Builder paramBuilder)
    {
      if (paramBuilder.name != null) {}
      for (String str = paramBuilder.name;; str = "file")
      {
        this.name = str;
        this.contentType = paramBuilder.mimeType;
        this.url = paramBuilder.url;
        return;
      }
    }
    
    public String mimeType()
    {
      return this.contentType;
    }
    
    public String name()
    {
      return this.name;
    }
    
    public String url()
    {
      return this.url;
    }
    
    static class Builder
    {
      private String mimeType;
      private String name;
      private String url;
      
      public Builder() {}
      
      public Builder(ParseFile.State paramState)
      {
        this.name = paramState.name();
        this.mimeType = paramState.mimeType();
        this.url = paramState.url();
      }
      
      public ParseFile.State build()
      {
        return new ParseFile.State(this, null);
      }
      
      public Builder mimeType(String paramString)
      {
        this.mimeType = paramString;
        return this;
      }
      
      public Builder name(String paramString)
      {
        this.name = paramString;
        return this;
      }
      
      public Builder url(String paramString)
      {
        this.url = paramString;
        return this;
      }
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */