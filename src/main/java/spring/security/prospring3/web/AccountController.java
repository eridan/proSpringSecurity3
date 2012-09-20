package spring.security.prospring3.web;

import spring.security.prospring3.security.IChangePassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.InetOrgPerson;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;
import org.springframework.security.ldap.userdetails.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Used to service account requests.
 *
 * @author Mularien
 */
@Controller
public class AccountController extends BaseController {

    @Autowired
    private IChangePassword changePasswordDao;

    @RequestMapping("/account/home.do")
    public void accountHome() {
    }

    @RequestMapping(value = "/account/changePassword.do", method = RequestMethod.GET)
    public void showChangePasswordPage() {
    }

    @RequestMapping(value = "/account/changePassword.do", method = RequestMethod.POST)
    public String submitChangePasswordPage(@RequestParam("password") String newPassword) {


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = principal.toString();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }

        changePasswordDao.changePassword(username, newPassword);
        SecurityContextHolder.clearContext();

        return "redirect:home.do";
    }

    @RequestMapping(value = "/account/viewLdapUserProfile.do", method = RequestMethod.GET)
    public void viewLdapUserProfile(ModelMap model) {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", principal);

        if (principal instanceof LdapUserDetailsImpl) {
            model.addAttribute("isLdapUserDetails", Boolean.TRUE);
        }
        if (principal instanceof Person) {
            model.addAttribute("isLdapPerson", Boolean.TRUE);
        }
        if (principal instanceof InetOrgPerson) {
            model.addAttribute("isLdapInetOrgPerson", Boolean.TRUE);
        }
    }
}
