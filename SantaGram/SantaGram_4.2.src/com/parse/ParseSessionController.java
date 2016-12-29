package com.parse;

import a.j;

abstract interface ParseSessionController
{
  public abstract j<ParseObject.State> getSessionAsync(String paramString);
  
  public abstract j<Void> revokeAsync(String paramString);
  
  public abstract j<ParseObject.State> upgradeToRevocable(String paramString);
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseSessionController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */