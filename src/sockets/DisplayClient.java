package sockets;

/**
 * @(#)client program.java
 *
 *
 * @author
 * @version 1.00 2012/9/22
 */

import java.net.*;
import java.io.*;

public class DisplayClient {
  public static void main(String[] args)
      throws IOException {

    InetAddress addr = InetAddress.getByName("127.0.0.1") ; //set the address of the server to be connected to. Any IP address can be set here as a string
    //If the name is saved in your "etc/hosts" file, then the name can be used instead of the ip address
	//Alternative method: InetAddress.getByAddress -see "stackoverflow" explanation if interested

    System.out.println("addr = " + addr);

    Socket socket = new Socket(addr, 8080);	//attempt to connect to the server by creating a socket using the IP address and Port number of the server

    try {
	      System.out.println("socket = " + socket);
	      BufferedReader in =
	        new BufferedReader(
	          new InputStreamReader(
	            socket.getInputStream())); //create an input variable for the socket- accepts input from the socket


	      PrintWriter out =
	        new PrintWriter(
	          new BufferedWriter(
	            new OutputStreamWriter(
	              socket.getOutputStream())),true); // create an output variable for the socket- writes output to the socket

			//this loop simply writes to the socket 10 times waits for a reply from the socket and then prints the reply received
	      for(int i = 0; i < 10; i ++) {
	        out.println("I am it: " + i); //write to socket
	        String str = in.readLine();	//read from socket
	        System.out.println(str);	//print to console line read from socket
	      }

	      out.println("END");	//send string that indicates end of transmission

    }catch( SocketException e ) {
           System.out.println("Server closed connection");
    }finally{
      	System.out.println("closing...");
     	 socket.close();	//close the connection
    }
  }
}