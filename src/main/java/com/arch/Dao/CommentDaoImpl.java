
package com.arch.Dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.arch.Entities.Comment;
import com.arch.Entities.Post;
import com.arch.Entities.Register;


@Transactional
@Component
public class CommentDaoImpl implements CommentDao{

	public List<Comment> vv;
    public  ArrayList<String> x;
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public void InsertComment(Comment comment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(comment);
        transaction.commit();
        session.flush(); //address will not get saved without this

	}

	@Override
	public Comment SelectComment(int Id) {
 
		Session session = sessionFactory.openSession();
         Transaction transaction = session.beginTransaction();
         Comment comment= (Comment) session.createCriteria(Comment.class).add(Restrictions.eq("id", Id)).uniqueResult();
         transaction.commit();
         session.flush(); //address will not get saved without this
         return comment;

	}

	@Override
	public void DeleteComment(int Id) {
	      Session session = sessionFactory.openSession();
	      Transaction transaction = session.beginTransaction();
	      Comment t =new Comment();
	      t=(Comment)session.get(Comment.class,Id);
	      session.delete(t);
	      session.flush(); //address will not get saved without this

	}

	@Override
	public void UpdateComment(Comment comment) {
		
	    Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(comment);
        transaction.commit();

        session.flush(); //address will not get saved without this
		
	}

	@Override
	public List<Comment> AllComments() {
	vv=new ArrayList<Comment>();

    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
   
   vv= session.createCriteria(Post.class).list();
    transaction.commit();
    session.flush(); //address will not get saved without this

		return vv;
	}
	
	@Override
	public ArrayList<String> AllPComment(int id,String Name) {
		 ArrayList<String> search =new ArrayList<String>();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
   
   Query x= session.createQuery("from Post where Id=? AND Name=? ");
   x.setInteger(0,id);
   x.setString(1,Name);

   List<Post> l =x.list();
   for(Post z:l)
   {
       search.add(z.getPosts());
   }
    transaction.commit();
    session.flush(); //address will not get saved without this
		return search;
	}

	@Override
	public  ArrayList<String> SelectCommentBy(String PostId) {
		
			 ArrayList<String> search =new ArrayList<String>();
	    Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();
	   Query x= session.createQuery("from Comment where  PId=? ");
	   x.setString(0,PostId);
	   

	   List<Comment> l =x.list();
	   for(Comment z:l)
	   {
	       search.add(z.getUser());
	       search.add(z.getComment());
	       
	   }
	    transaction.commit();
	    session.flush(); //address will not get saved without this
			return search;

	}
}