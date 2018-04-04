package cn.xhuww.mvvm.api;

import cn.xhuww.mvvm.api.data.FoodDetailBean;
import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by xhu_ww on 2018/4/4.
 * description:食谱相关
 */

public interface FoodService {
    //获取菜单明细
    @POST("/1164-1")
    Observable<FoodDetailBean> getFoodDetail(@Query("showapi_appid") String showapi_appid,
                                             @Query("showapi_sign") String showapi_appKey,
                                             @Query("type") String type,
                                             @Query("page") String page);

}
