package com.example.mybackend.Service;

public interface IStatisticsService {
    int countFriend();
    int countNote();
    int countCollection();
    int countCircle();

    int countViews();

    void incrementViews(String name);
}
