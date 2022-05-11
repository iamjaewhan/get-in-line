package com.jay.getinline.controller.api;

import com.jay.getinline.constant.PlaceType;
import com.jay.getinline.dto.APIDataResponse;
import com.jay.getinline.dto.PlaceDTO;
import com.jay.getinline.dto.PlaceResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIPlaceController {

    @GetMapping("/places")
    public APIDataResponse<List<PlaceResponse>> getPlaces(){
        return APIDataResponse.of(List.of((PlaceResponse.of(
                PlaceType.COMMON,
                "배드민턴장",
                "서울시 강남대로 123길",
                "010-1234-5678",
                30,
                "신장개업"))));
    }

    @PostMapping("/places")
    public Boolean  createPlace() {
        return true;
    }

    @GetMapping("/places/{placeId}")
    public APIDataResponse<PlaceDTO> getPlaces(@PathVariable Integer placeId) {
        if (placeId.equals(2)) {
             return APIDataResponse.of(null);
        }
        else {
            return APIDataResponse.of(PlaceDTO.of(
                    PlaceType.COMMON,
                    "배드민턴장",
                    "서울시 강남대로 123길",
                    "010-1234-5678",
                    30,
                    "신장개업"
            ));
        }
    }

    @PutMapping("/places/{placeId}")
    public Boolean postPlaces(@PathVariable String placeId) {
        return true;
    }

    @DeleteMapping("/places/{placeId}")
    public Boolean removePlaces(@PathVariable String placeId) {
        return true;
    }
}
