package p0813;

public class BankAccount {
    private String accountNumber;
    private String owner;
    private int balance;

    public BankAccount(String accountNumber, String owner, int balance) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            System.out.println("계좌번호는 비어있을 수 없습니다.");
            return;
        }
        else if (owner == null || owner.isEmpty()) {
            System.out.println("예금주는 비어있을 수 없습니다.");
            return;
        }
        else if (balance < 0) {
            System.out.println("초기 잔액은 0 이상이어야 합니다.");
            return;
        }

        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("입금 금액은 0보다 커야 합니다.");
            return;
        }
        balance += amount;
        System.out.println(this.owner + " 계좌에 " + amount + "원 입금 완료!");
    }

    public boolean withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("출금 금액은 0보다 커야 합니다.");
            return false;
        }
        else if (amount > balance) {
            System.out.println("잔액이 부족하여 출금할 수 없습니다.");
            return false;
        }
        balance -= amount;
        System.out.println(this.owner + " 계좌에서 " + amount + "원 출금 완료!");
        return true;
    }

    public int getBalance() {
        return balance;
    }

    public void transferTo(BankAccount target, int amount) {
        System.out.println(this.owner + "이 " +target.owner + "에게 " + amount + "원 이체 중...");
        if (target == this) {
            System.out.println("자기 자신에게 이체할 수 없습니다.");
            return;
        }
        if (this.withdraw(amount)) {
            target.deposit(amount);
            System.out.println(this.owner + "이 " +target.owner + "에게 " + amount + "원 이체 완료!");
        }
    }
    public String toString() {
        return String.format("계좌번호: %s, 예금주: %s, 잔액: %d원", accountNumber, owner, this.getBalance());
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("123-456", "홍길동", 1000);
        BankAccount acc2 = new BankAccount("789-012", "김민수", 500);

        acc1.deposit(500);
        acc1.withdraw(200);
        acc1.transferTo(acc2, 300);

        System.out.println(acc1);
        System.out.println(acc2);
    }
}
