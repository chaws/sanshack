package com.northpolewonderland.santagram;

import android.app.Application;
import com.parse.Parse;
import com.parse.Parse.Configuration.Builder;
import com.parse.ParseUser;

public class Configs
  extends Application
{
  public static String ACTIVITY_CLASS_NAME;
  public static String ACTIVITY_CURRENT_USER;
  public static String ACTIVITY_OTHER_USER;
  public static String ACTIVITY_TEXT;
  public static String COMMENTS_CLASS_NAME;
  public static String COMMENTS_COMMENT = "comment";
  public static String COMMENTS_CREATED_AT = "createdAt";
  public static String COMMENTS_POST_POINTER;
  public static String COMMENTS_USER_POINTER;
  public static String FOLLOW_A_USER;
  public static String FOLLOW_CLASS_NAME;
  public static String FOLLOW_IS_FOLLOWING;
  public static String LIKES_CLASS_NAME;
  public static String LIKES_CREATED_AT;
  public static String LIKES_LIKED_BY;
  public static String LIKES_POST_LIKED;
  public static String PARSE_APP_KEY;
  public static String PARSE_CLIENT_KEY;
  public static String POSTS_CITY;
  public static String POSTS_CLASSE_NAME;
  public static String POSTS_CREATED_AT;
  public static String POSTS_IMAGE;
  public static String POSTS_IS_REPORTED;
  public static String POSTS_KEYWORDS;
  public static String POSTS_LIKES;
  public static String POSTS_REPORT_MESSAGE;
  public static String POSTS_TEXT;
  public static String POSTS_TEXT_LOWERCASE;
  public static String POSTS_USER_POINTER;
  public static String REPORT_EMAIL_ADDRESS = "report@example.com";
  public static String USER_ABOUT_ME;
  public static String USER_AVATAR;
  public static String USER_CLASS_NAME;
  public static String USER_COVER_IMAGE;
  public static String USER_EMAIL;
  public static String USER_FULLNAME;
  public static String USER_IS_REPORTED;
  public static String USER_PUSH_ID;
  public static String USER_USERNAME;
  public static String[] colorsArray = { "#52861C", "#72A83B", "#99CC66", "#4F9F77", "#2E8357", "#15693E", "#4F9F77", "#C66386", "#831B40", "#A3395F" };
  boolean isParseInitialized = false;
  
  static
  {
    PARSE_APP_KEY = "ciy248KmH8uo8efusuTQ";
    PARSE_CLIENT_KEY = "kC2jgdZT3IGYQ9ZlNflY";
    USER_CLASS_NAME = "_User";
    USER_USERNAME = "username";
    USER_EMAIL = "email";
    USER_AVATAR = "avatar";
    USER_COVER_IMAGE = "coverImage";
    USER_FULLNAME = "fullName";
    USER_ABOUT_ME = "aboutMe";
    USER_PUSH_ID = null;
    USER_IS_REPORTED = "isReported";
    POSTS_CLASSE_NAME = "Posts";
    POSTS_TEXT = "postText";
    POSTS_TEXT_LOWERCASE = "textLowercase";
    POSTS_KEYWORDS = "keywords";
    POSTS_USER_POINTER = "postUser";
    POSTS_IMAGE = "postImageFile";
    POSTS_CITY = "city";
    POSTS_LIKES = "likes";
    POSTS_IS_REPORTED = "isReported";
    POSTS_REPORT_MESSAGE = "reportMessage";
    POSTS_CREATED_AT = "createdAt";
    LIKES_CLASS_NAME = "Likes";
    LIKES_LIKED_BY = "likedBy";
    LIKES_POST_LIKED = "postLiked";
    LIKES_CREATED_AT = "createdAt";
    FOLLOW_CLASS_NAME = "Follow";
    FOLLOW_A_USER = "aUser";
    FOLLOW_IS_FOLLOWING = "isFollowing";
    ACTIVITY_CLASS_NAME = "Activity";
    ACTIVITY_CURRENT_USER = "currentUser";
    ACTIVITY_OTHER_USER = "otherUser";
    ACTIVITY_TEXT = "text";
    COMMENTS_CLASS_NAME = "Comments";
    COMMENTS_POST_POINTER = "postPointer";
    COMMENTS_USER_POINTER = "userPointer";
  }
  
  public void onCreate()
  {
    super.onCreate();
    b.a(getApplicationContext(), getClass().getSimpleName());
    if (!this.isParseInitialized)
    {
      Parse.initialize(new Parse.Configuration.Builder(this).applicationId(String.valueOf(PARSE_APP_KEY)).clientKey(String.valueOf(PARSE_CLIENT_KEY)).server("https://www.northpolewonderland.com/parse").build());
      Parse.setLogLevel(2);
      ParseUser.enableAutomaticUser();
      this.isParseInitialized = true;
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/northpolewonderland/santagram/Configs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */