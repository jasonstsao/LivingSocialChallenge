Hello!

This is the explanation of my code 


With the files in the filepath's that they are, you should be able to run 
all the code by simply running the runLoad.sh file

Steps to run the code:

1.) Open merchantForm.html in a browser

2.) Select the tabbed file with item information
NOTE: I made my program really simple so right now the file must be called
"example_input.tab" because that is what my java files use as input 

3.) Upload the file 

Then 

4.) Run this command on the command line in the folder containing runLoad.sh

chmod u+x runLoad.sh

This will give yu the permission to run the script.

5.) Type "./runLoad.sh" in the command line

This should 
- compile the required java files
- create the database
- drop the 'Items' table in the database if it already exists
- create an 'Items' table'
- run the parser on the file "example_input.tab" in the same directory as where runLoad.sh was run
	- print out the total revenue from the parsed information to the screen using java System.out.println

- load the parsed information into the sql database
- delete the file created as input to load the parsed information

NOTES:

It didn't say in the instructions that we had to calculate the total revenue by pulling
the information from our database so right now the implementation just takes that information
straight from the parsed information. However I did write code in the runLoad.sh that should
be able to pull the correct information from the database and calculate the total revenue. I don't
use this method because I wasn't exactly sure if you would provide the correct files to allow me
to use the java SQL connector by having a classpath such as

export CLASSPATH=$CLASSPATH:/java/classes:/home/tchin/myclasses

but if you do have such libraries available, then you need only add the classpath 
and uncomment the last line in runLoad.sh that would run the necessary code to make 
the calculations

Also when I was testing this I was using the only available linux machine I had which 
was a virtual machine I'm using for one of my classes. It would not allow me to create a new
database though so I tested it on the class's database but I altered the code I turned 
in so that it does create the database so I believe it should work. 

If for some reason the form does not work then putting a file called "example_input.tab" in 
the directory with runLoad.sh and then running runLoad.sh should work as well

