package com.example.mybackend.Controller;
import com.example.mybackend.DTO.NoteDTO;
import com.example.mybackend.Service.IStatisticsService;
import com.example.mybackend.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.mybackend.Entity.Note;
import com.example.mybackend.Service.INoteService;

@RestController
@CrossOrigin(origins = "http://huangyonghui.cn")
public class NoteController {

    @Autowired
    private INoteService noteService;

    @Autowired
    private IStatisticsService statisticsService;

    @RequestMapping("/get-all-notes")
    @ResponseBody
    public Result<Object> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        statisticsService.incrementViews("notes");
        try {
            return Result.success(notes);
        } catch (Exception e) {
            return Result.fail(e.toString());
        }
    }

    @RequestMapping("/get-notes")
    @ResponseBody
    public Result<Object> getNotes() {
        try {
            List<NoteDTO> notes = noteService.getNotes();
            return Result.success(notes);
        } catch (Exception e) {
            return Result.fail(e.toString());
        }
    }

    @PostMapping("/note-thumbs-up")
    @ResponseBody
    public Result<Void> ThumbsUp(@RequestParam(name = "id") Integer id) {
        try {
            noteService.thumbsUp(id);
            return Result.success();
        } catch (Exception e) {
            return Result.fail(e.toString());
        }
    }
}