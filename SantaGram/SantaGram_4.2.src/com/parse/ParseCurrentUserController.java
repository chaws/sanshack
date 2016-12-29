package com.parse;

import a.j;

abstract interface ParseCurrentUserController
  extends ParseObjectCurrentController<ParseUser>
{
  public abstract j<ParseUser> getAsync(boolean paramBoolean);
  
  public abstract j<String> getCurrentSessionTokenAsync();
  
  public abstract j<Void> logOutAsync();
  
  public abstract j<Void> setIfNeededAsync(ParseUser paramParseUser);
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseCurrentUserController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */