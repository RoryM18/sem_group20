CHARACTERISTIC INFORMATION

Goal in Context: Show a sorted list of capital cities by largest population to smallest.

Scope: Organisation

Level: Primary Task

Preconditions: Database has all capital cities names and their population number

Success End Condition: User gets the sorted list of capital cities correctly

Failed End Condition: User doesnt gets any output, or the list showed is incorrect

Primary Actor: User from the organization

Trigger: Show capital cities table request comes in

----------------------------------------

MAIN SUCCESS SCENARIO

1.User request a list of cities to our system

2.User decides the scope of the cities being compared

3.The system shows the sorted list of countries to the user

----------------------

EXTENSIONS

<User chooses the scope of the world>

<2a> <condition> : <Use the propper SQL statement>

<User chooses the scope of a continent>

<2b> <condition> : <Use the propper SQL statement>

<User chooses the scope of a region>

<2c> <condition> : <Use the propper  SQL statement>

<step altered> <condition> : <action or sub.use case>

--------------------

SUB-VARIATIONS

User may choose the scope of

<2> <continent, region, country>

----------------------------

OPEN ISSUES (optional)



---------------------------

SCHEDULE

Due Date: 04/03/2022


