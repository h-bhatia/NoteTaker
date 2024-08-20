package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends jakarta.servlet.http.HttpServlet {
	
     
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	@Override
	protected void doGet(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
			throws jakarta.servlet.ServletException, IOException {
	try
	{
		int noteId=Integer.parseInt(req.getParameter("note_id").trim());
		Session s=FactoryProvider.getFactory().openSession();
		Transaction tx=s.beginTransaction();
		//session kai pass delete ka option hai jo object lega
		Note note=(Note)s.get(Note.class, noteId);
		s.delete(note);
		// issai note ka object mill jayega
		tx.commit();
		s.close();
		resp.sendRedirect("all_notes.jsp");
	}
	catch(Exception e)
	{
		
	}
	}

}
