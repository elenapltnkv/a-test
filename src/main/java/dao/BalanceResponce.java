package dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class BalanceResponce {
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "currency",
        "amount"
})
@Data
class Balance {

    @JsonProperty("type")
    private String type;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("amount")
    private Integer amount;

}
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "success",
        "result",
        "next",
        "request_id",
        "processing_time"
})



    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("result")
    private Result result;
    @JsonProperty("next")
    private Object next;


}
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "balances"
})
@Data
class Result {

    @JsonProperty("balances")
    private List<BalanceResponce.Balance> balances = new ArrayList<BalanceResponce.Balance>();

}
