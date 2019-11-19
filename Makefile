#OG Makefile Script for all java Files 


Main: *.java
	@javac *.java

edit:
	@vim Main.java

clean:
	@rm *.class

run:
	@java Main

default: 
	@cp ~/Desktop/Java/Main.java pwd ; mv pwd Main.java
