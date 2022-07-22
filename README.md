# AndroidUI_Kotlin
___

**1_AppBar**</br>
ActionBar / ToolBar / CustomAppBar[CoordinatorLayout / CollapsingToolbarLayout]</br>

**2_DrawerLayout**</br>


**3_ViewPager2_BottomNavigation(DataBinding)**</br>


**4_ViewPager2_Tab(DataBinding)**</br>


**5_RecyclerView_Adapter**</br>


**6_RecyclerView_ListView**</br>


**7_BottomNavigation**</br>
replace ver : supportFragmentManager.beginTransaction().replace() 사용</br>
-> 바텀 네비게이션 아이템이 바뀔 때마다 프래그먼트를 새로 그려줌.</br>
-> 콜백 요청이 있는 곳에서 아이템을 빠르게 바꾸면 앱이 죽는 문제가 있음</br>
add ver : supportFragmentManager.beginTransaction().add() 사용</br>
-> replace ver 의 문제점이 해결됨</br>
-> 바텀 네비게이션 아이템이 변해도 프래그먼트를 파괴하지 않고 show/hide 로 뷰를 제공</br>
<br></br>

---
