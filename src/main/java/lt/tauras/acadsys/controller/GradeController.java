package lt.tauras.acadsys.controller;

import lt.tauras.acadsys.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GradeController {

    @Autowired
    private GradeService gradeService;

}
