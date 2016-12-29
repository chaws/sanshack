package com.parse;

import a.j;
import java.util.List;

class OfflineQueryController
  extends AbstractQueryController
{
  private final ParseQueryController networkController;
  private final OfflineStore offlineStore;
  
  public OfflineQueryController(OfflineStore paramOfflineStore, ParseQueryController paramParseQueryController)
  {
    this.offlineStore = paramOfflineStore;
    this.networkController = paramParseQueryController;
  }
  
  public <T extends ParseObject> j<Integer> countAsync(ParseQuery.State<T> paramState, ParseUser paramParseUser, j<Void> paramj)
  {
    if (paramState.isFromLocalDatastore()) {
      return this.offlineStore.countFromPinAsync(paramState.pinName(), paramState, paramParseUser);
    }
    return this.networkController.countAsync(paramState, paramParseUser, paramj);
  }
  
  public <T extends ParseObject> j<List<T>> findAsync(ParseQuery.State<T> paramState, ParseUser paramParseUser, j<Void> paramj)
  {
    if (paramState.isFromLocalDatastore()) {
      return this.offlineStore.findFromPinAsync(paramState.pinName(), paramState, paramParseUser);
    }
    return this.networkController.findAsync(paramState, paramParseUser, paramj);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/OfflineQueryController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */