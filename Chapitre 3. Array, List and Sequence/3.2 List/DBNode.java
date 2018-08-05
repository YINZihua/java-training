public class DBNode implements Position{
    public Object ele;
    private DBNode prev;
    private DBNode next;

    //fonctions de constructeur
        public DBNode()
        {   this(null , null , null) ; }

        public DBNode(Object e , DBNode p , DBNode n)
        {   ele = e ; prev = p ; next = n ; }

    //opération sur ce noeud
        public Object getElem()
        {   return ele ; }

        public Object setElem(Object e)
        {   ele = e ;  return ele  ;}

    //information pour le prochain et le dernier
        public DBNode getNext()
        {   return next ; }

        public DBNode getPrev()
        {   return prev ; }

//modification sur les citations des dernier et prochain
        public void setNext(DBNode n)
        {   next = n ; }

        public void setPrev(DBNode p)
        {   prev = p ; }
}