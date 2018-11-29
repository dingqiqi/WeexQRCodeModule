package com.lakala.appcomponent.qrcodemodule;

import android.app.Activity;
import android.content.Intent;

/**
 * js调用方法的本地实现
 * Created by dingqq on 2018/10/22.
 */

public class ScanManager {

    public static ScanConfig mScanConfig;

    public void scanQRCode(Activity activity, ScanConfig scanConfig, ScanCallback scanCallback) {
        ScanQRCodeActivity.setScanCallback(scanCallback);

        mScanConfig = scanConfig;

        activity.startActivity(new Intent(activity, ScanQRCodeActivity.class));
    }


    public interface ScanCallback {
        void onResult(String result);
    }
}
