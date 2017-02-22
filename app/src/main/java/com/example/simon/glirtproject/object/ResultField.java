package com.example.simon.glirtproject.object;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Simon on 2/4/2017.
 */
@IgnoreExtraProperties
public class ResultField {
    public String name;
    public String gritscore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGritscore() {
        return gritscore;
    }

    public void setGritscore(String gritscore) {
        this.gritscore = gritscore;
    }

    public String getSurvey() {
        return survey;
    }

    public void setSurvey(String survey) {
        this.survey = survey;
    }

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
