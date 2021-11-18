
public class CryptoDemo1
{

	public static void main(String[] args) 
	{
		String message = "To be or not to be, that is the question";
		System.out.println("\nOriginal: " + message);
		message = encrypt(message);
		System.out.println("\nEncrypted: " + message);
		message = decrypt(message);
		System.out.println("\nDecrypted: " + message);
	}

	private static String encrypt(String s)
	{
		int key = 10;
		String enc = "";
		char[] chArray = s.toCharArray();
		for (char c : chArray)
		{
			enc = enc + (c += key);
		}
		return enc;
	}

	private static String decrypt(String e)
	{
		int key = 10;
		String dec = "";
		char[] chArray = e.toCharArray();
		for (char c : chArray)
		{
			dec = dec + (c -= key);
		}
		return dec;
	}

}
