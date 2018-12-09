package com.openlab.utils;

import com.openlab.exception.FormatErrorException;

public final class VerifyTools {
	// 格式正确时返回true，错误是抛出错误异常
	public static boolean formatVerify(String type, String str)
			throws FormatErrorException {
		if ("username".equals(type)) {
			return isUsernameFormat(str);
		} else if ("password".equals(type)) {
			return true;

		} else if ("nickname".equals(type)) {
			return true;

		} else if ("email".equals(type)) {
			return true;

		} else if ("phone".equals(type)) {
			return true;

		} else if ("loginUsername".equals(type)) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isUsernameFormat(String username)
			throws FormatErrorException {
		if (username.length() < 4)
			throw new FormatErrorException("用户名过短");
		else {
			return true;
		}
	}

}
