package flare.model.encryption;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class TokenGenerator {
	
	public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        
     // length of the random string.
        while (salt.length() < 18) { 
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

	}
}
