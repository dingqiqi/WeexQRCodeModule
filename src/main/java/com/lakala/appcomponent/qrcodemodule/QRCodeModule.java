package com.lakala.appcomponent.qrcodemodule;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import org.json.JSONException;
import org.json.JSONObject;

public class QRCodeModule extends WXModule implements IQRCode {

    private ScanManager scanManager;

    @JSMethod
    @Override
    public boolean scanQRCode(String params, final JSCallback callback) {
        Context context = mWXSDKInstance.getContext();
        if (context == null) {
            return false;
        }

        if (scanManager == null) {
            scanManager = new ScanManager();
        }

        ScanConfig scanConfig = null;
        if (!TextUtils.isEmpty(params)) {
            scanConfig = new ScanConfig();

            try {
                JSONObject jsonObject = new JSONObject(params);

                //状态栏颜色
                if (jsonObject.has("statusBarColor")) {
                    scanConfig.setStatusBarColor(Color.parseColor(jsonObject.getString("statusBarColor")));
                }

                //标题栏颜色
                if (jsonObject.has("toolbarBarColor")) {
                    scanConfig.setToolbarBarColor(Color.parseColor(jsonObject.getString("toolbarBarColor")));
                }

                //标题
                if (jsonObject.has("title")) {
                    scanConfig.setTitle(jsonObject.getString("title"));
                }

                //下面文字提示
                if (jsonObject.has("hint")) {
                    scanConfig.setHint(jsonObject.getString("hint"));
                }

                /*是否播放声音*/
                if (jsonObject.has("isPlayBeep")) {
                    scanConfig.setPlayBeep(jsonObject.getBoolean("isPlayBeep"));
                }

                /*是否震动*/
                if (jsonObject.has("isShake")) {
                    scanConfig.setShake(jsonObject.getBoolean("isShake"));
                }

                /*是否显示闪光灯按钮*/
                if (jsonObject.has("isShowFlashLight")) {
                    scanConfig.setShowFlashLight(jsonObject.getBoolean("isShowFlashLight"));
                }

                /*四个角的颜色*/
                if (jsonObject.has("reactColor")) {
                    scanConfig.setReactColor(Color.parseColor(jsonObject.getString("reactColor")));
                }

                if (jsonObject.has("frameLineColor")) {
                    scanConfig.setFrameLineColor(Color.parseColor(jsonObject.getString("frameLineColor")));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        scanManager.scanQRCode((Activity) context, scanConfig, new ScanManager.ScanCallback() {
            @Override
            public void onResult(String result) {
                if (callback != null) {
                    callback.invoke(result);
                }
            }
        });

        return true;
    }
}
