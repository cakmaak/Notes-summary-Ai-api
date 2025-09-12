package com.ai_note_api.ainoteapi.Controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ai_note_api.ainoteapi.Dto.NoteSummaryDto;
import com.ai_note_api.ainoteapi.Dto.SendNoteDto;
import com.ai_note_api.ainoteapi.Entity.Notes;

public interface INoteController {
	
	public Notes sendNotes(SendNoteDto sendNoteDto);
	public Page<NoteSummaryDto> getnotelist(Pageable pageable);
	public NoteSummaryDto getnotebyid(Long id);

}
