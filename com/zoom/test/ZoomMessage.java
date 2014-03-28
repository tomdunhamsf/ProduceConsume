package com.zoom.test;

public class ZoomMessage {
	private int ident;
	public ZoomMessage(int order){
		ident=order;
	}
	public int getMessage(){
		return ident;
	}
}
