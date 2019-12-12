package com.aike.plugin.user.application;

import android.app.Application;
import android.util.Log;
import com.aike.httpserver.AikeHttpService;
import com.aike.plugin.user.net.UserNetConfig;
import com.aike.plugin.user.utils.UserEventBusUtils;

/**
 * @Author xiekongying001
 * @Date 2019/10/27 17:45
 * @Des
 */
public class UserApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    init();
  }


  private void init() {
    UserEventBusUtils.init();
    AikeHttpService.initService("user",new UserNetConfig());
  }
}
