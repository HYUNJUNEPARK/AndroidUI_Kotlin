# ActionBar

<img src="https://github.com/HYUNJUNEPARK/ImageRepository/blob/master/androidUI/actionBar.jpg" height="400"/>

---
1. <a href = "#content1">업 버튼</a></br>
2. <a href = "#content2">메뉴</a></br>
3. <a href = "#content3">서치뷰</a></br>
* <a href = "#ref">참고링크</a>
---
><a id = "content1">**1. 업 버튼**</a></br>

-액션바에 뒤로가기 버튼 생성</br>

```
//AndroidManifest
<activity
    android:name=".SubActivity"
    android:parentActivityName=".MainActivity"
    android:exported="true" >

//SubActivity
override fun onSupportNavigateUp(): Boolean {
    //이전 화면으로 될아가기 전에 실행 시킬 로직
    return super.onSupportNavigateUp()
}
```
<br></br>
<br></br>

><a id = "content2">**2. 메뉴**</a></br>

-액션바에 메뉴 생성
-res-menu-menu.xml 생성 후 item 추가</br>
-showAsAction 속성값</br>
never(기본) : 항상 오버플로 메뉴로 출력</br>
ifRoom : 만약 액션바 공간이 있다면 액션 아이템으로, 없다면 오버플로 메뉴로 출력</br>
always : 항상 액션 아이템으로 출력</br>

```xml
//menu
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <item
        android:id="@+id/menu1"
        android:icon="@drawable/ic_baseline_search_24"
        android:title="menu_always"
        app:showAsAction="always" />

    <item
        android:id="@+id/menu2"
        android:icon="@drawable/ic_launcher_background"
        android:title="menu_never" />

    <item
        android:id="@+id/menu3"
        android:icon="@drawable/ic_baseline_settings_24"
        android:title="menu_ifRoom"
        app:showAsAction="ifRoom" />

</menu>

//SubActivity
override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu, menu)
    return super.onCreateOptionsMenu(menu)
}

override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when(item.itemId) {
        R.id.menuId -> Toast.makeText(this@SubActivity, "menu_never Event", Toast.LENGTH_SHORT).show()
    }
    return super.onOptionsItemSelected(item)
}
```

<br></br>
<br></br>


><a id = "content3">**3. 서치뷰**</a></br>

-app:actionViewClass="androidx.appcompat.widget.SearchView"</br>


```
//menu
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <item
        android:id="@+id/menu1"
        android:icon="@drawable/ic_baseline_search_24"
        android:title="menu_always"
        app:actionViewClass="androidx.appcompat.widget.SearchView"
        app:showAsAction="always" />

</menu>

//SubActivity
override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    val inflater: MenuInflater = menuInflater
    inflater.inflate(R.menu.menu, menu)

    val menuSearch = menu?.findItem(R.id.menu1)
    val searchView = menuSearch?.actionView as SearchView
    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(p0: String?): Boolean {
            Toast.makeText(this@SubActivity, "SearchView Event", Toast.LENGTH_SHORT).show()
            return true
        }
        override fun onQueryTextChange(p0: String?): Boolean {
            return true
        }
    })
    return true
}
```

<br></br>
<br></br>
---

><a id = "ref">**참고링크**</a></br>

메뉴</br>
https://developer.android.com/guide/topics/ui/menus?hl=ko</br>