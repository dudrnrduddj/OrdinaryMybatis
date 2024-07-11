기존의 jdbcTemplate -> sqlSessionTemplate으로 교체
sqlSessionTemplate에서 SqlSession 객체를 생성!!

### 💥dtd💥
```
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
 ```
 : 자동완성 가능
 
 DTD는 Document Type Definition의 약자로, XML 문서의 구조를 정의하는 데 사용됩니다. 
 DTD는 XML 문서 내에 어떤 요소들이 포함될 수 있으며, 각 요소가 어떻게 구성되는지를 정의합니다. 
 이를 통해 XML 문서가 올바른 구조를 가지도록 유효성을 검사할 수 있습니다.
 
 dtd 없어도 파일 자체엔 문제가 없지만 dtd가 있어야 만들때 올바른 구조를 가지도록 참고할 수 있음.
 
 config.xml ->  !DOCTYPE configuration ... config.dtd
 mapper.xml ->  !DOCTYPE mapper ... mapper.dtd
 
 
 **문서에 맞는 dtd를 써주도록 하자**💥💥
 
 ------------------------------------
 ## 💥Mybatis
 
 ### 💥Mybatis 라이브러리 다운 및 연동
 
 아래의 링크에 접속하여 Mybatis.3.4.5 버전을 다운로드 한다.
 
 https://github.com/mybatis/mybatis-3/releases
 
 다운로드가 완료되면 압축을 해제하고 **mybatis-3.4.5.jar** 라이브러리를 프로젝트 
 내 WEB-INF/lib/ 경로 안에 추가한다.
 
 
 ### 💥Mybatis-config 설정하기
 
 mybatis-config.xml 생성 위치 : resources/mybtis-config.xml
 
 ```
  <?xml version="1.0" encoding="utf-8"?>
 ```
  : 먼저 xml 파일 최상단에 다음과 같이 xml 형식을 지정하여 이하의 설정내용이 mybatis 설정임을 
    선언한다.

 
 ```
 <!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
 ```
 : dtd 설정

 ### 💥config.xml의 태그들
 configuration 태그
  :  MyBatis 프레임워크가 데이터베이스와의 연동을 어떻게 설정하고 동작할지를 정의하는데 사용된다. 여기서 configuration 태그는 전체 설정의 시작을 나타내며, 다양한 중요한 설정 항목들을 포함할 수 있다.

 environments 태그
  :  mybatis 에서 연동할 Database 정보를 등록한다.
  
transactionManager 태그 
  : MyBatis에서 사용할 트랜잭션 관리자의 유형을 지정합니다.

dataSource 태그
  : MyBatis에서 사용할 데이터 소스의 유형을 지정합니다. 
   
  Database 연결을 관리하는 DataSource의타입은 크게 POOLED와 UNPOOLED로 나눌 
  수 있는데 그 차이는 다음과 같다
   
  -POOLED : 최초 Connection 객체를 생성 시해당 정보를 pool 영역에 저장해 두고 이후 Connection 객체를 생성할 때 이를 재 사용한다.
  -UNPOOLED :  Connection 객체를 별도로 저장하지 않고, 객체 호출 시 매번 생성하여 사용한다.
   
	property 태그
	 : <property name="속성이름" value="속성의 값"/>
	 
	 name은 반드시!! 
	 MyBatis나 다른 프레임워크에서 제공하는 문서에서 명시된 속성 이름에 따라 설정해야 한다.
	 
	 
	mappers> 태그
	 : 사용하고자 하는 쿼리가 정의된 mapper 파일을 등록한다.
	
예시)	
```
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">

 <configuration>
 	<environments default="development">
 		<environment id="development">
			<transactionManager type="JDBC" /> 
 			<dataSource type="POOLED">
 				<property name="driver" value="oracle.jdbc.driver.OracleDriver"/>
 				<property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"/>
 				<property name="username" value="ORDINARYJDBC"/>
 				<property name="password" value="ORDINARYJDBC"/>
 			</dataSource>
 		</environment>
 	</environments>
 	<mappers>
 		<mapper resource="mapper/member-mapper.xml"/>
 	</mappers>
 </configuration>
```

### 💥Mapper
mapper.xml
 : mapper.xml은 사용하고자 하는 쿼리나 결과로 받을 객체를 선언할 수 있다 
 
 1. 먼저 xml 파일 최상단에 다음과 같이 xml 형식을 지정하여 이하의 설정내용은 mybatis mapper 설정임을 선언한다
 ```
  <?xml version="1.0" encoding="utf-8"?>
 ```
2. dtd 설정
``` 
  <!DOCTYPE mapper PUBLIC
 "-//mybatis.org//DTD Mapper 3.0//EN"
 "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
``` 
 
 3. 이어서 mapper 태그를 작성하고, 외부에서 접근할 수 있는 이름인 namespace 속성을 기입한다. 이제 이 후 작성될 태그들은 mapper 태그 안에 기록하면 된다.
 ```
 <mapper namespace="MemberMapper">
 </mapper>
```
### 💥mapper.xml의 태그들
 resultMap 태그
  : 조회한 결과를 객체와 Row간의 1:1 매칭이 아닌, 원하는 객체의 필드에 담아 반환하고자 할 때 사용한다.
   -> 자바객체로 매핑하여 반환
   (* resultMap의 type 속성은 실제로 구현해 놓은 자바 POJO 객체를 사용해야 하며, Mybatis config.xml에서 typeAlias를 지정하지 않은 경우, 패키지 명부터 클래스 명까지 모두 기술해야 한다.*)
   
  ```
  <resultMap type="com.ordinary.member.model.vo.Member" id="memberResultMap">
		<id property="memberId" column="MEMBER_ID"/>
		<result property="memberPw" column="MEMBER_PW"/>
		<result property="memberName" column="MEMBER_NAME"/>
  </resultMap>
 ```		
 #### 💥reusltMap 태그 안의 요소들
 id 태그 
  : 자바 객체(Member 클래스)의 필드명을 지정한다. 이 필드에 데이터베이스의 기본 키 값이 매핑된다.
 
 result 태그
  : 데이터베이스 테이블의 열(column)과 자바 객체의 필드(property) 간의 매핑을 정의할 때 사용된다.
  
#### 💥쿼리문 태그
  select, insert 태그
  
  insert 태그
  ```
  <insert id="insertMember">
    INSERT INTO MEMBER_TBL VALUES(#{memberId},#{memberPw},#{memberName},#{memberGender},
    #{memberAge},#{memberEmail},#{memberPhone},#{memberAddress},#{memberHobby}, DEFAULT)
  </insert>
  ```

  -> insertMember라는 id를 가진 sql문
  -> #{}문법을 사용하여 MyBatis의 파라미터 매핑 기능을 이용하여 자바 객체의 필드 값을 SQL문에 바인딩함.

  
  select 태그
  
  ```
  <select id="checkLogin" resultMap="memberResultMap">
    SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = #{memberId} AND MEMBER_PW = #{memberPw}
  </select>
  ```

  -> checkLogin이라는 id를 가진 SQL문
  -> 쿼리 결과를 자바 객체로 매핑하기 위해 사용할 resultMap의 ID를 지정함. 지정한 memberResultMap은 resultMap 태그를 사용하여 미리 직접 정의한 매핑 설정.
	
	
	
## 💥Mybatis 활용하기

 1. MyBatis 설정 파일을 읽어와 SqlSessionFactory를 생성할 준비를 한다.
 ```
 String resource = "mybatis-config.xml";  // 미리 설정한 config.xml
 InputStream is = Resources.getResourceAsStream(resource);
 ```
 
 2. SqlSessionFactory를 만들기 위한 빌더 객체를 초기화한다.
 ```
 SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
 ```

 3. MyBatis 설정 파일을 기반으로 SQL 세션을 생성할 수 있는 SqlSessionFactory 객체를 생성한다.
 ```
 SqlSessionFactory sessionFactory = builder.build(is);
 ```
 
 4. 자동 커밋 모드로 설정된 새로운 SQL 세션을 생성하여, SQL 작업을 수행할 준비를 한다.
 ```
 session = sessionFactory.openSession(true);
 // true : 자동 커밋 모드
 // false : 수동 커밋 모드
 ```
 
 
 ## 💥생성한 SqlSessionTemplate 활용하기💥
 
 미리 정의한 getSqlSession()를 이용하여 conn변수에 SqlSession객체를 초기화해준다.
 ex)
 ```
 public MemberService() {
	this.conn = SqlSessionTemplate.getSqlSession();
	this.mDao = new MemberDAO();
 }
 // mDao.insertMember(conn, member)에 conn, member 전달
 ```

 MemberDAO에서 각 메소드에 따라 SqlSession의 메소드를 사용하고 미리 만든 mapper.xml의 쿼리와 전달할 객체를 지정해준다.
 
 ex)
 ```
 public int insertMember(SqlSession conn, Member member) {
	int result = conn.insert("MemberMapper.insertMember", member);
			
	return result;
 } 
```
 -> MemberMapper는 mapper.xml의 mapper태그의 namespace 값
 -> insertMember는 insert태그의 id 값
 
