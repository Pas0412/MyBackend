package com.example.mybackend.Controller;
import com.example.mybackend.DTO.CollectionDTO;
import com.example.mybackend.Service.IStatisticsService;
import com.example.mybackend.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.mybackend.Entity.Collection;
import com.example.mybackend.Service.ICollectionService;

@RestController
@CrossOrigin(origins = "http://huangyonghui.cn")
public class CollectionController {

    @Autowired
    private ICollectionService collectionService;

    @Autowired
    private IStatisticsService statisticsService;

    @RequestMapping("/get-all-collections")
    @ResponseBody
    public Result<Object> getAllCollections() {
        List<Collection> collections = collectionService.getAllCollections();
        statisticsService.incrementViews("collections");
        try {
            return Result.success(collections);
        } catch (Exception e) {
            return Result.fail(e.toString());
        }
    }

    @RequestMapping("/get-collections")
    @ResponseBody
    public Result<Object> getCollections() {
        try {
            List<CollectionDTO> collections = collectionService.getCollections();
            return Result.success(collections);
        } catch (Exception e) {
            return Result.fail(e.toString());
        }
    }

    @PostMapping("/thumbs-up")
    @ResponseBody
    public Result<Void> ThumbsUp(@RequestParam(name = "id") Integer id) {
        try {
            collectionService.thumbsUp(id);
            return Result.success();
        } catch (Exception e) {
            return Result.fail(e.toString());
        }
    }
}