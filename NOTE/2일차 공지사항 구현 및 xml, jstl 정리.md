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

------------------------

## 💥 webapp 아래의 .jsp 파일과 a태그의 바인딩 💥
### ❓ 만약 회원가입 서블릿의 doGet (회원가입 화면을 띄우는 로직), doPost ( insert 로직 )을  하나의 서블릿에서 관리하고 싶지 않을 때 생긴 의문
 - 그럼 a태그를 통한 링크주소를 jsp파일로 지정해서 doGet로직을 구현할 필요없이 브라우저창에 띄우면 되지않을까?   
 **-> a태그의 주소로 register.jsp를 적어주어 회원가입서블릿의 doGet메소드를 지워줄 수 있었다.**   
### 단, 실제로는 index.jsp와 같은 메인페이지를 제외한 jsp파일들은 WEB-INF에서 관리되고 이 디렉토리의 하위 파일들은 a나 주소창을 통해 직접 접근 불가하기 때문에 a태그에 서블릿 주소를 적어주고 해당 서블릿의 doGet메소드를 이용해 request의 forward를 사용했던 것이다.





