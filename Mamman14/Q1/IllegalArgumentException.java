/**
 * Student Name: Ilay Zvi
 *  Date: 18/1/2023
 *  Class Name: IllegalArgumentException
 */

public class IllegalArgumentException extends Exception{

    public IllegalArgumentException()
    {
        super();
    }

    public IllegalArgumentException(String msg)
    {
        super(msg);
    }

    public IllegalArgumentException(Throwable cause)
    {
        super(cause);
    }

    public IllegalArgumentException(String msg, Throwable cause)
    {
        super(msg,cause);
    }
}
