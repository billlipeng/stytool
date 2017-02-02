package nico.styToolPro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;

import java.util.Map;
import java.util.Random;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static android.os.SystemClock.sleep;
import static de.robv.android.xposed.XposedBridge.log;
import static de.robv.android.xposed.XposedHelpers.callMethod;
import static de.robv.android.xposed.XposedHelpers.callStaticMethod;
import static de.robv.android.xposed.XposedHelpers.findAndHookConstructor;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;
import static de.robv.android.xposed.XposedHelpers.findFirstFieldByExactType;
import static de.robv.android.xposed.XposedHelpers.getObjectField;
import static de.robv.android.xposed.XposedHelpers.newInstance;
import static nico.styToolPro.oOooOOo.hideModule;
import de.robv.android.xposed.*;
import android.widget.*;
import java.lang.reflect.*;


public class Il implements IXposedHookLoadPackage{

  @Override
  public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {

	if(!loadPackageParam.packageName.equals("nico.styTool")) return;

	findAndHookMethod("nico.styTool.LoginActivity", loadPackageParam.classLoader, "attemptLogin", new XC_MethodHook() {
		@Override
		protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
		  XposedBridge.log("QQ");
		  Class o = param.thisObject.getClass();
		  XposedBridge.log(o.getName());
		  Field.setAccessible(o.getDeclaredFields(), true);
		  
		  Toast.makeText((Activity)param.thisObject,"areyouok",Toast.LENGTH_LONG).show();
		}


		@Override
		protected void afterHookedMethod(MethodHookParam param) throws Throwable {

		}
	  });

  }
}
