package com.lotissacayan.roomservice.dto;


import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

public record RoomRequest(
        Long id,


        @NotNull String name,
        int capacity,
        boolean availability,
        List<String> features
)
{

}
