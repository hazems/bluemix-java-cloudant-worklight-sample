package com.todos_client;

import android.os.Bundle;

import com.worklight.androidgap.WLDroidGap;

/* To simplify integration of native code in app startup and runtime,
   replace deprecated class WLDroidGap according to the Information Center article "Migrating Application Classes" */
public class todos_client extends WLDroidGap {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	/**
     * onWLInitCompleted is called when the Worklight runtime framework initialization is complete
     */
	@Override
	public void onWLInitCompleted(Bundle savedInstanceState){
		super.loadUrl(getWebMainFilePath());
		// Add custom initialization code after this line
	}
	
}



