package flare.model.encryption;

import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class PasswordEncryption {

	private String bcryptPassword;

	/**
	 * @return the bcryptPassword
	 */
	public String getBcryptPassword() {
		return bcryptPassword;
	}

	/**
	 * @param bcryptPassword the bcryptPassword to set
	 */
	private void setBcryptPassword(String bcryptPassword) {
		this.bcryptPassword = bcryptPassword;
	}
	
	public String bcryptHash(String password) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		setBcryptPassword( passwordEncoder.encode(password));
		return bcryptPassword;
	}
	
	
}
