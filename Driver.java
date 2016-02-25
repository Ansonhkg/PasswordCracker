import java.util.*;

public class Driver
{
    //Found Passwords ArrayList
    final static ArrayList<String> foundList = new ArrayList<String>();

    public static void main(String [] args) throws Exception
    {
        Filter filter = new Filter();

        //My dictionary
        ArrayList<String> myDictionary = FileIOExample.readFromFile("dictionary.txt");

        //Password Hashmap
        HashMap<Integer, String> passwords = FileIOExample.readFromFileH("password.txt");



        //For every single word inside the dictionary
        for(int i=0;i<myDictionary.size();i++){

          String currentWord = myDictionary.get(i);

          filter.exact(currentWord, passwords);
          filter.exact(filter.leet(currentWord), passwords);
          filter.exact(filter.reverse(currentWord), passwords);
          filter.exact(filter.capitalize(currentWord), passwords);
          
        }
        printAll();
        FileIOExample.writeToFile("output.txt", foundList);
    }

    /*Add found username password to the found list*/
    public static void add(Integer userKey, String password){
      String format = "user"+userKey+":"+password;
      //Make sure the username has not been store to the list before
      if(!foundList.contains(format)) foundList.add(format);
    }

    public static void printAll(){
      for(int i=0;i<foundList.size();i++){
        System.out.println(foundList.get(i));
      }
    }

}
