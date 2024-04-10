/**
 * Student Name: Ilay Zvi
 *  Date: 12/12/2023
 *  Class Name: NoServiceChargeChecking
 */
public class NoServiceChargeChecking extends CheckingAccount{

    private double minimumBalance = 1000;

    public NoServiceChargeChecking(String accountNumber, String ownerName, String ID, double balance)
    {
        super(accountNumber, ownerName, ID, balance);
        this.setAccountType("No Service Charge Checking Account");
    }

    public NoServiceChargeChecking(String accountNumber, String ownerName, String ID, double balance, double minimumBalance)
    {
        this(accountNumber, ownerName, ID, balance);
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void accountMaintenance() {
        System.out.println("Account with no service fee or maintenance");
    }

    /**
     * Withdraws money from the bank account if the account's balance is not lower than minimum balance post withdrawal
     * @param amount an amount to be withdrawn
     * @throws IllegalBalance if the balance after withdrawal would be lower than minimum balance
     */
    @Override
    public void withdraw(double amount) throws IllegalBalance{
        if(this.getBalance()-amount >= minimumBalance) {
            this.setBalance(this.getBalance() - amount);
            System.out.printf("Your new balance is: \n" + this.getBalance());
        }
        else throw new IllegalBalance("Attempting to withdraw an illegal amount, your balance is: " + this.getBalance());
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    /**
     * @return string representation of an object of type NoServiceChargeChecking
     */
    @Override
    public String toString() {
        return super.toString() + " Minimum Balance= " + minimumBalance;
    }

    /**
     * compares a given object with this instance of NoServiceChargeChecking
     * @param object an object to compare this instance of NoServiceChargeChecking to
     * @return the result of the comparison
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object) && this.minimumBalance == ((NoServiceChargeChecking)object).getMinimumBalance();
    }
}
