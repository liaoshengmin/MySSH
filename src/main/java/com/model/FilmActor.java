package com.model;

import java.sql.Timestamp;



public class FilmActor implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FilmActorId id;
	private Timestamp lastUpdate;

	// Constructors

	/** default constructor */
	public FilmActor() {
	}

	/** full constructor */
	public FilmActor(FilmActorId id, Timestamp lastUpdate) {
		this.id = id;
		this.lastUpdate = lastUpdate;
	}

	// Property accessors

	public FilmActorId getId() {
		return this.id;
	}

	public void setId(FilmActorId id) {
		this.id = id;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}