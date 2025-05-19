all : 
	javac *.java

main :
	javac App.java
	java App

clean :
	rm -rf *.class