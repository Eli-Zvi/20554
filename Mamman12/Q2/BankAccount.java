/**
 * Student Name: Ilay Zvi
 *  ID: 324125657
 *  Date: 12/12/2023
 *  Class Name: BankAccount
 */
public abstract class BankAccount {
    private String accountNumber;
    private String ownerName;
    private String ID;
    private double balance;
    private String accountType = "Default";

    public BankAccount(String accountNumber, String ownerName, String ID, double balance)
    {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.ID = ID;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getID() {
        return ID;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void addToBalance(double amount)
    {
        this.balance += amount;
        System.out.println("Deposit of: " + amount + " was made, your new balance is: " + this.balance);
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public abstract void accountMaintenance();

    /**
     * Withdraws money from the bank account if the account's balance is bigger than or equal to the amount specified
     * @param amount an amount to be withdrawn
     * @throws IllegalBalance if the balance is lower than the amount specified
     */
    public void withdraw(double amount) throws IllegalBalance
    {
        if(this.balance - amount >= 0)
        {
            this.balance -= amount;
            System.out.println("Your new balance is: " + this.balance);
        }
        else throw new IllegalBalance("Attempting to withdraw an illegal amount, your balance is: " + this.balance);
    }

    /**
     * @return string representation of an object of type BankAccount
     */
    @Override
    public String toString() {
        return "Account of Type: " + accountType + " ,account number='" + accountNumber + '\'' +
                ", owner name='" + ownerName + '\'' +
                ", ID='" + ID + '\'' +
                ", balance=" + balance;
    }

    /**
     * compares a given object with this instance of BankAccount
     * @param object an object to compare this instance of BankAccount to
     * @return the result of the comparison
     */
    @Override
    public boolean equals(Object object) {
        if(object == null || !(object instanceof BankAccount))
            return false;

        BankAccount account = (BankAccount) object;

        return this.accountNumber.equals(account.getAccountNumber()) && this.ownerName.equals(account.getOwnerName())
                && this.ID.equals(account.getID()) && this.balance == account.getBalance();
    }
}
