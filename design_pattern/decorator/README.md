## 데코레이터패턴
- 객체에 추가 요소를 동적으로 더할 수 있다.
- 데코레이터를 사용하면 서브클래스를 만들 때보다 훨씬 유연하게 기능을 확장할 수 있다.

### 디자인 원칙
 - 클래스 확장에는 열려 있어야 하지만 변경에는 닫혀 있어야 한다.


 ```mermaid
 classDiagram
    class Beverage{
        <<abscract>>
        - String description
        + String getDescription()
        + double cost()
    } 

    class CondimentDecorator{
        <<abscract>>
        - Beverage beverage
        + String getDescription()
    }

    class Espresso{
        + double cost()
    }
    class DarkRoast{
        + double cost()
    }

    class Milk{
        + double cost()
    }
    class Mocha{
        + double cost()
    }

    CondimentDecorator --> Beverage
    CondimentDecorator --|> Beverage

    Espresso --|> Beverage
    DarkRoast --|> Beverage
    Milk --|> CondimentDecorator
    Mocha --|> CondimentDecorator
 ```
