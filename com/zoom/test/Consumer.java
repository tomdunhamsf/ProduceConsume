package com.zoom.test;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;
import java.util.*;
public class Consumer extends Thread implements Runnable {

	private WorkQueue queue;
	private List<ZoomMessage> consumed=new LinkedList<ZoomMessage>();
	private int numConsumed=0;
	public Consumer(){
		queue=new WorkQueue();

	}
	@Override
	public void run() {
		BlockingQueue<ZoomMessage> raw=queue.getQueue();
	while(true){
			ZoomMessage msg;
			try {
				msg = raw.take();
				if(msg!=null){
					consumed.add(msg);
					numConsumed++;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		yield();
	}
}
	
	public int size(){
		return consumed.size();
	}
	
	public int last(){
		if(consumed.isEmpty()){
			return -99999;
		}else{
		return consumed.get(consumed.size()-1).getMessage();
		}
	}
	
	public int getNumConsumed(){
		return numConsumed;
	}

	
}
