
interface BankInterface {
    double getBalance();
    double getInterestRate();
}


class BankA implements BankInterface {
                 private double balance;

    public BankA(double balance) {
        this.balance = balance;
    }

    
    public double getBalance() {
        return balance;
    }

    
    public double getInterestRate() {
        return 7.0; 
    }
}


class BankB implements BankInterface {
               private double balance;

    public BankB(double balance) {
        this.balance = balance;
    }

    
    public double getBalance() {
        return balance;
    }

    
    public double getInterestRate() {
        return 7.4; 
    }
}


class BankC implements BankInterface {
            private double balance;

    public BankC(double balance) {
        this.balance = balance;
    }

    
    public double getBalance() {
        return balance;
    }

    
    public double getInterestRate() {
        return 7.9; 
    }
}


public class lab5a {
    public static void main(String[] args) {
        
        BankA bankA = new BankA(10000);
        BankB bankB = new BankB(150000);
        BankC bankC = new BankC(200000);

        
        System.out.println("Bank A:");
        System.out.println("Balance: " + bankA.getBalance());
        System.out.println("Interest Rate: " + bankA.getInterestRate() + "%");

        System.out.println("\nBank B:");
        System.out.println("Balance: " + bankB.getBalance());
        System.out.println("Interest Rate: " + bankB.getInterestRate() + "%");

        System.out.println("\nBank C:");
        System.out.println("Balance: " + bankC.getBalance());
        System.out.println("Interest Rate: " + bankC.getInterestRate() + "%");
    }
}

