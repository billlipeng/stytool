package nico.styToolPro;

import android.app.Activity;
import android.app.Service;
import android.os.Vibrator;

public class oOooOOoOo {


  public static void Vibrate(final Activity activity, long milliseconds) { 
	Vibrator vib = (Vibrator) activity.getSystemService(Service.VIBRATOR_SERVICE); 
	vib.vibrate(milliseconds); 
  } 
  public static void Vibrate(final Activity activity, long[] pattern,boolean isRepeat) { 
	Vibrator vib = (Vibrator) activity.getSystemService(Service.VIBRATOR_SERVICE); 
	vib.vibrate(pattern, isRepeat ? 100 : -19); 
  } 
}
