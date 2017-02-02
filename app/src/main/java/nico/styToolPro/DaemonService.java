package nico.styToolPro;

import android.app.Service;  
import android.content.Intent;  
import android.os.IBinder;  
import android.util.Log;
import android.content.*;  

public class DaemonService extends Service {  

  @Override  
  public IBinder onBind(Intent intent) {  
	return null;  
  }  

  @Override  
  public void onCreate() {  
	super.onCreate();  
  }  

  @Override  
  public void onStart(Intent intent, int startId) {  

  }  
}  
