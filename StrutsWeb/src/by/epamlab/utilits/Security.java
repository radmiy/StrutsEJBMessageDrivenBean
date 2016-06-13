package by.epamlab.utilits;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
	public static byte[] criptPass(String password) {
		if(password == null || password.equals("")) {
			return null;
		}

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md.digest(password.getBytes());
	}
}
