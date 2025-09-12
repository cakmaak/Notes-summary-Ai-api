package com.ai_note_api.ainoteapi.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ai_note_api.ainoteapi.Repository.UserRepository;
import com.ai_note_api.ainoteapi.Security.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;
import org.springframework.web.cors.CorsConfigurationSource;
import com.ai_note_api.ainoteapi.Controller.UserControllerimpl;
import com.ai_note_api.ainoteapi.Dto.LoginRequestDto;
import com.ai_note_api.ainoteapi.Dto.NoteSummaryDto;
import com.ai_note_api.ainoteapi.Dto.SendNoteDto;
import com.ai_note_api.ainoteapi.Entity.Notes;
import com.ai_note_api.ainoteapi.Entity.User;
import com.ai_note_api.ainoteapi.Enums.NoteStatus;
import com.ai_note_api.ainoteapi.Enums.Role;
import com.ai_note_api.ainoteapi.Repository.NoteRepository;

@Service
public class NoteServiceimpl implements INoteService {
    
	
	@Autowired
	SecurityFilterChain securityFilterChain;
	
	@Autowired
	NoteRepository noteRepository;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	AIServiceimpl aiServiceimpl;


	@Override
	public Notes sendNotes(SendNoteDto sendNoteDto) {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		 if (auth == null || !auth.isAuthenticated() || "anonymousUser".equals(auth.getPrincipal())) {
		        throw new RuntimeException("Please login ");
		    }
		 
		 String email=((UserDetails) auth.getPrincipal()).getUsername();
		 User user=userService.getUserbyEmail(email);
		 
		 Notes note=new Notes();
		 
		 note.setUser(user);
		 note.setTimestamp(LocalDateTime.now());
		 note.setAttempts(0);
		 note.setRawtext(sendNoteDto.getRawtext());
		 
		 Notes savednote=noteRepository.save(note);
		 System.out.println("Note ID " + note.getId() + " is QUEUED");
		 
		 aiServiceimpl.aiprocessAsync(savednote);
		 return savednote;
		 

	}


	@Override
	public Page<NoteSummaryDto> getnotelist(Pageable pageable) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (auth == null || !auth.isAuthenticated() || "anonymousUser".equals(auth.getPrincipal())) {
		        throw new RuntimeException("Please login");
		    }

		    String email = ((UserDetails) auth.getPrincipal()).getUsername();
		    User user = userService.getUserbyEmail(email);

		    Page<Notes> notesPage;

		    if (user.getRole() == Role.AGENT) {
		        notesPage = noteRepository.findAllByUserId(user.getId(), pageable);
		    } else  {  
		        notesPage = noteRepository.findAll(pageable);
		    }

		    
		    return notesPage.map(note -> {
		        NoteSummaryDto dto = new NoteSummaryDto();
		        dto.setId(note.getId());
		        dto.setNoteStatus(note.getStatus());
		        dto.setSummary(note.getSummary());
		        return dto;
		    });
	}
	@Override
	public Notes findnotebyid(Long id) {
		Optional<Notes> optional=noteRepository.findById(id);
		Notes note=optional.get();
		return note;
	}


	@Override
	public NoteSummaryDto getnotebyid(Long id) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth == null || !auth.isAuthenticated() || "anonymousUser".equals(auth.getPrincipal())) {
	        throw new RuntimeException("Please login");
	    }

	    String email = ((UserDetails) auth.getPrincipal()).getUsername();
	    User user = userService.getUserbyEmail(email);

	    if (!user.getRole().equals(Role.ADMIN)) {
	        throw new RuntimeException("Only admins can view notes by ID");
	    }

	    Notes note = noteRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Note not found with id: " + id));

	    NoteSummaryDto noteSummarydto = new NoteSummaryDto();
	    noteSummarydto.setId(note.getId());
	    noteSummarydto.setNoteStatus(note.getStatus());
	    noteSummarydto.setSummary(note.getSummary());

	    return noteSummarydto; 
	}
}




/*   //                         NOT PAGEABLE
	@Override
	public List<NoteSummaryDto> getnotelist(NoteSummaryDto noteSummaryDto) {
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		 if (auth == null || !auth.isAuthenticated() || "anonymousUser".equals(auth.getPrincipal())) {
		        throw new RuntimeException("Please login ");
		    }
		 
		 String email=((UserDetails) auth.getPrincipal()).getUsername();
		 User user=userService.getUserbyEmail(email);
		 
		 List<Notes> allnotelist=noteRepository.findAll();
		 if (user.getRole()==Role.AGENT) {
			 List<NoteSummaryDto> notelistdtoforagent=new ArrayList<>();
			 for (Notes notes : allnotelist) {
				 if (notes.getUser().getId().equals(user.getId())) {
					 NoteSummaryDto noteSummarydto=new NoteSummaryDto();
					 Long id =notes.getId();
					 String summary=notes.getSummary();
					 NoteStatus noteStatus=notes.getStatus();
					 noteSummarydto.setId(id);
					 noteSummarydto.setNoteStatus(noteStatus);
					 noteSummarydto.setSummary(summary);
					 notelistdtoforagent.add(noteSummarydto);		
				}
			}	 
			 return notelistdtoforagent;
		} 
		
		 
		 
		 else {
			List<NoteSummaryDto> notelistdtoforadmin=new ArrayList<>();
			for (Notes notes : allnotelist) {
				 NoteSummaryDto noteSummarydto=new NoteSummaryDto();
				 Long id=notes.getId();
				 String summary=notes.getSummary();
				 NoteStatus noteStatus=notes.getStatus();
				 noteSummarydto.setId(id);
				 noteSummarydto.setNoteStatus(noteStatus);
				 noteSummarydto.setSummary(summary);
				 notelistdtoforadmin.add(noteSummarydto);

			}
			return notelistdtoforadmin;
			
		}
		 
		 
*/
		
	



