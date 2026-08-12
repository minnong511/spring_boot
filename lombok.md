# Lombok 

Lombok은 Java에서 반복적인 코드를 줄여주는 라이브러리 (어노테이션으로 불러놓으면 반복적인 코들르 작성해준다.)

예를 들어 getter, setter, 생성자, toString, equals/hasecode 등을 어노테이션으로 자동 생성해준다. 

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
public class User{
    private String name; 
    private int age; 
}

위 코드만으로 getName(), setName(), 생성자등이 컴파일 시 자동으로 만들어진다. 

@Getter, @Setter
@Data - 여러 기능을 한 번에 적용 
@NoArgsConstructor, @AllArgsConstructor 
@Builder 
@RequiredArgsConstructor 
@slf4j 

------- @어노테이션 -> "이 클래스에 이런 기능을 자동으로 추가해줘"

원래는 이렇게 써야함 

public class User {
    private String name; 
    private int age; 

    public String getName() {
        return name; 
    }

    public void setName(String name){
        this.name = name; 
    }

    public int getAge() {
        return age; 
    }

    public void setAge(int age){
        this.age = age 
    }

}

@Getter 
@Setter 

-> Lombok이 컴파일할 때 getter와 setter를 대신 만들어준다. 

각 어노테이션은 이런 뜻 
1. @Getter : 필드 값을 읽는 메서드 생성 getName(), getAge()
2. @Setter : 필드 값을 변경하는 메서드 생성  setName(), setAge()
3. @NoArgsConstructor : 아무 값도 받지 않는 생성자 생성 
4. @AllArgsConsructor: 모든 필드를 받는 생성자 생성 
5. @builder : 객체를 단계적으로 만들 수 있다. 

근데 어떻게 생성자인걸 알아내냐?

생성자는 
1. 클래스 이름과 생성자 이름이 같음
2. 반환 타입이 없음 

User()는 클래스 이름이 User 와 같고 반환 타입이 없으므로 생성자이다. 
반면 getName()은 반환 타입 String이 있으므로 일반 메서드 

###  2. Lombok은 어떻게 생성자를 만드나?

@AllArgsConstructor
public class User {
    private String name;
    private int age;
}

Lombok은 클래스의 구조를 읽고 어노테이션 규칙에 따라 코드를 추가한다. 

@AllArgsConstructor 
public class User{
    private String name; 
    private int age; 
}

-> Lombok은 이걸 보고 내부적으로 다음 코드를 만든다. 

public User(String name, int age) {
    this.name = name; 
    this.age = aga; 
}

@AllArgsConstructor -> 모든 필드를 받는 생성자를 만들어라 -> 필드는 이미 정했으니 바로 만들어진다. 

@NoArgsConstructor -> 아무 인자도 받지 않는 생성자를 만들어라 
public User() {} 를 만들고 

@RequiredArgsConstructor -> final 이나 @Notnull이 붙은 필드를 만든ㄴ다. 

@getter 
@setter 
public class User {
    private String name; 
    private int age; 
} 

-> 

public class User{
    private String name; 
    private int age;


    public String getName(){
        return name; 
    }

    public void setName(String name) {
        this.name = name 
    }

    
    public int getAge(){
        return name; 
    }

    public void setAge(int age) {
        this.age = age 
    }


}

@Getter -> 값을 읽는 get필드명() 
@Setter -> 값을 바꾸는 set필드명(값)


private boolean active;

-> private boolean isActive() {
    return active; 
} 

public void setActive(boolean active){
    this.active = active; 
}


---
> Lombok 라이브러리는 컴파일 할 때 코드를 만든다. 
> 소스 코드에는 getter가 안 보이지만 -> 컴파일된 결과에는 getName() 같은 메서드가 들어가있다. -> 따라서 Lombok 

@Getter, @Setter : getter/setter 자동 생성 
@NoArgsConstructor : 기본 생성자 
@AllArgsConstructor : 모든 필드를 받는 생성자 
@RequireArgsConstructor : final 필드등을 받는 생성자 
@Bulider : Builder 패턴
@Slf4j : 로그 객체 생성
@Tostring : toString() 생성 

@Data -> 모든 생성자를 만들어버리므로 조심할 것 


------ 추가 문법 공부 

public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
}

public 

-> UserService 
-> 클래스 이름과 같다. 반환 타입이 없으ㅡ로 생성자 

(UserRepository userRepository)
- UserRepository : 자료형 
- userRepository : 매개변수 이름 

this.userRepository = userRepository
-> 여기가 핵심 

this.userRepository -> 현재 객체가 가지고 있는 필드 
userRepository -> 생성자가 전달받은 매개변수 

(UserRepository userRepository)

------- 

방금 쓴 코드는 Spring이 필요한 객체를 연결해주는 코드 

Spring Boot에서는 보통 이런 구조 

Controller  -> Service -> Repository 

@Service 
public class UserService{
    private final UserRepository userRepository; 

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository; 
    }

    public User findUser(Long id){
        return userRepository.findById(id).orElse(null); 
    }
}

Spring은 애플리케이션이 시작될 때:
1. userRepository 객체를 만들고 
2. userService 매서드를 만들고 
3. 생성자에 UserRepository를 넣어줘

new UserService(userRepository)

-> 실제로 요청이 오는 경우.. 