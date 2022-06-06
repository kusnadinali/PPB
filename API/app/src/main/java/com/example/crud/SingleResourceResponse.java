package com.example.crud;

public class SingleResourceResponse {
    private DataItemResource data;
    private Support support;

    public DataItemResource getData(){
        return data;
    }

    public void setSupport(Support support){
        this.support = support;
    }

    public Support getSupport(){
        return support;
    }

    @Override
    public String toString(){
        return
                "SingleResourceResponse{" +
                        "data = '" + data + '\'' +
                        ",support = '" + support + '\'' +
                        "}";
    }
}
