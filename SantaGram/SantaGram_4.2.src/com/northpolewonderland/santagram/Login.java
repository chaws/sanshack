package com.northpolewonderland.santagram;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.a.a;
import android.support.v7.a.d;
import android.support.v7.a.d.a;
import android.support.v7.a.e;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

public class Login
  extends e
{
  ProgressDialog a;
  EditText b;
  EditText c;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968622);
    super.setRequestedOrientation(1);
    b.a(getApplicationContext(), getClass().getSimpleName());
    getSupportActionBar().b();
    this.a = new ProgressDialog(this);
    this.a.setTitle(2131165208);
    this.a.setMessage("Logging in...");
    this.a.setIndeterminate(false);
    this.b = ((EditText)findViewById(2131558558));
    this.c = ((EditText)findViewById(2131558559));
    ((Button)findViewById(2131558560)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Login.this.a.show();
        ParseUser.logInInBackground(Login.this.b.getText().toString(), Login.this.c.getText().toString(), new LogInCallback()
        {
          public void done(ParseUser paramAnonymous2ParseUser, ParseException paramAnonymous2ParseException)
          {
            if (paramAnonymous2ParseUser != null)
            {
              Login.this.a.dismiss();
              Login.this.startActivity(new Intent(Login.this, Home.class));
              return;
            }
            Login.this.a.dismiss();
            Toast.makeText(Login.this.getApplicationContext(), paramAnonymous2ParseException.getMessage().toString(), 1).show();
          }
        });
      }
    });
    ((Button)findViewById(2131558562)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Login.this.startActivity(new Intent(Login.this, SignUp.class));
      }
    });
    ((Button)findViewById(2131558561)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new d.a(Login.this);
        paramAnonymousView.a(2131165208);
        paramAnonymousView.b("Type the valid email address you've used to register on this app");
        final EditText localEditText = new EditText(Login.this);
        localEditText.setInputType(33);
        paramAnonymousView.b(localEditText);
        paramAnonymousView.a("OK", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            ParseUser.requestPasswordResetInBackground(localEditText.getText().toString(), new RequestPasswordResetCallback()
            {
              public void done(ParseException paramAnonymous3ParseException)
              {
                if (paramAnonymous3ParseException == null)
                {
                  paramAnonymous3ParseException = new d.a(Login.this);
                  paramAnonymous3ParseException.b("We've sent you an email to reset your password!").a(2131165208).a("OK", null);
                  paramAnonymous3ParseException = paramAnonymous3ParseException.b();
                  paramAnonymous3ParseException.a(2130837592);
                  paramAnonymous3ParseException.show();
                  return;
                }
                Toast.makeText(Login.this.getApplicationContext(), paramAnonymous3ParseException.getMessage().toString(), 1).show();
              }
            });
          }
        });
        paramAnonymousView.b("Cancel", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        paramAnonymousView.c();
      }
    });
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/northpolewonderland/santagram/Login.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */