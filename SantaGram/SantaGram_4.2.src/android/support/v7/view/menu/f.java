package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.j.d;
import android.support.v7.b.a.b;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class f
  implements android.support.v4.e.a.a
{
  private static final int[] d = { 1, 4, 5, 3, 2, 0 };
  CharSequence a;
  Drawable b;
  View c;
  private final Context e;
  private final Resources f;
  private boolean g;
  private boolean h;
  private a i;
  private ArrayList<h> j;
  private ArrayList<h> k;
  private boolean l;
  private ArrayList<h> m;
  private ArrayList<h> n;
  private boolean o;
  private int p = 0;
  private ContextMenu.ContextMenuInfo q;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private ArrayList<h> v = new ArrayList();
  private CopyOnWriteArrayList<WeakReference<l>> w = new CopyOnWriteArrayList();
  private h x;
  private boolean y;
  
  public f(Context paramContext)
  {
    this.e = paramContext;
    this.f = paramContext.getResources();
    this.j = new ArrayList();
    this.k = new ArrayList();
    this.l = true;
    this.m = new ArrayList();
    this.n = new ArrayList();
    this.o = true;
    e(true);
  }
  
  private static int a(ArrayList<h> paramArrayList, int paramInt)
  {
    int i1 = paramArrayList.size() - 1;
    while (i1 >= 0)
    {
      if (((h)paramArrayList.get(i1)).c() <= paramInt) {
        return i1 + 1;
      }
      i1 -= 1;
    }
    return 0;
  }
  
  private h a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    return new h(this, paramInt1, paramInt2, paramInt3, paramInt4, paramCharSequence, paramInt5);
  }
  
  private void a(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView)
  {
    Resources localResources = d();
    if (paramView != null)
    {
      this.c = paramView;
      this.a = null;
      this.b = null;
      b(false);
      return;
    }
    if (paramInt1 > 0)
    {
      this.a = localResources.getText(paramInt1);
      label47:
      if (paramInt2 <= 0) {
        break label83;
      }
      this.b = android.support.v4.c.a.a(e(), paramInt2);
    }
    for (;;)
    {
      this.c = null;
      break;
      if (paramCharSequence == null) {
        break label47;
      }
      this.a = paramCharSequence;
      break label47;
      label83:
      if (paramDrawable != null) {
        this.b = paramDrawable;
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= this.j.size())) {}
    do
    {
      return;
      this.j.remove(paramInt);
    } while (!paramBoolean);
    b(true);
  }
  
  private boolean a(p paramp, l paraml)
  {
    boolean bool = false;
    if (this.w.isEmpty()) {
      return false;
    }
    if (paraml != null) {
      bool = paraml.a(paramp);
    }
    paraml = this.w.iterator();
    l locall;
    if (paraml.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paraml.next();
      locall = (l)localWeakReference.get();
      if (locall == null) {
        this.w.remove(localWeakReference);
      }
    }
    for (;;)
    {
      break;
      if (!bool)
      {
        bool = locall.a(paramp);
        continue;
        return bool;
      }
    }
  }
  
  private static int d(int paramInt)
  {
    int i1 = (0xFFFF0000 & paramInt) >> 16;
    if ((i1 < 0) || (i1 >= d.length)) {
      throw new IllegalArgumentException("order does not contain a valid category.");
    }
    return d[i1] << 16 | 0xFFFF & paramInt;
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.w.isEmpty()) {
      return;
    }
    g();
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      l locall = (l)localWeakReference.get();
      if (locall == null) {
        this.w.remove(localWeakReference);
      } else {
        locall.b(paramBoolean);
      }
    }
    h();
  }
  
  private void e(boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramBoolean) && (this.f.getConfiguration().keyboard != 1) && (this.f.getBoolean(a.b.abc_config_showMenuShortcutsWhenKeyboardPresent))) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.h = paramBoolean;
      return;
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i2 = size();
    int i1 = paramInt2;
    if (paramInt2 < 0) {
      i1 = 0;
    }
    while (i1 < i2)
    {
      if (((h)this.j.get(i1)).getGroupId() == paramInt1) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public f a(int paramInt)
  {
    this.p = paramInt;
    return this;
  }
  
  protected f a(Drawable paramDrawable)
  {
    a(0, null, 0, paramDrawable, null);
    return this;
  }
  
  protected f a(View paramView)
  {
    a(0, null, 0, null, paramView);
    return this;
  }
  
  protected f a(CharSequence paramCharSequence)
  {
    a(0, paramCharSequence, 0, null, null);
    return this;
  }
  
  h a(int paramInt, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = this.v;
    localArrayList.clear();
    a(localArrayList, paramInt, paramKeyEvent);
    if (localArrayList.isEmpty())
    {
      paramKeyEvent = null;
      return paramKeyEvent;
    }
    int i3 = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    paramKeyEvent.getKeyData(localKeyData);
    int i4 = localArrayList.size();
    if (i4 == 1) {
      return (h)localArrayList.get(0);
    }
    boolean bool = b();
    int i1 = 0;
    label85:
    if (i1 < i4)
    {
      h localh = (h)localArrayList.get(i1);
      if (bool) {}
      for (int i2 = localh.getAlphabeticShortcut();; i2 = localh.getNumericShortcut())
      {
        if (i2 == localKeyData.meta[0])
        {
          paramKeyEvent = localh;
          if ((i3 & 0x2) == 0) {
            break;
          }
        }
        if (i2 == localKeyData.meta[2])
        {
          paramKeyEvent = localh;
          if ((i3 & 0x2) != 0) {
            break;
          }
        }
        if ((bool) && (i2 == 8))
        {
          paramKeyEvent = localh;
          if (paramInt == 67) {
            break;
          }
        }
        i1 += 1;
        break label85;
      }
    }
    return null;
  }
  
  protected MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    int i1 = d(paramInt3);
    paramCharSequence = a(paramInt1, paramInt2, paramInt3, i1, paramCharSequence, this.p);
    if (this.q != null) {
      paramCharSequence.a(this.q);
    }
    this.j.add(a(this.j, i1), paramCharSequence);
    b(true);
    return paramCharSequence;
  }
  
  protected String a()
  {
    return "android:menu:actionviewstates";
  }
  
  public void a(Bundle paramBundle)
  {
    int i2 = size();
    int i1 = 0;
    Object localObject3;
    for (Object localObject1 = null; i1 < i2; localObject1 = localObject3)
    {
      MenuItem localMenuItem = getItem(i1);
      View localView = android.support.v4.j.p.a(localMenuItem);
      localObject3 = localObject1;
      if (localView != null)
      {
        localObject3 = localObject1;
        if (localView.getId() != -1)
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new SparseArray();
          }
          localView.saveHierarchyState((SparseArray)localObject2);
          localObject3 = localObject2;
          if (android.support.v4.j.p.c(localMenuItem))
          {
            paramBundle.putInt("android:menu:expandedactionview", localMenuItem.getItemId());
            localObject3 = localObject2;
          }
        }
      }
      if (localMenuItem.hasSubMenu()) {
        ((p)localMenuItem.getSubMenu()).a(paramBundle);
      }
      i1 += 1;
    }
    if (localObject1 != null) {
      paramBundle.putSparseParcelableArray(a(), (SparseArray)localObject1);
    }
  }
  
  public void a(a parama)
  {
    this.i = parama;
  }
  
  void a(h paramh)
  {
    this.l = true;
    b(true);
  }
  
  public void a(l paraml)
  {
    a(paraml, this.e);
  }
  
  public void a(l paraml, Context paramContext)
  {
    this.w.add(new WeakReference(paraml));
    paraml.a(paramContext, this);
    this.o = true;
  }
  
  void a(MenuItem paramMenuItem)
  {
    int i2 = paramMenuItem.getGroupId();
    int i3 = this.j.size();
    int i1 = 0;
    if (i1 < i3)
    {
      h localh = (h)this.j.get(i1);
      if ((localh.getGroupId() != i2) || (!localh.g())) {}
      while (!localh.isCheckable())
      {
        i1 += 1;
        break;
      }
      if (localh == paramMenuItem) {}
      for (boolean bool = true;; bool = false)
      {
        localh.b(bool);
        break;
      }
    }
  }
  
  void a(List<h> paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = b();
    int i3 = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67)) {
      return;
    }
    int i4 = this.j.size();
    int i1 = 0;
    label49:
    h localh;
    if (i1 < i4)
    {
      localh = (h)this.j.get(i1);
      if (localh.hasSubMenu()) {
        ((f)localh.getSubMenu()).a(paramList, paramInt, paramKeyEvent);
      }
      if (!bool) {
        break label184;
      }
    }
    label184:
    for (int i2 = localh.getAlphabeticShortcut();; i2 = localh.getNumericShortcut())
    {
      if (((i3 & 0x5) == 0) && (i2 != 0) && ((i2 == localKeyData.meta[0]) || (i2 == localKeyData.meta[2]) || ((bool) && (i2 == 8) && (paramInt == 67))) && (localh.isEnabled())) {
        paramList.add(localh);
      }
      i1 += 1;
      break label49;
      break;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.u) {
      return;
    }
    this.u = true;
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      l locall = (l)localWeakReference.get();
      if (locall == null) {
        this.w.remove(localWeakReference);
      } else {
        locall.a(this, paramBoolean);
      }
    }
    this.u = false;
  }
  
  boolean a(f paramf, MenuItem paramMenuItem)
  {
    return (this.i != null) && (this.i.a(paramf, paramMenuItem));
  }
  
  public boolean a(MenuItem paramMenuItem, int paramInt)
  {
    return a(paramMenuItem, null, paramInt);
  }
  
  public boolean a(MenuItem paramMenuItem, l paraml, int paramInt)
  {
    boolean bool2 = false;
    Object localObject = (h)paramMenuItem;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (((h)localObject).isEnabled()) {
        break label33;
      }
      bool1 = bool2;
    }
    label33:
    label101:
    do
    {
      return bool1;
      bool1 = ((h)localObject).b();
      paramMenuItem = ((h)localObject).a();
      if ((paramMenuItem != null) && (paramMenuItem.e())) {}
      for (int i1 = 1;; i1 = 0)
      {
        if (!((h)localObject).n()) {
          break label101;
        }
        bool2 = ((h)localObject).expandActionView() | bool1;
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        a(true);
        return bool2;
      }
      if ((!((h)localObject).hasSubMenu()) && (i1 == 0)) {
        break;
      }
      a(false);
      if (!((h)localObject).hasSubMenu()) {
        ((h)localObject).a(new p(e(), this, (h)localObject));
      }
      localObject = (p)((h)localObject).getSubMenu();
      if (i1 != 0) {
        paramMenuItem.a((SubMenu)localObject);
      }
      bool2 = a((p)localObject, paraml) | bool1;
      bool1 = bool2;
    } while (bool2);
    a(true);
    return bool2;
    if ((paramInt & 0x1) == 0) {
      a(true);
    }
    return bool1;
  }
  
  public MenuItem add(int paramInt)
  {
    return a(0, 0, 0, this.f.getString(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, this.f.getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(paramInt1, paramInt2, paramInt3, paramCharSequence);
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return a(0, 0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    PackageManager localPackageManager = this.e.getPackageManager();
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int i1;
    label52:
    ResolveInfo localResolveInfo;
    if (localList != null)
    {
      i1 = localList.size();
      if ((paramInt4 & 0x1) == 0) {
        removeGroup(paramInt1);
      }
      paramInt4 = 0;
      if (paramInt4 >= i1) {
        break label214;
      }
      localResolveInfo = (ResolveInfo)localList.get(paramInt4);
      if (localResolveInfo.specificIndex >= 0) {
        break label201;
      }
    }
    label201:
    for (paramComponentName = paramIntent;; paramComponentName = paramArrayOfIntent[localResolveInfo.specificIndex])
    {
      paramComponentName = new Intent(paramComponentName);
      paramComponentName.setComponent(new ComponentName(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name));
      paramComponentName = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(paramComponentName);
      if ((paramArrayOfMenuItem != null) && (localResolveInfo.specificIndex >= 0)) {
        paramArrayOfMenuItem[localResolveInfo.specificIndex] = paramComponentName;
      }
      paramInt4 += 1;
      break label52;
      i1 = 0;
      break;
    }
    label214:
    return i1;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return addSubMenu(0, 0, 0, this.f.getString(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addSubMenu(paramInt1, paramInt2, paramInt3, this.f.getString(paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = (h)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    p localp = new p(this.e, this, paramCharSequence);
    paramCharSequence.a(localp);
    return localp;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }
  
  public int b(int paramInt)
  {
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((h)this.j.get(i1)).getItemId() == paramInt) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public void b(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      int i1;
      do
      {
        return;
        SparseArray localSparseArray = paramBundle.getSparseParcelableArray(a());
        int i2 = size();
        i1 = 0;
        while (i1 < i2)
        {
          MenuItem localMenuItem = getItem(i1);
          View localView = android.support.v4.j.p.a(localMenuItem);
          if ((localView != null) && (localView.getId() != -1)) {
            localView.restoreHierarchyState(localSparseArray);
          }
          if (localMenuItem.hasSubMenu()) {
            ((p)localMenuItem.getSubMenu()).b(paramBundle);
          }
          i1 += 1;
        }
        i1 = paramBundle.getInt("android:menu:expandedactionview");
      } while (i1 <= 0);
      paramBundle = findItem(i1);
    } while (paramBundle == null);
    android.support.v4.j.p.b(paramBundle);
  }
  
  void b(h paramh)
  {
    this.o = true;
    b(true);
  }
  
  public void b(l paraml)
  {
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      l locall = (l)localWeakReference.get();
      if ((locall == null) || (locall == paraml)) {
        this.w.remove(localWeakReference);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.r)
    {
      if (paramBoolean)
      {
        this.l = true;
        this.o = true;
      }
      d(paramBoolean);
      return;
    }
    this.s = true;
  }
  
  boolean b()
  {
    return this.g;
  }
  
  public int c(int paramInt)
  {
    return a(paramInt, 0);
  }
  
  public void c(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public boolean c(h paramh)
  {
    boolean bool2 = false;
    if (this.w.isEmpty()) {
      return bool2;
    }
    g();
    Iterator localIterator = this.w.iterator();
    boolean bool1 = false;
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      l locall = (l)localWeakReference.get();
      if (locall == null) {
        this.w.remove(localWeakReference);
      }
      do
      {
        break;
        bool2 = locall.a(this, paramh);
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    }
    for (;;)
    {
      h();
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.x = paramh;
      return bool1;
    }
  }
  
  public void clear()
  {
    if (this.x != null) {
      d(this.x);
    }
    this.j.clear();
    b(true);
  }
  
  public void clearHeader()
  {
    this.b = null;
    this.a = null;
    this.c = null;
    b(false);
  }
  
  public void close()
  {
    a(true);
  }
  
  Resources d()
  {
    return this.f;
  }
  
  public boolean d(h paramh)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!this.w.isEmpty())
    {
      if (this.x != paramh) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    g();
    Iterator localIterator = this.w.iterator();
    bool1 = false;
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      l locall = (l)localWeakReference.get();
      if (locall == null) {
        this.w.remove(localWeakReference);
      }
      do
      {
        break;
        bool2 = locall.b(this, paramh);
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    }
    for (;;)
    {
      h();
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.x = null;
      return bool1;
    }
  }
  
  public Context e()
  {
    return this.e;
  }
  
  public void f()
  {
    if (this.i != null) {
      this.i.a(this);
    }
  }
  
  public MenuItem findItem(int paramInt)
  {
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = (h)this.j.get(i1);
      if (((h)localObject).getItemId() == paramInt) {}
      MenuItem localMenuItem;
      do
      {
        return (MenuItem)localObject;
        if (!((h)localObject).hasSubMenu()) {
          break;
        }
        localMenuItem = ((h)localObject).getSubMenu().findItem(paramInt);
        localObject = localMenuItem;
      } while (localMenuItem != null);
      i1 += 1;
    }
    return null;
  }
  
  public void g()
  {
    if (!this.r)
    {
      this.r = true;
      this.s = false;
    }
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.j.get(paramInt);
  }
  
  public void h()
  {
    this.r = false;
    if (this.s)
    {
      this.s = false;
      b(true);
    }
  }
  
  public boolean hasVisibleItems()
  {
    if (this.y) {
      return true;
    }
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((h)this.j.get(i1)).isVisible()) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public ArrayList<h> i()
  {
    if (!this.l) {
      return this.k;
    }
    this.k.clear();
    int i2 = this.j.size();
    int i1 = 0;
    while (i1 < i2)
    {
      h localh = (h)this.j.get(i1);
      if (localh.isVisible()) {
        this.k.add(localh);
      }
      i1 += 1;
    }
    this.l = false;
    this.o = true;
    return this.k;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return a(paramInt, paramKeyEvent) != null;
  }
  
  public void j()
  {
    ArrayList localArrayList = i();
    if (!this.o) {
      return;
    }
    Object localObject = this.w.iterator();
    int i1 = 0;
    if (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      l locall = (l)localWeakReference.get();
      if (locall == null) {
        this.w.remove(localWeakReference);
      }
      for (;;)
      {
        break;
        i1 = locall.b() | i1;
      }
    }
    if (i1 != 0)
    {
      this.m.clear();
      this.n.clear();
      int i3 = localArrayList.size();
      i1 = 0;
      if (i1 < i3)
      {
        localObject = (h)localArrayList.get(i1);
        if (((h)localObject).j()) {
          this.m.add(localObject);
        }
        for (;;)
        {
          int i2;
          i1 += 1;
          break;
          this.n.add(localObject);
        }
      }
    }
    else
    {
      this.m.clear();
      this.n.clear();
      this.n.addAll(i());
    }
    this.o = false;
  }
  
  public ArrayList<h> k()
  {
    j();
    return this.m;
  }
  
  public ArrayList<h> l()
  {
    j();
    return this.n;
  }
  
  public CharSequence m()
  {
    return this.a;
  }
  
  public Drawable n()
  {
    return this.b;
  }
  
  public View o()
  {
    return this.c;
  }
  
  public f p()
  {
    return this;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return a(findItem(paramInt1), paramInt2);
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    paramKeyEvent = a(paramInt1, paramKeyEvent);
    boolean bool = false;
    if (paramKeyEvent != null) {
      bool = a(paramKeyEvent, paramInt2);
    }
    if ((paramInt2 & 0x2) != 0) {
      a(true);
    }
    return bool;
  }
  
  boolean q()
  {
    return this.t;
  }
  
  public h r()
  {
    return this.x;
  }
  
  public void removeGroup(int paramInt)
  {
    int i2 = c(paramInt);
    if (i2 >= 0)
    {
      int i3 = this.j.size();
      int i1 = 0;
      while ((i1 < i3 - i2) && (((h)this.j.get(i2)).getGroupId() == paramInt))
      {
        a(i2, false);
        i1 += 1;
      }
      b(true);
    }
  }
  
  public void removeItem(int paramInt)
  {
    a(b(paramInt), true);
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = this.j.size();
    int i1 = 0;
    while (i1 < i2)
    {
      h localh = (h)this.j.get(i1);
      if (localh.getGroupId() == paramInt)
      {
        localh.a(paramBoolean2);
        localh.setCheckable(paramBoolean1);
      }
      i1 += 1;
    }
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    int i2 = this.j.size();
    int i1 = 0;
    while (i1 < i2)
    {
      h localh = (h)this.j.get(i1);
      if (localh.getGroupId() == paramInt) {
        localh.setEnabled(paramBoolean);
      }
      i1 += 1;
    }
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    int i3 = this.j.size();
    int i2 = 0;
    int i1 = 0;
    if (i2 < i3)
    {
      h localh = (h)this.j.get(i2);
      if ((localh.getGroupId() != paramInt) || (!localh.c(paramBoolean))) {
        break label74;
      }
      i1 = 1;
    }
    label74:
    for (;;)
    {
      i2 += 1;
      break;
      if (i1 != 0) {
        b(true);
      }
      return;
    }
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.g = paramBoolean;
    b(false);
  }
  
  public int size()
  {
    return this.j.size();
  }
  
  public static abstract interface a
  {
    public abstract void a(f paramf);
    
    public abstract boolean a(f paramf, MenuItem paramMenuItem);
  }
  
  public static abstract interface b
  {
    public abstract boolean a(h paramh);
  }
}


/* Location:              /home/cdo/tmp/sanshack/SantaGram_4.2-dex2jar.jar!/android/support/v7/view/menu/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */