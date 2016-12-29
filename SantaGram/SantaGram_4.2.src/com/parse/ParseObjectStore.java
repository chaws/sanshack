package com.parse;

import a.j;

abstract interface ParseObjectStore<T extends ParseObject>
{
  public abstract j<Void> deleteAsync();
  
  public abstract j<Boolean> existsAsync();
  
  public abstract j<T> getAsync();
  
  public abstract j<Void> setAsync(T paramT);
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseObjectStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */