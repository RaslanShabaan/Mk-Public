package com.arch.Dao;

import java.util.ArrayList;
import java.util.List;

import com.arch.Entities.*;

public interface CommentDao {

	public void InsertComment(Comment comment);
	public Comment SelectComment(int Id) ;
	public void DeleteComment(int Id) ;
	public void UpdateComment(Comment comment);
	
	public ArrayList<String> SelectCommentBy(String PostId) ;
	

	public List<Comment> AllComments();
	public ArrayList<String> AllPComment(int id,String Name);

}
