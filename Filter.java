import java.util.*;
import java.util.concurrent.*;

public class Filter{

  private HashHelper hp = null;

  public Filter(){
    this.hp = new HashHelper();
  }

  /*Check if has the exact same value*/
  public void find(String currentWord) throws Exception{
    String hashedWord = hp.getHash(currentWord);

    if(Driver.passwords.containsValue(hashedWord)){
      // String username = hp.getKey(hashedWord, passwords);
      Integer userKey = hp.getKey(hashedWord, Driver.passwords);
      Driver.add(userKey, currentWord);
    }
  }

  //Convert string into basic university leet
  public String leet(String word){
    return word.replace("a", "4")
               .replace("e", "3")
               .replace("g", "6")
               .replace("i", "1")
               .replace("o", "0")
               .replace("s", "5")
               .replace("t", "7");
  }

  //Reverse string
  //Example, 12345 -> 54321
  public String reverse(String word){
    return new StringBuilder(word).reverse().toString();
  }

  //Capitalize first letter
  public String capitalize(String word){
    return Character.toUpperCase(word.charAt(0)) + word.substring(1);
  }

  //Concatenate a word with all other words in the dictionary
  public String concatenate(String word, String word2){
    return word + word2;
  }


}
