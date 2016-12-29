package android.support.v7.widget;

import android.view.View;

class as
{
  static int a(ao.s params, an paraman, View paramView1, View paramView2, ao.h paramh, boolean paramBoolean)
  {
    if ((paramh.t() == 0) || (params.e() == 0) || (paramView1 == null) || (paramView2 == null)) {
      return 0;
    }
    if (!paramBoolean) {
      return Math.abs(paramh.d(paramView1) - paramh.d(paramView2)) + 1;
    }
    int i = paraman.b(paramView2);
    int j = paraman.a(paramView1);
    return Math.min(paraman.f(), i - j);
  }
  
  static int a(ao.s params, an paraman, View paramView1, View paramView2, ao.h paramh, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    int j = i;
    if (paramh.t() != 0)
    {
      j = i;
      if (params.e() != 0)
      {
        j = i;
        if (paramView1 != null)
        {
          if (paramView2 != null) {
            break label45;
          }
          j = i;
        }
      }
    }
    return j;
    label45:
    i = Math.min(paramh.d(paramView1), paramh.d(paramView2));
    j = Math.max(paramh.d(paramView1), paramh.d(paramView2));
    if (paramBoolean2) {}
    for (i = Math.max(0, params.e() - j - 1);; i = Math.max(0, i))
    {
      j = i;
      if (!paramBoolean1) {
        break;
      }
      j = Math.abs(paraman.b(paramView2) - paraman.a(paramView1));
      int k = Math.abs(paramh.d(paramView1) - paramh.d(paramView2));
      float f = j / (k + 1);
      return Math.round(i * f + (paraman.c() - paraman.a(paramView1)));
    }
  }
  
  static int b(ao.s params, an paraman, View paramView1, View paramView2, ao.h paramh, boolean paramBoolean)
  {
    if ((paramh.t() == 0) || (params.e() == 0) || (paramView1 == null) || (paramView2 == null)) {
      return 0;
    }
    if (!paramBoolean) {
      return params.e();
    }
    int i = paraman.b(paramView2);
    int j = paraman.a(paramView1);
    int k = Math.abs(paramh.d(paramView1) - paramh.d(paramView2));
    return (int)((i - j) / (k + 1) * params.e());
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/widget/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */