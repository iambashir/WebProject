<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
    <HEAD><TITLE>Using Implicit Objects</TITLE>
        <LINK REL=STYLESHEET
              HREF="./css/JSP-Styles.css"
              TYPE="text/css">
    </HEAD>
    <BODY>
        <TABLE BORDER=5 ALIGN="CENTER">
            <TR><TH CLASS="TITLE">
                    Using Implicit Objects
        </TABLE>
        <P>
        <UL>
            <LI><B>test Request Parameter:</B> ${param.test}
            <LI><B>User-Agent Header:</B> ${header["User-Agent"]}
            <LI><B>JSESSIONID Cookie Value:</B> ${cookie.JSESSIONID.value}
            <LI><B>Server:</B> ${pageContext.servletContext.serverInfo}
        </UL>
    </BODY></HTML>