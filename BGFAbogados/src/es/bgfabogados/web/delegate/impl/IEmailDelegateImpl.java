package es.bgfabogados.web.delegate.impl;

import org.springframework.stereotype.Controller;

import es.bgfabogados.web.bean.IDelivery;
import es.bgfabogados.web.bean.IEmail;
import es.bgfabogados.web.bean.IEmailContent;
import es.bgfabogados.web.bean.impl.DeliveryImpl;
import es.bgfabogados.web.bean.impl.EmailContentImpl;
import es.bgfabogados.web.bean.impl.EmailImpl;
import es.bgfabogados.web.delegate.IEmailDelegate;

/**
 * Delegate for eMails management.
 * 
 * @author juan-diego
 */
@Controller
public class IEmailDelegateImpl implements IEmailDelegate {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IEmail newEmail() {
		return new EmailImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IEmailContent newContent() {
		return new EmailContentImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IDelivery send(IEmail eMail) {
		IDelivery delivery = new DeliveryImpl();
		delivery.setStatus(IDelivery.Status.Success);
		return delivery;
	}
}
