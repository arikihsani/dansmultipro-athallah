package com.dansmultipro.athallahrikza.dto;

import lombok.Data;

@Data
public class JobDTO {
    private String id;
    private String type;
    private String url;
    private String created_at;
    private String company;
    private String company_url;
    private String location;
    private String title;
    private String description;
    private String how_to_apply;
    private String company_logo;

    public String toCsvString() {
        // Assuming you want a CSV format like: "title,company,location"
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", id, type, url, created_at, company, company_url, location, title, description, how_to_apply, company_logo);
    }
}
