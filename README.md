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
-어댑터 내에서 리스트를 정의하는게 아니라 리스트 자체에서 데이터 리스트를 정의하기 때문에 ListAdapter<데이터클래스, 리사이클러뷰 뷰홀더>를 인자로 받는다.</br>
`ListAdapter<BookDetailDto, BookAdapter.BookItemViewHolder>(diffUtil)`</br>


-`getCurrentList()` : 현재 리스트를 반환한다.</br>
-`onCurrentListChanged()` : 리스트가 업데이트 되었을 때 실행할 콜백을 지정할 수 있다.</br>
-`submitList(List)` : 리스트 데이터를 교체할 때 사용한다.</br>



<br></br>
<br></br>

---

><a id = "ref">**참고링크**</a></br>

