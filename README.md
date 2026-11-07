# Expense Tracker (Java)

A command-line expense tracker written in Java. Add expenses, list them, see a running total, and your data is saved between runs.

## Features
- Add an expense with a description, amount, and category
- List all expenses, numbered
- Show the total, formatted to two decimals
- Saves to `expenses.txt` on quit and loads it on startup
- Input validation: rejects non-numeric, zero, and negative amounts, and unknown menu choices

## Requirements
- JDK 17 or newer

## How to run
```
javac *.java
java ExpenseTracker
```

## How to use
Pick an option from the menu:

```
What would you like to do? 1 Add, 2 List, 3 Total, 4 Quit
```

Choose `4` to quit. Your expenses are saved automatically to `expenses.txt` in the folder you ran the program from.

## Project structure
- `Expense.java`: the data class (description, amount, category)
- `ExpenseTracker.java`: the menu loop, plus `save` and `load` methods

## What I learned
- Writing a class with private fields, a constructor, getters, and `toString`
- Working with `ArrayList` of objects
- Reading and writing text files with `Scanner`, `PrintWriter`, and `FileWriter`
- Using try-with-resources and handling `IOException` and `NumberFormatException`
- Compiling multiple files with `javac *.java`
