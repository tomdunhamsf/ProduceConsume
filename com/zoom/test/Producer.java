package com.zoom.test;

import java.util.concurrent.BlockingQueue;
import static java.util.concurrent.TimeUnit.*;
public class Producer extends Thread implements Runnable {
private static WorkQueue queue;
	public Producer(){
		queue=new WorkQueue();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BlockingQueue<ZoomMessage> raw=queue.getQueue();
		for(int i=0;i<500;i++){
				try {
					raw.put(new ZoomMessage(i));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				yield();
		}
		
	}

}
