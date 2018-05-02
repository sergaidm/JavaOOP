package ru.yandex.sergaidm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {
    private Socket socket;
    private String answer;
    private Thread thread;

    public Client(Socket socket, String answer) {
        this.socket = socket;
        this.answer = answer;
        thread = new Thread(this);
        thread.start();
    }
    
    public static String getSystemInfo() {
    	String answer = "<html><head><title>System Info</title> <meta charset='utf-8'></head><body><p>Information about System:</p><br>"
            + "<table border='2' cellpadding='5' ><tr><th>System parameter</th><th>Value</th>"
            + "<tr><td>Computer Name</td>"
            + "<td>" + System.getenv("COMPUTERNAME") + "</td></tr>"
            + "<tr><td>Operating System" + "</td>"
            + "<td>" + System.getProperty("os.name") + "</td></tr>"
            + "<tr><td>Available Processors</td>"
            + "<td>" + Runtime.getRuntime().availableProcessors() + " cores" + "</td></tr>"
            + "<tr><td>Free Memory</td>"
            + "<td>" + Runtime.getRuntime().freeMemory() + " bytes" + "</td></tr>"
            + "<tr><td>Total Memory</td>"
            + "<td>" + Runtime.getRuntime().totalMemory() + " bytes" + "</td></tr>"
            + "<tr><td>Max Memory</td>"
            + "<td>" + Runtime.getRuntime().maxMemory() + " bytes" + "</td></tr>"
            + "</table></body></html>";
    	return answer;
    }

    public void run() {
        try (InputStream is = socket.getInputStream();
             OutputStream os = socket.getOutputStream();
             PrintWriter pw = new PrintWriter(os)) {
            byte[] rec = new byte[is.available()];
            is.read(rec);
            String response = "HTTP/1.1 200 OK\r\n" + "Server: My_Server\r\n"
                    + "Content-Type: text/html\r\n" + "Content-Length: "
                    + "\r\n" + "Connection: close\r\n\r\n";
            pw.print(response + answer);
            pw.flush();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
}
