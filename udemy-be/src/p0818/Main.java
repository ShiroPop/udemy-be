package p0818;

public class Main {
    public static void main(String[] args) {
        // 박스 생성
        GenericBox<Integer> intBox = new GenericBox<>(10);
        GenericBox<String> strBox = GenericBox.of("Hello");

        // 값 꺼내기
        System.out.println(intBox.getValue());
        System.out.println(intBox.isPresent());

        // 값 교환
        GenericBox<Integer> a = new GenericBox<>(1);
        GenericBox<Integer> b = new GenericBox<>(2);
        GenericBox.swap(a, b);
        System.out.println(a.getValue());
        System.out.println(b.getValue());

        GenericBox<Integer> lengthBox = strBox.map(String::length);
        System.out.println(lengthBox.getValue());
    }
}
