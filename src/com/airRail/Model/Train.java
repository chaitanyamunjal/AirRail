package com.airRail.Model;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Train {

@SerializedName("dest_arrival_time")
@Expose
private String destArrivalTime;
@SerializedName("name")
@Expose
private String name;
@SerializedName("to")
@Expose
private To to;
@SerializedName("no")
@Expose
private Integer no;
@SerializedName("days")
@Expose
private List<Day> days = null;
@SerializedName("travel_time")
@Expose
private String travelTime;
@SerializedName("src_departure_time")
@Expose
private String srcDepartureTime;
@SerializedName("from")
@Expose
private From from;
@SerializedName("classes")
@Expose
private List<Class> classes = null;
@SerializedName("number")
@Expose
private String number;

public String getDestArrivalTime() {
return destArrivalTime;
}

public void setDestArrivalTime(String destArrivalTime) {
this.destArrivalTime = destArrivalTime;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public To getTo() {
return to;
}

public void setTo(To to) {
this.to = to;
}

public Integer getNo() {
return no;
}

public void setNo(Integer no) {
this.no = no;
}

public List<Day> getDays() {
return days;
}

public void setDays(List<Day> days) {
this.days = days;
}

public String getTravelTime() {
return travelTime;
}

public void setTravelTime(String travelTime) {
this.travelTime = travelTime;
}

public String getSrcDepartureTime() {
return srcDepartureTime;
}

public void setSrcDepartureTime(String srcDepartureTime) {
this.srcDepartureTime = srcDepartureTime;
}

public From getFrom() {
return from;
}

public void setFrom(From from) {
this.from = from;
}

public List<Class> getClasses() {
return classes;
}

public void setClasses(List<Class> classes) {
this.classes = classes;
}

public String getNumber() {
return number;
}

public void setNumber(String number) {
this.number = number;
}

}