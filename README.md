### loyalToPlant test

to run the test:
```
mvn test
```
It creates a .xml file in /target/site/allure-report
For creating report only on the current test-run:
```
mvn clean test
```

generation site with reports:
```
mvn allure:report
```

change settings and browsers:
```
src/test/res/parameters.properties
```