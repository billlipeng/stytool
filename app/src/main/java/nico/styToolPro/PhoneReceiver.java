package nico.styToolPro;

import android.content.*;
import android.telephony.*;
import android.app.*;
import android.hardware.*;
import android.hardware.Camera.*;
import android.media.*;
import java.util.*;

public class PhoneReceiver extends BroadcastReceiver {
  private static boolean incomingFlag = false;
  AudioManager audioManager;
  Thread thread;
  int currentVolume;

  private int START_STICKY;
  
  @Override
  public void onReceive(Context context, Intent intent) {
	audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
	currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
	thread = new LooperThread();
	
	if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
	  incomingFlag = false;
	  final String phoneNum = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
	} else {
	  TelephonyManager tm = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
	  tm.listen(listener,PhoneStateListener.LISTEN_CALL_STATE);
	}
  }
  final PhoneStateListener listener=new PhoneStateListener(){
	private Context context;
	@Override
	public void onCallStateChanged(int state, String incomingNumber) {
	  super.onCallStateChanged(state, incomingNumber);
	  
	  switch(state){
		case TelephonyManager.CALL_STATE_RINGING:
		  incomingFlag = true;

		  
			int max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
			audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, max, 0);

			try {
			  
			} catch (Exception e) {
			}

			thread.start();
		  break;
		case TelephonyManager.CALL_STATE_OFFHOOK:
		  if (incomingFlag) {
		  }
		  break;
		case TelephonyManager.CALL_STATE_IDLE:
		  if (incomingFlag) {
			Activity context = null;
			ActivityCollector.removeActivity(context);
			ActivityCollector.finishAll();
		  }
		  break;
	  }
	}
  };
  class LooperThread extends Thread {
	public void run() {
	  try {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

		  private Camera camera;

		  private Camera.Parameters parameters;
		  public void run() {
			try {
			  camera = Camera.open();
			  parameters = camera.getParameters();
			  parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
			  camera.setParameters(parameters);
			} catch (Exception ex) {
			}
			try {
			  parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
			  camera.setParameters(parameters);
			  camera.release();
			} catch (Exception ex) {
			}
		  }
		};
		timer.schedule(timerTask, new Date(), 1);
	  } catch (Exception e) {
		e.printStackTrace();
	  }
	}
  }}
