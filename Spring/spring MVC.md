Spring MVC
===

MVC패턴은 디자인 패턴 중 하나이다.

> 디자인패턴 : 프로그램 개발하는 중에 발생하는 문제점들을 정리하여 상황에 따라 간편하게 적용해서 쓸 수 있도록 정리하여 특정 규약(규칙)을 통해 사용하도록 만든 것

MVC패턴
---
Model, View, Controller의 앞 글자를 따서 지음

> Model : 데이터 가공을 담당
> 데이터베이스, 처음 정의하는 상수, 변수 등을 뜻하며 비지니스 로직을 처리한 후 모델의 변경사항을 컨트롤러나 뷰에 전달하는 역할


> View : 사용자에게 보여주는 부분
> 데이터를 화면에 표시하는 역할

> Controller : 모델과 뷰 사이를 이어주는 역할


MVC패턴을 사용하는 이유?
---
> 유지보수의 편리성

기능간의 결합도를 낮추어 수정 시 최소한의 수정으로 오류를 낮추기 위함


Spring의 MVC 처리 순서
---
<img width="534" alt="image" src="https://user-images.githubusercontent.com/53562331/179902645-61075ce3-c2c0-4e76-bd87-5a48d879df78.png">

1. Client요청이 DispatcherServlet에게 전달
2. DispatcherServlet은 HandlerMapping을 사용해서 Client요청을 처리할 Controller 객체를 추출
3. Controller에서 model을 사용해서 Client의 요청을 처리
4. Controller는 처리결과 data를 Model(AndView)에 담아서 return
5. DispatcherServlet은 ViewResolver를 통해 request에 해당하는 view파일 탐색 후 받아냄
6. 완성된 View파일을 Client에 response하여 화면에 출력



구성요소
---
Dispatcher Servlet
> 모든 request를 처리하는 중심 컨트롤러, 서블릿 컨테이너에서 http프로토콜을 통해 들어오는 모든 request에 대해 제일 앞단에서 중앙집중식으로 처리해주는 핵심적인 역할을 함

> 기존에는 web.xml에 모두 등록해줘야 했지만, Dispatcher Servlet이 모든 reqeust를 핸들링하면서 작업이 편리해짐

Handler Mapping
> 클라이언트의 request url을 어떤 컨트롤러가 처리해야 할 지 찾아서 Dispatcher Servlet에게 전달해주는 역할

> 컨트롤러 작성할 때 url을 매핑시키기 위해 @RequestMapping을 사용하는데, 핸들러가 이를 찾아주는 역할

View Resolver
> 컨트롤러의 처리 결과를 만들 view를 결정해주는 
