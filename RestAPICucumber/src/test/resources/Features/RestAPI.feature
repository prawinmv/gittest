Feature: Test CRUD methods in the Rest API 

Scenario: Data Upload to a Web service
Given Set POST data service api endpoint
When User upload data on a project
Then the server should handle it 
Then return a success status


Scenario: Data update for an existing record
Given Set PUT data service api endpoint
When User updates existing record in a project
Then receives a valid status

Scenario: Data retrieval from a Web service
Given Set GET data service api endpoint
When User want to get information on the project
Then the requested data is returned
Then user receives a success status

Scenario: Delete an existing record
Given Set DELETE data service api endpoint
When User deletes an existing record in a project
Then receives a delete status
 	

