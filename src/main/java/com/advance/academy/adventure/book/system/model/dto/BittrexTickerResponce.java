package com.advance.academy.adventure.book.system.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BittrexTickerResponce {
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("message")
    private String message;
    @JsonProperty("result")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private Result result;

    public Boolean getSuccess() {
        return success;
    }

    public BittrexTickerResponce() {
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result {

        @JsonProperty("Bid")
        private Double bid;
        @JsonProperty("Ask")
        private Double ask;
        @JsonProperty("Last")
        private Double last;

        public Double getBid() {
            return bid;
        }

        public Result() {
        }

        public void setBid(Double bid) {
            this.bid = bid;
        }

        public Double getAsk() {
            return ask;
        }

        public void setAsk(Double ask) {
            this.ask = ask;
        }

        public Double getLast() {
            return last;
        }

        public void setLast(Double last) {
            this.last = last;
        }

    }
}
