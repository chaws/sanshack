package com.northpolewonderland.santagram;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.a.a;
import android.support.v7.a.d;
import android.support.v7.a.d.a;
import android.support.v7.a.e;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.parse.CountCallback;
import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Me
  extends e
{
  ProgressDialog a;
  ImageView b;
  ImageView c;
  Button d;
  Button e;
  Button f;
  Button g;
  TextView h;
  TextView i;
  RadioButton j;
  RadioButton k;
  ParseUser l = ParseUser.getCurrentUser();
  List<ParseObject> m;
  List<ParseObject> n;
  
  void a()
  {
    ParseFile localParseFile = (ParseFile)this.l.get(Configs.USER_COVER_IMAGE);
    if (localParseFile != null) {
      localParseFile.getDataInBackground(new GetDataCallback()
      {
        public void done(byte[] paramAnonymousArrayOfByte, ParseException paramAnonymousParseException)
        {
          if (paramAnonymousParseException == null)
          {
            paramAnonymousArrayOfByte = b.a(paramAnonymousArrayOfByte, Me.this.getApplicationContext(), 400, 100);
            if (paramAnonymousArrayOfByte != null) {
              Me.this.b.setImageBitmap(paramAnonymousArrayOfByte);
            }
          }
        }
      });
    }
    localParseFile = (ParseFile)this.l.get(Configs.USER_AVATAR);
    if (localParseFile != null) {
      localParseFile.getDataInBackground(new GetDataCallback()
      {
        public void done(byte[] paramAnonymousArrayOfByte, ParseException paramAnonymousParseException)
        {
          if (paramAnonymousParseException == null)
          {
            paramAnonymousArrayOfByte = b.a(paramAnonymousArrayOfByte, Me.this.getApplicationContext(), 60, 60);
            if (paramAnonymousArrayOfByte != null) {
              Me.this.c.setImageBitmap(paramAnonymousArrayOfByte);
            }
          }
        }
      });
    }
    this.h.setText(this.l.getString(Configs.USER_FULLNAME));
    if (this.l.getString(Configs.USER_ABOUT_ME) != null)
    {
      this.i.setText(this.l.getString(Configs.USER_ABOUT_ME));
      return;
    }
    this.i.setText("N/A");
  }
  
  void b()
  {
    this.n = new ArrayList();
    this.m = new ArrayList();
    this.a.setMessage("Loading my Posts...");
    this.a.show();
    ParseQuery localParseQuery = ParseQuery.getQuery(Configs.POSTS_CLASSE_NAME);
    localParseQuery.whereEqualTo(Configs.POSTS_USER_POINTER, this.l);
    localParseQuery.orderByDescending(Configs.POSTS_CREATED_AT);
    localParseQuery.findInBackground(new FindCallback()
    {
      public void done(List<ParseObject> paramAnonymousList, ParseException paramAnonymousParseException)
      {
        if (paramAnonymousParseException == null)
        {
          Me.this.m = paramAnonymousList;
          Me.this.a.dismiss();
          paramAnonymousList = (ListView)Me.this.findViewById(2131558574);
          paramAnonymousList.setAdapter(new a(Me.this, Me.this.m));
          paramAnonymousList.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public void onItemClick(AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
            {
              paramAnonymous2AdapterView = (ParseObject)Me.this.m.get(paramAnonymous2Int);
              paramAnonymous2View = new Intent(Me.this, PostDetails.class);
              paramAnonymous2View.putExtra("objectID", paramAnonymous2AdapterView.getObjectId().toString());
              Me.this.startActivity(paramAnonymous2View);
            }
          });
          paramAnonymousList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
          {
            public boolean onItemLongClick(final AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
            {
              paramAnonymous2AdapterView = (ParseObject)Me.this.m.get(paramAnonymous2Int);
              Me.this.n = new ArrayList();
              paramAnonymous2View = new d.a(Me.this);
              paramAnonymous2View.b("Are you sure you want to delete this post?").a(2131165208).b("Cancel", null).b(2130837592).a("Delete post", new DialogInterface.OnClickListener()
              {
                public void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  Me.this.a.setMessage("Deleting post...");
                  Me.this.a.show();
                  paramAnonymous3DialogInterface = ParseQuery.getQuery(Configs.LIKES_CLASS_NAME);
                  paramAnonymous3DialogInterface.whereEqualTo(Configs.LIKES_POST_LIKED, paramAnonymous2AdapterView);
                  paramAnonymous3DialogInterface.findInBackground(new FindCallback()
                  {
                    public void done(List<ParseObject> paramAnonymous4List, ParseException paramAnonymous4ParseException)
                    {
                      if (paramAnonymous4ParseException == null)
                      {
                        Me.this.n = paramAnonymous4List;
                        int i = 0;
                        while (i < Me.this.n.size())
                        {
                          ((ParseObject)Me.this.n.get(i)).deleteInBackground();
                          i += 1;
                        }
                        Me.3.2.1.this.a.deleteInBackground(new DeleteCallback()
                        {
                          public void done(ParseException paramAnonymous5ParseException)
                          {
                            if (paramAnonymous5ParseException == null)
                            {
                              Me.this.a.dismiss();
                              paramAnonymous5ParseException = new d.a(Me.this);
                              paramAnonymous5ParseException.b("You've removed this post!").a(2131165208).a("OK", new DialogInterface.OnClickListener()
                              {
                                public void onClick(DialogInterface paramAnonymous6DialogInterface, int paramAnonymous6Int)
                                {
                                  Me.this.b();
                                }
                              }).b(2130837592);
                              paramAnonymous5ParseException.b().show();
                              return;
                            }
                            Toast.makeText(Me.this.getApplicationContext(), paramAnonymous5ParseException.getMessage().toString(), 1).show();
                            Me.this.a.dismiss();
                          }
                        });
                        return;
                      }
                      Toast.makeText(Me.this.getApplicationContext(), paramAnonymous4ParseException.getMessage().toString(), 1).show();
                      Me.this.a.dismiss();
                    }
                  });
                }
              });
              paramAnonymous2View.b().show();
              return true;
            }
          });
          return;
        }
        Toast.makeText(Me.this.getApplicationContext(), paramAnonymousParseException.getMessage().toString(), 1).show();
        Me.this.a.dismiss();
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
          return Me.this.m.size();
        }
        
        public Object getItem(int paramInt)
        {
          return Me.this.m.get(paramInt);
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
          paramView = (ParseObject)Me.this.m.get(paramInt);
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
                    paramAnonymousParseException = new BitmapFactory.Options();
                    paramAnonymousParseException.inSampleSize = 8;
                    paramAnonymousParseException.inDither = false;
                    paramAnonymousParseException.inPurgeable = true;
                    paramAnonymousParseException.inInputShareable = true;
                    paramAnonymousArrayOfByte = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length, paramAnonymousParseException);
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
  
  void c()
  {
    this.n = new ArrayList();
    this.m = new ArrayList();
    this.a.setMessage("Loading Posts I've liked...");
    this.a.show();
    ParseQuery localParseQuery = ParseQuery.getQuery(Configs.LIKES_CLASS_NAME);
    localParseQuery.whereEqualTo(Configs.LIKES_LIKED_BY, this.l);
    localParseQuery.orderByDescending(Configs.LIKES_CREATED_AT);
    localParseQuery.findInBackground(new FindCallback()
    {
      public void done(List<ParseObject> paramAnonymousList, ParseException paramAnonymousParseException)
      {
        if (paramAnonymousParseException == null)
        {
          Me.this.n = paramAnonymousList;
          Me.this.a.dismiss();
          paramAnonymousList = (ListView)Me.this.findViewById(2131558574);
          paramAnonymousList.setAdapter(new a(Me.this, Me.this.n));
          paramAnonymousList.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public void onItemClick(AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
            {
              ((ParseObject)Me.this.n.get(paramAnonymous2Int)).getParseObject(Configs.LIKES_POST_LIKED).fetchIfNeededInBackground(new GetCallback()
              {
                public void done(ParseObject paramAnonymous3ParseObject, ParseException paramAnonymous3ParseException)
                {
                  if (!paramAnonymous3ParseObject.getBoolean(Configs.POSTS_IS_REPORTED))
                  {
                    paramAnonymous3ParseException = new Intent(Me.this, PostDetails.class);
                    paramAnonymous3ParseException.putExtra("objectID", paramAnonymous3ParseObject.getObjectId().toString());
                    Me.this.startActivity(paramAnonymous3ParseException);
                    return;
                  }
                  paramAnonymous3ParseObject = new d.a(Me.this);
                  paramAnonymous3ParseObject.b("This post has been reported, you can't access it!").a(2131165208).a("OK", null).b(2130837592);
                  paramAnonymous3ParseObject.b().show();
                }
              });
            }
          });
          return;
        }
        Toast.makeText(Me.this.getApplicationContext(), paramAnonymousParseException.getMessage().toString(), 1).show();
        Me.this.a.dismiss();
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
          return Me.this.n.size();
        }
        
        public Object getItem(int paramInt)
        {
          return Me.this.n.get(paramInt);
        }
        
        public long getItemId(int paramInt)
        {
          return paramInt;
        }
        
        public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
        {
          paramViewGroup = paramView;
          if (paramView == null) {
            paramViewGroup = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2130968633, null);
          }
          ((ParseObject)Me.this.n.get(paramInt)).getParseObject(Configs.LIKES_POST_LIKED).fetchIfNeededInBackground(new GetCallback()
          {
            public void done(final ParseObject paramAnonymousParseObject, ParseException paramAnonymousParseException)
            {
              paramAnonymousParseObject.getParseObject(Configs.POSTS_USER_POINTER).fetchIfNeededInBackground(new GetCallback()
              {
                public void done(final ParseObject paramAnonymous2ParseObject, final ParseException paramAnonymous2ParseException)
                {
                  if (!paramAnonymousParseObject.getBoolean(Configs.POSTS_IS_REPORTED))
                  {
                    ((TextView)Me.4.a.1.this.a.findViewById(2131558595)).setText(paramAnonymous2ParseObject.getString(Configs.USER_FULLNAME));
                    paramAnonymous2ParseException = (ImageView)Me.4.a.1.this.a.findViewById(2131558596);
                    paramAnonymous2ParseException.setImageResource(2130837592);
                    paramAnonymous2ParseObject = (ParseFile)paramAnonymous2ParseObject.get(Configs.USER_AVATAR);
                    if (paramAnonymous2ParseObject != null) {
                      paramAnonymous2ParseObject.getDataInBackground(new GetDataCallback()
                      {
                        public void done(byte[] paramAnonymous3ArrayOfByte, ParseException paramAnonymous3ParseException)
                        {
                          if (paramAnonymous3ParseException == null)
                          {
                            paramAnonymous3ArrayOfByte = BitmapFactory.decodeByteArray(paramAnonymous3ArrayOfByte, 0, paramAnonymous3ArrayOfByte.length);
                            if (paramAnonymous3ArrayOfByte != null) {
                              paramAnonymous2ParseException.setImageBitmap(paramAnonymous3ArrayOfByte);
                            }
                          }
                        }
                      });
                    }
                    paramAnonymous2ParseException.setOnClickListener(new View.OnClickListener()
                    {
                      public void onClick(View paramAnonymous3View)
                      {
                        Me.4.a.1.1.this.a.getParseObject(Configs.POSTS_USER_POINTER).fetchIfNeededInBackground(new GetCallback()
                        {
                          public void done(ParseObject paramAnonymous4ParseObject, ParseException paramAnonymous4ParseException)
                          {
                            paramAnonymous4ParseException = new Intent(Me.this, OtherUserProfile.class);
                            paramAnonymous4ParseException.putExtra("objectID", paramAnonymous4ParseObject.getObjectId().toString());
                            Me.this.startActivity(paramAnonymous4ParseException);
                          }
                        });
                      }
                    });
                    paramAnonymous2ParseObject = (TextView)Me.4.a.1.this.a.findViewById(2131558602);
                    if (paramAnonymousParseObject.getString(Configs.POSTS_CITY) != null)
                    {
                      paramAnonymous2ParseObject.setText(paramAnonymousParseObject.getString(Configs.POSTS_CITY));
                      ((TextView)Me.4.a.1.this.a.findViewById(2131558603)).setText(paramAnonymousParseObject.getString(Configs.POSTS_TEXT));
                      paramAnonymous2ParseObject = (TextView)Me.4.a.1.this.a.findViewById(2131558605);
                      if (paramAnonymousParseObject.getNumber(Configs.POSTS_LIKES) == null) {
                        break label317;
                      }
                      paramAnonymous2ParseObject.setText(String.valueOf(paramAnonymousParseObject.getNumber(Configs.POSTS_LIKES)));
                    }
                    for (;;)
                    {
                      paramAnonymous2ParseObject = (ImageView)Me.4.a.1.this.a.findViewById(2131558599);
                      paramAnonymous2ParseException = (ParseFile)paramAnonymousParseObject.get(Configs.POSTS_IMAGE);
                      if (paramAnonymous2ParseException != null) {
                        paramAnonymous2ParseException.getDataInBackground(new GetDataCallback()
                        {
                          public void done(byte[] paramAnonymous3ArrayOfByte, ParseException paramAnonymous3ParseException)
                          {
                            if (paramAnonymous3ParseException == null)
                            {
                              paramAnonymous3ArrayOfByte = BitmapFactory.decodeByteArray(paramAnonymous3ArrayOfByte, 0, paramAnonymous3ArrayOfByte.length);
                              if (paramAnonymous3ArrayOfByte != null) {
                                paramAnonymous2ParseObject.setImageBitmap(paramAnonymous3ArrayOfByte);
                              }
                            }
                          }
                        });
                      }
                      paramAnonymous2ParseObject = (RelativeLayout)Me.4.a.1.this.a.findViewById(2131558600);
                      int i = new Random().nextInt(Configs.colorsArray.length);
                      paramAnonymous2ParseObject.setBackgroundColor(Color.parseColor(Configs.colorsArray[i]));
                      return;
                      paramAnonymous2ParseObject.setText("N/A");
                      break;
                      label317:
                      paramAnonymous2ParseObject.setText("0");
                    }
                  }
                  ((TextView)Me.4.a.1.this.a.findViewById(2131558595)).setText("THIS POST IS REPORTED!");
                  ((ImageView)Me.4.a.1.this.a.findViewById(2131558599)).setImageResource(2130837592);
                  ((TextView)Me.4.a.1.this.a.findViewById(2131558605)).setText("");
                  ((TextView)Me.4.a.1.this.a.findViewById(2131558602)).setText("");
                  ((TextView)Me.4.a.1.this.a.findViewById(2131558603)).setText("");
                  ((ImageView)Me.4.a.1.this.a.findViewById(2131558596)).setImageResource(2130837592);
                }
              });
            }
          });
          return paramViewGroup;
        }
      }
    });
  }
  
  void d()
  {
    ParseQuery localParseQuery = ParseQuery.getQuery(Configs.FOLLOW_CLASS_NAME);
    localParseQuery.whereEqualTo(Configs.FOLLOW_IS_FOLLOWING, this.l);
    localParseQuery.countInBackground(new CountCallback()
    {
      public void done(int paramAnonymousInt, ParseException paramAnonymousParseException)
      {
        if (paramAnonymousParseException == null)
        {
          Me.this.f.setText(paramAnonymousInt + "\nfollowers");
          Me.this.e();
        }
      }
    });
  }
  
  void e()
  {
    ParseQuery localParseQuery = ParseQuery.getQuery(Configs.FOLLOW_CLASS_NAME);
    localParseQuery.whereEqualTo(Configs.FOLLOW_A_USER, this.l);
    localParseQuery.countInBackground(new CountCallback()
    {
      public void done(int paramAnonymousInt, ParseException paramAnonymousParseException)
      {
        if (paramAnonymousParseException == null) {
          Me.this.g.setText(paramAnonymousInt + "\nfollowing");
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968623);
    super.setRequestedOrientation(1);
    b.a(getApplicationContext(), getClass().getSimpleName());
    getSupportActionBar().a("Me");
    this.b = ((ImageView)findViewById(2131558563));
    this.c = ((ImageView)findViewById(2131558564));
    this.d = ((Button)findViewById(2131558567));
    this.e = ((Button)findViewById(2131558568));
    this.f = ((Button)findViewById(2131558566));
    this.g = ((Button)findViewById(2131558569));
    this.h = ((TextView)findViewById(2131558565));
    this.i = ((TextView)findViewById(2131558570));
    this.j = ((RadioButton)findViewById(2131558572));
    this.k = ((RadioButton)findViewById(2131558573));
    this.a = new ProgressDialog(this);
    this.a.setTitle(2131165208);
    this.a.setIndeterminate(false);
    paramBundle = (Button)findViewById(2131558550);
    Button localButton = (Button)findViewById(2131558551);
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Me.this.startActivity(new Intent(Me.this, Home.class));
      }
    });
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Me.this.startActivity(new Intent(Me.this, Search.class));
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Me.this.startActivity(new Intent(Me.this, ActivityScreen.class));
      }
    });
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Me.this.startActivity(new Intent(Me.this, EditProfile.class));
      }
    });
    this.f.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(Me.this, Follow.class);
        Bundle localBundle = new Bundle();
        localBundle.putString("follow", "Followers");
        localBundle.putString("objectID", Me.this.l.getObjectId().toString());
        paramAnonymousView.putExtras(localBundle);
        Me.this.startActivity(paramAnonymousView);
      }
    });
    this.g.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(Me.this, Follow.class);
        Bundle localBundle = new Bundle();
        localBundle.putString("follow", "Following");
        localBundle.putString("objectID", Me.this.l.getObjectId().toString());
        paramAnonymousView.putExtras(localBundle);
        Me.this.startActivity(paramAnonymousView);
      }
    });
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623938, paramMenu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    this.a.setMessage("Logging out...");
    this.a.show();
    ParseUser.logOutInBackground(new LogOutCallback()
    {
      public void done(ParseException paramAnonymousParseException)
      {
        Me.this.a.dismiss();
        Me.this.startActivity(new Intent(Me.this, Login.class));
      }
    });
    return true;
  }
  
  protected void onStart()
  {
    super.onStart();
    this.j.setChecked(true);
    this.j.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Me.this.k.setChecked(false);
        Me.this.b();
      }
    });
    this.k.setChecked(false);
    this.k.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Me.this.j.setChecked(false);
        Me.this.c();
      }
    });
    b();
    d();
    a();
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/northpolewonderland/santagram/Me.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */