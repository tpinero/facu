package Server;

import java.rmi.Remote;

import Client.ClientInterface;

public interface ServerInterface extends Remote {

	public String sayHello() throws java.rmi.RemoteException;

	public void registerForCallback(ClientInterface callbackClientObject)
			throws java.rmi.RemoteException;

	public void unregisterForCallback(ClientInterface callbackClientObject)
			throws java.rmi.RemoteException;
}
