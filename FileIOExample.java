import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class FileIOExample {

  /**
   * Method to read a password file and extract the hashes
   * @param filename - the file to read from
   * @return
   */
  public static ArrayList<String> readFromFile(String filename) {
      ArrayList<String> words = new ArrayList<String>();
      //Vreate BufferedReader object to read in file
      BufferedReader br = null;

      try {

          String line;

          //Instantiate BufferedReader with a FileReaderm and the filename given in the method parameters
          br = new BufferedReader(new FileReader(filename));

          //While loop will read line by line (using the newlien character as a delimeter) until a null line is read (indicating the end of the file
          while ((line = br.readLine()) != null) {
              // System.out.println(line);
              //Split the line by semi colon
              // String[] split = line.split(":");
              //add the hash to the arraylist
              words.add(line);
          }

      } catch (IOException e) {
          //Catch any IO exception (this covers opening the file and and read errors
          e.printStackTrace();
      } finally {
          //After execution, close the reader
          try {
              if (br != null)
                  br.close();
          } catch (IOException ex) {
              ex.printStackTrace();
          }
      }
      return words;

  }

  /**
   * Method to read a password file and extract the hashes
   * @param filename - the file to read from
   * @return
   */
  public static HashMap<Integer, String> readFromFileH(String filename) {

      HashMap<Integer, String> words = new HashMap<Integer, String>();
      //Vreate BufferedReader object to read in file
      BufferedReader br = null;

      try {

          String line;

          //Instantiate BufferedReader with a FileReaderm and the filename given in the method parameters
          br = new BufferedReader(new FileReader(filename));

          //While loop will read line by line (using the newlien character as a delimeter) until a null line is read (indicating the end of the
          while ((line = br.readLine()) != null) {
              // System.out.println(line);

              //Split the line by semi colon
              String[] split = line.split(":");
              String[] userNumber = split[0].split("user");
              int userNo = Integer.parseInt(userNumber[1]);
              // System.out.println(userNo);

              //add the hash to the HashMap
              words.put(userNo, split[1]);
          }

      } catch (IOException e) {
          //Catch any IO exception (this covers opening the file and and read errors
          e.printStackTrace();
      } finally {
          //After execution, close the reader
          try {
              if (br != null)
                  br.close();
          } catch (IOException ex) {
              ex.printStackTrace();
          }
      }
      return words;

  }


    /**
     * Method for writing teh contents of an ArrayLIst to a file
     * @param filename - The filename to write to
     * @param words  - An ArrayLIst of string to write to the file
     */
    public static void writeToFile(String filename, ArrayList<String> words) {
        // Declare BufferedWriter object
        BufferedWriter writer = null;

                try {
                    //Instantiate BufferedWriter object, using a FileWriter and the filename passed as parameter to the method
                    writer = new BufferedWriter(new FileWriter(filename));

                    //loop through our ArrayList
                    for (int i = 0; i < words.size(); i++) {
                        //Write the string to the file
                        writer.write(words.get(i));
                        //writer.newLine prints the appropriate newLine character to the file (usually \n)
                        writer.newLine();
                        //writer.flush ensures than anything in the buffer is written to the file. If you do nto call this you may find an empty file. To be safe, you can call this after every write.
                        writer.flush();
                    }
                } catch (IOException e) {
                    // Catch any IO errors
                    e.printStackTrace();
                }finally {
                    try {
                        //after execution, close the writer
                        if (writer != null)
                            writer.flush();
                           writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

    }

}
