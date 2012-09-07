package spring.security.prospring3.service;


import com.packtpub.springsecurity.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.security.prospring3.jdbc.CustomJdbcDaoImpl;


/**
 * Implements methods declared in the IUserService interface.
 * 
 * @author Mularien
 */
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	CustomJdbcDaoImpl jdbcDao;
	
	public void changePassword(String username, String password) {
		jdbcDao.changePassword(username, password);
	}

	@Override
	public void createUser(String username, String password, String email) {
		/* Alternative if you were using JdbcUserDetailsManager-based createUser
		GrantedAuthority roleUser = new GrantedAuthorityImpl("ROLE_USER");
		UserDetails user = new User(username, password, true, true, true, true, Arrays.asList(roleUser));
		jdbcDao.createUser(user);
		*/
		jdbcDao.createUser(username, password, email);
	}
	
	
}
