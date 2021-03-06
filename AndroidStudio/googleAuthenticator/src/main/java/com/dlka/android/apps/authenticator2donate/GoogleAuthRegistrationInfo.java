package com.dlka.android.apps.authenticator2donate;

import android.content.ContentValues;
import android.content.Context;

import com.dlka.android.apps.authenticator2donate.R;
import com.sonyericsson.extras.liveware.aef.registration.Registration;
import com.sonyericsson.extras.liveware.extension.util.ExtensionUtils;
import com.sonyericsson.extras.liveware.extension.util.registration.RegistrationInformation;
//import com.sonyericsson.extras.liveware.sdk.R;

public class GoogleAuthRegistrationInfo extends RegistrationInformation
{
	private Context mContext;

	public GoogleAuthRegistrationInfo(Context context)
	{
		if (context == null)
		{
			throw new IllegalArgumentException("context == null");
		}
		mContext = context;
	}

	@Override
	public int getRequiredNotificationApiVersion()
	{
		return 0;
	}

	@Override
	public ContentValues getExtensionRegistrationConfiguration()
	{
		String extension48 = ExtensionUtils.getUriString(mContext, R.drawable.icon_extension48);
		String extensionIcon = ExtensionUtils.getUriString(mContext, R.drawable.icon_extension);
		String iconHostapp = ExtensionUtils.getUriString(mContext, R.drawable.ic_launcher);

		//String configurationText = mContext.getString(R.string.configuration_text);
		String extensionName = "Authenticator";

		ContentValues values = new ContentValues();
		// values.put(Registration.ExtensionColumns.CONFIGURATION_ACTIVITY,
		// SamplePreferenceActivity.class.getName());
		//values.put(Registration.ExtensionColumns.CONFIGURATION_TEXT, configurationText);
		values.put(Registration.ExtensionColumns.EXTENSION_48PX_ICON_URI, extension48);
		values.put(Registration.ExtensionColumns.EXTENSION_ICON_URI_BLACK_WHITE, extensionIcon);
		values.put(Registration.ExtensionColumns.EXTENSION_KEY, GoogleAuthService.EXTENSION_KEY);
		values.put(Registration.ExtensionColumns.HOST_APP_ICON_URI, iconHostapp);
		values.put(Registration.ExtensionColumns.NAME, extensionName);
		values.put(Registration.ExtensionColumns.NOTIFICATION_API_VERSION, getRequiredNotificationApiVersion());
		values.put(Registration.ExtensionColumns.PACKAGE_NAME, mContext.getPackageName());

		return values;
	}

	@Override
	public int getRequiredWidgetApiVersion()
	{
		return 0;
	}

	@Override
	public int getRequiredControlApiVersion()
	{
		return 1;
	}

	@Override
	public int getRequiredSensorApiVersion()
	{
		return 0;
	}

	@Override
	public boolean isDisplaySizeSupported(int width, int height)
	{
		// FIXME: Should probably return valid widths/heights?
		return true;
	}
}
