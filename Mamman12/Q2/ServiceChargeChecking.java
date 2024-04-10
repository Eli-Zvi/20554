/**
 * Student Name: Ilay Zvi
 *  ID: 324125657
 *  Date: 12/12/2023
 *  Class Name: ServiceChargeChecking
 */
public class ServiceChargeChecking extends CheckingAccount{

    private double fee = 20;

    public ServiceChargeChecking(String accountNumber, String ownerName, String ID, double balance)
    {
        super(accountNumber, ownerName, ID, balance);
        this.setAccountType("Service Charge Checking Account");
    }

    public ServiceChargeChecking(String accountNumber, String ownerName, String ID, double balance, double fee)
    {
        this(accountNumber, ownerName, ID, balance);
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee)
    {
        this.fee = fee;
    }

    /**
     * Pays the monthly fee for account maintenance
     */
    @Override
    public void accountMaintenance() { //not clear if an account's balance can be negative in the case of monthly maintenance making it negative, so I didn't add an IllegalBalance exception
        this.setBalance(this.getBalance()-fee);
        System.out.println("Monthly fee of: " + fee + " deducted, Account Balance: " + getBalance());
    }

    /**
     * @return string representation of an object of type ServiceChargeChecking
     */
    @Override
    public String toString() {
        return super.toString() + " Monthly Fee= " + fee;
    }

    /**
     * compares a given object with this instance of ServiceChargeChecking
     * @param object an object to compare this instance of ServiceChargeChecking to
     * @return the result of the comparison
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object) && this.fee == ((ServiceChargeChecking)object).getFee();
    }
}
