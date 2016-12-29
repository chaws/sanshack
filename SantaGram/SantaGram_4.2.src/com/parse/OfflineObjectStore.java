package com.parse;

import a.h;
import a.j;
import java.util.Arrays;
import java.util.List;

class OfflineObjectStore<T extends ParseObject>
  implements ParseObjectStore<T>
{
  private final String className;
  private final ParseObjectStore<T> legacy;
  private final String pinName;
  
  public OfflineObjectStore(Class<T> paramClass, String paramString, ParseObjectStore<T> paramParseObjectStore)
  {
    this(getSubclassingController().getClassName(paramClass), paramString, paramParseObjectStore);
  }
  
  public OfflineObjectStore(String paramString1, String paramString2, ParseObjectStore<T> paramParseObjectStore)
  {
    this.className = paramString1;
    this.pinName = paramString2;
    this.legacy = paramParseObjectStore;
  }
  
  private static ParseObjectSubclassingController getSubclassingController()
  {
    return ParseCorePlugins.getInstance().getSubclassingController();
  }
  
  private static <T extends ParseObject> j<T> migrate(ParseObjectStore<T> paramParseObjectStore1, final ParseObjectStore<T> paramParseObjectStore2)
  {
    paramParseObjectStore1.getAsync().d(new h()
    {
      public j<T> then(j<T> paramAnonymousj)
      {
        final ParseObject localParseObject = (ParseObject)paramAnonymousj.f();
        if (localParseObject == null) {
          return paramAnonymousj;
        }
        j.a(Arrays.asList(new j[] { this.val$from.deleteAsync(), paramParseObjectStore2.setAsync(localParseObject) })).a(new h()
        {
          public T then(j<Void> paramAnonymous2j)
          {
            return localParseObject;
          }
        });
      }
    });
  }
  
  public j<Void> deleteAsync()
  {
    final j localj = ParseObject.unpinAllInBackground(this.pinName);
    j.a(Arrays.asList(new j[] { this.legacy.deleteAsync(), localj })).b(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        return localj;
      }
    });
  }
  
  public j<Boolean> existsAsync()
  {
    ParseQuery.getQuery(this.className).fromPin(this.pinName).ignoreACLs().countInBackground().d(new h()
    {
      public j<Boolean> then(j<Integer> paramAnonymousj)
      {
        if (((Integer)paramAnonymousj.f()).intValue() == 1) {}
        for (int i = 1; i != 0; i = 0) {
          return j.a(Boolean.valueOf(true));
        }
        return OfflineObjectStore.this.legacy.existsAsync();
      }
    });
  }
  
  public j<T> getAsync()
  {
    ParseQuery.getQuery(this.className).fromPin(this.pinName).ignoreACLs().findInBackground().d(new h()
    {
      public j<T> then(j<List<T>> paramAnonymousj)
      {
        paramAnonymousj = (List)paramAnonymousj.f();
        if (paramAnonymousj != null)
        {
          if (paramAnonymousj.size() == 1) {
            return j.a(paramAnonymousj.get(0));
          }
          return ParseObject.unpinAllInBackground(OfflineObjectStore.this.pinName).j();
        }
        return j.a(null);
      }
    }).d(new h()
    {
      public j<T> then(j<T> paramAnonymousj)
      {
        if ((ParseObject)paramAnonymousj.f() != null) {
          return paramAnonymousj;
        }
        return OfflineObjectStore.migrate(OfflineObjectStore.this.legacy, OfflineObjectStore.this).j();
      }
    });
  }
  
  public j<Void> setAsync(final T paramT)
  {
    ParseObject.unpinAllInBackground(this.pinName).b(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        return paramT.pinInBackground(OfflineObjectStore.this.pinName, false);
      }
    });
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/OfflineObjectStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */