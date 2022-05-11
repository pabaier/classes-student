# CS Communication Helper

You have stumbled upon, or are grading, our CS Communication Helper Web App!
If you are grading - please be gentle :) 
This web app is being expertly developed by the capable minds of Paul Baier, Elaina Cole, Emily Coleman, Chase Platz, and Ahana Roy. Dr. Michael Verdicchio is overseeing the project as our professor for CSIS/CSCI 602: Introduction to Software Engineering as part of The College of Charleston and The Citadel's joint Masters Program.

We hope you enjoy the site!
(If you experience any issues, try deleting cookies...)

Link to heroku: https://cs-communication-helper.herokuapp.com/

Link to Pivotal Tracker: https://www.pivotaltracker.com/n/projects/2120073

### Steps to setup c9 to run tests for current release. 
Type the following:
```
git checkout iteration3
bundle install --without production
rake db:migrate db:test:prepare db:seed
rake cucumber
```

Commands for running the tests in c9:
```
rspec
cucumber
```

### Sample Bulk Import CSV
Steve,Jobs,sjo@apple.com,12345,Student,12/3/1988
Sam,Jobs,sjo@apple.com,12345,Student,12/3/1988
Shelly,Jobs,sjo@apple.com,12345,Student,12/3/1988

### Logging in
To login as an admin the email is : mverdicc@citadel.edu and password is: password1234
To login as a student the email is: sm@gmail.edu and password is: password1234
