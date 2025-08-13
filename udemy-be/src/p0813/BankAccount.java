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
        }
        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("입금 금액은 0보다 커야 합니다.");
        }
        else if (amount > balance) {
            System.out.println("입금 금액은 0보다 커야 합니다.");
        }
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public void transferTo(BankAccount target, int amount) {
        if (target == null) {
            System.out.println("이체할 대상 계좌가 없습니다.");
        }
        else if (target == this) {
            System.out.println("자기 자신에게 이체할 수 없습니다.");
        }
        this.withdraw(amount);
        target.deposit(amount);
    }

    public String toString() {
        return String.format("계좌번호: %s, 예금주: %s, 잔액: %d원", accountNumber, owner, balance);
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
