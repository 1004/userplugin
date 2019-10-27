package com.aike.plugin.user.application;

import android.app.Application;
import android.util.Log;

/**
 * @Author xiekongying001
 * @Date 2019/10/27 17:45
 * @Des
 */
public class UserApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    Log.i("UserApplication","UserApplication--oncreate");
  }
}
