package com.example.mybackend.Service;

import com.example.mybackend.DTO.CollectionDTO;
import com.example.mybackend.Entity.Collection;

import java.util.List;

public interface ICollectionService {
    List<Collection> getAllCollections();

    List<CollectionDTO> getCollections();

    void thumbsUp(int id);
}
