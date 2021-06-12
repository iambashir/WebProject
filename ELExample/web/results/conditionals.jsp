<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>Conditional Evaluation</TITLE>
<LINK REL=STYLESHEET
      HREF="./css/JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
  Conditional Evaluation
</TABLE>
<P>
<TABLE BORDER=1 ALIGN="CENTER">
  <TR><TH>
      <TH CLASS="COLORED">Apples
      <TH CLASS="COLORED">Oranges
  <TR><TH CLASS="COLORED">First Quarter
      <TD ALIGN="RIGHT">${apples.q1}
      <TD ALIGN="RIGHT">${oranges.q1}
  <TR><TH CLASS="COLORED">Second Quarter
      <TD ALIGN="RIGHT">${apples.q2}
      <TD ALIGN="RIGHT">${oranges.q2}
  <TR><TH CLASS="COLORED">Third Quarter
      <TD ALIGN="RIGHT">${apples.q3}
      <TD ALIGN="RIGHT">${oranges.q3}
  <TR><TH CLASS="COLORED">Fourth Quarter
      <TD ALIGN="RIGHT">${apples.q4}
      <TD ALIGN="RIGHT">${oranges.q4}
  <TR><TH CLASS="COLORED">Total
      <TD ALIGN="RIGHT"
          BGCOLOR="${(apples.total < 0) ? "RED" : "GREEN" }">
      ${apples.total}
      <TD ALIGN="RIGHT"
          BGCOLOR="${(oranges.total < 0) ? "RED" : "GREEN" }">
      ${oranges.total}
</TABLE>
</BODY></HTML>