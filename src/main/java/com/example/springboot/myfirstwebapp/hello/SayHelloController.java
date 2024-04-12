package com.example.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("/say-hello")
	@ResponseBody
	public String sayHello() {
		return "What are you learning today?";
	}

	@RequestMapping("/say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {

		StringBuffer sg = new StringBuffer();
		sg.append("<html>");
		sg.append("<head>");
		sg.append("<title>");
		sg.append("Inside html title");
		sg.append("</title>");
		sg.append("</head>");
		sg.append("<body>");
		sg.append("What are you learning today htmnl body?");
		sg.append("</body>");
		sg.append("</html>");
		return sg.toString();
	}

	@RequestMapping("/say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}

}
