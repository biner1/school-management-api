
import java.net.UnknownHostException;
import java.net.Socket;
import java.io.*;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket serverConnection = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            serverConnection = new Socket("127.0.0.1", 6789);
            System.out.println("connected to: " + serverConnection);
        } catch (UnknownHostException e) {
            System.err.println("Don't know host.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: sv.");
            System.exit(1);
        }

//        out = new PrintWriter(serverConnection.getOutputStream(), true);
//        in = new BufferedReader(new InputStreamReader(serverConnection.getInputStream()));

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer, toServer;
        System.out.println("connected");

        final ObjectOutputStream mapOutputStream;
        final ObjectInputStream mapInputStream;
        try {
            final InputStream yourInputStream =serverConnection.getInputStream(); // InputStream from where to receive the map, in case of network you get it from the Socket instance.
          	mapInputStream = new ObjectInputStream(yourInputStream);

            final OutputStream yourOutputStream = serverConnection.getOutputStream(); // OutputStream where to send the map in case of network you get it from the Socket instance.
            mapOutputStream = new ObjectOutputStream(yourOutputStream);
			System.out.println("login in");
            LoginView l = new LoginView();
            l.login(mapOutputStream,mapInputStream);
        }
        finally {
            //mapOutputStream.close();
        }


//        while ((fromServer = in.readLine()) != null) {
//
//            boolean isServerAskForInput = fromServer.equals("@r#");
//
//            if (isServerAskForInput) {
//                System.out.print("you> ");
//                toServer = stdIn.readLine();
//                if (toServer.equals("exit()")) {
//                    out.close();
//                    in.close();
//                    stdIn.close();
//                    serverConnection.close();
//                    System.exit(1);
//                }
//                out.println(toServer);
//            }else
//                System.out.println(":: " + fromServer);
//        }


    }
}
