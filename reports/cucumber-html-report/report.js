$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("terms.feature");
formatter.feature({
  "line": 2,
  "name": "Login Feature",
  "description": "I want to use this template for my feature file",
  "id": "login-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@login"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Validate the UserName and Password",
  "description": "",
  "id": "login-feature;validate-the-username-and-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I have a prescription Application",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I enter the correct UserName and Password",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I should be able to see the HomePage",
  "keyword": "Then "
});
formatter.match({
  "location": "DataVariableTest.i_have_a_prescription_Application()"
});
formatter.result({
  "duration": 257089730,
  "status": "passed"
});
formatter.match({
  "location": "DataVariableTest.i_enter_the_correct_UserName_and_Password()"
});
formatter.result({
  "duration": 20134689971,
  "error_message": "java.lang.AssertionError: 1 expectation failed.\nExpected status code \u003c200\u003e doesn\u0027t match actual status code \u003c401\u003e.\n\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.invoke(CachedConstructor.java:80)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.doConstructorInvoke(CachedConstructor.java:74)\r\n\tat org.codehaus.groovy.runtime.callsite.ConstructorSite$ConstructorSiteNoUnwrap.callConstructor(ConstructorSite.java:84)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallConstructor(CallSiteArray.java:60)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:235)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:247)\r\n\tat com.jayway.restassured.internal.ResponseSpecificationImpl$HamcrestAssertionClosure.validate(ResponseSpecificationImpl.groovy:573)\r\n\tat com.jayway.restassured.internal.ResponseSpecificationImpl$HamcrestAssertionClosure$validate$1.call(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:48)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:113)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:125)\r\n\tat com.jayway.restassured.internal.ResponseSpecificationImpl.validateResponseIfRequired(ResponseSpecificationImpl.groovy:727)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoMetaMethodSite$PogoCachedMethodSiteNoUnwrapNoCoerce.invoke(PogoMetaMethodSite.java:210)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoMetaMethodSite.callCurrent(PogoMetaMethodSite.java:59)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallCurrent(CallSiteArray.java:52)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:154)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:166)\r\n\tat com.jayway.restassured.internal.ResponseSpecificationImpl.statusCode(ResponseSpecificationImpl.groovy:106)\r\n\tat com.jayway.restassured.specification.ResponseSpecification$statusCode$0.callCurrent(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallCurrent(CallSiteArray.java:52)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:154)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:166)\r\n\tat com.jayway.restassured.internal.ResponseSpecificationImpl.statusCode(ResponseSpecificationImpl.groovy:114)\r\n\tat com.jayway.restassured.internal.ValidatableResponseOptionsImpl.statusCode(ValidatableResponseOptionsImpl.java:114)\r\n\tat ApplicationDataTest.DataVariableTest.i_enter_the_correct_UserName_and_Password(DataVariableTest.java:95)\r\n\tat ✽.When I enter the correct UserName and Password(terms.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "DataVariableTest.i_should_be_able_to_see_the_HomePage()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 10,
  "name": "Validate the Login Functionality",
  "description": "",
  "id": "login-feature;validate-the-login-functionality",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "I enter an invalid userName and Password",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "i initiate the tool",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I should be able to guide the tool",
  "keyword": "Then "
});
formatter.match({
  "location": "DataVariableTest.i_enter_an_invalid_userName_and_Password()"
});
formatter.result({
  "duration": 46915,
  "status": "passed"
});
formatter.match({
  "location": "DataVariableTest.i_initiate_the_tool()"
});
formatter.result({
  "duration": 23971,
  "status": "passed"
});
formatter.match({
  "location": "DataVariableTest.i_should_be_able_to_guide_the_tool()"
});
formatter.result({
  "duration": 24655,
  "status": "passed"
});
});