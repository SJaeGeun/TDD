import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Exit {

  public int pay(ParkingSpace parkingSpace) throws ParseException {
    Date now = new Date();
    String pattern = "yy-MM-dd HH:mm:ss";
    SimpleDateFormat formatter = new SimpleDateFormat(pattern);

    Date enterTime = formatter.parse(parkingSpace.getEnterTime());
    Date exitTime = formatter.parse(formatter.format(now));

    long untilizeTime = (exitTime.getTime() - enterTime.getTime()) / 1000;
    //초 단위로 비용 계산
    if(untilizeTime <= 1800){
      return 0;
    }

    else if(untilizeTime <= 3600){
      if(parkingSpace.car.getCarType().equals("소형")){
        return 500;
      }
      return 1000;
    }

    else if(untilizeTime <= 86400){
      long extraPostage = untilizeTime-3600;
      if(parkingSpace.car.getCarType().equals("소형")){
        return (int) (500+extraPostage/(60*10)*500/2);
      } else{
        return (int) (1000+extraPostage/(60*10)*500);
      }
    }

    else {
      if(parkingSpace.car.getCarType().equals("소형")){
        return 7500;
      }
      return 15000;
    }
  }
}


