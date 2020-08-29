# <div id= "Description"></div> WebApplication for generall Administration
![GitHub stars](https://img.shields.io/github/stars/SantiRey/AdministrationWildfly?style=social) ![GitHub commits since latest release (by SemVer)](https://img.shields.io/github/commits-since/SantiRey/AdministrationWildfly/V1.0/master) ![GitHub top language](https://img.shields.io/github/languages/top/SantiRey/AdministrationWildfly) [![Generic badge](https://img.shields.io/badge/server-Wildfly-<COLOR>.svg)](https://shields.io/)

![](https://i.imgur.com/9nTBKjK.gif)

This is an application developed in Java, with a server in Wildfly. This application is intended to create users and sales branches as well as products and the administration of products and users.

## <div id= "Content"></div> 2 Content 
1. [Description](#Description)
2. [Content](#Content)
4. [Installation](#installation)
6. [How to use](#howu)
7. [How contributing](#howc)
8. [Technologies used](#Technologies_used)
9. [Licens](#licens)

## <div id= "Installation"></div> 3 Installation
You can find Wildfly a the following link: [wildfly server](https://www.wildfly.org)<br/>
**from the IDE**
1) Donwload wildfly Server
2) Give wildfly libexec path in the Deploy/Run configuration
3) Build the AdministrationWildfly war

**from Wildfly**
1) clone the repository
2) go to the local repository use mvn install
3) the folder Target should be created with the War file
4) Donwload wildfly Server
5) execute in the bin folder the add-user script
6) follow the requiriment to add a User
7) execute standalone script from the bin Folder
8) go to the port of wildfly configuration default 9990
9) deploy the war File from the Target Folder in the step 3.
## <div id= "howu"></div> 4 How to use
### login page: 
user: paula; password: pruebe.

## <div id= "howc"></div> 5 How contributing
All suggestions, changes and comments are very welcome and also highly valued. 
you can fork the repository, after that make a pull request and i will be read the propoues and answer if there something no clear to me. after that it will be merged.
## <div id= "Technologies_used"></div> 6 Technologies used
***Server***: Wildfly Server <br/>
***Dependencies Managment***: Maven <br/>
***Database***: H2 <br/>
***Lenguaje***: Java EE
## <div id= "licens"></div> 7 Licens
The code is open to anyone who wants to modify or contribute.





