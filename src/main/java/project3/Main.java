package project3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/main")

public class Main extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
        String output;
        try {
        	output = new Operator(json).doAll();
        }catch (Exception e) {
        	output="{\"message\" : \"malformed json\"}";
        }
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        if (output==null) {
        	output="{\"message\" : \"malformed json\"}";
        }
        out.println(output); 
        
	}
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		        response.setContentType("application/json");
		        PrintWriter out = response.getWriter();
		        out.println("{ \"message\" : \"Use POST!\"}");
	 }
}
