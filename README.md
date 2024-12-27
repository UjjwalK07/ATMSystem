# ATM Simulation

This Java program simulates the basic functions of an ATM machine. It allows users to perform essential banking tasks such as checking account balance, depositing money, withdrawing cash, changing PIN, and viewing transaction history.

## Features
- **Account Balance Inquiry**: Check the current balance of the account.
- **Cash Withdrawal**: Withdraw a specified amount from the account, provided there are sufficient funds.
- **Cash Deposit**: Deposit a specified amount into the account.
- **PIN Change**: Change the account PIN to a new one.
- **Transaction History**: View the history of all transactions, including deposits, withdrawals, and PIN changes.

## How to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/UjjwalK07/ATM_Simulation.git
   cd ATM_Simulation
2. Compile the Code:
   ```bash
    javac ATMSystem.java
4. Run the Program:
   ```bash
   java ATMSystem
## Follow the On-Screen Instructions:
- Enter your PIN.
- Choose from the menu options to perform various banking tasks.

## Code Overview
The main class `ATMSystem` includes the following methods:

- **`updatePin(int newPin)`**: Changes the PIN after validating its size.
- **`depositMoney(int amount)`**: Adds a specified amount to the balance and logs the transaction.
- **`withdrawMoney(int amount)`**: Deducts a specified amount from the balance if sufficient funds are available and logs the transaction.
- **`showBalance()`**: Returns the current balance.
- **`verifyPin(int enteredPin)`**: Verifies the entered PIN.
- **`viewTransactionHistory()`**: Returns the transaction history as a formatted string.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

