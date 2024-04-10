/**
 * Student Name: Ilay Zvi
 *  ID: 324125657
 *  Class Name: InterestChecking
 */
public class InterestChecking extends NoServiceChargeChecking{

    private double interest = 0.03;

    public InterestChecking(String accountNumber, String ownerName, String ID, double balance)
    {
        super(accountNumber, ownerName, ID, balance);
        this.setMinimumBalance(2000);
        this.setAccountType("Interest Checking Account");
    }

    public InterestChecking(String accountNumber, String ownerName, String ID, double balance, double minimumBalance)
    {
        super(accountNumber, ownerName, ID, balance, minimumBalance);
        this.setAccountType("Interest Checking Account");
    }

    public InterestChecking(String accountNumber, String ownerName, String ID, double balance, double minimumBalance, double interest)
    {
        this(accountNumber, ownerName, ID, balance, minimumBalance);
        this.interest = interest;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest)
    {
        this.interest = interest;
    }

    /**
     * Applies monthly interest
     */
    @Override
    public void accountMaintenance() {
        this.setBalance(this.getBalance() * (1+this.interest));
        System.out.println("Your new balance is: " + this.getBalance());
    }

    /**
     * @return string representation of an object of type InterestChecking
     */
    @Override
    public String toString() {
        return super.toString() + " Interest= " + interest;
    }

    /**
     * compares a given object with this instance of InterestChecking
     * @param object an object to compare this instance of InterestChecking to
     * @return the result of the comparison
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object) && this.interest == ((InterestChecking)object).interest;
    }
}
