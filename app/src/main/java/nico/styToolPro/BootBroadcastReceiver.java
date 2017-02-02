package nico.styToolPro;
import android.content.*;

public class BootBroadcastReceiver extends BroadcastReceiver {
  static final String action_boot = "android.intent.action.BOOT_COMPLETED";
  @Override
  public void onReceive(Context context, Intent intent) {
	if (intent.getAction().equals(action_boot)) {

	  Intent service = new Intent(context, PhoneReceiver.class);  
	  context.startService(service);  
	}
  }
}

