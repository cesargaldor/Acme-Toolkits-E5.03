/*
 * PhoneFormatter.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.components;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;

import acme.datatypes.Phone;
import acme.framework.helpers.MessageHelper;
import acme.framework.helpers.StringHelper;

public class PhoneFormatter implements Formatter<Phone> {

	// Formatter<Money> interface ---------------------------------------------

	@Override
	public String print(final Phone object, final Locale locale) {
		assert object != null;
		assert locale != null;

		String result;
		String countryCodeText, areaCodeText, numberText;

		countryCodeText = String.format("%d", object.getCountryCode());
		areaCodeText = object.getAreaCode() == null ? " " : String.format(" (%s) ", object.getAreaCode());
		numberText = String.format("%s", object.getNumber());

		result = String.format("+%s%s%s", countryCodeText, areaCodeText, numberText);

		return result;
	}

	@Override
	public Phone parse(final String text, final Locale locale) throws ParseException {
		assert !StringHelper.isBlank(text);
		assert locale != null;

		Phone result;
		String countryCodeRegex, areaCodeRegex, numberRegex, phoneRegex;
		Pattern pattern;
		Matcher matcher;
		String errorMessage;
		String countryCodeText;
		int countryCode;
		String areaCode, number;

		countryCodeRegex = "\\+\\d{1,3}";
		areaCodeRegex = "\\d{1,6}";
		numberRegex = "\\d{1,9}([\\s-]\\d{1,9}){0,5}";
		phoneRegex = String.format( //
			"^\\s*(?<CC>%1$s)(\\s+\\((?<AC>%2$s)\\)\\s+|\\s+)(?<N>%3$s)\\s*$", //
			countryCodeRegex, //
			areaCodeRegex, //
			numberRegex //
		);

		pattern = Pattern.compile(phoneRegex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		matcher = pattern.matcher(text);

		if (!matcher.find()) {
			errorMessage = MessageHelper.getMessage("default.error.conversion", null, "Invalid value", locale);
			throw new ParseException(0, errorMessage);
		}
		countryCodeText = matcher.group("CC");
		countryCode = Integer.parseInt(countryCodeText);
		areaCode = matcher.group("AC");
		number = matcher.group("N");

		result = new Phone();
		result.setCountryCode(countryCode);
		result.setAreaCode(areaCode);
		result.setNumber(number);

		return result;
	}

}
