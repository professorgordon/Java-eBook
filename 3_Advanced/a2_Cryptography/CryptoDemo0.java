
public class CryptoDemo0
{
	public static void main(String[] args) 
	{
		String message = "To be or not to be, that is the question";
		System.out.println("\nOriginal: " + message);
		message = reverseString(message);
		System.out.println("\nEncrypted: " + message);
		message = reverseString(message);
		System.out.println("\nDecrypted: " + message);
	}

	private static String reverseString(String s)
	{
		char ch[] = s.toCharArray();
		String rev = "";
		for (int i = ch.length - 1; i >= 0; i--)
		{
			rev += ch[i];
		}
		return rev;
	}

}
