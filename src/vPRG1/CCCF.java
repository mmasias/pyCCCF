package vPRG1;

class CCCF {

    public static void main(String[] args) {
        
        final double OPENING_TIME = 9.0;
        final double CLOSING_TIME = 21.0;
        final double MINUTE = 1.0/60.0;
        double currentTime = OPENING_TIME;
        boolean isWorking = true;
        
        do{
            currentTime = currentTime + MINUTE;
            System.out.println(currentTime);
            isWorking=currentTime<CLOSING_TIME;
            
        }while(isWorking);
    }

}
