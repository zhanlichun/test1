package com.tedu.sp04.order.feignClient;

import org.springframework.stereotype.Component;

import com.tedu.sp01.pojo.User;
import com.tedu.web.util.JsonResult;
@Component
public class UserFeignServiceFB implements UserFeignService {
	//获取商品列表的降级方法，模拟使用缓存数据
	@Override
	public JsonResult<User> getUser(Integer userId) {
		if (Math.random()<0.4) {
			return JsonResult.ok(new User(userId, "缓存name"+userId, "缓存pwd"+userId));
		}
		return JsonResult.err("无法获取用户信息");
	}

	@Override
	public JsonResult addScore(Integer userId, Integer score) {
		return JsonResult.err("无法添加用户积分");
	}

}
