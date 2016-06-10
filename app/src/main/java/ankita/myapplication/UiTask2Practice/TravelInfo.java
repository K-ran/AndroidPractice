package ankita.myapplication.UiTask2Practice;

/**
 * Created by karan on 10/6/16.
 */
public class TravelInfo {
    String totalDisatnce;
    String fair;
    String fromAddress,fromCountry,fromCity,fromdate,fromtime;
    String toAddress,toCountry,toCity,todate,totime;

    public TravelInfo(String totalDisatnce, String fair, String fromAddress, String fromCountry, String fromCity, String fromdate, String fromtime, String toAddress, String toCountry, String toCity, String todate, String totime) {
        this.totalDisatnce = totalDisatnce;
        this.fair = fair;
        this.fromAddress = fromAddress;
        this.fromCountry = fromCountry;
        this.fromCity = fromCity;
        this.fromdate = fromdate;
        this.fromtime = fromtime;
        this.toAddress = toAddress;
        this.toCountry = toCountry;
        this.toCity = toCity;
        this.todate = todate;
        this.totime = totime;
    }
}
