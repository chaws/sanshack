package com.northpolewonderland.santagram;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.a.a;
import android.support.v7.a.e;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Home
  extends e
{
  ProgressDialog a;
  List<ParseObject> b;
  List<ParseObject> c;
  ParseUser d = ParseUser.getCurrentUser();
  
  void a()
  {
    this.a.setMessage("Loading Posts...");
    this.a.show();
    this.b = new ArrayList();
    ParseQuery localParseQuery = ParseQuery.getQuery(Configs.FOLLOW_CLASS_NAME);
    localParseQuery.whereEqualTo(Configs.FOLLOW_A_USER, this.d);
    localParseQuery.findInBackground(new FindCallback()
    {
      public void done(List<ParseObject> paramAnonymousList, ParseException paramAnonymousParseException)
      {
        int i = 0;
        if (paramAnonymousParseException == null)
        {
          Home.this.c = paramAnonymousList;
          if (Home.this.c.size() != 0) {
            while (i < Home.this.c.size())
            {
              ((ParseObject)Home.this.c.get(i)).getParseObject(Configs.FOLLOW_IS_FOLLOWING).fetchIfNeededInBackground(new GetCallback()
              {
                public void done(ParseObject paramAnonymous2ParseObject, ParseException paramAnonymous2ParseException)
                {
                  if (!paramAnonymous2ParseObject.getBoolean(Configs.USER_IS_REPORTED))
                  {
                    paramAnonymous2ParseException = ParseQuery.getQuery(Configs.POSTS_CLASSE_NAME);
                    paramAnonymous2ParseException.whereEqualTo(Configs.POSTS_USER_POINTER, paramAnonymous2ParseObject);
                    paramAnonymous2ParseException.whereEqualTo(Configs.POSTS_IS_REPORTED, Boolean.valueOf(false));
                    paramAnonymous2ParseException.orderByDescending(Configs.POSTS_CREATED_AT);
                    paramAnonymous2ParseException.findInBackground(new FindCallback()
                    {
                      public void done(List<ParseObject> paramAnonymous3List, ParseException paramAnonymous3ParseException)
                      {
                        if (paramAnonymous3ParseException == null)
                        {
                          if (paramAnonymous3List != null)
                          {
                            paramAnonymous3List = paramAnonymous3List.iterator();
                            while (paramAnonymous3List.hasNext())
                            {
                              paramAnonymous3ParseException = (ParseObject)paramAnonymous3List.next();
                              Home.this.b.add(paramAnonymous3ParseException);
                            }
                          }
                          Home.this.a.dismiss();
                          Home.this.b();
                          return;
                        }
                        Toast.makeText(Home.this.getApplicationContext(), paramAnonymous3ParseException.getMessage().toString(), 1).show();
                      }
                    });
                  }
                }
              });
              i += 1;
            }
          }
          ((TextView)Home.this.findViewById(2131558553)).setVisibility(0);
          Home.this.a.dismiss();
          return;
        }
        Toast.makeText(Home.this.getApplicationContext(), paramAnonymousParseException.getMessage().toString(), 1).show();
        Home.this.a.dismiss();
      }
    });
  }
  
  void b()
  {
    ListView localListView = (ListView)findViewById(2131558554);
    localListView.setAdapter(new a(this, this.b));
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = (ParseObject)Home.this.b.get(paramAnonymousInt);
        paramAnonymousView = new Intent(Home.this, PostDetails.class);
        Bundle localBundle = new Bundle();
        localBundle.putString("objectID", paramAnonymousAdapterView.getObjectId().toString());
        paramAnonymousView.putExtras(localBundle);
        Home.this.startActivity(paramAnonymousView);
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968621);
    super.setRequestedOrientation(1);
    b.a(getApplicationContext(), getClass().getSimpleName());
    getSupportActionBar().a(2131165208);
    this.a = new ProgressDialog(this);
    this.a.setTitle(2131165208);
    this.a.setIndeterminate(false);
    paramBundle = (Button)findViewById(2131558551);
    Button localButton = (Button)findViewById(2131558552);
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Home.this.startActivity(new Intent(Home.this, Search.class));
      }
    });
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Home.this.startActivity(new Intent(Home.this, Me.class));
      }
    });
    if (this.d.getUsername() != null) {
      a();
    }
    new b((ImageView)findViewById(2131558508)).execute(new String[] { getString(2131165210) });
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623937, paramMenu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    a();
    return true;
  }
  
  protected void onStart()
  {
    super.onStart();
    if (this.d.getUsername() == null) {
      startActivity(new Intent(this, Login.class));
    }
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
      return Home.this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return Home.this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2130968633, null);
      }
      paramView = (ParseObject)Home.this.b.get(paramInt);
      paramView.getParseObject(Configs.POSTS_USER_POINTER).fetchIfNeededInBackground(new GetCallback()
      {
        public void done(final ParseObject paramAnonymousParseObject, final ParseException paramAnonymousParseException)
        {
          ((TextView)paramViewGroup.findViewById(2131558595)).setText(paramAnonymousParseObject.getString(Configs.USER_FULLNAME));
          paramAnonymousParseException = (ImageView)paramViewGroup.findViewById(2131558596);
          paramAnonymousParseException.setImageResource(2130837592);
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
          paramAnonymousParseException.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              Home.a.1.this.b.getParseObject(Configs.POSTS_USER_POINTER).fetchIfNeededInBackground(new GetCallback()
              {
                public void done(ParseObject paramAnonymous3ParseObject, ParseException paramAnonymous3ParseException)
                {
                  paramAnonymous3ParseException = new Intent(Home.this, OtherUserProfile.class);
                  paramAnonymous3ParseException.putExtra("objectID", paramAnonymous3ParseObject.getObjectId().toString());
                  Home.this.startActivity(paramAnonymous3ParseException);
                }
              });
            }
          });
          paramAnonymousParseObject = (TextView)paramViewGroup.findViewById(2131558602);
          if (paramView.getString(Configs.POSTS_CITY) != null)
          {
            paramAnonymousParseObject.setText(paramView.getString(Configs.POSTS_CITY));
            ((TextView)paramViewGroup.findViewById(2131558603)).setText(paramView.getString(Configs.POSTS_TEXT));
            paramAnonymousParseObject = (TextView)paramViewGroup.findViewById(2131558605);
            if (paramView.getNumber(Configs.POSTS_LIKES) == null) {
              break label283;
            }
            paramAnonymousParseObject.setText(String.valueOf(paramView.getNumber(Configs.POSTS_LIKES)));
          }
          for (;;)
          {
            paramAnonymousParseObject = (ImageView)paramViewGroup.findViewById(2131558599);
            paramAnonymousParseException = (ParseFile)paramView.get(Configs.POSTS_IMAGE);
            if (paramAnonymousParseException != null) {
              paramAnonymousParseException.getDataInBackground(new GetDataCallback()
              {
                public void done(byte[] paramAnonymous2ArrayOfByte, ParseException paramAnonymous2ParseException)
                {
                  if (paramAnonymous2ParseException == null)
                  {
                    paramAnonymous2ArrayOfByte = BitmapFactory.decodeByteArray(paramAnonymous2ArrayOfByte, 0, paramAnonymous2ArrayOfByte.length);
                    if (paramAnonymous2ArrayOfByte != null) {
                      paramAnonymousParseObject.setImageBitmap(paramAnonymous2ArrayOfByte);
                    }
                  }
                }
              });
            }
            paramAnonymousParseObject = (RelativeLayout)paramViewGroup.findViewById(2131558600);
            int i = new Random().nextInt(Configs.colorsArray.length);
            paramAnonymousParseObject.setBackgroundColor(Color.parseColor(Configs.colorsArray[i]));
            return;
            paramAnonymousParseObject.setText("N/A");
            break;
            label283:
            paramAnonymousParseObject.setText("0");
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
        paramVarArgs = (HttpURLConnection)new URL(paramVarArgs).openConnection();
        paramVarArgs.setDoInput(true);
        paramVarArgs.connect();
        InputStream localInputStream = paramVarArgs.getInputStream();
        paramVarArgs = BitmapFactory.decodeStream(localInputStream);
        Log.e(Home.this.getString(2131165204), "downloadImageTask error: " + localException1.getMessage());
      }
      catch (Exception localException1)
      {
        try
        {
          Log.d(Home.this.getString(2131165204), "Retrieved Ad content, length " + localInputStream.available());
          return paramVarArgs;
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
        localException1 = localException1;
        paramVarArgs = null;
      }
      localException1.printStackTrace();
      return paramVarArgs;
    }
    
    protected void a(Bitmap paramBitmap)
    {
      this.a.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/northpolewonderland/santagram/Home.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */