import logical.LogicalLayer;
import pojo.Taxi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TaxiRunner {
    public static void main(String[] args)
    {
        LogicalLayer logical =new LogicalLayer();
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the no.of Taxis");
        int n= scan.nextInt();
        ArrayList<Taxi> taxis = new ArrayList<>();
        int j=1;
        for (int i = 0; i <n ; i++) {
            Taxi object=new Taxi();
            object.setCurrentPoint('A');
            object.setFreeTime(6);
            object.setBooked(false);
            object.setTotalEarnings(0);
            object.setId(j);
            taxis.add(object);
            j++;
        }
        int options;
        do{
            System.out.println("1.BookTaxi\n2.PrintTaxiDetails");
            options=scan.nextInt();
            switch (options)
            {
                case 1:
                {
                    System.out.println("Enter CustomerId");
                    int customerId=scan.nextInt();
                    System.out.println("Enter pickup point");
                    char pickupPoint=scan.next().charAt(0);
                    System.out.println("Enter drop point");
                    char dropPoint=scan.next().charAt(0);
                    System.out.println("Enter pickupTime");
                    int time=scan.nextInt();
                    ArrayList<Taxi> freeTaxis=logical.getFreeTaxis(taxis,pickupPoint,time);
                    if(freeTaxis.size()==0)
                    {
                        System.out.println("No taxi can be allotted");
                        return;
                    }
                    freeTaxis.sort(Comparator.comparingInt(Taxi::getTotalEarnings));
                    int taxiId=logical.BookTaxi(customerId,pickupPoint,dropPoint,time,freeTaxis);
                    System.out.println("Taxi "+taxiId+" is allotted");
                    break;
                }
                case 2:
                {
                   for (Taxi taxi:taxis)
                   {
                       System.out.println("Taxi-"+taxi.getId()+"TotalEarnings-"+taxi.getTotalEarnings());
                       System.out.println("BookingID    CustomerID    From    To    PickupTime    DropTime    Amount");
                       ArrayList<String> trips= taxi.getTrips();
                       for (String trip:trips)
                       {
                           System.out.println(trip);
                       }
                       System.out.println();
                       System.out.println();
                   }
                   break;
                }
            }
        }while (options<3);
    }
}
