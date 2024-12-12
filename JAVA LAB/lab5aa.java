import java.util.Scanner;

interface BankInterface{
    double getBalance(); double getInterestRate(); 
}

class BankA implements BankInterface {
private double balance;

public BankA(double balance){
this.balance = balance; }

public double getBalance() {
return balance; }

public double getInterestRate() {
return 7.0; } }

class BankB implements BankInterface {
private double balance;

public BankB(double balance) { 
this.balance = balance; }

public double getBalance() {
return balance; }

public double getInterestRate() { 
return 7.4; } }

class BankC implements BankInterface {
private double balance;

public BankC(double balance){
this.balance = balance; }

public double getBalance() { 
return balance; }

public double getInterestRate() {
return 7.9; } }

public class lab5aa {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in); 
System.out.print("Enter the balance for Bank A: "); 
double balanceA = scanner.nextDouble(); 
BankA bankA = new BankA(balanceA); 

System.out.print("Enter the balance for Bank B: "); 
double balanceB = scanner.nextDouble(); 
BankB bankB = new BankB(balanceB); 

System.out.print("Enter the balance for Bank C: "); 
double balanceC = scanner.nextDouble(); 
BankC bankC = new BankC(balanceC);

System.out.println("\nBank A:"); 
System.out.println("Balance: " + bankA.getBalance()); 
System.out.println("Interest Rate: " + bankA.getInterestRate() + "%");

System.out.println("\nBank B:"); 
System.out.println("Balance: " + bankB.getBalance()); 
System.out.println("Interest Rate: " + bankB.getInterestRate() + "%");

System.out.println("\nBank C:"); 
System.out.println("Balance: " + bankC.getBalance()); 
System.out.println("Interest Rate: " + bankC.getInterestRate() + "%");

scanner.close();
}
}
