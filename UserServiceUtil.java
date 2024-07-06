 
package org.example.services.util;
import org.mindrot.jbcrypt.BCrypt;


public class UserServiceUtil {

    public static String hashPassword(String plainPassword){
        return BCrypt.hashpw(plainPassword,Bcrypt.gensale());

    }

    public static boolean checkPassword(String plainPassword, String hashedPassword){
        return BCrypt.checkpw(plainPassword, hashedPassword);

    }

}
