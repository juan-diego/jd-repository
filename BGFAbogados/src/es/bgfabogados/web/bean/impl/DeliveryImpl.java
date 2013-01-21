package es.bgfabogados.web.bean.impl;

import java.io.Serializable;

import es.bgfabogados.web.bean.IDelivery;

/**
 * Represents a delivery.
 * 
 * @author juan-diego
 */
public class DeliveryImpl implements IDelivery, Serializable {
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
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
