# Configure and Run
Using Maven you can run tests. In project root folder you can find "pom.xml" which describes build process.
Phases are basically aimed to: Collect dependent libraries, Set environment paths, Set environment variables, Compile source code, Run code with Maven testNG plugin called "Surefire Plugin"
>This framework use "yandex allure report" which save after running tests in "target" directory in "site" folder. Open index.html for see report.

>For running tests configure "Maven execute" for this command  "clean test allure:report"

> Also at the end of Maven build you will get "target" directory.