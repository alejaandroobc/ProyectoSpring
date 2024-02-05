package es.competition.surf.controller;

import es.competition.surf.entities.SurfBoard;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="SURF-BOARD API"
,description = "Spring application with spring-boot 3.x")
@RestController
@RequestMapping("/surfboard")
public interface SurfBoardAPI {
    @Operation(
            summary = "Retrieve a lists of surfboards",
            description = "Get all the surfboards are created. The response is a list of SurfBoard objects.",
            tags = {"get","surfBoard"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success",
                    content = {@Content(schema = @Schema(implementation = SurfBoard.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })

    @GetMapping()
    List<SurfBoard> getSurfBoards();
    @Operation(
            summary = "Create surfboards",
            description = "Create any all the surfboards are created.",
            tags = {"new","surfboard"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "2001", description = "Success",
                    content = {@Content(schema = @Schema(implementation = SurfBoard.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })

    @PostMapping("/create")
    SurfBoard newSurfBoard(@RequestBody SurfBoard surfBoard);

    @Operation(
            summary = "update surfboards",
            description = "Update all the attributes from surfboard.",
            tags = {"update","surfboard"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Success",
                    content = {@Content(schema = @Schema(implementation = SurfBoard.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })
    @PutMapping("/update/put")
    SurfBoard updateSurfBoard(@RequestBody SurfBoard surfBoard);

    @Operation(
            summary = "update surfboards",
            description = "Update some attributes from surfboard.",
            tags = {"update","surfboard"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Success",
                    content = {@Content(schema = @Schema(implementation = SurfBoard.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })
    @PatchMapping("/update/patch")
    SurfBoard updatePartialSurfBoard(@RequestBody SurfBoard surfBoard);

    @Operation(
            summary = "delete surfboards",
            description = "Delete one surfboard by id.",
            tags = {"delete","surfboard"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Success",
                    content = {@Content(schema = @Schema(implementation = SurfBoard.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })

    @DeleteMapping("/delete")
    void delete(@PathVariable ("id")long id);
}
