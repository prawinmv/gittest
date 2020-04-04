$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("RestAPI.feature");
formatter.feature({
  "line": 1,
  "name": "Test CRUD methods in the Rest API",
  "description": "",
  "id": "test-crud-methods-in-the-rest-api",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Data Upload to a Web service",
  "description": "",
  "id": "test-crud-methods-in-the-rest-api;data-upload-to-a-web-service",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Set POST data service api endpoint",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User upload data on a project",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the server should handle it",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "return a success status",
  "keyword": "Then "
});
formatter.match({
  "location": "POST_Request.set_POST_data_service_api_endpoint()"
});
formatter.result({
  "duration": 1581904100,
  "status": "passed"
});
formatter.match({
  "location": "POST_Request.user_upload_data_on_a_project()"
});
formatter.result({
  "duration": 4279776500,
  "status": "passed"
});
formatter.match({
  "location": "POST_Request.the_server_should_handle_it()"
});
formatter.result({
  "duration": 14173000,
  "status": "passed"
});
formatter.match({
  "location": "POST_Request.return_a_post_response()"
});
formatter.result({
  "duration": 19981100,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Data update for an existing record",
  "description": "",
  "id": "test-crud-methods-in-the-rest-api;data-update-for-an-existing-record",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "Set PUT data service api endpoint",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "User updates existing record in a project",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "receives a valid status",
  "keyword": "Then "
});
formatter.match({
  "location": "PUT_Request.set_PUT_data_service_api_endpoint()"
});
formatter.result({
  "duration": 387200,
  "status": "passed"
});
formatter.match({
  "location": "PUT_Request.user_updates_existing_record_in_a_project()"
});
formatter.result({
  "duration": 84069400,
  "status": "passed"
});
formatter.match({
  "location": "PUT_Request.receives_a_put_response()"
});
formatter.result({
  "duration": 3145300,
  "error_message": "java.lang.AssertionError: expected [200] but found [404]\r\n\tat org.testng.Assert.fail(Assert.java:97)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:136)\r\n\tat org.testng.Assert.assertEquals(Assert.java:118)\r\n\tat org.testng.Assert.assertEquals(Assert.java:839)\r\n\tat org.testng.Assert.assertEquals(Assert.java:849)\r\n\tat stepDefinitions.PUT_Request.receives_a_put_response(PUT_Request.java:45)\r\n\tat ✽.Then receives a valid status(RestAPI.feature:13)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 15,
  "name": "Data retrieval from a Web service",
  "description": "",
  "id": "test-crud-methods-in-the-rest-api;data-retrieval-from-a-web-service",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "Set GET data service api endpoint",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "User want to get information on the project",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "the requested data is returned",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "user receives a success status",
  "keyword": "Then "
});
formatter.match({
  "location": "GET_Request.set_GET_data_service_api_endpoint()"
});
formatter.result({
  "duration": 389400,
  "status": "passed"
});
formatter.match({
  "location": "GET_Request.user_want_to_get_information_on_the_project()"
});
formatter.result({
  "duration": 29264600,
  "error_message": "java.net.UnknownHostException: restapi.demoqa.com\r\n\tat java.net.Inet6AddressImpl.lookupAllHostAddr(Native Method)\r\n\tat java.net.InetAddress$2.lookupAllHostAddr(InetAddress.java:929)\r\n\tat java.net.InetAddress.getAddressesFromNameService(InetAddress.java:1324)\r\n\tat java.net.InetAddress.getAllByName0(InetAddress.java:1277)\r\n\tat java.net.InetAddress.getAllByName(InetAddress.java:1193)\r\n\tat java.net.InetAddress.getAllByName(InetAddress.java:1127)\r\n\tat org.apache.http.impl.conn.SystemDefaultDnsResolver.resolve(SystemDefaultDnsResolver.java:45)\r\n\tat org.apache.http.impl.conn.DefaultClientConnectionOperator.resolveHostname(DefaultClientConnectionOperator.java:262)\r\n\tat org.apache.http.impl.conn.DefaultClientConnectionOperator.openConnection(DefaultClientConnectionOperator.java:161)\r\n\tat org.apache.http.impl.conn.ManagedClientConnectionImpl.open(ManagedClientConnectionImpl.java:328)\r\n\tat org.apache.http.impl.client.DefaultRequestDirector.tryConnect(DefaultRequestDirector.java:612)\r\n\tat org.apache.http.impl.client.DefaultRequestDirector.execute(DefaultRequestDirector.java:447)\r\n\tat org.apache.http.impl.client.AbstractHttpClient.doExecute(AbstractHttpClient.java:884)\r\n\tat org.apache.http.impl.client.CloseableHttpClient.execute(CloseableHttpClient.java:82)\r\n\tat org.apache.http.impl.client.CloseableHttpClient.execute(CloseableHttpClient.java:55)\r\n\tat org.apache.http.client.HttpClient$execute$0.call(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47)\r\n\tat org.apache.http.client.HttpClient$execute$0.call(Unknown Source)\r\n\tat io.restassured.internal.RequestSpecificationImpl$RestAssuredHttpBuilder.doRequest(RequestSpecificationImpl.groovy:2054)\r\n\tat io.restassured.internal.http.HTTPBuilder.doRequest(HTTPBuilder.java:494)\r\n\tat io.restassured.internal.http.HTTPBuilder.request(HTTPBuilder.java:451)\r\n\tat io.restassured.internal.http.HTTPBuilder$request$3.call(Unknown Source)\r\n\tat io.restassured.internal.RequestSpecificationImpl.sendHttpRequest(RequestSpecificationImpl.groovy:1450)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:101)\r\n\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:323)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1217)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1041)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:821)\r\n\tat io.restassured.internal.RequestSpecificationImpl.invokeMethod(RequestSpecificationImpl.groovy)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.call(PogoInterceptableSite.java:45)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.callCurrent(PogoInterceptableSite.java:55)\r\n\tat io.restassured.internal.RequestSpecificationImpl.sendRequest(RequestSpecificationImpl.groovy:1199)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:101)\r\n\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:323)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1217)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1041)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:821)\r\n\tat io.restassured.internal.RequestSpecificationImpl.invokeMethod(RequestSpecificationImpl.groovy)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.call(PogoInterceptableSite.java:45)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:151)\r\n\tat io.restassured.internal.filter.SendRequestFilter.filter(SendRequestFilter.groovy:30)\r\n\tat io.restassured.filter.Filter$filter$0.call(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47)\r\n\tat io.restassured.filter.Filter$filter.call(Unknown Source)\r\n\tat io.restassured.internal.filter.FilterContextImpl.next(FilterContextImpl.groovy:72)\r\n\tat io.restassured.filter.time.TimingFilter.filter(TimingFilter.java:56)\r\n\tat io.restassured.filter.Filter$filter.call(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47)\r\n\tat io.restassured.filter.Filter$filter$0.call(Unknown Source)\r\n\tat io.restassured.internal.filter.FilterContextImpl.next(FilterContextImpl.groovy:72)\r\n\tat io.restassured.filter.FilterContext$next.call(Unknown Source)\r\n\tat io.restassured.internal.RequestSpecificationImpl.applyPathParamsAndSendRequest(RequestSpecificationImpl.groovy:1654)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:101)\r\n\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:323)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1217)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1041)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:821)\r\n\tat io.restassured.internal.RequestSpecificationImpl.invokeMethod(RequestSpecificationImpl.groovy)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.call(PogoInterceptableSite.java:45)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.callCurrent(PogoInterceptableSite.java:55)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:184)\r\n\tat io.restassured.internal.RequestSpecificationImpl.request(RequestSpecificationImpl.groovy:295)\r\n\tat io.restassured.internal.RequestSpecificationImpl.request(RequestSpecificationImpl.groovy)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:101)\r\n\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:323)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1217)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1041)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:821)\r\n\tat io.restassured.internal.RequestSpecificationImpl.invokeMethod(RequestSpecificationImpl.groovy)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.call(PogoInterceptableSite.java:45)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoInterceptableSite.callCurrent(PogoInterceptableSite.java:55)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:184)\r\n\tat io.restassured.internal.RequestSpecificationImpl.request(RequestSpecificationImpl.groovy:291)\r\n\tat io.restassured.internal.RequestSpecificationImpl.request(RequestSpecificationImpl.groovy)\r\n\tat stepDefinitions.GET_Request.user_want_to_get_information_on_the_project(GET_Request.java:31)\r\n\tat ✽.When User want to get information on the project(RestAPI.feature:17)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "GET_Request.the_requested_data_is_returned()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "GET_Request.receives_a_get_response()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 21,
  "name": "Delete an existing record",
  "description": "",
  "id": "test-crud-methods-in-the-rest-api;delete-an-existing-record",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "Set DELETE data service api endpoint",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "User deletes an existing record in a project",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "receives a delete status",
  "keyword": "Then "
});
formatter.match({
  "location": "DELETE_Request.set_DELETE_data_service_api_endpoint()"
});
formatter.result({
  "duration": 643900,
  "status": "passed"
});
formatter.match({
  "location": "DELETE_Request.user_deletes_an_existing_record_in_a_project()"
});
formatter.result({
  "duration": 59826300,
  "status": "passed"
});
formatter.match({
  "location": "DELETE_Request.receives_a_delete_response()"
});
formatter.result({
  "duration": 173400,
  "status": "passed"
});
});