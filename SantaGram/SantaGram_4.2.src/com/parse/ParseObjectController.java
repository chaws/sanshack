package com.parse;

import a.j;
import java.util.List;

abstract interface ParseObjectController
{
  public abstract List<j<Void>> deleteAllAsync(List<ParseObject.State> paramList, String paramString);
  
  public abstract j<Void> deleteAsync(ParseObject.State paramState, String paramString);
  
  public abstract j<ParseObject.State> fetchAsync(ParseObject.State paramState, String paramString, ParseDecoder paramParseDecoder);
  
  public abstract List<j<ParseObject.State>> saveAllAsync(List<ParseObject.State> paramList, List<ParseOperationSet> paramList1, String paramString, List<ParseDecoder> paramList2);
  
  public abstract j<ParseObject.State> saveAsync(ParseObject.State paramState, ParseOperationSet paramParseOperationSet, String paramString, ParseDecoder paramParseDecoder);
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseObjectController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */