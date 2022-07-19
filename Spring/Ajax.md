Ajax란?
===
Ajax는 Javascript의 라이브러리중 하나이며 Asynchronuous Javascript And Xml(비동기식 자바스트립트와 xml)의 약자
브라우저가 가지고있는 XMLHttpRequest 객체를 이용해서 전체 페이지를 새로 고치치 않고도 페이지의 일부만을 위한 데이터를 로드하는 기법

> 비공기 통신, 클라이언트와 서버간에 XML데이터를 주고받는 기술



비동기 방식
---
> 웹페이지를 리로드하지 않고 데이터를 불러오는 방식

페이지를 리로드할 경우 전체 리소스를 다시 불러와야 하는데 이미지, 스크립트, 기타 코드등 모두 재요청할 경우 불필요한 
리소스 낭비가 발생하게 되지만 비동기식 방식을 이용할 경우 필요한 부분만 불러와 사용할 수 있다는 장점이 있다.



Ajax 장단점
===


장점
---
1. 웹페이지의 속도 향상
2. 서버의 처리가 완료 될때까지 기다리지 않고 처리 가능
3. 서버에서 Data만 전송하면 되므로 전체적인 코드양 줄어듦
4. 기존 웸에서 불가능했던 다양한 UI를 가능하게 해줌




단점
---
1. 히스토리 관리가 안 된다.
2. 연속으로 데이터를 요청하면 서버 부하가 증가할 수 있다.
3. XMLHttpRequest를 통해 통신을 하는 경우 사용자에게 아무런 진행 정보가 주어지지 않는다. 그래서 아직 요청이 완료되지 않았는데 사용자가 페이지를 떠나거나 오작동할 우려가 발생한다.