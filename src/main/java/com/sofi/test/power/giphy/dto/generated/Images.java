
package com.sofi.test.power.giphy.dto.generated;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonPropertyOrder({
    "original"
})
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Builder
public class Images {

    @JsonProperty("original")
    private Original original;


}
