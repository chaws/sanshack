package com.parse;

abstract interface ParseFieldOperation
{
  public abstract Object apply(Object paramObject, String paramString);
  
  public abstract Object encode(ParseEncoder paramParseEncoder);
  
  public abstract ParseFieldOperation mergeWithPrevious(ParseFieldOperation paramParseFieldOperation);
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseFieldOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */