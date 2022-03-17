# 프로젝트 이름

<img src="https://github.com/HYUNJUNEPARK/ImageRepository/blob/master/androidUI/ViewPager2_BottomNavigation.jpg" height="400"/>

---
1. <a href = "#content1">ViewPager2_BottomNavigation 연결 절차</a></br>
* <a href = "#ref">참고링크</a>
---
><a id = "content1">**1. ViewPager2_BottomNavigation 연결 절차**</a></br>


**(1) BottomNavigationView 에 들어갈 메뉴 생성**</br>
-res-menu-menu_bottom.xml
<br></br>
<br></br>
**(2) xml 에 ViewPager2 태그와 BottomNavigationView 태그 생성**</br>

```xml
    <androidx.appcompat.widget.AppCompatImageView
        //...
        />

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
<br></br>
**(4) BottomNavigationView, ViewPager2 연결**</br>

```kotlin
binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
    when(menuItem.itemId) {
        R.id.menuA -> {
            binding.viewPager.currentItem = 0
            true
        }
        R.id.menuB -> {
            binding.viewPager.currentItem = 1
            true
        }
        R.id.menuC -> {
            binding.viewPager.currentItem = 2
            true
        }
        else -> {
            false
        }
    }
}
binding.viewPager.registerOnPageChangeCallback(
    object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            binding.bottomNavigation.menu.getItem(position).isChecked = true
        }
    }
)
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
