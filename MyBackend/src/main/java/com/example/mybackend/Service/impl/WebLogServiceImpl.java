package com.example.mybackend.Service.impl;

import com.example.mybackend.Entity.WebLog;
import com.example.mybackend.Repository.WebLogRepository;
import com.example.mybackend.Service.IWebLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebLogServiceImpl implements IWebLogService {
    @Autowired
    private WebLogRepository webLogRepository;

    @Override
    public List<WebLog> getAllLogs() {
        return webLogRepository.findAll();
    }
}
