package com.example.mybackend.Service;

import com.example.mybackend.Entity.Friend;
import java.util.List;

public interface IFriendService {
    // 保存朋友信息
    Friend saveFriend(Friend friend);
    // 根据id查询朋友信息
    Friend findFriendById(int id);
    // 查询所有朋友信息
    List<Friend> findAllFriends();
    // 根据id更新朋友信息
    Friend updateFriend(int id, Friend updatedFriend);
    // 查找重复朋友
    Boolean isFriendExist(int id);
    // 根据id删除朋友信息
    void deleteFriendById(int id);
}