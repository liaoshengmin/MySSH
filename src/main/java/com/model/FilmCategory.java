package com.model;

import java.sql.Timestamp;



public class FilmCategory implements java.io.Serializable {

	// Fields

	private FilmCategoryId id;
	private Timestamp lastUpdate;

	// Constructors

	/** default constructor */
	public FilmCategory() {
	}

	/** full constructor */
	public FilmCategory(FilmCategoryId id, Timestamp lastUpdate) {
		this.id = id;
		this.lastUpdate = lastUpdate;
	}

	// Property accessors

	public FilmCategoryId getId() {
		return this.id;
	}

	public void setId(FilmCategoryId id) {
		this.id = id;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}