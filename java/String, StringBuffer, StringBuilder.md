String
---
특징
> - 문자열 연산시 새로 객체를 만드는 Overhead발생
> - Garbage Collector로 제거되어야 함
> - 객체가 불변하므로, MultiThread에서 동기화를 신경 쓸 필요가 없음(조회 연산에 매우 큰 장점)


StringBuffer,StringBuilder
---
공통점
> - 버퍼(buffer:데이터를 임시로 저장하는 메모리)에 문자열을 저장
> - 버퍼 내부에서 추가, 수정, 삭제 작업을 할 수 있음  
> - 문자열 연산시 새로 객체를 만들지 않고, 크기를 변경시킴
> - StringBuffer와 StringBuilder 클래스의 메서드가 동일함



차이점
> - 멀티 스레드환경 : StringBuffer 사용(동기화 가능)
> - 단일 스레드환경 : String Builder 사용(동기화 불가능)


----

| 분류   | String    | StringBuffer                    | StringBuilder        |
| ------ | --------- | ------------------------------- | -------------------- |
| 변경   | Immutable | Mutable                         | Mutable              |
| 동기화 |           | Synchronized 가능 (Thread-safe) | Synchronized 불가능. |
