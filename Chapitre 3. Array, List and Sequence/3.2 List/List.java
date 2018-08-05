public interface List{
    public int getSize();
    public boolean isEmpty();
    public Position first();
    public Position last();
    public Position getNext(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation;
    public Position getPrev(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation;
    public Position insertFirst(Object e);
    public Position insertLast(Object e);
    public Position insertAfter(Position p , Object ele) throws ExceptionPositionInvalid;
    public Object remove(Position p) throws ExceptionPositionInvalid;
    public Object removeFirst();
    public Object removeLast();
    public Object replace(Position p , Object ele) throws ExceptionPositionInvalid;

    public Iterator positions();
    public Iterator elements();
}