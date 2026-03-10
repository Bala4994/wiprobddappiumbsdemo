To run android -copy app id inside browserstackandr.yml to browserstack.yml and update userkey,accesskey 

To run ios -copy app id inside browserstackios.yml to browserstack.yml and update userkey,accesskey

then open local project folder and run below command

mvn test -Pandroidtest - > for android
mvn test -Piostest     - > for ios
