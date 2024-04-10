/**
 * Student Name: Ilay Zvi
 *  Date: 12/12/2023
 *  Class Name: CheckingAccount
 */
public class CheckingAccount extends BankAccount{

    public CheckingAccount(String accountNumber, String ownerName, String ID, double balance)
    {
        super(accountNumber, ownerName, ID, balance);
        this.setAccountType("Checking Account");
    }

    /**
     * writes a check of amount given if the account has sufficient balance
     * @param amount the check value
     */
    public void writeCheck(double amount)
    {
        try
        {
            this.withdraw(amount);
        } catch (IllegalBalance e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * account with no service maintenance
     */
    @Override
    public void accountMaintenance() {
        System.out.println("Account with no service fee or maintenance");
    }
}
