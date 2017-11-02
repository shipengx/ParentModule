package org.Security;

public class SimpleTextEncryption {

	public static void main(String[] args) {
	
		byte[] keyValue =
	            new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
		String inputStr = "shipeng is awesome";
		
		try {
			CipherService cipherService = new CipherServiceImpl(keyValue);
		    String encryptedStr = cipherService.encrypt(inputStr);
		    System.out.println("encrypted str: " + encryptedStr);
		    
		    String decryptedStr = cipherService.decrypt(encryptedStr);
		    System.out.println("decrypted str: " + decryptedStr);
		    
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
