package com.Student_Management.model;

	import jakarta.persistence.*;

	@Entity
	public class Student {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String name;
	    private int percentage;

	    // GETTERS & SETTERS

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getPercentage() {
	        return percentage;
	    }

	    public void setPercentage(int percentage) {   // ✅ THIS MUST EXIST
	        this.percentage = percentage;
	    }
	}


