package com.parse;

import a.j;
import com.parse.a.a;
import com.parse.a.b;
import com.parse.a.b.a;
import com.parse.a.b.b;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

class ParseRESTCommand
  extends ParseRequest<JSONObject>
{
  static final String HEADER_APPLICATION_ID = "X-Parse-Application-Id";
  static final String HEADER_APP_BUILD_VERSION = "X-Parse-App-Build-Version";
  static final String HEADER_APP_DISPLAY_VERSION = "X-Parse-App-Display-Version";
  static final String HEADER_CLIENT_KEY = "X-Parse-Client-Key";
  static final String HEADER_CLIENT_VERSION = "X-Parse-Client-Version";
  static final String HEADER_INSTALLATION_ID = "X-Parse-Installation-Id";
  private static final String HEADER_MASTER_KEY = "X-Parse-Master-Key";
  static final String HEADER_OS_VERSION = "X-Parse-OS-Version";
  private static final String HEADER_SESSION_TOKEN = "X-Parse-Session-Token";
  private static final String PARAMETER_METHOD_OVERRIDE = "_method";
  static final String USER_AGENT = "User-Agent";
  static URL server = null;
  String httpPath;
  private String installationId;
  final JSONObject jsonParameters;
  private String localId;
  public String masterKey;
  private String operationSetUUID;
  private final String sessionToken;
  
  ParseRESTCommand(Init<?> paramInit)
  {
    super(paramInit.method, createUrl(paramInit.httpPath));
    this.sessionToken = paramInit.sessionToken;
    this.installationId = paramInit.installationId;
    this.masterKey = paramInit.masterKey;
    this.httpPath = paramInit.httpPath;
    this.jsonParameters = paramInit.jsonParameters;
    this.operationSetUUID = paramInit.operationSetUUID;
    this.localId = paramInit.localId;
  }
  
  public ParseRESTCommand(String paramString1, b.b paramb, Map<String, ?> paramMap, String paramString2) {}
  
  public ParseRESTCommand(String paramString1, b.b paramb, JSONObject paramJSONObject, String paramString2)
  {
    this(paramString1, paramb, paramJSONObject, null, paramString2);
  }
  
  private ParseRESTCommand(String paramString1, b.b paramb, JSONObject paramJSONObject, String paramString2, String paramString3)
  {
    super(paramb, createUrl(paramString1));
    this.httpPath = paramString1;
    this.jsonParameters = paramJSONObject;
    this.localId = paramString2;
    this.sessionToken = paramString3;
  }
  
  private static void addToStringer(JSONStringer paramJSONStringer, Object paramObject)
  {
    if ((paramObject instanceof JSONObject))
    {
      paramJSONStringer.object();
      paramObject = (JSONObject)paramObject;
      Iterator localIterator = ((JSONObject)paramObject).keys();
      Object localObject = new ArrayList();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(localIterator.next());
      }
      Collections.sort((List)localObject);
      localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        paramJSONStringer.key((String)localObject);
        addToStringer(paramJSONStringer, ((JSONObject)paramObject).opt((String)localObject));
      }
      paramJSONStringer.endObject();
      return;
    }
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      paramJSONStringer.array();
      int i = 0;
      while (i < ((JSONArray)paramObject).length())
      {
        addToStringer(paramJSONStringer, ((JSONArray)paramObject).get(i));
        i += 1;
      }
      paramJSONStringer.endArray();
      return;
    }
    paramJSONStringer.value(paramObject);
  }
  
  private static String createUrl(String paramString)
  {
    if (paramString == null) {
      return server.toString();
    }
    try
    {
      paramString = new URL(server, paramString).toString();
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public static ParseRESTCommand fromJSONObject(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("httpPath");
    b.b localb = b.b.a(paramJSONObject.optString("httpMethod"));
    String str2 = paramJSONObject.optString("sessionToken", null);
    String str3 = paramJSONObject.optString("localId", null);
    return new ParseRESTCommand(str1, localb, paramJSONObject.optJSONObject("parameters"), str3, str2);
  }
  
  private static LocalIdManager getLocalIdManager()
  {
    return ParseCorePlugins.getInstance().getLocalIdManager();
  }
  
  protected static void getLocalPointersIn(Object paramObject, ArrayList<JSONObject> paramArrayList)
  {
    JSONObject localJSONObject;
    if ((paramObject instanceof JSONObject))
    {
      localJSONObject = (JSONObject)paramObject;
      if (("Pointer".equals(localJSONObject.opt("__type"))) && (localJSONObject.has("localId"))) {
        paramArrayList.add((JSONObject)paramObject);
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext()) {
        getLocalPointersIn(localJSONObject.get((String)localIterator.next()), paramArrayList);
      }
      if ((paramObject instanceof JSONArray))
      {
        paramObject = (JSONArray)paramObject;
        int i = 0;
        while (i < ((JSONArray)paramObject).length())
        {
          getLocalPointersIn(((JSONArray)paramObject).get(i), paramArrayList);
          i += 1;
        }
      }
    }
  }
  
  static boolean isValidCommandJSONObject(JSONObject paramJSONObject)
  {
    return paramJSONObject.has("httpPath");
  }
  
  static boolean isValidOldFormatCommandJSONObject(JSONObject paramJSONObject)
  {
    return paramJSONObject.has("op");
  }
  
  private void maybeChangeServerOperation()
  {
    if (this.localId != null)
    {
      String str = getLocalIdManager().getObjectId(this.localId);
      if (str != null)
      {
        this.localId = null;
        this.httpPath += String.format("/%s", new Object[] { str });
        this.url = createUrl(this.httpPath);
        if ((this.httpPath.startsWith("classes")) && (this.method == b.b.b)) {
          this.method = b.b.c;
        }
      }
    }
  }
  
  static String toDeterministicString(Object paramObject)
  {
    JSONStringer localJSONStringer = new JSONStringer();
    addToStringer(localJSONStringer, paramObject);
    return localJSONStringer.toString();
  }
  
  protected void addAdditionalHeaders(b.a parama)
  {
    if (this.installationId != null) {
      parama.a("X-Parse-Installation-Id", this.installationId);
    }
    if (this.sessionToken != null) {
      parama.a("X-Parse-Session-Token", this.sessionToken);
    }
    if (this.masterKey != null) {
      parama.a("X-Parse-Master-Key", this.masterKey);
    }
  }
  
  void enableRetrying()
  {
    setMaxRetries(4);
  }
  
  public j<JSONObject> executeAsync(ParseHttpClient paramParseHttpClient, ProgressCallback paramProgressCallback1, ProgressCallback paramProgressCallback2, j<Void> paramj)
  {
    resolveLocalIds();
    return super.executeAsync(paramParseHttpClient, paramProgressCallback1, paramProgressCallback2, paramj);
  }
  
  public String getCacheKey()
  {
    if (this.jsonParameters != null) {}
    for (;;)
    {
      try
      {
        String str1 = toDeterministicString(this.jsonParameters);
        String str3 = str1;
        if (this.sessionToken != null) {
          str3 = str1 + this.sessionToken;
        }
        return String.format("ParseRESTCommand.%s.%s.%s", new Object[] { this.method.toString(), ParseDigestUtils.md5(this.httpPath), ParseDigestUtils.md5(str3) });
      }
      catch (JSONException localJSONException)
      {
        throw new RuntimeException(localJSONException.getMessage());
      }
      String str2 = "";
    }
  }
  
  public String getLocalId()
  {
    return this.localId;
  }
  
  public String getOperationSetUUID()
  {
    return this.operationSetUUID;
  }
  
  public String getSessionToken()
  {
    return this.sessionToken;
  }
  
  protected a newBody(ProgressCallback paramProgressCallback)
  {
    if (this.jsonParameters == null) {
      throw new IllegalArgumentException(String.format("Trying to execute a %s command without body parameters.", new Object[] { this.method.toString() }));
    }
    try
    {
      paramProgressCallback = this.jsonParameters;
      if ((this.method == b.b.a) || (this.method == b.b.d))
      {
        paramProgressCallback = new JSONObject(this.jsonParameters.toString());
        paramProgressCallback.put("_method", this.method.toString());
      }
      paramProgressCallback = new ParseByteArrayHttpBody(paramProgressCallback.toString(), "application/json");
      return paramProgressCallback;
    }
    catch (Exception paramProgressCallback)
    {
      throw new RuntimeException(paramProgressCallback.getMessage());
    }
  }
  
  protected b newRequest(b.b paramb, String paramString, ProgressCallback paramProgressCallback)
  {
    if ((this.jsonParameters != null) && (paramb != b.b.b) && (paramb != b.b.c)) {}
    for (paramb = super.newRequest(b.b.b, paramString, paramProgressCallback);; paramb = super.newRequest(paramb, paramString, paramProgressCallback))
    {
      paramb = new b.a(paramb);
      addAdditionalHeaders(paramb);
      return paramb.a();
    }
  }
  
  /* Error */
  protected j<JSONObject> onResponseAsync(com.parse.a.c paramc, ProgressCallback paramProgressCallback)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_1
    //   5: invokevirtual 415	com/parse/a/c:b	()Ljava/io/InputStream;
    //   8: astore 4
    //   10: aload 4
    //   12: astore_2
    //   13: aload 4
    //   15: astore_3
    //   16: new 171	java/lang/String
    //   19: dup
    //   20: aload 4
    //   22: invokestatic 421	com/parse/ParseIOUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   25: invokespecial 424	java/lang/String:<init>	([B)V
    //   28: astore 5
    //   30: aload 4
    //   32: invokestatic 428	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   35: aload_1
    //   36: invokevirtual 430	com/parse/a/c:a	()I
    //   39: istore 6
    //   41: iload 6
    //   43: sipush 200
    //   46: if_icmplt +132 -> 178
    //   49: iload 6
    //   51: sipush 600
    //   54: if_icmpge +124 -> 178
    //   57: new 123	org/json/JSONObject
    //   60: dup
    //   61: aload 5
    //   63: invokespecial 382	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   66: astore_1
    //   67: iload 6
    //   69: sipush 400
    //   72: if_icmplt +56 -> 128
    //   75: iload 6
    //   77: sipush 500
    //   80: if_icmpge +48 -> 128
    //   83: aload_0
    //   84: aload_1
    //   85: ldc_w 432
    //   88: invokevirtual 436	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   91: aload_1
    //   92: ldc_w 438
    //   95: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: invokevirtual 442	com/parse/ParseRESTCommand:newPermanentException	(ILjava/lang/String;)Lcom/parse/ParseException;
    //   101: invokestatic 447	a/j:a	(Ljava/lang/Exception;)La/j;
    //   104: astore_1
    //   105: aload_1
    //   106: areturn
    //   107: astore_1
    //   108: aload_2
    //   109: astore_3
    //   110: aload_1
    //   111: invokestatic 447	a/j:a	(Ljava/lang/Exception;)La/j;
    //   114: astore_1
    //   115: aload_2
    //   116: invokestatic 428	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   119: aload_1
    //   120: areturn
    //   121: astore_1
    //   122: aload_3
    //   123: invokestatic 428	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   126: aload_1
    //   127: athrow
    //   128: iload 6
    //   130: sipush 500
    //   133: if_icmplt +25 -> 158
    //   136: aload_0
    //   137: aload_1
    //   138: ldc_w 432
    //   141: invokevirtual 436	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   144: aload_1
    //   145: ldc_w 438
    //   148: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   151: invokevirtual 450	com/parse/ParseRESTCommand:newTemporaryException	(ILjava/lang/String;)Lcom/parse/ParseException;
    //   154: invokestatic 447	a/j:a	(Ljava/lang/Exception;)La/j;
    //   157: areturn
    //   158: aload_1
    //   159: invokestatic 453	a/j:a	(Ljava/lang/Object;)La/j;
    //   162: astore_1
    //   163: aload_1
    //   164: areturn
    //   165: astore_1
    //   166: aload_0
    //   167: ldc_w 455
    //   170: aload_1
    //   171: invokevirtual 458	com/parse/ParseRESTCommand:newTemporaryException	(Ljava/lang/String;Ljava/lang/Throwable;)Lcom/parse/ParseException;
    //   174: invokestatic 447	a/j:a	(Ljava/lang/Exception;)La/j;
    //   177: areturn
    //   178: aload_0
    //   179: iconst_m1
    //   180: aload 5
    //   182: invokevirtual 442	com/parse/ParseRESTCommand:newPermanentException	(ILjava/lang/String;)Lcom/parse/ParseException;
    //   185: invokestatic 447	a/j:a	(Ljava/lang/Exception;)La/j;
    //   188: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	ParseRESTCommand
    //   0	189	1	paramc	com.parse.a.c
    //   0	189	2	paramProgressCallback	ProgressCallback
    //   1	122	3	localObject	Object
    //   8	23	4	localInputStream	java.io.InputStream
    //   28	153	5	str	String
    //   39	95	6	i	int
    // Exception table:
    //   from	to	target	type
    //   4	10	107	java/io/IOException
    //   16	30	107	java/io/IOException
    //   4	10	121	finally
    //   16	30	121	finally
    //   110	115	121	finally
    //   57	67	165	org/json/JSONException
    //   83	105	165	org/json/JSONException
    //   136	158	165	org/json/JSONException
    //   158	163	165	org/json/JSONException
  }
  
  public void releaseLocalIds()
  {
    if (this.localId != null) {
      getLocalIdManager().releaseLocalIdOnDisk(this.localId);
    }
    try
    {
      Object localObject = new ArrayList();
      getLocalPointersIn(this.jsonParameters, (ArrayList)localObject);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((JSONObject)((Iterator)localObject).next()).get("localId");
        getLocalIdManager().releaseLocalIdOnDisk(str);
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public void resolveLocalIds()
  {
    try
    {
      Object localObject = new ArrayList();
      getLocalPointersIn(this.jsonParameters, (ArrayList)localObject);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        JSONObject localJSONObject = (JSONObject)((Iterator)localObject).next();
        String str = (String)localJSONObject.get("localId");
        str = getLocalIdManager().getObjectId(str);
        if (str == null) {
          throw new IllegalStateException("Tried to serialize a command referencing a new, unsaved object.");
        }
        localJSONObject.put("objectId", str);
        localJSONObject.remove("localId");
      }
      maybeChangeServerOperation();
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public void retainLocalIds()
  {
    if (this.localId != null) {
      getLocalIdManager().retainLocalIdOnDisk(this.localId);
    }
    try
    {
      Object localObject = new ArrayList();
      getLocalPointersIn(this.jsonParameters, (ArrayList)localObject);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((JSONObject)((Iterator)localObject).next()).get("localId");
        getLocalIdManager().retainLocalIdOnDisk(str);
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public void setLocalId(String paramString)
  {
    this.localId = paramString;
  }
  
  void setOperationSetUUID(String paramString)
  {
    this.operationSetUUID = paramString;
  }
  
  public JSONObject toJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.httpPath != null) {
        localJSONObject.put("httpPath", this.httpPath);
      }
      localJSONObject.put("httpMethod", this.method.toString());
      if (this.jsonParameters != null) {
        localJSONObject.put("parameters", this.jsonParameters);
      }
      if (this.sessionToken != null) {
        localJSONObject.put("sessionToken", this.sessionToken);
      }
      if (this.localId != null) {
        localJSONObject.put("localId", this.localId);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException.getMessage());
    }
  }
  
  public static class Builder
    extends ParseRESTCommand.Init<Builder>
  {
    public ParseRESTCommand build()
    {
      return new ParseRESTCommand(this);
    }
    
    Builder self()
    {
      return this;
    }
  }
  
  static abstract class Init<T extends Init<T>>
  {
    private String httpPath;
    private String installationId;
    private JSONObject jsonParameters;
    private String localId;
    public String masterKey;
    private b.b method = b.b.a;
    private String operationSetUUID;
    private String sessionToken;
    
    public T httpPath(String paramString)
    {
      this.httpPath = paramString;
      return self();
    }
    
    public T installationId(String paramString)
    {
      this.installationId = paramString;
      return self();
    }
    
    public T jsonParameters(JSONObject paramJSONObject)
    {
      this.jsonParameters = paramJSONObject;
      return self();
    }
    
    public T localId(String paramString)
    {
      this.localId = paramString;
      return self();
    }
    
    public T masterKey(String paramString)
    {
      this.masterKey = paramString;
      return self();
    }
    
    public T method(b.b paramb)
    {
      this.method = paramb;
      return self();
    }
    
    public T operationSetUUID(String paramString)
    {
      this.operationSetUUID = paramString;
      return self();
    }
    
    abstract T self();
    
    public T sessionToken(String paramString)
    {
      this.sessionToken = paramString;
      return self();
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseRESTCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */