package es.bgfabogados.web.controller.impl;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import es.bgfabogados.web.exception.impl.ResourceNotFoundException;

/**
 * MVC Controller for managing request not caught by other controllers.
 * 
 * @author juan-diego
 */
@Controller
public class DefaultController {

	/**
	 * <p>
	 * Configuration parameters.
	 * </p>
	 * <p>
	 * It eases the process of inject configuration in the main class.
	 * </p>
	 * 
	 * @author ETP2227
	 */
	public static class Configuration {
		/**
		 * Resource where views have been defined.
		 */
		private Resource xmlConfigResource;

		/**
		 * xPath that will return all views
		 */
		private String xPath;

		/**
		 * @return xPath
		 */
		public String getxPath() {
			return xPath;
		}

		/**
		 * @param xPath
		 *            Expression to set.
		 */
		public void setxPath(String xPath) {
			this.xPath = xPath;
		}

		/**
		 * @return the xmlConfigResource
		 */
		public Resource getXmlConfigResource() {
			return xmlConfigResource;
		}

		/**
		 * @param xmlConfigResource
		 *            the xmlConfigResource to set
		 */
		public void setXmlConfigResource(Resource xmlConfigResource) {
			this.xmlConfigResource = xmlConfigResource;
		}

		public static boolean isValid(Configuration configuration) {
			return configuration != null
					&& configuration.xmlConfigResource != null
					&& configuration.xPath != null;
		}
	}

	/**
	 * Set of available views.
	 */
	private Set<String> viewsSet = new HashSet<String>();

	/**
	 * Controller's configuration
	 */
	private DefaultController.Configuration configuration;

	/**
	 * @param configuration
	 *            configuration to set.
	 */
	@Autowired(required = true)
	public void setConfiguration(DefaultController.Configuration configuration) {
		this.configuration = configuration;
	}

	/**
	 * Set an attribute 'page' in the model that contains the name of the
	 * invoked page.
	 * 
	 * @param page
	 *            Name of the invoked page.
	 * @return A new {@link ModelMap} instance that contains one attribute named
	 *         'page'.
	 */
	@RequestMapping("/{page}.xhtml")
	public ModelAndView setModel(@PathVariable String page) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.getModel().put("page", page);
		if (canHandle(page)) {
			modelAndView.setViewName(page);
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append("Page ").append(page).append(".xhtml")
					.append(" not found.");
			throw new ResourceNotFoundException();
		}
		return modelAndView;
	}

	/**
	 * Validate if the view resolver will be able to handle the view.
	 * 
	 * @param viewName
	 *            A view name.
	 * @return True if the view can be resolved or false in any other case.
	 */
	private boolean canHandle(String viewName) {
		if (viewName == null) {
			return false;
		} else {
			return viewsSet.contains(viewName);
		}
	}

	/**
	 * Load view information from the file set in the configuration.
	 */
	@PostConstruct
	public void init() {
		// Validate configuration
		if (!Configuration.isValid(configuration)) {
			throw new IllegalStateException(
					"Configuration has not been properly set. It or any of its properties is null.");
		}

		// Load configuration
		try {
			loadViewNames();
		} catch (Exception e) {
			throw new IllegalStateException(
					"Configuration could not be loaded.", e);
		}
	}

	/**
	 * Load viewNames from the configuration file by applying the xPath
	 * expression on the views configuration file.
	 * 
	 * @throws XPathExpressionException
	 *             If any error occurs when applying xPath expression. Or if the
	 *             expression returns no elements.
	 * @throws ParserConfigurationException
	 *             If file can not be parsed as a XML document.
	 * @throws SAXException
	 *             If file can not be parsed as a XML document.
	 * @throws IOException
	 *             If the file does not exist or it can not be read.
	 */
	private void loadViewNames() throws XPathExpressionException,
			ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		dBuilder.setEntityResolver(new EntityResolver() {
			/**
			 * Disables DOCTYPE validation just in case DTD URL can not be
			 * resolved.
			 */
			@Override
			public InputSource resolveEntity(String publicId, String systemId) {
				return new InputSource(new StringReader(""));
			}
		});
		InputSource inSource = new InputSource(configuration
				.getXmlConfigResource().getFile().getAbsolutePath());
		Document document = dBuilder.parse(inSource);

		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();

		NodeList nl = (NodeList) xpath.evaluate(configuration.getxPath(),
				document, XPathConstants.NODESET);
		if (nl == null) {
			throw new XPathExpressionException("Expression "
					+ configuration.getxPath() + " did no return elements.");
		}

		for (int ind = 0; ind < nl.getLength(); ind++) {
			Node node = nl.item(ind);
			if (node != null) {
				viewsSet.add(node.getTextContent());
			}
		}
	}
}
