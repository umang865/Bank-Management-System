import package2.BankDb;
import package1.kes2;
import package3.DatabaseOperations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
abstract class UserActions {
    abstract void processAccountActions(Connection connection, int cardNumber, Scanner scanner) throws SQLException;
}
public class kes1 extends UserActions{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bank_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;
        while (continueProgram) {
            System.out.print("Do you have an existing account? (yes/no/exit): ");
            String response = scanner.next().toLowerCase();
            if (response.equals("no")) {
                // User wants to create an account
                createAccount(scanner);
            } else if (response.equals("yes")) {
                // User has an existing account
                loginAndProcessAccount(scanner);
            } else if (response.equals("exit")) {
                System.out.println("Goodbye!");
                continueProgram = false; // Set continueProgram to false to exit the loop

            } else {
                System.out.println("Invalid response. Please enter 'yes', 'no', or 'exit'.");
            }
        }
    }
    private static kes1 instance= new kes1();
       private static kes2 k2=new kes2();
    private static void createAccount(Scanner scanner) {
        String name;
        boolean validName = false;
    
        do {
            System.out.print("Enter name: ");
            name = scanner.next();
    
            // Check if the name contains only alphabetical characters
            if (name.matches("^[a-zA-Z]+$")) {
                validName = true;
            } else {
                System.out.println("Invalid name. Please enter alphabetic characters only.");
            }
    
        } while (!validName);
        String fatherName;
        boolean validFatherName = false;
    
        do {
            System.out.print("Enter father's name: ");
            fatherName = scanner.next();
    
            // Check if the father's name contains only alphabetical characters
            if (fatherName.matches("^[a-zA-Z]+$")) {
                validFatherName = true;
            } else {
                System.out.println("Invalid father's name. Please enter alphabetic characters only.");
            }
    
        } while (!validFatherName);
    
        String dob;
        boolean validDOB = false;
    do {
        System.out.print("Enter date of birth (yyyy-MM-dd): ");
        dob = scanner.next(); // Assume you have a method in kes2 to validate DOB
        validDOB = k2.isValidDOB(dob);
        if (!validDOB) {
            System.out.println("Invalid date of birth OR your Age must be greater than 10.");
        }
    } while (!validDOB);
    String gender;
    boolean validGender=false;
    do {
        System.out.print("Enter gender (male/female/others): ");
        gender = scanner.next().toLowerCase();

        // Check if the gender is valid
        if (gender.equals("male") || gender.equals("female") || gender.equals("others")) {
            validGender = true;
        } else {
            System.out.println("Invalid gender. Please enter 'male,' 'female,' or 'others'.");
        }

    } while (!validGender);

    
    String email;
    boolean validEmail = false;

   do {
     System.out.print("Enter email: ");
       email   = scanner.next();

       // Check if the email contains at least one character followed by "@"
       if (email.length() >= 2 && email.charAt(0) != '@' && email.contains("@")) {
           validEmail = true;
       } else {
           System.out.println("Invalid email. Please enter an email address containing at least one character followed by '@'.");
       }

   } while (!validEmail);


        String maritalStatus;
        boolean validMaritalStatus = false;
    
        do {
            System.out.print("Enter marital status (married/unmarried): ");
            maritalStatus = scanner.next().toLowerCase();
    
            // Check if the marital status is valid
            if (maritalStatus.equals("married") || maritalStatus.equals("unmarried")) {
                validMaritalStatus = true;
            } else {
                System.out.println("Invalid marital status. Please enter 'married' or 'unmarried'.");
            }
    
        } while (!validMaritalStatus);
        System.out.print("Enter address: ");
        String address = scanner.next();

        String city;
        boolean validCity = false;
    
        do {
            System.out.print("Enter city: ");
            city = scanner.next();
    
            // Check if the city contains only alphabetical characters
            if (city.matches("^[a-zA-Z]+$")) {
                validCity = true;
            } else {
                System.out.println("Invalid city. Please enter alphabetic characters only.");
            }
    
        } while (!validCity);
    
       String pincode;
    boolean validPincode = false;

    do {
        System.out.print("Enter pincode (6 digits): ");
        pincode = scanner.next();

        // Check if the pincode contains only numeric characters and is exactly 6 digits long
        if (pincode.matches("^[0-9]{6}$")) {
            validPincode = true;
        } else {
            System.out.println("Invalid pincode. Please enter exactly 6 numeric digits.");
        }

    } while (!validPincode);
          String state;
    boolean validState = false;

    do {
        System.out.print("Enter state: ");
        state = scanner.next();

        // Check if the state contains only alphabetical characters
        if (state.matches("^[a-zA-Z]+$")) {
            validState = true;
        } else {
            System.out.println("Invalid state. Please enter alphabetic characters only.");
        }

    } while (!validState);

    long income = 0;  // Default value
    boolean validIncome = false;

    do {
        System.out.print("Enter income: ");
        
        // Check if the entered value is a valid long
        if (scanner.hasNextLong()) {
            income = scanner.nextLong();
            validIncome = true;
        } else {
            System.out.println("Invalid income. Please enter a valid long value.");
            // Consume the invalid input to prevent an infinite loop
            scanner.next();
        }

    } while (!validIncome);

          // Validate PAN number input
    String panNumber;
    boolean validPanNumber = false;

    do {
        System.out.print("Enter PAN number: ");
        panNumber = scanner.next();

        // Check if the PAN number contains only alphabetic characters and numeric digits
        if (panNumber.matches("^[a-zA-Z0-9]+$")) {
            validPanNumber = true;
        } else {
            System.out.println("Invalid PAN number. Please enter a valid PAN number without special characters.");
        }
    }
     while (!validPanNumber);
     
       
   
          long aadharNumber = 0;  // Default value
    boolean validaadhar = false;
    do {
        System.out.print("Enter aadharnumber: ");    
        // Check if the entered value is a valid long
        if (scanner.hasNextLong()) {
            aadharNumber = scanner.nextLong();
            validaadhar = true;
        } else {
            System.out.println("Invalid Aadharnumber. Please enter a valid long value.");
            // Consume the invalid input to prevent an infinite loop
            scanner.next();
        }
    }
    while (!validaadhar);
kes2 k=new kes2();
        while (!k.isValidPANNumber(panNumber) || !k.isValidAadharNumber(aadharNumber)) {
            System.out.println("Please enter a valid PAN number (10 characters) and Aadhar number (12 digits).");
            System.out.print("Enter PAN number: ");
            panNumber = scanner.next();
            System.out.print("Enter Aadhar number: ");
            aadharNumber = scanner.nextLong();
        }
  // Validate initial deposit input
  double initialDeposit = 0;  // Default value
  boolean validInitialDeposit = false;

  do {
      System.out.print("Enter initial deposit amount: ");
      
      // Check if the entered value is a valid double
      if (scanner.hasNextDouble()) {
          initialDeposit = scanner.nextDouble();
          validInitialDeposit = true;
      } else {
          System.out.println("Invalid initial deposit amount. Please enter a valid numeric value.");
          // Consume the invalid input to prevent an infinite loop
          scanner.next();
      }

  } while (!validInitialDeposit);

        String insertUserQuery = "INSERT INTO users (name, father_name, dob, gender, email, marital_status, " +
                "address, city, pincode, state, income, PAN_NUMBER, Adhar_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery)) {
                preparedStatement.setString(1, name);
        preparedStatement.setString(2, fatherName);
        preparedStatement.setString(3, dob);
        preparedStatement.setString(4, gender);
        preparedStatement.setString(5, email);
        preparedStatement.setString(6, maritalStatus);
        preparedStatement.setString(7, address);
        preparedStatement.setString(8, city);
        preparedStatement.setString(9, pincode);
        preparedStatement.setString(10, state);
        preparedStatement.setLong(11, income);
        preparedStatement.setString(12, panNumber);
        preparedStatement.setLong(13, aadharNumber);
        preparedStatement.executeUpdate();
            }

            Random random = new Random();
            int cardNumber = 10000000 + random.nextInt(90000000);
            int pin = 1000 + random.nextInt(9000);

            String insertAccountQuery = "INSERT INTO account (card_number, pin, balance) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertAccountQuery)) {
                preparedStatement.setInt(1, cardNumber);
                preparedStatement.setInt(2, pin);
                preparedStatement.setDouble(3, initialDeposit);

                preparedStatement.executeUpdate();
            }
  
            System.out.println("Account created successfully.");
            System.out.println("Card Number: " + cardNumber);
            System.out.println("PIN: " + pin);
            System.out.println("Initial deposit: $" + initialDeposit);

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    private static void loginAndProcessAccount(Scanner scanner) {
        boolean loggedIn = false;
       

        while (!loggedIn) {
            String cardNumber;
            boolean validcard=false;

            do {
                
                System.out.print("Enter your card number (8 digits only): ");
                cardNumber = scanner.next();
    
                
                if (cardNumber.length() == 8 && cardNumber.matches("\\d+")) {
                   
                    validcard=true;
                   
                    break;
                } else {
                    System.out.println("Invalid card number. Please enter a 8-digit numeric card number.");
                }
            } while (!validcard); 
    
 

                 String pin;
            boolean validpin=false;

            do {
              
                System.out.print("Enter your pin (4 digits only): ");
                pin = scanner.next();
    
               
                if (pin.length() == 4 && pin.matches("\\d+")) {
              
                    validpin=true;
                 
                    break; 
                } else {
                    System.out.println("Invalid pin. Please enter a 4-digit numeric pin number.");
                }
            } while (!validpin); 
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String checkAccountQuery = "SELECT * FROM account WHERE card_number = ? AND pin = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(checkAccountQuery)) {
                    preparedStatement.setString(1, cardNumber);
                    preparedStatement.setString(2, pin);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        System.out.println("Login successful. Welcome to your account!");
                        loggedIn = true;
                        int cardNumberInt = Integer.parseInt(cardNumber);
instance.processAccountActions(connection, cardNumberInt, scanner);
                        
                    } else {
                        System.out.println("Invalid card number or PIN. Please try again.");
                    }
                }

            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    BankDb bankDb = new BankDb();
 void processAccountActions(Connection connection, int cardNumber, Scanner scanner) {
  kes2 k1 =new kes2();
         while (true) {
            try {
                System.out.println("Choose an option:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdrawal");
                System.out.println("3. Check Balance");
                System.out.println("4. Change PIN");
                System.out.println("5. Check Transaction History");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");     
        int choice=0;
        boolean validChoice = false;
        do {
            try {
              
                choice = scanner.nextInt();

                if (choice >= 1 && choice <= 6) {
                    validChoice = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                }
            } catch (java.util.InputMismatchException e) {
               
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); 

        }} while (!validChoice);

                kes2 k=new kes2();
                switch (choice) {
                    case 1:
                      
                        double depositAmount = 0.0;  
                        boolean validDeposit = false;
                        do {
                            try {
                                System.out.print("Enter the amount to deposit: ");
                                depositAmount = scanner.nextDouble();
                                validDeposit = true;
                            } catch (java.util.InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid decimal number.");
                                scanner.nextLine();
                            }
                        } while (!validDeposit);
                          
                        double currentBalance = bankDb.getAccountBalance(connection, cardNumber);
                        double newBalance = currentBalance + depositAmount;
                        bankDb.updateAccountBalance(connection, cardNumber, newBalance);
                        System.out.println("Deposit successful. New balance: $" + newBalance);
                                k1.insertTransaction(connection, cardNumber, "Deposit", depositAmount);
                        break;
                    case 2:
                        // Withdrawal
                        double withdrawalAmount = 0.0;  
                        boolean validWithdrawal = false;
                        do {
                            try {
                                System.out.print("Enter the amount to withdraw: ");
                                withdrawalAmount = scanner.nextDouble();
                                validWithdrawal = true;
                            } catch (java.util.InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid decimal number.");
                                scanner.nextLine(); 
                        } }while (!validWithdrawal);

                        currentBalance = bankDb.getAccountBalance(connection, cardNumber);
         k1.insertTransaction(connection, cardNumber, "Withdrawal",withdrawalAmount );
                        if (withdrawalAmount > currentBalance) {
                            System.out.println("Insufficient balance.");
                        } else {
                            newBalance = currentBalance - withdrawalAmount;
                            bankDb.updateAccountBalance(connection, cardNumber, newBalance);
                            System.out.println("Withdrawal successful. New balance: $" + newBalance);
                        }
                        break;
                           
                    case 3:
                        // Check Balance
                        currentBalance = bankDb.getAccountBalance(connection, cardNumber);
                        System.out.println("Current balance: $" + currentBalance);
                        break;
                    case 4:
                      
                        int newPin = 0;  
                        boolean validNewPin = false;
                        do {
                            try {
                                System.out.print("Enter your new PIN: ");
                                newPin = scanner.nextInt();
                                validNewPin = true;
                            } catch (java.util.InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid integer.");
                                scanner.nextLine(); 
                            }
                        } while (!validNewPin);
                        bankDb.updateAccountPin(connection, cardNumber, newPin);
                        System.out.println("PIN changed successfully.");
                        break;
                        case 5:
                        // Check action History
                        bankDb.displayTransactionHistory(connection, cardNumber);
                        break;
                        case 6:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                        
                }
            
       
            }
           catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }}
    
