package com.speedbook.model;

/**
 * Loganderror entity. @author MyEclipse Persistence Tools
 */

public class Loganderror implements java.io.Serializable {

	// Fields

	private Integer id;
	private String type;
	private String log;
	private String error;
	private String date;

	// Constructors

	/** default constructor */
	public Loganderror() {
	}

	/** full constructor */
	public Loganderror(String type, String log, String error, String date) {
		this.type = type;
		this.log = log;
		this.error = error;
		this.date = date;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLog() {
		return this.log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}