package com.northpolewonderland.santagram;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.a.a;
import android.support.v7.a.e;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import java.net.URL;
import java.util.List;

public class Follow
  extends e
{
  ProgressDialog a;
  List<ParseObject> b;
  ParseObject c;
  String d = "";
  
  void a()
  {
    ListView localListView = (ListView)findViewById(2131558546);
    localListView.setAdapter(new a(this, this.b));
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = (ParseObject)Follow.this.b.get(paramAnonymousInt);
        if (Follow.this.d.matches("Followers")) {
          paramAnonymousAdapterView.getParseObject(Configs.FOLLOW_A_USER).fetchIfNeededInBackground(new GetCallback()
          {
            public void done(ParseObject paramAnonymous2ParseObject, ParseException paramAnonymous2ParseException)
            {
              paramAnonymous2ParseException = new Intent(Follow.this, OtherUserProfile.class);
              paramAnonymous2ParseException.putExtra("objectID", paramAnonymous2ParseObject.getObjectId().toString());
              Follow.this.startActivity(paramAnonymous2ParseException);
            }
          });
        }
        while (!Follow.this.d.matches("Following")) {
          return;
        }
        paramAnonymousAdapterView.getParseObject(Configs.FOLLOW_IS_FOLLOWING).fetchIfNeededInBackground(new GetCallback()
        {
          public void done(ParseObject paramAnonymous2ParseObject, ParseException paramAnonymous2ParseException)
          {
            paramAnonymous2ParseException = new Intent(Follow.this, OtherUserProfile.class);
            Bundle localBundle = new Bundle();
            localBundle.putString("objectID", paramAnonymous2ParseObject.getObjectId().toString());
            paramAnonymous2ParseException.putExtras(localBundle);
            Follow.this.startActivity(paramAnonymous2ParseException);
          }
        });
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968619);
    super.setRequestedOrientation(1);
    b.a(getApplicationContext(), getClass().getSimpleName());
    getSupportActionBar().a(true);
    getSupportActionBar().b(true);
    this.a = new ProgressDialog(this);
    this.a.setTitle(2131165208);
    this.a.setIndeterminate(false);
    paramBundle = getIntent().getExtras();
    this.d = paramBundle.getString("follow");
    paramBundle = paramBundle.getString("objectID");
    this.c = ParseObject.createWithoutData(Configs.USER_CLASS_NAME, paramBundle);
    try
    {
      this.c.fetchIfNeeded().getParseObject(Configs.USER_CLASS_NAME);
      if (this.d.matches("Followers"))
      {
        this.a.setMessage("Loading Followers...");
        this.a.show();
        paramBundle = ParseQuery.getQuery(Configs.FOLLOW_CLASS_NAME);
        paramBundle.whereEqualTo(Configs.FOLLOW_IS_FOLLOWING, this.c);
        paramBundle.findInBackground(new FindCallback()
        {
          public void done(List<ParseObject> paramAnonymousList, ParseException paramAnonymousParseException)
          {
            if (paramAnonymousParseException == null)
            {
              Follow.this.b = paramAnonymousList;
              Follow.this.a.dismiss();
              Follow.this.a();
              return;
            }
            Toast.makeText(Follow.this.getApplicationContext(), paramAnonymousParseException.getMessage(), 1).show();
            Follow.this.a.dismiss();
          }
        });
      }
      for (;;)
      {
        getSupportActionBar().a(this.d);
        new b((ImageView)findViewById(2131558508)).execute(new String[] { getString(2131165210) });
        return;
        if (this.d.matches("Following"))
        {
          this.a.setMessage("Loading Following...");
          this.a.show();
          paramBundle = ParseQuery.getQuery(Configs.FOLLOW_CLASS_NAME);
          paramBundle.whereEqualTo(Configs.FOLLOW_A_USER, this.c);
          paramBundle.findInBackground(new FindCallback()
          {
            public void done(List<ParseObject> paramAnonymousList, ParseException paramAnonymousParseException)
            {
              if (paramAnonymousParseException == null)
              {
                Follow.this.b = paramAnonymousList;
                Follow.this.a.dismiss();
                Follow.this.a();
                return;
              }
              Toast.makeText(Follow.this.getApplicationContext(), paramAnonymousParseException.getMessage().toString(), 1).show();
              Follow.this.a.dismiss();
            }
          });
        }
      }
    }
    catch (ParseException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    finish();
    return true;
  }
  
  class a
    extends BaseAdapter
  {
    private Context b;
    
    public a(List<ParseObject> paramList)
    {
      this.b = paramList;
    }
    
    public int getCount()
    {
      return Follow.this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return Follow.this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2130968620, null);
      }
      paramView = (ParseObject)Follow.this.b.get(paramInt);
      if (Follow.this.d.matches("Followers")) {
        paramView.getParseObject(Configs.FOLLOW_A_USER).fetchIfNeededInBackground(new GetCallback()
        {
          public void done(ParseObject paramAnonymousParseObject, final ParseException paramAnonymousParseException)
          {
            ((TextView)paramViewGroup.findViewById(2131558548)).setText(paramAnonymousParseObject.getString(Configs.USER_FULLNAME));
            paramAnonymousParseException = (ImageView)paramViewGroup.findViewById(2131558547);
            paramAnonymousParseObject = (ParseFile)paramAnonymousParseObject.get(Configs.USER_AVATAR);
            if (paramAnonymousParseObject != null) {
              paramAnonymousParseObject.getDataInBackground(new GetDataCallback()
              {
                public void done(byte[] paramAnonymous2ArrayOfByte, ParseException paramAnonymous2ParseException)
                {
                  if (paramAnonymous2ParseException == null)
                  {
                    paramAnonymous2ArrayOfByte = BitmapFactory.decodeByteArray(paramAnonymous2ArrayOfByte, 0, paramAnonymous2ArrayOfByte.length);
                    if (paramAnonymous2ArrayOfByte != null) {
                      paramAnonymousParseException.setImageBitmap(paramAnonymous2ArrayOfByte);
                    }
                  }
                }
              });
            }
          }
        });
      }
      while (!Follow.this.d.matches("Following")) {
        return paramViewGroup;
      }
      paramView.getParseObject(Configs.FOLLOW_IS_FOLLOWING).fetchIfNeededInBackground(new GetCallback()
      {
        public void done(ParseObject paramAnonymousParseObject, final ParseException paramAnonymousParseException)
        {
          ((TextView)paramViewGroup.findViewById(2131558548)).setText(paramAnonymousParseObject.getString(Configs.USER_FULLNAME));
          paramAnonymousParseException = (ImageView)paramViewGroup.findViewById(2131558547);
          paramAnonymousParseObject = (ParseFile)paramAnonymousParseObject.get(Configs.USER_AVATAR);
          if (paramAnonymousParseObject != null) {
            paramAnonymousParseObject.getDataInBackground(new GetDataCallback()
            {
              public void done(byte[] paramAnonymous2ArrayOfByte, ParseException paramAnonymous2ParseException)
              {
                if (paramAnonymous2ParseException == null)
                {
                  paramAnonymous2ArrayOfByte = BitmapFactory.decodeByteArray(paramAnonymous2ArrayOfByte, 0, paramAnonymous2ArrayOfByte.length);
                  if (paramAnonymous2ArrayOfByte != null) {
                    paramAnonymousParseException.setImageBitmap(paramAnonymous2ArrayOfByte);
                  }
                }
              }
            });
          }
        }
      });
      return paramViewGroup;
    }
  }
  
  private class b
    extends AsyncTask<String, Void, Bitmap>
  {
    ImageView a;
    
    public b(ImageView paramImageView)
    {
      this.a = paramImageView;
    }
    
    protected Bitmap a(String... paramVarArgs)
    {
      paramVarArgs = paramVarArgs[0];
      try
      {
        paramVarArgs = BitmapFactory.decodeStream(new URL(paramVarArgs).openStream());
        return paramVarArgs;
      }
      catch (Exception paramVarArgs)
      {
        Log.e(Follow.this.getString(2131165204), "Error: " + paramVarArgs.getMessage());
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void a(Bitmap paramBitmap)
    {
      this.a.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/northpolewonderland/santagram/Follow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */