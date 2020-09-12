import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) throws UnknownHostException {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(InetAddress.getLocalHost().getHostAddress());
    }
}
