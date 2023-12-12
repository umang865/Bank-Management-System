package package3;
import java.sql.Connection;
import java.sql.SQLException;
public interface DatabaseOperations {
    public double getAccountBalance(Connection connection, int cardNumber) throws SQLException;
    public void updateAccountBalance(Connection connection, int cardNumber, double newBalance) throws SQLException;
    public void updateAccountPin(Connection connection, int cardNumber, int newPin) throws SQLException;
   public void displayTransactionHistory(Connection connection, int cardNumber) throws SQLException;
}

interface a {
        public boolean isValidAadharNumber(long aadharNumber);
    public boolean isValidPANNumber(String panNumber) ;
    public void insertTransaction(Connection connection, int cardNumber, String transactionType, double amount) throws SQLException ;

}