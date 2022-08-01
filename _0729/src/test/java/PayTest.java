import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PayTest {



  @Test
  @DisplayName("중형차가 이용했을 때")
  void payTestMID() throws ParseException{
    ParkingLot parkingLot = new ParkingLot();
    ParkingSpace parkingSpace;
    parkingSpace = new ParkingSpace("22-07-31 20:18:00", "A-4", new Car(1111,"중형"));
    int parkingFee = parkingLot.exit.pay(parkingSpace);
    assertEquals(15000, parkingFee);
  }

  @Test
  @DisplayName("소형차가 이용했을 때")
  void payTestSMALL() throws ParseException{
    ParkingLot parkingLot = new ParkingLot();
    ParkingSpace parkingSpace;
    parkingSpace = new ParkingSpace("22-07-31 20:18:00", "A-4", new Car(1111,"소형"));
    int parkingFee = parkingLot.exit.pay(parkingSpace);
    assertEquals(7500, parkingFee);
  }

}
