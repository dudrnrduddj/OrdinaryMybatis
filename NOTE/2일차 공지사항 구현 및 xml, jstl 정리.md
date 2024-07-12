## 💥 mapper.xml - #{ } 의 접근 💥

xml 파일에선 sessionScope에 접근 불가능   
오직 전달받은 객체의 필드에 접근하는 것!!   
**따라서 property의 값을 반드시 넣고자 하는 필드명과 일치시켜야 한다!!**

만약 session에 있는 데이터를 활용하고 싶다면 mapper.xml에 전달할 객체의 필드에 저장해서 전달해주자   

ex)   
```
HttpSession session = request.getSession();
String noticeWriter = session.getAttribute("memberName");

Notice notice = new Notice();
notice.setNoticeWriter("memberName");

// DAO 클래스에서 
conn.insert("NoticeMapper.insertNotice", notice);
```

**-> 로그인 이름이 들어있는 notice객체를 xml에 전달해줌**   
**-> #{noticeWriter} 로 접근해줌!**

---------------------------------------------

## 💥 jstl foreach문 💥
### 서블릿에서 전달한 property인 noticeList 목록을 jsp에서 모두 출력시키기 위해 반복문을 써야 한다.

 *상단에 taglib 적기*   
```
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```
   
```
<c:forEach items="${nList}" var="notice">
    <tr>
        <td>${notice.noticeNo}</td>
        <td>${notice.subject }</td>
        <td>${notice.writer }</td>
        <td>${notice.regDate }</td>
        <td>${notice.viewCount }</td>
    </tr>
</c:forEach>
```   
 - items : 반복할 컬렉션, 배열, 맵, 또는 기타 반복 가능한 객체를 지정한다. (여기선 nList객체를 지정)
 - var : 반복문 내에서 사용할 변수 이름을 지정한다.   
   
*-> notice.fieldName 으로 받아온 객체의 필드에 접근할 수 있게 된다.*
