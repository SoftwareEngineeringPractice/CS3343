/**
 * 
 */
package poker;

// TODO: Auto-generated Javadoc
/**
 * The Class Poker.
 *
 * @author SUHAG BA
 */
public class Poker 
{
	
	/**
	 * Checks if is full house.
	 *
	 * @param cards the cards
	 * @param n the n
	 * @return true, if is full house
	 */
	/***
	 * Changes made here
	 */
	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isFullHouse(String cards[], int n)
	{
		return isThreeOfaKind(cards, n) && isTwoPairs(cards, n);
	}

	/**
	 * Checks if is three ofa kind.
	 *
	 * @param cards the cards
	 * @param n the n
	 * @return true, if is three ofa kind
	 */
	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isThreeOfaKind(String cards[], int n)
	{
		for (int i=0; i<n-2; i++)
		{
			if (cards[i].charAt(1) == cards[i+1].charAt(1) &&
					cards[i+1].charAt(1) == cards[i+2].charAt(1))
					return true;
		}

		return false;
	}

	/**
	 * Checks if is two pairs.
	 *
	 * @param cards the cards
	 * @param n the n
	 * @return true, if is two pairs
	 */
	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isTwoPairs(String cards[], int n)
	{
		int count = 0;
		for (int i=0; i<n-1; i++)
		{
			if (cards[i].charAt(1) == cards[i+1].charAt(1))
			{
				count++;
				i++;
			}
		}
		if (count == 2)
			return true;
		else
			return false;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[])
	{
		System.out.println(new Poker().isFullHouse(
			new String[] {"C2", "D2", "H2", "S3", "S4"}, 5));
	}
	/**
	 * Changes made here
	 * 
	 */
}
// end of Poker.java
