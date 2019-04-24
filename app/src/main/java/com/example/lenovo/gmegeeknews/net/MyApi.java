package com.example.lenovo.gmegeeknews.net;

import com.example.lenovo.gmegeeknews.bean.gold.GoldDetaBean;
import com.example.lenovo.gmegeeknews.bean.v2ex.VtexWebBean;
import com.example.lenovo.gmegeeknews.bean.zhihubean.DailyNewsBean;
import com.example.lenovo.gmegeeknews.bean.zhihubean.LoginBean;
import com.example.lenovo.gmegeeknews.bean.zhihubean.ZhiHuColumnBean;
import com.example.lenovo.gmegeeknews.bean.zhihubean.ZhiHuHotBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/*
* *  author gme
*/
public interface MyApi {


    String sBaseUrl = "http://yun918.cn/study/public/index.php/"; //登录接口
    @FormUrlEncoded//请求头  登录
    @POST("login")
    Observable<LoginBean> login(@Field("username") String name,@Field("password") String psw);






    String zhiFuDailyNewsUrl  = "http://news-at.zhihu.com/api/4/";  //知乎日报接口
    @GET("news/latest")
    Observable<DailyNewsBean> getZhiHuDailyNews();


    @GET("news/hot")    //知乎热门
    Observable<ZhiHuHotBean> getZhiHuHot();

    @GET("sections")
    Observable<ZhiHuColumnBean> getZhiHuColumn(); //知乎专栏


    String weChatUrl = "http://api.tianapi.com/wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1";


    String vtexUrl = "http://news-at.zhihu.com/api/4/";

    @GET("news/{id}")
    Observable<VtexWebBean> getVtexBean(@Path("id") int id);

    String gankUrl = "http://gank.io/api/";
   // data/{tech}/{num}/{page}
    @GET("data/{tech}/{num}/{page}")
    Observable<GoldDetaBean> getGoldDetaData(@Path("tech")String tech,@Path("num")int num,@Path("page")int page);
}
