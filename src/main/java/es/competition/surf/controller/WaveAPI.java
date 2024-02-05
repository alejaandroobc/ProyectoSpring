package es.competition.surf.controller;

import es.competition.surf.entities.Wave;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name="WAVE API"
        ,description = "Spring application with spring-boot 3.x")
@RestController
@RequestMapping("/wave")
public interface WaveAPI {
    @Operation(
            summary = "Create wave",
            description = "Create any all the wave is created.",
            tags = {"new","wave"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "2001", description = "Success",
                    content = {@Content(schema = @Schema(implementation = Wave.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })
    @PostMapping("/create")
    Wave createWave(@RequestBody Wave wave);
    @Operation(
            summary = "update wave",
            description = "Update all the attributes from wave.",
            tags = {"update","wave"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Success",
                    content = {@Content(schema = @Schema(implementation = Wave.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })
    @PutMapping("/update/put")
    Wave updateWave(@RequestBody Wave wave);

    @Operation(
            summary = "update wave",
            description = "Update some attributes from wave.",
            tags = {"update","wave"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Success",
                    content = {@Content(schema = @Schema(implementation = Wave.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })
    @PatchMapping("/update/patch")
     Wave updatePartialWave(@RequestBody Wave wave);

    @Operation(
            summary = "delete wave",
            description = "Delete one wave by id.",
            tags = {"delete","wave"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Success",
                    content = {@Content(schema = @Schema(implementation = Wave.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })

    @DeleteMapping("/delete")
    void delete(@PathVariable ("id")long id);
}
