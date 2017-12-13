package com.shipeng.bit;

/*
 * UTF-8 validation
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 * 1. For 1-byte character, the first bit is a 0, followed by its unicode code.
 * 2. For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
 * 
 * This is how the UTF-8 encoding would work:
 * 
 * 
 */

public class UTF8Validation {

}
