package client;

import java.rmi.Remote;

import models.User;

public interface ClientInterface extends Remote {

	public String receiveRegistrationResponse(Boolean response)
			throws java.rmi.RemoteException;

	public String receiveUser(User user) throws java.rmi.RemoteException;

}
