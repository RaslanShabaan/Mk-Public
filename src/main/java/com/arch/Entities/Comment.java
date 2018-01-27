package com.arch.Entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Comment", catalog = "Advert")
public class Comment {
	

		private int Id;
	    private String Comment;
	    private String User;
	    private String PId;
	    
	    
	    public Comment(){}
	    public Comment(int Id){this.Id= Id;}
	    public Comment(int Id, String PId,String Comment,String User){
	    	this.Id= Id;
	    	this.PId=PId;
	    	this.Comment=Comment;
	    	this.User= User;
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
		@Column(name = "Comment")
	    public String getComment() {
			return Comment;
		}
		public void setComment(String comment) {
			Comment = comment;
		}
		
		@Column(name = "User")
	    public String getUser() {
			return User;
		}
		public void setUser(String user) {
			User = user;
		}

		@Column(name = "PId")
		 public String getPId() {
				return PId;
			}
			public void setPId(String pId) {
				PId = pId;
			}
			
}
