package com.parse;

import a.j;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import org.json.JSONException;

class FileObjectStore<T extends ParseObject>
  implements ParseObjectStore<T>
{
  private final String className;
  private final ParseObjectCurrentCoder coder;
  private final File file;
  
  public FileObjectStore(Class<T> paramClass, File paramFile, ParseObjectCurrentCoder paramParseObjectCurrentCoder)
  {
    this(getSubclassingController().getClassName(paramClass), paramFile, paramParseObjectCurrentCoder);
  }
  
  public FileObjectStore(String paramString, File paramFile, ParseObjectCurrentCoder paramParseObjectCurrentCoder)
  {
    this.className = paramString;
    this.file = paramFile;
    this.coder = paramParseObjectCurrentCoder;
  }
  
  private static <T extends ParseObject> T getFromDisk(ParseObjectCurrentCoder paramParseObjectCurrentCoder, File paramFile, ParseObject.State.Init paramInit)
  {
    try
    {
      paramFile = ParseFileUtils.readFileToJSONObject(paramFile);
      return ParseObject.from(paramParseObjectCurrentCoder.decode(paramInit, paramFile, ParseDecoder.get()).isComplete(true).build());
    }
    catch (IOException paramParseObjectCurrentCoder)
    {
      return null;
    }
    catch (JSONException paramParseObjectCurrentCoder)
    {
      for (;;) {}
    }
  }
  
  private static ParseObjectSubclassingController getSubclassingController()
  {
    return ParseCorePlugins.getInstance().getSubclassingController();
  }
  
  private static void saveToDisk(ParseObjectCurrentCoder paramParseObjectCurrentCoder, ParseObject paramParseObject, File paramFile)
  {
    paramParseObjectCurrentCoder = paramParseObjectCurrentCoder.encode(paramParseObject.getState(), null, PointerEncoder.get());
    try
    {
      ParseFileUtils.writeJSONObjectToFile(paramFile, paramParseObjectCurrentCoder);
      return;
    }
    catch (IOException paramParseObjectCurrentCoder) {}
  }
  
  public j<Void> deleteAsync()
  {
    j.a(new Callable()
    {
      public Void call()
      {
        if ((FileObjectStore.this.file.exists()) && (!ParseFileUtils.deleteQuietly(FileObjectStore.this.file))) {
          throw new RuntimeException("Unable to delete");
        }
        return null;
      }
    }, ParseExecutors.io());
  }
  
  public j<Boolean> existsAsync()
  {
    j.a(new Callable()
    {
      public Boolean call()
      {
        return Boolean.valueOf(FileObjectStore.this.file.exists());
      }
    }, ParseExecutors.io());
  }
  
  public j<T> getAsync()
  {
    j.a(new Callable()
    {
      public T call()
      {
        if (!FileObjectStore.this.file.exists()) {
          return null;
        }
        return FileObjectStore.getFromDisk(FileObjectStore.this.coder, FileObjectStore.this.file, ParseObject.State.newBuilder(FileObjectStore.this.className));
      }
    }, ParseExecutors.io());
  }
  
  public j<Void> setAsync(final T paramT)
  {
    j.a(new Callable()
    {
      public Void call()
      {
        FileObjectStore.saveToDisk(FileObjectStore.this.coder, paramT, FileObjectStore.this.file);
        return null;
      }
    }, ParseExecutors.io());
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/FileObjectStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */