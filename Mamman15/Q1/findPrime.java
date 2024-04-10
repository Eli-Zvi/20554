/**
 * Student Name: Ilay Zvi
 *  Date: 5/2/2023
 *  Class Name: findPrime
 */
public class findPrime implements Runnable{

    private int [] numberArray;
    public int count = 0;

    /**
     * initializes a findPrime object with an m+1 length array
     * @param m range to be checked(0-m)
     */
    public findPrime(int m)
    {
        if(m > 1) //there are no prime numbers below 2
        {
            numberArray = new int[m+1]; //initiate an array of size m+1 for the range 0-m so the index correlates with the number
            count = 2; //start from number 2 which is the first prime number
            numberArray[0] = 1; //0 is not a prime number
            numberArray[1] = 1; //1 is not a prime number
        }
    }

    public int getRange()
    {
        return numberArray.length;
    }

    public boolean isPrime(int i)
    {
        return i < getRange() && numberArray[i] == 0;
    }

    public synchronized int getCount()
    {
        return count;
    }

    public synchronized void incCount()
    {
        count++;
    }

    /**
     * increments count and returns its number before increment
     * @return the number of elements that have been checked + 1
     */
    public synchronized int getAndIncCount()
    {
        int temp = count;

        if(count < numberArray.length)
        {
            incCount();
        } else return -1;

        return temp;
    }

    /**
     * checks if the current count value is a prime number
     */
    @Override
    public void run() {
        if(getCount() < numberArray.length) {
            int checkedNumber = getAndIncCount();

            for (int i = 2; i <= Math.sqrt(checkedNumber); i++) {
                if (checkedNumber % i == 0) {
                    numberArray[checkedNumber] = 1;
                    break;
                }
            }
        }
    }
}
