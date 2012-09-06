package spring.security.prospring3.web;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller is used to provide functionality for the login page.
 * 
 * @author Mularien
 */
@Controller
public class LoginLogoutController extends BaseController{
	@RequestMapping(method=RequestMethod.GET,value="/login.do")
	public void home() {
	}
	
	// Ch 6 Access Denied
	@RequestMapping(method=RequestMethod.GET, value="/accessDenied.do")
	public void accessDenied(ModelMap model, HttpServletRequest request) {
		AccessDeniedException ex = (AccessDeniedException) request.getAttribute(WebAttributes.ACCESS_DENIED_403);
		StringWriter sw = new StringWriter();
		model.addAttribute("errorDetails", ex.getMessage());
		ex.printStackTrace(new PrintWriter(sw));
		model.addAttribute("errorTrace", sw.toString());
	}
}