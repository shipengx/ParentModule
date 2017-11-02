package org.Security;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;


public class CipherServiceImpl implements CipherService {
	
	//package private
	CipherServiceImpl( byte[] keyBytes ) throws Exception {
		//expect key is the correct # of bytes
		
		// use 2 different key and cipher instances for encrypting & decrypting
		// - to avoid concurrent access issues
		{
			Key encipherKey = new SecretKeySpec( keyBytes, KEY_TYPE );
			encipher = Cipher.getInstance( TRANSFORMATION );
			encipher.init( Cipher.ENCRYPT_MODE, encipherKey );
		}
		
		{
			Key decipherKey = new SecretKeySpec( keyBytes, KEY_TYPE );
			decipher = Cipher.getInstance( TRANSFORMATION );
			decipher.init( Cipher.DECRYPT_MODE, decipherKey );
		}
	}

	//used for encoding
	private final Cipher encipher;
	
	//used for decoding
	private final Cipher decipher;

	private final String KEY_TYPE = "AES";
	private final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
	
	public String decrypt(String cipherText) throws Exception {
			byte[] cipherBytes = Base64.decodeBase64( cipherText );

			//Decrypt the message
			// - must synchronize, Cipher not thread-safe
			byte[] stringBytes = null;			
			synchronized( decipher ) {
				stringBytes = decipher.doFinal(cipherBytes);
			}
		 
			//converts the decoded message to a String
			String clear = new String(stringBytes, "UTF8");
			return clear;
	}

	public String encrypt(String plainText) throws Exception {
		// Gets the raw bytes to encrypt, UTF8 charset standard
		byte[] stringBytes = plainText.getBytes("UTF8");
		
		//Encrypt the message
		// - must synchronize, Cipher not thread-safe		
		byte[] cipherBytes = null;
		synchronized( encipher ) {
			cipherBytes = encipher.doFinal(stringBytes);
		}
		
		return Base64.encodeBase64URLSafeString( cipherBytes );
	}

}