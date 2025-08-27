package p0814;

abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int dailyFee;

    public Vehicle(String brand, String model, int dailyFee) {
        this.brand = brand;
        this.model = model;
        this.dailyFee = dailyFee;
    }

    public int calculateRentalFee(int days) {
        if (days < 1) throw new IllegalArgumentException("대여일 수는 1일 이상이어야 합니다.");
        return dailyFee * days;
    }
}

interface Rentable {
    void rent();
}

interface Returnable {
    void returnVehicle();
}

class Car extends Vehicle implements Rentable, Returnable {
    public Car(String brand, String model) {
        super(brand, model, 50000);
    }

    @Override
    public void rent() {
        System.out.println(brand + " " + model + "승용차 대여 시작");
    }

    @Override
    public void returnVehicle() {
        System.out.println(brand + " " + model + "승용차 반납 완료");
    }
}

class Truck extends Vehicle implements Rentable, Returnable {
    public Truck(String brand, String model) {
        super(brand, model, 80000);
    }

    @Override
    public void rent() {
        System.out.println(brand + " " + model + "트럭 대여 시작");
    }

    @Override
    public void returnVehicle() {
        System.out.println(brand + " " + model + "트럭 반납 완료");
    }
}


class ElectricCar extends Vehicle implements Rentable, Returnable {
    public ElectricCar(String brand, String model) {
        super(brand, model, 70000);
    }

    @Override
    public void rent() {
        System.out.println(brand + " " + model + "전기차 대여 시작");
        System.out.println("전기차는 충전 비용이 별도로 발생합니다.");
    }

    @Override
    public void returnVehicle() {
        System.out.println(brand + " " + model + "전기차 반납 완료");
    }
}