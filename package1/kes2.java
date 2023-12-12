package package1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import package3.DatabaseOperations;

public class kes2 {
    
    public static boolean isValidAadharNumber(long aadharNumber) {
        String aadharString = String.valueOf(aadharNumber);
        return aadharString.length() == 12;
    }
        public static boolean isValidAadharNumber(int aadharNumber) {
        String aadharString = String.valueOf(aadharNumber);
        return aadharString.length() == 12;
    }
    
    public static boolean isValidPANNumber(String panNumber) {
        return panNumber.length() == 10;
    }

   public static void insertTransaction(Connection connection, int cardNumber, String transactionType, double amount) throws SQLException {
    // Assuming you have a method to retrieve the current balance for the given cardNumber
    double currentBalance = getCurrentBalance(connection, cardNumber);
if(transactionType=="Withdrawal"){
    // Check if the balance is sufficient for the withdrawal
    if ("Withdrawal".equals(transactionType) && currentBalance < amount) {
        return;
    }}

    String insertTransactionQuery = "INSERT INTO transaction_history (card_number, transaction_type, amount, timestamp) VALUES (?, ?, ?, ?)";

    try {
        // Set auto-commit to false to start a transaction
        connection.setAutoCommit(false);

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertTransactionQuery)) {
            preparedStatement.setInt(1, cardNumber);
            preparedStatement.setString(2, transactionType); 
            preparedStatement.setDouble(3, amount);
            preparedStatement.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));

            // Print the SQL query before execution
            System.out.println("SQL Query: " + preparedStatement.toString());

            preparedStatement.executeUpdate();
        }

        // Commit the transaction after all statements have been executed successfully
        connection.commit();
    } catch (SQLException se) {
        // Rollback the transaction if an exception occurs
        if (connection != null) {
            connection.rollback();
        }
        se.printStackTrace();
    } finally {
        // Set auto-commit back to true after the transaction
        connection.setAutoCommit(true);
    }
}


private static double getCurrentBalance(Connection connection, int cardNumber) throws SQLException {

    String selectBalanceQuery = "SELECT balance FROM account WHERE card_number = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(selectBalanceQuery)) {
        preparedStatement.setInt(1, cardNumber);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getDouble("balance");
            } else {
                throw new SQLException("Card number not found");
            }
        }
    }
}


     public boolean isValidDOB(String dateOfBirth) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
            
         
            LocalDate today = LocalDate.now();
            LocalDate tenYearsAgo = today.minusYears(10);
            
            return dob.isBefore(tenYearsAgo);
        } catch (Exception e) {
            
            return false;
        }
    }

}
class kes9 extends kes2 {
    
    public static boolean isValidAadharNumber(long aadharNumber) {
        String aadharString = String.valueOf(aadharNumber);
        return aadharString.length() == 10;
    }}