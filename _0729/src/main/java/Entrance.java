import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Entrance {
  Date now = new Date();
  String pattern = "yy-MM-dd HH:mm:ss";
  SimpleDateFormat formatter = new SimpleDateFormat(pattern);

  String enterTime = formatter.format(now);
  public ParkingSpace carEnter(ParkingSpace parkingSpace, List<ParkingSpace> spaces){
    Scanner scanner = new Scanner(System.in);
    boolean carTypeCheck = true;
    boolean parkingAreaCheck = true;
    int licensePlate = 0;
    String carType = null;
    String parkingArea = null;

    while(carTypeCheck) {
      System.out.println("차량의 번호판을 입력해주세요.");
      licensePlate = scanner.nextInt();
      System.out.println("차량의 종류를 입력해주세요. ex)소형, 중형, 대형");
      carType = scanner.next();
      if (carType.equals("대형")){
        System.out.println("대형 차량은 주차할 수 없습니다.");
      }
      else {
        carTypeCheck =false;
      }
    }
    System.out.println("주차하고 싶은 공간을 적어주세요. ex)A-1");
    parkingArea = scanner.next();

//    while(parkingAreaCheck) {
//
//      System.out.println("주차하고 싶은 공간을 적어주세요. ex)A-1");
//      parkingArea = scanner.next();
//      for (ParkingSpace area : spaces){
//        if (area.getParkingArea().equals(parkingArea)){
//          System.out.println("자리가 없는 공간입니다.");
//          parkingArea = null;
//        }
//      }
//    }

    System.out.println("입차가 완료되었습니다.");
    return new ParkingSpace(enterTime, parkingArea, new Car(licensePlate, carType));

  }

}
