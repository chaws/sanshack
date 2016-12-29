package com.parse;

import a.j;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

abstract class ParseSQLiteOpenHelper
{
  private final SQLiteOpenHelper helper;
  
  public ParseSQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    this.helper = new SQLiteOpenHelper(paramContext, paramString, paramCursorFactory, paramInt)
    {
      public void onCreate(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        ParseSQLiteOpenHelper.this.onCreate(paramAnonymousSQLiteDatabase);
      }
      
      public void onOpen(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        super.onOpen(paramAnonymousSQLiteDatabase);
        ParseSQLiteOpenHelper.this.onOpen(paramAnonymousSQLiteDatabase);
      }
      
      public void onUpgrade(SQLiteDatabase paramAnonymousSQLiteDatabase, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        ParseSQLiteOpenHelper.this.onUpgrade(paramAnonymousSQLiteDatabase, paramAnonymousInt1, paramAnonymousInt2);
      }
    };
  }
  
  private j<ParseSQLiteDatabase> getDatabaseAsync(boolean paramBoolean)
  {
    SQLiteOpenHelper localSQLiteOpenHelper = this.helper;
    if (!paramBoolean) {}
    for (int i = 1;; i = 0) {
      return ParseSQLiteDatabase.openDatabaseAsync(localSQLiteOpenHelper, i);
    }
  }
  
  public j<ParseSQLiteDatabase> getReadableDatabaseAsync()
  {
    return getDatabaseAsync(false);
  }
  
  public j<ParseSQLiteDatabase> getWritableDatabaseAsync()
  {
    return getDatabaseAsync(true);
  }
  
  public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase);
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase) {}
  
  public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseSQLiteOpenHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */