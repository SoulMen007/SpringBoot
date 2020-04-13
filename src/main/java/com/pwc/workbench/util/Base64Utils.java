package com.pwc.workbench.util;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class Base64Utils {
	private static final String UNICODE_FORMAT = "UTF8";
	private static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	private static Cipher cipher;
	private static SecretKey secretKey;

	private static void init() {
		String privateKey = "ThisISPWCKeysecretForLIC";
		try {
			byte[] arrayBytes = privateKey.getBytes(UNICODE_FORMAT);
			KeySpec ks = new DESedeKeySpec(arrayBytes);
			SecretKeyFactory skf = SecretKeyFactory.getInstance(DESEDE_ENCRYPTION_SCHEME);
			cipher = Cipher.getInstance(DESEDE_ENCRYPTION_SCHEME);
			secretKey = skf.generateSecret(ks);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String encrypt(String unencryptedString){
		init();
		String encryptedString = null;
		try {
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
			byte[] encryptedText = cipher.doFinal(plainText);
			encryptedString = new String(Base64.encodeBase64(encryptedText));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptedString;
	}

	public static String decrypt(String encryptedString) {
		init();
		String decryptedText = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] encryptedText = Base64.decodeBase64(encryptedString);
			byte[] plainText = cipher.doFinal(encryptedText);
			decryptedText = new String(plainText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptedText;
	}

	public static void main(String args[])  {
		String target = "2018-04-10";
		String encrypted = encrypt(target);
		String decrypted = decrypt("4IJvPkEt+UHlVzQWLHZYYQ==");

		System.out.println("String To Encrypt: " + target);
		System.out.println("Encrypted String:" + encrypted);
		System.out.println("Decrypted String:" + decrypted);

	}

}
