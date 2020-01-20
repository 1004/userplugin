package com.aike.plugin.user.application;

import android.app.Application;
import android.util.Log;
import com.aike.httpserver.AikeHttpService;
import com.aike.plugin.user.net.UserNetConfig;
import com.aike.plugin.user.utils.UserEventBusUtils;
import com.analytics.sdk.AikeAnalytics;
import com.analytics.sdk.config.AnalyticsParams;
import com.analytics.sdk.event.data.ext.IExtEventDataLoader;
import com.analytics.sdk.liferecycle.ActivityLiferecyleCallBack;
import com.analytisc.sdk.mapping.AikeVirtualMappingClient;
import com.qihoo360.replugin.RePlugin;
import java.util.HashMap;
import java.util.Map;

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
    String down = "https://download.eu-west-3.fromsmash.co/transfer/pSEvoGRSvS-c0/";
    IExtEventDataLoader iExtEventDataLoader = new IExtEventDataLoader() {
      @Override
      public Map<String, String> getExtEventData() {
        HashMap<String, String> ext = new HashMap<>();
        ext.put("newhouse", "www.baidu.com");
        ext.put("newhouse2", "www.baidu.com2");
        return ext;
      }
    };
    AnalyticsParams.Builder builder = new AnalyticsParams.Builder()
        .anlyticsDataUrl(down)
        .digUrl("http://www.baidu.com")
        .hostApplication((Application) RePlugin.getHostContext().getApplicationContext())
        .pluginApplication(this)
        .isDebug(true)
        .pluginName("user")
        .extEventDataLoader(iExtEventDataLoader)
        .pluginPackageName(RePlugin.getPluginInfo("user").getPackageName());
    AikeAnalytics.init(builder.build());
  }
}
