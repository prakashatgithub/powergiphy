package com.sofi.test.power.giphy.dto.generated;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonPropertyOrder({
    "type",
    "id",
    "url",
    "trending_datetime",
    "images"
})
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Builder
public class Datum {

    @JsonProperty("type")
    private String type;
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("url")
    private String url;
    
   
    @JsonProperty("trending_datetime")
    private String trendingDatetime;
    
    @JsonProperty("images")
    private Images images;


}
