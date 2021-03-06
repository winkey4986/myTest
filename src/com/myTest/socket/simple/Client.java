package com.myTest.socket.simple;

import java.io.*;
import java.net.*;

public class Client {
	Socket socket;
	BufferedReader in;
	PrintWriter out;

	public Client() {
		try {
			socket = new Socket("xxx.xxx.xxx.xxx", 10000);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
			out.println(line.readLine());
			line.close();
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
		}
	}

	public static void main(String[] args) {
		new Client();
	}
}