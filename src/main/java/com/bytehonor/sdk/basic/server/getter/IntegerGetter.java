package com.bytehonor.sdk.basic.server.getter;

import java.util.Objects;

import com.bytehonor.sdk.basic.lang.string.StringCreator;
import com.bytehonor.sdk.basic.server.exception.ParameterExcption;
import com.bytehonor.sdk.basic.server.validate.IntegerValidate;

public class IntegerGetter {

	public static Integer requireRange(Integer src, int min, int max, String message) {
		Objects.requireNonNull(src, message);
		return optionalRange(src, min, max, message);
	}

	public static Integer optionalRange(Integer src, int min, int max, String message) {
		if (src != null) {
			IntegerValidate.range(src, min, max, message);
		}
		return src;
	}

	public static Integer requireRange(String src, int min, int max, String message) {
		Objects.requireNonNull(src, message);
		return optionalRange(src, min, max, message);
	}

	public static Integer optionalRange(String src, int min, int max, String message) {
		if (src == null) {
			return null;
		}
		return optionalRange(parse(src), min, max, message);
	}

	public static Integer parse(String src) {
		try {
			return Integer.valueOf(src);
		} catch (Exception e) {
			throw new ParameterExcption(StringCreator.create().append(src).append(" is not number ").toString());
		}
	}

	public static Integer require(String src, Integer def) {
	    if (src == null) {
            return def;
        }
		try {
			return parse(src);
		} catch (Exception e) {
			return def;
		}
	}
	
	public static Integer require(Integer src, Integer def) {
		return src != null ? src : def;
	}
}