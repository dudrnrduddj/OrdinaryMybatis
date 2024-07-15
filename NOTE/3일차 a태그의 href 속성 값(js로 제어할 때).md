# 💥a태그의 클릭 이벤트 설정 시 href 속성값 설정💥

**a 태그에서 onclick 이벤트로 페이지를 이동할땐 href 값으로 아무런 페이지이동이 일어나지 않도록 해야한다.**    
**href="javascript:void(0)"으로 해주어 아무런 동작이 일어나지 않음을 설정해줘야 한다.**

 - ex)
```
<a href="javascript:void(0)" onclick="checkDelete();">삭제하기</a>

<script type="text/javascript">
  function checkDelete(){
    if(confirm("정말 삭제하시겠습니까?")){
      location.href = "/notice/delete.kh?noticeNo=${notice.noticeNo }";
    }
  }
</script>
```
