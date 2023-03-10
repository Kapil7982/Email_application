package com.email_app.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.email_app.exception.EmailException;
import com.email_app.exception.LoginException;
import com.email_app.exception.UserException;
import com.email_app.model.Email;
import com.email_app.model.EmailDTO;
import com.email_app.service.EmailService;

@RestController
@RequestMapping("/masaimail")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/mail")
	public ResponseEntity<Email> sendEmail(@Valid @RequestBody EmailDTO emailDTO,
			@RequestParam("userEmail") String userEmail, @RequestParam("toEmail") String toEmail)
			throws EmailException, UserException, LoginException {
		return new ResponseEntity<Email>(emailService.sendEmail(emailDTO, userEmail, toEmail), HttpStatus.OK);
	}

	@PutMapping("/starred/{emailId}")
	public ResponseEntity<Email> starredEmail(@Valid @PathVariable("emailId") Integer emailId)
			throws EmailException, LoginException {
		return new ResponseEntity<Email>(emailService.starredEmail(emailId), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Email> deleteEmail(@PathVariable("id") Integer mailId)
			throws EmailException, LoginException, UserException {
		return new ResponseEntity<Email>(emailService.deleteEmail(mailId), HttpStatus.OK);
	}

}
