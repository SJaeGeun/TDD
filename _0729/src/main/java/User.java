import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

  @Override
  public String toString() {
    return "User{" +
        "userId='" + userId + '\'' +
        ", amount=" + amount +
        ", paycoUser=" + paycoUser +
        '}';
  }

  private String userId;
  private int amount;
  private boolean paycoUser;

  public User(String userId, int amount, boolean paycoUser){
    this.userId = userId;
    this.amount = amount;
    this.paycoUser = paycoUser;
  }

  public String getUserId() {
    return userId;
  }

  public int getAmount() {
    return amount;
  }
  public void setAmount(int amount){
    this.amount = amount;
  }

  public boolean isPaycoUser() {
    return paycoUser;
  }
}
