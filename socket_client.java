import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;


import javax.swing.JOptionPane;

public class socket_client {
	public static void main(String[] args) throws IOException {
		//System.out.println(args.length));
		if(args.length!=2)
		{
			if(args.length<2)
			{
				System.out.println("Less arguments! Syntax: java socket_client <IP Address> <port number>");
				System.exit(1);
			}
			else
			{
				System.out.println("Too many arguments! Syntax: java socket_client <IP Address> <port number>");
				System.exit(1);
			}
		}
		String serverAddress = args[0];
		int port = Integer.valueOf(args[1]);
//        String serverAddress = JOptionPane.showInputDialog("Enter IP Address of the server machine");
//        int port = Integer.valueOf(JOptionPane.showInputDialog("Enter port of the server machine at IP address: " + serverAddress));
        
		int n = 10000;
		long t1= System.currentTimeMillis();
		long t2= System.currentTimeMillis();
		while((t2-t1)<10000)
		{
			n = n*2;
			Socket s = new Socket(serverAddress, port);
	        PrintWriter out = new PrintWriter(
	        		s.getOutputStream(), true);
	        BufferedReader input =
	                new BufferedReader(new InputStreamReader(s.getInputStream()));
	        
			char[] data = new char[n];
			Arrays.fill(data, 'a');
			String str = new String(data);
			t1= System.currentTimeMillis();
			out.println(str);
	        String answer = input.readLine();
	        t2= System.currentTimeMillis();
	        s.close();
//	        System.out.println(answer);
		}
        System.out.println("Upload Speed = " + (n*2*8*1024/(t2-t1)) + " Bits/sec ");
        
        
        /*------------------------------------------now act as server for download speed-----------------------------------*/
        
        
        Socket s = new Socket(serverAddress, port);
        PrintWriter out = new PrintWriter(
        		s.getOutputStream(), true);

        out.println("now become client");
        out.println(n);
        BufferedReader input =
                new BufferedReader(new InputStreamReader(s.getInputStream()));
        t1= System.currentTimeMillis();
        String answer = input.readLine();
        t2= System.currentTimeMillis();
        s.close();
        System.out.println("Download speed = " + n*2*8*1024/(t2-t1) + " Bits/sec");
        System.exit(0);
    }
}