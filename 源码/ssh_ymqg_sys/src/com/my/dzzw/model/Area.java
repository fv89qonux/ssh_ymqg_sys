package com.my.dzzw.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 新闻
 * @author 
 *
 */
@Entity
@Table(name="area")
@DynamicInsert
@DynamicUpdate
public class Area {
	
	private int id;
	private Integer price;//价格
	private Integer type;//类型
	private Integer state;
	private Integer useState;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getUseState() {
		return useState;
	}
	public void setUseState(Integer useState) {
		this.useState = useState;
	}


	

}
