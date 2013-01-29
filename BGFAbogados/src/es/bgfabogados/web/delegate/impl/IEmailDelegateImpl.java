package es.bgfabogados.web.delegate.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

import es.bgfabogados.web.bean.IDelivery;
import es.bgfabogados.web.bean.IEmail;
import es.bgfabogados.web.bean.IEmailContent;
import es.bgfabogados.web.bean.IEmailTemplate;
import es.bgfabogados.web.bean.impl.DeliveryImpl;
import es.bgfabogados.web.bean.impl.EmailContentImpl;
import es.bgfabogados.web.bean.impl.EmailImpl;
import es.bgfabogados.web.bean.impl.EmailTemplateImpl;
import es.bgfabogados.web.delegate.IEmailDelegate;

/**
 * Delegate for eMails management.
 * 
 * @author juan-diego
 */
@Controller
public class IEmailDelegateImpl implements IEmailDelegate {
	
	/**
	 * Template used for composing the emails.
	 */
	private IEmailTemplate emailTemplate = new EmailTemplateImpl();

	/**
	 * @param emailHtmlTemplate the emailHtmlTemplate to set. Can not be null.
	 * @throws IOException If template content can not be loaded.
	 */
	@Autowired(required=true)
	@Qualifier("emailHtmlTemplate")
	public void setEmailHtmlTemplate(Resource template) throws IOException {
		if (template == null) {
			throw new IllegalArgumentException("Argument 'template' can not be null.");
		}
		this.emailTemplate.loadHtmlTemplate(template.getFilename());
	}

	/**
	 * @param emailTextTemplate the emailTextTemplate to set. Can not be null.
	 * @throws IOException If template content can not be loaded.
	 */
	@Autowired(required=true)
	@Qualifier("emailTextTemplate")
	public void setEmailTextTemplate(Resource template) throws IOException {
		if (template == null) {
			throw new IllegalArgumentException("Argument 'template' can not be null.");
		}
		this.emailTemplate.loadTextTemplate(template.getFilename());
	}

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
