package com.example.mybackend.Service.impl;

import com.example.mybackend.DTO.CollectionDTO;
import com.example.mybackend.Entity.Category;
import com.example.mybackend.Entity.Tag;
import com.example.mybackend.Repository.CategoryRepository;
import com.example.mybackend.Repository.TagRepository;
import com.example.mybackend.Service.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.mybackend.Entity.Collection;
import com.example.mybackend.Repository.CollectionRepository;

@Service
public class CollectionServiceImpl implements ICollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public CollectionServiceImpl(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public List<Collection> getAllCollections() {

        return collectionRepository.findAll();
    }

    // 根据传入的标签id列表，查找匹配这些标签的Collection集合，并转换为CollectionDTO列表返回
//    public List<CollectionDTO> findCollectionsByTags(List<Long> tagIds) {
//        List<Collection> allCollections = collectionRepository.findAll();
//        List<CollectionDTO> matchedDTOs = new ArrayList<>();
//
//        for (Collection collection : allCollections) {
//            List<Long> collectionTagIds = collection.getTags();
//            if (collectionTagIds.containsAll(tagIds)) {
//                CollectionDTO dto = convertToDTO(collection);
//                matchedDTOs.add(dto);
//            }
//        }
//
//        return matchedDTOs;
//    }

    // 获取所有的Collection列表，并转换为CollectionDTO列表返回
    public List<CollectionDTO> getCollections() {
        List<Collection> allCollections = collectionRepository.findAll();
        List<CollectionDTO> dtoList = new ArrayList<>();
        for (Collection collection : allCollections) {
            CollectionDTO dto = convertToDTO(collection);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public void thumbsUp(int id) {
        Optional<Collection> collectionOptional = collectionRepository.findById(id);
        if (collectionOptional.isPresent()) {
            Collection collection = collectionOptional.get();
            // 对 thumbs 字段加 1
            collection.setThumbs(collection.getThumbs() + 1);
            // 保存修改后的 Collection 对象回数据库
            collectionRepository.save(collection);
        } else {
            System.out.println("No collection found with id: " + id);
        }
    }

    // 辅助方法，将Collection实体转换为CollectionDTO对象
    private CollectionDTO convertToDTO(Collection collection) {
        CollectionDTO dto = new CollectionDTO();
        dto.setId(collection.getId());
        dto.setTitle(collection.getTitle());
        dto.setUrl(collection.getUrl());
        dto.setThumbs(collection.getThumbs());

        String tagIds = collection.getTags();
        List<String> tagTitles = getTagTitles(tagIds);
        dto.setTags(tagTitles);

        Optional<Category> categoryOptional = categoryRepository.findById(collection.getCategory());
        categoryOptional.ifPresent(category -> dto.setCategoryName(category.getTitle()));

        return dto;
    }

    // 辅助方法，根据标签id列表查询对应的标签名称列表
    private List<String> getTagTitles(String tagIds) {
        List<Integer> idList = Arrays.stream(tagIds.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<String> titleList = new ArrayList<>();
        for (int id : idList) {
            Optional<Tag> tagOptional = tagRepository.findById(id);
            tagOptional.ifPresent(tag -> titleList.add(tag.getTitle()));
        }

        // 将查询到的title列表拼接成逗号分隔的字符串
        return titleList;
    }
}