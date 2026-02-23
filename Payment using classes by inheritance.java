//for the payment program class name should be payment.Create a child classes use @override method to inherit from the parent class. don't use extends
class Payment{
  double amount;
  Payment(double amount){
    this.amount = amount;
  }
  void pay(){
    System.out.println("Processing payment..");
  }
}
class CardPayment extends Payment{
  CardPayment(double amount){
    super(amount);
  }
  @Override
  void pay(){
    System.out.println("Paid " +amount+"using Card");
  }
}
class CashPayment extends Payment{
  CashPayment(double amount){
  super(amount);
}
  @Override
  void pay(){
   System.out.println("Paid" +amount+"using Cash");
  }
}
public class Main {
  public static void main(String[] args){
    Payment p1=new CardPayment(2000);
    Payment p2=new CashPayment(500);
    p1.pay();
    p2.pay();
  }
}
