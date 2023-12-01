package com.farmdigital.nerddevs.Posts.Service;


import com.farmdigital.nerddevs.Posts.helpers.SearchParamsHelper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

@Service
@AllArgsConstructor
@Log4j2
public class SearchService {
private final SearchParamsHelper searchParamsHelper;
    public Object searchPost(String query) {


        StringJoiner newSearchTerms= searchParamsHelper.returnSearchTerms(query);


        log.info(newSearchTerms);

return  "yes";


    }
}
