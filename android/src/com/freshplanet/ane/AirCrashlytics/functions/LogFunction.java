package com.freshplanet.ane.AirCrashlytics.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREObject;
import com.crashlytics.android.Crashlytics;

/**
 * Created by xviricel on 06/03/15.
 */
public class LogFunction extends BaseFunction
{
	public FREObject call(FREContext context, FREObject[] args)
	{
		super.call(context, args);

		String message = getStringFromFREObject(args[0]);

		Crashlytics.log(":: [ Crashlytics ] :: " + message);

		return null;
	}
}
