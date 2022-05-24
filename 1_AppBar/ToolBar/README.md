# Toolbar

---
1. <a href = "#content1">AppBarLayout/Toolbar</a></br>
2. <a href = "#content2">setSupportActionBar(툴바 세팅)</a></br>
3. <a href = "#content3">onCreateOptionsMenu/onOptionsItemSelected(메뉴 커스텀)</a></br>
* <a href = "#ref">참고링크</a>
---
><a id = "content1">**1. AppBarLayout/Toolbar**</a></br>

-AppBarLayout 하위 태그로 Toolbar 세팅</br>

```
<com.google.android.material.appbar.AppBarLayout
    android:id="@+id/appBarLayout"
    style="@style/Theme.Toolbar"
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent">

    <androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</com.google.android.material.appbar.AppBarLayout>
```

<br></br>
<br></br>

><a id = "content2">**2. setSupportActionBar(툴바 세팅)**</a></br>

-xml 에 세팅한 툴바 setSupportActionBar 에 파라미터로 전달 `setSupportActionBar(binding.toolbar)`</br>
-onCreate 에 `supportActionBar?.setDisplayShowTitleEnabled(false)` 을 추가하면 툴바에 AppName 속성이 사라짐</br>


```kotlin
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
}
```


<br></br>
<br></br>

><a id = "content3">**3. onCreateOptionsMenu/onOptionsItemSelected(메뉴 커스텀)**</a></br>

```kotlin
override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    val inflater: MenuInflater = menuInflater
    inflater.inflate(R.menu.menu, menu)

    val menuSearch = menu?.findItem(R.id.menu1)
    val searchView = menuSearch?.actionView as SearchView
    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(p0: String?): Boolean {
            Toast.makeText(this@MainActivity, "SearchView Event", Toast.LENGTH_SHORT).show()
            return true
        }
        override fun onQueryTextChange(p0: String?): Boolean {
            return true
        }
    })
    return true
}

```

```
override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when(item.itemId) {
        R.id.menu2 -> {
            Toast.makeText(this, "menu_never Event", Toast.LENGTH_SHORT).show()
        }
        R.id.menu3 -> {
            Toast.makeText(this, "Setting Event", Toast.LENGTH_SHORT).show()
        }
    }
    return super.onOptionsItemSelected(item)
}
```


<br></br>
<br></br>
---

><a id = "ref">**참고링크**</a></br>

</br>ActionBar(Toolbar) 앱이름 감추기
</br>https://blog.daum.net/andro_java/726




