public class HotelDto {
    private int hotelId;
    private String hotelName;
    private String tplace;

    public HotelDto() {}

    public HotelDto(int hotelId, String hotelName, String tplace) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.tplace = tplace;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getTplace() {
        return tplace;
    }

    public void setTplace(String tplace) {
        this.tplace = tplace;
    }
}
