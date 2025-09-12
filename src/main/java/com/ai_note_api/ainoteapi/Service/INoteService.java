package com.ai_note_api.ainoteapi.Service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ai_note_api.ainoteapi.Dto.NoteSummaryDto;
import com.ai_note_api.ainoteapi.Dto.SendNoteDto;
import com.ai_note_api.ainoteapi.Entity.Notes;

public interface INoteService {
	
	public Notes sendNotes(SendNoteDto sendNoteDto);
	//public List<NoteSummaryDto> getnotelist(NoteSummaryDto noteSummaryDto);
	public Page<NoteSummaryDto> getnotelist(Pageable pageable);
	public NoteSummaryDto getnotebyid(Long id);
	public Notes findnotebyid(Long id);
	

}
