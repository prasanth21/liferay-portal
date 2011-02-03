/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.test.TestCase;

/**
 * @author Shuyang Zhou
 */
public class ValidatorTest extends TestCase {

	public void testIsNull() throws Exception {
		String[] nullStrings = {
			null, "", "  ", "null", " null", "null ", "  null  "
		};

		for (String nullString : nullStrings) {
			assertTrue(Validator.isNull(nullString));
		}

		String[] notNullStrings = {
			"a", "anull", "nulla", " anull", " nulla ","  null  a"
		};

		for (String notNullString : notNullStrings) {
			assertFalse(Validator.isNull(notNullString));
		}
	}

	public void testIsValidEmailAddress() throws Exception {
		String[] validEmailAddresses = {
			"email@domain.com", "firstname.lastname@domain.com",
			"firstname+lastname@domain.com", "123456789@domain.com",
			"email@domain-one.com", "____@domain.com", "email@domain.name",
			"firstname-lastname@domain.com"
		};

		for (String validEmailAddress : validEmailAddresses) {
			assertTrue(Validator.isEmailAddress(validEmailAddress));
		}

		String[] invalidEmailAddresses = {
			"domain",  "#$%^&.com", "joe smith <email@domain.com",
			"email.domain.com", "email@domain@domain.com",
			"email@domain.com (joe smith)", "email@domain"
		};

		for (String invalidEmailAddress : invalidEmailAddresses) {
			assertFalse(Validator.isEmailAddress(invalidEmailAddress));
		}
	}

}