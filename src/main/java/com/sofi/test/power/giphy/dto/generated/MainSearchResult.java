package com.sofi.test.power.giphy.dto.generated;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonPropertyOrder({
    "data",
    "pagination",
    "meta"
})
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Builder
public class MainSearchResult {

    @JsonProperty("data")
    private List<Datum> data = null;
    
    @JsonProperty("pagination")
    private Pagination pagination;
    
    @JsonProperty("meta")
    private Meta meta;

}
