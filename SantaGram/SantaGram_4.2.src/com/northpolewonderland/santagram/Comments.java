package com.northpolewonderland.santagram;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.a.a;
import android.support.v7.a.d;
import android.support.v7.a.d.a;
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
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
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
import com.parse.ParseUser;
import com.parse.SaveCallback;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Comments
  extends e
{
  EditText commentTxt;
  List<ParseObject> commentsArray;
  ParseUser currUser = ParseUser.getCurrentUser();
  ProgressDialog pd;
  ParseObject postObj;
  
  public void dismisskeyboard()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.commentTxt.getWindowToken(), 0);
    this.commentTxt.setText("");
    this.commentTxt.clearFocus();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968605);
    super.setRequestedOrientation(1);
    b.a(getApplicationContext(), getClass().getSimpleName());
    getSupportActionBar().a("Comments");
    getSupportActionBar().a(true);
    getSupportActionBar().b(true);
    paramBundle = getIntent().getStringExtra("objectID");
    this.postObj = ParseObject.createWithoutData(Configs.POSTS_CLASSE_NAME, paramBundle);
    try
    {
      this.postObj.fetchIfNeeded().getParseObject(Configs.POSTS_CLASSE_NAME);
      this.pd = new ProgressDialog(this);
      this.pd.setTitle(2131165208);
      this.pd.setIndeterminate(false);
      this.commentTxt = ((EditText)findViewById(2131558524));
      this.commentTxt.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if (paramAnonymousInt == 4)
          {
            Comments.this.pd.setMessage("Sending comment...");
            Comments.this.pd.show();
            paramAnonymousTextView = new ParseObject(Configs.COMMENTS_CLASS_NAME);
            paramAnonymousTextView.put(Configs.COMMENTS_COMMENT, Comments.this.commentTxt.getText().toString());
            paramAnonymousTextView.put(Configs.COMMENTS_POST_POINTER, Comments.this.postObj);
            paramAnonymousTextView.put(Configs.COMMENTS_USER_POINTER, Comments.this.currUser);
            paramAnonymousTextView.saveInBackground(new SaveCallback()
            {
              public void done(ParseException paramAnonymous2ParseException)
              {
                if (paramAnonymous2ParseException == null)
                {
                  Comments.this.pd.dismiss();
                  Comments.this.dismisskeyboard();
                  paramAnonymous2ParseException = new d.a(Comments.this);
                  paramAnonymous2ParseException.b("Your comment has been sent!").a(2131165208).b(2130837592).a("OK", new DialogInterface.OnClickListener()
                  {
                    public void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      Comments.this.queryComments();
                    }
                  });
                  paramAnonymous2ParseException.b().show();
                  Comments.this.postObj.getParseObject(Configs.POSTS_USER_POINTER).fetchIfNeededInBackground(new GetCallback()
                  {
                    public void done(ParseObject paramAnonymous3ParseObject, ParseException paramAnonymous3ParseException)
                    {
                      paramAnonymous3ParseException = Comments.this.currUser.getString(Configs.USER_FULLNAME).toString() + " commented on your post: " + Comments.this.postObj.getString(Configs.POSTS_TEXT);
                      ParseObject localParseObject = new ParseObject(Configs.ACTIVITY_CLASS_NAME);
                      localParseObject.put(Configs.ACTIVITY_CURRENT_USER, paramAnonymous3ParseObject);
                      localParseObject.put(Configs.ACTIVITY_OTHER_USER, Comments.this.currUser);
                      localParseObject.put(Configs.ACTIVITY_TEXT, paramAnonymous3ParseException);
                      localParseObject.saveInBackground();
                    }
                  });
                  return;
                }
                Toast.makeText(Comments.this.getApplicationContext(), paramAnonymous2ParseException.getMessage().toString(), 0).show();
                Comments.this.pd.dismiss();
              }
            });
            return true;
          }
          return false;
        }
      });
      queryComments();
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
    getMenuInflater().inflate(2131623936, paramMenu);
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
    queryComments();
    return true;
  }
  
  void queryComments()
  {
    this.pd.setMessage("Loading comments...");
    this.pd.show();
    ParseQuery localParseQuery = ParseQuery.getQuery(Configs.COMMENTS_CLASS_NAME);
    localParseQuery.whereEqualTo(Configs.COMMENTS_POST_POINTER, this.postObj);
    localParseQuery.orderByDescending(Configs.COMMENTS_CREATED_AT);
    localParseQuery.findInBackground(new FindCallback()
    {
      public void done(List<ParseObject> paramAnonymousList, ParseException paramAnonymousParseException)
      {
        if (paramAnonymousParseException == null)
        {
          Comments.this.commentsArray = paramAnonymousList;
          Comments.this.pd.dismiss();
          ((ListView)Comments.this.findViewById(2131558523)).setAdapter(new a(Comments.this, Comments.this.commentsArray));
          return;
        }
        Toast.makeText(Comments.this.getApplicationContext(), paramAnonymousParseException.getMessage().toString(), 1).show();
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
          return Comments.this.commentsArray.size();
        }
        
        public Object getItem(int paramInt)
        {
          return Comments.this.commentsArray.get(paramInt);
        }
        
        public long getItemId(int paramInt)
        {
          return paramInt;
        }
        
        public View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
        {
          paramViewGroup = paramView;
          if (paramView == null) {
            paramViewGroup = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2130968604, null);
          }
          paramView = (ParseObject)Comments.this.commentsArray.get(paramInt);
          paramView.getParseObject(Configs.COMMENTS_USER_POINTER).fetchIfNeededInBackground(new GetCallback()
          {
            public void done(ParseObject paramAnonymousParseObject, final ParseException paramAnonymousParseException)
            {
              ((TextView)paramViewGroup.findViewById(2131558520)).setText(paramAnonymousParseObject.getString(Configs.USER_FULLNAME));
              ((TextView)paramViewGroup.findViewById(2131558521)).setText(paramView.getString(Configs.COMMENTS_COMMENT));
              paramAnonymousParseException = (TextView)paramViewGroup.findViewById(2131558522);
              Date localDate = paramView.getCreatedAt();
              paramAnonymousParseException.setText(new SimpleDateFormat("MMM dd yyyy | hh:mm a").format(localDate));
              paramAnonymousParseException = (ImageView)paramViewGroup.findViewById(2131558519);
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
                  Comments.2.a.1.this.b.getParseObject(Configs.COMMENTS_USER_POINTER).fetchIfNeededInBackground(new GetCallback()
                  {
                    public void done(ParseObject paramAnonymous3ParseObject, ParseException paramAnonymous3ParseException)
                    {
                      Toast.makeText(Comments.this, paramAnonymous3ParseObject.getString(Configs.USER_FULLNAME), 0).show();
                    }
                  });
                }
              });
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
        Log.e(Comments.this.getString(2131165204), "Error: " + paramVarArgs.getMessage());
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


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/northpolewonderland/santagram/Comments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */