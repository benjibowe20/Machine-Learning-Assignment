# Machine-Learning-Assignment

1. List of classes, with a description

main.java - This class is the root of the assignment. It does not have any other function then creating a new object of the GUI.

GUI.java - This is the class used for the grapical user interface. The GUI is where all other classes and methods are called from.
	     The GUI provides instructions to the user on how to use the application, drop-down menus for the user to select the
	     attributes they would like their student to have, two buttons for calculations and data entry and the naive bayes formula
	     used in this machine learning model. There is two buttons in the GUI. When the "Start Machine" button is pressed the user
	     is promted for a file name. Once entered the GUI calls on the learningModel.java and fileInputAndOutput.java classes 
	     to analyse the data and trains itself on a random 70% of the dataset and the accuracy of the model is returned. Once this
	     has been completed the second buttton "Calculate Probability" becomes visable and the "Start Machine buttton is disabled.
	     Users can then choose any selection of attributes from the drop down menus and hit the "Calculate Probability" button 
	     whuich will return probabilities of that student becoming an entrepreneur or not. This last step can be repeated as 
	     many times as the user would like.

fileInputAndOutput.java - This class has 2 methods for different tasks. There is an openFile method which just opens the file
	    			  and a readFile method which splits the csv file up by "," characters and stores all values in an array.

learningModeal.java - This class' main funtion is to train the algorithm on the provided data. Firstly it uses the coolectData
			    method to break the data produced in the fileInputAndOutput.java class into smaller pieces. It creates
			    new arraylists for each column of data. Next the getEntriesForTraining method randomly generates an
			    array of indexes which contains 70% of all indexes. These array indexes will be used for the training.
  			    The remaining 30% of indexes are stored as they will be used for testing at a later stage. The prior
			    probabilities, probability of evidences and probability of liklihood of evidences are all calculated 
			    and stored in variables. These calculations are done on a random 70% of data which we got earlier.

dataAnalysis.java - This class contains two methods. The testData method uses the random 30% of indexes to make a guess at the 
			  outcome of the student becoming an entrepreneur or not. This guess is compared to the actual result of 
			  entreprenuer or not. The accuracy of the model is based on this testing. The second method gets the user
			  input from the drop-down menus and runs it through the algorithm to calculate probaility of entreprenuer an not
			  entrepreneur. Whichever value is higher is printed to the user with the probabilituies of each giving a result to
			  the user on which one is more likely based on the dataset.

2. Description of core functionality

The application implements the Naive Bayes classifier. The application trains itself on a random 70% of data entered, and tests itself 
on the remaining 30%. The GUI allows user input to be entered and user can pick a file to use. All files that are .csv and
contain the same number of columns and relevant data can be used and any extra instances added to dataset will improve the accuracy of the model.
All data is read in dynamically.

3. Optional Functionality

- Instructions for user
- User can pick file that they use
- Naive Bayes formula displayed
- Buttons are made visible and diabled for easier usage of application.
- Probabilties of each outcome are displayed to user
- Chooses a random 70% of data so the outcome should always be slightly diffent based on which data the model was trained on,
  and also allows a more accurate representation of the entire dataset.

4. If i had more time

- I would have created some kind of graph to display attributes and their effect on the outcome of student becoming an entrepreneur.
- Upon reaching the later stages of the project i realised some small things i could have done to make my project simpler, such as
  making objects of students from the dataset and have an array of students.
- I wouldve also liked to add a way to add the user input to the dataset to increase the size of the data to further inhance the 
  accuracy of the model.

5. Link to video and Github

Video: https://www.youtube.com/watch?v=OFxu7_zoqFQ

GitHub: https://github.com/benjibowe20
