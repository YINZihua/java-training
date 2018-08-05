public class Vector_ExtArray implements Vector{
    private int N = 8 ;
    private int n ; 
    private Object A[] ;

    public Vector_ExtArray()
    {   A = new Object[N] ; n = 0 ; }

    public int getSize()
    {   return n ; }

    public boolean isEmpty()
    {   return (n == 0) ; }

    public Object getAtRank(int rank) throws ExceptionBoundaryViolation
    {
        if((rank > n) || (0 > rank)) throw new ExceptionBoundaryViolation("Exception : the rank demanded is out of boundary.\n");

        return A[rank];
    }

    public Object replaceAtRank(int rank, Object ele) throws ExceptionBoundaryViolation
    {
        if((rank > n) || (0 > rank)) throw new ExceptionBoundaryViolation("Exception : the rank demanded is out of boundary.\n");

        Object interm = A[rank];
        A[rank] = ele;
        return interm;
    }

    public Object insertAtRank(int rank, Object ele) throws ExceptionBoundaryViolation
    {
        if((rank > n) || (0 > rank)) throw new ExceptionBoundaryViolation("Exception : the rank demanded is out of boundary.\n");
        if(n >= N){
            N *= 2;
            Object B[] = new Object[N];
            for( int i = 0 ; i < n ; i++) B[i] = A[i];
            A = B;
        }

        for(int i = n ; i > rank ; i--) A[i] = A[i-1];
        A[rank] = ele;
        n++;
        return ele;
    }

    public Object removeAtRank(int rank, Object ele) throws ExceptionBoundaryViolation
    {
        if((rank > n) || (0 > rank)) throw new ExceptionBoundaryViolation("Exception : the rank demanded is out of boundary.\n");

        Object interm = A[rank];
        for(int i = rank; i < n ; i--) A[i] = A[i + 1];
        n--;
        return interm;
    } 
}