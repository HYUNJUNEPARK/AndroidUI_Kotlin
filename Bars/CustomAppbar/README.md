# CustomAppBar

<img src="https://github.com/HYUNJUNEPARK/ImageRepository/blob/master/androidUI/CustomAppBar.jpg" height="400"/>

---
1. <a href = "#content1">CoordinatorLayout</a></br>
2. <a href = "#content2">CollapsingToolbarLayout</a></br>
* <a href = "#ref">참고링크</a>
---
><a id = "content1">**1. CoordinatorLayout**</a></br>


-뷰끼리 상호작용을 해야하는 경우 많이 사용됨(리사이클러뷰와 앱바 레이아웃 연동이 대표적 사례)</br>
-뷰끼리 상호작용을 하기위해서는 behavior 를 구현해야하며 behavior 가 사용자 스크롤 데이터를 받고 코디네이터 레이아웃에 정보를 전달함</br>
`app:layout_behavior="@string/appbar_scrolling_view_behavior"`</br>
-텍스트뷰, 이미지뷰 등은 스크롤 연동할 수 없음 -> NestedScrollView 의 하위뷰로 텍스트뷰, 이미지뷰를 넣음</br>
<br></br>
`app:layout_behavior="@string/appbar_scrolling_view_behavior"`</br>
-`app:layout_behavior` : 자신의 스크롤 정보를 어느 behavior 클래스가 받아서 처리해야하는지를 의미</br>
-`@string/appbar_scrolling_view_behavior` : ScrollingViewBehavior 를 의미</br>
-코디네이터 레아이웃이 NestedScrollView 의 스크롤 정보를 앱바 레이아웃의 ScrollingViewBehavior 클래스에 전달</br>
-NestedScrollView, RecyclerView 속성값으로 사용됨</br>
<br></br>
`app:layout_scrollFlags="scroll|enterAlways"`</br>
-app:layout_scrollFlags 속성이 설정된 뷰가 스크롤 정보를 수신해서 함께 스크롤 됨</br>
-AppBarLayout 하위 레이아아웃, 뷰의 속성값으로 사용됨</br>
<br></br>
->`app:layout_behavior` 속성이 있는 뷰가 스크롤 -> `app:layout_scrollFlags` 속성이 있는 레이아웃, 뷰가 반응</br>


```
<androidx.coordinatorlayout.widget.CoordinatorLayout ...>

    <com.google.android.material.appbar.AppBarLayout ...>
        <androidx.appcompat.widget.Toolbar ...
            app:layout_scrollFlags="scroll|enterAlways"/>
        <ImageView ...
            app:layout_scrollFlags="scroll|enterAlways"/>
    </com.google.android.material.appbar.AppBarLayout>

    <androidx.core.widget.NestedScrollView ...
        app:layout_behavior="@string/appbar_scrolling_view_behavior">
        <TextView .../>
    </androidx.core.widget.NestedScrollView>

</androidx.coordinatorlayout.widget.CoordinatorLayout>
```

<br></br>
<br></br>

><a id = "content2">**2. CollapsingToolbarLayout**</a></br>


-앱바 레이아웃 하위에 선언해 앱바가 접힐 때 다양한 설정(ex. 앱바가 접힐 때 표시할 제목이나 색상 설정 등)을 할 수 있는 뷰</br>
-앱바 레이아웃에 여러 개의 뷰를 추가했다면 개별뷰에 `app:layout_scrollFlags` 지정하는 것은 비효율적임</br>
-`expandedTitleMarginStart`, `expandedTitleMarginBottom` : 앱바가 접히지 않았을 때 제목의 위치 설정</br>
-`contentScrim` : 앱바가 접히면서 내용이 정상적으로 출력되지 못하는 상황이면 지정한 색으로 앱바를 출력</br>
<br></br>
app:layout_scrollFlags 속성 : 스크롤 설정</br>
-`scroll|enterAlways` : 스크롤이 완전히 사라졌다가 거꾸로 스크롤 시 처음부터 다시 나타남</br>
-`scroll|exitUntilCollapsed` : 스크롤 시 모두 사라지지 않고 툴바를 출력할 정도의 한 줄만 남을 때까지 스크롤됨</br>
-`scroll|enterAlwaysCollapsed` : 스크롤 시 완전히 사라졌다가 거꾸로 스크롤 시 exitUntilCollapsed 상태를 거친 후 메인 콘텐츠 부분이 생성</br>
<br></br>
app:layout_collapseMode 속성 : 개별 뷰 스크롤 설정</br>
-`parallax` : 함께 스크롤됨</br>
-`pin` : 고정되어 스크롤되지 않음</br>

```
<androidx.coordinatorlayout.widget.CoordinatorLayout ...>

    <com.google.android.material.appbar.AppBarLayout...>
        <com.google.android.material.appbar.CollapsingToolbarLayout
            app:layout_scrollFlags="scroll|exitUntilCollapsed"...>
            <ImageView
                app:layout_collapseMode="parallax"
                app:layout_scrollFlags="scroll|enterAlways"... />
            <androidx.appcompat.widget.Toolbar
                app:layout_collapseMode="pin" ... />
        </com.google.android.material.appbar.CollapsingToolbarLayout>
    </com.google.android.material.appbar.AppBarLayout>

    <androidx.core.widget.NestedScrollView
        app:layout_behavior="@string/appbar_scrolling_view_behavior"...>
        <TextView .../>
    </androidx.core.widget.NestedScrollView>

</androidx.coordinatorlayout.widget.CoordinatorLayout>
```

<br></br>
<br></br>

---

><a id = "ref">**참고링크**</a></br>
