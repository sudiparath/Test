package com.pack;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenMultipleTabs {

	static String[] appUrls = {
								  "http://oci-mohammaf01.nane.netapp.com",
								  "http://oci-qa07-s12r2.na.ead.netapp.com",
								 "http://oci-qa05-s12r2.nane.netapp.com" };

	public static void main(String[] args) {
		for (String url : appUrls) {
			System.out.println("URL:: " + url);
			Worker worker = new Worker(url);
			worker.start();
		}

	}

	public static class Worker extends Thread {

		String url;

		public Worker(String url) {
			this.url = url;
		}

		@Override
		public void run() {
			WebDriver driver = new FirefoxDriver();
			try {
				URL u = new URL(this.url);
				HttpURLConnection httpConnection = (HttpURLConnection) u.openConnection();
				System.out.println("Sending get request");
				httpConnection.setRequestMethod("GET");
				System.out.println("Connecting");
				httpConnection.connect();
				System.out.println("Connected and getting content");
				System.out.println(httpConnection.getURL());
				int responseCode = httpConnection.getResponseCode();
				System.out.println("responseCode:: " + responseCode);
				if (responseCode != 200) {
					String content = httpConnection.getContentType();
					System.out.println("Content:: " + content);
					String headerLocation = httpConnection
							.getHeaderField("Location");
					System.out.println("Header Location:: " + headerLocation);
					driver.get(headerLocation);
				} else if (driver != null) {
					driver.get(url);
				}

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(driver != null){
					driver.close();
					driver.quit();
				}
			}
		}
	}

}
