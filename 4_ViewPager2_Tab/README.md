# ViewPager2_Tab

<img src="https://github.com/HYUNJUNEPARK/ImageRepository/blob/master/androidUI/ViewPager2_Tab.jpg" height="400"/>

---
1. <a href = "#content1">FragmentAdapter</a></br>
2. <a href = "#content2">TabLayoutMediator</a></br>
* <a href = "#ref">참고링크</a>
---
><a id = "content1">**1. FragmentAdapter**</a></br>


-프레그먼트 리스트를 갖고있으며 프레그먼트와 액티비티를 연결</br>
-FragmentStateAdapter(fragmentActivity)를 상속받아 getItemCount, createFragment 오버라이딩</br>
`class FragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity)`</br>

```kotlin
//FragmentAdapter
class FragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    var fragmentList = listOf<Fragment>()

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}

//MainActivity
private fun initFragment() {
    val fragmentList = listOf(AFragment(), BFragment(), CFragment())
    val adapter = FragmentAdapter(this)
    adapter.fragmentList = fragmentList
    binding.viewPager.adapter = adapter
}
```

<br></br>
<br></br>

><a id = "content2">**2. TabLayoutMediator**</a></br>

-tabLayout 과 viewPager2 를 연결</br>

```kotlin
private fun initTab() {
    TabLayoutMediator(binding.tabLayout, binding.viewPager) { /*tab*/_, /*position*/_ ->
    }.attach()
    binding.tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_person_vector)
    binding.tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_star_vector)
    binding.tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_clock_vector)
}
```


<br></br>
<br></br>


---

><a id = "ref">**참고링크**</a></br>
