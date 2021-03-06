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

package com.freshplanet.AirCrashlytics;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.freshplanet.AirCrashlytics.functions.CrashFunction;
import com.freshplanet.AirCrashlytics.functions.GetApiKeyFunction;
import com.freshplanet.AirCrashlytics.functions.GetVersionFunction;
import com.freshplanet.AirCrashlytics.functions.SetBoolFunction;
import com.freshplanet.AirCrashlytics.functions.SetDebugModeFunction;
import com.freshplanet.AirCrashlytics.functions.SetFloatFunction;
import com.freshplanet.AirCrashlytics.functions.SetIntFunction;
import com.freshplanet.AirCrashlytics.functions.SetStringFunction;
import com.freshplanet.AirCrashlytics.functions.SetUserIdentifierFunction;
import com.freshplanet.AirCrashlytics.functions.StartFunction;
import com.freshplanet.AirCrashlytics.functions.LogAndExitFunction;
import com.freshplanet.AirCrashlytics.functions.LogFunction;

public class ExtensionContext extends FREContext {
	@Override
	public void dispose() {
		Extension.context = null;
	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		Map<String, FREFunction> functions = new HashMap<String, FREFunction>();

		functions.put("start", new StartFunction());
		functions.put("crash", new CrashFunction());
		functions.put("getApiKey", new GetApiKeyFunction());
		functions.put("getVersion", new GetVersionFunction());
		functions.put("setDebugMode", new SetDebugModeFunction());
		functions.put("setUserIdentifier", new SetUserIdentifierFunction());
		functions.put("setBool", new SetBoolFunction());
		functions.put("setInt", new SetIntFunction());
		functions.put("setFloat", new SetFloatFunction());
		functions.put("setString", new SetStringFunction());
		functions.put("log", new LogFunction());
		functions.put("crashAndLog", new LogAndExitFunction());

		return functions;
	}
}