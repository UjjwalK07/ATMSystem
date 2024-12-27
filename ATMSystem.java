import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A simple program to simulate basic ATM operations.
 */
public class ATMSystem {
    private int pinCode;
    private int accountBalance;
    private List<String> transactionLog;

    /**
     * Initializes the ATM with a starting balance and PIN.
     *
     * @param initialBalance Starting balance of the account
     * @param initialPin PIN to secure the account
     */
    public ATMSystem(int initialBalance, int initialPin) {
        this.accountBalance = initialBalance;
        this.pinCode = initialPin;
        this.transactionLog = new ArrayList<>();
    }

    /**
     * Updates the account PIN.
     *
     * @param newPin The new PIN to set
     * @return Confirmation or error message
     */
    public String updatePin(int newPin) {
        if (String.valueOf(newPin).length() != 4) {
            return "Error: PIN must be exactly 4 digits.";
        }
        this.pinCode = newPin;
        transactionLog.add("PIN updated successfully.");
        return "Your PIN has been updated.";
    }

    /**
     * Deposits money into the account.
     *
     * @param amount The amount to deposit
     * @return Confirmation or error message
     */
    public String depositMoney(int amount) {
        if (amount <= 0) {
            return "Error: Deposit amount should be more than zero.";
        }
        accountBalance += amount;
        transactionLog.add("Deposited: ₹" + amount);
        return "Deposit successful. New balance: ₹" + accountBalance;
    }

    /**
     * Withdraws money from the account.
     *
     * @param amount The amount to withdraw
     * @return Confirmation or error message
     */
    public String withdrawMoney(int amount) {
        if (amount <= 0) {
            return "Error: Withdrawal amount should be more than zero.";
        }
        if (amount > accountBalance) {
            return "Error: Insufficient balance.";
        }
        accountBalance -= amount;
        transactionLog.add("Withdrew: ₹" + amount);
        return "Withdrawal successful. Remaining balance: ₹" + accountBalance;
    }

    /**
     * Displays the current account balance.
     *
     * @return The current balance as a string
     */
    public String showBalance() {
        return "Current balance: ₹" + accountBalance;
    }

    /**
     * Verifies if the entered PIN matches the stored PIN.
     *
     * @param enteredPin The PIN entered by the user
     * @return True if the PIN is correct, false otherwise
     */
    public boolean verifyPin(int enteredPin) {
        return enteredPin == pinCode;
    }

    /**
     * Displays the transaction history.
     *
     * @return All transactions as a string
     */
    public String viewTransactionHistory() {
        if (transactionLog.isEmpty()) {
            return "No transactions yet.";
        }
        StringBuilder history = new StringBuilder("Transaction History:\n");
        for (String record : transactionLog) {
            history.append(record).append("\n");
        }
        return history.toString();
    }

    /**
     * Main method to run the ATM simulation.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMSystem atm = new ATMSystem(2000, 1234);

        System.out.println("Welcome to the ATM!");
        System.out.print("Please enter your 4-digit PIN: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid 4-digit PIN: ");
            scanner.next();
        }
        int enteredPin = scanner.nextInt();

        if (!atm.verifyPin(enteredPin)) {
            System.out.println("Invalid PIN. Access denied.");
            return;
        }

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Update PIN");
            System.out.println("4. Check Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                scanner.next();
            }
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid amount:");
                        scanner.next();
                    }
                    System.out.println(atm.depositMoney(scanner.nextInt()));
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid amount:");
                        scanner.next();
                    }
                    System.out.println(atm.withdrawMoney(scanner.nextInt()));
                    break;
                case 3:
                    System.out.print("Enter your new 4-digit PIN: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid 4-digit PIN:");
                        scanner.next();
                    }
                    System.out.println(atm.updatePin(scanner.nextInt()));
                    break;
                case 4:
                    System.out.println(atm.showBalance());
                    break;
                case 5:
                    System.out.println(atm.viewTransactionHistory());
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
