/**
 * Student Name: Ilay Zvi
 *  ID: 324125657
 *  Date: 12/12/2023
 *  Class Name: SavingsAccount
 */
public class SavingsAccount extends BankAccount{

    private double interest = 0.02;

    public SavingsAccount(String accountNumber, String ownerName, String ID, double balance)
    {
        super(accountNumber, ownerName, ID, balance);
        this.setAccountType("Savings Account");
    }

    public SavingsAccount(String accountNumber, String ownerName, String ID, double balance, double interest)
    {
        this(accountNumber, ownerName, ID, balance);
        this.interest = interest;
    }

    /**
     * Applies monthly interest
     */
    @Override
    public void accountMaintenance() {
        this.setBalance(this.getBalance() * (1+this.interest));
        System.out.printf("Your new balance is: %.3f\n" , this.getBalance());
    }

    /**
     * @return string representation of an object of type SavingsAccount
     */
    @Override
    public String toString() {
        return super.toString() + " Interest= " + interest;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    /**
     * compares a given object with this instance of SavingsAccount
     * @param object an object to compare this instance of SavingsAccount to
     * @return the result of the comparison
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object) && this.interest == ((SavingsAccount)object).getInterest();
    }
}
