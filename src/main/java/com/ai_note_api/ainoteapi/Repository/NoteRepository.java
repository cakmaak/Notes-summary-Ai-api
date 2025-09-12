package com.ai_note_api.ainoteapi.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ai_note_api.ainoteapi.Entity.Notes;

@Repository
public interface NoteRepository extends JpaRepository<Notes, Long> {
    
    List<Notes> findByUserId(Long userId);
    Page<Notes> findAllByUserId(Long userId, Pageable pageable);

}
