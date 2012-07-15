package com.progress.services.sms;

import java.net.HttpURLConnection;

public class Way2Sms {
	private int responseCode = -1;
	private String userCredentials = null;
	private String cookie = null;
	private String site = null;
	private String actionStr = null;
	private Credentials credentials = new Credentials();

	public static void main(String[] args) {
		Way2Sms smsSender = new Way2Sms();
		// setProxy("127.0.0.1", 8080);
		smsSender.login("8978993113", "E6226W");
		/*sendSMS("8978993113",
				"Wanna integrate SMS notifications in our code? V cud use RabbitMQ. Yeah this message comes via API!");*/
		smsSender.sendSMS("8978993113",
				"Wanna integrate SMS notifications in our code? V cud use RabbitMQ. Yeah this message comes via API!");
		/*sendSMS("9642744436",
				"Wanna integrate SMS notifications in our code? V cud use RabbitMQ. Yeah this message comes via API!");
		sendSMS("9505047391",
				"Wanna integrate SMS notifications in our code? V cud use RabbitMQ. Yeah this message comes via API!");*/
		// sendSMS(new String[] { "receivers mobile no. 1",
		// "receivers mobile no. 2", "..." }, "message");
		System.out.println("Message has been sent successfully!");
	}

	public void sendMessageEntryCall(String mobile, String message){
		try {
			login("8978993113", "E6226W");
			sendSMS(mobile, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setProxy(String host, int port) {
		URLConnector.setProxy(host, port);
	}

	private void getSite() {
		URLConnector.connect("http://www.way2sms.com/", false, "GET", null,
				null);
		responseCode = URLConnector.getResponseCode();
		if (responseCode != HttpURLConnection.HTTP_MOVED_TEMP
				&& responseCode != HttpURLConnection.HTTP_OK)
			exit("getSite failed!");
		else {
			site = URLConnector.getLocation();
			if (site != null)
				site = site.substring(7, site.length() - 1);
		}
		URLConnector.disconnect();
	}

	private void preHome() {
		URLConnector.connect("http://" + site + "/content/prehome.jsp", false,
				"GET", null, null);
		responseCode = URLConnector.getResponseCode();
		if (responseCode != HttpURLConnection.HTTP_MOVED_TEMP
				&& responseCode != HttpURLConnection.HTTP_OK)
			exit("preHome failed");
		else
			cookie = URLConnector.getCookie();
		URLConnector.disconnect();
	}

	private void login(String uid, String pwd) {
		try {
			getSite();
			preHome();

			String location = null;

			credentials.set("username", uid);
			credentials.append("password", pwd);
			credentials.append("button", "Login");
			userCredentials = credentials.getUserCredentials();

			URLConnector.connect("http://" + site + "/Login1.action", false,
					"POST", cookie, userCredentials);
			responseCode = URLConnector.getResponseCode();
			if (responseCode != HttpURLConnection.HTTP_MOVED_TEMP
					&& responseCode != HttpURLConnection.HTTP_OK)
			exit("authentication failed!");
			else
				location = URLConnector.getLocation();
			URLConnector.disconnect();

			URLConnector.connect(location, false, "GET", cookie, null);
			responseCode = URLConnector.getResponseCode();
			if (responseCode != HttpURLConnection.HTTP_MOVED_TEMP
					&& responseCode != HttpURLConnection.HTTP_OK)
			exit("redirection failed!");
			URLConnector.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
	}

	private void getActionString() {
		URLConnector.connect("http://" + site + "/jsp/InstantSMS.jsp", false,
				"GET", cookie, null);
		responseCode = URLConnector.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_MOVED_TEMP
				|| responseCode == HttpURLConnection.HTTP_OK) {
			String str = URLConnector.getResponse();

			String aStr = "name=\"Action\" id=\"Action\"";
			int aStrLen = aStr.length();

			int index = str.indexOf(aStr);
			if (index > 0) {
				str = str.substring(index + aStrLen);
				index = str.indexOf("\"");
				if (index > 0) {
					str = str.substring(index + 1);
					index = str.indexOf("\"");
					if (index > 0)
						actionStr = str.substring(0, index);
				}
			}
		} else
			exit("getActionString failed!");
		URLConnector.disconnect();
	}

	private void sendSMS(String receiversMobNo, String msg) {
		getActionString();

		credentials.reset();
		credentials.set("HiddenAction", "instantsms");
		credentials.append("catnamedis", "Birthday");
		if (actionStr != null)
			credentials.append("Action", actionStr);
		else
			exit("Action string missing!");
		credentials.append("chkall", "on");
		credentials.append("MobNo", receiversMobNo);
		credentials.append("textArea", msg);

		userCredentials = credentials.getUserCredentials();

		URLConnector.connect("http://" + site + "/quicksms.action", true,
				"POST", cookie, userCredentials);
		responseCode = URLConnector.getResponseCode();
		if (responseCode != HttpURLConnection.HTTP_MOVED_TEMP && responseCode != HttpURLConnection.HTTP_OK) {
			exit("sendSMS failed!");
		} else {
			System.out.println("SMS sent successfully...");
		}
		URLConnector.disconnect();
	}

	private void sendSMS(String[] receiversMobNos, String msg) {
		int noOfReceivers = receiversMobNos.length;

		for (int i = 0; i < noOfReceivers; i++)
			sendSMS(receiversMobNos[i], msg);
	}

	private void exit(String errorMsg) {
		System.err.println("[SMS-Service-Status] "+errorMsg);
//		System.exit(1);
	}
}