package com.example.mybackend.Controller;

import com.example.mybackend.Entity.WebLog;
import com.example.mybackend.Service.IWebLogService;
import com.example.mybackend.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yonghui HUANG
 * 获取网站日志
 */
@Controller
@CrossOrigin(origins = "http://huangyonghui.cn")
public class WebLogController {

    @Autowired
    private IWebLogService webLogService;

    // http://127.0.0.1:8081/count
    @RequestMapping("/get-all-logs")
    @ResponseBody
    public Result<Object> getAllLogs() {
        try {
            List<WebLog> data = webLogService.getAllLogs();
            return Result.success(data);
        } catch (Exception e) {
            return Result.fail(e.toString());
        }
    }
}

