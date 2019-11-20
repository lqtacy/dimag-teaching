package com.dimag.start;

import java.util.Arrays;
import java.util.List;

public class MessageApp {
	public static void main(String[] args) {
		Message m = new Message("hasari@gmail.com", "hasari@gmail.com");
		m.setMessage("Hello....");

		List<MessageSender> senders = Arrays.asList(new Emailer(), new SmsSender());
//		for (MessageSender sender:senders){
//			sender.send(m);
//		}

		senders.forEach(sender ->{
			sender.send(m);
		});
	}
}
