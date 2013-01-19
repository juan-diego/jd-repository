package es.bgfabogados.web.bean;

/**
 * Represents a delivery.
 * 
 * @author juan-diego
 */
public interface IDelivery {

	enum Status { Success, Failed };
	
	/**
	 * @return {@code true} if current delivery status implies that it was successfully sent.
	 * In any other case it will return {@code false}
	 */
	boolean isSent();
	
	/**
	 * @return {@code true} if current delivery status implies that it was successfully sent.
	 * In any other case it will return {@code false}
	 */
	boolean getSent();
	
	/**
	 * @return Current delivery status.
	 */
	Status getStatus();
	
	/**
	 * @param status New status to set.
	 */
	void setStatus(Status status);
}
