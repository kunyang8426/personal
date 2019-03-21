package com.kazma.util;


import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public class MD5 {

	private static String TOKEN_SALT = "tooth";
	private static String PWD_SALT = "pwd";

	public static String createToken(final String plainText) {
		String result = plainText + TOKEN_SALT;
		try {
			final MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			final byte b[] = md.digest();
			int i;
			final StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			result = buf.toString();
		} catch (final NoSuchAlgorithmException e) {
		}
		return result;
	}

	public static String createPwd(final String plainText) {
		String result = plainText + PWD_SALT;
		try {
			final MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			final byte b[] = md.digest();
			int i;
			final StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			result = buf.toString();
		} catch (final NoSuchAlgorithmException e) {
		}
		return result;
	}
}
