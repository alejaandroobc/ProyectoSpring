package es.competition.surf.controller;

import es.competition.surf.entities.Spot;
import es.competition.surf.entities.SurfBoard;
import es.competition.surf.service.SpotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="SPOT API"
        ,description = "Spring application with spring-boot 3.x")
@RestController
@RequestMapping("/spot")
public class SpotRestController {
    private final SpotService service;

    public SpotRestController(SpotService service) {
        this.service = service;
    }

    @Operation(
            summary = "Create spot",
            description = "Create any spot with all the attributes.",
            tags = {"new","spot"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Success",
                    content = {@Content(schema = @Schema(implementation = Spot.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })
    @PostMapping("/create")
    public Spot createSpot(@RequestBody Spot spot){
        return service.createSpot(spot);
    }
    @Operation(
            summary = "update spot",
            description = "Update all the attributes from spot.",
            tags = {"update","spot"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Success",
                    content = {@Content(schema = @Schema(implementation = Spot.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })
    @PutMapping("/update/put")
    public Spot updateSpot(@RequestBody Spot spot){return service.updateSpot(spot);}

    @Operation(
            summary = "update spot",
            description = "Update some attributes from spot.",
            tags = {"update","spot"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Success",
                    content = {@Content(schema = @Schema(implementation = Spot.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })
    @PatchMapping("/update/patch")
    public Spot updatePartialSpot(@RequestBody Spot spot){
        return service.updatePartialSpot(spot);
    }

    @Operation(
            summary = "delete spot",
            description = "Delete one spot by id.",
            tags = {"delete","spot"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Success",
                    content = {@Content(schema = @Schema(implementation = Spot.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })
    @DeleteMapping("/delete")
    public void delete(@PathVariable ("id")long id){
        service.delete(id);
    }
}
