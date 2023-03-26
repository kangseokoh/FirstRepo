package hello.core.singleton;

public class StatefulService {

    //private int price;
    // 무상태 설계가 매우 중요함

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        //this.price = price;
        return price;
    }

//    public int getPrice() {
//        return price;
//    }

}
