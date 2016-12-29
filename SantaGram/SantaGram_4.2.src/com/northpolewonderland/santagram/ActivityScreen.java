package com.northpolewonderland.santagram;

import android.app.ProgressDialog;
import android.content.Context;
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
import com.parse.ParseUser;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ActivityScreen
  extends e
{
  List<ParseObject> activityArray;
  ParseUser currUser = ParseUser.getCurrentUser();
  ProgressDialog pd;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968602);
    super.setRequestedOrientation(1);
    getSupportActionBar().a(true);
    getSupportActionBar().b(true);
    getSupportActionBar().a("Activity");
    this.pd = new ProgressDialog(this);
    this.pd.setTitle(2131165208);
    this.pd.setIndeterminate(false);
    showActivity();
    new a((ImageView)findViewById(2131558508)).execute(new String[] { getString(2131165210) });
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
  
  void showActivity()
  {
    this.pd.setMessage("Loading Activities...");
    this.pd.show();
    ParseQuery localParseQuery = ParseQuery.getQuery(Configs.ACTIVITY_CLASS_NAME);
    localParseQuery.whereEqualTo(Configs.ACTIVITY_CURRENT_USER, this.currUser);
    localParseQuery.orderByDescending("createdAt");
    localParseQuery.findInBackground(new FindCallback()
    {
      public void done(List<ParseObject> paramAnonymousList, ParseException paramAnonymousParseException)
      {
        if (paramAnonymousParseException == null)
        {
          ActivityScreen.this.activityArray = paramAnonymousList;
          ActivityScreen.this.pd.dismiss();
          paramAnonymousList = (ListView)ActivityScreen.this.findViewById(2131558509);
          paramAnonymousList.setAdapter(new a(ActivityScreen.this, ActivityScreen.this.activityArray));
          paramAnonymousList.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public void onItemClick(AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
            {
              ((ParseObject)ActivityScreen.this.activityArray.get(paramAnonymous2Int)).getParseObject(Configs.ACTIVITY_OTHER_USER).fetchIfNeededInBackground(new GetCallback()
              {
                public void done(ParseObject paramAnonymous3ParseObject, ParseException paramAnonymous3ParseException) {}
              });
            }
          });
          return;
        }
        Toast.makeText(ActivityScreen.this.getApplicationContext(), paramAnonymousParseException.getMessage().toString(), 1).show();
        ActivityScreen.this.pd.dismiss();
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
          return ActivityScreen.this.activityArray.size();
        }
        
        public Object getItem(int paramInt)
        {
          return ActivityScreen.this.activityArray.get(paramInt);
        }
        
        public long getItemId(int paramInt)
        {
          return paramInt;
        }
        
        public View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
        {
          paramViewGroup = paramView;
          if (paramView == null) {
            paramViewGroup = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2130968601, null);
          }
          paramView = (ParseObject)ActivityScreen.this.activityArray.get(paramInt);
          paramView.getParseObject(Configs.ACTIVITY_OTHER_USER).fetchIfNeededInBackground(new GetCallback()
          {
            public void done(ParseObject paramAnonymousParseObject, final ParseException paramAnonymousParseException)
            {
              ((TextView)paramViewGroup.findViewById(2131558507)).setText(paramView.getString(Configs.ACTIVITY_TEXT));
              paramAnonymousParseException = (TextView)paramViewGroup.findViewById(2131558506);
              Date localDate = paramView.getCreatedAt();
              paramAnonymousParseException.setText(new SimpleDateFormat("MMM dd yyyy | hh:mm a").format(localDate));
              paramAnonymousParseException = (ImageView)paramViewGroup.findViewById(2131558505);
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
    });
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
        Log.e(ActivityScreen.this.getString(2131165204), "Error: " + paramVarArgs.getMessage());
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


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/northpolewonderland/santagram/ActivityScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */