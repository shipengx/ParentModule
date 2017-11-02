package org.Security;

public interface CipherService {
	
	/**
	 * Encrypt the input
	 * 
	 * @param input
	 * @return ciphertext
	 */
	public String encrypt( String plainText ) throws Exception;
	
	/**
	 * Decrypt the cipherText to the original plaintext.
	 * 
	 * Note, the cipherText must have been generated using the same 
	 * CipherService
	 * 
	 * @param cipherText
	 * @return
	 * @throws Exception
	 */
	public String decrypt( String cipherText ) throws Exception;

}