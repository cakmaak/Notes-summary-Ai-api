package com.ai_note_api.ainoteapi.Dto;

import com.ai_note_api.ainoteapi.Enums.NoteStatus;

import lombok.Data;

@Data
public class NoteSummaryDto {
	
	private Long id;
	
	private NoteStatus noteStatus;
	
	private String summary;

}
