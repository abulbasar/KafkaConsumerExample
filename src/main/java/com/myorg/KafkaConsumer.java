package com.myorg;

import com.myorg.listener.ConsumerListener;
import java.util.concurrent.LinkedBlockingQueue;


public class KafkaConsumer {

    private void startConsumeMessagesFromTopic(String topic) {
        try {
            ConsumerListener consumerListener = new ConsumerListener();
            LinkedBlockingQueue<String> queue = consumerListener.consume(topic);
            System.out.println("Consuming messages from topic: " + topic);
            String msg = queue.take();
            System.out.println(msg);
            while ((msg = queue.take()) != null) {
                System.out.println(msg);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static final void main(String[] args) {
    	if(args.length != 1){
    		System.out.println("Usage: com.myorg.KafkaConsumer <topic_name>");
    		System.exit(-1);
    	}
    	String topic = args[0];
        KafkaConsumer consumer = new KafkaConsumer();
        consumer.startConsumeMessagesFromTopic(topic);
    }


}
