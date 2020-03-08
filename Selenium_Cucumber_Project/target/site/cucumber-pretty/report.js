$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "id": "open-vodafone-homepage",
  "description": "As an unprivileged user\r\nOpen the home page and login with invalid credentials",
  "name": "Open Vodafone Homepage",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "open-vodafone-homepage;go-to-vodafone-website",
  "description": "",
  "name": "Go to Vodafone website",
  "keyword": "Scenario",
  "line": 5,
  "type": "scenario"
});
formatter.step({
  "name": "the user opens a browser and go to \"http://www.vodafone.co.nz\"",
  "keyword": "Given ",
  "line": 6
});
formatter.step({
  "name": "user clicks on My Vodafone tab",
  "keyword": "When ",
  "line": 7
});
formatter.step({
  "name": "user clicks on Login button",
  "keyword": "And ",
  "line": 8
});
formatter.step({
  "name": "user enters invalid username \"medelvecina\"",
  "keyword": "And ",
  "line": 9
});
formatter.step({
  "name": "user enters invalid password \"password\"",
  "keyword": "And ",
  "line": 10
});
formatter.step({
  "name": "user clicks Sign in button",
  "keyword": "And ",
  "line": 11
});
formatter.step({
  "name": "user should NOT be able to login successfully",
  "keyword": "Then ",
  "line": 12
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.vodafone.co.nz",
      "offset": 36
    }
  ],
  "location": "StepDefinition.the_user_opens_a_browser_and_go_to(String)"
});
formatter.result({
  "duration": 29967599927,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_clicks_on_My_Vodafone_tab()"
});
formatter.result({
  "duration": 94291583455,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_clicks_on_Login_button()"
});
formatter.result({
  "duration": 20564620240,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "medelvecina",
      "offset": 30
    }
  ],
  "location": "StepDefinition.user_enters_invalid_username(String)"
});
formatter.result({
  "duration": 31397459334,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "password",
      "offset": 30
    }
  ],
  "location": "StepDefinition.user_enters_invalid_password(String)"
});
formatter.result({
  "duration": 127158274,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_clicks_Sign_in_button()"
});
formatter.result({
  "duration": 2852345969,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_should_NOT_be_able_to_login_successfully()"
});
formatter.result({
  "duration": 2042272593,
  "status": "passed"
});
});