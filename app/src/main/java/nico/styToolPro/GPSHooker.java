package nico.styToolPro;

import de.robv.android.xposed.*;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import de.robv.android.xposed.XposedBridge;

import android.app.Activity;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Iterator;

public class GPSHooker implements IXposedHookLoadPackage
{

  private LoadPackageParam mLpp;
  private static SettingsHelper mSettings = new SettingsHelper();


  public void log(String s)
  {
  }

  private void hook_method(Class<?> clazz, String methodName, Object... parameterTypesAndCallback)
  {
	try
	{
	  XposedHelpers.findAndHookMethod(clazz, methodName, parameterTypesAndCallback);
	}
	catch (Exception e)
	{
	}
  }

  private void hook_method(String className, ClassLoader classLoader, String methodName,
						   Object... parameterTypesAndCallback)
  {
	try
	{
	  XposedHelpers.findAndHookMethod(className, classLoader, methodName, parameterTypesAndCallback);
	}
	catch (Exception e)
	{
	}
  }

  private void hook_methods(String className, String methodName, XC_MethodHook xmh)
  {
	try
	{
	  Class<?> clazz = Class.forName(className);

	  for (Method method : clazz.getDeclaredMethods())
		if (method.getName().equals(methodName)
			&& !Modifier.isAbstract(method.getModifiers())
			&& Modifier.isPublic(method.getModifiers()))
		{
		  XposedBridge.hookMethod(method, xmh);
		}
	}
	catch (Exception e)
	{
	}
  }


  @Override
  public void handleLoadPackage(LoadPackageParam lpp) throws Throwable
  {
	// TODO Auto-generated method stub
	mLpp = lpp;

	if (!mLpp.packageName.equals("styTool"))
	  return;


	hook_method("android.net.wifi.WifiManager", mLpp.classLoader, "getScanResults",
	  new XC_MethodHook(){

		@Override
		protected void afterHookedMethod(MethodHookParam param)
		throws Throwable
		{
		  // TODO Auto-generated method stub
		  //super.afterHookedMethod(param);
		  param.setResult(null);
		}
	  });

	hook_method("android.telephony.TelephonyManager", mLpp.classLoader, "getCellLocation",
	  new XC_MethodHook(){

		@Override
		protected void afterHookedMethod(MethodHookParam param)
		throws Throwable
		{
		  param.setResult(null);
		}
	  });

	hook_method("android.telephony.TelephonyManager", mLpp.classLoader, "getNeighboringCellInfo",
	  new XC_MethodHook(){
		@Override
		protected void afterHookedMethod(MethodHookParam param)
		throws Throwable
		{
		  param.setResult(null);
		}
	  });

	hook_methods("android.locaton.LocationManager", "requestLocationUpdates",
	  new XC_MethodHook() {

		@Override
		protected void beforeHookedMethod(MethodHookParam param) throws Throwable
		{

		  if (param.args.length == 4 && (param.args[0] instanceof String))
		  {
			LocationListener ll = (LocationListener)param.args[3];

			Class<?> clazz = LocationListener.class;
			Method m = null;
			for (Method method : clazz.getDeclaredMethods())
			{
			  if (method.getName().equals("onLocationCanged"))
			  {
				m = method;
				break;
			  }
			}

			try
			{
			  if (m != null)
			  {
				mSettings.reload();

				Object[] args = new Object[1];
				Location l = new Location(LocationManager.GPS_PROVIDER);


				double la=39.886559;
				double lo=116.449635;
				l.setLatitude(la);
				l.setLongitude(lo);

				args[0] = l;
				
				m.invoke(ll, args);

			  }
			}
			catch (Exception e)
			{
			}
		  }
		}
	  });


	hook_methods("android.location.LocationManager", "getGpsStatus",
	  new XC_MethodHook(){

		@Override
		protected void afterHookedMethod(MethodHookParam param) throws Throwable
		{
		  GpsStatus gss = (GpsStatus)param.getResult();
		  if (gss == null)
			return;

		  Class<?> clazz = GpsStatus.class;
		  Method m = null;
		  for (Method method : clazz.getDeclaredMethods())
		  {
			if (method.getName().equals("setStatius"))
			{
			  if (method.getParameterTypes().length > 1)
			  {
				m = method;
				break;
			  }
			}
		  }

		  m.setAccessible(true);

		  int svCount = 5;
		  int[] prns = {1, 2, 3, 4, 5};
		  float[] snrs = {0, 0, 4, 0, 0};
		  float[] elevations = {0, 0, 0, 9, 0};
		  float[] azimuths = {0, 0, 0, 0, 0};
		  int ephemerisMask = 0x1f;
		  int almanacMask = 0x9f;

		  int usedInFixMask = 0x1f;

		  try
		  {
			if (m != null)
			{
			  m.invoke(gss, svCount, prns, snrs, elevations, azimuths, ephemerisMask, almanacMask, usedInFixMask);
			  param.setResult(gss);
			}
		  }
		  catch (Exception e)
		  {
		  }
		}
	  });
  }

}
