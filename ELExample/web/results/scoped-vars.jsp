<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>Accessing Scoped Variables</TITLE>
<LINK REL=STYLESHEET
      HREF="./css/JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
  Accessing Scoped Variables
</TABLE>
<P>
<UL>
    <LI><B>attribute1:</B> ${attribute1}<%=request.getAttribute("attribute1")%>
          
  <LI><B>attribute2:</B> ${attribute2}
  <LI><B>attribute3:</B> ${attribute3}
  <LI><B>Source of "repeated" attribute:</B> ${repeated}
</UL>
</BODY></HTML>