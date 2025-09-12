package com.ai_note_api.ainoteapi.Controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai_note_api.ainoteapi.Dto.NoteSummaryDto;
import com.ai_note_api.ainoteapi.Dto.SendNoteDto;
import com.ai_note_api.ainoteapi.Entity.Notes;
import com.ai_note_api.ainoteapi.Service.INoteService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/ainoteapi")
public class NoteControllerimpl implements INoteController {
	
	@Autowired
	INoteService noteService;
	
	@PostMapping("/sendnote")
	@Operation(summary = "Create a new note and queue AI summary job")
	@Override
	public Notes sendNotes(@RequestBody SendNoteDto sendNoteDto) {
		return noteService.sendNotes(sendNoteDto) ;
	}

	@Override
	@GetMapping("/getnotes")
	@Operation(summary = "summary content with pagination")
	
	public Page<NoteSummaryDto> getnotelist(@ParameterObject Pageable pageable) {
		return noteService.getnotelist(pageable);
	}
	
	
	@Operation(summary = "get note by id for admins")
	@GetMapping("/getnote/{id}")
	@Override
	public NoteSummaryDto getnotebyid(@PathVariable Long id) {
		
		return noteService.getnotebyid(id);
	}

}
