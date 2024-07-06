
package org.example;
import java.sql.Time;
import java.util.*;
import java.util.Map;


public class Train {

    private String trainId;

    private String trainNo;

    private List<List<Integer>> seats;

    private Map<String, String> stationTimes;

    private List<String> stations;

    public Train (){}

    public Train (String trainId, String trianNo,List<List<Integer>> seats, Map<String, String> stationTimes, List<String> stations){
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.seats = seats;
        this.stationTimes = stationTimes;
        this.stations = stations;

    }

    public List<String>getStation(){
        return stations;

    }

    public void setSeats(List<List<Integer>> seats){
        this.seats = seats;

    }

    public String getTrainId(){
        return trainId;

    }

    public Map<String, String> getStationTimes(){
        return stationTimes;

    }

    public String getTrainNo(){
        return trainNo;

    }


    public void setTrainId(String trainId){
        this.trainId = trainId;

    }

    public void setStationTimes(Map<String, String> stationTimes){
        this.stationTimes = stationTimes;

    }
    public void setStations(List<String> stations){
        this.stations = stations;

    }
    public String getTrainInfo(){
        return String.format("Train ID: %s Train No: %s, trianId, trainNo");

    }

}

