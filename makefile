default: ; @echo "Compiling..." ; javac -cp Doodle.jar *.java


run: default ; java -cp "Doodle.jar:." Doodle

clean: ; rm -f *.class
