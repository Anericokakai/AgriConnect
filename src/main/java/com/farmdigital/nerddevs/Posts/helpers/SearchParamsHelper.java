package com.farmdigital.nerddevs.Posts.helpers;

import org.springframework.stereotype.Service;

import java.util.StringJoiner;
@Service
public class SearchParamsHelper {

    public  StringJoiner returnSearchTerms(String  query){

        StringJoiner  newSearchTerms= new StringJoiner(" & ");

        String[] queryArray=query.split("\\s+");

        for(String  term:queryArray){

            newSearchTerms.add("'"+term+"'");
        }

        return  newSearchTerms;


    }

}
