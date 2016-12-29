package com.parse;

import a.j;
import java.util.Map;

abstract interface ParseUserController
{
  public abstract j<ParseUser.State> getUserAsync(String paramString);
  
  public abstract j<ParseUser.State> logInAsync(ParseUser.State paramState, ParseOperationSet paramParseOperationSet);
  
  public abstract j<ParseUser.State> logInAsync(String paramString1, String paramString2);
  
  public abstract j<ParseUser.State> logInAsync(String paramString, Map<String, String> paramMap);
  
  public abstract j<Void> requestPasswordResetAsync(String paramString);
  
  public abstract j<ParseUser.State> signUpAsync(ParseObject.State paramState, ParseOperationSet paramParseOperationSet, String paramString);
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseUserController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */