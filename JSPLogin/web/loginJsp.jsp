
        <jsp:useBean id="login" scope="request" class="pack1.LogBean" >
            <jsp:setProperty name="login" property="usrnm" value = '<%=request.getParameter("usrnm")%>'/>
            <jsp:setProperty name="login" property="pwd" value = '<%=request.getParameter("pwd")%>'/>
        </jsp:useBean>
        <jsp:forward page="adminCheck">
            <jsp:param name="usrnm" value="<%=login.getUsrnm()%>" />
            <jsp:param name="pwd" value="<%=login.getPwd()%>" />
        </jsp:forward>
        <%--<h1>Hello, <jsp:getProperty name="login" property="usrnm" />!</h1>--%>
    

