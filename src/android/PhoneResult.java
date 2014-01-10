package com.phone.phone;

import java.util.Date;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog.Calls;
import android.telephony.PhoneNumberUtils;

public class PhonePlugin extends CordovaPlugin{

    private static final int PHONE_CALL = 0;     // 拨打电话
    private Date start_time;
    private String phonenumber;

    public boolean execute(String action, JSONArray data,
            CallbackContext callbackContext) throws JSONException {
        if (action.equals("Call")) {
            this.phonenumber = data.getString(0);
            this.Call(data.getString(0),callbackContext);
            return true;
        }
        else if(action.equals("Abort"))
        {
            return true;
        }
        else
        {

        }
        return false;
    }

    private void Call(String phonenumber, CallbackContext callbackContext) {

         if (phonenumber != null && phonenumber.length() > 0) {

            if(PhoneNumberUtils.isGlobalPhoneNumber(phonenumber)){
                Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+phonenumber));
                start_time = new Date();
                this.cordova.startActivityForResult(this, i,PHONE_CALL);
            }
            else{
               callbackContext.error(phonenumber+"不是有效的电话号码。");
            }
         } else {
               callbackContext.error("电话号码不能为空.");
         }

    }

    //中断电话
    private void abort(CallbackContext callbackContext) {

    }

}
