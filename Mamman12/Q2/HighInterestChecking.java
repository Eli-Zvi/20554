/**
 * Student Name: Ilay Zvi
 *  ID: 324125657
 *  Date: 12/12/2023
 *  Class Name: HighInterestChecking
 */
public class HighInterestChecking extends SavingsAccount{

    private double minimumBalance = 1000;

    public HighInterestChecking(String accountNumber, String ownerName, String ID, double balance)
    {
        super(accountNumber, ownerName, ID, balance);
        this.setInterest(0.05);
        this.setAccountType("High Interest Checking Account");
    }

    public HighInterestChecking(String accountNumber, String ownerName, String ID, double balance, double minimumBalance)
    {
        super(accountNumber, ownerName, ID, balance);
        this.minimumBalance = minimumBalance;
        this.setInterest(0.05);
        this.setAccountType("High Interest Checking Account");
    }

    public HighInterestChecking(String accountNumber, String ownerName, String ID, double balance, double minimumBalance, double interest)
    {
        super(accountNumber, ownerName, ID, balance,interest);
        this.minimumBalance = minimumBalance;
        this.setAccountType("High Interest Checking Account");
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}
