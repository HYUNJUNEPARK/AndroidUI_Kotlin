# DrawerLayout

<img src="https://github.com/HYUNJUNEPARK/ImageRepository/blob/master/androidUI/DrawerLayout.jpg" height="400"/>

---
1. <a href = "#content1">레이아웃 구성</a></br>
2. <a href = "#content2">토글버튼</a></br>
3. <a href = "#content3">내비게이션뷰</a></br>
* <a href = "#ref">참고링크</a>
---
><a id = "content1">**1. 레이아웃 구성**</a></br>

-대부분 앱이 액티비티가 기본 화면으로 보이고 그 위를 드로어 레이아웃이 덮듯이 나오는 구조</br>
-액티비티 레이아웃 XML 파일의 루트 태그를 DrawerLayout 으로 선언</br>
-첫번째 태그화면이 보이고 두번째 태그화면은 왼쪽에 숨어있다 드래그로 끌려나오거나 토글버튼으로 출력됨</br>

```xml
<!--루트 태그로 선언된 DrawerLayout-->
<androidx.drawerlayout.widget.DrawerLayout
    //...
    tools:context=".MainActivity">

<!--첫번째 태그 : 액티비티 화면에 출력-->
    <androidx.constraintlayout.widget.ConstraintLayout
        //...
        />
        <androidx.appcompat.widget.Toolbar
            //...
            />
    </androidx.constraintlayout.widget.ConstraintLayout>

<!--두번째 태그 : 안보이다가 토글 버튼을 누르면 출력-->
    <com.google.android.material.navigation.NavigationView
        android:id="@+id/main_drawer_view"
        app:headerLayout="@layout/navigation_header"
        app:menu="@menu/menu_navigation"
        android:layout_gravity="start"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"/>
</androidx.drawerlayout.widget.DrawerLayout>
```
<br></br>
<br></br>

><a id = "content2">**2. 토글버튼**</a></br>

-`lateinit var toggle: ActionBarDrawerToggle` 으로 변수 선언</br>
-`ActionBarDrawerToggle()` : 토글 객체 생성</br>
-`onOptionsItemSelected()` : 토글 버튼이 눌렸을 때 이벤트 처리</br>


```kotlin
class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
    }

override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (toggle.onOptionsItemSelected(item)) {
        return true
    }
    return super.onOptionsItemSelected(item)
    }
}
```

<br></br>
<br></br>

><a id = "content3">**3. 내비게이션뷰**</a></br>

-`app:headerLayout="@layout/navigation_header"` : 내비게이션 뷰의 헤더레이아웃</br>
-`app:menu="@menu/menu_navigation"` : 헤더레이아웃 하단 메뉴</br>
-`android:layout_gravity="start"` : start 속성 값을 줘야 왼쪽으로 드로어레이아웃이 숨음</br>
-항목 선택 이벤트는 DrawerLayout 의 setNavigationItemSelectedListener() 로 이벤트 핸들러를 지정하여 처리</br>


```xml
<com.google.android.material.navigation.NavigationView
    android:id="@+id/main_drawer_view"
    app:headerLayout="@layout/navigation_header"
    app:menu="@menu/menu_navigation"
    android:layout_gravity="start"
    android:layout_width="wrap_content"
    android:layout_height="match_parent"/>
```


```kotlin
binding.mainDrawerView.setNavigationItemSelectedListener { menuItem ->
    when(menuItem.itemId) {
        R.id.item1 -> Toast.makeText(this, "Item1 Clicked", Toast.LENGTH_SHORT).show()
    }
    true
}
```
<br></br>
<br></br>
---

><a id = "ref">**참고링크**</a></br>


