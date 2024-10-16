package com.example.brandlist.entity;
import jdk.jshell.Snippet;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {
    private Integer id;
    private String companyName;
    private String brandName;
    private Integer ordered;
    private String description;
}


