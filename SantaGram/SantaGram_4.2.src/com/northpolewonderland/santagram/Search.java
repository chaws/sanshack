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
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Search
  extends e
{
  ProgressDialog pd;
  List<ParseObject> postsArray;
  EditText searchTxt;
  
  public void dismisskeyboard()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.searchTxt.getWindowToken(), 0);
    this.searchTxt.setText("");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968635);
    super.setRequestedOrientation(1);
    b.a(getApplicationContext(), getClass().getSimpleName());
    getSupportActionBar().a("Popular");
    this.pd = new ProgressDialog(this);
    this.pd.setTitle(2131165208);
    this.pd.setIndeterminate(false);
    this.searchTxt = ((EditText)findViewById(2131558622));
    paramBundle = (Button)findViewById(2131558550);
    Button localButton = (Button)findViewById(2131558552);
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Search.this.startActivity(new Intent(Search.this, Home.class));
      }
    });
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Search.this.startActivity(new Intent(Search.this, Me.class));
      }
    });
    this.searchTxt.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        int i = 0;
        if (paramAnonymousInt == 3)
        {
          paramAnonymousTextView = new ArrayList();
          paramAnonymousKeyEvent = Search.this.searchTxt.getText().toString().toLowerCase().split(" ");
          int j = paramAnonymousKeyEvent.length;
          paramAnonymousInt = i;
          while (paramAnonymousInt < j)
          {
            paramAnonymousTextView.add(paramAnonymousKeyEvent[paramAnonymousInt]);
            paramAnonymousInt += 1;
          }
          Search.this.queryPosts((ArrayList)paramAnonymousTextView);
          return true;
        }
        return false;
      }
    });
    queryPosts(null);
    new a((ImageView)findViewById(2131558508)).execute(new String[] { getString(2131165210) });
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623940, paramMenu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    queryPosts(null);
    return true;
  }
  
  void queryPosts(ArrayList paramArrayList)
  {
    this.pd.setMessage("Loading...");
    this.pd.show();
    dismisskeyboard();
    ParseQuery localParseQuery = ParseQuery.getQuery(Configs.POSTS_CLASSE_NAME);
    if (paramArrayList != null)
    {
      localParseQuery.whereContainedIn(Configs.POSTS_KEYWORDS, paramArrayList);
      getSupportActionBar().a("Search");
    }
    for (;;)
    {
      localParseQuery.whereEqualTo(Configs.POSTS_IS_REPORTED, Boolean.valueOf(false));
      localParseQuery.findInBackground(new FindCallback()
      {
        public void done(List<ParseObject> paramAnonymousList, ParseException paramAnonymousParseException)
        {
          if (paramAnonymousParseException == null)
          {
            Search.this.postsArray = paramAnonymousList;
            Search.this.pd.dismiss();
            paramAnonymousList = (ListView)Search.this.findViewById(2131558624);
            paramAnonymousList.setAdapter(new a(Search.this, Search.this.postsArray));
            paramAnonymousList.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              public void onItemClick(AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
              {
                paramAnonymous2AdapterView = (ParseObject)Search.this.postsArray.get(paramAnonymous2Int);
                paramAnonymous2View = new Intent(Search.this, PostDetails.class);
                Bundle localBundle = new Bundle();
                localBundle.putString("objectID", paramAnonymous2AdapterView.getObjectId().toString());
                paramAnonymous2View.putExtras(localBundle);
                Search.this.startActivity(paramAnonymous2View);
              }
            });
            return;
          }
          Toast.makeText(Search.this.getApplicationContext(), paramAnonymousParseException.getMessage().toString(), 1).show();
          Search.this.pd.dismiss();
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
            return Search.this.postsArray.size();
          }
          
          public Object getItem(int paramInt)
          {
            return Search.this.postsArray.get(paramInt);
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
            paramView = (ParseObject)Search.this.postsArray.get(paramInt);
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
                    Search.4.a.1.this.b.getParseObject(Configs.POSTS_USER_POINTER).fetchIfNeededInBackground(new GetCallback()
                    {
                      public void done(ParseObject paramAnonymous3ParseObject, ParseException paramAnonymous3ParseException)
                      {
                        paramAnonymous3ParseException = new Intent(Search.this, OtherUserProfile.class);
                        paramAnonymous3ParseException.putExtra("objectID", paramAnonymous3ParseObject.getObjectId().toString());
                        Search.this.startActivity(paramAnonymous3ParseException);
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
      });
      return;
      localParseQuery.setLimit(50);
      localParseQuery.orderByDescending(Configs.POSTS_LIKES);
      getSupportActionBar().a("Popular Posts");
    }
  }
  
  private class a
    extends AsyncTask<String, Void, Bitmap>
  {
    ImageView a;
    
    public a(ImageView paramImageView)
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
        Log.e(Search.this.getString(2131165204), "Error: " + paramVarArgs.getMessage());
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


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/northpolewonderland/santagram/Search.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */