public class IteratorPosition implements Iterator{
    private List list;
    private Position nextPosition;

    public IteratorPosition(){  list = null ; }

    public IteratorPosition(List L)
    {
        list = L ; 
        if(list.isEmpty())
            nextPosition = null ; 
        else 
            nextPosition = list.first();
    }

    public boolean hasNext(){   return (nextPosition != null) ; }
    
    public Object getNext() 
    throws ExceptionNoSuchElement
    {
        if
    }
}