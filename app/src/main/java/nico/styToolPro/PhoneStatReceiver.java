package nico.styToolPro;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneStatReceiver extends BroadcastReceiver {

  private static final String TAG = PhoneStatReceiver.class.getSimpleName();

  private static boolean incomingFlag = false;

  private static String incoming_number = null;

  @Override
  public void onReceive(Context context, Intent intent) {
	if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
	  incomingFlag = false;
	  String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
	} else {
	  TelephonyManager tm = (TelephonyManager) context
		.getSystemService(Service.TELEPHONY_SERVICE);

	  switch (tm.getCallState()) {
		case TelephonyManager.CALL_STATE_RINGING:
		  incomingFlag = true;
		  incoming_number = intent.getStringExtra("incoming_number");
		  Intent service = new Intent(context, PhoneReceiver.class);  
		  context.startService(service);  
		  break;
		case TelephonyManager.CALL_STATE_OFFHOOK:
		  if (incomingFlag) {
		  }
		  break;

		case TelephonyManager.CALL_STATE_IDLE:
		  if (incomingFlag) {
		  }
		  break;
	  }
	}
  }
}
