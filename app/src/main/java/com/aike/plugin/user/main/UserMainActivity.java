package com.aike.plugin.user.main;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.aike.plugin.event.cource.CoureseMainEvent;
import com.aike.plugin.event.user.UserHomeEvent;
import com.aike.plugin.user.R;
import com.aike.plugin.user.utils.UserEventBusUtils;
import com.aike.router.Route;
import com.aike.router.Router;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
        Router.create("xky://cource/main").navigate(UserMainActivity.this);
      }
    });
    findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        UserEventBusUtils.post(new CoureseMainEvent());
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
