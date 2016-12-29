package com.parse;

import a.j;
import java.util.List;

abstract interface ParseQueryController
{
  public abstract <T extends ParseObject> j<Integer> countAsync(ParseQuery.State<T> paramState, ParseUser paramParseUser, j<Void> paramj);
  
  public abstract <T extends ParseObject> j<List<T>> findAsync(ParseQuery.State<T> paramState, ParseUser paramParseUser, j<Void> paramj);
  
  public abstract <T extends ParseObject> j<T> getFirstAsync(ParseQuery.State<T> paramState, ParseUser paramParseUser, j<Void> paramj);
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseQueryController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */