package com.tecnocampus.agile.utils;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Pagination<T> {

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private List<T> items;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private int currentPage = 0;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private int totalItems = 0;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private int pageSize = 0;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private boolean isLastPage;


    public boolean isLastPage() {
        return (getCurrentPage() + 1) * getPageSize() >= totalItems;
    }

}
