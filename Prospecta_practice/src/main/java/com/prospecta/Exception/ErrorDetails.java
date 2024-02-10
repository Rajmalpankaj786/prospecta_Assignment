package com.prospecta.Exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails {
	private LocalDateTime timeStamp;
	private String msg;
	private String details;
}
