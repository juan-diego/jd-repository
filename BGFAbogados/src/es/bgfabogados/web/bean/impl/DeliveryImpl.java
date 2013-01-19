package es.bgfabogados.web.bean.impl;

import es.bgfabogados.web.bean.IDelivery;

/**
 * Represents a delivery.
 * 
 * @author juan-diego
 */
public class DeliveryImpl implements IDelivery {
	
	/**
	 * Current status.
	 */
	private IDelivery.Status status;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSent() {
		return (IDelivery.Status.Success.equals(this.status));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean getSent() {
		return isSent();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Status getStatus() {
		return this.status;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStatus(Status status) {
		this.status = status;		
	}

}
