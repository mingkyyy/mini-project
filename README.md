
# subway food order

## 개발 환경
* JDK 11
* IDE : Eclipse
* Database : MariaDB 10.5

## 프로젝트 소개
 * 회원가입과 로그인을 하여 역 이름을 검색하면 역 주변 반찬 가게 에서 주문, 가게 등록을 할 수 있다.

## 주요 기능

 #### 회원가입
GUI에 구현된 회원가입 양식에 쓴 text가 데이터베이스에 저장됨


<img src="https://user-images.githubusercontent.com/54256348/122498432-11c10b80-d02a-11eb-9ed1-d0712f3df8ed.PNG" width="50%" height="50%">


#### 로그인
로그인시 데이터베이스에있는 아이디 비밀번호가 일치하는 확인 함, 회원정보 수정, 탈퇴가 가능함


<img src="https://user-images.githubusercontent.com/54256348/122498543-4765f480-d02a-11eb-860b-4f14e4b4cdd9.PNG" width="50%" height="50%">


#### 검색, 추천 가게
textfild에 역을 검색 하면 크롬 브라우저를 통해 검색 한 역 지도가 띄어지고 Gui 화면에는 역 주변 가게 리스트들이 보인다. 

<img src="https://user-images.githubusercontent.com/54256348/122498623-68c6e080-d02a-11eb-8aa7-325d4f389da0.PNG" width="50%" height="50%">



#### 가게
Jtable 양식에 맞추어 음식 이름 - 가격 - 사진을 추가 할 수 있다. 음식 이름을 입력하면 이름,가격,사진 모두 수정 할 수 있으며 음식 한 행 자체를 삭제 할 수 있다.


<img src="https://user-images.githubusercontent.com/54256348/122498661-7b411a00-d02a-11eb-8b59-4a640c9d877d.PNG"  width="50%" height="50%">


#### 일반 회원 
 가게 메뉴를 클릭하면 '음식이름 - 가격'이 오른쪽 화면에 띄어진다. 클릭이 누적 될 수록 총 합계 금액도 같이 누적 되어 화면에 띄어지게 된다.
 '주문' 버튼을 누르면 회원 번호 - 음식 번호 - 주문시간이 저절로 db에 저장된다.
 
 <img src="https://user-images.githubusercontent.com/54256348/122498701-8dbb5380-d02a-11eb-997d-123e118b3eae.PNG" width="50%" height="50%" >

### 잘한 점
* 데이터베이스를 통해 로그인, 회원가입, 가게 추가, 주문 구현한 것.

### 힘들었던 점
 * Jtable에 imageicon을 띄었을때 이미지가 아닌 String 형태인 이미지의 주소로 띄어졌다. getColumnClass 를 만들어 열을 쪼개어 맞는 형으로 return 해주었더니 해결 되었다.
 * 데이터베이스나 다른 기능 메서드를 구글링에서 찾고 코드를 쓰고 원하는 대로 안되면 좀 힘들었다 특히 초반 mariaDB랑 연동하는게 잘 안 됐었다. 패널에 이미지 넣을 때도 힘들었었다.


### 부족한 점
* 시간 부족으로 인해 신촌역만 검색 할수 있게 하였는데 신촌역 뿐만 아니라 서울시 모든 역을 검색 하였을때 저절로 가게 리스트들이 나왔으면 한다.
* 가게 즐겨찾기 기능 구현 못하여 데이터베이스 완전히 활용 못한 것이 아쉽다.



### DB Table 설계

<img src ="https://user-images.githubusercontent.com/54256348/122430754-d2190600-cfce-11eb-90c0-d3773ad4c4c7.png" width="80%" height="80%">

### Javadoc 링크

### 시연 영상
<div>
   <a href="https://www.youtube.com/watch?v=f_TcB0HsC7c" target="_blank"><image src = "https://img.youtube.com/vi/f_TcB0HsC7c/mqdefault.jpg"></a>   
</div>

