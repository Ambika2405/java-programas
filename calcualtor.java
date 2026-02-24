//write a program to create a calculator that should be calculate all the number.
import java.util.Scanner;
public class Calculator{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("====Simple Calculator====");
    Systen.out.println("1.Addition");
    System.out.println("2.Substraction");
    System.out.println("3.Multiplication");
    System.out.println("4.Division");
    System.out.println("Choose an option:");
    int choice=sc.nextInt();
    System.out.println("Ente the first no.:");
    double num1=sc.nextDouble();
    System.out.println("Enter the second no.:");
    double num2=sc.nextInt();
    Switch(choice){
      case 1:
        System.out.println("Result=" +(num1+num2));
        break;
      case 2:
        System.out.println("Result=" +(num1-num2));
        break;
      case 3:
        System.out.println("Result="+(num1*num2));
        break;
      case 4:
        if(num2!=0){
          System.out.println("Result="+num1/num2));
        } else {
            System.out.println("Division by zero is not allowed!");
        }
        break;
      default:
        System.out.println("Invalid choice!");
    }
    sc.close();
}
