package com.example.mybackend.Service.impl;

import com.example.mybackend.Repository.CollectionRepository;
import com.example.mybackend.Repository.FriendRepository;
import com.example.mybackend.Service.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl  implements IStatisticsService {

    @Autowired
    private FriendRepository friendRepository;
    @Autowired
    private CollectionRepository collectionRepository;

    @Override
    public int countFriend() {
        return (int) friendRepository.count();
    }

    @Override
    public int countArticle() {
        return 0;
    }

    @Override
    public int countCollection() {
        return (int) collectionRepository.count();
    }

    @Override
    public int countCircle() {
        return 0;
    }
}
