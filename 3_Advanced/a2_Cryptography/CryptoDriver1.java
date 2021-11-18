
public class CryptoDriver1
{

    public static void main(String args []) throws Exception
    {
    	Crypto crypt = new Crypto();
    	
    	// Example 1
        String target="demouserpassword";
        String encrypted = crypt.encrypt(target);
        String decrypted = crypt.decrypt(encrypted);
        System.out.println("\nString To Encrypt: "+ target);
        System.out.println("\nEncrypted String: " + encrypted);
        System.out.println("\nDecrypted String: " + decrypted);
        System.out.print("\n\n");
        
        // Example 2
		String hamlet = "To be, or not to be, that is the question: "
				+ "Whether 'tis nobler in the mind to suffer The "
				+ "slings and arrows of outrageous fortune, Or to "
				+ "take Arms against a Sea of troubles, And by "
				+ "opposing end them: to die, to sleep; No more; and "
				+ "by a sleep, to say we end The heart-ache, and the "
				+ "thousand natural shocks That Flesh is heir to? "
				+ "'Tis a consummation Devoutly to be wished. To die, "
				+ "to sleep, To sleep, perchance to Dream; aye, there's "
				+ "the rub, For in that sleep of death, what dreams "
				+ "may come, When we have shuffled off this mortal "
				+ "coil, Must give us pause.";
        encrypted = crypt.encrypt(hamlet);
        decrypted = crypt.decrypt(encrypted);
        System.out.println("\nString To Encrypt: "+ hamlet);
        System.out.println("\nEncrypted String: " + encrypted);
        System.out.println("\nDecrypted String: " + decrypted);
    }

}
