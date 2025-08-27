package p0811;

public class CheckLogin {
    public static void main(String[] args) {
        String userId1 = "Admin";
        String userId2 = "admin";

        if(userId1.equalsIgnoreCase(userId2)) {
            System.out.println("로그인 성공!");
        } else {
            System.out.println("아이디가 일치하지 않습니다.");
        }
    }
}
