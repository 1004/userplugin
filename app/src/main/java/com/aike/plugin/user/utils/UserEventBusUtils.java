package com.aike.plugin.user.utils;

import com.aike.eventbus.AikeEventBusIPC;
import com.aike.plugin.user.config.UserConstants;

/**
 * 创建时间: 2019/11/19 11:34 <br>
 * 作者: xiekongying001 <br>
 * 描述:
 */
public class UserEventBusUtils {
  public static void init(){
    AikeEventBusIPC.registerBinder(UserConstants.PLUGIN_NAME);
  }
  public static void register(Object subscribe){
    AikeEventBusIPC.register(UserConstants.PLUGIN_NAME,subscribe);
  }

  public static void unregister(Object subscribe){
    AikeEventBusIPC.unregister(UserConstants.PLUGIN_NAME,subscribe);
  }

  public static void post(Object event){
    AikeEventBusIPC.post(event);
  }

}
