package com.parse;

import a.h;
import a.j;
import java.util.List;

abstract class AbstractQueryController
  implements ParseQueryController
{
  public <T extends ParseObject> j<T> getFirstAsync(ParseQuery.State<T> paramState, ParseUser paramParseUser, j<Void> paramj)
  {
    findAsync(paramState, paramParseUser, paramj).a(new h()
    {
      public T then(j<List<T>> paramAnonymousj)
      {
        if (paramAnonymousj.e()) {
          throw paramAnonymousj.g();
        }
        if ((paramAnonymousj.f() != null) && (((List)paramAnonymousj.f()).size() > 0)) {
          return (ParseObject)((List)paramAnonymousj.f()).get(0);
        }
        throw new ParseException(101, "no results found for query");
      }
    });
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/AbstractQueryController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */