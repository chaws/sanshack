package com.parse;

import a.h;
import a.j;
import a.k;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ParseSQLiteDatabase
{
  private static final ExecutorService dbExecutor = ;
  private static final TaskQueue taskQueue = new TaskQueue();
  private j<Void> current = null;
  private final Object currentLock = new Object();
  private SQLiteDatabase db;
  private int openFlags;
  private final k<Void> tcs = new k();
  
  private ParseSQLiteDatabase(int paramInt)
  {
    this.openFlags = paramInt;
    taskQueue.enqueue(new h()
    {
      public j<Void> then(j<Void> paramAnonymousj)
      {
        synchronized (ParseSQLiteDatabase.this.currentLock)
        {
          ParseSQLiteDatabase.access$102(ParseSQLiteDatabase.this, paramAnonymousj);
          return ParseSQLiteDatabase.this.tcs.a();
        }
      }
    });
  }
  
  static j<ParseSQLiteDatabase> openDatabaseAsync(SQLiteOpenHelper paramSQLiteOpenHelper, int paramInt)
  {
    ParseSQLiteDatabase localParseSQLiteDatabase = new ParseSQLiteDatabase(paramInt);
    localParseSQLiteDatabase.open(paramSQLiteOpenHelper).b(new h()
    {
      public j<ParseSQLiteDatabase> then(j<Void> paramAnonymousj)
      {
        return j.a(this.val$db);
      }
    });
  }
  
  public j<Void> beginTransactionAsync()
  {
    synchronized (this.currentLock)
    {
      this.current = this.current.b(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          ParseSQLiteDatabase.this.db.beginTransaction();
          return paramAnonymousj;
        }
      }, dbExecutor);
      j localj = this.current.b(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          return paramAnonymousj;
        }
      }, j.a);
      return localj;
    }
  }
  
  public j<Void> closeAsync()
  {
    synchronized (this.currentLock)
    {
      this.current = this.current.b(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          try
          {
            ParseSQLiteDatabase.this.db.close();
            return ParseSQLiteDatabase.this.tcs.a();
          }
          finally
          {
            ParseSQLiteDatabase.this.tcs.b(null);
          }
        }
      }, dbExecutor);
      j localj = this.current.b(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          return paramAnonymousj;
        }
      }, j.a);
      return localj;
    }
  }
  
  public j<Void> deleteAsync(final String paramString1, final String paramString2, final String[] paramArrayOfString)
  {
    synchronized (this.currentLock)
    {
      paramString1 = this.current.c(new h()
      {
        public Integer then(j<Void> paramAnonymousj)
        {
          return Integer.valueOf(ParseSQLiteDatabase.this.db.delete(paramString1, paramString2, paramArrayOfString));
        }
      }, dbExecutor);
      this.current = paramString1.k();
      paramString1 = paramString1.b(new h()
      {
        public j<Integer> then(j<Integer> paramAnonymousj)
        {
          return paramAnonymousj;
        }
      }, j.a).k();
      return paramString1;
    }
  }
  
  public j<Void> endTransactionAsync()
  {
    synchronized (this.currentLock)
    {
      this.current = this.current.a(new h()
      {
        public Void then(j<Void> paramAnonymousj)
        {
          ParseSQLiteDatabase.this.db.endTransaction();
          return null;
        }
      }, dbExecutor);
      j localj = this.current.b(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          return paramAnonymousj;
        }
      }, j.a);
      return localj;
    }
  }
  
  public boolean inTransaction()
  {
    return this.db.inTransaction();
  }
  
  public j<Void> insertOrThrowAsync(final String paramString, final ContentValues paramContentValues)
  {
    synchronized (this.currentLock)
    {
      paramString = this.current.c(new h()
      {
        public Long then(j<Void> paramAnonymousj)
        {
          return Long.valueOf(ParseSQLiteDatabase.this.db.insertOrThrow(paramString, null, paramContentValues));
        }
      }, dbExecutor);
      this.current = paramString.k();
      paramString = paramString.b(new h()
      {
        public j<Long> then(j<Long> paramAnonymousj)
        {
          return paramAnonymousj;
        }
      }, j.a).k();
      return paramString;
    }
  }
  
  public j<Void> insertWithOnConflict(final String paramString, final ContentValues paramContentValues, final int paramInt)
  {
    synchronized (this.currentLock)
    {
      paramString = this.current.c(new h()
      {
        public Long then(j<Void> paramAnonymousj)
        {
          return Long.valueOf(ParseSQLiteDatabase.this.db.insertWithOnConflict(paramString, null, paramContentValues, paramInt));
        }
      }, dbExecutor);
      this.current = paramString.k();
      paramString = paramString.b(new h()
      {
        public j<Long> then(j<Long> paramAnonymousj)
        {
          return paramAnonymousj;
        }
      }, j.a).k();
      return paramString;
    }
  }
  
  public j<Boolean> isOpenAsync()
  {
    synchronized (this.currentLock)
    {
      j localj = this.current.a(new h()
      {
        public Boolean then(j<Void> paramAnonymousj)
        {
          return Boolean.valueOf(ParseSQLiteDatabase.this.db.isOpen());
        }
      });
      this.current = localj.k();
      return localj;
    }
  }
  
  public j<Boolean> isReadOnlyAsync()
  {
    synchronized (this.currentLock)
    {
      j localj = this.current.a(new h()
      {
        public Boolean then(j<Void> paramAnonymousj)
        {
          return Boolean.valueOf(ParseSQLiteDatabase.this.db.isReadOnly());
        }
      });
      this.current = localj.k();
      return localj;
    }
  }
  
  j<Void> open(final SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    synchronized (this.currentLock)
    {
      this.current = this.current.a(new h()
      {
        public SQLiteDatabase then(j<Void> paramAnonymousj)
        {
          if ((ParseSQLiteDatabase.this.openFlags & 0x1) == 1) {
            return paramSQLiteOpenHelper.getReadableDatabase();
          }
          return paramSQLiteOpenHelper.getWritableDatabase();
        }
      }, dbExecutor).b(new h()
      {
        public j<Void> then(j<SQLiteDatabase> paramAnonymousj)
        {
          ParseSQLiteDatabase.access$302(ParseSQLiteDatabase.this, (SQLiteDatabase)paramAnonymousj.f());
          return paramAnonymousj.k();
        }
      }, j.a);
      paramSQLiteOpenHelper = this.current;
      return paramSQLiteOpenHelper;
    }
  }
  
  public j<Cursor> queryAsync(final String paramString1, final String[] paramArrayOfString1, final String paramString2, final String[] paramArrayOfString2)
  {
    synchronized (this.currentLock)
    {
      paramString1 = this.current.c(new h()
      {
        public Cursor then(j<Void> paramAnonymousj)
        {
          return ParseSQLiteDatabase.this.db.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, null);
        }
      }, dbExecutor).c(new h()
      {
        public Cursor then(j<Cursor> paramAnonymousj)
        {
          paramAnonymousj = ParseSQLiteCursor.create((Cursor)paramAnonymousj.f(), ParseSQLiteDatabase.dbExecutor);
          paramAnonymousj.getCount();
          return paramAnonymousj;
        }
      }, dbExecutor);
      this.current = paramString1.k();
      paramString1 = paramString1.b(new h()
      {
        public j<Cursor> then(j<Cursor> paramAnonymousj)
        {
          return paramAnonymousj;
        }
      }, j.a);
      return paramString1;
    }
  }
  
  public j<Cursor> rawQueryAsync(final String paramString, final String[] paramArrayOfString)
  {
    synchronized (this.currentLock)
    {
      paramString = this.current.c(new h()
      {
        public Cursor then(j<Void> paramAnonymousj)
        {
          return ParseSQLiteDatabase.this.db.rawQuery(paramString, paramArrayOfString);
        }
      }, dbExecutor).c(new h()
      {
        public Cursor then(j<Cursor> paramAnonymousj)
        {
          paramAnonymousj = ParseSQLiteCursor.create((Cursor)paramAnonymousj.f(), ParseSQLiteDatabase.dbExecutor);
          paramAnonymousj.getCount();
          return paramAnonymousj;
        }
      }, dbExecutor);
      this.current = paramString.k();
      paramString = paramString.b(new h()
      {
        public j<Cursor> then(j<Cursor> paramAnonymousj)
        {
          return paramAnonymousj;
        }
      }, j.a);
      return paramString;
    }
  }
  
  public j<Void> setTransactionSuccessfulAsync()
  {
    synchronized (this.currentLock)
    {
      this.current = this.current.d(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          ParseSQLiteDatabase.this.db.setTransactionSuccessful();
          return paramAnonymousj;
        }
      }, dbExecutor);
      j localj = this.current.b(new h()
      {
        public j<Void> then(j<Void> paramAnonymousj)
        {
          return paramAnonymousj;
        }
      }, j.a);
      return localj;
    }
  }
  
  public j<Integer> updateAsync(final String paramString1, final ContentValues paramContentValues, final String paramString2, final String[] paramArrayOfString)
  {
    synchronized (this.currentLock)
    {
      paramString1 = this.current.c(new h()
      {
        public Integer then(j<Void> paramAnonymousj)
        {
          return Integer.valueOf(ParseSQLiteDatabase.this.db.update(paramString1, paramContentValues, paramString2, paramArrayOfString));
        }
      }, dbExecutor);
      this.current = paramString1.k();
      paramString1 = paramString1.b(new h()
      {
        public j<Integer> then(j<Integer> paramAnonymousj)
        {
          return paramAnonymousj;
        }
      }, j.a);
      return paramString1;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseSQLiteDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */