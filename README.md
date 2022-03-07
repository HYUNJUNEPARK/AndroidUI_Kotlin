# RecyclerView

<img src="이미지 주소" height="400"/>

---
1. <a href = "#content1">ViewHolder</a></br>
2. <a href = "#content2">Adapter</a></br>
3. <a href = "#content3">레이아웃 매니저</a></br>
3. <a href = "#content4">리사이클러뷰 초기화</a></br>
* <a href = "#ref">참고링크</a>
---

ViewHolder : 이미지뷰, 텍스트뷰 등 각 항목을 구성하는 뷰 객체를 가짐</br>
Adapter : 뷰 홀더에 있는 객체에 적잘한 데이터를 대입해 항목을 완성</br>
LayoutManager : 어댑터가 만든 항목들을 어덯게 배치할지 결정해 리사이클러 뷰에 출력</br>
ItemDecoration(선택) : 항목을 꾸밈</br>

`implementation 'com.google.android.material:material:1.5.0'` 머티리얼 디자인 라이브러리에 recyclerview 가 있음</br>

><a id = "content1">**ViewHolder**</a></br>

-RecyclerView.ViewHolder 를 상속받아 작성 `RecyclerView.ViewHolder(binding.root)`</br>
-onBindViewHolder() 로 부터 position 에 해당하는 개별 객체를 받아 UI 를 구성하는  ex. setData(data: Data)</br>
-클래스 앞에 inner 를 붙여 Adapter 내부에 작성할 수 있음</br>

```kotlin
inner class MyHolder(private val binding: ItemMainRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context,"클릭된 아이템=${binding.textTitle.text}", Toast.LENGTH_LONG).show()
        }
    }
    fun setData (data: Data) {
        binding.textNo.text = "${data.no}"
        binding.textTitle.text = data.title
        var sdf = SimpleDateFormat("yyyy/MM/dd")
        var formattedDate = sdf.format(data.timestamp)
        binding.textDate.text = formattedDate
    }
}
```

<br></br>
<br></br>

><a id = "content2">**2. Adapter**</a></br>

-RecyclerView.Adapter 를 상속받아 작성 `class MainAdapter : RecyclerView.Adapter<MainAdapter.MyHolder>()`</br>

(a) **getItemCount()** : 항목 개수를 판단하려고 자동으로 호출</br>

```kotlin
override fun getItemCount(): Int {
    return listData.size
}
```

(b) **onCreateViewHolder** : 항목의 뷰를 가지는 뷰 홀더를 준비하려고 자동호출</br>
-binding 을 초기화한 후 뷰홀더의 파라미터로 전달한 후 뷰홀더를 리턴</br>

```kotlin
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
    val binding = ItemMainRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return MyHolder(binding)
}
```

(c) **onBindViewHolder** : 뷰 홀더의 뷰에 데이터를 출력하려고 자동으로 호출</br>
-인덱스 정보(position)을 파라미터로 전달 받음</br>
-파라미터로 전달된 뷰홀더 객체의 뷰에 데이터를 출력하거나 필요한 이벤트를 등록</br>

```kotlin
override fun onBindViewHolder(myHolder: MyHolder, position: Int) {
    val data = listData[position]
    myHolder.setData(data)
}
```

<br></br>
<br></br>

><a id = "content3">**3. 레이아웃 매니저**</a></br>

(a) LinearLayoutManager : 항목을 가로나 세로 방향으로 배치</br>
-방향을 설정하지 않으면 세로가 기본으로 적용됨</br>

```kotlin
//가로방향 배치
val layoutManager = LinearLayoutManager(this)
binding.recyclerView.layoutManager = layoutManager

//세로방향 배치
val layoutManager = LinearLayoutManager(this)
layoutManager.orientation = LinearLayoutManager.HORIZONTAL
binding.recyclerView.layoutManager = layoutManager
```

(b) GridLayoutManager : 항목을 그리드로 배치</br>
-세로 열이 기본 설정</br>
-세번째 파라미터로 Boolean 이 오는 데, true 라면 세로 배치일 때 뷰가 아래부터 배치되고 가로배치일 때 오른쪽 부터 배치됨</br>

```kotlin
//2열 세로 배치
val layoutManager = GridLayoutManager(this, /*column*/2)
binding.recyclerView.layoutManager = layoutManager

//3행 가로 배치
val layoutManager = GridLayoutManager(this, /*row*/3, GridLayoutManager.HORIZONTAL, false)
binding.recyclerView.layoutManager = layoutManager
```

(c) StaggeredGridLayoutManager : 항목을 높이가 불규칙한 그리드로 배치</br>
-그리드 구조로 뷰를 배치하지만 뷰의 크기가 다르면 지그재그 형태로 배치</br>

```kotlin
val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
binding.recyclerView.layoutManager = layoutManager
```

<br></br>
<br></br>

><a id = "content1">**4. 리사이클러뷰 초기화**</a></br>

```kotlin
//adapter
val adapter = MainAdapter()
adapter.listData = loadData()
binding.recyclerView.adapter = adapter

//레이아웃 매니저
val layoutManager = LinearLayoutManager(this)
layoutManager.orientation = LinearLayoutManager.HORIZONTAL
binding.recyclerView.layoutManager = layoutManager
```

<br></br>
<br></br>
---

><a id = "ref">**참고링크**</a></br>
</br>
</br>



