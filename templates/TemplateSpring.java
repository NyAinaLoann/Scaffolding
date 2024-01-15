package ##package##;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/##EntityName##")
public class ##EntityName##Controller {

    private final ##EntityName##Service service;

    public ##EntityName##Controller(##EntityName##Service service) {
        this.service = service;
    }

    @GetMapping
    public List<##EntityName##> getAll##entityName##() {
        return service.getAll##entityName##();
    }

    @GetMapping("/{id}")
    public ##EntityName## get##EntityName##ById(@PathVariable Long id) {
        return service.get##EntityName##ById(id);
    }

    @PostMapping
    public ##EntityName## create##EntityName##(@RequestBody ##EntityName## ##EntityName##) {
        return service.create##EntityName##(##EntityName##);
    }

    // ... d'autres méthodes pour les opérations CRUD

    @DeleteMapping("/{id}")
    public void delete##EntityName##(@PathVariable Long id) {
        service.delete##EntityName##(id);
    }
}
