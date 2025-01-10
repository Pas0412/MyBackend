package com.example.mybackend.Controller;
import com.example.mybackend.DTO.CollectionDTO;
import com.example.mybackend.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.mybackend.Entity.Collection;
import com.example.mybackend.Service.ICollectionService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class CollectionController {

    @Autowired
    private ICollectionService collectionService;

    @RequestMapping("/get-all-collections")
    @ResponseBody
    public Result<Object> getAllCollections() {
        List<Collection> collections = collectionService.getAllCollections();
        try {
            return Result.success(collections);
        } catch (Exception e) {
            return Result.fail(e.toString());
        }
    }

    @RequestMapping("/get-collections")
    @ResponseBody
    public Result<Object> getCollections() {
        List<CollectionDTO> collections = collectionService.getCollections();
        try {
            return Result.success(collections);
        } catch (Exception e) {
            return Result.fail(e.toString());
        }
    }

    @RequestMapping("/thumbs-up")
    @ResponseBody
    public Result<Object> getThumbsUp(@RequestParam(name = "id") int id) {
        collectionService.thumbsup(id);
        return Result.success();
    }
}