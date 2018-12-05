package com.lakala.appcomponent.qrcodemodule;

import com.taobao.weex.bridge.JSCallback;

public interface IQRCode {

    boolean scanQRCode(String params, JSCallback callback);

    boolean createQRCode(String params, JSCallback jsCallback);

}
