package expeditors.backend.adoptapp.controller;

import expeditors.backend.adoptapp.domain.Adopter;
import expeditors.backend.adoptapp.service.AdopterService;
import expeditors.backend.utils.UriCreator;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author whynot
 */
@RestController
@RequestMapping("/petservice")
public class AdopterController {

    private AdopterService adopterService;
    private UriCreator uriCreator;

    private static Logger logger = LoggerFactory.getLogger("expeditors.backend");


    public AdopterController(AdopterService adopterService,
                             UriCreator uriCreator) {
        this.adopterService = adopterService;
        this.uriCreator = uriCreator;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Adopter> adopters = adopterService.getAllAdopters();
        return ResponseEntity.ok(adopters);
    }

    @GetMapping("/{id:\\d+}")   //id of only digits
    public ResponseEntity<?> getAdopter(@PathVariable("id") int id) {
        Adopter adopters = adopterService.getAdopter(id);
        if(adopters == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No adopters with id: " + id);
        }
        return ResponseEntity.ok(adopters);
    }

    @PostMapping
    public ResponseEntity<?> addAdopter(@RequestBody @Valid Adopter adopter) {
        Adopter newAdopter = adopterService.addAdopter(adopter);

        URI uri = uriCreator.getURI(newAdopter.getId());

        logger.debug("Added Adtoper: " + newAdopter);

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<?> deleteAdopter(@PathVariable("id") int id) {
        boolean result = adopterService.deleteAdopter(id);
        if(!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Adopter with id: " + id);
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> updateAdopter(@RequestBody Adopter adopter) {
        boolean result = adopterService.updateAdopter(adopter);
        if(!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No adopter with id: " + adopter.getId());
        }

        return ResponseEntity.noContent().build();
    }
}
