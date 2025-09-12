package com.ai_note_api.ainoteapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ai_note_api.ainoteapi.Entity.Notes;
import com.ai_note_api.ainoteapi.Enums.NoteStatus;
import com.ai_note_api.ainoteapi.Repository.NoteRepository;

@Service
public class AIServiceimpl {
	@Autowired
	NoteRepository noteRepository;
	
	@Async
	public void aiprocessAsync(Notes note) {
		aiprocess(note);
	}
	
	
	
	
	@Retryable(retryFor  = Exception.class,maxAttempts = 3,backoff = @Backoff(delay = 2000))
	public void aiprocess(Notes note) {
		try {
			
			note.setStatus(NoteStatus.PROCESSING);
			noteRepository.save(note);
			System.out.println("Note ID " + note.getId() + " is PROCESSING");
			
			String raw = note.getRawtext();
			int firstDot = raw.indexOf('.') + 1;
			int secondDot = raw.indexOf('.', firstDot) + 1;

			String summarytext;
			if (firstDot > 0 && secondDot > 0 && secondDot <= 100) {
			    summarytext = raw.substring(0, secondDot);
			} else if(firstDot > 0) {
			    summarytext = raw.substring(0, firstDot); 
			} else {
			    summarytext = raw.length() > 100 ? raw.substring(0, 100) + ".." : raw;
			}
			
			Thread.sleep(5000);
			
			
			note.setSummary(summarytext);
			note.setStatus(NoteStatus.DONE);
			noteRepository.save(note);
			System.out.println("Note ID " + note.getId() + " is DONE");
			
		} catch (Exception e) {
			note.setStatus(NoteStatus.FAILED);
			note.setAttempts(note.getAttempts()+1);
			noteRepository.save(note);
			System.out.println("Note ID " + note.getId() + " FAILED");
			
		}
		
	}

}
