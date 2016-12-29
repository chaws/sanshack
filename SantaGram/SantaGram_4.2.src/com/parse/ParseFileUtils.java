package com.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.json.JSONObject;

class ParseFileUtils
{
  private static final long FILE_COPY_BUFFER_SIZE = 31457280L;
  public static final long ONE_KB = 1024L;
  public static final long ONE_MB = 1048576L;
  
  public static void cleanDirectory(File paramFile)
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("Failed to list contents of " + paramFile);
    }
    int j = arrayOfFile.length;
    paramFile = null;
    int i = 0;
    for (;;)
    {
      File localFile;
      if (i < j) {
        localFile = arrayOfFile[i];
      }
      try
      {
        forceDelete(localFile);
        i += 1;
        continue;
        if (paramFile != null) {
          throw paramFile;
        }
      }
      catch (IOException paramFile)
      {
        for (;;) {}
      }
    }
  }
  
  public static void copyFile(File paramFile1, File paramFile2)
  {
    copyFile(paramFile1, paramFile2, true);
  }
  
  public static void copyFile(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' exists but is a directory");
    }
    if (paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath())) {
      throw new IOException("Source '" + paramFile1 + "' and destination '" + paramFile2 + "' are the same");
    }
    File localFile = paramFile2.getParentFile();
    if ((localFile != null) && (!localFile.mkdirs()) && (!localFile.isDirectory())) {
      throw new IOException("Destination '" + localFile + "' directory cannot be created");
    }
    if ((paramFile2.exists()) && (!paramFile2.canWrite())) {
      throw new IOException("Destination '" + paramFile2 + "' exists but is read-only");
    }
    doCopyFile(paramFile1, paramFile2, paramBoolean);
  }
  
  public static void deleteDirectory(File paramFile)
  {
    if (!paramFile.exists()) {}
    do
    {
      return;
      if (!isSymlink(paramFile)) {
        cleanDirectory(paramFile);
      }
    } while (paramFile.delete());
    throw new IOException("Unable to delete directory " + paramFile + ".");
  }
  
  public static boolean deleteQuietly(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    try
    {
      if (paramFile.isDirectory()) {
        cleanDirectory(paramFile);
      }
      try
      {
        boolean bool = paramFile.delete();
        return bool;
      }
      catch (Exception paramFile)
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  private static void doCopyFile(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 29	java/io/File:exists	()Z
    //   4: ifeq +42 -> 46
    //   7: aload_1
    //   8: invokevirtual 53	java/io/File:isDirectory	()Z
    //   11: ifeq +35 -> 46
    //   14: new 23	java/io/IOException
    //   17: dup
    //   18: new 33	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   25: ldc 108
    //   27: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: ldc 86
    //   36: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokespecial 62	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   45: athrow
    //   46: aconst_null
    //   47: astore 4
    //   49: aconst_null
    //   50: astore 5
    //   52: new 137	java/io/FileInputStream
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 139	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: astore_3
    //   61: new 141	java/io/FileOutputStream
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 142	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   69: astore 4
    //   71: aload_3
    //   72: invokevirtual 146	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   75: astore 5
    //   77: aload 4
    //   79: invokevirtual 147	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   82: astore 7
    //   84: aload 5
    //   86: invokevirtual 153	java/nio/channels/FileChannel:size	()J
    //   89: lstore 14
    //   91: lconst_0
    //   92: lstore 8
    //   94: goto +238 -> 332
    //   97: aload 7
    //   99: aload 5
    //   101: lload 8
    //   103: lload 10
    //   105: invokevirtual 157	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   108: lstore 10
    //   110: lload 10
    //   112: lconst_0
    //   113: lcmp
    //   114: ifne +98 -> 212
    //   117: aload 7
    //   119: invokestatic 163	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   122: aload 4
    //   124: invokestatic 166	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   127: aload 5
    //   129: invokestatic 163	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   132: aload_3
    //   133: invokestatic 169	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   136: aload_0
    //   137: invokevirtual 172	java/io/File:length	()J
    //   140: lstore 8
    //   142: aload_1
    //   143: invokevirtual 172	java/io/File:length	()J
    //   146: lstore 10
    //   148: lload 8
    //   150: lload 10
    //   152: lcmp
    //   153: ifeq +94 -> 247
    //   156: new 23	java/io/IOException
    //   159: dup
    //   160: new 33	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   167: ldc -82
    //   169: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_0
    //   173: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   176: ldc -80
    //   178: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_1
    //   182: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   185: ldc -78
    //   187: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: lload 8
    //   192: invokevirtual 181	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   195: ldc -73
    //   197: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: lload 10
    //   202: invokevirtual 181	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   205: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokespecial 62	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   211: athrow
    //   212: lload 8
    //   214: lload 10
    //   216: ladd
    //   217: lstore 8
    //   219: goto +113 -> 332
    //   222: astore_0
    //   223: aconst_null
    //   224: astore_3
    //   225: aconst_null
    //   226: astore_1
    //   227: aload_1
    //   228: invokestatic 163	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   231: aload 5
    //   233: invokestatic 166	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   236: aload_3
    //   237: invokestatic 163	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   240: aload 4
    //   242: invokestatic 169	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   245: aload_0
    //   246: athrow
    //   247: iload_2
    //   248: ifeq +12 -> 260
    //   251: aload_1
    //   252: aload_0
    //   253: invokevirtual 186	java/io/File:lastModified	()J
    //   256: invokevirtual 190	java/io/File:setLastModified	(J)Z
    //   259: pop
    //   260: return
    //   261: astore_0
    //   262: aload_3
    //   263: astore 4
    //   265: aconst_null
    //   266: astore_1
    //   267: aconst_null
    //   268: astore_3
    //   269: goto -42 -> 227
    //   272: astore_0
    //   273: aload_3
    //   274: astore 6
    //   276: aconst_null
    //   277: astore_3
    //   278: aconst_null
    //   279: astore_1
    //   280: aload 4
    //   282: astore 5
    //   284: aload 6
    //   286: astore 4
    //   288: goto -61 -> 227
    //   291: astore_0
    //   292: aload_3
    //   293: astore 6
    //   295: aload 5
    //   297: astore_3
    //   298: aconst_null
    //   299: astore_1
    //   300: aload 4
    //   302: astore 5
    //   304: aload 6
    //   306: astore 4
    //   308: goto -81 -> 227
    //   311: astore_0
    //   312: aload_3
    //   313: astore 6
    //   315: aload 7
    //   317: astore_1
    //   318: aload 5
    //   320: astore_3
    //   321: aload 4
    //   323: astore 5
    //   325: aload 6
    //   327: astore 4
    //   329: goto -102 -> 227
    //   332: lload 8
    //   334: lload 14
    //   336: lcmp
    //   337: ifge -220 -> 117
    //   340: lload 14
    //   342: lload 8
    //   344: lsub
    //   345: lstore 12
    //   347: lload 12
    //   349: lstore 10
    //   351: lload 12
    //   353: ldc2_w 7
    //   356: lcmp
    //   357: ifle -260 -> 97
    //   360: ldc2_w 7
    //   363: lstore 10
    //   365: goto -268 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	paramFile1	File
    //   0	368	1	paramFile2	File
    //   0	368	2	paramBoolean	boolean
    //   60	261	3	localObject1	Object
    //   47	281	4	localObject2	Object
    //   50	274	5	localObject3	Object
    //   274	52	6	localObject4	Object
    //   82	234	7	localFileChannel	java.nio.channels.FileChannel
    //   92	251	8	l1	long
    //   103	1	10	localObject5	Object
    //   108	256	10	l2	long
    //   345	7	12	l3	long
    //   89	252	14	l4	long
    // Exception table:
    //   from	to	target	type
    //   52	61	222	finally
    //   61	71	261	finally
    //   71	77	272	finally
    //   77	84	291	finally
    //   84	91	311	finally
    //   97	110	311	finally
  }
  
  public static void forceDelete(File paramFile)
  {
    if (paramFile.isDirectory()) {
      deleteDirectory(paramFile);
    }
    boolean bool;
    do
    {
      return;
      bool = paramFile.exists();
    } while (paramFile.delete());
    if (!bool) {
      throw new FileNotFoundException("File does not exist: " + paramFile);
    }
    throw new IOException("Unable to delete file: " + paramFile);
  }
  
  public static boolean isSymlink(File paramFile)
  {
    if (paramFile == null) {
      throw new NullPointerException("File must not be null");
    }
    if (paramFile.getParent() == null) {}
    while (paramFile.getCanonicalFile().equals(paramFile.getAbsoluteFile()))
    {
      return false;
      paramFile = new File(paramFile.getParentFile().getCanonicalFile(), paramFile.getName());
    }
    return true;
  }
  
  public static void moveFile(File paramFile1, File paramFile2)
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' is a directory");
    }
    if (paramFile2.exists()) {
      throw new IOException("Destination '" + paramFile2 + "' already exists");
    }
    if (paramFile2.isDirectory()) {
      throw new IOException("Destination '" + paramFile2 + "' is a directory");
    }
    if (!paramFile1.renameTo(paramFile2))
    {
      copyFile(paramFile1, paramFile2);
      if (!paramFile1.delete())
      {
        deleteQuietly(paramFile2);
        throw new IOException("Failed to delete original file '" + paramFile1 + "' after copy to '" + paramFile2 + "'");
      }
    }
  }
  
  public static FileInputStream openInputStream(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canRead()) {
        throw new IOException("File '" + paramFile + "' cannot be read");
      }
    }
    else
    {
      throw new FileNotFoundException("File '" + paramFile + "' does not exist");
    }
    return new FileInputStream(paramFile);
  }
  
  public static FileOutputStream openOutputStream(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canWrite()) {
        throw new IOException("File '" + paramFile + "' cannot be written to");
      }
    }
    else
    {
      File localFile = paramFile.getParentFile();
      if ((localFile != null) && (!localFile.exists()) && (!localFile.mkdirs())) {
        throw new IOException("File '" + paramFile + "' could not be created");
      }
    }
    return new FileOutputStream(paramFile);
  }
  
  public static byte[] readFileToByteArray(File paramFile)
  {
    File localFile = null;
    try
    {
      paramFile = openInputStream(paramFile);
      localFile = paramFile;
      byte[] arrayOfByte = ParseIOUtils.toByteArray(paramFile);
      return arrayOfByte;
    }
    finally
    {
      ParseIOUtils.closeQuietly(localFile);
    }
  }
  
  public static JSONObject readFileToJSONObject(File paramFile)
  {
    return new JSONObject(readFileToString(paramFile, "UTF-8"));
  }
  
  public static String readFileToString(File paramFile, String paramString)
  {
    return readFileToString(paramFile, Charset.forName(paramString));
  }
  
  public static String readFileToString(File paramFile, Charset paramCharset)
  {
    return new String(readFileToByteArray(paramFile), paramCharset);
  }
  
  public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfByte)
  {
    File localFile = null;
    try
    {
      paramFile = openOutputStream(paramFile);
      localFile = paramFile;
      paramFile.write(paramArrayOfByte);
      return;
    }
    finally
    {
      ParseIOUtils.closeQuietly(localFile);
    }
  }
  
  public static void writeJSONObjectToFile(File paramFile, JSONObject paramJSONObject)
  {
    writeByteArrayToFile(paramFile, paramJSONObject.toString().getBytes(Charset.forName("UTF-8")));
  }
  
  public static void writeStringToFile(File paramFile, String paramString1, String paramString2)
  {
    writeStringToFile(paramFile, paramString1, Charset.forName(paramString2));
  }
  
  public static void writeStringToFile(File paramFile, String paramString, Charset paramCharset)
  {
    writeByteArrayToFile(paramFile, paramString.getBytes(paramCharset));
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/ParseFileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */