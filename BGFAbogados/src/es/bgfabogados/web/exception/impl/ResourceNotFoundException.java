package es.bgfabogados.web.exception.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Represents an HTTP Page Not found Exception.
 * 
 * @author juan-diego
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new runtime exception with null as its detail message. The
	 * cause is not initialized, and may subsequently be initialized by a call
	 * to Throwable.initCause(java.lang.Throwable).
	 */
	public ResourceNotFoundException() {
		super();
	}

	/**
	 * Constructs a new runtime exception with the specified detail message.
	 * 
	 * @param message
	 *            The detail message (which is saved for later retrieval by the
	 *            Throwable.getMessage() method).
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}

	/**
	 * <p>
	 * Constructs a new runtime exception with the specified detail message and
	 * cause.
	 * </p>
	 * <p>
	 * Note that the detail message associated with cause is not automatically
	 * incorporated in this runtime exception's detail message.
	 * </p>
	 * 
	 * @param message
	 *            the detail message (which is saved for later retrieval by the
	 *            Throwable.getMessage() method).
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            Throwable.getCause() method). (A null value is permitted, and
	 *            indicates that the cause is nonexistent or unknown.)
	 */
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new runtime exception with the specified cause and a detail
	 * message of (cause==null ? null : cause.toString()) (which typically
	 * contains the class and detail message of cause). This constructor is
	 * useful for runtime exceptions that are little more than wrappers for
	 * other throwables.
	 * 
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            Throwable.getCause() method). (A null value is permitted, and
	 *            indicates that the cause is nonexistent or unknown.)
	 */
	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}
}
