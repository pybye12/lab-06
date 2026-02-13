package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;
    /**
     * Constructor for City
     * @param city Name of the city
     * @param province Name of the province
     */
    public City(String city, String province){
        this.city = city;
        this.province = province;
    }
    /**
     * Gets the city name
     * @return The city name
     */
    String getCityName(){
        return this.city;
    }
    /**
     * Gets the province name
     * @return The province name
     */
    String getProvinceName(){
        return this.province;
    }
    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return city.equals(city1.city) && province.equals(city1.province);
    }

    @Override
    public int hashCode() {
        return city.hashCode();
    }
}