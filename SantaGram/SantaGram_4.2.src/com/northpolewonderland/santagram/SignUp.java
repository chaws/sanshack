package com.northpolewonderland.santagram;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.a.a;
import android.support.v7.a.d;
import android.support.v7.a.d.a;
import android.support.v7.a.e;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp
  extends e
{
  EditText fullnameTxt;
  EditText passwordTxt;
  ProgressDialog progDialog;
  EditText usernameTxt;
  
  public void dismisskeyboard()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    localInputMethodManager.hideSoftInputFromWindow(this.usernameTxt.getWindowToken(), 0);
    localInputMethodManager.hideSoftInputFromWindow(this.passwordTxt.getWindowToken(), 0);
    localInputMethodManager.hideSoftInputFromWindow(this.fullnameTxt.getWindowToken(), 0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968639);
    super.setRequestedOrientation(1);
    b.a(getApplicationContext(), getClass().getSimpleName());
    getSupportActionBar().a(true);
    getSupportActionBar().b(true);
    getSupportActionBar().a("Sign Up");
    this.progDialog = new ProgressDialog(this);
    this.progDialog.setTitle(2131165208);
    this.progDialog.setMessage("Signing Up...");
    this.progDialog.setIndeterminate(false);
    this.usernameTxt = ((EditText)findViewById(2131558626));
    this.passwordTxt = ((EditText)findViewById(2131558627));
    this.fullnameTxt = ((EditText)findViewById(2131558628));
    ((Button)findViewById(2131558629)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((SignUp.this.usernameTxt.getText().toString().matches("")) || (SignUp.this.passwordTxt.getText().toString().matches("")) || (SignUp.this.fullnameTxt.getText().toString().matches("")))
        {
          paramAnonymousView = new d.a(SignUp.this);
          paramAnonymousView.b("You must fill all the fields to Sign Up!").a(2131165208).a("OK", null);
          paramAnonymousView = paramAnonymousView.b();
          paramAnonymousView.a(2130837592);
          paramAnonymousView.show();
          return;
        }
        SignUp.this.progDialog.show();
        SignUp.this.dismisskeyboard();
        paramAnonymousView = new ParseUser();
        paramAnonymousView.setUsername(SignUp.this.usernameTxt.getText().toString());
        paramAnonymousView.setPassword(SignUp.this.passwordTxt.getText().toString());
        paramAnonymousView.setEmail(SignUp.this.usernameTxt.getText().toString());
        paramAnonymousView.put(Configs.USER_FULLNAME, SignUp.this.fullnameTxt.getText().toString());
        paramAnonymousView.put(Configs.USER_IS_REPORTED, Boolean.valueOf(false));
        paramAnonymousView.signUpInBackground(new SignUpCallback()
        {
          public void done(ParseException paramAnonymous2ParseException)
          {
            if (paramAnonymous2ParseException == null)
            {
              SignUp.this.progDialog.dismiss();
              SignUp.this.startActivity(new Intent(SignUp.this, Home.class));
              return;
            }
            SignUp.this.progDialog.dismiss();
            Toast.makeText(SignUp.this.getApplicationContext(), paramAnonymous2ParseException.getMessage().toString(), 1).show();
          }
        });
      }
    });
    ((Button)findViewById(2131558630)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SignUp.this.startActivity(new Intent(SignUp.this, TermsOfUse.class));
      }
    });
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


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/northpolewonderland/santagram/SignUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */