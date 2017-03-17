package aa;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * Encode and decode TinyURL
 * 
 * TinyURL is a URL shortening service where you enter a URL such as 
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL
 * such as http://tinyurl.com/4e9iAk.
 * 
 * Design the encode and decode methods for the TinyURL service.
 * There is not restriction on how your encode/decode algorithm should work.
 * You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 * 
 */

public class EncodeAndDecodeTinyURL {

	Map<String, String> hashToUrl = new HashMap<String, String>();
	Map<String, String> urlToHash = new HashMap<String, String>();
	String tinyUrlBase = "http://tinyurl.com/";
	String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	Random random = new Random();

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		if (urlToHash.containsKey(longUrl)) {
			return tinyUrlBase + urlToHash.get(longUrl);
		}
		StringBuilder hash = new StringBuilder();
		while (hashToUrl.containsKey(hash.toString())) {
			hash.append(chars.charAt(random.nextInt(chars.length())));
		}
		hashToUrl.put(hash.toString(), longUrl);
		urlToHash.put(longUrl, hash.toString());
		return tinyUrlBase + hash.toString();
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return hashToUrl.get(shortUrl.substring(tinyUrlBase.length()));
	}

}
