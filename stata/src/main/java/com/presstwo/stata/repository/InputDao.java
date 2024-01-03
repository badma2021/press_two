package com.presstwo.stata.repository;

import com.presstwo.stata.entity.Input;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InputDao extends MongoRepository<Input, String> {

    List<Input> findAllByUserIdOrderByUpdatedAtDesc(String userID);

    Page<Input> findByAvailable(boolean b, PageRequest updatedAt);

    List<Input> findByCategory(String category);
}

