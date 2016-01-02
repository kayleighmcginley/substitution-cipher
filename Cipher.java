import javax.swing.JOptionPane;
import java.util.Random;

public class Cipher {
	public static void main(String [] args) {
		try{
			char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v',
					'w','x','y','z',' '};
			char[] cipher = new char [alphabet.length];
					
			String message = JOptionPane.showInputDialog(null, "Please enter your message to be converted to cipher code.");
			String lowercaseMessage = message.toLowerCase();
	
			char[] messageArray = lowercaseMessage.toCharArray();
			char[] cipherRef = createCipher(alphabet, cipher);
						
			 Object[] options = {"Decrypt", "End"};
				int decryptOption = JOptionPane.showOptionDialog(null,"Encrypted message: " + 
						encrypt(messageArray, cipherRef, alphabet) +"\nWould you like to decrypt this message?", 
							null, JOptionPane.YES_NO_OPTION,	JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				
				if(decryptOption == JOptionPane.YES_OPTION)
				{
					JOptionPane.showMessageDialog(null, "Decrypted message: " + decrypt(messageArray, cipherRef, alphabet));
				}
				else
				{
			    	System.exit(0);
				}
		}
		catch (NullPointerException exception)
	    {   	
	    	System.exit(0);
	    }
	}
	public static char[] createCipher(char[] alphabet, char[] cipher) {
		char[] alphabetCopy = new char [alphabet.length];
		for (int index = 0; index < alphabet.length;  index++)
			alphabetCopy[index] = alphabet[index];
		int index = 0;
		int index2 = 0;
		Random randomGenerator = new Random();
		for (index = 0; index < cipher.length; index++)
		{
			index2 = randomGenerator.nextInt(alphabetCopy.length);
			if(alphabetCopy[index2] != '*')
			{
				cipher[index] = alphabetCopy[index2];
				alphabetCopy[index2] = '*';
			}
			else if(alphabetCopy[index2] == '*')
			{
				index--;
			}
		}	
		return cipher;
	}
	public static String encrypt(char[] messageArray, char[] cipherRef, char[] alphabet) {
		String encryptedText = "";
		int index2 = 0;
		int index = 0;
		if (messageArray != null)
		{
			for (index = 0; index < messageArray.length; index++)
			{
				for (index2 = 0; index2 < alphabet.length; index2++)
				{
					if(messageArray[index] == alphabet[index2])			
					{
						messageArray[index] = cipherRef[index2];
						break;
					}
				}
			}
		}
		encryptedText = new String(messageArray);
		return encryptedText;
	}
	public static String decrypt(char[] messageArray, char[] cipherRef, char[] alphabet) {
		String decryptedText = "";		
		int index2 = 0;
		int index = 0;		
		if (messageArray != null)
		{
			for (index = 0; index < messageArray.length; index++)
			{
				for (index2 = 0; index2 < cipherRef.length; index2++)
				{
					if(messageArray[index] == cipherRef[index2])			
					{
						messageArray[index] = alphabet[index2];
						break;
					}
				}
			}
		}
		decryptedText = new String(messageArray);
		return decryptedText;
	}	
}