package com.example.demo.domain;

import lombok.Data;

@Data
public class Message {
    private String type;
    private String content;
    private String sender;
}
