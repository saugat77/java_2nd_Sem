class VideoGameStation{
    
    //Qno.1
    public String gameStation;
    public String videoGame;
    public String customerName;
    public String customerType;
    public String bookingDate;
    public int timeDuration;
    public int hourlyRate;
    public boolean availableStatus ;
    
    //Qno.2
    public VideoGameStation() {
        this.gameStation = "Playstation";
        this.videoGame = "God of War";
        this.hourlyRate = 100;
        this.customerName = "";
        this.customerType = "";
        this.bookingDate  = "";
        this.timeDuration  = 0;
        this.availableStatus = true;
    }
    
    //Qno.3
    public String getGameStation(){
        return this.gameStation;
    }

    public String getVideoGame(){
        return this.videoGame;
    }

    public String getCustomerName(){
        return this.customerName;
    }

    public String getCustomerType(){
        return this.customerType;
    }

    public String getBookingDate(){
        return this.bookingDate;
    }

    public int gettimeDuration(){
        return this.timeDuration;
    }

    public int getHourlyRate(){
        return this.hourlyRate;
    }

    public boolean getavailableStatus(){
        return this.availableStatus;
    }

    //Qno.4
    public void sethourlyRate(int rate){
        this.hourlyRate = rate;
    }

    public void setcustomerType(String type){
        this.customerType = type;
    }
    
    //Qn.5
    public void booking(String c_name,String c_type,String date,int duration){
        if(this.availableStatus == true){
            this.customerName = c_name;
            this.customerType = c_type;
            this.bookingDate = date;
            this.timeDuration = duration;
            this.availableStatus = false;
        }else{
            System.out.println("The game station is not free till" + this.timeDuration + this.bookingDate);

        }
    }
    
    //Qno.6
    public void defaultInfo(){
        if(this.availableStatus==true){
            System.out.println("The video game station is available for booking!");
        }else{
            this.customerName = "";
            this.customerType = "";
            this.bookingDate = "";
            this.timeDuration = 0;
            this.availableStatus = true;
        }
    }
    
    //Qno.7
    public void printInfo(){
        System.out.println("Game station: " + this.gameStation);
        System.out.println("Hourly Rate: " + this.hourlyRate); 
    }

}