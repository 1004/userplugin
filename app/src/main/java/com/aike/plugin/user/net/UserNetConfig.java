package com.aike.plugin.user.net;

import com.aike.httpserver.config.service.dependency.DefaultRetrofitConfigDependency;

/**
 * 创建时间: 2019/12/12 14:40 <br>
 * 作者: xiekongying001 <br>
 * 描述:
 */
public class UserNetConfig extends DefaultRetrofitConfigDependency {
  @Override
  public String baseUrl() {
    return "http://www.kuaidi100.com/";
  }

}
