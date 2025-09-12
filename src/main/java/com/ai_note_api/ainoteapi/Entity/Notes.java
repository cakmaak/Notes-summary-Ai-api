package com.ai_note_api.ainoteapi.Entity;

import java.security.spec.DSAPrivateKeySpec;
import java.time.LocalDateTime;

import com.ai_note_api.ainoteapi.Enums.NoteStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "notes",schema = "ainoteapi")
@Data
public class Notes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "rawtext",columnDefinition = "TEXT")
	private String rawtext;
	
	@Column(name = "summary",columnDefinition = "TEXT")
	private String summary;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private NoteStatus status=NoteStatus.QUEUED;
	
	@Column(name = "timestamp")
	private LocalDateTime timestamp=LocalDateTime.now();
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "attempts")
	private int attempts=0;

}
