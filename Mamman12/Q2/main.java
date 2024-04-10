/**
 * Student Name: Ilay Zvi
 *  Date: 12/12/2023
 *  Class Name: main
 */
public class main {
    public static void main(String[] args) {
        BankAccount accountArray[] = new BankAccount[6];
        accountArray[0] = new CheckingAccount("231241","Yaron","23354672",5000);
        accountArray[1] = new ServiceChargeChecking("2323235","Yaniv","95201624",3000);
        accountArray[2] = new NoServiceChargeChecking("3838439","David","34906438",500000,10000);
        accountArray[3] = new InterestChecking("892392382","Yariv","90239045",10000,7000);
        accountArray[4] = new SavingsAccount("9348934","Yoav","039250594",400,0.10);
        accountArray[5] = new HighInterestChecking("293829323","Yakov","89238923",53212,0.07);

        for(int i=0; i < accountArray.length;i++) {
            System.out.println(accountArray[i]);
            accountArray[i].accountMaintenance();
            System.out.println(accountArray[i]);
            try {
                accountArray[i].withdraw(accountArray[i].getBalance() + 1);
            }catch (IllegalBalance e)
            {
                System.out.println(e.getMessage());
            }
            try{
                accountArray[i].withdraw(accountArray[i].getBalance());
            } catch (IllegalBalance e)
            {
                System.out.println(e.getMessage());
            }

            System.out.println(accountArray[i]);

            accountArray[i].addToBalance(1000 * i);
            System.out.println(accountArray[i]);
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
