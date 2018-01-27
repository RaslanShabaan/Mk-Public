package com.arch.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Post", catalog = "Advert")
public class Post {

	 private int Id;
	 private String Header;
	 private String Picture;
     private String Posts;

    
    public Post(){}
    public Post(int Id){this.Id= Id;}
    public Post(int Id, String Posts, String Header,String Picture){
    	this.Id= Id;
    	this.Posts=Posts;
    	this.Header=Header;
    	this.Picture=Picture;
    	
    }
    
	@Id
	@GeneratedValue
	@Column(name = "Id")
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	@Column(name = "Posts")
	public String getPosts() {
		return Posts;
	}
	public void setPosts(String posts) {
		Posts = posts;
	}

	@Column(name = "Header")
	public String getHeader() {
		return Header;
	}
	public void setHeader(String header) {
		Header = header;
	}
	
	@Column(name = "Picture")
	public String getPicture() {
		return Picture;
	}
	public void setPicture(String picture) {
		Picture = picture;
	}
	
}
