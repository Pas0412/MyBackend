package com.example.mybackend.Service;

import com.example.mybackend.Entity.WebLog;

import java.util.List;

public interface IWebLogService {
    List<WebLog> getAllLogs();
}
