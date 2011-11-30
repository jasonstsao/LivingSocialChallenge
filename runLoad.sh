javac helperFunctions/Parser.java
javac helperFunctions/CalculateRevenue.java
javac helperFunctions/DbManager.java

mysql < createDatabase

mysql LivingSocial < drop.sql

mysql LivingSocial < create.sql

java helperFunctions/Parser "example_input.tab"

mysql LivingSocial < load.sql 

rm Items.csv

#java helperFunctions/CalculateRevenue;






