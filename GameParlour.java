import java.util.ArrayList;
import java.lang.String;
import java.util.Collections;

public class GameParlour{
    //Qno. 8
    private ArrayList<VideoGameStation>gameStationList = new ArrayList<VideoGameStation>();

    //Qno. 9
    public void addGameStation(String gameStation, String videoGame, int hourlyRate ){
        gameStationList.add(new VideoGameStation(gameStation, videoGame, hourlyRate));
    }

    //Qno. 10
    public void removeGameStation(int index){
        try{
            gameStationList.remove(index);
        }catch (IndexOutOfBoundsException ex){
            System.out.println("Please enter valid index for Game Station");
        }
    }

    //Qno. 11
    public void bookingGameStation(int index,String customerName, String customerType, String bookingDate, int timeDuration){
        try{
            VideoGameStation book = gameStationList.get(index);
            book.booking(customerName, customerType, bookingDate, timeDuration);
        }catch (IndexOutOfBoundsException ex){
            System.out.println("Please enter valid index for Game Station");
        }
    }

    //Qno. 12
    public void freeingGameStation(int index){
        try{
            VideoGameStation free = gameStationList.get(index);
            free.defaultInfo();
        }catch (IndexOutOfBoundsException ex){
            System.out.println("Please enter valid index for Game Station");
        }
    }  

    //Qno. 13
    public void displayGameStation(int index){
        for(VideoGameStation display:gameStationList){
            if(display.availableStatus == true){
                System.out.println(gameStationList.indexOf(index));
                display.printInfo();
            }
        }
    }

        //Qno. 14
        public void searchGameStation(int max_hrate, String search_term, int index){
        for(VideoGameStation search:gameStationList){
            if (search.availableStatus == true && search_term == search.videoGame && search.hourlyRate <= max_hrate){
                System.out.println(gameStationList.get(index));
                search.printInfo();
                break;
            }else{
                System.out.println("The given Game Station doesnot exits !");
            }
        }
    }

    //Qno. 15
    public void displayInfo(){
        Collections.sort(gameStationList);
        for(VideoGameStation display:gameStationList){
            if(display.availableStatus == false){
                System.out.println("Customer name:- " + display.customerName + "booked Video Game Station:-" + display.gameStation);
            }
        }
    }
}

