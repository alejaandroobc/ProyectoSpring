package es.competition.surf.controller;

import es.competition.surf.entities.Spot;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name="SPOT API"
        ,description = "Spring application with spring-boot 3.x")
@RestController
@RequestMapping("/spot")
public interface SpotAPI {
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
    Spot createSpot(@RequestBody Spot spot);

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
    Spot updateSpot(@RequestBody Spot spot);

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
    Spot updatePartialSpot(@RequestBody Spot spot);

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
    void delete(@PathVariable ("id")long id);
}
