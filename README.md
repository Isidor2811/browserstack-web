# Browserstack (WEB) POC
In this project we use standard approach (not Browserstack SDK)

* First we need to get username and key after registration:
``` 
public static final String AUTOMATE_USERNAME = "bsuser_egrfsp";
public static final String AUTOMATE_ACCESS_KEY = "Z4Qf1PKGA9L7MUxY2bcr";
 ```
To run tests use following command:
```
mvn clean test -Dsuite=smoke -DbrowserName=Safari -DbrowserVersion=latest, -Dos='OS X' -DosVersion=Monterey
```

where,
`browserName` can be: `Chrome, Firefox, IE, Safari, Edge, Opera`

`browserVersion` can be: `latest, latest-1`, etc

`os` can be: `Windows, OS X`

`osVersion` can be: `XP, 10, 11, Catalina, Big Sur, Monterey, Ventura`, etc.

by default, tests will be run with following config:

```
 <browserName>Chrome</browserName>
 <browserVersion>latest</browserVersion>
 <os>Windows</os>
 <osVersion>10</osVersion>
```

## How new SKD is working?
BrowserStack SDK is a plug-and-play solution available in multiple programming languages, namely Java, NodeJS, Python, and C# that will enable you to run your entire test suite on the BrowserStack Cloud with no code changes. It reduces the integration time from hours to a few minutes.

To get started, you need to install the SDK and set up the configuration file. Your tests will automatically run on the BrowserStack cloud with no modifications to your existing test suite.

The BrowserStack SDK integrates into your existing test suite framework, intercepts your test scripts, and then modifies the execution during runtime to run tests on BrowserStack.

The capabilities defined in the SDK configuration override your existing Selenium/Appium webdriver URL and capabilities, i.e. your tests will run on the BrowserStack cloud irrespective of your webdriver URL being configured to your local grid. Since all capabilities are defined through the SDK configuration, changes to your test script are not required.

---
This is mean following:
If for example we have `WebDriver d = new ChromeDriver();`, we don't need to change something in our code
All we need just set up config file with necessary browsers, os (capabilities) and in run time SDK will change all necessary
properties to specific browser