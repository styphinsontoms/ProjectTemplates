<?xml version="1.0" encoding="UTF-8"?>
<!--
  © Copyright 2009-2012 Piotr Soróbka <psorobka@gmail.com>.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<f:view>
    <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="eng">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
            <title><h:outputText value="#{msgs.sitename}"/></title>
        </head>
        <body>
            <div id="main">
                <div id="header">
                </div>
                <div id="content">
                    <h:form id="mainForm">
                        <h:panelGrid columns="1">
                            <h:outputText id="greeting" value="#{msgs.greeting} #{HelloController.name}!"/>                            
                        </h:panelGrid>
                        <h:commandButton value="#{msgs.back}" action="back"/>
                    </h:form>
                </div>
                <div id="footer">
                </div>
            </div>
        </body>
    </html>
</f:view>
