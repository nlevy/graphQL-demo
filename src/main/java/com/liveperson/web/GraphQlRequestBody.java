package com.liveperson.web;

import com.google.common.base.Objects;

import java.util.Map;

/**
 * @author nirl
 * @since {version}
 */
public class GraphQlRequestBody {

    private Map<String, Object> variables;
    private String query;
    private String operationName;

    public GraphQlRequestBody() {
    }

    public GraphQlRequestBody(Map<String, Object> variables, String query, String operationName) {
        this.variables = variables;
        this.query = query;
        this.operationName = operationName;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public String getQuery() {
        return query;
    }

    public String getOperationName() {
        return operationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraphQlRequestBody that = (GraphQlRequestBody) o;

        if (query != null ? !query.equals(that.query) : that.query != null) return false;
        if (operationName != null ? !operationName.equals(that.operationName) : that.operationName != null) return false;
        if (variables != null ? !variables.equals(that.variables) : that.variables != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = variables != null ? variables.hashCode() : 0;
        result = 31 * result + (operationName != null ? operationName.hashCode() : 0);
        result = 31 * result + (query != null ? query.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("variables", variables)
                .add("query", query)
                .add("operationName", operationName)
                .toString();
    }
}
