# acquentCodeChallenge

This project will take text file as input and sorts the orders in lexicographicalOrder and writes output to a file.

How to Run the Project. 

Clone the project and start the application by running AcquentTestApplication.java.

Open swagger which has a end point which will take the inputFilePath and outPutFilePath as inputs and writes a file to outputFile Path

To run tests through command line run below command
$ mvn clean install -DTests


#Assumptions while sorting the orders according to the lexicographicalOrder ignored case as it doesn't give any value to the business user if the two same orders showing at different order if one they are case sensitive.
