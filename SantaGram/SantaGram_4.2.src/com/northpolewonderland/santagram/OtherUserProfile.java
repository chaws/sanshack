package com.northpolewonderland.santagram;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.a.a;
import android.support.v7.a.d;
import android.support.v7.a.d.a;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.parse.CountCallback;
import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.FunctionCallback;
import com.parse.GetDataCallback;
import com.parse.ParseCloud;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class OtherUserProfile
  extends e
{
  ParseUser currUser = ParseUser.getCurrentUser();
  List<ParseObject> followArray;
  Button followButt;
  List<ParseObject> followersArray;
  Button followersButt;
  List<ParseObject> followingArray;
  Button followingButt;
  ProgressDialog pd;
  List<ParseObject> postsArray;
  ParseObject userObj;
  
  void checkIfFollowingThisUser()
  {
    ParseQuery localParseQuery = ParseQuery.getQuery(Configs.FOLLOW_CLASS_NAME);
    localParseQuery.whereEqualTo(Configs.FOLLOW_A_USER, this.currUser);
    localParseQuery.whereEqualTo(Configs.FOLLOW_IS_FOLLOWING, this.userObj);
    localParseQuery.findInBackground(new FindCallback()
    {
      public void done(List<ParseObject> paramAnonymousList, ParseException paramAnonymousParseException)
      {
        if (paramAnonymousParseException == null)
        {
          OtherUserProfile.this.followArray = paramAnonymousList;
          if (OtherUserProfile.this.followArray.size() != 0)
          {
            OtherUserProfile.this.followButt.setText("unfollow");
            OtherUserProfile.this.followButt.setBackgroundResource(2130837603);
            return;
          }
          OtherUserProfile.this.followButt.setText("follow");
          OtherUserProfile.this.followButt.setBackgroundResource(2130837586);
          return;
        }
        Toast.makeText(OtherUserProfile.this.getApplicationContext(), paramAnonymousParseException.getMessage().toString(), 1).show();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968632);
    super.setRequestedOrientation(1);
    b.a(getApplicationContext(), getClass().getSimpleName());
    getSupportActionBar().a(true);
    getSupportActionBar().b(true);
    this.pd = new ProgressDialog(this);
    this.pd.setTitle(2131165208);
    this.pd.setIndeterminate(false);
    this.pd.setIcon(2130837592);
    this.followersButt = ((Button)findViewById(2131558566));
    this.followingButt = ((Button)findViewById(2131558591));
    this.followButt = ((Button)findViewById(2131558568));
    paramBundle = getIntent().getExtras().getString("objectID");
    this.userObj = ParseObject.createWithoutData(Configs.USER_CLASS_NAME, paramBundle);
    try
    {
      this.userObj.fetchIfNeeded().getParseObject(Configs.USER_CLASS_NAME);
      getSupportActionBar().a(this.userObj.getString(Configs.USER_FULLNAME).toString());
      showUserDetails();
      queryUserPosts();
      checkIfFollowingThisUser();
      queryFollowers();
      this.followButt.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new ParseObject(Configs.FOLLOW_CLASS_NAME);
          if (OtherUserProfile.this.followButt.getText().toString().matches("unfollow"))
          {
            OtherUserProfile.this.pd.setMessage("Unfollowing...");
            OtherUserProfile.this.pd.show();
            ((ParseObject)OtherUserProfile.this.followArray.get(0)).deleteInBackground(new DeleteCallback()
            {
              public void done(ParseException paramAnonymous2ParseException)
              {
                if (paramAnonymous2ParseException == null)
                {
                  OtherUserProfile.this.followButt.setText("follow");
                  OtherUserProfile.this.followButt.setBackgroundResource(2130837586);
                  OtherUserProfile.this.pd.dismiss();
                  return;
                }
                Toast.makeText(OtherUserProfile.this.getApplicationContext(), paramAnonymous2ParseException.getMessage().toString(), 1).show();
                OtherUserProfile.this.pd.dismiss();
              }
            });
            return;
          }
          OtherUserProfile.this.pd.setMessage("Following...");
          OtherUserProfile.this.pd.show();
          paramAnonymousView.put(Configs.FOLLOW_A_USER, OtherUserProfile.this.currUser);
          paramAnonymousView.put(Configs.FOLLOW_IS_FOLLOWING, OtherUserProfile.this.userObj);
          paramAnonymousView.saveInBackground(new SaveCallback()
          {
            public void done(ParseException paramAnonymous2ParseException)
            {
              if (paramAnonymous2ParseException == null)
              {
                OtherUserProfile.this.pd.dismiss();
                OtherUserProfile.this.followButt.setText("unfollow");
                OtherUserProfile.this.followButt.setBackgroundResource(2130837603);
                paramAnonymous2ParseException = OtherUserProfile.this.currUser.getString(Configs.USER_FULLNAME).toString() + " started following you";
                ParseObject localParseObject = new ParseObject(Configs.ACTIVITY_CLASS_NAME);
                localParseObject.put(Configs.ACTIVITY_CURRENT_USER, OtherUserProfile.this.userObj);
                localParseObject.put(Configs.ACTIVITY_OTHER_USER, OtherUserProfile.this.currUser);
                localParseObject.put(Configs.ACTIVITY_TEXT, paramAnonymous2ParseException);
                localParseObject.saveInBackground();
                return;
              }
              Toast.makeText(OtherUserProfile.this.getApplicationContext(), paramAnonymous2ParseException.getMessage().toString(), 0).show();
              OtherUserProfile.this.pd.dismiss();
            }
          });
        }
      });
      this.followersButt.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new Intent(OtherUserProfile.this, Follow.class);
          Bundle localBundle = new Bundle();
          localBundle.putString("objectID", OtherUserProfile.this.userObj.getObjectId().toString());
          localBundle.putString("follow", "Followers");
          paramAnonymousView.putExtras(localBundle);
          OtherUserProfile.this.startActivity(paramAnonymousView);
        }
      });
      this.followingButt.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new Intent(OtherUserProfile.this, Follow.class);
          Bundle localBundle = new Bundle();
          localBundle.putString("objectID", OtherUserProfile.this.userObj.getObjectId().toString());
          localBundle.putString("follow", "Following");
          paramAnonymousView.putExtras(localBundle);
          OtherUserProfile.this.startActivity(paramAnonymousView);
        }
      });
      new a((ImageView)findViewById(2131558508)).execute(new String[] { getString(2131165210) });
      return;
    }
    catch (ParseException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623939, paramMenu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332: 
      finish();
      return true;
    }
    paramMenuItem = new d.a(this);
    final EditText localEditText = new EditText(this);
    localEditText.setHint("");
    paramMenuItem.b("Briefly explain us the reason why you're reporting this User").b(localEditText).a(2131165208).b(2130837592).b("Cancel", null).a("OK", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        OtherUserProfile.this.pd.setMessage("Reporting User...");
        OtherUserProfile.this.pd.show();
        paramAnonymousDialogInterface = new HashMap();
        paramAnonymousDialogInterface.put("userId", OtherUserProfile.this.userObj.getObjectId());
        paramAnonymousDialogInterface.put("reportMessage", localEditText.getText().toString());
        ParseCloud.callFunctionInBackground("reportUser", paramAnonymousDialogInterface, new FunctionCallback()
        {
          public void a(ParseUser paramAnonymous2ParseUser, ParseException paramAnonymous2ParseException)
          {
            if (paramAnonymous2ParseException == null)
            {
              OtherUserProfile.this.pd.dismiss();
              paramAnonymous2ParseUser = ParseQuery.getQuery(Configs.POSTS_CLASSE_NAME);
              paramAnonymous2ParseUser.whereEqualTo(Configs.POSTS_USER_POINTER, OtherUserProfile.this.userObj);
              paramAnonymous2ParseUser.findInBackground(new FindCallback()
              {
                public void done(List<ParseObject> paramAnonymous3List, ParseException paramAnonymous3ParseException)
                {
                  if (paramAnonymous3ParseException == null)
                  {
                    int i = 0;
                    while (i < paramAnonymous3List.size())
                    {
                      paramAnonymous3ParseException = (ParseObject)paramAnonymous3List.get(i);
                      paramAnonymous3ParseException.put(Configs.POSTS_REPORT_MESSAGE, "*Reported automatically after User reporting");
                      paramAnonymous3ParseException.saveInBackground();
                      i += 1;
                    }
                  }
                }
              });
              paramAnonymous2ParseUser = new d.a(OtherUserProfile.this);
              paramAnonymous2ParseUser.b("Thanks for reporting " + OtherUserProfile.this.userObj.getString(Configs.USER_FULLNAME) + ". We'll check it out within 24h.").a(2131165208).a("OK", new DialogInterface.OnClickListener()
              {
                public void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  OtherUserProfile.this.finish();
                }
              }).b(2130837592);
              paramAnonymous2ParseUser.b().show();
              return;
            }
            Toast.makeText(OtherUserProfile.this.getApplicationContext(), paramAnonymous2ParseException.getMessage(), 1).show();
            OtherUserProfile.this.pd.dismiss();
          }
        });
      }
    });
    paramMenuItem.b().show();
    return true;
  }
  
  void queryFollowers()
  {
    ParseQuery localParseQuery = ParseQuery.getQuery(Configs.FOLLOW_CLASS_NAME);
    localParseQuery.whereEqualTo(Configs.FOLLOW_IS_FOLLOWING, this.userObj);
    localParseQuery.countInBackground(new CountCallback()
    {
      public void done(int paramAnonymousInt, ParseException paramAnonymousParseException)
      {
        if (paramAnonymousParseException == null)
        {
          OtherUserProfile.this.followersButt.setText(paramAnonymousInt + "\nfollowers");
          OtherUserProfile.this.queryFollowing();
        }
      }
    });
  }
  
  void queryFollowing()
  {
    ParseQuery localParseQuery = ParseQuery.getQuery(Configs.FOLLOW_CLASS_NAME);
    localParseQuery.whereEqualTo(Configs.FOLLOW_A_USER, this.userObj);
    localParseQuery.countInBackground(new CountCallback()
    {
      public void done(int paramAnonymousInt, ParseException paramAnonymousParseException)
      {
        if (paramAnonymousParseException == null) {
          OtherUserProfile.this.followingButt.setText(paramAnonymousInt + "\nfollowing");
        }
      }
    });
  }
  
  void queryUserPosts()
  {
    this.pd.setMessage("Loading Posts...");
    this.pd.show();
    ParseQuery localParseQuery = ParseQuery.getQuery(Configs.POSTS_CLASSE_NAME);
    localParseQuery.whereEqualTo(Configs.POSTS_USER_POINTER, this.userObj);
    localParseQuery.whereEqualTo(Configs.POSTS_IS_REPORTED, Boolean.valueOf(false));
    localParseQuery.orderByDescending(Configs.POSTS_CREATED_AT);
    localParseQuery.findInBackground(new FindCallback()
    {
      public void done(List<ParseObject> paramAnonymousList, ParseException paramAnonymousParseException)
      {
        if (paramAnonymousParseException == null)
        {
          OtherUserProfile.this.postsArray = paramAnonymousList;
          OtherUserProfile.this.pd.dismiss();
          paramAnonymousList = (ListView)OtherUserProfile.this.findViewById(2131558593);
          paramAnonymousList.setAdapter(new a(OtherUserProfile.this, OtherUserProfile.this.postsArray));
          paramAnonymousList.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public void onItemClick(AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
            {
              paramAnonymous2AdapterView = (ParseObject)OtherUserProfile.this.postsArray.get(paramAnonymous2Int);
              paramAnonymous2View = new Intent(OtherUserProfile.this, PostDetails.class);
              paramAnonymous2View.putExtra("objectID", paramAnonymous2AdapterView.getObjectId().toString());
              OtherUserProfile.this.startActivity(paramAnonymous2View);
            }
          });
          return;
        }
        Toast.makeText(OtherUserProfile.this.getApplicationContext(), paramAnonymousParseException.getMessage().toString(), 1).show();
        OtherUserProfile.this.pd.dismiss();
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
          return OtherUserProfile.this.postsArray.size();
        }
        
        public Object getItem(int paramInt)
        {
          return OtherUserProfile.this.postsArray.get(paramInt);
        }
        
        public long getItemId(int paramInt)
        {
          return paramInt;
        }
        
        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
        {
          paramViewGroup = paramView;
          if (paramView == null) {
            paramViewGroup = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2130968633, null);
          }
          paramView = (ParseObject)OtherUserProfile.this.postsArray.get(paramInt);
          ((TextView)paramViewGroup.findViewById(2131558595)).setVisibility(4);
          ((ImageView)paramViewGroup.findViewById(2131558596)).setVisibility(4);
          final Object localObject = (TextView)paramViewGroup.findViewById(2131558602);
          if (paramView.getString(Configs.POSTS_CITY) != null)
          {
            ((TextView)localObject).setText(paramView.getString(Configs.POSTS_CITY));
            ((TextView)paramViewGroup.findViewById(2131558603)).setText(paramView.getString(Configs.POSTS_TEXT));
            localObject = (TextView)paramViewGroup.findViewById(2131558605);
            if (paramView.getNumber(Configs.POSTS_LIKES) == null) {
              break label248;
            }
            ((TextView)localObject).setText(String.valueOf(paramView.getNumber(Configs.POSTS_LIKES)));
          }
          for (;;)
          {
            localObject = (ImageView)paramViewGroup.findViewById(2131558599);
            paramView = (ParseFile)paramView.get(Configs.POSTS_IMAGE);
            if (paramView != null) {
              paramView.getDataInBackground(new GetDataCallback()
              {
                public void done(byte[] paramAnonymousArrayOfByte, ParseException paramAnonymousParseException)
                {
                  if (paramAnonymousParseException == null)
                  {
                    paramAnonymousArrayOfByte = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
                    if (paramAnonymousArrayOfByte != null) {
                      localObject.setImageBitmap(paramAnonymousArrayOfByte);
                    }
                  }
                }
              });
            }
            paramView = (RelativeLayout)paramViewGroup.findViewById(2131558600);
            paramInt = new Random().nextInt(Configs.colorsArray.length);
            paramView.setBackgroundColor(Color.parseColor(Configs.colorsArray[paramInt]));
            return paramViewGroup;
            ((TextView)localObject).setText("N/A");
            break;
            label248:
            ((TextView)localObject).setText("0");
          }
        }
      }
    });
  }
  
  void showUserDetails()
  {
    final Object localObject = (ImageView)findViewById(2131558588);
    ParseFile localParseFile = (ParseFile)this.userObj.get(Configs.USER_COVER_IMAGE);
    if (localParseFile != null) {
      localParseFile.getDataInBackground(new GetDataCallback()
      {
        public void done(byte[] paramAnonymousArrayOfByte, ParseException paramAnonymousParseException)
        {
          if (paramAnonymousParseException == null)
          {
            paramAnonymousArrayOfByte = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
            if (paramAnonymousArrayOfByte != null) {
              localObject.setImageBitmap(paramAnonymousArrayOfByte);
            }
          }
        }
      });
    }
    localObject = (ImageView)findViewById(2131558589);
    localParseFile = (ParseFile)this.userObj.get(Configs.USER_AVATAR);
    if (localParseFile != null) {
      localParseFile.getDataInBackground(new GetDataCallback()
      {
        public void done(byte[] paramAnonymousArrayOfByte, ParseException paramAnonymousParseException)
        {
          if (paramAnonymousParseException == null)
          {
            paramAnonymousArrayOfByte = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
            if (paramAnonymousArrayOfByte != null) {
              localObject.setImageBitmap(paramAnonymousArrayOfByte);
            }
          }
        }
      });
    }
    ((TextView)findViewById(2131558590)).setText(this.userObj.getString(Configs.USER_FULLNAME));
    localObject = (TextView)findViewById(2131558592);
    if (this.userObj.getString(Configs.USER_ABOUT_ME) != null)
    {
      ((TextView)localObject).setText(this.userObj.getString(Configs.USER_ABOUT_ME));
      return;
    }
    ((TextView)localObject).setText("N/A");
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
        Bitmap localBitmap = BitmapFactory.decodeStream(new URL(paramVarArgs).openStream());
        return localBitmap;
      }
      catch (Exception localException)
      {
        Log.e(OtherUserProfile.this.getString(2131165204), "Error downloading image from " + paramVarArgs + " -- " + localException.getMessage());
        localException.printStackTrace();
      }
      return null;
    }
    
    protected void a(Bitmap paramBitmap)
    {
      this.a.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/northpolewonderland/santagram/OtherUserProfile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */