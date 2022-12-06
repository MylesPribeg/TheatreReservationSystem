public class Seat {
    String seat_id;
    String room_name;

    //constructors
    Seat(String seat_id, String room_name){
        this.seat_id = seat_id;
        this.room_name = room_name;
    }

    //getters
    public String getSeatId(){return this.seat_id;}
    public String getRoomName(){return this.room_name;}


}
