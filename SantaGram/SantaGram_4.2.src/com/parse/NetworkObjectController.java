package com.parse;

import a.h;
import a.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

class NetworkObjectController
  implements ParseObjectController
{
  private ParseHttpClient client;
  private ParseObjectCoder coder;
  
  public NetworkObjectController(ParseHttpClient paramParseHttpClient)
  {
    this.client = paramParseHttpClient;
    this.coder = ParseObjectCoder.get();
  }
  
  public List<j<Void>> deleteAllAsync(List<ParseObject.State> paramList, String paramString)
  {
    int j = 0;
    int k = paramList.size();
    ArrayList localArrayList = new ArrayList(k);
    int i = 0;
    while (i < k)
    {
      ParseRESTObjectCommand localParseRESTObjectCommand = ParseRESTObjectCommand.deleteObjectCommand((ParseObject.State)paramList.get(i), paramString);
      localParseRESTObjectCommand.enableRetrying();
      localArrayList.add(localParseRESTObjectCommand);
      i += 1;
    }
    paramList = ParseRESTObjectBatchCommand.executeBatch(this.client, localArrayList, paramString);
    paramString = new ArrayList(k);
    i = j;
    while (i < k)
    {
      paramString.add(((j)paramList.get(i)).k());
      i += 1;
    }
    return paramString;
  }
  
  public j<Void> deleteAsync(ParseObject.State paramState, String paramString)
  {
    paramState = ParseRESTObjectCommand.deleteObjectCommand(paramState, paramString);
    paramState.enableRetrying();
    return paramState.executeAsync(this.client).k();
  }
  
  public j<ParseObject.State> fetchAsync(final ParseObject.State paramState, String paramString, final ParseDecoder paramParseDecoder)
  {
    paramString = ParseRESTObjectCommand.getObjectCommand(paramState.objectId(), paramState.className(), paramString);
    paramString.enableRetrying();
    paramString.executeAsync(this.client).c(new h()
    {
      public ParseObject.State then(j<JSONObject> paramAnonymousj)
      {
        paramAnonymousj = (JSONObject)paramAnonymousj.f();
        ParseObject.State.Init localInit = paramState.newBuilder().clear();
        return NetworkObjectController.this.coder.decode(localInit, paramAnonymousj, paramParseDecoder).isComplete(true).build();
      }
    });
  }
  
  public List<j<ParseObject.State>> saveAllAsync(List<ParseObject.State> paramList, List<ParseOperationSet> paramList1, String paramString, List<ParseDecoder> paramList2)
  {
    int j = paramList.size();
    final Object localObject1 = new ArrayList(j);
    final Object localObject2 = PointerEncoder.get();
    int i = 0;
    while (i < j)
    {
      ParseObject.State localState = (ParseObject.State)paramList.get(i);
      ParseOperationSet localParseOperationSet = (ParseOperationSet)paramList1.get(i);
      ((List)localObject1).add(ParseRESTObjectCommand.saveObjectCommand(localState, this.coder.encode(localState, localParseOperationSet, (ParseEncoder)localObject2), paramString));
      i += 1;
    }
    paramList1 = ParseRESTObjectBatchCommand.executeBatch(this.client, (List)localObject1, paramString);
    paramString = new ArrayList(j);
    i = 0;
    while (i < j)
    {
      localObject1 = (ParseObject.State)paramList.get(i);
      localObject2 = (ParseDecoder)paramList2.get(i);
      paramString.add(((j)paramList1.get(i)).c(new h()
      {
        public ParseObject.State then(j<JSONObject> paramAnonymousj)
        {
          paramAnonymousj = (JSONObject)paramAnonymousj.f();
          ParseObject.State.Init localInit = localObject1.newBuilder().clear();
          return NetworkObjectController.this.coder.decode(localInit, paramAnonymousj, localObject2).isComplete(false).build();
        }
      }));
      i += 1;
    }
    return paramString;
  }
  
  public j<ParseObject.State> saveAsync(final ParseObject.State paramState, ParseOperationSet paramParseOperationSet, String paramString, final ParseDecoder paramParseDecoder)
  {
    paramParseOperationSet = ParseRESTObjectCommand.saveObjectCommand(paramState, this.coder.encode(paramState, paramParseOperationSet, PointerEncoder.get()), paramString);
    paramParseOperationSet.enableRetrying();
    paramParseOperationSet.executeAsync(this.client).c(new h()
    {
      public ParseObject.State then(j<JSONObject> paramAnonymousj)
      {
        paramAnonymousj = (JSONObject)paramAnonymousj.f();
        ParseObject.State.Init localInit = paramState.newBuilder().clear();
        return NetworkObjectController.this.coder.decode(localInit, paramAnonymousj, paramParseDecoder).isComplete(false).build();
      }
    });
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/com/parse/NetworkObjectController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */