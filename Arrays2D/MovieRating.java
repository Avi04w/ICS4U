package Arrays2D;
/* Movie Rating
    This code will allow the user to enter a number of movies and their ratings.
    It will store these ratings in a 2d array and display them in a table format.
    It will also display the average rating for each movie as well as all the movies
    with a ranking of 8 or higher.
 */

//import statements
import java.util.Scanner;

public class MovieRating {
    //main method
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("How many movies would you like to enter ratings for? ");
        int numMovies = input.nextInt(); //asking user for number of movies.

        input.nextLine(); //eats newline from line above

        int[][] moviesRatings = new int[numMovies][];
        String[] movies = new String[numMovies];
        float[] averages = new float[numMovies];

        for (int i = 0; i < numMovies; i++){
            System.out.print("Enter movie name: ");
            String movie = input.nextLine(); //getting name of movie
            movies[i] = movie;

            System.out.print("How many ratings would you like to enter? ");
            int numRatings = input.nextInt(); //asking user for number of ratings.
            moviesRatings[i] = new int[numRatings];

            float average = 0;

            for (int j = 0; j < numRatings; j++){
                System.out.print("Enter rating: ");
                int rating = input.nextInt(); //asking user for movie rating.
                moviesRatings[i][j] = rating; //adding rating to ratings Array.
                average += (float) rating;
            }

            input.nextLine(); //eats newline from line above

            //Calculating average of movie ratings and adding them to averages Array.
            average /= numRatings;
            averages[i] = average;
        }


        //Displaying movies and their ratings
        System.out.println();
        System.out.println("Movie");
        for (int i = 0; i < numMovies; i++){
            System.out.print(movies[i]);
            for (int x = 0; x < (15 - movies[i].length()); x++) {
                System.out.print(" ");
            }
            for (int j = 0; j < moviesRatings[i].length; j++){
                System.out.print(moviesRatings[i][j] + "  ");
            }
            System.out.println();
        }


        //Displaying movies and their averages.
        System.out.println();
        System.out.println("Averages");
        for (int i = 0; i < numMovies; i++){
            System.out.print(movies[i]);
            for (int x = 0; x < (20 - movies[i].length()); x++) {
                System.out.print(" ");
            }
            System.out.printf("%.2f", averages[i]);
            System.out.println();
        }

        //Displaying movies with average above 8.
        System.out.println();
        System.out.println("Movies with average above 8");
        for (int i = 0; i<averages.length; i++){
            if (averages[i] > 8){
                System.out.println(movies[i]);
            }
        }

        //Displaying movie with the highest average rating.
        float maxRating = 0;
        int index = 0;
        for (int i = 0; i<averages.length; i++){
            if (averages[i] > maxRating){
                maxRating = averages[i];
                index = i;
            }
        }
        System.out.println();
        System.out.println("Highest Average: " + movies[index]);
    }
}