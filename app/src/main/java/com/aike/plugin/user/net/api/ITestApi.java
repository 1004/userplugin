package com.aike.plugin.user.net.api;

import com.aike.httpserver.adapter.calladapter.IAikeHttpCall;
import retrofit2.http.GET;

/**
 * 创建时间: 2019/11/21 14:02 <br>
 * 作者: xiekongying001 <br>
 * 描述:
 */
public interface ITestApi {
  @GET("query?type=yuantong&postid=11111111111")
  IAikeHttpCall<Object> getKnowledgeSystem();
}
