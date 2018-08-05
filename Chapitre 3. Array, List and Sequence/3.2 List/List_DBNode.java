public class List_DBNode implements List{
    protected int numElem;
    protected DBNode header, tailer;
    
    public List_DBNode(){
        numElem = 0 ;
        header = new DBNode(null, null, null);
        tailer = new DBNode(null, header, null);
        header.setNext(tailer); 
    }

    protected DBNode checkPosition(Position p) throws ExceptionPositionInvalid
    {
        if(p == null) 
            throw new ExceptionPositionInvalid("Exception : the position sent to List_DBNode is not valid.\n");
        if(header == null)
            throw new ExceptionPositionInvalid("Exception : the header of List_DBNode is null.\n");
        if(tailer == null)
            throw new ExceptionPositionInvalid("Exception : the tailer of List_DBNode is null.\n");
        
        DBNode interm = (DBNode) p;
        return interm;
    }

    public int getSize(){   return numElem ; }

    public boolean isEmpty(){   return (numElem == 0) ; }

    public Position first() 
    throws ExceptionListEmpty
    {
        if(isEmpty()) throw new ExceptionListEmpty("Exception : the list is empty.\n");
        return header.getNext();
    }

    public Position last() 
    throws ExceptionListEmpty
    {
        if(isEmpty()) throw new ExceptionListEmpty("Exception : the list is empty.\n");
        return tailer.getPrev();
    }

    public Position getPrev(Position p) 
    throws ExceptionBoundaryViolation, ExceptionPositionInvalid
    {
        DBNode v = checkPosition(p);
        DBNode prev = v.getPrev();

        if(prev == header) throw new ExceptionBoundaryViolation("Exception : tended to pass off the header.\n");
        return prev;
    }

    public Position getNext(Position p) 
    throws ExceptionBoundaryViolation, ExceptionPositionInvalid
    {
        DBNode v = checkPosition(p);
        DBNode next = v.getNext();

        if(next == tailer) throw new ExceptionBoundaryViolation("Exception : tended to pass off the tailer.\n");
        return next;
    }

    public Position insertBefore(Position p , Object ele) 
    throws ExceptionPositionInvalid
    {
        DBNode v = checkPosition(p);
        numElem++;
        DBNode newNode = new DBNode(element, v.getPrev(), v);
        v.getPrev().setNext(newNode);
        v.setPrev(newNode);
        return newNode;
    }

    public Position insertFirst(Object ele)
    {
        numElem++;
        DBNode newNode = new DBNode(ele , header, header.getNext());
        heder.getNext().setPrev(newNode);
        header.setNext(newNode);
        return newNode;        
    }

    public Position insertLast(Object ele)
    {
        numElem++;
        DBNode newNode = new DBNode(ele , tailer.getPrev(), tailer);
        if(null == tailer.getPrev()) System.out.println("!!!Prev of tailer is null.");
        tailer.getprev().setnext(newNode);
        tailer.setprev(newNode);
        return newNode;
    }

    public Object remove(Position p)
    throws ExceptionPositionInvalid
    {
        DBNode v = checkPosition(p);
        numElem--;
        DBNode vPrev = v.getPrev();
        DBNode vNext = v.getNext();

        vPrev.setNext(vNext);
        vNext.setPrev(vPrev);

        Object Elem = v.getElem();
        v.setNext(null);
        v.setPrev(null);
        return Elem;
    }

    public Object removeFirst()
    {   return remove(header.getNext()) ; }

    public Object removeLast()
    {   return remove(tailer.getPrev()) ; }

    public Object replace(Position p , Object ele)
    throws ExceptionPositionInvalid
    {
        DBNode v = checkPosition(p);
        Object oldElem = v.getElem();
        v.setElem(ele);
        return oldElem;
    }

    public Iterator positions()
    {   return new IteratorPositon(this) ; }

    public Iterator elements()
    {   return new IteratorElements(this) ; }
}