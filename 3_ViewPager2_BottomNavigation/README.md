# 프로젝트 이름

<img src="https://github.com/HYUNJUNEPARK/ImageRepository/blob/master/androidUI/ViewPager2_BottomNavigation2.jpg" height="400"/>

---
1. <a href = "#content1">ViewPager2_BottomNavigation 연결 절차</a></br>
-BottomNavigationView 에 들어갈 메뉴 생성</br>
-xml 에 ViewPager2 태그와 BottomNavigationView 태그 생성</br>
-프래그먼트 어댑터를 이용한 ViewPager2 세팅</br>
-BottomNavigationView, ViewPager2 연결</br>

2. <a href = "#content2">Fragment 에 따른 툴바 메뉴 변경</a></br>
-invalidateOptionsMenu()</br>

* <a href = "#ref">참고링크</a>
---
><a id = "content1">**1. ViewPager2_BottomNavigation 연결 절차**</a></br>


**(1) BottomNavigationView 에 들어갈 메뉴 생성**</br>
-res-menu-menu_bottom.xml
<br></br>
**(2) xml 에 ViewPager2 태그와 BottomNavigationView 태그 생성**</br>

```xml
    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottomNavigation"
        android:layout_width="0dp"
        android:layout_height="?attr/actionBarSize"
        app:menu="@menu/menu_bottom"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />
```
<br></br>
**(3) 프래그먼트 어댑터를 이용한 ViewPager2 세팅**</br>
-`class FragmentAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity)`

```kotlin

val fragmentList = listOf(
    AFragment(),
    BFragment(),
    CFragment()
)
val adapter = FragmentAdapter(this)
adapter.fragmentList = fragmentList
binding.viewPager.adapter = adapter

```
<br></br>
**(4) BottomNavigationView, ViewPager2 연결**</br>

```kotlin
val toolBarTitleList = listOf(
    getString(R.string.fragment_a),
    getString(R.string.fragment_b),
    getString(R.string.fragment_c)
)
//BottomNavigation -> ViewPager2
binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
    when(menuItem.itemId) {
        R.id.menuA -> {
            binding.titleTextView.text = toolBarTitleList[0]
            binding.viewPager.currentItem = 0
            true
        }
        R.id.menuB -> {
            binding.titleTextView.text = toolBarTitleList[1]
            binding.viewPager.currentItem = 1
            true
        }
        R.id.menuC -> {
            binding.titleTextView.text = toolBarTitleList[2]
            binding.viewPager.currentItem = 2
            true
        }
        else -> {
            false
        }
    }
}
//ViewPager2 -> BottomNavigationView
binding.viewPager.registerOnPageChangeCallback(
    object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            invalidateOptionsMenu()
            binding.titleTextView.text = toolBarTitleList[position]
            binding.bottomNavigation.menu.getItem(position).isChecked = true
        }
    }
)
```
<br></br>
<br></br>

><a id = "content2">**2. Fragment 에 따른 툴바 메뉴 변경**</a></br>

-**invalidateOptionsMenu()**</br>

```kotlin

//뷰페이저에 변화가 있을 때 CallBack 함수가 실행되는데 내부 invalidateOptionsMenu() 가 menu 를 파괴시킴
binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
    override fun onPageSelected(position: Int) {
        super.onPageSelected(position)
        invalidateOptionsMenu()
        binding.titleTextView.text = toolBarTitleList[position]
        binding.bottomNavigation.menu.getItem(position).isChecked = true
    }
})

//menu 가 파괴되면 onCreateOptionsMenu() 가 실행됨
override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    val inflater: MenuInflater = menuInflater
    inflater.inflate(R.menu.menu_toolbar, menu)
    menu?.apply {
        findItem(R.id.toolBarMenu1).isVisible = (binding.viewPager.currentItem == 0)
        findItem(R.id.toolBarMenu2).isVisible = (binding.viewPager.currentItem == 1)
        findItem(R.id.toolBarMenu3).isVisible = (binding.viewPager.currentItem == 2)
    }
    return true
}

```


<br></br>
<br></br>
---

><a id = "ref">**참고링크**</a></br>

BottomNavigationView</br>
https://developer.android.com/reference/com/google/android/material/bottomnavigation/BottomNavigationView</br>

setOnNavigationItemSelectedListener deprecated 해결</br>
https://junyoung-developer.tistory.com/153</br>

OnNavigationItemSelectedListener deprecated [JAVA]</br>
https://stackoverflow.com/questions/68021770/setonnavigationitemselectedlistener-deprecated</br>
