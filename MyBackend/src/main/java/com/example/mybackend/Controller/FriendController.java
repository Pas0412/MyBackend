/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.mybackend.Controller;

import com.example.mybackend.Entity.Friend;
import com.example.mybackend.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.mybackend.Service.IFriendService;

/**
 * @author Yonghui HUANG
 */
@Controller
@CrossOrigin(origins = "http://huangyonghui.cn")
public class FriendController {

    @Autowired
    private IFriendService friendService;

    // http://127.0.0.1:8081/friend
    @RequestMapping("/friend")
    @ResponseBody
    public Result<Void> friend(@RequestParam(name = "name") String name, @RequestParam(name = "type") String type, @RequestParam(name = "../assets/friend.png") String avatarURL) {
        Friend friend = new Friend(name, type, avatarURL);
        try {
            friendService.saveFriend(friend);
            return Result.success();
        } catch (Exception e) {
            return Result.fail("添加朋友信息失败", e);
        }
    }

    // http://127.0.0.1:8081/save_friend?name=newName&age=11
//    @RequestMapping("/edit_friend")
//    @ResponseBody
//    public String saveFriend(Friend u) {
//        return u.getType() + u.getName() + "will be saved";
//    }

}
