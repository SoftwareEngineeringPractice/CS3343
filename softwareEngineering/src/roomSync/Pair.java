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
    
    @Override
	public boolean equals(Object p1)
	{
		Pair p = (Pair) p1;
		if(p.getLeft().equals(this.left) && p.getRight().equals(this.right))
			return true;
		return false;
	}
    

}