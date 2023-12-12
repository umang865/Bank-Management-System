    package package2;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.Scanner;
    import package3.DatabaseOperations;
    public class BankDb implements DatabaseOperations{
        
      public double getAccountBalance(Connection connection, int cardNumber) throws SQLException {
            String getBalanceQuery = "SELECT balance FROM account WHERE card_number = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(getBalanceQuery)) {
                preparedStatement.setInt(1, cardNumber);
                ResultSet resultSet = preparedStatement.executeQuery();
    
                if (resultSet.next()) {
                    return resultSet.getDouble("balance");
                } else {
                    throw new SQLException("Account not found.");
                }
            }
        }
        
        public void updateAccountBalance(Connection connection, int cardNumber, double newBalance) throws SQLException {
            String updateBalanceQuery = "UPDATE account SET balance = ? WHERE card_number = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateBalanceQuery)) {
                preparedStatement.setDouble(1, newBalance);
                preparedStatement.setInt(2, cardNumber);
                preparedStatement.executeUpdate();
                
            }
        }
        
         public void updateAccountPin(Connection connection, int cardNumber, int newPin) throws SQLException {
            String updatePinQuery = "UPDATE account SET pin = ? WHERE card_number = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updatePinQuery)) {
                preparedStatement.setInt(1, newPin);
                preparedStatement.setInt(2, cardNumber);
                preparedStatement.executeUpdate();
            }
        }
        @Override
       public void displayTransactionHistory(Connection connection, int cardNumber) throws SQLException {
            String getTransactionHistoryQuery = "SELECT * FROM transaction_history WHERE card_number = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(getTransactionHistoryQuery)) {
                preparedStatement.setInt(1, cardNumber);
                ResultSet resultSet = preparedStatement.executeQuery();
        
                System.out.println("Transaction History:");
                System.out.printf("%-20s %-15s %-10s %-30s%n", "Timestamp", "Type", "Amount", "Card Number");
                while (resultSet.next()) {
                    String timestamp = resultSet.getString("timestamp");
                    String type = resultSet.getString("transaction_type");
                    double amount = resultSet.getDouble("amount");
        
                    System.out.printf("%-20s %-15s $%-10.2f %-30d%n", timestamp, type, amount, cardNumber);
                }
            }
        }
        }  