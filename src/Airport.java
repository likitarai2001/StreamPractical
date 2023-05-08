public class Airport{
    String name;
    String journey;
    int arrTime;
    int deptTime;
    int price;

    Airport(String name, String journey, int arrTime, int deptTime, int price){
        this.name = name;
        this.journey = journey;
        this.arrTime = arrTime;
        this.deptTime = deptTime;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public String getJourney()
    {
        return journey;
    }

    public int getArrTime(){
        return arrTime;
    }

    public int getDeptTime() {
        return deptTime;
    }

    public int getPrice() {
        return price;
    }
}