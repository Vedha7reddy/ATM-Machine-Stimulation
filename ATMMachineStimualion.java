// Import required classes and packages   
import java.util.ArrayList;
import java.util.Scanner;

// Create Main class to implement the ATM functionality  
public class ATMMachineStimualion{

    // Main method starts
    public static void main(String args[]) {

        // Declare and initialize balance, withdraw, and deposit  
        int balance = 100000, withdraw, deposit;
        int pin = 1234;
        ArrayList<String> transactionHistory = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("Enter your PIN: ");
            int enteredPin = sc.nextInt();
            
            if (enteredPin == pin) {

                while (true) {
                    System.out.println("Automated Teller Machine");
                    System.out.println("Choose 1 for Withdraw");
                    System.out.println("Choose 2 for Deposit");
                    System.out.println("Choose 3 for Check Balance");
                    System.out.println("Choose 4 for Change PIN");
                    System.out.println("Choose 5 for Transaction History");
                    System.out.println("Choose 6 for EXIT");
                    System.out.print("Choose the operation you want to perform:");

                    // Get choice from user  
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.print("Enter money to be withdrawn:");

                            // Get the withdrawal money from user  
                            withdraw = sc.nextInt();

                            // Check whether the balance is greater than or equal to the withdrawal amount  
                            if (balance >= withdraw) {
                                
                                // Remove the withdrawal amount from the total balance  
                                balance = balance - withdraw;
                                System.out.println("Please collect your money");
                                transactionHistory.add("Withdrawn: $" + withdraw);
                            } else {
                                // Show custom error message   
                                System.out.println("Insufficient Balance");
                            }
                            System.out.println("");
                            break;

                        case 2:
                            System.out.print("Enter money to be deposited:");
                            // Get deposit amount from the user  
                            deposit = sc.nextInt();
                            // Add the deposit amount to the total balance  
                            balance = balance + deposit;
                            System.out.println("Your Money has been successfully deposited");
                            transactionHistory.add("Deposited: $" + deposit);
                            System.out.println("");
                            break;

                        case 3:
                            // Display the total balance of the user  
                            System.out.println("Balance: $" + balance);
                            System.out.println("");
                            break;

                        case 4:
                            System.out.print("Enter your current PIN: ");
                            int currentPin = sc.nextInt();
                            if (currentPin == pin) {
                                System.out.print("Enter your new PIN: ");
                                int newPin = sc.nextInt();
                                pin = newPin;
                                System.out.println("PIN changed successfully.");
                                transactionHistory.add("PIN changed successfully.");
                            } else {
                                System.out.println("Incorrect current PIN.");
                            }
                            System.out.println("");
                            break;

                        case 5:
                            System.out.println("Transaction History:");
                            for (String transaction : transactionHistory) {
                                System.out.println(transaction);
                            }
                            System.out.println("");
                            break;

                        case 6:
                            // Exit from the menu  
                            System.exit(0);
                    }
                }
            } else {
                System.out.println("Invalid PIN. Please try again.");
            }
        }
    }
}
