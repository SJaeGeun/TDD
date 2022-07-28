import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("결제 시스템 테스트")
class PayCommandTest {
  private Customer.item item = new Customer.item(10000L);
  @Test
  @DisplayName("10% 쿠폰 적용 테스트")
  void DisPer10(){
    long result = DiscountPolicy.DISPER10.getDiscountAmt(10000L);
    assertEquals(1000, result);
  }
  @Test
  @DisplayName("1000원 쿠폰 적용 테스트")
  void Dis1000(){
    long result = DiscountPolicy.DIS1000.getDiscountAmt(10000L);
    assertEquals(1000, result);
  }
  @Test
  @DisplayName("적립기능 테스트")
  void Accumulate(){
    item.setAccumulatedMoney((long) (10000 * 0.1));
    long result = item.getAccumulatedMoney();
    assertEquals(1000, result);
  }
  @Test
  @DisplayName("적립금 사용 테스트")
  void UseAccumulatedMoney(){
    long result = item.getMoney() - item.getAccumulatedMoney();
    assertEquals(10000, result);
  }

}
