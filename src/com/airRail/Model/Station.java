package com.airRail.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Station {

@SerializedName("code")
@Expose
private String code;
@SerializedName("fullname")
@Expose
private String fullname;

public String getCode() {
return code;
}

public void setCode(String code) {
this.code = code;
}

public String getFullname() {
return fullname;
}

public void setFullname(String fullname) {
this.fullname = fullname;
}

}