/*
 *  © Copyright 2009-2012 Piotr Soróbka <psorobka@gmail.com>.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.shaninfo.exampleJar;

import javax.ejb.EJB;

/**
 *
 * @author Piotr Soróbka <psorobka@gmail.com>
 */
public class HelloController {

    @EJB
    private HelloLocal helloService;
    //properties
    private String name;
    private String greeting;

    /**
     * default empty constructor
     */
    public HelloController() {
    }

    //-------------------getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    //-------------------actions
    public String sendAction() {
        greeting = helloService.sayHello();
        return "success";
    }
}