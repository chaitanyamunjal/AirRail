package com.airRail.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Destination {

@SerializedName("airport")
@Expose
private String airport;

public String getAirport() {
return airport;
}

public void setAirport(String airport) {
this.airport = airport;
}

}