import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Date;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class socket_server{
	public static void main(String[] args) throws IOException {
		int port = Integer.valueOf(JOptionPane.showInputDialog("Enter port of this machine at which it will listen to"));
		System.out.println("Listening on port: " + port);
		ServerSocket listener = new ServerSocket(port);
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                	BufferedReader in = new BufferedReader( 
                            new InputStreamReader(socket.getInputStream()));
                	PrintWriter out = new PrintWriter(
                    		socket.getOutputStream(), true);
                	int n;
                	String input = in.readLine();
//                	System.out.println(input);
                	if(input.equals("now become client"))
                	{
                		
//                		out.println("here, I will now send data");
                		String n_s = in.readLine();
                		n = Integer.valueOf(n_s);
                		long t1= System.currentTimeMillis();
                		long t2= System.currentTimeMillis();
//                		while((t2-t1)<100)
//                		{
                			char[] data = new char[n];
                			Arrays.fill(data, 'a');
                			String str = new String(data);
                			t1= System.currentTimeMillis();
                			out.println(str);
                	        String answer = in.readLine();
                	        t2= System.currentTimeMillis();
                	        socket.close();
                	        //System.out.println(answer);
//                		}
//                		out.println("dowload test complete");
//                		out.println(n);
                	}
                	else
                	{
                		long count = input.length();
                    	out.println(count);
                	}
                } 
            finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }
}
