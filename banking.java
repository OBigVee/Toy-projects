import java.util.Scanner;
import java.lang.Math.*;


public class BankingApp{
    public static void main(String[] args) {
        // BankAccount customer1 = new BankAccount("juliet","83");
    BankAccount cust = new BankAccount();
    //BankAccount custId = new BankAccount();
    cust.setAccountName("juliet");
    cust.setAccountId("83");
    String customerName = cust.getAccountName();
    String customerId = cust.getAccountId();
    cust.bankMenu();

        /*customer1.bal = 50;
        customer1.previousTransactions = 40;
        customer1.accountName = "customer1iet";
        customer1.accountId = "0";
        customer1.deposit(90);
        customer1.bankMenu();*/

    }
}

class BankAccount{
    //instance variables
    int bal ;
    int previousTransactions;
    private String accountName;
    private String accountId;


    void setAccountName(String x){
        this.accountName = x;
    }

    String getAccountName(){
         return accountName;
    }

    void setAccountId(String id){
        this.accountId = id;
    }

    String getAccountId(){
        return accountId;
    }

    void deposit(int amount){
        if (amount != 0){
            bal = bal+amount;
            previousTransactions = amount;
            System.out.println("you account has just be creditted wit $"+Integer.toString(amount));
            System.out.println("$"+Integer.toString(amount)+"\tDeposited");
        }else{
            System.out.println("you can\'t deposit $"+Integer.toString(amount));
        }
    }

    void withdraw(int amount){
        if (amount>bal){
            System.out.println("you don\'t have sufficient fund");
            
        }else{
            bal = bal - amount;
            previousTransactions = -amount;
            System.out.println("Debit Alert!!!\nyour account has just been debitted of $"+Integer.toString(amount));
            

        }
    }

    void getPreviousTrans (){
        if (previousTransactions > 0){
            System.out.println("deposited: "+previousTransactions);
        }else if(previousTransactions < 0){
            System.out.println("withdrawn: $"+ Math.abs(previousTransactions));
        }else{
                System.out.println("No Transaction occured!");
            }
        
    }

    void bankMenu(){
        String selectOption;
        Scanner scanner = new Scanner(System.in);
        System.out.println("**************************");
        System.out.println("welcome "+ accountName);
        System.out.println("your Id is "+ accountId);
        System.out.println("**************************");
        // System.out.println("\n");
        System.out.println("The following option performs corresponding tasks\n ");
        System.out.println(" A :| Check balance \n B :| Deposit \n C :| withdraw \n D :| check Previous transactions \n E :| Exit");
        System.out.println("- -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -   -  -  -  -  -");
        do{
            System.out.println("=================================================================================");
            System.out.println("select an option to perform an action");
            System.out.println("=================================================================================");
            selectOption = String.valueOf(scanner.next().charAt(0));
            System.out.println("\n");
        
            switch (selectOption) {
                case "A":
                    System.out.println("-------------------- ----");
                    System.out.println("Balance:: $"+ bal);
                    System.out.println("-------------------------");
                    break;

                case "B":
                    System.out.println("-------------------------");
                    System.out.println("Enter the amount to deposit");
                    System.out.println("-------------------------");
                    try {
                        int amount = scanner.nextInt();
                    deposit(amount);
                    } catch (Exception e) {
                       System.out.println("enter numeric values not letters");
                    }
                    System.out.println("------------------------------");
                    break;
                
                case "C":
                    System.out.println("-------------------------");
                    System.out.println("Enter an amount to withdraw");
                    System.out.println("----------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    // System.out.println("your accounted has been debitted of\t"+Integer.toString(amount2));
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case "D":
                    System.out.println("---------------------------");
                    getPreviousTrans();
                    System.out.println("---------------------------");
                    System.out.println("\n");
                    break;
                
                case "E":
                    System.out.println("-------------------------");
                    System.out.println("Exiting App in a secs");
                    break;

                default:
                    System.out.println("Invaid option please select again");
                    break;
            }
            
            
        }
        while(selectOption != "E");//{System.out.println("thanks for using our service!");}
    System.out.println("thanks for using our service");
   
        
    }
}