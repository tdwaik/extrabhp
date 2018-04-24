package com.extrabhp.controller.RESTful.helper.CarsTimeline;

import java.util.Date;

/**
 * @author Thaer Aldwaik <t_dwaik@hotmail.com>
 */
public class CarsTimelineResponse {

    private String code;

    private String title;

    private String description;

    private String img;

    private String productionDate;

    public String getCode() {
        return code;
    }

    public CarsTimelineResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CarsTimelineResponse setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CarsTimelineResponse setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImg() {
        return img;
    }

    public CarsTimelineResponse setImg(String img) {
        this.img = img;
        return this;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public CarsTimelineResponse setReleaseDate(String productionDate) {
        this.productionDate = productionDate;
        return this;
    }
}
