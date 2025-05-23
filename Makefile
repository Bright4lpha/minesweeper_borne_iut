all : 
	javac *.java

main :
	javac *.java
	java App

clean :
	rm -rf *.class