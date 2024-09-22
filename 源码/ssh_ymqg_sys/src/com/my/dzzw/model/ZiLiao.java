package com.my.dzzw.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Entity
@Table(name="zi_liao")
@DynamicInsert
@DynamicUpdate
public class ZiLiao {
	private int id;
	private String url2;
	private String title;
	private Date addTime;
	private int type ;//1轮播图 2 普通资料
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl2() {
		return url2;
	}
	public void setUrl2(String url) {
		this.url2 = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

}
