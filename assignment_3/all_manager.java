import java.util.*;
//import net.*;
public class all_manager{
	public static void main(String[] args) {
		network net = new network();
		feature_phone p1 = new feature_phone(12345,"TI");
		smartphone p2 = new smartphone(23456,"Mediatek","Samsung");
		smartphone p3 = new smartphone(13452,"Apple","Apple");
		p1.add_to_network(net);
		p2.add_to_network(net);
		p3.add_to_network(net);
		System.out.println(p1.call_request(23456));
		System.out.println(p3.call_request(12345));
		p2.request_hangup();
		System.out.println(p3.call_request(12345));

	}
}