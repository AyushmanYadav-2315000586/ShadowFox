package chatapp;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler extends Thread {
    private static final List<ClientHandler> clients = new ArrayList<>();
    private final Socket socket;
    private PrintWriter out;
    private String username;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        synchronized (clients) {
            clients.add(this);
        }
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Enter your username:");
            username = in.readLine();
            broadcast(username + " has joined the chat!");

            String message;
            while ((message = in.readLine()) != null) {
                broadcast(username + ": " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            synchronized (clients) {
                clients.remove(this);
            }
            broadcast(username + " has left the chat.");
        }
    }

    private void broadcast(String message) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                client.out.println(message);
            }
        }
    }
}
