import java.util.HashMap;
import java.util.Map;

public class Customer {

  private String accountId;

  public Customer(String customerId , item item) {
    this.customer.put(customerId,item);
  }

  public item getCustomerItem(String customerId){
    return this.customer.get(customerId);
  }
  //결재는 계정에 의존함.
  Map<String,item> customer = new HashMap<>();

  static class item{

    public void setMoney(Long money) {
      this.money = money;
    }
    public void setAccumulatedMoney(Long accumulatedMoney) {
      this.accumulatedMoney = accumulatedMoney;
    }
    public Long getAccumulatedMoney() {
      return accumulatedMoney;
    }
    public Long getMoney() {
      return money;
    }
    public item(Long money) {
      this.accumulatedMoney = 0L;
      this.money = money;
    }
    private Long accumulatedMoney;
    private Long money;
  }
}

