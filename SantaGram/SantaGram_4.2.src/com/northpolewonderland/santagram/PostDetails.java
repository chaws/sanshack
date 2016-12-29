package com.northpolewonderland.santagram;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.support.v7.a.a;
import android.support.v7.a.d;
import android.support.v7.a.d.a;
import android.support.v7.a.e;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PostDetails
  extends e
{
  ParseUser currUser = ParseUser.getCurrentUser();
  List<ParseObject> followArray;
  Button followButt;
  Button likeButt;
  List<ParseObject> likesArray;
  ProgressDialog pd;
  ParseObject postObj;
  
  void fixMediaDir()
  {
    File localFile = Environment.getExternalStorageDirectory();
    if (localFile != null)
    {
      localFile = new File(localFile, "DCIM/Camera");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
  }
  
  public Uri getImageUri(Context paramContext, Bitmap paramBitmap)
  {
    fixMediaDir();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    return Uri.parse(MediaStore.Images.Media.insertImage(paramContext.getContentResolver(), paramBitmap, "image", null));
  }
  
  void hidePreviewLayout()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131558619);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(localLinearLayout.getLayoutParams());
    localMarginLayoutParams.setMargins(0, 2000, 0, 0);
    localLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(localMarginLayoutParams));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
    {
      public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
      {
        b.a(PostDetails.this.getApplication(), paramAnonymousThrowable);
        if (this.a != null)
        {
          this.a.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
          return;
        }
        System.exit(2);
      }
    });
    setContentView(2130968634);
    super.setRequestedOrientation(1);
    b.a(getApplicationContext(), getClass().getSimpleName());
    getSupportActionBar().a("Post Details");
    getSupportActionBar().a(true);
    getSupportActionBar().b(true);
    this.pd = new ProgressDialog(this);
    this.pd.setTitle(2131165208);
    this.pd.setIndeterminate(false);
    paramBundle = getIntent().getExtras().getString("objectID");
    this.postObj = ParseObject.createWithoutData(Configs.POSTS_CLASSE_NAME, paramBundle);
    try
    {
      this.postObj.fetchIfNeeded().getParseObject(Configs.POSTS_CLASSE_NAME);
      showPostDetails();
      queryFollow();
      queryLikeStatus();
      this.followButt = ((Button)findViewById(2131558610));
      this.likeButt = ((Button)findViewById(2131558614));
      this.followButt.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new ParseObject(Configs.FOLLOW_CLASS_NAME);
          final ParseUser localParseUser = PostDetails.this.postObj.getParseUser(Configs.POSTS_USER_POINTER);
          if (PostDetails.this.followButt.getText().toString().matches("unfollow"))
          {
            PostDetails.this.pd.setMessage("Unfollowing...");
            PostDetails.this.pd.show();
            ((ParseObject)PostDetails.this.followArray.get(0)).deleteInBackground(new DeleteCallback()
            {
              public void done(ParseException paramAnonymous2ParseException)
              {
                if (paramAnonymous2ParseException == null)
                {
                  PostDetails.this.followButt.setText("follow");
                  PostDetails.this.followButt.setBackgroundResource(2130837586);
                  PostDetails.this.pd.dismiss();
                  return;
                }
                Toast.makeText(PostDetails.this.getApplicationContext(), paramAnonymous2ParseException.getMessage().toString(), 1).show();
                PostDetails.this.pd.dismiss();
              }
            });
            return;
          }
          PostDetails.this.pd.setMessage("Following...");
          PostDetails.this.pd.show();
          paramAnonymousView.put(Configs.FOLLOW_A_USER, PostDetails.this.currUser);
          paramAnonymousView.put(Configs.FOLLOW_IS_FOLLOWING, localParseUser);
          paramAnonymousView.saveInBackground(new SaveCallback()
          {
            public void done(ParseException paramAnonymous2ParseException)
            {
              if (paramAnonymous2ParseException == null)
              {
                PostDetails.this.pd.dismiss();
                PostDetails.this.followButt.setText("unfollow");
                PostDetails.this.followButt.setBackgroundResource(2130837603);
                paramAnonymous2ParseException = PostDetails.this.currUser.getString(Configs.USER_FULLNAME).toString() + " started following you";
                ParseObject localParseObject = new ParseObject(Configs.ACTIVITY_CLASS_NAME);
                localParseObject.put(Configs.ACTIVITY_CURRENT_USER, localParseUser);
                localParseObject.put(Configs.ACTIVITY_OTHER_USER, PostDetails.this.currUser);
                localParseObject.put(Configs.ACTIVITY_TEXT, paramAnonymous2ParseException);
                localParseObject.saveInBackground();
                return;
              }
              Toast.makeText(PostDetails.this.getApplicationContext(), paramAnonymous2ParseException.getMessage().toString(), 0).show();
              PostDetails.this.pd.dismiss();
            }
          });
        }
      });
      this.likeButt.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          PostDetails.this.likesArray = new ArrayList();
          paramAnonymousView = ParseQuery.getQuery(Configs.LIKES_CLASS_NAME);
          paramAnonymousView.whereEqualTo(Configs.LIKES_LIKED_BY, PostDetails.this.currUser);
          paramAnonymousView.whereEqualTo(Configs.LIKES_POST_LIKED, PostDetails.this.postObj);
          paramAnonymousView.findInBackground(new FindCallback()
          {
            public void done(List<ParseObject> paramAnonymous2List, ParseException paramAnonymous2ParseException)
            {
              if (paramAnonymous2ParseException == null)
              {
                PostDetails.this.likesArray = paramAnonymous2List;
                paramAnonymous2List = new ParseObject(Configs.LIKES_CLASS_NAME);
                if (PostDetails.this.likesArray.size() == 0)
                {
                  PostDetails.this.pd.setMessage("Liking post...");
                  PostDetails.this.pd.show();
                  PostDetails.this.postObj.increment(Configs.POSTS_LIKES, Integer.valueOf(1));
                  PostDetails.this.postObj.saveInBackground();
                  ((TextView)PostDetails.this.findViewById(2131558615)).setText(String.valueOf(((Integer)PostDetails.this.postObj.getNumber(Configs.POSTS_LIKES)).intValue()));
                  paramAnonymous2List.put(Configs.LIKES_LIKED_BY, PostDetails.this.currUser);
                  paramAnonymous2List.put(Configs.LIKES_POST_LIKED, PostDetails.this.postObj);
                  paramAnonymous2List.saveInBackground(new SaveCallback()
                  {
                    public void done(ParseException paramAnonymous3ParseException)
                    {
                      if (paramAnonymous3ParseException == null)
                      {
                        PostDetails.this.pd.dismiss();
                        paramAnonymous3ParseException = new d.a(PostDetails.this);
                        paramAnonymous3ParseException.b("You've liked this post!").a(2131165208).a("OK", null).b(2130837592);
                        paramAnonymous3ParseException.b().show();
                        PostDetails.this.likeButt.setBackgroundResource(2130837588);
                        paramAnonymous3ParseException = PostDetails.this.postObj.getParseUser(Configs.POSTS_USER_POINTER);
                        String str = PostDetails.this.currUser.getString(Configs.USER_FULLNAME).toString() + " liked your post: " + PostDetails.this.postObj.getString(Configs.POSTS_TEXT);
                        ParseObject localParseObject = new ParseObject(Configs.ACTIVITY_CLASS_NAME);
                        localParseObject.put(Configs.ACTIVITY_CURRENT_USER, paramAnonymous3ParseException);
                        localParseObject.put(Configs.ACTIVITY_OTHER_USER, PostDetails.this.currUser);
                        localParseObject.put(Configs.ACTIVITY_TEXT, str);
                        localParseObject.saveInBackground();
                      }
                    }
                  });
                  return;
                }
                PostDetails.this.pd.setMessage("Unliking post...");
                PostDetails.this.pd.show();
                PostDetails.this.postObj.increment(Configs.POSTS_LIKES, Integer.valueOf(-1));
                PostDetails.this.postObj.saveInBackground();
                ((TextView)PostDetails.this.findViewById(2131558615)).setText(String.valueOf(((Integer)PostDetails.this.postObj.getNumber(Configs.POSTS_LIKES)).intValue()));
                ((ParseObject)PostDetails.this.likesArray.get(0)).deleteInBackground(new DeleteCallback()
                {
                  public void done(ParseException paramAnonymous3ParseException)
                  {
                    if (paramAnonymous3ParseException == null)
                    {
                      PostDetails.this.pd.dismiss();
                      paramAnonymous3ParseException = new d.a(PostDetails.this);
                      paramAnonymous3ParseException.b("You've unliked this post!").a(2131165208).a("OK", null).b(2130837592);
                      paramAnonymous3ParseException.b().show();
                      PostDetails.this.likeButt.setBackgroundResource(2130837604);
                      return;
                    }
                    Toast.makeText(PostDetails.this.getApplicationContext(), paramAnonymous3ParseException.getMessage().toString(), 1).show();
                    PostDetails.this.pd.dismiss();
                  }
                });
                return;
              }
              Toast.makeText(PostDetails.this.getApplicationContext(), paramAnonymous2ParseException.getMessage().toString(), 1).show();
            }
          });
        }
      });
      ((Button)findViewById(2131558617)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new Intent(PostDetails.this, Comments.class);
          paramAnonymousView.putExtra("objectID", PostDetails.this.postObj.getObjectId().toString());
          PostDetails.this.startActivity(paramAnonymousView);
        }
      });
      ((Button)findViewById(2131558618)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new d.a(PostDetails.this);
          final EditText localEditText = new EditText(PostDetails.this);
          localEditText.setHint("");
          paramAnonymousView.b("Briefly explain the reason why you are reporting this post").b(localEditText).a(2131165208).b(2130837592).b("Cancel", null).a("OK", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              String str = localEditText.getText().toString();
              paramAnonymous2DialogInterface = str;
              if (str.isEmpty()) {
                paramAnonymous2DialogInterface = null;
              }
              PostDetails.this.postObj.put(Configs.POSTS_REPORT_MESSAGE, paramAnonymous2DialogInterface.toLowerCase());
              PostDetails.this.postObj.saveInBackground(new SaveCallback()
              {
                public void done(ParseException paramAnonymous3ParseException)
                {
                  if (paramAnonymous3ParseException == null)
                  {
                    paramAnonymous3ParseException = new d.a(PostDetails.this);
                    paramAnonymous3ParseException.b("Thanks for reporting this post!\nWe'll check it out within 24 hours.").a(2131165208).b(2130837592).a("OK", new DialogInterface.OnClickListener()
                    {
                      public void onClick(DialogInterface paramAnonymous4DialogInterface, int paramAnonymous4Int)
                      {
                        PostDetails.this.finish();
                      }
                    });
                    paramAnonymous3ParseException.b().show();
                  }
                }
              });
            }
          });
          paramAnonymousView.b().show();
        }
      });
      ((Button)findViewById(2131558616)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = ((BitmapDrawable)((ImageView)PostDetails.this.findViewById(2131558611)).getDrawable()).getBitmap();
          paramAnonymousView = PostDetails.this.getImageUri(PostDetails.this, paramAnonymousView);
          Intent localIntent = new Intent("android.intent.action.SEND");
          localIntent.setType("image/jpeg");
          localIntent.putExtra("android.intent.extra.STREAM", paramAnonymousView);
          localIntent.putExtra("android.intent.extra.TEXT", "Check out " + PostDetails.this.postObj.getString(Configs.POSTS_TEXT).toString() + " on #" + 2131165208);
          PostDetails.this.startActivity(Intent.createChooser(localIntent, "Share on..."));
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
  
  void queryFollow()
  {
    ParseUser localParseUser = this.postObj.getParseUser(Configs.POSTS_USER_POINTER);
    this.followArray = new ArrayList();
    ParseQuery localParseQuery = ParseQuery.getQuery(Configs.FOLLOW_CLASS_NAME);
    localParseQuery.whereEqualTo(Configs.FOLLOW_A_USER, this.currUser);
    localParseQuery.whereEqualTo(Configs.FOLLOW_IS_FOLLOWING, localParseUser);
    localParseQuery.findInBackground(new FindCallback()
    {
      public void done(List<ParseObject> paramAnonymousList, ParseException paramAnonymousParseException)
      {
        if (paramAnonymousParseException == null)
        {
          PostDetails.this.followArray = paramAnonymousList;
          if (PostDetails.this.followArray.size() != 0)
          {
            PostDetails.this.followButt.setText("unfollow");
            PostDetails.this.followButt.setBackgroundResource(2130837603);
            return;
          }
          PostDetails.this.followButt.setText("follow");
          PostDetails.this.followButt.setBackgroundResource(2130837586);
          return;
        }
        Toast.makeText(PostDetails.this.getApplicationContext(), paramAnonymousParseException.getMessage().toString(), 1).show();
      }
    });
  }
  
  void queryLikeStatus()
  {
    this.likesArray = new ArrayList();
    ParseQuery localParseQuery = ParseQuery.getQuery(Configs.LIKES_CLASS_NAME);
    localParseQuery.whereEqualTo(Configs.LIKES_LIKED_BY, this.currUser);
    localParseQuery.whereEqualTo(Configs.LIKES_POST_LIKED, this.postObj);
    localParseQuery.findInBackground(new FindCallback()
    {
      public void done(List<ParseObject> paramAnonymousList, ParseException paramAnonymousParseException)
      {
        if (paramAnonymousParseException == null)
        {
          PostDetails.this.likesArray = paramAnonymousList;
          if (PostDetails.this.likesArray.size() == 0)
          {
            PostDetails.this.likeButt.setBackgroundResource(2130837604);
            return;
          }
          PostDetails.this.likeButt.setBackgroundResource(2130837588);
          return;
        }
        Toast.makeText(PostDetails.this.getApplicationContext(), paramAnonymousParseException.getMessage().toString(), 1).show();
      }
    });
  }
  
  void showPostDetails()
  {
    this.postObj.getParseObject(Configs.POSTS_USER_POINTER).fetchIfNeededInBackground(new GetCallback()
    {
      public void done(final ParseObject paramAnonymousParseObject, final ParseException paramAnonymousParseException)
      {
        ((TextView)PostDetails.this.findViewById(2131558609)).setText(paramAnonymousParseObject.getString(Configs.USER_FULLNAME));
        paramAnonymousParseException = (ImageView)PostDetails.this.findViewById(2131558608);
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
            PostDetails.this.postObj.getParseObject(Configs.POSTS_USER_POINTER).fetchIfNeededInBackground(new GetCallback()
            {
              public void done(ParseObject paramAnonymous3ParseObject, ParseException paramAnonymous3ParseException)
              {
                paramAnonymous3ParseException = new Intent(PostDetails.this, OtherUserProfile.class);
                paramAnonymous3ParseException.putExtra("objectID", paramAnonymous3ParseObject.getObjectId().toString());
                PostDetails.this.startActivity(paramAnonymous3ParseException);
              }
            });
          }
        });
        paramAnonymousParseObject = (ImageView)PostDetails.this.findViewById(2131558611);
        paramAnonymousParseException = (ParseFile)PostDetails.this.postObj.get(Configs.POSTS_IMAGE);
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
        paramAnonymousParseException = (ImageView)PostDetails.this.findViewById(2131558621);
        paramAnonymousParseObject.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            PostDetails.this.showPreviewLayout();
            paramAnonymous2View = ((BitmapDrawable)((ImageView)PostDetails.this.findViewById(2131558611)).getDrawable()).getBitmap();
            paramAnonymousParseException.setImageBitmap(paramAnonymous2View);
          }
        });
        paramAnonymousParseException.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
          {
            switch (paramAnonymous2View.getId())
            {
            }
            for (;;)
            {
              return true;
              switch (paramAnonymous2MotionEvent.getAction())
              {
              default: 
                break;
              case 0: 
                PostDetails.this.hidePreviewLayout();
              }
            }
          }
        });
        ((TextView)PostDetails.this.findViewById(2131558612)).setText(PostDetails.this.postObj.getString(Configs.POSTS_TEXT));
        paramAnonymousParseObject = (TextView)PostDetails.this.findViewById(2131558615);
        if (PostDetails.this.postObj.getNumber(Configs.POSTS_LIKES) != null)
        {
          paramAnonymousParseObject.setText(String.valueOf(PostDetails.this.postObj.getNumber(Configs.POSTS_LIKES)));
          return;
        }
        paramAnonymousParseObject.setText("0");
      }
    });
  }
  
  void showPreviewLayout()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131558619);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(localLinearLayout.getLayoutParams());
    localMarginLayoutParams.setMargins(0, 0, 0, 0);
    localLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(localMarginLayoutParams));
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
        Log.e(PostDetails.this.getString(2131165204), "downloadImageTask error: " + paramVarArgs.getMessage());
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


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/northpolewonderland/santagram/PostDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */