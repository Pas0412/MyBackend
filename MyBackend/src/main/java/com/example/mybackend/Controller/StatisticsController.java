package com.example.mybackend.Controller;

import com.example.mybackend.Entity.Friend;
import com.example.mybackend.Service.IFriendService;
import com.example.mybackend.Service.IStatisticsService;
import com.example.mybackend.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yonghui HUANG
 * 专门做一些统计操作
 */
@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class StatisticsController {

    @Autowired
    private IStatisticsService statisticsService;

    // http://127.0.0.1:8081/count
    @RequestMapping("/count")
    @ResponseBody
    public Result<Object> count() {
        Map<String, Object> data = new HashMap<>();
        data.put("friend", statisticsService.countFriend()); // 模拟设置朋友数量，实际替换为获取统计值逻辑
        data.put("article", statisticsService.countArticle());
        data.put("circle", statisticsService.countCircle());
        data.put("collection", statisticsService.countCollection());
        try {
            return Result.success(data);
        } catch (Exception e) {
            return Result.fail(e.toString());
        }
    }
}

