Feature: Login

Scenario: Succesfull login with valid Credentials
Given user launch chrome browser
When user opens url "http://admin-demo.nopcommerce.com/login"
And user enters emails as "admin@yourstore.com" and password as "admin"
And click on login 
Then Page title should be "Dashboard / nopcommerce administration"
When user click on log out link
Then Page title should be "Your store. Login"
And close browser