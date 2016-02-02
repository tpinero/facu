package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import models.User;

public class ClientImpl extends UnicastRemoteObject implements ClientInterface {

	public ClientImpl() throws RemoteException {
		super();
	}

	public String notifyMe(String message) {
		String returnMessage = "Call back received: " + message;
		System.out.println(returnMessage);
		return returnMessage;
	}

	public String receiveRegistrationResponse(Boolean callback) {
		if (callback.booleanValue()) {
			System.out.println("The server has registered me");
			return "The server has registered me";
		} else {
			System.out.println("The server hasn't registered me");
			return "The server hasn't registered me";
		}
	}

	public String receiveUser(User user) {
		System.out.println("Callback received: " + user.toString());
		String userInformationResponse = "The user: " + user.getName()
				+ " has the following email address: " + user.getEmail();
		return userInformationResponse;
	}

}
