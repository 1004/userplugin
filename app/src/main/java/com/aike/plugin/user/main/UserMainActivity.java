package com.aike.plugin.user.main;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.aike.httpserver.AikeHttpService;
import com.aike.httpserver.adapter.calladapter.ASimpleCallBack;
import com.aike.plugin.event.cource.CoureseMainEvent;
import com.aike.plugin.event.user.UserHomeEvent;
import com.aike.plugin.user.R;
import com.aike.plugin.user.net.api.ITestApi;
import com.aike.plugin.user.utils.UserEventBusUtils;
import com.aike.router.Route;
import com.aike.router.Router;
import com.analytisc.sdk.mapping.AikeVirtualMappingClient;
import com.analytisc.sdk.mapping.config.AikeVirtualMappingConfig;
import com.qihoo360.replugin.RePlugin;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import retrofit2.Response;

/**
 * @Author xiekongying001
 * @Date 2019/10/27 16:08
 * @Des
 */
@Route("xky://user/main")
public class UserMainActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    UserEventBusUtils.register(this);
    findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        boolean navigate = Router.create("xky://cource/main").navigate(UserMainActivity.this);
      }
    });
    findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        UserEventBusUtils.post(new CoureseMainEvent());
      }
    });
    findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        AikeHttpService.createService("user",ITestApi.class).getKnowledgeSystem().enqueue(
            new ASimpleCallBack() {
              @Override
              public void onResponse(Response response, Object entity) {
                Log.i("HTTP","onResponse-"+entity.toString());
              }

              @Override
              public void onError(Throwable e) {
                Log.i("HTTP","onError-"+e.toString());
              }
            });
      }
    });
    findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        AikeVirtualMappingClient.startVirtualMappingTools();
     }
    });
    final Button btn5 = findViewById(R.id.btn5);
    findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        AikeVirtualMappingClient.updataEnable(!AikeVirtualMappingConfig.isEnable);
        btn5.setText(AikeVirtualMappingConfig.isEnable?"无埋点圈选关":"无埋点圈选开");
      }
    });
  }


  @Subscribe(threadMode = ThreadMode.MAIN)
  public void mainEvent(UserHomeEvent userEvent) {
    Log.i("UserMainActivity","用户插件收到消息");
  }


  @Override
  protected void onDestroy() {
    super.onDestroy();
    UserEventBusUtils.unregister(this);
  }
}
