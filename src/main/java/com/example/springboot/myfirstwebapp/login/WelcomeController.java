package com.example.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	// @Autowired
	/*private AuthenticationService authenticationService;

	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	} */
	/*
	 * private Logger logger = LoggerFactory.getLogger(getClass());
	 * 
	 * @RequestMapping("login") public String gotoLoginPage(@RequestParam String
	 * name,ModelMap model) { model.put("name", name);
	 * //System.out.println("Request param is "+name);
	 * logger.debug("Request param is {}",name); return "login"; }
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		// System.out.println("Request param is "+name);

		return "welcome";
	}

	// passing login logout functionality to spring security, hence login.jsp and authentication service.java no more required, keeping it for reference.
	/*@RequestMapping(value = "login", method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		model.put("name", name);
		model.put("password", password);
		if (authenticationService.authenticate(name, password)) {

			// System.out.println("Request param is "+name);

			return "welcome";

		} else {

			model.put("errorMessage", "Invalid Creedentials! Please try again.");

			return "login";
		}

	}*/
	 
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();	
		return authentication.getName();
		
	}
}
