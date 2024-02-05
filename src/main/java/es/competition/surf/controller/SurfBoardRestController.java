package es.competition.surf.controller;

import es.competition.surf.entities.SurfBoard;
import es.competition.surf.service.SurfBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@Tag(name="SURF-BOARD API"
        ,description = "Spring application with spring-boot 3.x")
@RestController
@RequestMapping("/surfboard")
public class SurfBoardRestController {
    private final SurfBoardService service;
    public SurfBoardRestController(SurfBoardService service) {
        this.service = service;
    }
    @Operation(
            summary = "Retrieve a lists of surfboards",
            description = "Get all the surfboards are created. The response is a list of SurfBoard objects.",
            tags = {"get","surfboard"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success",
                    content = {@Content(schema = @Schema(implementation = SurfBoard.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })

    @GetMapping()
    public List<SurfBoard> getSurfBoards(){
        return service.findAll();
    }

    @Operation(
            summary = "Create surfboards",
            description = "Create any surfboards with all the attributes.",
            tags = {"new","surfboard"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Success",
                    content = {@Content(schema = @Schema(implementation = SurfBoard.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })

    @PostMapping("/create")
    public SurfBoard newSurfBoard(@RequestBody SurfBoard surfBoard){
        return service.createSurfBoard(surfBoard);
    }

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
    public SurfBoard updateSurfBoard(@RequestBody SurfBoard surfBoard){return service.updateSurfBoard(surfBoard);}

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
    public SurfBoard updatePartialSurfBoard(@RequestBody SurfBoard surfBoard){
        return service.updatePartialSurfBoard(surfBoard);
    }
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
    public void delete(@PathVariable ("id")long id){
        service.delete(id);
    }


    @GetMapping("/year/now")
    public List<SurfBoard> getSurfBoardCurrentYear(@RequestParam (defaultValue = "0") Integer anyo ) {
       // anyo=LocalDate.now().getYear()
        return service.getSurfBoardCurrentYear(LocalDate.now().getYear());
    }
}
