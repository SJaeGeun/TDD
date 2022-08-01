import java.util.Date;

public class ParkingSpace {
  private String parkingArea;
  private String enterTime;

  public String getEnterTime() {
    return enterTime;
  }

  @Override
  public String toString() {
    return "현재 주차 정보{" +
        "입차 시간=" + enterTime +
        ", 주차 구역='" + parkingArea + '\'' +
        ", 차 번호=" + car.getLicensePlate() +
        ", 차 종류=" + car.getCarType() +
        '}';
  }

  Car car;

  public String getParkingArea() {
    return parkingArea;
  }

  public Car getCar() {
    return car;
  }

  public ParkingSpace(String enterTime, String parkingArea, Car car){
    this.enterTime = enterTime;
    this.parkingArea = parkingArea;
    this.car = car;
  }
}
