package com.mikedg.android.apps.authenticator;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

import com.sonyericsson.extras.liveware.extension.util.ExtensionService;
import com.sonyericsson.extras.liveware.extension.util.control.ControlExtension;
import com.sonyericsson.extras.liveware.extension.util.registration.RegistrationInformation;

public class GoogleAuthService extends ExtensionService
{
	public static final String EXTENSION_KEY = "com.mikedg.android.apps.authenticator.key";
	public static final String TAG = "GoogleAuthExtension";

	public GoogleAuthService()
	{
		super(EXTENSION_KEY);
	}

	@Override
	protected RegistrationInformation getRegistrationInformation()
	{
		return new GoogleAuthRegistrationInfo(this);
	}

	@Override
	protected boolean keepRunningWhenConnected()
	{
		return false;
	}

	@Override
	public IBinder onBind(Intent intent)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		int retVal = super.onStartCommand(intent, flags, startId);
		if (intent != null)
		{
			// Handling of extension specific intents goes here
		}
		return retVal;
	}

	@Override
	public ControlExtension createControlExtension(String hostAppPackageName)
	{
		// FIXME: should appropriately build this
		// final int controlSWWidth = SampleControlSmartWatch.getSupportedControlWidth(this);
		// final int controlSWHeight = SampleControlSmartWatch.getSupportedControlHeight(this);
		// final int controlSWHPWidth = SampleControlSmartWirelessHeadsetPro.getSupportedControlWidth(this);
		// final int controlSWHPHeight = SampleControlSmartWirelessHeadsetPro.getSupportedControlHeight(this);
		//
		// for (DeviceInfo device : RegistrationAdapter.getHostApplication(this, hostAppPackageName).getDevices())
		// {
		// for (DisplayInfo display : device.getDisplays())
		// {
		return new GoogleAuthControl(hostAppPackageName, this, new Handler());
		// }
		// }
		// throw new IllegalArgumentException("No control for: " + hostAppPackageName);
	}
}
