package com.samuel.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.samuel.cursomc.domain.Cliente;
import com.samuel.cursomc.domain.Pedido;

public interface EmailService {

		void sendOrderConfirmationEmail(Pedido obj);
		
		void sendEmail(SimpleMailMessage msg);
		
		void sendNewPasswordEmail(Cliente cliente, String newPass);
	
}
