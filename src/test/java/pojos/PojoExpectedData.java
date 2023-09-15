package pojos;

public class PojoExpectedData {
    private int bookingid;
    private PojoHerokuappRequestBody booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public PojoHerokuappRequestBody getBooking() {
        return booking;
    }

    public void setBooking(PojoHerokuappRequestBody booking) {
        this.booking = booking;
    }

    public PojoExpectedData(int bookingid, PojoHerokuappRequestBody booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public PojoExpectedData() {
    }

    @Override
    public String toString() {
        return "PojoExpectedData{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
