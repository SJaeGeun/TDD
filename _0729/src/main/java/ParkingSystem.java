import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingSystem {

  static List<User> users = new ArrayList<>();


  public static User checkPaycoUser(){
    Scanner scanner = new Scanner(System.in);
    int checkMenu;
    String userId;
    int amount;

    System.out.println("페이코(Payco) 회원입니까? (1):네 (2):아니요");
    checkMenu = scanner.nextInt();
    System.out.println("이름을 입력해주세요.");
    userId = scanner.next();
    System.out.println("현재 소지하고 있는 금액을 입력해주세요.");
    amount = scanner.nextInt();

    if (checkMenu == 1){
      return new User(userId, amount, true);
    }
    else {
      return new User(userId, amount, false);
    }
  }

  public static void addUser(User user){
    users.add(user);
  }

  public static void printUser(){
    for (User user: users) {
      System.out.println(user.toString());
    }
  }

  public static void main(String[] args) throws ParseException {
    Scanner scanner = new Scanner(System.in);
    ParkingLot parkingLot = new ParkingLot();
    int parkingFee;
    int menu;
    while(true) {
      System.out.println("원하시는 메뉴를 선택해주세요 : (1):입차 (2):출차 (3):현재 주차정보 (4):종료");
      menu = scanner.nextInt();
      switch (menu) {
        case 1:
          parkingLot.enter();
          break;
        case 2:
          User user =checkPaycoUser();
          addUser(user);
          parkingFee = parkingLot.exit();
          if (user.isPaycoUser() == true){
            user.setAmount(user.getAmount() - (int)(parkingFee*0.9));
          }
          else user.setAmount(user.getAmount()-parkingFee);
          System.out.println("이용 요금은 " + parkingFee +"원 입니다.");
          System.out.println("잔액은 " + user.getAmount()+ "원 입니다.");
          break;
        case 3:
          parkingLot.printAll();
          break;
        default:
          System.exit(1);
      }
    }
  }


}
