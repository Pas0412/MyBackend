package com.example.mybackend.Service.impl;

import com.example.mybackend.DTO.NoteDTO;
import com.example.mybackend.Entity.Category;
import com.example.mybackend.Entity.Tag;
import com.example.mybackend.Repository.CategoryRepository;
import com.example.mybackend.Repository.TagRepository;
import com.example.mybackend.Service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.mybackend.Entity.Note;
import com.example.mybackend.Repository.NoteRepository;

@Service
public class NoteServiceImpl implements INoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {

        return noteRepository.findAll();
    }

    // 根据传入的标签id列表，查找匹配这些标签的Note集合，并转换为NoteDTO列表返回
//    public List<NoteDTO> findNotesByTags(List<Long> tagIds) {
//        List<Note> allNotes = noteRepository.findAll();
//        List<NoteDTO> matchedDTOs = new ArrayList<>();
//
//        for (Note note : allNotes) {
//            List<Long> noteTagIds = note.getTags();
//            if (noteTagIds.containsAll(tagIds)) {
//                NoteDTO dto = convertToDTO(note);
//                matchedDTOs.add(dto);
//            }
//        }
//
//        return matchedDTOs;
//    }

    // 获取所有的Note列表，并转换为NoteDTO列表返回
    public List<NoteDTO> getNotes() {
        List<Note> allNotes = noteRepository.findAll();
        List<NoteDTO> dtoList = new ArrayList<>();
        for (Note note : allNotes) {
            NoteDTO dto = convertToDTO(note);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public void thumbsUp(int id) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        if (noteOptional.isPresent()) {
            Note note = noteOptional.get();
            // 对 thumbs 字段加 1
            note.setThumbs(note.getThumbs() + 1);
            // 保存修改后的 Note 对象回数据库
            noteRepository.save(note);
        } else {
            System.out.println("No note found with id: " + id);
        }
    }

    // 辅助方法，将Note实体转换为NoteDTO对象
    private NoteDTO convertToDTO(Note note) {
        NoteDTO dto = new NoteDTO();
        dto.setId(note.getId());
        dto.setTitle(note.getTitle());
        dto.setUrl(note.getUrl());
        dto.setThumbs(note.getThumbs());

        String tagIds = note.getTags();
        List<String> tagTitles = getTagTitles(tagIds);
        dto.setTags(tagTitles);

        Optional<Category> categoryOptional = categoryRepository.findById(note.getCategory());
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