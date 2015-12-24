package security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SHA1PasswordEncoder implements PasswordEncoder {

	private String digestAlgorithm = "SHA-1";
	private String charset = "UTF-8";

	@Override
	public String encode(CharSequence rawPassword) {
		try {
			MessageDigest messageDigest = MessageDigest
					.getInstance(digestAlgorithm);
			messageDigest.update(rawPassword.toString().getBytes(charset));
			byte[] digest = messageDigest.digest();
			return new String(Hex.encode(digest));
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("No such algorithm ["
					+ digestAlgorithm + "]");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("Unsupported encoding ["
					+ charset + "]");
		}
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String pass1 = "" + encodedPassword;
		String pass2 = encode(rawPassword);

		return equals(pass1, pass2);
	}

	/**
	 * Constant time comparison to prevent against timing attacks.
	 * 
	 * @param expected
	 * @param actual
	 * @return
	 */
	static boolean equals(String expected, String actual) {
		byte[] expectedBytes = bytesUtf8(expected);
		byte[] actualBytes = bytesUtf8(actual);
		int expectedLength = expectedBytes == null ? -1 : expectedBytes.length;
		int actualLength = actualBytes == null ? -1 : actualBytes.length;
		if (expectedLength != actualLength) {
			return false;
		}

		int result = 0;
		for (int i = 0; i < expectedLength; i++) {
			result |= expectedBytes[i] ^ actualBytes[i];
		}
		return result == 0;
	}

	private static byte[] bytesUtf8(String s) {
		if (s == null) {
			return null;
		}

		return Utf8.encode(s);
	}

}
