package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import Client.ClientInterface;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface {

	private Vector clientList;

	public ServerImpl() throws RemoteException {
		super();
		clientList = new Vector();
	}

	public void registerForCallback(ClientInterface callbackClientObject)
			throws RemoteException {
		if (!(clientList.contains(callbackClientObject))) {
			clientList.addElement(callbackClientObject);
			doCallbacks();
		}
	}

	public String sayHello() throws RemoteException {
		return "hello";
	}

	public void unregisterForCallback(ClientInterface callbackClientObject)
			throws RemoteException {
		if (clientList.removeElement(callbackClientObject)) {
			System.out.println("Unregistered client. ");
		} else {
			System.out.println("unregister: client wasn't registered.");
		}
	}

	private synchronized void doCallbacks() throws RemoteException {
		for (int i = 0; i < clientList.size(); i++) {

			System.out.println("");
			ClientInterface nextClient = (ClientInterface) clientList
					.elementAt(i);
			nextClient.notifyMe("Number of registered clients="
					+ clientList.size());
		} // for
	}

}
