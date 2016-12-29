package com.parse;

import a.j;

abstract interface ParseObjectCurrentController<T extends ParseObject>
{
  public abstract void clearFromDisk();
  
  public abstract void clearFromMemory();
  
  public abstract j<Boolean> existsAsync();
  
  public abstract j<T> getAsync();
  
  public abstract boolean isCurrent(T paramT);
  
  public abstract j<Void> setAsync(T paramT);
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseObjectCurrentController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */