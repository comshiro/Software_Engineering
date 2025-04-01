import java.math.BigInteger;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Person {

    String FirstName;
    String LastName;
    String Username;
    String Password;
    String Email;
    String PhoneNumber;


    public Person(String phoneNumber, String email, String password, String username, String lastName, String firstName) {
        PhoneNumber = phoneNumber;
        Email = email;
        Password = password;
        Username = username;
        LastName = lastName;
        FirstName = firstName;
    }

    public static String getSHA(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));
            BigInteger number = new BigInteger(1, hash);
            StringBuilder hexString = new StringBuilder(number.toString(16));

            while (hexString.length() < 64) {
                hexString.insert(0, '0');
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void createAccount(String firstName, String lastName, String username, String password, String email, String phoneNumber) {
        String aux = firstName + lastName + username + password + email + phoneNumber;
        String hashedAccount = getSHA(aux);
        setAccountID(hashedAccount);
    }

    public void LogginIn(String Username, String Password)
    {
        if(this.Username.equals(Username) && this.Password.equals(Password))
            setLoggedStatus(true);
    }
}
