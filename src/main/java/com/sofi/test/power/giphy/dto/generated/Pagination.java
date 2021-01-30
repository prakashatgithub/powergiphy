
package com.sofi.test.power.giphy.dto.generated;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonPropertyOrder({
    "total_count",
    "count",
    "offset"
})
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Builder
public class Pagination {

    @JsonProperty("total_count")
    private Integer totalCount;
    
    @JsonProperty("count")
    private Integer count;
    
    @JsonProperty("offset")
    private Integer offset;

}
