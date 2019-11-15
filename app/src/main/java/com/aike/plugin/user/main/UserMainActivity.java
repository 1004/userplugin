package com.aike.plugin.user.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.aike.plugin.user.R;
import com.aike.router.Route;
import com.aike.router.Router;

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
    findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Router.create("xky://course/main").navigate(UserMainActivity.this);
      }
    });
  }
}
