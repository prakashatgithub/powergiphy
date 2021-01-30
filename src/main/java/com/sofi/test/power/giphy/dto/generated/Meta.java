
package com.sofi.test.power.giphy.dto.generated;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonPropertyOrder({
    "status",
    "msg",
    "response_id"
})
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class Meta {

    @JsonProperty("status")
    private Integer status;
    
    @JsonProperty("msg")
    private String msg;
    
    @JsonProperty("response_id")
    private String responseId;

}
