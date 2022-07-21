Web Server란?
===

![image](https://user-images.githubusercontent.com/53562331/180244989-3605490b-cf15-45d9-930a-48a7fe7b9686.png)


> 웹 브라우저(클라이언트)로부터 HTTP요청을 받아 HTML문서(또는 image,css,javascript)와 같은 **정적 컨텐츠**를 제공하는 프로그램

Web Server의 기능
---
- 클라이언트로부터 HTTP요청을 받을 수 있다.
- 정적 컨텐츠 요청 시 : 정적 컨텐츠(html, jpeg, css..)를 제공할 수 있다.
- 동적 컨텐츠 요청 시 : WAS(Web Application Server)로 전달하여 WAS 가 처리한 결과를 클라이언트에 전달


WAS(Web Application Server)란?
===
![image](https://user-images.githubusercontent.com/53562331/180245748-6bf5b546-06e9-42d4-a209-bcc6f199c3cf.png)

> DB조회나 다양한 로직 처리를 요구하는 **동적인 컨텐츠**를 제공하기 위해 만들어진 프로그램



WAS의 기능
---
![image](https://user-images.githubusercontent.com/53562331/180246673-cfc9cbf5-3959-4d79-8783-4f748ebcac81.png)

- 클라이언트로부터 HTTP요청을 받을 수 있다.(대부분 WAS는 Web Server내장)
- 요청에 맞는 정적 컨텐츠(html, jpeg, css..)를 제공할 수 있다.

<br>

WAS가 다 해줄 수 있는데 굳이 Web Server가 왜 필요한가?
===

**Web Server를 같이 사용했을 때의 장점**

> 1. **책임 분할**을 통한 서버 부하 방지<br>
> → 정적 컨텐츠는 Web Server, 동적 컨텐츠는 WAS가 담당


> 2. 여러대의 WAS **로드밸런싱**<br>
> → WAS가 처리해야 하는 요청을 여러 WAS가 나누어서 처리할 수 있도록 설정


> 3. 여러대의 WAS **Health check**<br>
> → 서버에 주기적으로 HTTP요청을 보내 서버의 상채를 확인(ex, 특정 url요청에 200응답이 오는지..)

> 4. 보안<br>
> → **리버스 프록시**를 통해 실제 서버를 외부에 노출하지 않을 수 있다.
