public interface Vector{
    public int getSize();
    public boolean isEmpty();
    public Object getAtRank(int rank) throws ExceptionBoundaryViolation;
    public Object replaceAtRank(int rank, Object ele) throws ExceptionBoundaryViolation;
    public Object insertAtRank(int rank, Object ele) throws ExceptionBoundaryViolation;
    public Object removeAtRank(int rank, Object ele) throws ExceptionBoundaryViolation;
}