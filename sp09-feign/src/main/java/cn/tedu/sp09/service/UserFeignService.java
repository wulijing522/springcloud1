package cn.tedu.sp09.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;

@FeignClient("user-service")
public interface UserFeignService {
    @GetMapping("/{userId}")
    JsonResult<User> getUser(@PathVariable("userId") Integer userId);

    // 拼接路径 /{userId}/score?score=新增积分
    @GetMapping("/{userId}/score")
    JsonResult addScore(@PathVariable("userId") Integer userId, @RequestParam("score") Integer score);
}
