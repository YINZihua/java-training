public class Array implements myArray{
    protected int SIZE_DF = 100;
    protected Object[] tab;
    protected int size;//[0~~99]


    public Array()
    {   tab = new Object[SIZE_DF] ; size = 0 ; }

    public int getSize()
    {   return size ; }

    public boolean isEmpty()
    {   return (size == 0) ; }

    public Object getAtRank(int rank) throws ExceptionBoundaryViolation
    {   
        if((rank > size) || (0 > rank)) throw new ExceptionBoundaryViolation("Exception : the rank demanded is out of boundary.\n");
        return tab[rank];
    }
    
    public Object replaceAtRank(int rank, Object ele) throws ExceptionBoundaryViolation
    {
        if((rank > size) || (0 > rank)) throw new ExceptionBoundaryViolation("Exception : the rank demanded is out of boundary.\n");
        Object interm = tab[rank];
        tab[rank] = ele;
        return interm;
    }

    public Object insertAtRank(int rank, Object ele) throws ExceptionBoundaryViolation
    {
        if((rank > size) || (0 > rank)) throw new ExceptionBoundaryViolation("Exception : the rank demanded is out of boundary.\n");
        if(size >= SIZE_DF) throw new ExceptionBoundaryViolation("Exception : no enough arrays for this action.\n");

        Object interm = tab[rank];
        for(int i = size + 1 ; i > rank ; i--)tab[i] = tab[i-1];
        tab[rank] = ele;
        size++;
        return interm;
    }

    public Object removeAtRank(int rank) throws ExceptionBoundaryViolation
    {
        if((rank > size) || (0 > rank)) throw new ExceptionBoundaryViolation("Exception : the rank demanded is out of boundary.\n");

        Object interm = tab[rank];
        for(int i = size ; i > rank ; i--) tab[i-1] = tab[i];
        size--;
        return interm;
    }
}