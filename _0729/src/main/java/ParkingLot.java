import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ParkingLot {

  private ParkingSpace parkingSpace;
  int exitLicensePlate;
  Scanner scanner = new Scanner(System.in);
  Entrance entrance = new Entrance();
  Exit exit = new Exit();
  List<ParkingSpace> spaces = new ArrayList<>();

  public void addParkingLot(ParkingSpace parkingSpace){
    spaces.add(parkingSpace);
  }

  public void enter(){
    addParkingLot(entrance.carEnter(parkingSpace, spaces));

  }
  public int exit() throws ParseException {
    System.out.println("출차할 차량의 번호판을 입력해주세요.");
    exitLicensePlate = scanner.nextInt();
    for (Iterator<ParkingSpace> iterator = spaces.iterator(); iterator.hasNext(); ) {
      ParkingSpace carNumber = iterator.next();
      if (carNumber.car.getLicensePlate() == exitLicensePlate) {
        int parkingFee = exit.pay(carNumber);
        iterator.remove();
        System.out.println("출차가 완료되었습니다.");
        return parkingFee;
      }
    }
    return 0;
  }
  public void printAll(){
    for (ParkingSpace park: spaces) {
      System.out.println(park.toString());
    }
  }
}
