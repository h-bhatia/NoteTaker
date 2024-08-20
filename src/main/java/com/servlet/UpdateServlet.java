package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
@Override
protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
		throws jakarta.servlet.ServletException, IOException {
	
	try
	{
		System.out.println("hello");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		System.out.println("hello1");
		int noteid=Integer.parseInt(req.getParameter("noteId").trim());
		Session s=FactoryProvider.getFactory().openSession();
		Transaction tx=s.beginTransaction();
		System.out.println("hello2");
		Note note=(Note)s.get(Note.class, noteid);
		// hame apne object ko presistent state mai lai jna tha . jaise hamne get kia vo presistent state mai chla gya
		System.out.println("hello3");
		note.setTitle(title);
		note.setContent(content);
		note.setAddedDate(new Date());
		System.out.println("hello4");
		System.out.println(note.getContent());
		System.out.println(note.getTitle());
		System.out.println(note.getAddedDate());
		System.out.println("hello5");
		
		tx.commit();
		s.close();
		resp.sendRedirect("all_notes.jsp");
	}
catch(Exception e)
{
	
}
}
}
