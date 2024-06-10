package com.spring1.dto;

import java.util.List;

import com.spring1.vo.UploadData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private String description;
    private double price;
    private List<UploadData> images;
}
