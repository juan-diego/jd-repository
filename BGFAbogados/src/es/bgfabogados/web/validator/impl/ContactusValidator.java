package es.bgfabogados.web.validator.impl;

import java.util.regex.Pattern;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;

import es.bgfabogados.web.form.impl.ContactusFormImpl;

@Component
public class ContactusValidator {

	/**
	 * Pattern for validating eMail address.
	 */
	private static final Pattern VALID_EMAIL_PATTERN = Pattern
			.compile("^[^@]+@[^@]+\\.[^@.]+$");

	public void validateEnterContactusDetails(ContactusFormImpl form,
			ValidationContext context) {
		MessageContext messages = context.getMessageContext();
		// User's name
		if (isEmpty(form.getName())) {
			messages.addMessage(new MessageBuilder().error().source("name").
	                code("contactus.validator.error-empty-name").build());
		}
		// Contact address
		if (isEmpty(form.getEmail())) {
			messages.addMessage(new MessageBuilder().error().source("email").
					code("contactus.validator.error-empty-email").build());
		} else if (!applyPattern(VALID_EMAIL_PATTERN, form.getEmail())) {
			messages.addMessage(new MessageBuilder().warning().source("email").
					code("contactus.validator.error-invalid-email").build());
		}
		// Comment
		if (isEmpty(form.getSubject())) {
			messages.addMessage(new MessageBuilder().error().source("subject").
					code("contactus.validator.error-empty-subject").build());
		}
		// Comment
		if (isEmpty(form.getComments())) {
			messages.addMessage(new MessageBuilder().error().source("comments").
					code("contactus.validator.error-empty-comments").build());
		}
	}

	/**
	 * @param text
	 *            String to check
	 * @return True if it is null or empty
	 */
	private boolean isEmpty(String text) {
		return text == null || text.isEmpty();
	}

	/**
	 * Applies a pattern on a value.
	 * 
	 * @param pattern Any non null value.
	 * @param Value Any non null value.
	 * @return True if the value match the pattern or False in any other case.
	 */
	private boolean applyPattern(Pattern pattern, String value) {
		if (value == null || value.isEmpty()) {
			return true;
		}
		return pattern.matcher(value).matches();
	}

}
