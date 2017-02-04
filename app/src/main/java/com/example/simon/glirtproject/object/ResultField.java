package com.example.simon.glirtproject.object;

/**
 * Created by Simon on 2/4/2017.
 */

public class ResultField {
    public String name;
    public String gritscore;
    public String survey;

    //Default constructor required for  cllas to Datasnapchat.getvalue(resultfield.class)
    public ResultField() {
    }

    public ResultField(String name, String gritscore, String survey) {
        this.name = name;
        this.gritscore = gritscore;
        this.survey = survey;
    }
}
