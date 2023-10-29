package com.springmvc.demomvc.dto;

public class SearchFormData {
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public SearchFormData() {

    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public SearchFormData(String keyword) {
        this.keyword = keyword;
    }

}
