package logical;

import pojo.Taxi;

import java.util.ArrayList;

public class LogicalLayer {
    ArrayList<String> tripsDetails= new ArrayList<>();
    public  ArrayList<Taxi> getFreeTaxis(ArrayList<Taxi> taxis, char pickupPoint, int time)
    {
        ArrayList<Taxi> freeTaxi=new ArrayList<>();
        for (Taxi taxi:taxis) {
            if(taxi.getFreeTime()<=time && (Math.abs((int)taxi.getCurrentPoint()-(int)pickupPoint)<=time-taxi.getFreeTime()))
            {
                freeTaxi.add(taxi);
            }
        }
        return freeTaxi;
    }
    public int BookTaxi(int customerId,char pickupPoint,char dropPoint,int pickupTime,ArrayList<Taxi> freeTaxis)
    {
        int min=999;
        int earnings=0;
        int nextFreeTime=0;
        char nextPoint = ' ';
        Taxi bookedTaxi = null;
        String trips="";
        for (Taxi taxi:freeTaxis)
        {
            int distanceBetweenCustomerAndTaxi=Math.abs((int)taxi.getCurrentPoint()-(int)pickupPoint)*15;
            if(distanceBetweenCustomerAndTaxi<min)
            {
                bookedTaxi=taxi;
                int distance=Math.abs(((int)dropPoint-(int)pickupPoint)*15);
                earnings=(distance-5)*10+100;
                int dropTime=pickupTime+distance/15;
                nextFreeTime=dropTime;
                nextPoint=dropPoint;
                trips = customerId + "    " + customerId + "    " + pickupPoint +  "   " + dropPoint + "   " + pickupTime + "    " +dropTime + "      " + earnings;
                min=distanceBetweenCustomerAndTaxi;
            }
        }
//        Taxi object = new Taxi();
        bookedTaxi.setBooked(true);
        bookedTaxi.setTotalEarnings(bookedTaxi.getTotalEarnings()+earnings);
        bookedTaxi.setFreeTime(nextFreeTime);
        bookedTaxi.setCurrentPoint(nextPoint);
        tripsDetails.add(trips);
        bookedTaxi.setTrips(tripsDetails);
        return bookedTaxi.getId();
    }
}
