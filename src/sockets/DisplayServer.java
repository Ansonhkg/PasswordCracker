package sockets;

/**
 * @(#)DisplayServer.java
 *
 *
 * @author
 * @version 1.00 2012/9/25
 */



import java.io.*;
import java.net.*;

public class DisplayServer {

  public static final int PORT = 8080;
  public static void main(String[] args) throws IOException {

    ServerSocket s = new ServerSocket(PORT); //create server socket object
    System.out.println("Started: " + s);

    try {
	      Socket socket = s.accept();	//accept a socket connection using the Server Socket created previously
	      try {
		      System.out.println(
		          "Connection accepted: "+ socket);

		      BufferedReader in =
		          new BufferedReader(
		            new InputStreamReader(
		              socket.getInputStream())); //create an input variable for the socket- accepts input from the socket

		       PrintWriter out =
		          new PrintWriter(
		            new BufferedWriter(
		              new OutputStreamWriter(
		                socket.getOutputStream())),true);	// create an output variable for the socket- writes output to the socket


				//this loop accepts input from the socket, prints out what it receives anc echoes it back into the socket until it recives the word "END" indicating the end of transmission
		       while (true) {
		          String str = in.readLine();	//read line from socket
		          if (str.equals("END")) break;
		          System.out.println("Echoing: " + str);	//print line to console
		          out.println("You said: " + str); //echo line read back into socket
		       }


	      }catch ( SocketException  e ) {
	          System.out.println("Client closed connection");
	      }finally{				//close the present connection
	        System.out.println("closing...");
	        socket.close();
	      }

    }catch( SocketException e ){
          System.out.println("Server socket closed unexpectedly");
    }finally{				//close the server socket. i.e. stop listening for connections
      s.close();			//without this line, the server would continue waiting for another connection
    }
  }
}