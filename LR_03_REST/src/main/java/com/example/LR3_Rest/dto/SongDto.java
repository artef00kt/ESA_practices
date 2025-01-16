package com.example.LR3_Rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class SongDto {

    private String title;

    private String executor;

    private Long albumId;

}
