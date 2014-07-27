package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{
	
	MediaPlayer ourSong;
	
	@Override
	protected void onCreate(Bundle TheKing) {
		// TODO Auto-generated method stub
		super.onCreate(TheKing);
		setContentView(R.layout.splash);
		ourSong = MediaPlayer.create(Splash.this, R.raw.gottheme);
		ourSong.start();
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(9000);					
				} catch (InterruptedException e){
					e.printStackTrace();
				} finally{
					Intent openStartingPoint = new Intent("com.example.myfirstapp.STARTINGPOINT");
					startActivity(openStartingPoint);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}
	
}
