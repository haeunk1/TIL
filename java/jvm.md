자바 가상 머신 JVM(Java Virtual Machine)
===

요약
---
시스템 메모리를 관리하면서, 자바 기반 애플리케이션을 위해 이식 가능한 실행 환경을 제공함   


 <img width="520" alt="image" src="https://user-images.githubusercontent.com/53562331/177925954-9cc2d722-c84c-4f2d-a801-c579c420fee2.png"><br>
 JVM은 다른 프로그램을 실행시키는 것이 목적이다.<br>
 1. 자바 프로그램이 어느 기기나 운영체제 상에서도 실행될 수 있도록 하는 것<br>
 2. 프로그램 메모리를 관리하고 최적화하는 것<br>   

실행 과정
---

<img width="400" alt="image" src="https://user-images.githubusercontent.com/53562331/177927388-00ac17b4-e6a2-43de-b322-118d0482da27.png"><br>
1. 우리가 작성한 소스파일(.java)을 자바컴파일러가(javac) 클래스파일형태의 바이트코드(.class)로 변환<br>
2. 클래스로더가 JVM메모리 영역인 Runtime Data Area로 로딩시킴<br>
 - Method Area, Heap은 모든 스레드가 공유<br>
 - stack, PC Register, Natice Method Stack은 스레드가 생성될 때마다 생성<br>

Runtime Data Area
---
JVM이 운영체제 위에서 실행되면서 할당받은 메모리 영역<br>
<img width="575" alt="image" src="https://user-images.githubusercontent.com/53562331/177928982-fff0b24b-9dd1-4868-a340-7414890aeb30.png">

1. **Method영역**은 JVM이 시작될 때 생성되는 공간으로 바이트코드가 이 영역에 저장됨<br>
- 클래스 정보, 변수 정보, static으로 선언한 변수가 저장되고 모든 스레드가 공유하는 영역<br>
2. **Heap영역**은 동적으로 생성된 객체가 저장되는 영역으로 GC의 대상이 되는 공간<br>
- 배열객체나 new연산자를 통해 생성된 객체가 소멸되기 전이나 가비지 컬렉터가 정리하기 전 이 영역에 남아있음<br>
- 가비지컬렉션의 대상이 되는 공간<br>
>**가비지 컬렉션** - 자바에서는 JVM이 프로그램 메모리를 관리, JVM은 가비지컬렉션이라는 프로세스를 통해 메모리를 관리, 자바에서 사용되지 않은 메모리를 지속적으로 찾아내서 제거하는 역할을 함.<br>
>실행순서: 참조되지 않은 객체들을 탐색 후 삭제 → 삭제된 객체의 메모리를 반환  → 힙 메모리 재사용<br>
>효율적인 GC를 위해 5가지 영역으로 나뉨<br>
3. **Stack영역**은 지역변수나 메서드의 매개변수, 임시적으로 사용되는 변수, 메서드의 정보가 저장되는 영역<br>
<img width="357" alt="image" src="https://user-images.githubusercontent.com/53562331/177929634-f2a01ed6-c820-4fc4-9736-a7c66ac5dcb1.png"><br>
- primitive Type이 아닌 Reference Type(class, interface, enum, Array)은 Heap영역에 메모리를 저장하고, 메모리 주소를 참조하는 변수를 Stack영역에 저장<br>
4. **PC Register영역** = PC(Program Counter)<br>
- 스레드가 생성될 때 생성되며, 현재 수행중인 JVM의 명령어 주소를 저장하는 공간. 즉, 스레드가 어떤 부분을 어떤 명령어로 수해할지를 저장하는 공간.<br>
5. **Navive Method Stack영역**은 JAVA가 아닌 다른 언어로 작성된 코드를 위한 공간. C/C++등의 코드가 기계어로 작성된 프로그램을 실행<br>

Execution Engine
---
Runtime Data Area에 로딩된 class파일이 Execution Engine에 의해 해석
<img width="642" alt="image" src="https://user-images.githubusercontent.com/53562331/177931355-34d665c9-bee4-428b-b1ab-3979d0f81ff1.png">
- interpreter는 명령어를 한줄한줄 실행
- JIT Compiler는 interpreter의 단점을 해결, 런타임시간에 한꺼번에 변경하여 실행
- 해석된 후 Runtime Data Area에 배치되어 수행(스레드동기화, 가비지 컬랙션)

<hr>
<img width="509" alt="image" src="https://user-images.githubusercontent.com/53562331/177932214-74ec8472-3e63-4a15-8990-0461bf824fd1.png">
Native Method Interface(JNI)<br>
- JVM에 의해 실행되는 코드 중 네이티브로 실행되는 것이 있다면 해당 네이티브 코드를 호출하거나 호출 될 수 있도록 만든 일종의 프레임워크<br>
Native Method Library<br>
- 네이티브메소드 실행에 필요한 라이브러리

