package com.example.mybackend.Service.impl;
import com.example.mybackend.Service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mybackend.Entity.Friend;
import com.example.mybackend.Repository.FriendRepository;
import java.util.List;

@Service
public class FriendServiceImpl implements IFriendService {

    @Autowired
    private FriendRepository friendRepository;

    // 保存朋友信息
    @Override
    public Friend saveFriend(Friend friend) {
        return friendRepository.save(friend);
    }

    // 根据id查询朋友信息
    @Override
    public Friend findFriendById(int id) {
        return friendRepository.findById(id).orElse(null);
    }

    // 查询所有朋友信息
    @Override
    public List<Friend> findAllFriends() {
        return friendRepository.findAll();
    }

    // 根据id更新朋友信息
    @Override
    public Friend updateFriend(int id, Friend updatedFriend) {
        Friend existingFriend = friendRepository.findById(id).orElse(null);
        if (existingFriend!= null) {
            existingFriend.setName(updatedFriend.getName());
            existingFriend.setType(updatedFriend.getType());
            existingFriend.setAvatarURL(updatedFriend.getAvatarURL());
            return friendRepository.save(existingFriend);
        }
        return null;
    }

    @Override
    public Boolean isFriendExist(int id) {
        return null;
    }

    // 根据id删除朋友信息
    @Override
    public void deleteFriendById(int id) {
        friendRepository.deleteById(id);
    }
}
