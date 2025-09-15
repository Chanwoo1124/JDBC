package com.newlecture.app.entity;

import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private String write_id;
	private String content;
	private Date refdate;
	private int hit;
	private String files;
	
	public Notice() {
		
	}



	public Notice(int id, String title, String write_id, String content, Date refdate, int hit, String files) {
		super();
		this.id = id;
		this.title = title;
		this.write_id = write_id;
		this.content = content;
		this.refdate = refdate;
		this.hit = hit;
		this.files = files;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWr_id() {
		return write_id;
	}
	public void setWr_id(String write_id) {
		this.write_id = write_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRefdate() {
		return refdate;
	}
	public void setRefdate(Date refdate) {
		this.refdate = refdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}
	
	
}
