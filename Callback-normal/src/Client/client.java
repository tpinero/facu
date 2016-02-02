package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

import Server.ServerInterface;

public class client {
	public static void main(String args[]) {
		try {
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			System.out.println("Enter the RMIRegistry host namer:");
			String hostName = br.readLine();
			System.out.println("Enter the RMIregistry port number:");
			String portNum = br.readLine();
			System.out.println("Enter how many seconds to stayregistered:");
			String timeDuration = br.readLine();
			int time = Integer.parseInt(timeDuration);
			String regURL = "rmi://" + hostName + ":" + portNum + "/tati";
			ServerInterface h = (ServerInterface) Naming.lookup(regURL);
			System.out.println("Lookup completed ");
			System.out.println("Server said " + h.sayHello());
			ClientInterface callbackObj = new ClientImpl();
			h.registerForCallback(callbackObj);
			System.out.println("Registered for callback.");

			try {
				Thread.sleep(time * 1000);
				h.unregisterForCallback(callbackObj);
				System.out.println("Unregistered for callback.");
			} catch (InterruptedException ex) { /* sleep over */
			}
		} // try
		catch (Exception e) {
			System.out.println("Exception in CallbackClient: " + e);
		}
	}
}
