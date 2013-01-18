package es.bgfabogados.web.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MVC Controller for managing request not caught by other controllers.
 * 
 * @author Juan Diego Suárez
 */
@Controller
public class DefaultController {

	/**
	 * Set an attribute 'page' in the model that contains the name of the invoked page.
	 * 
	 * @param page Name of the invoked page.
	 * @return A new {@link ModelMap} instance that contains one attribute named 'page'.
	 */
	@RequestMapping("/{page}.xhtml")
	public ModelMap setModel(@PathVariable String page) {
		return new ModelMap().addAttribute("page", page);
	}
}
