javac helperFunctions/Parser.java
javac helperFunctions/CalculateRevenue.java
javac helperFunctions/DbManager.java

mysql CS144 < drop.sql

mysql CS144 < create.sql

java helperFunctions/Parser "example_input.tab"

mysql CS144 < load.sql 

rm Items.csv

java helperFunctions/CalculateRevenue;






