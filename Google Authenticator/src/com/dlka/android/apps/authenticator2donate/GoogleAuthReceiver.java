package com.dlka.android.apps.authenticator2donate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class GoogleAuthReceiver extends BroadcastReceiver
{

	@Override
	public void onReceive(final Context context, final Intent intent)
	{
		Log.d(GoogleAuthService.TAG, "onReceive: " + intent.getAction());
		intent.setClass(context, GoogleAuthService.class);
		context.startService(intent);
	}

}
