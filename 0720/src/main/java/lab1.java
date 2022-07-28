public class lab1 {

  public static void main(String[] args) {
    PayCommand paycommand1 = new PayCommand(new Customer("박상웅", new Customer.item(30000L)));
    paycommand1.prepare(10000L, "박상웅");
  }
}
