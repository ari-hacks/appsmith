package com.appsmith.server.domains;

import com.appsmith.external.models.BaseDomain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.querydsl.core.annotations.QueryEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@QueryEntity
@Document
public class Application extends BaseDomain {

    @NotNull
    String name;

    String organizationId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Boolean isPublic = false;

    /**
     * TODO : Introduce published pages and unpublished pages in this structure. This ensures that when the application
     * is fetched for edit and view mode, different pages list can be returned. This would take care of both delete of
     * pages in edit mode and setting default in edit mode not changing the view mode before deploy.
     */
    List<ApplicationPage> pages;

    @Transient
    boolean appIsExample = false;

    @JsonIgnore
    String clonedFromApplicationId;

    String colour;

    String icon;

}
