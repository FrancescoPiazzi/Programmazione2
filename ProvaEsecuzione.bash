#!/bin/bash

openjfxPath=/home/francesco/.m2/repository/org/openjfx

classpath=$openjfxPath/javafx-controls/11.0.2/javafx-controls-11.0.2.jar:$openjfxPath/javafx-graphics/11.0.2/javafx-graphics-11.0.2.jar:$openjfxPath/javafx-base/11.0.2/javafx-base-11.0.2.jar:$openjfxPath/javafx-fxml/11.0.2/javafx-fxml-11.0.2.jar

myclass=/home/francesco/Programmazione2/$1

p=$myclass:$openjfxPath/javafx-fxml/11.0.2/javafx-fxml-11.0.2-linux.jar:$openjfxPath/javafx-controls/11.0.2/javafx-controls-11.0.2-linux.jar:$openjfxPath/javafx-graphics/11.0.2/javafx-graphics-11.0.2-linux.jar:$openjfxPath/javafx-base/11.0.2/javafx-base-11.0.2-linux.jar


java -classpath $classpath -p $p -m $2
