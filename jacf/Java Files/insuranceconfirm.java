import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class insuranceconfirm extends HttpServlet {

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
        out.println("Your request was"+ request.getMethod()+"\\n");
        out.println("</body>");
        out.println("</html>");
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        Connection c=null;
        
        String name=request.getParameter("name");
        String age=request.getParameter("age");
        String sex=request.getParameter("sex");        
        String tm=request.getParameter("tm");
        String ticketno=request.getParameter("ticketno");
        String inamount=request.getParameter("inamount");        
        String cardno=request.getParameter("cardno");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String query =null;
        int tkno=Integer.parseInt(ticketno);
        int n=Integer.parseInt(tm);
   		try{
   			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            c= DriverManager.getConnection("jdbc:odbc:ITMNGMNT","grandtour","grandtour");
            Statement st =c.createStatement();
            int inrno=0;                     
                      
            ResultSet rs2=st.executeQuery("select * from insurance"); 
            if(rs2.next())
            {
                        
                        query = new String("select max(insuranceno) as rno from insurance"); 
                        ResultSet rs3= st.executeQuery("select max(insuranceno) as rno from insurance");
                        if(rs3.next())
                        inrno= rs3.getInt(1) + 1;
                        
            } 
            else
               inrno=5000;
            ResultSet rs=null;     
           if(n==1)                               
                  rs= st.executeQuery("select * from trainbooking where pnrno1 =("+tkno+")"); 
            else if(n==2) 
                  rs= st.executeQuery("select * from carbooking1 where reqno =("+tkno+")"); 
            else if(n==3)
                 rs= st.executeQuery("select * from flightbooking where reqno =("+tkno+")");
            else if(n==4)
                 rs= st.executeQuery("select * from cruisebooking where reqno =("+tkno+")");
            if(rs.next())
            {    
            query = new String("insert into insurance values('"+name+"','"+age+"','"+sex+"',"+tkno+",'"+inamount+"','"+cardno+"',"+inrno+")");           
                           
            st.executeUpdate(query);  

out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
out.println("<html>");
out.println("<head>");
out.println("<title>insuranceconfirm</title>");
out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">");
out.println("<SCRIPT>");
out.println("function doClear()");
out.println("{       ");
out.println("}");
out.println("function doSubmit()");
out.println("{");
out.println("var strErrMsg;         ");
out.println("strErrMsg = \"\";          ");
out.println("strErrMsg = doValidations();");
out.println("if (strErrMsg == \"\" )");
out.println("{                          ");
out.println("document.mainform.action = \"http://localhost:2008/examples/servlet/insurancebooking\"  ;                  ");
out.println("document.mainform.submit();");
out.println("}");
out.println("else");
out.println("{alert(strErrMsg);}");
out.println("}");
out.println("function doValidations()");
out.println("{         ");
out.println("var ddIndex;");
out.println("var strTemp;");
out.println("var strFld;");
out.println("var frmDoc;");
out.println("var strErrMsg;");
out.println("strErrMsg = \"\";");
out.println("frmDoc = document.mainform;            ");
out.println("strFld = frmDoc.loginid");
out.println("if (strFld.value == \"\")strErrMsg = strErrMsg + \"Please enter loginid\\n\";");
out.println("strFld = frmDoc.pswd");
out.println("if (strFld.value == \"\") strErrMsg = strErrMsg + \"Please enter password\\n\";                                             ");
out.println("return strErrMsg;");
out.println("}");
out.println("</SCRIPT>");
out.println("</head>");
out.println("<body bgcolor=\"#FFFFFF\">");
out.println("<FORM name=mainform method=post>");
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
out.println("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
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
out.println("<td width=\"21%\" height=\"20\" bgcolor=\"#0000CC\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/acc.htm\"><font color=\"#FFFFFF\" size=\"4\"> ");
out.println("Accommodation</font></a></div></td>");
out.println("<td width=\"24%\" bgcolor=\"#0000CC\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/travel.htm\"><font color=\"#FFFFFF\" size=\"4\"> ");
out.println("Traveling Means</font></a></div>");
out.println("<div align=\"center\"></div></td>");
out.println("<td width=\"25%\" bgcolor=\"#0000CC\"> ");
out.println("<div align=\"center\"><a href=\"http://localhost:2008/hcutravels/travelguide.htm\"><font color=\"#FFFFFF\" size=\"4\">Travel ");
out.println("Guide</font></a></div></td>");
out.println("<td width=\"30%\" bgcolor=\"#3333FF\"> ");
out.println("<div align=\"center\"><a href=\"http://localhost:2008/hcutravels/travelinsurance.htm\"><font color=\"#FFFFFF\" size=\"4\">Travel ");
out.println("Insurance</font></a></div></td>");
out.println("</tr>");
out.println("</table></td>");
out.println("</tr>");
out.println("</table>");
out.println("<p align=\"center\"><span class=\"style1\"><u><font color=\"#660033\" size=\"6\"><strong>Travel ");
out.println("Insurance </strong></font></u></span></p>");
out.println("<div align=\"center\"></div>");
out.println("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
out.println("<tr> ");
out.println("<td width=\"45%\" height=\"55\" bgcolor=\"#333333\">");
out.println("<div align=\"center\"><img src=\"http://localhost:2008/hcutravels/images/supersurpriceban.jpg\" width=\"356\" height=\"55\"> ");
out.println("</div></td>");
out.println("<td width=\"55%\" bgcolor=\"#FFCCFF\"> <p align=\"center\" onClick=\"javascript:doSubmit();\"><strong><font color=\"#660033\" size=\"5\">Insurance ");
out.println("Confirmation</font></strong></p></td>");
out.println("</tr>");
out.println("<tr> ");
out.println("<td height=\"264\"> ");
out.println("<table width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\">");
out.println("<tr> ");
out.println("<td width=\"46%\" height=\"262\"><img src=\"http://localhost:2008/hcutravels/images/Southern%20GP59.jpg\" width=\"167\" height=\"247\"></td>");
out.println("<td width=\"54%\"><table width=\"100%\" height=\"248\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\">");
out.println("<tr> ");
out.println("<td height=\"137\"><img src=\"http://localhost:2008/hcutravels/images/cruises-celebrity.jpg\" width=\"201\" height=\"157\"></td>");
out.println("</tr>");
out.println("<tr> ");
out.println("<td height=\"102\"> ");
out.println("<div align=\"center\"><img src=\"http://localhost:2008/hcutravels/images/vitara.jpg\" width=\"200\" height=\"100\"></div></td>");
out.println("</tr>");
out.println("</table></td>");
out.println("</tr>");
out.println("</table>");
out.println("</td>");
out.println("<td width=\"55%\" bgcolor=\"#FFCCFF\"><table width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\">");
out.println("<tr> ");
out.println("<td height=\"86\"> ");
out.println("<div align=\"center\"><font size=\"4\"><strong>Your Insurance ");
out.println("no. is "+inrno+"</strong></font></div></td>");
out.println("</tr>");
out.println("<tr> ");
out.println("<td height=\"72\">");
out.println("<div align=\"center\"><font color=\"#663300\" size=\"5\">Thanx ");
out.println("for using the sevice</font></div></td>");
out.println("</tr>");
out.println("<tr>");
out.println("<td height=\"100\"> ");
out.println("<div align=\"center\"><font size=\"4\"><a href=\"http://localhost:2008/hcutravels/home.htm\">Home</a></font></div></td>");
out.println("</tr>");
out.println("</table></td>");
out.println("</tr>");
out.println("</table>");
out.println("<HR align=center noShade>");
out.println("<p align=\"center\"><font size=\"4\" face=\"Arial\"><a href=\"http://localhost:2008/hcutravels/home.htm\">Home</a> | <a href=\"http://localhost:2008/hcutravels/services.htm\">Services</a></font></p>");
out.println("<HR align=center noShade>");
out.println("<p>&nbsp;</p>");
out.println("</body>");
out.println("</html>");
             
          
           }
            else
             {
            
out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
out.println("<html>");
out.println("<head>");
out.println("<title>invalireqno</title>");
out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">");
out.println("<SCRIPT>");
out.println("function doClear()");
out.println("{       ");
out.println("document.mainform.name.value = \"\";");
out.println("document.mainform.age.value = \"\";");
out.println("document.mainform.sex.value = \"\";");
out.println("document.mainform.ticketno.value = \"\";");
out.println("document.mainform.inamount.value = \"\";       ");
out.println("document.mainform.cardno.value = \"\";");
out.println("}");
out.println("function doSubmit()");
out.println("{");
out.println("var strErrMsg;         ");
out.println("strErrMsg = \"\";          ");
out.println("strErrMsg = doValidations();");
out.println("if (strErrMsg == \"\" )");
out.println("{                          ");
out.println("document.mainform.action =  \"http://localhost:2008/examples/servlet/insuranceconfirm\"  ;                     ");
out.println("document.mainform.submit();");
out.println("}");
out.println("else");
out.println("{alert(strErrMsg);}");
out.println("}");
out.println("function doValidations()");
out.println("{         ");
out.println("var ddIndex;");
out.println("var strTemp;");
out.println("var strFld;");
out.println("var frmDoc;");
out.println("var strErrMsg;");
out.println("strErrMsg = \"\";");
out.println("frmDoc = document.mainform;            ");
out.println("strFld = frmDoc.name");
out.println("if (strFld.value == \"\")strErrMsg = strErrMsg + \"Please enter the name\\n\";");
out.println("strFld = frmDoc.age");
out.println("if (strFld.value == \"\") strErrMsg = strErrMsg + \"Please enter age\\n\";");
out.println("strFld = frmDoc.ticketno");
out.println("if (strFld.value == \"\") strErrMsg = strErrMsg + \"Please enter ticket no/ Req. no.\\n\";");
out.println("strFld = frmDoc.inamount");
out.println("if (strFld.value == \"\") strErrMsg = strErrMsg + \"Please enter insurance amount\\n\";");
out.println("strFld = frmDoc.cardno");
out.println("if (strFld.value == \"\"|| strFld.value.length<4 || strFld.value.length >4 ) ");
out.println("strErrMsg = strErrMsg + \"Please enter credit card no\\n\"; ");
out.println("return strErrMsg;");
out.println("}");
out.println("</SCRIPT>");
out.println("</head>");
out.println("<body bgcolor=\"#FFFFFF\">");
out.println("<FORM name=mainform method=post>");
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
out.println("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
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
out.println("<td width=\"21%\" height=\"20\" bgcolor=\"#0000CC\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/acc.htm\"><font color=\"#FFFFFF\" size=\"4\"> ");
out.println("Accommodation</font></a></div></td>");
out.println("<td width=\"24%\" bgcolor=\"#0000CC\"> <div align=\"center\"><a href=\"http://localhost:2008/hcutravels/travel.htm\"><font color=\"#FFFFFF\" size=\"4\"> ");
out.println("Traveling Means</font></a></div>");
out.println("<div align=\"center\"></div></td>");
out.println("<td width=\"25%\" bgcolor=\"#0000CC\"> ");
out.println("<div align=\"center\"><a href=\"http://localhost:2008/hcutravels/travelguide.htm\"><font color=\"#FFFFFF\" size=\"4\">Travel ");
out.println("Guide</font></a></div></td>");
out.println("<td width=\"30%\" bgcolor=\"#3333FF\"> ");
out.println("<div align=\"center\"><a href=\"http://localhost:2008/hcutravels/travelinsurance.htm\"><font color=\"#FFFFFF\" size=\"4\">Travel ");
out.println("Insurance</font></a></div></td>");
out.println("</tr>");
out.println("</table></td>");
out.println("</tr>");
out.println("</table>");
out.println("<p align=\"center\"><span class=\"style1\"><u><font color=\"#660033\" size=\"6\"><strong>Travel ");
out.println("Insurance </strong></font><font color=\"#0000FF\" size=\"6\"></font></u></span></p>");
out.println("<div align=\"center\"></div>");
out.println("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
out.println("<tr> ");
out.println("<td width=\"45%\" height=\"55\" valign=\"top\" bgcolor=\"#333333\"><div align=\"center\"><img src=\"http://localhost:2008/hcutravels/images/supersurpriceban.jpg\" width=\"356\" height=\"55\"> ");
out.println("</div></td>");
out.println("<td width=\"55%\" rowspan=\"2\" valign=\"top\" bgcolor=\"#FFCCFF\"> ");
out.println("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bordercolor=\"#660033\" background=\"airfare_search_bg_big.gif\">");
out.println("<tr bgcolor=\"#FFCCFF\"> ");
out.println("<td colspan=\"2\"> <div align=\"center\"> ");
out.println("<p><em><strong><font color=\"#660000\" size=\"5\">Invalid Ticketno./reqno. ");
out.println("try again!!!</font></strong></em></p>");
out.println("</div></td>");
out.println("</tr>");
out.println("<tr> ");
out.println("<td width=\"71%\" bgcolor=\"#FFCCFF\"><font size=\"4\"> Enter Your Name</font></td>");
out.println("<td width=\"29%\" bgcolor=\"#FFCCFF\"> <INPUT name=\"name\" type=\"text\"class=if id=\"name\"  size=\"10\" maxlength=\"10\"> ");
out.println("</td>");
out.println("</tr>");
out.println("<tr> ");
out.println("<td height=\"20\" bgcolor=\"#FFCCFF\"><font size=\"4\">Age</font></td>");
out.println("<td bgcolor=\"#FFCCFF\"><B> ");
out.println("<input name=\"age\" type=\"text\" id=\"age\" size=\"2\">");
out.println("</B> </td>");
out.println("</tr>");
out.println("<tr> ");
out.println("<td bgcolor=\"#FFCCFF\"><font size=\"4\">Sex</font></td>");
out.println("<td bgcolor=\"#FFCCFF\"><B> ");
out.println("<select name=\"sex\" id=\"sex\">");
out.println("<option value=\"M\" selected>M</option>");
out.println("<option value=\"F\">F</option>");
out.println("</select>");
out.println("</B></td>");
out.println("</tr>");
out.println("<tr> ");
out.println("<td bgcolor=\"#FFCCFF\"><font size=\"4\">Travelling means</font></td>");
out.println("<td bgcolor=\"#FFCCFF\"><select name=\"tm\" id=\"tm\">");
out.println("<option value=\"1\">train</option>");
out.println("<option value=\"2\">flight</option>");
out.println("<option value=\"3\">car</option>");
out.println("<option value=\"4\">cruise</option>");
out.println("</select></td>");
out.println("</tr>");
out.println("<tr> ");
out.println("<td bgcolor=\"#FFCCFF\"><font size=\"4\">Ticket no./Req no.(First Three ");
out.println("Digits) </font></td>");
out.println("<td bgcolor=\"#FFCCFF\"><input name=\"ticketno\" type=\"text\" id=\"ticketno2\" size=\"10\"> ");
out.println("</td>");
out.println("</tr>");
out.println("<tr> ");
out.println("<td bgcolor=\"#FFCCFF\"><font size=\"4\">Insurance amount</font></td>");
out.println("<td bgcolor=\"#FFCCFF\"><input name=\"inamount\" type=\"text\" id=\"inamount2\" size=\"6\"> ");
out.println("</td>");
out.println("</tr>");
out.println("<tr> ");
out.println("<td bgcolor=\"#FFCCFF\"><font size=\"4\">Enter last four digits of your ");
out.println("Credit Card No.</font></td>");
out.println("<td bgcolor=\"#FFCCFF\"><input name=\"cardno\" type=\"text\" id=\"cardno2\" size=\"4\" maxlength=\"4\"> ");
out.println("</td>");
out.println("</tr>");
out.println("</table>");
out.println("<p align=\"center\" onClick=\"javascript:doSubmit();\"> ");
out.println("<object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0\" width=\"147\" height=\"34\">");
out.println("<param name=\"BGCOLOR\" value=\"#FFCCFF\">");
out.println("<param name=\"movie\" value=\"http://localhost:2008/hcutravels/images/getinsurance.swf\">");
out.println("<param name=\"quality\" value=\"high\">");
out.println("<embed src=\"http://localhost:2008/hcutravels/images/getinsurance.swf\" width=\"147\" height=\"34\" quality=\"high\" pluginspage=\"http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash\" type=\"application/x-shockwave-flash\" bgcolor=\"#FFCCFF\" ></embed> ");
out.println("</object>");
out.println("<object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0\" width=\"147\" height=\"34\">");
out.println("<param name=\"movie\" value=\"http://localhost:2008/hcutravels/images/inscleardata.swf\">");
out.println("<param name=\"quality\" value=\"high\">");
out.println("<param name=\"bgcolor\" value=\"#FFCCFF\">");
out.println("<embed src=\"http://localhost:2008/hcutravels/images/inscleardata.swf\" quality=\"high\" pluginspage=\"http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash\" type=\"application/x-shockwave-flash\" width=\"147\" height=\"34\" bgcolor=\"#FFCCFF\"></embed> ");
out.println("</object>");
out.println("</p></td>");
out.println("</tr>");
out.println("<tr>");
out.println("<td height=\"263\" valign=\"top\"> ");
out.println("<table width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\">");
out.println("<tr>");
out.println("<td width=\"46%\" height=\"261\"><img src=\"http://localhost:2008/hcutravels/images/Southern%20GP59.jpg\" width=\"172\" height=\"260\"></td>");
out.println("<td width=\"54%\"><table width=\"100%\" height=\"245\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\">");
out.println("<tr>");
out.println("<td height=\"141\"><img src=\"http://localhost:2008/hcutravels/images/cruises-celebrity.jpg\" width=\"201\" height=\"157\"></td>");
out.println("</tr>");
out.println("<tr>");
out.println("<td height=\"101\"> ");
out.println("<div align=\"center\"><img src=\"http://localhost:2008/hcutravels/images/vitara.jpg\" width=\"200\" height=\"100\"></div></td>");
out.println("</tr>");
out.println("</table></td>");
out.println("</tr>");
out.println("</table>");
out.println("</td>");
out.println("</tr>");
out.println("</table>");
out.println("<HR align=center noShade>");
out.println("<p align=\"center\"><font size=\"4\" face=\"Arial\"><a href=\"http://localhost:2008/hcutravels/home.htm\">Home</a> | <a href=\"http://localhost:2008/hcutravels/services.htm\">Services</a></font></p>");
out.println("<HR align=center noShade>");
out.println("<p>&nbsp;</p>");
out.println("</body>");
out.println("</html>");

    
             }
            
            
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



