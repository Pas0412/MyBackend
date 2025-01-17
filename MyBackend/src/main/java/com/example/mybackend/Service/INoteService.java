package com.example.mybackend.Service;

import com.example.mybackend.DTO.NoteDTO;
import com.example.mybackend.Entity.Note;

import java.util.List;

public interface INoteService {
    List<Note> getAllNotes();

    List<NoteDTO> getNotes();

    void thumbsUp(int id);
}