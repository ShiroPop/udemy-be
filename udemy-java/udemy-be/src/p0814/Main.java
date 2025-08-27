package p0814;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 대여일 수 입력
        System.out.print("며칠 빌리시겠습니까? (1일 이상): ");
        int days = sc.nextInt();
        if (days < 1) {
            System.out.println("대여일 수는 1일 이상이어야 합니다.");
            return;
        }

        // 2. 차량 종류 선택
        System.out.println("차량 종류를 선택하세요: ");
        System.out.println("1. Car (승용차)");
        System.out.println("2. Truck (트럭)");
        System.out.println("3. ElectricCar (전기차)");
        System.out.print("선택: ");
        int choice = sc.nextInt();

        Vehicle vehicle = switch (choice) {
            case 1 -> new Car("Hyundai", "Sonata");
            case 2 -> new Truck("Kia", "Bongo");
            case 3 -> new ElectricCar("Tesla", "Model 3");
            default -> null;
        };

        if (vehicle == null) {
            System.out.println("잘못된 선택입니다.");
            return;
        }

        // 3. 대여 과정
        ((Rentable) vehicle).rent();
        int fee = vehicle.calculateRentalFee(days);
        System.out.println(vehicle.brand + " " + vehicle.model + " 요금: " + fee + "원");
        ((Returnable) vehicle).returnVehicle();

        System.out.println("총 대여 요금: " + fee + "원");

        sc.close();
    }
}
