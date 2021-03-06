//////////////////////////////////////////////////////////////////////////////////////
//
//  Copyright 2012 Freshplanet (http://freshplanet.com | opensource@freshplanet.com)
//  
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//  
//    http://www.apache.org/licenses/LICENSE-2.0
//  
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
//  
//////////////////////////////////////////////////////////////////////////////////////

package com.freshplanet.AirCrashlytics.functions;

import android.util.Log;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREObject;
import com.crashlytics.android.Crashlytics;

public class LogAndExitFunction extends BaseFunction {
	private static final String TAG = "AirCrashlytics";

	public FREObject call(FREContext context, FREObject[] args) {
		super.call(context, args);

		String name = getStringFromFREObject(args[0]);
		String stack = getStringFromFREObject(args[1]);

		Crashlytics.log(":: [ Crashlytics ] :: " + name + ", next step!! Develop a realy crash in Android... stack: " + stack);
		Crashlytics.logException(new Exception("Crash app, name '" + name + "' stack: '" + stack + "'"));

		Log.d(TAG, "Crash app, name '" + name + "' stack: '" + stack + "'");

		//throw new RuntimeException("This is a crash");

		return null;
	}
}