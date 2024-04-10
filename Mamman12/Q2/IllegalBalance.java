public class IllegalBalance extends Exception{
    public IllegalBalance()
    {
        super();
    }

    public IllegalBalance(String s)
    {
        super(s);
    }

    public IllegalBalance(Throwable cause)
    {
        super(cause);
    }

    public IllegalBalance( String s, Throwable cause)
    {
        super(s,cause);
    }
}
