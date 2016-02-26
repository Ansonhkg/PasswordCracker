import java.security.*;
import java.util.*;

/**

 * Hashing Example
 *
 * @author gardine1
 * @editor Anson Cheung
 *
 */
public class HashHelper {

    public String getHash(String password) throws Exception
    {
      // MessageDigest object is used to create hash. getInstance requires
      // the hashing algorithm to be defined.
      MessageDigest digest = MessageDigest.getInstance("SHA-256");

      String toHash = password;
      // Convert the string into a byte array (getBytes()) and pass into
      // the digest object, which returns the hash as a byte array.
      byte[] hash = digest.digest(toHash.getBytes("UTF-8"));
      // using a string buffer, convert the byte array to a string
      // containing the hexadecimal representation
      StringBuffer hexString = new StringBuffer();
      for (int i = 0; i < hash.length; i++) {
          String hex = Integer.toHexString(0xff & hash[i]);
          if (hex.length() == 1)
              hexString.append('0');
          hexString.append(hex);
      }
      // Print the output. Output string can be obtained by calling the
      // builders toString() method
      // System.out.println(hexString.toString());
      return hexString.toString();

    }

    public Integer getKey(String value, HashMap<Integer, String> map){
      for(Integer key : map.keySet())
        if(map.get(key).equals(value))
          return key;
      return null;
    }


}
