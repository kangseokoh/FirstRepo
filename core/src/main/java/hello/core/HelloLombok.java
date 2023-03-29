package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // lombok
@Setter // lombok
@ToString // lombok
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("memberA"); // @Setter

        String name = helloLombok.getName(); // @Getter
        System.out.println("name = " + name);
        System.out.println("HelloLombok = " + helloLombok); // @ToString
    }
}
