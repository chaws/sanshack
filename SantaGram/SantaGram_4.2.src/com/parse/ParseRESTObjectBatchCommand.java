package com.parse;

import a.h;
import a.j;
import a.k;
import com.parse.a.b.b;
import com.parse.a.c;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseRESTObjectBatchCommand
  extends ParseRESTCommand
{
  public static final int COMMAND_OBJECT_BATCH_MAX_SIZE = 50;
  private static final String KEY_RESULTS = "results";
  
  private ParseRESTObjectBatchCommand(String paramString1, b.b paramb, JSONObject paramJSONObject, String paramString2)
  {
    super(paramString1, paramb, paramJSONObject, paramString2);
  }
  
  /* Error */
  public static List<j<JSONObject>> executeBatch(ParseHttpClient paramParseHttpClient, List<ParseRESTObjectCommand> paramList, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: aload_1
    //   4: invokeinterface 30 1 0
    //   9: istore 10
    //   11: new 32	java/util/ArrayList
    //   14: dup
    //   15: iload 10
    //   17: invokespecial 35	java/util/ArrayList:<init>	(I)V
    //   20: astore_3
    //   21: iload 10
    //   23: iconst_1
    //   24: if_icmpne +26 -> 50
    //   27: aload_3
    //   28: aload_1
    //   29: iconst_0
    //   30: invokeinterface 39 2 0
    //   35: checkcast 41	com/parse/ParseRESTObjectCommand
    //   38: aload_0
    //   39: invokevirtual 45	com/parse/ParseRESTObjectCommand:executeAsync	(Lcom/parse/ParseHttpClient;)La/j;
    //   42: invokeinterface 49 2 0
    //   47: pop
    //   48: aload_3
    //   49: areturn
    //   50: iload 10
    //   52: bipush 50
    //   54: if_icmple +62 -> 116
    //   57: aload_1
    //   58: bipush 50
    //   60: invokestatic 55	com/parse/Lists:partition	(Ljava/util/List;I)Ljava/util/List;
    //   63: astore_1
    //   64: aload_1
    //   65: invokeinterface 30 1 0
    //   70: istore 10
    //   72: iconst_0
    //   73: istore 9
    //   75: iload 9
    //   77: iload 10
    //   79: if_icmpge +35 -> 114
    //   82: aload_3
    //   83: aload_0
    //   84: aload_1
    //   85: iload 9
    //   87: invokeinterface 39 2 0
    //   92: checkcast 26	java/util/List
    //   95: aload_2
    //   96: invokestatic 57	com/parse/ParseRESTObjectBatchCommand:executeBatch	(Lcom/parse/ParseHttpClient;Ljava/util/List;Ljava/lang/String;)Ljava/util/List;
    //   99: invokeinterface 61 2 0
    //   104: pop
    //   105: iload 9
    //   107: iconst_1
    //   108: iadd
    //   109: istore 9
    //   111: goto -36 -> 75
    //   114: aload_3
    //   115: areturn
    //   116: new 32	java/util/ArrayList
    //   119: dup
    //   120: iload 10
    //   122: invokespecial 35	java/util/ArrayList:<init>	(I)V
    //   125: astore 4
    //   127: iload 9
    //   129: iload 10
    //   131: if_icmpge +43 -> 174
    //   134: new 63	a/k
    //   137: dup
    //   138: invokespecial 66	a/k:<init>	()V
    //   141: astore 5
    //   143: aload 4
    //   145: aload 5
    //   147: invokeinterface 49 2 0
    //   152: pop
    //   153: aload_3
    //   154: aload 5
    //   156: invokevirtual 70	a/k:a	()La/j;
    //   159: invokeinterface 49 2 0
    //   164: pop
    //   165: iload 9
    //   167: iconst_1
    //   168: iadd
    //   169: istore 9
    //   171: goto -44 -> 127
    //   174: new 72	org/json/JSONObject
    //   177: dup
    //   178: invokespecial 73	org/json/JSONObject:<init>	()V
    //   181: astore 5
    //   183: new 75	org/json/JSONArray
    //   186: dup
    //   187: invokespecial 76	org/json/JSONArray:<init>	()V
    //   190: astore 6
    //   192: aload_1
    //   193: invokeinterface 80 1 0
    //   198: astore_1
    //   199: aload_1
    //   200: invokeinterface 86 1 0
    //   205: ifeq +108 -> 313
    //   208: aload_1
    //   209: invokeinterface 90 1 0
    //   214: checkcast 41	com/parse/ParseRESTObjectCommand
    //   217: astore 8
    //   219: new 72	org/json/JSONObject
    //   222: dup
    //   223: invokespecial 73	org/json/JSONObject:<init>	()V
    //   226: astore 7
    //   228: aload 7
    //   230: ldc 92
    //   232: aload 8
    //   234: getfield 95	com/parse/ParseRESTObjectCommand:method	Lcom/parse/a/b$b;
    //   237: invokevirtual 101	com/parse/a/b$b:toString	()Ljava/lang/String;
    //   240: invokevirtual 105	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   243: pop
    //   244: aload 7
    //   246: ldc 107
    //   248: new 109	java/net/URL
    //   251: dup
    //   252: getstatic 113	com/parse/ParseRESTObjectBatchCommand:server	Ljava/net/URL;
    //   255: aload 8
    //   257: getfield 116	com/parse/ParseRESTObjectCommand:httpPath	Ljava/lang/String;
    //   260: invokespecial 119	java/net/URL:<init>	(Ljava/net/URL;Ljava/lang/String;)V
    //   263: invokevirtual 122	java/net/URL:getPath	()Ljava/lang/String;
    //   266: invokevirtual 105	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   269: pop
    //   270: aload 8
    //   272: getfield 126	com/parse/ParseRESTObjectCommand:jsonParameters	Lorg/json/JSONObject;
    //   275: astore 8
    //   277: aload 8
    //   279: ifnull +13 -> 292
    //   282: aload 7
    //   284: ldc -128
    //   286: aload 8
    //   288: invokevirtual 105	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   291: pop
    //   292: aload 6
    //   294: aload 7
    //   296: invokevirtual 131	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   299: pop
    //   300: goto -101 -> 199
    //   303: astore_0
    //   304: new 133	java/lang/RuntimeException
    //   307: dup
    //   308: aload_0
    //   309: invokespecial 136	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   312: athrow
    //   313: aload 5
    //   315: ldc -118
    //   317: aload 6
    //   319: invokevirtual 105	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   322: pop
    //   323: new 2	com/parse/ParseRESTObjectBatchCommand
    //   326: dup
    //   327: ldc -116
    //   329: getstatic 143	com/parse/a/b$b:b	Lcom/parse/a/b$b;
    //   332: aload 5
    //   334: aload_2
    //   335: invokespecial 144	com/parse/ParseRESTObjectBatchCommand:<init>	(Ljava/lang/String;Lcom/parse/a/b$b;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   338: aload_0
    //   339: invokevirtual 145	com/parse/ParseRESTCommand:executeAsync	(Lcom/parse/ParseHttpClient;)La/j;
    //   342: new 6	com/parse/ParseRESTObjectBatchCommand$1
    //   345: dup
    //   346: iload 10
    //   348: aload 4
    //   350: invokespecial 148	com/parse/ParseRESTObjectBatchCommand$1:<init>	(ILjava/util/List;)V
    //   353: invokevirtual 153	a/j:a	(La/h;)La/j;
    //   356: pop
    //   357: aload_3
    //   358: areturn
    //   359: astore_0
    //   360: new 133	java/lang/RuntimeException
    //   363: dup
    //   364: aload_0
    //   365: invokespecial 136	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   368: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	paramParseHttpClient	ParseHttpClient
    //   0	369	1	paramList	List<ParseRESTObjectCommand>
    //   0	369	2	paramString	String
    //   20	338	3	localArrayList1	java.util.ArrayList
    //   125	224	4	localArrayList2	java.util.ArrayList
    //   141	192	5	localObject1	Object
    //   190	128	6	localJSONArray	JSONArray
    //   226	69	7	localJSONObject	JSONObject
    //   217	70	8	localObject2	Object
    //   1	169	9	i	int
    //   9	338	10	j	int
    // Exception table:
    //   from	to	target	type
    //   192	199	303	org/json/JSONException
    //   199	277	303	org/json/JSONException
    //   282	292	303	org/json/JSONException
    //   292	300	303	org/json/JSONException
    //   313	323	303	org/json/JSONException
    //   192	199	359	java/net/MalformedURLException
    //   199	277	359	java/net/MalformedURLException
    //   282	292	359	java/net/MalformedURLException
    //   292	300	359	java/net/MalformedURLException
    //   313	323	359	java/net/MalformedURLException
  }
  
  protected j<JSONObject> onResponseAsync(c paramc, ProgressCallback paramProgressCallback)
  {
    Object localObject = null;
    paramProgressCallback = null;
    try
    {
      paramc = paramc.b();
      paramProgressCallback = paramc;
      localObject = paramc;
      String str = new String(ParseIOUtils.toByteArray(paramc));
      ParseIOUtils.closeQuietly(paramc);
      return j.a(newTemporaryException("bad json response", paramc));
    }
    catch (IOException paramc)
    {
      paramc = paramc;
      localObject = paramProgressCallback;
      paramc = j.a(paramc);
      ParseIOUtils.closeQuietly(paramProgressCallback);
      return paramc;
    }
    finally
    {
      ParseIOUtils.closeQuietly((InputStream)localObject);
    }
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseRESTObjectBatchCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */