package roomSync;
public class Pair 
{

    private final Person left;
    private final Person right;

    public Pair(Person aKey, Person aValue)
    {
        left   = aKey;
        right = aValue;
    }

    public Person getLeft()   { return left; }
    public Person getRight() { return right; }
  
    @Override
    public String toString()
    {
    	return left.getName() + " -- " + right.getName();
    }
    
    
    

}