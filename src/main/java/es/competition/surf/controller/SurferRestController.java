package es.competition.surf.controller;

import es.competition.surf.entities.SurfBoard;
import es.competition.surf.entities.Surfer;
import es.competition.surf.service.SurferService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="SURFER API"
        ,description = "Spring application with spring-boot 3.x")
@RestController
@RequestMapping("/surfer")
public class SurferRestController {
    private final SurferService service;


    public SurferRestController(SurferService service) {
        this.service = service;
    }

    @Operation(
            summary = "Retrieve a lists of surfers",
            description = "Get all the surfers are created. The response is a list of surfer objects.",
            tags = {"get","surfer"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success",
                    content = {@Content(schema = @Schema(implementation = Surfer.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })
    @GetMapping()
    List<Surfer> getSurfers(){
        return service.findAll();
    }

    @Operation(
            summary = "Create surfer",
            description = "Create any surfer with all the attributes.",
            tags = {"new","surfboard"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Success",
                    content = {@Content(schema = @Schema(implementation = Surfer.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })
    @PostMapping("/create")
    public Surfer createSurfer(@RequestBody Surfer surfer){
        return service.createSurfer(surfer);
    }

    @Operation(
            summary = "update surfer",
            description = "Update all the attributes from surfer.",
            tags = {"update","surfer"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Success",
                    content = {@Content(schema = @Schema(implementation = Surfer.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })
    @PutMapping("/update/put")
    public Surfer updateSurfer(@RequestBody Surfer surfer){return service.updateSurfer(surfer);}
    @Operation(
            summary = "update surfer",
            description = "Update some attributes from surfer.",
            tags = {"update","surfer"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Success",
                    content = {@Content(schema = @Schema(implementation = Surfer.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })
    @PatchMapping("/update/patch")
    public Surfer updatePartialSurfBoard(@RequestBody Surfer surfer){
        return service.updatePartialSurfer(surfer);
    }
    @Operation(
            summary = "delete surfer",
            description = "Delete one surfer by id.",
            tags = {"delete","surfer"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Success",
                    content = {@Content(schema = @Schema(implementation = Surfer.class))}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema())})
    })
    @DeleteMapping("/delete")
    public void delete(@PathVariable ("id")long id){
        service.delete(id);
    }

    @GetMapping("/score/worst")
    public Surfer getWorstSurfer(){
        return service.getSurferWithLessScore();
    }

    @GetMapping("/surfboard/{fabricante}")
    public List<Surfer> getSurferBySurfBoardMaker(@PathVariable("fabricante") String maker){
        return service.getSurferBySurfBoardMaker(maker);
    }
}