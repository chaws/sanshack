package com.northpolewonderland.santagram;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.provider.Settings.Secure;
import android.support.v7.a.d;
import android.support.v7.a.d.a;
import android.support.v7.a.e;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONObject;

public class EditProfile
  extends e
{
  ProgressDialog a;
  ParseUser b = ParseUser.getCurrentUser();
  a c = new a(this);
  boolean d;
  int e = 0;
  int f = 1;
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if (paramInt1 != this.e) {
        break label54;
      }
    }
    for (paramIntent = (Bitmap)paramIntent.getExtras().get("data"); this.d; paramIntent = null)
    {
      ((ImageView)findViewById(2131558535)).setImageBitmap(paramIntent);
      return;
      label54:
      if (paramInt1 == this.f) {
        try
        {
          paramIntent = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), paramIntent.getData());
        }
        catch (IOException paramIntent)
        {
          paramIntent.printStackTrace();
        }
      }
    }
    ((ImageView)findViewById(2131558537)).setImageBitmap(paramIntent);
  }
  
  protected void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968618);
    super.setRequestedOrientation(1);
    b.a(getApplicationContext(), getClass().getSimpleName());
    int i;
    if (getString(2131165214).equals("true"))
    {
      Log.i(getString(2131165204), "Remote debug logging is Enabled");
      i = 1;
    }
    for (;;)
    {
      getSupportActionBar().a(true);
      getSupportActionBar().b(true);
      getSupportActionBar().a("Edit Profile");
      this.a = new ProgressDialog(this);
      this.a.setTitle(2131165208);
      this.a.setIndeterminate(false);
      if (i != 0) {}
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("date", new SimpleDateFormat("yyyyMMddHHmmssZ").format(Calendar.getInstance().getTime()));
        paramBundle.put("udid", Settings.Secure.getString(getContentResolver(), "android_id"));
        paramBundle.put("debug", getClass().getCanonicalName() + ", " + getClass().getSimpleName());
        paramBundle.put("freemem", Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        new Thread(new Runnable()
        {
          public void run()
          {
            b.a(EditProfile.this.getString(2131165213), paramBundle);
          }
        }).start();
        paramBundle = (ImageView)findViewById(2131558535);
        final Object localObject = (ParseFile)this.b.get(Configs.USER_AVATAR);
        if (localObject != null) {
          ((ParseFile)localObject).getDataInBackground(new GetDataCallback()
          {
            public void done(byte[] paramAnonymousArrayOfByte, ParseException paramAnonymousParseException)
            {
              if (paramAnonymousParseException == null)
              {
                paramAnonymousParseException = new BitmapFactory.Options();
                paramAnonymousParseException.inPurgeable = true;
                paramAnonymousArrayOfByte = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length, paramAnonymousParseException);
                if (paramAnonymousArrayOfByte != null) {
                  paramBundle.setImageBitmap(paramAnonymousArrayOfByte);
                }
              }
            }
          });
        }
        paramBundle.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            EditProfile.this.d = true;
            Toast.makeText(EditProfile.this.getApplicationContext(), "Only elves can upload images", 1).show();
          }
        });
        paramBundle = (ImageView)findViewById(2131558537);
        localObject = (ParseFile)this.b.get(Configs.USER_COVER_IMAGE);
        if (localObject != null) {
          ((ParseFile)localObject).getDataInBackground(new GetDataCallback()
          {
            public void done(byte[] paramAnonymousArrayOfByte, ParseException paramAnonymousParseException)
            {
              if (paramAnonymousParseException == null)
              {
                paramAnonymousParseException = new BitmapFactory.Options();
                paramAnonymousParseException.inPurgeable = true;
                paramAnonymousArrayOfByte = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length, paramAnonymousParseException);
                paramAnonymousParseException = b.a(paramAnonymousArrayOfByte, 1024.0F);
                if (paramAnonymousArrayOfByte != null) {
                  paramBundle.setImageBitmap(paramAnonymousParseException);
                }
              }
            }
          });
        }
        paramBundle.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            EditProfile.this.d = false;
            Toast.makeText(EditProfile.this.getApplicationContext(), "Only elves can upload images", 1).show();
          }
        });
        paramBundle = (TextView)findViewById(2131558540);
        paramBundle.setText(this.b.getString(Configs.USER_FULLNAME));
        localObject = (TextView)findViewById(2131558542);
        ((TextView)localObject).setText(this.b.getString(Configs.USER_ABOUT_ME));
        ((TextView)findViewById(2131558544)).setText(this.b.getString(Configs.USER_EMAIL));
        ((Button)findViewById(2131558545)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            EditProfile.this.a.setMessage("Updating profile...");
            EditProfile.this.a.show();
            EditProfile.this.b.put(Configs.USER_FULLNAME, paramBundle.getText().toString());
            EditProfile.this.b.put(Configs.USER_ABOUT_ME, localObject.getText().toString());
            EditProfile.this.b.saveInBackground(new SaveCallback()
            {
              public void done(ParseException paramAnonymous2ParseException)
              {
                if (paramAnonymous2ParseException == null)
                {
                  EditProfile.this.a.dismiss();
                  paramAnonymous2ParseException = new d.a(EditProfile.this);
                  paramAnonymous2ParseException.b("Your profile has been updated!").a(2131165208).b(2130837592).a("OK", null);
                  paramAnonymous2ParseException.b().show();
                  return;
                }
                Toast.makeText(EditProfile.this.getApplicationContext(), paramAnonymous2ParseException.getMessage().toString(), 0).show();
                EditProfile.this.a.dismiss();
              }
            });
          }
        });
        return;
        Log.i(getString(2131165204), "Remote debug logging is Disabled");
        i = 0;
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Log.e(getString(2131165204), "Error posting JSON debug data: " + paramBundle.getMessage());
        }
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
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/northpolewonderland/santagram/EditProfile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */