## 옵저버패턴
 신문사(주제) + 구독자(옵저버)
 - 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체에게 연락이 가고, 자동으로 내용이 갱신되는 방식으로 일대다 의존성을 정의한다.

### 디자인 원칙
 - 상호작용하는 객체 사이에는 가능하면 느슨한 결합을 사용해야 한다.

observer : 주제(subject) 상태 변화 알림 받음.
subject : observer 목록 관리, 변경이 있을 때 알림.

 ```mermaid
 classDiagram
    class Subject{
        <<interface>>
        + void registerObserver(Observer o)
        + void removeObserver(Observer o)
        + void notifyOservers()
    } 
    class Observer{
        <<interface>>
        + void update(float temp, float humidity,float pressure)
    }
    class DisplayElement{
        <<interface>>
        + void display()
    }

    
    class WeatherData{
        - List~Observer~ observers
        - float temperature
        - float humidity
        - float pressure

    }

    class CurrentConditionsDisplay{
        - float temperature
        - float humidity
        - WeatherData weatherData
        + update()
        + display()
    }
    class ForecastDisplay{
        - float currentPressure
        - float lastPressure
        - WeatherData weatherData
        + update()
        + display()
    }

    class HeatIndexDisplay{
        - float heatIndex
        - WeatherData weatherData
        + update()
        + display()
    }

    Subject <|..WeatherData
    Observer<|..CurrentConditionsDisplay
    DisplayElement<|..CurrentConditionsDisplay
    Observer<|..ForecastDisplay
    DisplayElement<|..ForecastDisplay
    Observer<|..HeatIndexDisplay
    DisplayElement<|..HeatIndexDisplay

    WeatherData --> Observer 
    
```