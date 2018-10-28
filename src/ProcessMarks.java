// Import Arrays in order to use sort method

import java.util.Arrays;

/*
The ProcessMarks class is designed to retrieve an array of marks and then
process this array to retrieve certain information from it. The information
includes finding the maximum, minimum, range, mean, median and mode of marks.
It is also able to find the corresponding grades to these marks, show a string
of the marks and show the distribution of marks.
*/

public class ProcessMarks {
    public static void main(String[] args) {
        // Display the max score
        System.out.println("The maximum mark of the array of marks is "
                + max());
        System.out.println("");

        // Display the min score
        System.out.println("The minimum mark of the array of marks is "
                + min());
        System.out.println("");

        // Display the range
        System.out.println("The range of the array of marks is " + range());
        System.out.println("");

        // Display the mean score
        System.out.println("The mean of the array of marks is " + mean());
        System.out.println("");

        // Display the median score
        System.out.println("The median of the array of marks is " + median());
        System.out.println("");

        // Display the mode score
        System.out.println("One mode of the array of marks is " + mode());
        System.out.println("");

        // For loop to increment through all of the values of the array passed
        // from the grades method
        for (int i = 0; i < grades().length; i++) {

            // Display the grade at index i
            System.out.print(grades()[i] + " ");

            // If statement used to format 30 grades to a line
            if (i % 30 == 29)
                System.out.println();
        }

        // Display 2 blank lines
        System.out.println("");
        System.out.println("");

        // Create and define grades array
        char[] grades = {'A', 'B', 'C', 'D', 'E', 'F'};

        // For loop to incrememnt through all of the values of the array passed
        // from the gradeDistn method
        for (int i = 0; i < gradeDistn().length; i++) {
            // Display the value of grades array and the array passed from the
            // gradeDistn method, where both at index i
            System.out.println(grades[i] + ": " + gradeDistn()[i]);
        }
    }

    // The getMarks method will copy array from Marks class
    public static int[] getMarks() {
        // Create tempMarks array and call Marks.getMarks() to populate array
        int[] tempMarks = Marks.getMarks();

        // Copy tempMarks array to marks array
        int[] arrayOfMarks = tempMarks.clone();

        // Return arrayOfMarks
        return arrayOfMarks;
    }

    // The getSortedMarks method will sort the marks of an array in ascending
    // order
    public static int[] getSortedMarks() {
        // Create sortedMarks array and call getMarks to populate array
        int[] sortedMarks = getMarks();

        // Sort values in array in ascending order
        Arrays.sort(sortedMarks);

        // Return sorted array
        return sortedMarks;
    }

    // The max method will scan an array and find the largest value and return
    // that value when called
    public static int max() {
        // Declare max variable and initialise with index 0 of array
        int max = getMarks()[0];

        // For loop will increment through the entire array
        for (int i = 1; i < getMarks().length; i++)
            // If the value of array[i] is larger than max, assign max with
            // reference to current index
            if (getMarks()[i] > max) max = getMarks()[i];

        // Return max
        return max;
    }

    // The min method will scan an array and find the smallest value and return
    // that value when called
    public static int min() {
        // Declare min variable and initialise with index 0 of array
        int min = getMarks()[0];

        // For loop will increment through the entire array
        for (int i = 1; i < getMarks().length; i++)
            // If the value of array[i] is smaller than min, assign min with
            // reference to current index
            if (getMarks()[i] < min) min = getMarks()[i];

        // Return min
        return min;
    }

    // The range method will find the range of the array (difference between
    // largest and smallest value
    public static int range() {
        // Declare range value and assign the range by calling max and min
        // methods and finding the difference between the two
        int range = (max() - min());

        // Return range
        return range;
    }

    // The mean method will find the mean of the set of marks in the array
    public static double mean() {
        // Initialise total variable
        double total = 0;

        // For loop to increment through all values in the array
        for (int i = 0; i < getMarks().length; i++) {
            // Add all values of the array to the total variable
            total += getMarks()[i];
        }

        // The sum of the marks divided by the amount of marks in the array will
        // give the mean value. Assign to mean
        double mean = total / getMarks().length;

        // Return mean
        return mean;
    }

    // The median method will find the median of the set of marks in the array
    public static double median() {
        // Create array and populate by calling getSortedMarks method
        int[] arrayOfMarks = getSortedMarks();

        // Declare median variable
        double median;

        // If arrayOfMarks is even
        if (arrayOfMarks.length%2 == 0)
            /* Calculate the median by adding the two values (which are
            converted from int to double) at array.length/2 and
            array.length/2-1 (due to array starting at 0 not 1) and then
            dividing by 2. This value is then assigned to median. */
            median = ((double)arrayOfMarks[arrayOfMarks.length/2]
                    + (double)arrayOfMarks[arrayOfMarks.length/2-1])/2;

            // If arrayOfMarks is odd
        else
            // Assign the value at the median index of arrayOfMarks array to
            // median
            median = (double)arrayOfMarks[arrayOfMarks.length / 2];

        //Return median variable when median is called
        return median;
    }

    /* The mode method will find the mode value within the given array.
    Please note that I have used the ordered array as directed in the assignment
    outline, however my code does not require the array to be ordered. */
    public static int mode() {
        // Create array and populate by calling getSortedMarks method
        int[] arrayOfMarks = getSortedMarks();

        // Initialise mode and maxCount
        int mode = 0;
        int maxCount = 0;

        // For loop increments through every value in the array
        for (int i = 0; i < arrayOfMarks.length; i++) {
            // Initialise count variable
            int count = 0;

            // For loop which then checks how many times in the entire array
            // the first value (i) occurs
            for (int j = 0; j < arrayOfMarks.length; j++) {
                //Everytime there is a match of values, increment count by 1
                if (arrayOfMarks[j] == arrayOfMarks[i]) count++;
            }

            // If count is larger than maxCount
            if (count > maxCount) {
                // Assign the value of count to maxCount
                maxCount = count;
                // Assign the value of arrayOfMarks[i] to mode
                mode = arrayOfMarks[i];
            }
        }
        // Return mode
        return mode;
    }

    // The grades method will compare the array of marks and return an array of
    // grades as determined by the gradeBoundaries array
    public static char[] grades() {
        // Create array and populate by calling getSortedMarks method
        int[] arrayOfMarks = getSortedMarks();

        // Create array for grades using arrayOfMarks.length as the number of
        // values in the array
        char[] arrayOfGrades = new char[arrayOfMarks.length];

        // Create array for grade boundaries
        int[] gradeBoundaries = {90, 75, 60, 50, 45};

        // For loop to increment through each value of the array
        for (int i = 0; i < arrayOfMarks.length; i++) {

            // If arrayOfMarks[i] is larger or equal to gradeBoundaries[0]
            if (arrayOfMarks[i] >= gradeBoundaries[0])
                // Assign 'A' to arrayOfGrades[i]
                arrayOfGrades[i] = 'A';

                // Else if arrayOfMarks[i] is larger or equal to gradeBoundaries[1]
            else if (arrayOfMarks[i] >= gradeBoundaries[1])
                // Assign 'B' to arrayOfGrades[i]
                arrayOfGrades[i] = 'B';

                // Else if arrayOfMarks[i] is larger or equal to gradeBoundaries[2]
            else if (arrayOfMarks[i] >= gradeBoundaries[2])
                // Assign 'C' to arrayOfGrades[i]
                arrayOfGrades[i] = 'C';

                // Else if arrayOfMarks[i] is larger or equal to gradeBoundaries[3]
            else if (arrayOfMarks[i] >= gradeBoundaries[3])
                // Assign 'D' to arrayOfGrades[i]
                arrayOfGrades[i] = 'D';

                // Else if arrayOfMarks[i] is larger or equal to gradeBoundaries[4]
            else if (arrayOfMarks[i] >= gradeBoundaries[4])
                // Assign 'E' to arrayOfGrades[i]
                arrayOfGrades[i] = 'E';

                // Else if arrayOfMarks[i] is larger or equal to gradeBoundaries[5]
            else
                // Assign 'F' to arrayOfGrades[i]
                arrayOfGrades[i] = 'F';
        }
        // Return array
        return arrayOfGrades;
    }

    // The gradeDistn method will take an array of grades and count the
    // distribution of each mark and then return an array containing the
    // distribution of each grade in order from A to F
    public static int[] gradeDistn() {
        // Create array and populate by calling grades method
        char[] sortedGrades = grades();

        // Create array with 6 values
        int[] gradeDistn = new int[6];

        // Sort array in ascending order (A-F)
        Arrays.sort(sortedGrades);

        // For loop to increment through all values in the array
        for (int i = 0; i < sortedGrades.length; i++)
            // Switch used to check each value
            switch (sortedGrades[i]) {
                // If 'A'
                case 'A':
                    // Increment value at gradeDistn[0]
                    gradeDistn[0]++;
                    // Break from switch
                    break;

                // If 'B'
                case 'B':
                    // Increment value at gradeDistn[1]
                    gradeDistn[1]++;
                    // Break from switch
                    break;

                // If 'C'
                case 'C':
                    // Increment value at gradeDistn[2]
                    gradeDistn[2]++;
                    // Break from switch
                    break;

                // If 'D'
                case 'D':
                    // Increment value at gradeDistn[3]
                    gradeDistn[3]++;
                    // Break from switch
                    break;

                // If 'E'
                case 'E':
                    // Increment value at gradeDistn[4]
                    gradeDistn[4]++;
                    // Break from switch
                    break;

                // If anything else ('F')
                default:
                    // Increment value at gradeDistn[5]
                    gradeDistn[5]++;
                    // Break from switch
                    break;
            }
        // Return gradeDistn array
        return gradeDistn;
    }
}