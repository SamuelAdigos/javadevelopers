package es.cabsa.javadevelopers.dto;

import javax.validation.constraints.NotNull;

public class Search {
    @NotNull
    private String searchTerm;

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
}
