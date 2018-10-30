install:
	javac -classpath .:/opt/ibm/ILOG/CPLEX_Studio1271/cplex/lib/cplex.jar Example.java
run:
	java -classpath .:/opt/ibm/ILOG/CPLEX_Studio1271/cplex/lib/cplex.jar -Djava.library.path=/opt/ibm/ILOG/CPLEX_Studio1271/cplex/bin/x86-64_linux Example
