$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "TNEB Login Page application",
  "description": "",
  "id": "tneb-login-page-application",
  "keyword": "Feature"
});
formatter.before({
  "duration": 15598772700,
  "status": "passed"
});
formatter.scenario({
  "line": 2,
  "name": "Check Login functionality with valid credentials",
  "description": "",
  "id": "tneb-login-page-application;check-login-functionality-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Navigate to TNEB Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User enters username and password",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "User redirected to Home Page",
  "keyword": "Then "
});
formatter.match({
  "location": "TNEBLogin.navigate_to_tneb_login_page()"
});
formatter.result({
  "duration": 8318353600,
  "status": "passed"
});
formatter.match({
  "location": "TNEBLogin.user_enters_username_and_password()"
});
formatter.result({
  "duration": 553202500,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"css selector\",\"selector\":\"*[name\u003d\u0027u_0_b\u0027]\"}\n  (Session info: chrome\u003d80.0.3987.149)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027LAPTOP-04MOMSC6\u0027, ip: \u0027192.168.1.10\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_201\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 80.0.3987.149, chrome: {chromedriverVersion: 79.0.3945.36 (3582db32b3389..., userDataDir: C:\\Users\\prawi\\AppData\\Loca...}, goog:chromeOptions: {debuggerAddress: localhost:49889}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 933a1185745d474327f676897da16127\n*** Element info: {Using\u003dname, value\u003du_0_b}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByName(RemoteWebDriver.java:404)\r\n\tat org.openqa.selenium.By$ByName.findElement(By.java:284)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat stepDefinitions.TNEBLogin.user_enters_username_and_password(TNEBLogin.java:44)\r\n\tat ✽.Then User enters username and password(Login.feature:5)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "TNEBLogin.user_redirected_to_home_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 826724800,
  "status": "passed"
});
});