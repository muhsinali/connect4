Introduction [![Build Status](https://travis-ci.org/muhsinali/connect4.svg?branch=master)](https://travis-ci.org/muhsinali/connect4)
=================================
![alt tag](public/images/connect4.png)

### [Try out project here](http://connect4.muhsinali.xyz)

This is a simple implementation of the Connect 4 game. 


### Key features:
- Game was implemented in a [TDD fashion](https://github.com/muhsinali/connect4/blob/master/test/models/GridSpec.scala)
- Used GitFlow and created a continuous deployment pipeline using [Travis](https://travis-ci.org/muhsinali/connect4) and Heroku
- Added a [GZip compression filter](https://github.com/muhsinali/connect4/blob/master/app/Filters.scala) to compress server responses


### Tech stack
- Scala 2.11.8
- Play framework (version 2.5.12)
- HTML, CSS, Bootstrap 3, [Twirl template engine](https://www.playframework.com/documentation/2.5.x/ScalaTemplates)


### How to run the web app
To run the web app locally, start the MongoDB database using `mongod` and then go to the root directory of this project and run `activator run`. Once ready, go to [http://localhost:9000](http://localhost:9000) (if running for the first time, will need to wait a bit for the source code to compile).
