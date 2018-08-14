package com.bytehonor.standard.spring.boot.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bytehonor.standard.spring.boot.util.PasswordUtils;

public class PasswordUtilsTest {

	@Test
	public void testEncrypt() {
		String pwd = PasswordUtils.encrypt("123456", "609267");
		boolean isOk = "E86F32AE1595BFA91D24D0A51CEAEB42".equals(pwd);
		assertTrue("*testEncrypt*", isOk);
	}

}
