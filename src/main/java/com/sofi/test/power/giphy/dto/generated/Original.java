
package com.sofi.test.power.giphy.dto.generated;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonPropertyOrder({
    "height",
    "width",
    "size",
    "url"
})
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Builder
public class Original {

    @JsonProperty("height")
    private String height;
    
    @JsonProperty("width")
    private String width;
    
    @JsonProperty("size")
    private String size;
    
    @JsonProperty("url")
    private String url;

}
