import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class flightbooking extends HttpServlet {

    public void init(ServletConfig config)
    	throws ServletException {
    		super.init(config);
    	}
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        out.println("Your request was"+ request.getMethod()+"\n");
        out.println("</body>");
        out.println("</html>");
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        Connection c=null;
        
        String loginid=request.getParameter("loginid");
        String source=request.getParameter("source");
        String destination=request.getParameter("destination");
        String sdd=request.getParameter("sdd");
        String smm=request.getParameter("smm");
        String syy=request.getParameter("syy");
        String not=request.getParameter("not");
        String clas=request.getParameter("class");
        String type=request.getParameter("type");
        String ddd=request.getParameter("ddd");
        String dmm=request.getParameter("dmm");
        String dyy=request.getParameter("dyy");
        String cardno=request.getParameter("cardno");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String query =null;
   		try{
   			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            c= DriverManager.getConnection("jdbc:odbc:ITMNGMNT","grandtour","grandtour");
            Statement st =c.createStatement();
            int reqno=0;
        //    query = new String("select * from flightbooking"); 
            ResultSet rs= st.executeQuery("select * from flightbooking");
                               
            if(rs.next())
            {
            			
            			query = new String("select max(reqno) as rno from flightbooking"); 
            			ResultSet rs2= st.executeQuery("select max(reqno) as rno from flightbooking");
            			if(rs2.next())
            			reqno= rs2.getInt(1) + 1;
            			
            }
            else
            	reqno =100;
            if(type.equals("RT"))
            	query = new String("insert into flightbooking values('"+loginid+"','"+source+"','"+destination+"','"+sdd+"','"+smm+"','"+syy+"','"+not+"','"+clas+"','"+type+"','"+ddd+"','"+dmm+"','"+dyy+"','"+cardno+"',"+reqno+")");
			else
				query = new String("insert into flightbooking values('"+loginid+"','"+source+"','"+destination+"','"+sdd+"','"+smm+"','"+syy+"','"+not+"','"+clas+"','"+type+"',null,null,null,'"+cardno+"',"+reqno+")");			
			st.executeUpdate(query);
			
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Untitled Document</title>");
			out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<div align=\"center\">");
			out.println("<center>");
			out.println("<div align=\"center\">");
			out.println("<center>");
			out.println("<TABLE cellSpacing=0 cellPadding=0 width=750 border=0 style=\"border-collapse: collapse\" bordercolor=\"#111111\">");
			out.println("<TBODY>");
			out.println("<TR> ");
			out.println("<TD class=header><img src=\"http://localhost:2008/hcutravels/images/frontpage.gif\" alt=\"\" width=\"386\" height=\"71\"><img src=\"http://localhost:2008/hcutravels/images/Hdr_AS_Seal.jpg\" width=\"289\" height=\"71\"> ");
			out.println("<img src=\"http://localhost:2008/hcutravels/images/1animated12-thumb%5B1%5D.gif\" width=\"67\" height=\"50\"> ");
			out.println("</TD>");
			out.println("</TR>");
			out.println("</TBODY>");
			out.println("</TABLE>");
			out.println("</center>");
			out.println("</div>");
			out.println("<p align=\"left\"><font face=\"arial\" size=\"2\"> ");
			out.println("<marquee behavior=\"scroll\" style=\"font-family: Courier New; color: #333300; text-decoration: blink; font-size: 18pt; font-style: italic; font-weight: bold\">");
			out.println("we share a visi<img src=\"http://localhost:2008/hcutravels/images/Animsun.gif\" width=\"50\" height=\"26\">n ");
			out.println("</marquee>");
			out.println("</font></p>");
			out.println("</center>");
			out.println("</div>");
			out.println("<table width=\"97%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
			out.println("<tr bordercolor=\"#CCCCCC\" bgcolor=\"#000099\"> ");
			out.println("<td width=\"10%\" bgcolor=\"#000099\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/home.htm\"><font color=\"#FFFFFF\" size=\"5\">Home</font></a></div></td>");
			out.println("<td width=\"14%\" bgcolor=\"#0000CC\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/services.htm\"><font color=\"#FFFFFF\" size=\"5\">Services</font></a></div></td>");
			out.println("<td width=\"25%\" bgcolor=\"#000099\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/packagefinal.htm\"><font color=\"#FFFFFF\" size=\"5\">Holiday ");
			out.println("Packages </font></a></div></td>");
			out.println("<td width=\"11%\" bgcolor=\"#000099\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/faq.htm\"><font color=\"#FFFFFF\" size=\"5\">FAQs</font></a></div></td>");
			out.println("<td width=\"25%\" bgcolor=\"#000099\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/register.htm\"><font color=\"#FFFFFF\" size=\"5\">Register ");
			out.println("Yourself</font></a></div></td>");
			out.println("<td width=\"15%\" bgcolor=\"#000099\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/aboutus.htm\"><font color=\"#FFFFFF\" size=\"5\">About ");
			out.println("Us</font></a></div></td>");
			out.println("</tr>");
			out.println("<tr> ");
			out.println("<td colspan=\"6\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
			out.println("<tr bgcolor=\"#0000CC\"> ");
			out.println("<td width=\"22%\" bgcolor=\"#0000CC\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/acc.htm\"><font color=\"#FFFFFF\" size=\"4\"> ");
			out.println("Accommodation</font></a></div></td>");
			out.println("<td width=\"21%\" bgcolor=\"#3333FF\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/travel.htm\"><font color=\"#FFFFFF\" size=\"4\"> ");
			out.println("Traveling Means</font></a></div>");
			out.println("<div align=\"center\"></div></td>");
			out.println("<td width=\"25%\" bgcolor=\"#0000CC\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/travelguide.htm\"><font color=\"#FFFFFF\" size=\"4\">Travel ");
			out.println("Guide</font></a></div></td>");
			out.println("<td width=\"32%\" bgcolor=\"#0000CC\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/travelinsurance.htm\"><font color=\"#FFFFFF\" size=\"4\">Travel ");
			out.println("Insurance</font></a></div></td>");
			out.println("</tr>");
			out.println("</table></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("<table width=\"97%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
			out.println("<tr bgcolor=\"#3333FF\"> ");
			out.println("<td bgcolor=\"#3333FF\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/car.htm\"><font color=\"#FFFFFF\" size=\"4\">By ");
			out.println("Car</font></a></div></td>");
			out.println("<td bgcolor=\"#3333FF\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/train.htm\"><font color=\"#FFFFFF\" size=\"4\">By ");
			out.println("Train</font></a></div></td>");
			out.println("<td bgcolor=\"#3399FF\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/flight.htm\"><font color=\"#FFFFFF\" size=\"4\">By ");
			out.println("Flight</font></a></div></td>");
			out.println("<td> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/cruise.htm\"><font color=\"#FFFFFF\" size=\"4\">By ");
			out.println("Cruises</font></a></div></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("<h1 align=\"center\"><font color=\"#660033\">Flights</font></h1>");
			out.println("<table width=\"733\" height=\"372\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
			out.println("<tr> ");
			out.println("<td height=\"130\" colspan=\"2\"><div align=\"center\"><img src=\"http://localhost:2008/hcutravels/images/h_air_01.gif\" width=\"511\" height=\"110\"><img src=\"http://localhost:2008/hcutravels/images/h_air_02.gif\" width=\"205\" height=\"110\"></div></td>");
			out.println("</tr>");
			out.println("<tr> ");
			out.println("<td width=\"145\" height=\"242\" valign=\"top\" bgcolor=\"#660000\"> <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
			out.println("<tr> ");
			out.println("<td bgcolor=\"#FFFFCC\"> <div align=\"center\"><strong><a href=\"http://localhost:2008/hcutravels/flightstatus.htm\">Flight ");
			out.println("Status</a></strong></div></td>");
			out.println("</tr>");
			out.println("<tr> ");
			out.println("<td bgcolor=\"#FFFFCC\"> <div align=\"center\"><strong><a href=\"http://localhost:2008/hcutravels/farecompare.htm\">Fare ");
			out.println("Compare</a></strong></div></td>");
			out.println("</tr>");
			out.println("<tr> ");
			out.println("<td bgcolor=\"#FFFFCC\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/passport.htm\"><strong>Passport ");
			out.println("Details</strong></a></div></td>");
			out.println("</tr>");
			out.println("<tr> ");
			out.println("<td bgcolor=\"#FFFFCC\"> <div align=\"center\"><strong><a href=\"http://localhost:2008/hcutravels/timetable.htm\">Time ");
			out.println("Table Search</a></strong></div></td>");
			out.println("</tr>");
			out.println("<tr> ");
			out.println("<td bgcolor=\"#FFCCFF\"> <div align=\"center\"><strong><a href=\"http://localhost:2008/hcutravels/flightlogin.htm\">Flight ");
			out.println("Booking </a></strong></div></td>");
			out.println("</tr>");
			out.println("<tr> ");
			out.println("<td bgcolor=\"#FFFFCC\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/airport.htm\"><strong>Airport ");
			out.println("Details</strong></a></div></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("<p align=\"center\"><img src=\"http://localhost:2008/hcutravels/images/108937881992.jpg\" width=\"125\" height=\"125\"></p></td>");
			out.println("<td width=\"588\"><table width=\"100%\" height=\"282\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" background=\"http://localhost:2008/hcutravels/airfare_search_bg_big.gif\">");
			out.println("<tr bgcolor=\"#FFCCFF\"> ");
			out.println("<td height=\"42\" colspan=\"2\"> <div align=\"center\"><font color=\"#660033\" size=\"5\">Online ");
			out.println("Flight Booking </font></div></td>");
			out.println("</tr>");
			out.println("<tr> ");
			out.println("<td width=\"70%\" height=\"240\" bgcolor=\"#FFCCFF\"> <div align=\"center\"> ");
			out.println("<table width=\"100%\" height=\"156\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
			out.println("<tr bgcolor=\"#FFCCFF\"> ");
			out.println("<td height=\"40\" colspan=\"2\"> <div align=\"center\"> ");
			out.println("<p><font color=\"#660033\" size=\"5\">Booking Confirmation</font></p>");
			out.println("</div></td>");
			out.println("</tr>");
			out.println("<tr> ");
			out.println("<td width=\"48%\" height=\"26\"> <div align=\"center\"><font size=\"4\"><strong>Your ");
			out.println("request no. is</strong></font></div></td>");
			out.println("<td width=\"52%\"><div align=\"center\"><font color=\"#660033\" size=\"5\"><strong>"+reqno+"</strong></font></div></td>");
			out.println("</tr>");
			out.println("<tr> ");
			out.println("<td height=\"35\" colspan=\"2\" bgcolor=\"#FFCCFF\"> <div align=\"center\"></div>");
			out.println("<div align=\"center\"><font size=\"4\">Your ticket booking details ");
			out.println("would be</font></div></td>");
			out.println("</tr>");
			out.println("<tr bgcolor=\"#FFCCFF\"> ");
			out.println("<td height=\"47\" colspan=\"2\"> <div align=\"center\"><font size=\"4\">sent ");
			out.println("to you within 3 days on your mail ID</font></div>");
			out.println("<div align=\"center\" ></div></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("<p><font color=\"#663300\" size=\"5\">Thanx for using the sevice</font></p>");
			out.println("<p>&nbsp;</p>");
			out.println("</div></td>");
			out.println("<td width=\"30%\"><img src=\"http://localhost:2008/hcutravels/images/flight.jpg\" width=\"181\" height=\"240\"></td>");
			out.println("</tr>");
			out.println("</table></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("<p align=\"center\">&nbsp;</p>");
			out.println("<hr size=1 width=\"70%\">");
			out.println("<p align=\"center\"><FONT face=\"Arial, Helvetica, sans-serif\" size=2><A ");
			out.println("href=\"http://localhost:2008/hcutravels/flightstatus.htm\">Flight Status </A> | <A ");
			out.println("href=\"http://localhost:2008/hcutravels/farecompare.htm\">Fare Compare</A> | <A ");
			out.println("href=\"http://localhost:2008/hcutravels/passport.htm\">Passport Details</A> | <A ");
			out.println("href=\"http://localhost:2008/hcutravels/timetable.htm\">Time Table Search</A> | <A ");
			out.println("href=\"http://localhost:2008/hcutravels/flightlogin.htm\">Flight Booking</A> | <A ");
			out.println("href=\"http://localhost:2008/hcutravels/airport.htm\">Airport Details</A></FONT></p>");
			out.println("<div align=\"center\"><FONT face=\"Arial, Helvetica, sans-serif\"><A ");
			out.println("href=\"http://localhost:2008/hcutravels/home.htm\"><FONT ");
			out.println("size=3>HOME</FONT></A></FONT> </div>");
			out.println("<hr size=1 width=\"70%\">");
			out.println("<p align=\"center\"><img src=\"http://localhost:2008/hcutravels/images/twisting_cranberry_wht.jpg\" width=\"300\" height=\"30\"></p>");
			out.println("</body>");
			out.println("</html>");

			

            
           }catch(Exception e){
            	out.println("Exception"+e.getMessage()+e.toString());
            }
            finally{
            	try{
            		if(c!=null)
            			c.close();
            	}catch(Exception e){
            		out.println("Exception closing the connection"+e.getMessage());
            	}
            }
   		}
   }
   
