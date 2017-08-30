package pkt;

import java.util.ArrayList;
import java.util.List;

public class MessageService {

	
	public List<Messenger> getAllMessages()
	{
		
		Messenger m1=new Messenger(1L,"merhaba", "cagatay");
		Messenger m2=new Messenger(1L,"selam", "kubra");
		List<Messenger> listem=new ArrayList<>();
		listem.add(m1);
		listem.add(m2);
		return listem;
		
	}
}
