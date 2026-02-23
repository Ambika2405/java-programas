//for the payment program class name should be payment.Create a child classes use @override method to inherit from the parent class. don't use extends
interface Payment{
  void pay(double amount);
}
class CashPayment implements Payment{
  @Override
  public void pay(double amount){
    System.out.println("cash payment of:"+ amount);
  }
}
class CardPayment implements Payment{
  @Override
  public void pay(double amount){
    System.out.println("card payment of:" +amount);
  }
}
public class Main {
  public static void main(String[] args){
    Payment p1=new CashPayment();
    Payment p2=new CardPayment();
    p1.pay(500);
    p2.pay(1000);
  }
}
