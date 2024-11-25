package es.fmorelli.ejemplos.spring.ejercicio01primeraweb.controles;

import es.fmorelli.ejemplos.spring.ejercicio01primeraweb.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {


//Mapping que solo adminte GET
//@RequestMapping(value = "", method = RequestMethod.GET)

//Array de strings
//    public String getAllEvents(Model model) {
//    List<Event> events = new ArrayList<>();
//    events.add(new Event(1,"Evento 1", "Descripcion evento 1", LocalDateTime.now(),LocalDateTime.now()));
//    events.add(new Event(2,"Evento 2", "Descripcion evento 2", LocalDateTime.now(),LocalDateTime.now()));
//    events.add(new Event(3,"Evento 3", "Descripcion evento 3", LocalDateTime.now(),LocalDateTime.now()));
//model.addAttribute("events", events);
//        return "event-list";
//    }
@GetMapping({"","/"})
public ModelAndView getAllEvents() {
//    Iterable<Event> eventos= eventService.getlAllEvets();
//    ModelAndView modelAndView = new ModelAndView();
    List<Event> events = new ArrayList<>();
    events.add(new Event(1,"Evento 1", "Descripcion evento 1", LocalDateTime.now(),LocalDateTime.now()));
    events.add(new Event(2,"Evento 2", "Descripcion evento 2", LocalDateTime.now(),LocalDateTime.now()));
    events.add(new Event(3,"Evento 3", "Descripcion evento 3", LocalDateTime.now(),LocalDateTime.now()));
    ModelAndView modelAndView = new ModelAndView("event-list","events",events);
    modelAndView.addObject("usuario", "Fernanda Morelli");
    return modelAndView;
//     return   new ModelAndView("event-list","events",events); Más facil
//el primero el nombre de la vista,El segundo paramentro es el nombre que quiero en el modelo, es la clave.
}
    @GetMapping("/new")

    public String getCreateForm(){
    return "create-form";
}
@PostMapping("/new")
public  String createEvent(){
    return "event-created";
}
@GetMapping("/{eventId}")

public String getEventById(@PathVariable int eventId, Model model){
    System.out.println(eventId);
    Event event = new Event(1,"Hola","Estoy diciendo hola", LocalDateTime.now().plusDays(2),LocalDateTime.now().plusDays(5));
//    Event event = new Event(1,"Hola","Estoy diciendo hola", LocalDateTime.now().plusDays(2),null);

    model.addAttribute("eventId", eventId)
    .addAttribute("event", event);

    return "event-details";
}


}


