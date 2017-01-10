package com.liveperson.web;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author nirl
 * @since {version}
 */
@Controller
public class GraphqlResource {

    @Autowired
    private GraphQL graphQL;

    @RequestMapping(path = "/graphql", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE , method = RequestMethod.POST)
    @ResponseBody
    public Object readData(@RequestBody GraphQlRequestBody body) {
        Map<String, Object> variables = body.getVariables() != null ? body.getVariables() : Collections.emptyMap();
        String query = body.getQuery();
        ExecutionResult executionResult = graphQL.execute(query, (Object) null, variables);
        Map<String, Object> result = new LinkedHashMap<>();
        if (executionResult.getErrors().size() > 0) {
            result.put("errors", executionResult.getErrors());
        }
        result.put("data", executionResult.getData());
        return result;
    }
}
