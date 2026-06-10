//NAME: Tianxin Liang
import java.util.*;
public class Main{
    public static void main(String[] args) {
        //chosen project: MLM (Music Library Manager)
        //Variables/initializing, for title, artist, and rating
        Scanner sc = new Scanner(System.in);
        ArrayList<String> title = new ArrayList<>();
        ArrayList<String> artist = new ArrayList<>();
        ArrayList<Double> rating = new ArrayList<>();

        boolean running = true; //to keep the program running
        //adding initial 5 songs
        title.add("Hate That I Made You Love Me"); title.add("Choosin' Texas"); title.add("Janice STFU"); title.add("Be Her"); title.add("I Just Might");
        rating.add(95.0); rating.add(94.0); rating.add(93.0); rating.add(92.0);rating.add(91.0);
        artist.add("Ariana Grande"); artist.add("Ella Langley"); artist.add("Drake"); artist.add("Ella Langley");
        artist.add("Bruno Mars");

        //greetings to user
        System.out.println("=====================");
        System.out.println("=Welcome to the MLM!=");
        System.out.println("=====================");

        // menu
        while(running){
            System.out.println("\n===Menu===\nwhat do you want to do? (type in a number from 1-8)\noptions");
            System.out.println("================================\n1. Add a song\n" +
                    "2. Average rating of the library\n" +
                    "3. Minimum and Maximum rated song\n" +
                    "4. Display the list of songs\n" +
                    "5. Display the Rating Distribution\n" +
                    "6. Search a song\n" +
                    "7. Display the top and bottom 20%\n" +
                    "8. Exit the program\n" +
                    "================================\n");
            System.out.print("please input you choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            while(choice > 8 || choice < 1){ //check to make sure they choose between a number from 1-8
                System.out.print("invalid choice please choose again:");
                choice = Integer.parseInt(sc.nextLine());
            }

            //navigating to the option
            switch(choice){
                case 1:
                    //add song
                    int counter = 0; //make sure to leave after 2 songs added
                    boolean proceed = true;
                    while(counter < 2 && proceed){
                        System.out.println("what is the Title?");
                        title.add(sc.nextLine());
                        System.out.println("who is the Artist?");
                        artist.add(sc.nextLine());
                        System.out.println("what is the Rating?");
                        double rate = Double.parseDouble(sc.nextLine());
                        while(rate > 100 || rate < 0){
                            System.out.println("invalid option please enter a value from 0-100");
                            rate = Double.parseDouble(sc.nextLine());
                        }
                        rating.add(rate);
                        counter++;

                        if(counter < 2){ //only ask to add another if less than 2 songs are added
                            System.out.println("would you like to add another song?");
                            if(!sc.nextLine().equalsIgnoreCase("yes")){
                                proceed = false;
                            }
                        }
                    }
                    break;

                case 2:
                    //rating average
                    double sum = 0;
                    for(double rates: rating){
                        sum+=rates; //add all the ratings
                    }
                    double average = sum/rating.size(); //find average
                    System.out.println("---------------------------------");
                    System.out.println("the average rating is: " + average);
                    System.out.println("---------------------------------\n");
                    System.out.println("returning to main menu...");
                    break;

                case 3:
                    //max+min
                    double max = 0;
                    double min = 100;

                    //loop to check each number for max/min
                    for(double rate: rating){
                        if(rate > max){
                            max = rate;
                        }
                        if(rate < min){
                            min = rate;
                        }
                    }
                    //printing result
                    System.out.println("-------------------------------------------");
                    System.out.println("The highest Rating is: "+ max);
                    System.out.println("Song Title: "+ title.get(rating.indexOf(max)));
                    System.out.println("From the Artist: "+ artist.get(rating.indexOf(max)));
                    System.out.println("-------------------------------------------\n");

                    System.out.println("-------------------------------------------");
                    System.out.println("The lowest Rating is: "+ min);
                    System.out.println("Song Title: "+ title.get(rating.indexOf(min)));
                    System.out.println("From the Artist: "+ artist.get(rating.indexOf(min)));
                    System.out.println("-------------------------------------------\n");

                    System.out.println("returning to main menu...");
                    break;

                case 4:
                    //list display
                    System.out.println("\nList of Songs:");
                    for(int i = 0 ; i < title.size(); i++){
                        System.out.println(" ------------------------");
                        System.out.println(" ID: " + i);
                        System.out.println(" Title: " + title.get(i));
                        System.out.println(" Artist: " + artist.get(i));
                        System.out.println(" Rating: " + rating.get(i));
                        System.out.println(" ------------------------");
                        System.out.println();
                    }
                    //sub-menu
                    boolean run = true;
                    while(run){
                        System.out.println(
                                " ==sub menu==\n1. Edit a song\n2. Remove a song\n3. Return to the main menu \n");

                        System.out.print("which option do you want to choose: ");
                        int option = Integer.parseInt(sc.nextLine());

                        while(option > 3 || option < 1){
                            System.out.print("invalid choice please choose again:");
                            option = Integer.parseInt(sc.nextLine());
                        }

                        //submenu navigation
                        switch(option){
                            case 1:
                                //edit song
                                System.out.println("what is the ID of the song you want to edit?");
                                int ID = Integer.parseInt(sc.nextLine());
                                while(ID > title.size() - 1 || ID < 0){
                                    System.out.println("invalid choice please try again: ");
                                    ID = Integer.parseInt(sc.nextLine());
                                }
                                System.out.println("do you want to do change 1.Title, 2.Artist, or 3.Rating (type number): ");
                                int subchoice = Integer.parseInt(sc.nextLine());
                                while(subchoice > 3 || subchoice < 1){
                                    System.out.println("invalid choice please try again");
                                    subchoice = Integer.parseInt(sc.nextLine());
                                }
                                switch(subchoice){
                                    case 1:
                                        System.out.println("what Title do you want to change it to?");
                                        title.set(ID, sc.nextLine());
                                        break;
                                    case 2:
                                        System.out.println("what Artist do you want to change it to?");
                                        artist.set(ID, sc.nextLine());
                                        break;
                                    case 3:
                                        System.out.println("what is the new rating?");
                                        double newRate = Double.parseDouble(sc.nextLine());
                                        while(newRate > 100 || newRate < 0){
                                            System.out.println("invalid please enter number from 0-100");
                                            newRate = Double.parseDouble(sc.nextLine());
                                        }
                                        rating.set(ID, newRate);
                                        break;
                                }
                                System.out.println("------------------------\nyour updated song is here:\n ID: " + ID +  "\n Title: "
                                        + title.get(ID) + "\n Artist: " + artist.get(ID) +
                                        "\n Updated Rating: " + rating.get(ID) + "\n------------------------\n");
                                break;

                            case 2:
                                //remove song
                                if(title.size() == 0){//check if there are songs to remove
                                    System.out.println("there are no more songs to remove!\n");
                                }
                                else{
                                    System.out.println("what is the ID of the song you want to remove?");
                                    int ID2 = Integer.parseInt(sc.nextLine());
                                    while(ID2 > title.size() - 1 || ID2 < 0){
                                        System.out.println("invalid choice please try again: ");
                                        ID2 = Integer.parseInt(sc.nextLine());
                                    }

                                    System.out.println("---------------------------------------------------------------------\nthe songs: \""
                                            + title.get(ID2) + "\" was removed here is an updated " +
                                            "list of songs\n---------------------------------------------------------------------");
                                    title.remove(ID2);
                                    artist.remove(ID2);
                                    rating.remove(ID2);
                                    for(int i = 0; i < title.size(); i++){
                                        System.out.println(" ------------------------");
                                        System.out.println(" ID: " + i );
                                        System.out.println(" Title: " + title.get(i));
                                        System.out.println(" Artist: " + artist.get(i));
                                        System.out.println(" Rating: " + rating.get(i));
                                        System.out.println(" ------------------------");
                                        System.out.println();
                                    }
                                }
                                break;

                            case 3:
                                //return to main menu
                                System.out.println("=========================");
                                System.out.println("returning to main menu...");
                                System.out.println("=========================");
                                run = false;
                                break;
                        }
                    }
                    break;

                case 5:
                    //rating
                    int star5 = 0;
                    int star4 = 0;
                    int star3 = 0;
                    int star2 = 0;
                    int star1 = 0;
                    for( double rate: rating){
                        if(rate < 40)
                            star1++;
                        else if(rate <= 59)
                            star2++;
                        else if(rate <= 74)
                            star3++;
                        else if(rate <= 89)
                            star4++;
                        else if(rate <= 100)
                            star5++;
                    }
                    System.out.println("\n=====================");
                    System.out.println("your distribution chart");
                    System.out.println("=======================");

                    //find the rating catagory with the most songs
                    int most = Math.max (star5, Math.max (star4, Math.max (star3, Math.max (star2, star1))));

                    //print the result
                    for( int i = most; i >= 1 ; i--){
                        if(star5 >= i)
                            System.out.print("#  ");
                        else
                            System.out.print("   ");
                        if(star4 >= i)
                            System.out.print("#  ");
                        else
                            System.out.print("   ");
                        if(star3 >= i)
                            System.out.print("#  ");
                        else
                            System.out.print("   ");
                        if(star2 >= i)
                            System.out.print("#  ");
                        else
                            System.out.print("   ");
                        if(star1 >= i)
                            System.out.print("#  ");
                        else
                            System.out.print("   ");

                        System.out.println();
                    }
                    System.out.println("__________________\n5* 4* 3* 2* 1*");
                    System.out.println("=========================");
                    System.out.println("returning to main menu...");
                    System.out.println("=========================");
                    break;

                case 6:
                    //search intake
                    System.out.print("what are you searching for: ");
                    String ans = sc.nextLine().toLowerCase();
                    while(ans.length() == 0){
                        ans = sc.nextLine().toLowerCase();
                    }
                    //find average
                    double sum6 = 0;
                    for (double rate: rating){
                        sum6 += rate;
                    }
                    double average6 = sum6 / rating.size();

                    //checking if the search is in the song
                    boolean found = false;

                    for(int i = 0; i < title.size(); i++){
                        String strRate = String.valueOf(rating.get(i));
                        if( title.get(i).toLowerCase().contains(ans) || artist.get(i).toLowerCase().contains(ans)
                        || strRate.contains(ans)){

                            if(!found){
                                System.out.println("------------------\nthis song is found:");
                                found = true;
                            }

                            System.out.println("______________________________\nthe Title is: " + title.get(i));
                            System.out.println("the Artist is: " + artist.get(i));
                            System.out.println("the Rating is: " + rating.get(i));

                            //printing average
                            if( rating.get(i) > average6) {
                                System.out.println("It is greater than the average");
                                System.out.println("______________________________");

                            }
                            else if( rating.get(i) < average6) {
                                System.out.println("It is smaller than the average");
                                System.out.println("______________________________");
                            }
                            else {
                                System.out.println("It is the same as the average");
                                System.out.println("______________________________");
                            }
                        }
                    }
                    if(!found) //accounting for an invalid search
                        System.out.println("\n-----------------\nInvalid search :(\n-----------------");
                    System.out.println("\n=========================");
                    System.out.println("returning to main menu...");
                    System.out.println("=========================");
                    break;

                case 7:
                    //top/bottom
                    //setting up new arraylist for the top/bottom 20%
                    //duplicated the rating as temp
                    ArrayList<Double> temp = new ArrayList<>();

                    ArrayList<Double> topRate = new ArrayList<>();
                    ArrayList<String> topTitles = new ArrayList<>();
                    ArrayList<String> topArtists = new ArrayList<>();

                    ArrayList<Double> lowRate = new ArrayList<>();
                    ArrayList<String> lowTitles = new ArrayList<>();
                    ArrayList<String> lowArtists = new ArrayList<>();

                    //add the element of rating into temp
                    for( double rate: rating){
                        temp.add(rate);
                    }

                    //calculate the amount that is 20%
                    int twentypercent = Math.max(1, ((int)(rating.size() * 0.2)));
                    //for each time get the max, x times, for top/bottom 20%
                    for (int i = 1; i <= twentypercent; i++){
                        double maxRate = 0;
                        double minRate = 100;
                        for (double rate: temp){
                            if(rate > maxRate){
                                maxRate = rate;
                            }
                            if( rate < minRate){
                                minRate = rate;
                            }
                        }
                        int index = rating.indexOf(maxRate);
                        int lowindex = rating.indexOf(minRate);

                        topRate.add(maxRate);
                        topTitles.add(title.get(index));
                        topArtists.add(artist.get(index));

                        lowRate.add(minRate);
                        lowTitles.add(title.get(lowindex));
                        lowArtists.add(artist.get(lowindex));

                        temp.remove(maxRate);
                        temp.remove(minRate);
                    }
                    //print results
                    System.out.println("\nthe top 20% of ratings are:");
                    for( int i = 0; i < topTitles.size(); i++){
                        System.out.println("-----------------------------");
                        System.out.println("Title: " + topTitles.get(i));
                        System.out.println("Artist: " + topArtists.get(i));
                        System.out.println("Rating: " + topRate.get(i));
                        System.out.println("-----------------------------\n");
                    }
                    System.out.println("the lowest 20% of ratings are:");
                    for ( int i = 0; i < lowTitles.size(); i++){
                        System.out.println("-----------------------------");
                        System.out.println("Title: " + lowTitles.get(i));
                        System.out.println("Artist: " + lowArtists.get(i));
                        System.out.println("Rating: " + lowRate.get(i));
                        System.out.println("-----------------------------\n");
                    }
                    System.out.println("=========================");
                    System.out.println("returning to main menu...");
                    System.out.println("=========================");
                    break;

                case 8:
                    //exit program, and print ending message
                    System.out.println("\n================================");
                    System.out.println("==Thank you for using the MLM!==");
                    System.out.println("================================");

                    running = false; //stop the program from running
                    break;
            }
        }
        sc.close();

    }
}