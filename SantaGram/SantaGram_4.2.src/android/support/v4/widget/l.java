package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.ListView;

public final class l
{
  public static void a(ListView paramListView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      n.a(paramListView, paramInt);
      return;
    }
    m.a(paramListView, paramInt);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v4/widget/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */