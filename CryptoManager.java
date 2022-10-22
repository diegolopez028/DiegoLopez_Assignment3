/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: Encrypt and Decrypt 
 * Due: 10/21/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Diego Lopez________
*/

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) 
	{
		boolean flag = true;
		for(int j = 0; j < plainText.length()-1;j++)
		{
			char i = plainText.charAt(j);
			
			if((char)i < LOWER_RANGE && (char)i > UPPER_RANGE) // check range
			{
				 flag = false;
				 break;
				
			}
		}
		return flag;
		
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
	
		String encryptedText = "";
		
		for(int i = 0; i < plainText.length();i++)
		{
			int c = plainText.charAt(i);
			int k = c + key;
			while(k > 95)
			{
				k -= 64;
			}
			encryptedText += (char)k;
				
		}
	
		return encryptedText;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	
	public static String bellasoEncryption (String plainText, String bellasoStr) 
	{
		String encryptedText = "";
		int max = 95;
		int min = 32;
		int count = 0;
		for(int j = bellasoStr.length()-1 ; j < plainText.length(); j++)
		{
			if(j == bellasoStr.length())
			{
				bellasoStr += bellasoStr.charAt(j);
				count = 0; // to reset the string and add teh 1st char
			}
			bellasoStr += bellasoStr.charAt(count);
			count += 1;
			
		}
		for(int y = 0; y < plainText.length(); y++)
		{
			int c = plainText.charAt(y);
			int h = bellasoStr.charAt(y);

			int ch = c + h - 64;
			if(ch > (int)UPPER_RANGE)
			{
				int diff = ch - max - 1 ;
				ch = min + diff;
			}
			if(ch < (int)LOWER_RANGE)
			{
				int diff5 = min - ch - 1;
				ch = max - diff5;
			}
			encryptedText += (char)ch;
		}
		return encryptedText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	
	public static String caesarDecryption(String encryptedText, int key) 
	{

		String plainText = "";
		
		for(int i = 0; i < encryptedText.length();i++)
		{
			int a = encryptedText.charAt(i);
			int h = a - key;
			while(h < 32)
			{
				h += 64;
			}
			plainText += (char)h;
			
		}
		
	
		return plainText;
	
		
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
	 
		String BacktoPlaintext = "";
		int max = 95;
		int min = 32;
		int count = 0;
		for(int j = bellasoStr.length()-1 ; j < encryptedText.length(); j++)
		{
			if(j == bellasoStr.length())
			{
				bellasoStr += bellasoStr.charAt(j);
				count = 0;
			}
			bellasoStr += bellasoStr.charAt(count);
			count += 1;
			
		}
		for(int p = 0; p < encryptedText.length(); p++)
		{
			
			int c1 = encryptedText.charAt(p);
			int h1 = bellasoStr.charAt(p);
			int c1h1 = c1 - h1 + 64;
			if(c1h1 > (int)UPPER_RANGE)
			{
				int diff31 = c1h1 - max - 1;
				c1h1 = min + diff31;
				 
			}
			if(c1h1 < (int)LOWER_RANGE)
			{
				int diff5 = min - c1h1 - 1;
				c1h1 = max - diff5;
				
			}
			
			BacktoPlaintext += (char)c1h1;
			
		}
		return BacktoPlaintext;
	}
}
