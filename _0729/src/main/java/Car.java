import java.util.HashMap;
import java.util.Map;

public class Car {
  private int licensePlate;
  private String carType;
  public Car(int licensePlate, String carType){
    this.licensePlate = licensePlate;
    this.carType = carType;
  }

  public int getLicensePlate() {
    return licensePlate;
  }

  public String getCarType() {
    return carType;
  }

}

