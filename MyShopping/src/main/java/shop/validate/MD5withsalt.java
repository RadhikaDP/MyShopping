package shop.validate;


import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class MD5withsalt 
{

    public static String getSecurePassword(String passwordToHash) throws NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException
    { 
    	byte[] salt = getSalt();

    	String salttostring=toHex(salt);
    	
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt);
            //Get the hash's bytes 
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
            System.out.println(" Generated password "+generatedPassword);
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword+":"+salttostring;
    }
     
    //Add salt
    private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
    {
        //Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        sr.nextBytes(salt);
        //return salt
        return salt;
    }
    
    public static String checksecurepassword(String passwordToHash, byte[] salt){
    	String pass = null;
    	
    	  try {
              // Create MessageDigest instance for MD5
              MessageDigest md = MessageDigest.getInstance("MD5");
              //Add password bytes to digest
              md.update(salt);
              //Get the hash's bytes 
              byte[] bytes = md.digest(passwordToHash.getBytes());
              //This bytes[] has bytes in decimal format;
              //Convert it to hexadecimal format
              StringBuilder sb = new StringBuilder();
              for(int i=0; i< bytes.length ;i++)
              {
                  sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
              }
              //Get complete hashed password in hex format
              pass = sb.toString();
          } 
          catch (NoSuchAlgorithmException e) {
              e.printStackTrace();
          }
    	return pass;
    }
   /**
    * 
    * @param hex: conversion of hexadecimal to string
    * @return
    */
    public static byte[] fromHex(String hex)
    {
        byte[] binary = new byte[hex.length() / 2];
        for(int i = 0; i < binary.length; i++)
        {
            binary[i] = (byte)Integer.parseInt(hex.substring(2*i, 2*i+2), 16);
        }
        return binary;
    }

    /**
     * Converts a byte array into a hexadecimal string.
     *
     * @param   array       the byte array to convert
     * @return              a length*2 character string encoding the byte array
     */
    
    public static String toHex(byte[] array)
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0) 
            return String.format("%0" + paddingLength + "d", 0) + hex;
        else
            return hex;
    }
}