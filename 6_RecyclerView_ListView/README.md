# RecyclerView_ListAdapter


---
1. <a href = "#content1">ListAdapter</a></br>
* <a href = "#ref">참고링크</a>
---

<br></br>
<br></br>

><a id = "content1">**1. ListAdapter**</a></br>

-DiffUtil 을 활용해서 리스트를 업데이트 할 수 있는 기능을 추가한 Adapter</br>
-List 데이터를 표현해주며 List 를 백그라운드 스레드에서 diff(차이)를 처리하는 특징이 있다.</br>
-RecyclerViewAdapter 와 다르게 getItemCount() 구현안해도 됨</br>
-어댑터 내에서 리스트를 정의하는게 아니라 리스트 자체에서 데이터 리스트를 정의하기 때문에 ListAdapter<데이터클래스, 리사이클러뷰 뷰홀더>를 인자로 받는다.
`ListAdapter<BookDetailDto, BookAdapter.BookItemViewHolder>(diffUtil)`</br>

-`getCurrentList()` : 현재 리스트를 반환한다.</br>
-`onCurrentListChanged()` : 리스트가 업데이트 되었을 때 실행할 콜백을 지정할 수 있다.</br>
-`submitList(List)` : 리스트 데이터를 교체할 때 사용한다.</br>


<br></br>
1)**DiffUtil**</br>
-리사이클러뷰가 실제로 뷰 포지션이 변경되었을 때 새로운 값을 할당할지 말지 결정하는 기준</br>
-같은 아이템이 올라오면 다시 할당할 필요가 없다 이런걸 판단해 주는게 diffUtil</br>
-기존 리스트와 업데이트 된 리스트의 차이를 계산하고 실제로 변환할 리스트 아이템들의 결과를 반환하는 유틸리티 클래스</br>
-RecyclerView Adpater 의 업데이트를 계산하는데 사용되고 ListAdapter 에서 DiffUtil 을 활용해서 차이점을 계산</br>
```kotlin
companion object {
    val diffUtil = object : DiffUtil.ItemCallback<MyData>() {
        override fun areItemsTheSame(oldItem: MyData, newItem: MyData): Boolean {
            return oldItem.number == newItem.number
        }
        override fun areContentsTheSame(oldItem: MyData, newItem: MyData): Boolean {
            return oldItem == newItem
        }
    }
}
```

<br></br>
2)**onCreateViewHolder**</br>
-아이템 레이아웃을 바인딩한 후 '뷰홀더' 에 넘겨줌</br>
```kotlin
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(binding)
}
```

<br></br>
3)**onBindViewHolder**</br>
`onBindViewHolder(holder: ViewHolder, position: Int)`</br>
-ListAdapter 의 데이터는 currentList 에 미리 저장되 어 있음</br>
-데이터 인덱스 파라미터(position)를 갖고 있 ViewHolder 클래스 내부 함수(fun bind)에 currentList[position] 전달해줘 개별 데이터를 보여줌</br>
```kotlin
override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    holder.bind(currentList[position])
}
```

<br></br>
4)**ViewHolder**</br>
-바인딩 객체를 파라미터로 받아고 ui 객체를 가져와 개별 데이터를 바인딩</br>
-목록에서 아이템 하나가 클릭외었을 때 홀더가 갖고 있는 아이템 바인딩에 클릭 리스너를 달아 처리</br>
-ui 작업이 필요한 함수(fun bind)는 holder 에 작성하고 onBindViewHolder 에서 호출해 사용</br>
```kotlin
inner class MyViewHolder(private val binding: ItemMainRecyclerviewBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(data: MyData) {
        binding.textNo.text = data.number.toString()
        binding.textTitle.text = data.title
        var sdf = SimpleDateFormat("yyyy/MM/dd")
        var formattedDate = sdf.format(data.timestamp)
        binding.textDate.text = formattedDate

        binding.root.setOnClickListener {
            itemClickedListener(data)
        }
    }
}
```


<br></br>
<br></br>

---

><a id = "ref">**참고링크**</a></br>