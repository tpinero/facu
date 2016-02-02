package server;

import java.rmi.Remote;

import client.ClientInterface;

public interface ServerInterface extends Remote {

	public String sayHello() throws java.rmi.RemoteException;

	public Boolean registerForCallback(ClientInterface callbackClientObject)
			throws java.rmi.RemoteException;

	public void unregisterForCallback(ClientInterface callbackClientObject)
			throws java.rmi.RemoteException;

	public String getUser(String userIdentifier, ClientInterface callbackObj)
			throws java.rmi.RemoteException;
}
