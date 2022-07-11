
개요
---
C/C++프로그래밍을 할 때 메모리 누수(Memory Leak)를 막기 위해 객체를 생성한 후 사용하지 않는 객체의 메모리를 프로그래머가 직접 해제 해주어야 했습니다.
하지만 JAVA에서는 JVM이 구성된 JRE(Java Runtime Environment)가 제공되며, 그 구성 요소 중 하나인 GC이 자동으로 사용하지 않는 객체를 파괴합니다.

>- stop-the-world : GC를 실행하기 위해 JVM이 애플리케이션 실행을 멈추는 것
어떤 GC알고리즘을 사용하더라도 'stop-the-world'가 발생하게 되는데, 대게의 경우 GC튜닝은 이 'stop-the-world'시간을 줄이는 것이라고 합니다.

GC를 해도 더이상 사용 가능한 메모리 영역이 없는데 계속 메모리를 할당하려고 하면,
OutOfMemoryError가 발생하여 WAS가 다운될 수도 있습니다.

따라서 규모있는 JAVA애플리케이션을 효율적으로 개발하기 위해서는 GC에 대해 잘 알아야 한다고 한다.


GC알고리즘
---
<img width="300" alt="image" src="https://user-images.githubusercontent.com/53562331/178184992-5a97b9a2-1468-49a6-a786-c05ca8978e38.png">

1.Reference Counting - reference count로 해당 객체에 접근할 수 있는지 나타냄, 해당 객체에 접근할 수 있는 방법이 없으면
reference count가 0이됨. 0이 된다면 가비지 컬렉션의 대상이 됨<br>

단점 : 순환참조로 인해 서로를 참조하고있다면 Memory Leak이 발생
<img width="600" alt="image" src="https://user-images.githubusercontent.com/53562331/178184953-d9bd5cfd-4a34-4caa-9f15-1fd5e3a83b21.png">

**2. Mark And Sweep - 자바가 메모리를 관리하는 방식**, 
루트에서부터 해당 객체에 접근이 가능한지를 해제의 기준으로 삼음.
루트부터 그래프 순회를 통해 연결된 객체들을 찾아내고(Mark:연두색), 연결이 끊어진 객체들을 지우는 방식(Sweep : 우측 그림)<br>

단점 : 의도적으로 GC를 실행시켜야 함, 어플리케이션 실행과 GC실행이 병행됨 → 어플리케이션의 사용성을 유지하면서 효율적이게 GC를 실행하기 어려움


GC - Heap영역 
---
<a href="https://github.com/haeunk1/TIL/blob/main/java/Garbage%20Collection(GC).md">JVM</a>의 Heap영역
<img width="600" alt="image" src="https://user-images.githubusercontent.com/53562331/178188007-684b51b5-d31d-426c-839e-3832fa756352.png">

**1. Young generation에서 발생하는 GC는 minor gc**
- Eden : 새롭게 생성된 객체들이 할당되는 영역
- Survival : minor gc로부터 살아남은 객체들이 존재하는 영역
  - 둘 중 하나는 꼭 비어있어야 함
  - age-bit : minor gc에서 살아남을 때마다 1씩 증가
  - Promotion: JVM GC에서 age-bit 15를 넘어가면 old Generation으로 넘어감<br>

**2. old generation에서 발생하는 GC는 major gc**
- major gc는 minor gc보다 오래걸림

Generation GC 배경
---
 <img width="315" alt="image" src="https://user-images.githubusercontent.com/53562331/178189479-a398aee2-ba8a-4bf2-9261-ffac66b951de.png">
GC도 결국 비용인데 모든 영역에서 탐색하며 해제하기 보다는 특정부분에서 탐색하며 해제하는 것이 효율적!<br>
→ 대부분의 객체가 수명이 짧기 때문에 Young generation안에서 최대한 처리

