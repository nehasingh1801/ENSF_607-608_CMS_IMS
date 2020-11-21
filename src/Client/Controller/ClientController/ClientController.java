package Client.Controller.ClientController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

import Client.ClientModel.*;

public class ClientController {
	
	private Socket aSocket;
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	private int choice;
	private Boolean isConnected = true;
	private ObjectInputStream serverInputStream;
	private ObjectOutputStream serverOutputStream;
	private Customer customer;
	
	public ClientController(String serverName, int portNumber) throws ClassNotFoundException {
		
		try {
			aSocket = new Socket(serverName, portNumber);
			isConnected = true;
			// Socket input Stream
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));

			// Socket output Stream
			socketOut = new PrintWriter(aSocket.getOutputStream(), true);
			runClient();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void runClient() throws ClassNotFoundException {
		
		while(isConnected) {
			String response = "";
			
			
				System.out.println("sending 1 to server");
				socketOut.println("1");
				socketOut.flush();
				isConnected= false;
//				serverInputStream = new ObjectInputStream(aSocket.getInputStream());
//				customer = (Customer) serverInputStream.readObject();
//				System.out.println(" Customer is " + customer.getCustomerID() + " " +customer.getFirstName());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		//}
		
		}
		
	}
public static void main(String[] args) throws ClassNotFoundException {
	ClientController cc = new ClientController("localhost", 9090);
}
}
