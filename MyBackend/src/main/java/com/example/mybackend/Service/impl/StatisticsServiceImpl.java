package com.example.mybackend.Service.impl;

import com.example.mybackend.Repository.CollectionRepository;
import com.example.mybackend.Repository.FriendRepository;
import com.example.mybackend.Repository.NoteRepository;
import com.example.mybackend.Repository.ViewRepository;
import com.example.mybackend.Service.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StatisticsServiceImpl  implements IStatisticsService {

    @Autowired
    private FriendRepository friendRepository;
    @Autowired
    private CollectionRepository collectionRepository;
    @Autowired
    private ViewRepository viewRepository;
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public int countFriend() {
        return (int) friendRepository.count();
    }

    @Override
    public int countNote() {
        return (int) noteRepository.count();
    }

    @Override
    public int countCollection() {
        return (int) collectionRepository.count();
    }

    @Override
    public int countCircle() {
        return 0;
    }

    @Override
    public int countViews() {
        return viewRepository.sumViews();
    }

    @Override
    @Transactional
    public void incrementViews(String name) {
        viewRepository.incrementViewsByName(name);
    }
}
