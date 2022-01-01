import java.util.ArrayList;

public class UserOperations {
    DataRetriever db = DataRetriever.getInstance();
    CarRequest currentRequest;

    void requestRide(User user, Area source, Area destination,int passengersNo,boolean aloneStatus) {
        if(aloneStatus){
            currentRequest = new CarRequest(user,source,destination);
        }else{
            currentRequest = new CarRequest(user,source,destination,passengersNo);
        }
    }
    ArrayList<Offer> getOffers(User user){
        return db.getDriverOffer(user);
    }

    void reviewOffers() {
    }

    void rateDriver(User user,String driverName,int rating) {
        db.rateDriver(user,db.getDriver(driverName), rating);
        }

    Double getDriverRating() {
        if (currentRequest != null)
            return currentRequest.getRating();
        System.out.println("You are not in a ride!");
        return 0.0;
    }


    ArrayList<Ride> getCarpoolRides(User user,Area source,Area destination){
        //TODO add or add to current request ride
        return db.getCarpoolRides(source,destination);

    }
    public void joinRide(User user,int rideID){

    }



}
