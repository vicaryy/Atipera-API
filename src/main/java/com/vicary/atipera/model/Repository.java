package com.vicary.atipera.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Repository {

        private String repositoryName;
        private Owner owner;
        private List<Branch> branches;
        private boolean fork;
        private String branchesUrl;

        @JsonIgnore
        public boolean isFork() {
                return this.fork;
        }

        @JsonProperty("branches_url")
        public void setBranchesUrl(String branchesUrl) {
                this.branchesUrl = branchesUrl;
        }

        @JsonIgnore
        public String getBranchesUrl() {
                return this.branchesUrl;
        }

        @JsonProperty("name")
        public void setRepositoryName(String repositoryName) {
                this.repositoryName = repositoryName;
        }

        @JsonProperty("repository_name")
        public String getRepositoryName() {
                return this.repositoryName;
        }
}
