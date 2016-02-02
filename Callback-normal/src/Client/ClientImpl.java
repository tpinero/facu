package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl extends UnicastRemoteObject implements ClientInterface {

	public ClientImpl() throws RemoteException {
		super();
	}

	public String notifyMe(String message) {
		String returnMessage = "Call back received: " + message;
		System.out.println(returnMessage);
		return returnMessage;
	}

}
