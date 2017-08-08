package tst.project.utils;

import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Sha1Utils {

	public static String sha1(String data) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("SHA1");

		md.update(data.getBytes());

		StringBuffer buf = new StringBuffer();

		byte[] bits = md.digest();

		for (int i = 0; i < bits.length; i++) {

			int a = bits[i];

			if (a < 0)
				a += 256;

			if (a < 16)
				buf.append("0");

			buf.append(Integer.toHexString(a));

		}

		return buf.toString();

	}
}
