package com.speedbook.model;

/**
 * Loganderror entity. @author MyEclipse Persistence Tools
 */

public class Loganderror implements java.io.Serializable {

	// Fields

	private Integer id;
	private String log;
	private String error;

	// Constructors

	/** default constructor */
	public Loganderror() {
	}

	/** minimal constructor */
	public Loganderror(String error) {
		this.error = error;
	}

	/** full constructor */
	public Loganderror(String log, String error) {
		this.log = log;
		this.error = error;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}