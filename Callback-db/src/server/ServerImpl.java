package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import models.User;
import DataBase.DataBaseAccess;
import client.ClientInterface;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface {

	private Vector clientList;
	private static final DataBaseAccess dbConnector = new DataBaseAccess();

	public ServerImpl() throws RemoteException {
		super();
		clientList = new Vector();
	}

	public Boolean registerForCallback(ClientInterface callbackClientObject)
			throws RemoteException {
		if (!(clientList.contains(callbackClientObject))) {
			clientList.addElement(callbackClientObject);
			return this
					.giveResponseToClient(callbackClientObject, Boolean.TRUE);
		} else {
			return this.giveResponseToClient(callbackClientObject,
					Boolean.FALSE);
		}
	}

	private Boolean giveResponseToClient(ClientInterface client,
			Boolean clientSuccesfullyRegistered) throws RemoteException {

		client.receiveRegistrationResponse(clientSuccesfullyRegistered);
		return clientSuccesfullyRegistered;

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

	public String getUser(String userIdentifier, ClientInterface callbackObj)
			throws RemoteException {
		try {
			ResultSet result = dbConnector.selectFromWhere("*", "user",
					"identifier", userIdentifier);
			if (result.next()) {
				Long aLong = new Long(0);
				Integer anInteger = new Integer(0);
				User user = new User("", aLong, "", anInteger);
				user.setName(result.getString("name"));
				user.setEmail(result.getString("mail"));
				user.setIdentifier(Long.valueOf(result.getLong("identifier")));
				user.setPhonenumber(Integer.valueOf(result
						.getInt("phonenumber")));
				// System.out.println("User name: " + user.getName());
				return callbackObj.receiveUser(user);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
