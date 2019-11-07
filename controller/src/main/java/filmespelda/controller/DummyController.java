package filmespelda.controller;

import filmespelda.exceptions.DateIsTooLate;
import filmespelda.model.Szereplo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.UUID;

@Controller
public class DummyController {

    @RequestMapping(value = "/cica")
    public void dummy(){
        System.out.println("CICA");
    }

    @RequestMapping(value = "/dummy")
    @ResponseBody
    public Szereplo returnWithSzereplo() throws DateIsTooLate {
        Szereplo szereplo = new Szereplo();
        szereplo.setSzuletesi_datum(LocalDate.of(1994,03,10));
        szereplo.setKarakter_neve("AnimeLibera");
        szereplo.setId(UUID.randomUUID());
        szereplo.setKeresztnev("Anime");
        szereplo.setVezeteknev("Libera");
        return szereplo;
    }

    @RequestMapping(value = "/dummywrong")
    @ResponseBody
    public Szereplo returnWithException() throws DateIsTooLate {
        Szereplo szereplo = new Szereplo();
        szereplo.setSzuletesi_datum(LocalDate.of(3000,03,10));
        szereplo.setKarakter_neve("AnimeLibera");
        szereplo.setId(UUID.randomUUID());
        szereplo.setKeresztnev("Anime");
        szereplo.setVezeteknev("Libera");
        return szereplo;
    }

    @ExceptionHandler(DateIsTooLate.class)
    @ResponseBody
    public String handleException(){
        return "HEEEW";
    }
}
