@echo off
echo Compiling Java files...
javac -d bin src\eu\deic\api\*.java

echo Running Benchmark...
java -cp bin eu.deic.api.Parallel1

pause
