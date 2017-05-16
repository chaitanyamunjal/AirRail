package com.airRail.Model;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RailwayServiceResults {


@SerializedName("response_code")
@Expose
private Integer responseCode;
@SerializedName("total")
@Expose
private Integer total;
@SerializedName("train")
@Expose
private List<Train> train = null;
@SerializedName("error")
@Expose
private String error;

public Integer getResponseCode() {
return responseCode;
}

public void setResponseCode(Integer responseCode) {
this.responseCode = responseCode;
}

public Integer getTotal() {
return total;
}

public void setTotal(Integer total) {
this.total = total;
}

public List<Train> getTrain() {
return train;
}

public void setTrain(List<Train> train) {
this.train = train;
}

public String getError() {
return error;
}

public void setError(String error) {
this.error = error;
}

}


