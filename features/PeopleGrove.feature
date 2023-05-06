Feature: career job message
@one
Scenario: check user able to receive the message
Given user clicks on career jobs
When send the message to another user
And another user login to their account
Then check the message received or not

@two
Scenario: choose carrer path for inspiring
Given Login to people grove
When go to career portal job
And choose the message to inspire
And and refresh the page
Then check the choosed message displayed or not
