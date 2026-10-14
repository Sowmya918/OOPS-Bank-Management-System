# OOP Bank Management System (Core Java)

A console-based Core Java project demonstrating object-oriented programming concepts.

## Features
- List the sample savings accounts
- Deposit funds into an account
- Withdraw funds while maintaining a minimum savings balance of $100
- Validate basic menu choices and amounts

## OOP concepts
- **Abstraction:** `AccountOperations` defines the operations supported by an account.
- **Encapsulation:** `BankAccount` keeps account details and balance private and exposes methods to interact with them.
- **Inheritance:** `SavingsAccount` extends `BankAccount`.
- **Polymorphism:** The menu calls overridden account methods through `BankAccount` references.

## Requirements
JDK 11 or newer.

## Compile and run
Open a terminal in the project folder and run:

```bash
javac -d out src/*.java
java -cp out BankEngine
```

Sample account numbers: `SAV101` (Alice Smith, $500.00) and `SAV102` (Bob Jones, $150.00).

This is an educational console demo, not production banking software. It stores data only in memory and resets when the program exits.
